package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class SocketResponsedMessage extends ResponsedMessage<byte[]> {
    public int mRetry;
    public long sequenceID;

    public SocketResponsedMessage(int i2) {
        super(i2);
        this.mRetry = 0;
    }

    public void decodeExtraDataInBackGround(int i2, byte[] bArr) throws Exception {
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public abstract /* synthetic */ void decodeInBackGround(int i2, T t) throws Exception;

    public int getRetry() {
        return this.mRetry;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return getError() != 0;
    }

    public void setRetry(int i2) {
        this.mRetry = i2;
    }
}
