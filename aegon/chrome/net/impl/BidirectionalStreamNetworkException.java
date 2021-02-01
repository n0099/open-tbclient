package aegon.chrome.net.impl;
/* loaded from: classes3.dex */
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    public static final /* synthetic */ boolean $assertionsDisabled = !BidirectionalStreamNetworkException.class.desiredAssertionStatus();

    public BidirectionalStreamNetworkException(String str, int i, int i2) {
        super(str, i, i2);
    }

    @Override // aegon.chrome.net.impl.NetworkExceptionImpl
    public boolean immediatelyRetryable() {
        int i = this.mCronetInternalErrorCode;
        if (i != -358 && i != -352) {
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
        } else if ($assertionsDisabled || this.mErrorCode == 11) {
            return true;
        } else {
            throw new AssertionError();
        }
    }
}
