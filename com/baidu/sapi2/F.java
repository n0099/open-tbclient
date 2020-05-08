package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.GetUserInfoResult;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class F extends HttpHandlerWrap {
    final /* synthetic */ GetUserInfoCallback a;
    final /* synthetic */ GetUserInfoResult b;
    final /* synthetic */ L c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(L l, Looper looper, GetUserInfoCallback getUserInfoCallback, GetUserInfoResult getUserInfoResult) {
        super(looper);
        this.c = l;
        this.a = getUserInfoCallback;
        this.b = getUserInfoResult;
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
        int b = this.c.b(str);
        this.b.setResultCode(b);
        if (b != 0) {
            if (b != 400021) {
                this.a.onFailure(this.b);
                return;
            } else {
                this.a.onBdussExpired(this.b);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.portraitSign = jSONObject.optString("portrait_tag");
            this.b.isInitialPortrait = "0".equals(this.b.portraitSign);
            String optString = jSONObject.optString("portrait");
            if (!TextUtils.isEmpty(optString)) {
                this.b.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.b.portraitSign);
                this.b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.b.portraitSign);
            }
            this.b.username = jSONObject.optString("username");
            this.b.uid = jSONObject.optString("userid");
            this.b.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
            this.b.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
            this.b.secureMobile = jSONObject.optString("securemobil");
            this.b.secureEmail = jSONObject.optString("secureemail");
            this.b.havePwd = "1".equals(jSONObject.optString("have_psw"));
            this.b.carSdkFace = jSONObject.optInt("carSdkFace");
            this.b.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
            this.a.onSuccess(this.b);
        } catch (Exception e) {
            this.a.onFailure(this.b);
        }
    }
}
