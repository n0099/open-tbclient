package aegon.chrome.net.impl;

import aegon.chrome.net.NetworkException;
/* loaded from: classes4.dex */
public class NetworkExceptionImpl extends NetworkException {
    public static final /* synthetic */ boolean $assertionsDisabled = !NetworkExceptionImpl.class.desiredAssertionStatus();
    public final int mCronetInternalErrorCode;
    public final int mErrorCode;

    public NetworkExceptionImpl(String str, int i, int i2) {
        super(str, null);
        if (!$assertionsDisabled && (i <= 0 || i >= 12)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && i2 >= 0) {
            throw new AssertionError();
        }
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
        sb.append(", ErrorCode=").append(this.mErrorCode);
        if (this.mCronetInternalErrorCode != 0) {
            sb.append(", InternalErrorCode=").append(this.mCronetInternalErrorCode);
        }
        sb.append(", Retryable=").append(immediatelyRetryable());
        return sb.toString();
    }

    public boolean immediatelyRetryable() {
        switch (this.mErrorCode) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            case 7:
            default:
                return false;
        }
    }
}
