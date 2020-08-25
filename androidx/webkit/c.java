package androidx.webkit;

import android.os.Build;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.reflect.InvocationHandler;
/* loaded from: classes4.dex */
public class c extends WebViewClient {
    private static final String[] sSupportedFeatures = {"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(@NonNull WebView webView, @NonNull String str) {
    }

    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull InvocationHandler invocationHandler) {
        onReceivedError(webView, webResourceRequest, new androidx.webkit.internal.c(invocationHandler));
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT >= 23) {
            onReceivedError(webView, webResourceRequest, new androidx.webkit.internal.c(webResourceError));
        }
    }

    @RequiresApi(21)
    public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull b bVar) {
        if (Build.VERSION.SDK_INT >= 21 && d.aY("WEB_RESOURCE_ERROR_GET_CODE") && d.aY("WEB_RESOURCE_ERROR_GET_DESCRIPTION") && webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, bVar.getErrorCode(), bVar.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void onSafeBrowsingHit(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, int i, @NonNull InvocationHandler invocationHandler) {
        onSafeBrowsingHit(webView, webResourceRequest, i, new androidx.webkit.internal.b(invocationHandler));
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(27)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void onSafeBrowsingHit(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, int i, @NonNull SafeBrowsingResponse safeBrowsingResponse) {
        onSafeBrowsingHit(webView, webResourceRequest, i, new androidx.webkit.internal.b(safeBrowsingResponse));
    }

    public void onSafeBrowsingHit(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, int i, @NonNull a aVar) {
        if (d.aY("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
            aVar.Z(true);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(21)
    public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
