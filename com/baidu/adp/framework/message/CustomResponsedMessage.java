package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public class CustomResponsedMessage<T> extends ResponsedMessage<T> {
    public T mData;

    public CustomResponsedMessage(int i2) {
        super(i2);
        this.mData = null;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, T t) throws Exception {
        this.mData = t;
    }

    public T getData() {
        return this.mData;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return getError() != 0;
    }

    public CustomResponsedMessage(int i2, T t) {
        super(i2);
        this.mData = null;
        this.mData = t;
    }
}
