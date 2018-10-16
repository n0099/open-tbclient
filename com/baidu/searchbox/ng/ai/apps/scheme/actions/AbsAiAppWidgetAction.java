package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AbsAiAppWidgetAction extends AiAppAction {
    private static final String INSERT_SUB_ACTION = "insert";
    protected static final String MODULE_TAG = "AbsAiAppWidget";
    private static final String REMOVE_SUB_ACTION = "remove";
    private static final String UPDATE_SUB_ACTION = "update";

    @NonNull
    public abstract String getModuleName();

    public abstract boolean insertAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp);

    public abstract boolean otherSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp);

    public abstract boolean removeAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp);

    public abstract boolean updateAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp);

    public AbsAiAppWidgetAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        boolean otherSubAction;
        String subActionAbsolutePath = getSubActionAbsolutePath(INSERT_SUB_ACTION);
        String subActionAbsolutePath2 = getSubActionAbsolutePath(UPDATE_SUB_ACTION);
        String subActionAbsolutePath3 = getSubActionAbsolutePath(REMOVE_SUB_ACTION);
        if (TextUtils.equals(subActionAbsolutePath, str)) {
            otherSubAction = insertAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
        } else if (TextUtils.equals(subActionAbsolutePath2, str)) {
            otherSubAction = updateAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
        } else if (TextUtils.equals(subActionAbsolutePath3, str)) {
            otherSubAction = removeAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
        } else {
            otherSubAction = otherSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
        }
        AiAppsLog.i(MODULE_TAG, "subAction = " + str + " ; handle result = " + otherSubAction);
        return otherSubAction || super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject getParamsJSONObject(UnitedSchemeEntity unitedSchemeEntity) {
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            AiAppsLog.e(MODULE_TAG, "getParamsJSONObject entity is null");
            return null;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            AiAppsLog.e(MODULE_TAG, "getParamsJSONObject paramsJson is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(param);
        } catch (JSONException e) {
            AiAppsLog.e(MODULE_TAG, "getParamsJSONObject exception = " + e.getMessage());
            jSONObject = null;
        }
        return jSONObject;
    }

    private String getSubActionAbsolutePath(String str) {
        return getModuleName() + "/" + str;
    }
}
