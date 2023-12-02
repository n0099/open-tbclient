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
import com.baidu.tieba.i52;
import com.baidu.tieba.ng2;
import com.baidu.tieba.oz2;
import com.baidu.tieba.r82;
import com.baidu.tieba.sq2;
import com.baidu.tieba.xr2;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppJsBridge extends sq2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";

    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, i52 i52Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, i52Var);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            if (sq2.DEBUG) {
                Log.d(TAG, "doSchemeDispatch scheme: " + str + " mCallbackHandler: " + this.mCallbackHandler);
            }
            SchemeTimeCostMoniter.getInstance().schemeStart(str);
            this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
            SchemeTimeCostMoniter.getInstance().schemeEnd(str);
            JSONObject jSONObject = unitedSchemeEntity.result;
            if (jSONObject != null) {
                return jSONObject.toString();
            }
            return "";
        }
        return UnitedSchemeUtility.wrapCallbackParams(201).toString();
    }

    @JavascriptInterface
    public String dispatch(String str) {
        if (r82.a(this.mJsContainer, str)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        return doSchemeDispatch(str);
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (sq2.DEBUG) {
            Log.d(TAG, "slave id: " + str + " data: " + str2);
        }
        i52 i52Var = this.mJsContainer;
        if (r82.a(i52Var, "setData - " + str2)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        oz2.a("postMessage", "PostMsg setData handle");
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ng2 ng2Var = new ng2(str, str2);
            oz2.a("postMessage", "PostMsg setData start");
            xr2.V().z(ng2Var, false);
            oz2.a("postMessage", "PostMsg setData end");
        } else {
            i = 202;
        }
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }
}
