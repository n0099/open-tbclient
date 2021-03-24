package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.b.c.e.c.i;
import d.b.b.e.m.f;
import d.b.b.e.p.l;
import d.b.b.e.r.h;
import d.b.b.e.r.j;
import d.b.b.e.r.k;
import java.util.Map;
/* loaded from: classes.dex */
public class BdSocketLinkService extends BdBaseService {
    public static int BASE_ERROR_NO = -100001000;
    public static final int LINK_ERROR_CODE_CONNECT = -1001;
    public static final int LINK_ERROR_CODE_SERVICE = -1000;
    public static final String MODULE_NAME = "linkservice";
    public static final String REASON = "reason";
    public static final String RE_OPEN = "reopen";
    public static final int TIMEOUT_EVENT = 1;
    public static d.b.b.c.e.c.k.a connStateCallBack;
    public static d.b.b.c.e.c.k.b mCanOpenWebSocket;
    public ScreenOnBroadcastReciver mScreenOnBroadcastReciver;
    public static final int CONNECT_OPEN = (-100001000) - 1;
    public static final int BEGIN_OPEN = (-100001000) - 2;
    public static final int START_SERVICE_ERROR = (-100001000) - 3;
    public static final int ALLREADY = (-100001000) - 4;
    public static final int STOP_RECONN = (-100001000) - 5;
    public static d.b.b.c.e.c.k.d reConnStra = new d.b.b.c.e.c.k.d();
    public static boolean isAvailable = true;
    public static boolean hasAbsoluteClose = false;
    public static final Handler mHandler = new a(Looper.getMainLooper());
    public static j connCallback = new b();
    public d myBinder = new d();
    public ServiceConnection conn = new c();

    /* loaded from: classes.dex */
    public class ScreenOnBroadcastReciver extends BroadcastReceiver {
        public ScreenOnBroadcastReciver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.b.b.c.e.c.b r;
            if (intent == null || !"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (r = MessageManager.getInstance().getSocketClient().r()) == null) {
                return;
            }
            r.a("Screen on");
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            BdLog.w("tcp建立和握手超时");
            BdSocketLinkService.close(9, "connect timeout");
            BdSocketLinkService.reConnStra.e("tcp or websocket handshake timeout");
        }
    }

    /* loaded from: classes.dex */
    public static class b extends j {
        @Override // d.b.b.e.r.j, d.b.b.e.r.g
        public void a(int i, String str) {
            i.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onClose", i, str);
            if (i == 6 || i == 5 || i == 2 || i == 3 || i == 4) {
                i.d();
            }
            BdSocketLinkService.mHandler.removeMessages(1);
            if ((BdSocketLinkService.connStateCallBack != null ? BdSocketLinkService.connStateCallBack.a(i, null) : false) || i == 1 || !l.C()) {
                return;
            }
            d.b.b.c.e.c.k.d dVar = BdSocketLinkService.reConnStra;
            dVar.e("onClose:" + i + ":" + str);
        }

        @Override // d.b.b.e.r.g
        public void b(d.b.b.e.r.c cVar) {
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.b(cVar);
            }
        }

        @Override // d.b.b.e.r.g
        public void c(String str) {
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.c(str);
            }
        }

        @Override // d.b.b.e.r.g
        public void h(k kVar) {
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.d(kVar);
            }
        }

        @Override // d.b.b.e.r.g
        public void onOpen(Map<String, String> map) {
            i.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onOpen", 0, "LinkService:onOpen");
            i.d();
            BdSocketLinkService.mHandler.removeMessages(1);
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.g(map);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BdSocketDaemonService.startService();
        }
    }

    /* loaded from: classes.dex */
    public class d extends Binder {
        public d() {
        }
    }

    public static void close(String str) {
        close(1, str);
    }

    public static boolean hasAbsoluteClose() {
        return hasAbsoluteClose;
    }

    public static void init() {
        h.j().r(d.b.b.c.e.c.h.d(), d.b.b.c.e.c.h.a(), null, d.b.b.c.e.c.h.b());
        h.j().c(connCallback);
    }

    public static boolean isAvailable() {
        return isAvailable;
    }

    public static boolean isClose() {
        return (h.j().l() || h.j().s()) ? false : true;
    }

    public static boolean isOpen() {
        return h.j().l();
    }

    private boolean open(String str) {
        i.a(MODULE_NAME, 0, 0, "open", 0, str);
        BdLog.w("启动连接");
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessageDelayed(1, d.b.b.c.j.c.c().b().b());
        try {
            return h.j().u();
        } catch (Throwable th) {
            connCallback.a(-1001, "open error");
            BdLog.e(th.getMessage());
            return false;
        }
    }

    private void registerScreenOnBroadcastReciver() {
        try {
            this.mScreenOnBroadcastReciver = new ScreenOnBroadcastReciver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            registerReceiver(this.mScreenOnBroadcastReciver, intentFilter);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public static boolean sendMessage(d.b.b.e.r.c cVar) {
        if (cVar != null && h.j().l() && h.j().k()) {
            return h.j().v(cVar);
        }
        return false;
    }

    public static void setAvailable(boolean z) {
        isAvailable = z;
    }

    public static void setCanOpenWebSocket(d.b.b.c.e.c.k.b bVar) {
        mCanOpenWebSocket = bVar;
    }

    public static void setConnStateCallBack(d.b.b.c.e.c.k.a aVar) {
        connStateCallBack = aVar;
    }

    public static void setHasAbsoluteClose(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("manual close socketLink");
        sb.append(z ? IntentConfig.CLOSE : "open");
        BdLog.d(sb.toString());
        hasAbsoluteClose = z;
    }

    public static void startService(boolean z, String str) {
        if (!hasAbsoluteClose() && isAvailable()) {
            try {
                Intent intent = new Intent(BdBaseApplication.getInst().getApp(), BdSocketLinkService.class);
                intent.putExtra(RE_OPEN, z);
                intent.putExtra("reason", str);
                if (BdBaseApplication.getInst().getApp().startService(intent) == null) {
                    connCallback.a(-1000, "startService error");
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                connCallback.a(-1000, "startService error");
                i.a(MODULE_NAME, 0, 0, "startService_exception", START_SERVICE_ERROR, e2.getMessage());
            }
        }
    }

    public static void stopReConnStrategy(String str) {
        d.b.b.c.e.c.k.d dVar = reConnStra;
        if (dVar != null) {
            dVar.f(str);
        }
    }

    private void unRegisterScreenOnBroadcastReciver() {
        try {
            if (this.mScreenOnBroadcastReciver != null) {
                unregisterReceiver(this.mScreenOnBroadcastReciver);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void bindServiceInternal() {
        f.a(this, new Intent(this, BdSocketDaemonService.class), this.conn, 1);
    }

    public boolean isIdle() {
        return h.j().k();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.myBinder;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            try {
                startForeground(2147483646, new Notification());
            } catch (Exception unused) {
                d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", BdSocketLinkService.class.getName() + "-onCreate-startForeground");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
        }
        registerScreenOnBroadcastReciver();
        bindServiceInternal();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        close("service onDestroy");
        unRegisterScreenOnBroadcastReciver();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        d.b.b.c.e.c.k.b bVar = mCanOpenWebSocket;
        if (bVar != null && !bVar.a()) {
            close("exit app");
        } else if (intent != null) {
            String stringExtra = intent.getStringExtra("reason");
            if (stringExtra == null) {
                stringExtra = "--";
            }
            if (intent.getBooleanExtra(RE_OPEN, false)) {
                BdLog.w("进行重连" + stringExtra);
                close(stringExtra);
                open(stringExtra);
            } else if (h.j().l() || h.j().s()) {
            } else {
                BdLog.w("进行连接" + stringExtra);
                close(stringExtra);
                open(stringExtra);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public static void close(int i, String str) {
        if (isClose()) {
            return;
        }
        i.a(MODULE_NAME, 0, 0, IntentConfig.CLOSE, i, str);
        i.d();
        mHandler.removeMessages(1);
        h.j().f(i, str);
    }
}
