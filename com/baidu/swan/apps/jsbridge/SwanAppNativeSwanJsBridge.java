package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.fs1;
import com.baidu.tieba.fw2;
import com.baidu.tieba.io3;
import com.baidu.tieba.ta2;
import com.baidu.tieba.u73;
import com.baidu.tieba.v82;
import com.baidu.tieba.w23;
import com.baidu.tieba.zn3;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = fs1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public ta2 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return SchemeCollecter.CLASSIFY_SWAN_WEB;
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return fw2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = w23.b();
        v82.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        ta2 ta2Var = this.mJSContainer;
        if (ta2Var == null || !(ta2Var instanceof NgWebView) || !((NgWebView) ta2Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(ta2 ta2Var) {
        this.mJSContainer = ta2Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (u73.p()) {
                return io3.d(i, getClassify());
            }
            return "";
        }
        String d = io3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                zn3.c(io3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                io3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            zn3.d();
        }
        return d;
    }
}
