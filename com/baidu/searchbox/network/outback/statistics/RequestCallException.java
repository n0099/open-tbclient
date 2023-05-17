package com.baidu.searchbox.network.outback.statistics;
/* loaded from: classes3.dex */
public class RequestCallException extends Exception {
    public Exception mRealException;
    public NetworkStatRecord mStatRecord;

    public RequestCallException(Exception exc, NetworkStatRecord networkStatRecord) {
        super(exc);
        this.mRealException = exc;
        this.mStatRecord = networkStatRecord;
    }

    public RequestCallException(String str, Exception exc, NetworkStatRecord networkStatRecord) {
        super(str, exc);
        this.mRealException = exc;
        this.mStatRecord = networkStatRecord;
    }

    public Exception getRealException() {
        return this.mRealException;
    }

    public NetworkStatRecord getStatRecord() {
        return this.mStatRecord;
    }
}
