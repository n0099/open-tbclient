package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class WXLoginActivity extends BaseSSOLoginActivity {
    public static final String q = WXLoginActivity.class.getSimpleName();
    public static final String r = "from_wx_auth";
    public static final String s = "state";
    public static final String t = "code";
    public static final String u = "error_code";
    public static int v;
    public static String w;
    public static boolean x;
    public String n;
    public String o;
    public int p;

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void onFinish();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setPageAnim(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a implements b {
        public a() {
        }

        @Override // com.baidu.sapi2.activity.social.WXLoginActivity.b
        public void a() {
            Toast.makeText(WXLoginActivity.this, "微信未安装", 1).show();
            WXLoginActivity.this.a(WXLoginActivity.v);
        }

        @Override // com.baidu.sapi2.activity.social.WXLoginActivity.b
        public void onFinish() {
            WXLoginActivity.this.finish();
        }
    }

    private void a(b bVar) {
        try {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.configuration.context, this.configuration.wxAppID);
            if (!createWXAPI.isWXAppInstalled()) {
                bVar.a();
                return;
            }
            bVar.onFinish();
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            createWXAPI.sendReq(req);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void b(int i) {
        super.b(i);
        b(i, (Intent) null);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
    }

    private void b(int i, Intent intent) {
        if (SocialLoginBase.getWXinvokeCallback() != null) {
            SocialLoginBase.getWXinvokeCallback().onResult(i, intent);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void a(int i, Intent intent) {
        super.a(i, intent);
        b(i, intent);
    }

    private void e() {
        ((BaseSSOLoginActivity) this).g = v;
        ((BaseSSOLoginActivity) this).e = w;
        ((BaseSSOLoginActivity) this).f = x;
        w = null;
        x = false;
        this.o = getIntent().getStringExtra("code");
        this.n = getIntent().getStringExtra("state");
        int intExtra = getIntent().getIntExtra("error_code", -1);
        this.p = intExtra;
        if (((BaseSSOLoginActivity) this).f) {
            Intent intent = new Intent();
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE, this.o);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.WEIXIN.getType()));
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, ThirdPartyUtil.TYPE_WEIXIN);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().wxAppID);
            a(4001, intent);
            finish();
        } else if (intExtra == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("wxRespCode", this.o);
            hashMap.put("wxRespState", this.n);
            StatService.onEventAutoStat("third_login_wx_result", hashMap);
            if (TextUtils.equals(ThirdPartyUtil.wxAuthCodeMap.get(this.o), this.n)) {
                return;
            }
            ThirdPartyUtil.wxAuthCodeMap.put(this.o, this.n);
            a(ParamsUtil.getUrlWeixinBind(this.configuration, this.o, this.n, false), "授权微信帐号登录中");
        } else {
            a(v);
        }
    }

    private void f() {
        setupViews();
        setTitleText("微信帐号登录");
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        if (!getIntent().getBooleanExtra(r, false)) {
            v = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            w = ((BaseSSOLoginActivity) this).e;
            x = ((BaseSSOLoginActivity) this).f;
            a(new a());
            return;
        }
        e();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void a(int i) {
        super.a(i);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
