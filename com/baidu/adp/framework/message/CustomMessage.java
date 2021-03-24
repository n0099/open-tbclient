package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public class CustomMessage<T> extends Message<T> {
    public T mData;

    public CustomMessage(int i) {
        super(i);
        this.mData = null;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.a(i);
    }

    @Override // com.baidu.adp.framework.message.Message
    public T encodeInBackGround() {
        return this.mData;
    }

    public T getData() {
        return this.mData;
    }

    public void setData(T t) {
        this.mData = t;
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
}
