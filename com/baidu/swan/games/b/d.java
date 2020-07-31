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
/* loaded from: classes7.dex */
public class d {
    private static volatile d ddJ;
    private HandlerThread ddK;
    private a ddL;
    private b ddM;
    private c ddO;
    private long mStartTime;
    private int aJu = 0;
    private long ddN = 300000;
    private e.a ddP = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.iI(gVar.ddU)) {
                d.this.bQ(gVar.interval * 1000);
                d.this.ac(gVar.state, gVar.ddT);
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

    public static d aBS() {
        if (ddJ == null) {
            synchronized (d.class) {
                if (ddJ == null) {
                    ddJ = new d();
                }
            }
        }
        return ddJ;
    }

    public void a(b bVar) {
        this.ddM = bVar;
    }

    private void create() {
        aBT();
        gc(true);
        startMonitor();
        this.ddO = new c();
    }

    private void aBT() {
        if (this.ddK == null) {
            this.ddK = new HandlerThread("anti_addiction_monitor");
            this.ddK.start();
            this.ddL = new a(this.ddK.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aJu == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null || arw.arp() == null) {
            return null;
        }
        return arw.arp();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.ddL.aBX()) {
            this.mStartTime = System.currentTimeMillis();
            this.ddL.aBW();
        }
    }

    public synchronized void aBU() {
        if (isOpen()) {
            gc(false);
        }
        this.ddL.aBU();
    }

    public void aBV() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0442a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0442a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0442a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0442a interfaceC0442a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0442a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0442a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0442a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0442a
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
                                interfaceC0442a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0442a.onFail(fVar.msg);
                            } else {
                                interfaceC0442a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.ddO.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0442a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0442a
                public void onFail(String str2) {
                    interfaceC0442a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(boolean z) {
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
        e.a(j, this.ddP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iI(int i) {
        this.aJu = i;
        if (1 == i) {
            aBU();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(long j) {
        if (300000 < j) {
            this.ddN = j;
        } else {
            this.ddN = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
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
                    this.ddO.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aBV();
                        }
                    });
                    return;
                }
                return;
            default:
                ad(i, str);
                return;
        }
    }

    private void ad(int i, String str) {
        if (this.ddM != null) {
            try {
                this.ddM.ab(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.ddL.aBU();
        if (this.ddK != null) {
            this.ddK.quitSafely();
            this.ddK = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (ddJ != null) {
                ddJ.destroy();
                ddJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.gc(false);
                    aBW();
                    return;
                default:
                    return;
            }
        }

        void aBW() {
            if (1 != d.this.aJu) {
                sendEmptyMessageDelayed(1, d.this.ddN);
            }
        }

        void aBU() {
            removeCallbacksAndMessages(null);
        }

        boolean aBX() {
            return hasMessages(1);
        }
    }
}
