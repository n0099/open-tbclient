package com.baidu.cloudsdk;

import android.app.Activity;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ProxyActivityListener implements IBaiduListener {
    private Activity a;
    private IBaiduListener b;

    public ProxyActivityListener(Activity activity, IBaiduListener iBaiduListener) {
        this.a = activity;
        this.b = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.a.finish();
        if (this.b != null) {
            this.b.onCancel();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.a.finish();
        if (this.b != null) {
            this.b.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        this.a.finish();
        if (this.b != null) {
            this.b.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.a.finish();
        if (this.b != null) {
            this.b.onComplete(jSONObject);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.a.finish();
        if (this.b != null) {
            this.b.onError(baiduException);
        }
    }
}
