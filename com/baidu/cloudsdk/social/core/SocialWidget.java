package com.baidu.cloudsdk.social.core;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Validator;
/* loaded from: classes.dex */
public abstract class SocialWidget {

    /* renamed from: a  reason: collision with root package name */
    private static final String f835a = SocialWidget.class.getName();
    protected String mClientId;
    public Context mContext;

    public SocialWidget(Context context) {
        this(context, SocialConfig.getInstance(context).getClientId(MediaType.BAIDU));
    }

    protected SocialWidget(Context context, String str) {
        Validator.notNull(context, "context");
        Validator.notNullOrEmpty(str, "clientId");
        this.mContext = context;
        this.mClientId = str;
        getWidgetStatisticsManager().setWidgetActivated();
    }

    private void a(String str) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_BDUSS, str);
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.mClientId);
        requestParams.put(SocialConstants.PARAM_GRANT_TYPE, SocialConstants.PARAM_BDUSS);
        new AsyncHttpClient().post(null, "https://openapi.baidu.com/social/oauth/2.0/token", requestParams, new p(this));
    }

    public String getClientId() {
        return this.mClientId;
    }

    public Context getContext() {
        return this.mContext;
    }

    protected abstract WidgetStatisticsManager getWidgetStatisticsManager();

    public void onLoginStatusChanged(String str) {
        SessionManager.getInstance(this.mContext).removeAll();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str);
    }

    public SocialWidget setClientId(String str) {
        this.mClientId = str;
        return this;
    }

    public SocialWidget setContext(Context context) {
        Validator.notNull(context, "context");
        this.mContext = context;
        return this;
    }
}
