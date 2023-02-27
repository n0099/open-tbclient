package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.l12;
import com.baidu.tieba.m12;
import com.baidu.tieba.n12;
import com.baidu.tieba.nx1;
import com.baidu.tieba.tb2;
import com.baidu.tieba.tq3;
import com.baidu.tieba.uq3;
import com.baidu.tieba.vq3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final nx1 nx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                tq3 tq3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof tq3)) {
                    tq3Var = (tq3) obj;
                } else {
                    tq3Var = new tq3(this.mSwanApiContext);
                    this.mApis.put("446653951", tq3Var);
                }
                Pair<Boolean, l12> a = n12.a(tq3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = tq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                uq3 uq3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof uq3)) {
                    uq3Var = (uq3) obj;
                } else {
                    uq3Var = new uq3(this.mSwanApiContext);
                    this.mApis.put("-404108695", uq3Var);
                }
                Pair<Boolean, l12> a = n12.a(uq3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = uq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                vq3 vq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof vq3)) {
                    vq3Var = (vq3) obj;
                } else {
                    vq3Var = new vq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", vq3Var);
                }
                Pair<Boolean, l12> a = n12.a(vq3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = vq3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                vq3 vq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof vq3)) {
                    vq3Var = (vq3) obj;
                } else {
                    vq3Var = new vq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", vq3Var);
                }
                Pair<Boolean, l12> a = n12.a(vq3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = vq3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final nx1 nx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                tq3 tq3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof tq3)) {
                    tq3Var = (tq3) obj;
                } else {
                    tq3Var = new tq3(this.mSwanApiContext);
                    this.mApis.put("446653951", tq3Var);
                }
                Pair<Boolean, l12> a = n12.a(tq3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = tq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(nx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public nx1 mSwanApiContext;

            {
                this.mSwanApiContext = nx1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                uq3 uq3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof uq3)) {
                    uq3Var = (uq3) obj;
                } else {
                    uq3Var = new uq3(this.mSwanApiContext);
                    this.mApis.put("-404108695", uq3Var);
                }
                Pair<Boolean, l12> a = n12.a(uq3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 y = uq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                vq3 vq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof vq3)) {
                    vq3Var = (vq3) obj;
                } else {
                    vq3Var = new vq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", vq3Var);
                }
                Pair<Boolean, l12> a = n12.a(vq3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 F = vq3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                vq3 vq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof vq3)) {
                    vq3Var = (vq3) obj;
                } else {
                    vq3Var = new vq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", vq3Var);
                }
                Pair<Boolean, l12> a = n12.a(vq3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((l12) a.second).a();
                }
                if (tb2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new m12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                m12 G = vq3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
