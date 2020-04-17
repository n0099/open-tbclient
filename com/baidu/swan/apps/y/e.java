package com.baidu.swan.apps.y;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c bXO = new c(this);
    private a bXP = new a();
    private boolean bXQ;

    /* loaded from: classes11.dex */
    public interface b {
        void fs(int i);
    }

    public void bV(Context context) {
        if (!this.bXQ) {
            this.bXQ = true;
            context.registerReceiver(this.bXO, c.getIntentFilter());
        }
    }

    public void bW(Context context) {
        if (this.bXQ) {
            this.bXQ = false;
            try {
                context.unregisterReceiver(this.bXO);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            aeC();
        } else {
            aeD();
        }
    }

    public void a(b bVar) {
        this.bXP.a(bVar);
    }

    public void aeB() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.bXP.startTimer();
    }

    private void aeC() {
        this.bXP.aeF();
    }

    private void aeD() {
        this.bXP.aeG();
    }

    public void aeE() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.bXP.RX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private b bXR;
        private long bXS = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.bXS - 1;
            aVar.bXS = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            aeI();
            cancelTimer();
            aeH();
        }

        public void RX() {
            this.mStatus = 2;
            cancelTimer();
            aeI();
        }

        public void aeF() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                aeH();
            }
        }

        public void aeG() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                cancelTimer();
            }
        }

        private synchronized void cancelTimer() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void aeH() {
            this.mTimer = new Timer();
            this.mTimer.schedule(aeJ(), 0L, 1000L);
        }

        private void aeI() {
            this.bXS = 300L;
        }

        public void a(b bVar) {
            this.bXR = bVar;
        }

        private TimerTask aeJ() {
            return new TimerTask() { // from class: com.baidu.swan.apps.y.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.bXS);
                    }
                    a.b(a.this);
                    if (a.this.bXS <= 0 && a.this.bXR != null) {
                        a.this.bXR.fs(1);
                        a.this.RX();
                    }
                }
            };
        }
    }

    /* loaded from: classes11.dex */
    private static class c extends BroadcastReceiver {
        private WeakReference<e> mPolicyRef;

        c(e eVar) {
            this.mPolicyRef = new WeakReference<>(eVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e eVar;
            if (intent != null && !TextUtils.isEmpty(intent.getAction()) && (eVar = this.mPolicyRef.get()) != null) {
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
                        eVar.dM(true);
                        return;
                    case 1:
                        eVar.dM(false);
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
