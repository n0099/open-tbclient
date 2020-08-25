package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.WebResourceError;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class c extends androidx.webkit.b {
    private WebResourceError zP;
    private org.a.a.b zQ;

    public c(@NonNull InvocationHandler invocationHandler) {
        this.zQ = (org.a.a.b) org.a.a.a.a.a(org.a.a.b.class, invocationHandler);
    }

    public c(@NonNull WebResourceError webResourceError) {
        this.zP = webResourceError;
    }

    @RequiresApi(23)
    private WebResourceError hQ() {
        if (this.zP == null) {
            this.zP = d.hT().a(Proxy.getInvocationHandler(this.zQ));
        }
        return this.zP;
    }

    private org.a.a.b hR() {
        if (this.zQ == null) {
            this.zQ = (org.a.a.b) org.a.a.a.a.a(org.a.a.b.class, d.hT().a(this.zP));
        }
        return this.zQ;
    }

    @Override // androidx.webkit.b
    @SuppressLint({"NewApi"})
    public int getErrorCode() {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_RESOURCE_ERROR_GET_CODE");
        if (feature.isSupportedByFramework()) {
            return hQ().getErrorCode();
        }
        if (feature.isSupportedByWebView()) {
            return hR().getErrorCode();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.b
    @NonNull
    @SuppressLint({"NewApi"})
    public CharSequence getDescription() {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        if (feature.isSupportedByFramework()) {
            return hQ().getDescription();
        }
        if (feature.isSupportedByWebView()) {
            return hR().getDescription();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
