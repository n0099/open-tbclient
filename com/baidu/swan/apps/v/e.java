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
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cXP;
    private c cXN = new c(this);
    private a cXO = new a();
    private final com.baidu.swan.apps.v.a.a cXQ = com.baidu.swan.apps.v.a.c.azs();

    /* loaded from: classes7.dex */
    public interface b {
        void je(int i);
    }

    public void cj(Context context) {
        if (!this.cXP) {
            this.cXP = true;
            context.registerReceiver(this.cXN, c.getIntentFilter());
        }
    }

    public void ck(Context context) {
        if (this.cXP) {
            this.cXP = false;
            try {
                context.unregisterReceiver(this.cXN);
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
            ayY();
        } else {
            ayZ();
        }
    }

    public void a(b bVar) {
        this.cXO.a(bVar);
    }

    public void ayX() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.cXQ.onPause();
        this.cXO.startTimer();
    }

    private void ayY() {
        this.cXO.azb();
    }

    private void ayZ() {
        this.cXO.azc();
    }

    public void aza() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.cXQ.onResume();
        this.cXO.ajI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private b cXR;
        private long cXS = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            aze();
            cancelTimer();
            azd();
        }

        public void ajI() {
            this.mStatus = 2;
            cancelTimer();
            aze();
        }

        public void azb() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                azd();
            }
        }

        public void azc() {
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

        private void azd() {
            this.mTimer = new Timer();
            this.mTimer.schedule(azf(), 0L, 10000L);
        }

        private void aze() {
            this.cXS = com.baidu.swan.apps.performance.b.d.aDz();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aDR().getBoolean("swan_5min_back_optimize", false)) {
                this.cXS = 30L;
            }
        }

        public void a(b bVar) {
            this.cXR = bVar;
        }

        private TimerTask azf() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.cXS);
                    }
                    a.this.cXS -= 10;
                    if (a.this.cXS <= 0 && a.this.cXR != null) {
                        a.this.cXR.je(1);
                        a.this.ajI();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
