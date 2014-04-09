package com.baidu.adp.lib.network.websocket;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.webSocket.q;
/* loaded from: classes.dex */
public class BdSocketLinkService extends Service {
    private static c c;
    private static boolean a = false;
    private static e b = new e();
    private static final Handler d = new a();
    private static q e = new b();

    public static void a(c cVar) {
        c = cVar;
    }

    private static boolean f() {
        if (!a) {
            a(com.baidu.adp.framework.e.c.a());
        }
        com.baidu.adp.lib.util.f.e("启动连接");
        d.removeMessages(1);
        j.a().b();
        d.sendEmptyMessageDelayed(1, j.a().c());
        return com.baidu.adp.lib.webSocket.l.a().b();
    }

    public static void a(com.baidu.adp.framework.e.c cVar) {
        if (cVar.d() == null) {
            com.baidu.adp.lib.util.f.b("WebSocket URL is NULL");
            throw new IllegalArgumentException("WebSocket URL is NULL");
        }
        com.baidu.adp.lib.webSocket.l.a().a(cVar.d(), cVar.e(), cVar.f(), cVar.g());
        com.baidu.adp.lib.webSocket.l.a().a(e);
        a = true;
    }

    public static void a(String str) {
        if (com.baidu.adp.framework.e.c.a().i() != null) {
            com.baidu.adp.framework.e.c.a().i().a("TiebaSocketLinkService", "close():", 0, (com.baidu.adp.framework.message.d<?>) null);
        }
        a(1);
    }

    public static void a(int i) {
        if (!a()) {
            com.baidu.adp.lib.util.f.e("关闭连接");
            if (com.baidu.adp.framework.e.c.a().i() != null) {
                com.baidu.adp.framework.e.c.a().i().a("TiebaSocketLinkService", "close():", i, (com.baidu.adp.framework.message.d<?>) null);
            }
            d.removeMessages(1);
            com.baidu.adp.lib.webSocket.l.a().a(i);
        }
    }

    public static boolean a(com.baidu.adp.lib.webSocket.d dVar) {
        if (dVar != null && com.baidu.adp.lib.webSocket.l.a().d() && com.baidu.adp.lib.webSocket.l.a().c()) {
            return com.baidu.adp.lib.webSocket.l.a().a(dVar);
        }
        return false;
    }

    public static boolean a() {
        return (com.baidu.adp.lib.webSocket.l.a().d() || com.baidu.adp.lib.webSocket.l.a().e()) ? false : true;
    }

    public static boolean b() {
        return com.baidu.adp.lib.webSocket.l.a().d();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void a(boolean z, String str) {
        Intent intent = new Intent(com.baidu.adp.a.b.a().b(), BdSocketLinkService.class);
        intent.putExtra("reopen", z);
        intent.putExtra("reason", str);
        com.baidu.adp.lib.f.c.a(com.baidu.adp.a.b.a().b(), intent);
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
                com.baidu.adp.lib.util.f.e("进行重连" + stringExtra);
                a(stringExtra);
                f();
            } else if (!com.baidu.adp.lib.webSocket.l.a().d() && !com.baidu.adp.lib.webSocket.l.a().e()) {
                com.baidu.adp.lib.util.f.e("进行连接" + stringExtra);
                a(stringExtra);
                f();
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
            b.b();
        }
    }
}
