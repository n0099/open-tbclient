package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.ea2;
import com.baidu.tieba.ep3;
import com.baidu.tieba.fp3;
import com.baidu.tieba.gp3;
import com.baidu.tieba.wz1;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yv1;
import com.baidu.tieba.yz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final yv1 yv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ep3 ep3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ep3)) {
                    ep3Var = (ep3) obj;
                } else {
                    ep3Var = new ep3(this.mSwanApiContext);
                    this.mApis.put("446653951", ep3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ep3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = ep3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                fp3 fp3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof fp3)) {
                    fp3Var = (fp3) obj;
                } else {
                    fp3Var = new fp3(this.mSwanApiContext);
                    this.mApis.put("-404108695", fp3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fp3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = fp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                gp3 gp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof gp3)) {
                    gp3Var = (gp3) obj;
                } else {
                    gp3Var = new gp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", gp3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gp3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = gp3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                gp3 gp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof gp3)) {
                    gp3Var = (gp3) obj;
                } else {
                    gp3Var = new gp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", gp3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gp3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = gp3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final yv1 yv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                ep3 ep3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof ep3)) {
                    ep3Var = (ep3) obj;
                } else {
                    ep3Var = new ep3(this.mSwanApiContext);
                    this.mApis.put("446653951", ep3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(ep3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = ep3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(yv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public yv1 mSwanApiContext;

            {
                this.mSwanApiContext = yv1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                fp3 fp3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof fp3)) {
                    fp3Var = (fp3) obj;
                } else {
                    fp3Var = new fp3(this.mSwanApiContext);
                    this.mApis.put("-404108695", fp3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(fp3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 y = fp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                gp3 gp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof gp3)) {
                    gp3Var = (gp3) obj;
                } else {
                    gp3Var = new gp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", gp3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gp3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 F = gp3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                gp3 gp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof gp3)) {
                    gp3Var = (gp3) obj;
                } else {
                    gp3Var = new gp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", gp3Var);
                }
                Pair<Boolean, wz1> a = yz1.a(gp3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((wz1) a.second).a();
                }
                if (ea2.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new xz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                xz1 G = gp3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
