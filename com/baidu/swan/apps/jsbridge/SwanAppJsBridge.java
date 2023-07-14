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
import com.baidu.tieba.ce2;
import com.baidu.tieba.dw2;
import com.baidu.tieba.ix2;
import com.baidu.tieba.ta2;
import com.baidu.tieba.yl2;
import com.baidu.tieba.z43;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppJsBridge extends dw2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";

    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, ta2 ta2Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, ta2Var);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            if (dw2.DEBUG) {
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
        if (ce2.a(this.mJsContainer, str)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        return doSchemeDispatch(str);
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (dw2.DEBUG) {
            Log.d(TAG, "slave id: " + str + " data: " + str2);
        }
        ta2 ta2Var = this.mJsContainer;
        if (ce2.a(ta2Var, "setData - " + str2)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        z43.a("postMessage", "PostMsg setData handle");
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            yl2 yl2Var = new yl2(str, str2);
            z43.a("postMessage", "PostMsg setData start");
            ix2.T().y(yl2Var, false);
            z43.a("postMessage", "PostMsg setData end");
        } else {
            i = 202;
        }
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }
}
