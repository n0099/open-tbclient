package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.BaseActivity;
/* loaded from: classes2.dex */
public class WXLoginActivity extends BaseSSOLoginActivity {
    public static final String KEY_BASE_RESP_CODE = "code";
    public static final String KEY_BASE_RESP_ERROR_CODE = "error_code";
    public static final String KEY_BASE_RESP_STATE = "state";
    public static final String KEY_FROM_WX_AUTH = "from_wx_auth";
    public static final String TAG = WXLoginActivity.class.getSimpleName();
    private static int businessFrom;
    public String wxRespCode;
    public int wxRespErrorCode;
    public String wxRespState;

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    private void initView() {
        setupViews();
        setTitleText(a.c.sapi_sdk_title_login_wx);
        this.sapiWebView.setWeixinHandler(new SapiWebView.WeixinHandler() { // from class: com.baidu.sapi2.activity.social.WXLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleNotInstall() {
                Toast.makeText(WXLoginActivity.this, SapiWebView.DEFAULT_WEIXIN_NOT_INSTALL_ERROR, 1).show();
                WXLoginActivity.this.handleBack(WXLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleServerError(String str) {
                Toast.makeText(WXLoginActivity.this, "服务错误", 1).show();
                WXLoginActivity.this.handleBack(WXLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void onFinish() {
                WXLoginActivity.this.finish();
            }
        });
        if (!getIntent().getBooleanExtra(KEY_FROM_WX_AUTH, false)) {
            businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            if (businessFrom == 2003) {
                this.sapiWebView.loadWeixinSSOLogin(true, getIntent().getStringExtra(AccountCenterActivity.EXTRA_WEIIXIN_BIND_URL), getStatParamList());
                return;
            }
            this.sapiWebView.loadWeixinSSOLogin(getStatParamList());
            return;
        }
        handleWxResp();
    }

    private void handleWxResp() {
        this.businessFrom = businessFrom;
        this.wxRespCode = getIntent().getStringExtra("code");
        this.wxRespState = getIntent().getStringExtra(KEY_BASE_RESP_STATE);
        this.wxRespErrorCode = getIntent().getIntExtra(KEY_BASE_RESP_ERROR_CODE, -1);
        if (this.wxRespErrorCode == 0) {
            if (businessFrom == 2003) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("wx_state", this.wxRespState);
                bundle.putString("wx_code", this.wxRespCode);
                intent.putExtras(bundle);
                setActivtyResult(-1, intent);
                finish();
                return;
            }
            this.sapiWebView.weixinSSOLogin(this.wxRespCode, this.wxRespState, false, getStatParamList());
            return;
        }
        handleBack(businessFrom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void handleBack(int i) {
        super.handleBack(i);
    }

    private void setInvokeResult(int i, Intent intent) {
        if (wxInvokeCallback != null) {
            wxInvokeCallback.onResult(i, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i) {
        super.setActivtyResult(i);
        setInvokeResult(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity
    public void setActivtyResult(int i, Intent intent) {
        super.setActivtyResult(i, intent);
        setInvokeResult(i, intent);
    }
}
