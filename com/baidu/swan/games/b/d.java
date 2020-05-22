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
    private static volatile d cTp;
    private HandlerThread cTq;
    private a cTr;
    private b cTs;
    private c cTu;
    private long mStartTime;
    private int aFD = 0;
    private long cTt = 300000;
    private e.a cTv = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.ie(gVar.cTA)) {
                d.this.bD(gVar.interval * 1000);
                d.this.Z(gVar.state, gVar.cTz);
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

    public static d axh() {
        if (cTp == null) {
            synchronized (d.class) {
                if (cTp == null) {
                    cTp = new d();
                }
            }
        }
        return cTp;
    }

    public void a(b bVar) {
        this.cTs = bVar;
    }

    private void create() {
        axi();
        fG(true);
        startMonitor();
        this.cTu = new c();
    }

    private void axi() {
        if (this.cTq == null) {
            this.cTq = new HandlerThread("anti_addiction_monitor");
            this.cTq.start();
            this.cTr = new a(this.cTq.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aFD == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null || aoG.aoz() == null) {
            return null;
        }
        return aoG.aoz();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.cTr.axm()) {
            this.mStartTime = System.currentTimeMillis();
            this.cTr.axl();
        }
    }

    public synchronized void axj() {
        if (isOpen()) {
            fG(false);
        }
        this.cTr.axj();
    }

    public void axk() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0423a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0423a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0423a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0423a interfaceC0423a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0423a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0423a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0423a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0423a
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
                                interfaceC0423a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0423a.onFail(fVar.msg);
                            } else {
                                interfaceC0423a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.cTu.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0423a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0423a
                public void onFail(String str2) {
                    interfaceC0423a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(boolean z) {
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
        e.a(j, this.cTv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ie(int i) {
        this.aFD = i;
        if (1 == i) {
            axj();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(long j) {
        if (300000 < j) {
            this.cTt = j;
        } else {
            this.cTt = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
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
                    this.cTu.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.axk();
                        }
                    });
                    return;
                }
                return;
            default:
                aa(i, str);
                return;
        }
    }

    private void aa(int i, String str) {
        if (this.cTs != null) {
            try {
                this.cTs.Y(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.cTr.axj();
        if (this.cTq != null) {
            this.cTq.quitSafely();
            this.cTq = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (cTp != null) {
                cTp.destroy();
                cTp = null;
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
                    d.this.fG(false);
                    axl();
                    return;
                default:
                    return;
            }
        }

        void axl() {
            if (1 != d.this.aFD) {
                sendEmptyMessageDelayed(1, d.this.cTt);
            }
        }

        void axj() {
            removeCallbacksAndMessages(null);
        }

        boolean axm() {
            return hasMessages(1);
        }
    }
}
