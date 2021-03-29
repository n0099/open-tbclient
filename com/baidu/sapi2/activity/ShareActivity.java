package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.share.c;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.webkit.internal.ETAG;
import d.b.a0.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShareActivity extends BaseActivity {
    public static final String w = "ShareActivity";
    public static final String x = "share_fail_code";
    public static final String y = "share_fail_reason";
    public static final String z = "share_account";
    public String p = "0";
    public b q = new b();
    public WebAuthListener r;
    public String s;
    public String t;
    public String u;
    public String v;

    private void i() {
        Map<String, String> c2 = c();
        c2.put("error_code", "" + this.q.getResultCode());
        StatService.onEventAutoStat(c.f11376h, c2);
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
                c2.put(ImageViewerConfig.IS_LOGIN, this.p.equals("1") ? "0" : "1");
                StatService.onEventAutoStat(c.f11374f, c2);
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.q.setResultCode(b.o);
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
            jSONObject.put("errno", "0");
            String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
            jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
            String str = pkgIconAndName[1];
            this.s = str;
            jSONObject.put("currentAPPName", str);
            String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
            jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
            String str2 = pkgIconAndName2[1];
            this.t = str2;
            jSONObject.put("originAPPName", str2);
            if (currentAccount == null) {
                this.p = "1";
            } else {
                jSONObject.put("displayName", currentAccount.displayname);
            }
            jSONObject.put("portrait", getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, getIntent().getStringExtra(a.f11344b));
            jSONObject.put("trace_id", getIntent().getStringExtra(a.f11343a));
            this.u = getIntent().getStringExtra(a.f11345c);
            this.v = getIntent().getStringExtra(a.f11346d);
            Log.d(w, "调用来源=" + this.v + ", 调起方=" + this.t + ", 被调起方=" + this.s + ", shareVer=" + this.u);
        } catch (Exception e2) {
            Log.e(e2);
        }
        SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams = new SapiJsCallBacks.ShareV2LoginParams() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams
            public void onError() {
                StatService.onEventAutoStat(c.i, ShareActivity.this.c());
                if (!ShareActivity.this.p.equals("1")) {
                    ShareActivity.this.p = "2";
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
            this.q.setResultCode(b.n);
            d();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put(ProgressInfo.JSON_KEY_CURRENT, this.s);
        hashMap.put("original", this.t);
        hashMap.put(a.c.i, this.v);
        hashMap.put("share_ver", this.u);
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
            this.q.setResultCode(b.p);
            d();
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        Map<String, String> c2 = c();
        c2.put(ImageViewerConfig.IS_LOGIN, this.p.equals("1") ? "0" : "1");
        StatService.onEventAutoStat(c.f11375g, c2);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("share_account", currentAccount);
        bundle.putInt("SDK_VERSION", 250);
        bundle.putString("PKG", getPackageName());
        bundle.putString(a.f11345c, this.u);
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        final boolean z2 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
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
        this.r = new WebAuthListener() { // from class: com.baidu.sapi2.activity.ShareActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                Map c2 = ShareActivity.this.c();
                c2.put("code", "" + webAuthResult.getResultCode());
                StatService.onEventAutoStat(c.k, c2);
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                ShareActivity.this.q.setResultCode(b.q);
                ShareActivity.this.q.setResultMsg(String.format(b.f11368h, ShareActivity.this.s));
                ShareActivity.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                StatService.onEventAutoStat(c.j, ShareActivity.this.c());
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                SapiWebView sapiWebView = ShareActivity.this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.reload();
                }
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        };
        CoreViewRouter.getInstance().startLogin(this, this.r, webLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.q.setResultCode(b.j);
        this.q.setResultMsg(String.format(b.f11361a, this.s));
        d();
    }

    private void h() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("share_fail_code", "" + this.q.getResultCode());
        bundle.putString("share_fail_reason", this.q.getResultMsg());
        bundle.putString(a.f11345c, this.u);
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }

    private boolean a() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage) || !new a().a(this, callingPackage)) {
            this.q.setResultCode(b.k);
            d();
            return false;
        }
        return true;
    }
}
