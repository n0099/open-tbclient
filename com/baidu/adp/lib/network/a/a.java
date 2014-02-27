package com.baidu.adp.lib.network.a;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.webSocket.q;
/* loaded from: classes.dex */
public class a extends Service {
    private static d c;
    private static boolean a = false;
    private static f b = new f();
    private static final Handler d = new b();
    private static q e = new c();

    public static void a(d dVar) {
        c = dVar;
    }

    private static boolean e() {
        if (!a) {
            com.baidu.adp.framework.e.c a2 = com.baidu.adp.framework.e.c.a();
            if (a2.c() == null) {
                com.baidu.adp.lib.util.e.b("WebSocket URL is NULL");
                throw new IllegalArgumentException("WebSocket URL is NULL");
            }
            com.baidu.adp.lib.webSocket.l.a().a(a2.c(), a2.d(), a2.e(), a2.f());
            com.baidu.adp.lib.webSocket.l.a().a(e);
            a = true;
        }
        com.baidu.adp.lib.util.e.e("启动连接");
        d.removeMessages(1);
        j.a().b();
        d.sendEmptyMessageDelayed(1, j.a().c());
        return com.baidu.adp.lib.webSocket.l.a().b();
    }

    public static void a(String str) {
        if (!a()) {
            com.baidu.adp.lib.util.e.e("关闭连接");
            d.removeMessages(1);
            com.baidu.adp.lib.webSocket.l.a().a(1);
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

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void a(boolean z, String str) {
        Intent intent = new Intent(com.baidu.adp.a.b.a().b(), a.class);
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
                com.baidu.adp.lib.util.e.e("进行重连" + stringExtra);
                a(stringExtra);
                e();
            } else if (!com.baidu.adp.lib.webSocket.l.a().d() && !com.baidu.adp.lib.webSocket.l.a().e()) {
                com.baidu.adp.lib.util.e.e("进行连接" + stringExtra);
                a(stringExtra);
                e();
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a("service onDestroy");
    }
}
