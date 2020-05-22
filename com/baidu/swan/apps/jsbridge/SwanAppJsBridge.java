package com.baidu.swan.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.event.a.d;
import com.baidu.swan.apps.performance.a.f;
@Keep
/* loaded from: classes11.dex */
public class SwanAppJsBridge extends a {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    private static final String TAG = "SwanAppJsBridge";

    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        super(context, unitedSchemeMainDispatcher, callbackHandler);
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        int i = 0;
        if (DEBUG) {
            Log.d(TAG, "slave id: " + str + " data: " + str2);
        }
        f.alH().iq("setData");
        com.baidu.swan.apps.performance.f.D("postMessage", "PostMsg setData handle");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            i = 202;
        } else {
            d dVar = new d(str, str2);
            com.baidu.swan.apps.performance.f.D("postMessage", "PostMsg setData start");
            com.baidu.swan.apps.w.f.ahV().a(dVar, false);
            com.baidu.swan.apps.performance.f.D("postMessage", "PostMsg setData end");
        }
        f.alH().ir("setData");
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }

    @JavascriptInterface
    public String dispatch(String str) {
        return doSchemeDispatch(str);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            if (DEBUG) {
                Log.d(TAG, "doSchemeDispatch scheme: " + str + " mCallbackHandler: " + this.mCallbackHandler);
            }
            SchemeTimeCostMoniter.getInstance().schemeStart(str);
            String path = unitedSchemeEntity.getUri().getPath();
            f.alH().iq(path);
            this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
            SchemeTimeCostMoniter.getInstance().schemeEnd(str);
            f.alH().ir(path);
            if (unitedSchemeEntity.result != null) {
                return unitedSchemeEntity.result.toString();
            }
            return "";
        }
        return UnitedSchemeUtility.wrapCallbackParams(201).toString();
    }
}
