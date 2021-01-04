package android.net.http;

import android.content.Context;
import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class RequestQueue implements RequestFeeder {
    public RequestQueue(Context context) {
        throw new RuntimeException("Stub!");
    }

    public RequestQueue(Context context, int i) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void enablePlatformNotifications() {
        throw new RuntimeException("Stub!");
    }

    public synchronized void disablePlatformNotifications() {
        throw new RuntimeException("Stub!");
    }

    public HttpHost getProxyHost() {
        throw new RuntimeException("Stub!");
    }

    public RequestHandle queueRequest(String str, String str2, Map<String, String> map, EventHandler eventHandler, InputStream inputStream, int i) {
        throw new RuntimeException("Stub!");
    }

    public RequestHandle queueRequest(String str, WebAddress webAddress, String str2, Map<String, String> map, EventHandler eventHandler, InputStream inputStream, int i) {
        throw new RuntimeException("Stub!");
    }

    public RequestHandle queueSynchronousRequest(String str, WebAddress webAddress, String str2, Map<String, String> map, EventHandler eventHandler, InputStream inputStream, int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.RequestFeeder
    public synchronized Request getRequest() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.RequestFeeder
    public synchronized Request getRequest(HttpHost httpHost) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.RequestFeeder
    public synchronized boolean haveRequest(HttpHost httpHost) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.RequestFeeder
    public void requeueRequest(Request request) {
        throw new RuntimeException("Stub!");
    }

    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    protected synchronized void queueRequest(Request request, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void startTiming() {
        throw new RuntimeException("Stub!");
    }

    public void stopTiming() {
        throw new RuntimeException("Stub!");
    }
}
