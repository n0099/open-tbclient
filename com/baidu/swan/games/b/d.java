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
/* loaded from: classes10.dex */
public class d {
    private static volatile d dQq;
    private HandlerThread dQr;
    private a dQs;
    private b dQt;
    private c dQv;
    private long mStartTime;
    private int aWf = 0;
    private long dQu = 300000;
    private e.a dQw = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.lU(gVar.dQB)) {
                d.this.cE(gVar.interval * 1000);
                d.this.as(gVar.state, gVar.dQA);
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

    public static d aSv() {
        if (dQq == null) {
            synchronized (d.class) {
                if (dQq == null) {
                    dQq = new d();
                }
            }
        }
        return dQq;
    }

    public void a(b bVar) {
        this.dQt = bVar;
    }

    private void create() {
        aSw();
        hp(true);
        startMonitor();
        this.dQv = new c();
    }

    private void aSw() {
        if (this.dQr == null) {
            this.dQr = new HandlerThread("anti_addiction_monitor");
            this.dQr.start();
            this.dQs = new a(this.dQr.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aWf == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null || aHv.aHo() == null) {
            return null;
        }
        return aHv.aHo();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dQs.aSA()) {
            this.mStartTime = System.currentTimeMillis();
            this.dQs.aSz();
        }
    }

    public synchronized void aSx() {
        if (isOpen()) {
            hp(false);
        }
        this.dQs.aSx();
    }

    public void aSy() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0528a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0528a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0528a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0528a interfaceC0528a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0528a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0528a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0528a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0528a
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
                                interfaceC0528a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0528a.onFail(fVar.msg);
                            } else {
                                interfaceC0528a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dQv.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0528a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0528a
                public void onFail(String str2) {
                    interfaceC0528a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(boolean z) {
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
        e.a(j, this.dQw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lU(int i) {
        this.aWf = i;
        if (1 == i) {
            aSx();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(long j) {
        if (300000 < j) {
            this.dQu = j;
        } else {
            this.dQu = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(int i, String str) {
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
                    this.dQv.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aSy();
                        }
                    });
                    return;
                }
                return;
            default:
                at(i, str);
                return;
        }
    }

    private void at(int i, String str) {
        if (this.dQt != null) {
            try {
                this.dQt.ar(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dQs.aSx();
        if (this.dQr != null) {
            this.dQr.quitSafely();
            this.dQr = null;
        }
        if (this.dQv != null) {
            this.dQv.destroy();
            this.dQv = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dQq != null) {
                dQq.destroy();
                dQq = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.hp(false);
                    aSz();
                    return;
                default:
                    return;
            }
        }

        void aSz() {
            if (1 != d.this.aWf) {
                sendEmptyMessageDelayed(1, d.this.dQu);
            }
        }

        void aSx() {
            removeCallbacksAndMessages(null);
        }

        boolean aSA() {
            return hasMessages(1);
        }
    }
}
