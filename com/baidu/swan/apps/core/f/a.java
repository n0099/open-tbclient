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
    private static final Set<String> bpM = new HashSet();

    static {
        bpM.add("https");
        bpM.add(HttpHost.DEFAULT_SCHEME_NAME);
        bpM.add(LoginConstants.SMS_LOGIN);
        bpM.add("tel");
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void em(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void goBack() {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public boolean en(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = bpM.contains(parse.getScheme());
        if (DEBUG) {
            Log.d("WebViewWidgetListener", (contains ? "legal schemes : " : "illegal schemes : ") + parse.getScheme());
        }
        return !contains;
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void el(String str) {
    }

    @Override // com.baidu.swan.apps.core.f.d
    public void c(int i, String str, String str2) {
    }
}
