package aegon.chrome.net;
/* loaded from: classes5.dex */
public abstract class NetworkException extends CronetException {
    public NetworkException(String str, Throwable th) {
        super(str, th);
    }

    public abstract int getErrorCode();
}
