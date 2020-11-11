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
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cZz;
    private c cZx = new c(this);
    private a cZy = new a();
    private final com.baidu.swan.apps.v.a.a cZA = com.baidu.swan.apps.v.a.c.aAa();

    /* loaded from: classes10.dex */
    public interface b {
        void ji(int i);
    }

    public void cj(Context context) {
        if (!this.cZz) {
            this.cZz = true;
            context.registerReceiver(this.cZx, c.getIntentFilter());
        }
    }

    public void ck(Context context) {
        if (this.cZz) {
            this.cZz = false;
            try {
                context.unregisterReceiver(this.cZx);
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
            azG();
        } else {
            azH();
        }
    }

    public void a(b bVar) {
        this.cZy.a(bVar);
    }

    public void azF() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.cZA.onPause();
        this.cZy.startTimer();
    }

    private void azG() {
        this.cZy.azJ();
    }

    private void azH() {
        this.cZy.azK();
    }

    public void azI() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.cZA.onResume();
        this.cZy.akq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private b cZB;
        private long cZC = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            azM();
            cancelTimer();
            azL();
        }

        public void akq() {
            this.mStatus = 2;
            cancelTimer();
            azM();
        }

        public void azJ() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                azL();
            }
        }

        public void azK() {
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

        private void azL() {
            this.mTimer = new Timer();
            this.mTimer.schedule(azN(), 0L, 10000L);
        }

        private void azM() {
            this.cZC = com.baidu.swan.apps.performance.b.d.aEh();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aEz().getBoolean("swan_5min_back_optimize", false)) {
                this.cZC = 30L;
            }
        }

        public void a(b bVar) {
            this.cZB = bVar;
        }

        private TimerTask azN() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.cZC);
                    }
                    a.this.cZC -= 10;
                    if (a.this.cZC <= 0 && a.this.cZB != null) {
                        a.this.cZB.ji(1);
                        a.this.akq();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
