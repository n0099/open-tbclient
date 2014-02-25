package com.baidu.adp.framework.b;

import com.baidu.adp.framework.message.f;
/* loaded from: classes.dex */
public abstract class b<T extends f<?>> extends c<T> {
    public abstract T a(T t);

    public T b(T t) {
        if (t != null) {
            if (b() == 0 || b() == t.b()) {
                return a(t);
            }
            return t;
        }
        return t;
    }
}
