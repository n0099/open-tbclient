package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.l;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes2.dex */
public class WXLoginActivity extends BaseSSOLoginActivity {
    public static final String KEY_BASE_RESP_CODE = "code";
    public static final String KEY_BASE_RESP_ERROR_CODE = "error_code";
    public static final String KEY_BASE_RESP_STATE = "state";
    public static final String KEY_FROM_WX_AUTH = "from_wx_auth";
    public static final String TAG = WXLoginActivity.class.getSimpleName();
    public static int businessFrom;
    public static String mWxExtraJson;
    public static boolean mWxIsVerification;
    public String wxRespCode;
    public int wxRespErrorCode;
    public String wxRespState;

    /* loaded from: classes2.dex */
    public interface WxCallback {
        void handleNotInstall();

        void onFinish();
    }

    private void handleWxResp() {
        this.businessFrom = businessFrom;
        this.extraJson = mWxExtraJson;
        this.mIsVerification = mWxIsVerification;
        mWxExtraJson = null;
        mWxIsVerification = false;
        this.wxRespCode = getIntent().getStringExtra("code");
        this.wxRespState = getIntent().getStringExtra("state");
        int intExtra = getIntent().getIntExtra("error_code", -1);
        this.wxRespErrorCode = intExtra;
        if (!this.mIsVerification) {
            if (intExtra == 0) {
                loadLoginInNA(ParamsUtil.getUrlWeixinBind(this.configuration, this.wxRespCode, this.wxRespState, false), "授权微信帐号登录中");
                return;
            } else {
                handleBack(businessFrom);
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE, this.wxRespCode);
        intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.QQ_SSO.getType()));
        intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, l.f11528a);
        intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().wxAppID);
        setActivtyResult(3001, intent);
        finish();
    }

    private void initView() {
        setupViews();
        setTitleText("微信帐号登录");
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        if (!getIntent().getBooleanExtra(KEY_FROM_WX_AUTH, false)) {
            businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            mWxExtraJson = this.extraJson;
            mWxIsVerification = this.mIsVerification;
            requestWXLogin(new WxCallback() { // from class: com.baidu.sapi2.activity.social.WXLoginActivity.1
                @Override // com.baidu.sapi2.activity.social.WXLoginActivity.WxCallback
                public void handleNotInstall() {
                    Toast.makeText(WXLoginActivity.this, "微信未安装", 1).show();
                    WXLoginActivity.this.handleBack(WXLoginActivity.businessFrom);
                }

                @Override // com.baidu.sapi2.activity.social.WXLoginActivity.WxCallback
                public void onFinish() {
                    WXLoginActivity.this.finish();
                }
            });
            return;
        }
        handleWxResp();
    }

    private void requestWXLogin(WxCallback wxCallback) {
        SapiConfiguration sapiConfiguration = this.configuration;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(sapiConfiguration.context, sapiConfiguration.wxAppID);
        if (!createWXAPI.isWXAppInstalled()) {
            wxCallback.handleNotInstall();
            return;
        }
        wxCallback.onFinish();
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        createWXAPI.sendReq(req);
    }

    private void setInvokeResult(int i, Intent intent) {
        if (SocialLoginBase.getWXinvokeCallback() != null) {
            SocialLoginBase.getWXinvokeCallback().onResult(i, intent);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void handleBack(int i) {
        super.handleBack(i);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i) {
        super.setActivtyResult(i);
        setInvokeResult(i, null);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setPageAnim(boolean z) {
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i, Intent intent) {
        super.setActivtyResult(i, intent);
        setInvokeResult(i, intent);
    }
}
