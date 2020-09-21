package com.baidu.swan.apps.core.f;

import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.account.contants.LoginConstants;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> clz = new HashSet();

    static {
        clz.add("https");
        clz.add(HttpHost.DEFAULT_SCHEME_NAME);
        clz.add(LoginConstants.SMS_LOGIN);
        clz.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void hQ(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public boolean hR(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = clz.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void hp(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void d(int i, String str, String str2) {
    }
}
