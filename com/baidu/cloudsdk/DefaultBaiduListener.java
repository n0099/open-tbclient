package com.baidu.cloudsdk;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DefaultBaiduListener implements IBaiduListener {
    protected IBaiduListener mListener;

    public DefaultBaiduListener() {
        this.mListener = null;
    }

    public DefaultBaiduListener(IBaiduListener iBaiduListener) {
        this.mListener = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        if (this.mListener != null) {
            this.mListener.onCancel();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        if (this.mListener != null) {
            this.mListener.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        if (this.mListener != null) {
            this.mListener.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        if (this.mListener != null) {
            this.mListener.onComplete(jSONObject);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        if (this.mListener != null) {
            this.mListener.onError(baiduException);
        }
    }
}
