package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public class QQSSOLoginActivity extends QQOauthLoginActivity {
    public static final String q = "QQSSOLoginActivity";

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.a.a.a
    public void a() {
        if (((BaseSSOLoginActivity) this).f9810f) {
            b(3001);
            finish();
            return;
        }
        a(((BaseSSOLoginActivity) this).f9811g);
    }

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (((BaseSSOLoginActivity) this).f9810f && i2 == 11101 && i3 == 0) {
            b(3001);
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText("QQ帐号登录");
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.a.a.a
    public void a(String str, String str2, String str3) {
        if (((BaseSSOLoginActivity) this).f9810f) {
            Intent intent = new Intent();
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, str);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_UNION_ID, str3);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.QQ_SSO.getType()));
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "qzone");
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().qqAppID);
            a(3001, intent);
            finish();
            return;
        }
        a(ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3), "授权QQ账号登录中");
    }
}
