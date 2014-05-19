package com.baidu.adp.lib.network.websocket;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.r;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class BdSocketLinkService extends Service {
    private static c c;
    private static boolean a = false;
    private static e b = new e();
    private static final Handler d = new a();
    private static r e = new b();

    public static void a(c cVar) {
        c = cVar;
    }

    private boolean c(String str) {
        if (!a) {
            a(com.baidu.adp.framework.c.c.a());
        }
        BdLog.d("启动连接");
        d.removeMessages(1);
        j.a().c();
        d.sendEmptyMessageDelayed(1, j.a().d());
        try {
            return com.baidu.adp.lib.webSocket.m.a().b();
        } catch (Throwable th) {
            th.printStackTrace();
            BdLog.e(th.getMessage());
            return false;
        }
    }

    public static void a(com.baidu.adp.framework.c.c cVar) {
        if (cVar.d() == null) {
            BdLog.e("WebSocket URL is NULL");
            throw new IllegalArgumentException("WebSocket URL is NULL");
        }
        a(cVar.d(), cVar.e(), cVar.f(), cVar.g());
        a = true;
    }

    public static void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        com.baidu.adp.lib.webSocket.m.a().a(str, str2, strArr, list);
        com.baidu.adp.lib.webSocket.m.a().a(e);
    }

    public static void a(String str) {
        if (com.baidu.adp.framework.c.c.a().i() != null) {
            com.baidu.adp.framework.c.c.a().i().a("TiebaSocketLinkService", "close():", 0, (Message<?>) null);
        }
        a(1, str);
    }

    public static void a(int i, String str) {
        if (!a()) {
            BdLog.d("关闭连接");
            if (com.baidu.adp.framework.c.c.a().i() != null) {
                com.baidu.adp.framework.c.c.a().i().a("TiebaSocketLinkService", "close():", i, (Message<?>) null);
            }
            d.removeMessages(1);
            com.baidu.adp.lib.webSocket.m.a().a(i, str);
        }
    }

    public static boolean a(com.baidu.adp.lib.webSocket.d dVar) {
        if (dVar != null && com.baidu.adp.lib.webSocket.m.a().d() && com.baidu.adp.lib.webSocket.m.a().c()) {
            return com.baidu.adp.lib.webSocket.m.a().a(dVar);
        }
        return false;
    }

    public static boolean a() {
        return (com.baidu.adp.lib.webSocket.m.a().d() || com.baidu.adp.lib.webSocket.m.a().e()) ? false : true;
    }

    public static boolean b() {
        return com.baidu.adp.lib.webSocket.m.a().d();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void a(boolean z, String str) {
        Intent intent = new Intent(com.baidu.adp.base.a.getInst().getApp(), BdSocketLinkService.class);
        intent.putExtra("reopen", z);
        intent.putExtra("reason", str);
        com.baidu.adp.lib.f.c.a(com.baidu.adp.base.a.getInst().getApp(), intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("reason");
            if (stringExtra == null) {
                stringExtra = "--";
            }
            if (intent.getBooleanExtra("reopen", false)) {
                BdLog.d("进行重连" + stringExtra);
                a(stringExtra);
                c(stringExtra);
            } else if (!com.baidu.adp.lib.webSocket.m.a().d() && !com.baidu.adp.lib.webSocket.m.a().e()) {
                BdLog.d("进行连接" + stringExtra);
                a(stringExtra);
                c(stringExtra);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a("service onDestroy");
    }

    public static void b(String str) {
        if (b != null) {
            b.b(str);
        }
    }
}
