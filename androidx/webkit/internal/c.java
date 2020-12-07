package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_boundary.util.Features;
/* loaded from: classes19.dex */
public class c extends androidx.webkit.b {
    private WebResourceError Bb;
    private WebResourceErrorBoundaryInterface Bc;

    public c(InvocationHandler invocationHandler) {
        this.Bc = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    public c(WebResourceError webResourceError) {
        this.Bb = webResourceError;
    }

    private WebResourceError hR() {
        if (this.Bb == null) {
            this.Bb = d.hU().a(Proxy.getInvocationHandler(this.Bc));
        }
        return this.Bb;
    }

    private WebResourceErrorBoundaryInterface hS() {
        if (this.Bc == null) {
            this.Bc = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceErrorBoundaryInterface.class, d.hU().a(this.Bb));
        }
        return this.Bc;
    }

    @Override // androidx.webkit.b
    @SuppressLint({"NewApi"})
    public int getErrorCode() {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature(Features.WEB_RESOURCE_ERROR_GET_CODE);
        if (feature.isSupportedByFramework()) {
            return hR().getErrorCode();
        }
        if (feature.isSupportedByWebView()) {
            return hS().getErrorCode();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.b
    @SuppressLint({"NewApi"})
    public CharSequence getDescription() {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature(Features.WEB_RESOURCE_ERROR_GET_DESCRIPTION);
        if (feature.isSupportedByFramework()) {
            return hR().getDescription();
        }
        if (feature.isSupportedByWebView()) {
            return hS().getDescription();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
