package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
/* loaded from: classes7.dex */
public class f implements e {
    WebViewProviderFactoryBoundaryInterface Am;

    public f(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.Am = webViewProviderFactoryBoundaryInterface;
    }

    @Override // androidx.webkit.internal.e
    public WebkitToCompatConverterBoundaryInterface hN() {
        return (WebkitToCompatConverterBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebkitToCompatConverterBoundaryInterface.class, this.Am.getWebkitToCompatConverter());
    }

    @Override // androidx.webkit.internal.e
    public String[] hO() {
        return this.Am.getSupportedFeatures();
    }
}
