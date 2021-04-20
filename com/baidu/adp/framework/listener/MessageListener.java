package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import d.b.c.c.d;
/* loaded from: classes.dex */
public abstract class MessageListener<T extends ResponsedMessage<?>> extends d {
    public int mCmd;
    public boolean mSelfListener;
    public BdUniqueId mTag;

    public MessageListener(int i) {
        this.mCmd = 0;
        this.mTag = null;
        this.mSelfListener = false;
        this.mCmd = i;
    }

    public int getCmd() {
        return this.mCmd;
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public boolean isSelfListener() {
        return this.mSelfListener;
    }

    public abstract void onMessage(T t);

    public void setSelfListener(boolean z) {
        this.mSelfListener = z;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public MessageListener(int i, boolean z) {
        this.mCmd = 0;
        this.mTag = null;
        this.mSelfListener = false;
        this.mCmd = i;
        this.mSelfListener = z;
    }
}
