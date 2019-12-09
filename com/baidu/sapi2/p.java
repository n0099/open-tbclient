package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.shell.response.SocialResponse;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p extends HttpHandlerWrap {
    final /* synthetic */ IqiyiLoginCallback a;
    final /* synthetic */ IqiyiLoginResult b;
    final /* synthetic */ G c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(G g, Looper looper, IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginResult iqiyiLoginResult) {
        super(looper);
        this.c = g;
        this.a = iqiyiLoginCallback;
        this.b = iqiyiLoginResult;
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        SapiConfiguration sapiConfiguration;
        SapiConfiguration sapiConfiguration2;
        if (this.c.b(str) != 302) {
            sapiConfiguration = this.c.c;
            SocialResponse b = SapiWebView.b(str, sapiConfiguration.context);
            if (b == null) {
                this.b.setResultCode(-100);
                this.b.setResultMsg("登录失败");
                this.a.onFailure(this.b);
                return;
            } else if (b.errorCode != -100) {
                this.b.setResultCode(-100);
                this.b.setResultMsg("登录失败");
                this.a.onFailure(this.b);
                return;
            } else {
                SapiAccount a = this.c.a(b);
                a.addSocialInfo(b.socialType, b.socialPortraitUrl);
                a.putExtra("account_type", Integer.valueOf(b.accountType.getType()));
                a.addDispersionCertification(b.tplStokenMap);
                a.addIsGuestAccount(b.isGuestAccount);
                sapiConfiguration2 = this.c.c;
                a.putExtra(TableDefine.PaSubscribeColumns.COLUMN_TPL, sapiConfiguration2.tpl);
                SapiShareClient.getInstance().validate(a);
                this.a.onSuccess(this.b);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.nextUrl = jSONObject.optString("next_url");
            this.a.onBindWebview(this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
