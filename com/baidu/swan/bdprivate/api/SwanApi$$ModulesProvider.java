package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.fe2;
import com.baidu.tieba.ft3;
import com.baidu.tieba.gt3;
import com.baidu.tieba.ht3;
import com.baidu.tieba.x32;
import com.baidu.tieba.y32;
import com.baidu.tieba.z32;
import com.baidu.tieba.zz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final zz1 zz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(zz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zz1 mSwanApiContext;

            {
                this.mSwanApiContext = zz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ft3 ft3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ft3)) {
                    ft3Var = (ft3) obj;
                } else {
                    ft3Var = new ft3(this.mSwanApiContext);
                    this.mApis.put("446653951", ft3Var);
                }
                Pair<Boolean, x32> a = z32.a(ft3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 y = ft3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(zz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zz1 mSwanApiContext;

            {
                this.mSwanApiContext = zz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                gt3 gt3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof gt3)) {
                    gt3Var = (gt3) obj;
                } else {
                    gt3Var = new gt3(this.mSwanApiContext);
                    this.mApis.put("-404108695", gt3Var);
                }
                Pair<Boolean, x32> a = z32.a(gt3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 y = gt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ht3 ht3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ht3)) {
                    ht3Var = (ht3) obj;
                } else {
                    ht3Var = new ht3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ht3Var);
                }
                Pair<Boolean, x32> a = z32.a(ht3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 F = ht3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ht3 ht3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ht3)) {
                    ht3Var = (ht3) obj;
                } else {
                    ht3Var = new ht3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ht3Var);
                }
                Pair<Boolean, x32> a = z32.a(ht3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 G = ht3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final zz1 zz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(zz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zz1 mSwanApiContext;

            {
                this.mSwanApiContext = zz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ft3 ft3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ft3)) {
                    ft3Var = (ft3) obj;
                } else {
                    ft3Var = new ft3(this.mSwanApiContext);
                    this.mApis.put("446653951", ft3Var);
                }
                Pair<Boolean, x32> a = z32.a(ft3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 y = ft3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(zz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zz1 mSwanApiContext;

            {
                this.mSwanApiContext = zz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                gt3 gt3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof gt3)) {
                    gt3Var = (gt3) obj;
                } else {
                    gt3Var = new gt3(this.mSwanApiContext);
                    this.mApis.put("-404108695", gt3Var);
                }
                Pair<Boolean, x32> a = z32.a(gt3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 y = gt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ht3 ht3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ht3)) {
                    ht3Var = (ht3) obj;
                } else {
                    ht3Var = new ht3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ht3Var);
                }
                Pair<Boolean, x32> a = z32.a(ht3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 F = ht3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ht3 ht3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ht3)) {
                    ht3Var = (ht3) obj;
                } else {
                    ht3Var = new ht3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ht3Var);
                }
                Pair<Boolean, x32> a = z32.a(ht3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x32) a.second).a();
                }
                if (fe2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new y32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y32 G = ht3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
