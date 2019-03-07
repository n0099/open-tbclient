package com.baidu.swan.apps.core.e;

import android.net.Uri;
import android.util.Log;
import com.facebook.common.internal.h;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final Set<String> arL = h.K(HttpHost.DEFAULT_SCHEME_NAME, "https", "tel", "sms");

    @Override // com.baidu.swan.apps.core.e.c
    public void dl(String str) {
    }

    @Override // com.baidu.swan.apps.core.e.c
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.e.c
    public boolean ea(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = arL.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }
}
