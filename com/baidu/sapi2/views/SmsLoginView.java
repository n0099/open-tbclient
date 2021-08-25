package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.c0.a.g;
import c.a.c0.a.h;
import c.a.c0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public class SmsLoginView extends FrameLayout implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String q = "extrajson";
    public static final String r = "sdk_situation";
    public static final String s = "pop_login";
    public static int smgLoginViewIndexStat = 0;
    public static final String t = "skipreg";
    public static final int u = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f44841a;

    /* renamed from: b  reason: collision with root package name */
    public View f44842b;

    /* renamed from: c  reason: collision with root package name */
    public View f44843c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f44844d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f44845e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44846f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44847g;

    /* renamed from: h  reason: collision with root package name */
    public View f44848h;

    /* renamed from: i  reason: collision with root package name */
    public View f44849i;

    /* renamed from: j  reason: collision with root package name */
    public Dialog f44850j;
    public CountDownTimer k;
    public String l;
    public boolean m;
    public boolean n;
    public PrivacyAgreementIntercept o;
    public int p;

    /* loaded from: classes5.dex */
    public class GetCheckCodeListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmsLoginView f44851a;

        /* loaded from: classes5.dex */
        public class a extends CountDownTimer {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ GetCheckCodeListener f44853a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(GetCheckCodeListener getCheckCodeListener, long j2, long j3) {
                super(j2, j3);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {getCheckCodeListener, Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44853a = getCheckCodeListener;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f44853a.f44851a.f44844d.getText().toString().length() == 11) {
                        this.f44853a.f44851a.f44846f.setEnabled(true);
                        this.f44853a.f44851a.f44846f.setText(g.sapi_sdk_sms_re_get_check_code);
                        this.f44853a.f44851a.a(true);
                        return;
                    }
                    this.f44853a.f44851a.f44846f.setText(g.sapi_sdk_sms_get_check_code);
                    this.f44853a.f44851a.a(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                    TextView textView = this.f44853a.f44851a.f44846f;
                    textView.setText((j2 / 1000) + this.f44853a.f44851a.f44841a.getString(g.sapi_sdk_sms_second));
                    this.f44853a.f44851a.f44846f.setEnabled(false);
                    this.f44853a.f44851a.a(false);
                }
            }
        }

        public GetCheckCodeListener(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44851a = smsLoginView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.f44851a.o == null || this.f44851a.o.across(1)) && this.f44851a.f44844d.getText().toString().length() == 11) {
                    SmsLoginView smsLoginView = this.f44851a;
                    smsLoginView.m = smsLoginView.f44846f.getText().toString().equals(this.f44851a.f44841a.getString(g.sapi_sdk_sms_get_check_code));
                    this.f44851a.f44847g.setVisibility(8);
                    this.f44851a.f44847g.setText("");
                    this.f44851a.f44845e.requestFocus();
                    this.f44851a.k = new a(this, 60000L, 1000L);
                    this.f44851a.k.start();
                    SmsLoginView smsLoginView2 = this.f44851a;
                    smsLoginView2.l = smsLoginView2.f44844d.getText().toString();
                    String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
                    HashMap hashMap = new HashMap();
                    if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                        hashMap.put("extrajson", smsLoginStatExtra);
                    }
                    hashMap.put(SmsLoginView.r, "pop_login");
                    hashMap.put(SmsLoginView.t, "1");
                    SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback(this) { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ GetCheckCodeListener f44852a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f44852a = this;
                        }

                        public void onFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            }
                        }

                        public void onStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, getDynamicPwdResult) == null) {
                                if (this.f44852a.f44851a.m) {
                                    SmsLoginView.b(f.f44864f, getDynamicPwdResult.getResultCode() + "");
                                } else {
                                    SmsLoginView.b(f.f44867i, getDynamicPwdResult.getResultCode() + "");
                                }
                                if (this.f44852a.f44851a.k != null) {
                                    this.f44852a.f44851a.k.cancel();
                                }
                                WebAuthResult webAuthResult = new WebAuthResult();
                                webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                                webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.f44852a.f44851a.l;
                                SmsViewLoginCallback smsViewLoginCallback = this.f44852a.f44851a.getSmsViewLoginCallback();
                                if (smsViewLoginCallback != null) {
                                    this.f44852a.f44851a.l = "";
                                    smsViewLoginCallback.onNeedBack(webAuthResult);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, getDynamicPwdResult) == null) {
                                if (this.f44852a.f44851a.m) {
                                    SmsLoginView.b(f.f44864f, getDynamicPwdResult.getResultCode() + "");
                                    this.f44852a.f44851a.f44846f.setText(g.sapi_sdk_sms_get_check_code);
                                } else {
                                    SmsLoginView.b(f.f44867i, getDynamicPwdResult.getResultCode() + "");
                                    this.f44852a.f44851a.f44846f.setText(g.sapi_sdk_sms_re_get_check_code);
                                }
                                if (this.f44852a.f44851a.k != null) {
                                    this.f44852a.f44851a.k.cancel();
                                }
                                this.f44852a.f44851a.f44846f.setEnabled(true);
                                this.f44852a.f44851a.a(true);
                                if (getDynamicPwdResult.noNeedBack) {
                                    this.f44852a.f44851a.f44847g.setText(getDynamicPwdResult.getResultMsg());
                                    this.f44852a.f44851a.f44847g.setVisibility(0);
                                    return;
                                }
                                WebAuthResult webAuthResult = new WebAuthResult();
                                webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                                webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.f44852a.f44851a.l;
                                SmsViewLoginCallback smsViewLoginCallback = this.f44852a.f44851a.getSmsViewLoginCallback();
                                if (smsViewLoginCallback != null) {
                                    this.f44852a.f44851a.l = "";
                                    smsViewLoginCallback.onNeedBack(webAuthResult);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048582, this, getDynamicPwdResult) == null) {
                                if (this.f44852a.f44851a.m) {
                                    SmsLoginView.b(f.f44863e, (String) null);
                                } else {
                                    SmsLoginView.b(f.f44866h, (String) null);
                                }
                            }
                        }
                    }, this.f44851a.l, null, hashMap);
                    if (this.f44851a.m) {
                        SmsLoginView.b(f.f44862d, (String) null);
                    } else {
                        SmsLoginView.b(f.f44865g, (String) null);
                    }
                }
            }
        }

        public /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }
    }

    /* loaded from: classes5.dex */
    public interface PrivacyAgreementIntercept extends NoProguard {
        public static final int LOGIN = 2;
        public static final int SNED_SMS = 1;

        boolean across(int i2);
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmsLoginView f44854a;

        public a(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44854a = smsLoginView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44854a.f44845e.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) this.f44854a.f44841a.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f44854a.f44844d, 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends DynamicPwdLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmsLoginView f44855a;

        public b(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44855a = smsLoginView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dynamicPwdLoginResult) == null) {
                SmsLoginView.b(f.l, dynamicPwdLoginResult.getResultCode() + "");
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                if (dynamicPwdLoginResult.noNeedBack) {
                    this.f44855a.f44847g.setText(dynamicPwdLoginResult.getResultMsg());
                    this.f44855a.f44847g.setVisibility(0);
                    this.f44855a.f44845e.setText("");
                    SmsViewLoginCallback smsViewLoginCallback = this.f44855a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback != null) {
                        smsViewLoginCallback.onFailure(webAuthResult);
                        return;
                    }
                    return;
                }
                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.f44855a.l;
                SmsViewLoginCallback smsViewLoginCallback2 = this.f44855a.getSmsViewLoginCallback();
                if (smsViewLoginCallback2 != null) {
                    this.f44855a.l = "";
                    smsViewLoginCallback2.onNeedBack(webAuthResult);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dynamicPwdLoginResult) == null) {
                SmsLoginView.b("success", (String) null);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                webAuthResult.accountType = AccountType.NORMAL;
                SmsViewLoginCallback smsViewLoginCallback = this.f44855a.getSmsViewLoginCallback();
                if (smsViewLoginCallback != null) {
                    SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, this.f44855a.l);
                    SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "sms");
                    smsViewLoginCallback.onSuccess(webAuthResult);
                }
                new PtokenStat().onEvent(PtokenStat.LOGIN_POP);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f44855a.a();
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f44855a.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmsLoginView f44856a;

        public c(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44856a = smsLoginView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                int length = charSequence.toString().length();
                if (length == 0) {
                    this.f44856a.f44845e.setGravity(19);
                } else if (length != 1) {
                    if (length == 6 && !TextUtils.isEmpty(this.f44856a.l)) {
                        this.f44856a.c();
                    }
                } else {
                    this.f44856a.f44847g.setText("");
                    this.f44856a.f44847g.setVisibility(8);
                    this.f44856a.f44845e.setGravity(17);
                }
            }
        }

        public /* synthetic */ c(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmsLoginView f44857a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SmsLoginView smsLoginView, Context context) {
            super(context, h.sapi_sdk_empty_dialog);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44857a = smsLoginView;
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmsLoginView f44858a;

        public e(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44858a = smsLoginView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                int length = charSequence.toString().length();
                if (length == 0) {
                    SmsViewLoginCallback smsViewLoginCallback = this.f44858a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback != null) {
                        smsViewLoginCallback.onCheckCodeViewHide();
                    }
                    this.f44858a.f44843c.setVisibility(8);
                    this.f44858a.f44847g.setVisibility(8);
                    this.f44858a.f44847g.setText("");
                    this.f44858a.f44844d.setGravity(19);
                } else if (this.f44858a.f44843c.getVisibility() != 0) {
                    SmsViewLoginCallback smsViewLoginCallback2 = this.f44858a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback2 != null) {
                        smsViewLoginCallback2.onCheckCodeViewShow();
                    }
                    this.f44858a.f44843c.setVisibility(0);
                    this.f44858a.f44844d.setGravity(17);
                }
                if (length == 10) {
                    if (TextUtils.isEmpty(this.f44858a.l)) {
                        this.f44858a.f44846f.setText(g.sapi_sdk_sms_get_check_code);
                        this.f44858a.a(false);
                        this.f44858a.f44847g.setVisibility(8);
                        this.f44858a.f44847g.setText("");
                        this.f44858a.f44846f.setEnabled(false);
                    }
                } else if (length == 11) {
                    if (!this.f44858a.f44844d.getText().toString().equals(this.f44858a.l)) {
                        if (this.f44858a.k != null) {
                            this.f44858a.k.cancel();
                        }
                        this.f44858a.f44846f.setText(g.sapi_sdk_sms_get_check_code);
                        this.f44858a.a(true);
                        if (SapiUtils.validateMobile(charSequence.toString())) {
                            this.f44858a.f44846f.setEnabled(true);
                        } else {
                            this.f44858a.f44847g.setVisibility(0);
                            this.f44858a.f44847g.setText(g.sapi_sdk_sms_prompt_phone_number_error);
                        }
                    }
                    SmsLoginView.b(f.f44861c, (String) null);
                }
            }
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }
    }

    /* loaded from: classes5.dex */
    public interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final String f44859a = "pop_login";

        /* renamed from: b  reason: collision with root package name */
        public static final String f44860b = "show";

        /* renamed from: c  reason: collision with root package name */
        public static final String f44861c = "input_phone";

        /* renamed from: d  reason: collision with root package name */
        public static final String f44862d = "first_get_dpass";

        /* renamed from: e  reason: collision with root package name */
        public static final String f44863e = "first_get_dpass_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f44864f = "first_get_dpass_failure";

        /* renamed from: g  reason: collision with root package name */
        public static final String f44865g = "get_dpass_again";

        /* renamed from: h  reason: collision with root package name */
        public static final String f44866h = "get_dpass_again_success";

        /* renamed from: i  reason: collision with root package name */
        public static final String f44867i = "get_dpass_again_failure";

        /* renamed from: j  reason: collision with root package name */
        public static final String f44868j = "verify";
        public static final String k = "success";
        public static final String l = "failure";
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(652276083, "Lcom/baidu/sapi2/views/SmsLoginView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(652276083, "Lcom/baidu/sapi2/views/SmsLoginView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmsLoginView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmsViewLoginCallback getSmsViewLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) ? CoreViewRouter.getInstance().getSmsViewLoginCallback(getSmsLoginViewIndex()) : (SmsViewLoginCallback) invokeV.objValue;
    }

    public static void notifyStartLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            b("show", (String) null);
        }
    }

    public void clean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f44845e.setText("");
            this.f44844d.setText("");
            CountDownTimer countDownTimer = this.k;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f44846f.setText(g.sapi_sdk_sms_get_check_code);
            a(false);
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CountDownTimer countDownTimer = this.k;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CoreViewRouter.getInstance().release();
        }
    }

    public int getSmsLoginViewIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.intValue;
    }

    public void setDarkMode(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && this.n == (!z)) {
            this.n = z;
            d();
            a(false);
        }
    }

    public void setSendVerificationCodeIntercept(PrivacyAgreementIntercept privacyAgreementIntercept) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, privacyAgreementIntercept) == null) {
            this.o = privacyAgreementIntercept;
        }
    }

    public void setSmsLoginViewIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.p = i2;
        }
    }

    public void try2SmsLogin() {
        EditText editText;
        Editable text;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (editText = this.f44845e) == null || (text = editText.getText()) == null || text.toString().length() < 6) {
            return;
        }
        PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
        if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
            c();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
            if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
                String obj = this.f44845e.getText().toString();
                String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put(r, "pop_login");
                SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new b(this), this.l, obj, hashMap);
                b(f.f44868j, (String) null);
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            try {
                if (this.n) {
                    this.f44842b.setBackgroundColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_bg_night_mode));
                    this.f44844d.setTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
                    this.f44844d.setHintTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_hint_color_night_mode));
                    this.f44845e.setTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
                    this.f44845e.setHintTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
                    this.f44847g.setTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
                    this.f44848h.setBackgroundColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_separate_line_color_night_mode));
                    Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField.setAccessible(true);
                    declaredField.set(this.f44845e, Integer.valueOf(c.a.c0.a.d.sapi_sdk_input_edit_text_cursor_bg_night));
                } else {
                    this.f44842b.setBackgroundColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_bg_light_mode));
                    this.f44844d.setTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_phone_text_color));
                    this.f44844d.setHintTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_hint_color));
                    this.f44845e.setTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_check_code_text_color));
                    this.f44845e.setHintTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_edit_check_code_hint_text_color));
                    this.f44847g.setTextColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_prompt_phone_number_error_color));
                    this.f44848h.setBackgroundColor(getResources().getColor(c.a.c0.a.b.sapi_sdk_separate_line_color));
                    Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField2.setAccessible(true);
                    declaredField2.set(this.f44845e, Integer.valueOf(c.a.c0.a.d.sapi_sdk_input_edit_text_cursor_bg));
                }
            } catch (Exception unused) {
            }
            a(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        boolean z = true;
        this.m = true;
        this.p = -1;
        this.f44841a = context;
        this.f44842b = LayoutInflater.from(context).inflate(c.a.c0.a.f.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_sms_login_view, i2, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.f44843c = this.f44842b.findViewById(c.a.c0.a.e.code_container);
        this.f44844d = (EditText) this.f44842b.findViewById(c.a.c0.a.e.phone);
        this.f44849i = this.f44842b.findViewById(c.a.c0.a.e.loading_container);
        this.f44845e = (EditText) this.f44842b.findViewById(c.a.c0.a.e.check_code);
        this.f44846f = (TextView) this.f44842b.findViewById(c.a.c0.a.e.get_code);
        this.f44847g = (TextView) this.f44842b.findViewById(c.a.c0.a.e.prompt);
        this.f44848h = this.f44842b.findViewById(c.a.c0.a.e.separate_line);
        a(this.f44844d, context.getString(g.sapi_sdk_sms_hint_input_phone));
        a(this.f44845e, context.getString(g.sapi_sdk_sms_hint_input_check_code));
        this.f44844d.addTextChangedListener(new e(this, null));
        this.f44845e.addTextChangedListener(new c(this, null));
        this.f44846f.setEnabled(false);
        this.f44846f.setOnClickListener(new GetCheckCodeListener(this, null));
        if (SapiAccountManager.getInstance().getSapiConfiguration() != null) {
            if (!SapiAccountManager.getInstance().getSapiConfiguration().isNightMode && !SapiAccountManager.getInstance().getSapiConfiguration().isDarkMode) {
                z = false;
            }
            this.n = z;
        } else {
            this.n = false;
        }
        d();
        if (z2) {
            new Handler().postDelayed(new a(this), 100L);
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null) {
            ViewUtility.enlargedViews(this.f44844d, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f44845e, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f44846f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedOtherView(this.f44846f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedViews(this.f44847g, sapiConfiguration.textZoom);
        }
        if (SapiUtils.getLastLoginType() != 2) {
            return;
        }
        String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
        if (TextUtils.isEmpty(decryptStr) || decryptStr.length() != 11) {
            return;
        }
        this.f44844d.setText(decryptStr);
        this.f44844d.setSelection(decryptStr.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f44849i.setVisibility(0);
            d dVar = new d(this, this.f44841a);
            this.f44850j = dVar;
            dVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_get_code_text_color);
            int i2 = -1;
            if (this.n) {
                i2 = getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_bg_night_mode);
                if (z) {
                    color = getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_get_code_text_color_night_mode);
                } else {
                    color = getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_get_code_disable_color_night_mode);
                }
            } else if (z) {
                color = getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_get_code_text_color);
            } else {
                color = getResources().getColor(c.a.c0.a.b.sapi_sdk_sms_get_code_disable_color);
            }
            GradientDrawable gradientDrawable = (GradientDrawable) this.f44846f.getBackground();
            gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
            gradientDrawable.setColor(i2);
            this.f44846f.setTextColor(color);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("pop_login", str);
            HashMap hashMap = new HashMap(1);
            hashMap.put("extrajson", CoreViewRouter.getInstance().getSmsLoginStatExtra());
            hashMap.put("errno", str2);
            StatService.onEventAutoStatistic(linkedHashMap, hashMap);
        }
    }

    private void a(EditText editText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, editText, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
            editText.setHint(new SpannedString(spannableString));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f44849i.setVisibility(8);
            try {
                this.f44850j.dismiss();
            } catch (Throwable unused) {
            }
        }
    }
}
