package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.account.contants.LoginConstants;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class a implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cTN = new HashSet();

    static {
        cTN.add("https");
        cTN.add(HttpHost.DEFAULT_SCHEME_NAME);
        cTN.add(LoginConstants.SMS_LOGIN);
        cTN.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void iv(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public boolean iw(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = cTN.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void iu(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void g(int i, String str, String str2) {
    }
}
