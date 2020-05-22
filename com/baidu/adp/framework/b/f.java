package com.baidu.adp.framework.b;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class f<T extends Message<?>, M extends MessageTask> extends h<T> {
    public abstract T process(T t, M m);

    public f(int i) {
        super(i);
    }

    public T rule(T t, M m) {
        if (t != null) {
            if (getCmd() == 0 || getCmd() == t.getCmd()) {
                return process(t, m);
            }
            return t;
        }
        return t;
    }
}
