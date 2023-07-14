package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.ce2;
import com.baidu.tieba.ct3;
import com.baidu.tieba.dt3;
import com.baidu.tieba.et3;
import com.baidu.tieba.u32;
import com.baidu.tieba.v32;
import com.baidu.tieba.w32;
import com.baidu.tieba.wz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final wz1 wz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ct3 ct3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ct3)) {
                    ct3Var = (ct3) obj;
                } else {
                    ct3Var = new ct3(this.mSwanApiContext);
                    this.mApis.put("446653951", ct3Var);
                }
                Pair<Boolean, u32> a = w32.a(ct3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = ct3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                dt3 dt3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof dt3)) {
                    dt3Var = (dt3) obj;
                } else {
                    dt3Var = new dt3(this.mSwanApiContext);
                    this.mApis.put("-404108695", dt3Var);
                }
                Pair<Boolean, u32> a = w32.a(dt3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = dt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                et3 et3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof et3)) {
                    et3Var = (et3) obj;
                } else {
                    et3Var = new et3(this.mSwanApiContext);
                    this.mApis.put("1495818240", et3Var);
                }
                Pair<Boolean, u32> a = w32.a(et3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = et3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                et3 et3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof et3)) {
                    et3Var = (et3) obj;
                } else {
                    et3Var = new et3(this.mSwanApiContext);
                    this.mApis.put("1495818240", et3Var);
                }
                Pair<Boolean, u32> a = w32.a(et3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = et3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final wz1 wz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ct3 ct3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ct3)) {
                    ct3Var = (ct3) obj;
                } else {
                    ct3Var = new ct3(this.mSwanApiContext);
                    this.mApis.put("446653951", ct3Var);
                }
                Pair<Boolean, u32> a = w32.a(ct3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = ct3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(wz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public wz1 mSwanApiContext;

            {
                this.mSwanApiContext = wz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                dt3 dt3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof dt3)) {
                    dt3Var = (dt3) obj;
                } else {
                    dt3Var = new dt3(this.mSwanApiContext);
                    this.mApis.put("-404108695", dt3Var);
                }
                Pair<Boolean, u32> a = w32.a(dt3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 y = dt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                et3 et3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof et3)) {
                    et3Var = (et3) obj;
                } else {
                    et3Var = new et3(this.mSwanApiContext);
                    this.mApis.put("1495818240", et3Var);
                }
                Pair<Boolean, u32> a = w32.a(et3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 F = et3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                et3 et3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof et3)) {
                    et3Var = (et3) obj;
                } else {
                    et3Var = new et3(this.mSwanApiContext);
                    this.mApis.put("1495818240", et3Var);
                }
                Pair<Boolean, u32> a = w32.a(et3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((u32) a.second).a();
                }
                if (ce2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new v32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                v32 G = et3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
