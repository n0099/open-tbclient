package aegon.chrome.net.impl;
/* loaded from: classes.dex */
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public BidirectionalStreamNetworkException(String str, int i, int i2) {
        super(str, i, i2);
    }

    @Override // aegon.chrome.net.impl.NetworkExceptionImpl
    public boolean immediatelyRetryable() {
        int i;
        int i2 = this.mCronetInternalErrorCode;
        return i2 == -358 || i2 == -352 || (i = this.mErrorCode) == 3 || i == 4 || i == 5 || i == 6 || i == 8;
    }
}
