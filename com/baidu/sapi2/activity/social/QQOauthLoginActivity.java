package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.tencent.connect.UnionInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QQOauthLoginActivity extends BaseSSOLoginActivity implements com.baidu.sapi2.a.a.a {
    public static final String p = "QQOauthLoginActivity";
    public static final String q = "QQ未安装";
    public IUiListener n;
    public ThirdLoginCallback o;

    /* loaded from: classes3.dex */
    public class a implements IUiListener {
        public final /* synthetic */ Tencent a;
        public final /* synthetic */ com.baidu.sapi2.a.a.a b;

        public a(Tencent tencent, com.baidu.sapi2.a.a.a aVar) {
            this.a = tencent;
            this.b = aVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.b.a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    String optString = jSONObject.optString("access_token");
                    String optString2 = jSONObject.optString("expires_in");
                    String optString3 = jSONObject.optString("openid");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        this.a.setAccessToken(optString, optString2);
                        this.a.setOpenId(optString3);
                        QQOauthLoginActivity.this.a(this.a, this.b);
                        return;
                    }
                    this.b.a();
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            this.b.a();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements IUiListener {
        public final /* synthetic */ com.baidu.sapi2.a.a.a a;
        public final /* synthetic */ Tencent b;

        public b(com.baidu.sapi2.a.a.a aVar, Tencent tencent) {
            this.a = aVar;
            this.b = tencent;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.a.a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj != null) {
                this.a.a(this.b.getAccessToken(), this.b.getOpenId(), ((JSONObject) obj).optString("unionid"));
                return;
            }
            this.a.a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            this.a.a();
        }
    }

    /* JADX DEBUG: Possible override for method com.baidu.sapi2.activity.BaseActivity.a()Lcom/baidu/sapi2/callback/ActivityResultCallback; */
    @Override // com.baidu.sapi2.a.a.a
    public void a() {
        Log.d(p, "onAuthFailure");
        ThirdLoginCallback thirdLoginCallback = this.o;
        if (thirdLoginCallback != null) {
            thirdLoginCallback.onAuthFailure(-100, "QQ授权失败");
        }
        finish();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.o = ThirdPartyService.getThirdLoginCallback();
        ThirdPartyService.releaseThirdLoginCallback();
        try {
            a((com.baidu.sapi2.a.a.a) this);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    private void a(com.baidu.sapi2.a.a.a aVar) {
        if (aVar == null) {
            return;
        }
        Tencent createInstance = Tencent.createInstance(this.configuration.qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this.configuration.context, q, 0).show();
            aVar.a();
            return;
        }
        a aVar2 = new a(createInstance, aVar);
        this.n = aVar2;
        createInstance.login(this, "all", aVar2);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Tencent tencent, com.baidu.sapi2.a.a.a aVar) {
        if (tencent != null && tencent.isSessionValid()) {
            new UnionInfo(this, tencent.getQQToken()).getUnionId(new b(aVar, tencent));
        } else {
            aVar.a();
        }
    }

    @Override // com.baidu.sapi2.a.a.a
    public void a(String str, String str2, String str3) {
        Log.d(p, "onAuthSuccess");
        String urlQQBind = ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3);
        ThirdLoginCallback thirdLoginCallback = this.o;
        if (thirdLoginCallback != null) {
            thirdLoginCallback.onAuthSuccess();
        }
        com.baidu.sapi2.activity.social.a.a().a(urlQQBind, this.o);
        finish();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d(p, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
        if (i == 11101 || i == 10102) {
            Tencent.onActivityResultData(i, i2, intent, this.n);
        }
    }
}
