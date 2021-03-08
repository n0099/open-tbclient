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
/* loaded from: classes8.dex */
public class d {
    private static volatile d edz;
    private HandlerThread edA;
    private a edB;
    private b edC;
    private c edE;
    private long mStartTime;
    private int aYY = 0;
    private long edD = 300000;
    private e.a edF = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.kU(gVar.edK)) {
                d.this.dk(gVar.interval * 1000);
                d.this.az(gVar.state, gVar.edJ);
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

    public static d aTI() {
        if (edz == null) {
            synchronized (d.class) {
                if (edz == null) {
                    edz = new d();
                }
            }
        }
        return edz;
    }

    public void a(b bVar) {
        this.edC = bVar;
    }

    private void create() {
        aTJ();
        hX(true);
        startMonitor();
        this.edE = new c();
    }

    private void aTJ() {
        if (this.edA == null) {
            this.edA = new HandlerThread("anti_addiction_monitor");
            this.edA.start();
            this.edB = new a(this.edA.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aYY == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null || aIO.aIH() == null) {
            return null;
        }
        return aIO.aIH();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.edB.aTN()) {
            this.mStartTime = System.currentTimeMillis();
            this.edB.aTM();
        }
    }

    public synchronized void aTK() {
        if (isOpen()) {
            hX(false);
        }
        this.edB.aTK();
    }

    public void aTL() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0517a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0517a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(activity, a.h.swan_game_anti_addiction_success).aIv();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0517a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0517a interfaceC0517a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0517a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0517a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0517a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0517a
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
                                interfaceC0517a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0517a.onFail(fVar.msg);
                            } else {
                                interfaceC0517a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.edE.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0517a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0517a
                public void onFail(String str2) {
                    interfaceC0517a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(boolean z) {
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
        e.a(j, this.edF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kU(int i) {
        this.aYY = i;
        if (1 == i) {
            aTK();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(long j) {
        if (300000 < j) {
            this.edD = j;
        } else {
            this.edD = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(int i, String str) {
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
                    this.edE.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aTL();
                        }
                    });
                    return;
                }
                return;
            default:
                aA(i, str);
                return;
        }
    }

    private void aA(int i, String str) {
        if (this.edC != null) {
            try {
                this.edC.ay(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.edB.aTK();
        if (this.edA != null) {
            this.edA.quitSafely();
            this.edA = null;
        }
        if (this.edE != null) {
            this.edE.destroy();
            this.edE = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (edz != null) {
                edz.destroy();
                edz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.hX(false);
                    aTM();
                    return;
                default:
                    return;
            }
        }

        void aTM() {
            if (1 != d.this.aYY) {
                sendEmptyMessageDelayed(1, d.this.edD);
            }
        }

        void aTK() {
            removeCallbacksAndMessages(null);
        }

        boolean aTN() {
            return hasMessages(1);
        }
    }
}
