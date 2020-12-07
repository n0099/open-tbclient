package com.baidu.swan.apps.v;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes25.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean deO;
    private c deM = new c(this);
    private a deN = new a();
    private final com.baidu.swan.apps.v.a.a deP = com.baidu.swan.apps.v.a.c.aCB();

    /* loaded from: classes25.dex */
    public interface b {
        void jC(int i);
    }

    public void cP(Context context) {
        if (!this.deO) {
            this.deO = true;
            context.registerReceiver(this.deM, c.getIntentFilter());
        }
    }

    public void cQ(Context context) {
        if (this.deO) {
            this.deO = false;
            try {
                context.unregisterReceiver(this.deM);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenStatusChanged(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            aCh();
        } else {
            aCi();
        }
    }

    public void a(b bVar) {
        this.deN.a(bVar);
    }

    public void aCg() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.deP.onPause();
        this.deN.startTimer();
    }

    private void aCh() {
        this.deN.aCk();
    }

    private void aCi() {
        this.deN.aCl();
    }

    public void aCj() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.deP.onResume();
        this.deN.amQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        private b deQ;
        private long deR = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            aCn();
            cancelTimer();
            aCm();
        }

        public void amQ() {
            this.mStatus = 2;
            cancelTimer();
            aCn();
        }

        public void aCk() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                aCm();
            }
        }

        public void aCl() {
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

        private void aCm() {
            this.mTimer = new Timer();
            this.mTimer.schedule(aCo(), 0L, 10000L);
        }

        private void aCn() {
            this.deR = com.baidu.swan.apps.performance.b.d.aGH();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aGZ().getBoolean("swan_5min_back_optimize", false)) {
                this.deR = 30L;
            }
        }

        public void a(b bVar) {
            this.deQ = bVar;
        }

        private TimerTask aCo() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.deR);
                    }
                    a.this.deR -= 10;
                    if (a.this.deR <= 0 && a.this.deQ != null) {
                        a.this.deQ.jC(1);
                        a.this.amQ();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class c extends BroadcastReceiver {
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
                        eVar.onScreenStatusChanged(true);
                        return;
                    case 1:
                        eVar.onScreenStatusChanged(false);
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
