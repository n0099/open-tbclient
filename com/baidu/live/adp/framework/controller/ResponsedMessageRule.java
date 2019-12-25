package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.message.ResponsedMessage;
/* loaded from: classes2.dex */
public abstract class ResponsedMessageRule<T extends ResponsedMessage<?>> extends Rule<T> {
    public abstract T process(T t);

    public ResponsedMessageRule(int i) {
        super(i);
    }

    public T rule(T t) {
        if (t != null) {
            if (getCmd() == 0 || getCmd() == t.getCmd()) {
                return process(t);
            }
            return t;
        }
        return t;
    }
}
