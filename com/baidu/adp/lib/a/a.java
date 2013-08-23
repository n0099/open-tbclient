package com.baidu.adp.lib.a;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f349a = 0;
    private String[] b = null;
    private int c = 0;
    private String d;
    private b e;
    private int f;

    public a(String str, int i, b bVar) {
        this.d = null;
        this.e = null;
        this.f = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.d = str;
        this.e = bVar;
        this.f = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.f349a = i;
        this.b = strArr;
        this.c = i2;
    }

    public String a() {
        return this.d;
    }

    public int b() {
        return this.f349a;
    }

    public String[] c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.f;
    }

    public void a(int i) {
        if (this.e != null) {
            this.e.callback(this.d, i);
        }
    }
}
