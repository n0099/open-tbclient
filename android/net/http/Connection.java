package android.net.http;

import android.content.Context;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public abstract class Connection {
    public SslCertificate mCertificate;
    public AndroidHttpClientConnection mHttpClientConnection;

    public Connection(Context context, HttpHost httpHost, RequestFeeder requestFeeder) {
        throw new RuntimeException("Stub!");
    }

    public synchronized String toString() {
        throw new RuntimeException("Stub!");
    }
}
