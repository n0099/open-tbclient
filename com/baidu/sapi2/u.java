package com.baidu.sapi2;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class u extends HttpHandlerWrap {
    final /* synthetic */ com.baidu.sapi2.callback.a.a a;
    final /* synthetic */ com.baidu.sapi2.result.a.a b;
    final /* synthetic */ G c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(G g, boolean z, com.baidu.sapi2.callback.a.a aVar, com.baidu.sapi2.result.a.a aVar2) {
        super(z);
        this.c = g;
        this.a = aVar;
        this.b = aVar2;
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
                this.b.a = jSONObject.optInt("push", 0) == 1;
                this.b.b = jSONObject.optString("url");
                this.b.c = jSONObject.optString("title");
                this.b.d = jSONObject.optString("msg");
                this.b.e = jSONObject.optInt("interval", 5);
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
