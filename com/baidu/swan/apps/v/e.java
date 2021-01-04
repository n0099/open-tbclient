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
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean djI;
    private c djG = new c(this);
    private a djH = new a();
    private final com.baidu.swan.apps.v.a.a djJ = com.baidu.swan.apps.v.a.c.aDS();

    /* loaded from: classes9.dex */
    public interface b {
        void jx(int i);
    }

    public void cX(Context context) {
        if (!this.djI) {
            this.djI = true;
            context.registerReceiver(this.djG, c.getIntentFilter());
        }
    }

    public void cY(Context context) {
        if (this.djI) {
            this.djI = false;
            try {
                context.unregisterReceiver(this.djG);
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
            aDy();
        } else {
            aDz();
        }
    }

    public void a(b bVar) {
        this.djH.a(bVar);
    }

    public void aDx() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.djJ.onPause();
        this.djH.startTimer();
    }

    private void aDy() {
        this.djH.aDB();
    }

    private void aDz() {
        this.djH.aDC();
    }

    public void aDA() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.djJ.onResume();
        this.djH.aoa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private b djK;
        private long djL = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            aDE();
            cancelTimer();
            aDD();
        }

        public void aoa() {
            this.mStatus = 2;
            cancelTimer();
            aDE();
        }

        public void aDB() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                aDD();
            }
        }

        public void aDC() {
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

        private void aDD() {
            this.mTimer = new Timer();
            this.mTimer.schedule(aDF(), 0L, 10000L);
        }

        private void aDE() {
            this.djL = com.baidu.swan.apps.performance.b.d.aIa();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aIs().getBoolean("swan_5min_back_optimize", false)) {
                this.djL = 30L;
            }
        }

        public void a(b bVar) {
            this.djK = bVar;
        }

        private TimerTask aDF() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.djL);
                    }
                    a.this.djL -= 10;
                    if (a.this.djL <= 0 && a.this.djK != null) {
                        a.this.djK.jx(1);
                        a.this.aoa();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
