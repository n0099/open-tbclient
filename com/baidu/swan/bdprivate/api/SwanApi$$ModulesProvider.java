package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.f12;
import com.baidu.tieba.g12;
import com.baidu.tieba.h12;
import com.baidu.tieba.hx1;
import com.baidu.tieba.nb2;
import com.baidu.tieba.nq3;
import com.baidu.tieba.oq3;
import com.baidu.tieba.pq3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final hx1 hx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                nq3 nq3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof nq3)) {
                    nq3Var = (nq3) obj;
                } else {
                    nq3Var = new nq3(this.mSwanApiContext);
                    this.mApis.put("446653951", nq3Var);
                }
                Pair<Boolean, f12> a = h12.a(nq3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = nq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                oq3 oq3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof oq3)) {
                    oq3Var = (oq3) obj;
                } else {
                    oq3Var = new oq3(this.mSwanApiContext);
                    this.mApis.put("-404108695", oq3Var);
                }
                Pair<Boolean, f12> a = h12.a(oq3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = oq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                pq3 pq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pq3)) {
                    pq3Var = (pq3) obj;
                } else {
                    pq3Var = new pq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pq3Var);
                }
                Pair<Boolean, f12> a = h12.a(pq3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = pq3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                pq3 pq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pq3)) {
                    pq3Var = (pq3) obj;
                } else {
                    pq3Var = new pq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pq3Var);
                }
                Pair<Boolean, f12> a = h12.a(pq3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = pq3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final hx1 hx1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                nq3 nq3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof nq3)) {
                    nq3Var = (nq3) obj;
                } else {
                    nq3Var = new nq3(this.mSwanApiContext);
                    this.mApis.put("446653951", nq3Var);
                }
                Pair<Boolean, f12> a = h12.a(nq3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = nq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(hx1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hx1 mSwanApiContext;

            {
                this.mSwanApiContext = hx1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                oq3 oq3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof oq3)) {
                    oq3Var = (oq3) obj;
                } else {
                    oq3Var = new oq3(this.mSwanApiContext);
                    this.mApis.put("-404108695", oq3Var);
                }
                Pair<Boolean, f12> a = h12.a(oq3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 y = oq3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                pq3 pq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pq3)) {
                    pq3Var = (pq3) obj;
                } else {
                    pq3Var = new pq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pq3Var);
                }
                Pair<Boolean, f12> a = h12.a(pq3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 F = pq3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                pq3 pq3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pq3)) {
                    pq3Var = (pq3) obj;
                } else {
                    pq3Var = new pq3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pq3Var);
                }
                Pair<Boolean, f12> a = h12.a(pq3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f12) a.second).a();
                }
                if (nb2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new g12(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g12 G = pq3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
