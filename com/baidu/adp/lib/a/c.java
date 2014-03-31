package com.baidu.adp.lib.a;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public final class c {
    private int a = 0;
    private String[] b = null;
    private int c = 0;
    private String d;
    private d e;
    private int f;

    public c(String str, int i, d dVar) {
        this.d = null;
        this.e = null;
        this.f = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.d = str;
        this.e = dVar;
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
            d dVar = this.e;
            String str = this.d;
            dVar.a(i);
        }
    }
}
