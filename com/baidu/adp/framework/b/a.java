package com.baidu.adp.framework.b;

import com.baidu.adp.framework.message.e;
import com.baidu.adp.framework.task.b;
/* loaded from: classes.dex */
public abstract class a<T extends e<?>, M extends com.baidu.adp.framework.task.b> extends c<T> {
    public abstract T a(T t, M m);

    public T b(T t, M m) {
        if (t != null) {
            if (b() == 0 || b() == t.d()) {
                return a(t, m);
            }
            return t;
        }
        return t;
    }
}
