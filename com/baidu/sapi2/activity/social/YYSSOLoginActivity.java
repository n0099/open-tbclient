package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.tieba.lpa;
import com.baidu.tieba.mpa;
import com.baidu.tieba.npa;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class YYSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String q = "YYSSOLoginActivity";
    public npa n;
    public String o;
    public lpa p = new a();

    /* loaded from: classes2.dex */
    public class a implements lpa {
        public a() {
        }

        @Override // com.baidu.tieba.lpa
        public void onCancel() {
            Log.d(YYSSOLoginActivity.q, "YY授权登录 已取消");
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).g, -1000, AbstractThirdPartyService.RESULT_AUTH_CANCEL_MSG);
        }

        @Override // com.baidu.tieba.lpa
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
            yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).g, -1, "未知错误");
        }

        @Override // com.baidu.tieba.lpa
        public void onError(mpa mpaVar) {
            Log.d(YYSSOLoginActivity.q, "onError " + mpaVar.a + " " + mpaVar.b);
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(((BaseSSOLoginActivity) yYSSOLoginActivity).g, mpaVar.a, mpaVar.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a(ParamsUtil.getUrlYYLogin(this.o, SapiAccountManager.getInstance().getConfignation()), "授权YY账号登录中");
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText("YY授权登录");
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.n.c(i, i2, intent, this.p);
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && !TextUtils.isEmpty(confignation.yyAppId)) {
            try {
                npa b = npa.b(getApplicationContext(), confignation.yyAppId);
                this.n = b;
                b.a(this, this.p);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        a(((BaseSSOLoginActivity) this).g, -10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_MSG);
    }
}
