package com.baidu.searchbox.ng.ai.apps.scheme.intercept;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.searchbox.ng.ai.apps.util.AiAppActivityUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsLaunchInterceptor extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = false;
    private static final Set<String> DEL_PARAMS_SET = new HashSet();
    private static final String LAUNCH_INTERCEPTOR_NAME = "aiapps_launch_interceptor";
    private static final String LAUNCH_INTERNAL_PARAMS_KEY = "_baiduboxapp";
    private static final String LAUNCH_SCHEME_HOST = "swan";
    private static final String PARAM_SEARCH_ID = "searchid";
    private static final String PARAM_SEARCH_URL = "url";
    private static final String QUERY_SEPARATOR = "?";
    private static final String TAG = "AiAppsLaunchInterceptor";

    static {
        DEL_PARAMS_SET.add("_baiduboxapp");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return LAUNCH_INTERCEPTOR_NAME;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f6  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str;
        JSONObject optJSONObject;
        String str2 = null;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String appId = getAppId(uri);
        if (TextUtils.isEmpty(appId)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            ErrCode detail = new ErrCode().feature(1L).error(1L).detail("appId is empty");
            Tracer.get().record(detail);
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail.code())).infoAdd(GetSwanHistoryAction.KEY_SCHEME, uri.toString()).infoAdd("detail", detail.details().toString()));
            return true;
        }
        String pagePath = getPagePath(appId, uri);
        String query = getQuery(uri);
        AiAppsLaunchParams aiAppsLaunchParams = new AiAppsLaunchParams();
        aiAppsLaunchParams.mAppId = appId;
        aiAppsLaunchParams.mLaunchScheme = uri.toString();
        if (!TextUtils.isEmpty(pagePath)) {
            aiAppsLaunchParams.mPage = pagePath + QUERY_SEPARATOR + query;
        }
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aiAppsLaunchParams.mFrom = jSONObject.optString("from");
                optJSONObject = jSONObject.optJSONObject("ext");
            } catch (JSONException e) {
                str = null;
            }
            if (optJSONObject != null) {
                str = optJSONObject.optString("searchid");
                try {
                    str2 = optJSONObject.optString("url");
                } catch (JSONException e2) {
                }
                if (!TextUtils.isEmpty(str)) {
                    aiAppsLaunchParams.requireExtraData().putString(AiAppsSearchFlowUBC.EXTRA_SEARCH_ID, str);
                    aiAppsLaunchParams.requireExtraData().putString(AiAppsSearchFlowUBC.EXTRA_SEARCH_URL, str2);
                    aiAppsLaunchParams.requireExtraData().putLong(AiAppsSearchFlowUBC.EXTRA_SEARCH_DOM_CLICK_TIMESTAMP, System.currentTimeMillis());
                    AiAppsSearchFlowUBC.recordFromLaunch(aiAppsLaunchParams);
                }
                AiAppActivityUtils.startActivitySafely(context, AiAppsLaunchParams.createLaunchParamsIntent(context, aiAppsLaunchParams));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
        AiAppActivityUtils.startActivitySafely(context, AiAppsLaunchParams.createLaunchParamsIntent(context, aiAppsLaunchParams));
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }

    private String getAppId(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return null;
        }
        return pathSegments.get(0);
    }

    private String getPagePath(String str, Uri uri) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        if (substring.endsWith(File.separator)) {
            return substring.substring(0, substring.length() - 1);
        }
        return substring;
    }

    private String getQuery(Uri uri) {
        return AiAppsUrlUtils.deleteQueryParam(uri.getQuery(), DEL_PARAMS_SET);
    }

    private String getLaunchFrom(UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param)) {
            return null;
        }
        try {
            return new JSONObject(param).optString("from");
        } catch (JSONException e) {
            return null;
        }
    }
}
