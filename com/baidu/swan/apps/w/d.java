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
    private c aTv = new c(this);
    private a aTw = new a();
    private boolean aTx;

    /* loaded from: classes2.dex */
    public interface b {
        void dE(int i);
    }

    public void bl(Context context) {
        if (!this.aTx) {
            this.aTx = true;
            context.registerReceiver(this.aTv, c.getIntentFilter());
        }
    }

    public void bm(Context context) {
        if (this.aTx) {
            this.aTx = false;
            try {
                context.unregisterReceiver(this.aTv);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            Lw();
        } else {
            Lx();
        }
    }

    public void a(b bVar) {
        this.aTw.a(bVar);
    }

    public void Lv() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.aTw.startTimer();
    }

    private void Lw() {
        this.aTw.Lz();
    }

    private void Lx() {
        this.aTw.LA();
    }

    public void Ly() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.aTw.CF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private b aTy;
        private long aTz = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.aTz - 1;
            aVar.aTz = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            LC();
            CG();
            LB();
        }

        public void CF() {
            this.mStatus = 2;
            CG();
            LC();
        }

        public void Lz() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                CG();
                LB();
            }
        }

        public void LA() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                CG();
            }
        }

        private synchronized void CG() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void LB() {
            this.mTimer = new Timer();
            this.mTimer.schedule(LD(), 0L, 1000L);
        }

        private void LC() {
            this.aTz = 300L;
        }

        public void a(b bVar) {
            this.aTy = bVar;
        }

        private TimerTask LD() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.d.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.aTz);
                    }
                    a.b(a.this);
                    if (a.this.aTz <= 0 && a.this.aTy != null) {
                        a.this.aTy.dE(1);
                        a.this.CF();
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
                        dVar.bN(true);
                        return;
                    case 1:
                        dVar.bN(false);
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
