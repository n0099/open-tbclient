package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.account.contants.LoginConstants;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class a implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bXe = new HashSet();

    static {
        bXe.add("https");
        bXe.add(HttpHost.DEFAULT_SCHEME_NAME);
        bXe.add(LoginConstants.SMS_LOGIN);
        bXe.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void fR(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public boolean fS(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = bXe.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void fQ(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void d(int i, String str, String str2) {
    }
}
