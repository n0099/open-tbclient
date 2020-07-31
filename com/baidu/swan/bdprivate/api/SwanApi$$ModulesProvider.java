package com.baidu.swan.bdprivate.api;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.performance.a.f;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes11.dex */
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getBDUSS(String str) {
                com.baidu.swan.bdprivate.api.a aVar;
                try {
                    f.aoh().iI("getBDUSS");
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateAccount.getBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj == null || !(obj instanceof com.baidu.swan.bdprivate.api.a)) {
                        com.baidu.swan.bdprivate.api.a aVar2 = new com.baidu.swan.bdprivate.api.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.bdprivate.api.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b qV = aVar.qV(str);
                    String jsonString = qV == null ? "" : qV.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getBDUSS");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getBDUSS");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                com.baidu.swan.bdprivate.api.b bVar2;
                try {
                    f.aoh().iI("getOpenBDUSS");
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj == null || !(obj instanceof com.baidu.swan.bdprivate.api.b)) {
                        com.baidu.swan.bdprivate.api.b bVar3 = new com.baidu.swan.bdprivate.api.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.bdprivate.api.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b qW = bVar2.qW(str);
                    String jsonString = qW == null ? "" : qW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getOpenBDUSS");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getOpenBDUSS");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getBDUSS(String str) {
                com.baidu.swan.bdprivate.api.a aVar;
                try {
                    f.aoh().iI("getBDUSS");
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateAccount.getBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj == null || !(obj instanceof com.baidu.swan.bdprivate.api.a)) {
                        com.baidu.swan.bdprivate.api.a aVar2 = new com.baidu.swan.bdprivate.api.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.bdprivate.api.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b qV = aVar.qV(str);
                    String jsonString = qV == null ? "" : qV.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getBDUSS");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getBDUSS");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                com.baidu.swan.bdprivate.api.b bVar2;
                try {
                    f.aoh().iI("getOpenBDUSS");
                    if (DEBUG) {
                        Log.d(TAG, "====================PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj == null || !(obj instanceof com.baidu.swan.bdprivate.api.b)) {
                        com.baidu.swan.bdprivate.api.b bVar3 = new com.baidu.swan.bdprivate.api.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.bdprivate.api.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b qW = bVar2.qW(str);
                    String jsonString = qW == null ? "" : qW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getOpenBDUSS");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getOpenBDUSS");
                    }
                }
            }
        });
        return hashMap;
    }
}
