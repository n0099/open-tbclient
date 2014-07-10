package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class SocketResponsedMessage extends ResponsedMessage<byte[]> {
    private long mCostTime;
    private int mDownSize;
    private int mRetry;

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return getError() != 0;
    }

    public int getDownSize() {
        return this.mDownSize;
    }

    public void setDownSize(int i) {
        this.mDownSize = i;
    }

    public int getRetry() {
        return this.mRetry;
    }

    public void setRetry(int i) {
        this.mRetry = i;
    }

    public long getCostTime() {
        return this.mCostTime;
    }

    public void setCostTime(long j) {
        this.mCostTime = j;
    }

    public SocketResponsedMessage(int i) {
        super(i);
        this.mDownSize = 0;
        this.mRetry = 0;
        this.mCostTime = 0L;
    }
}
