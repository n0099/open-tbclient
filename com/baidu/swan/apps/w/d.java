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
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c aTN = new c(this);
    private a aTO = new a();
    private boolean aTP;

    /* loaded from: classes2.dex */
    public interface b {
        void dE(int i);
    }

    public void bl(Context context) {
        if (!this.aTP) {
            this.aTP = true;
            context.registerReceiver(this.aTN, c.getIntentFilter());
        }
    }

    public void bm(Context context) {
        if (this.aTP) {
            this.aTP = false;
            try {
                context.unregisterReceiver(this.aTN);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            Lv();
        } else {
            Lw();
        }
    }

    public void a(b bVar) {
        this.aTO.a(bVar);
    }

    public void Lu() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.aTO.startTimer();
    }

    private void Lv() {
        this.aTO.Ly();
    }

    private void Lw() {
        this.aTO.Lz();
    }

    public void Lx() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.aTO.CE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private b aTQ;
        private long aTR = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.aTR - 1;
            aVar.aTR = j;
            return j;
        }

        public void startTimer() {
            this.mStatus = 1;
            LB();
            CF();
            LA();
        }

        public void CE() {
            this.mStatus = 2;
            CF();
            LB();
        }

        public void Ly() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                CF();
                LA();
            }
        }

        public void Lz() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                CF();
            }
        }

        private synchronized void CF() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void LA() {
            this.mTimer = new Timer();
            this.mTimer.schedule(LC(), 0L, 1000L);
        }

        private void LB() {
            this.aTR = 300L;
        }

        public void a(b bVar) {
            this.aTQ = bVar;
        }

        private TimerTask LC() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.d.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.aTR);
                    }
                    a.b(a.this);
                    if (a.this.aTR <= 0 && a.this.aTQ != null) {
                        a.this.aTQ.dE(1);
                        a.this.CE();
                    }
                }
            };
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends BroadcastReceiver {
        private WeakReference<d> mPolicyRef;

        c(d dVar) {
            this.mPolicyRef = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d dVar;
            if (intent != null && !TextUtils.isEmpty(intent.getAction()) && (dVar = this.mPolicyRef.get()) != null) {
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
                        dVar.bN(true);
                        return;
                    case 1:
                        dVar.bN(false);
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
