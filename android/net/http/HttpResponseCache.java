package android.net.http;

import java.io.File;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public final class HttpResponseCache extends ResponseCache {
    HttpResponseCache() {
        throw new RuntimeException("Stub!");
    }

    public static HttpResponseCache getInstalled() {
        throw new RuntimeException("Stub!");
    }

    public static synchronized HttpResponseCache install(File file, long j) throws IOException {
        synchronized (HttpResponseCache.class) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // java.net.ResponseCache
    public CacheResponse get(URI uri, String str, Map<String, List<String>> map) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.net.ResponseCache
    public CacheRequest put(URI uri, URLConnection uRLConnection) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public long size() {
        throw new RuntimeException("Stub!");
    }

    public long maxSize() {
        throw new RuntimeException("Stub!");
    }

    public void flush() {
        throw new RuntimeException("Stub!");
    }

    public int getNetworkCount() {
        throw new RuntimeException("Stub!");
    }

    public int getHitCount() {
        throw new RuntimeException("Stub!");
    }

    public int getRequestCount() {
        throw new RuntimeException("Stub!");
    }

    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void delete() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
