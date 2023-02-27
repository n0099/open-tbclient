package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes2.dex */
public class QQSSOLoginActivity extends QQOauthLoginActivity {
    public static final String r = "QQSSOLoginActivity";

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.a.a.a
    public void a() {
        if (((BaseSSOLoginActivity) this).f) {
            b(4001);
            finish();
            return;
        }
        a(((BaseSSOLoginActivity) this).g);
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
        if (((BaseSSOLoginActivity) this).f) {
            Intent intent = new Intent();
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, str);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_UNION_ID, str3);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.QQ_SSO.getType()));
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "qzone");
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().qqAppID);
            a(4001, intent);
            finish();
            return;
        }
        a(ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3), "授权QQ账号登录中");
    }

    @Override // com.baidu.sapi2.activity.social.QQOauthLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (((BaseSSOLoginActivity) this).f && i == 11101 && i2 == 0) {
            b(4001);
            finish();
        }
    }
}
