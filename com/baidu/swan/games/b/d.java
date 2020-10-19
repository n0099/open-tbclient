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
    private static volatile d dCb;
    private HandlerThread dCc;
    private a dCd;
    private b dCe;
    private c dCg;
    private long mStartTime;
    private int aTR = 0;
    private long dCf = 300000;
    private e.a dCh = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.lz(gVar.dCm)) {
                d.this.cg(gVar.interval * 1000);
                d.this.am(gVar.state, gVar.dCl);
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

    public static d aOb() {
        if (dCb == null) {
            synchronized (d.class) {
                if (dCb == null) {
                    dCb = new d();
                }
            }
        }
        return dCb;
    }

    public void a(b bVar) {
        this.dCe = bVar;
    }

    private void create() {
        aOc();
        gT(true);
        startMonitor();
        this.dCg = new c();
    }

    private void aOc() {
        if (this.dCc == null) {
            this.dCc = new HandlerThread("anti_addiction_monitor");
            this.dCc.start();
            this.dCd = new a(this.dCc.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aTR == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null || aDb.aCU() == null) {
            return null;
        }
        return aDb.aCU();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dCd.aOg()) {
            this.mStartTime = System.currentTimeMillis();
            this.dCd.aOf();
        }
    }

    public synchronized void aOd() {
        if (isOpen()) {
            gT(false);
        }
        this.dCd.aOd();
    }

    public void aOe() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0502a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0502a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0502a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0502a interfaceC0502a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0502a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0502a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0502a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0502a
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
                                interfaceC0502a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0502a.onFail(fVar.msg);
                            } else {
                                interfaceC0502a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dCg.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0502a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0502a
                public void onFail(String str2) {
                    interfaceC0502a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT(boolean z) {
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
        e.a(j, this.dCh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lz(int i) {
        this.aTR = i;
        if (1 == i) {
            aOd();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(long j) {
        if (300000 < j) {
            this.dCf = j;
        } else {
            this.dCf = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(int i, String str) {
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
                    this.dCg.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aOe();
                        }
                    });
                    return;
                }
                return;
            default:
                an(i, str);
                return;
        }
    }

    private void an(int i, String str) {
        if (this.dCe != null) {
            try {
                this.dCe.al(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dCd.aOd();
        if (this.dCc != null) {
            this.dCc.quitSafely();
            this.dCc = null;
        }
        if (this.dCg != null) {
            this.dCg.destroy();
            this.dCg = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dCb != null) {
                dCb.destroy();
                dCb = null;
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
                    d.this.gT(false);
                    aOf();
                    return;
                default:
                    return;
            }
        }

        void aOf() {
            if (1 != d.this.aTR) {
                sendEmptyMessageDelayed(1, d.this.dCf);
            }
        }

        void aOd() {
            removeCallbacksAndMessages(null);
        }

        boolean aOg() {
            return hasMessages(1);
        }
    }
}
