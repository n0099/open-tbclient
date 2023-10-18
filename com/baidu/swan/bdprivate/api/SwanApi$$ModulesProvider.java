package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.px1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.rt1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.w72;
import com.baidu.tieba.wm3;
import com.baidu.tieba.xm3;
import com.baidu.tieba.ym3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final rt1 rt1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                wm3 wm3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof wm3)) {
                    wm3Var = (wm3) obj;
                } else {
                    wm3Var = new wm3(this.mSwanApiContext);
                    this.mApis.put("446653951", wm3Var);
                }
                Pair<Boolean, px1> a = rx1.a(wm3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = wm3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                xm3 xm3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof xm3)) {
                    xm3Var = (xm3) obj;
                } else {
                    xm3Var = new xm3(this.mSwanApiContext);
                    this.mApis.put("-404108695", xm3Var);
                }
                Pair<Boolean, px1> a = rx1.a(xm3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = xm3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ym3 ym3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ym3)) {
                    ym3Var = (ym3) obj;
                } else {
                    ym3Var = new ym3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ym3Var);
                }
                Pair<Boolean, px1> a = rx1.a(ym3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = ym3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ym3 ym3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ym3)) {
                    ym3Var = (ym3) obj;
                } else {
                    ym3Var = new ym3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ym3Var);
                }
                Pair<Boolean, px1> a = rx1.a(ym3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = ym3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final rt1 rt1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                wm3 wm3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof wm3)) {
                    wm3Var = (wm3) obj;
                } else {
                    wm3Var = new wm3(this.mSwanApiContext);
                    this.mApis.put("446653951", wm3Var);
                }
                Pair<Boolean, px1> a = rx1.a(wm3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = wm3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(rt1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public rt1 mSwanApiContext;

            {
                this.mSwanApiContext = rt1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                xm3 xm3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof xm3)) {
                    xm3Var = (xm3) obj;
                } else {
                    xm3Var = new xm3(this.mSwanApiContext);
                    this.mApis.put("-404108695", xm3Var);
                }
                Pair<Boolean, px1> a = rx1.a(xm3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 z = xm3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ym3 ym3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ym3)) {
                    ym3Var = (ym3) obj;
                } else {
                    ym3Var = new ym3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ym3Var);
                }
                Pair<Boolean, px1> a = rx1.a(ym3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 G = ym3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ym3 ym3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ym3)) {
                    ym3Var = (ym3) obj;
                } else {
                    ym3Var = new ym3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ym3Var);
                }
                Pair<Boolean, px1> a = rx1.a(ym3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((px1) a.second).a();
                }
                if (w72.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new qx1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                qx1 H = ym3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
