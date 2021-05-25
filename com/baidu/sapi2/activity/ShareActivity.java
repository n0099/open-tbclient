package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.share.ShareStatKey;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.webkit.internal.ETAG;
import d.a.a0.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShareActivity extends BaseActivity {
    public static final String B = "ShareActivity";
    public static final String C = "share_fail_code";
    public static final String D = "share_fail_reason";
    public static final String E = "share_account";
    public String A;
    public String t = "0";
    public ShareResult u = new ShareResult();
    public WebAuthListener v;
    public String w;
    public String x;
    public String y;
    public String z;

    private void i() {
        Map<String, String> c2 = c();
        c2.put("error_code", "" + this.u.getResultCode());
        StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_FAIL, c2);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        g();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            if (b() && a()) {
                init();
                setupViews();
                Map<String, String> c2 = c();
                c2.put(ImageViewerConfig.IS_LOGIN, this.t.equals("1") ? "0" : "1");
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_INVOKED, c2);
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.u.setResultCode(ShareResult.ERROR_CODE_SYS_ERROR);
            d();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        g();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                ShareActivity.this.g();
                return false;
            }
        });
        JSONObject jSONObject = new JSONObject();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        try {
            String stringExtra = getIntent().getStringExtra(ShareCallPacking.EXTRA_FROM_APP_TPL);
            this.y = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.y = "unknown";
            }
            jSONObject.put("errno", "0");
            String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
            jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
            String str = pkgIconAndName[1];
            this.w = str;
            jSONObject.put("currentAPPName", str);
            String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
            jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
            String str2 = pkgIconAndName2[1];
            this.x = str2;
            jSONObject.put("originAPPName", str2);
            if (currentAccount == null) {
                this.t = "1";
            } else {
                jSONObject.put("displayName", currentAccount.displayname);
            }
            jSONObject.put("portrait", getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, getIntent().getStringExtra(ShareCallPacking.EXTRA_SESSION_ID));
            jSONObject.put("trace_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_TRACE_ID));
            this.z = getIntent().getStringExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE);
            this.A = getIntent().getStringExtra(ShareCallPacking.EXTRA_CALL_TYPE_SHARE);
            Log.d(B, "调用来源=" + this.A + ", 调起方=" + this.x + ", 被调起方=" + this.w + ", shareVer=" + this.z);
        } catch (Exception e2) {
            Log.e(e2);
        }
        SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams = new SapiJsCallBacks.ShareV2LoginParams() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onError() {
                StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_EXPIRED, ShareActivity.this.c());
                if (!ShareActivity.this.t.equals("1")) {
                    ShareActivity.this.t = "2";
                }
                ShareActivity.this.f();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onSuccess() {
                ShareActivity.this.e();
            }
        };
        shareV2LoginParams.pageParams = jSONObject;
        this.sapiWebView.setShareV2LoginParams(shareV2LoginParams);
        this.sapiWebView.loadShareV2Login();
    }

    private boolean b() {
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e("pass sdk have not been initialized", new Object[0]);
            this.u.setResultCode(ShareResult.ERROR_CODE_REASON_SDK_NOT_INIT);
            d();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> c() {
        HashMap hashMap = new HashMap();
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null) {
            hashMap.put("cur_tpl", sapiConfiguration.tpl);
        } else {
            hashMap.put("cur_tpl", "unknown");
        }
        hashMap.put("from_tpl", this.y);
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, this.A);
        hashMap.put("share_ver", this.z);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        i();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            this.u.setResultCode(ShareResult.ERROR_CODE_RESULT_NULL);
            d();
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        Map<String, String> c2 = c();
        c2.put(ImageViewerConfig.IS_LOGIN, this.t.equals("1") ? "0" : "1");
        StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_SUCCESS, c2);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("share_account", currentAccount);
        bundle.putInt("SDK_VERSION", 250);
        bundle.putString("PKG", getPackageName());
        bundle.putString(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, this.z);
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        this.v = new WebAuthListener() { // from class: com.baidu.sapi2.activity.ShareActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                Map c2 = ShareActivity.this.c();
                c2.put("code", "" + webAuthResult.getResultCode());
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_FAIL, c2);
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                ShareActivity.this.u.setResultCode(ShareResult.ERROR_CODE_EXPIRED_LOGIN_FAIL);
                ShareActivity.this.u.setResultMsg(String.format(ShareResult.ERROR_MSG_EXPIRED_LOGIN_FAIL, ShareActivity.this.w));
                ShareActivity.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_SUCCESS, ShareActivity.this.c());
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                SapiWebView sapiWebView = ShareActivity.this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.reload();
                }
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        };
        CoreViewRouter.getInstance().startLogin(this, this.v, webLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.u.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
        this.u.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, this.w));
        d();
    }

    private void h() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("share_fail_code", "" + this.u.getResultCode());
        bundle.putString("share_fail_reason", this.u.getResultMsg());
        bundle.putString(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, this.z);
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }

    private boolean a() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage) || !new ShareCallPacking().checkPkgSign(this, callingPackage)) {
            this.u.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
            d();
            return false;
        }
        return true;
    }
}
