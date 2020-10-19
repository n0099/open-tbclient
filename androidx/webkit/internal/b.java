package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.SafeBrowsingResponse;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_boundary.util.Features;
/* loaded from: classes15.dex */
public class b extends androidx.webkit.a {
    private SafeBrowsingResponse Af;
    private SafeBrowsingResponseBoundaryInterface Ag;

    public b(@NonNull InvocationHandler invocationHandler) {
        this.Ag = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    public b(@NonNull SafeBrowsingResponse safeBrowsingResponse) {
        this.Af = safeBrowsingResponse;
    }

    @RequiresApi(27)
    private SafeBrowsingResponse hP() {
        if (this.Af == null) {
            this.Af = d.hU().b(Proxy.getInvocationHandler(this.Ag));
        }
        return this.Af;
    }

    private SafeBrowsingResponseBoundaryInterface hQ() {
        if (this.Ag == null) {
            this.Ag = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, d.hU().a(this.Af));
        }
        return this.Ag;
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
