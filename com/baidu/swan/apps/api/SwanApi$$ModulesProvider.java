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
/* loaded from: classes11.dex */
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
                    f.alH().iq("checkSession");
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
                    com.baidu.swan.apps.api.c.b hd = aVar.hd(str);
                    String jsonString = hd == null ? "" : hd.toJsonString();
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
                            f.alH().ir("checkSession");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("checkSession");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [122=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String isLoginSync() {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.alH().iq("isLoginSync");
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
                    com.baidu.swan.apps.api.c.b TV = bVar2.TV();
                    String jsonString = TV == null ? "" : TV.toJsonString();
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
                            f.alH().ir("isLoginSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("isLoginSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String login(String str) {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.alH().iq(c.k);
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
                    com.baidu.swan.apps.api.c.b he = bVar2.he(str);
                    String jsonString = he == null ? "" : he.toJsonString();
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
                            f.alH().ir(c.k);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir(c.k);
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
                    f.alH().iq("loadSubPackage");
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
                    com.baidu.swan.apps.api.c.b hf = aVar.hf(str);
                    String jsonString = hf == null ? "" : hf.toJsonString();
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
                            f.alH().ir("loadSubPackage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("loadSubPackage");
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
                    f.alH().iq("showFavoriteGuide");
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
                    com.baidu.swan.apps.api.c.b hh = showFavoriteGuideApi.hh(str);
                    String jsonString = hh == null ? "" : hh.toJsonString();
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
                            f.alH().ir("showFavoriteGuide");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showFavoriteGuide");
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
                    f.alH().iq("shareFile");
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
                    com.baidu.swan.apps.api.c.b hi = aVar.hi(str);
                    String jsonString = hi == null ? "" : hi.toJsonString();
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
                            f.alH().ir("shareFile");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("shareFile");
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
                    f.alH().iq("postGameCenterMessage");
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
                    com.baidu.swan.apps.api.c.b kp = aVar.kp(str);
                    String jsonString = kp == null ? "" : kp.toJsonString();
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
                            f.alH().ir("postGameCenterMessage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("postGameCenterMessage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                com.baidu.swan.apps.n.a aVar;
                try {
                    f.alH().iq("postGameCenterMessageSync");
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
                    com.baidu.swan.apps.api.c.b kq = aVar.kq(str);
                    String jsonString = kq == null ? "" : kq.toJsonString();
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
                            f.alH().ir("postGameCenterMessageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("postGameCenterMessageSync");
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
                    f.alH().iq("compressImage");
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
                    com.baidu.swan.apps.api.c.b hk = aVar.hk(str);
                    String jsonString = hk == null ? "" : hk.toJsonString();
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
                            f.alH().ir("compressImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("compressImage");
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
                    f.alH().iq("closeTabBar");
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
                    com.baidu.swan.apps.api.c.b hB = gVar.hB(str);
                    String jsonString = hB == null ? "" : hB.toJsonString();
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
                            f.alH().ir("closeTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("closeTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                g gVar;
                try {
                    f.alH().iq("closeTabBarRedDot");
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
                    com.baidu.swan.apps.api.c.b hy = gVar.hy(str);
                    String jsonString = hy == null ? "" : hy.toJsonString();
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
                            f.alH().ir("closeTabBarRedDot");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("closeTabBarRedDot");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideLoading() {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.alH().iq("hideLoading");
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
                    com.baidu.swan.apps.api.c.b Uc = aVar.Uc();
                    String jsonString = Uc == null ? "" : Uc.toJsonString();
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
                            f.alH().ir("hideLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("hideLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [216=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("hideNavigationBarLoading");
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
                    com.baidu.swan.apps.api.c.b hp = cVar.hp(str);
                    String jsonString = hp == null ? "" : hp.toJsonString();
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
                            f.alH().ir("hideNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("hideNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [260=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideToast() {
                h hVar;
                try {
                    f.alH().iq("hideToast");
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
                    com.baidu.swan.apps.api.c.b Uf = hVar.Uf();
                    String jsonString = Uf == null ? "" : Uf.toJsonString();
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
                            f.alH().ir("hideToast");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("hideToast");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [304=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openMultiPicker(String str) {
                e eVar;
                try {
                    f.alH().iq("openMultiPicker");
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
                    com.baidu.swan.apps.api.c.b hu = eVar.hu(str);
                    String jsonString = hu == null ? "" : hu.toJsonString();
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
                            f.alH().ir("openMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("openMultiPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openPicker(String str) {
                e eVar;
                try {
                    f.alH().iq("openPicker");
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
                    com.baidu.swan.apps.api.c.b ht = eVar.ht(str);
                    String jsonString = ht == null ? "" : ht.toJsonString();
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
                            f.alH().ir("openPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("openPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [392=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openTabBar(String str) {
                g gVar;
                try {
                    f.alH().iq("openTabBar");
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
                    com.baidu.swan.apps.api.c.b hA = gVar.hA(str);
                    String jsonString = hA == null ? "" : hA.toJsonString();
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
                            f.alH().ir("openTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("openTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [436=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String pageScrollTo(String str) {
                com.baidu.swan.apps.api.module.e.d dVar;
                try {
                    f.alH().iq("pageScrollTo");
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
                    com.baidu.swan.apps.api.c.b hr = dVar.hr(str);
                    String jsonString = hr == null ? "" : hr.toJsonString();
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
                            f.alH().ir("pageScrollTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("pageScrollTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("setNavigationBarColor");
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
                    com.baidu.swan.apps.api.c.b ho = cVar.ho(str);
                    String jsonString = ho == null ? "" : ho.toJsonString();
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
                            f.alH().ir("setNavigationBarColor");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setNavigationBarColor");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [524=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("setNavigationBarTitle");
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
                    com.baidu.swan.apps.api.c.b hn = cVar.hn(str);
                    String jsonString = hn == null ? "" : hn.toJsonString();
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
                            f.alH().ir("setNavigationBarTitle");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setNavigationBarTitle");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [568=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setTabBarItem(String str) {
                g gVar;
                try {
                    f.alH().iq("setTabBarItem");
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
                    com.baidu.swan.apps.api.c.b hz = gVar.hz(str);
                    String jsonString = hz == null ? "" : hz.toJsonString();
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
                            f.alH().ir("setTabBarItem");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setTabBarItem");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [612=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showDatePickerView(String str) {
                e eVar;
                try {
                    f.alH().iq("showDatePickerView");
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
                    com.baidu.swan.apps.api.c.b hs = eVar.hs(str);
                    String jsonString = hs == null ? "" : hs.toJsonString();
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
                            f.alH().ir("showDatePickerView");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showDatePickerView");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [656=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showLoading(String str) {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.alH().iq("showLoading");
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
                    com.baidu.swan.apps.api.c.b hl = aVar.hl(str);
                    String jsonString = hl == null ? "" : hl.toJsonString();
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
                            f.alH().ir("showLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [700=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showModal(String str) {
                com.baidu.swan.apps.api.module.e.b bVar2;
                try {
                    f.alH().iq("showModal");
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
                    com.baidu.swan.apps.api.c.b hm = bVar2.hm(str);
                    String jsonString = hm == null ? "" : hm.toJsonString();
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
                            f.alH().ir("showModal");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showModal");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [744=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("showNavigationBarLoading");
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
                    com.baidu.swan.apps.api.c.b hq = cVar.hq(str);
                    String jsonString = hq == null ? "" : hq.toJsonString();
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
                            f.alH().ir("showNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [788=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showToast(String str) {
                h hVar;
                try {
                    f.alH().iq(PopItemMethodConstant.showToast);
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
                    com.baidu.swan.apps.api.c.b hC = hVar.hC(str);
                    String jsonString = hC == null ? "" : hC.toJsonString();
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
                            f.alH().ir(PopItemMethodConstant.showToast);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir(PopItemMethodConstant.showToast);
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [832=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                com.baidu.swan.apps.api.module.e.f fVar;
                try {
                    f.alH().iq("stopPullDownRefresh");
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
                    com.baidu.swan.apps.api.c.b hx = fVar.hx(str);
                    String jsonString = hx == null ? "" : hx.toJsonString();
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
                            f.alH().ir("stopPullDownRefresh");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("stopPullDownRefresh");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [876=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String updateMultiPicker(String str) {
                e eVar;
                try {
                    f.alH().iq("updateMultiPicker");
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
                    com.baidu.swan.apps.api.c.b hv = eVar.hv(str);
                    String jsonString = hv == null ? "" : hv.toJsonString();
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
                            f.alH().ir("updateMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("updateMultiPicker");
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
                    f.alH().iq("getLocation");
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
                    com.baidu.swan.apps.api.c.b hF = aVar.hF(str);
                    String jsonString = hF == null ? "" : hF.toJsonString();
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
                            f.alH().ir("getLocation");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getLocation");
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
                    f.alH().iq("cancelRequest");
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
                    com.baidu.swan.apps.api.c.b hI = bVar2.hI(str);
                    String jsonString = hI == null ? "" : hI.toJsonString();
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
                            f.alH().ir("cancelRequest");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("cancelRequest");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getNetworkType() {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.alH().iq("getNetworkType");
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
                    com.baidu.swan.apps.api.c.b Ui = aVar.Ui();
                    String jsonString = Ui == null ? "" : Ui.toJsonString();
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
                            f.alH().ir("getNetworkType");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getNetworkType");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [169=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String networkStatusChange(String str) {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.alH().iq("networkStatusChange");
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
                    com.baidu.swan.apps.api.c.b hH = aVar.hH(str);
                    String jsonString = hH == null ? "" : hH.toJsonString();
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
                            f.alH().ir("networkStatusChange");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("networkStatusChange");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=6, 226=6] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    com.baidu.swan.apps.api.b.c.UG().iq("request");
                    f.alH().iq("request");
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
                            return com.baidu.swan.apps.api.c.a.bMU.toJsonString();
                        }
                        if (DEBUG) {
                            Log.d(TAG, "JsObject->JSONObject: " + jSONObject.toString());
                        }
                        com.baidu.swan.apps.api.c.b ak = bVar2.ak(jSONObject);
                        String jsonString = ak == null ? "" : ak.toJsonString();
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
                            com.baidu.swan.apps.api.b.c.UG().ir("request");
                            f.alH().ir("request");
                            return "";
                        }
                        throw th;
                    } finally {
                        com.baidu.swan.apps.api.b.c.UG().ir("request");
                        f.alH().ir("request");
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
                com.baidu.swan.apps.ae.c.a.a aVar;
                try {
                    f.alH().iq("invokePluginChooseAddress");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ae.c.a.a)) {
                        com.baidu.swan.apps.ae.c.a.a aVar2 = new com.baidu.swan.apps.ae.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ae.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mJ = aVar.mJ(str);
                    String jsonString = mJ == null ? "" : mJ.toJsonString();
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
                            f.alH().ir("invokePluginChooseAddress");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("invokePluginChooseAddress");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                com.baidu.swan.apps.ae.c.a.a aVar;
                try {
                    f.alH().iq("invokePluginLoginAndGetUserInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ae.c.a.a)) {
                        com.baidu.swan.apps.ae.c.a.a aVar2 = new com.baidu.swan.apps.ae.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ae.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mI = aVar.mI(str);
                    String jsonString = mI == null ? "" : mI.toJsonString();
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
                            f.alH().ir("invokePluginLoginAndGetUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("invokePluginLoginAndGetUserInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginPayment(String str) {
                com.baidu.swan.apps.ae.c.a.a aVar;
                try {
                    f.alH().iq("invokePluginPayment");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ae.c.a.a)) {
                        com.baidu.swan.apps.ae.c.a.a aVar2 = new com.baidu.swan.apps.ae.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ae.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mK = aVar.mK(str);
                    String jsonString = mK == null ? "" : mK.toJsonString();
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
                            f.alH().ir("invokePluginPayment");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("invokePluginPayment");
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
                    f.alH().iq("navigateBack");
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
                    com.baidu.swan.apps.api.c.b hO = aVar.hO(str);
                    String jsonString = hO == null ? "" : hO.toJsonString();
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
                            f.alH().ir("navigateBack");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("navigateBack");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateTo(String str) {
                com.baidu.swan.apps.api.module.g.b bVar2;
                try {
                    f.alH().iq("navigateTo");
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
                    com.baidu.swan.apps.api.c.b hP = bVar2.hP(str);
                    String jsonString = hP == null ? "" : hP.toJsonString();
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
                            f.alH().ir("navigateTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("navigateTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String reLaunch(String str) {
                com.baidu.swan.apps.api.module.g.d dVar;
                try {
                    f.alH().iq("reLaunch");
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
                    com.baidu.swan.apps.api.c.b hR = dVar.hR(str);
                    String jsonString = hR == null ? "" : hR.toJsonString();
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
                            f.alH().ir("reLaunch");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("reLaunch");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String redirectTo(String str) {
                com.baidu.swan.apps.api.module.g.c cVar;
                try {
                    f.alH().iq("redirectTo");
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
                    com.baidu.swan.apps.api.c.b hQ = cVar.hQ(str);
                    String jsonString = hQ == null ? "" : hQ.toJsonString();
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
                            f.alH().ir("redirectTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("redirectTo");
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
                    f.alH().iq("getAppInfoSync");
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
                    com.baidu.swan.apps.api.c.b Uk = aVar.Uk();
                    String jsonString = Uk == null ? "" : Uk.toJsonString();
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
                            f.alH().ir("getAppInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getAppInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSetting(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getSetting");
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
                    com.baidu.swan.apps.api.c.b hT = aVar.hT(str);
                    String jsonString = hT == null ? "" : hT.toJsonString();
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
                            f.alH().ir("getSetting");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSetting");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSlaveIdSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getSlaveIdSync");
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
                    com.baidu.swan.apps.api.c.b Ul = aVar.Ul();
                    String jsonString = Ul == null ? "" : Ul.toJsonString();
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
                            f.alH().ir("getSlaveIdSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSlaveIdSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSwanId(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getSwanId");
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
                    com.baidu.swan.apps.api.c.b hS = aVar.hS(str);
                    String jsonString = hS == null ? "" : hS.toJsonString();
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
                            f.alH().ir("getSwanId");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSwanId");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getUserInfo(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getUserInfo");
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
                    com.baidu.swan.apps.api.c.b hU = aVar.hU(str);
                    String jsonString = hU == null ? "" : hU.toJsonString();
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
                            f.alH().ir("getUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getUserInfo");
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
                    f.alH().iq("clearStorage");
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
                    com.baidu.swan.apps.api.c.b Un = aVar.Un();
                    String jsonString = Un == null ? "" : Un.toJsonString();
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
                            f.alH().ir("clearStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("clearStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String clearStorageSync() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("clearStorageSync");
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
                    com.baidu.swan.apps.api.c.b Um = aVar.Um();
                    String jsonString = Um == null ? "" : Um.toJsonString();
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
                            f.alH().ir("clearStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("clearStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("getStorage");
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
                    com.baidu.swan.apps.api.c.b ia = aVar.ia(str);
                    String jsonString = ia == null ? "" : ia.toJsonString();
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
                            f.alH().ir("getStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageInfo() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("getStorageInfo");
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
                    com.baidu.swan.apps.api.c.b Uo = aVar.Uo();
                    String jsonString = Uo == null ? "" : Uo.toJsonString();
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
                            f.alH().ir("getStorageInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getStorageInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("getStorageSync");
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
                    com.baidu.swan.apps.api.c.b hZ = aVar.hZ(str);
                    String jsonString = hZ == null ? "" : hZ.toJsonString();
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
                            f.alH().ir("getStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("removeStorage");
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
                    com.baidu.swan.apps.api.c.b hY = aVar.hY(str);
                    String jsonString = hY == null ? "" : hY.toJsonString();
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
                            f.alH().ir("removeStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("removeStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("removeStorageSync");
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
                    com.baidu.swan.apps.api.c.b hX = aVar.hX(str);
                    String jsonString = hX == null ? "" : hX.toJsonString();
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
                            f.alH().ir("removeStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("removeStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [385=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("setStorage");
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
                    com.baidu.swan.apps.api.c.b hW = aVar.hW(str);
                    String jsonString = hW == null ? "" : hW.toJsonString();
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
                            f.alH().ir("setStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("setStorageSync");
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
                    com.baidu.swan.apps.api.c.b hV = aVar.hV(str);
                    String jsonString = hV == null ? "" : hV.toJsonString();
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
                            f.alH().ir("setStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setStorageSync");
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
                    f.alH().iq("subscribeService");
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
                    com.baidu.swan.apps.api.c.b ic = aVar.ic(str);
                    String jsonString = ic == null ? "" : ic.toJsonString();
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
                            f.alH().ir("subscribeService");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("subscribeService");
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
                    f.alH().iq("exitFullScreen");
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
                    com.baidu.swan.apps.api.c.b ih = eVar.ih(str);
                    String jsonString = ih == null ? "" : ih.toJsonString();
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
                            f.alH().ir("exitFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("exitFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [127=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getBrightness() {
                com.baidu.swan.apps.api.module.k.b bVar2;
                try {
                    f.alH().iq("getBrightness");
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
                    com.baidu.swan.apps.api.c.b Uq = bVar2.Uq();
                    String jsonString = Uq == null ? "" : Uq.toJsonString();
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
                            f.alH().ir("getBrightness");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getBrightness");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getClipboardData() {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.alH().iq("getClipboardData");
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
                    com.baidu.swan.apps.api.c.b Ur = cVar.Ur();
                    String jsonString = Ur == null ? "" : Ur.toJsonString();
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
                            f.alH().ir("getClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String makePhoneCall(String str) {
                com.baidu.swan.apps.api.module.k.f fVar;
                try {
                    f.alH().iq("makePhoneCall");
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
                    com.baidu.swan.apps.api.c.b ii = fVar.ii(str);
                    String jsonString = ii == null ? "" : ii.toJsonString();
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
                            f.alH().ir("makePhoneCall");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("makePhoneCall");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [259=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String requestFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.g gVar;
                try {
                    f.alH().iq("requestFullScreen");
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
                    com.baidu.swan.apps.api.c.b ij = gVar.ij(str);
                    String jsonString = ij == null ? "" : ij.toJsonString();
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
                            f.alH().ir("requestFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("requestFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [303=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setClipboardData(String str) {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.alH().iq("setClipboardData");
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
                    com.baidu.swan.apps.api.c.b m25if = cVar.m25if(str);
                    String jsonString = m25if == null ? "" : m25if.toJsonString();
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
                            f.alH().ir("setClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [347=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startAccelerometer(String str) {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.alH().iq("startAccelerometer");
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
                    com.baidu.swan.apps.api.c.b id = aVar.id(str);
                    String jsonString = id == null ? "" : id.toJsonString();
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
                            f.alH().ir("startAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("startAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startCompass(String str) {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.alH().iq("startCompass");
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
                    com.baidu.swan.apps.api.c.b ig = dVar.ig(str);
                    String jsonString = ig == null ? "" : ig.toJsonString();
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
                            f.alH().ir("startCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("startCompass");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [435=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopAccelerometer() {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.alH().iq("stopAccelerometer");
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
                    com.baidu.swan.apps.api.c.b Up = aVar.Up();
                    String jsonString = Up == null ? "" : Up.toJsonString();
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
                            f.alH().ir("stopAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("stopAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [479=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopCompass() {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.alH().iq("stopCompass");
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
                    com.baidu.swan.apps.api.c.b Us = dVar.Us();
                    String jsonString = Us == null ? "" : Us.toJsonString();
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
                            f.alH().ir("stopCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("stopCompass");
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
                    f.alH().iq("checkAppInstalled");
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
                    com.baidu.swan.apps.api.c.b in = aVar.in(str);
                    String jsonString = in == null ? "" : in.toJsonString();
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
                            f.alH().ir("checkAppInstalled");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("checkAppInstalled");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getCommonSysInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.alH().iq("getCommonSysInfoSync");
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
                    com.baidu.swan.apps.api.c.b UE = cVar.UE();
                    String jsonString = UE == null ? "" : UE.toJsonString();
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
                            f.alH().ir("getCommonSysInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getCommonSysInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfo() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.alH().iq("getSystemInfo");
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
                    com.baidu.swan.apps.api.c.b UC = cVar.UC();
                    String jsonString = UC == null ? "" : UC.toJsonString();
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
                            f.alH().ir("getSystemInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSystemInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.alH().iq("getSystemInfoSync");
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
                    com.baidu.swan.apps.api.c.b UD = cVar.UD();
                    String jsonString = UD == null ? "" : UD.toJsonString();
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
                            f.alH().ir("getSystemInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSystemInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String previewImage(String str) {
                com.baidu.swan.apps.api.module.l.b bVar2;
                try {
                    f.alH().iq("previewImage");
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
                    com.baidu.swan.apps.api.c.b io2 = bVar2.io(str);
                    String jsonString = io2 == null ? "" : io2.toJsonString();
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
                            f.alH().ir("previewImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("previewImage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [300=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String ubcFlowJar(String str) {
                com.baidu.swan.apps.api.module.l.e eVar;
                try {
                    f.alH().iq("ubcFlowJar");
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
                    com.baidu.swan.apps.api.c.b ip = eVar.ip(str);
                    String jsonString = ip == null ? "" : ip.toJsonString();
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
                            f.alH().ir("ubcFlowJar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("ubcFlowJar");
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
                    f.alH().iq("checkSession");
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
                    com.baidu.swan.apps.api.c.b hd = aVar.hd(str);
                    String jsonString = hd == null ? "" : hd.toJsonString();
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
                            f.alH().ir("checkSession");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("checkSession");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [122=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String isLoginSync() {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.alH().iq("isLoginSync");
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
                    com.baidu.swan.apps.api.c.b TV = bVar2.TV();
                    String jsonString = TV == null ? "" : TV.toJsonString();
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
                            f.alH().ir("isLoginSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("isLoginSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String login(String str) {
                com.baidu.swan.apps.api.module.a.b bVar2;
                try {
                    f.alH().iq(c.k);
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
                    com.baidu.swan.apps.api.c.b he = bVar2.he(str);
                    String jsonString = he == null ? "" : he.toJsonString();
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
                            f.alH().ir(c.k);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir(c.k);
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
                    f.alH().iq("loadSubPackage");
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
                    com.baidu.swan.apps.api.c.b hf = aVar.hf(str);
                    String jsonString = hf == null ? "" : hf.toJsonString();
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
                            f.alH().ir("loadSubPackage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("loadSubPackage");
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
                    f.alH().iq("showFavoriteGuide");
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
                    com.baidu.swan.apps.api.c.b hh = showFavoriteGuideApi.hh(str);
                    String jsonString = hh == null ? "" : hh.toJsonString();
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
                            f.alH().ir("showFavoriteGuide");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showFavoriteGuide");
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
                    f.alH().iq("shareFile");
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
                    com.baidu.swan.apps.api.c.b hi = aVar.hi(str);
                    String jsonString = hi == null ? "" : hi.toJsonString();
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
                            f.alH().ir("shareFile");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("shareFile");
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
                    f.alH().iq("postGameCenterMessage");
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
                    com.baidu.swan.apps.api.c.b kp = aVar.kp(str);
                    String jsonString = kp == null ? "" : kp.toJsonString();
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
                            f.alH().ir("postGameCenterMessage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("postGameCenterMessage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                com.baidu.swan.apps.n.a aVar;
                try {
                    f.alH().iq("postGameCenterMessageSync");
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
                    com.baidu.swan.apps.api.c.b kq = aVar.kq(str);
                    String jsonString = kq == null ? "" : kq.toJsonString();
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
                            f.alH().ir("postGameCenterMessageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("postGameCenterMessageSync");
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
                    f.alH().iq("compressImage");
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
                    com.baidu.swan.apps.api.c.b hk = aVar.hk(str);
                    String jsonString = hk == null ? "" : hk.toJsonString();
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
                            f.alH().ir("compressImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("compressImage");
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
                    f.alH().iq("closeTabBar");
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
                    com.baidu.swan.apps.api.c.b hB = gVar.hB(str);
                    String jsonString = hB == null ? "" : hB.toJsonString();
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
                            f.alH().ir("closeTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("closeTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                g gVar;
                try {
                    f.alH().iq("closeTabBarRedDot");
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
                    com.baidu.swan.apps.api.c.b hy = gVar.hy(str);
                    String jsonString = hy == null ? "" : hy.toJsonString();
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
                            f.alH().ir("closeTabBarRedDot");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("closeTabBarRedDot");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideLoading() {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.alH().iq("hideLoading");
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
                    com.baidu.swan.apps.api.c.b Uc = aVar.Uc();
                    String jsonString = Uc == null ? "" : Uc.toJsonString();
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
                            f.alH().ir("hideLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("hideLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [216=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("hideNavigationBarLoading");
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
                    com.baidu.swan.apps.api.c.b hp = cVar.hp(str);
                    String jsonString = hp == null ? "" : hp.toJsonString();
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
                            f.alH().ir("hideNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("hideNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [260=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String hideToast() {
                h hVar;
                try {
                    f.alH().iq("hideToast");
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
                    com.baidu.swan.apps.api.c.b Uf = hVar.Uf();
                    String jsonString = Uf == null ? "" : Uf.toJsonString();
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
                            f.alH().ir("hideToast");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("hideToast");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [304=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openMultiPicker(String str) {
                e eVar;
                try {
                    f.alH().iq("openMultiPicker");
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
                    com.baidu.swan.apps.api.c.b hu = eVar.hu(str);
                    String jsonString = hu == null ? "" : hu.toJsonString();
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
                            f.alH().ir("openMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("openMultiPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openPicker(String str) {
                e eVar;
                try {
                    f.alH().iq("openPicker");
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
                    com.baidu.swan.apps.api.c.b ht = eVar.ht(str);
                    String jsonString = ht == null ? "" : ht.toJsonString();
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
                            f.alH().ir("openPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("openPicker");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [392=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String openTabBar(String str) {
                g gVar;
                try {
                    f.alH().iq("openTabBar");
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
                    com.baidu.swan.apps.api.c.b hA = gVar.hA(str);
                    String jsonString = hA == null ? "" : hA.toJsonString();
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
                            f.alH().ir("openTabBar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("openTabBar");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [436=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String pageScrollTo(String str) {
                com.baidu.swan.apps.api.module.e.d dVar;
                try {
                    f.alH().iq("pageScrollTo");
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
                    com.baidu.swan.apps.api.c.b hr = dVar.hr(str);
                    String jsonString = hr == null ? "" : hr.toJsonString();
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
                            f.alH().ir("pageScrollTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("pageScrollTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("setNavigationBarColor");
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
                    com.baidu.swan.apps.api.c.b ho = cVar.ho(str);
                    String jsonString = ho == null ? "" : ho.toJsonString();
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
                            f.alH().ir("setNavigationBarColor");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setNavigationBarColor");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [524=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("setNavigationBarTitle");
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
                    com.baidu.swan.apps.api.c.b hn = cVar.hn(str);
                    String jsonString = hn == null ? "" : hn.toJsonString();
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
                            f.alH().ir("setNavigationBarTitle");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setNavigationBarTitle");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [568=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setTabBarItem(String str) {
                g gVar;
                try {
                    f.alH().iq("setTabBarItem");
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
                    com.baidu.swan.apps.api.c.b hz = gVar.hz(str);
                    String jsonString = hz == null ? "" : hz.toJsonString();
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
                            f.alH().ir("setTabBarItem");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setTabBarItem");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [612=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showDatePickerView(String str) {
                e eVar;
                try {
                    f.alH().iq("showDatePickerView");
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
                    com.baidu.swan.apps.api.c.b hs = eVar.hs(str);
                    String jsonString = hs == null ? "" : hs.toJsonString();
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
                            f.alH().ir("showDatePickerView");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showDatePickerView");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [656=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showLoading(String str) {
                com.baidu.swan.apps.api.module.e.a aVar;
                try {
                    f.alH().iq("showLoading");
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
                    com.baidu.swan.apps.api.c.b hl = aVar.hl(str);
                    String jsonString = hl == null ? "" : hl.toJsonString();
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
                            f.alH().ir("showLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [700=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showModal(String str) {
                com.baidu.swan.apps.api.module.e.b bVar2;
                try {
                    f.alH().iq("showModal");
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
                    com.baidu.swan.apps.api.c.b hm = bVar2.hm(str);
                    String jsonString = hm == null ? "" : hm.toJsonString();
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
                            f.alH().ir("showModal");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showModal");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [744=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    f.alH().iq("showNavigationBarLoading");
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
                    com.baidu.swan.apps.api.c.b hq = cVar.hq(str);
                    String jsonString = hq == null ? "" : hq.toJsonString();
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
                            f.alH().ir("showNavigationBarLoading");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("showNavigationBarLoading");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [788=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String showToast(String str) {
                h hVar;
                try {
                    f.alH().iq(PopItemMethodConstant.showToast);
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
                    com.baidu.swan.apps.api.c.b hC = hVar.hC(str);
                    String jsonString = hC == null ? "" : hC.toJsonString();
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
                            f.alH().ir(PopItemMethodConstant.showToast);
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir(PopItemMethodConstant.showToast);
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [832=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                com.baidu.swan.apps.api.module.e.f fVar;
                try {
                    f.alH().iq("stopPullDownRefresh");
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
                    com.baidu.swan.apps.api.c.b hx = fVar.hx(str);
                    String jsonString = hx == null ? "" : hx.toJsonString();
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
                            f.alH().ir("stopPullDownRefresh");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("stopPullDownRefresh");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [876=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String updateMultiPicker(String str) {
                e eVar;
                try {
                    f.alH().iq("updateMultiPicker");
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
                    com.baidu.swan.apps.api.c.b hv = eVar.hv(str);
                    String jsonString = hv == null ? "" : hv.toJsonString();
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
                            f.alH().ir("updateMultiPicker");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("updateMultiPicker");
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
                    f.alH().iq("getLocation");
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
                    com.baidu.swan.apps.api.c.b hF = aVar.hF(str);
                    String jsonString = hF == null ? "" : hF.toJsonString();
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
                            f.alH().ir("getLocation");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getLocation");
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
                    f.alH().iq("cancelRequest");
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
                    com.baidu.swan.apps.api.c.b hI = bVar2.hI(str);
                    String jsonString = hI == null ? "" : hI.toJsonString();
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
                            f.alH().ir("cancelRequest");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("cancelRequest");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getNetworkType() {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.alH().iq("getNetworkType");
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
                    com.baidu.swan.apps.api.c.b Ui = aVar.Ui();
                    String jsonString = Ui == null ? "" : Ui.toJsonString();
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
                            f.alH().ir("getNetworkType");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getNetworkType");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String networkStatusChange(String str) {
                com.baidu.swan.apps.api.module.network.a aVar;
                try {
                    f.alH().iq("networkStatusChange");
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
                    com.baidu.swan.apps.api.c.b hH = aVar.hH(str);
                    String jsonString = hH == null ? "" : hH.toJsonString();
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
                            f.alH().ir("networkStatusChange");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("networkStatusChange");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [224=6, 225=6] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                com.baidu.swan.apps.api.module.network.b bVar2;
                try {
                    com.baidu.swan.apps.api.b.c.UG().iq("request");
                    f.alH().iq("request");
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
                    Pair<com.baidu.swan.apps.api.c.a, JSONObject> hb = d.hb(str);
                    if (((com.baidu.swan.apps.api.c.a) hb.first).isSuccess()) {
                        JSONObject jSONObject = (JSONObject) hb.second;
                        if (jSONObject == null) {
                            return com.baidu.swan.apps.api.c.a.bMU.toJsonString();
                        }
                        if (DEBUG) {
                            Log.d(TAG, "JsObject->JSONObject: " + jSONObject.toString());
                        }
                        com.baidu.swan.apps.api.c.b ak = bVar2.ak(jSONObject);
                        String jsonString = ak == null ? "" : ak.toJsonString();
                        if (DEBUG) {
                            Log.d(TAG, "====================[[Network.request[type:Webview, v8 binding:true] result]]" + jsonString);
                        }
                        return jsonString;
                    }
                    return ((com.baidu.swan.apps.api.c.a) hb.first).toJsonString();
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
                            com.baidu.swan.apps.api.b.c.UG().ir("request");
                            f.alH().ir("request");
                            return "";
                        }
                        throw th;
                    } finally {
                        com.baidu.swan.apps.api.b.c.UG().ir("request");
                        f.alH().ir("request");
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
                com.baidu.swan.apps.ae.c.a.a aVar;
                try {
                    f.alH().iq("invokePluginChooseAddress");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ae.c.a.a)) {
                        com.baidu.swan.apps.ae.c.a.a aVar2 = new com.baidu.swan.apps.ae.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ae.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mJ = aVar.mJ(str);
                    String jsonString = mJ == null ? "" : mJ.toJsonString();
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
                            f.alH().ir("invokePluginChooseAddress");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("invokePluginChooseAddress");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                com.baidu.swan.apps.ae.c.a.a aVar;
                try {
                    f.alH().iq("invokePluginLoginAndGetUserInfo");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ae.c.a.a)) {
                        com.baidu.swan.apps.ae.c.a.a aVar2 = new com.baidu.swan.apps.ae.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ae.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mI = aVar.mI(str);
                    String jsonString = mI == null ? "" : mI.toJsonString();
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
                            f.alH().ir("invokePluginLoginAndGetUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("invokePluginLoginAndGetUserInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String invokePluginPayment(String str) {
                com.baidu.swan.apps.ae.c.a.a aVar;
                try {
                    f.alH().iq("invokePluginPayment");
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj == null || !(obj instanceof com.baidu.swan.apps.ae.c.a.a)) {
                        com.baidu.swan.apps.ae.c.a.a aVar2 = new com.baidu.swan.apps.ae.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    } else {
                        aVar = (com.baidu.swan.apps.ae.c.a.a) obj;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.c.a> a = com.baidu.swan.apps.api.d.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.c.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.c.b mK = aVar.mK(str);
                    String jsonString = mK == null ? "" : mK.toJsonString();
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
                            f.alH().ir("invokePluginPayment");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("invokePluginPayment");
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
                    f.alH().iq("navigateBack");
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
                    com.baidu.swan.apps.api.c.b hO = aVar.hO(str);
                    String jsonString = hO == null ? "" : hO.toJsonString();
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
                            f.alH().ir("navigateBack");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("navigateBack");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String navigateTo(String str) {
                com.baidu.swan.apps.api.module.g.b bVar2;
                try {
                    f.alH().iq("navigateTo");
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
                    com.baidu.swan.apps.api.c.b hP = bVar2.hP(str);
                    String jsonString = hP == null ? "" : hP.toJsonString();
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
                            f.alH().ir("navigateTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("navigateTo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String reLaunch(String str) {
                com.baidu.swan.apps.api.module.g.d dVar;
                try {
                    f.alH().iq("reLaunch");
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
                    com.baidu.swan.apps.api.c.b hR = dVar.hR(str);
                    String jsonString = hR == null ? "" : hR.toJsonString();
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
                            f.alH().ir("reLaunch");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("reLaunch");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String redirectTo(String str) {
                com.baidu.swan.apps.api.module.g.c cVar;
                try {
                    f.alH().iq("redirectTo");
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
                    com.baidu.swan.apps.api.c.b hQ = cVar.hQ(str);
                    String jsonString = hQ == null ? "" : hQ.toJsonString();
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
                            f.alH().ir("redirectTo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("redirectTo");
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
                    f.alH().iq("getAppInfoSync");
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
                    com.baidu.swan.apps.api.c.b Uk = aVar.Uk();
                    String jsonString = Uk == null ? "" : Uk.toJsonString();
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
                            f.alH().ir("getAppInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getAppInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSetting(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getSetting");
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
                    com.baidu.swan.apps.api.c.b hT = aVar.hT(str);
                    String jsonString = hT == null ? "" : hT.toJsonString();
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
                            f.alH().ir("getSetting");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSetting");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSlaveIdSync() {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getSlaveIdSync");
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
                    com.baidu.swan.apps.api.c.b Ul = aVar.Ul();
                    String jsonString = Ul == null ? "" : Ul.toJsonString();
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
                            f.alH().ir("getSlaveIdSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSlaveIdSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSwanId(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getSwanId");
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
                    com.baidu.swan.apps.api.c.b hS = aVar.hS(str);
                    String jsonString = hS == null ? "" : hS.toJsonString();
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
                            f.alH().ir("getSwanId");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSwanId");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getUserInfo(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    f.alH().iq("getUserInfo");
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
                    com.baidu.swan.apps.api.c.b hU = aVar.hU(str);
                    String jsonString = hU == null ? "" : hU.toJsonString();
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
                            f.alH().ir("getUserInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getUserInfo");
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
                    f.alH().iq("clearStorage");
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
                    com.baidu.swan.apps.api.c.b Un = aVar.Un();
                    String jsonString = Un == null ? "" : Un.toJsonString();
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
                            f.alH().ir("clearStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("clearStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String clearStorageSync() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("clearStorageSync");
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
                    com.baidu.swan.apps.api.c.b Um = aVar.Um();
                    String jsonString = Um == null ? "" : Um.toJsonString();
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
                            f.alH().ir("clearStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("clearStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("getStorage");
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
                    com.baidu.swan.apps.api.c.b ia = aVar.ia(str);
                    String jsonString = ia == null ? "" : ia.toJsonString();
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
                            f.alH().ir("getStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [209=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageInfo() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("getStorageInfo");
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
                    com.baidu.swan.apps.api.c.b Uo = aVar.Uo();
                    String jsonString = Uo == null ? "" : Uo.toJsonString();
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
                            f.alH().ir("getStorageInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getStorageInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("getStorageSync");
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
                    com.baidu.swan.apps.api.c.b hZ = aVar.hZ(str);
                    String jsonString = hZ == null ? "" : hZ.toJsonString();
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
                            f.alH().ir("getStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("removeStorage");
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
                    com.baidu.swan.apps.api.c.b hY = aVar.hY(str);
                    String jsonString = hY == null ? "" : hY.toJsonString();
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
                            f.alH().ir("removeStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("removeStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String removeStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("removeStorageSync");
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
                    com.baidu.swan.apps.api.c.b hX = aVar.hX(str);
                    String jsonString = hX == null ? "" : hX.toJsonString();
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
                            f.alH().ir("removeStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("removeStorageSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [385=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorage(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("setStorage");
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
                    com.baidu.swan.apps.api.c.b hW = aVar.hW(str);
                    String jsonString = hW == null ? "" : hW.toJsonString();
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
                            f.alH().ir("setStorage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setStorage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setStorageSync(String str) {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    f.alH().iq("setStorageSync");
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
                    com.baidu.swan.apps.api.c.b hV = aVar.hV(str);
                    String jsonString = hV == null ? "" : hV.toJsonString();
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
                            f.alH().ir("setStorageSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setStorageSync");
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
                    f.alH().iq("subscribeService");
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
                    com.baidu.swan.apps.api.c.b ic = aVar.ic(str);
                    String jsonString = ic == null ? "" : ic.toJsonString();
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
                            f.alH().ir("subscribeService");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("subscribeService");
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
                    f.alH().iq("exitFullScreen");
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
                    com.baidu.swan.apps.api.c.b ih = eVar.ih(str);
                    String jsonString = ih == null ? "" : ih.toJsonString();
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
                            f.alH().ir("exitFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("exitFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [127=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getBrightness() {
                com.baidu.swan.apps.api.module.k.b bVar2;
                try {
                    f.alH().iq("getBrightness");
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
                    com.baidu.swan.apps.api.c.b Uq = bVar2.Uq();
                    String jsonString = Uq == null ? "" : Uq.toJsonString();
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
                            f.alH().ir("getBrightness");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getBrightness");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getClipboardData() {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.alH().iq("getClipboardData");
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
                    com.baidu.swan.apps.api.c.b Ur = cVar.Ur();
                    String jsonString = Ur == null ? "" : Ur.toJsonString();
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
                            f.alH().ir("getClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String makePhoneCall(String str) {
                com.baidu.swan.apps.api.module.k.f fVar;
                try {
                    f.alH().iq("makePhoneCall");
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
                    com.baidu.swan.apps.api.c.b ii = fVar.ii(str);
                    String jsonString = ii == null ? "" : ii.toJsonString();
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
                            f.alH().ir("makePhoneCall");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("makePhoneCall");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [259=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String requestFullScreen(String str) {
                com.baidu.swan.apps.api.module.k.g gVar;
                try {
                    f.alH().iq("requestFullScreen");
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
                    com.baidu.swan.apps.api.c.b ij = gVar.ij(str);
                    String jsonString = ij == null ? "" : ij.toJsonString();
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
                            f.alH().ir("requestFullScreen");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("requestFullScreen");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [303=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String setClipboardData(String str) {
                com.baidu.swan.apps.api.module.k.c cVar;
                try {
                    f.alH().iq("setClipboardData");
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
                    com.baidu.swan.apps.api.c.b m25if = cVar.m25if(str);
                    String jsonString = m25if == null ? "" : m25if.toJsonString();
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
                            f.alH().ir("setClipboardData");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("setClipboardData");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [347=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startAccelerometer(String str) {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.alH().iq("startAccelerometer");
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
                    com.baidu.swan.apps.api.c.b id = aVar.id(str);
                    String jsonString = id == null ? "" : id.toJsonString();
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
                            f.alH().ir("startAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("startAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String startCompass(String str) {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.alH().iq("startCompass");
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
                    com.baidu.swan.apps.api.c.b ig = dVar.ig(str);
                    String jsonString = ig == null ? "" : ig.toJsonString();
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
                            f.alH().ir("startCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("startCompass");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [435=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopAccelerometer() {
                com.baidu.swan.apps.api.module.k.a aVar;
                try {
                    f.alH().iq("stopAccelerometer");
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
                    com.baidu.swan.apps.api.c.b Up = aVar.Up();
                    String jsonString = Up == null ? "" : Up.toJsonString();
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
                            f.alH().ir("stopAccelerometer");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("stopAccelerometer");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [479=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String stopCompass() {
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    f.alH().iq("stopCompass");
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
                    com.baidu.swan.apps.api.c.b Us = dVar.Us();
                    String jsonString = Us == null ? "" : Us.toJsonString();
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
                            f.alH().ir("stopCompass");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("stopCompass");
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
                    f.alH().iq("checkAppInstalled");
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
                    com.baidu.swan.apps.api.c.b in = aVar.in(str);
                    String jsonString = in == null ? "" : in.toJsonString();
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
                            f.alH().ir("checkAppInstalled");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("checkAppInstalled");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getCommonSysInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.alH().iq("getCommonSysInfoSync");
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
                    com.baidu.swan.apps.api.c.b UE = cVar.UE();
                    String jsonString = UE == null ? "" : UE.toJsonString();
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
                            f.alH().ir("getCommonSysInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getCommonSysInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfo() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.alH().iq("getSystemInfo");
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
                    com.baidu.swan.apps.api.c.b UC = cVar.UC();
                    String jsonString = UC == null ? "" : UC.toJsonString();
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
                            f.alH().ir("getSystemInfo");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSystemInfo");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String getSystemInfoSync() {
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    f.alH().iq("getSystemInfoSync");
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
                    com.baidu.swan.apps.api.c.b UD = cVar.UD();
                    String jsonString = UD == null ? "" : UD.toJsonString();
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
                            f.alH().ir("getSystemInfoSync");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("getSystemInfoSync");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String previewImage(String str) {
                com.baidu.swan.apps.api.module.l.b bVar2;
                try {
                    f.alH().iq("previewImage");
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
                    com.baidu.swan.apps.api.c.b io2 = bVar2.io(str);
                    String jsonString = io2 == null ? "" : io2.toJsonString();
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
                            f.alH().ir("previewImage");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("previewImage");
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [300=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String ubcFlowJar(String str) {
                com.baidu.swan.apps.api.module.l.e eVar;
                try {
                    f.alH().iq("ubcFlowJar");
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
                    com.baidu.swan.apps.api.c.b ip = eVar.ip(str);
                    String jsonString = ip == null ? "" : ip.toJsonString();
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
                            f.alH().ir("ubcFlowJar");
                            return "";
                        }
                        throw th;
                    } finally {
                        f.alH().ir("ubcFlowJar");
                    }
                }
            }
        });
        return hashMap;
    }
}
