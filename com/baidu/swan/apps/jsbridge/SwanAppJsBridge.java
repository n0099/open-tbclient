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
import com.baidu.tieba.ba2;
import com.baidu.tieba.gl2;
import com.baidu.tieba.h43;
import com.baidu.tieba.kd2;
import com.baidu.tieba.lv2;
import com.baidu.tieba.qw2;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppJsBridge extends lv2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";

    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, ba2 ba2Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, ba2Var);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            if (lv2.DEBUG) {
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
        if (kd2.a(this.mJsContainer, str)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        return doSchemeDispatch(str);
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (lv2.DEBUG) {
            Log.d(TAG, "slave id: " + str + " data: " + str2);
        }
        ba2 ba2Var = this.mJsContainer;
        if (kd2.a(ba2Var, "setData - " + str2)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        h43.a("postMessage", "PostMsg setData handle");
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gl2 gl2Var = new gl2(str, str2);
            h43.a("postMessage", "PostMsg setData start");
            qw2.T().y(gl2Var, false);
            h43.a("postMessage", "PostMsg setData end");
        } else {
            i = 202;
        }
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }
}
