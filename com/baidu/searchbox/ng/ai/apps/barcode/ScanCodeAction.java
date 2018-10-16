package com.baidu.searchbox.ng.ai.apps.barcode;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScanCodeAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/scanCode";
    private static final String KEY_CB = "cb";
    private static final String KEY_CHAR_SET = "charSet";
    private static final String KEY_PARAMS = "params";
    private static final String KEY_RESULT = "result";
    private static final String KEY_SCAN_TYPE = "scanType";
    public static final String MODULE_TAG = "scanCode";
    public static final String RESULT_CODE = "status_code";
    public static final String RESULT_DATA = "data";
    private String mCallback;

    public ScanCodeAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.i(MODULE_TAG, "aiApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        this.mCallback = parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            AiAppsLog.i(MODULE_TAG, "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsRuntime.getScanCodeRuntime().scanCode(aiApp.getActivity(), new IScanResultCallback() { // from class: com.baidu.searchbox.ng.ai.apps.barcode.ScanCodeAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.barcode.IScanResultCallback
            public void onResult(JSONObject jSONObject, int i) {
                if (jSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(ScanCodeAction.KEY_SCAN_TYPE, jSONObject.optString("codeType"));
                        jSONObject2.put(ScanCodeAction.KEY_CHAR_SET, jSONObject.optString("encoding"));
                        jSONObject2.put("result", jSONObject.optString("result"));
                        AiAppsLog.i(ScanCodeAction.MODULE_TAG, jSONObject2.toString());
                        callbackHandler.handleSchemeDispatchCallback(ScanCodeAction.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, i).toString());
                        return;
                    } catch (JSONException e) {
                    }
                }
                AiAppsLog.i(ScanCodeAction.MODULE_TAG, "scanCode exec fail");
                callbackHandler.handleSchemeDispatchCallback(ScanCodeAction.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public static JSONObject parseString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }
}
