package com.baidu.adp.framework.client.socket.link;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.r;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class BdSocketLinkService extends Service {
    private static final int LINK_ERROR_CODE_CONNECT = -1001;
    private static final int LINK_ERROR_CODE_SERVICE = -1000;
    private static final String MODULE_NAME = "linkservice";
    private static final String REASON = "reason";
    private static final String RE_OPEN = "reopen";
    private static final int TIMEOUT_EVENT = 1;
    private static c connStateCallBack;
    private static int BASE_ERROR_NO = -100001000;
    public static final int CONNECT_OPEN = BASE_ERROR_NO - 1;
    public static final int BEGIN_OPEN = BASE_ERROR_NO - 2;
    public static final int START_SERVICE_ERROR = BASE_ERROR_NO - 3;
    public static final int ALLREADY = BASE_ERROR_NO - 4;
    public static final int STOP_RECONN = BASE_ERROR_NO - 5;
    private static d reConnStra = new d();
    private static boolean isAvailable = true;
    private static final Handler mHandler = new a(Looper.getMainLooper());
    private static r connCallback = new b();

    public static void setConnStateCallBack(c cVar) {
        connStateCallBack = cVar;
    }

    private boolean open(String str) {
        m.a(MODULE_NAME, 0, 0, TbConfig.ST_TYPE_OPEN, 0, str);
        BdLog.d("启动连接");
        mHandler.removeMessages(1);
        mHandler.sendEmptyMessageDelayed(1, com.baidu.adp.framework.c.c.a().d().b());
        try {
            return com.baidu.adp.lib.webSocket.m.a().b();
        } catch (Throwable th) {
            connCallback.a(-1001, "open error");
            BdLog.e(th.getMessage());
            return false;
        }
    }

    public static void init() {
        com.baidu.adp.lib.webSocket.m.a().a(l.b(), l.c(), null, l.d());
        com.baidu.adp.lib.webSocket.m.a().a(connCallback);
    }

    public static void close(String str) {
        close(1, str);
    }

    public static void close(int i, String str) {
        if (!isClose()) {
            m.a(MODULE_NAME, 0, 0, "close", i, str);
            mHandler.removeMessages(1);
            com.baidu.adp.lib.webSocket.m.a().a(i, str);
        }
    }

    public boolean isIdle() {
        return com.baidu.adp.lib.webSocket.m.a().c();
    }

    public static boolean sendMessage(com.baidu.adp.lib.webSocket.d dVar) {
        if (dVar != null && com.baidu.adp.lib.webSocket.m.a().d() && com.baidu.adp.lib.webSocket.m.a().c()) {
            return com.baidu.adp.lib.webSocket.m.a().a(dVar);
        }
        return false;
    }

    public static boolean isClose() {
        return (com.baidu.adp.lib.webSocket.m.a().d() || com.baidu.adp.lib.webSocket.m.a().e()) ? false : true;
    }

    public static boolean isOpen() {
        return com.baidu.adp.lib.webSocket.m.a().d();
    }

    public static boolean isAvailable() {
        return isAvailable;
    }

    public static void setAvailable(boolean z) {
        isAvailable = z;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void startService(boolean z, String str) {
        if (isAvailable()) {
            Intent intent = new Intent(BdBaseApplication.getInst().getApp(), BdSocketLinkService.class);
            intent.putExtra(RE_OPEN, z);
            intent.putExtra(REASON, str);
            try {
                if (BdBaseApplication.getInst().getApp().startService(intent) == null) {
                    connCallback.a(LINK_ERROR_CODE_SERVICE, "startService error");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                connCallback.a(LINK_ERROR_CODE_SERVICE, "startService error");
                m.a(MODULE_NAME, 0, 0, "startService_exception", START_SERVICE_ERROR, e.getMessage());
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        BdLog.i("----enter onStart");
        if (intent != null) {
            String stringExtra = intent.getStringExtra(REASON);
            if (stringExtra == null) {
                stringExtra = "--";
            }
            if (intent.getBooleanExtra(RE_OPEN, false)) {
                BdLog.d("进行重连" + stringExtra);
                close(stringExtra);
                open(stringExtra);
            } else if (!com.baidu.adp.lib.webSocket.m.a().d() && !com.baidu.adp.lib.webSocket.m.a().e()) {
                BdLog.d("进行连接" + stringExtra);
                close(stringExtra);
                open(stringExtra);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        close("service onDestroy");
    }

    public static void stopReConnStrategy(String str) {
        if (reConnStra != null) {
            reConnStra.b(str);
        }
    }
}
