package com.baidu.adp.framework.message;

import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public class a<T> extends d<T> {
    private T a;

    public a(int i) {
        super(i);
        this.a = null;
    }

    public a(int i, T t) {
        super(i);
        this.a = null;
        this.a = t;
    }

    public final void a(T t) {
        this.a = t;
    }

    public final T a() {
        return this.a;
    }

    @Override // com.baidu.adp.framework.message.d
    public final boolean a(int i) {
        return FrameHelper.d(i);
    }
}
