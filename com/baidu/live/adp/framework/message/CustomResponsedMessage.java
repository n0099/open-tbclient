package com.baidu.live.adp.framework.message;
/* loaded from: classes2.dex */
public class CustomResponsedMessage<T> extends ResponsedMessage<T> {
    private T mData;

    public CustomResponsedMessage(int i) {
        super(i);
        this.mData = null;
    }

    public CustomResponsedMessage(int i, T t) {
        super(i);
        this.mData = null;
        this.mData = t;
    }

    public T getData() {
        return this.mData;
    }

    @Override // com.baidu.live.adp.framework.message.IDecode
    public void decodeInBackGround(int i, T t) throws Exception {
        this.mData = t;
    }

    @Override // com.baidu.live.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return getError() != 0;
    }
}
