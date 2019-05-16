package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> arX = new HashSet();

    static {
        arX.add("https");
        arX.add(HttpHost.DEFAULT_SCHEME_NAME);
        arX.add("sms");
        arX.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void da(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.c
    public boolean dQ(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = arX.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }
}
