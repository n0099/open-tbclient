package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
/* loaded from: classes.dex */
public class CustomMessage<T> extends Message<T> {
    public T mData;

    public CustomMessage(int i2) {
        super(i2);
        this.mData = null;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i2) {
        return FrameHelper.a(i2);
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

    public CustomMessage(int i2, T t) {
        super(i2);
        this.mData = null;
        this.mData = t;
    }

    public CustomMessage(int i2, BdUniqueId bdUniqueId) {
        super(i2, bdUniqueId);
        this.mData = null;
    }
}
