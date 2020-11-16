package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.account.contants.LoginConstants;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class a implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cKw = new HashSet();

    static {
        cKw.add("https");
        cKw.add(HttpHost.DEFAULT_SCHEME_NAME);
        cKw.add(LoginConstants.SMS_LOGIN);
        cKw.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void iJ(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public boolean iK(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = cKw.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void hP(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void e(int i, String str, String str2) {
    }
}
