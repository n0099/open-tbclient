package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.a.h0.a.t.b.b;
import d.a.h0.a.t.b.d;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11423e;

                public a(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11423e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11423e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11424e;

                public b(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11424e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11424e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11425e;

                public c(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f11425e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11425e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.a.h0.a.t.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.a.a)) {
                        aVar = (d.a.h0.a.t.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.checkSession[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.a.b)) {
                        bVar2 = (d.a.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b v = bVar2.v();
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.a.b)) {
                        bVar2 = (d.a.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = bVar2.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11429e;

                public a(SwanApi$$BasicV8Module swanApi$$BasicV8Module, Throwable th) {
                    this.f11429e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11429e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.a.h0.a.t.c.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.b.a)) {
                        aVar = (d.a.h0.a.t.c.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11431e;

                public a(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11431e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11431e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11432e;

                public b(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11432e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11432e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11433e;

                public c(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11433e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11433e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11434e;

                public d(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f11434e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11434e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b D = aVar.D(str);
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b I = aVar.I(str);
                    String b2 = I == null ? "" : I.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b J = aVar.J(str);
                    String b2 = J == null ? "" : J.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b L = aVar.L(str);
                    String b2 = L == null ? "" : L.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11439e;

                public a(SwanApi$$FavoriteV8Module swanApi$$FavoriteV8Module, Throwable th) {
                    this.f11439e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11439e;
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
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = showFavoriteGuideApi.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Favorite.showFavoriteGuide[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11441e;

                public a(SwanApi$$FileV8Module swanApi$$FileV8Module, Throwable th) {
                    this.f11441e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11441e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.a.h0.a.t.c.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.d.a)) {
                        aVar = (d.a.h0.a.t.c.d.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.d.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[File.shareFile[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11443e;

                public a(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f11443e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11443e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11444e;

                public b(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f11444e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11444e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.a.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.h0.a.p0.a)) {
                        aVar = (d.a.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.a.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.h0.a.p0.a)) {
                        aVar = (d.a.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.a.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11447e;

                public a(SwanApi$$ImageV8Module swanApi$$ImageV8Module, Throwable th) {
                    this.f11447e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11447e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.a.h0.a.t.c.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.e.a)) {
                        aVar = (d.a.h0.a.t.c.e.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.e.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11449e;

                public a(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11449e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11449e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11450e;

                public b(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11450e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11450e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11451e;

                public c(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11451e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11451e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11452e;

                public d(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11452e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11452e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11453e;

                public e(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11453e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11453e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11454e;

                public f(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11454e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11454e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11455e;

                public g(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11455e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11455e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11456e;

                public h(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11456e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11456e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11457e;

                public i(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11457e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11457e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11458e;

                public j(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11458e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11458e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11459e;

                public k(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11459e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11459e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11460e;

                public l(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11460e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11460e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11461e;

                public m(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11461e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11461e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11462e;

                public n(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11462e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11462e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11463e;

                public o(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11463e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11463e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11464e;

                public p(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11464e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11464e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11465e;

                public q(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11465e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11465e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11466e;

                public r(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11466e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11466e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11467e;

                public s(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f11467e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11467e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q2 = gVar.q(str);
                    String b2 = q2 == null ? "" : q2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBar[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r2 = gVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.a)) {
                        aVar = (d.a.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r2 = aVar.r();
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r2 = cVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.h)) {
                        hVar = (d.a.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.a.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b D = hVar.D();
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = eVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b A = eVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b v = gVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.d)) {
                        dVar = (d.a.h0.a.t.c.f.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.f.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s2 = dVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s2 = cVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarColor[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = cVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarTitle[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = gVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setTabBarItem[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b E = eVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showDatePickerView[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.a)) {
                        aVar = (d.a.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s2 = aVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.b)) {
                        bVar2 = (d.a.h0.a.t.c.f.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.f.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = bVar2.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.h)) {
                        hVar = (d.a.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.a.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b J = hVar.J(str);
                    String b2 = J == null ? "" : J.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.f)) {
                        fVar = (d.a.h0.a.t.c.f.f) obj;
                    } else {
                        fVar = new d.a.h0.a.t.c.f.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q2 = fVar.q(str);
                    String b2 = q2 == null ? "" : q2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b F = eVar.F(str);
                    String b2 = F == null ? "" : F.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11487e;

                public a(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11487e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11487e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11488e;

                public b(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11488e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11488e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11489e;

                public c(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f11489e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11489e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.a.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.g.a)) {
                        aVar = (d.a.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.getLocation[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.g.a)) {
                        aVar = (d.a.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.startLocationUpdate[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.g.a)) {
                        aVar = (d.a.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = aVar.u();
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.stopLocationUpdate[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11493e;

                public a(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11493e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11493e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11494e;

                public b(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11494e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11494e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11495e;

                public c(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11495e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11495e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11496e;

                public d(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f11496e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11496e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                d.a.h0.a.t.c.h.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.b)) {
                        bVar2 = (d.a.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = bVar2.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.a)) {
                        aVar = (d.a.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.a)) {
                        aVar = (d.a.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.h.b bVar2;
                String b2;
                try {
                    d.a.h0.a.t.d.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:V8, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.b)) {
                        bVar2 = (d.a.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        b2 = ((d.a.h0.a.t.e.a) a2.second).b();
                    } else {
                        Pair<d.a.h0.a.t.e.a, JSONObject> m = d.a.h0.a.t.b.d.m(jsObject);
                        if (!((d.a.h0.a.t.e.a) m.first).a()) {
                            b2 = ((d.a.h0.a.t.e.a) m.first).b();
                        } else {
                            JSONObject jSONObject = (JSONObject) m.second;
                            if (jSONObject == null) {
                                b2 = d.a.h0.a.t.e.a.f44323a.b();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.a.h0.a.t.e.b L = bVar2.L(jSONObject);
                                b2 = L == null ? "" : L.b();
                                if (DEBUG) {
                                    Log.d("Api-Base", "====================[[Network.request[type:V8, v8 binding:true] result]]" + b2);
                                }
                            }
                        }
                    }
                    return b2;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e("Api-Base", "====================[[Network.request[type:V8, v8 binding:true] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new d(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.a.h0.a.t.d.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11501e;

                public a(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f11501e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11501e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11502e;

                public b(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f11502e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11502e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11503e;

                public c(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f11503e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11503e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.a.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.h0.a.l1.c.a.a)) {
                        aVar = (d.a.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginChooseAddress[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.h0.a.l1.c.a.a)) {
                        aVar = (d.a.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.h0.a.l1.c.a.a)) {
                        aVar = (d.a.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginPayment[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11517e;

                public a(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11517e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11517e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11518e;

                public b(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11518e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11518e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11519e;

                public c(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11519e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11519e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11520e;

                public d(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f11520e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11520e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.a.h0.a.t.c.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.a)) {
                        aVar = (d.a.h0.a.t.c.i.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.i.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateBack[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.i.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.b)) {
                        bVar2 = (d.a.h0.a.t.c.i.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.i.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = bVar2.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateTo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.i.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.d)) {
                        dVar = (d.a.h0.a.t.c.i.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.i.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = dVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.reLaunch[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.i.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.c)) {
                        cVar = (d.a.h0.a.t.c.i.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.i.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.redirectTo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11525e;

                public a(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11525e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11525e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11526e;

                public b(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11526e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11526e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11527e;

                public c(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11527e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11527e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11528e;

                public d(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11528e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11528e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11529e;

                public e(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f11529e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11529e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = aVar.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getAppInfoSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b x = aVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSetting[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = aVar.y();
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSlaveIdSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSwanId[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b A = aVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getUserInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11535e;

                public a(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11535e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11535e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11536e;

                public b(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11536e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11536e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11537e;

                public c(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11537e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11537e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11538e;

                public d(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11538e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11538e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11539e;

                public e(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11539e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11539e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11540e;

                public f(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11540e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11540e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11541e;

                public g(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11541e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11541e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11542e;

                public h(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11542e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11542e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11543e;

                public i(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f11543e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11543e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = aVar.u();
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b v = aVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b A = aVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b B = aVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b C = aVar.C(str);
                    String b2 = C == null ? "" : C.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11553e;

                public a(SwanApi$$SubscriptionV8Module swanApi$$SubscriptionV8Module, Throwable th) {
                    this.f11553e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11553e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.a.h0.a.t.c.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.l.a)) {
                        aVar = (d.a.h0.a.t.c.l.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.l.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = aVar.y(str);
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Subscription.subscribeService[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11555e;

                public a(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11555e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11555e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11556e;

                public b(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11556e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11556e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11557e;

                public c(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11557e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11557e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11558e;

                public d(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11558e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11558e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11559e;

                public e(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11559e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11559e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11560e;

                public f(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11560e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11560e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11561e;

                public g(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11561e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11561e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11562e;

                public h(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11562e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11562e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11563e;

                public i(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11563e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11563e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11564e;

                public j(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11564e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11564e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11565e;

                public k(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11565e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11565e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11566e;

                public l(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f11566e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11566e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.a.h0.a.t.c.m.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.f)) {
                        fVar = (d.a.h0.a.t.c.m.f) obj;
                    } else {
                        fVar = new d.a.h0.a.t.c.m.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = fVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.b)) {
                        bVar2 = (d.a.h0.a.t.c.m.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.m.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = bVar2.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.c)) {
                        cVar = (d.a.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = cVar.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.e)) {
                        eVar = (d.a.h0.a.t.c.m.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.m.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = eVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.g)) {
                        gVar = (d.a.h0.a.t.c.m.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.m.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = gVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.i)) {
                        iVar = (d.a.h0.a.t.c.m.i) obj;
                    } else {
                        iVar = new d.a.h0.a.t.c.m.i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = iVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.h)) {
                        hVar = (d.a.h0.a.t.c.m.h) obj;
                    } else {
                        hVar = new d.a.h0.a.t.c.m.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = hVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.c)) {
                        cVar = (d.a.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = cVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.a)) {
                        aVar = (d.a.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.d)) {
                        dVar = (d.a.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = dVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.a)) {
                        aVar = (d.a.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = aVar.s();
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.d)) {
                        dVar = (d.a.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = dVar.s();
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11579e;

                public a(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11579e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11579e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11580e;

                public b(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11580e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11580e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11581e;

                public c(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11581e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11581e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11582e;

                public d(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11582e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11582e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11583e;

                public e(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11583e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11583e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11584e;

                public f(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11584e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11584e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11585e;

                public g(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f11585e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11585e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.a.h0.a.t.c.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.a)) {
                        aVar = (d.a.h0.a.t.c.n.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.n.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.d)) {
                        dVar = (d.a.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = dVar.u();
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.d)) {
                        dVar = (d.a.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b x = dVar.x();
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.d)) {
                        dVar = (d.a.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = dVar.y();
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.b)) {
                        bVar2 = (d.a.h0.a.t.c.n.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.n.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.c)) {
                        cVar = (d.a.h0.a.t.c.n.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.n.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.f)) {
                        fVar = (d.a.h0.a.t.c.n.f) obj;
                    } else {
                        fVar = new d.a.h0.a.t.c.n.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b B = fVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11426e;

                public a(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11426e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11426e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11427e;

                public b(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11427e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11427e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11428e;

                public c(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f11428e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11428e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.a.h0.a.t.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.a.a)) {
                        aVar = (d.a.h0.a.t.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.a.a(this.mSwanApiContext);
                        this.mApis.put("1930258908", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.checkSession[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.a.b)) {
                        bVar2 = (d.a.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b v = bVar2.v();
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.a.b)) {
                        bVar2 = (d.a.h0.a.t.c.a.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.a.b(this.mSwanApiContext);
                        this.mApis.put("-1017914143", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = bVar2.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11430e;

                public a(SwanApi$$BasicWebviewModule swanApi$$BasicWebviewModule, Throwable th) {
                    this.f11430e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11430e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.a.h0.a.t.c.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.b.a)) {
                        aVar = (d.a.h0.a.t.c.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11435e;

                public a(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11435e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11435e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11436e;

                public b(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11436e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11436e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11437e;

                public c(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11437e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11437e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11438e;

                public d(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f11438e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11438e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b D = aVar.D(str);
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b I = aVar.I(str);
                    String b2 = I == null ? "" : I.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b J = aVar.J(str);
                    String b2 = J == null ? "" : J.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.h0.a.n.b.a)) {
                        aVar = (d.a.h0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.h0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b L = aVar.L(str);
                    String b2 = L == null ? "" : L.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11440e;

                public a(SwanApi$$FavoriteWebviewModule swanApi$$FavoriteWebviewModule, Throwable th) {
                    this.f11440e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11440e;
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
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = showFavoriteGuideApi.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Favorite.showFavoriteGuide[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11442e;

                public a(SwanApi$$FileWebviewModule swanApi$$FileWebviewModule, Throwable th) {
                    this.f11442e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11442e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.a.h0.a.t.c.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.d.a)) {
                        aVar = (d.a.h0.a.t.c.d.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.d.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[File.shareFile[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11445e;

                public a(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f11445e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11445e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11446e;

                public b(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f11446e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11446e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.a.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.h0.a.p0.a)) {
                        aVar = (d.a.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.a.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.p0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.h0.a.p0.a)) {
                        aVar = (d.a.h0.a.p0.a) obj;
                    } else {
                        aVar = new d.a.h0.a.p0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11448e;

                public a(SwanApi$$ImageWebviewModule swanApi$$ImageWebviewModule, Throwable th) {
                    this.f11448e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11448e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.a.h0.a.t.c.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.e.a)) {
                        aVar = (d.a.h0.a.t.c.e.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.e.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11468e;

                public a(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11468e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11468e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11469e;

                public b(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11469e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11469e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11470e;

                public c(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11470e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11470e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11471e;

                public d(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11471e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11471e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11472e;

                public e(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11472e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11472e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11473e;

                public f(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11473e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11473e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11474e;

                public g(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11474e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11474e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11475e;

                public h(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11475e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11475e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11476e;

                public i(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11476e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11476e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11477e;

                public j(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11477e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11477e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11478e;

                public k(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11478e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11478e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11479e;

                public l(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11479e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11479e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11480e;

                public m(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11480e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11480e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11481e;

                public n(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11481e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11481e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11482e;

                public o(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11482e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11482e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11483e;

                public p(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11483e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11483e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11484e;

                public q(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11484e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11484e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11485e;

                public r(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11485e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11485e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11486e;

                public s(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f11486e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11486e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q2 = gVar.q(str);
                    String b2 = q2 == null ? "" : q2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBar[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r2 = gVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.a)) {
                        aVar = (d.a.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r2 = aVar.r();
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r2 = cVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.h)) {
                        hVar = (d.a.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.a.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b D = hVar.D();
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = eVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b A = eVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b v = gVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.d)) {
                        dVar = (d.a.h0.a.t.c.f.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.f.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s2 = dVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s2 = cVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarColor[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = cVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setNavigationBarTitle[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.g)) {
                        gVar = (d.a.h0.a.t.c.f.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.f.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = gVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.setTabBarItem[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b E = eVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showDatePickerView[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.a)) {
                        aVar = (d.a.h0.a.t.c.f.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.f.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s2 = aVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.b)) {
                        bVar2 = (d.a.h0.a.t.c.f.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.f.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = bVar2.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.c)) {
                        cVar = (d.a.h0.a.t.c.f.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.f.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.h)) {
                        hVar = (d.a.h0.a.t.c.f.h) obj;
                    } else {
                        hVar = new d.a.h0.a.t.c.f.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b J = hVar.J(str);
                    String b2 = J == null ? "" : J.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.f)) {
                        fVar = (d.a.h0.a.t.c.f.f) obj;
                    } else {
                        fVar = new d.a.h0.a.t.c.f.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q2 = fVar.q(str);
                    String b2 = q2 == null ? "" : q2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.f.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.f.e)) {
                        eVar = (d.a.h0.a.t.c.f.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.f.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b F = eVar.F(str);
                    String b2 = F == null ? "" : F.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11490e;

                public a(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11490e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11490e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11491e;

                public b(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11491e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11491e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11492e;

                public c(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f11492e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11492e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.a.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.g.a)) {
                        aVar = (d.a.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.getLocation[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.g.a)) {
                        aVar = (d.a.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.startLocationUpdate[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.g.a)) {
                        aVar = (d.a.h0.a.t.c.g.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.g.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = aVar.u();
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[LocationService.stopLocationUpdate[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11497e;

                public a(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11497e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11497e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11498e;

                public b(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11498e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11498e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11499e;

                public c(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11499e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11499e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11500e;

                public d(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f11500e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11500e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                d.a.h0.a.t.c.h.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.b)) {
                        bVar2 = (d.a.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = bVar2.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.a)) {
                        aVar = (d.a.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.a)) {
                        aVar = (d.a.h0.a.t.c.h.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.h.a(this.mSwanApiContext);
                        this.mApis.put("453220699", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.h.b bVar2;
                String b2;
                try {
                    d.a.h0.a.t.d.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:Webview, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.h.b)) {
                        bVar2 = (d.a.h0.a.t.c.h.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.h.b(this.mSwanApiContext);
                        this.mApis.put("968563034", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        b2 = ((d.a.h0.a.t.e.a) a2.second).b();
                    } else {
                        Pair<d.a.h0.a.t.e.a, JSONObject> n = d.a.h0.a.t.b.d.n(str);
                        if (!((d.a.h0.a.t.e.a) n.first).a()) {
                            b2 = ((d.a.h0.a.t.e.a) n.first).b();
                        } else {
                            JSONObject jSONObject = (JSONObject) n.second;
                            if (jSONObject == null) {
                                b2 = d.a.h0.a.t.e.a.f44323a.b();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.a.h0.a.t.e.b L = bVar2.L(jSONObject);
                                b2 = L == null ? "" : L.b();
                                if (DEBUG) {
                                    Log.d("Api-Base", "====================[[Network.request[type:Webview, v8 binding:true] result]]" + b2);
                                }
                            }
                        }
                    }
                    return b2;
                } catch (Throwable th) {
                    try {
                        if (DEBUG) {
                            Log.e("Api-Base", "====================[[Network.request[type:Webview, v8 binding:true] with exception]]", th);
                            new Handler(Looper.getMainLooper()).post(new d(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.a.h0.a.t.d.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11504e;

                public a(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f11504e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11504e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11505e;

                public b(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f11505e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11505e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11506e;

                public c(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f11506e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11506e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.a.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.h0.a.l1.c.a.a)) {
                        aVar = (d.a.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.h0.a.l1.c.a.a)) {
                        aVar = (d.a.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.l1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.h0.a.l1.c.a.a)) {
                        aVar = (d.a.h0.a.l1.c.a.a) obj;
                    } else {
                        aVar = new d.a.h0.a.l1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Plugin.invokePluginPayment[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11521e;

                public a(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11521e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11521e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11522e;

                public b(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11522e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11522e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11523e;

                public c(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11523e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11523e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11524e;

                public d(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f11524e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11524e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.a.h0.a.t.c.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.a)) {
                        aVar = (d.a.h0.a.t.c.i.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.i.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateBack[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.i.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.b)) {
                        bVar2 = (d.a.h0.a.t.c.i.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.i.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = bVar2.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.navigateTo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.i.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.d)) {
                        dVar = (d.a.h0.a.t.c.i.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.i.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = dVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.reLaunch[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.i.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.i.c)) {
                        cVar = (d.a.h0.a.t.c.i.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.i.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Router.redirectTo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11530e;

                public a(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11530e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11530e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11531e;

                public b(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11531e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11531e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11532e;

                public c(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11532e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11532e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11533e;

                public d(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11533e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11533e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11534e;

                public e(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f11534e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11534e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = aVar.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getAppInfoSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b x = aVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSetting[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = aVar.y();
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSlaveIdSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getSwanId[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.j.a)) {
                        aVar = (d.a.h0.a.t.c.j.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.j.a(this.mSwanApiContext);
                        this.mApis.put("-594895721", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b A = aVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.getUserInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11544e;

                public a(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11544e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11544e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11545e;

                public b(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11545e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11545e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11546e;

                public c(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11546e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11546e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11547e;

                public d(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11547e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11547e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11548e;

                public e(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11548e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11548e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11549e;

                public f(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11549e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11549e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11550e;

                public g(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11550e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11550e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11551e;

                public h(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11551e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11551e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11552e;

                public i(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f11552e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11552e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearStorage() {
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = aVar.u();
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b v = aVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b A = aVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b B = aVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.k.a)) {
                        aVar = (d.a.h0.a.t.c.k.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.k.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b C = aVar.C(str);
                    String b2 = C == null ? "" : C.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11554e;

                public a(SwanApi$$SubscriptionWebviewModule swanApi$$SubscriptionWebviewModule, Throwable th) {
                    this.f11554e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11554e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.a.h0.a.t.c.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.l.a)) {
                        aVar = (d.a.h0.a.t.c.l.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.l.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = aVar.y(str);
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Subscription.subscribeService[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11567e;

                public a(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11567e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11567e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11568e;

                public b(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11568e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11568e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11569e;

                public c(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11569e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11569e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11570e;

                public d(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11570e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11570e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11571e;

                public e(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11571e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11571e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11572e;

                public f(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11572e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11572e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11573e;

                public g(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11573e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11573e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11574e;

                public h(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11574e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11574e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11575e;

                public i(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11575e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11575e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11576e;

                public j(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11576e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11576e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11577e;

                public k(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11577e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11577e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11578e;

                public l(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f11578e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11578e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.a.h0.a.t.c.m.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.f)) {
                        fVar = (d.a.h0.a.t.c.m.f) obj;
                    } else {
                        fVar = new d.a.h0.a.t.c.m.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = fVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.b)) {
                        bVar2 = (d.a.h0.a.t.c.m.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.m.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = bVar2.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.c)) {
                        cVar = (d.a.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = cVar.q();
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.e)) {
                        eVar = (d.a.h0.a.t.c.m.e) obj;
                    } else {
                        eVar = new d.a.h0.a.t.c.m.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = eVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.g)) {
                        gVar = (d.a.h0.a.t.c.m.g) obj;
                    } else {
                        gVar = new d.a.h0.a.t.c.m.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = gVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.i)) {
                        iVar = (d.a.h0.a.t.c.m.i) obj;
                    } else {
                        iVar = new d.a.h0.a.t.c.m.i(this.mSwanApiContext);
                        this.mApis.put("1099851202", iVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(iVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b t = iVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.h)) {
                        hVar = (d.a.h0.a.t.c.m.h) obj;
                    } else {
                        hVar = new d.a.h0.a.t.c.m.h(this.mSwanApiContext);
                        this.mApis.put("-1707203360", hVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(hVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b w = hVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.c)) {
                        cVar = (d.a.h0.a.t.c.m.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.m.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = cVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.a)) {
                        aVar = (d.a.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.d)) {
                        dVar = (d.a.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = dVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.a)) {
                        aVar = (d.a.h0.a.t.c.m.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.m.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = aVar.s();
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.m.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.m.d)) {
                        dVar = (d.a.h0.a.t.c.m.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.m.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b s = dVar.s();
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
            public static final boolean DEBUG = d.a.h0.a.t.b.d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11586e;

                public a(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11586e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11586e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11587e;

                public b(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11587e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11587e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11588e;

                public c(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11588e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11588e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11589e;

                public d(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11589e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11589e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11590e;

                public e(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11590e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11590e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11591e;

                public f(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11591e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11591e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11592e;

                public g(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f11592e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11592e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.a.h0.a.t.c.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.a)) {
                        aVar = (d.a.h0.a.t.c.n.a) obj;
                    } else {
                        aVar = new d.a.h0.a.t.c.n.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b q = aVar.q(str);
                    String b2 = q == null ? "" : q.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.d)) {
                        dVar = (d.a.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = dVar.u();
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.d)) {
                        dVar = (d.a.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b x = dVar.x();
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.d)) {
                        dVar = (d.a.h0.a.t.c.n.d) obj;
                    } else {
                        dVar = new d.a.h0.a.t.c.n.d(this.mSwanApiContext);
                        this.mApis.put("-1011537871", dVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(dVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = dVar.y();
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.b)) {
                        bVar2 = (d.a.h0.a.t.c.n.b) obj;
                    } else {
                        bVar2 = new d.a.h0.a.t.c.n.b(this.mSwanApiContext);
                        this.mApis.put("-2097727681", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.c)) {
                        cVar = (d.a.h0.a.t.c.n.c) obj;
                    } else {
                        cVar = new d.a.h0.a.t.c.n.c(this.mSwanApiContext);
                        this.mApis.put("589529211", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
                d.a.h0.a.t.c.n.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.a.h0.a.t.c.n.f)) {
                        fVar = (d.a.h0.a.t.c.n.f) obj;
                    } else {
                        fVar = new d.a.h0.a.t.c.n.f(this.mSwanApiContext);
                        this.mApis.put("-577481801", fVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(fVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b B = fVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
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
