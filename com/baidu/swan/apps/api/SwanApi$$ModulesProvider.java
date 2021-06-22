package com.baidu.swan.apps.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.a.m0.a.h0.l.g.f;
import d.a.m0.a.j2.o;
import d.a.m0.a.u.c.b;
import d.a.m0.a.u.c.d;
import d.a.m0.a.u.e.j.g;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10544e;

                public a(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10544e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10544e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10545e;

                public b(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10545e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10545e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10546e;

                public c(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10546e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10546e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10547e;

                public d(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10547e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10547e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10548e;

                public e(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10548e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10548e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10549e;

                public f(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10549e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10549e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10550e;

                public g(SwanApi$$AccountV8Module swanApi$$AccountV8Module, Throwable th) {
                    this.f10550e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10550e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.a.m0.a.u.e.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.b)) {
                        bVar2 = (d.a.m0.a.u.e.a.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.a.b(this.mSwanApiContext);
                        this.mApis.put("1930258908", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
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
            public String getLoginCode(String str) {
                d.a.m0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getLoginCode[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.c)) {
                        cVar = (d.a.m0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/getLoginCode");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getLoginCode[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getOpenId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1754780133");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.d)) {
                        dVar = (d.a.m0.a.u.e.a.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.a.d(this.mSwanApiContext);
                        this.mApis.put("1754780133", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/getOpenId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = dVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getOpenId[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.s.a.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getUnionBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-343998465");
                    if (obj != null && (obj instanceof d.a.m0.a.s.a.j.a)) {
                        aVar = (d.a.m0.a.s.a.j.a) obj;
                    } else {
                        aVar = new d.a.m0.a.s.a.j.a(this.mSwanApiContext);
                        this.mApis.put("-343998465", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getUnionBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getUnionBDUSS[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isBaiduAccountSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-337742792");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.a)) {
                        aVar = (d.a.m0.a.u.e.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.a.a(this.mSwanApiContext);
                        this.mApis.put("-337742792", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/isBaiduAccountSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isBaiduAccountSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.c)) {
                        cVar = (d.a.m0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = cVar.z();
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.c)) {
                        cVar = (d.a.m0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.login")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = cVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10558e;

                public a(SwanApi$$BasicV8Module swanApi$$BasicV8Module, Throwable th) {
                    this.f10558e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10558e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10559e;

                public b(SwanApi$$BasicV8Module swanApi$$BasicV8Module, Throwable th) {
                    this.f10559e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10559e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.a.m0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.b.a)) {
                        aVar = (d.a.m0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
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

            @JavascriptInterface
            public String loadSubPackages(String str) {
                d.a.m0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackages[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.b.a)) {
                        aVar = (d.a.m0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/loadSubPackages");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = aVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackages[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10562e;

                public a(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10562e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10562e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10563e;

                public b(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10563e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10563e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10564e;

                public c(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10564e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10564e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10565e;

                public d(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10565e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10565e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10566e;

                public e(SwanApi$$BookshelfV8Module swanApi$$BookshelfV8Module, Throwable th) {
                    this.f10566e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10566e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.deleteBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/deleteBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = aVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.deleteBookshelf[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b J = aVar.J(str);
                    String a3 = J == null ? "" : J.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b O = aVar.O(str);
                    String a3 = O == null ? "" : O.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b P = aVar.P(str);
                    String a3 = P == null ? "" : P.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b R = aVar.R(str);
                    String a3 = R == null ? "" : R.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10572e;

                public a(SwanApi$$CalendarV8Module swanApi$$CalendarV8Module, Throwable th) {
                    this.f10572e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10572e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10573e;

                public b(SwanApi$$CalendarV8Module swanApi$$CalendarV8Module, Throwable th) {
                    this.f10573e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10573e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addEventOnCalendar(String str) {
                d.a.m0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.addEventOnCalendar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.c.a)) {
                        aVar = (d.a.m0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/addEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.addEventOnCalendar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.addEventOnCalendar[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.deleteEventOnCalendar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.c.a)) {
                        aVar = (d.a.m0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/deleteEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.deleteEventOnCalendar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = aVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.deleteEventOnCalendar[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10576e;

                public a(SwanApi$$CouponV8Module swanApi$$CouponV8Module, Throwable th) {
                    this.f10576e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10576e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10577e;

                public b(SwanApi$$CouponV8Module swanApi$$CouponV8Module, Throwable th) {
                    this.f10577e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10577e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10578e;

                public c(SwanApi$$CouponV8Module swanApi$$CouponV8Module, Throwable th) {
                    this.f10578e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10578e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                d.a.m0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getPlatformCoupons[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.m0.a.u.d.a)) {
                        aVar = (d.a.m0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/coupon/getPlatformCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getPlatformCoupons[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getUserCoupons[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.m0.a.u.d.a)) {
                        aVar = (d.a.m0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/coupon/getUserCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getUserCoupons[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.takeCoupons[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.m0.a.u.d.a)) {
                        aVar = (d.a.m0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/coupon/takeCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = aVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.takeCoupons[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10582e;

                public a(SwanApi$$FavoriteV8Module swanApi$$FavoriteV8Module, Throwable th) {
                    this.f10582e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10582e;
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = showFavoriteGuideApi.A(str);
                    String a3 = A == null ? "" : A.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10584e;

                public a(SwanApi$$FileV8Module swanApi$$FileV8Module, Throwable th) {
                    this.f10584e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10584e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.a.m0.a.u.e.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.e.a)) {
                        aVar = (d.a.m0.a.u.e.e.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.e.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "File.shareFile")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10586e;

                public a(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f10586e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10586e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10587e;

                public b(SwanApi$$GameCenterV8Module swanApi$$GameCenterV8Module, Throwable th) {
                    this.f10587e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10587e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.a.m0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.m0.a.u0.a)) {
                        aVar = (d.a.m0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
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
                d.a.m0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.m0.a.u0.a)) {
                        aVar = (d.a.m0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10590e;

                public a(SwanApi$$ImageV8Module swanApi$$ImageV8Module, Throwable th) {
                    this.f10590e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10590e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10591e;

                public b(SwanApi$$ImageV8Module swanApi$$ImageV8Module, Throwable th) {
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
            public String callImageMenu(String str) {
                d.a.m0.a.j1.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.callImageMenu[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1445003743");
                    if (obj != null && (obj instanceof d.a.m0.a.j1.b)) {
                        bVar2 = (d.a.m0.a.j1.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.j1.b(this.mSwanApiContext);
                        this.mApis.put("1445003743", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/callImageMenu");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.callImageMenu[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.f.a)) {
                        aVar = (d.a.m0.a.u.e.f.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.f.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10594e;

                public a(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public b(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public c(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public d(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public e(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public f(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public g(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public h(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public i(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public j(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public k(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public l(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
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

                public m(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10606e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10606e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10607e;

                public n(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10607e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10607e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10608e;

                public o(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10608e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10608e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10609e;

                public p(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10609e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10609e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10610e;

                public q(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10610e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10610e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10611e;

                public r(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10611e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10611e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10612e;

                public s(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10612e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10612e;
                }
            }

            /* loaded from: classes2.dex */
            public class t implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10613e;

                public t(SwanApi$$InteractionV8Module swanApi$$InteractionV8Module, Throwable th) {
                    this.f10613e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10613e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = gVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
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
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = gVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.a)) {
                        aVar = (d.a.m0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = aVar.s();
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = cVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.h)) {
                        hVar = (d.a.m0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = hVar.E();
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = eVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b B = eVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = gVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.d)) {
                        dVar = (d.a.m0.a.u.e.g.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.g.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t2 = dVar.t(str);
                    String a3 = t2 == null ? "" : t2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t2 = cVar.t(str);
                    String a3 = t2 == null ? "" : t2.a();
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
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
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = gVar.x(str);
                    String a3 = x == null ? "" : x.a();
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b F = eVar.F(str);
                    String a3 = F == null ? "" : F.a();
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
            public String showHalfScreenWebview(String str) {
                d.a.m0.a.u.e.g.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showHalfScreenWebview[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1172469410");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.i)) {
                        iVar = (d.a.m0.a.u.e.g.i) obj;
                    } else {
                        iVar = new d.a.m0.a.u.e.g.i(this.mSwanApiContext);
                        this.mApis.put("1172469410", iVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(iVar, "swanAPI/showHalfScreenWebview");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = iVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showHalfScreenWebview[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.a)) {
                        aVar = (d.a.m0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t2 = aVar.t(str);
                    String a3 = t2 == null ? "" : t2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.b)) {
                        bVar2 = (d.a.m0.a.u.e.g.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.g.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = bVar2.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = cVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.h)) {
                        hVar = (d.a.m0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b K = hVar.K(str);
                    String a3 = K == null ? "" : K.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.f)) {
                        fVar = (d.a.m0.a.u.e.g.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.g.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = fVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b G = eVar.G(str);
                    String a3 = G == null ? "" : G.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10634e;

                public a(SwanApi$$KeyboardV8Module swanApi$$KeyboardV8Module, Throwable th) {
                    this.f10634e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10634e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10635e;

                public b(SwanApi$$KeyboardV8Module swanApi$$KeyboardV8Module, Throwable th) {
                    this.f10635e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10635e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                d.a.m0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.startKeyboardHeightChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.h.a)) {
                        aVar = (d.a.m0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/startKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = aVar.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.startKeyboardHeightChange[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.stopKeyboardHeightChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.h.a)) {
                        aVar = (d.a.m0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/stopKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = aVar.x();
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.stopKeyboardHeightChange[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10638e;

                public a(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f10638e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10638e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10639e;

                public b(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f10639e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10639e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10640e;

                public c(SwanApi$$LocationServiceV8Module swanApi$$LocationServiceV8Module, Throwable th) {
                    this.f10640e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10640e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.a.m0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.i.a)) {
                        aVar = (d.a.m0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.i.a)) {
                        aVar = (d.a.m0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
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
                d.a.m0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.i.a)) {
                        aVar = (d.a.m0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = aVar.v();
                    String a3 = v == null ? "" : v.a();
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10644e;

                public a(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10644e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10644e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10645e;

                public b(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10645e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10645e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10646e;

                public c(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10646e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10646e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10647e;

                public d(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10647e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10647e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10648e;

                public e(SwanApi$$NetworkV8Module swanApi$$NetworkV8Module, Throwable th) {
                    this.f10648e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10648e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String callService(String str) {
                d.a.m0.a.u.e.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.callService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1076509454");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.j.a)) {
                        aVar = (d.a.m0.a.u.e.j.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.j.a(this.mSwanApiContext);
                        this.mApis.put("-1076509454", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/callService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.callService")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.callService[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = gVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.j.f)) {
                        fVar = (d.a.m0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = fVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.j.f)) {
                        fVar = (d.a.m0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = fVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                String a2;
                try {
                    d.a.m0.a.u.g.c.c().a("request");
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a3 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/request");
                    if (((Boolean) a3.first).booleanValue()) {
                        a2 = ((d.a.m0.a.u.h.a) a3.second).a();
                    } else if (f.a(this.mSwanApiContext.g(), "Network.request")) {
                        a2 = new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<d.a.m0.a.u.h.a, JSONObject> n = d.a.m0.a.u.c.d.n(jsObject);
                        if (!((d.a.m0.a.u.h.a) n.first).isSuccess()) {
                            a2 = ((d.a.m0.a.u.h.a) n.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) n.second;
                            if (jSONObject == null) {
                                a2 = d.a.m0.a.u.h.a.f49019a.a();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.a.m0.a.u.h.b N = gVar.N(jSONObject);
                                a2 = N == null ? "" : N.a();
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
                            new Handler(Looper.getMainLooper()).post(new e(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.a.m0.a.u.g.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10654e;

                public a(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f10654e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10654e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10655e;

                public b(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f10655e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10655e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10656e;

                public c(SwanApi$$PluginV8Module swanApi$$PluginV8Module, Throwable th) {
                    this.f10656e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10656e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.a.m0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.m0.a.t1.c.a.a)) {
                        aVar = (d.a.m0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.m0.a.t1.c.a.a)) {
                        aVar = (d.a.m0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
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
                d.a.m0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.m0.a.t1.c.a.a)) {
                        aVar = (d.a.m0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
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
        hashMap.put("_naPrefetch", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10660e;

                public a(SwanApi$$PrefetchV8Module swanApi$$PrefetchV8Module, Throwable th) {
                    this.f10660e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10660e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                d.a.m0.a.h0.o.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Prefetch.prefetchResources[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2068479848");
                    if (obj != null && (obj instanceof d.a.m0.a.h0.o.f.a)) {
                        aVar = (d.a.m0.a.h0.o.f.a) obj;
                    } else {
                        aVar = new d.a.m0.a.h0.o.f.a(this.mSwanApiContext);
                        this.mApis.put("-2068479848", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/prefetchResources");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Prefetch.prefetchResources[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10662e;

                public a(SwanApi$$PreloadV8Module swanApi$$PreloadV8Module, Throwable th) {
                    this.f10662e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10662e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                d.a.m0.a.h0.l.g.o.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Preload.preloadStatus[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("423661539");
                    if (obj != null && (obj instanceof d.a.m0.a.h0.l.g.o.d.a)) {
                        aVar = (d.a.m0.a.h0.l.g.o.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.h0.l.g.o.d.a(this.mSwanApiContext);
                        this.mApis.put("423661539", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/preloadStatus");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Preload.preloadStatus[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10672e;

                public a(SwanApi$$PrivateFileV8Module swanApi$$PrivateFileV8Module, Throwable th) {
                    this.f10672e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10672e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                d.a.m0.a.u2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateFile.uploadFileToBos[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1929343869");
                    if (obj != null && (obj instanceof d.a.m0.a.u2.b)) {
                        bVar2 = (d.a.m0.a.u2.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u2.b(this.mSwanApiContext);
                        this.mApis.put("-1929343869", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/uploadFileToBos");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = bVar2.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateFile.uploadFileToBos[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10676e;

                public a(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10676e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10676e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10677e;

                public b(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10677e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10677e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10678e;

                public c(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10678e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10678e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10679e;

                public d(SwanApi$$RouterV8Module swanApi$$RouterV8Module, Throwable th) {
                    this.f10679e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10679e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.a.m0.a.u.e.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.a)) {
                        aVar = (d.a.m0.a.u.e.k.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.k.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.a.u.e.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.b)) {
                        bVar2 = (d.a.m0.a.u.e.k.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.k.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = bVar2.v(str);
                    String a3 = v == null ? "" : v.a();
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
                d.a.m0.a.u.e.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.d)) {
                        dVar = (d.a.m0.a.u.e.k.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.k.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = dVar.v(str);
                    String a3 = v == null ? "" : v.a();
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
                d.a.m0.a.u.e.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.c)) {
                        cVar = (d.a.m0.a.u.e.k.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.k.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = cVar.w(str);
                    String a3 = w == null ? "" : w.a();
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10684e;

                public a(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10684e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10684e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10685e;

                public b(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10685e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10685e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10686e;

                public c(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10686e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10686e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10687e;

                public d(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10687e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10687e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10688e;

                public e(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10688e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10688e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10689e;

                public f(SwanApi$$SettingV8Module swanApi$$SettingV8Module, Throwable th) {
                    this.f10689e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10689e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = bVar2.z();
                    String a3 = z == null ? "" : z.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = bVar2.A(str);
                    String a3 = A == null ? "" : A.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b B = bVar2.B();
                    String a3 = B == null ? "" : B.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b C = bVar2.C(str);
                    String a3 = C == null ? "" : C.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b D = bVar2.D(str);
                    String a3 = D == null ? "" : D.a();
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

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                d.a.m0.a.u.e.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.isAllowedAdOpenAppSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("450273045");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.a)) {
                        aVar = (d.a.m0.a.u.e.l.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.l.a(this.mSwanApiContext);
                        this.mApis.put("450273045", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/isAllowedAdOpenAppSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.isAllowedAdOpenAppSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10696e;

                public a(SwanApi$$StatisticEventV8Module swanApi$$StatisticEventV8Module, Throwable th) {
                    this.f10696e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10696e;
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(oVar, "swanAPI/ubcAndCeresStatisticEvent");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = oVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[StatisticEvent.ubcAndCeresStatisticEvent[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10698e;

                public a(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10698e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10698e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10699e;

                public b(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10699e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10699e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10700e;

                public c(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10700e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10700e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10701e;

                public d(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10701e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10701e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10702e;

                public e(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10702e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10702e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10703e;

                public f(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10703e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10703e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10704e;

                public g(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10704e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10704e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10705e;

                public h(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10705e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10705e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10706e;

                public i(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10706e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10706e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10707e;

                public j(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10707e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10707e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10708e;

                public k(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10708e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10708e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10709e;

                public l(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10709e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10709e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10710e;

                public m(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10710e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10710e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10711e;

                public n(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10711e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10711e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10712e;

                public o(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10712e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10712e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10713e;

                public p(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10713e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10713e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10714e;

                public q(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10714e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10714e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10715e;

                public r(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10715e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10715e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10716e;

                public s(SwanApi$$StorageV8Module swanApi$$StorageV8Module, Throwable th) {
                    this.f10716e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10716e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = bVar2.r();
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = bVar2.s();
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = aVar.r();
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = aVar.s();
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = bVar2.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = bVar2.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b K = bVar2.K();
                    String a3 = K == null ? "" : K.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfoSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = bVar2.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = aVar.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = aVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b D = bVar2.D(str);
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = bVar2.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b D = aVar.D(str);
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = aVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b F = bVar2.F(str);
                    String a3 = F == null ? "" : F.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b G = bVar2.G(str);
                    String a3 = G == null ? "" : G.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b F = aVar.F(str);
                    String a3 = F == null ? "" : F.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b G = aVar.G(str);
                    String a3 = G == null ? "" : G.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10736e;

                public a(SwanApi$$SubscriptionV8Module swanApi$$SubscriptionV8Module, Throwable th) {
                    this.f10736e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10736e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.a.m0.a.u.e.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.n.a)) {
                        aVar = (d.a.m0.a.u.e.n.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.n.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10738e;

                public a(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10738e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10738e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10739e;

                public b(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10739e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10739e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10740e;

                public c(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10740e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10740e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10741e;

                public d(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10741e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10741e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10742e;

                public e(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10742e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10742e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10743e;

                public f(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10743e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10743e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10744e;

                public g(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10744e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10744e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10745e;

                public h(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10745e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10745e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10746e;

                public i(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10746e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10746e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10747e;

                public j(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10747e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10747e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10748e;

                public k(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10748e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10748e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10749e;

                public l(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10749e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10749e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10750e;

                public m(SwanApi$$SystemV8Module swanApi$$SystemV8Module, Throwable th) {
                    this.f10750e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10750e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkPhoneContactsAuthorization(String str) {
                d.a.m0.a.u.e.o.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.checkPhoneContactsAuthorization[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1112806039");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.h)) {
                        hVar = (d.a.m0.a.u.e.o.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.o.h(this.mSwanApiContext);
                        this.mApis.put("-1112806039", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPIcheckPhoneContactsAuthorization");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.checkPhoneContactsAuthorization")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = hVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.checkPhoneContactsAuthorization[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.f)) {
                        fVar = (d.a.m0.a.u.e.o.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.o.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = fVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.b)) {
                        bVar2 = (d.a.m0.a.u.e.o.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.o.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.c)) {
                        cVar = (d.a.m0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = cVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.e)) {
                        eVar = (d.a.m0.a.u.e.o.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.o.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = eVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.g)) {
                        gVar = (d.a.m0.a.u.e.o.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.o.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = gVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.j jVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.j)) {
                        jVar = (d.a.m0.a.u.e.o.j) obj;
                    } else {
                        jVar = new d.a.m0.a.u.e.o.j(this.mSwanApiContext);
                        this.mApis.put("1099851202", jVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(jVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = jVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.i)) {
                        iVar = (d.a.m0.a.u.e.o.i) obj;
                    } else {
                        iVar = new d.a.m0.a.u.e.o.i(this.mSwanApiContext);
                        this.mApis.put("-1707203360", iVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(iVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = iVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.c)) {
                        cVar = (d.a.m0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = cVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.a)) {
                        aVar = (d.a.m0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.d)) {
                        dVar = (d.a.m0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startCompass")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = dVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.a)) {
                        aVar = (d.a.m0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t();
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.d)) {
                        dVar = (d.a.m0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = dVar.t();
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10764e;

                public a(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10764e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10764e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10765e;

                public b(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10765e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10765e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10766e;

                public c(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10766e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10766e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10767e;

                public d(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10767e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10767e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10768e;

                public e(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10768e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10768e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10769e;

                public f(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10769e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10769e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10770e;

                public g(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10770e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10770e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10771e;

                public h(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10771e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10771e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10772e;

                public i(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10772e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10772e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10773e;

                public j(SwanApi$$UtilsV8Module swanApi$$UtilsV8Module, Throwable th) {
                    this.f10773e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10773e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                d.a.m0.a.u.e.p.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.addToDesktop[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("201194468");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.b)) {
                        bVar2 = (d.a.m0.a.u.e.p.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.p.b(this.mSwanApiContext);
                        this.mApis.put("201194468", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/addToDesktop");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = bVar2.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.addToDesktop[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.a)) {
                        aVar = (d.a.m0.a.u.e.p.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.p.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.f)) {
                        fVar = (d.a.m0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = fVar.v();
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.f)) {
                        fVar = (d.a.m0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b y = fVar.y();
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.f)) {
                        fVar = (d.a.m0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = fVar.z();
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.c)) {
                        cVar = (d.a.m0.a.u.e.p.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.p.c(this.mSwanApiContext);
                        this.mApis.put("-2097727681", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = cVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.d2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.hideCaptureScreenShareDialog[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1031678042");
                    if (obj != null && (obj instanceof d.a.m0.a.d2.b)) {
                        bVar2 = (d.a.m0.a.d2.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.d2.b(this.mSwanApiContext);
                        this.mApis.put("1031678042", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/hideCaptureScreenShareDialog");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.hideCaptureScreenShareDialog[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.logToFile[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1751900130");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.d)) {
                        dVar = (d.a.m0.a.u.e.p.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.p.d(this.mSwanApiContext);
                        this.mApis.put("1751900130", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/logToFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = dVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.logToFile[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.e)) {
                        eVar = (d.a.m0.a.u.e.p.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.p.e(this.mSwanApiContext);
                        this.mApis.put("589529211", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = eVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.h)) {
                        hVar = (d.a.m0.a.u.e.p.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.p.h(this.mSwanApiContext);
                        this.mApis.put("-577481801", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b B = hVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10551e;

                public a(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10551e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10551e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10552e;

                public b(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10552e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10552e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10553e;

                public c(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10553e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10553e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10554e;

                public d(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10554e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10554e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10555e;

                public e(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10555e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10555e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10556e;

                public f(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10556e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10556e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10557e;

                public g(SwanApi$$AccountWebviewModule swanApi$$AccountWebviewModule, Throwable th) {
                    this.f10557e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10557e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkSession(String str) {
                d.a.m0.a.u.e.a.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.checkSession[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1930258908");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.b)) {
                        bVar2 = (d.a.m0.a.u.e.a.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.a.b(this.mSwanApiContext);
                        this.mApis.put("1930258908", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/checkSession");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
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
            public String getLoginCode(String str) {
                d.a.m0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getLoginCode[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.c)) {
                        cVar = (d.a.m0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/getLoginCode");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getLoginCode[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getOpenId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1754780133");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.d)) {
                        dVar = (d.a.m0.a.u.e.a.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.a.d(this.mSwanApiContext);
                        this.mApis.put("1754780133", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/getOpenId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = dVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getOpenId[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.s.a.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.getUnionBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-343998465");
                    if (obj != null && (obj instanceof d.a.m0.a.s.a.j.a)) {
                        aVar = (d.a.m0.a.s.a.j.a) obj;
                    } else {
                        aVar = new d.a.m0.a.s.a.j.a(this.mSwanApiContext);
                        this.mApis.put("-343998465", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getUnionBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.getUnionBDUSS[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isBaiduAccountSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-337742792");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.a)) {
                        aVar = (d.a.m0.a.u.e.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.a.a(this.mSwanApiContext);
                        this.mApis.put("-337742792", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/isBaiduAccountSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isBaiduAccountSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.isLoginSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.c)) {
                        cVar = (d.a.m0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/isLoginSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = cVar.z();
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.isLoginSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.a.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Account.login[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1017914143");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.a.c)) {
                        cVar = (d.a.m0.a.u.e.a.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.a.c(this.mSwanApiContext);
                        this.mApis.put("-1017914143", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/login");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Account.login")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = cVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Account.login[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10560e;

                public a(SwanApi$$BasicWebviewModule swanApi$$BasicWebviewModule, Throwable th) {
                    this.f10560e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10560e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10561e;

                public b(SwanApi$$BasicWebviewModule swanApi$$BasicWebviewModule, Throwable th) {
                    this.f10561e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10561e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String loadSubPackage(String str) {
                d.a.m0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.b.a)) {
                        aVar = (d.a.m0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/loadSubPackage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
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

            @JavascriptInterface
            public String loadSubPackages(String str) {
                d.a.m0.a.u.e.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Basic.loadSubPackages[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1249666566");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.b.a)) {
                        aVar = (d.a.m0.a.u.e.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.b.a(this.mSwanApiContext);
                        this.mApis.put("-1249666566", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/loadSubPackages");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = aVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Basic.loadSubPackages[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10567e;

                public a(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10567e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10567e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10568e;

                public b(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10568e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10568e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10569e;

                public c(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10569e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10569e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10570e;

                public d(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10570e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10570e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10571e;

                public e(SwanApi$$BookshelfWebviewModule swanApi$$BookshelfWebviewModule, Throwable th) {
                    this.f10571e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10571e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String deleteBookshelf(String str) {
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.deleteBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/deleteBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = aVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.deleteBookshelf[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.insertBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b J = aVar.J(str);
                    String a3 = J == null ? "" : J.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.insertBookshelf[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b O = aVar.O(str);
                    String a3 = O == null ? "" : O.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.navigateToBookshelf[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.queryBookshelf[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b P = aVar.P(str);
                    String a3 = P == null ? "" : P.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.queryBookshelf[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.n.b.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1460300387");
                    if (obj != null && (obj instanceof d.a.m0.a.n.b.a)) {
                        aVar = (d.a.m0.a.n.b.a) obj;
                    } else {
                        aVar = new d.a.m0.a.n.b.a(this.mSwanApiContext);
                        this.mApis.put("1460300387", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b R = aVar.R(str);
                    String a3 = R == null ? "" : R.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Bookshelf.updateBookshelfReadTime[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10574e;

                public a(SwanApi$$CalendarWebviewModule swanApi$$CalendarWebviewModule, Throwable th) {
                    this.f10574e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10574e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10575e;

                public b(SwanApi$$CalendarWebviewModule swanApi$$CalendarWebviewModule, Throwable th) {
                    this.f10575e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10575e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addEventOnCalendar(String str) {
                d.a.m0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.addEventOnCalendar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.c.a)) {
                        aVar = (d.a.m0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/addEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.addEventOnCalendar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.addEventOnCalendar[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Calendar.deleteEventOnCalendar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("6984667");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.c.a)) {
                        aVar = (d.a.m0.a.u.e.c.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.c.a(this.mSwanApiContext);
                        this.mApis.put("6984667", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/deleteEventOnCalendar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Calendar.deleteEventOnCalendar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = aVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Calendar.deleteEventOnCalendar[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10579e;

                public a(SwanApi$$CouponWebviewModule swanApi$$CouponWebviewModule, Throwable th) {
                    this.f10579e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10579e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10580e;

                public b(SwanApi$$CouponWebviewModule swanApi$$CouponWebviewModule, Throwable th) {
                    this.f10580e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10580e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10581e;

                public c(SwanApi$$CouponWebviewModule swanApi$$CouponWebviewModule, Throwable th) {
                    this.f10581e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10581e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getPlatformCoupons(String str) {
                d.a.m0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getPlatformCoupons[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.m0.a.u.d.a)) {
                        aVar = (d.a.m0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/coupon/getPlatformCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getPlatformCoupons[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.getUserCoupons[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.m0.a.u.d.a)) {
                        aVar = (d.a.m0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/coupon/getUserCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.getUserCoupons[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Coupon.takeCoupons[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-277316359");
                    if (obj != null && (obj instanceof d.a.m0.a.u.d.a)) {
                        aVar = (d.a.m0.a.u.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.d.a(this.mSwanApiContext);
                        this.mApis.put("-277316359", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/coupon/takeCoupons");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = aVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Coupon.takeCoupons[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10583e;

                public a(SwanApi$$FavoriteWebviewModule swanApi$$FavoriteWebviewModule, Throwable th) {
                    this.f10583e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10583e;
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = showFavoriteGuideApi.A(str);
                    String a3 = A == null ? "" : A.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10585e;

                public a(SwanApi$$FileWebviewModule swanApi$$FileWebviewModule, Throwable th) {
                    this.f10585e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10585e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String shareFile(String str) {
                d.a.m0.a.u.e.e.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================File.shareFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2057135077");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.e.a)) {
                        aVar = (d.a.m0.a.u.e.e.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.e.a(this.mSwanApiContext);
                        this.mApis.put("-2057135077", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/shareFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "File.shareFile")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10588e;

                public a(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f10588e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10588e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10589e;

                public b(SwanApi$$GameCenterWebviewModule swanApi$$GameCenterWebviewModule, Throwable th) {
                    this.f10589e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10589e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String postGameCenterMessage(String str) {
                d.a.m0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.m0.a.u0.a)) {
                        aVar = (d.a.m0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
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
                d.a.m0.a.u0.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================GameCenter.postGameCenterMessageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("2077414795");
                    if (obj != null && (obj instanceof d.a.m0.a.u0.a)) {
                        aVar = (d.a.m0.a.u0.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u0.a(this.mSwanApiContext);
                        this.mApis.put("2077414795", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10592e;

                public a(SwanApi$$ImageWebviewModule swanApi$$ImageWebviewModule, Throwable th) {
                    this.f10592e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10592e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10593e;

                public b(SwanApi$$ImageWebviewModule swanApi$$ImageWebviewModule, Throwable th) {
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
            public String callImageMenu(String str) {
                d.a.m0.a.j1.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.callImageMenu[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1445003743");
                    if (obj != null && (obj instanceof d.a.m0.a.j1.b)) {
                        bVar2 = (d.a.m0.a.j1.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.j1.b(this.mSwanApiContext);
                        this.mApis.put("1445003743", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/callImageMenu");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.callImageMenu[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Image.compressImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1252730367");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.f.a)) {
                        aVar = (d.a.m0.a.u.e.f.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.f.a(this.mSwanApiContext);
                        this.mApis.put("-1252730367", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/compressImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Image.compressImage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10614e;

                public a(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10614e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10614e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10615e;

                public b(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10615e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10615e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10616e;

                public c(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10616e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10616e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10617e;

                public d(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10617e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10617e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10618e;

                public e(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10618e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10618e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10619e;

                public f(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10619e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10619e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10620e;

                public g(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10620e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10620e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10621e;

                public h(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10621e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10621e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10622e;

                public i(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10622e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10622e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10623e;

                public j(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10623e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10623e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10624e;

                public k(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10624e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10624e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10625e;

                public l(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10625e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10625e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10626e;

                public m(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10626e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10626e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10627e;

                public n(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10627e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10627e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10628e;

                public o(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10628e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10628e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10629e;

                public p(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10629e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10629e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10630e;

                public q(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10630e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10630e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10631e;

                public r(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10631e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10631e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10632e;

                public s(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10632e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10632e;
                }
            }

            /* loaded from: classes2.dex */
            public class t implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10633e;

                public t(SwanApi$$InteractionWebviewModule swanApi$$InteractionWebviewModule, Throwable th) {
                    this.f10633e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10633e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String closeTabBar(String str) {
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/closeTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = gVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
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
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.closeTabBarRedDot[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/closeTabBarRedDot");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = gVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.closeTabBarRedDot[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.a)) {
                        aVar = (d.a.m0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/hideLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = aVar.s();
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/hideNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = cVar.s(str);
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideNavigationBarLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.hideToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.h)) {
                        hVar = (d.a.m0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPI/hideToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = hVar.E();
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.hideToast[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/openMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = eVar.A(str);
                    String a3 = A == null ? "" : A.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openMultiPicker[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/openPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b B = eVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openPicker[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.openTabBar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/openTabBar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = gVar.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.openTabBar[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.pageScrollTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1750613704");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.d)) {
                        dVar = (d.a.m0.a.u.e.g.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.g.d(this.mSwanApiContext);
                        this.mApis.put("-1750613704", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/pageScrollTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t2 = dVar.t(str);
                    String a3 = t2 == null ? "" : t2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.pageScrollTo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarColor[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarColor");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t2 = cVar.t(str);
                    String a3 = t2 == null ? "" : t2.a();
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setNavigationBarTitle[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/setNavigationBarTitle");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = cVar.u(str);
                    String a3 = u == null ? "" : u.a();
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
                d.a.m0.a.u.e.g.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.setTabBarItem[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1871435471");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.g)) {
                        gVar = (d.a.m0.a.u.e.g.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.g.g(this.mSwanApiContext);
                        this.mApis.put("-1871435471", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/setTabBarItem");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = gVar.x(str);
                    String a3 = x == null ? "" : x.a();
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showDatePickerView[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/showDatePickerView");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b F = eVar.F(str);
                    String a3 = F == null ? "" : F.a();
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
            public String showHalfScreenWebview(String str) {
                d.a.m0.a.u.e.g.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showHalfScreenWebview[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1172469410");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.i)) {
                        iVar = (d.a.m0.a.u.e.g.i) obj;
                    } else {
                        iVar = new d.a.m0.a.u.e.g.i(this.mSwanApiContext);
                        this.mApis.put("1172469410", iVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(iVar, "swanAPI/showHalfScreenWebview");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = iVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showHalfScreenWebview[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("5236036");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.a)) {
                        aVar = (d.a.m0.a.u.e.g.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.g.a(this.mSwanApiContext);
                        this.mApis.put("5236036", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/showLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t2 = aVar.t(str);
                    String a3 = t2 == null ? "" : t2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showModal[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1913747800");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.b)) {
                        bVar2 = (d.a.m0.a.u.e.g.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.g.b(this.mSwanApiContext);
                        this.mApis.put("1913747800", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/showModal");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = bVar2.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showModal[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showNavigationBarLoading[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-246386074");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.c)) {
                        cVar = (d.a.m0.a.u.e.g.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.g.c(this.mSwanApiContext);
                        this.mApis.put("-246386074", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/showNavigationBarLoading");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = cVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showNavigationBarLoading[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.showToast[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1159492510");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.h)) {
                        hVar = (d.a.m0.a.u.e.g.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.g.h(this.mSwanApiContext);
                        this.mApis.put("1159492510", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPI/showToast");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b K = hVar.K(str);
                    String a3 = K == null ? "" : K.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.showToast[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.stopPullDownRefresh[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1165118609");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.f)) {
                        fVar = (d.a.m0.a.u.e.g.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.g.f(this.mSwanApiContext);
                        this.mApis.put("1165118609", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/stopPullDownRefresh");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = fVar.r(str);
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.stopPullDownRefresh[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.g.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Interaction.updateMultiPicker[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-108978463");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.g.e)) {
                        eVar = (d.a.m0.a.u.e.g.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.g.e(this.mSwanApiContext);
                        this.mApis.put("-108978463", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/updateMultiPicker");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b G = eVar.G(str);
                    String a3 = G == null ? "" : G.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Interaction.updateMultiPicker[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10636e;

                public a(SwanApi$$KeyboardWebviewModule swanApi$$KeyboardWebviewModule, Throwable th) {
                    this.f10636e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10636e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10637e;

                public b(SwanApi$$KeyboardWebviewModule swanApi$$KeyboardWebviewModule, Throwable th) {
                    this.f10637e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10637e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String startKeyboardHeightChange() {
                d.a.m0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.startKeyboardHeightChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.h.a)) {
                        aVar = (d.a.m0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/startKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = aVar.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.startKeyboardHeightChange[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.h.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Keyboard.stopKeyboardHeightChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-137346255");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.h.a)) {
                        aVar = (d.a.m0.a.u.e.h.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.h.a(this.mSwanApiContext);
                        this.mApis.put("-137346255", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/stopKeyboardHeightChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = aVar.x();
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Keyboard.stopKeyboardHeightChange[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10641e;

                public a(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f10641e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10641e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10642e;

                public b(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f10642e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10642e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10643e;

                public c(SwanApi$$LocationServiceWebviewModule swanApi$$LocationServiceWebviewModule, Throwable th) {
                    this.f10643e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10643e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getLocation(String str) {
                d.a.m0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.getLocation[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.i.a)) {
                        aVar = (d.a.m0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getLocation");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.startLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.i.a)) {
                        aVar = (d.a.m0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/startLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
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
                d.a.m0.a.u.e.i.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================LocationService.stopLocationUpdate[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-397373095");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.i.a)) {
                        aVar = (d.a.m0.a.u.e.i.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.i.a(this.mSwanApiContext);
                        this.mApis.put("-397373095", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/stopLocationUpdate");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = aVar.v();
                    String a3 = v == null ? "" : v.a();
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10649e;

                public a(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10649e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10649e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10650e;

                public b(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10650e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10650e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10651e;

                public c(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10651e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10651e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10652e;

                public d(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10652e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10652e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10653e;

                public e(SwanApi$$NetworkWebviewModule swanApi$$NetworkWebviewModule, Throwable th) {
                    this.f10653e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10653e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String callService(String str) {
                d.a.m0.a.u.e.j.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.callService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1076509454");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.j.a)) {
                        aVar = (d.a.m0.a.u.e.j.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.j.a(this.mSwanApiContext);
                        this.mApis.put("-1076509454", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/callService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.callService")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.callService[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/cancelRequest");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = gVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.cancelRequest[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.getNetworkType[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.j.f)) {
                        fVar = (d.a.m0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getNetworkType");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = fVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.getNetworkType[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.j.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Network.networkStatusChange[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("453220699");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.j.f)) {
                        fVar = (d.a.m0.a.u.e.j.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.j.f(this.mSwanApiContext);
                        this.mApis.put("453220699", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/networkStatusChange");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = fVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Network.networkStatusChange[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                String a2;
                try {
                    d.a.m0.a.u.g.c.c().a("request");
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a3 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/request");
                    if (((Boolean) a3.first).booleanValue()) {
                        a2 = ((d.a.m0.a.u.h.a) a3.second).a();
                    } else if (f.a(this.mSwanApiContext.g(), "Network.request")) {
                        a2 = new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    } else {
                        Pair<d.a.m0.a.u.h.a, JSONObject> o = d.a.m0.a.u.c.d.o(str);
                        if (!((d.a.m0.a.u.h.a) o.first).isSuccess()) {
                            a2 = ((d.a.m0.a.u.h.a) o.first).a();
                        } else {
                            JSONObject jSONObject = (JSONObject) o.second;
                            if (jSONObject == null) {
                                a2 = d.a.m0.a.u.h.a.f49019a.a();
                            } else {
                                if (DEBUG) {
                                    Log.d("Api-Base", "JsObject->JSONObject: " + jSONObject.toString());
                                }
                                d.a.m0.a.u.h.b N = gVar.N(jSONObject);
                                a2 = N == null ? "" : N.a();
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
                            new Handler(Looper.getMainLooper()).post(new e(this, th));
                            return "";
                        }
                        throw th;
                    } finally {
                        d.a.m0.a.u.g.c.c().b("request");
                    }
                }
            }
        });
        hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10657e;

                public a(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f10657e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10657e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10658e;

                public b(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f10658e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10658e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10659e;

                public c(SwanApi$$PluginWebviewModule swanApi$$PluginWebviewModule, Throwable th) {
                    this.f10659e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10659e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String invokePluginChooseAddress(String str) {
                d.a.m0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginChooseAddress[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.m0.a.t1.c.a.a)) {
                        aVar = (d.a.m0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginLoginAndGetUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.m0.a.t1.c.a.a)) {
                        aVar = (d.a.m0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
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
                d.a.m0.a.t1.c.a.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Plugin.invokePluginPayment[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-254510461");
                    if (obj != null && (obj instanceof d.a.m0.a.t1.c.a.a)) {
                        aVar = (d.a.m0.a.t1.c.a.a) obj;
                    } else {
                        aVar = new d.a.m0.a.t1.c.a.a(this.mSwanApiContext);
                        this.mApis.put("-254510461", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/invokePluginPayment");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
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
        hashMap.put("_naPrefetch", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10661e;

                public a(SwanApi$$PrefetchWebviewModule swanApi$$PrefetchWebviewModule, Throwable th) {
                    this.f10661e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10661e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String prefetchResources(String str) {
                d.a.m0.a.h0.o.f.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Prefetch.prefetchResources[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2068479848");
                    if (obj != null && (obj instanceof d.a.m0.a.h0.o.f.a)) {
                        aVar = (d.a.m0.a.h0.o.f.a) obj;
                    } else {
                        aVar = new d.a.m0.a.h0.o.f.a(this.mSwanApiContext);
                        this.mApis.put("-2068479848", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/prefetchResources");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Prefetch.prefetchResources[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10663e;

                public a(SwanApi$$PreloadWebviewModule swanApi$$PreloadWebviewModule, Throwable th) {
                    this.f10663e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10663e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String preloadStatus(String str) {
                d.a.m0.a.h0.l.g.o.d.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Preload.preloadStatus[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("423661539");
                    if (obj != null && (obj instanceof d.a.m0.a.h0.l.g.o.d.a)) {
                        aVar = (d.a.m0.a.h0.l.g.o.d.a) obj;
                    } else {
                        aVar = new d.a.m0.a.h0.l.g.o.d.a(this.mSwanApiContext);
                        this.mApis.put("423661539", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/preloadStatus");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Preload.preloadStatus[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10673e;

                public a(SwanApi$$PrivateFileWebviewModule swanApi$$PrivateFileWebviewModule, Throwable th) {
                    this.f10673e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10673e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String uploadFileToBos(String str) {
                d.a.m0.a.u2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateFile.uploadFileToBos[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1929343869");
                    if (obj != null && (obj instanceof d.a.m0.a.u2.b)) {
                        bVar2 = (d.a.m0.a.u2.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u2.b(this.mSwanApiContext);
                        this.mApis.put("-1929343869", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/uploadFileToBos");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = bVar2.w(str);
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateFile.uploadFileToBos[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10680e;

                public a(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10680e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10680e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10681e;

                public b(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10681e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10681e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10682e;

                public c(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10682e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10682e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10683e;

                public d(SwanApi$$RouterWebviewModule swanApi$$RouterWebviewModule, Throwable th) {
                    this.f10683e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10683e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String navigateBack(String str) {
                d.a.m0.a.u.e.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateBack[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1495163604");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.a)) {
                        aVar = (d.a.m0.a.u.e.k.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.k.a(this.mSwanApiContext);
                        this.mApis.put("-1495163604", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/navigateBack");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.a.u.e.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.navigateTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1968522584");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.b)) {
                        bVar2 = (d.a.m0.a.u.e.k.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.k.b(this.mSwanApiContext);
                        this.mApis.put("1968522584", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/navigateTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = bVar2.v(str);
                    String a3 = v == null ? "" : v.a();
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
                d.a.m0.a.u.e.k.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.reLaunch[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1317280190");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.d)) {
                        dVar = (d.a.m0.a.u.e.k.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.k.d(this.mSwanApiContext);
                        this.mApis.put("1317280190", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/reLaunch");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = dVar.v(str);
                    String a3 = v == null ? "" : v.a();
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
                d.a.m0.a.u.e.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Router.redirectTo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1792515533");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.k.c)) {
                        cVar = (d.a.m0.a.u.e.k.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.k.c(this.mSwanApiContext);
                        this.mApis.put("1792515533", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/redirectTo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = cVar.w(str);
                    String a3 = w == null ? "" : w.a();
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10690e;

                public a(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10690e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10690e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10691e;

                public b(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10691e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10691e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10692e;

                public c(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10692e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10692e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10693e;

                public d(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10693e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10693e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10694e;

                public e(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10694e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10694e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10695e;

                public f(SwanApi$$SettingWebviewModule swanApi$$SettingWebviewModule, Throwable th) {
                    this.f10695e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10695e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getAppInfoSync() {
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getAppInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getAppInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = bVar2.z();
                    String a3 = z == null ? "" : z.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSetting[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getSetting");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = bVar2.A(str);
                    String a3 = A == null ? "" : A.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSlaveIdSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getSlaveIdSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b B = bVar2.B();
                    String a3 = B == null ? "" : B.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getSwanId[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getSwanId");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b C = bVar2.C(str);
                    String a3 = C == null ? "" : C.a();
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
                d.a.m0.a.u.e.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.getUserInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-594895721");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.b)) {
                        bVar2 = (d.a.m0.a.u.e.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.l.b(this.mSwanApiContext);
                        this.mApis.put("-594895721", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getUserInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b D = bVar2.D(str);
                    String a3 = D == null ? "" : D.a();
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

            @JavascriptInterface
            public String isAllowedAdOpenAppSync() {
                d.a.m0.a.u.e.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Setting.isAllowedAdOpenAppSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("450273045");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.l.a)) {
                        aVar = (d.a.m0.a.u.e.l.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.l.a(this.mSwanApiContext);
                        this.mApis.put("450273045", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/isAllowedAdOpenAppSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = aVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Setting.isAllowedAdOpenAppSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10697e;

                public a(SwanApi$$StatisticEventWebviewModule swanApi$$StatisticEventWebviewModule, Throwable th) {
                    this.f10697e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10697e;
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
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(oVar, "swanAPI/ubcAndCeresStatisticEvent");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = oVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[StatisticEvent.ubcAndCeresStatisticEvent[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10717e;

                public a(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10717e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10717e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10718e;

                public b(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10718e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10718e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10719e;

                public c(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10719e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10719e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10720e;

                public d(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10720e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10720e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10721e;

                public e(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10721e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10721e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10722e;

                public f(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10722e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10722e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10723e;

                public g(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10723e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10723e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10724e;

                public h(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10724e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10724e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10725e;

                public i(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10725e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10725e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10726e;

                public j(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10726e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10726e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10727e;

                public k(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10727e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10727e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10728e;

                public l(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10728e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10728e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10729e;

                public m(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10729e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10729e;
                }
            }

            /* loaded from: classes2.dex */
            public class n implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10730e;

                public n(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10730e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10730e;
                }
            }

            /* loaded from: classes2.dex */
            public class o implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10731e;

                public o(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10731e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10731e;
                }
            }

            /* loaded from: classes2.dex */
            public class p implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10732e;

                public p(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10732e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10732e;
                }
            }

            /* loaded from: classes2.dex */
            public class q implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10733e;

                public q(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10733e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10733e;
                }
            }

            /* loaded from: classes2.dex */
            public class r implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10734e;

                public r(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10734e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10734e;
                }
            }

            /* loaded from: classes2.dex */
            public class s implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10735e;

                public s(SwanApi$$StorageWebviewModule swanApi$$StorageWebviewModule, Throwable th) {
                    this.f10735e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10735e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String clearGlobalStorage() {
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = bVar2.r();
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/clearGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = bVar2.s();
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearGlobalStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/clearStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r2 = aVar.r();
                    String a3 = r2 == null ? "" : r2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.clearStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/clearStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s2 = aVar.s();
                    String a3 = s2 == null ? "" : s2.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.clearStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = bVar2.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = bVar2.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b K = bVar2.K();
                    String a3 = K == null ? "" : K.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageInfoSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = bVar2.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getGlobalStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getStorageInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b w = aVar.w();
                    String a3 = w == null ? "" : w.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.getStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = aVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.getStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b D = bVar2.D(str);
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/removeGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = bVar2.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeGlobalStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/removeStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b D = aVar.D(str);
                    String a3 = D == null ? "" : D.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.removeStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/removeStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b E = aVar.E(str);
                    String a3 = E == null ? "" : E.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.removeStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b F = bVar2.F(str);
                    String a3 = F == null ? "" : F.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setGlobalStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-804054859");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.b)) {
                        bVar2 = (d.a.m0.a.u.e.m.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.m.b(this.mSwanApiContext);
                        this.mApis.put("-804054859", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/setGlobalStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b G = bVar2.G(str);
                    String a3 = G == null ? "" : G.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setGlobalStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/setStorage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b F = aVar.F(str);
                    String a3 = F == null ? "" : F.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.m.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Storage.setStorageSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("130910081");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.m.a)) {
                        aVar = (d.a.m0.a.u.e.m.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.m.a(this.mSwanApiContext);
                        this.mApis.put("130910081", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/setStorageSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b G = aVar.G(str);
                    String a3 = G == null ? "" : G.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Storage.setStorageSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10737e;

                public a(SwanApi$$SubscriptionWebviewModule swanApi$$SubscriptionWebviewModule, Throwable th) {
                    this.f10737e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10737e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String subscribeService(String str) {
                d.a.m0.a.u.e.n.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Subscription.subscribeService[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-947445811");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.n.a)) {
                        aVar = (d.a.m0.a.u.e.n.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.n.a(this.mSwanApiContext);
                        this.mApis.put("-947445811", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/subscribeService");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = aVar.z(str);
                    String a3 = z == null ? "" : z.a();
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10751e;

                public a(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10751e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10751e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10752e;

                public b(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10752e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10752e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10753e;

                public c(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10753e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10753e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10754e;

                public d(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10754e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10754e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10755e;

                public e(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10755e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10755e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10756e;

                public f(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10756e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10756e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10757e;

                public g(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10757e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10757e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10758e;

                public h(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10758e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10758e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10759e;

                public i(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10759e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10759e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10760e;

                public j(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10760e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10760e;
                }
            }

            /* loaded from: classes2.dex */
            public class k implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10761e;

                public k(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10761e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10761e;
                }
            }

            /* loaded from: classes2.dex */
            public class l implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10762e;

                public l(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10762e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10762e;
                }
            }

            /* loaded from: classes2.dex */
            public class m implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10763e;

                public m(SwanApi$$SystemWebviewModule swanApi$$SystemWebviewModule, Throwable th) {
                    this.f10763e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10763e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String checkPhoneContactsAuthorization(String str) {
                d.a.m0.a.u.e.o.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.checkPhoneContactsAuthorization[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1112806039");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.h)) {
                        hVar = (d.a.m0.a.u.e.o.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.o.h(this.mSwanApiContext);
                        this.mApis.put("-1112806039", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPIcheckPhoneContactsAuthorization");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.checkPhoneContactsAuthorization")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = hVar.t(str);
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.checkPhoneContactsAuthorization[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.exitFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1936205521");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.f)) {
                        fVar = (d.a.m0.a.u.e.o.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.o.f(this.mSwanApiContext);
                        this.mApis.put("1936205521", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/exitFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = fVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.exitFullScreen[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getBrightness[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("99997465");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.b)) {
                        bVar2 = (d.a.m0.a.u.e.o.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.o.b(this.mSwanApiContext);
                        this.mApis.put("99997465", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getBrightness");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getBrightness[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.c)) {
                        cVar = (d.a.m0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/getClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = cVar.r();
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getClipboardData[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.getDeviceInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1694151270");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.e)) {
                        eVar = (d.a.m0.a.u.e.o.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.o.e(this.mSwanApiContext);
                        this.mApis.put("1694151270", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/getDeviceInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = eVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.getDeviceInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.g gVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.makePhoneCall[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1569246082");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.g)) {
                        gVar = (d.a.m0.a.u.e.o.g) obj;
                    } else {
                        gVar = new d.a.m0.a.u.e.o.g(this.mSwanApiContext);
                        this.mApis.put("-1569246082", gVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(gVar, "swanAPI/makePhoneCall");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = gVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.makePhoneCall[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.j jVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.openSMSPanel[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1099851202");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.j)) {
                        jVar = (d.a.m0.a.u.e.o.j) obj;
                    } else {
                        jVar = new d.a.m0.a.u.e.o.j(this.mSwanApiContext);
                        this.mApis.put("1099851202", jVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(jVar, "swanAPI/openSMSPanel");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = jVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.openSMSPanel[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.i iVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.requestFullScreen[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1707203360");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.i)) {
                        iVar = (d.a.m0.a.u.e.o.i) obj;
                    } else {
                        iVar = new d.a.m0.a.u.e.o.i(this.mSwanApiContext);
                        this.mApis.put("-1707203360", iVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(iVar, "swanAPI/requestFullScreen");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b x = iVar.x(str);
                    String a3 = x == null ? "" : x.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.requestFullScreen[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.setClipboardData[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-518757484");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.c)) {
                        cVar = (d.a.m0.a.u.e.o.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.o.c(this.mSwanApiContext);
                        this.mApis.put("-518757484", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/setClipboardData");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = cVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.setClipboardData[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.a)) {
                        aVar = (d.a.m0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/startAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startAccelerometer[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.startCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.d)) {
                        dVar = (d.a.m0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/startCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.startCompass")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = dVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.startCompass[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopAccelerometer[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1372680763");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.a)) {
                        aVar = (d.a.m0.a.u.e.o.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.o.a(this.mSwanApiContext);
                        this.mApis.put("1372680763", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/stopAccelerometer");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = aVar.t();
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopAccelerometer[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.o.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================System.stopCompass[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1689255576");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.o.d)) {
                        dVar = (d.a.m0.a.u.e.o.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.o.d(this.mSwanApiContext);
                        this.mApis.put("1689255576", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/stopCompass");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b t = dVar.t();
                    String a3 = t == null ? "" : t.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[System.stopCompass[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.a.m0.a.u.c.d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10774e;

                public a(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10774e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10774e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10775e;

                public b(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10775e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10775e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10776e;

                public c(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10776e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10776e;
                }
            }

            /* loaded from: classes2.dex */
            public class d implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10777e;

                public d(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10777e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10777e;
                }
            }

            /* loaded from: classes2.dex */
            public class e implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10778e;

                public e(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10778e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10778e;
                }
            }

            /* loaded from: classes2.dex */
            public class f implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10779e;

                public f(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10779e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10779e;
                }
            }

            /* loaded from: classes2.dex */
            public class g implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10780e;

                public g(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10780e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10780e;
                }
            }

            /* loaded from: classes2.dex */
            public class h implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10781e;

                public h(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10781e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10781e;
                }
            }

            /* loaded from: classes2.dex */
            public class i implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10782e;

                public i(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10782e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10782e;
                }
            }

            /* loaded from: classes2.dex */
            public class j implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10783e;

                public j(SwanApi$$UtilsWebviewModule swanApi$$UtilsWebviewModule, Throwable th) {
                    this.f10783e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10783e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String addToDesktop(String str) {
                d.a.m0.a.u.e.p.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.addToDesktop[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("201194468");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.b)) {
                        bVar2 = (d.a.m0.a.u.e.p.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.u.e.p.b(this.mSwanApiContext);
                        this.mApis.put("201194468", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/addToDesktop");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = bVar2.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.addToDesktop[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.checkAppInstalled[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1626415364");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.a)) {
                        aVar = (d.a.m0.a.u.e.p.a) obj;
                    } else {
                        aVar = new d.a.m0.a.u.e.p.a(this.mSwanApiContext);
                        this.mApis.put("1626415364", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/checkAppInstalled");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b u = aVar.u(str);
                    String a3 = u == null ? "" : u.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getCommonSysInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.f)) {
                        fVar = (d.a.m0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getCommonSysInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = fVar.v();
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.f)) {
                        fVar = (d.a.m0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getSystemInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b y = fVar.y();
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.f fVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.getSystemInfoSync[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-1011537871");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.f)) {
                        fVar = (d.a.m0.a.u.e.p.f) obj;
                    } else {
                        fVar = new d.a.m0.a.u.e.p.f(this.mSwanApiContext);
                        this.mApis.put("-1011537871", fVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(fVar, "swanAPI/getSystemInfoSync");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = fVar.z();
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.handleException[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-2097727681");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.c)) {
                        cVar = (d.a.m0.a.u.e.p.c) obj;
                    } else {
                        cVar = new d.a.m0.a.u.e.p.c(this.mSwanApiContext);
                        this.mApis.put("-2097727681", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/handleException");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = cVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.handleException[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.d2.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.hideCaptureScreenShareDialog[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1031678042");
                    if (obj != null && (obj instanceof d.a.m0.a.d2.b)) {
                        bVar2 = (d.a.m0.a.d2.b) obj;
                    } else {
                        bVar2 = new d.a.m0.a.d2.b(this.mSwanApiContext);
                        this.mApis.put("1031678042", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/hideCaptureScreenShareDialog");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.hideCaptureScreenShareDialog[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.d dVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.logToFile[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1751900130");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.d)) {
                        dVar = (d.a.m0.a.u.e.p.d) obj;
                    } else {
                        dVar = new d.a.m0.a.u.e.p.d(this.mSwanApiContext);
                        this.mApis.put("1751900130", dVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(dVar, "swanAPI/logToFile");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = dVar.s(str);
                    String a3 = s == null ? "" : s.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.logToFile[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.e eVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.previewImage[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("589529211");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.e)) {
                        eVar = (d.a.m0.a.u.e.p.e) obj;
                    } else {
                        eVar = new d.a.m0.a.u.e.p.e(this.mSwanApiContext);
                        this.mApis.put("589529211", eVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(eVar, "swanAPI/previewImage");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b v = eVar.v(str);
                    String a3 = v == null ? "" : v.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.previewImage[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.a.m0.a.u.e.p.h hVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================Utils.ubcFlowJar[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-577481801");
                    if (obj != null && (obj instanceof d.a.m0.a.u.e.p.h)) {
                        hVar = (d.a.m0.a.u.e.p.h) obj;
                    } else {
                        hVar = new d.a.m0.a.u.e.p.h(this.mSwanApiContext);
                        this.mApis.put("-577481801", hVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(hVar, "swanAPI/ubcFlowJar");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (d.a.m0.a.h0.l.g.f.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b B = hVar.B(str);
                    String a3 = B == null ? "" : B.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
