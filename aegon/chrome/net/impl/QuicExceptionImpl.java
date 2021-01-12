package aegon.chrome.net.impl;

import aegon.chrome.net.NetworkException;
/* loaded from: classes4.dex */
public class QuicExceptionImpl extends NetworkException {
    public final NetworkExceptionImpl mNetworkException;
    public final int mQuicDetailedErrorCode;

    public QuicExceptionImpl(String str, int i, int i2, int i3) {
        super(str, null);
        this.mNetworkException = new NetworkExceptionImpl(str, i, i2);
        this.mQuicDetailedErrorCode = i3;
    }

    @Override // aegon.chrome.net.NetworkException
    public int getErrorCode() {
        return this.mNetworkException.mErrorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(this.mNetworkException.getMessage());
        sb.append(", QuicDetailedErrorCode=").append(this.mQuicDetailedErrorCode);
        return sb.toString();
    }
}
