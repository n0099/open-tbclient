package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.ba2;
import com.baidu.tieba.c73;
import com.baidu.tieba.d82;
import com.baidu.tieba.e23;
import com.baidu.tieba.hn3;
import com.baidu.tieba.nr1;
import com.baidu.tieba.nv2;
import com.baidu.tieba.qn3;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = nr1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public ba2 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return SchemeCollecter.CLASSIFY_SWAN_WEB;
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return nv2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = e23.b();
        d82.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        ba2 ba2Var = this.mJSContainer;
        if (ba2Var == null || !(ba2Var instanceof NgWebView) || !((NgWebView) ba2Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(ba2 ba2Var) {
        this.mJSContainer = ba2Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (c73.p()) {
                return qn3.d(i, getClassify());
            }
            return "";
        }
        String d = qn3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                hn3.c(qn3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                qn3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            hn3.d();
        }
        return d;
    }
}
