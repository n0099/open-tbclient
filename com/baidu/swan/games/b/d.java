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
    private static volatile d dOI;
    private HandlerThread dOJ;
    private a dOK;
    private b dOL;
    private c dON;
    private long mStartTime;
    private int aUu = 0;
    private long dOM = 300000;
    private e.a dOO = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.lQ(gVar.dOT)) {
                d.this.cE(gVar.interval * 1000);
                d.this.as(gVar.state, gVar.dOS);
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

    public static d aRN() {
        if (dOI == null) {
            synchronized (d.class) {
                if (dOI == null) {
                    dOI = new d();
                }
            }
        }
        return dOI;
    }

    public void a(b bVar) {
        this.dOL = bVar;
    }

    private void create() {
        aRO();
        hs(true);
        startMonitor();
        this.dON = new c();
    }

    private void aRO() {
        if (this.dOJ == null) {
            this.dOJ = new HandlerThread("anti_addiction_monitor");
            this.dOJ.start();
            this.dOK = new a(this.dOJ.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aUu == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN == null || aGN.aGG() == null) {
            return null;
        }
        return aGN.aGG();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.dOK.aRS()) {
            this.mStartTime = System.currentTimeMillis();
            this.dOK.aRR();
        }
    }

    public synchronized void aRP() {
        if (isOpen()) {
            hs(false);
        }
        this.dOK.aRP();
    }

    public void aRQ() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0526a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0526a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(activity, a.h.swan_game_anti_addiction_success).showToast();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0526a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0526a interfaceC0526a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0526a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0526a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0526a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0526a
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
                                interfaceC0526a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0526a.onFail(fVar.msg);
                            } else {
                                interfaceC0526a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.dON.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0526a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0526a
                public void onFail(String str2) {
                    interfaceC0526a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(boolean z) {
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
        e.a(j, this.dOO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lQ(int i) {
        this.aUu = i;
        if (1 == i) {
            aRP();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(long j) {
        if (300000 < j) {
            this.dOM = j;
        } else {
            this.dOM = 300000L;
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
                    this.dON.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aRQ();
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
        if (this.dOL != null) {
            try {
                this.dOL.ar(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.dOK.aRP();
        if (this.dOJ != null) {
            this.dOJ.quitSafely();
            this.dOJ = null;
        }
        if (this.dON != null) {
            this.dON.destroy();
            this.dON = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (dOI != null) {
                dOI.destroy();
                dOI = null;
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
                    d.this.hs(false);
                    aRR();
                    return;
                default:
                    return;
            }
        }

        void aRR() {
            if (1 != d.this.aUu) {
                sendEmptyMessageDelayed(1, d.this.dOM);
            }
        }

        void aRP() {
            removeCallbacksAndMessages(null);
        }

        boolean aRS() {
            return hasMessages(1);
        }
    }
}
