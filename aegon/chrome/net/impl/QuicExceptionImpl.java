package aegon.chrome.net.impl;

import aegon.chrome.net.NetworkException;
/* loaded from: classes.dex */
public class QuicExceptionImpl extends NetworkException {
    public final NetworkExceptionImpl mNetworkException;
    public final int mQuicDetailedErrorCode;

    public QuicExceptionImpl(String str, int i2, int i3, int i4) {
        super(str, null);
        this.mNetworkException = new NetworkExceptionImpl(str, i2, i3);
        this.mQuicDetailedErrorCode = i4;
    }

    @Override // aegon.chrome.net.NetworkException
    public int getErrorCode() {
        return this.mNetworkException.mErrorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mNetworkException.getMessage() + ", QuicDetailedErrorCode=" + this.mQuicDetailedErrorCode;
    }
}
