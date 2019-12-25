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
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean buA;
    private c buy = new c(this);
    private a buz = new a();

    /* loaded from: classes9.dex */
    public interface b {
        void eW(int i);
    }

    public void ce(Context context) {
        if (!this.buA) {
            this.buA = true;
            context.registerReceiver(this.buy, c.getIntentFilter());
        }
    }

    public void cf(Context context) {
        if (this.buA) {
            this.buA = false;
            try {
                context.unregisterReceiver(this.buy);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            TX();
        } else {
            TY();
        }
    }

    public void a(b bVar) {
        this.buz.a(bVar);
    }

    public void TW() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.buz.startTimer();
    }

    private void TX() {
        this.buz.Ua();
    }

    private void TY() {
        this.buz.Ub();
    }

    public void TZ() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.buz.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private b buB;
        private long buC = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.buC - 1;
            aVar.buC = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            Ud();
            cancelTimer();
            Uc();
        }

        public void stopTimer() {
            this.mStatus = 2;
            cancelTimer();
            Ud();
        }

        public void Ua() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                Uc();
            }
        }

        public void Ub() {
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

        private void Uc() {
            this.mTimer = new Timer();
            this.mTimer.schedule(Ue(), 0L, 1000L);
        }

        private void Ud() {
            this.buC = 300L;
        }

        public void a(b bVar) {
            this.buB = bVar;
        }

        private TimerTask Ue() {
            return new TimerTask() { // from class: com.baidu.swan.apps.y.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.buC);
                    }
                    a.b(a.this);
                    if (a.this.buC <= 0 && a.this.buB != null) {
                        a.this.buB.eW(1);
                        a.this.stopTimer();
                    }
                }
            };
        }
    }

    /* loaded from: classes9.dex */
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
                        eVar.cD(true);
                        return;
                    case 1:
                        eVar.cD(false);
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
