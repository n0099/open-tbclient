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
import com.baidu.tieba.ak3;
import com.baidu.tieba.dg2;
import com.baidu.tieba.e52;
import com.baidu.tieba.eg2;
import com.baidu.tieba.g32;
import com.baidu.tieba.kr2;
import com.baidu.tieba.n82;
import com.baidu.tieba.oq2;
import com.baidu.tieba.vz2;
import com.baidu.tieba.wz2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes4.dex */
public class SwanAppGlobalJsBridge extends oq2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";
    public CopyOnWriteArrayList<String> mPendingSchemeList;

    /* loaded from: classes4.dex */
    public class c implements vz2 {

        /* loaded from: classes4.dex */
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
                if (kr2.a) {
                    Log.d("SwanPerformance", "pending api count = " + SwanAppGlobalJsBridge.this.mPendingSchemeList.size());
                }
                SwanAppGlobalJsBridge.this.mPendingSchemeList.clear();
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.vz2
        public void a() {
            if (SwanAppGlobalJsBridge.this.mPendingSchemeList.isEmpty()) {
                return;
            }
            ak3.a0(new a());
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppGlobalJsBridge.this.registerLaunchTrigger();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends eg2 {
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // com.baidu.tieba.eg2
        public void c() {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
            swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.c);
        }
    }

    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, e52 e52Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, e52Var);
        this.mPendingSchemeList = new CopyOnWriteArrayList<>();
        ak3.e0(new a());
    }

    private void dispatchOnUiThread(String str) {
        dg2.b().c(new b(str, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
            unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
            unitedSchemeEntity.setPageUrl(str);
            if (oq2.DEBUG) {
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
        wz2.c().d(new c());
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        g32.i(TAG, "dispatch: scheme " + str);
        if (n82.a(this.mJsContainer, str)) {
            return false;
        }
        if (wz2.c().b(str)) {
            this.mPendingSchemeList.add(str);
            return true;
        }
        dispatchOnUiThread(str);
        return true;
    }
}
