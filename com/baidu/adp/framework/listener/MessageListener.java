package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class MessageListener<T extends ResponsedMessage<?>> extends com.baidu.adp.framework.c {
    private int mCmd;
    private BdUniqueId mTag = null;

    public abstract void onMessage(T t);

    public MessageListener(int i) {
        this.mCmd = 0;
        this.mCmd = i;
    }

    public int getCmd() {
        return this.mCmd;
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }
}
