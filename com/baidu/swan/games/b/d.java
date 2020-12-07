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
/* loaded from: classes25.dex */
public class d {
    private static volatile d dVG;
    private HandlerThread dVH;
    private a dVI;
    private b dVJ;
    private c dVL;
    private long mStartTime;
    private int aXB = 0;
    private long dVK = 300000;
    private e.a dVM = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.mo(gVar.dVR)) {
                d.this.dd(gVar.interval * 1000);
                d.this.as(gVar.state, gVar.dVQ);
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

    public static d aUS() {
        if (dVG == null) {
            synchronized (d.class) {
                if (dVG == null) {
                    dVG = new d();
                }
            }
        }
        return dVG;
    }

    public void a(b bVar) {
        this.dVJ = bVar;
    }

    private void create() {
        aUT();
        hH(true);
        startMonitor();
        this.dVL = new c();
    }

    private void aUT() {
        if (this.dVH == null) {
            this.dVH = new HandlerThread("anti_addiction_monitor");
            this.dVH.start();
            this.dVI = new a(this.dVH.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aXB == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null || aJV.aJO() == null) {
            return null;
        }
        return aJV.aJO();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dVI.aUX()) {
            this.mStartTime = System.currentTimeMillis();
            this.dVI.aUW();
        }
    }

    public synchronized void aUU() {
        if (isOpen()) {
            hH(false);
        }
        this.dVI.aUU();
    }

    public void aUV() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0538a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0538a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.t(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0538a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0538a interfaceC0538a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0538a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0538a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0538a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0538a
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
                                interfaceC0538a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0538a.onFail(fVar.msg);
                            } else {
                                interfaceC0538a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dVL.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0538a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0538a
                public void onFail(String str2) {
                    interfaceC0538a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(boolean z) {
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
        e.a(j, this.dVM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mo(int i) {
        this.aXB = i;
        if (1 == i) {
            aUU();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(long j) {
        if (300000 < j) {
            this.dVK = j;
        } else {
            this.dVK = 300000L;
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
                    this.dVL.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aUV();
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
        if (this.dVJ != null) {
            try {
                this.dVJ.ar(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dVI.aUU();
        if (this.dVH != null) {
            this.dVH.quitSafely();
            this.dVH = null;
        }
        if (this.dVL != null) {
            this.dVL.destroy();
            this.dVL = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dVG != null) {
                dVG.destroy();
                dVG = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.hH(false);
                    aUW();
                    return;
                default:
                    return;
            }
        }

        void aUW() {
            if (1 != d.this.aXB) {
                sendEmptyMessageDelayed(1, d.this.dVK);
            }
        }

        void aUU() {
            removeCallbacksAndMessages(null);
        }

        boolean aUX() {
            return hasMessages(1);
        }
    }
}
