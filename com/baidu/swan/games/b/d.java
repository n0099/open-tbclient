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
    private static volatile d eeD;
    private HandlerThread eeE;
    private a eeF;
    private b eeG;
    private c eeI;
    private long mStartTime;
    private int aZg = 0;
    private long eeH = 300000;
    private e.a eeJ = new e.a() { // from class: com.baidu.swan.games.b.d.4
        @Override // com.baidu.swan.games.b.e.a
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.mStartTime = System.currentTimeMillis();
            if (d.this.mw(gVar.eeO)) {
                d.this.de(gVar.interval * 1000);
                d.this.au(gVar.state, gVar.eeN);
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

    public static d aXm() {
        if (eeD == null) {
            synchronized (d.class) {
                if (eeD == null) {
                    eeD = new d();
                }
            }
        }
        return eeD;
    }

    public void a(b bVar) {
        this.eeG = bVar;
    }

    private void create() {
        aXn();
        hZ(true);
        startMonitor();
        this.eeI = new c();
    }

    private void aXn() {
        if (this.eeE == null) {
            this.eeE = new HandlerThread("anti_addiction_monitor");
            this.eeE.start();
            this.eeF = new a(this.eeE.getLooper());
        }
    }

    private boolean isOpen() {
        return this.aZg == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null || aMl.aMe() == null) {
            return null;
        }
        return aMl.aMe();
    }

    public synchronized void startMonitor() {
        if (isOpen() && !this.eeF.aXr()) {
            this.mStartTime = System.currentTimeMillis();
            this.eeF.aXq();
        }
    }

    public synchronized void aXo() {
        if (isOpen()) {
            hZ(false);
        }
        this.eeF.aXo();
    }

    public void aXp() {
        com.baidu.swan.games.b.a.b(new a.InterfaceC0531a() { // from class: com.baidu.swan.games.b.d.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0531a
            public void onSuccess() {
                Activity activity = d.this.getActivity();
                if (activity != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(activity, a.h.swan_game_anti_addiction_success).aLS();
                }
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0531a
            public void onFail(String str) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
                }
            }
        });
    }

    public void a(final String str, final a.InterfaceC0531a interfaceC0531a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0531a.onFail("orderInfo is null");
        } else if (!isOpen()) {
            interfaceC0531a.onSuccess();
        } else {
            com.baidu.swan.games.b.a.a(new a.InterfaceC0531a() { // from class: com.baidu.swan.games.b.d.2
                @Override // com.baidu.swan.games.b.a.InterfaceC0531a
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
                                interfaceC0531a.onSuccess();
                            } else if (1 == fVar.state) {
                                interfaceC0531a.onFail(fVar.msg);
                            } else {
                                interfaceC0531a.onFail(fVar.msg);
                                if (!TextUtils.isEmpty(fVar.msg) && (activity = d.this.getActivity()) != null) {
                                    d.this.eeI.a(activity, fVar.msg, activity.getString(a.h.swan_game_anti_addiction_dialog_ok), true, null);
                                }
                            }
                        }

                        @Override // com.baidu.swan.games.b.e.a
                        public void onFail(String str2) {
                            interfaceC0531a.onFail(str2);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0531a
                public void onFail(String str2) {
                    interfaceC0531a.onFail(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ(boolean z) {
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
        e.a(j, this.eeJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mw(int i) {
        this.aZg = i;
        if (1 == i) {
            aXo();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(long j) {
        if (300000 < j) {
            this.eeH = j;
        } else {
            this.eeH = 300000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(int i, String str) {
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
                    this.eeI.a(activity, activity.getString(a.h.swan_game_anti_addiction_dialog_message), activity.getString(a.h.swan_game_anti_addiction_dialog_auth), true, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.games.b.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.aXp();
                        }
                    });
                    return;
                }
                return;
            default:
                av(i, str);
                return;
        }
    }

    private void av(int i, String str) {
        if (this.eeG != null) {
            try {
                this.eeG.at(i, str);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void destroy() {
        this.eeF.aXo();
        if (this.eeE != null) {
            this.eeE.quitSafely();
            this.eeE = null;
        }
        if (this.eeI != null) {
            this.eeI.destroy();
            this.eeI = null;
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (eeD != null) {
                eeD.destroy();
                eeD = null;
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
                    d.this.hZ(false);
                    aXq();
                    return;
                default:
                    return;
            }
        }

        void aXq() {
            if (1 != d.this.aZg) {
                sendEmptyMessageDelayed(1, d.this.eeH);
            }
        }

        void aXo() {
            removeCallbacksAndMessages(null);
        }

        boolean aXr() {
            return hasMessages(1);
        }
    }
}
