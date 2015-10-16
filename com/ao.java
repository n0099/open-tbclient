package com;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.BaseConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ao extends JsonHttpResponseHandler {
    final /* synthetic */ IBaiduListener a;
    final /* synthetic */ String b;
    final /* synthetic */ BaseConfig dsz;

    public ao(BaseConfig baseConfig, IBaiduListener iBaiduListener, String str) {
        this.dsz = baseConfig;
        this.a = iBaiduListener;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.a.onError(new BaiduException(th));
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.a.onError(new BaiduException("Load config from server failed, url: " + this.b));
            return;
        }
        this.dsz.a(jSONObject);
        this.a.onComplete(jSONObject);
    }
}
