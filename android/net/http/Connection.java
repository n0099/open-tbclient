package android.net.http;

import android.content.Context;
import org.apache.http.HttpHost;
/* loaded from: classes5.dex */
abstract class Connection {
    protected SslCertificate mCertificate;
    protected AndroidHttpClientConnection mHttpClientConnection;

    /* JADX INFO: Access modifiers changed from: protected */
    public Connection(Context context, HttpHost httpHost, RequestFeeder requestFeeder) {
        throw new RuntimeException("Stub!");
    }

    public synchronized String toString() {
        throw new RuntimeException("Stub!");
    }
}
