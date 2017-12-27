package android.net.http;

import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class RequestHandle {
    public static final int MAX_REDIRECT_COUNT = 16;

    public RequestHandle(RequestQueue requestQueue, String str, WebAddress webAddress, String str2, Map<String, String> map, InputStream inputStream, int i, Request request) {
        throw new RuntimeException("Stub!");
    }

    public RequestHandle(RequestQueue requestQueue, String str, WebAddress webAddress, String str2, Map<String, String> map, InputStream inputStream, int i, Request request, Connection connection) {
        throw new RuntimeException("Stub!");
    }

    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    public void pauseRequest(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void handleSslErrorResponse(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public boolean isRedirectMax() {
        throw new RuntimeException("Stub!");
    }

    public int getRedirectCount() {
        throw new RuntimeException("Stub!");
    }

    public void setRedirectCount(int i) {
        throw new RuntimeException("Stub!");
    }

    public boolean setupRedirect(String str, int i, Map<String, String> map) {
        throw new RuntimeException("Stub!");
    }

    public void setupBasicAuthResponse(boolean z, String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public void setupDigestAuthResponse(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        throw new RuntimeException("Stub!");
    }

    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    public static String computeBasicAuthResponse(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public void waitUntilComplete() {
        throw new RuntimeException("Stub!");
    }

    public void processRequest() {
        throw new RuntimeException("Stub!");
    }

    public static String authorizationHeader(boolean z) {
        throw new RuntimeException("Stub!");
    }
}
