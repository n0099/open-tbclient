package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
public class BdSocketLinkService extends BdBaseService {
    private static final int LINK_ERROR_CODE_CONNECT = -1001;
    private static final int LINK_ERROR_CODE_SERVICE = -1000;
    private static final String MODULE_NAME = "linkservice";
    private static final String REASON = "reason";
    private static final String RE_OPEN = "reopen";
    private static final int TIMEOUT_EVENT = 1;
    private static g connStateCallBack;
    public static h mCanOpenWebSocket;
    private static int BASE_ERROR_NO = -100001000;
    public static final int CONNECT_OPEN = BASE_ERROR_NO - 1;
    public static final int BEGIN_OPEN = BASE_ERROR_NO - 2;
    public static final int START_SERVICE_ERROR = BASE_ERROR_NO - 3;
    public static final int ALLREADY = BASE_ERROR_NO - 4;
    public static final int STOP_RECONN = BASE_ERROR_NO - 5;
    private static i reConnStra = new i();
    private static boolean isAvailable = true;
    private static final Handler mHandler = new c(Looper.getMainLooper());
    private static r connCallback = new d();
    private f myBinder = new f(this);
    private ServiceConnection conn = new e(this);

    public static void setCanOpenWebSocket(h hVar) {
        mCanOpenWebSocket = hVar;
    }

    public static void setConnStateCallBack(g gVar) {
        connStateCallBack = gVar;
    }

    private boolean open(String str) {
        m.a(MODULE_NAME, 0, 0, TbConfig.ST_TYPE_OPEN, 0, str);
        BdLog.w("启动连接");
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessageDelayed(1, com.baidu.adp.framework.c.c.by().bz().bA());
        try {
            return com.baidu.adp.lib.webSocket.m.fV().fW();
        } catch (Throwable th) {
            connCallback.l(-1001, "open error");
            BdLog.e(th.getMessage());
            return false;
        }
    }

    public static void init() {
        com.baidu.adp.lib.webSocket.m.fV().a(l.getUrl(), l.bc(), null, l.bd());
        com.baidu.adp.lib.webSocket.m.fV().a(connCallback);
    }

    public static void close(String str) {
        close(1, str);
    }

    public static void close(int i, String str) {
        if (!isClose()) {
            m.a(MODULE_NAME, 0, 0, LoginActivityConfig.CLOSE, i, str);
            mHandler.removeMessages(1);
            com.baidu.adp.lib.webSocket.m.fV().close(i, str);
        }
    }

    public boolean isIdle() {
        return com.baidu.adp.lib.webSocket.m.fV().fX();
    }

    public static boolean sendMessage(com.baidu.adp.lib.webSocket.d dVar) {
        if (dVar != null && com.baidu.adp.lib.webSocket.m.fV().fY() && com.baidu.adp.lib.webSocket.m.fV().fX()) {
            return com.baidu.adp.lib.webSocket.m.fV().sendMessage(dVar);
        }
        return false;
    }

    public static boolean isClose() {
        return (com.baidu.adp.lib.webSocket.m.fV().fY() || com.baidu.adp.lib.webSocket.m.fV().fZ()) ? false : true;
    }

    public static boolean isOpen() {
        return com.baidu.adp.lib.webSocket.m.fV().fY();
    }

    public static boolean isAvailable() {
        return isAvailable;
    }

    public static void setAvailable(boolean z) {
        isAvailable = z;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.myBinder;
    }

    public static void startService(boolean z, String str) {
        if (isAvailable()) {
            try {
                Intent intent = new Intent(BdBaseApplication.getInst().getApp(), BdSocketLinkService.class);
                intent.putExtra(RE_OPEN, z);
                intent.putExtra(REASON, str);
                if (BdBaseApplication.getInst().getApp().startService(intent) == null) {
                    connCallback.l(LINK_ERROR_CODE_SERVICE, "startService error");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                connCallback.l(LINK_ERROR_CODE_SERVICE, "startService error");
                m.a(MODULE_NAME, 0, 0, "startService_exception", START_SERVICE_ERROR, e.getMessage());
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (mCanOpenWebSocket != null && !mCanOpenWebSocket.bn()) {
            close("exit app");
        } else if (intent != null) {
            String stringExtra = intent.getStringExtra(REASON);
            if (stringExtra == null) {
                stringExtra = "--";
            }
            if (intent.getBooleanExtra(RE_OPEN, false)) {
                BdLog.w("进行重连" + stringExtra);
                close(stringExtra);
                open(stringExtra);
            } else if (!com.baidu.adp.lib.webSocket.m.fV().fY() && !com.baidu.adp.lib.webSocket.m.fV().fZ()) {
                BdLog.w("进行连接" + stringExtra);
                close(stringExtra);
                open(stringExtra);
            }
        }
    }

    private void registerScreenOnBroadcastReciver() {
        try {
            ScreenOnBroadcastReciver screenOnBroadcastReciver = new ScreenOnBroadcastReciver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            registerReceiver(screenOnBroadcastReciver, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* loaded from: classes.dex */
    public class ScreenOnBroadcastReciver extends BroadcastReceiver {
        public ScreenOnBroadcastReciver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.baidu.adp.framework.client.socket.b aZ;
            if (intent != null && intent.getAction() == "android.intent.action.SCREEN_ON" && (aZ = MessageManager.getInstance().getSocketClient().aZ()) != null) {
                aZ.x("Screen on");
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        close("service onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }

    public static void stopReConnStrategy(String str) {
        if (reConnStra != null) {
            reConnStra.A(str);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(2147483646, new Notification());
        }
        registerScreenOnBroadcastReciver();
        bindServiceInternal();
    }

    public void bindServiceInternal() {
        com.baidu.adp.lib.g.j.a(this, new Intent(this, BdSocketDaemonService.class), this.conn, 1);
    }
}
