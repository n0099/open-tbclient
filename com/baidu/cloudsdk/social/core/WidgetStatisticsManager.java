package com.baidu.cloudsdk.social.core;

import android.content.Context;
import android.util.Log;
import com.aq;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.CommonParam;
import com.baidu.cloudsdk.common.util.CoordinateManager;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public abstract class WidgetStatisticsManager {
    protected String mClientId;
    protected Context mContext;

    public WidgetStatisticsManager(Context context, String str) {
        Validator.notNull(context, "context");
        Validator.notNullOrEmpty(str, "clientId");
        this.mContext = context.getApplicationContext();
        this.mClientId = str;
    }

    protected static String getWidgetName() {
        return TbConfig.TMP_SHARE_DIR_NAME;
    }

    protected static String getWidgetVersion() {
        return "2.2.0";
    }

    protected static String getWidgetVersionFlag() {
        return "i";
    }

    public static void setCommonParams(Context context, RequestParams requestParams) {
        Validator.notNull(requestParams, "params");
        requestParams.put(SocialConstants.PARAM_CUID, CommonParam.getCUID(context));
        requestParams.put(SocialConstants.PARAM_CUA, CommonParam.getUA(context, getWidgetName(), getWidgetVersionFlag(), getWidgetVersion()));
        requestParams.put(SocialConstants.PARAM_CUT, CommonParam.getDeviceInfo());
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                requestParams.put(SocialConstants.PARAM_CRD, new CoordinateManager(context).getCrd());
            }
        } catch (Exception e) {
            Log.e("WidgetStatisticsManager", "ex " + e.getMessage());
        }
    }

    public void setWidgetActivated() {
        WidgetPreferenceManager widgetPreferenceManager = new WidgetPreferenceManager(this.mContext);
        String widgetName = getWidgetName();
        if (widgetPreferenceManager.isWidgetActivated(widgetName)) {
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.put("client_id", this.mClientId);
        setCommonParams(this.mContext, requestParams);
        new AsyncHttpClient().post(null, "http://openapi.baidu.com/social/api/statistics/activate_widget", requestParams, new aq(this, widgetPreferenceManager, widgetName));
    }
}
