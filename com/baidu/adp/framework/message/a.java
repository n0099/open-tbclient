package com.baidu.adp.framework.message;

import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public class a<T> extends e<T> {
    private T a;

    public a(int i, T t) {
        super(i);
        this.a = null;
        this.a = t;
    }

    public T a() {
        return this.a;
    }

    @Override // com.baidu.adp.framework.message.e
    public boolean a(int i) {
        return FrameHelper.d(i);
    }
}
