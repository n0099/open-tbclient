package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.i52;
import com.baidu.tieba.j23;
import com.baidu.tieba.k32;
import com.baidu.tieba.lx2;
import com.baidu.tieba.oi3;
import com.baidu.tieba.uq2;
import com.baidu.tieba.vm1;
import com.baidu.tieba.xi3;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = vm1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public i52 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return SchemeCollecter.CLASSIFY_SWAN_WEB;
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return uq2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = lx2.b();
        k32.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        i52 i52Var = this.mJSContainer;
        if (i52Var == null || !(i52Var instanceof NgWebView) || !((NgWebView) i52Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(i52 i52Var) {
        this.mJSContainer = i52Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (j23.p()) {
                return xi3.d(i, getClassify());
            }
            return "";
        }
        String d = xi3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                oi3.c(xi3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                xi3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            oi3.d();
        }
        return d;
    }
}
