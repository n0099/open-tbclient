package com.baidu.sapi2.views.logindialog.page;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class LoginPager extends LinearLayout implements ILoginConfirmCallback, ISendSmsUICallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes2.dex */
    public class a implements ShareModelResultCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginPager a;

        public a(LoginPager loginPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginPager;
        }

        @Override // com.baidu.sapi2.callback.ShareModelResultCallback
        public void onFailure(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LoginPager loginPager = this.a;
                loginPager.a(loginPager.a(LoginPager.a(loginPager)));
            }
        }

        @Override // com.baidu.sapi2.callback.ShareModelResultCallback
        public void onSuccess(List<ShareStorage.StorageModel> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.b(list);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginPager a;

        public b(LoginPager loginPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginPager;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                Log.e(QuickLoginDialog.STAG, "one key login is available, enable = " + oneKeyLoginResult.enable + ", hasHistory is " + oneKeyLoginResult.hasHistory + ", encryptPhoneNum is " + oneKeyLoginResult.encryptPhoneNum);
                this.a.a(oneKeyLoginResult);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                Log.e(QuickLoginDialog.STAG, "one key login is unAvailable, code is " + oneKeyLoginResult.getResultCode() + ", msg is " + oneKeyLoginResult.getResultMsg());
                this.a.a(oneKeyLoginResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1258744083, "Lcom/baidu/sapi2/views/logindialog/page/LoginPager$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1258744083, "Lcom/baidu/sapi2/views/logindialog/page/LoginPager$c;");
                    return;
                }
            }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPager(@NonNull Context context, ColorType colorType, IQuickLoginDialogCallback iQuickLoginDialogCallback, IPagerLoadCallback iPagerLoadCallback, ISendSmsCallback iSendSmsCallback) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, colorType, iQuickLoginDialogCallback, iPagerLoadCallback, iSendSmsCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04bf, this);
            this.c = (OneKeyLoginView) findViewById(R.id.obfuscated_res_0x7f091d0f);
            this.d = (ShareLoginView) findViewById(R.id.obfuscated_res_0x7f091d11);
            this.e = (HistoryLoginView) findViewById(R.id.obfuscated_res_0x7f091d0d);
            this.f = (SendSmsView) findViewById(R.id.obfuscated_res_0x7f091d10);
            this.g = (ThirdPartyView) findViewById(R.id.obfuscated_res_0x7f091d12);
            this.h = (AgreementView) findViewById(R.id.obfuscated_res_0x7f091d0c);
            this.g.setLoginCallback(this);
            this.h.a((Activity) this.a, this.i);
            b();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            SapiAccountManager.getInstance().checkAvailableLoginHistory(new LoginHistoryCallback(this) { // from class: com.baidu.sapi2.views.logindialog.page.LoginPager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginPager a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                public void onFailure() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LoginPager loginPager = this.a;
                        loginPager.a(loginPager.a(LoginPager.a(loginPager)));
                    }
                }

                @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                public void onResult(JSONArray jSONArray) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
                        super.onResult(jSONArray);
                    }
                }

                @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                public void onSuccess(List<LoginHistoryModel> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                        this.a.a(list);
                    }
                }
            });
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new b(this));
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            SapiAccountManager.getInstance().getShareModels(1500L, new a(this));
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
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
    }

    public void hideSendMsgErrorTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SendSmsView sendSmsView = this.f;
            if (sendSmsView != null) {
                sendSmsView.b();
            }
            AgreementView agreementView = this.h;
            if (agreementView != null) {
                agreementView.setPadding(0, ViewUtils.dp2px(this.a, 25.0f), 0, 0);
            }
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback
    public void onFailure(QuickLoginResult quickLoginResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, quickLoginResult) == null) {
            Log.e(QuickLoginDialog.STAG, "login fail,login type = " + quickLoginResult.mLoginType + ",result code = " + quickLoginResult.getResultCode());
            IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
            if (iQuickLoginDialogCallback == null) {
                return;
            }
            iQuickLoginDialogCallback.onLoginFailure(quickLoginResult);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback
    public void onHideErrorTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hideSendMsgErrorTip();
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback
    public void onHideThirdParty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.setVisibility(8);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback
    public boolean onPreStart(boolean z) {
        InterceptResult invokeZ;
        IPagerLoadCallback iPagerLoadCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
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
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback
    public void onShowThirdParty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g.setVisibility(0);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback
    public void onSuccess(QuickLoginResult quickLoginResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, quickLoginResult) == null) {
            Log.e(QuickLoginDialog.STAG, "login success,login type = " + quickLoginResult.mLoginType);
            IQuickLoginDialogCallback iQuickLoginDialogCallback = this.i;
            if (iQuickLoginDialogCallback == null) {
                return;
            }
            iQuickLoginDialogCallback.onLoginSuccess(quickLoginResult);
        }
    }

    public void showSendMsgErrorTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            SendSmsView sendSmsView = this.f;
            if (sendSmsView != null) {
                sendSmsView.a(str);
            }
            AgreementView agreementView = this.h;
            if (agreementView != null) {
                agreementView.setPadding(0, 13, 0, 0);
            }
        }
    }

    public static /* synthetic */ int a(LoginPager loginPager) {
        int i = loginPager.m + 1;
        loginPager.m = i;
        return i;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.b == ColorType.DARK) {
            this.c.a();
            this.d.a();
            this.e.a();
            this.f.a();
            this.g.a();
            this.h.a();
        }
    }

    private JSONArray a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(QuickLoginType.HISTORY.getValue());
            jSONArray.put(QuickLoginType.SHARE.getValue());
            jSONArray.put(QuickLoginType.ONEKEY.getValue());
            jSONArray.put(QuickLoginType.SMS.getValue());
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<ShareStorage.StorageModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, list) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuickLoginType a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (i >= 0 && i <= this.l.length() - 1) {
                String optString = this.l.optString(i);
                if (TextUtils.isEmpty(optString)) {
                    return QuickLoginType.SMS;
                }
                return QuickLoginType.getViewLoginTypeByValue(optString);
            }
            return QuickLoginType.SMS;
        }
        return (QuickLoginType) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(QuickLoginType quickLoginType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, quickLoginType) == null) {
            int i = c.a[quickLoginType.ordinal()];
            if (i == 1) {
                d();
            } else if (i == 2) {
                f();
            } else if (i != 3) {
                g();
            } else {
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LoginHistoryModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, list) == null) {
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
    }

    private void a(LoginHistoryModel loginHistoryModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, loginHistoryModel) == null) {
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
    }

    private void a(ShareStorage.StorageModel storageModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, storageModel) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OneKeyLoginResult oneKeyLoginResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, oneKeyLoginResult) == null) {
            if (oneKeyLoginResult != null && oneKeyLoginResult.enable) {
                IPagerLoadCallback iPagerLoadCallback = this.j;
                if (iPagerLoadCallback != null) {
                    iPagerLoadCallback.onPageShow(QuickLoginDialog.HEIGHT_ONEKEY);
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
    }
}
