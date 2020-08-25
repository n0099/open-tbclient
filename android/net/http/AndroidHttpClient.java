package android.net.http;

import android.content.ContentResolver;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes9.dex */
public final class AndroidHttpClient implements HttpClient {
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES;

    AndroidHttpClient() {
        throw new RuntimeException("Stub!");
    }

    public static AndroidHttpClient newInstance(String str, Context context) {
        throw new RuntimeException("Stub!");
    }

    public static AndroidHttpClient newInstance(String str) {
        throw new RuntimeException("Stub!");
    }

    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest httpRequest) {
        throw new RuntimeException("Stub!");
    }

    public static InputStream getUngzippedContent(HttpEntity httpEntity) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void close() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    public static AbstractHttpEntity getCompressedEntity(byte[] bArr, ContentResolver contentResolver) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static long getMinGzipSize(ContentResolver contentResolver) {
        throw new RuntimeException("Stub!");
    }

    public void enableCurlLogging(String str, int i) {
        throw new RuntimeException("Stub!");
    }

    public void disableCurlLogging() {
        throw new RuntimeException("Stub!");
    }

    public static long parseDate(String str) {
        throw new RuntimeException("Stub!");
    }
}
