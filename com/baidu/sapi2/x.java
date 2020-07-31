package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class x extends HttpHandlerWrap {
    final /* synthetic */ SapiCallback a;
    final /* synthetic */ SapiResult b;
    final /* synthetic */ L c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(L l, Looper looper, SapiCallback sapiCallback, SapiResult sapiResult) {
        super(looper);
        this.c = l;
        this.a = sapiCallback;
        this.b = sapiResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        this.b.setResultCode(i);
        this.b.setResultMsg(str);
        this.a.onFailure(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFinish() {
        this.a.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onStart() {
        this.a.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.setResultCode(jSONObject.optInt(BaseJsonData.TAG_ERRNO));
            this.b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
        } catch (JSONException e) {
            Log.e(e);
        }
        if (this.b.getResultCode() == 0) {
            this.a.onSuccess(this.b);
        } else {
            this.a.onFailure(this.b);
        }
    }
}
