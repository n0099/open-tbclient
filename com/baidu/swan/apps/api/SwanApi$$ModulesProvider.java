package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.b.h0.a.t.b.b;
import d.b.h0.a.t.b.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11595e;

                public a(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11595e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11595e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11596e;

                public b(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11596e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11596e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11597e;

                public c(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11597e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11597e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.b.h0.a.t.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.a.a)) {
                        aVar = (d.b.h0.a.t.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.checkSession[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.checkSession[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String isLoginSync() {
                d.b.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.a.b)) {
                        bVar2 = (d.b.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b v = bVar2.v();
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.isLoginSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String login(String str) {
                d.b.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.a.b)) {
                        bVar2 = (d.b.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = bVar2.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.login[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11601e;

                public a(SwanApi$$BasicV8Module swanApi$$BasicV8Module, Throwable th) {
                    this.f11601e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11601e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.b.h0.a.t.c.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.b.a)) {
                        aVar = (d.b.h0.a.t.c.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Basic.loadSubPackage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11603e;

                public a(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11603e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11603e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11604e;

                public b(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11604e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11604e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11605e;

                public c(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11605e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11605e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11606e;

                public d(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11606e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11606e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b D = aVar.D(str);
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b I = aVar.I(str);
                    String a3 = I == null ? "" : I.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b J = aVar.J(str);
                    String a3 = J == null ? "" : J.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b L = aVar.L(str);
                    String a3 = L == null ? "" : L.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11611e;

                public a(SwanApi$$FavoriteV8Module swanApi$$FavoriteV8Module, Throwable th) {
                    this.f11611e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11611e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Favorite.showFavoriteGuide[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("269275578");
                    if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                        showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                    } else {
                        showFavoriteGuideApi = new ShowFavoriteGuideApi(this.mSwanApiContext);
                        this.mApis.put("269275578", showFavoriteGuideApi);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = showFavoriteGuideApi.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Favorite.showFavoriteGuide[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Favorite.showFavoriteGuide[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11613e;

                public a(SwanApi$$FileV8Module swanApi$$FileV8Module, Throwable th) {
                    this.f11613e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11613e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.b.h0.a.t.c.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.d.a)) {
                        aVar = (d.b.h0.a.t.c.d.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.d.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[File.shareFile[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[File.shareFile[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naGameCenter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11615e;

                public a(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f11615e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11615e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11616e;

                public b(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f11616e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11616e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.b.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.h0.a.p0.a)) {
                        aVar = (d.b.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[GameCenter.postGameCenterMessage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                d.b.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.h0.a.p0.a)) {
                        aVar = (d.b.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naImage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11619e;

                public a(SwanApi$$ImageV8Module swanApi$$ImageV8Module, Throwable th) {
                    this.f11619e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11619e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.b.h0.a.t.c.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.e.a)) {
                        aVar = (d.b.h0.a.t.c.e.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.e.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Image.compressImage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11621e;

                public a(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11621e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11621e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11622e;

                public b(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11622e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11622e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11623e;

                public c(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11623e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11623e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11624e;

                public d(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11624e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11624e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11625e;

                public e(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11625e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11625e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11626e;

                public f(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11626e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11626e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11627e;

                public g(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11627e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11627e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11628e;

                public h(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11628e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11628e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11629e;

                public i(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11629e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11629e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11630e;

                public j(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11630e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11630e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11631e;

                public k(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11631e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11631e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11632e;

                public l(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11632e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11632e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11633e;

                public m(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11633e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11633e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11634e;

                public n(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11634e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11634e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11635e;

                public o(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11635e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11635e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11636e;

                public p(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11636e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11636e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11637e;

                public q(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11637e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11637e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11638e;

                public r(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11638e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11638e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11639e;

                public s(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11639e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11639e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q2 = gVar.q(str);
                    String a3 = q2 == null ? "" : q2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBar[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.closeTabBar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r2 = gVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideLoading() {
                d.b.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.a)) {
                        aVar = (d.b.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r2 = aVar.r();
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r2 = cVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new n(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideToast() {
                d.b.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.h)) {
                        hVar = (d.b.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b D = hVar.D();
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideToast[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new o(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = eVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new p(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openPicker(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b A = eVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new q(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b v = gVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openTabBar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new r(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                d.b.h0.a.t.c.f.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.d)) {
                        dVar = (d.b.h0.a.t.c.f.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.f.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s2 = dVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new s(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s2 = cVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarColor[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.setNavigationBarColor[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = cVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarTitle[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.setNavigationBarTitle[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = gVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setTabBarItem[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.setTabBarItem[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b E = eVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showDatePickerView[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showDatePickerView[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showLoading(String str) {
                d.b.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.a)) {
                        aVar = (d.b.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s2 = aVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showModal(String str) {
                d.b.h0.a.t.c.f.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.b)) {
                        bVar2 = (d.b.h0.a.t.c.f.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.f.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = bVar2.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showModal[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showToast(String str) {
                d.b.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.h)) {
                        hVar = (d.b.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b J = hVar.J(str);
                    String a3 = J == null ? "" : J.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showToast[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                d.b.h0.a.t.c.f.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.f)) {
                        fVar = (d.b.h0.a.t.c.f.f) obj;
                    } else {
                        fVar = new d.b.h0.a.t.c.f.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q2 = fVar.q(str);
                    String a3 = q2 == null ? "" : q2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b F = eVar.F(str);
                    String a3 = F == null ? "" : F.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11659e;

                public a(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11659e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11659e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11660e;

                public b(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11660e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11660e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11661e;

                public c(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11661e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11661e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.b.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.g.a)) {
                        aVar = (d.b.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.getLocation[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[LocationService.getLocation[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                d.b.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.g.a)) {
                        aVar = (d.b.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.startLocationUpdate[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[LocationService.startLocationUpdate[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                d.b.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.g.a)) {
                        aVar = (d.b.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = aVar.u();
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.stopLocationUpdate[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[LocationService.stopLocationUpdate[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naNetwork", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11665e;

                public a(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11665e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11665e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11666e;

                public b(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11666e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11666e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11667e;

                public c(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11667e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11667e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11668e;

                public d(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11668e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11668e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                d.b.h0.a.t.c.h.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.b)) {
                        bVar2 = (d.b.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = bVar2.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.cancelRequest[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getNetworkType() {
                d.b.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.a)) {
                        aVar = (d.b.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.getNetworkType[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                d.b.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.a)) {
                        aVar = (d.b.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.networkStatusChange[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                d.b.h0.a.t.c.h.b bVar2;
                String a2;
                try {
                    d.b.h0.a.t.d.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:V8, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.b)) {
                        bVar2 = (d.b.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a3 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a3.first).booleanValue()) {
                        a2 = ((d.b.h0.a.t.e.a) a3.second).a();
                    } else {
                        Pair<d.b.h0.a.t.e.a, JSONObject> m = d.b.h0.a.t.b.d.m(jsObject);
                        if (!((d.b.h0.a.t.e.a) m.first).b()) {
                            a2 = ((d.b.h0.a.t.e.a) m.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) m.second;
                            if (jSONObject == null) {
                                a2 = d.b.h0.a.t.e.a.f46935a.a();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.b.h0.a.t.e.b L = bVar2.L(jSONObject);
                                a2 = L == null ? "" : L.a();
                                if (DEBUG) {
                                    Log.d("Api-Base", "====================[[Network.request[type:V8, v8 binding:true] result]]" + a2);
                                }
                            }
                        }
                    }
                    return a2;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e("Api-Base", "====================[[Network.request[type:V8, v8 binding:true] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new d(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.b.h0.a.t.d.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11673e;

                public a(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f11673e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11673e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11674e;

                public b(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f11674e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11674e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11675e;

                public c(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f11675e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11675e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.b.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.h0.a.l1.c.a.a)) {
                        aVar = (d.b.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginChooseAddress[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Plugin.invokePluginChooseAddress[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                d.b.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.h0.a.l1.c.a.a)) {
                        aVar = (d.b.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                d.b.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.h0.a.l1.c.a.a)) {
                        aVar = (d.b.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginPayment[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Plugin.invokePluginPayment[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11689e;

                public a(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11689e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11689e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11690e;

                public b(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11690e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11690e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11691e;

                public c(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11691e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11691e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11692e;

                public d(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11692e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11692e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.b.h0.a.t.c.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.a)) {
                        aVar = (d.b.h0.a.t.c.i.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.i.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateBack[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.navigateBack[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                d.b.h0.a.t.c.i.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.b)) {
                        bVar2 = (d.b.h0.a.t.c.i.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.i.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = bVar2.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateTo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.navigateTo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                d.b.h0.a.t.c.i.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.d)) {
                        dVar = (d.b.h0.a.t.c.i.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.i.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = dVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.reLaunch[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.reLaunch[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                d.b.h0.a.t.c.i.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.c)) {
                        cVar = (d.b.h0.a.t.c.i.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.i.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.redirectTo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.redirectTo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSetting", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11697e;

                public a(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11697e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11697e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11698e;

                public b(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11698e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11698e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11699e;

                public c(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11699e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11699e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11700e;

                public d(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11700e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11700e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11701e;

                public e(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11701e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11701e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = aVar.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getAppInfoSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getAppInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSetting(String str) {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b x = aVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSetting[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getSetting[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b y = aVar.y();
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSlaveIdSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getSlaveIdSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSwanId[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getSwanId[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b A = aVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getUserInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getUserInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11707e;

                public a(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11707e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11707e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11708e;

                public b(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11708e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11708e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11709e;

                public c(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11709e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11709e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11710e;

                public d(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11710e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11710e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11711e;

                public e(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11711e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11711e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11712e;

                public f(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11712e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11712e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11713e;

                public g(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11713e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11713e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11714e;

                public h(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11714e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11714e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11715e;

                public i(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11715e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11715e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearStorageSync() {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorage(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageInfo() {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = aVar.u();
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b v = aVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b A = aVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorage(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b B = aVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b C = aVar.C(str);
                    String a3 = C == null ? "" : C.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11725e;

                public a(SwanApi$$SubscriptionV8Module swanApi$$SubscriptionV8Module, Throwable th) {
                    this.f11725e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11725e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.b.h0.a.t.c.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.l.a)) {
                        aVar = (d.b.h0.a.t.c.l.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.l.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b y = aVar.y(str);
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Subscription.subscribeService[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Subscription.subscribeService[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSystem", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11727e;

                public a(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11727e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11727e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11728e;

                public b(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11728e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11728e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11729e;

                public c(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11729e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11729e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11730e;

                public d(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11730e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11730e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11731e;

                public e(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11731e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11731e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11732e;

                public f(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11732e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11732e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11733e;

                public g(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11733e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11733e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11734e;

                public h(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11734e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11734e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11735e;

                public i(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11735e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11735e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11736e;

                public j(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11736e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11736e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11737e;

                public k(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11737e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11737e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11738e;

                public l(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11738e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11738e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.b.h0.a.t.c.m.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.f)) {
                        fVar = (d.b.h0.a.t.c.m.f) obj;
                    } else {
                        fVar = new d.b.h0.a.t.c.m.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = fVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.exitFullScreen[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getBrightness() {
                d.b.h0.a.t.c.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.b)) {
                        bVar2 = (d.b.h0.a.t.c.m.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.m.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = bVar2.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getBrightness[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getClipboardData() {
                d.b.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.c)) {
                        cVar = (d.b.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = cVar.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getClipboardData[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                d.b.h0.a.t.c.m.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.e)) {
                        eVar = (d.b.h0.a.t.c.m.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.m.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = eVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getDeviceInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                d.b.h0.a.t.c.m.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.g)) {
                        gVar = (d.b.h0.a.t.c.m.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.m.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = gVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.makePhoneCall[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                d.b.h0.a.t.c.m.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.i)) {
                        iVar = (d.b.h0.a.t.c.m.i) obj;
                    } else {
                        iVar = new d.b.h0.a.t.c.m.i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = iVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.openSMSPanel[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                d.b.h0.a.t.c.m.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.h)) {
                        hVar = (d.b.h0.a.t.c.m.h) obj;
                    } else {
                        hVar = new d.b.h0.a.t.c.m.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = hVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.requestFullScreen[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                d.b.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.c)) {
                        cVar = (d.b.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = cVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.setClipboardData[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                d.b.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.a)) {
                        aVar = (d.b.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startCompass(String str) {
                d.b.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.d)) {
                        dVar = (d.b.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = dVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startCompass[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                d.b.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.a)) {
                        aVar = (d.b.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = aVar.s();
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopCompass() {
                d.b.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.d)) {
                        dVar = (d.b.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = dVar.s();
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11751e;

                public a(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11751e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11751e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11752e;

                public b(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11752e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11752e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11753e;

                public c(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11753e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11753e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11754e;

                public d(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11754e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11754e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11755e;

                public e(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11755e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11755e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11756e;

                public f(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11756e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11756e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11757e;

                public g(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11757e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11757e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.b.h0.a.t.c.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.a)) {
                        aVar = (d.b.h0.a.t.c.n.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.n.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                d.b.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.d)) {
                        dVar = (d.b.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = dVar.u();
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfo() {
                d.b.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.d)) {
                        dVar = (d.b.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b x = dVar.x();
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                d.b.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.d)) {
                        dVar = (d.b.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b y = dVar.y();
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String handleException(String str) {
                d.b.h0.a.t.c.n.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.b)) {
                        bVar2 = (d.b.h0.a.t.c.n.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.n.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.handleException[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String previewImage(String str) {
                d.b.h0.a.t.c.n.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.c)) {
                        cVar = (d.b.h0.a.t.c.n.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.n.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.previewImage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                d.b.h0.a.t.c.n.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.f)) {
                        fVar = (d.b.h0.a.t.c.n.f) obj;
                    } else {
                        fVar = new d.b.h0.a.t.c.n.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b B = fVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
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
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11598e;

                public a(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11598e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11598e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11599e;

                public b(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11599e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11599e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11600e;

                public c(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11600e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11600e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.b.h0.a.t.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.a.a)) {
                        aVar = (d.b.h0.a.t.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.checkSession[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.checkSession[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String isLoginSync() {
                d.b.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.a.b)) {
                        bVar2 = (d.b.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b v = bVar2.v();
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.isLoginSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String login(String str) {
                d.b.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.a.b)) {
                        bVar2 = (d.b.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = bVar2.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.login[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11602e;

                public a(SwanApi$$BasicWebviewModule swanApi$$BasicWebviewModule, Throwable th) {
                    this.f11602e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11602e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.b.h0.a.t.c.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.b.a)) {
                        aVar = (d.b.h0.a.t.c.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Basic.loadSubPackage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11607e;

                public a(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11607e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11607e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11608e;

                public b(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11608e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11608e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11609e;

                public c(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11609e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11609e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11610e;

                public d(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11610e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11610e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b D = aVar.D(str);
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b I = aVar.I(str);
                    String a3 = I == null ? "" : I.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b J = aVar.J(str);
                    String a3 = J == null ? "" : J.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                d.b.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.h0.a.n.b.a)) {
                        aVar = (d.b.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b L = aVar.L(str);
                    String a3 = L == null ? "" : L.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11612e;

                public a(SwanApi$$FavoriteWebviewModule swanApi$$FavoriteWebviewModule, Throwable th) {
                    this.f11612e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11612e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String showFavoriteGuide(String str) {
                ShowFavoriteGuideApi showFavoriteGuideApi;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Favorite.showFavoriteGuide[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("269275578");
                    if (obj != null && (obj instanceof ShowFavoriteGuideApi)) {
                        showFavoriteGuideApi = (ShowFavoriteGuideApi) obj;
                    } else {
                        showFavoriteGuideApi = new ShowFavoriteGuideApi(this.mSwanApiContext);
                        this.mApis.put("269275578", showFavoriteGuideApi);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = showFavoriteGuideApi.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Favorite.showFavoriteGuide[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Favorite.showFavoriteGuide[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11614e;

                public a(SwanApi$$FileWebviewModule swanApi$$FileWebviewModule, Throwable th) {
                    this.f11614e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11614e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.b.h0.a.t.c.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.d.a)) {
                        aVar = (d.b.h0.a.t.c.d.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.d.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[File.shareFile[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[File.shareFile[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naGameCenter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11617e;

                public a(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f11617e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11617e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11618e;

                public b(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f11618e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11618e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.b.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.h0.a.p0.a)) {
                        aVar = (d.b.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[GameCenter.postGameCenterMessage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String postGameCenterMessageSync(String str) {
                d.b.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.h0.a.p0.a)) {
                        aVar = (d.b.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naImage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11620e;

                public a(SwanApi$$ImageWebviewModule swanApi$$ImageWebviewModule, Throwable th) {
                    this.f11620e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11620e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.b.h0.a.t.c.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.e.a)) {
                        aVar = (d.b.h0.a.t.c.e.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.e.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Image.compressImage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11640e;

                public a(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11640e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11640e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11641e;

                public b(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11641e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11641e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11642e;

                public c(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11642e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11642e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11643e;

                public d(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11643e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11643e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11644e;

                public e(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11644e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11644e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11645e;

                public f(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11645e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11645e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11646e;

                public g(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11646e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11646e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11647e;

                public h(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11647e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11647e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11648e;

                public i(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11648e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11648e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11649e;

                public j(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11649e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11649e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11650e;

                public k(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11650e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11650e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11651e;

                public l(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11651e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11651e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11652e;

                public m(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11652e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11652e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11653e;

                public n(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11653e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11653e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11654e;

                public o(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11654e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11654e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11655e;

                public p(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11655e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11655e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11656e;

                public q(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11656e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11656e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11657e;

                public r(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11657e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11657e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11658e;

                public s(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11658e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11658e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q2 = gVar.q(str);
                    String a3 = q2 == null ? "" : q2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBar[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.closeTabBar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String closeTabBarRedDot(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r2 = gVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideLoading() {
                d.b.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.a)) {
                        aVar = (d.b.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r2 = aVar.r();
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r2 = cVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new n(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideToast() {
                d.b.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.h)) {
                        hVar = (d.b.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b D = hVar.D();
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideToast[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new o(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = eVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new p(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openPicker(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b A = eVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new q(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b v = gVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new r(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                d.b.h0.a.t.c.f.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.d)) {
                        dVar = (d.b.h0.a.t.c.f.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.f.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s2 = dVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new s(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s2 = cVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarColor[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.setNavigationBarColor[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setNavigationBarTitle(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = cVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarTitle[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.setNavigationBarTitle[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setTabBarItem(String str) {
                d.b.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.g)) {
                        gVar = (d.b.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = gVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setTabBarItem[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.setTabBarItem[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showDatePickerView(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b E = eVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showDatePickerView[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showDatePickerView[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showLoading(String str) {
                d.b.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.a)) {
                        aVar = (d.b.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s2 = aVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showModal(String str) {
                d.b.h0.a.t.c.f.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.b)) {
                        bVar2 = (d.b.h0.a.t.c.f.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.f.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = bVar2.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showModal[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                d.b.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.c)) {
                        cVar = (d.b.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showToast(String str) {
                d.b.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.h)) {
                        hVar = (d.b.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b J = hVar.J(str);
                    String a3 = J == null ? "" : J.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showToast[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                d.b.h0.a.t.c.f.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.f)) {
                        fVar = (d.b.h0.a.t.c.f.f) obj;
                    } else {
                        fVar = new d.b.h0.a.t.c.f.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q2 = fVar.q(str);
                    String a3 = q2 == null ? "" : q2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                d.b.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.f.e)) {
                        eVar = (d.b.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b F = eVar.F(str);
                    String a3 = F == null ? "" : F.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11662e;

                public a(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11662e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11662e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11663e;

                public b(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11663e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11663e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11664e;

                public c(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11664e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11664e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.b.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.g.a)) {
                        aVar = (d.b.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.getLocation[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[LocationService.getLocation[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startLocationUpdate(String str) {
                d.b.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.g.a)) {
                        aVar = (d.b.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.startLocationUpdate[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[LocationService.startLocationUpdate[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopLocationUpdate() {
                d.b.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.g.a)) {
                        aVar = (d.b.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = aVar.u();
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.stopLocationUpdate[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[LocationService.stopLocationUpdate[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naNetwork", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11669e;

                public a(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11669e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11669e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11670e;

                public b(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11670e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11670e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11671e;

                public c(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11671e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11671e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11672e;

                public d(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11672e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11672e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                d.b.h0.a.t.c.h.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.b)) {
                        bVar2 = (d.b.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = bVar2.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.cancelRequest[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getNetworkType() {
                d.b.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.a)) {
                        aVar = (d.b.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.getNetworkType[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                d.b.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.a)) {
                        aVar = (d.b.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                d.b.h0.a.t.c.h.b bVar2;
                String a2;
                try {
                    d.b.h0.a.t.d.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:Webview, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.h.b)) {
                        bVar2 = (d.b.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a3 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a3.first).booleanValue()) {
                        a2 = ((d.b.h0.a.t.e.a) a3.second).a();
                    } else {
                        Pair<d.b.h0.a.t.e.a, JSONObject> n = d.b.h0.a.t.b.d.n(str);
                        if (!((d.b.h0.a.t.e.a) n.first).b()) {
                            a2 = ((d.b.h0.a.t.e.a) n.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) n.second;
                            if (jSONObject == null) {
                                a2 = d.b.h0.a.t.e.a.f46935a.a();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.b.h0.a.t.e.b L = bVar2.L(jSONObject);
                                a2 = L == null ? "" : L.a();
                                if (DEBUG) {
                                    Log.d("Api-Base", "====================[[Network.request[type:Webview, v8 binding:true] result]]" + a2);
                                }
                            }
                        }
                    }
                    return a2;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e("Api-Base", "====================[[Network.request[type:Webview, v8 binding:true] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new d(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.b.h0.a.t.d.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11676e;

                public a(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f11676e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11676e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11677e;

                public b(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f11677e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11677e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11678e;

                public c(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f11678e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11678e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.b.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.h0.a.l1.c.a.a)) {
                        aVar = (d.b.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String invokePluginLoginAndGetUserInfo(String str) {
                d.b.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.h0.a.l1.c.a.a)) {
                        aVar = (d.b.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String invokePluginPayment(String str) {
                d.b.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.h0.a.l1.c.a.a)) {
                        aVar = (d.b.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginPayment[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Plugin.invokePluginPayment[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11693e;

                public a(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11693e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11693e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11694e;

                public b(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11694e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11694e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11695e;

                public c(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11695e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11695e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11696e;

                public d(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11696e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11696e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.b.h0.a.t.c.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.a)) {
                        aVar = (d.b.h0.a.t.c.i.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.i.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateBack[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.navigateBack[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String navigateTo(String str) {
                d.b.h0.a.t.c.i.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.b)) {
                        bVar2 = (d.b.h0.a.t.c.i.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.i.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = bVar2.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateTo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.navigateTo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String reLaunch(String str) {
                d.b.h0.a.t.c.i.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.d)) {
                        dVar = (d.b.h0.a.t.c.i.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.i.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = dVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.reLaunch[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.reLaunch[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String redirectTo(String str) {
                d.b.h0.a.t.c.i.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.i.c)) {
                        cVar = (d.b.h0.a.t.c.i.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.i.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.redirectTo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Router.redirectTo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSetting", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11702e;

                public a(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11702e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11702e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11703e;

                public b(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11703e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11703e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11704e;

                public c(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11704e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11704e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11705e;

                public d(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11705e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11705e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11706e;

                public e(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11706e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11706e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = aVar.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getAppInfoSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getAppInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSetting(String str) {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b x = aVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSetting[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getSetting[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSlaveIdSync() {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b y = aVar.y();
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSlaveIdSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getSlaveIdSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSwanId(String str) {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSwanId[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getSwanId[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getUserInfo(String str) {
                d.b.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.j.a)) {
                        aVar = (d.b.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b A = aVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getUserInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.getUserInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11716e;

                public a(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11716e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11716e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11717e;

                public b(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11717e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11717e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11718e;

                public c(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11718e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11718e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11719e;

                public d(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11719e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11719e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11720e;

                public e(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11720e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11720e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11721e;

                public f(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11721e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11721e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11722e;

                public g(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11722e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11722e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11723e;

                public h(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11723e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11723e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11724e;

                public i(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11724e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11724e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearStorageSync() {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorage(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageInfo() {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = aVar.u();
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b v = aVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b A = aVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorage(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b B = aVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                d.b.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.k.a)) {
                        aVar = (d.b.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b C = aVar.C(str);
                    String a3 = C == null ? "" : C.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11726e;

                public a(SwanApi$$SubscriptionWebviewModule swanApi$$SubscriptionWebviewModule, Throwable th) {
                    this.f11726e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11726e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.b.h0.a.t.c.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.l.a)) {
                        aVar = (d.b.h0.a.t.c.l.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.l.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b y = aVar.y(str);
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Subscription.subscribeService[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Subscription.subscribeService[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSystem", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11739e;

                public a(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11739e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11739e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11740e;

                public b(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11740e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11740e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11741e;

                public c(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11741e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11741e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11742e;

                public d(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11742e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11742e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11743e;

                public e(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11743e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11743e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11744e;

                public f(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11744e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11744e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11745e;

                public g(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11745e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11745e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11746e;

                public h(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11746e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11746e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11747e;

                public i(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11747e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11747e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11748e;

                public j(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11748e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11748e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11749e;

                public k(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11749e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11749e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11750e;

                public l(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11750e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11750e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.b.h0.a.t.c.m.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.f)) {
                        fVar = (d.b.h0.a.t.c.m.f) obj;
                    } else {
                        fVar = new d.b.h0.a.t.c.m.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = fVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.exitFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getBrightness() {
                d.b.h0.a.t.c.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.b)) {
                        bVar2 = (d.b.h0.a.t.c.m.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.m.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = bVar2.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getBrightness[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getClipboardData() {
                d.b.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.c)) {
                        cVar = (d.b.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = cVar.q();
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                d.b.h0.a.t.c.m.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.e)) {
                        eVar = (d.b.h0.a.t.c.m.e) obj;
                    } else {
                        eVar = new d.b.h0.a.t.c.m.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = eVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                d.b.h0.a.t.c.m.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.g)) {
                        gVar = (d.b.h0.a.t.c.m.g) obj;
                    } else {
                        gVar = new d.b.h0.a.t.c.m.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = gVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.makePhoneCall[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                d.b.h0.a.t.c.m.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.i)) {
                        iVar = (d.b.h0.a.t.c.m.i) obj;
                    } else {
                        iVar = new d.b.h0.a.t.c.m.i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b t = iVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.openSMSPanel[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                d.b.h0.a.t.c.m.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.h)) {
                        hVar = (d.b.h0.a.t.c.m.h) obj;
                    } else {
                        hVar = new d.b.h0.a.t.c.m.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b w = hVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.requestFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                d.b.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.c)) {
                        cVar = (d.b.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = cVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.setClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                d.b.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.a)) {
                        aVar = (d.b.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startCompass(String str) {
                d.b.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.d)) {
                        dVar = (d.b.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = dVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startCompass[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                d.b.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.a)) {
                        aVar = (d.b.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = aVar.s();
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopCompass() {
                d.b.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.m.d)) {
                        dVar = (d.b.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b s = dVar.s();
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopCompass[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = d.b.h0.a.t.b.d.f46650c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11758e;

                public a(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11758e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11758e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11759e;

                public b(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11759e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11759e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11760e;

                public c(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11760e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11760e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11761e;

                public d(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11761e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11761e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11762e;

                public e(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11762e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11762e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11763e;

                public f(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11763e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11763e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11764e;

                public g(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11764e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11764e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.b.h0.a.t.c.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.a)) {
                        aVar = (d.b.h0.a.t.c.n.a) obj;
                    } else {
                        aVar = new d.b.h0.a.t.c.n.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b q = aVar.q(str);
                    String a3 = q == null ? "" : q.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                d.b.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.d)) {
                        dVar = (d.b.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = dVar.u();
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfo() {
                d.b.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.d)) {
                        dVar = (d.b.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b x = dVar.x();
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                d.b.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.d)) {
                        dVar = (d.b.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b y = dVar.y();
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String handleException(String str) {
                d.b.h0.a.t.c.n.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.b)) {
                        bVar2 = (d.b.h0.a.t.c.n.b) obj;
                    } else {
                        bVar2 = new d.b.h0.a.t.c.n.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar2);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.handleException[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String previewImage(String str) {
                d.b.h0.a.t.c.n.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.c)) {
                        cVar = (d.b.h0.a.t.c.n.c) obj;
                    } else {
                        cVar = new d.b.h0.a.t.c.n.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.previewImage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                d.b.h0.a.t.c.n.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.b.h0.a.t.c.n.f)) {
                        fVar = (d.b.h0.a.t.c.n.f) obj;
                    } else {
                        fVar = new d.b.h0.a.t.c.n.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar);
                    }
                    Pair<Boolean, d.b.h0.a.t.e.a> a2 = d.b.h0.a.t.f.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.h0.a.t.e.a) a2.second).a();
                    }
                    d.b.h0.a.t.e.b B = fVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        return hashMap;
    }
}
