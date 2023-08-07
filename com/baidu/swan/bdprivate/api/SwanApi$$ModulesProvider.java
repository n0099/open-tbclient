package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.fd2;
import com.baidu.tieba.fs3;
import com.baidu.tieba.gs3;
import com.baidu.tieba.hs3;
import com.baidu.tieba.x22;
import com.baidu.tieba.y22;
import com.baidu.tieba.z22;
import com.baidu.tieba.zy1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final zy1 zy1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                fs3 fs3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof fs3)) {
                    fs3Var = (fs3) obj;
                } else {
                    fs3Var = new fs3(this.mSwanApiContext);
                    this.mApis.put("446653951", fs3Var);
                }
                Pair<Boolean, x22> a = z22.a(fs3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = fs3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                gs3 gs3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof gs3)) {
                    gs3Var = (gs3) obj;
                } else {
                    gs3Var = new gs3(this.mSwanApiContext);
                    this.mApis.put("-404108695", gs3Var);
                }
                Pair<Boolean, x22> a = z22.a(gs3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = gs3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                hs3 hs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof hs3)) {
                    hs3Var = (hs3) obj;
                } else {
                    hs3Var = new hs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", hs3Var);
                }
                Pair<Boolean, x22> a = z22.a(hs3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = hs3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                hs3 hs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof hs3)) {
                    hs3Var = (hs3) obj;
                } else {
                    hs3Var = new hs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", hs3Var);
                }
                Pair<Boolean, x22> a = z22.a(hs3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = hs3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final zy1 zy1Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                fs3 fs3Var;
                Object obj = this.mApis.get("446653951");
                if (obj != null && (obj instanceof fs3)) {
                    fs3Var = (fs3) obj;
                } else {
                    fs3Var = new fs3(this.mSwanApiContext);
                    this.mApis.put("446653951", fs3Var);
                }
                Pair<Boolean, x22> a = z22.a(fs3Var, "swanAPI/getBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateAccount.getBDUSS")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = fs3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(zy1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = false;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public zy1 mSwanApiContext;

            {
                this.mSwanApiContext = zy1Var;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                gs3 gs3Var;
                Object obj = this.mApis.get("-404108695");
                if (obj != null && (obj instanceof gs3)) {
                    gs3Var = (gs3) obj;
                } else {
                    gs3Var = new gs3(this.mSwanApiContext);
                    this.mApis.put("-404108695", gs3Var);
                }
                Pair<Boolean, x22> a = z22.a(gs3Var, "swanAPI/getOpenBDUSS");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateBusiness.getOpenBDUSS")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 y = gs3Var.y(str);
                if (y == null) {
                    return "";
                }
                return y.a();
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                hs3 hs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof hs3)) {
                    hs3Var = (hs3) obj;
                } else {
                    hs3Var = new hs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", hs3Var);
                }
                Pair<Boolean, x22> a = z22.a(hs3Var, "swanAPI/queryQuickLoginInfo");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateBusiness.queryQuickLoginInfo")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 F = hs3Var.F(str);
                if (F == null) {
                    return "";
                }
                return F.a();
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                hs3 hs3Var;
                Object obj = this.mApis.get("1495818240");
                if (obj != null && (obj instanceof hs3)) {
                    hs3Var = (hs3) obj;
                } else {
                    hs3Var = new hs3(this.mSwanApiContext);
                    this.mApis.put("1495818240", hs3Var);
                }
                Pair<Boolean, x22> a = z22.a(hs3Var, "swanAPI/quickLogin");
                if (((Boolean) a.first).booleanValue()) {
                    return ((x22) a.second).a();
                }
                if (fd2.a(this.mSwanApiContext.d(), "PrivateBusiness.quickLogin")) {
                    return new y22(1001, "illegal swanApp, intercept for preload/prefetch").a();
                }
                y22 G = hs3Var.G(str);
                if (G == null) {
                    return "";
                }
                return G.a();
            }
        });
        return hashMap;
    }
}
