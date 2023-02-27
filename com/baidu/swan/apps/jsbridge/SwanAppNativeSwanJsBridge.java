package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.k82;
import com.baidu.tieba.l53;
import com.baidu.tieba.m62;
import com.baidu.tieba.n03;
import com.baidu.tieba.ql3;
import com.baidu.tieba.wp1;
import com.baidu.tieba.wt2;
import com.baidu.tieba.zl3;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = wp1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public k82 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return "swan/web";
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return wt2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = n03.b();
        m62.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        k82 k82Var = this.mJSContainer;
        if (k82Var == null || !(k82Var instanceof NgWebView) || !((NgWebView) k82Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(k82 k82Var) {
        this.mJSContainer = k82Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (l53.p()) {
                return zl3.d(i, getClassify());
            }
            return "";
        }
        String d = zl3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                ql3.c(zl3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                zl3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            ql3.d();
        }
        return d;
    }
}
