package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class ResponsedMessage<T> implements b<T> {
    private final int mCmd;
    private int mError = 0;
    private String mErrorString = null;
    private Message<?> mOrginalMessage;

    public abstract boolean hasError();

    public int getError() {
        return this.mError;
    }

    public void setError(int i) {
        this.mError = i;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }

    public ResponsedMessage(int i) {
        this.mCmd = i;
    }

    public int getCmd() {
        return this.mCmd;
    }

    public Message<?> getOrginalMessage() {
        return this.mOrginalMessage;
    }

    public void setOrginalMessage(Message<?> message) {
        this.mOrginalMessage = message;
    }

    public void processInBackGround(int i, T t) {
    }
}
