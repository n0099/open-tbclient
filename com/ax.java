package com;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.SocialOAuthStatisticsManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class ax extends av {
    private AsyncHttpClient a;
    protected a mAPIResponseHandler;

    /* loaded from: classes.dex */
    class a extends JsonHttpResponseHandler {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            ax.this.startAuthDialog();
        }

        @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
        protected void onSuccess(JSONArray jSONArray) {
            if (ax.this.mListener != null) {
                ax.this.mListener.onComplete(jSONArray);
            }
        }

        @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
        protected void onSuccess(JSONObject jSONObject) {
            if (!jSONObject.has(SocialConstants.PARAM_ERROR_CODE)) {
                if (ax.this.mListener != null) {
                    ax.this.mListener.onComplete(jSONObject);
                    return;
                }
                return;
            }
            try {
                onFailure(new BaiduException(jSONObject.getInt(SocialConstants.PARAM_ERROR_CODE), jSONObject.getString(SocialConstants.PARAM_ERROR_MSG)), jSONObject.toString());
            } catch (JSONException e) {
                onFailure(e, jSONObject.toString());
            }
        }
    }

    public ax(SocialOAuthActivity socialOAuthActivity, String str, String str2, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, str2, iBaiduListener);
        this.a = new AsyncHttpClient();
        this.mAPIResponseHandler = new a();
    }

    protected abstract Intent getIntentForSSO();

    protected abstract int getSSORequestCode();

    protected abstract String getSSOSignatureHash();

    /* JADX INFO: Access modifiers changed from: protected */
    public void getSessionFromServer(String str, String str2, String str3) {
        RequestParams requestParams = new RequestParams();
        requestParams.put(SocialConstants.PARAM_GRANT_TYPE, "media_token");
        requestParams.put("media_token", str);
        requestParams.put(SocialConstants.PARAM_MEDIA_UID, str2);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, str3);
        requestParams.put("client_id", this.mClientId);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        SocialOAuthStatisticsManager.setCommonParams(this.mActivity, requestParams);
        this.a.post(this.mActivity, "https://openapi.baidu.com/social/oauth/2.0/token", requestParams, this.mAPIResponseHandler);
    }

    @Override // com.av
    public void onDestroy() {
        this.a.cancelRequests(this.mActivity, true);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean startSingleSignOn() {
        Intent intentForSSO = getIntentForSSO();
        if (validateAppSignature(intentForSSO, getSSOSignatureHash())) {
            try {
                this.mActivity.startActivityForResult(intentForSSO, getSSORequestCode());
                this.mActivity.a();
                return true;
            } catch (ActivityNotFoundException e) {
                return false;
            }
        }
        return false;
    }

    protected boolean validateAppSignature(Intent intent, String str) {
        PackageManager packageManager = this.mActivity.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            for (Signature signature : signatureArr) {
                if (str.equals(Utils.md5(signature.toCharsString()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
