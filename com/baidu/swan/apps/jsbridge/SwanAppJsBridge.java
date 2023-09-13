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
import com.baidu.tieba.fa2;
import com.baidu.tieba.kl2;
import com.baidu.tieba.l43;
import com.baidu.tieba.od2;
import com.baidu.tieba.pv2;
import com.baidu.tieba.uw2;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppJsBridge extends pv2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";

    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, fa2 fa2Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, fa2Var);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            if (pv2.DEBUG) {
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
        if (od2.a(this.mJsContainer, str)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        return doSchemeDispatch(str);
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (pv2.DEBUG) {
            Log.d(TAG, "slave id: " + str + " data: " + str2);
        }
        fa2 fa2Var = this.mJsContainer;
        if (od2.a(fa2Var, "setData - " + str2)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        l43.a("postMessage", "PostMsg setData handle");
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            kl2 kl2Var = new kl2(str, str2);
            l43.a("postMessage", "PostMsg setData start");
            uw2.T().y(kl2Var, false);
            l43.a("postMessage", "PostMsg setData end");
        } else {
            i = 202;
        }
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }
}
