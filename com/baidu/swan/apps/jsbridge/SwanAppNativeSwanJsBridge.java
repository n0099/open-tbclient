package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.am1;
import com.baidu.tieba.ci3;
import com.baidu.tieba.n42;
import com.baidu.tieba.o13;
import com.baidu.tieba.p22;
import com.baidu.tieba.qw2;
import com.baidu.tieba.th3;
import com.baidu.tieba.zp2;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = am1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public n42 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return SchemeCollecter.CLASSIFY_SWAN_WEB;
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return zp2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = qw2.b();
        p22.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        n42 n42Var = this.mJSContainer;
        if (n42Var == null || !(n42Var instanceof NgWebView) || !((NgWebView) n42Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(n42 n42Var) {
        this.mJSContainer = n42Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (o13.p()) {
                return ci3.d(i, getClassify());
            }
            return "";
        }
        String d = ci3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                th3.c(ci3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                ci3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            th3.d();
        }
        return d;
    }
}
