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
    private boolean deT;
    private c deR = new c(this);
    private a deS = new a();
    private final com.baidu.swan.apps.v.a.a deU = com.baidu.swan.apps.v.a.c.azZ();

    /* loaded from: classes8.dex */
    public interface b {
        void hR(int i);
    }

    public void cW(Context context) {
        if (!this.deT) {
            this.deT = true;
            context.registerReceiver(this.deR, c.getIntentFilter());
        }
    }

    public void cX(Context context) {
        if (this.deT) {
            this.deT = false;
            try {
                context.unregisterReceiver(this.deR);
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
            azF();
        } else {
            azG();
        }
    }

    public void a(b bVar) {
        this.deS.a(bVar);
    }

    public void azE() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.deU.onPause();
        this.deS.startTimer();
    }

    private void azF() {
        this.deS.azI();
    }

    private void azG() {
        this.deS.azJ();
    }

    public void azH() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.deU.onResume();
        this.deS.akh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private b deV;
        private long deW = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            azL();
            cancelTimer();
            azK();
        }

        public void akh() {
            this.mStatus = 2;
            cancelTimer();
            azL();
        }

        public void azI() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                azK();
            }
        }

        public void azJ() {
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

        private void azK() {
            this.mTimer = new Timer();
            this.mTimer.schedule(azM(), 0L, 10000L);
        }

        private void azL() {
            this.deW = com.baidu.swan.apps.performance.b.d.aEh();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aEz().getBoolean("swan_5min_back_optimize", false)) {
                this.deW = 30L;
            }
        }

        public void a(b bVar) {
            this.deV = bVar;
        }

        private TimerTask azM() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.deW);
                    }
                    a.this.deW -= 10;
                    if (a.this.deW <= 0 && a.this.deV != null) {
                        a.this.deV.hR(1);
                        a.this.akh();
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
