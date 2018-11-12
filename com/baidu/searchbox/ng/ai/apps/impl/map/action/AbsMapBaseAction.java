package com.baidu.searchbox.ng.ai.apps.impl.map.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.map.MapView;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class AbsMapBaseAction {
    private static final int ERR_INIT_MAP_LIB_FAIL = 2000;
    private static final String ERR_MSG_BD_MAP_LIB_LOAD_FAIL = "baidu map lib load failed!";
    public static final String PARAMS_DATA = "data";
    public static final String PARAMS_JSON_CALLBACK = "cb";
    public static final String PARAMS_KEY = "params";
    private static boolean sIsInitializedMapSoFile = false;

    protected abstract boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        MapModel model = getModel(unitedSchemeEntity);
        if (model == null) {
            AiAppsLog.e("map", "parse error, model is null");
            unitedSchemeEntity.result = wrapResult(202);
            return false;
        }
        if (TextUtils.isEmpty(model.slaveId)) {
            String topWebViewId = AiAppsUtils.getTopWebViewId();
            if (!TextUtils.isEmpty(topWebViewId)) {
                model.slaveId = topWebViewId;
            }
            AiAppsLog.w("map", "webView id is empty, use current webView");
        }
        WebView bdWebView = getBdWebView(unitedSchemeEntity, model.slaveId);
        if (bdWebView == null) {
            unitedSchemeEntity.result = wrapResult(202);
            AiAppsLog.e("map", "can not find weiView by id " + model.slaveId);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        if (!doAction(context, model, bdWebView, aiApp, jSONObject, unitedSchemeEntity, callbackHandler)) {
            unitedSchemeEntity.result = wrapResult(1001);
            AiAppsLog.e("map", "doAction  fail ");
            return false;
        }
        if (jSONObject.length() <= 0) {
            jSONObject = null;
        }
        callBackWithParams(unitedSchemeEntity, callbackHandler, jSONObject);
        return true;
    }

    protected MapModel getModel(UnitedSchemeEntity unitedSchemeEntity) {
        MapModel mapModel;
        JSONException e;
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            AiAppsLog.e("map", "entity get Params is empty");
            return null;
        }
        String str = params.get("params");
        if (str == null) {
            AiAppsLog.e("map", "params string is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            mapModel = new MapModel();
        } catch (JSONException e2) {
            mapModel = null;
            e = e2;
        }
        try {
            mapModel.parseFromJson(jSONObject);
            return mapModel;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            AiAppsLog.e("map", "params json parse error");
            return mapModel;
        }
    }

    protected JSONObject wrapResult(int i) {
        return UnitedSchemeUtility.wrapCallbackParams(i);
    }

    protected void callBackWithParams(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    protected WebView getBdWebView(UnitedSchemeEntity unitedSchemeEntity, String str) {
        WebView bdWebViewBySlaveId = AiAppsUtils.getBdWebViewBySlaveId(str);
        if (bdWebViewBySlaveId == null) {
            unitedSchemeEntity.result = wrapResult(1001);
            return null;
        }
        return bdWebViewBySlaveId;
    }

    private void makeSureMapSoFileCopied(Context context) {
        if (!sIsInitializedMapSoFile) {
            new MapView(context);
            sIsInitializedMapSoFile = true;
        }
    }
}
