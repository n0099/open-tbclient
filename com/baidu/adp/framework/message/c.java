package com.baidu.adp.framework.message;

import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class c extends f<byte[]> {
    private int a;
    private HashMap<String, String> b;

    public c(int i) {
        super(i);
        this.a = -1;
        this.b = null;
    }

    public final boolean a() {
        return this.a == 200;
    }

    public final void a(int i, String str) {
        this.a = i;
        if (!a()) {
            a(-1);
            a(str);
        }
    }
}
