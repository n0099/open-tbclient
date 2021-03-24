package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public class HttpProgressResponsedMessage extends CustomResponsedMessage<Object> {
    public float mProgress;

    public HttpProgressResponsedMessage(int i) {
        super(i);
        this.mProgress = 0.0f;
    }

    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, Object obj) throws Exception {
    }

    public float getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return false;
    }

    public void setProgress(float f2) {
        this.mProgress = f2;
    }
}
