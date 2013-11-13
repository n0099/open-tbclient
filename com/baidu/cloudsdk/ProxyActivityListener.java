package com.baidu.cloudsdk;

import android.app.Activity;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ProxyActivityListener implements IBaiduListener {

    /* renamed from: a  reason: collision with root package name */
    private Activity f831a;
    private IBaiduListener b;

    public ProxyActivityListener(Activity activity, IBaiduListener iBaiduListener) {
        this.f831a = activity;
        this.b = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.f831a.finish();
        if (this.b != null) {
            this.b.onCancel();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.f831a.finish();
        if (this.b != null) {
            this.b.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        this.f831a.finish();
        if (this.b != null) {
            this.b.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.f831a.finish();
        if (this.b != null) {
            this.b.onComplete(jSONObject);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.f831a.finish();
        if (this.b != null) {
            this.b.onError(baiduException);
        }
    }
}
