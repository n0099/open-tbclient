package com.baidu.swan.apps.w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean aAB;
    private c aAz = new c(this);
    private a aAA = new a();

    /* loaded from: classes2.dex */
    public interface b {
        void cJ(int i);
    }

    public void bj(Context context) {
        if (!this.aAB) {
            this.aAB = true;
            context.registerReceiver(this.aAz, c.getIntentFilter());
        }
    }

    public void bk(Context context) {
        if (this.aAB) {
            this.aAB = false;
            try {
                context.unregisterReceiver(this.aAz);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            GB();
        } else {
            GC();
        }
    }

    public void a(b bVar) {
        this.aAA.a(bVar);
    }

    public void GA() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.aAA.iO();
    }

    private void GB() {
        this.aAA.GE();
    }

    private void GC() {
        this.aAA.GF();
    }

    public void GD() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.aAA.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private b aAC;
        private long aAD = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.aAD - 1;
            aVar.aAD = j;
            return j;
        }

        public void iO() {
            this.mStatus = 1;
            GH();
            xK();
            GG();
        }

        public void stopTimer() {
            this.mStatus = 2;
            xK();
            GH();
        }

        public void GE() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                xK();
                GG();
            }
        }

        public void GF() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                xK();
            }
        }

        private synchronized void xK() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void GG() {
            this.mTimer = new Timer();
            this.mTimer.schedule(GI(), 0L, 1000L);
        }

        private void GH() {
            this.aAD = 300L;
        }

        public void a(b bVar) {
            this.aAC = bVar;
        }

        private TimerTask GI() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.d.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.aAD);
                    }
                    a.b(a.this);
                    if (a.this.aAD <= 0 && a.this.aAC != null) {
                        a.this.aAC.cJ(1);
                        a.this.stopTimer();
                    }
                }
            };
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends BroadcastReceiver {
        private WeakReference<d> mPolicyRef;

        c(d dVar) {
            this.mPolicyRef = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d dVar;
            if (intent != null && !TextUtils.isEmpty(intent.getAction()) && (dVar = this.mPolicyRef.get()) != null) {
                String action = intent.getAction();
                char c = 65535;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        dVar.bv(true);
                        return;
                    case 1:
                        dVar.bv(false);
                        return;
                    default:
                        return;
                }
            }
        }

        public static IntentFilter getIntentFilter() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            return intentFilter;
        }
    }
}
