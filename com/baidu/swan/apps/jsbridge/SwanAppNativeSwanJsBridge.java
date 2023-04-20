package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.fo1;
import com.baidu.tieba.fs2;
import com.baidu.tieba.ik3;
import com.baidu.tieba.t62;
import com.baidu.tieba.u33;
import com.baidu.tieba.v42;
import com.baidu.tieba.wy2;
import com.baidu.tieba.zj3;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = fo1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public t62 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return "swan/web";
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return fs2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = wy2.b();
        v42.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        t62 t62Var = this.mJSContainer;
        if (t62Var == null || !(t62Var instanceof NgWebView) || !((NgWebView) t62Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(t62 t62Var) {
        this.mJSContainer = t62Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (u33.p()) {
                return ik3.d(i, getClassify());
            }
            return "";
        }
        String d = ik3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                zj3.c(ik3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                ik3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            zj3.d();
        }
        return d;
    }
}
