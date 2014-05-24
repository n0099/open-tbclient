package com.baidu.adp.lib.network.websocket;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.r;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class BdSocketLinkService extends Service {
    private static final String REASON = "reason";
    private static final String RE_OPEN = "reopen";
    private static final int TIMEOUT_EVENT = 1;
    private static c connStateCallBack;
    private static boolean isInit = false;
    private static e reConnStra = new e();
    private static final Handler mHandler = new a();
    private static r connCallback = new b();

    public static void setConnStateCallBack(c cVar) {
        connStateCallBack = cVar;
    }

    private boolean open(String str) {
        if (!isInit) {
            init(com.baidu.adp.framework.c.c.a());
        }
        BdLog.d("启动连接");
        mHandler.removeMessages(1);
        j.a().c();
        mHandler.sendEmptyMessageDelayed(1, j.a().d());
        try {
            return com.baidu.adp.lib.webSocket.m.a().b();
        } catch (Throwable th) {
            th.printStackTrace();
            BdLog.e(th.getMessage());
            return false;
        }
    }

    public static void init(com.baidu.adp.framework.c.c cVar) {
        if (cVar.d() == null) {
            BdLog.e("WebSocket URL is NULL");
            throw new IllegalArgumentException("WebSocket URL is NULL");
        }
        init(cVar.d(), cVar.e(), cVar.f(), cVar.g());
        isInit = true;
    }

    public static void init(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        com.baidu.adp.lib.webSocket.m.a().a(str, str2, strArr, list);
        com.baidu.adp.lib.webSocket.m.a().a(connCallback);
    }

    public static void close(String str) {
        close(1, str);
    }

    public static void close(int i, String str) {
        if (!isClose()) {
            BdLog.d("关闭连接");
            if (i != 0 && i != 1 && com.baidu.adp.framework.c.c.a().i() != null) {
                com.baidu.adp.framework.c.c.a().i().a("TiebaSocketLinkService", "close():", i, (Message<?>) null);
            }
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

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void startService(boolean z, String str) {
        Intent intent = new Intent(BdBaseApplication.getInst().getApp(), BdSocketLinkService.class);
        intent.putExtra(RE_OPEN, z);
        intent.putExtra(REASON, str);
        com.baidu.adp.lib.f.c.a(BdBaseApplication.getInst().getApp(), intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
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
