package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.module.e.c;
import com.baidu.swan.apps.api.module.e.e;
import com.baidu.swan.apps.api.module.e.f;
import com.baidu.swan.apps.api.module.e.g;
import com.baidu.swan.apps.api.module.e.h;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.api.module.k.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes8.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                com.baidu.swan.apps.api.module.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.checkSession[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.a)) {
                        aVar = (com.baidu.swan.apps.api.module.a.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.a aVar2 = new com.baidu.swan.apps.api.module.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iR = aVar.iR(str);
                    String jsonString = iR == null ? "" : iR.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.checkSession[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.checkSession[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module.1
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
            public String isLoginSync() {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.isLoginSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abM = bVar2.abM();
                    String jsonString = abM == null ? "" : abM.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.isLoginSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.isLoginSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module.2
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
            public String login(String str) {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.login[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iS = bVar2.iS(str);
                    String jsonString = iS == null ? "" : iS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.login[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.login[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module.3
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
        hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                com.baidu.swan.apps.api.module.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Basic.loadSubPackage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.b.a)) {
                        aVar = (com.baidu.swan.apps.api.module.b.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.b.a aVar2 = new com.baidu.swan.apps.api.module.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iT = aVar.iT(str);
                    String jsonString = iT == null ? "" : iT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Basic.loadSubPackage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Basic.loadSubPackage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module.1
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
        hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.insertBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iz = aVar.iz(str);
                    String jsonString = iz == null ? "" : iz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.1
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
            public String navigateToBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.navigateToBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iC = aVar.iC(str);
                    String jsonString = iC == null ? "" : iC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.2
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
            public String queryBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.queryBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iA = aVar.iA(str);
                    String jsonString = iA == null ? "" : iA.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.3
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
            public String updateBookshelfReadTime(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iB = aVar.iB(str);
                    String jsonString = iB == null ? "" : iB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.4
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
        hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Favorite.showFavoriteGuide[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("269275578");
                    if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                        showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                    } else {
                        ShowFavoriteGuideApi showFavoriteGuideApi2 = new ShowFavoriteGuideApi(this.mSwanApiContext);
                        this.mApis.put("269275578", showFavoriteGuideApi2);
                        showFavoriteGuideApi = showFavoriteGuideApi2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iW = showFavoriteGuideApi.iW(str);
                    String jsonString = iW == null ? "" : iW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Favorite.showFavoriteGuide[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Favorite.showFavoriteGuide[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module.1
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
        hashMap.put("_naFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                com.baidu.swan.apps.api.module.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================File.shareFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.c.a)) {
                        aVar = (com.baidu.swan.apps.api.module.c.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.c.a aVar2 = new com.baidu.swan.apps.api.module.c.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iX = aVar.iX(str);
                    String jsonString = iX == null ? "" : iX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[File.shareFile[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[File.shareFile[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module.1
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
        hashMap.put("_naGameCenter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                com.baidu.swan.apps.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.o.a)) {
                        aVar = (com.baidu.swan.apps.o.a) obj;
                    } else {
                        com.baidu.swan.apps.o.a aVar2 = new com.baidu.swan.apps.o.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mI = aVar.mI(str);
                    String jsonString = mI == null ? "" : mI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[GameCenter.postGameCenterMessage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module.1
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
            public String postGameCenterMessageSync(String str) {
                com.baidu.swan.apps.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.o.a)) {
                        aVar = (com.baidu.swan.apps.o.a) obj;
                    } else {
                        com.baidu.swan.apps.o.a aVar2 = new com.baidu.swan.apps.o.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mJ = aVar.mJ(str);
                    String jsonString = mJ == null ? "" : mJ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module.2
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
        hashMap.put("_naImage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                com.baidu.swan.apps.api.module.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Image.compressImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.d.a)) {
                        aVar = (com.baidu.swan.apps.api.module.d.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.d.a aVar2 = new com.baidu.swan.apps.api.module.d.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iZ = aVar.iZ(str);
                    String jsonString = iZ == null ? "" : iZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Image.compressImage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Image.compressImage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module.1
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
        hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jq = gVar.jq(str);
                    String jsonString = jq == null ? "" : jq.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBar[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.closeTabBar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.1
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
            public String closeTabBarRedDot(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBarRedDot[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jn = gVar.jn(str);
                    String jsonString = jn == null ? "" : jn.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.12
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
            public String hideLoading() {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abT = aVar.abT();
                    String jsonString = abT == null ? "" : abT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideLoading[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.13
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
            public String hideNavigationBarLoading(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b je = cVar.je(str);
                    String jsonString = je == null ? "" : je.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.14
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
            public String hideToast() {
                h hVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof h)) {
                        hVar = (h) obj;
                    } else {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abW = hVar.abW();
                    String jsonString = abW == null ? "" : abW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideToast[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideToast[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.15
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
            public String openMultiPicker(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jj = eVar.jj(str);
                    String jsonString = jj == null ? "" : jj.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.16
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
            public String openPicker(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ji = eVar.ji(str);
                    String jsonString = ji == null ? "" : ji.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openPicker[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.17
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
            public String openTabBar(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jp = gVar.jp(str);
                    String jsonString = jp == null ? "" : jp.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openTabBar[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openTabBar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.18
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
            public String pageScrollTo(String str) {
                com.baidu.swan.apps.api.module.e.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.pageScrollTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.d)) {
                        dVar = (com.baidu.swan.apps.api.module.e.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.d dVar2 = new com.baidu.swan.apps.api.module.e.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jg = dVar.jg(str);
                    String jsonString = jg == null ? "" : jg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.19
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
            public String setNavigationBarColor(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarColor[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jd = cVar.jd(str);
                    String jsonString = jd == null ? "" : jd.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarColor[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setNavigationBarColor[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.2
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
            public String setNavigationBarTitle(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarTitle[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jc = cVar.jc(str);
                    String jsonString = jc == null ? "" : jc.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarTitle[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setNavigationBarTitle[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.3
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
            public String setTabBarItem(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setTabBarItem[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jo = gVar.jo(str);
                    String jsonString = jo == null ? "" : jo.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setTabBarItem[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setTabBarItem[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.4
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
            public String showDatePickerView(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showDatePickerView[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jh = eVar.jh(str);
                    String jsonString = jh == null ? "" : jh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showDatePickerView[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showDatePickerView[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.5
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
            public String showLoading(String str) {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ja = aVar.ja(str);
                    String jsonString = ja == null ? "" : ja.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showLoading[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.6
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
            public String showModal(String str) {
                com.baidu.swan.apps.api.module.e.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showModal[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.e.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.b bVar3 = new com.baidu.swan.apps.api.module.e.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jb = bVar2.jb(str);
                    String jsonString = jb == null ? "" : jb.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showModal[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showModal[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.7
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
            public String showNavigationBarLoading(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jf = cVar.jf(str);
                    String jsonString = jf == null ? "" : jf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.8
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
            public String showToast(String str) {
                h hVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof h)) {
                        hVar = (h) obj;
                    } else {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jr = hVar.jr(str);
                    String jsonString = jr == null ? "" : jr.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showToast[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showToast[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.9
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
            public String stopPullDownRefresh(String str) {
                f fVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.stopPullDownRefresh[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof f)) {
                        fVar = (f) obj;
                    } else {
                        f fVar2 = new f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar2);
                        fVar = fVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jm = fVar.jm(str);
                    String jsonString = jm == null ? "" : jm.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.10
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
            public String updateMultiPicker(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.updateMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jk = eVar.jk(str);
                    String jsonString = jk == null ? "" : jk.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.11
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
        hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.getLocation[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ju = aVar.ju(str);
                    String jsonString = ju == null ? "" : ju.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.getLocation[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[LocationService.getLocation[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module.1
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
            public String startLocationUpdate(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.startLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jv = aVar.jv(str);
                    String jsonString = jv == null ? "" : jv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.startLocationUpdate[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[LocationService.startLocationUpdate[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module.2
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
            public String stopLocationUpdate() {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.stopLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abY = aVar.abY();
                    String jsonString = abY == null ? "" : abY.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.stopLocationUpdate[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[LocationService.stopLocationUpdate[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module.3
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
        hashMap.put("_naNetwork", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.cancelRequest[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.network.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.network.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.network.b bVar3 = new com.baidu.swan.apps.api.module.network.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jy = bVar2.jy(str);
                    String jsonString = jy == null ? "" : jy.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.cancelRequest[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.cancelRequest[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module.1
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
            public String getNetworkType() {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.getNetworkType[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b aca = aVar.aca();
                    String jsonString = aca == null ? "" : aca.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.getNetworkType[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.getNetworkType[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module.2
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
            public String networkStatusChange(String str) {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.networkStatusChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jx = aVar.jx(str);
                    String jsonString = jx == null ? "" : jx.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.networkStatusChange[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.networkStatusChange[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module.3
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [214=6] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    com.baidu.swan.apps.api.b.c.acz().kj("request");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.request[type:V8, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.b)) {
                        com.baidu.swan.apps.api.module.network.b bVar3 = new com.baidu.swan.apps.api.module.network.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.network.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    Pair<com.baidu.swan.apps.api.c.a, JSONObject> a2 = d.a(jsObject);
                    if (((com.baidu.swan.apps.api.c.a) a2.first).isSuccess()) {
                        JSONObject jSONObject = (JSONObject) a2.second;
                        if (jSONObject == null) {
                            return com.baidu.swan.apps.api.c.a.bYm.toJsonString();
                        }
                        if (DEBUG) {
                            Log.d(TAG, "JsObject->JSONObject: " + jSONObject.toString());
                        }
                        com.baidu.swan.apps.api.c.b au = bVar2.au(jSONObject);
                        String jsonString = au == null ? "" : au.toJsonString();
                        if (DEBUG) {
                            Log.d(TAG, "====================[[Network.request[type:V8, v8 binding:true] result]]" + jsonString);
                        }
                        return jsonString;
                    }
                    return ((com.baidu.swan.apps.api.c.a) a2.first).toJsonString();
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.request[type:V8, v8 binding:true] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            com.baidu.swan.apps.api.b.c.acz().kk("request");
                            return "";
                        }
                        throw th;
                    } finally {
                        com.baidu.swan.apps.api.b.c.acz().kk("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                com.baidu.swan.apps.ac.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ac.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ac.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ac.c.a.a aVar2 = new com.baidu.swan.apps.ac.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b px = aVar.px(str);
                    String jsonString = px == null ? "" : px.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginChooseAddress[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginChooseAddress[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module.1
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
            public String invokePluginLoginAndGetUserInfo(String str) {
                com.baidu.swan.apps.ac.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ac.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ac.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ac.c.a.a aVar2 = new com.baidu.swan.apps.ac.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b pw = aVar.pw(str);
                    String jsonString = pw == null ? "" : pw.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module.2
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
            public String invokePluginPayment(String str) {
                com.baidu.swan.apps.ac.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ac.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ac.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ac.c.a.a aVar2 = new com.baidu.swan.apps.ac.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b py = aVar.py(str);
                    String jsonString = py == null ? "" : py.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginPayment[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginPayment[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module.3
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
        hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                com.baidu.swan.apps.api.module.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateBack[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.a)) {
                        aVar = (com.baidu.swan.apps.api.module.g.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.a aVar2 = new com.baidu.swan.apps.api.module.g.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jE = aVar.jE(str);
                    String jsonString = jE == null ? "" : jE.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateBack[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.navigateBack[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.1
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
            public String navigateTo(String str) {
                com.baidu.swan.apps.api.module.g.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.g.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.b bVar3 = new com.baidu.swan.apps.api.module.g.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jF = bVar2.jF(str);
                    String jsonString = jF == null ? "" : jF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateTo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.navigateTo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.2
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
            public String reLaunch(String str) {
                com.baidu.swan.apps.api.module.g.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.reLaunch[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.d)) {
                        dVar = (com.baidu.swan.apps.api.module.g.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.d dVar2 = new com.baidu.swan.apps.api.module.g.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jH = dVar.jH(str);
                    String jsonString = jH == null ? "" : jH.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.reLaunch[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.reLaunch[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.3
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
            public String redirectTo(String str) {
                com.baidu.swan.apps.api.module.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.redirectTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.c)) {
                        cVar = (com.baidu.swan.apps.api.module.g.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.c cVar2 = new com.baidu.swan.apps.api.module.g.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jG = cVar.jG(str);
                    String jsonString = jG == null ? "" : jG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.redirectTo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.redirectTo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.4
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
        hashMap.put("_naSetting", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getAppInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acc = aVar.acc();
                    String jsonString = acc == null ? "" : acc.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getAppInfoSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getAppInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.1
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
            public String getSetting(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSetting[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jJ = aVar.jJ(str);
                    String jsonString = jJ == null ? "" : jJ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSetting[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSetting[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.2
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
            public String getSlaveIdSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSlaveIdSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acd = aVar.acd();
                    String jsonString = acd == null ? "" : acd.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSlaveIdSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSlaveIdSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.3
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
            public String getSwanId(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSwanId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jI = aVar.jI(str);
                    String jsonString = jI == null ? "" : jI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSwanId[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSwanId[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.4
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
            public String getUserInfo(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jK = aVar.jK(str);
                    String jsonString = jK == null ? "" : jK.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getUserInfo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getUserInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.5
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
        hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acf = aVar.acf();
                    String jsonString = acf == null ? "" : acf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.clearStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.1
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
            public String clearStorageSync() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ace = aVar.ace();
                    String jsonString = ace == null ? "" : ace.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.2
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
            public String getStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jQ = aVar.jQ(str);
                    String jsonString = jQ == null ? "" : jQ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.3
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
            public String getStorageInfo() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acg = aVar.acg();
                    String jsonString = acg == null ? "" : acg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.4
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
            public String getStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jP = aVar.jP(str);
                    String jsonString = jP == null ? "" : jP.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.5
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
            public String removeStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jO = aVar.jO(str);
                    String jsonString = jO == null ? "" : jO.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.removeStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.6
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
            public String removeStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jN = aVar.jN(str);
                    String jsonString = jN == null ? "" : jN.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.7
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
            public String setStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jM = aVar.jM(str);
                    String jsonString = jM == null ? "" : jM.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.setStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.8
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
            public String setStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jL = aVar.jL(str);
                    String jsonString = jL == null ? "" : jL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.setStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.9
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
        hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Subscription.subscribeService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jS = aVar.jS(str);
                    String jsonString = jS == null ? "" : jS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Subscription.subscribeService[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Subscription.subscribeService[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module.1
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
        hashMap.put("_naSystem", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.f fVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.exitFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.f)) {
                        fVar = (com.baidu.swan.apps.api.module.k.f) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.f fVar2 = new com.baidu.swan.apps.api.module.k.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar2);
                        fVar = fVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jY = fVar.jY(str);
                    String jsonString = jY == null ? "" : jY.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.exitFullScreen[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.exitFullScreen[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.1
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
            public String getBrightness() {
                com.baidu.swan.apps.api.module.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getBrightness[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.k.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.b bVar3 = new com.baidu.swan.apps.api.module.k.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b aci = bVar2.aci();
                    String jsonString = aci == null ? "" : aci.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getBrightness[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getBrightness[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.5
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
            public String getClipboardData() {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acj = cVar.acj();
                    String jsonString = acj == null ? "" : acj.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getClipboardData[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getClipboardData[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.6
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
            public String getDeviceInfo(String str) {
                com.baidu.swan.apps.api.module.k.e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getDeviceInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.e)) {
                        eVar = (com.baidu.swan.apps.api.module.k.e) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.e eVar2 = new com.baidu.swan.apps.api.module.k.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jX = eVar.jX(str);
                    String jsonString = jX == null ? "" : jX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getDeviceInfo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getDeviceInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.7
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
            public String makePhoneCall(String str) {
                com.baidu.swan.apps.api.module.k.g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.makePhoneCall[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.g)) {
                        gVar = (com.baidu.swan.apps.api.module.k.g) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.g gVar2 = new com.baidu.swan.apps.api.module.k.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jZ = gVar.jZ(str);
                    String jsonString = jZ == null ? "" : jZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.makePhoneCall[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.makePhoneCall[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.8
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
            public String openSMSPanel(String str) {
                i iVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.openSMSPanel[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof i)) {
                        iVar = (i) obj;
                    } else {
                        i iVar2 = new i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar2);
                        iVar = iVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kb = iVar.kb(str);
                    String jsonString = kb == null ? "" : kb.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.openSMSPanel[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.openSMSPanel[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.9
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
            public String requestFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.h hVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.requestFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.h)) {
                        hVar = (com.baidu.swan.apps.api.module.k.h) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.h hVar2 = new com.baidu.swan.apps.api.module.k.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ka = hVar.ka(str);
                    String jsonString = ka == null ? "" : ka.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.requestFullScreen[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.requestFullScreen[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.10
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
            public String setClipboardData(String str) {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.setClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jV = cVar.jV(str);
                    String jsonString = jV == null ? "" : jV.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.setClipboardData[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.setClipboardData[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.11
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
            public String startAccelerometer(String str) {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jT = aVar.jT(str);
                    String jsonString = jT == null ? "" : jT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startAccelerometer[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.startAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.12
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
            public String startCompass(String str) {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jW = dVar.jW(str);
                    String jsonString = jW == null ? "" : jW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startCompass[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.startCompass[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.2
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
            public String stopAccelerometer() {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ach = aVar.ach();
                    String jsonString = ach == null ? "" : ach.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopAccelerometer[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.stopAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.3
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
            public String stopCompass() {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ack = dVar.ack();
                    String jsonString = ack == null ? "" : ack.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopCompass[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.stopCompass[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.4
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
        hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                com.baidu.swan.apps.api.module.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.checkAppInstalled[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.a)) {
                        aVar = (com.baidu.swan.apps.api.module.l.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.a aVar2 = new com.baidu.swan.apps.api.module.l.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kf = aVar.kf(str);
                    String jsonString = kf == null ? "" : kf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.1
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
            public String getCommonSysInfoSync() {
                com.baidu.swan.apps.api.module.l.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getCommonSysInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.d)) {
                        dVar = (com.baidu.swan.apps.api.module.l.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.d dVar2 = new com.baidu.swan.apps.api.module.l.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acx = dVar.acx();
                    String jsonString = acx == null ? "" : acx.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.2
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
            public String getSystemInfo() {
                com.baidu.swan.apps.api.module.l.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.d)) {
                        dVar = (com.baidu.swan.apps.api.module.l.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.d dVar2 = new com.baidu.swan.apps.api.module.l.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acv = dVar.acv();
                    String jsonString = acv == null ? "" : acv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.3
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
            public String getSystemInfoSync() {
                com.baidu.swan.apps.api.module.l.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.d)) {
                        dVar = (com.baidu.swan.apps.api.module.l.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.d dVar2 = new com.baidu.swan.apps.api.module.l.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acw = dVar.acw();
                    String jsonString = acw == null ? "" : acw.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.4
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
            public String handleException(String str) {
                com.baidu.swan.apps.api.module.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.handleException[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.l.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.b bVar3 = new com.baidu.swan.apps.api.module.l.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kg = bVar2.kg(str);
                    String jsonString = kg == null ? "" : kg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.handleException[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.handleException[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.5
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
            public String previewImage(String str) {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.previewImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kh = cVar.kh(str);
                    String jsonString = kh == null ? "" : kh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.previewImage[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.previewImage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.6
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
            public String ubcFlowJar(String str) {
                com.baidu.swan.apps.api.module.l.f fVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.ubcFlowJar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.f)) {
                        fVar = (com.baidu.swan.apps.api.module.l.f) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.f fVar2 = new com.baidu.swan.apps.api.module.l.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar2);
                        fVar = fVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ki = fVar.ki(str);
                    String jsonString = ki == null ? "" : ki.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.7
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

    public static Map<String, Object> getWebviewApiModules(final b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                com.baidu.swan.apps.api.module.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.checkSession[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.a)) {
                        aVar = (com.baidu.swan.apps.api.module.a.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.a aVar2 = new com.baidu.swan.apps.api.module.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iR = aVar.iR(str);
                    String jsonString = iR == null ? "" : iR.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.checkSession[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.checkSession[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule.1
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
            public String isLoginSync() {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.isLoginSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abM = bVar2.abM();
                    String jsonString = abM == null ? "" : abM.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.isLoginSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.isLoginSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule.2
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
            public String login(String str) {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.login[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iS = bVar2.iS(str);
                    String jsonString = iS == null ? "" : iS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.login[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.login[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule.3
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
        hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                com.baidu.swan.apps.api.module.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Basic.loadSubPackage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.b.a)) {
                        aVar = (com.baidu.swan.apps.api.module.b.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.b.a aVar2 = new com.baidu.swan.apps.api.module.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iT = aVar.iT(str);
                    String jsonString = iT == null ? "" : iT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Basic.loadSubPackage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Basic.loadSubPackage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule.1
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
        hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.insertBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iz = aVar.iz(str);
                    String jsonString = iz == null ? "" : iz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.1
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
            public String navigateToBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iC = aVar.iC(str);
                    String jsonString = iC == null ? "" : iC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.2
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
            public String queryBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.queryBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iA = aVar.iA(str);
                    String jsonString = iA == null ? "" : iA.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.3
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
            public String updateBookshelfReadTime(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.b.b.a)) {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    } else {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iB = aVar.iB(str);
                    String jsonString = iB == null ? "" : iB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.4
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
        hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Favorite.showFavoriteGuide[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("269275578");
                    if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                        showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                    } else {
                        ShowFavoriteGuideApi showFavoriteGuideApi2 = new ShowFavoriteGuideApi(this.mSwanApiContext);
                        this.mApis.put("269275578", showFavoriteGuideApi2);
                        showFavoriteGuideApi = showFavoriteGuideApi2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iW = showFavoriteGuideApi.iW(str);
                    String jsonString = iW == null ? "" : iW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Favorite.showFavoriteGuide[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Favorite.showFavoriteGuide[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule.1
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
        hashMap.put("_naFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                com.baidu.swan.apps.api.module.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================File.shareFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.c.a)) {
                        aVar = (com.baidu.swan.apps.api.module.c.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.c.a aVar2 = new com.baidu.swan.apps.api.module.c.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iX = aVar.iX(str);
                    String jsonString = iX == null ? "" : iX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[File.shareFile[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[File.shareFile[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule.1
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
        hashMap.put("_naGameCenter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                com.baidu.swan.apps.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.o.a)) {
                        aVar = (com.baidu.swan.apps.o.a) obj;
                    } else {
                        com.baidu.swan.apps.o.a aVar2 = new com.baidu.swan.apps.o.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mI = aVar.mI(str);
                    String jsonString = mI == null ? "" : mI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[GameCenter.postGameCenterMessage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule.1
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
            public String postGameCenterMessageSync(String str) {
                com.baidu.swan.apps.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.o.a)) {
                        aVar = (com.baidu.swan.apps.o.a) obj;
                    } else {
                        com.baidu.swan.apps.o.a aVar2 = new com.baidu.swan.apps.o.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mJ = aVar.mJ(str);
                    String jsonString = mJ == null ? "" : mJ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule.2
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
        hashMap.put("_naImage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                com.baidu.swan.apps.api.module.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Image.compressImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.d.a)) {
                        aVar = (com.baidu.swan.apps.api.module.d.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.d.a aVar2 = new com.baidu.swan.apps.api.module.d.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iZ = aVar.iZ(str);
                    String jsonString = iZ == null ? "" : iZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Image.compressImage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Image.compressImage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule.1
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
        hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jq = gVar.jq(str);
                    String jsonString = jq == null ? "" : jq.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBar[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.closeTabBar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.1
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
            public String closeTabBarRedDot(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBarRedDot[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jn = gVar.jn(str);
                    String jsonString = jn == null ? "" : jn.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.12
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
            public String hideLoading() {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abT = aVar.abT();
                    String jsonString = abT == null ? "" : abT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.13
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
            public String hideNavigationBarLoading(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b je = cVar.je(str);
                    String jsonString = je == null ? "" : je.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.14
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
            public String hideToast() {
                h hVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof h)) {
                        hVar = (h) obj;
                    } else {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abW = hVar.abW();
                    String jsonString = abW == null ? "" : abW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideToast[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideToast[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.15
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
            public String openMultiPicker(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jj = eVar.jj(str);
                    String jsonString = jj == null ? "" : jj.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.16
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
            public String openPicker(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ji = eVar.ji(str);
                    String jsonString = ji == null ? "" : ji.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openPicker[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.17
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
            public String openTabBar(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jp = gVar.jp(str);
                    String jsonString = jp == null ? "" : jp.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.18
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
            public String pageScrollTo(String str) {
                com.baidu.swan.apps.api.module.e.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.pageScrollTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.d)) {
                        dVar = (com.baidu.swan.apps.api.module.e.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.d dVar2 = new com.baidu.swan.apps.api.module.e.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jg = dVar.jg(str);
                    String jsonString = jg == null ? "" : jg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.19
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
            public String setNavigationBarColor(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarColor[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jd = cVar.jd(str);
                    String jsonString = jd == null ? "" : jd.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarColor[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setNavigationBarColor[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.2
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
            public String setNavigationBarTitle(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarTitle[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jc = cVar.jc(str);
                    String jsonString = jc == null ? "" : jc.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarTitle[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setNavigationBarTitle[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.3
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
            public String setTabBarItem(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setTabBarItem[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jo = gVar.jo(str);
                    String jsonString = jo == null ? "" : jo.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setTabBarItem[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setTabBarItem[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.4
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
            public String showDatePickerView(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showDatePickerView[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jh = eVar.jh(str);
                    String jsonString = jh == null ? "" : jh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showDatePickerView[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showDatePickerView[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.5
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
            public String showLoading(String str) {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ja = aVar.ja(str);
                    String jsonString = ja == null ? "" : ja.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.6
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
            public String showModal(String str) {
                com.baidu.swan.apps.api.module.e.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showModal[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.e.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.b bVar3 = new com.baidu.swan.apps.api.module.e.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jb = bVar2.jb(str);
                    String jsonString = jb == null ? "" : jb.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showModal[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showModal[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.7
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
            public String showNavigationBarLoading(String str) {
                c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof c)) {
                        cVar = (c) obj;
                    } else {
                        c cVar2 = new c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jf = cVar.jf(str);
                    String jsonString = jf == null ? "" : jf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.8
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
            public String showToast(String str) {
                h hVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof h)) {
                        hVar = (h) obj;
                    } else {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jr = hVar.jr(str);
                    String jsonString = jr == null ? "" : jr.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showToast[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showToast[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.9
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
            public String stopPullDownRefresh(String str) {
                f fVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.stopPullDownRefresh[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof f)) {
                        fVar = (f) obj;
                    } else {
                        f fVar2 = new f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar2);
                        fVar = fVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jm = fVar.jm(str);
                    String jsonString = jm == null ? "" : jm.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.10
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
            public String updateMultiPicker(String str) {
                e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.updateMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jk = eVar.jk(str);
                    String jsonString = jk == null ? "" : jk.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.11
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
        hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.getLocation[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ju = aVar.ju(str);
                    String jsonString = ju == null ? "" : ju.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.getLocation[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[LocationService.getLocation[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule.1
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
            public String startLocationUpdate(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.startLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jv = aVar.jv(str);
                    String jsonString = jv == null ? "" : jv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.startLocationUpdate[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[LocationService.startLocationUpdate[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule.2
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
            public String stopLocationUpdate() {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.stopLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b abY = aVar.abY();
                    String jsonString = abY == null ? "" : abY.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.stopLocationUpdate[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[LocationService.stopLocationUpdate[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule.3
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
        hashMap.put("_naNetwork", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.cancelRequest[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.network.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.network.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.network.b bVar3 = new com.baidu.swan.apps.api.module.network.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jy = bVar2.jy(str);
                    String jsonString = jy == null ? "" : jy.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.cancelRequest[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.cancelRequest[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule.1
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
            public String getNetworkType() {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.getNetworkType[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b aca = aVar.aca();
                    String jsonString = aca == null ? "" : aca.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.getNetworkType[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.getNetworkType[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule.2
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
            public String networkStatusChange(String str) {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.networkStatusChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jx = aVar.jx(str);
                    String jsonString = jx == null ? "" : jx.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule.3
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [213=6] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    com.baidu.swan.apps.api.b.c.acz().kj("request");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.request[type:Webview, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.b)) {
                        com.baidu.swan.apps.api.module.network.b bVar3 = new com.baidu.swan.apps.api.module.network.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.network.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    Pair<com.baidu.swan.apps.api.c.a, JSONObject> iP = d.iP(str);
                    if (((com.baidu.swan.apps.api.c.a) iP.first).isSuccess()) {
                        JSONObject jSONObject = (JSONObject) iP.second;
                        if (jSONObject == null) {
                            return com.baidu.swan.apps.api.c.a.bYm.toJsonString();
                        }
                        if (DEBUG) {
                            Log.d(TAG, "JsObject->JSONObject: " + jSONObject.toString());
                        }
                        com.baidu.swan.apps.api.c.b au = bVar2.au(jSONObject);
                        String jsonString = au == null ? "" : au.toJsonString();
                        if (DEBUG) {
                            Log.d(TAG, "====================[[Network.request[type:Webview, v8 binding:true] result]]" + jsonString);
                        }
                        return jsonString;
                    }
                    return ((com.baidu.swan.apps.api.c.a) iP.first).toJsonString();
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.request[type:Webview, v8 binding:true] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            com.baidu.swan.apps.api.b.c.acz().kk("request");
                            return "";
                        }
                        throw th;
                    } finally {
                        com.baidu.swan.apps.api.b.c.acz().kk("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                com.baidu.swan.apps.ac.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ac.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ac.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ac.c.a.a aVar2 = new com.baidu.swan.apps.ac.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b px = aVar.px(str);
                    String jsonString = px == null ? "" : px.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule.1
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
            public String invokePluginLoginAndGetUserInfo(String str) {
                com.baidu.swan.apps.ac.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ac.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ac.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ac.c.a.a aVar2 = new com.baidu.swan.apps.ac.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b pw = aVar.pw(str);
                    String jsonString = pw == null ? "" : pw.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule.2
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
            public String invokePluginPayment(String str) {
                com.baidu.swan.apps.ac.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ac.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ac.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ac.c.a.a aVar2 = new com.baidu.swan.apps.ac.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b py = aVar.py(str);
                    String jsonString = py == null ? "" : py.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginPayment[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginPayment[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule.3
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
        hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                com.baidu.swan.apps.api.module.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateBack[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.a)) {
                        aVar = (com.baidu.swan.apps.api.module.g.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.a aVar2 = new com.baidu.swan.apps.api.module.g.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jE = aVar.jE(str);
                    String jsonString = jE == null ? "" : jE.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateBack[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.navigateBack[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.1
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
            public String navigateTo(String str) {
                com.baidu.swan.apps.api.module.g.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.g.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.b bVar3 = new com.baidu.swan.apps.api.module.g.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jF = bVar2.jF(str);
                    String jsonString = jF == null ? "" : jF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateTo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.navigateTo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.2
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
            public String reLaunch(String str) {
                com.baidu.swan.apps.api.module.g.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.reLaunch[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.d)) {
                        dVar = (com.baidu.swan.apps.api.module.g.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.d dVar2 = new com.baidu.swan.apps.api.module.g.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jH = dVar.jH(str);
                    String jsonString = jH == null ? "" : jH.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.reLaunch[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.reLaunch[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.3
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
            public String redirectTo(String str) {
                com.baidu.swan.apps.api.module.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.redirectTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.c)) {
                        cVar = (com.baidu.swan.apps.api.module.g.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.c cVar2 = new com.baidu.swan.apps.api.module.g.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jG = cVar.jG(str);
                    String jsonString = jG == null ? "" : jG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.redirectTo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.redirectTo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.4
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
        hashMap.put("_naSetting", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getAppInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acc = aVar.acc();
                    String jsonString = acc == null ? "" : acc.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getAppInfoSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getAppInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.1
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
            public String getSetting(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSetting[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jJ = aVar.jJ(str);
                    String jsonString = jJ == null ? "" : jJ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSetting[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSetting[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.2
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
            public String getSlaveIdSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSlaveIdSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acd = aVar.acd();
                    String jsonString = acd == null ? "" : acd.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSlaveIdSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSlaveIdSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.3
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
            public String getSwanId(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSwanId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jI = aVar.jI(str);
                    String jsonString = jI == null ? "" : jI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSwanId[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSwanId[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.4
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
            public String getUserInfo(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jK = aVar.jK(str);
                    String jsonString = jK == null ? "" : jK.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getUserInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getUserInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.5
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
        hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acf = aVar.acf();
                    String jsonString = acf == null ? "" : acf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.clearStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.1
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
            public String clearStorageSync() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ace = aVar.ace();
                    String jsonString = ace == null ? "" : ace.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.2
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
            public String getStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jQ = aVar.jQ(str);
                    String jsonString = jQ == null ? "" : jQ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.3
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
            public String getStorageInfo() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acg = aVar.acg();
                    String jsonString = acg == null ? "" : acg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.4
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
            public String getStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jP = aVar.jP(str);
                    String jsonString = jP == null ? "" : jP.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.5
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
            public String removeStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jO = aVar.jO(str);
                    String jsonString = jO == null ? "" : jO.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.removeStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.6
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
            public String removeStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jN = aVar.jN(str);
                    String jsonString = jN == null ? "" : jN.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.7
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
            public String setStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jM = aVar.jM(str);
                    String jsonString = jM == null ? "" : jM.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.setStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.8
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
            public String setStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jL = aVar.jL(str);
                    String jsonString = jL == null ? "" : jL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.9
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
        hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Subscription.subscribeService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jS = aVar.jS(str);
                    String jsonString = jS == null ? "" : jS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Subscription.subscribeService[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Subscription.subscribeService[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule.1
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
        hashMap.put("_naSystem", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.f fVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.exitFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.f)) {
                        fVar = (com.baidu.swan.apps.api.module.k.f) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.f fVar2 = new com.baidu.swan.apps.api.module.k.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar2);
                        fVar = fVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jY = fVar.jY(str);
                    String jsonString = jY == null ? "" : jY.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.exitFullScreen[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.exitFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.1
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
            public String getBrightness() {
                com.baidu.swan.apps.api.module.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getBrightness[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.k.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.b bVar3 = new com.baidu.swan.apps.api.module.k.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b aci = bVar2.aci();
                    String jsonString = aci == null ? "" : aci.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getBrightness[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getBrightness[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.5
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
            public String getClipboardData() {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acj = cVar.acj();
                    String jsonString = acj == null ? "" : acj.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getClipboardData[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.6
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
            public String getDeviceInfo(String str) {
                com.baidu.swan.apps.api.module.k.e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getDeviceInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.e)) {
                        eVar = (com.baidu.swan.apps.api.module.k.e) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.e eVar2 = new com.baidu.swan.apps.api.module.k.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jX = eVar.jX(str);
                    String jsonString = jX == null ? "" : jX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.7
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
            public String makePhoneCall(String str) {
                com.baidu.swan.apps.api.module.k.g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.makePhoneCall[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.g)) {
                        gVar = (com.baidu.swan.apps.api.module.k.g) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.g gVar2 = new com.baidu.swan.apps.api.module.k.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jZ = gVar.jZ(str);
                    String jsonString = jZ == null ? "" : jZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.makePhoneCall[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.makePhoneCall[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.8
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
            public String openSMSPanel(String str) {
                i iVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.openSMSPanel[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof i)) {
                        iVar = (i) obj;
                    } else {
                        i iVar2 = new i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar2);
                        iVar = iVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kb = iVar.kb(str);
                    String jsonString = kb == null ? "" : kb.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.openSMSPanel[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.openSMSPanel[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.9
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
            public String requestFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.h hVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.requestFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.h)) {
                        hVar = (com.baidu.swan.apps.api.module.k.h) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.h hVar2 = new com.baidu.swan.apps.api.module.k.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ka = hVar.ka(str);
                    String jsonString = ka == null ? "" : ka.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.requestFullScreen[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.requestFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.10
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
            public String setClipboardData(String str) {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.setClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jV = cVar.jV(str);
                    String jsonString = jV == null ? "" : jV.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.setClipboardData[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.setClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.11
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
            public String startAccelerometer(String str) {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jT = aVar.jT(str);
                    String jsonString = jT == null ? "" : jT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startAccelerometer[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.startAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.12
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
            public String startCompass(String str) {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b jW = dVar.jW(str);
                    String jsonString = jW == null ? "" : jW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startCompass[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.startCompass[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.2
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
            public String stopAccelerometer() {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ach = aVar.ach();
                    String jsonString = ach == null ? "" : ach.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.3
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
            public String stopCompass() {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ack = dVar.ack();
                    String jsonString = ack == null ? "" : ack.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopCompass[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.stopCompass[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.4
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
        hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            private static final boolean DEBUG = d.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                com.baidu.swan.apps.api.module.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.checkAppInstalled[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.a)) {
                        aVar = (com.baidu.swan.apps.api.module.l.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.a aVar2 = new com.baidu.swan.apps.api.module.l.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kf = aVar.kf(str);
                    String jsonString = kf == null ? "" : kf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.1
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
            public String getCommonSysInfoSync() {
                com.baidu.swan.apps.api.module.l.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getCommonSysInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.d)) {
                        dVar = (com.baidu.swan.apps.api.module.l.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.d dVar2 = new com.baidu.swan.apps.api.module.l.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acx = dVar.acx();
                    String jsonString = acx == null ? "" : acx.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.2
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
            public String getSystemInfo() {
                com.baidu.swan.apps.api.module.l.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.d)) {
                        dVar = (com.baidu.swan.apps.api.module.l.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.d dVar2 = new com.baidu.swan.apps.api.module.l.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acv = dVar.acv();
                    String jsonString = acv == null ? "" : acv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.3
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
            public String getSystemInfoSync() {
                com.baidu.swan.apps.api.module.l.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.d)) {
                        dVar = (com.baidu.swan.apps.api.module.l.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.d dVar2 = new com.baidu.swan.apps.api.module.l.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b acw = dVar.acw();
                    String jsonString = acw == null ? "" : acw.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.4
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
            public String handleException(String str) {
                com.baidu.swan.apps.api.module.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.handleException[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.l.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.b bVar3 = new com.baidu.swan.apps.api.module.l.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kg = bVar2.kg(str);
                    String jsonString = kg == null ? "" : kg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.handleException[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.handleException[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.5
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
            public String previewImage(String str) {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.previewImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kh = cVar.kh(str);
                    String jsonString = kh == null ? "" : kh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.previewImage[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.previewImage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.6
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
            public String ubcFlowJar(String str) {
                com.baidu.swan.apps.api.module.l.f fVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.ubcFlowJar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.f)) {
                        fVar = (com.baidu.swan.apps.api.module.l.f) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.f fVar2 = new com.baidu.swan.apps.api.module.l.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar2);
                        fVar = fVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ki = fVar.ki(str);
                    String jsonString = ki == null ? "" : ki.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.7
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
