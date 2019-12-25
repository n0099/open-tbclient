package com.baidu.live.adp.framework.message;
/* loaded from: classes2.dex */
public abstract class SocketResponsedMessage extends ResponsedMessage<byte[]> {
    private int mRetry;
    public long sequenceID;

    @Override // com.baidu.live.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return getError() != 0;
    }

    public int getRetry() {
        return this.mRetry;
    }

    public void setRetry(int i) {
        this.mRetry = i;
    }

    public SocketResponsedMessage(int i) {
        super(i);
        this.mRetry = 0;
    }

    public void decodeExtraDataInBackGround(int i, byte[] bArr) throws Exception {
    }
}
