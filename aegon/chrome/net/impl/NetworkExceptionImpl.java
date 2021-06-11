package aegon.chrome.net.impl;

import aegon.chrome.net.NetworkException;
/* loaded from: classes.dex */
public class NetworkExceptionImpl extends NetworkException {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final int mCronetInternalErrorCode;
    public final int mErrorCode;

    public NetworkExceptionImpl(String str, int i2, int i3) {
        super(str, null);
        this.mErrorCode = i2;
        this.mCronetInternalErrorCode = i3;
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
        int i2 = this.mErrorCode;
        return i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 8;
    }
}
