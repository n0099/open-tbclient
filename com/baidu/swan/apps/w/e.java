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
    private c cnj = new c(this);
    private a cnk = new a();
    private boolean cnl;

    /* loaded from: classes11.dex */
    public interface b {
        void fS(int i);
    }

    public void bV(Context context) {
        if (!this.cnl) {
            this.cnl = true;
            context.registerReceiver(this.cnj, c.getIntentFilter());
        }
    }

    public void bW(Context context) {
        if (this.cnl) {
            this.cnl = false;
            try {
                context.unregisterReceiver(this.cnj);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            aiT();
        } else {
            aiU();
        }
    }

    public void a(b bVar) {
        this.cnk.a(bVar);
    }

    public void aiS() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.cnk.startTimer();
    }

    private void aiT() {
        this.cnk.aiW();
    }

    private void aiU() {
        this.cnk.aiX();
    }

    public void aiV() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.cnk.VO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private b cnm;
        private long cnn = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.cnn - 1;
            aVar.cnn = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            aiZ();
            cancelTimer();
            aiY();
        }

        public void VO() {
            this.mStatus = 2;
            cancelTimer();
            aiZ();
        }

        public void aiW() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                aiY();
            }
        }

        public void aiX() {
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

        private void aiY() {
            this.mTimer = new Timer();
            this.mTimer.schedule(aja(), 0L, 1000L);
        }

        private void aiZ() {
            this.cnn = 300L;
            if (e.DEBUG && com.baidu.swan.apps.af.a.a.anf().getBoolean("swan_5min_back_optimize", false)) {
                this.cnn = 30L;
            }
        }

        public void a(b bVar) {
            this.cnm = bVar;
        }

        private TimerTask aja() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.cnn);
                    }
                    a.b(a.this);
                    if (a.this.cnn <= 0 && a.this.cnm != null) {
                        a.this.cnm.fS(1);
                        a.this.VO();
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
                        eVar.eh(true);
                        return;
                    case 1:
                        eVar.eh(false);
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
