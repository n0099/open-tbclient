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
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cLk;
    private c cLi = new c(this);
    private a cLj = new a();
    private final com.baidu.swan.apps.v.a.a cLl = com.baidu.swan.apps.v.a.c.avG();

    /* loaded from: classes10.dex */
    public interface b {
        void iN(int i);
    }

    public void cj(Context context) {
        if (!this.cLk) {
            this.cLk = true;
            context.registerReceiver(this.cLi, c.getIntentFilter());
        }
    }

    public void ck(Context context) {
        if (this.cLk) {
            this.cLk = false;
            try {
                context.unregisterReceiver(this.cLi);
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
            avm();
        } else {
            avn();
        }
    }

    public void a(b bVar) {
        this.cLj.a(bVar);
    }

    public void avl() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.cLl.onPause();
        this.cLj.startTimer();
    }

    private void avm() {
        this.cLj.avp();
    }

    private void avn() {
        this.cLj.avq();
    }

    public void avo() {
        if (DEBUG) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.cLl.onResume();
        this.cLj.afW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private b cLm;
        private long cLn = 300;
        private int mStatus = 0;
        private Timer mTimer;

        public void startTimer() {
            this.mStatus = 1;
            avs();
            cancelTimer();
            avr();
        }

        public void afW() {
            this.mStatus = 2;
            cancelTimer();
            avs();
        }

        public void avp() {
            if (this.mStatus == 4) {
                this.mStatus = 3;
                cancelTimer();
                avr();
            }
        }

        public void avq() {
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

        private void avr() {
            this.mTimer = new Timer();
            this.mTimer.schedule(avt(), 0L, 10000L);
        }

        private void avs() {
            this.cLn = com.baidu.swan.apps.performance.b.d.azN();
            if (e.DEBUG && com.baidu.swan.apps.ad.a.a.aAf().getBoolean("swan_5min_back_optimize", false)) {
                this.cLn = 30L;
            }
        }

        public void a(b bVar) {
            this.cLm = bVar;
        }

        private TimerTask avt() {
            return new TimerTask() { // from class: com.baidu.swan.apps.v.e.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d("SwanAppCollectionPolicy", "task run: " + a.this.cLn);
                    }
                    a.this.cLn -= 10;
                    if (a.this.cLn <= 0 && a.this.cLm != null) {
                        a.this.cLm.iN(1);
                        a.this.afW();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
