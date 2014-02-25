package com.baidu.adp.framework.e;

import com.baidu.adp.lib.network.a.k;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c extends d {
    private static c c = null;
    private String d = null;
    private String e = null;
    private String[] f = null;
    private List<BasicNameValuePair> g = null;
    private k h = null;
    private int[] i = com.baidu.adp.framework.b.a;

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
        this.a = new e(20000, 10000, 5000);
        this.b = 3;
    }

    public k b() {
        return this.h;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String[] e() {
        return this.f;
    }

    public List<BasicNameValuePair> f() {
        return this.g;
    }
}
