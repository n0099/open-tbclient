package com.baidu.sapi2.views.logindialog.page;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelResultCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.sapi2.views.logindialog.view.AgreementView;
import com.baidu.sapi2.views.logindialog.view.HistoryLoginView;
import com.baidu.sapi2.views.logindialog.view.OneKeyLoginView;
import com.baidu.sapi2.views.logindialog.view.SendSmsView;
import com.baidu.sapi2.views.logindialog.view.ShareLoginView;
import com.baidu.sapi2.views.logindialog.view.ThirdPartyView;
import com.baidu.tieba.R;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class LoginPager extends LinearLayout implements ILoginConfirmCallback, ISendSmsUICallback {
    public Context a;
    public ColorType b;
    public OneKeyLoginView c;
    public ShareLoginView d;
    public HistoryLoginView e;
    public SendSmsView f;
    public ThirdPartyView g;
    public AgreementView h;
    public IQuickLoginDialogCallback i;
    public IPagerLoadCallback j;
    public ISendSmsCallback k;
    public JSONArray l;
    public int m;
    public final long n;

    /* loaded from: classes3.dex */
    public class a implements ShareModelResultCallback {
        public a() {
        }

        @Override // com.baidu.sapi2.callback.ShareModelResultCallback
        public void onSuccess(List<ShareStorage.StorageModel> list) {
            LoginPager.this.b(list);
        }

        @Override // com.baidu.sapi2.callback.ShareModelResultCallback
        public void onFailure(int i, String str) {
            LoginPager loginPager = LoginPager.this;
            loginPager.a(loginPager.a(LoginPager.a(loginPager)));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends OneKeyLoginCallback {
        public b() {
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Log.e(QuickLoginDialog.STAG, "one key login is unAvailable, code is " + oneKeyLoginResult.getResultCode() + ", msg is " + oneKeyLoginResult.getResultMsg());
            LoginPager.this.a(oneKeyLoginResult);
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Log.e(QuickLoginDialog.STAG, "one key login is available, enable = " + oneKeyLoginResult.enable + ", hasHistory is " + oneKeyLoginResult.hasHistory + ", encryptPhoneNum is " + oneKeyLoginResult.encryptPhoneNum);
            LoginPager.this.a(oneKeyLoginResult);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[QuickLoginType.values().length];
            a = iArr;
            try {
                iArr[QuickLoginType.HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[QuickLoginType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[QuickLoginType.ONEKEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LoginPager(@NonNull Context context, ColorType colorType, IQuickLoginDialogCallback iQuickLoginDialogCallback, IPagerLoadCallback iPagerLoadCallback, ISendSmsCallback iSendSmsCallback) {
        super(context);
        this.a = context;
        this.b = colorType;
        this.i = iQuickLoginDialogCallback;
        this.j = iPagerLoadCallback;
        this.k = iSendSmsCallback;
        c();
        IPagerLoadCallback iPagerLoadCallback2 = this.j;
        if (iPagerLoadCallback2 != null) {
            iPagerLoadCallback2.onPageLoading();
        }
        try {
            this.l = SapiContext.getInstance().getSapiOptions().getDialogLoginPriority(SapiAccountManager.getInstance().getConfignation().tpl);
        } catch (Exception e) {
            Log.e(QuickLoginDialog.STAG, "get dialog config error:" + e.getMessage());
        }
        if (this.l == null) {
            this.l = a();
        }
        a(a(this.m));
        this.n = System.currentTimeMillis();
    }

    public static /* synthetic */ int a(LoginPager loginPager) {
        int i = loginPager.m + 1;
        loginPager.m = i;
        return i;
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback
    public boolean onPreStart(boolean z) {
        IPagerLoadCallback iPagerLoadCallback;
        AgreementView agreementView = this.h;
        if (agreementView == null) {
            return false;
        }
        boolean b2 = agreementView.b();
        if (b2 && z && (iPagerLoadCallback = this.j) != null) {
            iPagerLoadCallback.onPageLoading();
        }
        return b2;
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback
    public void onSuccess(QuickLoginResult quickLoginResult) {
        Log.e(QuickLoginDialog.STAG, "login success,login type = " + quickLoginResult.mLoginType);
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
        if (iQuickLoginDialogCallback == null) {
            return;
        }
        iQuickLoginDialogCallback.onLoginSuccess(quickLoginResult);
    }

    public void showSendMsgErrorTip(String str) {
        SendSmsView sendSmsView = this.f;
        if (sendSmsView != null) {
            sendSmsView.a(str);
        }
        AgreementView agreementView = this.h;
        if (agreementView != null) {
            agreementView.setPadding(0, 13, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuickLoginType a(int i) {
        if (i >= 0 && i <= this.l.length() - 1) {
            String optString = this.l.optString(i);
            if (TextUtils.isEmpty(optString)) {
                return QuickLoginType.SMS;
            }
            return QuickLoginType.getViewLoginTypeByValue(optString);
        }
        return QuickLoginType.SMS;
    }

    private JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(QuickLoginType.HISTORY.getValue());
        jSONArray.put(QuickLoginType.SHARE.getValue());
        jSONArray.put(QuickLoginType.ONEKEY.getValue());
        jSONArray.put(QuickLoginType.SMS.getValue());
        return jSONArray;
    }

    private void b() {
        if (this.b == ColorType.DARK) {
            this.c.a();
            this.d.a();
            this.e.a();
            this.f.a();
            this.g.a();
            this.h.a();
        }
    }

    private void d() {
        SapiAccountManager.getInstance().checkAvailableLoginHistory(new LoginHistoryCallback() { // from class: com.baidu.sapi2.views.logindialog.page.LoginPager.1
            @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
            public void onResult(JSONArray jSONArray) {
                super.onResult(jSONArray);
            }

            @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
            public void onSuccess(List<LoginHistoryModel> list) {
                LoginPager.this.a(list);
            }

            @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
            public void onFailure() {
                LoginPager loginPager = LoginPager.this;
                loginPager.a(loginPager.a(LoginPager.a(loginPager)));
            }
        });
    }

    private void e() {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new b());
    }

    private void f() {
        SapiAccountManager.getInstance().getShareModels(1500L, new a());
    }

    public void hideSendMsgErrorTip() {
        SendSmsView sendSmsView = this.f;
        if (sendSmsView != null) {
            sendSmsView.b();
        }
        AgreementView agreementView = this.h;
        if (agreementView != null) {
            agreementView.setPadding(0, ViewUtils.dp2px(this.a, 25.0f), 0, 0);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback
    public void onHideErrorTip() {
        hideSendMsgErrorTip();
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback
    public void onHideThirdParty() {
        this.g.setVisibility(8);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback
    public void onShowThirdParty() {
        this.g.setVisibility(0);
    }

    private void a(LoginHistoryModel loginHistoryModel) {
        IPagerLoadCallback iPagerLoadCallback = this.j;
        if (iPagerLoadCallback != null) {
            iPagerLoadCallback.onPageShow(256);
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.HISTORY, this.e.getTvButton());
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.g.b();
        this.g.setDialogLoginType(QuickLoginType.HISTORY);
        this.e.a((Activity) this.a, loginHistoryModel, this);
        com.baidu.sapi2.views.logindialog.utils.a.a(System.currentTimeMillis() - this.n, QuickLoginType.HISTORY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<ShareStorage.StorageModel> list) {
        if (list != null && list.size() != 0) {
            ShareStorage.StorageModel storageModel = list.get(0);
            if (storageModel == null) {
                int i = this.m + 1;
                this.m = i;
                a(a(i));
                return;
            }
            Log.e(QuickLoginDialog.STAG, "share login is available, enable = " + list.size());
            a(storageModel);
            return;
        }
        int i2 = this.m + 1;
        this.m = i2;
        a(a(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OneKeyLoginResult oneKeyLoginResult) {
        if (oneKeyLoginResult != null && oneKeyLoginResult.enable) {
            IPagerLoadCallback iPagerLoadCallback = this.j;
            if (iPagerLoadCallback != null) {
                iPagerLoadCallback.onPageShow(238);
            }
            IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
            if (iQuickLoginDialogCallback != null) {
                iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.ONEKEY, this.c.getTvButton());
            }
            AgreementView agreementView = this.h;
            if (agreementView != null) {
                agreementView.a(oneKeyLoginResult.operator);
            }
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.g.b();
            this.g.setDialogLoginType(QuickLoginType.ONEKEY);
            this.c.a(oneKeyLoginResult.encryptPhoneNum, oneKeyLoginResult.operator, this);
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(oneKeyLoginResult.operator)) {
                com.baidu.sapi2.views.logindialog.utils.a.a(currentTimeMillis - this.n, QuickLoginType.ONEKEY);
                return;
            }
            long j = currentTimeMillis - this.n;
            com.baidu.sapi2.views.logindialog.utils.a.a(j, QuickLoginType.ONEKEY.getValue() + "_" + oneKeyLoginResult.operator.toLowerCase());
            return;
        }
        int i = this.m + 1;
        this.m = i;
        a(a(i));
    }

    private void a(ShareStorage.StorageModel storageModel) {
        IPagerLoadCallback iPagerLoadCallback = this.j;
        if (iPagerLoadCallback != null) {
            iPagerLoadCallback.onPageShow(256);
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.SHARE, this.d.getTvButton());
        }
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.g.b();
        this.g.setDialogLoginType(QuickLoginType.SHARE);
        this.d.a((Activity) this.a, storageModel, this);
        com.baidu.sapi2.views.logindialog.utils.a.a(System.currentTimeMillis() - this.n, QuickLoginType.SHARE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(QuickLoginType quickLoginType) {
        int i = c.a[quickLoginType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    g();
                    return;
                } else {
                    e();
                    return;
                }
            }
            f();
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LoginHistoryModel> list) {
        if (list != null && list.size() != 0) {
            LoginHistoryModel loginHistoryModel = list.get(0);
            if (loginHistoryModel == null) {
                int i = this.m + 1;
                this.m = i;
                a(a(i));
                return;
            }
            Log.e(QuickLoginDialog.STAG, "history login is available, enable = " + list.size());
            a(loginHistoryModel);
            return;
        }
        int i2 = this.m + 1;
        this.m = i2;
        a(a(i2));
    }

    private void c() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_login_pager, this);
        this.c = (OneKeyLoginView) findViewById(R.id.sapi_sdk_login_dialog_onekeyloginview);
        this.d = (ShareLoginView) findViewById(R.id.sapi_sdk_login_dialog_shareloginview);
        this.e = (HistoryLoginView) findViewById(R.id.sapi_sdk_login_dialog_historyloginview);
        this.f = (SendSmsView) findViewById(R.id.sapi_sdk_login_dialog_sendsmsview);
        this.g = (ThirdPartyView) findViewById(R.id.sapi_sdk_login_dialog_thirdpartyview);
        this.h = (AgreementView) findViewById(R.id.sapi_sdk_login_dialog_agreementview);
        this.g.setLoginCallback(this);
        this.h.a((Activity) this.a, this.i);
        b();
    }

    private void g() {
        IPagerLoadCallback iPagerLoadCallback = this.j;
        if (iPagerLoadCallback != null) {
            iPagerLoadCallback.onPageShow(181);
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(this.b, QuickLoginType.SMS, this.f.getTvSendSms());
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.setVisibility(0);
        this.f.a((Activity) this.a);
        this.g.c();
        this.g.setDialogLoginType(QuickLoginType.SMS);
        this.f.a(this, this.k, this);
        com.baidu.sapi2.views.logindialog.utils.a.a(System.currentTimeMillis() - this.n, QuickLoginType.SMS);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback
    public void onFailure(QuickLoginResult quickLoginResult) {
        Log.e(QuickLoginDialog.STAG, "login fail,login type = " + quickLoginResult.mLoginType + ",result code = " + quickLoginResult.getResultCode());
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
        if (iQuickLoginDialogCallback == null) {
            return;
        }
        iQuickLoginDialogCallback.onLoginFailure(quickLoginResult);
    }
}
