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
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.j1.h;
import d.b.g0.a.k0.b.d;
import d.b.g0.a.x0.a;
import d.b.g0.a.z0.f;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppJsBridge extends a {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";

    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        super(context, unitedSchemeMainDispatcher, callbackHandler);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            if (a.DEBUG) {
                Log.d(TAG, "doSchemeDispatch scheme: " + str + " mCallbackHandler: " + this.mCallbackHandler);
            }
            SchemeTimeCostMoniter.getInstance().schemeStart(str);
            unitedSchemeEntity.getUri().getPath();
            this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
            SchemeTimeCostMoniter.getInstance().schemeEnd(str);
            JSONObject jSONObject = unitedSchemeEntity.result;
            return jSONObject != null ? jSONObject.toString() : "";
        }
        return UnitedSchemeUtility.wrapCallbackParams(201).toString();
    }

    @JavascriptInterface
    public String dispatch(String str) {
        return doSchemeDispatch(str);
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (a.DEBUG) {
            Log.d(TAG, "slave id: " + str + " data: " + str2);
        }
        h.a("postMessage", "PostMsg setData handle");
        int i = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            i = 202;
        } else {
            d dVar = new d(str, str2);
            h.a("postMessage", "PostMsg setData start");
            f.V().e(dVar, false);
            h.a("postMessage", "PostMsg setData end");
        }
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }
}
