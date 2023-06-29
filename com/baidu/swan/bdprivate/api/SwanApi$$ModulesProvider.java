package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.b42;
import com.baidu.tieba.c42;
import com.baidu.tieba.d02;
import com.baidu.tieba.d42;
import com.baidu.tieba.je2;
import com.baidu.tieba.jt3;
import com.baidu.tieba.kt3;
import com.baidu.tieba.lt3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final d02 d02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                jt3 jt3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof jt3)) {
                    jt3Var = (jt3) obj;
                } else {
                    jt3Var = new jt3(this.mSwanApiContext);
                    this.mApis.put("446653951", jt3Var);
                }
                Pair<Boolean, b42> a = d42.a(jt3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = jt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                kt3 kt3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof kt3)) {
                    kt3Var = (kt3) obj;
                } else {
                    kt3Var = new kt3(this.mSwanApiContext);
                    this.mApis.put("-404108695", kt3Var);
                }
                Pair<Boolean, b42> a = d42.a(kt3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = kt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                lt3 lt3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof lt3)) {
                    lt3Var = (lt3) obj;
                } else {
                    lt3Var = new lt3(this.mSwanApiContext);
                    this.mApis.put("1495818240", lt3Var);
                }
                Pair<Boolean, b42> a = d42.a(lt3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = lt3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                lt3 lt3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof lt3)) {
                    lt3Var = (lt3) obj;
                } else {
                    lt3Var = new lt3(this.mSwanApiContext);
                    this.mApis.put("1495818240", lt3Var);
                }
                Pair<Boolean, b42> a = d42.a(lt3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = lt3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final d02 d02Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                jt3 jt3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof jt3)) {
                    jt3Var = (jt3) obj;
                } else {
                    jt3Var = new jt3(this.mSwanApiContext);
                    this.mApis.put("446653951", jt3Var);
                }
                Pair<Boolean, b42> a = d42.a(jt3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = jt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(d02Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d02 mSwanApiContext;

            {
                this.mSwanApiContext = d02Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                kt3 kt3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof kt3)) {
                    kt3Var = (kt3) obj;
                } else {
                    kt3Var = new kt3(this.mSwanApiContext);
                    this.mApis.put("-404108695", kt3Var);
                }
                Pair<Boolean, b42> a = d42.a(kt3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 y = kt3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                lt3 lt3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof lt3)) {
                    lt3Var = (lt3) obj;
                } else {
                    lt3Var = new lt3(this.mSwanApiContext);
                    this.mApis.put("1495818240", lt3Var);
                }
                Pair<Boolean, b42> a = d42.a(lt3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 F = lt3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                lt3 lt3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof lt3)) {
                    lt3Var = (lt3) obj;
                } else {
                    lt3Var = new lt3(this.mSwanApiContext);
                    this.mApis.put("1495818240", lt3Var);
                }
                Pair<Boolean, b42> a = d42.a(lt3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((b42) a.second).a();
                }
                if (je2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new c42(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                c42 G = lt3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
