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
import com.baidu.tieba.ba2;
import com.baidu.tieba.cs2;
import com.baidu.tieba.j13;
import com.baidu.tieba.k13;
import com.baidu.tieba.ol3;
import com.baidu.tieba.rh2;
import com.baidu.tieba.s62;
import com.baidu.tieba.sh2;
import com.baidu.tieba.u42;
import com.baidu.tieba.ys2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes3.dex */
public class SwanAppGlobalJsBridge extends cs2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";
    public CopyOnWriteArrayList<String> mPendingSchemeList;

    /* loaded from: classes3.dex */
    public class c implements j13 {

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
                if (ys2.a) {
                    Log.d("SwanPerformance", "pending api count = " + SwanAppGlobalJsBridge.this.mPendingSchemeList.size());
                }
                SwanAppGlobalJsBridge.this.mPendingSchemeList.clear();
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.j13
        public void a() {
            if (SwanAppGlobalJsBridge.this.mPendingSchemeList.isEmpty()) {
                return;
            }
            ol3.a0(new a());
        }
    }

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
    public class b extends sh2 {
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // com.baidu.tieba.sh2
        public void c() {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
            swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.c);
        }
    }

    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, s62 s62Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, s62Var);
        this.mPendingSchemeList = new CopyOnWriteArrayList<>();
        ol3.e0(new a());
    }

    private void dispatchOnUiThread(String str) {
        rh2.b().c(new b(str, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
            unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
            unitedSchemeEntity.setPageUrl(str);
            if (cs2.DEBUG) {
                Log.d(TAG, "doSchemeDispatch scheme: " + str2 + " mCallbackHandler: " + this.mCallbackHandler);
            }
            SchemeTimeCostMoniter.getInstance().schemeStart(str2);
            boolean dispatch = this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
            SchemeTimeCostMoniter.getInstance().schemeEnd(str2);
            return dispatch;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLaunchTrigger() {
        k13.c().d(new c());
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        u42.i(TAG, "dispatch: scheme " + str);
        if (ba2.a(this.mJsContainer, str)) {
            return false;
        }
        if (k13.c().b(str)) {
            this.mPendingSchemeList.add(str);
            return true;
        }
        dispatchOnUiThread(str);
        return true;
    }
}
