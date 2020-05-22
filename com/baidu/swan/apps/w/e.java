package com.baidu.swan.apps.w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c civ = new c(this);
    private a ciw = new a();
    private boolean cix;

    /* loaded from: classes11.dex */
    public interface b {
        void fF(int i);
    }

    public void bU(Context context) {
        if (!this.cix) {
            this.cix = true;
            context.registerReceiver(this.civ, c.getIntentFilter());
        }
    }

    public void bV(Context context) {
        if (this.cix) {
            this.cix = false;
            try {
                context.unregisterReceiver(this.civ);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ec(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            ahN();
        } else {
            ahO();
        }
    }

    public void a(b bVar) {
        this.ciw.a(bVar);
    }

    public void ahM() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.ciw.startTimer();
    }

    private void ahN() {
        this.ciw.ahQ();
    }

    private void ahO() {
        this.ciw.ahR();
    }

    public void ahP() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.ciw.UI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private b ciy;
        private long ciz = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.ciz - 1;
            aVar.ciz = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            ahT();
            cancelTimer();
            ahS();
        }

        public void UI() {
            this.mStatus = 2;
            cancelTimer();
            ahT();
        }

        public void ahQ() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                ahS();
            }
        }

        public void ahR() {
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

        private void ahS() {
            this.mTimer = new Timer();
            this.mTimer.schedule(ahU(), 0L, 1000L);
        }

        private void ahT() {
            this.ciz = 300L;
            if (e.DEBUG && com.baidu.swan.apps.af.a.a.alZ().getBoolean("swan_5min_back_optimize", false)) {
                this.ciz = 30L;
            }
        }

        public void a(b bVar) {
            this.ciy = bVar;
        }

        private TimerTask ahU() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.ciz);
                    }
                    a.b(a.this);
                    if (a.this.ciz <= 0 && a.this.ciy != null) {
                        a.this.ciy.fF(1);
                        a.this.UI();
                    }
                }
            };
        }
    }

    /* loaded from: classes11.dex */
    private static class c extends BroadcastReceiver {
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
                        eVar.ec(true);
                        return;
                    case 1:
                        eVar.ec(false);
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
