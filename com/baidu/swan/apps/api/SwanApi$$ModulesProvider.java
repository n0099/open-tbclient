package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.a.l0.a.h0.l.g.f;
import d.a.l0.a.j2.o;
import d.a.l0.a.u.c.b;
import d.a.l0.a.u.c.d;
import d.a.l0.a.u.e.j.g;
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10400e;

                public a(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10400e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10400e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10401e;

                public b(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10401e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10401e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10402e;

                public c(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10402e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10402e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10403e;

                public d(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10403e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10403e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10404e;

                public e(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10404e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10404e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10405e;

                public f(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10405e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10405e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10406e;

                public g(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10406e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10406e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.a.l0.a.u.e.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.b)) {
                        bVar2 = (d.a.l0.a.u.e.a.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.a.b(this.mSwanApiContext);
                        this.mApis.put("1930258908", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
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
            public String getLoginCode(String str) {
                d.a.l0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getLoginCode[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.c)) {
                        cVar = (d.a.l0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/getLoginCode");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getLoginCode[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.getLoginCode[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                d.a.l0.a.u.e.a.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getOpenId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1754780133");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.d)) {
                        dVar = (d.a.l0.a.u.e.a.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.a.d(this.mSwanApiContext);
                        this.mApis.put("1754780133", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/getOpenId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = dVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getOpenId[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.getOpenId[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                d.a.l0.a.s.a.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getUnionBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-343998465");
                    if (obj != null && (obj instanceof d.a.l0.a.s.a.j.a)) {
                        aVar = (d.a.l0.a.s.a.j.a) obj;
                    } else {
                        aVar = new d.a.l0.a.s.a.j.a(this.mSwanApiContext);
                        this.mApis.put("-343998465", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getUnionBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getUnionBDUSS[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.getUnionBDUSS[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                d.a.l0.a.u.e.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isBaiduAccountSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-337742792");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.a)) {
                        aVar = (d.a.l0.a.u.e.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.a.a(this.mSwanApiContext);
                        this.mApis.put("-337742792", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/isBaiduAccountSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isBaiduAccountSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.isBaiduAccountSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String isLoginSync() {
                d.a.l0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.c)) {
                        cVar = (d.a.l0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = cVar.z();
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.isLoginSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String login(String str) {
                d.a.l0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.c)) {
                        cVar = (d.a.l0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.login")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = cVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.login[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10414e;

                public a(SwanApi$$BasicV8Module swanApi$$BasicV8Module, Throwable th) {
                    this.f10414e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10414e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10415e;

                public b(SwanApi$$BasicV8Module swanApi$$BasicV8Module, Throwable th) {
                    this.f10415e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10415e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.a.l0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.b.a)) {
                        aVar = (d.a.l0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
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

            @JavascriptInterface
            public String loadSubPackages(String str) {
                d.a.l0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackages[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.b.a)) {
                        aVar = (d.a.l0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/loadSubPackages");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = aVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackages[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Basic.loadSubPackages[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10418e;

                public a(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10418e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10418e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10419e;

                public b(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10419e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10419e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10420e;

                public c(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10420e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10420e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10421e;

                public d(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10421e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10421e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10422e;

                public e(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10422e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10422e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.deleteBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/deleteBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = aVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.deleteBookshelf[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.deleteBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b J = aVar.J(str);
                    String b2 = J == null ? "" : J.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b O = aVar.O(str);
                    String b2 = O == null ? "" : O.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b P = aVar.P(str);
                    String b2 = P == null ? "" : P.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b R = aVar.R(str);
                    String b2 = R == null ? "" : R.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naCalendar", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$CalendarV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10428e;

                public a(SwanApi$$CalendarV8Module swanApi$$CalendarV8Module, Throwable th) {
                    this.f10428e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10428e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10429e;

                public b(SwanApi$$CalendarV8Module swanApi$$CalendarV8Module, Throwable th) {
                    this.f10429e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10429e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addEventOnCalendar(String str) {
                d.a.l0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.addEventOnCalendar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.c.a)) {
                        aVar = (d.a.l0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/addEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.addEventOnCalendar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.addEventOnCalendar[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Calendar.addEventOnCalendar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String deleteEventOnCalendar(String str) {
                d.a.l0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.deleteEventOnCalendar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.c.a)) {
                        aVar = (d.a.l0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/deleteEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.deleteEventOnCalendar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = aVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.deleteEventOnCalendar[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Calendar.deleteEventOnCalendar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naCoupon", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10432e;

                public a(SwanApi$$CouponV8Module swanApi$$CouponV8Module, Throwable th) {
                    this.f10432e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10432e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10433e;

                public b(SwanApi$$CouponV8Module swanApi$$CouponV8Module, Throwable th) {
                    this.f10433e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10433e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10434e;

                public c(SwanApi$$CouponV8Module swanApi$$CouponV8Module, Throwable th) {
                    this.f10434e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10434e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                d.a.l0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getPlatformCoupons[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.l0.a.u.d.a)) {
                        aVar = (d.a.l0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/coupon/getPlatformCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getPlatformCoupons[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Coupon.getPlatformCoupons[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                d.a.l0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getUserCoupons[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.l0.a.u.d.a)) {
                        aVar = (d.a.l0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/coupon/getUserCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getUserCoupons[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Coupon.getUserCoupons[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                d.a.l0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.takeCoupons[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.l0.a.u.d.a)) {
                        aVar = (d.a.l0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/coupon/takeCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = aVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.takeCoupons[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Coupon.takeCoupons[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10438e;

                public a(SwanApi$$FavoriteV8Module swanApi$$FavoriteV8Module, Throwable th) {
                    this.f10438e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10438e;
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
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = showFavoriteGuideApi.A(str);
                    String b2 = A == null ? "" : A.b();
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
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10440e;

                public a(SwanApi$$FileV8Module swanApi$$FileV8Module, Throwable th) {
                    this.f10440e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10440e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.a.l0.a.u.e.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.e.a)) {
                        aVar = (d.a.l0.a.u.e.e.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.e.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "File.shareFile")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10442e;

                public a(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f10442e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10442e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10443e;

                public b(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f10443e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10443e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.a.l0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.l0.a.u0.a)) {
                        aVar = (d.a.l0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
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
                d.a.l0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.l0.a.u0.a)) {
                        aVar = (d.a.l0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10446e;

                public a(SwanApi$$ImageV8Module swanApi$$ImageV8Module, Throwable th) {
                    this.f10446e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10446e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10447e;

                public b(SwanApi$$ImageV8Module swanApi$$ImageV8Module, Throwable th) {
                    this.f10447e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10447e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                d.a.l0.a.j1.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.callImageMenu[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1445003743");
                    if (obj != null && (obj instanceof d.a.l0.a.j1.b)) {
                        bVar2 = (d.a.l0.a.j1.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.j1.b(this.mSwanApiContext);
                        this.mApis.put("1445003743", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/callImageMenu");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.callImageMenu[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Image.callImageMenu[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.a.l0.a.u.e.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.f.a)) {
                        aVar = (d.a.l0.a.u.e.f.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.f.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Image.compressImage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10450e;

                public a(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10450e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10450e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10451e;

                public b(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10451e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10451e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10452e;

                public c(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10452e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10452e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10453e;

                public d(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10453e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10453e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10454e;

                public e(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10454e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10454e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10455e;

                public f(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10455e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10455e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10456e;

                public g(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10456e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10456e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10457e;

                public h(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10457e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10457e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10458e;

                public i(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10458e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10458e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10459e;

                public j(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10459e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10459e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10460e;

                public k(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10460e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10460e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10461e;

                public l(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10461e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10461e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10462e;

                public m(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10462e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10462e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10463e;

                public n(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10463e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10463e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10464e;

                public o(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10464e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10464e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10465e;

                public p(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10465e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10465e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10466e;

                public q(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10466e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10466e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10467e;

                public r(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10467e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10467e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10468e;

                public s(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10468e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10468e;
                }
            }

            /* loaded from: classes2.dex */
            public class t implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10469e;

                public t(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10469e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10469e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = gVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
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
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = gVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideLoading() {
                d.a.l0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.a)) {
                        aVar = (d.a.l0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = aVar.s();
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new n(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = cVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new o(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideToast() {
                d.a.l0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.h)) {
                        hVar = (d.a.l0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = hVar.E();
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideToast[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new p(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = eVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new q(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openPicker(String str) {
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b B = eVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new r(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = gVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openTabBar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new s(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                d.a.l0.a.u.e.g.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.d)) {
                        dVar = (d.a.l0.a.u.e.g.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.g.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t2 = dVar.t(str);
                    String b2 = t2 == null ? "" : t2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new t(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t2 = cVar.t(str);
                    String b2 = t2 == null ? "" : t2.b();
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
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
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
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = gVar.x(str);
                    String b2 = x == null ? "" : x.b();
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
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b F = eVar.F(str);
                    String b2 = F == null ? "" : F.b();
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
            public String showHalfScreenWebview(String str) {
                d.a.l0.a.u.e.g.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showHalfScreenWebview[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1172469410");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.i)) {
                        iVar = (d.a.l0.a.u.e.g.i) obj;
                    } else {
                        iVar = new d.a.l0.a.u.e.g.i(this.mSwanApiContext);
                        this.mApis.put("1172469410", iVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(iVar, "swanAPI/showHalfScreenWebview");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = iVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showHalfScreenWebview[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showHalfScreenWebview[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showLoading(String str) {
                d.a.l0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.a)) {
                        aVar = (d.a.l0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t2 = aVar.t(str);
                    String b2 = t2 == null ? "" : t2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showModal(String str) {
                d.a.l0.a.u.e.g.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.b)) {
                        bVar2 = (d.a.l0.a.u.e.g.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.g.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = bVar2.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showModal[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = cVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showToast(String str) {
                d.a.l0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.h)) {
                        hVar = (d.a.l0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b K = hVar.K(str);
                    String b2 = K == null ? "" : K.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showToast[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                d.a.l0.a.u.e.g.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.f)) {
                        fVar = (d.a.l0.a.u.e.g.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.g.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = fVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b G = eVar.G(str);
                    String b2 = G == null ? "" : G.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naKeyboard", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10490e;

                public a(SwanApi$$KeyboardV8Module swanApi$$KeyboardV8Module, Throwable th) {
                    this.f10490e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10490e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10491e;

                public b(SwanApi$$KeyboardV8Module swanApi$$KeyboardV8Module, Throwable th) {
                    this.f10491e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10491e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                d.a.l0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.startKeyboardHeightChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.h.a)) {
                        aVar = (d.a.l0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/startKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = aVar.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.startKeyboardHeightChange[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Keyboard.startKeyboardHeightChange[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                d.a.l0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.stopKeyboardHeightChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.h.a)) {
                        aVar = (d.a.l0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/stopKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = aVar.x();
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.stopKeyboardHeightChange[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Keyboard.stopKeyboardHeightChange[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10494e;

                public a(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f10494e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10494e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10495e;

                public b(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f10495e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10495e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10496e;

                public c(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f10496e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10496e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.a.l0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.i.a)) {
                        aVar = (d.a.l0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
                d.a.l0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.i.a)) {
                        aVar = (d.a.l0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
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
                d.a.l0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.i.a)) {
                        aVar = (d.a.l0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = aVar.v();
                    String b2 = v == null ? "" : v.b();
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10500e;

                public a(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10500e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10500e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10501e;

                public b(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10501e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10501e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10502e;

                public c(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10502e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10502e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10503e;

                public d(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10503e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10503e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10504e;

                public e(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10504e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10504e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String callService(String str) {
                d.a.l0.a.u.e.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.callService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1076509454");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.j.a)) {
                        aVar = (d.a.l0.a.u.e.j.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.j.a(this.mSwanApiContext);
                        this.mApis.put("-1076509454", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/callService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.callService")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.callService[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.callService[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        gVar = new g(this.mSwanApiContext);
                        this.mApis.put("968563034", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = gVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.cancelRequest[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getNetworkType() {
                d.a.l0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.j.f)) {
                        fVar = (d.a.l0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = fVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.getNetworkType[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                d.a.l0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.j.f)) {
                        fVar = (d.a.l0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = fVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.networkStatusChange[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(JsObject jsObject) {
                g gVar;
                String b2;
                try {
                    d.a.l0.a.u.g.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:V8, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        gVar = new g(this.mSwanApiContext);
                        this.mApis.put("968563034", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        b2 = ((d.a.l0.a.u.h.a) a2.second).b();
                    } else if (f.a(this.mSwanApiContext.g(), "Network.request")) {
                        b2 = new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    } else {
                        Pair<d.a.l0.a.u.h.a, JSONObject> n = d.a.l0.a.u.c.d.n(jsObject);
                        if (!((d.a.l0.a.u.h.a) n.first).a()) {
                            b2 = ((d.a.l0.a.u.h.a) n.first).b();
                        } else {
                            JSONObject jSONObject = (JSONObject) n.second;
                            if (jSONObject == null) {
                                b2 = d.a.l0.a.u.h.a.f45237a.b();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.a.l0.a.u.h.b N = gVar.N(jSONObject);
                                b2 = N == null ? "" : N.b();
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
                            new Handler(Looper.getMainLooper()).post(new e(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.a.l0.a.u.g.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10510e;

                public a(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f10510e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10510e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10511e;

                public b(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f10511e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10511e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10512e;

                public c(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f10512e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10512e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.a.l0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.l0.a.t1.c.a.a)) {
                        aVar = (d.a.l0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
                d.a.l0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.l0.a.t1.c.a.a)) {
                        aVar = (d.a.l0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
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
                d.a.l0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.l0.a.t1.c.a.a)) {
                        aVar = (d.a.l0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
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
        hashMap.put("_naPrefetch", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10516e;

                public a(SwanApi$$PrefetchV8Module swanApi$$PrefetchV8Module, Throwable th) {
                    this.f10516e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10516e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                d.a.l0.a.h0.o.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Prefetch.prefetchResources[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2068479848");
                    if (obj != null && (obj instanceof d.a.l0.a.h0.o.f.a)) {
                        aVar = (d.a.l0.a.h0.o.f.a) obj;
                    } else {
                        aVar = new d.a.l0.a.h0.o.f.a(this.mSwanApiContext);
                        this.mApis.put("-2068479848", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/prefetchResources");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Prefetch.prefetchResources[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Prefetch.prefetchResources[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPreload", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10518e;

                public a(SwanApi$$PreloadV8Module swanApi$$PreloadV8Module, Throwable th) {
                    this.f10518e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10518e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                d.a.l0.a.h0.l.g.o.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Preload.preloadStatus[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("423661539");
                    if (obj != null && (obj instanceof d.a.l0.a.h0.l.g.o.d.a)) {
                        aVar = (d.a.l0.a.h0.l.g.o.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.h0.l.g.o.d.a(this.mSwanApiContext);
                        this.mApis.put("423661539", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/preloadStatus");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Preload.preloadStatus[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Preload.preloadStatus[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10528e;

                public a(SwanApi$$PrivateFileV8Module swanApi$$PrivateFileV8Module, Throwable th) {
                    this.f10528e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10528e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                d.a.l0.a.u2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateFile.uploadFileToBos[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1929343869");
                    if (obj != null && (obj instanceof d.a.l0.a.u2.b)) {
                        bVar2 = (d.a.l0.a.u2.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u2.b(this.mSwanApiContext);
                        this.mApis.put("-1929343869", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/uploadFileToBos");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = bVar2.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateFile.uploadFileToBos[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateFile.uploadFileToBos[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10532e;

                public a(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10532e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10532e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10533e;

                public b(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10533e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10533e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10534e;

                public c(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10534e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10534e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10535e;

                public d(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10535e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10535e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.a.l0.a.u.e.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.a)) {
                        aVar = (d.a.l0.a.u.e.k.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.k.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
                d.a.l0.a.u.e.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.b)) {
                        bVar2 = (d.a.l0.a.u.e.k.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.k.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = bVar2.v(str);
                    String b2 = v == null ? "" : v.b();
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
                d.a.l0.a.u.e.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.d)) {
                        dVar = (d.a.l0.a.u.e.k.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.k.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = dVar.v(str);
                    String b2 = v == null ? "" : v.b();
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
                d.a.l0.a.u.e.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.c)) {
                        cVar = (d.a.l0.a.u.e.k.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.k.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = cVar.w(str);
                    String b2 = w == null ? "" : w.b();
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10540e;

                public a(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10540e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10540e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10541e;

                public b(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10541e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10541e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10542e;

                public c(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10542e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10542e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10543e;

                public d(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10543e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10543e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10544e;

                public e(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10544e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10544e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10545e;

                public f(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10545e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10545e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = bVar2.z();
                    String b2 = z == null ? "" : z.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = bVar2.A(str);
                    String b2 = A == null ? "" : A.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b B = bVar2.B();
                    String b2 = B == null ? "" : B.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b C = bVar2.C(str);
                    String b2 = C == null ? "" : C.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b D = bVar2.D(str);
                    String b2 = D == null ? "" : D.b();
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

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                d.a.l0.a.u.e.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.isAllowedAdOpenAppSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("450273045");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.a)) {
                        aVar = (d.a.l0.a.u.e.l.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.l.a(this.mSwanApiContext);
                        this.mApis.put("450273045", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/isAllowedAdOpenAppSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.isAllowedAdOpenAppSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.isAllowedAdOpenAppSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naStatisticEvent", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10552e;

                public a(SwanApi$$StatisticEventV8Module swanApi$$StatisticEventV8Module, Throwable th) {
                    this.f10552e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10552e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                o oVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================StatisticEvent.ubcAndCeresStatisticEvent[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("712777136");
                    if (obj != null && (obj instanceof o)) {
                        oVar = (o) obj;
                    } else {
                        oVar = new o(this.mSwanApiContext);
                        this.mApis.put("712777136", oVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(oVar, "swanAPI/ubcAndCeresStatisticEvent");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = oVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[StatisticEvent.ubcAndCeresStatisticEvent[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[StatisticEvent.ubcAndCeresStatisticEvent[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10554e;

                public a(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10554e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10554e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10555e;

                public b(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10555e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10555e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10556e;

                public c(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10556e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10556e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10557e;

                public d(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10557e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10557e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10558e;

                public e(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10558e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10558e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10559e;

                public f(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10559e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10559e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10560e;

                public g(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10560e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10560e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10561e;

                public h(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10561e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10561e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10562e;

                public i(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10562e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10562e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10563e;

                public j(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10563e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10563e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10564e;

                public k(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10564e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10564e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10565e;

                public l(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10565e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10565e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10566e;

                public m(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10566e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10566e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10567e;

                public n(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10567e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10567e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10568e;

                public o(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10568e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10568e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10569e;

                public p(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10569e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10569e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10570e;

                public q(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10570e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10570e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10571e;

                public r(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10571e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10571e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10572e;

                public s(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10572e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10572e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = bVar2.r();
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearGlobalStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = bVar2.s();
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearGlobalStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearStorage() {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = aVar.r();
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearStorageSync() {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = aVar.s();
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new n(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = bVar2.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new o(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = bVar2.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorageInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new p(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b K = bVar2.K();
                    String b2 = K == null ? "" : K.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfoSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorageInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new q(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = bVar2.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new r(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorage(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new s(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageInfo() {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = aVar.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = aVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b D = bVar2.D(str);
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeGlobalStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = bVar2.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeGlobalStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b D = aVar.D(str);
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = aVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b F = bVar2.F(str);
                    String b2 = F == null ? "" : F.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setGlobalStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b G = bVar2.G(str);
                    String b2 = G == null ? "" : G.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setGlobalStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorage(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b F = aVar.F(str);
                    String b2 = F == null ? "" : F.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b G = aVar.G(str);
                    String b2 = G == null ? "" : G.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorageSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10592e;

                public a(SwanApi$$SubscriptionV8Module swanApi$$SubscriptionV8Module, Throwable th) {
                    this.f10592e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10592e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.a.l0.a.u.e.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.n.a)) {
                        aVar = (d.a.l0.a.u.e.n.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.n.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10594e;

                public a(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10594e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10594e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10595e;

                public b(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10595e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10595e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10596e;

                public c(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10596e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10596e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10597e;

                public d(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10597e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10597e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10598e;

                public e(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10598e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10598e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10599e;

                public f(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10599e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10599e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10600e;

                public g(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10600e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10600e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10601e;

                public h(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10601e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10601e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10602e;

                public i(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10602e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10602e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10603e;

                public j(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10603e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10603e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10604e;

                public k(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10604e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10604e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10605e;

                public l(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10605e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10605e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10606e;

                public m(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10606e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10606e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkPhoneContactsAuthorization(String str) {
                d.a.l0.a.u.e.o.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.checkPhoneContactsAuthorization[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1112806039");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.h)) {
                        hVar = (d.a.l0.a.u.e.o.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.o.h(this.mSwanApiContext);
                        this.mApis.put("-1112806039", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPIcheckPhoneContactsAuthorization");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.checkPhoneContactsAuthorization")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = hVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.checkPhoneContactsAuthorization[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.checkPhoneContactsAuthorization[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.a.l0.a.u.e.o.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.f)) {
                        fVar = (d.a.l0.a.u.e.o.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.o.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = fVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.exitFullScreen[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getBrightness() {
                d.a.l0.a.u.e.o.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.b)) {
                        bVar2 = (d.a.l0.a.u.e.o.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.o.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getBrightness[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getClipboardData() {
                d.a.l0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.c)) {
                        cVar = (d.a.l0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = cVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getClipboardData[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                d.a.l0.a.u.e.o.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.e)) {
                        eVar = (d.a.l0.a.u.e.o.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.o.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = eVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getDeviceInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                d.a.l0.a.u.e.o.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.g)) {
                        gVar = (d.a.l0.a.u.e.o.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.o.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = gVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.makePhoneCall[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                d.a.l0.a.u.e.o.j jVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.j)) {
                        jVar = (d.a.l0.a.u.e.o.j) obj;
                    } else {
                        jVar = new d.a.l0.a.u.e.o.j(this.mSwanApiContext);
                        this.mApis.put("1099851202", jVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(jVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = jVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.openSMSPanel[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                d.a.l0.a.u.e.o.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.i)) {
                        iVar = (d.a.l0.a.u.e.o.i) obj;
                    } else {
                        iVar = new d.a.l0.a.u.e.o.i(this.mSwanApiContext);
                        this.mApis.put("-1707203360", iVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(iVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = iVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.requestFullScreen[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                d.a.l0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.c)) {
                        cVar = (d.a.l0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = cVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.setClipboardData[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                d.a.l0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.a)) {
                        aVar = (d.a.l0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startCompass(String str) {
                d.a.l0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.d)) {
                        dVar = (d.a.l0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startCompass")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = dVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startCompass[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                d.a.l0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.a)) {
                        aVar = (d.a.l0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t();
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopAccelerometer[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopCompass() {
                d.a.l0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.d)) {
                        dVar = (d.a.l0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = dVar.t();
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10620e;

                public a(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10620e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10620e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10621e;

                public b(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10621e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10621e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10622e;

                public c(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10622e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10622e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10623e;

                public d(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10623e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10623e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10624e;

                public e(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10624e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10624e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10625e;

                public f(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10625e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10625e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10626e;

                public g(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10626e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10626e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10627e;

                public h(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10627e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10627e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10628e;

                public i(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10628e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10628e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10629e;

                public j(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10629e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10629e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                d.a.l0.a.u.e.p.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.addToDesktop[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("201194468");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.b)) {
                        bVar2 = (d.a.l0.a.u.e.p.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.p.b(this.mSwanApiContext);
                        this.mApis.put("201194468", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/addToDesktop");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = bVar2.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.addToDesktop[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.addToDesktop[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.a.l0.a.u.e.p.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.a)) {
                        aVar = (d.a.l0.a.u.e.p.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.p.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                d.a.l0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.f)) {
                        fVar = (d.a.l0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = fVar.v();
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfo() {
                d.a.l0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.f)) {
                        fVar = (d.a.l0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b y = fVar.y();
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                d.a.l0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.f)) {
                        fVar = (d.a.l0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = fVar.z();
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String handleException(String str) {
                d.a.l0.a.u.e.p.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.c)) {
                        cVar = (d.a.l0.a.u.e.p.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.p.c(this.mSwanApiContext);
                        this.mApis.put("-2097727681", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = cVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.handleException[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                d.a.l0.a.d2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.hideCaptureScreenShareDialog[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1031678042");
                    if (obj != null && (obj instanceof d.a.l0.a.d2.b)) {
                        bVar2 = (d.a.l0.a.d2.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.d2.b(this.mSwanApiContext);
                        this.mApis.put("1031678042", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/hideCaptureScreenShareDialog");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.hideCaptureScreenShareDialog[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.hideCaptureScreenShareDialog[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String logToFile(String str) {
                d.a.l0.a.u.e.p.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.logToFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1751900130");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.d)) {
                        dVar = (d.a.l0.a.u.e.p.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.p.d(this.mSwanApiContext);
                        this.mApis.put("1751900130", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/logToFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = dVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.logToFile[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.logToFile[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String previewImage(String str) {
                d.a.l0.a.u.e.p.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.e)) {
                        eVar = (d.a.l0.a.u.e.p.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.p.e(this.mSwanApiContext);
                        this.mApis.put("589529211", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = eVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.previewImage[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                d.a.l0.a.u.e.p.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.h)) {
                        hVar = (d.a.l0.a.u.e.p.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.p.h(this.mSwanApiContext);
                        this.mApis.put("-577481801", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b B = hVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10407e;

                public a(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10407e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10407e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10408e;

                public b(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10408e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10408e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10409e;

                public c(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10409e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10409e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10410e;

                public d(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10410e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10410e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10411e;

                public e(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10411e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10411e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10412e;

                public f(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10412e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10412e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10413e;

                public g(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10413e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10413e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.a.l0.a.u.e.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.b)) {
                        bVar2 = (d.a.l0.a.u.e.a.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.a.b(this.mSwanApiContext);
                        this.mApis.put("1930258908", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
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
            public String getLoginCode(String str) {
                d.a.l0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getLoginCode[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.c)) {
                        cVar = (d.a.l0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/getLoginCode");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getLoginCode[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.getLoginCode[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getOpenId(String str) {
                d.a.l0.a.u.e.a.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getOpenId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1754780133");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.d)) {
                        dVar = (d.a.l0.a.u.e.a.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.a.d(this.mSwanApiContext);
                        this.mApis.put("1754780133", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/getOpenId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = dVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getOpenId[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.getOpenId[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getUnionBDUSS(String str) {
                d.a.l0.a.s.a.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getUnionBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-343998465");
                    if (obj != null && (obj instanceof d.a.l0.a.s.a.j.a)) {
                        aVar = (d.a.l0.a.s.a.j.a) obj;
                    } else {
                        aVar = new d.a.l0.a.s.a.j.a(this.mSwanApiContext);
                        this.mApis.put("-343998465", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getUnionBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getUnionBDUSS[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.getUnionBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String isBaiduAccountSync() {
                d.a.l0.a.u.e.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isBaiduAccountSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-337742792");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.a)) {
                        aVar = (d.a.l0.a.u.e.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.a.a(this.mSwanApiContext);
                        this.mApis.put("-337742792", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/isBaiduAccountSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isBaiduAccountSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.isBaiduAccountSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String isLoginSync() {
                d.a.l0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.c)) {
                        cVar = (d.a.l0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = cVar.z();
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.isLoginSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String login(String str) {
                d.a.l0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.a.c)) {
                        cVar = (d.a.l0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.login")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = cVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Account.login[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10416e;

                public a(SwanApi$$BasicWebviewModule swanApi$$BasicWebviewModule, Throwable th) {
                    this.f10416e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10416e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10417e;

                public b(SwanApi$$BasicWebviewModule swanApi$$BasicWebviewModule, Throwable th) {
                    this.f10417e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10417e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.a.l0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.b.a)) {
                        aVar = (d.a.l0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
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

            @JavascriptInterface
            public String loadSubPackages(String str) {
                d.a.l0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackages[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.b.a)) {
                        aVar = (d.a.l0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/loadSubPackages");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = aVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackages[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Basic.loadSubPackages[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10423e;

                public a(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10423e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10423e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10424e;

                public b(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10424e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10424e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10425e;

                public c(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10425e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10425e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10426e;

                public d(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10426e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10426e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10427e;

                public e(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10427e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10427e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.deleteBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/deleteBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = aVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.deleteBookshelf[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.deleteBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String insertBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b J = aVar.J(str);
                    String b2 = J == null ? "" : J.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String navigateToBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b O = aVar.O(str);
                    String b2 = O == null ? "" : O.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryBookshelf(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b P = aVar.P(str);
                    String b2 = P == null ? "" : P.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateBookshelfReadTime(String str) {
                d.a.l0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.l0.a.n.b.a)) {
                        aVar = (d.a.l0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.l0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b R = aVar.R(str);
                    String b2 = R == null ? "" : R.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naCalendar", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$CalendarWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10430e;

                public a(SwanApi$$CalendarWebviewModule swanApi$$CalendarWebviewModule, Throwable th) {
                    this.f10430e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10430e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10431e;

                public b(SwanApi$$CalendarWebviewModule swanApi$$CalendarWebviewModule, Throwable th) {
                    this.f10431e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10431e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addEventOnCalendar(String str) {
                d.a.l0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.addEventOnCalendar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.c.a)) {
                        aVar = (d.a.l0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/addEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.addEventOnCalendar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.addEventOnCalendar[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Calendar.addEventOnCalendar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String deleteEventOnCalendar(String str) {
                d.a.l0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.deleteEventOnCalendar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.c.a)) {
                        aVar = (d.a.l0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/deleteEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.deleteEventOnCalendar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = aVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.deleteEventOnCalendar[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Calendar.deleteEventOnCalendar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naCoupon", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10435e;

                public a(SwanApi$$CouponWebviewModule swanApi$$CouponWebviewModule, Throwable th) {
                    this.f10435e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10435e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10436e;

                public b(SwanApi$$CouponWebviewModule swanApi$$CouponWebviewModule, Throwable th) {
                    this.f10436e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10436e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10437e;

                public c(SwanApi$$CouponWebviewModule swanApi$$CouponWebviewModule, Throwable th) {
                    this.f10437e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10437e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                d.a.l0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getPlatformCoupons[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.l0.a.u.d.a)) {
                        aVar = (d.a.l0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/coupon/getPlatformCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getPlatformCoupons[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Coupon.getPlatformCoupons[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getUserCoupons(String str) {
                d.a.l0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getUserCoupons[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.l0.a.u.d.a)) {
                        aVar = (d.a.l0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/coupon/getUserCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getUserCoupons[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Coupon.getUserCoupons[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String takeCoupons(String str) {
                d.a.l0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.takeCoupons[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.l0.a.u.d.a)) {
                        aVar = (d.a.l0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/coupon/takeCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = aVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.takeCoupons[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Coupon.takeCoupons[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10439e;

                public a(SwanApi$$FavoriteWebviewModule swanApi$$FavoriteWebviewModule, Throwable th) {
                    this.f10439e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10439e;
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
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = showFavoriteGuideApi.A(str);
                    String b2 = A == null ? "" : A.b();
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
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10441e;

                public a(SwanApi$$FileWebviewModule swanApi$$FileWebviewModule, Throwable th) {
                    this.f10441e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10441e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.a.l0.a.u.e.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.e.a)) {
                        aVar = (d.a.l0.a.u.e.e.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.e.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "File.shareFile")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10444e;

                public a(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f10444e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10444e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10445e;

                public b(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f10445e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10445e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.a.l0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.l0.a.u0.a)) {
                        aVar = (d.a.l0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
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
                d.a.l0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.l0.a.u0.a)) {
                        aVar = (d.a.l0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10448e;

                public a(SwanApi$$ImageWebviewModule swanApi$$ImageWebviewModule, Throwable th) {
                    this.f10448e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10448e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10449e;

                public b(SwanApi$$ImageWebviewModule swanApi$$ImageWebviewModule, Throwable th) {
                    this.f10449e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10449e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String callImageMenu(String str) {
                d.a.l0.a.j1.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.callImageMenu[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1445003743");
                    if (obj != null && (obj instanceof d.a.l0.a.j1.b)) {
                        bVar2 = (d.a.l0.a.j1.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.j1.b(this.mSwanApiContext);
                        this.mApis.put("1445003743", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/callImageMenu");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.callImageMenu[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Image.callImageMenu[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String compressImage(String str) {
                d.a.l0.a.u.e.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.f.a)) {
                        aVar = (d.a.l0.a.u.e.f.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.f.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Image.compressImage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10470e;

                public a(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10470e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10470e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10471e;

                public b(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10471e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10471e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10472e;

                public c(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10472e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10472e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10473e;

                public d(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10473e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10473e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10474e;

                public e(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10474e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10474e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10475e;

                public f(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10475e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10475e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10476e;

                public g(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10476e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10476e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10477e;

                public h(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10477e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10477e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10478e;

                public i(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10478e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10478e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10479e;

                public j(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10479e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10479e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10480e;

                public k(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10480e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10480e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10481e;

                public l(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10481e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10481e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10482e;

                public m(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10482e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10482e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10483e;

                public n(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10483e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10483e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10484e;

                public o(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10484e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10484e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10485e;

                public p(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10485e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10485e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10486e;

                public q(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10486e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10486e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10487e;

                public r(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10487e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10487e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10488e;

                public s(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10488e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10488e;
                }
            }

            /* loaded from: classes2.dex */
            public class t implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10489e;

                public t(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10489e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10489e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = gVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
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
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = gVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideLoading() {
                d.a.l0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.a)) {
                        aVar = (d.a.l0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = aVar.s();
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new n(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideNavigationBarLoading(String str) {
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = cVar.s(str);
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new o(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideToast() {
                d.a.l0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.h)) {
                        hVar = (d.a.l0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = hVar.E();
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.hideToast[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new p(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openMultiPicker(String str) {
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = eVar.A(str);
                    String b2 = A == null ? "" : A.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new q(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openPicker(String str) {
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b B = eVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new r(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openTabBar(String str) {
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = gVar.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new s(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String pageScrollTo(String str) {
                d.a.l0.a.u.e.g.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.d)) {
                        dVar = (d.a.l0.a.u.e.g.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.g.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t2 = dVar.t(str);
                    String b2 = t2 == null ? "" : t2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new t(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setNavigationBarColor(String str) {
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t2 = cVar.t(str);
                    String b2 = t2 == null ? "" : t2.b();
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
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = cVar.u(str);
                    String b2 = u == null ? "" : u.b();
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
                d.a.l0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.g)) {
                        gVar = (d.a.l0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = gVar.x(str);
                    String b2 = x == null ? "" : x.b();
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
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b F = eVar.F(str);
                    String b2 = F == null ? "" : F.b();
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
            public String showHalfScreenWebview(String str) {
                d.a.l0.a.u.e.g.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showHalfScreenWebview[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1172469410");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.i)) {
                        iVar = (d.a.l0.a.u.e.g.i) obj;
                    } else {
                        iVar = new d.a.l0.a.u.e.g.i(this.mSwanApiContext);
                        this.mApis.put("1172469410", iVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(iVar, "swanAPI/showHalfScreenWebview");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = iVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showHalfScreenWebview[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showHalfScreenWebview[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showLoading(String str) {
                d.a.l0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.a)) {
                        aVar = (d.a.l0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t2 = aVar.t(str);
                    String b2 = t2 == null ? "" : t2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showModal(String str) {
                d.a.l0.a.u.e.g.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.b)) {
                        bVar2 = (d.a.l0.a.u.e.g.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.g.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = bVar2.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showModal[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showNavigationBarLoading(String str) {
                d.a.l0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.c)) {
                        cVar = (d.a.l0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = cVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String showToast(String str) {
                d.a.l0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.h)) {
                        hVar = (d.a.l0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b K = hVar.K(str);
                    String b2 = K == null ? "" : K.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.showToast[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopPullDownRefresh(String str) {
                d.a.l0.a.u.e.g.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.f)) {
                        fVar = (d.a.l0.a.u.e.g.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.g.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = fVar.r(str);
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String updateMultiPicker(String str) {
                d.a.l0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.g.e)) {
                        eVar = (d.a.l0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b G = eVar.G(str);
                    String b2 = G == null ? "" : G.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naKeyboard", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10492e;

                public a(SwanApi$$KeyboardWebviewModule swanApi$$KeyboardWebviewModule, Throwable th) {
                    this.f10492e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10492e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10493e;

                public b(SwanApi$$KeyboardWebviewModule swanApi$$KeyboardWebviewModule, Throwable th) {
                    this.f10493e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10493e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                d.a.l0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.startKeyboardHeightChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.h.a)) {
                        aVar = (d.a.l0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/startKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = aVar.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.startKeyboardHeightChange[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Keyboard.startKeyboardHeightChange[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopKeyboardHeightChange() {
                d.a.l0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.stopKeyboardHeightChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.h.a)) {
                        aVar = (d.a.l0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/stopKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = aVar.x();
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.stopKeyboardHeightChange[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Keyboard.stopKeyboardHeightChange[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10497e;

                public a(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f10497e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10497e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10498e;

                public b(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f10498e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10498e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10499e;

                public c(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f10499e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10499e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.a.l0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.i.a)) {
                        aVar = (d.a.l0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
                d.a.l0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.i.a)) {
                        aVar = (d.a.l0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
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
                d.a.l0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.i.a)) {
                        aVar = (d.a.l0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = aVar.v();
                    String b2 = v == null ? "" : v.b();
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10505e;

                public a(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10505e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10505e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10506e;

                public b(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10506e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10506e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10507e;

                public c(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10507e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10507e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10508e;

                public d(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10508e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10508e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10509e;

                public e(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10509e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10509e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String callService(String str) {
                d.a.l0.a.u.e.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.callService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1076509454");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.j.a)) {
                        aVar = (d.a.l0.a.u.e.j.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.j.a(this.mSwanApiContext);
                        this.mApis.put("-1076509454", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/callService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.callService")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.callService[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.callService[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String cancelRequest(String str) {
                g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.cancelRequest[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        gVar = new g(this.mSwanApiContext);
                        this.mApis.put("968563034", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = gVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.cancelRequest[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getNetworkType() {
                d.a.l0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.j.f)) {
                        fVar = (d.a.l0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = fVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.getNetworkType[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String networkStatusChange(String str) {
                d.a.l0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.j.f)) {
                        fVar = (d.a.l0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = fVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @JavascriptInterface
            public String request(String str) {
                g gVar;
                String b2;
                try {
                    d.a.l0.a.u.g.c.c().a("request");
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.request[type:Webview, v8 binding:true]====================");
                    }
                    Object obj = this.mApis.get("968563034");
                    if (obj != null && (obj instanceof g)) {
                        gVar = (g) obj;
                    } else {
                        gVar = new g(this.mSwanApiContext);
                        this.mApis.put("968563034", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/request");
                    if (((Boolean) a2.first).booleanValue()) {
                        b2 = ((d.a.l0.a.u.h.a) a2.second).b();
                    } else if (f.a(this.mSwanApiContext.g(), "Network.request")) {
                        b2 = new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    } else {
                        Pair<d.a.l0.a.u.h.a, JSONObject> o = d.a.l0.a.u.c.d.o(str);
                        if (!((d.a.l0.a.u.h.a) o.first).a()) {
                            b2 = ((d.a.l0.a.u.h.a) o.first).b();
                        } else {
                            JSONObject jSONObject = (JSONObject) o.second;
                            if (jSONObject == null) {
                                b2 = d.a.l0.a.u.h.a.f45237a.b();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.a.l0.a.u.h.b N = gVar.N(jSONObject);
                                b2 = N == null ? "" : N.b();
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
                            new Handler(Looper.getMainLooper()).post(new e(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.a.l0.a.u.g.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10513e;

                public a(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f10513e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10513e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10514e;

                public b(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f10514e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10514e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10515e;

                public c(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f10515e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10515e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.a.l0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.l0.a.t1.c.a.a)) {
                        aVar = (d.a.l0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
                d.a.l0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.l0.a.t1.c.a.a)) {
                        aVar = (d.a.l0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
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
                d.a.l0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.l0.a.t1.c.a.a)) {
                        aVar = (d.a.l0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.l0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
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
        hashMap.put("_naPrefetch", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10517e;

                public a(SwanApi$$PrefetchWebviewModule swanApi$$PrefetchWebviewModule, Throwable th) {
                    this.f10517e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10517e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                d.a.l0.a.h0.o.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Prefetch.prefetchResources[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2068479848");
                    if (obj != null && (obj instanceof d.a.l0.a.h0.o.f.a)) {
                        aVar = (d.a.l0.a.h0.o.f.a) obj;
                    } else {
                        aVar = new d.a.l0.a.h0.o.f.a(this.mSwanApiContext);
                        this.mApis.put("-2068479848", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/prefetchResources");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Prefetch.prefetchResources[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Prefetch.prefetchResources[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPreload", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10519e;

                public a(SwanApi$$PreloadWebviewModule swanApi$$PreloadWebviewModule, Throwable th) {
                    this.f10519e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10519e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                d.a.l0.a.h0.l.g.o.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Preload.preloadStatus[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("423661539");
                    if (obj != null && (obj instanceof d.a.l0.a.h0.l.g.o.d.a)) {
                        aVar = (d.a.l0.a.h0.l.g.o.d.a) obj;
                    } else {
                        aVar = new d.a.l0.a.h0.l.g.o.d.a(this.mSwanApiContext);
                        this.mApis.put("423661539", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/preloadStatus");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Preload.preloadStatus[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Preload.preloadStatus[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10529e;

                public a(SwanApi$$PrivateFileWebviewModule swanApi$$PrivateFileWebviewModule, Throwable th) {
                    this.f10529e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10529e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                d.a.l0.a.u2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateFile.uploadFileToBos[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1929343869");
                    if (obj != null && (obj instanceof d.a.l0.a.u2.b)) {
                        bVar2 = (d.a.l0.a.u2.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u2.b(this.mSwanApiContext);
                        this.mApis.put("-1929343869", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/uploadFileToBos");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = bVar2.w(str);
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateFile.uploadFileToBos[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateFile.uploadFileToBos[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10536e;

                public a(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10536e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10536e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10537e;

                public b(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10537e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10537e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10538e;

                public c(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10538e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10538e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10539e;

                public d(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10539e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10539e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.a.l0.a.u.e.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.a)) {
                        aVar = (d.a.l0.a.u.e.k.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.k.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
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
                d.a.l0.a.u.e.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.b)) {
                        bVar2 = (d.a.l0.a.u.e.k.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.k.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = bVar2.v(str);
                    String b2 = v == null ? "" : v.b();
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
                d.a.l0.a.u.e.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.d)) {
                        dVar = (d.a.l0.a.u.e.k.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.k.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = dVar.v(str);
                    String b2 = v == null ? "" : v.b();
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
                d.a.l0.a.u.e.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.k.c)) {
                        cVar = (d.a.l0.a.u.e.k.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.k.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = cVar.w(str);
                    String b2 = w == null ? "" : w.b();
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10546e;

                public a(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10546e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10546e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10547e;

                public b(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10547e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10547e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10548e;

                public c(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10548e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10548e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10549e;

                public d(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10549e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10549e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10550e;

                public e(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10550e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10550e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10551e;

                public f(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10551e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10551e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = bVar2.z();
                    String b2 = z == null ? "" : z.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b A = bVar2.A(str);
                    String b2 = A == null ? "" : A.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b B = bVar2.B();
                    String b2 = B == null ? "" : B.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b C = bVar2.C(str);
                    String b2 = C == null ? "" : C.b();
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
                d.a.l0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.b)) {
                        bVar2 = (d.a.l0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b D = bVar2.D(str);
                    String b2 = D == null ? "" : D.b();
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

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                d.a.l0.a.u.e.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.isAllowedAdOpenAppSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("450273045");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.l.a)) {
                        aVar = (d.a.l0.a.u.e.l.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.l.a(this.mSwanApiContext);
                        this.mApis.put("450273045", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/isAllowedAdOpenAppSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = aVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.isAllowedAdOpenAppSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Setting.isAllowedAdOpenAppSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naStatisticEvent", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10553e;

                public a(SwanApi$$StatisticEventWebviewModule swanApi$$StatisticEventWebviewModule, Throwable th) {
                    this.f10553e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10553e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String ubcAndCeresStatisticEvent(String str) {
                o oVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================StatisticEvent.ubcAndCeresStatisticEvent[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("712777136");
                    if (obj != null && (obj instanceof o)) {
                        oVar = (o) obj;
                    } else {
                        oVar = new o(this.mSwanApiContext);
                        this.mApis.put("712777136", oVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(oVar, "swanAPI/ubcAndCeresStatisticEvent");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = oVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[StatisticEvent.ubcAndCeresStatisticEvent[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[StatisticEvent.ubcAndCeresStatisticEvent[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10573e;

                public a(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10573e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10573e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10574e;

                public b(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10574e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10574e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10575e;

                public c(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10575e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10575e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10576e;

                public d(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10576e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10576e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10577e;

                public e(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10577e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10577e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10578e;

                public f(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10578e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10578e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10579e;

                public g(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10579e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10579e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10580e;

                public h(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10580e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10580e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10581e;

                public i(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10581e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10581e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10582e;

                public j(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10582e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10582e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10583e;

                public k(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10583e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10583e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10584e;

                public l(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10584e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10584e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10585e;

                public m(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10585e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10585e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10586e;

                public n(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10586e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10586e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10587e;

                public o(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10587e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10587e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10588e;

                public p(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10588e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10588e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10589e;

                public q(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10589e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10589e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10590e;

                public r(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10590e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10590e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10591e;

                public s(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10591e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10591e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = bVar2.r();
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearGlobalStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearGlobalStorageSync() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = bVar2.s();
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearGlobalStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearStorage() {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r2 = aVar.r();
                    String b2 = r2 == null ? "" : r2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String clearStorageSync() {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s2 = aVar.s();
                    String b2 = s2 == null ? "" : s2.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new n(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorage(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = bVar2.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new o(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorageInfo() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = bVar2.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorageInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new p(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorageInfoSync() {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b K = bVar2.K();
                    String b2 = K == null ? "" : K.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfoSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorageInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new q(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getGlobalStorageSync(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = bVar2.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getGlobalStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new r(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorage(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new s(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageInfo() {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b w = aVar.w();
                    String b2 = w == null ? "" : w.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getStorageSync(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = aVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeGlobalStorage(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b D = bVar2.D(str);
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeGlobalStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeGlobalStorageSync(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = bVar2.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeGlobalStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorage(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b D = aVar.D(str);
                    String b2 = D == null ? "" : D.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String removeStorageSync(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b E = aVar.E(str);
                    String b2 = E == null ? "" : E.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setGlobalStorage(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b F = bVar2.F(str);
                    String b2 = F == null ? "" : F.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setGlobalStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setGlobalStorageSync(String str) {
                d.a.l0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.b)) {
                        bVar2 = (d.a.l0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b G = bVar2.G(str);
                    String b2 = G == null ? "" : G.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setGlobalStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorage(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b F = aVar.F(str);
                    String b2 = F == null ? "" : F.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setStorageSync(String str) {
                d.a.l0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.m.a)) {
                        aVar = (d.a.l0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b G = aVar.G(str);
                    String b2 = G == null ? "" : G.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
            public static final boolean DEBUG = d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10593e;

                public a(SwanApi$$SubscriptionWebviewModule swanApi$$SubscriptionWebviewModule, Throwable th) {
                    this.f10593e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10593e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.a.l0.a.u.e.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.n.a)) {
                        aVar = (d.a.l0.a.u.e.n.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.n.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = aVar.z(str);
                    String b2 = z == null ? "" : z.b();
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
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10607e;

                public a(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10607e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10607e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10608e;

                public b(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10608e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10608e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10609e;

                public c(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10609e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10609e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10610e;

                public d(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10610e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10610e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10611e;

                public e(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10611e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10611e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10612e;

                public f(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10612e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10612e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10613e;

                public g(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10613e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10613e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10614e;

                public h(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10614e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10614e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10615e;

                public i(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10615e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10615e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10616e;

                public j(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10616e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10616e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10617e;

                public k(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10617e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10617e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10618e;

                public l(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10618e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10618e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10619e;

                public m(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10619e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10619e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkPhoneContactsAuthorization(String str) {
                d.a.l0.a.u.e.o.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.checkPhoneContactsAuthorization[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1112806039");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.h)) {
                        hVar = (d.a.l0.a.u.e.o.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.o.h(this.mSwanApiContext);
                        this.mApis.put("-1112806039", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPIcheckPhoneContactsAuthorization");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.checkPhoneContactsAuthorization")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = hVar.t(str);
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.checkPhoneContactsAuthorization[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.checkPhoneContactsAuthorization[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String exitFullScreen(String str) {
                d.a.l0.a.u.e.o.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.f)) {
                        fVar = (d.a.l0.a.u.e.o.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.o.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = fVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.exitFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getBrightness() {
                d.a.l0.a.u.e.o.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.b)) {
                        bVar2 = (d.a.l0.a.u.e.o.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.o.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getBrightness[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getClipboardData() {
                d.a.l0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.c)) {
                        cVar = (d.a.l0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = cVar.r();
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getDeviceInfo(String str) {
                d.a.l0.a.u.e.o.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.e)) {
                        eVar = (d.a.l0.a.u.e.o.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.o.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = eVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String makePhoneCall(String str) {
                d.a.l0.a.u.e.o.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.g)) {
                        gVar = (d.a.l0.a.u.e.o.g) obj;
                    } else {
                        gVar = new d.a.l0.a.u.e.o.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = gVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.makePhoneCall[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String openSMSPanel(String str) {
                d.a.l0.a.u.e.o.j jVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.j)) {
                        jVar = (d.a.l0.a.u.e.o.j) obj;
                    } else {
                        jVar = new d.a.l0.a.u.e.o.j(this.mSwanApiContext);
                        this.mApis.put("1099851202", jVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(jVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = jVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.openSMSPanel[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new k(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String requestFullScreen(String str) {
                d.a.l0.a.u.e.o.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.i)) {
                        iVar = (d.a.l0.a.u.e.o.i) obj;
                    } else {
                        iVar = new d.a.l0.a.u.e.o.i(this.mSwanApiContext);
                        this.mApis.put("-1707203360", iVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(iVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b x = iVar.x(str);
                    String b2 = x == null ? "" : x.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.requestFullScreen[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new l(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String setClipboardData(String str) {
                d.a.l0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.c)) {
                        cVar = (d.a.l0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = cVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.setClipboardData[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new m(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startAccelerometer(String str) {
                d.a.l0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.a)) {
                        aVar = (d.a.l0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = aVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String startCompass(String str) {
                d.a.l0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.d)) {
                        dVar = (d.a.l0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startCompass")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = dVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.startCompass[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopAccelerometer() {
                d.a.l0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.a)) {
                        aVar = (d.a.l0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = aVar.t();
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String stopCompass() {
                d.a.l0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.o.d)) {
                        dVar = (d.a.l0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b t = dVar.t();
                    String b2 = t == null ? "" : t.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[System.stopCompass[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
            public static final boolean DEBUG = d.a.l0.a.u.c.d.f44812c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.l0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10630e;

                public a(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10630e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10630e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10631e;

                public b(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10631e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10631e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10632e;

                public c(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10632e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10632e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10633e;

                public d(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10633e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10633e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10634e;

                public e(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10634e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10634e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10635e;

                public f(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10635e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10635e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10636e;

                public g(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10636e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10636e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10637e;

                public h(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10637e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10637e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10638e;

                public i(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10638e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10638e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10639e;

                public j(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10639e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10639e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                d.a.l0.a.u.e.p.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.addToDesktop[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("201194468");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.b)) {
                        bVar2 = (d.a.l0.a.u.e.p.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.u.e.p.b(this.mSwanApiContext);
                        this.mApis.put("201194468", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/addToDesktop");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = bVar2.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.addToDesktop[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.addToDesktop[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String checkAppInstalled(String str) {
                d.a.l0.a.u.e.p.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.a)) {
                        aVar = (d.a.l0.a.u.e.p.a) obj;
                    } else {
                        aVar = new d.a.l0.a.u.e.p.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b u = aVar.u(str);
                    String b2 = u == null ? "" : u.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getCommonSysInfoSync() {
                d.a.l0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.f)) {
                        fVar = (d.a.l0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = fVar.v();
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new d(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfo() {
                d.a.l0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.f)) {
                        fVar = (d.a.l0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b y = fVar.y();
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new e(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String getSystemInfoSync() {
                d.a.l0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.f)) {
                        fVar = (d.a.l0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.l0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(fVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b z = fVar.z();
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new f(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String handleException(String str) {
                d.a.l0.a.u.e.p.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.c)) {
                        cVar = (d.a.l0.a.u.e.p.c) obj;
                    } else {
                        cVar = new d.a.l0.a.u.e.p.c(this.mSwanApiContext);
                        this.mApis.put("-2097727681", cVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(cVar, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = cVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.handleException[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new g(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String hideCaptureScreenShareDialog(String str) {
                d.a.l0.a.d2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.hideCaptureScreenShareDialog[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1031678042");
                    if (obj != null && (obj instanceof d.a.l0.a.d2.b)) {
                        bVar2 = (d.a.l0.a.d2.b) obj;
                    } else {
                        bVar2 = new d.a.l0.a.d2.b(this.mSwanApiContext);
                        this.mApis.put("1031678042", bVar2);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(bVar2, "swanAPI/hideCaptureScreenShareDialog");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.hideCaptureScreenShareDialog[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.hideCaptureScreenShareDialog[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new h(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String logToFile(String str) {
                d.a.l0.a.u.e.p.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.logToFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1751900130");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.d)) {
                        dVar = (d.a.l0.a.u.e.p.d) obj;
                    } else {
                        dVar = new d.a.l0.a.u.e.p.d(this.mSwanApiContext);
                        this.mApis.put("1751900130", dVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(dVar, "swanAPI/logToFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b s = dVar.s(str);
                    String b2 = s == null ? "" : s.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.logToFile[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.logToFile[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new i(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String previewImage(String str) {
                d.a.l0.a.u.e.p.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.e)) {
                        eVar = (d.a.l0.a.u.e.p.e) obj;
                    } else {
                        eVar = new d.a.l0.a.u.e.p.e(this.mSwanApiContext);
                        this.mApis.put("589529211", eVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(eVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b v = eVar.v(str);
                    String b2 = v == null ? "" : v.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.previewImage[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new j(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String ubcFlowJar(String str) {
                d.a.l0.a.u.e.p.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.a.l0.a.u.e.p.h)) {
                        hVar = (d.a.l0.a.u.e.p.h) obj;
                    } else {
                        hVar = new d.a.l0.a.u.e.p.h(this.mSwanApiContext);
                        this.mApis.put("-577481801", hVar);
                    }
                    Pair<Boolean, d.a.l0.a.u.h.a> a2 = d.a.l0.a.u.i.a.a(hVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.l0.a.u.h.a) a2.second).b();
                    }
                    if (d.a.l0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                        return new d.a.l0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").b();
                    }
                    d.a.l0.a.u.h.b B = hVar.B(str);
                    String b2 = B == null ? "" : B.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        return hashMap;
    }
}
