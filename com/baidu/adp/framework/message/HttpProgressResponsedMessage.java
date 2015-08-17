package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public class HttpProgressResponsedMessage extends CustomResponsedMessage<Object> {
    private float mProgress;

    public HttpProgressResponsedMessage(int i) {
        super(i);
        this.mProgress = 0.0f;
    }

    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, Object obj) {
    }

    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
