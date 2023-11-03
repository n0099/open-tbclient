package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.gy1;
import com.baidu.tieba.hy1;
import com.baidu.tieba.iu1;
import com.baidu.tieba.iy1;
import com.baidu.tieba.n82;
import com.baidu.tieba.nn3;
import com.baidu.tieba.on3;
import com.baidu.tieba.pn3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final iu1 iu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                nn3 nn3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof nn3)) {
                    nn3Var = (nn3) obj;
                } else {
                    nn3Var = new nn3(this.mSwanApiContext);
                    this.mApis.put("446653951", nn3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(nn3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = nn3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                on3 on3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof on3)) {
                    on3Var = (on3) obj;
                } else {
                    on3Var = new on3(this.mSwanApiContext);
                    this.mApis.put("-404108695", on3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(on3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = on3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                pn3 pn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pn3)) {
                    pn3Var = (pn3) obj;
                } else {
                    pn3Var = new pn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pn3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pn3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = pn3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                pn3 pn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pn3)) {
                    pn3Var = (pn3) obj;
                } else {
                    pn3Var = new pn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pn3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pn3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = pn3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final iu1 iu1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                nn3 nn3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof nn3)) {
                    nn3Var = (nn3) obj;
                } else {
                    nn3Var = new nn3(this.mSwanApiContext);
                    this.mApis.put("446653951", nn3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(nn3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = nn3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(iu1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public iu1 mSwanApiContext;

            {
                this.mSwanApiContext = iu1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                on3 on3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof on3)) {
                    on3Var = (on3) obj;
                } else {
                    on3Var = new on3(this.mSwanApiContext);
                    this.mApis.put("-404108695", on3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(on3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 z = on3Var.z(str);
                if (z == null) {
                    return "";
                }
                return z.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                pn3 pn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pn3)) {
                    pn3Var = (pn3) obj;
                } else {
                    pn3Var = new pn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pn3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pn3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 G = pn3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                pn3 pn3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof pn3)) {
                    pn3Var = (pn3) obj;
                } else {
                    pn3Var = new pn3(this.mSwanApiContext);
                    this.mApis.put("1495818240", pn3Var);
                }
                Pair<Boolean, gy1> a = iy1.a(pn3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((gy1) a.second).a();
                }
                if (n82.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                    return new hy1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                hy1 H = pn3Var.H(str);
                if (H == null) {
                    return "";
                }
                return H.a();
            }
        });
        return hashMap;
    }
}
