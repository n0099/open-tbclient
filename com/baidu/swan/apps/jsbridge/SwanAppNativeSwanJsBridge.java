package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.fa2;
import com.baidu.tieba.g73;
import com.baidu.tieba.h82;
import com.baidu.tieba.i23;
import com.baidu.tieba.ln3;
import com.baidu.tieba.rr1;
import com.baidu.tieba.rv2;
import com.baidu.tieba.un3;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = rr1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public fa2 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return SchemeCollecter.CLASSIFY_SWAN_WEB;
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return rv2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = i23.b();
        h82.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        fa2 fa2Var = this.mJSContainer;
        if (fa2Var == null || !(fa2Var instanceof NgWebView) || !((NgWebView) fa2Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(fa2 fa2Var) {
        this.mJSContainer = fa2Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (g73.p()) {
                return un3.d(i, getClassify());
            }
            return "";
        }
        String d = un3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                ln3.c(un3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                un3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            ln3.d();
        }
        return d;
    }
}
