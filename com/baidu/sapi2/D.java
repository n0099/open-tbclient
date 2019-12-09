package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.OAuthResult;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class D extends HttpHandlerWrap {
    final /* synthetic */ SapiCallback a;
    final /* synthetic */ OAuthResult b;
    final /* synthetic */ G c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(G g, Looper looper, SapiCallback sapiCallback, OAuthResult oAuthResult) {
        super(looper);
        this.c = g;
        this.a = sapiCallback;
        this.b = oAuthResult;
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
            if (parseInt != 0) {
                this.a.onFailure(this.b);
            } else {
                this.b.accessToken = jSONObject.optString("access_token");
                this.b.expiresIn = jSONObject.optInt("expires_in");
                this.b.scope = jSONObject.optString("scope");
                this.b.refreshToken = jSONObject.optString(Oauth2AccessToken.KEY_REFRESH_TOKEN);
                this.b.sessionKey = jSONObject.optString("session_key");
                this.b.sessionSecret = jSONObject.optString("session_secret");
                this.b.extra = str;
                this.b.openid = jSONObject.optString("openid");
                this.a.onSuccess(this.b);
            }
        } catch (Throwable th) {
            this.b.setResultCode(-202);
            this.a.onFailure(this.b);
        }
    }
}
