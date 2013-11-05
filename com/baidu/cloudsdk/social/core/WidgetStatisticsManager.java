package com.baidu.cloudsdk.social.core;

import android.content.Context;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.CommonParam;
import com.baidu.cloudsdk.common.util.CoordinateManager;
import com.baidu.cloudsdk.common.util.Validator;
/* loaded from: classes.dex */
public abstract class WidgetStatisticsManager {
    protected String mClientId;
    protected Context mContext;

    public WidgetStatisticsManager(Context context, String str) {
        Validator.notNull(context, "context");
        Validator.notNullOrEmpty(str, "clientId");
        this.mContext = context;
        this.mClientId = str;
    }

    protected abstract String getWidgetName();

    protected abstract String getWidgetVersion();

    protected abstract String getWidgetVersionFlag();

    public void setCommonParams(RequestParams requestParams) {
        Validator.notNull(requestParams, "params");
        requestParams.put(SocialConstants.PARAM_CUID, CommonParam.getCUID(this.mContext));
        requestParams.put(SocialConstants.PARAM_CUA, CommonParam.getUA(this.mContext, getWidgetName(), getWidgetVersionFlag(), getWidgetVersion()));
        requestParams.put(SocialConstants.PARAM_CUT, CommonParam.getDeviceInfo());
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            requestParams.put(SocialConstants.PARAM_CRD, CoordinateManager.getInstance(this.mContext).getCrd());
        }
    }

    public void setWidgetActivated() {
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.getInstance(this.mContext);
        String widgetName = getWidgetName();
        if (widgetPreferenceManager.isWidgetActivated(widgetName)) {
            return;
        }
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.mClientId);
        setCommonParams(requestParams);
        new AsyncHttpClient().post(null, "http://openapi.baidu.com/social/api/statistics/activate_widget", requestParams, new q(this, widgetPreferenceManager, widgetName));
    }
}
