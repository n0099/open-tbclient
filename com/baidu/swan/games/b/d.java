package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.b.a;
import com.baidu.swan.games.b.e;
import org.json.JSONException;
/* loaded from: classes11.dex */
public class d {
    private static volatile d cXZ;
    private HandlerThread cYa;
    private a cYb;
    private b cYc;
    private c cYe;
    private long mStartTime;
    private int aHZ = 0;
    private long cYd = 300000;
    private e.a cYf = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.ir(gVar.cYk)) {
                d.this.bD(gVar.interval * 1000);
                d.this.ab(gVar.state, gVar.cYj);
            }
        }

        @Override // com.baidu.swan.games.b.e.a
        public void onFail(String str) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("AntiAddictionManager", str);
            }
        }
    };

    private d() {
        create();
    }

    public static d ayn() {
        if (cXZ == null) {
            synchronized (d.class) {
                if (cXZ == null) {
                    cXZ = new d();
                }
            }
        }
        return cXZ;
    }

    public void a(b bVar) {
        this.cYc = bVar;
    }

    private void create() {
        ayo();
        fL(true);
        startMonitor();
        this.cYe = new c();
    }

    private void ayo() {
        if (this.cYa == null) {
            this.cYa = new HandlerThread("anti_addiction_monitor");
            this.cYa.start();
            this.cYb = new a(this.cYa.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aHZ == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null || apN.apG() == null) {
            return null;
        }
        return apN.apG();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.cYb.ays()) {
            this.mStartTime = System.currentTimeMillis();
            this.cYb.ayr();
        }
    }

    public synchronized void ayp() {
        if (isOpen()) {
            fL(false);
        }
        this.cYb.ayp();
    }

    public void ayq() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0429a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0429a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0429a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0429a interfaceC0429a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0429a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0429a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0429a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0429a
                public void onSuccess() {
                    e.a(str, new e.a() { // from class: com.baidu.swan.games.b.d.2.1
                        @Override // com.baidu.swan.games.b.e.a
                        public void onSuccess(Object obj) {
                            Activity activity;
                            f fVar = (f) obj;
                            if (com.baidu.swan.apps.b.DEBUG) {
                                Log.d("AntiAddictionManager", fVar.toString());
                            }
                            if (fVar.state == 0) {
                                interfaceC0429a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0429a.onFail(fVar.msg);
                            } else {
                                interfaceC0429a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.cYe.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0429a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0429a
                public void onFail(String str2) {
                    interfaceC0429a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(boolean z) {
        long j = 0;
        if (!z) {
            j = System.currentTimeMillis() - this.mStartTime;
            if (180000 > j) {
                return;
            }
        }
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        e.a(j, this.cYf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ir(int i) {
        this.aHZ = i;
        if (1 == i) {
            ayp();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(long j) {
        if (300000 < j) {
            this.cYd = j;
        } else {
            this.cYd = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (i < 0) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("AntiAddictionManager", "server AntiAddiction state error = " + i + " msg = " + str);
                return;
            }
            return;
        }
        switch (i) {
            case 0:
                return;
            case 1:
                Activity activity = getActivity();
                if (activity != null) {
                    this.cYe.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.ayq();
                        }
                    });
                    return;
                }
                return;
            default:
                ac(i, str);
                return;
        }
    }

    private void ac(int i, String str) {
        if (this.cYc != null) {
            try {
                this.cYc.aa(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.cYb.ayp();
        if (this.cYa != null) {
            this.cYa.quitSafely();
            this.cYa = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (cXZ != null) {
                cXZ.destroy();
                cXZ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.fL(false);
                    ayr();
                    return;
                default:
                    return;
            }
        }

        void ayr() {
            if (1 != d.this.aHZ) {
                sendEmptyMessageDelayed(1, d.this.cYd);
            }
        }

        void ayp() {
            removeCallbacksAndMessages(null);
        }

        boolean ays() {
            return hasMessages(1);
        }
    }
}
