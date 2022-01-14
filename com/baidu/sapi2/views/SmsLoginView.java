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
import c.a.e0.a.g;
import c.a.e0.a.h;
import c.a.e0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes10.dex */
public class SmsLoginView extends FrameLayout implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String q = "extrajson";
    public static final String r = "sdk_situation";
    public static final String s = "pop_login";
    public static final String t = "skipreg";
    public static final int u = 6;
    public static String v;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f38150b;

    /* renamed from: c  reason: collision with root package name */
    public View f38151c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f38152d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f38153e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38154f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38155g;

    /* renamed from: h  reason: collision with root package name */
    public View f38156h;

    /* renamed from: i  reason: collision with root package name */
    public View f38157i;

    /* renamed from: j  reason: collision with root package name */
    public Dialog f38158j;
    public CountDownTimer k;
    public String l;
    public boolean m;
    public boolean n;
    public PrivacyAgreementIntercept o;
    public SmsViewLoginCallback p;

    /* loaded from: classes10.dex */
    public class GetCheckCodeListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

        /* loaded from: classes10.dex */
        public class a extends CountDownTimer {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GetCheckCodeListener a;

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
                this.a = getCheckCodeListener;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.a.f38152d.getText().toString().length() == 11) {
                        this.a.a.f38154f.setEnabled(true);
                        this.a.a.f38154f.setText(g.sapi_sdk_sms_re_get_check_code);
                        this.a.a.a(true);
                        return;
                    }
                    this.a.a.f38154f.setText(g.sapi_sdk_sms_get_check_code);
                    this.a.a.a(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                    TextView textView = this.a.a.f38154f;
                    textView.setText((j2 / 1000) + this.a.a.a.getString(g.sapi_sdk_sms_second));
                    this.a.a.f38154f.setEnabled(false);
                    this.a.a.a(false);
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
            this.a = smsLoginView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.a.o == null || this.a.o.across(1)) && this.a.f38152d.getText().toString().length() == 11) {
                    SmsLoginView smsLoginView = this.a;
                    smsLoginView.m = smsLoginView.f38154f.getText().toString().equals(this.a.a.getString(g.sapi_sdk_sms_get_check_code));
                    this.a.f38155g.setVisibility(8);
                    this.a.f38155g.setText("");
                    this.a.f38153e.requestFocus();
                    this.a.k = new a(this, 60000L, 1000L);
                    this.a.k.start();
                    SmsLoginView smsLoginView2 = this.a;
                    smsLoginView2.l = smsLoginView2.f38152d.getText().toString();
                    String smsLoginStatExtra = SmsLoginView.getSmsLoginStatExtra();
                    HashMap hashMap = new HashMap();
                    if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                        hashMap.put("extrajson", smsLoginStatExtra);
                    }
                    hashMap.put(SmsLoginView.r, "pop_login");
                    hashMap.put(SmsLoginView.t, "1");
                    SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback(this) { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ GetCheckCodeListener a;

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
                            this.a = this;
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
                                if (this.a.a.m) {
                                    SmsLoginView.b(f.f38163f, getDynamicPwdResult.getResultCode() + "");
                                } else {
                                    SmsLoginView.b(f.f38166i, getDynamicPwdResult.getResultCode() + "");
                                }
                                if (this.a.a.k != null) {
                                    this.a.a.k.cancel();
                                }
                                WebAuthResult webAuthResult = new WebAuthResult();
                                webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                                webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.a.a.l;
                                SmsViewLoginCallback smsViewLoginCallback = this.a.a.getSmsViewLoginCallback();
                                if (smsViewLoginCallback != null) {
                                    this.a.a.l = "";
                                    smsViewLoginCallback.onNeedBack(webAuthResult);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, getDynamicPwdResult) == null) {
                                if (this.a.a.m) {
                                    SmsLoginView.b(f.f38163f, getDynamicPwdResult.getResultCode() + "");
                                    this.a.a.f38154f.setText(g.sapi_sdk_sms_get_check_code);
                                } else {
                                    SmsLoginView.b(f.f38166i, getDynamicPwdResult.getResultCode() + "");
                                    this.a.a.f38154f.setText(g.sapi_sdk_sms_re_get_check_code);
                                }
                                if (this.a.a.k != null) {
                                    this.a.a.k.cancel();
                                }
                                this.a.a.f38154f.setEnabled(true);
                                this.a.a.a(true);
                                if (getDynamicPwdResult.noNeedBack) {
                                    this.a.a.f38155g.setText(getDynamicPwdResult.getResultMsg());
                                    this.a.a.f38155g.setVisibility(0);
                                    return;
                                }
                                WebAuthResult webAuthResult = new WebAuthResult();
                                webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                                webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.a.a.l;
                                SmsViewLoginCallback smsViewLoginCallback = this.a.a.getSmsViewLoginCallback();
                                if (smsViewLoginCallback != null) {
                                    this.a.a.l = "";
                                    smsViewLoginCallback.onNeedBack(webAuthResult);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048582, this, getDynamicPwdResult) == null) {
                                if (this.a.a.m) {
                                    SmsLoginView.b(f.f38162e, (String) null);
                                } else {
                                    SmsLoginView.b(f.f38165h, (String) null);
                                }
                            }
                        }
                    }, this.a.l, null, hashMap);
                    if (this.a.m) {
                        SmsLoginView.b(f.f38161d, (String) null);
                    } else {
                        SmsLoginView.b(f.f38164g, (String) null);
                    }
                }
            }
        }

        public /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }
    }

    /* loaded from: classes10.dex */
    public interface PrivacyAgreementIntercept extends NoProguard {
        public static final int LOGIN = 2;
        public static final int SNED_SMS = 1;

        boolean across(int i2);
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

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
            this.a = smsLoginView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f38153e.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) this.a.a.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.a.f38152d, 0);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends DynamicPwdLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

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
            this.a = smsLoginView;
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
                    this.a.f38155g.setText(dynamicPwdLoginResult.getResultMsg());
                    this.a.f38155g.setVisibility(0);
                    this.a.f38153e.setText("");
                    SmsViewLoginCallback smsViewLoginCallback = this.a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback != null) {
                        smsViewLoginCallback.onFailure(webAuthResult);
                        return;
                    }
                    return;
                }
                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.a.l;
                SmsViewLoginCallback smsViewLoginCallback2 = this.a.getSmsViewLoginCallback();
                if (smsViewLoginCallback2 != null) {
                    this.a.l = "";
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
                SmsViewLoginCallback smsViewLoginCallback = this.a.getSmsViewLoginCallback();
                if (smsViewLoginCallback != null) {
                    SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, this.a.l);
                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.SMS.getName());
                    smsViewLoginCallback.onSuccess(webAuthResult);
                }
                new PtokenStat().onEvent(PtokenStat.LOGIN_POP);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.b();
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

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
            this.a = smsLoginView;
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
                    this.a.f38153e.setGravity(19);
                } else if (1 == length) {
                    this.a.f38155g.setText("");
                    this.a.f38155g.setVisibility(8);
                    this.a.f38153e.setGravity(17);
                } else if (length != SapiAccountManager.getInstance().getSmsCodeLength() || TextUtils.isEmpty(this.a.l)) {
                } else {
                    this.a.d();
                }
            }
        }

        public /* synthetic */ c(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }
    }

    /* loaded from: classes10.dex */
    public class d extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

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
            this.a = smsLoginView;
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    /* loaded from: classes10.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

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
            this.a = smsLoginView;
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
                    SmsViewLoginCallback smsViewLoginCallback = this.a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback != null) {
                        smsViewLoginCallback.onCheckCodeViewHide();
                    }
                    this.a.f38151c.setVisibility(8);
                    this.a.f38155g.setVisibility(8);
                    this.a.f38155g.setText("");
                    this.a.f38152d.setGravity(19);
                } else if (this.a.f38151c.getVisibility() != 0) {
                    SmsViewLoginCallback smsViewLoginCallback2 = this.a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback2 != null) {
                        smsViewLoginCallback2.onCheckCodeViewShow();
                    }
                    this.a.f38151c.setVisibility(0);
                    this.a.f38152d.setGravity(17);
                }
                if (length == 10) {
                    if (TextUtils.isEmpty(this.a.l)) {
                        this.a.f38154f.setText(g.sapi_sdk_sms_get_check_code);
                        this.a.a(false);
                        this.a.f38155g.setVisibility(8);
                        this.a.f38155g.setText("");
                        this.a.f38154f.setEnabled(false);
                    }
                } else if (length == 11) {
                    if (!this.a.f38152d.getText().toString().equals(this.a.l)) {
                        if (this.a.k != null) {
                            this.a.k.cancel();
                        }
                        this.a.f38154f.setText(g.sapi_sdk_sms_get_check_code);
                        this.a.a(true);
                        if (SapiUtils.validateMobile(charSequence.toString())) {
                            this.a.f38154f.setEnabled(true);
                        } else {
                            this.a.f38155g.setVisibility(0);
                            this.a.f38155g.setText(g.sapi_sdk_sms_prompt_phone_number_error);
                        }
                    }
                    SmsLoginView.b(f.f38160c, (String) null);
                }
            }
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }
    }

    /* loaded from: classes10.dex */
    public interface f {
        public static final String a = "pop_login";

        /* renamed from: b  reason: collision with root package name */
        public static final String f38159b = "show";

        /* renamed from: c  reason: collision with root package name */
        public static final String f38160c = "input_phone";

        /* renamed from: d  reason: collision with root package name */
        public static final String f38161d = "first_get_dpass";

        /* renamed from: e  reason: collision with root package name */
        public static final String f38162e = "first_get_dpass_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f38163f = "first_get_dpass_failure";

        /* renamed from: g  reason: collision with root package name */
        public static final String f38164g = "get_dpass_again";

        /* renamed from: h  reason: collision with root package name */
        public static final String f38165h = "get_dpass_again_success";

        /* renamed from: i  reason: collision with root package name */
        public static final String f38166i = "get_dpass_again_failure";

        /* renamed from: j  reason: collision with root package name */
        public static final String f38167j = "verify";
        public static final String k = "success";
        public static final String l = "failure";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmsLoginView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String getSmsLoginStatExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (v == null) {
                v = CoreViewRouter.getInstance().getSmsLoginStatExtra();
            }
            return WebLoginDTO.getStatExtraDecode(v);
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmsViewLoginCallback getSmsViewLoginCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (this.p == null) {
                this.p = CoreViewRouter.getInstance().getSmsViewLoginCallback();
                CoreViewRouter.getInstance().releaseSmsViewLoginCallback();
            }
            return this.p;
        }
        return (SmsViewLoginCallback) invokeV.objValue;
    }

    public static void notifyStartLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            b("show", (String) null);
        }
    }

    public void clean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f38153e.setText("");
            this.f38152d.setText("");
            CountDownTimer countDownTimer = this.k;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f38154f.setText(g.sapi_sdk_sms_get_check_code);
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

    public void setDarkMode(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.n == (!z)) {
            this.n = z;
            e();
            a(false);
        }
    }

    public void setSendVerificationCodeIntercept(PrivacyAgreementIntercept privacyAgreementIntercept) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, privacyAgreementIntercept) == null) {
            this.o = privacyAgreementIntercept;
        }
    }

    public void setSmsLoginStatExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            v = str;
        }
    }

    public void setSmsViewLoginCallback(SmsViewLoginCallback smsViewLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, smsViewLoginCallback) == null) {
            this.p = smsViewLoginCallback;
        }
    }

    public void try2SmsLogin() {
        EditText editText;
        Editable text;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (editText = this.f38153e) == null || (text = editText.getText()) == null || text.toString().length() < 6) {
            return;
        }
        PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
        if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
            d();
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f38157i.setVisibility(0);
            d dVar = new d(this, this.a);
            this.f38158j = dVar;
            dVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
            if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
                String obj = this.f38153e.getText().toString();
                String smsLoginStatExtra = getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put(r, "pop_login");
                SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new b(this), this.l, obj, hashMap);
                b(f.f38167j, (String) null);
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            try {
                if (this.n) {
                    this.f38150b.setBackgroundColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_bg_night_mode));
                    this.f38152d.setTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
                    this.f38152d.setHintTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_hint_color_night_mode));
                    this.f38153e.setTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
                    this.f38153e.setHintTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
                    this.f38155g.setTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
                    this.f38156h.setBackgroundColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_separate_line_color_night_mode));
                    Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField.setAccessible(true);
                    declaredField.set(this.f38153e, Integer.valueOf(c.a.e0.a.d.sapi_sdk_input_edit_text_cursor_bg_night));
                } else {
                    this.f38150b.setBackgroundColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_bg_light_mode));
                    this.f38152d.setTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_phone_text_color));
                    this.f38152d.setHintTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_hint_color));
                    this.f38153e.setTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_check_code_text_color));
                    this.f38153e.setHintTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_edit_check_code_hint_text_color));
                    this.f38155g.setTextColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_prompt_phone_number_error_color));
                    this.f38156h.setBackgroundColor(getResources().getColor(c.a.e0.a.b.sapi_sdk_separate_line_color));
                    Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField2.setAccessible(true);
                    declaredField2.set(this.f38153e, Integer.valueOf(c.a.e0.a.d.sapi_sdk_input_edit_text_cursor_bg));
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
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        boolean z = true;
        this.m = true;
        this.a = context;
        this.f38150b = LayoutInflater.from(context).inflate(c.a.e0.a.f.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_sms_login_view, i2, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.f38151c = this.f38150b.findViewById(c.a.e0.a.e.code_container);
        this.f38152d = (EditText) this.f38150b.findViewById(c.a.e0.a.e.phone);
        this.f38157i = this.f38150b.findViewById(c.a.e0.a.e.loading_container);
        this.f38153e = (EditText) this.f38150b.findViewById(c.a.e0.a.e.check_code);
        this.f38154f = (TextView) this.f38150b.findViewById(c.a.e0.a.e.get_code);
        this.f38155g = (TextView) this.f38150b.findViewById(c.a.e0.a.e.prompt);
        this.f38156h = this.f38150b.findViewById(c.a.e0.a.e.separate_line);
        a(this.f38152d, context.getString(g.sapi_sdk_sms_hint_input_phone));
        a(this.f38153e, context.getString(g.sapi_sdk_sms_hint_input_check_code));
        this.f38152d.addTextChangedListener(new e(this, null));
        this.f38153e.addTextChangedListener(new c(this, null));
        this.f38154f.setEnabled(false);
        this.f38154f.setOnClickListener(new GetCheckCodeListener(this, null));
        if (SapiAccountManager.getInstance().getSapiConfiguration() != null) {
            if (!SapiAccountManager.getInstance().getSapiConfiguration().isNightMode && !SapiAccountManager.getInstance().getSapiConfiguration().isDarkMode) {
                z = false;
            }
            this.n = z;
        } else {
            this.n = false;
        }
        e();
        if (z2) {
            new Handler().postDelayed(new a(this), 100L);
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null) {
            ViewUtility.enlargedViews(this.f38152d, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f38153e, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f38154f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedOtherView(this.f38154f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedViews(this.f38155g, sapiConfiguration.textZoom);
        }
        if (SapiUtils.getLastLoginType() != Enums.LastLoginType.SMS.getValue()) {
            return;
        }
        String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
        if (TextUtils.isEmpty(decryptStr) || decryptStr.length() != 11) {
            return;
        }
        this.f38152d.setText(decryptStr);
        this.f38152d.setSelection(decryptStr.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f38157i.setVisibility(8);
            try {
                this.f38158j.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("pop_login", str);
            HashMap hashMap = new HashMap(1);
            hashMap.put("extrajson", getSmsLoginStatExtra());
            hashMap.put("errno", str2);
            StatService.onEventAutoStatistic(linkedHashMap, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_get_code_text_color);
            int i2 = -1;
            if (this.n) {
                i2 = getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_bg_night_mode);
                if (z) {
                    color = getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_get_code_text_color_night_mode);
                } else {
                    color = getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_get_code_disable_color_night_mode);
                }
            } else if (z) {
                color = getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_get_code_text_color);
            } else {
                color = getResources().getColor(c.a.e0.a.b.sapi_sdk_sms_get_code_disable_color);
            }
            GradientDrawable gradientDrawable = (GradientDrawable) this.f38154f.getBackground();
            gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
            gradientDrawable.setColor(i2);
            this.f38154f.setTextColor(color);
        }
    }

    private void a(EditText editText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, editText, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
            editText.setHint(new SpannedString(spannableString));
        }
    }
}
