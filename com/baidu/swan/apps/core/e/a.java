package com.baidu.swan.apps.core.e;

import android.net.Uri;
import android.util.Log;
import com.facebook.common.internal.h;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> arQ = h.K(HttpHost.DEFAULT_SCHEME_NAME, "https", "tel", "sms");

    @Override // com.baidu.swan.apps.core.e.c
    public void dn(String str) {
    }

    @Override // com.baidu.swan.apps.core.e.c
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.e.c
    public boolean ec(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = arQ.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }
}
