package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class u extends HttpHandlerWrap {
    final /* synthetic */ SapiCallback a;
    final /* synthetic */ FaceLoginStatusResult b;
    final /* synthetic */ L c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(L l, Looper looper, SapiCallback sapiCallback, FaceLoginStatusResult faceLoginStatusResult) {
        super(looper);
        this.c = l;
        this.a = sapiCallback;
        this.b = faceLoginStatusResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        this.b.setResultCode(i);
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
            int parseInt = Integer.parseInt(jSONObject.optString(BaseJsonData.TAG_ERRNO));
            this.b.setResultCode(parseInt);
            this.b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
            if (parseInt == 0) {
                this.b.status = jSONObject.optInt("status");
                this.b.livingUname = jSONObject.optString("livinguname");
                this.b.authsid = jSONObject.optString("authsid");
                this.b.authWidgetURL = jSONObject.optString("authurl");
                this.b.faceLoginSwitch = jSONObject.optInt("faceLoginEnabled") == 1;
                this.a.onSuccess(this.b);
            } else {
                this.a.onFailure(this.b);
            }
        } catch (Throwable th) {
            this.b.setResultCode(-202);
            this.a.onFailure(this.b);
        }
    }
}
