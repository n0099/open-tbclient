package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.j.a.a.a;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.ParamsUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes3.dex */
public class WXLoginActivity extends BaseSSOLoginActivity {
    public static final String KEY_BASE_RESP_CODE = "code";
    public static final String KEY_BASE_RESP_ERROR_CODE = "error_code";
    public static final String KEY_BASE_RESP_STATE = "state";
    public static final String KEY_FROM_WX_AUTH = "from_wx_auth";
    public static final String TAG = WXLoginActivity.class.getSimpleName();
    private static int businessFrom;
    private static String mWxExtraJson;
    public String wxRespCode;
    public int wxRespErrorCode;
    public String wxRespState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface WxCallback {
        void handleNotInstall();

        void onFinish();
    }

    private void handleWxResp() {
        this.businessFrom = businessFrom;
        this.extraJson = mWxExtraJson;
        mWxExtraJson = null;
        this.wxRespCode = getIntent().getStringExtra("code");
        this.wxRespState = getIntent().getStringExtra("state");
        this.wxRespErrorCode = getIntent().getIntExtra("error_code", -1);
        if (this.wxRespErrorCode == 0) {
            loadLoginInNA(ParamsUtil.getUrlWeixinBind(this.configuration, this.wxRespCode, this.wxRespState, false), "授权微信帐号登录中");
        } else {
            handleBack(businessFrom);
        }
    }

    private void initView() {
        setupViews();
        setTitleText(a.c.sapi_sdk_title_login_wx);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        if (!getIntent().getBooleanExtra(KEY_FROM_WX_AUTH, false)) {
            businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            mWxExtraJson = this.extraJson;
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
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.configuration.context, this.configuration.wxAppID);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void handleBack(int i) {
        super.handleBack(i);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i) {
        super.setActivtyResult(i);
        setInvokeResult(i, null);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    protected void setPageAnim(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i, Intent intent) {
        super.setActivtyResult(i, intent);
        setInvokeResult(i, intent);
    }
}
