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
/* loaded from: classes3.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean czf;
    private c czd = new c(this);
    private a cze = new a();
    private final com.baidu.swan.apps.v.a.a czg = com.baidu.swan.apps.v.a.c.asV();

    /* loaded from: classes3.dex */
    public interface b {
        void iq(int i);
    }

    public void cd(Context context) {
        if (!this.czf) {
            this.czf = true;
            context.registerReceiver(this.czd, c.getIntentFilter());
        }
    }

    public void ce(Context context) {
        if (this.czf) {
            this.czf = false;
            try {
                context.unregisterReceiver(this.czd);
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
            asB();
        } else {
            asC();
        }
    }

    public void a(b bVar) {
        this.cze.a(bVar);
    }

    public void asA() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.czg.onPause();
        this.cze.startTimer();
    }

    private void asB() {
        this.cze.asE();
    }

    private void asC() {
        this.cze.asF();
    }

    public void asD() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.czg.onResume();
        this.cze.adk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private b czh;
        private long czi = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            asH();
            cancelTimer();
            asG();
        }

        public void adk() {
            this.mStatus = 2;
            cancelTimer();
            asH();
        }

        public void asE() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                asG();
            }
        }

        public void asF() {
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

        private void asG() {
            this.mTimer = new Timer();
            this.mTimer.schedule(asI(), 0L, 10000L);
        }

        private void asH() {
            this.czi = com.baidu.swan.apps.performance.b.d.axc();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.axu().getBoolean("swan_5min_back_optimize", false)) {
                this.czi = 30L;
            }
        }

        public void a(b bVar) {
            this.czh = bVar;
        }

        private TimerTask asI() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.czi);
                    }
                    a.this.czi -= 10;
                    if (a.this.czi <= 0 && a.this.czh != null) {
                        a.this.czh.iq(1);
                        a.this.adk();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
