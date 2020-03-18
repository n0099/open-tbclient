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
    private c bzI = new c(this);
    private a bzJ = new a();
    private boolean bzK;

    /* loaded from: classes11.dex */
    public interface b {
        void fn(int i);
    }

    public void ch(Context context) {
        if (!this.bzK) {
            this.bzK = true;
            context.registerReceiver(this.bzI, c.getIntentFilter());
        }
    }

    public void ci(Context context) {
        if (this.bzK) {
            this.bzK = false;
            try {
                context.unregisterReceiver(this.bzI);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            WN();
        } else {
            WO();
        }
    }

    public void a(b bVar) {
        this.bzJ.a(bVar);
    }

    public void WM() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.bzJ.startTimer();
    }

    private void WN() {
        this.bzJ.WQ();
    }

    private void WO() {
        this.bzJ.WR();
    }

    public void WP() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.bzJ.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private b bzL;
        private long bzM = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.bzM - 1;
            aVar.bzM = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            WT();
            cancelTimer();
            WS();
        }

        public void stopTimer() {
            this.mStatus = 2;
            cancelTimer();
            WT();
        }

        public void WQ() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                WS();
            }
        }

        public void WR() {
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

        private void WS() {
            this.mTimer = new Timer();
            this.mTimer.schedule(WU(), 0L, 1000L);
        }

        private void WT() {
            this.bzM = 300L;
        }

        public void a(b bVar) {
            this.bzL = bVar;
        }

        private TimerTask WU() {
            return new TimerTask() { // from class: com.baidu.swan.apps.y.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.bzM);
                    }
                    a.b(a.this);
                    if (a.this.bzM <= 0 && a.this.bzL != null) {
                        a.this.bzL.fn(1);
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
                        eVar.cQ(true);
                        return;
                    case 1:
                        eVar.cQ(false);
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
