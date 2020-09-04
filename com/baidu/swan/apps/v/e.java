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
    private boolean cxe;
    private c cxc = new c(this);
    private a cxd = new a();
    private final com.baidu.swan.apps.v.a.a cxf = com.baidu.swan.apps.v.a.c.ask();

    /* loaded from: classes8.dex */
    public interface b {
        void ig(int i);
    }

    public void ce(Context context) {
        if (!this.cxe) {
            this.cxe = true;
            context.registerReceiver(this.cxc, c.getIntentFilter());
        }
    }

    public void cf(Context context) {
        if (this.cxe) {
            this.cxe = false;
            try {
                context.unregisterReceiver(this.cxc);
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
            arQ();
        } else {
            arR();
        }
    }

    public void a(b bVar) {
        this.cxd.a(bVar);
    }

    public void arP() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.cxf.onPause();
        this.cxd.startTimer();
    }

    private void arQ() {
        this.cxd.arT();
    }

    private void arR() {
        this.cxd.arU();
    }

    public void arS() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.cxf.onResume();
        this.cxd.acB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private b cxg;
        private long cxh = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            arW();
            cancelTimer();
            arV();
        }

        public void acB() {
            this.mStatus = 2;
            cancelTimer();
            arW();
        }

        public void arT() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                arV();
            }
        }

        public void arU() {
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

        private void arV() {
            this.mTimer = new Timer();
            this.mTimer.schedule(arX(), 0L, 10000L);
        }

        private void arW() {
            this.cxh = com.baidu.swan.apps.performance.b.d.awt();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.awL().getBoolean("swan_5min_back_optimize", false)) {
                this.cxh = 30L;
            }
        }

        public void a(b bVar) {
            this.cxg = bVar;
        }

        private TimerTask arX() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.cxh);
                    }
                    a.this.cxh -= 10;
                    if (a.this.cxh <= 0 && a.this.cxg != null) {
                        a.this.cxg.ig(1);
                        a.this.acB();
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
