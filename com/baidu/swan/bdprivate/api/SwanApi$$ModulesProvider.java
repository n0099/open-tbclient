package com.baidu.swan.bdprivate.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.a.h0.a.t.b.b;
import d.a.h0.a.t.b.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11507e;

                public a(SwanApi$$PrivateAccountV8Module swanApi$$PrivateAccountV8Module, Throwable th) {
                    this.f11507e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11507e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                d.a.h0.b.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof d.a.h0.b.k.a)) {
                        aVar = (d.a.h0.b.k.a) obj;
                    } else {
                        aVar = new d.a.h0.b.k.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11509e;

                public a(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                    this.f11509e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11509e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11510e;

                public b(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                    this.f11510e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11510e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11511e;

                public c(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                    this.f11511e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11511e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                d.a.h0.b.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof d.a.h0.b.k.b)) {
                        bVar2 = (d.a.h0.b.k.b) obj;
                    } else {
                        bVar2 = new d.a.h0.b.k.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                d.a.h0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.h0.b.k.c)) {
                        cVar = (d.a.h0.b.k.c) obj;
                    } else {
                        cVar = new d.a.h0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = cVar.y(str);
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                d.a.h0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.h0.b.k.c)) {
                        cVar = (d.a.h0.b.k.c) obj;
                    } else {
                        cVar = new d.a.h0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = cVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsV8Module
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11515e;

                public a(SwanApi$$PrivateUtilsV8Module swanApi$$PrivateUtilsV8Module, Throwable th) {
                    this.f11515e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11515e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                d.a.h0.b.m.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof d.a.h0.b.m.c.a)) {
                        aVar = (d.a.h0.b.m.c.a) obj;
                    } else {
                        aVar = new d.a.h0.b.m.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] with exception]]", th);
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
        hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11508e;

                public a(SwanApi$$PrivateAccountWebviewModule swanApi$$PrivateAccountWebviewModule, Throwable th) {
                    this.f11508e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11508e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                d.a.h0.b.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof d.a.h0.b.k.a)) {
                        aVar = (d.a.h0.b.k.a) obj;
                    } else {
                        aVar = new d.a.h0.b.k.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.h0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11512e;

                public a(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                    this.f11512e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11512e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11513e;

                public b(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                    this.f11513e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11513e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11514e;

                public c(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                    this.f11514e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11514e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                d.a.h0.b.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof d.a.h0.b.k.b)) {
                        bVar2 = (d.a.h0.b.k.b) obj;
                    } else {
                        bVar2 = new d.a.h0.b.k.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar2);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = bVar2.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new a(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String queryQuickLoginInfo(String str) {
                d.a.h0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.h0.b.k.c)) {
                        cVar = (d.a.h0.b.k.c) obj;
                    } else {
                        cVar = new d.a.h0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b y = cVar.y(str);
                    String b2 = y == null ? "" : y.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new b(this, th));
                        return "";
                    }
                    throw th;
                }
            }

            @JavascriptInterface
            public String quickLogin(String str) {
                d.a.h0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.h0.b.k.c)) {
                        cVar = (d.a.h0.b.k.c) obj;
                    } else {
                        cVar = new d.a.h0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b z = cVar.z(str);
                    String b2 = z == null ? "" : z.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] with exception]]", th);
                        new Handler(Looper.getMainLooper()).post(new c(this, th));
                        return "";
                    }
                    throw th;
                }
            }
        });
        hashMap.put("_naPrivateUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsWebviewModule
            public static final boolean DEBUG = d.f44021c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11516e;

                public a(SwanApi$$PrivateUtilsWebviewModule swanApi$$PrivateUtilsWebviewModule, Throwable th) {
                    this.f11516e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11516e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                d.a.h0.b.m.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof d.a.h0.b.m.c.a)) {
                        aVar = (d.a.h0.b.m.c.a) obj;
                    } else {
                        aVar = new d.a.h0.b.m.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar);
                    }
                    Pair<Boolean, d.a.h0.a.t.e.a> a2 = d.a.h0.a.t.f.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.h0.a.t.e.a) a2.second).b();
                    }
                    d.a.h0.a.t.e.b r = aVar.r(str);
                    String b2 = r == null ? "" : r.b();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] result]]" + b2);
                    }
                    return b2;
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] with exception]]", th);
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
