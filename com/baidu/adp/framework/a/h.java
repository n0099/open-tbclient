package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class h<T extends Message<?>, M extends MessageTask> extends j<T> {
    public abstract T a(T t, M m);

    public h(int i) {
        super(i);
    }

    public T b(T t, M m) {
        if (t != null) {
            if (a() == 0 || a() == t.getCmd()) {
                return a(t, m);
            }
            return t;
        }
        return t;
    }
}
