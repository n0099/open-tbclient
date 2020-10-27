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
    private boolean cTG;
    private c cTE = new c(this);
    private a cTF = new a();
    private final com.baidu.swan.apps.v.a.a cTH = com.baidu.swan.apps.v.a.c.axA();

    /* loaded from: classes10.dex */
    public interface b {
        void iY(int i);
    }

    public void cj(Context context) {
        if (!this.cTG) {
            this.cTG = true;
            context.registerReceiver(this.cTE, c.getIntentFilter());
        }
    }

    public void ck(Context context) {
        if (this.cTG) {
            this.cTG = false;
            try {
                context.unregisterReceiver(this.cTE);
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
            axg();
        } else {
            axh();
        }
    }

    public void a(b bVar) {
        this.cTF.a(bVar);
    }

    public void axf() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.cTH.onPause();
        this.cTF.startTimer();
    }

    private void axg() {
        this.cTF.axj();
    }

    private void axh() {
        this.cTF.axk();
    }

    public void axi() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.cTH.onResume();
        this.cTF.ahQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private b cTI;
        private long cTJ = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            axm();
            cancelTimer();
            axl();
        }

        public void ahQ() {
            this.mStatus = 2;
            cancelTimer();
            axm();
        }

        public void axj() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                axl();
            }
        }

        public void axk() {
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

        private void axl() {
            this.mTimer = new Timer();
            this.mTimer.schedule(axn(), 0L, 10000L);
        }

        private void axm() {
            this.cTJ = com.baidu.swan.apps.performance.b.d.aBH();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aBZ().getBoolean("swan_5min_back_optimize", false)) {
                this.cTJ = 30L;
            }
        }

        public void a(b bVar) {
            this.cTI = bVar;
        }

        private TimerTask axn() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.cTJ);
                    }
                    a.this.cTJ -= 10;
                    if (a.this.cTJ <= 0 && a.this.cTI != null) {
                        a.this.cTI.iY(1);
                        a.this.ahQ();
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
