package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.ky1;
import com.baidu.tieba.ly1;
import com.baidu.tieba.mu1;
import com.baidu.tieba.my1;
import com.baidu.tieba.r82;
import com.baidu.tieba.rn3;
import com.baidu.tieba.sn3;
import com.baidu.tieba.tn3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final mu1 mu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                rn3 rn3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof rn3)) {
                    rn3Var = (rn3) obj;
                } else {
                    rn3Var = new rn3(this.mSwanApiContext);
                    this.mApis.put("446653951", rn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(rn3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = rn3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                sn3 sn3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof sn3)) {
                    sn3Var = (sn3) obj;
                } else {
                    sn3Var = new sn3(this.mSwanApiContext);
                    this.mApis.put("-404108695", sn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(sn3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = sn3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                tn3 tn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof tn3)) {
                    tn3Var = (tn3) obj;
                } else {
                    tn3Var = new tn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", tn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(tn3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = tn3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                tn3 tn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof tn3)) {
                    tn3Var = (tn3) obj;
                } else {
                    tn3Var = new tn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", tn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(tn3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = tn3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final mu1 mu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                rn3 rn3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof rn3)) {
                    rn3Var = (rn3) obj;
                } else {
                    rn3Var = new rn3(this.mSwanApiContext);
                    this.mApis.put("446653951", rn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(rn3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = rn3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(mu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public mu1 mSwanApiContext;

            {
                this.mSwanApiContext = mu1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                sn3 sn3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof sn3)) {
                    sn3Var = (sn3) obj;
                } else {
                    sn3Var = new sn3(this.mSwanApiContext);
                    this.mApis.put("-404108695", sn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(sn3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 z = sn3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                tn3 tn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof tn3)) {
                    tn3Var = (tn3) obj;
                } else {
                    tn3Var = new tn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", tn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(tn3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 G = tn3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                tn3 tn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof tn3)) {
                    tn3Var = (tn3) obj;
                } else {
                    tn3Var = new tn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", tn3Var);
                }
                Pair<Boolean, ky1> a = my1.a(tn3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((ky1) a.second).a();
                }
                if (r82.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new ly1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                ly1 H = tn3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
