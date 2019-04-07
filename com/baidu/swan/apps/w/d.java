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
    private c ayv = new c(this);
    private a ayw = new a();
    private boolean ayx;

    /* loaded from: classes2.dex */
    public interface b {
        void cE(int i);
    }

    public void bN(Context context) {
        if (!this.ayx) {
            this.ayx = true;
            context.registerReceiver(this.ayv, c.getIntentFilter());
        }
    }

    public void bO(Context context) {
        if (this.ayx) {
            this.ayx = false;
            try {
                context.unregisterReceiver(this.ayv);
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
            DS();
        } else {
            DT();
        }
    }

    public void a(b bVar) {
        this.ayw.a(bVar);
    }

    public void DR() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.ayw.jL();
    }

    private void DS() {
        this.ayw.DV();
    }

    private void DT() {
        this.ayw.DW();
    }

    public void DU() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.ayw.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private b ayy;
        private long ayz = 300;
        private int mStatus = 0;
        private Timer mTimer;

        static /* synthetic */ long b(a aVar) {
            long j = aVar.ayz - 1;
            aVar.ayz = j;
            return j;
        }

        public void jL() {
            this.mStatus = 1;
            DY();
            wn();
            DX();
        }

        public void stopTimer() {
            this.mStatus = 2;
            wn();
            DY();
        }

        public void DV() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                wn();
                DX();
            }
        }

        public void DW() {
            if (this.mStatus != 2) {
                this.mStatus = 4;
                wn();
            }
        }

        private synchronized void wn() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        }

        private void DX() {
            this.mTimer = new Timer();
            this.mTimer.schedule(DZ(), 0L, 1000L);
        }

        private void DY() {
            this.ayz = 300L;
        }

        public void a(b bVar) {
            this.ayy = bVar;
        }

        private TimerTask DZ() {
            return new TimerTask() { // from class: com.baidu.swan.apps.w.d.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.ayz);
                    }
                    a.b(a.this);
                    if (a.this.ayz <= 0 && a.this.ayy != null) {
                        a.this.ayy.cE(1);
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
