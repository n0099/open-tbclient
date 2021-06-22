package com.baidu.swan.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import d.a.m0.a.h0.l.g.f;
import d.a.m0.a.r1.l.e;
import d.a.m0.a.v2.q0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes3.dex */
public class SwanAppGlobalJsBridge extends d.a.m0.a.d1.a {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";
    public CopyOnWriteArrayList<String> mPendingSchemeList;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppGlobalJsBridge.this.registerLaunchTrigger();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.a.o0.c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10941g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(str);
            this.f10941g = str2;
        }

        @Override // d.a.m0.a.o0.c
        public void c() {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
            swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.f10941g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10943e;

        public c(String str) {
            this.f10943e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
            swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.f10943e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.r1.k.h.a {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = SwanAppGlobalJsBridge.this.mPendingSchemeList.iterator();
                while (it.hasNext()) {
                    SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
                    swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), (String) it.next());
                }
                if (d.a.m0.a.f1.f.a.f45636a) {
                    Log.d("SwanPerformance", "pending api count = " + SwanAppGlobalJsBridge.this.mPendingSchemeList.size());
                }
                SwanAppGlobalJsBridge.this.mPendingSchemeList.clear();
            }
        }

        public d() {
        }

        @Override // d.a.m0.a.r1.k.h.a
        public void a() {
            if (SwanAppGlobalJsBridge.this.mPendingSchemeList.isEmpty()) {
                return;
            }
            q0.X(new a());
        }
    }

    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, d.a.m0.a.h0.f.a aVar) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
        this.mPendingSchemeList = new CopyOnWriteArrayList<>();
        q0.b0(new a());
    }

    private void dispatchOnUiThread(String str) {
        if (e.a()) {
            d.a.m0.a.o0.b.b().c(new b(str, str), null);
        } else {
            q0.b0(new c(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            return false;
        }
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
        unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
        unitedSchemeEntity.setPageUrl(str);
        if (d.a.m0.a.d1.a.DEBUG) {
            Log.d(TAG, "doSchemeDispatch scheme: " + str2 + " mCallbackHandler: " + this.mCallbackHandler);
        }
        SchemeTimeCostMoniter.getInstance().schemeStart(str2);
        boolean dispatch = this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
        SchemeTimeCostMoniter.getInstance().schemeEnd(str2);
        return dispatch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLaunchTrigger() {
        d.a.m0.a.r1.k.h.b.c().d(new d());
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        if (f.a(this.mJsContainer, str)) {
            return false;
        }
        if (d.a.m0.a.r1.k.h.b.c().b(str)) {
            this.mPendingSchemeList.add(str);
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.d("SwanPerformance", "pending api size = " + this.mPendingSchemeList.size());
                return true;
            }
            return true;
        }
        dispatchOnUiThread(str);
        return true;
    }
}
