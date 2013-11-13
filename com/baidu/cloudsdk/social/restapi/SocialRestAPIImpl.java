package com.baidu.cloudsdk.social.restapi;

import android.content.Context;
import com.baidu.cloudsdk.BaiduAPIResponseHandler;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.SessionManager;
/* loaded from: classes.dex */
public class SocialRestAPIImpl implements ISocialRestAPI {

    /* renamed from: a  reason: collision with root package name */
    private AsyncHttpClient f855a = new AsyncHttpClient();
    private Context b;

    public SocialRestAPIImpl(Context context) {
        this.b = context;
    }

    @Override // com.baidu.cloudsdk.social.restapi.ISocialRestAPI
    public void getUserInfo(String str, IBaiduListener iBaiduListener) {
        Validator.notNullOrEmpty(str, "mediatype");
        Validator.notNull(iBaiduListener, "baiduListener");
        RequestParams requestParams = new RequestParams();
        SessionManager.Session session = SessionManager.getInstance(this.b).get(str);
        if (session == null || session.isExpired()) {
            iBaiduListener.onError(new BaiduException("Invalid AccessToken"));
            return;
        }
        requestParams.put("access_token", session.getAccessToken());
        this.f855a.post(null, "https://openapi.baidu.com/social/api/2.0/user/info", requestParams, new BaiduAPIResponseHandler("https://openapi.baidu.com/social/api/2.0/user/info", iBaiduListener));
    }
}
