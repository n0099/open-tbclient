package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.eo1;
import com.baidu.tieba.es2;
import com.baidu.tieba.hk3;
import com.baidu.tieba.s62;
import com.baidu.tieba.t33;
import com.baidu.tieba.u42;
import com.baidu.tieba.vy2;
import com.baidu.tieba.yj3;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = eo1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public s62 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return "swan/web";
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return es2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = vy2.b();
        u42.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        s62 s62Var = this.mJSContainer;
        if (s62Var == null || !(s62Var instanceof NgWebView) || !((NgWebView) s62Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(s62 s62Var) {
        this.mJSContainer = s62Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (t33.p()) {
                return hk3.d(i, getClassify());
            }
            return "";
        }
        String d = hk3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                yj3.c(hk3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                hk3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            yj3.d();
        }
        return d;
    }
}
