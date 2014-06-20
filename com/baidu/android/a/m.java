package com.baidu.android.a;
/* loaded from: classes.dex */
public class m extends e {
    private String a;
    private String b;
    private String c;
    private String d;

    public m() {
        a(3);
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.a = str;
    }

    public String e() {
        return this.a;
    }

    public void e(String str) {
        this.b = str;
    }

    public String f() {
        return this.b;
    }

    public void f(String str) {
        this.c = str;
    }

    public int g() {
        try {
            return Integer.parseInt(this.c);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
