package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes19.dex */
public class f implements e {
    WebViewProviderFactoryBoundaryInterface Bg;

    public f(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.Bg = webViewProviderFactoryBoundaryInterface;
    }

    @Override // androidx.webkit.internal.e
    public WebkitToCompatConverterBoundaryInterface hN() {
        return (WebkitToCompatConverterBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebkitToCompatConverterBoundaryInterface.class, this.Bg.getWebkitToCompatConverter());
    }

    @Override // androidx.webkit.internal.e
    public String[] hO() {
        return this.Bg.getSupportedFeatures();
    }
}
