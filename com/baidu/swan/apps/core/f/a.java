package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> asA = new HashSet();

    static {
        asA.add("https");
        asA.add(HttpHost.DEFAULT_SCHEME_NAME);
        asA.add("sms");
        asA.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void de(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.c
    public boolean dU(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = asA.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }
}
