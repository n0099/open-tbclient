package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s extends HttpHandlerWrap {
    final /* synthetic */ SapiCallback a;
    final /* synthetic */ FaceLoginStatusResult b;
    final /* synthetic */ G c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(G g, Looper looper, SapiCallback sapiCallback, FaceLoginStatusResult faceLoginStatusResult) {
        super(looper);
        this.c = g;
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
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.b.setResultCode(parseInt);
            this.b.setResultMsg(jSONObject.optString("errmsg"));
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
