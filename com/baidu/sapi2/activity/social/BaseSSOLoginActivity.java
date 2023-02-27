package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseSSOLoginActivity extends SocialLoginBase {
    public static final String k = "extraJson";
    public static final String l = "sceneFrom";
    public static final String m = "isVerification";
    public boolean b;
    public Handler c;
    public Dialog d;
    public String e;
    public boolean f;
    public int g;
    public final String a = "BaseSSOLoginActivity";
    public WebAuthResult h = new a();
    public com.baidu.sapi2.a.a.b i = new b();
    public AuthorizationListener j = new c();

    /* loaded from: classes2.dex */
    public class a extends WebAuthResult {
        public a() {
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            super.finishActivity(z);
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.g == 2001) {
                baseSSOLoginActivity.b(1001);
            } else if (z) {
                CoreViewRouter.getInstance().release();
                ThirdPartyService.releaseThirdLoginCallback();
            }
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.g == 2001) {
                baseSSOLoginActivity.b(1001);
            } else {
                CoreViewRouter.getInstance().release();
                ThirdPartyService.releaseThirdLoginCallback();
            }
            BaseSSOLoginActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements com.baidu.sapi2.a.a.b {
        public b() {
        }

        @Override // com.baidu.sapi2.a.a.b
        public void a(String str) {
            Intent intent = new Intent();
            intent.putExtra("response", str);
            BaseSSOLoginActivity.this.a(4001, intent);
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.a.a.b
        public void a() {
            BaseSSOLoginActivity.this.b(4001);
            BaseSSOLoginActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends AuthorizationListener {
        public c() {
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                CoreViewRouter.getInstance().getWebAuthListener().beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (BaseSSOLoginActivity.this.g == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i);
                intent.putExtra("result_msg", str);
                BaseSSOLoginActivity.this.a(1002, intent);
            } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                BaseSSOLoginActivity.this.h.setResultCode(i);
                BaseSSOLoginActivity.this.h.setResultMsg(str);
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(BaseSSOLoginActivity.this.h);
                CoreViewRouter.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            if (BaseSSOLoginActivity.this.b) {
                return;
            }
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = BaseSSOLoginActivity.this.h;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(BaseSSOLoginActivity.this.h);
            }
            int i = BaseSSOLoginActivity.this.g;
            if (i == 2001) {
                WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
                if (webRegDTO != null) {
                    if (webRegDTO.finishActivityAfterSuc) {
                        BaseSSOLoginActivity.this.b(1001);
                        BaseSSOLoginActivity.this.finish();
                        return;
                    }
                    return;
                }
                WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
                if (webLoginDTO != null && webLoginDTO.finishActivityAfterSuc) {
                    BaseSSOLoginActivity.this.b(1001);
                    BaseSSOLoginActivity.this.finish();
                }
            } else if (i != 2003 && i != 2004) {
                WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
                if (socialLoginDTO != null && socialLoginDTO.finishActivityAfterSuc) {
                    if (socialLoginDTO.isReleaseAllCallback.booleanValue()) {
                        CoreViewRouter.getInstance().release();
                    }
                    BaseSSOLoginActivity.this.finish();
                }
            } else {
                BaseSSOLoginActivity.this.b(1001);
                BaseSSOLoginActivity.this.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements SapiWebView.OnBackCallback {
        public d() {
        }

        @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
        public void onBack() {
            if (BaseSSOLoginActivity.this.sapiWebView != null && BaseSSOLoginActivity.this.sapiWebView.canGoBack()) {
                BaseSSOLoginActivity.this.sapiWebView.goBack();
                return;
            }
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            baseSSOLoginActivity.a(baseSSOLoginActivity.g);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements SapiWebView.OnFinishCallback {
        public e() {
        }

        @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
        public void onFinish() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            baseSSOLoginActivity.a(baseSSOLoginActivity.g);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public final /* synthetic */ SapiAccount a;

        public f(SapiAccount sapiAccount) {
            this.a = sapiAccount;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (BaseSSOLoginActivity.this.j != null) {
                    BaseSSOLoginActivity.this.j.beforeSuccess(this.a);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            SapiAccountManager.getInstance().validate(this.a);
            BaseSSOLoginActivity.this.a(AccountType.UNKNOWN);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public final /* synthetic */ SocialResponse a;

        public g(SocialResponse socialResponse) {
            this.a = socialResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.j;
            if (authorizationListener != null) {
                SocialResponse socialResponse = this.a;
                authorizationListener.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends HttpHandlerWrap {
        public final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Looper looper, String str) {
            super(looper);
            this.a = str;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            ThirdPartyUtil.wxAuthCodeMap.clear();
            AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.j;
            if (authorizationListener != null) {
                authorizationListener.onFailed(-100, "登录失败");
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            ThirdPartyUtil.wxAuthCodeMap.clear();
            super.onFinish();
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            ViewUtility.dismissDialog(baseSSOLoginActivity, baseSSOLoginActivity.d);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            super.onStart();
            BaseSSOLoginActivity.this.a(this.a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
            ThirdPartyUtil.wxAuthCodeMap.clear();
            if (str == null) {
                AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.j;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, "登录失败");
                    return;
                }
                return;
            }
            try {
                BaseSSOLoginActivity.this.a(SocialResponse.fromJSONObject(new JSONObject(str)), hashMap);
            } catch (Throwable th) {
                Log.e(th);
                AuthorizationListener authorizationListener2 = BaseSSOLoginActivity.this.j;
                if (authorizationListener2 != null) {
                    authorizationListener2.onFailed(-100, "登录失败");
                }
            }
        }
    }

    private void e() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    /* JADX DEBUG: Possible override for method com.baidu.sapi2.activity.BaseActivity.b()Lcom/baidu/sapi2/callback/ImageCropCallback; */
    /* JADX DEBUG: Possible override for method com.baidu.sapi2.activity.TitleActivity.b()V */
    public String b() {
        if (!TextUtils.isEmpty(this.e)) {
            try {
                return new JSONObject(this.e).optString(l);
            } catch (Exception e2) {
                Log.e(e2);
                return "";
            }
        }
        return "";
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        ViewUtility.dismissDialog(this, this.d);
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getSocialLoginDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.onKeyUp(4);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        a(this.g);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        SapiWebView sapiWebView;
        super.onLeftBtnClick();
        if (this.executeSubClassMethod && (sapiWebView = this.sapiWebView) != null) {
            sapiWebView.onKeyUp(4);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.setOnBackCallback(new d());
            this.sapiWebView.setOnFinishCallback(new e());
            this.sapiWebView.setAuthorizationListener(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && !TextUtils.isEmpty(sapiWebView.touchidPortraitAndSign[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.sapiWebView.touchidPortraitAndSign;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        AuthorizationListener authorizationListener = this.j;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.j.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.j.onSuccess();
        }
    }

    @Override // com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            e();
        }
        super.onCreate(bundle);
        d();
    }

    private void d() {
        super.init();
        this.g = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.e = getIntent().getStringExtra("extraJson");
        this.f = getIntent().getBooleanExtra(m, false);
        this.h.activity = this;
        this.c = new Handler();
    }

    public void a(int i) {
        a(i, -301, "您已取消操作");
    }

    public void b(int i) {
        setResult(i);
    }

    public void a(int i, int i2, String str) {
        if (i == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i2);
            intent.putExtra("result_msg", str);
            a(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            this.b = true;
            this.h.setResultCode(i2);
            this.h.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.h);
            CoreViewRouter.getInstance().release();
        }
        SapiUtils.hideSoftInput(this);
        finish();
    }

    public void a(int i, Intent intent) {
        setResult(i, intent);
    }

    public void a(SocialResponse socialResponse, HashMap<String, String> hashMap) {
        if (socialResponse.errorCode == 302) {
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            String str = hashMap.get("mkey");
            String str2 = hashMap.get("BAIDUID");
            String str3 = hashMap.get(HttpRequest.BDUSS);
            String str4 = hashMap.get("PTOKEN");
            String str5 = hashMap.get("STOKEN");
            String str6 = socialResponse.userInfoXmlContent;
            String str7 = socialResponse.nextUrl;
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null) {
                sapiWebView.loadThirdPartySSOLogin(str7, str6, str, str2, str3, str4, str5);
                return;
            }
            return;
        }
        SapiAccount sapiAccountResponseToAccount = ((ThirdPartyService) CoreViewRouter.getInstance().getThirdPartyService()).sapiAccountResponseToAccount(this, socialResponse);
        if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (SapiContext.getInstance().mLastLoginType != null) {
            SapiContext.getInstance().setPreLoginType(SapiContext.getInstance().mLastLoginType.getName());
        }
        if (this.j != null) {
            int i = socialResponse.errorCode;
            if (i != 0 && i != 110000) {
                this.c.post(new g(socialResponse));
            } else {
                this.c.post(new f(sapiAccountResponseToAccount));
            }
        }
    }

    public void a(String str) {
        LoadingDialog createDialog = new LoadingDialog.Builder(this).setMessage(str).setCancelable(false).setCancelOutside(false).createDialog();
        this.d = createDialog;
        if (!createDialog.isShowing() && !isFinishing()) {
            this.d.show();
        }
    }

    public void a(String str, String str2) {
        if (this.sapiWebView == null) {
            if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                this.h.setResultCode(-202);
                this.h.setResultMsg("网络连接失败，请检查网络设置");
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.h);
            }
            CoreViewRouter.getInstance().release();
            finish();
            return;
        }
        HashMap hashMap = new HashMap();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra));
        }
        hashMap.put(l, b());
        hashMap.put("json", "1");
        String addExtras = ParamsUtil.addExtras(str, hashMap);
        new HttpClientWrap().get(addExtras, ReqPriority.IMMEDIATE, ParamsUtil.buildNaCookie(addExtras, this.configuration), new h(Looper.getMainLooper(), str2));
    }

    /* JADX DEBUG: Possible override for method com.baidu.sapi2.activity.BaseActivity.c()V */
    public List<PassNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra)));
        }
        return arrayList;
    }
}
