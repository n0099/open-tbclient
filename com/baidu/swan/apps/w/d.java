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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private c ayr = new c(this);
    private a ays = new a();
    private boolean ayt;

    /* loaded from: classes2.dex */
    public interface b {
        void cF(int i);
    }

    public void bN(Context context) {
        if (!this.ayt) {
            this.ayt = true;
            context.registerReceiver(this.ayr, c.getIntentFilter());
        }
    }

    public void bO(Context context) {
        if (this.ayt) {
            this.ayt = false;
            try {
                context.unregisterReceiver(this.ayr);
            } catch (IllegalArgumentException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            DU();
        } else {
            DV();
        }
    }

    public void a(b bVar) {
        this.ays.a(bVar);
    }

    public void DT() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.ays.jL();
    }

    private void DU() {
        this.ays.DX();
    }

    private void DV() {
        this.ays.DY();
    }

    public void DW() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.ays.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private b ayu;
        private long ayv = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.ayv - 1;
            aVar.ayv = j;
            return j;
        }

        public void jL() {
            this.mStatus = 1;
            Ea();
            wo();
            DZ();
        }

        public void stopTimer() {
            this.mStatus = 2;
            wo();
            Ea();
        }

        public void DX() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                wo();
                DZ();
            }
        }

        public void DY() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                wo();
            }
        }

        private synchronized void wo() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void DZ() {
            this.mTimer = new Timer();
            this.mTimer.schedule(Eb(), 0L, 1000L);
        }

        private void Ea() {
            this.ayv = 300L;
        }

        public void a(b bVar) {
            this.ayu = bVar;
        }

        private TimerTask Eb() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.d.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.ayv);
                    }
                    a.b(a.this);
                    if (a.this.ayv <= 0 && a.this.ayu != null) {
                        a.this.ayu.cF(1);
                        a.this.stopTimer();
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
                        dVar.bj(true);
                        return;
                    case 1:
                        dVar.bj(false);
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
