package com.baidu.searchbox.ng.ai.apps.scheme.actions.route;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.ConsoleController;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.core.turbo.PageReadyEvent;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceTrace;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ActionUtils {
    public static final String BACK_TO_HOME_REQUEST = "backtohome";
    private static final boolean DEBUG = false;
    private static final int ERROR_NO_SUB_PACKAGE = 1001;
    public static final String PARAMS_KEY = "params";

    public static JSONObject buildRouteJSONData(String str) {
        return buildRouteJSONData(str, "");
    }

    public static JSONObject buildRouteJSONData(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("pageUrl", str2);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static JSONObject buildPagesRouteData(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            jSONObject.put("root", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("pageUrl", str3);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static void onPagesRouteSuccess(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, String str, String str2, String str3) {
        if (aiApp != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(buildPagesRouteData(str, aiApp.getPackageName(AiAppsUrlUtils.delAllParamsFromUrl(str2)), str2), 0).toString(), str3);
        }
    }

    public static void onPagesRouteFailed(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No SubPackage").toString(), str);
    }

    public static String parseUrlParams(UnitedSchemeEntity unitedSchemeEntity, String str) {
        String str2 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2).optString("url");
        } catch (JSONException e) {
            return null;
        }
    }

    public static void createAndLoadPage(AiAppsSlaveManager aiAppsSlaveManager, AiAppsPageParam aiAppsPageParam) {
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.ROUTE_TAG, "createAndLoadPage start.");
        String buildPageUrl = AiAppsUtils.buildPageUrl(aiAppsPageParam.mBaseUrl, aiAppsPageParam.mPage, aiAppsPageParam.mParams);
        WindowConfig pageWindowConfig = AiAppsController.getInstance().getPageWindowConfig(aiAppsPageParam.mPage);
        PageReadyEvent pageReadyEvent = new PageReadyEvent();
        pageReadyEvent.appPath = aiAppsPageParam.mBaseUrl;
        pageReadyEvent.pagePath = AiAppsPageParam.buildPageWithParams(aiAppsPageParam);
        pageReadyEvent.onReachBottomDistance = pageWindowConfig.mOnReachBottomDistance;
        pageReadyEvent.sConsole = String.valueOf(ConsoleController.isConsoleEnabled());
        AiAppsController.getInstance().sendJSMessage(aiAppsSlaveManager.getWebViewId(), PageReadyEvent.createPageReadyMessage(pageReadyEvent));
        AiAppsSlavePool.putSlaveManager(buildPageUrl, aiAppsSlaveManager);
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.ROUTE_TAG, "createAndLoadPage end.");
    }

    public static void dispatchRouteRequest(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage(str, hashMap));
    }
}
