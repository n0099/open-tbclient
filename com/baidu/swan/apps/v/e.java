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
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean diI;
    private c diG = new c(this);
    private a diH = new a();
    private final com.baidu.swan.apps.v.a.a diJ = com.baidu.swan.apps.v.a.c.aAA();

    /* loaded from: classes8.dex */
    public interface b {
        void hV(int i);
    }

    public void cU(Context context) {
        if (!this.diI) {
            this.diI = true;
            context.registerReceiver(this.diG, c.getIntentFilter());
        }
    }

    public void cV(Context context) {
        if (this.diI) {
            this.diI = false;
            try {
                context.unregisterReceiver(this.diG);
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
            aAg();
        } else {
            aAh();
        }
    }

    public void a(b bVar) {
        this.diH.a(bVar);
    }

    public void aAf() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.diJ.onPause();
        this.diH.startTimer();
    }

    private void aAg() {
        this.diH.aAj();
    }

    private void aAh() {
        this.diH.aAk();
    }

    public void aAi() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.diJ.onResume();
        this.diH.akI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private b diK;
        private long diL = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            aAm();
            cancelTimer();
            aAl();
        }

        public void akI() {
            this.mStatus = 2;
            cancelTimer();
            aAm();
        }

        public void aAj() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                aAl();
            }
        }

        public void aAk() {
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

        private void aAl() {
            this.mTimer = new Timer();
            this.mTimer.schedule(aAn(), 0L, 10000L);
        }

        private void aAm() {
            this.diL = com.baidu.swan.apps.performance.b.d.aEF();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aEX().getBoolean("swan_5min_back_optimize", false)) {
                this.diL = 30L;
            }
        }

        public void a(b bVar) {
            this.diK = bVar;
        }

        private TimerTask aAn() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.diL);
                    }
                    a.this.diL -= 10;
                    if (a.this.diL <= 0 && a.this.diK != null) {
                        a.this.diK.hV(1);
                        a.this.akI();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
