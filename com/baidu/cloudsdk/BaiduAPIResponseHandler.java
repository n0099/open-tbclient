package com.baidu.cloudsdk;

import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BaiduAPIResponseHandler extends JsonHttpResponseHandler {
    protected IBaiduListener mListener;
    protected MediaType mMediaType;
    protected String mUrl;

    public BaiduAPIResponseHandler(MediaType mediaType, String str, IBaiduListener iBaiduListener) {
        this(str, iBaiduListener);
        this.mMediaType = mediaType;
    }

    public BaiduAPIResponseHandler(String str, IBaiduListener iBaiduListener) {
        this.mUrl = str;
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
                if (this.mMediaType != null && !TextUtils.isEmpty(this.mMediaType.toString()) && jSONObject != null) {
                    try {
                        jSONObject.put("mediatype", this.mMediaType);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mListener.onComplete(jSONObject);
                return;
            }
            return;
        }
        try {
            int i = jSONObject.getInt(SocialConstants.PARAM_ERROR_CODE);
            if (this.mMediaType != null && !TextUtils.isEmpty(this.mMediaType.toString())) {
                jSONObject.put("mediatype", this.mMediaType);
            }
            if (this.mListener != null) {
                this.mListener.onError(new BaiduException(i, jSONObject.toString()));
            }
        } catch (JSONException e2) {
            if (this.mListener != null) {
                this.mListener.onError(new BaiduException("response format for " + this.mUrl + " invalid"));
            }
        }
    }
}
