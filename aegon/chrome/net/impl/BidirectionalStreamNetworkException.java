package aegon.chrome.net.impl;
/* loaded from: classes.dex */
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public BidirectionalStreamNetworkException(String str, int i2, int i3) {
        super(str, i2, i3);
    }

    @Override // aegon.chrome.net.impl.NetworkExceptionImpl
    public boolean immediatelyRetryable() {
        int i2;
        int i3 = this.mCronetInternalErrorCode;
        return i3 == -358 || i3 == -352 || (i2 = this.mErrorCode) == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 8;
    }
}
