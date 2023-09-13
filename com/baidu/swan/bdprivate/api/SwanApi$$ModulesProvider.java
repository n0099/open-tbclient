package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.g32;
import com.baidu.tieba.h32;
import com.baidu.tieba.i32;
import com.baidu.tieba.iz1;
import com.baidu.tieba.od2;
import com.baidu.tieba.os3;
import com.baidu.tieba.ps3;
import com.baidu.tieba.qs3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final iz1 iz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                os3 os3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof os3)) {
                    os3Var = (os3) obj;
                } else {
                    os3Var = new os3(this.mSwanApiContext);
                    this.mApis.put("446653951", os3Var);
                }
                Pair<Boolean, g32> a = i32.a(os3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = os3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                ps3 ps3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof ps3)) {
                    ps3Var = (ps3) obj;
                } else {
                    ps3Var = new ps3(this.mSwanApiContext);
                    this.mApis.put("-404108695", ps3Var);
                }
                Pair<Boolean, g32> a = i32.a(ps3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = ps3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                qs3 qs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof qs3)) {
                    qs3Var = (qs3) obj;
                } else {
                    qs3Var = new qs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", qs3Var);
                }
                Pair<Boolean, g32> a = i32.a(qs3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = qs3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                qs3 qs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof qs3)) {
                    qs3Var = (qs3) obj;
                } else {
                    qs3Var = new qs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", qs3Var);
                }
                Pair<Boolean, g32> a = i32.a(qs3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = qs3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final iz1 iz1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                os3 os3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof os3)) {
                    os3Var = (os3) obj;
                } else {
                    os3Var = new os3(this.mSwanApiContext);
                    this.mApis.put("446653951", os3Var);
                }
                Pair<Boolean, g32> a = i32.a(os3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = os3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(iz1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iz1 mSwanApiContext;

            {
                this.mSwanApiContext = iz1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                ps3 ps3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof ps3)) {
                    ps3Var = (ps3) obj;
                } else {
                    ps3Var = new ps3(this.mSwanApiContext);
                    this.mApis.put("-404108695", ps3Var);
                }
                Pair<Boolean, g32> a = i32.a(ps3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 y = ps3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                qs3 qs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof qs3)) {
                    qs3Var = (qs3) obj;
                } else {
                    qs3Var = new qs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", qs3Var);
                }
                Pair<Boolean, g32> a = i32.a(qs3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 F = qs3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                qs3 qs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof qs3)) {
                    qs3Var = (qs3) obj;
                } else {
                    qs3Var = new qs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", qs3Var);
                }
                Pair<Boolean, g32> a = i32.a(qs3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((g32) a.second).a();
                }
                if (od2.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new h32(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                h32 G = qs3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
