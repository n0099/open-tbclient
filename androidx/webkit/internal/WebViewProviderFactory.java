package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
/* loaded from: classes3.dex */
public interface WebViewProviderFactory {
    WebViewProviderBoundaryInterface createWebView(WebView webView);

    ServiceWorkerControllerBoundaryInterface getServiceWorkerController();

    StaticsBoundaryInterface getStatics();

    String[] getWebViewFeatures();

    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();
}
