package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.SafeBrowsingResponse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_boundary.util.Features;
/* loaded from: classes19.dex */
public class b extends androidx.webkit.a {
    private SafeBrowsingResponse AZ;
    private SafeBrowsingResponseBoundaryInterface Ba;

    public b(InvocationHandler invocationHandler) {
        this.Ba = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    public b(SafeBrowsingResponse safeBrowsingResponse) {
        this.AZ = safeBrowsingResponse;
    }

    private SafeBrowsingResponse hP() {
        if (this.AZ == null) {
            this.AZ = d.hU().b(Proxy.getInvocationHandler(this.Ba));
        }
        return this.AZ;
    }

    private SafeBrowsingResponseBoundaryInterface hQ() {
        if (this.Ba == null) {
            this.Ba = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, d.hU().a(this.AZ));
        }
        return this.Ba;
    }

    @Override // androidx.webkit.a
    @SuppressLint({"NewApi"})
    public void showInterstitial(boolean z) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature(Features.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL);
        if (feature.isSupportedByFramework()) {
            hP().showInterstitial(z);
        } else if (feature.isSupportedByWebView()) {
            hQ().showInterstitial(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
