package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class r extends HttpHandlerWrap {
    final /* synthetic */ SapiCallback a;
    final /* synthetic */ CheckUserFaceIdResult b;
    final /* synthetic */ G c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(G g, Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult) {
        super(looper);
        this.c = g;
        this.a = sapiCallback;
        this.b = checkUserFaceIdResult;
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
            this.b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
            if (parseInt == 0) {
                this.b.status = jSONObject.optInt("status");
                this.b.livingUname = jSONObject.optString("livinguname");
                this.b.authsid = jSONObject.optString("authsid");
                this.b.authWidgetURL = jSONObject.optString("authurl");
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
