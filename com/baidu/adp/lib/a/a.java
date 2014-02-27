package com.baidu.adp.lib.a;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public final class a {
    private int a = 0;
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

    public final void a(int i, String[] strArr, int i2) {
        this.a = i;
        this.b = strArr;
        this.c = i2;
    }

    public final String a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public final String[] c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.f;
    }

    public final void a(int i) {
        if (this.e != null) {
            this.e.callback(this.d, i);
        }
    }
}
