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
/* loaded from: classes3.dex */
public class d {
    private static volatile d dpX;
    private HandlerThread dpY;
    private a dpZ;
    private b dqa;
    private c dqc;
    private long mStartTime;
    private int aQG = 0;
    private long dqb = 300000;
    private e.a dqd = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.lc(gVar.dqi)) {
                d.this.bY(gVar.interval * 1000);
                d.this.ab(gVar.state, gVar.dqh);
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

    public static d aLs() {
        if (dpX == null) {
            synchronized (d.class) {
                if (dpX == null) {
                    dpX = new d();
                }
            }
        }
        return dpX;
    }

    public void a(b bVar) {
        this.dqa = bVar;
    }

    private void create() {
        aLt();
        gx(true);
        startMonitor();
        this.dqc = new c();
    }

    private void aLt() {
        if (this.dpY == null) {
            this.dpY = new HandlerThread("anti_addiction_monitor");
            this.dpY.start();
            this.dpZ = new a(this.dpY.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aQG == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null || aAs.aAl() == null) {
            return null;
        }
        return aAs.aAl();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dpZ.aLx()) {
            this.mStartTime = System.currentTimeMillis();
            this.dpZ.aLw();
        }
    }

    public synchronized void aLu() {
        if (isOpen()) {
            gx(false);
        }
        this.dpZ.aLu();
    }

    public void aLv() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0485a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0485a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0485a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0485a interfaceC0485a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0485a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0485a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0485a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0485a
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
                                interfaceC0485a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0485a.onFail(fVar.msg);
                            } else {
                                interfaceC0485a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dqc.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0485a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0485a
                public void onFail(String str2) {
                    interfaceC0485a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
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
        e.a(j, this.dqd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lc(int i) {
        this.aQG = i;
        if (1 == i) {
            aLu();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(long j) {
        if (300000 < j) {
            this.dqb = j;
        } else {
            this.dqb = 300000L;
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
                    this.dqc.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aLv();
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
        if (this.dqa != null) {
            try {
                this.dqa.aa(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dpZ.aLu();
        if (this.dpY != null) {
            this.dpY.quitSafely();
            this.dpY = null;
        }
        if (this.dqc != null) {
            this.dqc.destroy();
            this.dqc = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dpX != null) {
                dpX.destroy();
                dpX = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.gx(false);
                    aLw();
                    return;
                default:
                    return;
            }
        }

        void aLw() {
            if (1 != d.this.aQG) {
                sendEmptyMessageDelayed(1, d.this.dqb);
            }
        }

        void aLu() {
            removeCallbacksAndMessages(null);
        }

        boolean aLx() {
            return hasMessages(1);
        }
    }
}
