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
    private c aAb = new c(this);
    private a aAc = new a();
    private boolean aAd;

    /* loaded from: classes2.dex */
    public interface b {
        void cI(int i);
    }

    public void bj(Context context) {
        if (!this.aAd) {
            this.aAd = true;
            context.registerReceiver(this.aAb, c.getIntentFilter());
        }
    }

    public void bk(Context context) {
        if (this.aAd) {
            this.aAd = false;
            try {
                context.unregisterReceiver(this.aAb);
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
            Gx();
        } else {
            Gy();
        }
    }

    public void a(b bVar) {
        this.aAc.a(bVar);
    }

    public void Gw() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.aAc.iO();
    }

    private void Gx() {
        this.aAc.GA();
    }

    private void Gy() {
        this.aAc.GB();
    }

    public void Gz() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.aAc.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private b aAe;
        private long aAf = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.aAf - 1;
            aVar.aAf = j;
            return j;
        }

        public void iO() {
            this.mStatus = 1;
            GD();
            xG();
            GC();
        }

        public void stopTimer() {
            this.mStatus = 2;
            xG();
            GD();
        }

        public void GA() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                xG();
                GC();
            }
        }

        public void GB() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                xG();
            }
        }

        private synchronized void xG() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void GC() {
            this.mTimer = new Timer();
            this.mTimer.schedule(GE(), 0L, 1000L);
        }

        private void GD() {
            this.aAf = 300L;
        }

        public void a(b bVar) {
            this.aAe = bVar;
        }

        private TimerTask GE() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.d.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.aAf);
                    }
                    a.b(a.this);
                    if (a.this.aAf <= 0 && a.this.aAe != null) {
                        a.this.aAe.cI(1);
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
