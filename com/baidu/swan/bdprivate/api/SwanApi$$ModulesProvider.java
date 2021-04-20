package com.baidu.swan.bdprivate.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.b.g0.a.t.b.b;
import d.b.g0.a.t.b.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = d.f46321c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11671e;

                public a(SwanApi$$PrivateAccountV8Module swanApi$$PrivateAccountV8Module, Throwable th) {
                    this.f11671e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11671e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                d.b.g0.b.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof d.b.g0.b.k.a)) {
                        aVar = (d.b.g0.b.k.a) obj;
                    } else {
                        aVar = new d.b.g0.b.k.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f46321c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11673e;

                public a(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
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

                public b(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
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

                public c(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
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
            public String getOpenBDUSS(String str) {
                d.b.g0.b.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof d.b.g0.b.k.b)) {
                        bVar2 = (d.b.g0.b.k.b) obj;
                    } else {
                        bVar2 = new d.b.g0.b.k.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.b.g0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.b.g0.b.k.c)) {
                        cVar = (d.b.g0.b.k.c) obj;
                    } else {
                        cVar = new d.b.g0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = cVar.y(str);
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.b.g0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.b.g0.b.k.c)) {
                        cVar = (d.b.g0.b.k.c) obj;
                    } else {
                        cVar = new d.b.g0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = cVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f46321c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11679e;

                public a(SwanApi$$PrivateUtilsV8Module swanApi$$PrivateUtilsV8Module, Throwable th) {
                    this.f11679e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11679e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                d.b.g0.b.m.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof d.b.g0.b.m.c.a)) {
                        aVar = (d.b.g0.b.m.c.a) obj;
                    } else {
                        aVar = new d.b.g0.b.m.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f46321c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11672e;

                public a(SwanApi$$PrivateAccountWebviewModule swanApi$$PrivateAccountWebviewModule, Throwable th) {
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
            public String getBDUSS(String str) {
                d.b.g0.b.k.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof d.b.g0.b.k.a)) {
                        aVar = (d.b.g0.b.k.a) obj;
                    } else {
                        aVar = new d.b.g0.b.k.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f46321c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.b.g0.a.t.b.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11676e;

                public a(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
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

                public b(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
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

                public c(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
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
            public String getOpenBDUSS(String str) {
                d.b.g0.b.k.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof d.b.g0.b.k.b)) {
                        bVar2 = (d.b.g0.b.k.b) obj;
                    } else {
                        bVar2 = new d.b.g0.b.k.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar2);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = bVar2.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.b.g0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.b.g0.b.k.c)) {
                        cVar = (d.b.g0.b.k.c) obj;
                    } else {
                        cVar = new d.b.g0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b y = cVar.y(str);
                    String a3 = y == null ? "" : y.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
                d.b.g0.b.k.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.b.g0.b.k.c)) {
                        cVar = (d.b.g0.b.k.c) obj;
                    } else {
                        cVar = new d.b.g0.b.k.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b z = cVar.z(str);
                    String a3 = z == null ? "" : z.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
            public static final boolean DEBUG = d.f46321c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f11680e;

                public a(SwanApi$$PrivateUtilsWebviewModule swanApi$$PrivateUtilsWebviewModule, Throwable th) {
                    this.f11680e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f11680e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                d.b.g0.b.m.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof d.b.g0.b.m.c.a)) {
                        aVar = (d.b.g0.b.m.c.a) obj;
                    } else {
                        aVar = new d.b.g0.b.m.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar);
                    }
                    Pair<Boolean, d.b.g0.a.t.e.a> a2 = d.b.g0.a.t.f.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.b.g0.a.t.e.a) a2.second).a();
                    }
                    d.b.g0.a.t.e.b r = aVar.r(str);
                    String a3 = r == null ? "" : r.a();
                    if (DEBUG) {
                        Log.d("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] result]]" + a3);
                    }
                    return a3;
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
