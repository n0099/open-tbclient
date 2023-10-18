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
import com.baidu.tieba.cr2;
import com.baidu.tieba.n42;
import com.baidu.tieba.sf2;
import com.baidu.tieba.ty2;
import com.baidu.tieba.w72;
import com.baidu.tieba.xp2;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppJsBridge extends xp2 {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";

    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, n42 n42Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, n42Var);
    }

    private String doSchemeDispatch(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
            if (xp2.DEBUG) {
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
        if (w72.a(this.mJsContainer, str)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        return doSchemeDispatch(str);
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        if (xp2.DEBUG) {
            Log.d(TAG, "slave id: " + str + " data: " + str2);
        }
        n42 n42Var = this.mJsContainer;
        if (w72.a(n42Var, "setData - " + str2)) {
            return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
        }
        ty2.a("postMessage", "PostMsg setData handle");
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sf2 sf2Var = new sf2(str, str2);
            ty2.a("postMessage", "PostMsg setData start");
            cr2.V().z(sf2Var, false);
            ty2.a("postMessage", "PostMsg setData end");
        } else {
            i = 202;
        }
        return UnitedSchemeUtility.wrapCallbackParams(i).toString();
    }
}
