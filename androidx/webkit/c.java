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
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;
import org.chromium.support_lib_boundary.util.Features;
/* loaded from: classes15.dex */
public class c extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {Features.VISUAL_STATE_CALLBACK, Features.RECEIVE_WEB_RESOURCE_ERROR, Features.RECEIVE_HTTP_ERROR, Features.SHOULD_OVERRIDE_WITH_REDIRECTS, Features.SAFE_BROWSING_HIT};

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onPageCommitVisible(@NonNull WebView webView, @NonNull String str) {
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
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
        if (Build.VERSION.SDK_INT >= 21 && d.aY(Features.WEB_RESOURCE_ERROR_GET_CODE) && d.aY(Features.WEB_RESOURCE_ERROR_GET_DESCRIPTION) && webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, bVar.getErrorCode(), bVar.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse) {
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
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
        if (d.aY(Features.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL)) {
            aVar.showInterstitial(true);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    @RequiresApi(21)
    public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
