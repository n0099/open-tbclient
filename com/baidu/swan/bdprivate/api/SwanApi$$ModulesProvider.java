package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.f32;
import com.baidu.tieba.g32;
import com.baidu.tieba.h32;
import com.baidu.tieba.hz1;
import com.baidu.tieba.nd2;
import com.baidu.tieba.ns3;
import com.baidu.tieba.os3;
import com.baidu.tieba.ps3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final hz1 hz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(hz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hz1 mSwanApiContext;

            {
                this.mSwanApiContext = hz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ns3 ns3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ns3)) {
                    ns3Var = (ns3) obj;
                } else {
                    ns3Var = new ns3(this.mSwanApiContext);
                    this.mApis.put("446653951", ns3Var);
                }
                Pair<Boolean, f32> a = h32.a(ns3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 y = ns3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(hz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hz1 mSwanApiContext;

            {
                this.mSwanApiContext = hz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                os3 os3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof os3)) {
                    os3Var = (os3) obj;
                } else {
                    os3Var = new os3(this.mSwanApiContext);
                    this.mApis.put("-404108695", os3Var);
                }
                Pair<Boolean, f32> a = h32.a(os3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 y = os3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ps3 ps3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ps3)) {
                    ps3Var = (ps3) obj;
                } else {
                    ps3Var = new ps3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ps3Var);
                }
                Pair<Boolean, f32> a = h32.a(ps3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 F = ps3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ps3 ps3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ps3)) {
                    ps3Var = (ps3) obj;
                } else {
                    ps3Var = new ps3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ps3Var);
                }
                Pair<Boolean, f32> a = h32.a(ps3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 G = ps3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final hz1 hz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(hz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hz1 mSwanApiContext;

            {
                this.mSwanApiContext = hz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ns3 ns3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ns3)) {
                    ns3Var = (ns3) obj;
                } else {
                    ns3Var = new ns3(this.mSwanApiContext);
                    this.mApis.put("446653951", ns3Var);
                }
                Pair<Boolean, f32> a = h32.a(ns3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 y = ns3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(hz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public hz1 mSwanApiContext;

            {
                this.mSwanApiContext = hz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                os3 os3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof os3)) {
                    os3Var = (os3) obj;
                } else {
                    os3Var = new os3(this.mSwanApiContext);
                    this.mApis.put("-404108695", os3Var);
                }
                Pair<Boolean, f32> a = h32.a(os3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 y = os3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                ps3 ps3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ps3)) {
                    ps3Var = (ps3) obj;
                } else {
                    ps3Var = new ps3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ps3Var);
                }
                Pair<Boolean, f32> a = h32.a(ps3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 F = ps3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                ps3 ps3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof ps3)) {
                    ps3Var = (ps3) obj;
                } else {
                    ps3Var = new ps3(this.mSwanApiContext);
                    this.mApis.put("1495818240", ps3Var);
                }
                Pair<Boolean, f32> a = h32.a(ps3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((f32) a.second).a();
                }
                if (nd2.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new g32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                g32 G = ps3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
