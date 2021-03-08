package com.baidu.swan.bdprivate.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.bdprivate.api.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes8.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final com.baidu.swan.apps.api.a.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                com.baidu.swan.bdprivate.api.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateAccount.getBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof com.baidu.swan.bdprivate.api.a)) {
                        aVar = (com.baidu.swan.bdprivate.api.a) obj;
                    } else {
                        com.baidu.swan.bdprivate.api.a aVar2 = new com.baidu.swan.bdprivate.api.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uA = aVar.uA(str);
                    String jsonString = uA == null ? "" : uA.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module.1
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                com.baidu.swan.bdprivate.api.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof com.baidu.swan.bdprivate.api.b)) {
                        bVar2 = (com.baidu.swan.bdprivate.api.b) obj;
                    } else {
                        com.baidu.swan.bdprivate.api.b bVar3 = new com.baidu.swan.bdprivate.api.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uB = bVar2.uB(str);
                    String jsonString = uB == null ? "" : uB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module.1
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uE = cVar.uE(str);
                    String jsonString = uE == null ? "" : uE.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module.2
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.quickLogin[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uC = cVar.uC(str);
                    String jsonString = uC == null ? "" : uC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module.3
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                com.baidu.swan.bdprivate.extensions.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof com.baidu.swan.bdprivate.extensions.c.a)) {
                        aVar = (com.baidu.swan.bdprivate.extensions.c.a) obj;
                    } else {
                        com.baidu.swan.bdprivate.extensions.c.a aVar2 = new com.baidu.swan.bdprivate.extensions.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uL = aVar.uL(str);
                    String jsonString = uL == null ? "" : uL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsV8Module.1
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }
        });
        return hashMap;
    }

    public static Map<String, Object> getWebviewApiModules(final com.baidu.swan.apps.api.a.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                com.baidu.swan.bdprivate.api.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateAccount.getBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof com.baidu.swan.bdprivate.api.a)) {
                        aVar = (com.baidu.swan.bdprivate.api.a) obj;
                    } else {
                        com.baidu.swan.bdprivate.api.a aVar2 = new com.baidu.swan.bdprivate.api.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uA = aVar.uA(str);
                    String jsonString = uA == null ? "" : uA.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule.1
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                com.baidu.swan.bdprivate.api.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof com.baidu.swan.bdprivate.api.b)) {
                        bVar2 = (com.baidu.swan.bdprivate.api.b) obj;
                    } else {
                        com.baidu.swan.bdprivate.api.b bVar3 = new com.baidu.swan.bdprivate.api.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uB = bVar2.uB(str);
                    String jsonString = uB == null ? "" : uB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule.1
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uE = cVar.uE(str);
                    String jsonString = uE == null ? "" : uE.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule.2
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.quickLogin[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uC = cVar.uC(str);
                    String jsonString = uC == null ? "" : uC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule.3
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                com.baidu.swan.bdprivate.extensions.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof com.baidu.swan.bdprivate.extensions.c.a)) {
                        aVar = (com.baidu.swan.bdprivate.extensions.c.a) obj;
                    } else {
                        com.baidu.swan.bdprivate.extensions.c.a aVar2 = new com.baidu.swan.bdprivate.extensions.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a2 = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a2.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b uL = aVar.uL(str);
                    String jsonString = uL == null ? "" : uL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsWebviewModule.1
                            @Override // java.lang.Runnable
                            public void run() {
                                throw th;
                            }
                        });
                        return "";
                    }
                    throw th;
                }
            }
        });
        return hashMap;
    }
}
