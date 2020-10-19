package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.webkit.internal.WebViewFeatureInternal;
/* loaded from: classes15.dex */
public class d {
    public static boolean aY(@NonNull String str) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature(str);
        return feature.isSupportedByFramework() || feature.isSupportedByWebView();
    }
}
