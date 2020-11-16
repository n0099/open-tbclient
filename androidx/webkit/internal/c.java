package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.WebResourceError;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_boundary.util.Features;
/* loaded from: classes7.dex */
public class c extends androidx.webkit.b {
    private WebResourceError Ah;
    private WebResourceErrorBoundaryInterface Ai;

    public c(@NonNull InvocationHandler invocationHandler) {
        this.Ai = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    public c(@NonNull WebResourceError webResourceError) {
        this.Ah = webResourceError;
    }

    @RequiresApi(23)
    private WebResourceError hR() {
        if (this.Ah == null) {
            this.Ah = d.hU().a(Proxy.getInvocationHandler(this.Ai));
        }
        return this.Ah;
    }

    private WebResourceErrorBoundaryInterface hS() {
        if (this.Ai == null) {
            this.Ai = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceErrorBoundaryInterface.class, d.hU().a(this.Ah));
        }
        return this.Ai;
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
    @NonNull
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
