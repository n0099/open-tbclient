package android.net.http;

import java.io.File;
/* loaded from: classes.dex */
public class HttpsConnection extends Connection {
    public SslCertificate mCertificate;
    public AndroidHttpClientConnection mHttpClientConnection;

    public HttpsConnection() {
        super(null, null, null);
        throw new RuntimeException("Stub!");
    }

    public static void initializeEngine(File file) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.Connection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
