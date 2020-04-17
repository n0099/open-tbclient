package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.api.module.e.d;
import com.baidu.swan.apps.api.module.e.e;
import com.baidu.swan.apps.api.module.e.f;
import com.baidu.swan.apps.api.module.e.g;
import com.baidu.swan.apps.api.module.e.h;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes11.dex */
public class SwanApi$$ModulesProvider {
    private Map<String, Object> mApiModules = new HashMap();

    public SwanApi$$ModulesProvider(final b bVar) {
        this.mApiModules.put("_naAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountModule
            private static final boolean DEBUG = c.DEBUG;
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
                        Log.d(TAG, "====================Account.checkSession====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.a)) {
                        aVar = (com.baidu.swan.apps.api.module.a.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.a aVar2 = new com.baidu.swan.apps.api.module.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gp = aVar.gp(str);
                    String jsonString = gp == null ? "" : gp.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.checkSession result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.checkSession with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountModule.1
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
                        Log.d(TAG, "====================Account.isLoginSync====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b Rv = bVar2.Rv();
                    String jsonString = Rv == null ? "" : Rv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.isLoginSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.isLoginSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountModule.2
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
                        Log.d(TAG, "====================Account.login====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.a.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.a.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.a.b bVar3 = new com.baidu.swan.apps.api.module.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gq = bVar2.gq(str);
                    String jsonString = gq == null ? "" : gq.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Account.login result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Account.login with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$AccountModule.3
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
        this.mApiModules.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicModule
            private static final boolean DEBUG = c.DEBUG;
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
                        Log.d(TAG, "====================Basic.loadSubPackage====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.b.a)) {
                        aVar = (com.baidu.swan.apps.api.module.b.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.b.a aVar2 = new com.baidu.swan.apps.api.module.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gr = aVar.gr(str);
                    String jsonString = gr == null ? "" : gr.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Basic.loadSubPackage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Basic.loadSubPackage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$BasicModule.1
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
        this.mApiModules.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteModule
            private static final boolean DEBUG = c.DEBUG;
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
                        Log.d(TAG, "====================Favorite.showFavoriteGuide====================");
                    }
                    Object obj = this.mApis.get("269275578");
                    if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                        showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                    } else {
                        ShowFavoriteGuideApi showFavoriteGuideApi2 = new ShowFavoriteGuideApi(this.mSwanApiContext);
                        this.mApis.put("269275578", showFavoriteGuideApi2);
                        showFavoriteGuideApi = showFavoriteGuideApi2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gu = showFavoriteGuideApi.gu(str);
                    String jsonString = gu == null ? "" : gu.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Favorite.showFavoriteGuide result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Favorite.showFavoriteGuide with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteModule.1
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
        this.mApiModules.put("_naFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FileModule
            private static final boolean DEBUG = c.DEBUG;
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
                        Log.d(TAG, "====================File.shareFile====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.c.a)) {
                        aVar = (com.baidu.swan.apps.api.module.c.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.c.a aVar2 = new com.baidu.swan.apps.api.module.c.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gv = aVar.gv(str);
                    String jsonString = gv == null ? "" : gv.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[File.shareFile result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[File.shareFile with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$FileModule.1
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
        this.mApiModules.put("_naGameCenter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                com.baidu.swan.apps.p.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessage====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.p.a)) {
                        aVar = (com.baidu.swan.apps.p.a) obj;
                    } else {
                        com.baidu.swan.apps.p.a aVar2 = new com.baidu.swan.apps.p.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b jh = aVar.jh(str);
                    String jsonString = jh == null ? "" : jh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[GameCenter.postGameCenterMessage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterModule.1
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
                com.baidu.swan.apps.p.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================GameCenter.postGameCenterMessageSync====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.p.a)) {
                        aVar = (com.baidu.swan.apps.p.a) obj;
                    } else {
                        com.baidu.swan.apps.p.a aVar2 = new com.baidu.swan.apps.p.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b ji = aVar.ji(str);
                    String jsonString = ji == null ? "" : ji.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[GameCenter.postGameCenterMessageSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[GameCenter.postGameCenterMessageSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterModule.2
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
        this.mApiModules.put("_naImage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageModule
            private static final boolean DEBUG = c.DEBUG;
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
                        Log.d(TAG, "====================Image.compressImage====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.d.a)) {
                        aVar = (com.baidu.swan.apps.api.module.d.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.d.a aVar2 = new com.baidu.swan.apps.api.module.d.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gx = aVar.gx(str);
                    String jsonString = gx == null ? "" : gx.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Image.compressImage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Image.compressImage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$ImageModule.1
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
        this.mApiModules.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.closeTabBarRedDot====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gJ = gVar.gJ(str);
                    String jsonString = gJ == null ? "" : gJ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.closeTabBarRedDot result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.closeTabBarRedDot with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.1
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
                        Log.d(TAG, "====================Interaction.hideLoading====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RC = aVar.RC();
                    String jsonString = RC == null ? "" : RC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideLoading result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideLoading with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.8
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
                        Log.d(TAG, "====================Interaction.hideToast====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof h)) {
                        hVar = (h) obj;
                    } else {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RF = hVar.RF();
                    String jsonString = RF == null ? "" : RF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.hideToast result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.hideToast with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.9
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
                        Log.d(TAG, "====================Interaction.openMultiPicker====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gF = eVar.gF(str);
                    String jsonString = gF == null ? "" : gF.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openMultiPicker result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openMultiPicker with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.10
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
                        Log.d(TAG, "====================Interaction.openPicker====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gE = eVar.gE(str);
                    String jsonString = gE == null ? "" : gE.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.openPicker result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.openPicker with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.11
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
                d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.pageScrollTo====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d)) {
                        dVar = (d) obj;
                    } else {
                        d dVar2 = new d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gC = dVar.gC(str);
                    String jsonString = gC == null ? "" : gC.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.pageScrollTo result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.pageScrollTo with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.12
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
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarColor====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gB = cVar.gB(str);
                    String jsonString = gB == null ? "" : gB.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarColor result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setNavigationBarColor with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.13
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
                com.baidu.swan.apps.api.module.e.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Interaction.setNavigationBarTitle====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.c)) {
                        cVar = (com.baidu.swan.apps.api.module.e.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.c cVar2 = new com.baidu.swan.apps.api.module.e.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gA = cVar.gA(str);
                    String jsonString = gA == null ? "" : gA.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setNavigationBarTitle result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setNavigationBarTitle with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.14
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
                        Log.d(TAG, "====================Interaction.setTabBarItem====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        g gVar2 = new g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar2);
                        gVar = gVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gK = gVar.gK(str);
                    String jsonString = gK == null ? "" : gK.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.setTabBarItem result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.setTabBarItem with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.15
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
                        Log.d(TAG, "====================Interaction.showDatePickerView====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gD = eVar.gD(str);
                    String jsonString = gD == null ? "" : gD.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showDatePickerView result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showDatePickerView with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.2
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
                        Log.d(TAG, "====================Interaction.showLoading====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.a)) {
                        aVar = (com.baidu.swan.apps.api.module.e.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.a aVar2 = new com.baidu.swan.apps.api.module.e.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gy = aVar.gy(str);
                    String jsonString = gy == null ? "" : gy.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showLoading result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showLoading with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.3
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
                        Log.d(TAG, "====================Interaction.showModal====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.e.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.e.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.e.b bVar3 = new com.baidu.swan.apps.api.module.e.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gz = bVar2.gz(str);
                    String jsonString = gz == null ? "" : gz.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showModal result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showModal with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.4
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
                        Log.d(TAG, "====================Interaction.showToast====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof h)) {
                        hVar = (h) obj;
                    } else {
                        h hVar2 = new h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar2);
                        hVar = hVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gL = hVar.gL(str);
                    String jsonString = gL == null ? "" : gL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.showToast result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.showToast with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.5
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
                        Log.d(TAG, "====================Interaction.stopPullDownRefresh====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof f)) {
                        fVar = (f) obj;
                    } else {
                        f fVar2 = new f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar2);
                        fVar = fVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gI = fVar.gI(str);
                    String jsonString = gI == null ? "" : gI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.stopPullDownRefresh result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.stopPullDownRefresh with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.6
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
                        Log.d(TAG, "====================Interaction.updateMultiPicker====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof e)) {
                        eVar = (e) obj;
                    } else {
                        e eVar2 = new e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gG = eVar.gG(str);
                    String jsonString = gG == null ? "" : gG.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Interaction.updateMultiPicker result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Interaction.updateMultiPicker with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionModule.7
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
        this.mApiModules.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceModule
            private static final boolean DEBUG = c.DEBUG;
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
                        Log.d(TAG, "====================LocationService.getLocation====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.f.a)) {
                        aVar = (com.baidu.swan.apps.api.module.f.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.f.a aVar2 = new com.baidu.swan.apps.api.module.f.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gO = aVar.gO(str);
                    String jsonString = gO == null ? "" : gO.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[LocationService.getLocation result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[LocationService.getLocation with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceModule.1
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
        this.mApiModules.put("_naNetwork", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getNetworkType() {
                com.baidu.swan.apps.api.module.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.getNetworkType====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.a)) {
                        aVar = (com.baidu.swan.apps.api.module.g.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.a aVar2 = new com.baidu.swan.apps.api.module.g.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RI = aVar.RI();
                    String jsonString = RI == null ? "" : RI.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.getNetworkType result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.getNetworkType with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkModule.1
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
                com.baidu.swan.apps.api.module.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.networkStatusChange====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.a)) {
                        aVar = (com.baidu.swan.apps.api.module.g.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.a aVar2 = new com.baidu.swan.apps.api.module.g.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gR = aVar.gR(str);
                    String jsonString = gR == null ? "" : gR.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.networkStatusChange result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.networkStatusChange with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkModule.2
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
            public String request(String str) {
                com.baidu.swan.apps.api.module.g.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Network.request====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.g.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.g.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.g.b bVar3 = new com.baidu.swan.apps.api.module.g.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gS = bVar2.gS(str);
                    String jsonString = gS == null ? "" : gS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Network.request result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Network.request with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkModule.3
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
        this.mApiModules.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                com.baidu.swan.apps.ag.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginChooseAddress====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ag.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ag.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ag.c.a.a aVar2 = new com.baidu.swan.apps.ag.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b ls = aVar.ls(str);
                    String jsonString = ls == null ? "" : ls.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginChooseAddress result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginChooseAddress with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginModule.1
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
                com.baidu.swan.apps.ag.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginLoginAndGetUserInfo====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ag.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ag.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ag.c.a.a aVar2 = new com.baidu.swan.apps.ag.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b lr = aVar.lr(str);
                    String jsonString = lr == null ? "" : lr.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginLoginAndGetUserInfo with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginModule.2
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
                com.baidu.swan.apps.ag.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Plugin.invokePluginPayment====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.ag.c.a.a)) {
                        aVar = (com.baidu.swan.apps.ag.c.a.a) obj;
                    } else {
                        com.baidu.swan.apps.ag.c.a.a aVar2 = new com.baidu.swan.apps.ag.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b lt = aVar.lt(str);
                    String jsonString = lt == null ? "" : lt.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Plugin.invokePluginPayment result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Plugin.invokePluginPayment with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$PluginModule.3
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
        this.mApiModules.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                com.baidu.swan.apps.api.module.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateBack====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.a)) {
                        aVar = (com.baidu.swan.apps.api.module.h.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.a aVar2 = new com.baidu.swan.apps.api.module.h.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gY = aVar.gY(str);
                    String jsonString = gY == null ? "" : gY.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateBack result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.navigateBack with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterModule.1
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
                com.baidu.swan.apps.api.module.h.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.navigateTo====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.h.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.b bVar3 = new com.baidu.swan.apps.api.module.h.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b gZ = bVar2.gZ(str);
                    String jsonString = gZ == null ? "" : gZ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.navigateTo result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.navigateTo with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterModule.2
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
                com.baidu.swan.apps.api.module.h.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.reLaunch====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.d)) {
                        dVar = (com.baidu.swan.apps.api.module.h.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.d dVar2 = new com.baidu.swan.apps.api.module.h.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hb = dVar.hb(str);
                    String jsonString = hb == null ? "" : hb.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.reLaunch result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.reLaunch with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterModule.3
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
                com.baidu.swan.apps.api.module.h.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Router.redirectTo====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.h.c)) {
                        cVar = (com.baidu.swan.apps.api.module.h.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.h.c cVar2 = new com.baidu.swan.apps.api.module.h.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b ha = cVar.ha(str);
                    String jsonString = ha == null ? "" : ha.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Router.redirectTo result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Router.redirectTo with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$RouterModule.4
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
        this.mApiModules.put("_naSetting", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getAppInfoSync====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RK = aVar.RK();
                    String jsonString = RK == null ? "" : RK.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getAppInfoSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getAppInfoSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingModule.1
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
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSetting====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hd = aVar.hd(str);
                    String jsonString = hd == null ? "" : hd.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSetting result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSetting with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingModule.2
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
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSlaveIdSync====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RL = aVar.RL();
                    String jsonString = RL == null ? "" : RL.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSlaveIdSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSlaveIdSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingModule.3
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
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getSwanId====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hc = aVar.hc(str);
                    String jsonString = hc == null ? "" : hc.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getSwanId result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getSwanId with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingModule.4
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
                com.baidu.swan.apps.api.module.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Setting.getUserInfo====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.i.a)) {
                        aVar = (com.baidu.swan.apps.api.module.i.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.i.a aVar2 = new com.baidu.swan.apps.api.module.i.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b he = aVar.he(str);
                    String jsonString = he == null ? "" : he.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Setting.getUserInfo result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Setting.getUserInfo with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SettingModule.5
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
        this.mApiModules.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorage====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RN = aVar.RN();
                    String jsonString = RN == null ? "" : RN.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.clearStorage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.1
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.clearStorageSync====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RM = aVar.RM();
                    String jsonString = RM == null ? "" : RM.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.clearStorageSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.clearStorageSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.2
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorage====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hk = aVar.hk(str);
                    String jsonString = hk == null ? "" : hk.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.3
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageInfo====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RO = aVar.RO();
                    String jsonString = RO == null ? "" : RO.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageInfo result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorageInfo with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.4
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.getStorageSync====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hj = aVar.hj(str);
                    String jsonString = hj == null ? "" : hj.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.getStorageSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.getStorageSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.5
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorage====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hi = aVar.hi(str);
                    String jsonString = hi == null ? "" : hi.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.removeStorage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.6
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.removeStorageSync====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hh = aVar.hh(str);
                    String jsonString = hh == null ? "" : hh.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.removeStorageSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.removeStorageSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.7
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorage====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hg = aVar.hg(str);
                    String jsonString = hg == null ? "" : hg.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.setStorage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.8
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
                com.baidu.swan.apps.api.module.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Storage.setStorageSync====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.j.a)) {
                        aVar = (com.baidu.swan.apps.api.module.j.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.j.a aVar2 = new com.baidu.swan.apps.api.module.j.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hf = aVar.hf(str);
                    String jsonString = hf == null ? "" : hf.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Storage.setStorageSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Storage.setStorageSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$StorageModule.9
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
        this.mApiModules.put("_naSystem", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemModule
            private static final boolean DEBUG = c.DEBUG;
            private static final String TAG = "Api-Base";
            private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            private b mSwanApiContext;

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBrightness() {
                com.baidu.swan.apps.api.module.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.getBrightness====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.k.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.b bVar3 = new com.baidu.swan.apps.api.module.k.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RQ = bVar2.RQ();
                    String jsonString = RQ == null ? "" : RQ.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getBrightness result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getBrightness with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemModule.1
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
                        Log.d(TAG, "====================System.getClipboardData====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RR = cVar.RR();
                    String jsonString = RR == null ? "" : RR.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.getClipboardData result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.getClipboardData with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemModule.2
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
                com.baidu.swan.apps.api.module.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================System.makePhoneCall====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.d)) {
                        dVar = (com.baidu.swan.apps.api.module.k.d) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.d dVar2 = new com.baidu.swan.apps.api.module.k.d(this.mSwanApiContext);
                        this.mApis.put("-1569246082", dVar2);
                        dVar = dVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(dVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hp = dVar.hp(str);
                    String jsonString = hp == null ? "" : hp.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.makePhoneCall result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.makePhoneCall with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemModule.3
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
                        Log.d(TAG, "====================System.setClipboardData====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.c)) {
                        cVar = (com.baidu.swan.apps.api.module.k.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.c cVar2 = new com.baidu.swan.apps.api.module.k.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b ho = cVar.ho(str);
                    String jsonString = ho == null ? "" : ho.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.setClipboardData result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.setClipboardData with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemModule.4
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
                        Log.d(TAG, "====================System.startAccelerometer====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hm = aVar.hm(str);
                    String jsonString = hm == null ? "" : hm.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.startAccelerometer result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.startAccelerometer with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemModule.5
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
                        Log.d(TAG, "====================System.stopAccelerometer====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.k.a)) {
                        aVar = (com.baidu.swan.apps.api.module.k.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.k.a aVar2 = new com.baidu.swan.apps.api.module.k.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RP = aVar.RP();
                    String jsonString = RP == null ? "" : RP.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[System.stopAccelerometer result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[System.stopAccelerometer with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$SystemModule.6
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
        this.mApiModules.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsModule
            private static final boolean DEBUG = c.DEBUG;
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
                        Log.d(TAG, "====================Utils.checkAppInstalled====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.a)) {
                        aVar = (com.baidu.swan.apps.api.module.l.a) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.a aVar2 = new com.baidu.swan.apps.api.module.l.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar2);
                        aVar = aVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hq = aVar.hq(str);
                    String jsonString = hq == null ? "" : hq.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.checkAppInstalled result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.checkAppInstalled with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsModule.1
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
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getCommonSysInfoSync====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RU = cVar.RU();
                    String jsonString = RU == null ? "" : RU.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getCommonSysInfoSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getCommonSysInfoSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsModule.2
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
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfo====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RS = cVar.RS();
                    String jsonString = RS == null ? "" : RS.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfo result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getSystemInfo with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsModule.3
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
                com.baidu.swan.apps.api.module.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.getSystemInfoSync====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.c)) {
                        cVar = (com.baidu.swan.apps.api.module.l.c) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.c cVar2 = new com.baidu.swan.apps.api.module.l.c(this.mSwanApiContext);
                        this.mApis.put("-1011537871", cVar2);
                        cVar = cVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(cVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b RT = cVar.RT();
                    String jsonString = RT == null ? "" : RT.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.getSystemInfoSync result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.getSystemInfoSync with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsModule.4
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
                com.baidu.swan.apps.api.module.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.previewImage====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.b)) {
                        bVar2 = (com.baidu.swan.apps.api.module.l.b) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.b bVar3 = new com.baidu.swan.apps.api.module.l.b(this.mSwanApiContext);
                        this.mApis.put("589529211", bVar3);
                        bVar2 = bVar3;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(bVar2, "swanAPI/previewImage");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hr = bVar2.hr(str);
                    String jsonString = hr == null ? "" : hr.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.previewImage result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.previewImage with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsModule.5
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
                com.baidu.swan.apps.api.module.l.e eVar;
                try {
                    if (DEBUG) {
                        Log.d(TAG, "====================Utils.ubcFlowJar====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof com.baidu.swan.apps.api.module.l.e)) {
                        eVar = (com.baidu.swan.apps.api.module.l.e) obj;
                    } else {
                        com.baidu.swan.apps.api.module.l.e eVar2 = new com.baidu.swan.apps.api.module.l.e(this.mSwanApiContext);
                        this.mApis.put("-577481801", eVar2);
                        eVar = eVar2;
                    }
                    Pair<Boolean, com.baidu.swan.apps.api.b.a> a = com.baidu.swan.apps.api.c.a.a(eVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a.first).booleanValue()) {
                        return ((com.baidu.swan.apps.api.b.a) a.second).toJsonString();
                    }
                    com.baidu.swan.apps.api.b.b hs = eVar.hs(str);
                    String jsonString = hs == null ? "" : hs.toJsonString();
                    if (DEBUG) {
                        Log.d(TAG, "====================[[Utils.ubcFlowJar result]]" + jsonString);
                        return jsonString;
                    }
                    return jsonString;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e(TAG, "====================[[Utils.ubcFlowJar with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsModule.6
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
    }

    public Map<String, Object> getApiModules() {
        return this.mApiModules;
    }
}
