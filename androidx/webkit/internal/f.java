package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes17.dex */
public class f implements e {
    WebViewProviderFactoryBoundaryInterface zU;

    public f(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.zU = webViewProviderFactoryBoundaryInterface;
    }

    @Override // androidx.webkit.internal.e
    public WebkitToCompatConverterBoundaryInterface hM() {
        return (WebkitToCompatConverterBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebkitToCompatConverterBoundaryInterface.class, this.zU.getWebkitToCompatConverter());
    }

    @Override // androidx.webkit.internal.e
    public String[] hN() {
        return this.zU.getSupportedFeatures();
    }
}
