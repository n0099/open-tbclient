package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.Message;
/* loaded from: classes.dex */
public abstract class g<T extends Message<?>> extends j<T> {
    public abstract T a(T t);

    public g(int i) {
        super(i);
    }

    public T b(T t) {
        if (t != null) {
            if (a() == 0 || a() == t.getCmd()) {
                return a(t);
            }
            return t;
        }
        return t;
    }
}
