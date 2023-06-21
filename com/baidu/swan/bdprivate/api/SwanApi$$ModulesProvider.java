package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.a02;
import com.baidu.tieba.a42;
import com.baidu.tieba.ge2;
import com.baidu.tieba.gt3;
import com.baidu.tieba.ht3;
import com.baidu.tieba.it3;
import com.baidu.tieba.y32;
import com.baidu.tieba.z32;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final a02 a02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                gt3 gt3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof gt3)) {
                    gt3Var = (gt3) obj;
                } else {
                    gt3Var = new gt3(this.mSwanApiContext);
                    this.mApis.put("446653951", gt3Var);
                }
                Pair<Boolean, y32> a = a42.a(gt3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = gt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                ht3 ht3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof ht3)) {
                    ht3Var = (ht3) obj;
                } else {
                    ht3Var = new ht3(this.mSwanApiContext);
                    this.mApis.put("-404108695", ht3Var);
                }
                Pair<Boolean, y32> a = a42.a(ht3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = ht3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                it3 it3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof it3)) {
                    it3Var = (it3) obj;
                } else {
                    it3Var = new it3(this.mSwanApiContext);
                    this.mApis.put("1495818240", it3Var);
                }
                Pair<Boolean, y32> a = a42.a(it3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = it3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                it3 it3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof it3)) {
                    it3Var = (it3) obj;
                } else {
                    it3Var = new it3(this.mSwanApiContext);
                    this.mApis.put("1495818240", it3Var);
                }
                Pair<Boolean, y32> a = a42.a(it3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = it3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final a02 a02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                gt3 gt3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof gt3)) {
                    gt3Var = (gt3) obj;
                } else {
                    gt3Var = new gt3(this.mSwanApiContext);
                    this.mApis.put("446653951", gt3Var);
                }
                Pair<Boolean, y32> a = a42.a(gt3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = gt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(a02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public a02 mSwanApiContext;

            {
                this.mSwanApiContext = a02Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                ht3 ht3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof ht3)) {
                    ht3Var = (ht3) obj;
                } else {
                    ht3Var = new ht3(this.mSwanApiContext);
                    this.mApis.put("-404108695", ht3Var);
                }
                Pair<Boolean, y32> a = a42.a(ht3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 y = ht3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                it3 it3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof it3)) {
                    it3Var = (it3) obj;
                } else {
                    it3Var = new it3(this.mSwanApiContext);
                    this.mApis.put("1495818240", it3Var);
                }
                Pair<Boolean, y32> a = a42.a(it3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 F = it3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                it3 it3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof it3)) {
                    it3Var = (it3) obj;
                } else {
                    it3Var = new it3(this.mSwanApiContext);
                    this.mApis.put("1495818240", it3Var);
                }
                Pair<Boolean, y32> a = a42.a(it3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((y32) a.second).a();
                }
                if (ge2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new z32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                z32 G = it3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
