package com.baidu.adp.framework.e;

import com.baidu.adp.lib.network.websocket.BdSocketLinkService;
import com.baidu.adp.lib.network.websocket.k;
import com.baidu.adp.lib.network.websocket.l;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c extends e {
    private static c c = null;
    private String d = null;
    private String e = null;
    private String[] f = null;
    private List<BasicNameValuePair> g = null;
    private l h = null;
    private k i = null;
    private d j = null;
    private int[] k = com.baidu.adp.framework.b.a;

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private c() {
        this.a = new f(20000, 10000, 5000);
        this.b = 3;
    }

    public final void a(l lVar) {
        this.h = lVar;
    }

    public final l b() {
        return this.h;
    }

    public final void a(k kVar) {
        this.i = kVar;
    }

    public final k c() {
        return this.i;
    }

    public final String d() {
        return this.d;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final String e() {
        return this.e;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final String[] f() {
        return this.f;
    }

    public final List<BasicNameValuePair> g() {
        return this.g;
    }

    public final void a(List<BasicNameValuePair> list) {
        this.g = list;
    }

    public final void h() {
        BdSocketLinkService.a(this);
    }

    public static void a(boolean z, String str) {
        BdSocketLinkService.a(z, str);
    }

    public static void a(int i, String str) {
        BdSocketLinkService.a(8);
    }

    public static void c(String str) {
        BdSocketLinkService.b(str);
    }

    public static void a(boolean z) {
        com.baidu.adp.framework.c.a().a(z);
    }

    public final d i() {
        return this.j;
    }

    public final void a(d dVar) {
        this.j = dVar;
    }
}
