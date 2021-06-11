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
/* loaded from: classes2.dex */
public class QQOauthLoginActivity extends BaseSSOLoginActivity implements com.baidu.sapi2.a.a.a {
    public static final String o = "QQOauthLoginActivity";
    public static final String p = "QQ未安装";
    public IUiListener n;

    /* loaded from: classes2.dex */
    public class a implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Tencent f9806a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.baidu.sapi2.a.a.a f9807b;

        public a(Tencent tencent, com.baidu.sapi2.a.a.a aVar) {
            this.f9806a = tencent;
            this.f9807b = aVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f9807b.a();
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
                        this.f9806a.setAccessToken(optString, optString2);
                        this.f9806a.setOpenId(optString3);
                        QQOauthLoginActivity.this.a(this.f9806a, this.f9807b);
                        return;
                    }
                    this.f9807b.a();
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            this.f9807b.a();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.sapi2.a.a.a f9809a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Tencent f9810b;

        public b(com.baidu.sapi2.a.a.a aVar, Tencent tencent) {
            this.f9809a = aVar;
            this.f9810b = tencent;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f9809a.a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj != null) {
                this.f9809a.a(this.f9810b.getAccessToken(), this.f9810b.getOpenId(), ((JSONObject) obj).optString("unionid"));
                return;
            }
            this.f9809a.a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            this.f9809a.a();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Log.d(o, "requestCode = " + i2 + " resultCode = " + i3 + " data = " + intent);
        if (i2 == 11101 || i2 == 10102) {
            Tencent.onActivityResultData(i2, i3, intent, this.n);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        a((com.baidu.sapi2.a.a.a) this);
    }

    private void a(com.baidu.sapi2.a.a.a aVar) {
        if (aVar == null) {
            return;
        }
        Tencent createInstance = Tencent.createInstance(this.configuration.qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this.configuration.context, p, 0).show();
            aVar.a();
            return;
        }
        a aVar2 = new a(createInstance, aVar);
        this.n = aVar2;
        createInstance.login(this, "all", aVar2);
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
    public void a() {
        Log.d(o, "onAuthFailure");
        ThirdLoginCallback thirdLoginCallback = ThirdPartyService.getThirdLoginCallback();
        if (thirdLoginCallback != null) {
            thirdLoginCallback.onAuthFailure(-100, "QQ授权失败");
        }
        ThirdPartyService.releaseThirdLoginCallback();
        finish();
    }

    @Override // com.baidu.sapi2.a.a.a
    public void a(String str, String str2, String str3) {
        Log.d(o, "onAuthSuccess");
        String urlQQBind = ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3);
        ThirdLoginCallback thirdLoginCallback = ThirdPartyService.getThirdLoginCallback();
        if (thirdLoginCallback != null) {
            thirdLoginCallback.onAuthSuccess();
        }
        com.baidu.sapi2.activity.social.a.a().a(urlQQBind, thirdLoginCallback);
        finish();
    }
}
