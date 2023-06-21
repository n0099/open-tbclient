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
import com.baidu.tieba.dx2;
import com.baidu.tieba.ge2;
import com.baidu.tieba.hw2;
import com.baidu.tieba.o53;
import com.baidu.tieba.p53;
import com.baidu.tieba.tp3;
import com.baidu.tieba.wl2;
import com.baidu.tieba.xa2;
import com.baidu.tieba.xl2;
import com.baidu.tieba.z82;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes4.dex */
public class SwanAppGlobalJsBridge extends hw2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";
    public CopyOnWriteArrayList<String> mPendingSchemeList;

    /* loaded from: classes4.dex */
    public class c implements o53 {

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
                if (dx2.a) {
                    Log.d("SwanPerformance", "pending api count = " + SwanAppGlobalJsBridge.this.mPendingSchemeList.size());
                }
                SwanAppGlobalJsBridge.this.mPendingSchemeList.clear();
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.o53
        public void a() {
            if (SwanAppGlobalJsBridge.this.mPendingSchemeList.isEmpty()) {
                return;
            }
            tp3.a0(new a());
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
    public class b extends xl2 {
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // com.baidu.tieba.xl2
        public void c() {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
            swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.c);
        }
    }

    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, xa2 xa2Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, xa2Var);
        this.mPendingSchemeList = new CopyOnWriteArrayList<>();
        tp3.e0(new a());
    }

    private void dispatchOnUiThread(String str) {
        wl2.b().c(new b(str, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
            unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
            unitedSchemeEntity.setPageUrl(str);
            if (hw2.DEBUG) {
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
        p53.c().d(new c());
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        z82.i(TAG, "dispatch: scheme " + str);
        if (ge2.a(this.mJsContainer, str)) {
            return false;
        }
        if (p53.c().b(str)) {
            this.mPendingSchemeList.add(str);
            return true;
        }
        dispatchOnUiThread(str);
        return true;
    }
}
