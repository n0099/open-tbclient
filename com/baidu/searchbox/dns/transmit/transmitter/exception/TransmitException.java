package com.baidu.searchbox.dns.transmit.transmitter.exception;
/* loaded from: classes3.dex */
public class TransmitException extends Exception {
    public int detailErrorCode;
    public int failStatus;

    public TransmitException() {
        this.failStatus = -1;
        this.detailErrorCode = -1;
    }

    public int getDetailErrorCode() {
        return this.detailErrorCode;
    }

    public int getFailStatus() {
        return this.failStatus;
    }

    public TransmitException(int i, int i2, String str) {
        super(str);
        this.failStatus = -1;
        this.detailErrorCode = -1;
        this.failStatus = i;
        this.detailErrorCode = i2;
    }

    public TransmitException(int i, String str) {
        super(str);
        this.failStatus = -1;
        this.detailErrorCode = -1;
        this.failStatus = i;
    }

    public TransmitException(String str) {
        super(str);
        this.failStatus = -1;
        this.detailErrorCode = -1;
    }
}
