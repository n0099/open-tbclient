package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.ba2;
import com.baidu.tieba.bp3;
import com.baidu.tieba.cp3;
import com.baidu.tieba.dp3;
import com.baidu.tieba.tz1;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vv1;
import com.baidu.tieba.vz1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final vv1 vv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                bp3 bp3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof bp3)) {
                    bp3Var = (bp3) obj;
                } else {
                    bp3Var = new bp3(this.mSwanApiContext);
                    this.mApis.put("446653951", bp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bp3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = bp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                cp3 cp3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof cp3)) {
                    cp3Var = (cp3) obj;
                } else {
                    cp3Var = new cp3(this.mSwanApiContext);
                    this.mApis.put("-404108695", cp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cp3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = cp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                dp3 dp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof dp3)) {
                    dp3Var = (dp3) obj;
                } else {
                    dp3Var = new dp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", dp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dp3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = dp3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                dp3 dp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof dp3)) {
                    dp3Var = (dp3) obj;
                } else {
                    dp3Var = new dp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", dp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dp3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = dp3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final vv1 vv1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                bp3 bp3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof bp3)) {
                    bp3Var = (bp3) obj;
                } else {
                    bp3Var = new bp3(this.mSwanApiContext);
                    this.mApis.put("446653951", bp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(bp3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = bp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(vv1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public vv1 mSwanApiContext;

            {
                this.mSwanApiContext = vv1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                cp3 cp3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof cp3)) {
                    cp3Var = (cp3) obj;
                } else {
                    cp3Var = new cp3(this.mSwanApiContext);
                    this.mApis.put("-404108695", cp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(cp3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 y = cp3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                dp3 dp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof dp3)) {
                    dp3Var = (dp3) obj;
                } else {
                    dp3Var = new dp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", dp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dp3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 F = dp3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                dp3 dp3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof dp3)) {
                    dp3Var = (dp3) obj;
                } else {
                    dp3Var = new dp3(this.mSwanApiContext);
                    this.mApis.put("1495818240", dp3Var);
                }
                Pair<Boolean, tz1> a = vz1.a(dp3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((tz1) a.second).a();
                }
                if (ba2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                    return new uz1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                uz1 G = dp3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
