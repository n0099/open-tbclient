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
    private static volatile d dKy;
    private a dKA;
    private b dKB;
    private c dKD;
    private HandlerThread dKz;
    private long mStartTime;
    private int aUN = 0;
    private long dKC = 300000;
    private e.a dKE = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.lK(gVar.dKJ)) {
                d.this.ci(gVar.interval * 1000);
                d.this.ao(gVar.state, gVar.dKI);
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

    public static d aPV() {
        if (dKy == null) {
            synchronized (d.class) {
                if (dKy == null) {
                    dKy = new d();
                }
            }
        }
        return dKy;
    }

    public void a(b bVar) {
        this.dKB = bVar;
    }

    private void create() {
        aPW();
        hg(true);
        startMonitor();
        this.dKD = new c();
    }

    private void aPW() {
        if (this.dKz == null) {
            this.dKz = new HandlerThread("anti_addiction_monitor");
            this.dKz.start();
            this.dKA = new a(this.dKz.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aUN == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null || aEV.aEO() == null) {
            return null;
        }
        return aEV.aEO();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dKA.aQa()) {
            this.mStartTime = System.currentTimeMillis();
            this.dKA.aPZ();
        }
    }

    public synchronized void aPX() {
        if (isOpen()) {
            hg(false);
        }
        this.dKA.aPX();
    }

    public void aPY() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0516a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0516a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0516a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0516a interfaceC0516a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0516a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0516a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0516a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0516a
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
                                interfaceC0516a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0516a.onFail(fVar.msg);
                            } else {
                                interfaceC0516a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dKD.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0516a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0516a
                public void onFail(String str2) {
                    interfaceC0516a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg(boolean z) {
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
        e.a(j, this.dKE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lK(int i) {
        this.aUN = i;
        if (1 == i) {
            aPX();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(long j) {
        if (300000 < j) {
            this.dKC = j;
        } else {
            this.dKC = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(int i, String str) {
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
                    this.dKD.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aPY();
                        }
                    });
                    return;
                }
                return;
            default:
                ap(i, str);
                return;
        }
    }

    private void ap(int i, String str) {
        if (this.dKB != null) {
            try {
                this.dKB.an(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dKA.aPX();
        if (this.dKz != null) {
            this.dKz.quitSafely();
            this.dKz = null;
        }
        if (this.dKD != null) {
            this.dKD.destroy();
            this.dKD = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dKy != null) {
                dKy.destroy();
                dKy = null;
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
                    d.this.hg(false);
                    aPZ();
                    return;
                default:
                    return;
            }
        }

        void aPZ() {
            if (1 != d.this.aUN) {
                sendEmptyMessageDelayed(1, d.this.dKC);
            }
        }

        void aPX() {
            removeCallbacksAndMessages(null);
        }

        boolean aQa() {
            return hasMessages(1);
        }
    }
}
