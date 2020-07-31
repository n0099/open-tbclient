package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.sapi2.outsdk.c;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.module.e.e;
import com.baidu.swan.apps.api.module.e.g;
import com.baidu.swan.apps.api.module.e.h;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.performance.a.f;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes7.dex */
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String checkSession(String str) {
                com.baidu.swan.apps.api.module.a.a aVar;
                try {
                    f.aoh().iI("checkSession");
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.checkSession[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.a.a)) {
                        com.baidu.swan.apps.api.module.a.a aVar2 = new com.baidu.swan.apps.api.module.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ht = aVar.ht(str);
                    String jsonString = ht == null ? "" : ht.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.checkSession[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Account.checkSession[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("checkSession");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("checkSession");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [122=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String isLoginSync() {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.aoh().iI("isLoginSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.isLoginSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VG = bVar2.VG();
                    String jsonString = VG == null ? "" : VG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.isLoginSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Account.isLoginSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("isLoginSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("isLoginSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String login(String str) {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.aoh().iI(c.k);
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.login[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hu = bVar2.hu(str);
                    String jsonString = hu == null ? "" : hu.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.login[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Account.login[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ(c.k);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ(c.k);
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String loadSubPackage(String str) {
                com.baidu.swan.apps.api.module.b.a aVar;
                try {
                    f.aoh().iI("loadSubPackage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Basic.loadSubPackage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.b.a)) {
                        com.baidu.swan.apps.api.module.b.a aVar2 = new com.baidu.swan.apps.api.module.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hv = aVar.hv(str);
                    String jsonString = hv == null ? "" : hv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Basic.loadSubPackage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Basic.loadSubPackage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("loadSubPackage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("loadSubPackage");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String insertBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("insertBookshelf");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.insertBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b he = aVar.he(str);
                    String jsonString = he == null ? "" : he.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("insertBookshelf");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("insertBookshelf");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("navigateToBookshelf");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.navigateToBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hh = aVar.hh(str);
                    String jsonString = hh == null ? "" : hh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("navigateToBookshelf");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("navigateToBookshelf");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String queryBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("queryBookshelf");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.queryBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hf = aVar.hf(str);
                    String jsonString = hf == null ? "" : hf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("queryBookshelf");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("queryBookshelf");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("updateBookshelfReadTime");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hg = aVar.hg(str);
                    String jsonString = hg == null ? "" : hg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("updateBookshelfReadTime");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("updateBookshelfReadTime");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                try {
                    f.aoh().iI("showFavoriteGuide");
                    if (DEBUG) {
                        Log.d(TAG, "====================Favorite.showFavoriteGuide[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("269275578");
                    if (obj == null || !(obj instanceof ShowFavoriteGuideApi)) {
                        ShowFavoriteGuideApi showFavoriteGuideApi2 = new ShowFavoriteGuideApi(this.mSwanApiContext);
                        this.mApis.put("269275578", showFavoriteGuideApi2);
                        showFavoriteGuideApi = showFavoriteGuideApi2;
                    } else {
                        showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hy = showFavoriteGuideApi.hy(str);
                    String jsonString = hy == null ? "" : hy.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Favorite.showFavoriteGuide[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Favorite.showFavoriteGuide[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showFavoriteGuide");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showFavoriteGuide");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String shareFile(String str) {
                com.baidu.swan.apps.api.module.c.a aVar;
                try {
                    f.aoh().iI("shareFile");
                    if (DEBUG) {
                        Log.d(TAG, "====================File.shareFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.c.a)) {
                        com.baidu.swan.apps.api.module.c.a aVar2 = new com.baidu.swan.apps.api.module.c.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.c.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hz = aVar.hz(str);
                    String jsonString = hz == null ? "" : hz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[File.shareFile[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[File.shareFile[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("shareFile");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("shareFile");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                com.baidu.swan.apps.n.a aVar;
                try {
                    f.aoh().iI("postGameCenterMessage");
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.n.a)) {
                        com.baidu.swan.apps.n.a aVar2 = new com.baidu.swan.apps.n.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.n.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kT = aVar.kT(str);
                    String jsonString = kT == null ? "" : kT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[GameCenter.postGameCenterMessage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("postGameCenterMessage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("postGameCenterMessage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                com.baidu.swan.apps.n.a aVar;
                try {
                    f.aoh().iI("postGameCenterMessageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.n.a)) {
                        com.baidu.swan.apps.n.a aVar2 = new com.baidu.swan.apps.n.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.n.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kU = aVar.kU(str);
                    String jsonString = kU == null ? "" : kU.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("postGameCenterMessageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("postGameCenterMessageSync");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String compressImage(String str) {
                com.baidu.swan.apps.api.module.d.a aVar;
                try {
                    f.aoh().iI("compressImage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Image.compressImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.d.a)) {
                        com.baidu.swan.apps.api.module.d.a aVar2 = new com.baidu.swan.apps.api.module.d.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.d.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hB = aVar.hB(str);
                    String jsonString = hB == null ? "" : hB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Image.compressImage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Image.compressImage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("compressImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("compressImage");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String closeTabBar(String str) {
                g gVar;
                try {
                    f.aoh().iI("closeTabBar");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hS = gVar.hS(str);
                    String jsonString = hS == null ? "" : hS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBar[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.closeTabBar[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("closeTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("closeTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                g gVar;
                try {
                    f.aoh().iI("closeTabBarRedDot");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBarRedDot[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hP = gVar.hP(str);
                    String jsonString = hP == null ? "" : hP.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.12
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("closeTabBarRedDot");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("closeTabBarRedDot");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideLoading() {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.aoh().iI("hideLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VN = aVar.VN();
                    String jsonString = VN == null ? "" : VN.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideLoading[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.hideLoading[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.13
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("hideLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("hideLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [216=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("hideNavigationBarLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hG = cVar.hG(str);
                    String jsonString = hG == null ? "" : hG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.14
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("hideNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("hideNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [260=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideToast() {
                h hVar;
                try {
                    f.aoh().iI("hideToast");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj == null || !(obj instanceof h)) {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    } else {
                        hVar = (h) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VQ = hVar.VQ();
                    String jsonString = VQ == null ? "" : VQ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideToast[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.hideToast[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.15
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("hideToast");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("hideToast");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [304=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openMultiPicker(String str) {
                e eVar;
                try {
                    f.aoh().iI("openMultiPicker");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hL = eVar.hL(str);
                    String jsonString = hL == null ? "" : hL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.16
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("openMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("openMultiPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openPicker(String str) {
                e eVar;
                try {
                    f.aoh().iI("openPicker");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hK = eVar.hK(str);
                    String jsonString = hK == null ? "" : hK.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openPicker[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.openPicker[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.17
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("openPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("openPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [392=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openTabBar(String str) {
                g gVar;
                try {
                    f.aoh().iI("openTabBar");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hR = gVar.hR(str);
                    String jsonString = hR == null ? "" : hR.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openTabBar[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.openTabBar[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.18
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("openTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("openTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [436=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String pageScrollTo(String str) {
                com.baidu.swan.apps.api.module.e.d dVar;
                try {
                    f.aoh().iI("pageScrollTo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.pageScrollTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.d)) {
                        com.baidu.swan.apps.api.module.e.d dVar2 = new com.baidu.swan.apps.api.module.e.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.e.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hI = dVar.hI(str);
                    String jsonString = hI == null ? "" : hI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.19
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("pageScrollTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("pageScrollTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("setNavigationBarColor");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarColor[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hF = cVar.hF(str);
                    String jsonString = hF == null ? "" : hF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarColor[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.setNavigationBarColor[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setNavigationBarColor");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setNavigationBarColor");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [524=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("setNavigationBarTitle");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarTitle[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hE = cVar.hE(str);
                    String jsonString = hE == null ? "" : hE.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarTitle[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.setNavigationBarTitle[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setNavigationBarTitle");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setNavigationBarTitle");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [568=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setTabBarItem(String str) {
                g gVar;
                try {
                    f.aoh().iI("setTabBarItem");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setTabBarItem[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hQ = gVar.hQ(str);
                    String jsonString = hQ == null ? "" : hQ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setTabBarItem[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.setTabBarItem[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setTabBarItem");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setTabBarItem");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [612=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showDatePickerView(String str) {
                e eVar;
                try {
                    f.aoh().iI("showDatePickerView");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showDatePickerView[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hJ = eVar.hJ(str);
                    String jsonString = hJ == null ? "" : hJ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showDatePickerView[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showDatePickerView[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showDatePickerView");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showDatePickerView");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [656=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showLoading(String str) {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.aoh().iI("showLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hC = aVar.hC(str);
                    String jsonString = hC == null ? "" : hC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showLoading[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showLoading[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [700=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showModal(String str) {
                com.baidu.swan.apps.api.module.e.b bVar2;
                try {
                    f.aoh().iI("showModal");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showModal[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.b)) {
                        com.baidu.swan.apps.api.module.e.b bVar3 = new com.baidu.swan.apps.api.module.e.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.e.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hD = bVar2.hD(str);
                    String jsonString = hD == null ? "" : hD.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showModal[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showModal[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showModal");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showModal");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [744=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("showNavigationBarLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hH = cVar.hH(str);
                    String jsonString = hH == null ? "" : hH.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [788=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showToast(String str) {
                h hVar;
                try {
                    f.aoh().iI(PopItemMethodConstant.showToast);
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj == null || !(obj instanceof h)) {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    } else {
                        hVar = (h) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hT = hVar.hT(str);
                    String jsonString = hT == null ? "" : hT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showToast[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showToast[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ(PopItemMethodConstant.showToast);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ(PopItemMethodConstant.showToast);
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [832=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                com.baidu.swan.apps.api.module.e.f fVar;
                try {
                    f.aoh().iI("stopPullDownRefresh");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.stopPullDownRefresh[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.f)) {
                        com.baidu.swan.apps.api.module.e.f fVar2 = new com.baidu.swan.apps.api.module.e.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar2);
                        fVar = fVar2;
                    } else {
                        fVar = (com.baidu.swan.apps.api.module.e.f) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hO = fVar.hO(str);
                    String jsonString = hO == null ? "" : hO.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopPullDownRefresh");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopPullDownRefresh");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [876=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String updateMultiPicker(String str) {
                e eVar;
                try {
                    f.aoh().iI("updateMultiPicker");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.updateMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hM = eVar.hM(str);
                    String jsonString = hM == null ? "" : hM.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module.11
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("updateMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("updateMultiPicker");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getLocation(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    f.aoh().iI("getLocation");
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.getLocation[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hW = aVar.hW(str);
                    String jsonString = hW == null ? "" : hW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.getLocation[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[LocationService.getLocation[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getLocation");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getLocation");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startLocationUpdate(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    f.aoh().iI("startLocationUpdate");
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.startLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hX = aVar.hX(str);
                    String jsonString = hX == null ? "" : hX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.startLocationUpdate[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[LocationService.startLocationUpdate[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("startLocationUpdate");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("startLocationUpdate");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopLocationUpdate() {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    f.aoh().iI("stopLocationUpdate");
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.stopLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VS = aVar.VS();
                    String jsonString = VS == null ? "" : VS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.stopLocationUpdate[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[LocationService.stopLocationUpdate[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopLocationUpdate");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopLocationUpdate");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String cancelRequest(String str) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    f.aoh().iI("cancelRequest");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.cancelRequest[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.b)) {
                        com.baidu.swan.apps.api.module.network.b bVar3 = new com.baidu.swan.apps.api.module.network.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.network.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ia = bVar2.ia(str);
                    String jsonString = ia == null ? "" : ia.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.cancelRequest[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.cancelRequest[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("cancelRequest");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("cancelRequest");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getNetworkType() {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.aoh().iI("getNetworkType");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.getNetworkType[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VU = aVar.VU();
                    String jsonString = VU == null ? "" : VU.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.getNetworkType[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.getNetworkType[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getNetworkType");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getNetworkType");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [169=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String networkStatusChange(String str) {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.aoh().iI("networkStatusChange");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.networkStatusChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hZ = aVar.hZ(str);
                    String jsonString = hZ == null ? "" : hZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.networkStatusChange[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.networkStatusChange[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("networkStatusChange");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("networkStatusChange");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=6, 226=6] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    com.baidu.swan.apps.api.b.c.Wt().iI("request");
                    f.aoh().iI("request");
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
                            return com.baidu.swan.apps.api.c.a.bSA.toJsonString();
                        }
                        if (DEBUG) {
                            Log.d(TAG, "JsObject->JSONObject: " + jSONObject.toString());
                        }
                        com.baidu.swan.apps.api.c.b as = bVar2.as(jSONObject);
                        String jsonString = as == null ? "" : as.toJsonString();
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
                            com.baidu.swan.apps.api.b.c.Wt().iJ("request");
                            f.aoh().iJ("request");
                            return "";
                        }
                        throw th;
                    } finally {
                        com.baidu.swan.apps.api.b.c.Wt().iJ("request");
                        f.aoh().iJ("request");
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                com.baidu.swan.apps.ad.c.a.a aVar;
                try {
                    f.aoh().iI("invokePluginChooseAddress");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ad.c.a.a)) {
                        com.baidu.swan.apps.ad.c.a.a aVar2 = new com.baidu.swan.apps.ad.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ad.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ny = aVar.ny(str);
                    String jsonString = ny == null ? "" : ny.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginChooseAddress[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Plugin.invokePluginChooseAddress[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("invokePluginChooseAddress");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("invokePluginChooseAddress");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                com.baidu.swan.apps.ad.c.a.a aVar;
                try {
                    f.aoh().iI("invokePluginLoginAndGetUserInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ad.c.a.a)) {
                        com.baidu.swan.apps.ad.c.a.a aVar2 = new com.baidu.swan.apps.ad.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ad.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b nx = aVar.nx(str);
                    String jsonString = nx == null ? "" : nx.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("invokePluginLoginAndGetUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("invokePluginLoginAndGetUserInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginPayment(String str) {
                com.baidu.swan.apps.ad.c.a.a aVar;
                try {
                    f.aoh().iI("invokePluginPayment");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ad.c.a.a)) {
                        com.baidu.swan.apps.ad.c.a.a aVar2 = new com.baidu.swan.apps.ad.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ad.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b nz = aVar.nz(str);
                    String jsonString = nz == null ? "" : nz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginPayment[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Plugin.invokePluginPayment[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("invokePluginPayment");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("invokePluginPayment");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateBack(String str) {
                com.baidu.swan.apps.api.module.g.a aVar;
                try {
                    f.aoh().iI("navigateBack");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateBack[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.a)) {
                        com.baidu.swan.apps.api.module.g.a aVar2 = new com.baidu.swan.apps.api.module.g.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.g.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ig = aVar.ig(str);
                    String jsonString = ig == null ? "" : ig.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateBack[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.navigateBack[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("navigateBack");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("navigateBack");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateTo(String str) {
                com.baidu.swan.apps.api.module.g.b bVar2;
                try {
                    f.aoh().iI("navigateTo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.b)) {
                        com.baidu.swan.apps.api.module.g.b bVar3 = new com.baidu.swan.apps.api.module.g.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.g.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ih = bVar2.ih(str);
                    String jsonString = ih == null ? "" : ih.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateTo[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.navigateTo[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("navigateTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("navigateTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String reLaunch(String str) {
                com.baidu.swan.apps.api.module.g.d dVar;
                try {
                    f.aoh().iI("reLaunch");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.reLaunch[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.d)) {
                        com.baidu.swan.apps.api.module.g.d dVar2 = new com.baidu.swan.apps.api.module.g.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.g.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ij = dVar.ij(str);
                    String jsonString = ij == null ? "" : ij.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.reLaunch[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.reLaunch[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("reLaunch");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("reLaunch");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String redirectTo(String str) {
                com.baidu.swan.apps.api.module.g.c cVar;
                try {
                    f.aoh().iI("redirectTo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.redirectTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.c)) {
                        com.baidu.swan.apps.api.module.g.c cVar2 = new com.baidu.swan.apps.api.module.g.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.g.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ii = cVar.ii(str);
                    String jsonString = ii == null ? "" : ii.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.redirectTo[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.redirectTo[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("redirectTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("redirectTo");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getAppInfoSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getAppInfoSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getAppInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VW = aVar.VW();
                    String jsonString = VW == null ? "" : VW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getAppInfoSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getAppInfoSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getAppInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getAppInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSetting(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getSetting");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSetting[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b il = aVar.il(str);
                    String jsonString = il == null ? "" : il.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSetting[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getSetting[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSetting");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSetting");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSlaveIdSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getSlaveIdSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSlaveIdSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VX = aVar.VX();
                    String jsonString = VX == null ? "" : VX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSlaveIdSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getSlaveIdSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSlaveIdSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSlaveIdSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSwanId(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getSwanId");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSwanId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ik = aVar.ik(str);
                    String jsonString = ik == null ? "" : ik.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSwanId[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getSwanId[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSwanId");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSwanId");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getUserInfo(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getUserInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b im = aVar.im(str);
                    String jsonString = im == null ? "" : im.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getUserInfo[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getUserInfo[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getUserInfo");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String clearStorage() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("clearStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VZ = aVar.VZ();
                    String jsonString = VZ == null ? "" : VZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.clearStorage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("clearStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("clearStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String clearStorageSync() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("clearStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VY = aVar.VY();
                    String jsonString = VY == null ? "" : VY.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("clearStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("clearStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("getStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b is = aVar.is(str);
                    String jsonString = is == null ? "" : is.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.getStorage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageInfo() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("getStorageInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wa = aVar.Wa();
                    String jsonString = Wa == null ? "" : Wa.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getStorageInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getStorageInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("getStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ir = aVar.ir(str);
                    String jsonString = ir == null ? "" : ir.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.getStorageSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("removeStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iq = aVar.iq(str);
                    String jsonString = iq == null ? "" : iq.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.removeStorage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("removeStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("removeStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("removeStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ip = aVar.ip(str);
                    String jsonString = ip == null ? "" : ip.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("removeStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("removeStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [385=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("setStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b io2 = aVar.io(str);
                    String jsonString = io2 == null ? "" : io2.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.setStorage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("setStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b in = aVar.in(str);
                    String jsonString = in == null ? "" : in.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorageSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.setStorageSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setStorageSync");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String subscribeService(String str) {
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    f.aoh().iI("subscribeService");
                    if (DEBUG) {
                        Log.d(TAG, "====================Subscription.subscribeService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iu = aVar.iu(str);
                    String jsonString = iu == null ? "" : iu.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Subscription.subscribeService[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Subscription.subscribeService[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("subscribeService");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("subscribeService");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String exitFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.e eVar;
                try {
                    f.aoh().iI("exitFullScreen");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.exitFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.e)) {
                        com.baidu.swan.apps.api.module.k.e eVar2 = new com.baidu.swan.apps.api.module.k.e(this.mSwanApiContext);
                        this.mApis.put("1936205521", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (com.baidu.swan.apps.api.module.k.e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iz = eVar.iz(str);
                    String jsonString = iz == null ? "" : iz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.exitFullScreen[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.exitFullScreen[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("exitFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("exitFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [127=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getBrightness() {
                com.baidu.swan.apps.api.module.k.b bVar2;
                try {
                    f.aoh().iI("getBrightness");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getBrightness[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.b)) {
                        com.baidu.swan.apps.api.module.k.b bVar3 = new com.baidu.swan.apps.api.module.k.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.k.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wc = bVar2.Wc();
                    String jsonString = Wc == null ? "" : Wc.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getBrightness[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.getBrightness[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getBrightness");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getBrightness");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getClipboardData() {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.aoh().iI("getClipboardData");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wd = cVar.Wd();
                    String jsonString = Wd == null ? "" : Wd.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getClipboardData[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.getClipboardData[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String makePhoneCall(String str) {
                com.baidu.swan.apps.api.module.k.f fVar;
                try {
                    f.aoh().iI("makePhoneCall");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.makePhoneCall[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.f)) {
                        com.baidu.swan.apps.api.module.k.f fVar2 = new com.baidu.swan.apps.api.module.k.f(this.mSwanApiContext);
                        this.mApis.put("-1569246082", fVar2);
                        fVar = fVar2;
                    } else {
                        fVar = (com.baidu.swan.apps.api.module.k.f) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iA = fVar.iA(str);
                    String jsonString = iA == null ? "" : iA.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.makePhoneCall[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.makePhoneCall[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("makePhoneCall");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("makePhoneCall");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [259=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String requestFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.g gVar;
                try {
                    f.aoh().iI("requestFullScreen");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.requestFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.g)) {
                        com.baidu.swan.apps.api.module.k.g gVar2 = new com.baidu.swan.apps.api.module.k.g(this.mSwanApiContext);
                        this.mApis.put("-1707203360", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (com.baidu.swan.apps.api.module.k.g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iB = gVar.iB(str);
                    String jsonString = iB == null ? "" : iB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.requestFullScreen[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.requestFullScreen[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("requestFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("requestFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [303=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setClipboardData(String str) {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.aoh().iI("setClipboardData");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.setClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ix = cVar.ix(str);
                    String jsonString = ix == null ? "" : ix.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.setClipboardData[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.setClipboardData[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [347=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startAccelerometer(String str) {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.aoh().iI("startAccelerometer");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iv = aVar.iv(str);
                    String jsonString = iv == null ? "" : iv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startAccelerometer[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.startAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("startAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("startAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startCompass(String str) {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.aoh().iI("startCompass");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iy = dVar.iy(str);
                    String jsonString = iy == null ? "" : iy.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startCompass[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.startCompass[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("startCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("startCompass");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [435=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopAccelerometer() {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.aoh().iI("stopAccelerometer");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wb = aVar.Wb();
                    String jsonString = Wb == null ? "" : Wb.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopAccelerometer[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.stopAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [479=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopCompass() {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.aoh().iI("stopCompass");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b We = dVar.We();
                    String jsonString = We == null ? "" : We.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopCompass[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.stopCompass[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopCompass");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String checkAppInstalled(String str) {
                com.baidu.swan.apps.api.module.l.a aVar;
                try {
                    f.aoh().iI("checkAppInstalled");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.checkAppInstalled[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.a)) {
                        com.baidu.swan.apps.api.module.l.a aVar2 = new com.baidu.swan.apps.api.module.l.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.l.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iF = aVar.iF(str);
                    String jsonString = iF == null ? "" : iF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("checkAppInstalled");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("checkAppInstalled");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getCommonSysInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.aoh().iI("getCommonSysInfoSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getCommonSysInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wr = cVar.Wr();
                    String jsonString = Wr == null ? "" : Wr.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getCommonSysInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getCommonSysInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfo() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.aoh().iI("getSystemInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wo = cVar.Wo();
                    String jsonString = Wo == null ? "" : Wo.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSystemInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSystemInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.aoh().iI("getSystemInfoSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wp = cVar.Wp();
                    String jsonString = Wp == null ? "" : Wp.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSystemInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSystemInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String previewImage(String str) {
                com.baidu.swan.apps.api.module.l.b bVar2;
                try {
                    f.aoh().iI("previewImage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.previewImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.b)) {
                        com.baidu.swan.apps.api.module.l.b bVar3 = new com.baidu.swan.apps.api.module.l.b(this.mSwanApiContext);
                        this.mApis.put("589529211", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.l.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/previewImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iG = bVar2.iG(str);
                    String jsonString = iG == null ? "" : iG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.previewImage[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.previewImage[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("previewImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("previewImage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [300=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String ubcFlowJar(String str) {
                com.baidu.swan.apps.api.module.l.e eVar;
                try {
                    f.aoh().iI("ubcFlowJar");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.ubcFlowJar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.e)) {
                        com.baidu.swan.apps.api.module.l.e eVar2 = new com.baidu.swan.apps.api.module.l.e(this.mSwanApiContext);
                        this.mApis.put("-577481801", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (com.baidu.swan.apps.api.module.l.e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iH = eVar.iH(str);
                    String jsonString = iH == null ? "" : iH.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("ubcFlowJar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("ubcFlowJar");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String checkSession(String str) {
                com.baidu.swan.apps.api.module.a.a aVar;
                try {
                    f.aoh().iI("checkSession");
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.checkSession[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.a.a)) {
                        com.baidu.swan.apps.api.module.a.a aVar2 = new com.baidu.swan.apps.api.module.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ht = aVar.ht(str);
                    String jsonString = ht == null ? "" : ht.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.checkSession[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Account.checkSession[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("checkSession");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("checkSession");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [122=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String isLoginSync() {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.aoh().iI("isLoginSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.isLoginSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VG = bVar2.VG();
                    String jsonString = VG == null ? "" : VG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.isLoginSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Account.isLoginSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("isLoginSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("isLoginSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String login(String str) {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.aoh().iI(c.k);
                    if (DEBUG) {
                        Log.d(TAG, "====================Account.login[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hu = bVar2.hu(str);
                    String jsonString = hu == null ? "" : hu.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.login[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Account.login[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ(c.k);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ(c.k);
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String loadSubPackage(String str) {
                com.baidu.swan.apps.api.module.b.a aVar;
                try {
                    f.aoh().iI("loadSubPackage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Basic.loadSubPackage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.b.a)) {
                        com.baidu.swan.apps.api.module.b.a aVar2 = new com.baidu.swan.apps.api.module.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hv = aVar.hv(str);
                    String jsonString = hv == null ? "" : hv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Basic.loadSubPackage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Basic.loadSubPackage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("loadSubPackage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("loadSubPackage");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String insertBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("insertBookshelf");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.insertBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b he = aVar.he(str);
                    String jsonString = he == null ? "" : he.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("insertBookshelf");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("insertBookshelf");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("navigateToBookshelf");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hh = aVar.hh(str);
                    String jsonString = hh == null ? "" : hh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("navigateToBookshelf");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("navigateToBookshelf");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String queryBookshelf(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("queryBookshelf");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.queryBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hf = aVar.hf(str);
                    String jsonString = hf == null ? "" : hf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("queryBookshelf");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("queryBookshelf");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                com.baidu.swan.apps.b.b.a aVar;
                try {
                    f.aoh().iI("updateBookshelfReadTime");
                    if (DEBUG) {
                        Log.d(TAG, "====================Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.b.b.a)) {
                        com.baidu.swan.apps.b.b.a aVar2 = new com.baidu.swan.apps.b.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.b.b.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hg = aVar.hg(str);
                    String jsonString = hg == null ? "" : hg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("updateBookshelfReadTime");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("updateBookshelfReadTime");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                try {
                    f.aoh().iI("showFavoriteGuide");
                    if (DEBUG) {
                        Log.d(TAG, "====================Favorite.showFavoriteGuide[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("269275578");
                    if (obj == null || !(obj instanceof ShowFavoriteGuideApi)) {
                        ShowFavoriteGuideApi showFavoriteGuideApi2 = new ShowFavoriteGuideApi(this.mSwanApiContext);
                        this.mApis.put("269275578", showFavoriteGuideApi2);
                        showFavoriteGuideApi = showFavoriteGuideApi2;
                    } else {
                        showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hy = showFavoriteGuideApi.hy(str);
                    String jsonString = hy == null ? "" : hy.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Favorite.showFavoriteGuide[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Favorite.showFavoriteGuide[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showFavoriteGuide");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showFavoriteGuide");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String shareFile(String str) {
                com.baidu.swan.apps.api.module.c.a aVar;
                try {
                    f.aoh().iI("shareFile");
                    if (DEBUG) {
                        Log.d(TAG, "====================File.shareFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.c.a)) {
                        com.baidu.swan.apps.api.module.c.a aVar2 = new com.baidu.swan.apps.api.module.c.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.c.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hz = aVar.hz(str);
                    String jsonString = hz == null ? "" : hz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[File.shareFile[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[File.shareFile[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("shareFile");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("shareFile");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                com.baidu.swan.apps.n.a aVar;
                try {
                    f.aoh().iI("postGameCenterMessage");
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.n.a)) {
                        com.baidu.swan.apps.n.a aVar2 = new com.baidu.swan.apps.n.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.n.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kT = aVar.kT(str);
                    String jsonString = kT == null ? "" : kT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[GameCenter.postGameCenterMessage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("postGameCenterMessage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("postGameCenterMessage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                com.baidu.swan.apps.n.a aVar;
                try {
                    f.aoh().iI("postGameCenterMessageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.n.a)) {
                        com.baidu.swan.apps.n.a aVar2 = new com.baidu.swan.apps.n.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.n.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b kU = aVar.kU(str);
                    String jsonString = kU == null ? "" : kU.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("postGameCenterMessageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("postGameCenterMessageSync");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String compressImage(String str) {
                com.baidu.swan.apps.api.module.d.a aVar;
                try {
                    f.aoh().iI("compressImage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Image.compressImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.d.a)) {
                        com.baidu.swan.apps.api.module.d.a aVar2 = new com.baidu.swan.apps.api.module.d.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.d.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hB = aVar.hB(str);
                    String jsonString = hB == null ? "" : hB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Image.compressImage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Image.compressImage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("compressImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("compressImage");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String closeTabBar(String str) {
                g gVar;
                try {
                    f.aoh().iI("closeTabBar");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hS = gVar.hS(str);
                    String jsonString = hS == null ? "" : hS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBar[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.closeTabBar[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("closeTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("closeTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                g gVar;
                try {
                    f.aoh().iI("closeTabBarRedDot");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBarRedDot[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hP = gVar.hP(str);
                    String jsonString = hP == null ? "" : hP.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.12
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("closeTabBarRedDot");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("closeTabBarRedDot");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideLoading() {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.aoh().iI("hideLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VN = aVar.VN();
                    String jsonString = VN == null ? "" : VN.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.13
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("hideLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("hideLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [216=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("hideNavigationBarLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hG = cVar.hG(str);
                    String jsonString = hG == null ? "" : hG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.14
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("hideNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("hideNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [260=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideToast() {
                h hVar;
                try {
                    f.aoh().iI("hideToast");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.hideToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj == null || !(obj instanceof h)) {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    } else {
                        hVar = (h) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VQ = hVar.VQ();
                    String jsonString = VQ == null ? "" : VQ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideToast[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.hideToast[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.15
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("hideToast");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("hideToast");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [304=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openMultiPicker(String str) {
                e eVar;
                try {
                    f.aoh().iI("openMultiPicker");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hL = eVar.hL(str);
                    String jsonString = hL == null ? "" : hL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.16
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("openMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("openMultiPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openPicker(String str) {
                e eVar;
                try {
                    f.aoh().iI("openPicker");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hK = eVar.hK(str);
                    String jsonString = hK == null ? "" : hK.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openPicker[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.openPicker[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.17
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("openPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("openPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [392=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openTabBar(String str) {
                g gVar;
                try {
                    f.aoh().iI("openTabBar");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.openTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hR = gVar.hR(str);
                    String jsonString = hR == null ? "" : hR.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.18
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("openTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("openTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [436=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String pageScrollTo(String str) {
                com.baidu.swan.apps.api.module.e.d dVar;
                try {
                    f.aoh().iI("pageScrollTo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.pageScrollTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.d)) {
                        com.baidu.swan.apps.api.module.e.d dVar2 = new com.baidu.swan.apps.api.module.e.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.e.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hI = dVar.hI(str);
                    String jsonString = hI == null ? "" : hI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.19
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("pageScrollTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("pageScrollTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("setNavigationBarColor");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarColor[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hF = cVar.hF(str);
                    String jsonString = hF == null ? "" : hF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarColor[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.setNavigationBarColor[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setNavigationBarColor");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setNavigationBarColor");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [524=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("setNavigationBarTitle");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarTitle[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hE = cVar.hE(str);
                    String jsonString = hE == null ? "" : hE.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarTitle[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.setNavigationBarTitle[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setNavigationBarTitle");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setNavigationBarTitle");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [568=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setTabBarItem(String str) {
                g gVar;
                try {
                    f.aoh().iI("setTabBarItem");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setTabBarItem[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj == null || !(obj instanceof g)) {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hQ = gVar.hQ(str);
                    String jsonString = hQ == null ? "" : hQ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setTabBarItem[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.setTabBarItem[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setTabBarItem");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setTabBarItem");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [612=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showDatePickerView(String str) {
                e eVar;
                try {
                    f.aoh().iI("showDatePickerView");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showDatePickerView[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hJ = eVar.hJ(str);
                    String jsonString = hJ == null ? "" : hJ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showDatePickerView[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showDatePickerView[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showDatePickerView");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showDatePickerView");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [656=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showLoading(String str) {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.aoh().iI("showLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hC = aVar.hC(str);
                    String jsonString = hC == null ? "" : hC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showLoading[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [700=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showModal(String str) {
                com.baidu.swan.apps.api.module.e.b bVar2;
                try {
                    f.aoh().iI("showModal");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showModal[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.b)) {
                        com.baidu.swan.apps.api.module.e.b bVar3 = new com.baidu.swan.apps.api.module.e.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.e.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hD = bVar2.hD(str);
                    String jsonString = hD == null ? "" : hD.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showModal[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showModal[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showModal");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showModal");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [744=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.aoh().iI("showNavigationBarLoading");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hH = cVar.hH(str);
                    String jsonString = hH == null ? "" : hH.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("showNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("showNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [788=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showToast(String str) {
                h hVar;
                try {
                    f.aoh().iI(PopItemMethodConstant.showToast);
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.showToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj == null || !(obj instanceof h)) {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    } else {
                        hVar = (h) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hT = hVar.hT(str);
                    String jsonString = hT == null ? "" : hT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showToast[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.showToast[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ(PopItemMethodConstant.showToast);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ(PopItemMethodConstant.showToast);
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [832=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                com.baidu.swan.apps.api.module.e.f fVar;
                try {
                    f.aoh().iI("stopPullDownRefresh");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.stopPullDownRefresh[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.e.f)) {
                        com.baidu.swan.apps.api.module.e.f fVar2 = new com.baidu.swan.apps.api.module.e.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar2);
                        fVar = fVar2;
                    } else {
                        fVar = (com.baidu.swan.apps.api.module.e.f) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hO = fVar.hO(str);
                    String jsonString = hO == null ? "" : hO.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopPullDownRefresh");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopPullDownRefresh");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [876=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String updateMultiPicker(String str) {
                e eVar;
                try {
                    f.aoh().iI("updateMultiPicker");
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.updateMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj == null || !(obj instanceof e)) {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hM = eVar.hM(str);
                    String jsonString = hM == null ? "" : hM.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule.11
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("updateMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("updateMultiPicker");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getLocation(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    f.aoh().iI("getLocation");
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.getLocation[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hW = aVar.hW(str);
                    String jsonString = hW == null ? "" : hW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.getLocation[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[LocationService.getLocation[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getLocation");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getLocation");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startLocationUpdate(String str) {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    f.aoh().iI("startLocationUpdate");
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.startLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hX = aVar.hX(str);
                    String jsonString = hX == null ? "" : hX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.startLocationUpdate[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[LocationService.startLocationUpdate[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("startLocationUpdate");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("startLocationUpdate");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopLocationUpdate() {
                com.baidu.swan.apps.api.module.f.a aVar;
                try {
                    f.aoh().iI("stopLocationUpdate");
                    if (DEBUG) {
                        Log.d(TAG, "====================LocationService.stopLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VS = aVar.VS();
                    String jsonString = VS == null ? "" : VS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.stopLocationUpdate[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[LocationService.stopLocationUpdate[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopLocationUpdate");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopLocationUpdate");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String cancelRequest(String str) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    f.aoh().iI("cancelRequest");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.cancelRequest[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.b)) {
                        com.baidu.swan.apps.api.module.network.b bVar3 = new com.baidu.swan.apps.api.module.network.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.network.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ia = bVar2.ia(str);
                    String jsonString = ia == null ? "" : ia.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.cancelRequest[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.cancelRequest[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("cancelRequest");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("cancelRequest");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getNetworkType() {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.aoh().iI("getNetworkType");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.getNetworkType[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VU = aVar.VU();
                    String jsonString = VU == null ? "" : VU.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.getNetworkType[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.getNetworkType[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getNetworkType");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getNetworkType");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String networkStatusChange(String str) {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.aoh().iI("networkStatusChange");
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.networkStatusChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.network.a)) {
                        com.baidu.swan.apps.api.module.network.a aVar2 = new com.baidu.swan.apps.api.module.network.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.network.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b hZ = aVar.hZ(str);
                    String jsonString = hZ == null ? "" : hZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("networkStatusChange");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("networkStatusChange");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [224=6, 225=6] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    com.baidu.swan.apps.api.b.c.Wt().iI("request");
                    f.aoh().iI("request");
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
                    Pair<com.baidu.swan.apps.api.c.a, JSONObject> hr = d.hr(str);
                    if (((com.baidu.swan.apps.api.c.a) hr.first).isSuccess()) {
                        JSONObject jSONObject = (JSONObject) hr.second;
                        if (jSONObject == null) {
                            return com.baidu.swan.apps.api.c.a.bSA.toJsonString();
                        }
                        if (DEBUG) {
                            Log.d(TAG, "JsObject->JSONObject: " + jSONObject.toString());
                        }
                        com.baidu.swan.apps.api.c.b as = bVar2.as(jSONObject);
                        String jsonString = as == null ? "" : as.toJsonString();
                        if (DEBUG) {
                            Log.d(TAG, "====================[[Network.request[type:Webview, v8 binding:true] result]]" + jsonString);
                        }
                        return jsonString;
                    }
                    return ((com.baidu.swan.apps.api.c.a) hr.first).toJsonString();
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
                            com.baidu.swan.apps.api.b.c.Wt().iJ("request");
                            f.aoh().iJ("request");
                            return "";
                        }
                        throw th;
                    } finally {
                        com.baidu.swan.apps.api.b.c.Wt().iJ("request");
                        f.aoh().iJ("request");
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                com.baidu.swan.apps.ad.c.a.a aVar;
                try {
                    f.aoh().iI("invokePluginChooseAddress");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ad.c.a.a)) {
                        com.baidu.swan.apps.ad.c.a.a aVar2 = new com.baidu.swan.apps.ad.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ad.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ny = aVar.ny(str);
                    String jsonString = ny == null ? "" : ny.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("invokePluginChooseAddress");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("invokePluginChooseAddress");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                com.baidu.swan.apps.ad.c.a.a aVar;
                try {
                    f.aoh().iI("invokePluginLoginAndGetUserInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ad.c.a.a)) {
                        com.baidu.swan.apps.ad.c.a.a aVar2 = new com.baidu.swan.apps.ad.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ad.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b nx = aVar.nx(str);
                    String jsonString = nx == null ? "" : nx.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("invokePluginLoginAndGetUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("invokePluginLoginAndGetUserInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginPayment(String str) {
                com.baidu.swan.apps.ad.c.a.a aVar;
                try {
                    f.aoh().iI("invokePluginPayment");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ad.c.a.a)) {
                        com.baidu.swan.apps.ad.c.a.a aVar2 = new com.baidu.swan.apps.ad.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ad.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b nz = aVar.nz(str);
                    String jsonString = nz == null ? "" : nz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginPayment[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Plugin.invokePluginPayment[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("invokePluginPayment");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("invokePluginPayment");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateBack(String str) {
                com.baidu.swan.apps.api.module.g.a aVar;
                try {
                    f.aoh().iI("navigateBack");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateBack[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.a)) {
                        com.baidu.swan.apps.api.module.g.a aVar2 = new com.baidu.swan.apps.api.module.g.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.g.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ig = aVar.ig(str);
                    String jsonString = ig == null ? "" : ig.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateBack[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.navigateBack[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("navigateBack");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("navigateBack");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateTo(String str) {
                com.baidu.swan.apps.api.module.g.b bVar2;
                try {
                    f.aoh().iI("navigateTo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.b)) {
                        com.baidu.swan.apps.api.module.g.b bVar3 = new com.baidu.swan.apps.api.module.g.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.g.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ih = bVar2.ih(str);
                    String jsonString = ih == null ? "" : ih.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateTo[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.navigateTo[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("navigateTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("navigateTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String reLaunch(String str) {
                com.baidu.swan.apps.api.module.g.d dVar;
                try {
                    f.aoh().iI("reLaunch");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.reLaunch[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.d)) {
                        com.baidu.swan.apps.api.module.g.d dVar2 = new com.baidu.swan.apps.api.module.g.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.g.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ij = dVar.ij(str);
                    String jsonString = ij == null ? "" : ij.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.reLaunch[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.reLaunch[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("reLaunch");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("reLaunch");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String redirectTo(String str) {
                com.baidu.swan.apps.api.module.g.c cVar;
                try {
                    f.aoh().iI("redirectTo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.redirectTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.g.c)) {
                        com.baidu.swan.apps.api.module.g.c cVar2 = new com.baidu.swan.apps.api.module.g.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.g.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ii = cVar.ii(str);
                    String jsonString = ii == null ? "" : ii.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.redirectTo[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Router.redirectTo[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("redirectTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("redirectTo");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getAppInfoSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getAppInfoSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getAppInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VW = aVar.VW();
                    String jsonString = VW == null ? "" : VW.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getAppInfoSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getAppInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getAppInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getAppInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSetting(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getSetting");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSetting[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b il = aVar.il(str);
                    String jsonString = il == null ? "" : il.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSetting[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getSetting[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSetting");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSetting");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSlaveIdSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getSlaveIdSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSlaveIdSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VX = aVar.VX();
                    String jsonString = VX == null ? "" : VX.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSlaveIdSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getSlaveIdSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSlaveIdSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSlaveIdSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSwanId(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getSwanId");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSwanId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ik = aVar.ik(str);
                    String jsonString = ik == null ? "" : ik.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSwanId[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getSwanId[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSwanId");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSwanId");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getUserInfo(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.aoh().iI("getUserInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b im = aVar.im(str);
                    String jsonString = im == null ? "" : im.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getUserInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Setting.getUserInfo[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getUserInfo");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String clearStorage() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("clearStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VZ = aVar.VZ();
                    String jsonString = VZ == null ? "" : VZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.clearStorage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("clearStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("clearStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String clearStorageSync() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("clearStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b VY = aVar.VY();
                    String jsonString = VY == null ? "" : VY.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("clearStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("clearStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("getStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b is = aVar.is(str);
                    String jsonString = is == null ? "" : is.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.getStorage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageInfo() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("getStorageInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wa = aVar.Wa();
                    String jsonString = Wa == null ? "" : Wa.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getStorageInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getStorageInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("getStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ir = aVar.ir(str);
                    String jsonString = ir == null ? "" : ir.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("removeStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iq = aVar.iq(str);
                    String jsonString = iq == null ? "" : iq.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.removeStorage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("removeStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("removeStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("removeStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ip = aVar.ip(str);
                    String jsonString = ip == null ? "" : ip.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("removeStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("removeStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [385=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("setStorage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b io2 = aVar.io(str);
                    String jsonString = io2 == null ? "" : io2.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.setStorage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.aoh().iI("setStorageSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b in = aVar.in(str);
                    String jsonString = in == null ? "" : in.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setStorageSync");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String subscribeService(String str) {
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    f.aoh().iI("subscribeService");
                    if (DEBUG) {
                        Log.d(TAG, "====================Subscription.subscribeService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iu = aVar.iu(str);
                    String jsonString = iu == null ? "" : iu.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Subscription.subscribeService[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Subscription.subscribeService[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("subscribeService");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("subscribeService");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String exitFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.e eVar;
                try {
                    f.aoh().iI("exitFullScreen");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.exitFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.e)) {
                        com.baidu.swan.apps.api.module.k.e eVar2 = new com.baidu.swan.apps.api.module.k.e(this.mSwanApiContext);
                        this.mApis.put("1936205521", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (com.baidu.swan.apps.api.module.k.e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iz = eVar.iz(str);
                    String jsonString = iz == null ? "" : iz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.exitFullScreen[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.exitFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("exitFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("exitFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [127=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getBrightness() {
                com.baidu.swan.apps.api.module.k.b bVar2;
                try {
                    f.aoh().iI("getBrightness");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getBrightness[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.b)) {
                        com.baidu.swan.apps.api.module.k.b bVar3 = new com.baidu.swan.apps.api.module.k.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.k.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wc = bVar2.Wc();
                    String jsonString = Wc == null ? "" : Wc.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getBrightness[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.getBrightness[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getBrightness");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getBrightness");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getClipboardData() {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.aoh().iI("getClipboardData");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wd = cVar.Wd();
                    String jsonString = Wd == null ? "" : Wd.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getClipboardData[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.getClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String makePhoneCall(String str) {
                com.baidu.swan.apps.api.module.k.f fVar;
                try {
                    f.aoh().iI("makePhoneCall");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.makePhoneCall[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.f)) {
                        com.baidu.swan.apps.api.module.k.f fVar2 = new com.baidu.swan.apps.api.module.k.f(this.mSwanApiContext);
                        this.mApis.put("-1569246082", fVar2);
                        fVar = fVar2;
                    } else {
                        fVar = (com.baidu.swan.apps.api.module.k.f) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(fVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iA = fVar.iA(str);
                    String jsonString = iA == null ? "" : iA.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.makePhoneCall[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.makePhoneCall[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("makePhoneCall");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("makePhoneCall");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [259=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String requestFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.g gVar;
                try {
                    f.aoh().iI("requestFullScreen");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.requestFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.g)) {
                        com.baidu.swan.apps.api.module.k.g gVar2 = new com.baidu.swan.apps.api.module.k.g(this.mSwanApiContext);
                        this.mApis.put("-1707203360", gVar2);
                        gVar = gVar2;
                    } else {
                        gVar = (com.baidu.swan.apps.api.module.k.g) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(gVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iB = gVar.iB(str);
                    String jsonString = iB == null ? "" : iB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.requestFullScreen[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.requestFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("requestFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("requestFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [303=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setClipboardData(String str) {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.aoh().iI("setClipboardData");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.setClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b ix = cVar.ix(str);
                    String jsonString = ix == null ? "" : ix.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.setClipboardData[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.setClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("setClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("setClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [347=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startAccelerometer(String str) {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.aoh().iI("startAccelerometer");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iv = aVar.iv(str);
                    String jsonString = iv == null ? "" : iv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startAccelerometer[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.startAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("startAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("startAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startCompass(String str) {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.aoh().iI("startCompass");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.startCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iy = dVar.iy(str);
                    String jsonString = iy == null ? "" : iy.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startCompass[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.startCompass[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("startCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("startCompass");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [435=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopAccelerometer() {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.aoh().iI("stopAccelerometer");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wb = aVar.Wb();
                    String jsonString = Wb == null ? "" : Wb.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [479=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopCompass() {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.aoh().iI("stopCompass");
                    if (DEBUG) {
                        Log.d(TAG, "====================System.stopCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar2);
                        dVar = dVar2;
                    } else {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b We = dVar.We();
                    String jsonString = We == null ? "" : We.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopCompass[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[System.stopCompass[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("stopCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("stopCompass");
                    }
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

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String checkAppInstalled(String str) {
                com.baidu.swan.apps.api.module.l.a aVar;
                try {
                    f.aoh().iI("checkAppInstalled");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.checkAppInstalled[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.a)) {
                        com.baidu.swan.apps.api.module.l.a aVar2 = new com.baidu.swan.apps.api.module.l.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.api.module.l.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iF = aVar.iF(str);
                    String jsonString = iF == null ? "" : iF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("checkAppInstalled");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("checkAppInstalled");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getCommonSysInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.aoh().iI("getCommonSysInfoSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getCommonSysInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wr = cVar.Wr();
                    String jsonString = Wr == null ? "" : Wr.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getCommonSysInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getCommonSysInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfo() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.aoh().iI("getSystemInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wo = cVar.Wo();
                    String jsonString = Wo == null ? "" : Wo.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSystemInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSystemInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.aoh().iI("getSystemInfoSync");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(cVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b Wp = cVar.Wp();
                    String jsonString = Wp == null ? "" : Wp.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("getSystemInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("getSystemInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String previewImage(String str) {
                com.baidu.swan.apps.api.module.l.b bVar2;
                try {
                    f.aoh().iI("previewImage");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.previewImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.b)) {
                        com.baidu.swan.apps.api.module.l.b bVar3 = new com.baidu.swan.apps.api.module.l.b(this.mSwanApiContext);
                        this.mApis.put("589529211", bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (com.baidu.swan.apps.api.module.l.b) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(bVar2, "swanAPI/previewImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iG = bVar2.iG(str);
                    String jsonString = iG == null ? "" : iG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.previewImage[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.previewImage[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("previewImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("previewImage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [300=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String ubcFlowJar(String str) {
                com.baidu.swan.apps.api.module.l.e eVar;
                try {
                    f.aoh().iI("ubcFlowJar");
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.ubcFlowJar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.api.module.l.e)) {
                        com.baidu.swan.apps.api.module.l.e eVar2 = new com.baidu.swan.apps.api.module.l.e(this.mSwanApiContext);
                        this.mApis.put("-577481801", eVar2);
                        eVar = eVar2;
                    } else {
                        eVar = (com.baidu.swan.apps.api.module.l.e) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(eVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b iH = eVar.iH(str);
                    String jsonString = iH == null ? "" : iH.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] result]]" + jsonString);
                    }
                    return jsonString;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw th;
                                }
                            });
                            f.aoh().iJ("ubcFlowJar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.aoh().iJ("ubcFlowJar");
                    }
                }
            }
        });
        return hashMap;
    }
}
