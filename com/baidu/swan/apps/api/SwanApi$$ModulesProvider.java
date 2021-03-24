package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.b.g0.a.t.b.b;
import d.b.g0.a.t.b.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11925e;

                public a(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11925e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11925e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11926e;

                public b(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11926e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11926e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11927e;

                public c(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11927e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11927e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.b.g0.a.t.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.a.a)) {
                        aVar = (d.b.g0.a.t.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
                d.b.g0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.a.b)) {
                        bVar2 = (d.b.g0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b v = bVar2.v();
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
                d.b.g0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.a.b)) {
                        bVar2 = (d.b.g0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = bVar2.w(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11931e;

                public a(SwanApi$$BasicV8Module swanApi$$BasicV8Module, Throwable th) {
                    this.f11931e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11931e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.b.g0.a.t.c.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.b.a)) {
                        aVar = (d.b.g0.a.t.c.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = aVar.u(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11933e;

                public a(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11933e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11933e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11934e;

                public b(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11934e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11934e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11935e;

                public c(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11935e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11935e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11936e;

                public d(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11936e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11936e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b D = aVar.D(str);
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
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b I = aVar.I(str);
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
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b J = aVar.J(str);
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
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b L = aVar.L(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11941e;

                public a(SwanApi$$FavoriteV8Module swanApi$$FavoriteV8Module, Throwable th) {
                    this.f11941e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11941e;
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
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = showFavoriteGuideApi.z(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11943e;

                public a(SwanApi$$FileV8Module swanApi$$FileV8Module, Throwable th) {
                    this.f11943e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11943e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.b.g0.a.t.c.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.d.a)) {
                        aVar = (d.b.g0.a.t.c.d.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.d.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11945e;

                public a(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f11945e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11945e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11946e;

                public b(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f11946e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11946e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.b.g0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.g0.a.p0.a)) {
                        aVar = (d.b.g0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.g0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
                d.b.g0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.g0.a.p0.a)) {
                        aVar = (d.b.g0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.g0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11949e;

                public a(SwanApi$$ImageV8Module swanApi$$ImageV8Module, Throwable th) {
                    this.f11949e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11949e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.b.g0.a.t.c.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.e.a)) {
                        aVar = (d.b.g0.a.t.c.e.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.e.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11951e;

                public a(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11951e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11951e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11952e;

                public b(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11952e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11952e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11953e;

                public c(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11953e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11953e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11954e;

                public d(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11954e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11954e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11955e;

                public e(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11955e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11955e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11956e;

                public f(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11956e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11956e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11957e;

                public g(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11957e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11957e;
                }
            }

            /* loaded from: classes3.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11958e;

                public h(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11958e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11958e;
                }
            }

            /* loaded from: classes3.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11959e;

                public i(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11959e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11959e;
                }
            }

            /* loaded from: classes3.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11960e;

                public j(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11960e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11960e;
                }
            }

            /* loaded from: classes3.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11961e;

                public k(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11961e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11961e;
                }
            }

            /* loaded from: classes3.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11962e;

                public l(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11962e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11962e;
                }
            }

            /* loaded from: classes3.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11963e;

                public m(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11963e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11963e;
                }
            }

            /* loaded from: classes3.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11964e;

                public n(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11964e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11964e;
                }
            }

            /* loaded from: classes3.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11965e;

                public o(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11965e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11965e;
                }
            }

            /* loaded from: classes3.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11966e;

                public p(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11966e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11966e;
                }
            }

            /* loaded from: classes3.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11967e;

                public q(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11967e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11967e;
                }
            }

            /* loaded from: classes3.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11968e;

                public r(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11968e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11968e;
                }
            }

            /* loaded from: classes3.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11969e;

                public s(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11969e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11969e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q2 = gVar.q(str);
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
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r2 = gVar.r(str);
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
                d.b.g0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.a)) {
                        aVar = (d.b.g0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r2 = aVar.r();
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r2 = cVar.r(str);
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
                d.b.g0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.h)) {
                        hVar = (d.b.g0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.g0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b D = hVar.D();
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = eVar.z(str);
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b A = eVar.A(str);
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
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b v = gVar.v(str);
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
                d.b.g0.a.t.c.f.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.d)) {
                        dVar = (d.b.g0.a.t.c.f.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.f.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s2 = dVar.s(str);
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s2 = cVar.s(str);
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = cVar.t(str);
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
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = gVar.w(str);
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b E = eVar.E(str);
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
                d.b.g0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.a)) {
                        aVar = (d.b.g0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s2 = aVar.s(str);
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
                d.b.g0.a.t.c.f.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.b)) {
                        bVar2 = (d.b.g0.a.t.c.f.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.f.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = bVar2.t(str);
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = cVar.u(str);
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
                d.b.g0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.h)) {
                        hVar = (d.b.g0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.g0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b J = hVar.J(str);
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
                d.b.g0.a.t.c.f.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.f)) {
                        fVar = (d.b.g0.a.t.c.f.f) obj;
                    } else {
                        fVar = new d.b.g0.a.t.c.f.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q2 = fVar.q(str);
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b F = eVar.F(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11989e;

                public a(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11989e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11989e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11990e;

                public b(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11990e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11990e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11991e;

                public c(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11991e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11991e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.b.g0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.g.a)) {
                        aVar = (d.b.g0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.g.a)) {
                        aVar = (d.b.g0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = aVar.t(str);
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
                d.b.g0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.g.a)) {
                        aVar = (d.b.g0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = aVar.u();
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11995e;

                public a(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11995e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11995e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11996e;

                public b(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11996e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11996e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11997e;

                public c(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11997e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11997e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11998e;

                public d(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11998e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11998e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                d.b.g0.a.t.c.h.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.b)) {
                        bVar2 = (d.b.g0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = bVar2.u(str);
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
                d.b.g0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.a)) {
                        aVar = (d.b.g0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q();
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
                d.b.g0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.a)) {
                        aVar = (d.b.g0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.h.b bVar2;
                String a2;
                try {
                    d.b.g0.a.t.d.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:V8, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.b)) {
                        bVar2 = (d.b.g0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a3 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a3.first).booleanValue()) {
                        a2 = ((d.b.g0.a.t.e.a) a3.second).a();
                    } else {
                        Pair<d.b.g0.a.t.e.a, JSONObject> m = d.b.g0.a.t.b.d.m(jsObject);
                        if (!((d.b.g0.a.t.e.a) m.first).b()) {
                            a2 = ((d.b.g0.a.t.e.a) m.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) m.second;
                            if (jSONObject == null) {
                                a2 = d.b.g0.a.t.e.a.f46213a.a();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.b.g0.a.t.e.b L = bVar2.L(jSONObject);
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
                        d.b.g0.a.t.d.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12003e;

                public a(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f12003e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12003e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12004e;

                public b(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f12004e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12004e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12005e;

                public c(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f12005e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12005e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.b.g0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.g0.a.l1.c.a.a)) {
                        aVar = (d.b.g0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.g0.a.l1.c.a.a)) {
                        aVar = (d.b.g0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = aVar.s(str);
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
                d.b.g0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.g0.a.l1.c.a.a)) {
                        aVar = (d.b.g0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = aVar.t(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12019e;

                public a(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f12019e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12019e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12020e;

                public b(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f12020e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12020e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12021e;

                public c(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f12021e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12021e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12022e;

                public d(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f12022e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12022e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.b.g0.a.t.c.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.a)) {
                        aVar = (d.b.g0.a.t.c.i.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.i.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.i.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.b)) {
                        bVar2 = (d.b.g0.a.t.c.i.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.i.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = bVar2.u(str);
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
                d.b.g0.a.t.c.i.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.d)) {
                        dVar = (d.b.g0.a.t.c.i.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.i.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = dVar.u(str);
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
                d.b.g0.a.t.c.i.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.c)) {
                        cVar = (d.b.g0.a.t.c.i.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.i.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = cVar.u(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12027e;

                public a(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f12027e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12027e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12028e;

                public b(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f12028e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12028e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12029e;

                public c(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f12029e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12029e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12030e;

                public d(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f12030e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12030e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12031e;

                public e(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f12031e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12031e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = aVar.w();
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b x = aVar.x(str);
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = aVar.y();
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = aVar.z(str);
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b A = aVar.A(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12037e;

                public a(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12037e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12037e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12038e;

                public b(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12038e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12038e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12039e;

                public c(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12039e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12039e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12040e;

                public d(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12040e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12040e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12041e;

                public e(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12041e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12041e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12042e;

                public f(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12042e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12042e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12043e;

                public g(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12043e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12043e;
                }
            }

            /* loaded from: classes3.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12044e;

                public h(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12044e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12044e;
                }
            }

            /* loaded from: classes3.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12045e;

                public i(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f12045e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12045e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q();
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r();
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = aVar.s(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = aVar.u();
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b v = aVar.v(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = aVar.z(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b A = aVar.A(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b B = aVar.B(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b C = aVar.C(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12055e;

                public a(SwanApi$$SubscriptionV8Module swanApi$$SubscriptionV8Module, Throwable th) {
                    this.f12055e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12055e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.b.g0.a.t.c.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.l.a)) {
                        aVar = (d.b.g0.a.t.c.l.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.l.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = aVar.y(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12057e;

                public a(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12057e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12057e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12058e;

                public b(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12058e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12058e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12059e;

                public c(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12059e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12059e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12060e;

                public d(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12060e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12060e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12061e;

                public e(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12061e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12061e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12062e;

                public f(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12062e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12062e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12063e;

                public g(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12063e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12063e;
                }
            }

            /* loaded from: classes3.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12064e;

                public h(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12064e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12064e;
                }
            }

            /* loaded from: classes3.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12065e;

                public i(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12065e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12065e;
                }
            }

            /* loaded from: classes3.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12066e;

                public j(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12066e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12066e;
                }
            }

            /* loaded from: classes3.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12067e;

                public k(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12067e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12067e;
                }
            }

            /* loaded from: classes3.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12068e;

                public l(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f12068e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12068e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.b.g0.a.t.c.m.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.f)) {
                        fVar = (d.b.g0.a.t.c.m.f) obj;
                    } else {
                        fVar = new d.b.g0.a.t.c.m.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = fVar.r(str);
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
                d.b.g0.a.t.c.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.b)) {
                        bVar2 = (d.b.g0.a.t.c.m.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.m.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = bVar2.q();
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
                d.b.g0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.c)) {
                        cVar = (d.b.g0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = cVar.q();
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
                d.b.g0.a.t.c.m.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.e)) {
                        eVar = (d.b.g0.a.t.c.m.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.m.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = eVar.r(str);
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
                d.b.g0.a.t.c.m.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.g)) {
                        gVar = (d.b.g0.a.t.c.m.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.m.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = gVar.q(str);
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
                d.b.g0.a.t.c.m.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.i)) {
                        iVar = (d.b.g0.a.t.c.m.i) obj;
                    } else {
                        iVar = new d.b.g0.a.t.c.m.i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = iVar.t(str);
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
                d.b.g0.a.t.c.m.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.h)) {
                        hVar = (d.b.g0.a.t.c.m.h) obj;
                    } else {
                        hVar = new d.b.g0.a.t.c.m.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = hVar.w(str);
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
                d.b.g0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.c)) {
                        cVar = (d.b.g0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = cVar.r(str);
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
                d.b.g0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.a)) {
                        aVar = (d.b.g0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.d)) {
                        dVar = (d.b.g0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = dVar.r(str);
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
                d.b.g0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.a)) {
                        aVar = (d.b.g0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = aVar.s();
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
                d.b.g0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.d)) {
                        dVar = (d.b.g0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = dVar.s();
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12081e;

                public a(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f12081e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12081e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12082e;

                public b(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f12082e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12082e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12083e;

                public c(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f12083e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12083e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12084e;

                public d(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f12084e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12084e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12085e;

                public e(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f12085e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12085e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12086e;

                public f(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f12086e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12086e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12087e;

                public g(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f12087e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12087e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.b.g0.a.t.c.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.a)) {
                        aVar = (d.b.g0.a.t.c.n.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.n.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
                d.b.g0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.d)) {
                        dVar = (d.b.g0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = dVar.u();
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
                d.b.g0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.d)) {
                        dVar = (d.b.g0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b x = dVar.x();
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
                d.b.g0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.d)) {
                        dVar = (d.b.g0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = dVar.y();
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
                d.b.g0.a.t.c.n.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.b)) {
                        bVar2 = (d.b.g0.a.t.c.n.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.n.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = bVar2.r(str);
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
                d.b.g0.a.t.c.n.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.c)) {
                        cVar = (d.b.g0.a.t.c.n.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.n.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = cVar.u(str);
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
                d.b.g0.a.t.c.n.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.f)) {
                        fVar = (d.b.g0.a.t.c.n.f) obj;
                    } else {
                        fVar = new d.b.g0.a.t.c.n.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b B = fVar.B(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11928e;

                public a(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11928e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11928e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11929e;

                public b(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11929e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11929e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11930e;

                public c(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11930e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11930e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.b.g0.a.t.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.a.a)) {
                        aVar = (d.b.g0.a.t.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
                d.b.g0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.a.b)) {
                        bVar2 = (d.b.g0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b v = bVar2.v();
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
                d.b.g0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.a.b)) {
                        bVar2 = (d.b.g0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = bVar2.w(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11932e;

                public a(SwanApi$$BasicWebviewModule swanApi$$BasicWebviewModule, Throwable th) {
                    this.f11932e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11932e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.b.g0.a.t.c.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.b.a)) {
                        aVar = (d.b.g0.a.t.c.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = aVar.u(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11937e;

                public a(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11937e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11937e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11938e;

                public b(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11938e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11938e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11939e;

                public c(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11939e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11939e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11940e;

                public d(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11940e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11940e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b D = aVar.D(str);
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
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b I = aVar.I(str);
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
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b J = aVar.J(str);
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
                d.b.g0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.b.g0.a.n.b.a)) {
                        aVar = (d.b.g0.a.n.b.a) obj;
                    } else {
                        aVar = new d.b.g0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b L = aVar.L(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11942e;

                public a(SwanApi$$FavoriteWebviewModule swanApi$$FavoriteWebviewModule, Throwable th) {
                    this.f11942e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11942e;
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
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = showFavoriteGuideApi.z(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11944e;

                public a(SwanApi$$FileWebviewModule swanApi$$FileWebviewModule, Throwable th) {
                    this.f11944e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11944e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.b.g0.a.t.c.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.d.a)) {
                        aVar = (d.b.g0.a.t.c.d.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.d.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11947e;

                public a(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f11947e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11947e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11948e;

                public b(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f11948e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11948e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.b.g0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.g0.a.p0.a)) {
                        aVar = (d.b.g0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.g0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
                d.b.g0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.b.g0.a.p0.a)) {
                        aVar = (d.b.g0.a.p0.a) obj;
                    } else {
                        aVar = new d.b.g0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11950e;

                public a(SwanApi$$ImageWebviewModule swanApi$$ImageWebviewModule, Throwable th) {
                    this.f11950e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11950e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.b.g0.a.t.c.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.e.a)) {
                        aVar = (d.b.g0.a.t.c.e.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.e.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11970e;

                public a(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11970e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11970e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11971e;

                public b(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11971e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11971e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11972e;

                public c(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11972e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11972e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11973e;

                public d(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11973e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11973e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11974e;

                public e(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11974e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11974e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11975e;

                public f(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11975e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11975e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11976e;

                public g(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11976e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11976e;
                }
            }

            /* loaded from: classes3.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11977e;

                public h(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11977e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11977e;
                }
            }

            /* loaded from: classes3.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11978e;

                public i(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11978e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11978e;
                }
            }

            /* loaded from: classes3.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11979e;

                public j(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11979e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11979e;
                }
            }

            /* loaded from: classes3.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11980e;

                public k(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11980e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11980e;
                }
            }

            /* loaded from: classes3.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11981e;

                public l(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11981e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11981e;
                }
            }

            /* loaded from: classes3.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11982e;

                public m(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11982e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11982e;
                }
            }

            /* loaded from: classes3.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11983e;

                public n(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11983e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11983e;
                }
            }

            /* loaded from: classes3.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11984e;

                public o(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11984e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11984e;
                }
            }

            /* loaded from: classes3.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11985e;

                public p(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11985e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11985e;
                }
            }

            /* loaded from: classes3.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11986e;

                public q(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11986e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11986e;
                }
            }

            /* loaded from: classes3.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11987e;

                public r(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11987e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11987e;
                }
            }

            /* loaded from: classes3.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11988e;

                public s(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11988e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11988e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q2 = gVar.q(str);
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
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r2 = gVar.r(str);
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
                d.b.g0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.a)) {
                        aVar = (d.b.g0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r2 = aVar.r();
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r2 = cVar.r(str);
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
                d.b.g0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.h)) {
                        hVar = (d.b.g0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.g0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b D = hVar.D();
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = eVar.z(str);
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b A = eVar.A(str);
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
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b v = gVar.v(str);
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
                d.b.g0.a.t.c.f.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.d)) {
                        dVar = (d.b.g0.a.t.c.f.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.f.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s2 = dVar.s(str);
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s2 = cVar.s(str);
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = cVar.t(str);
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
                d.b.g0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.g)) {
                        gVar = (d.b.g0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = gVar.w(str);
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b E = eVar.E(str);
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
                d.b.g0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.a)) {
                        aVar = (d.b.g0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s2 = aVar.s(str);
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
                d.b.g0.a.t.c.f.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.b)) {
                        bVar2 = (d.b.g0.a.t.c.f.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.f.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = bVar2.t(str);
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
                d.b.g0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.c)) {
                        cVar = (d.b.g0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = cVar.u(str);
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
                d.b.g0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.h)) {
                        hVar = (d.b.g0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.b.g0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b J = hVar.J(str);
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
                d.b.g0.a.t.c.f.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.f)) {
                        fVar = (d.b.g0.a.t.c.f.f) obj;
                    } else {
                        fVar = new d.b.g0.a.t.c.f.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q2 = fVar.q(str);
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
                d.b.g0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.f.e)) {
                        eVar = (d.b.g0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b F = eVar.F(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11992e;

                public a(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11992e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11992e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11993e;

                public b(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11993e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11993e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11994e;

                public c(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11994e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11994e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.b.g0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.g.a)) {
                        aVar = (d.b.g0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.g.a)) {
                        aVar = (d.b.g0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = aVar.t(str);
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
                d.b.g0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.g.a)) {
                        aVar = (d.b.g0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = aVar.u();
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11999e;

                public a(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11999e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11999e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12000e;

                public b(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f12000e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12000e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12001e;

                public c(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f12001e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12001e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12002e;

                public d(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f12002e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12002e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                d.b.g0.a.t.c.h.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.b)) {
                        bVar2 = (d.b.g0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = bVar2.u(str);
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
                d.b.g0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.a)) {
                        aVar = (d.b.g0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q();
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
                d.b.g0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.a)) {
                        aVar = (d.b.g0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.h.b bVar2;
                String a2;
                try {
                    d.b.g0.a.t.d.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:Webview, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.h.b)) {
                        bVar2 = (d.b.g0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a3 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a3.first).booleanValue()) {
                        a2 = ((d.b.g0.a.t.e.a) a3.second).a();
                    } else {
                        Pair<d.b.g0.a.t.e.a, JSONObject> n = d.b.g0.a.t.b.d.n(str);
                        if (!((d.b.g0.a.t.e.a) n.first).b()) {
                            a2 = ((d.b.g0.a.t.e.a) n.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) n.second;
                            if (jSONObject == null) {
                                a2 = d.b.g0.a.t.e.a.f46213a.a();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.b.g0.a.t.e.b L = bVar2.L(jSONObject);
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
                        d.b.g0.a.t.d.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12006e;

                public a(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f12006e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12006e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12007e;

                public b(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f12007e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12007e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12008e;

                public c(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f12008e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12008e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.b.g0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.g0.a.l1.c.a.a)) {
                        aVar = (d.b.g0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.g0.a.l1.c.a.a)) {
                        aVar = (d.b.g0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = aVar.s(str);
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
                d.b.g0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.b.g0.a.l1.c.a.a)) {
                        aVar = (d.b.g0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.b.g0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = aVar.t(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12023e;

                public a(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f12023e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12023e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12024e;

                public b(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f12024e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12024e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12025e;

                public c(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f12025e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12025e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12026e;

                public d(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f12026e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12026e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.b.g0.a.t.c.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.a)) {
                        aVar = (d.b.g0.a.t.c.i.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.i.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.i.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.b)) {
                        bVar2 = (d.b.g0.a.t.c.i.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.i.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = bVar2.u(str);
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
                d.b.g0.a.t.c.i.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.d)) {
                        dVar = (d.b.g0.a.t.c.i.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.i.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = dVar.u(str);
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
                d.b.g0.a.t.c.i.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.i.c)) {
                        cVar = (d.b.g0.a.t.c.i.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.i.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = cVar.u(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12032e;

                public a(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f12032e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12032e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12033e;

                public b(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f12033e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12033e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12034e;

                public c(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f12034e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12034e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12035e;

                public d(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f12035e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12035e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12036e;

                public e(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f12036e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12036e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = aVar.w();
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b x = aVar.x(str);
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = aVar.y();
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = aVar.z(str);
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
                d.b.g0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.j.a)) {
                        aVar = (d.b.g0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b A = aVar.A(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12046e;

                public a(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12046e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12046e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12047e;

                public b(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12047e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12047e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12048e;

                public c(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12048e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12048e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12049e;

                public d(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12049e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12049e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12050e;

                public e(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12050e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12050e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12051e;

                public f(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12051e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12051e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12052e;

                public g(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12052e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12052e;
                }
            }

            /* loaded from: classes3.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12053e;

                public h(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12053e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12053e;
                }
            }

            /* loaded from: classes3.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12054e;

                public i(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f12054e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12054e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q();
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r();
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = aVar.s(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = aVar.u();
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b v = aVar.v(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = aVar.z(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b A = aVar.A(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b B = aVar.B(str);
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
                d.b.g0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.k.a)) {
                        aVar = (d.b.g0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b C = aVar.C(str);
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
            public static final boolean DEBUG = d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12056e;

                public a(SwanApi$$SubscriptionWebviewModule swanApi$$SubscriptionWebviewModule, Throwable th) {
                    this.f12056e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12056e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.b.g0.a.t.c.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.l.a)) {
                        aVar = (d.b.g0.a.t.c.l.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.l.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = aVar.y(str);
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12069e;

                public a(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12069e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12069e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12070e;

                public b(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12070e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12070e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12071e;

                public c(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12071e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12071e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12072e;

                public d(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12072e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12072e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12073e;

                public e(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12073e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12073e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12074e;

                public f(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12074e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12074e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12075e;

                public g(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12075e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12075e;
                }
            }

            /* loaded from: classes3.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12076e;

                public h(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12076e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12076e;
                }
            }

            /* loaded from: classes3.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12077e;

                public i(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12077e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12077e;
                }
            }

            /* loaded from: classes3.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12078e;

                public j(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12078e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12078e;
                }
            }

            /* loaded from: classes3.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12079e;

                public k(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12079e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12079e;
                }
            }

            /* loaded from: classes3.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12080e;

                public l(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f12080e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12080e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.b.g0.a.t.c.m.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.f)) {
                        fVar = (d.b.g0.a.t.c.m.f) obj;
                    } else {
                        fVar = new d.b.g0.a.t.c.m.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = fVar.r(str);
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
                d.b.g0.a.t.c.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.b)) {
                        bVar2 = (d.b.g0.a.t.c.m.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.m.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = bVar2.q();
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
                d.b.g0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.c)) {
                        cVar = (d.b.g0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = cVar.q();
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
                d.b.g0.a.t.c.m.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.e)) {
                        eVar = (d.b.g0.a.t.c.m.e) obj;
                    } else {
                        eVar = new d.b.g0.a.t.c.m.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = eVar.r(str);
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
                d.b.g0.a.t.c.m.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.g)) {
                        gVar = (d.b.g0.a.t.c.m.g) obj;
                    } else {
                        gVar = new d.b.g0.a.t.c.m.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = gVar.q(str);
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
                d.b.g0.a.t.c.m.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.i)) {
                        iVar = (d.b.g0.a.t.c.m.i) obj;
                    } else {
                        iVar = new d.b.g0.a.t.c.m.i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b t = iVar.t(str);
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
                d.b.g0.a.t.c.m.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.h)) {
                        hVar = (d.b.g0.a.t.c.m.h) obj;
                    } else {
                        hVar = new d.b.g0.a.t.c.m.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b w = hVar.w(str);
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
                d.b.g0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.c)) {
                        cVar = (d.b.g0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = cVar.r(str);
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
                d.b.g0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.a)) {
                        aVar = (d.b.g0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
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
                d.b.g0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.d)) {
                        dVar = (d.b.g0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = dVar.r(str);
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
                d.b.g0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.a)) {
                        aVar = (d.b.g0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = aVar.s();
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
                d.b.g0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.m.d)) {
                        dVar = (d.b.g0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b s = dVar.s();
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
            public static final boolean DEBUG = d.b.g0.a.t.b.d.f45928c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes3.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12088e;

                public a(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f12088e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12088e;
                }
            }

            /* loaded from: classes3.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12089e;

                public b(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f12089e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12089e;
                }
            }

            /* loaded from: classes3.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12090e;

                public c(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f12090e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12090e;
                }
            }

            /* loaded from: classes3.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12091e;

                public d(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f12091e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12091e;
                }
            }

            /* loaded from: classes3.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12092e;

                public e(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f12092e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12092e;
                }
            }

            /* loaded from: classes3.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12093e;

                public f(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f12093e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12093e;
                }
            }

            /* loaded from: classes3.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f12094e;

                public g(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f12094e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f12094e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.b.g0.a.t.c.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.a)) {
                        aVar = (d.b.g0.a.t.c.n.a) obj;
                    } else {
                        aVar = new d.b.g0.a.t.c.n.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b q = aVar.q(str);
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
                d.b.g0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.d)) {
                        dVar = (d.b.g0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = dVar.u();
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
                d.b.g0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.d)) {
                        dVar = (d.b.g0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b x = dVar.x();
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
                d.b.g0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.d)) {
                        dVar = (d.b.g0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.b.g0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = dVar.y();
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
                d.b.g0.a.t.c.n.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.b)) {
                        bVar2 = (d.b.g0.a.t.c.n.b) obj;
                    } else {
                        bVar2 = new d.b.g0.a.t.c.n.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = bVar2.r(str);
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
                d.b.g0.a.t.c.n.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.c)) {
                        cVar = (d.b.g0.a.t.c.n.c) obj;
                    } else {
                        cVar = new d.b.g0.a.t.c.n.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b u = cVar.u(str);
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
                d.b.g0.a.t.c.n.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.b.g0.a.t.c.n.f)) {
                        fVar = (d.b.g0.a.t.c.n.f) obj;
                    } else {
                        fVar = new d.b.g0.a.t.c.n.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b B = fVar.B(str);
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
