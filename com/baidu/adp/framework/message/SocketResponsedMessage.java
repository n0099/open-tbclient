package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class SocketResponsedMessage extends ResponsedMessage<byte[]> {
    public int mRetry;
    public long sequenceID;

    public SocketResponsedMessage(int i) {
        super(i);
        this.mRetry = 0;
    }

    public void decodeExtraDataInBackGround(int i, byte[] bArr) throws Exception {
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public abstract /* synthetic */ void decodeInBackGround(int i, T t) throws Exception;

    public int getRetry() {
        return this.mRetry;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return getError() != 0;
    }

    public void setRetry(int i) {
        this.mRetry = i;
    }
}
