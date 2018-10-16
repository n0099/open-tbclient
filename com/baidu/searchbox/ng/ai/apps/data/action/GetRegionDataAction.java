package com.baidu.searchbox.ng.ai.apps.data.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppAssetUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetRegionDataAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getRegionData";
    private static final String REGION_DATA_FILE_NAME = "aiapps/pickerRegion.js";
    private static final String VALUE_KEY_CONTENT = "content";

    public GetRegionDataAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        }
        String loadAssetsFile = AiAppAssetUtils.loadAssetsFile(context, REGION_DATA_FILE_NAME);
        if (TextUtils.isEmpty(loadAssetsFile)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty regionData");
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(loadAssetsFile);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content", jSONArray);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exec fail");
            return false;
        }
    }
}
