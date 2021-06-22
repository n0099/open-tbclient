package com.baidu.swan.bdprivate.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.a.m0.a.h0.l.g.f;
import d.a.m0.a.u.c.b;
import d.a.m0.a.u.c.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes3.dex */
public class SwanApi$$ModulesProvider {
    public static Map<String, Object> getV8ApiModules(final b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10664e;

                public a(SwanApi$$PrivateAccountV8Module swanApi$$PrivateAccountV8Module, Throwable th) {
                    this.f10664e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10664e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                d.a.m0.b.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof d.a.m0.b.l.a)) {
                        aVar = (d.a.m0.b.l.a) obj;
                    } else {
                        aVar = new d.a.m0.b.l.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateAccount.getBDUSS")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10666e;

                public a(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                    this.f10666e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10666e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10667e;

                public b(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                    this.f10667e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10667e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10668e;

                public c(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                    this.f10668e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10668e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                d.a.m0.b.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof d.a.m0.b.l.b)) {
                        bVar2 = (d.a.m0.b.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.b.l.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.getOpenBDUSS")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = bVar2.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.b.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.m0.b.l.c)) {
                        cVar = (d.a.m0.b.l.c) obj;
                    } else {
                        cVar = new d.a.m0.b.l.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.queryQuickLoginInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = cVar.z(str);
                    String a3 = z == null ? "" : z.a();
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
                d.a.m0.b.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.m0.b.l.c)) {
                        cVar = (d.a.m0.b.l.c) obj;
                    } else {
                        cVar = new d.a.m0.b.l.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.quickLogin")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = cVar.A(str);
                    String a3 = A == null ? "" : A.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10674e;

                public a(SwanApi$$PrivateUtilsV8Module swanApi$$PrivateUtilsV8Module, Throwable th) {
                    this.f10674e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10674e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                d.a.m0.b.n.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof d.a.m0.b.n.c.a)) {
                        aVar = (d.a.m0.b.n.c.a) obj;
                    } else {
                        aVar = new d.a.m0.b.n.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateUtils.getCommonSysInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10665e;

                public a(SwanApi$$PrivateAccountWebviewModule swanApi$$PrivateAccountWebviewModule, Throwable th) {
                    this.f10665e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10665e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getBDUSS(String str) {
                d.a.m0.b.l.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("446653951");
                    if (obj != null && (obj instanceof d.a.m0.b.l.a)) {
                        aVar = (d.a.m0.b.l.a) obj;
                    } else {
                        aVar = new d.a.m0.b.l.a(this.mSwanApiContext);
                        this.mApis.put("446653951", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateAccount.getBDUSS")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public d.a.m0.a.u.c.b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10669e;

                public a(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                    this.f10669e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10669e;
                }
            }

            /* loaded from: classes2.dex */
            public class b implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10670e;

                public b(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                    this.f10670e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10670e;
                }
            }

            /* loaded from: classes2.dex */
            public class c implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10671e;

                public c(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                    this.f10671e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10671e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getOpenBDUSS(String str) {
                d.a.m0.b.l.b bVar2;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-404108695");
                    if (obj != null && (obj instanceof d.a.m0.b.l.b)) {
                        bVar2 = (d.a.m0.b.l.b) obj;
                    } else {
                        bVar2 = new d.a.m0.b.l.b(this.mSwanApiContext);
                        this.mApis.put("-404108695", bVar2);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.getOpenBDUSS")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = bVar2.s(str);
                    String a3 = s == null ? "" : s.a();
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
                d.a.m0.b.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.m0.b.l.c)) {
                        cVar = (d.a.m0.b.l.c) obj;
                    } else {
                        cVar = new d.a.m0.b.l.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.queryQuickLoginInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b z = cVar.z(str);
                    String a3 = z == null ? "" : z.a();
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
                d.a.m0.b.l.c cVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("1495818240");
                    if (obj != null && (obj instanceof d.a.m0.b.l.c)) {
                        cVar = (d.a.m0.b.l.c) obj;
                    } else {
                        cVar = new d.a.m0.b.l.c(this.mSwanApiContext);
                        this.mApis.put("1495818240", cVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(cVar, "swanAPI/quickLogin");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.quickLogin")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b A = cVar.A(str);
                    String a3 = A == null ? "" : A.a();
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
            public static final boolean DEBUG = d.f48594c;
            public static final String TAG = "Api-Base";
            public ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
            public b mSwanApiContext;

            /* loaded from: classes2.dex */
            public class a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f10675e;

                public a(SwanApi$$PrivateUtilsWebviewModule swanApi$$PrivateUtilsWebviewModule, Throwable th) {
                    this.f10675e = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f10675e;
                }
            }

            {
                this.mSwanApiContext = bVar;
            }

            @JavascriptInterface
            public String getCommonSysInfo(String str) {
                d.a.m0.b.n.c.a aVar;
                try {
                    if (DEBUG) {
                        Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false]====================");
                    }
                    Object obj = this.mApis.get("-599878304");
                    if (obj != null && (obj instanceof d.a.m0.b.n.c.a)) {
                        aVar = (d.a.m0.b.n.c.a) obj;
                    } else {
                        aVar = new d.a.m0.b.n.c.a(this.mSwanApiContext);
                        this.mApis.put("-599878304", aVar);
                    }
                    Pair<Boolean, d.a.m0.a.u.h.a> a2 = d.a.m0.a.u.i.a.a(aVar, "swanAPI/getCommonSysInfo");
                    if (((Boolean) a2.first).booleanValue()) {
                        return ((d.a.m0.a.u.h.a) a2.second).a();
                    }
                    if (f.a(this.mSwanApiContext.g(), "PrivateUtils.getCommonSysInfo")) {
                        return new d.a.m0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                    }
                    d.a.m0.a.u.h.b s = aVar.s(str);
                    String a3 = s == null ? "" : s.a();
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
