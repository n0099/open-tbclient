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
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
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

    /* renamed from: b  reason: collision with root package name */
    public boolean f9823b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f9824c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f9825d;

    /* renamed from: e  reason: collision with root package name */
    public String f9826e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9827f;

    /* renamed from: g  reason: collision with root package name */
    public int f9828g;

    /* renamed from: a  reason: collision with root package name */
    public final String f9822a = "BaseSSOLoginActivity";

    /* renamed from: h  reason: collision with root package name */
    public WebAuthResult f9829h = new a();

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.sapi2.a.a.b f9830i = new b();
    public AuthorizationListener j = new c();

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
        public void onFailed(int i2, String str) {
            if (BaseSSOLoginActivity.this.f9828g == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i2);
                intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
                BaseSSOLoginActivity.this.a(1002, intent);
            } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                BaseSSOLoginActivity.this.f9829h.setResultCode(i2);
                BaseSSOLoginActivity.this.f9829h.setResultMsg(str);
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(BaseSSOLoginActivity.this.f9829h);
                CoreViewRouter.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            if (BaseSSOLoginActivity.this.f9823b) {
                return;
            }
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = BaseSSOLoginActivity.this.f9829h;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(BaseSSOLoginActivity.this.f9829h);
            }
            int i2 = BaseSSOLoginActivity.this.f9828g;
            if (i2 != 2001) {
                if (i2 != 2003 && i2 != 2004) {
                    WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
                    if (socialLoginDTO == null || !socialLoginDTO.finishActivityAfterSuc) {
                        return;
                    }
                    CoreViewRouter.getInstance().release();
                    BaseSSOLoginActivity.this.finish();
                    return;
                }
                BaseSSOLoginActivity.this.b(1001);
                BaseSSOLoginActivity.this.finish();
                return;
            }
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
            if (webLoginDTO == null || !webLoginDTO.finishActivityAfterSuc) {
                return;
            }
            BaseSSOLoginActivity.this.b(1001);
            BaseSSOLoginActivity.this.finish();
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
            baseSSOLoginActivity.a(baseSSOLoginActivity.f9828g);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements SapiWebView.OnFinishCallback {
        public e() {
        }

        @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
        public void onFinish() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            baseSSOLoginActivity.a(baseSSOLoginActivity.f9828g);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f9836a;

        public f(SapiAccount sapiAccount) {
            this.f9836a = sapiAccount;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (BaseSSOLoginActivity.this.j != null) {
                    BaseSSOLoginActivity.this.j.beforeSuccess(this.f9836a);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            SapiAccountManager.getInstance().validate(this.f9836a);
            BaseSSOLoginActivity.this.a(AccountType.UNKNOWN);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SocialResponse f9838a;

        public g(SocialResponse socialResponse) {
            this.f9838a = socialResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.j;
            if (authorizationListener != null) {
                SocialResponse socialResponse = this.f9838a;
                authorizationListener.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9840a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Looper looper, String str) {
            super(looper);
            this.f9840a = str;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.j;
            if (authorizationListener != null) {
                authorizationListener.onFailed(-100, "登录失败");
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            super.onFinish();
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            ViewUtility.dismissDialog(baseSSOLoginActivity, baseSSOLoginActivity.f9825d);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            super.onStart();
            BaseSSOLoginActivity.this.a(this.f9840a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
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

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        ViewUtility.dismissDialog(this, this.f9825d);
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getSocialLoginDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        this.sapiWebView.onKeyUp(4);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        a(this.f9828g);
    }

    @Override // com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            e();
        }
        super.onCreate(bundle);
        d();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.onKeyUp(4);
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
        this.sapiWebView.setOnBackCallback(new d());
        this.sapiWebView.setOnFinishCallback(new e());
        this.sapiWebView.setAuthorizationListener(this.j);
    }

    private void d() {
        super.init();
        this.f9828g = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.f9826e = getIntent().getStringExtra("extraJson");
        this.f9827f = getIntent().getBooleanExtra(m, false);
        this.f9829h.activity = this;
        this.f9824c = new Handler();
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

    public void b(int i2) {
        setResult(i2);
    }

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

    public void a(int i2) {
        a(i2, -301, "您已取消操作");
    }

    public String b() {
        if (TextUtils.isEmpty(this.f9826e)) {
            return "";
        }
        try {
            return new JSONObject(this.f9826e).optString(l);
        } catch (Exception e2) {
            Log.e(e2);
            return "";
        }
    }

    /* loaded from: classes2.dex */
    public class a extends WebAuthResult {
        public a() {
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.f9828g == 2001) {
                baseSSOLoginActivity.b(1001);
            } else {
                CoreViewRouter.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity(boolean z) {
            super.finishActivity(z);
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.f9828g == 2001) {
                baseSSOLoginActivity.b(1001);
            } else if (z) {
                CoreViewRouter.getInstance().release();
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
            BaseSSOLoginActivity.this.a(3001, intent);
            BaseSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.a.a.b
        public void a() {
            BaseSSOLoginActivity.this.b(3001);
            BaseSSOLoginActivity.this.finish();
        }
    }

    public void a(int i2, int i3, String str) {
        if (i2 == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i3);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
            a(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            this.f9823b = true;
            this.f9829h.setResultCode(i3);
            this.f9829h.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f9829h);
            CoreViewRouter.getInstance().release();
        }
        SapiUtils.hideSoftInput(this);
        finish();
    }

    public void a(int i2, Intent intent) {
        setResult(i2, intent);
    }

    public void a(SocialResponse socialResponse, HashMap<String, String> hashMap) {
        if (socialResponse.errorCode == 302) {
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            String str = socialResponse.userInfoXmlContent;
            String str2 = socialResponse.nextUrl;
            this.sapiWebView.loadThirdPartySSOLogin(str2, str, hashMap.get("mkey"), hashMap.get("BAIDUID"), hashMap.get(HttpRequest.BDUSS), hashMap.get("PTOKEN"), hashMap.get("STOKEN"));
            return;
        }
        SapiAccount sapiAccountResponseToAccount = ((ThirdPartyService) CoreViewRouter.getInstance().getThirdPartyService()).sapiAccountResponseToAccount(this, socialResponse);
        if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (this.j != null) {
            int i2 = socialResponse.errorCode;
            if (i2 != 0 && i2 != 110000) {
                this.f9824c.post(new g(socialResponse));
            } else {
                this.f9824c.post(new f(sapiAccountResponseToAccount));
            }
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

    public void a(String str, String str2) {
        if (this.sapiWebView == null) {
            if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                this.f9829h.setResultCode(-202);
                this.f9829h.setResultMsg("网络连接失败，请检查网络设置");
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f9829h);
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

    public void a(String str) {
        LoadingDialog createDialog = new LoadingDialog.Builder(this).setMessage(str).setCancelable(false).setCancelOutside(false).createDialog();
        this.f9825d = createDialog;
        if (createDialog.isShowing() || isFinishing()) {
            return;
        }
        this.f9825d.show();
    }
}
