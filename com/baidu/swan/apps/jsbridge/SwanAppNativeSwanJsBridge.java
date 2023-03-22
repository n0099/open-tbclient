package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.do1;
import com.baidu.tieba.ds2;
import com.baidu.tieba.gk3;
import com.baidu.tieba.r62;
import com.baidu.tieba.s33;
import com.baidu.tieba.t42;
import com.baidu.tieba.uy2;
import com.baidu.tieba.xj3;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = do1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public r62 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return "swan/web";
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return ds2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = uy2.b();
        t42.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        r62 r62Var = this.mJSContainer;
        if (r62Var == null || !(r62Var instanceof NgWebView) || !((NgWebView) r62Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(r62 r62Var) {
        this.mJSContainer = r62Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (s33.p()) {
                return gk3.d(i, getClassify());
            }
            return "";
        }
        String d = gk3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                xj3.c(gk3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                gk3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            xj3.d();
        }
        return d;
    }
}
