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
/* loaded from: classes17.dex */
public class b extends androidx.webkit.a {
    private SafeBrowsingResponse zN;
    private SafeBrowsingResponseBoundaryInterface zO;

    public b(@NonNull InvocationHandler invocationHandler) {
        this.zO = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    public b(@NonNull SafeBrowsingResponse safeBrowsingResponse) {
        this.zN = safeBrowsingResponse;
    }

    @RequiresApi(27)
    private SafeBrowsingResponse hO() {
        if (this.zN == null) {
            this.zN = d.hT().b(Proxy.getInvocationHandler(this.zO));
        }
        return this.zN;
    }

    private SafeBrowsingResponseBoundaryInterface hP() {
        if (this.zO == null) {
            this.zO = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, d.hT().a(this.zN));
        }
        return this.zO;
    }

    @Override // androidx.webkit.a
    @SuppressLint({"NewApi"})
    public void showInterstitial(boolean z) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature(Features.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL);
        if (feature.isSupportedByFramework()) {
            hO().showInterstitial(z);
        } else if (feature.isSupportedByWebView()) {
            hP().showInterstitial(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
