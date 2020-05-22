package com.baidu.adp.framework.b;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class g<T extends ResponsedMessage<?>> extends h<T> {
    public abstract T a(T t);

    public g(int i) {
        super(i);
    }

    public T b(T t) {
        if (t != null) {
            if (getCmd() == 0 || getCmd() == t.getCmd()) {
                return a(t);
            }
            return t;
        }
        return t;
    }
}
