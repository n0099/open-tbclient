package com.baidu.cloudsdk;

import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BaiduAPIResponseHandler extends JsonHttpResponseHandler {
    protected IBaiduListener mListener;
    protected String mUrl;

    public BaiduAPIResponseHandler(String str, IBaiduListener iBaiduListener) {
        this.mListener = iBaiduListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        if (this.mListener != null) {
            this.mListener.onError(new BaiduException(th));
        }
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONArray jSONArray) {
        if (this.mListener != null) {
            this.mListener.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        if (!jSONObject.has(SocialConstants.PARAM_ERROR_CODE)) {
            if (this.mListener != null) {
                this.mListener.onComplete(jSONObject);
                return;
            }
            return;
        }
        try {
            int i = jSONObject.getInt(SocialConstants.PARAM_ERROR_CODE);
            String string = jSONObject.getString("error_msg");
            if (this.mListener != null) {
                this.mListener.onError(new BaiduException(i, string));
            }
        } catch (JSONException e) {
            if (this.mListener != null) {
                this.mListener.onError(new BaiduException("response format for " + this.mUrl + " invalid"));
            }
        }
    }
}
