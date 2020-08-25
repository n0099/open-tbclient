package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
/* loaded from: classes4.dex */
public class g {
    private final org.a.a.d zV;

    public g(org.a.a.d dVar) {
        this.zV = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvocationHandler a(WebResourceError webResourceError) {
        return this.zV.bR(webResourceError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(23)
    public WebResourceError a(InvocationHandler invocationHandler) {
        return (WebResourceError) this.zV.c(invocationHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvocationHandler a(SafeBrowsingResponse safeBrowsingResponse) {
        return this.zV.bS(safeBrowsingResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(27)
    public SafeBrowsingResponse b(InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse) this.zV.d(invocationHandler);
    }
}
