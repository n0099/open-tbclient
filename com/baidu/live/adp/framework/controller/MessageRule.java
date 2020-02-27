package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.task.MessageTask;
/* loaded from: classes3.dex */
public abstract class MessageRule<T extends Message<?>, M extends MessageTask> extends Rule<T> {
    public abstract T process(T t, M m);

    public MessageRule(int i) {
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
