package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.account.contants.LoginConstants;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes8.dex */
public class a implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cRA = new HashSet();

    static {
        cRA.add("https");
        cRA.add(HttpHost.DEFAULT_SCHEME_NAME);
        cRA.add(LoginConstants.SMS_LOGIN);
        cRA.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void hV(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public boolean hW(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = cRA.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void gV(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void g(int i, String str, String str2) {
    }
}
