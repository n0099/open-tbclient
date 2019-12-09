package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.share.face.FaceLoginService;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t extends HttpHandlerWrap {
    final /* synthetic */ SapiCallback a;
    final /* synthetic */ CheckUserFaceIdResult b;
    final /* synthetic */ boolean c;
    final /* synthetic */ G d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(G g, Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult, boolean z) {
        super(looper);
        this.d = g;
        this.a = sapiCallback;
        this.b = checkUserFaceIdResult;
        this.c = z;
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
        SapiConfiguration sapiConfiguration;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.b.setResultCode(parseInt);
            this.b.setResultMsg(jSONObject.optString("errmsg"));
            if (parseInt == 0) {
                if (this.c) {
                    String optString = jSONObject.optString("livinguname");
                    if (!TextUtils.isEmpty(optString)) {
                        FaceLoginService faceLoginService = new FaceLoginService();
                        sapiConfiguration = this.d.c;
                        faceLoginService.syncFaceLoginUID(sapiConfiguration.context, optString);
                    }
                }
                this.a.onSuccess(this.b);
                return;
            }
            this.a.onFailure(this.b);
        } catch (Throwable th) {
            this.b.setResultCode(-202);
            this.a.onFailure(this.b);
        }
    }
}
