package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetAppInfoSyncAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getAppInfoSync";
    private static final boolean DEBUG = false;
    private static final String JSON_ALIAS_APP_ID_KEY = "appId";
    private static final String JSON_APP_ID_KEY = "appid";
    private static final String JSON_APP_LAUNCH_SCHEME_KEY = "appLaunchScheme";
    private static final String JSON_APP_NAME_KEY = "appname";
    private static final String JSON_CLK_ID_KEY = "clkid";
    private static final String JSON_CUID_KEY = "cuid";
    private static final String JSON_EXTRA_DATA_KEY = "extraData";
    private static final String JSON_MTJ_CUID_KEY = "mtjCuid";
    private static final String JSON_SCENE_KEY = "scene";
    private static final String MODULE_TAG = "appInfo";
    private static final String TAG = "GetAppInfoSyncAction";

    public GetAppInfoSyncAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsActivity activity = AiAppsController.getInstance().getActivity();
        if (activity == null) {
            AiAppsLog.e(MODULE_TAG, "activity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AiAppsLaunchInfo launchInfo = activity.getLaunchInfo();
        if (launchInfo == null || !launchInfo.isValid()) {
            AiAppsLog.e(MODULE_TAG, "launch info is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", launchInfo.mAppId);
            jSONObject.put(JSON_APP_NAME_KEY, launchInfo.mAppTitle);
            if (!TextUtils.isEmpty(launchInfo.mLaunchScheme)) {
                jSONObject.put(JSON_APP_LAUNCH_SCHEME_KEY, launchInfo.mLaunchScheme);
            }
            String cuid = AiAppsRuntime.getAiAppAccountRuntime().getCuid(context);
            jSONObject.put("cuid", cuid);
            jSONObject.put("mtjCuid", cuid);
            jSONObject.put("clkid", launchInfo.mClickId);
            jSONObject.put("scene", launchInfo.mLaunchFrom);
            jSONObject.put("appId", launchInfo.mAppId);
            Bundle bundle = launchInfo.mExtraData;
            if (bundle != null) {
                String string = bundle.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("extraData", new JSONObject(string));
                }
                if (TextUtils.equals(bundle.getString(LaunchAction.PARAM_NAVI_KEY), LaunchAction.AI_APPS_NAVI_TO)) {
                    jSONObject.put(LaunchAction.PARAM_SOURCE_KEY, bundle.getString(LaunchAction.PARAM_SOURCE_KEY));
                    jSONObject.put(LaunchAction.PARAM_PAGE_KEY, bundle.getString(LaunchAction.PARAM_PAGE_KEY));
                }
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e) {
            AiAppsLog.e(MODULE_TAG, Log.getStackTraceString(e));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
