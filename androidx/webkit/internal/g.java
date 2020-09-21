package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
/* loaded from: classes17.dex */
public class g {
    private final WebkitToCompatConverterBoundaryInterface zV;

    public g(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.zV = webkitToCompatConverterBoundaryInterface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvocationHandler a(WebResourceError webResourceError) {
        return this.zV.convertWebResourceError(webResourceError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(23)
    public WebResourceError a(InvocationHandler invocationHandler) {
        return (WebResourceError) this.zV.convertWebResourceError(invocationHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvocationHandler a(SafeBrowsingResponse safeBrowsingResponse) {
        return this.zV.convertSafeBrowsingResponse(safeBrowsingResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(27)
    public SafeBrowsingResponse b(InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse) this.zV.convertSafeBrowsingResponse(invocationHandler);
    }
}
