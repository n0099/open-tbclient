package com.baidu.adp.framework.listener;

import com.baidu.adp.framework.c;
import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class MessageListener<T extends ResponsedMessage<?>> extends c {
    private int mCmd;
    private int mTag = 0;

    public abstract void onMessage(T t);

    public MessageListener(int i) {
        this.mCmd = 0;
        this.mCmd = i;
    }

    public int getCmd() {
        return this.mCmd;
    }

    public int getTag() {
        return this.mTag;
    }

    public void setTag(int i) {
        this.mTag = i;
    }
}
