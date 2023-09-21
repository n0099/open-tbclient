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
import com.baidu.tieba.ap3;
import com.baidu.tieba.dl2;
import com.baidu.tieba.ea2;
import com.baidu.tieba.el2;
import com.baidu.tieba.g82;
import com.baidu.tieba.kw2;
import com.baidu.tieba.nd2;
import com.baidu.tieba.ov2;
import com.baidu.tieba.v43;
import com.baidu.tieba.w43;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes4.dex */
public class SwanAppGlobalJsBridge extends ov2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";
    public CopyOnWriteArrayList<String> mPendingSchemeList;

    /* loaded from: classes4.dex */
    public class c implements v43 {

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
                if (kw2.a) {
                    Log.d("SwanPerformance", "pending api count = " + SwanAppGlobalJsBridge.this.mPendingSchemeList.size());
                }
                SwanAppGlobalJsBridge.this.mPendingSchemeList.clear();
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.v43
        public void a() {
            if (SwanAppGlobalJsBridge.this.mPendingSchemeList.isEmpty()) {
                return;
            }
            ap3.a0(new a());
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
    public class b extends el2 {
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // com.baidu.tieba.el2
        public void c() {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
            swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.c);
        }
    }

    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, ea2 ea2Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, ea2Var);
        this.mPendingSchemeList = new CopyOnWriteArrayList<>();
        ap3.e0(new a());
    }

    private void dispatchOnUiThread(String str) {
        dl2.b().c(new b(str, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
            unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
            unitedSchemeEntity.setPageUrl(str);
            if (ov2.DEBUG) {
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
        w43.c().d(new c());
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        g82.i(TAG, "dispatch: scheme " + str);
        if (nd2.a(this.mJsContainer, str)) {
            return false;
        }
        if (w43.c().b(str)) {
            this.mPendingSchemeList.add(str);
            return true;
        }
        dispatchOnUiThread(str);
        return true;
    }
}
