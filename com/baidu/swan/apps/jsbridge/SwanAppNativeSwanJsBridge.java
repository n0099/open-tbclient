package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.bk3;
import com.baidu.tieba.ho1;
import com.baidu.tieba.hs2;
import com.baidu.tieba.kk3;
import com.baidu.tieba.v62;
import com.baidu.tieba.w33;
import com.baidu.tieba.x42;
import com.baidu.tieba.yy2;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = ho1.a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public v62 mJSContainer;

    public String getClassify() {
        if (isSwanWeb()) {
            return "swan/web";
        }
        return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return hs2.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject b = yy2.b();
        x42.k(TAG, "getNACanIUseMap - " + b.toString());
        return b.toString();
    }

    public boolean isSwanWeb() {
        v62 v62Var = this.mJSContainer;
        if (v62Var == null || !(v62Var instanceof NgWebView) || !((NgWebView) v62Var).isSwanWebMode()) {
            return false;
        }
        return true;
    }

    public SwanAppNativeSwanJsBridge(v62 v62Var) {
        this.mJSContainer = v62Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        if (DEBUG) {
            if (w33.p()) {
                return kk3.d(i, getClassify());
            }
            return "";
        }
        String d = kk3.d(i, getClassify());
        if (TextUtils.isEmpty(d)) {
            if (!DEBUG) {
                bk3.c(kk3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
            } else {
                kk3.i();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
            }
        } else {
            bk3.d();
        }
        return d;
    }
}
