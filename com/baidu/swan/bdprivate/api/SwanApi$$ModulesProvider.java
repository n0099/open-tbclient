package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.aa2;
import com.baidu.tieba.ap3;
import com.baidu.tieba.bp3;
import com.baidu.tieba.cp3;
import com.baidu.tieba.sz1;
import com.baidu.tieba.tz1;
import com.baidu.tieba.uv1;
import com.baidu.tieba.uz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final uv1 uv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ap3 ap3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ap3)) {
                    ap3Var = (ap3) obj;
                } else {
                    ap3Var = new ap3(this.mSwanApiContext);
                    this.mApis.put("446653951", ap3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ap3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = ap3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                bp3 bp3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof bp3)) {
                    bp3Var = (bp3) obj;
                } else {
                    bp3Var = new bp3(this.mSwanApiContext);
                    this.mApis.put("-404108695", bp3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bp3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = bp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                cp3 cp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof cp3)) {
                    cp3Var = (cp3) obj;
                } else {
                    cp3Var = new cp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", cp3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cp3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = cp3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                cp3 cp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof cp3)) {
                    cp3Var = (cp3) obj;
                } else {
                    cp3Var = new cp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", cp3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cp3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = cp3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final uv1 uv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ap3 ap3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ap3)) {
                    ap3Var = (ap3) obj;
                } else {
                    ap3Var = new ap3(this.mSwanApiContext);
                    this.mApis.put("446653951", ap3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(ap3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = ap3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(uv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public uv1 mSwanApiContext;

            {
                this.mSwanApiContext = uv1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                bp3 bp3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof bp3)) {
                    bp3Var = (bp3) obj;
                } else {
                    bp3Var = new bp3(this.mSwanApiContext);
                    this.mApis.put("-404108695", bp3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(bp3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 y = bp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                cp3 cp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof cp3)) {
                    cp3Var = (cp3) obj;
                } else {
                    cp3Var = new cp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", cp3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cp3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 F = cp3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                cp3 cp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof cp3)) {
                    cp3Var = (cp3) obj;
                } else {
                    cp3Var = new cp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", cp3Var);
                }
                Pair<Boolean, sz1> a = uz1.a(cp3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((sz1) a.second).a();
                }
                if (aa2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new tz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                tz1 G = cp3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
