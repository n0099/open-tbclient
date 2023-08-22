package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.c32;
import com.baidu.tieba.d32;
import com.baidu.tieba.e32;
import com.baidu.tieba.ez1;
import com.baidu.tieba.kd2;
import com.baidu.tieba.ks3;
import com.baidu.tieba.ls3;
import com.baidu.tieba.ms3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final ez1 ez1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ks3 ks3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ks3)) {
                    ks3Var = (ks3) obj;
                } else {
                    ks3Var = new ks3(this.mSwanApiContext);
                    this.mApis.put("446653951", ks3Var);
                }
                Pair<Boolean, c32> a = e32.a(ks3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = ks3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                ls3 ls3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof ls3)) {
                    ls3Var = (ls3) obj;
                } else {
                    ls3Var = new ls3(this.mSwanApiContext);
                    this.mApis.put("-404108695", ls3Var);
                }
                Pair<Boolean, c32> a = e32.a(ls3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = ls3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ms3 ms3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ms3)) {
                    ms3Var = (ms3) obj;
                } else {
                    ms3Var = new ms3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ms3Var);
                }
                Pair<Boolean, c32> a = e32.a(ms3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = ms3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ms3 ms3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ms3)) {
                    ms3Var = (ms3) obj;
                } else {
                    ms3Var = new ms3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ms3Var);
                }
                Pair<Boolean, c32> a = e32.a(ms3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = ms3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final ez1 ez1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ks3 ks3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ks3)) {
                    ks3Var = (ks3) obj;
                } else {
                    ks3Var = new ks3(this.mSwanApiContext);
                    this.mApis.put("446653951", ks3Var);
                }
                Pair<Boolean, c32> a = e32.a(ks3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = ks3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(ez1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public ez1 mSwanApiContext;

            {
                this.mSwanApiContext = ez1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                ls3 ls3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof ls3)) {
                    ls3Var = (ls3) obj;
                } else {
                    ls3Var = new ls3(this.mSwanApiContext);
                    this.mApis.put("-404108695", ls3Var);
                }
                Pair<Boolean, c32> a = e32.a(ls3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 y = ls3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ms3 ms3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ms3)) {
                    ms3Var = (ms3) obj;
                } else {
                    ms3Var = new ms3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ms3Var);
                }
                Pair<Boolean, c32> a = e32.a(ms3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 F = ms3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ms3 ms3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ms3)) {
                    ms3Var = (ms3) obj;
                } else {
                    ms3Var = new ms3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ms3Var);
                }
                Pair<Boolean, c32> a = e32.a(ms3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((c32) a.second).a();
                }
                if (kd2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new d32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                d32 G = ms3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
