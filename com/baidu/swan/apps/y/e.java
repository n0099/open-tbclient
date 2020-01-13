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
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c bvm = new c(this);
    private a bvn = new a();
    private boolean bvo;

    /* loaded from: classes10.dex */
    public interface b {
        void eX(int i);
    }

    public void ce(Context context) {
        if (!this.bvo) {
            this.bvo = true;
            context.registerReceiver(this.bvm, c.getIntentFilter());
        }
    }

    public void cf(Context context) {
        if (this.bvo) {
            this.bvo = false;
            try {
                context.unregisterReceiver(this.bvm);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            Uu();
        } else {
            Uv();
        }
    }

    public void a(b bVar) {
        this.bvn.a(bVar);
    }

    public void Ut() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.bvn.startTimer();
    }

    private void Uu() {
        this.bvn.Ux();
    }

    private void Uv() {
        this.bvn.Uy();
    }

    public void Uw() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.bvn.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private b bvp;
        private long bvq = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.bvq - 1;
            aVar.bvq = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            UA();
            cancelTimer();
            Uz();
        }

        public void stopTimer() {
            this.mStatus = 2;
            cancelTimer();
            UA();
        }

        public void Ux() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                Uz();
            }
        }

        public void Uy() {
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

        private void Uz() {
            this.mTimer = new Timer();
            this.mTimer.schedule(UB(), 0L, 1000L);
        }

        private void UA() {
            this.bvq = 300L;
        }

        public void a(b bVar) {
            this.bvp = bVar;
        }

        private TimerTask UB() {
            return new TimerTask() { // from class: com.baidu.swan.apps.y.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.bvq);
                    }
                    a.b(a.this);
                    if (a.this.bvq <= 0 && a.this.bvp != null) {
                        a.this.bvp.eX(1);
                        a.this.stopTimer();
                    }
                }
            };
        }
    }

    /* loaded from: classes10.dex */
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
                        eVar.cI(true);
                        return;
                    case 1:
                        eVar.cI(false);
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
