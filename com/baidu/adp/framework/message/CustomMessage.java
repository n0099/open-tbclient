package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public class CustomMessage<T> extends Message<T> {
    private T mData;

    public CustomMessage(int i) {
        super(i);
        this.mData = null;
    }

    public CustomMessage(int i, T t) {
        super(i);
        this.mData = null;
        this.mData = t;
    }

    public CustomMessage(int i, BdUniqueId bdUniqueId) {
        super(i, bdUniqueId);
        this.mData = null;
    }

    public void setData(T t) {
        this.mData = t;
    }

    public T getData() {
        return this.mData;
    }

    public T encodeInBackGround() {
        return this.mData;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.G(i);
    }
}
