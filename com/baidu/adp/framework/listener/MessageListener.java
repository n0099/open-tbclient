package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class MessageListener<T extends ResponsedMessage<?>> extends com.baidu.adp.framework.c {
    private int mCmd;
    private boolean mSelfListener;
    private BdUniqueId mTag;

    public abstract void onMessage(T t);

    public MessageListener(int i) {
        this.mCmd = 0;
        this.mTag = null;
        this.mSelfListener = false;
        this.mCmd = i;
    }

    public MessageListener(int i, boolean z) {
        this.mCmd = 0;
        this.mTag = null;
        this.mSelfListener = false;
        this.mCmd = i;
        this.mSelfListener = z;
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

    public boolean isSelfListener() {
        return this.mSelfListener;
    }

    public void setSelfListener(boolean z) {
        this.mSelfListener = z;
    }
}
