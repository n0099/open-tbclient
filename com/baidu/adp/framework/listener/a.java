package com.baidu.adp.framework.listener;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener a;
    private b b;

    public HttpMessageListener a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }

    public int c() {
        if (this.a.getTag() != this.b.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.a.getTag();
    }

    public void a(int i) {
        this.a.setTag(i);
        this.b.setTag(i);
    }
}
