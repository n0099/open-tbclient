package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import d.r.b.b;
import d.r.b.d;
import d.r.b.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class YYSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String q = "YYSSOLoginActivity";
    public e n;
    public String o;
    public b p = new a();

    /* loaded from: classes2.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.r.b.b
        public void onCancel() {
            Log.d(YYSSOLoginActivity.q, "YY授权登录 已取消");
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).f9811g, -1000, AbstractThirdPartyService.RESULT_AUTH_CANCEL_MSG);
        }

        @Override // d.r.b.b
        public void onComplete(JSONObject jSONObject) {
            Log.d(YYSSOLoginActivity.q, "onComplete " + jSONObject.toString());
            if (jSONObject != null) {
                if (jSONObject.has("access_code")) {
                    YYSSOLoginActivity.this.o = jSONObject.optString("access_code");
                } else if (jSONObject.has("token")) {
                    YYSSOLoginActivity.this.o = jSONObject.optString("token");
                }
            }
            if (!TextUtils.isEmpty(YYSSOLoginActivity.this.o)) {
                Log.d(YYSSOLoginActivity.q, "accessCode=" + YYSSOLoginActivity.this.o);
                YYSSOLoginActivity.this.d();
                return;
            }
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).f9811g, -1, "未知错误");
        }

        @Override // d.r.b.b
        public void onError(d dVar) {
            Log.d(YYSSOLoginActivity.q, "onError " + dVar.f71549a + " " + dVar.f71550b);
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).f9811g, dVar.f71549a, dVar.f71550b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a(ParamsUtil.getUrlYYLogin(this.o, SapiAccountManager.getInstance().getConfignation()), "授权YY账号登录中");
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.n.c(i2, i3, intent, this.p);
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && !TextUtils.isEmpty(confignation.yyAppId)) {
            e b2 = e.b(this, confignation.yyAppId);
            this.n = b2;
            b2.a(this, this.p);
            return;
        }
        a(((BaseSSOLoginActivity) this).f9811g, -10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_MSG);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText("YY授权登录");
    }
}
