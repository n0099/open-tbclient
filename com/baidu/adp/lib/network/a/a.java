package com.baidu.adp.lib.network.a;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.adp.lib.webSocket.r;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a extends Service {
    private static d c;
    private static boolean a = false;
    private static f b = new f();
    private static final Handler d = new b();
    private static r e = new c();

    public static void a(d dVar) {
        c = dVar;
    }

    private boolean b(String str) {
        if (!a) {
            a(com.baidu.adp.framework.e.c.a());
        }
        com.baidu.adp.lib.util.f.e("启动连接");
        d.removeMessages(1);
        j.a().c();
        d.sendEmptyMessageDelayed(1, j.a().d());
        return m.a().b();
    }

    public static void a(com.baidu.adp.framework.e.c cVar) {
        if (cVar.c() == null) {
            com.baidu.adp.lib.util.f.b("WebSocket URL is NULL");
            throw new IllegalArgumentException("WebSocket URL is NULL");
        }
        a(cVar.c(), cVar.d(), cVar.e(), cVar.f());
        a = true;
    }

    public static void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        m.a().a(str, str2, strArr, list);
        m.a().a(e);
    }

    public static void a(String str) {
        a(1, str);
    }

    public static void a(int i, String str) {
        if (!a()) {
            com.baidu.adp.lib.util.f.e("关闭连接");
            d.removeMessages(1);
            m.a().a(i);
        }
    }

    public static boolean a(com.baidu.adp.lib.webSocket.d dVar) {
        if (dVar != null && m.a().d() && m.a().c()) {
            return m.a().a(dVar);
        }
        return false;
    }

    public static boolean a() {
        return (m.a().d() || m.a().e()) ? false : true;
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
                com.baidu.adp.lib.util.f.e("进行重连" + stringExtra);
                a(stringExtra);
                b(stringExtra);
            } else if (!m.a().d() && !m.a().e()) {
                com.baidu.adp.lib.util.f.e("进行连接" + stringExtra);
                a(stringExtra);
                b(stringExtra);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a("service onDestroy");
    }
}
