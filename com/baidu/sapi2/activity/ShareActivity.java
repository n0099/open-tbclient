package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.common.PassSdkModel;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.share.ShareStatKey;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.u.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
        this.u.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, this.w));
        a(false);
    }

    private void e() {
        Map<String, String> a = a();
        a.put("error_code", "" + this.u.getResultCode());
        StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_FAIL, a);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        d();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.v = null;
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null) {
            hashMap.put("cur_tpl", sapiConfiguration.tpl);
        } else {
            hashMap.put("cur_tpl", "unknown");
        }
        hashMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_TPL, this.y);
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, this.A);
        hashMap.put("share_ver", this.z);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        e();
        b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            this.u.setResultCode(ShareResult.ERROR_CODE_RESULT_NULL);
            a(true);
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        Map<String, String> a = a();
        String str = "1";
        if (this.t.equals("1")) {
            str = "0";
        }
        a.put("is_login", str);
        StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_SUCCESS, a);
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

    private void b(boolean z) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("share_fail_code", "" + this.u.getResultCode());
        bundle.putString("share_fail_reason", this.u.getResultMsg());
        if (z) {
            bundle.putString(ShareLoginModel.AUTH_APP_PKG_NAME, getPackageName());
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                bundle.putString(ShareLoginModel.INVALIDATE_BDUSS, currentAccount.bduss);
            }
        }
        bundle.putString(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, this.z);
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
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
                Map a = ShareActivity.this.a();
                a.put("code", "" + webAuthResult.getResultCode());
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_FAIL, a);
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                ShareActivity.this.u.setResultCode(ShareResult.ERROR_CODE_EXPIRED_LOGIN_FAIL);
                ShareActivity.this.u.setResultMsg(String.format(ShareResult.ERROR_MSG_EXPIRED_LOGIN_FAIL, ShareActivity.this.w));
                ShareActivity.this.a(true);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_SUCCESS, ShareActivity.this.a());
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

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            if (!PassSdkModel.getInstance().checkPassSdkInit()) {
                Log.e(B, "pass sdk没有初始化");
                this.u.setResultCode(ShareResult.ERROR_CODE_REASON_SDK_NOT_INIT);
                a(true);
                return;
            }
            String callingPackage = getCallingPackage();
            if (!PassSdkModel.getInstance().checkPkgSign(this, callingPackage)) {
                Log.d(B, callingPackage + "不是已经授权的百度系app");
                this.u.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
                a(false);
                return;
            }
            init();
            setupViews();
            Map<String, String> a = a();
            String str = "1";
            if (this.t.equals("1")) {
                str = "0";
            }
            a.put("is_login", str);
            StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_INVOKED, a);
        } catch (Throwable th) {
            reportWebviewError(th);
            this.u.setResultCode(ShareResult.ERROR_CODE_SYS_ERROR);
            a(false);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                ShareActivity.this.d();
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
                jSONObject.put(FileProvider.DISPLAYNAME_FIELD, currentAccount.displayname);
            }
            jSONObject.put("portrait", getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put("session_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_SESSION_ID));
            jSONObject.put("trace_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_TRACE_ID));
            this.z = getIntent().getStringExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE);
            this.A = getIntent().getStringExtra(ShareCallPacking.EXTRA_CALL_TYPE_SHARE);
            Log.d(B, "调用来源=" + this.A + ", 调起方=" + this.x + ", 被调起方=" + this.w + ", shareVer=" + this.z);
        } catch (Exception e) {
            Log.e(e);
        }
        SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams = new SapiJsCallBacks.ShareV2LoginParams() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onError() {
                StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_EXPIRED, ShareActivity.this.a());
                if (!ShareActivity.this.t.equals("1")) {
                    ShareActivity.this.t = "2";
                }
                ShareActivity.this.c();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onSuccess() {
                ShareActivity.this.b();
            }
        };
        shareV2LoginParams.pageParams = jSONObject;
        this.sapiWebView.setShareV2LoginParams(shareV2LoginParams);
        this.sapiWebView.loadShareV2Login();
    }
}
