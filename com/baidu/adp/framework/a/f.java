package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class f<T extends Message<?>, M extends MessageTask> extends h<T> {
    public abstract T a(T t, M m);

    public f(int i) {
        super(i);
    }

    public T b(T t, M m) {
        if (t != null) {
            if (getCmd() == 0 || getCmd() == t.getCmd()) {
                return a(t, m);
            }
            return t;
        }
        return t;
    }
}
