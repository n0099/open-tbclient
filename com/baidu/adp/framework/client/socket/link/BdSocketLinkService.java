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
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.lib.g.f;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.webSocket.h;
import com.baidu.adp.lib.webSocket.j;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
/* loaded from: classes.dex */
public class BdSocketLinkService extends BdBaseService {
    private static final int LINK_ERROR_CODE_CONNECT = -1001;
    private static final int LINK_ERROR_CODE_SERVICE = -1000;
    private static final String MODULE_NAME = "linkservice";
    private static final String REASON = "reason";
    private static final String RE_OPEN = "reopen";
    private static final int TIMEOUT_EVENT = 1;
    private static com.baidu.adp.framework.client.socket.link.a connStateCallBack;
    public static b mCanOpenWebSocket;
    private static int BASE_ERROR_NO = -100001000;
    public static final int CONNECT_OPEN = BASE_ERROR_NO - 1;
    public static final int BEGIN_OPEN = BASE_ERROR_NO - 2;
    public static final int START_SERVICE_ERROR = BASE_ERROR_NO - 3;
    public static final int ALLREADY = BASE_ERROR_NO - 4;
    public static final int STOP_RECONN = BASE_ERROR_NO - 5;
    private static d reConnStra = new d();
    private static boolean isAvailable = true;
    private static boolean hasAbsoluteClose = false;
    private static final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.framework.client.socket.link.BdSocketLinkService.1
        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    BdLog.w("tcp建立和握手超时");
                    BdSocketLinkService.close(9, "connect timeout");
                    BdSocketLinkService.reConnStra.start("tcp or websocket handshake timeout");
                    return;
                default:
                    return;
            }
        }
    };
    private static j connCallback = new j() { // from class: com.baidu.adp.framework.client.socket.link.BdSocketLinkService.2
        @Override // com.baidu.adp.lib.webSocket.j, com.baidu.adp.lib.webSocket.g.a
        public void b(k.a aVar) {
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.a(aVar);
            }
        }

        @Override // com.baidu.adp.lib.webSocket.j, com.baidu.adp.lib.webSocket.g.a
        public void J(String str) {
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.J(str);
            }
        }

        @Override // com.baidu.adp.lib.webSocket.j, com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.a(cVar);
            }
        }

        @Override // com.baidu.adp.lib.webSocket.j, com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            i.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onOpen", 0, "LinkService:onOpen");
            i.kE();
            BdSocketLinkService.mHandler.removeMessages(1);
            if (BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.d(map);
            }
        }

        @Override // com.baidu.adp.lib.webSocket.j, com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            boolean z = false;
            i.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onClose", i, str);
            if (i == 6 || i == 5 || i == 2 || i == 3 || i == 4) {
                i.kE();
            }
            BdSocketLinkService.mHandler.removeMessages(1);
            if (BdSocketLinkService.connStateCallBack != null) {
                if (i != 0) {
                }
                z = BdSocketLinkService.connStateCallBack.d(i, null);
            }
            if (!z && i != 1 && l.oZ()) {
                BdSocketLinkService.reConnStra.start("onClose:" + i + ":" + str);
            }
        }
    };
    private a myBinder = new a();
    private ServiceConnection conn = new ServiceConnection() { // from class: com.baidu.adp.framework.client.socket.link.BdSocketLinkService.3
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BdSocketDaemonService.startService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }
    };

    public static void setCanOpenWebSocket(b bVar) {
        mCanOpenWebSocket = bVar;
    }

    public static void setConnStateCallBack(com.baidu.adp.framework.client.socket.link.a aVar) {
        connStateCallBack = aVar;
    }

    private boolean open(String str) {
        i.a(MODULE_NAME, 0, 0, TbConfig.ST_TYPE_OPEN, 0, str);
        BdLog.w("启动连接");
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessageDelayed(1, com.baidu.adp.framework.c.c.kY().kZ().la());
        try {
            return h.pu().pv();
        } catch (Throwable th) {
            connCallback.e(LINK_ERROR_CODE_CONNECT, "open error");
            BdLog.e(th.getMessage());
            return false;
        }
    }

    public static void init() {
        h.pu().a(com.baidu.adp.framework.client.socket.h.getUrl(), com.baidu.adp.framework.client.socket.h.kC(), null, com.baidu.adp.framework.client.socket.h.kD());
        h.pu().a(connCallback);
    }

    public static void close(String str) {
        close(1, str);
    }

    public static void close(int i, String str) {
        if (!isClose()) {
            i.a(MODULE_NAME, 0, 0, IntentConfig.CLOSE, i, str);
            i.kE();
            mHandler.removeMessages(1);
            h.pu().close(i, str);
        }
    }

    public boolean isIdle() {
        return h.pu().pw();
    }

    public static boolean sendMessage(com.baidu.adp.lib.webSocket.c cVar) {
        if (cVar != null && h.pu().px() && h.pu().pw()) {
            return h.pu().sendMessage(cVar);
        }
        return false;
    }

    public static boolean isClose() {
        return (h.pu().px() || h.pu().isConnecting()) ? false : true;
    }

    public static boolean isOpen() {
        return h.pu().px();
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
        if (!hasAbsoluteClose() && isAvailable()) {
            try {
                Intent intent = new Intent(BdBaseApplication.getInst().getApp(), BdSocketLinkService.class);
                intent.putExtra(RE_OPEN, z);
                intent.putExtra(REASON, str);
                if (BdBaseApplication.getInst().getApp().startService(intent) == null) {
                    connCallback.e(-1000, "startService error");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                connCallback.e(-1000, "startService error");
                i.a(MODULE_NAME, 0, 0, "startService_exception", START_SERVICE_ERROR, e.getMessage());
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (mCanOpenWebSocket != null && !mCanOpenWebSocket.kQ()) {
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
            } else if (!h.pu().px() && !h.pu().isConnecting()) {
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
            com.baidu.adp.framework.client.socket.b kA;
            if (intent != null && intent.getAction() == "android.intent.action.SCREEN_ON" && (kA = MessageManager.getInstance().getSocketClient().kA()) != null) {
                kA.I("Screen on");
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        close("service onDestroy");
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public static void stopReConnStrategy(String str) {
        if (reConnStra != null) {
            reConnStra.L(str);
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            try {
                startForeground(2147483646, new Notification());
            } catch (Exception e) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("loc", getClass().getName() + "-onCreate-startForeground");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
        }
        registerScreenOnBroadcastReciver();
        bindServiceInternal();
    }

    public void bindServiceInternal() {
        f.bindService(this, new Intent(this, BdSocketDaemonService.class), this.conn, 1);
    }

    public static boolean hasAbsoluteClose() {
        return hasAbsoluteClose;
    }

    public static void setHasAbsoluteClose(boolean z) {
        BdLog.d("manual close socketLink" + (z ? IntentConfig.CLOSE : TbConfig.ST_TYPE_OPEN));
        hasAbsoluteClose = z;
    }

    /* loaded from: classes.dex */
    class a extends Binder {
        a() {
        }
    }
}
