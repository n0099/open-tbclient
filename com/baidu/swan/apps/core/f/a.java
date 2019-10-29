package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> aMp = new HashSet();

    static {
        aMp.add("https");
        aMp.add(HttpHost.DEFAULT_SCHEME_NAME);
        aMp.add("sms");
        aMp.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void dc(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.c
    public boolean dd(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = aMp.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }
}
