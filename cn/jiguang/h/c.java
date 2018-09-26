package cn.jiguang.h;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {
    private String a;
    private String b;
    private Map<String, Object> c;
    private int d;
    private boolean f;
    private boolean g;
    private int h;

    public c() {
        this.h = -1;
        this.c = new HashMap();
    }

    public c(String str) {
        this.h = -1;
        this.a = str;
        this.d = 0;
        this.f = false;
        this.g = false;
        this.c = new HashMap();
    }

    public void R(String str) {
        this.b = str;
    }

    public String cb() {
        return this.b;
    }

    public int getResponseCode() {
        return this.h;
    }

    public void m(String str, String str2) {
        if (this.c != null) {
            this.c.put(str, str2);
        }
    }

    public void q(int i) {
        this.h = i;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.b + "', responseCode=" + this.h + '}';
    }
}
