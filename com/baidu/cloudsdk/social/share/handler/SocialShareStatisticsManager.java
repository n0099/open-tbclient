package com.baidu.cloudsdk.social.share.handler;

import android.content.Context;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.WidgetStatisticsManager;
import com.baidu.cloudsdk.social.share.ShareContent;
/* loaded from: classes.dex */
public class SocialShareStatisticsManager extends WidgetStatisticsManager {

    /* renamed from: a  reason: collision with root package name */
    private static SocialShareStatisticsManager f854a;

    private SocialShareStatisticsManager(Context context) {
        super(context, SocialConfig.getInstance(context).getClientId(MediaType.BAIDU));
    }

    public static SocialShareStatisticsManager getInstance(Context context) {
        if (f854a == null) {
            f854a = new SocialShareStatisticsManager(context);
        }
        return f854a;
    }

    public void getBackUrl(String str, String str2, HttpResponseHandler httpResponseHandler) {
        Validator.notNullOrEmpty(str, SocialConstants.PARAM_URL);
        Validator.notNullOrEmpty(str2, "mediatype");
        Validator.notNull(httpResponseHandler, "listener");
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.mClientId);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, str2);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        requestParams.put(SocialConstants.PARAM_URL, str);
        setCommonParams(requestParams);
        new AsyncHttpClient().get(null, "http://openapi.baidu.com/social/api/2.0/share/back/url", requestParams, httpResponseHandler);
    }

    @Override // com.baidu.cloudsdk.social.core.WidgetStatisticsManager
    protected String getWidgetName() {
        return "share";
    }

    @Override // com.baidu.cloudsdk.social.core.WidgetStatisticsManager
    protected String getWidgetVersion() {
        return "2.1.0";
    }

    @Override // com.baidu.cloudsdk.social.core.WidgetStatisticsManager
    protected String getWidgetVersionFlag() {
        return "i";
    }

    public void statistics(MediaType mediaType, ShareContent shareContent) {
        statistics(mediaType.toString(), shareContent);
    }

    public void statistics(String str, ShareContent shareContent) {
        Validator.notNullOrEmpty(str, "mediaType");
        Validator.notNull(shareContent, "content");
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_CLIENT_ID, this.mClientId);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, str);
        requestParams.put(SocialConstants.PARAM_URL, shareContent.getLinkUrl());
        setCommonParams(requestParams);
        new AsyncHttpClient().get(null, "http://openapi.baidu.com/social/api/2.0/share/statistics", requestParams, null);
    }
}
