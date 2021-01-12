package com.baidu.live.adp.framework.message;
/* loaded from: classes10.dex */
public class HttpProgressResponsedMessage extends CustomResponsedMessage<Object> {
    private float mProgress;

    public HttpProgressResponsedMessage(int i) {
        super(i);
        this.mProgress = 0.0f;
    }

    @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage, com.baidu.live.adp.framework.message.IDecode
    public void decodeInBackGround(int i, Object obj) throws Exception {
    }

    @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage, com.baidu.live.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return false;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float f) {
        this.mProgress = f;
    }
}
