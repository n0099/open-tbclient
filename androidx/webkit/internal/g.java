package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
/* loaded from: classes19.dex */
public class g {
    private final WebkitToCompatConverterBoundaryInterface Bh;

    public g(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.Bh = webkitToCompatConverterBoundaryInterface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvocationHandler a(WebResourceError webResourceError) {
        return this.Bh.convertWebResourceError(webResourceError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebResourceError a(InvocationHandler invocationHandler) {
        return (WebResourceError) this.Bh.convertWebResourceError(invocationHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvocationHandler a(SafeBrowsingResponse safeBrowsingResponse) {
        return this.Bh.convertSafeBrowsingResponse(safeBrowsingResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeBrowsingResponse b(InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse) this.Bh.convertSafeBrowsingResponse(invocationHandler);
    }
}
