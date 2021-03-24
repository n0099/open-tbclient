package aegon.chrome.net.impl;

import aegon.chrome.net.NetworkException;
/* loaded from: classes.dex */
public class NetworkExceptionImpl extends NetworkException {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final int mCronetInternalErrorCode;
    public final int mErrorCode;

    public NetworkExceptionImpl(String str, int i, int i2) {
        super(str, null);
        this.mErrorCode = i;
        this.mCronetInternalErrorCode = i2;
    }

    @Override // aegon.chrome.net.NetworkException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        sb.append(", ErrorCode=");
        sb.append(this.mErrorCode);
        if (this.mCronetInternalErrorCode != 0) {
            sb.append(", InternalErrorCode=");
            sb.append(this.mCronetInternalErrorCode);
        }
        sb.append(", Retryable=");
        sb.append(immediatelyRetryable());
        return sb.toString();
    }

    public boolean immediatelyRetryable() {
        int i = this.mErrorCode;
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 8;
    }
}
