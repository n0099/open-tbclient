package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.webkit.SafeBrowsingResponse;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class b extends androidx.webkit.a {
    private SafeBrowsingResponse zN;
    private org.a.a.a zO;

    public b(@NonNull InvocationHandler invocationHandler) {
        this.zO = (org.a.a.a) org.a.a.a.a.a(org.a.a.a.class, invocationHandler);
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

    private org.a.a.a hP() {
        if (this.zO == null) {
            this.zO = (org.a.a.a) org.a.a.a.a.a(org.a.a.a.class, d.hT().a(this.zN));
        }
        return this.zO;
    }

    @Override // androidx.webkit.a
    @SuppressLint({"NewApi"})
    public void Z(boolean z) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        if (feature.isSupportedByFramework()) {
            hO().showInterstitial(z);
        } else if (feature.isSupportedByWebView()) {
            hP().Z(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
