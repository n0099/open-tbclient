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
/* loaded from: classes9.dex */
public class d {
    private static volatile d ebY;
    private HandlerThread ebZ;
    private a eca;
    private b ecb;
    private c ecd;
    private long mStartTime;
    private int aXy = 0;
    private long ecc = 300000;
    private e.a ece = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.kT(gVar.ecj)) {
                d.this.dk(gVar.interval * 1000);
                d.this.az(gVar.state, gVar.eci);
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

    public static d aTF() {
        if (ebY == null) {
            synchronized (d.class) {
                if (ebY == null) {
                    ebY = new d();
                }
            }
        }
        return ebY;
    }

    public void a(b bVar) {
        this.ecb = bVar;
    }

    private void create() {
        aTG();
        hX(true);
        startMonitor();
        this.ecd = new c();
    }

    private void aTG() {
        if (this.ebZ == null) {
            this.ebZ = new HandlerThread("anti_addiction_monitor");
            this.ebZ.start();
            this.eca = new a(this.ebZ.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aXy == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null || aIL.aIE() == null) {
            return null;
        }
        return aIL.aIE();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.eca.aTK()) {
            this.mStartTime = System.currentTimeMillis();
            this.eca.aTJ();
        }
    }

    public synchronized void aTH() {
        if (isOpen()) {
            hX(false);
        }
        this.eca.aTH();
    }

    public void aTI() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0511a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0511a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(activity, a.h.swan_game_anti_addiction_success).aIs();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0511a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0511a interfaceC0511a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0511a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0511a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0511a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0511a
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
                                interfaceC0511a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0511a.onFail(fVar.msg);
                            } else {
                                interfaceC0511a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.ecd.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0511a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0511a
                public void onFail(String str2) {
                    interfaceC0511a.onFail(str2);
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
        e.a(j, this.ece);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kT(int i) {
        this.aXy = i;
        if (1 == i) {
            aTH();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(long j) {
        if (300000 < j) {
            this.ecc = j;
        } else {
            this.ecc = 300000L;
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
                    this.ecd.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aTI();
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
        if (this.ecb != null) {
            try {
                this.ecb.ay(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.eca.aTH();
        if (this.ebZ != null) {
            this.ebZ.quitSafely();
            this.ebZ = null;
        }
        if (this.ecd != null) {
            this.ecd.destroy();
            this.ecd = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (ebY != null) {
                ebY.destroy();
                ebY = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.hX(false);
                    aTJ();
                    return;
                default:
                    return;
            }
        }

        void aTJ() {
            if (1 != d.this.aXy) {
                sendEmptyMessageDelayed(1, d.this.ecc);
            }
        }

        void aTH() {
            removeCallbacksAndMessages(null);
        }

        boolean aTK() {
            return hasMessages(1);
        }
    }
}
