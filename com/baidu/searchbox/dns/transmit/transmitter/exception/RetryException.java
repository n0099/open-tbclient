package com.baidu.searchbox.dns.transmit.transmitter.exception;
/* loaded from: classes2.dex */
public class RetryException extends TransmitException {
    public RetryException() {
    }

    public RetryException(int i, int i2, String str) {
        super(i, i2, str);
    }

    public RetryException(int i, String str) {
        super(i, str);
    }

    public RetryException(String str) {
        super(str);
    }
}
