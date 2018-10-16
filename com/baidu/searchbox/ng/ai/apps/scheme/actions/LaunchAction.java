package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.launch.error.LaunchError;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/launch";
    public static final String AI_APPS_NAVI_BACK = "naviBack";
    public static final String AI_APPS_NAVI_TO = "naviTo";
    private static final boolean DEBUG = false;
    private static final String PARAMS_FROM_KEY = "from";
    private static final String PARAMS_NOT_IN_HISTORY_KEY = "notinhis";
    private static final String PARAM_APPID_KEY = "appid";
    private static final String PARAM_CLICK_ID_KEY = "clkid";
    private static final String PARAM_DOWNLOAD_URL_KEY = "downloadurl";
    public static final String PARAM_EXTRA_DATA_KEY = "extraData";
    public static final String PARAM_NAVI_KEY = "navi";
    public static final String PARAM_PAGE_KEY = "srcAppPage";
    public static final String PARAM_SOURCE_KEY = "srcAppId";
    private static final String PARAM_URL_KEY = "url";
    private static final String TAG = "LaunchAction";

    public LaunchAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        String str = params.get("params");
        String str2 = params.get("from");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            ErrCode detail = new ErrCode().feature(1L).error(1L).detail("paramsValue is empty");
            Tracer.get().record(detail);
            LaunchError.showErrorDialog(context, detail);
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail.code())).source(str2).infoAdd(GetSwanHistoryAction.KEY_SCHEME, unitedSchemeEntity.getUri().toString()).infoAdd("detail", detail.details().toString()));
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString(PARAM_EXTRA_DATA_KEY);
            String optString4 = jSONObject.optString(PARAM_NAVI_KEY);
            String optString5 = jSONObject.optString(PARAM_DOWNLOAD_URL_KEY);
            String optString6 = jSONObject.optString("clkid");
            String optString7 = jSONObject.optString(PARAMS_NOT_IN_HISTORY_KEY);
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ErrCode detail2 = new ErrCode().feature(1L).error(1L).detail("appId is empty");
                Tracer.get().record(detail2);
                LaunchError.showErrorDialog(context, detail2);
                AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail2.code())).source(str2).infoAdd(GetSwanHistoryAction.KEY_SCHEME, unitedSchemeEntity.getUri().toString()).infoAdd("detail", detail2.details().toString()));
                return false;
            }
            AiAppsLaunchParams aiAppsLaunchParams = new AiAppsLaunchParams();
            aiAppsLaunchParams.mAppId = optString;
            aiAppsLaunchParams.mPage = optString2;
            aiAppsLaunchParams.mFrom = str2;
            aiAppsLaunchParams.mLaunchScheme = unitedSchemeEntity.getUri().toString();
            aiAppsLaunchParams.mClickId = optString6;
            aiAppsLaunchParams.mNotInHistory = optString7;
            if (aiApp != null && !TextUtils.isEmpty(optString4)) {
                if (!TextUtils.isEmpty(optString3)) {
                    aiAppsLaunchParams.putExtraData(PARAM_EXTRA_DATA_KEY, optString3);
                }
                aiAppsLaunchParams.putExtraData(PARAM_NAVI_KEY, optString4);
                aiAppsLaunchParams.putExtraData(PARAM_SOURCE_KEY, aiApp.getLaunchInfo().mAppId);
                aiAppsLaunchParams.putExtraData(PARAM_PAGE_KEY, getCurAiAppPage());
            }
            if (TextUtils.isEmpty(optString5)) {
                aiAppsLaunchParams.mIsDebug = false;
                Intent createLaunchParamsIntent = AiAppsLaunchParams.createLaunchParamsIntent(context, aiAppsLaunchParams);
                createLaunchParamsIntent.addFlags(268435456);
                context.startActivity(createLaunchParamsIntent);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            ErrCode detail3 = new ErrCode().feature(1L).error(1L).detail("release but downloadUrl is not empty");
            Tracer.get().record(detail3);
            LaunchError.showErrorDialog(context, detail3);
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail3.code())).source(str2).appId(optString).infoAdd(GetSwanHistoryAction.KEY_SCHEME, unitedSchemeEntity.getUri().toString()).infoAdd("detail", detail3.details().toString()));
            return false;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            ErrCode detail4 = new ErrCode().feature(1L).error(1L).detail("parse paramsValue with JSONException:" + e.getMessage());
            Tracer.get().record(detail4);
            LaunchError.showErrorDialog(context, detail4);
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail4.code())).source(str2).infoAdd(GetSwanHistoryAction.KEY_SCHEME, unitedSchemeEntity.getUri().toString()).infoAdd("detail", detail4.details().toString()));
            return false;
        }
    }

    private String getCurAiAppPage() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null || aiAppsFragmentManager.getTopAiAppsFragment() == null) {
            return "";
        }
        return aiAppsFragmentManager.getTopAiAppsFragment().getCurPage();
    }
}
