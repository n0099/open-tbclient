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
    private static volatile d dnR;
    private HandlerThread dnS;
    private a dnT;
    private b dnU;
    private c dnW;
    private long mStartTime;
    private int aOF = 0;
    private long dnV = 300000;
    private e.a dnX = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.kR(gVar.dod)) {
                d.this.bX(gVar.interval * 1000);
                d.this.aa(gVar.state, gVar.dob);
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

    public static d aKH() {
        if (dnR == null) {
            synchronized (d.class) {
                if (dnR == null) {
                    dnR = new d();
                }
            }
        }
        return dnR;
    }

    public void a(b bVar) {
        this.dnU = bVar;
    }

    private void create() {
        aKI();
        gy(true);
        startMonitor();
        this.dnW = new c();
    }

    private void aKI() {
        if (this.dnS == null) {
            this.dnS = new HandlerThread("anti_addiction_monitor");
            this.dnS.start();
            this.dnT = new a(this.dnS.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aOF == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null || azJ.azC() == null) {
            return null;
        }
        return azJ.azC();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dnT.aKM()) {
            this.mStartTime = System.currentTimeMillis();
            this.dnT.aKL();
        }
    }

    public synchronized void aKJ() {
        if (isOpen()) {
            gy(false);
        }
        this.dnT.aKJ();
    }

    public void aKK() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0490a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0490a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0490a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0490a interfaceC0490a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0490a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0490a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0490a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0490a
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
                                interfaceC0490a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0490a.onFail(fVar.msg);
                            } else {
                                interfaceC0490a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dnW.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0490a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0490a
                public void onFail(String str2) {
                    interfaceC0490a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(boolean z) {
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
        e.a(j, this.dnX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kR(int i) {
        this.aOF = i;
        if (1 == i) {
            aKJ();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(long j) {
        if (300000 < j) {
            this.dnV = j;
        } else {
            this.dnV = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
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
                    this.dnW.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aKK();
                        }
                    });
                    return;
                }
                return;
            default:
                ab(i, str);
                return;
        }
    }

    private void ab(int i, String str) {
        if (this.dnU != null) {
            try {
                this.dnU.Z(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dnT.aKJ();
        if (this.dnS != null) {
            this.dnS.quitSafely();
            this.dnS = null;
        }
        if (this.dnW != null) {
            this.dnW.destroy();
            this.dnW = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dnR != null) {
                dnR.destroy();
                dnR = null;
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
                    d.this.gy(false);
                    aKL();
                    return;
                default:
                    return;
            }
        }

        void aKL() {
            if (1 != d.this.aOF) {
                sendEmptyMessageDelayed(1, d.this.dnV);
            }
        }

        void aKJ() {
            removeCallbacksAndMessages(null);
        }

        boolean aKM() {
            return hasMessages(1);
        }
    }
}
