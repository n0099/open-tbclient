package com.baidu.swan.apps.y;

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
    private c bzv = new c(this);
    private a bzw = new a();
    private boolean bzx;

    /* loaded from: classes11.dex */
    public interface b {
        void fn(int i);
    }

    public void ci(Context context) {
        if (!this.bzx) {
            this.bzx = true;
            context.registerReceiver(this.bzv, c.getIntentFilter());
        }
    }

    public void cj(Context context) {
        if (this.bzx) {
            this.bzx = false;
            try {
                context.unregisterReceiver(this.bzv);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            WI();
        } else {
            WJ();
        }
    }

    public void a(b bVar) {
        this.bzw.a(bVar);
    }

    public void WH() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.bzw.startTimer();
    }

    private void WI() {
        this.bzw.WL();
    }

    private void WJ() {
        this.bzw.WM();
    }

    public void WK() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.bzw.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private b bzy;
        private long bzz = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.bzz - 1;
            aVar.bzz = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            WO();
            cancelTimer();
            WN();
        }

        public void stopTimer() {
            this.mStatus = 2;
            cancelTimer();
            WO();
        }

        public void WL() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                WN();
            }
        }

        public void WM() {
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

        private void WN() {
            this.mTimer = new Timer();
            this.mTimer.schedule(WP(), 0L, 1000L);
        }

        private void WO() {
            this.bzz = 300L;
        }

        public void a(b bVar) {
            this.bzy = bVar;
        }

        private TimerTask WP() {
            return new TimerTask() { // from class: com.baidu.swan.apps.y.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.bzz);
                    }
                    a.b(a.this);
                    if (a.this.bzz <= 0 && a.this.bzy != null) {
                        a.this.bzy.fn(1);
                        a.this.stopTimer();
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
                        eVar.cP(true);
                        return;
                    case 1:
                        eVar.cP(false);
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
