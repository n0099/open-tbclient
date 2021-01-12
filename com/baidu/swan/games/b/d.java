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
    private static volatile d dZR;
    private HandlerThread dZS;
    private a dZT;
    private b dZU;
    private c dZW;
    private long mStartTime;
    private int aUt = 0;
    private long dZV = 300000;
    private e.a dZX = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.kQ(gVar.eac)) {
                d.this.de(gVar.interval * 1000);
                d.this.av(gVar.state, gVar.eab);
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

    public static d aTt() {
        if (dZR == null) {
            synchronized (d.class) {
                if (dZR == null) {
                    dZR = new d();
                }
            }
        }
        return dZR;
    }

    public void a(b bVar) {
        this.dZU = bVar;
    }

    private void create() {
        aTu();
        hV(true);
        startMonitor();
        this.dZW = new c();
    }

    private void aTu() {
        if (this.dZS == null) {
            this.dZS = new HandlerThread("anti_addiction_monitor");
            this.dZS.start();
            this.dZT = new a(this.dZS.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aUt == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null || aIs.aIl() == null) {
            return null;
        }
        return aIs.aIl();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dZT.aTy()) {
            this.mStartTime = System.currentTimeMillis();
            this.dZT.aTx();
        }
    }

    public synchronized void aTv() {
        if (isOpen()) {
            hV(false);
        }
        this.dZT.aTv();
    }

    public void aTw() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0514a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0514a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(activity, a.h.swan_game_anti_addiction_success).aHZ();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0514a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0514a interfaceC0514a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0514a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0514a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0514a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0514a
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
                                interfaceC0514a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0514a.onFail(fVar.msg);
                            } else {
                                interfaceC0514a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dZW.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0514a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0514a
                public void onFail(String str2) {
                    interfaceC0514a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV(boolean z) {
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
        e.a(j, this.dZX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kQ(int i) {
        this.aUt = i;
        if (1 == i) {
            aTv();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(long j) {
        if (300000 < j) {
            this.dZV = j;
        } else {
            this.dZV = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
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
                    this.dZW.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aTw();
                        }
                    });
                    return;
                }
                return;
            default:
                aw(i, str);
                return;
        }
    }

    private void aw(int i, String str) {
        if (this.dZU != null) {
            try {
                this.dZU.au(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dZT.aTv();
        if (this.dZS != null) {
            this.dZS.quitSafely();
            this.dZS = null;
        }
        if (this.dZW != null) {
            this.dZW.destroy();
            this.dZW = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dZR != null) {
                dZR.destroy();
                dZR = null;
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
                    d.this.hV(false);
                    aTx();
                    return;
                default:
                    return;
            }
        }

        void aTx() {
            if (1 != d.this.aUt) {
                sendEmptyMessageDelayed(1, d.this.dZV);
            }
        }

        void aTv() {
            removeCallbacksAndMessages(null);
        }

        boolean aTy() {
            return hasMessages(1);
        }
    }
}
