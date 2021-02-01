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
    private boolean dhe;
    private c dhc = new c(this);
    private a dhd = new a();
    private final com.baidu.swan.apps.v.a.a dhf = com.baidu.swan.apps.v.a.c.aAx();

    /* loaded from: classes9.dex */
    public interface b {
        void hU(int i);
    }

    public void cV(Context context) {
        if (!this.dhe) {
            this.dhe = true;
            context.registerReceiver(this.dhc, c.getIntentFilter());
        }
    }

    public void cW(Context context) {
        if (this.dhe) {
            this.dhe = false;
            try {
                context.unregisterReceiver(this.dhc);
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
            aAd();
        } else {
            aAe();
        }
    }

    public void a(b bVar) {
        this.dhd.a(bVar);
    }

    public void aAc() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.dhf.onPause();
        this.dhd.startTimer();
    }

    private void aAd() {
        this.dhd.aAg();
    }

    private void aAe() {
        this.dhd.aAh();
    }

    public void aAf() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.dhf.onResume();
        this.dhd.akF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private b dhg;
        private long dhh = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            aAj();
            cancelTimer();
            aAi();
        }

        public void akF() {
            this.mStatus = 2;
            cancelTimer();
            aAj();
        }

        public void aAg() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                aAi();
            }
        }

        public void aAh() {
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

        private void aAi() {
            this.mTimer = new Timer();
            this.mTimer.schedule(aAk(), 0L, 10000L);
        }

        private void aAj() {
            this.dhh = com.baidu.swan.apps.performance.b.d.aEC();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aEU().getBoolean("swan_5min_back_optimize", false)) {
                this.dhh = 30L;
            }
        }

        public void a(b bVar) {
            this.dhg = bVar;
        }

        private TimerTask aAk() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.dhh);
                    }
                    a.this.dhh -= 10;
                    if (a.this.dhh <= 0 && a.this.dhg != null) {
                        a.this.dhg.hU(1);
                        a.this.akF();
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
