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
import d.b.g0.a.i2.k0;
@Keep
/* loaded from: classes2.dex */
public class SwanAppGlobalJsBridge extends d.b.g0.a.x0.a {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    public static final String TAG = "SwanAppGlobalJsBridge";

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12229e;

        public a(String str) {
            this.f12229e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = SwanAppGlobalJsBridge.this;
            swanAppGlobalJsBridge.doSchemeDispatch(swanAppGlobalJsBridge.mCallbackHandler.getCurrentPageUrl(), this.f12229e);
        }
    }

    public SwanAppGlobalJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        super(context, unitedSchemeMainDispatcher, callbackHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doSchemeDispatch(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            return false;
        }
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str2));
        unitedSchemeEntity.setReferUrl(this.mCallbackHandler.getCurrentPageUrl());
        unitedSchemeEntity.setPageUrl(str);
        if (d.b.g0.a.x0.a.DEBUG) {
            Log.d(TAG, "doSchemeDispatch scheme: " + str2 + " mCallbackHandler: " + this.mCallbackHandler);
        }
        SchemeTimeCostMoniter.getInstance().schemeStart(str2);
        unitedSchemeEntity.getUri().getPath();
        boolean dispatch = this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
        SchemeTimeCostMoniter.getInstance().schemeEnd(str2);
        return dispatch;
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        k0.X(new a(str));
        return true;
    }
}
