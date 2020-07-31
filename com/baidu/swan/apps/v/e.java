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
    private c cpp = new c(this);
    private a cpq = new a();
    private boolean cpr;

    /* loaded from: classes7.dex */
    public interface b {
        void gc(int i);
    }

    public void bY(Context context) {
        if (!this.cpr) {
            this.cpr = true;
            context.registerReceiver(this.cpp, c.getIntentFilter());
        }
    }

    public void bZ(Context context) {
        if (this.cpr) {
            this.cpr = false;
            try {
                context.unregisterReceiver(this.cpp);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            akj();
        } else {
            akk();
        }
    }

    public void a(b bVar) {
        this.cpq.a(bVar);
    }

    public void aki() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.cpq.startTimer();
    }

    private void akj() {
        this.cpq.akm();
    }

    private void akk() {
        this.cpq.akn();
    }

    public void akl() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.cpq.Wv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private b cps;
        private long cpt = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            akp();
            cancelTimer();
            ako();
        }

        public void Wv() {
            this.mStatus = 2;
            cancelTimer();
            akp();
        }

        public void akm() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                ako();
            }
        }

        public void akn() {
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

        private void ako() {
            this.mTimer = new Timer();
            this.mTimer.schedule(akq(), 0L, 10000L);
        }

        private void akp() {
            this.cpt = com.baidu.swan.apps.performance.b.c.aos();
            if (e.DEBUG && com.baidu.swan.apps.ae.a.a.aoO().getBoolean("swan_5min_back_optimize", false)) {
                this.cpt = 30L;
            }
        }

        public void a(b bVar) {
            this.cps = bVar;
        }

        private TimerTask akq() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.cpt);
                    }
                    a.this.cpt -= 10;
                    if (a.this.cpt <= 0 && a.this.cps != null) {
                        a.this.cps.gc(1);
                        a.this.Wv();
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
                        eVar.ep(true);
                        return;
                    case 1:
                        eVar.ep(false);
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
