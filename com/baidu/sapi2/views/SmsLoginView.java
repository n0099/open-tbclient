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
import com.baidu.tieba.R;
import com.baidu.tieba.ta1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
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
    public View b;
    public View c;
    public EditText d;
    public EditText e;
    public TextView f;
    public TextView g;
    public View h;
    public View i;
    public Dialog j;
    public CountDownTimer k;
    public String l;
    public boolean m;
    public boolean n;
    public PrivacyAgreementIntercept o;
    public SmsViewLoginCallback p;

    /* loaded from: classes2.dex */
    public interface PrivacyAgreementIntercept extends NoProguard {
        public static final int LOGIN = 2;
        public static final int SNED_SMS = 1;

        boolean across(int i);
    }

    /* loaded from: classes2.dex */
    public interface f {
        public static final String a = "pop_login";
        public static final String b = "show";
        public static final String c = "input_phone";
        public static final String d = "first_get_dpass";
        public static final String e = "first_get_dpass_success";
        public static final String f = "first_get_dpass_failure";
        public static final String g = "get_dpass_again";
        public static final String h = "get_dpass_again_success";
        public static final String i = "get_dpass_again_failure";
        public static final String j = "verify";
        public static final String k = "success";
        public static final String l = "failure";
    }

    /* loaded from: classes2.dex */
    public class GetCheckCodeListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

        /* loaded from: classes2.dex */
        public class a extends CountDownTimer {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GetCheckCodeListener a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(GetCheckCodeListener getCheckCodeListener, long j, long j2) {
                super(j, j2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {getCheckCodeListener, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    if (this.a.a.d.getText().toString().length() == 11) {
                        this.a.a.f.setEnabled(true);
                        this.a.a.f.setText(R.string.sapi_sdk_sms_re_get_check_code);
                        this.a.a.a(true);
                        return;
                    }
                    this.a.a.f.setText(R.string.sapi_sdk_sms_get_check_code);
                    this.a.a.a(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) {
                    return;
                }
                TextView textView = this.a.a.f;
                textView.setText((j / 1000) + this.a.a.a.getString(R.string.sapi_sdk_sms_second));
                this.a.a.f.setEnabled(false);
                this.a.a.a(false);
            }
        }

        public GetCheckCodeListener(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smsLoginView;
        }

        public /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.o != null && !this.a.o.across(1)) || this.a.d.getText().toString().length() != 11) {
                    return;
                }
                SmsLoginView smsLoginView = this.a;
                smsLoginView.m = smsLoginView.f.getText().toString().equals(this.a.a.getString(R.string.sapi_sdk_sms_get_check_code));
                this.a.g.setVisibility(8);
                this.a.g.setText("");
                this.a.e.requestFocus();
                this.a.k = new a(this, 60000L, 1000L);
                this.a.k.start();
                SmsLoginView smsLoginView2 = this.a;
                smsLoginView2.l = smsLoginView2.d.getText().toString();
                String smsLoginStatExtra = SmsLoginView.getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put("sdk_situation", "pop_login");
                hashMap.put("skipreg", "1");
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback(this) { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GetCheckCodeListener a;

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

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048582, this, getDynamicPwdResult) == null) {
                            if (this.a.a.m) {
                                SmsLoginView.b(f.e, (String) null);
                            } else {
                                SmsLoginView.b(f.h, (String) null);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, getDynamicPwdResult) == null) {
                            if (this.a.a.m) {
                                SmsLoginView.b(f.f, getDynamicPwdResult.getResultCode() + "");
                            } else {
                                SmsLoginView.b(f.i, getDynamicPwdResult.getResultCode() + "");
                            }
                            if (this.a.a.k != null) {
                                this.a.a.k.cancel();
                            }
                            WebAuthResult webAuthResult = new WebAuthResult();
                            webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                            webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                            SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.a.a.l;
                            SmsViewLoginCallback smsViewLoginCallback = this.a.a.getSmsViewLoginCallback();
                            if (smsViewLoginCallback == null) {
                                return;
                            }
                            this.a.a.l = "";
                            smsViewLoginCallback.onNeedBack(webAuthResult);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, getDynamicPwdResult) == null) {
                            if (this.a.a.m) {
                                SmsLoginView.b(f.f, getDynamicPwdResult.getResultCode() + "");
                                this.a.a.f.setText(R.string.sapi_sdk_sms_get_check_code);
                            } else {
                                SmsLoginView.b(f.i, getDynamicPwdResult.getResultCode() + "");
                                this.a.a.f.setText(R.string.sapi_sdk_sms_re_get_check_code);
                            }
                            if (this.a.a.k != null) {
                                this.a.a.k.cancel();
                            }
                            this.a.a.f.setEnabled(true);
                            this.a.a.a(true);
                            if (getDynamicPwdResult.noNeedBack) {
                                this.a.a.g.setText(getDynamicPwdResult.getResultMsg());
                                this.a.a.g.setVisibility(0);
                                return;
                            }
                            WebAuthResult webAuthResult = new WebAuthResult();
                            webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                            webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                            SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.a.a.l;
                            SmsViewLoginCallback smsViewLoginCallback = this.a.a.getSmsViewLoginCallback();
                            if (smsViewLoginCallback == null) {
                                return;
                            }
                            this.a.a.l = "";
                            smsViewLoginCallback.onNeedBack(webAuthResult);
                        }
                    }
                }, this.a.l, null, hashMap);
                if (this.a.m) {
                    SmsLoginView.b(f.d, (String) null);
                } else {
                    SmsLoginView.b(f.g, (String) null);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.e.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) this.a.a.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.a.d, 0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    this.a.g.setText(dynamicPwdLoginResult.getResultMsg());
                    this.a.g.setVisibility(0);
                    this.a.e.setText("");
                    SmsViewLoginCallback smsViewLoginCallback = this.a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback != null) {
                        smsViewLoginCallback.onFailure(webAuthResult);
                        return;
                    }
                    return;
                }
                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.a.l;
                SmsViewLoginCallback smsViewLoginCallback2 = this.a.getSmsViewLoginCallback();
                if (smsViewLoginCallback2 == null) {
                    return;
                }
                this.a.l = "";
                smsViewLoginCallback2.onNeedBack(webAuthResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dynamicPwdLoginResult) != null) {
                return;
            }
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

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.a.b();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
                return;
            }
            this.a.c();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public c(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smsLoginView;
        }

        public /* synthetic */ c(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                int length = charSequence.toString().length();
                if (length == 0) {
                    this.a.e.setGravity(19);
                } else if (1 == length) {
                    this.a.g.setText("");
                    this.a.g.setVisibility(8);
                    this.a.e.setGravity(17);
                } else if (length != SapiAccountManager.getInstance().getSmsCodeLength() || TextUtils.isEmpty(this.a.l)) {
                } else {
                    this.a.d();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SmsLoginView smsLoginView, Context context) {
            super(context, R.style.obfuscated_res_0x7f1003ea);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsLoginView a;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public e(SmsLoginView smsLoginView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsLoginView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smsLoginView;
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this(smsLoginView);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                int length = charSequence.toString().length();
                if (length != 0) {
                    if (this.a.c.getVisibility() != 0) {
                        SmsViewLoginCallback smsViewLoginCallback = this.a.getSmsViewLoginCallback();
                        if (smsViewLoginCallback != null) {
                            smsViewLoginCallback.onCheckCodeViewShow();
                        }
                        this.a.c.setVisibility(0);
                        this.a.d.setGravity(17);
                    }
                } else {
                    SmsViewLoginCallback smsViewLoginCallback2 = this.a.getSmsViewLoginCallback();
                    if (smsViewLoginCallback2 != null) {
                        smsViewLoginCallback2.onCheckCodeViewHide();
                    }
                    this.a.c.setVisibility(8);
                    this.a.g.setVisibility(8);
                    this.a.g.setText("");
                    this.a.d.setGravity(19);
                }
                if (length == 10) {
                    if (TextUtils.isEmpty(this.a.l)) {
                        this.a.f.setText(R.string.sapi_sdk_sms_get_check_code);
                        this.a.a(false);
                        this.a.g.setVisibility(8);
                        this.a.g.setText("");
                        this.a.f.setEnabled(false);
                    }
                } else if (length == 11) {
                    if (!this.a.d.getText().toString().equals(this.a.l)) {
                        if (this.a.k != null) {
                            this.a.k.cancel();
                        }
                        this.a.f.setText(R.string.sapi_sdk_sms_get_check_code);
                        this.a.a(true);
                        if (SapiUtils.validateMobile(charSequence.toString())) {
                            this.a.f.setEnabled(true);
                        } else {
                            this.a.g.setVisibility(0);
                            this.a.g.setText(R.string.sapi_sdk_sms_prompt_phone_number_error);
                        }
                    }
                    SmsLoginView.b(f.c, (String) null);
                }
            }
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
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.b = LayoutInflater.from(context).inflate(R.layout.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ta1.sapi_sdk_sms_login_view, i, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        this.c = this.b.findViewById(R.id.code_container);
        this.d = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f091a6a);
        this.i = this.b.findViewById(R.id.loading_container);
        this.e = (EditText) this.b.findViewById(R.id.check_code);
        this.f = (TextView) this.b.findViewById(R.id.get_code);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b88);
        this.h = this.b.findViewById(R.id.separate_line);
        a(this.d, context.getString(R.string.sapi_sdk_sms_hint_input_phone));
        a(this.e, context.getString(R.string.sapi_sdk_sms_hint_input_check_code));
        this.d.addTextChangedListener(new e(this, null));
        this.e.addTextChangedListener(new c(this, null));
        this.f.setEnabled(false);
        this.f.setOnClickListener(new GetCheckCodeListener(this, null));
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
            ViewUtility.enlargedViews(this.d, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.e, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedOtherView(this.f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedViews(this.g, sapiConfiguration.textZoom);
        }
        if (SapiUtils.getLastLoginType() != Enums.LastLoginType.SMS.getValue()) {
            return;
        }
        String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
        if (!TextUtils.isEmpty(decryptStr) && decryptStr.length() == 11) {
            this.d.setText(decryptStr);
            this.d.setSelection(decryptStr.length());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.i.setVisibility(8);
            try {
                this.j.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.i.setVisibility(0);
            d dVar = new d(this, this.a);
            this.j = dVar;
            dVar.show();
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
            this.e.setText("");
            this.d.setText("");
            CountDownTimer countDownTimer = this.k;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f.setText(R.string.sapi_sdk_sms_get_check_code);
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

    private void a(EditText editText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, editText, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
            editText.setHint(new SpannedString(spannableString));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            getResources().getColor(R.color.sapi_sdk_sms_get_code_text_color);
            int i = -1;
            if (this.n) {
                i = getResources().getColor(R.color.sapi_sdk_sms_bg_night_mode);
                if (z) {
                    color = getResources().getColor(R.color.sapi_sdk_sms_get_code_text_color_night_mode);
                } else {
                    color = getResources().getColor(R.color.sapi_sdk_sms_get_code_disable_color_night_mode);
                }
            } else if (z) {
                color = getResources().getColor(R.color.sapi_sdk_sms_get_code_text_color);
            } else {
                color = getResources().getColor(R.color.sapi_sdk_sms_get_code_disable_color);
            }
            GradientDrawable gradientDrawable = (GradientDrawable) this.f.getBackground();
            gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
            gradientDrawable.setColor(i);
            this.f.setTextColor(color);
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
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
            if (privacyAgreementIntercept != null && !privacyAgreementIntercept.across(2)) {
                return;
            }
            String obj = this.e.getText().toString();
            String smsLoginStatExtra = getSmsLoginStatExtra();
            HashMap hashMap = new HashMap();
            if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                hashMap.put("extrajson", smsLoginStatExtra);
            }
            hashMap.put("sdk_situation", "pop_login");
            SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new b(this), this.l, obj, hashMap);
            b(f.j, (String) null);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            try {
                if (this.n) {
                    this.b.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_sms_bg_night_mode));
                    this.d.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_phone_text_color_night_mode));
                    this.d.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_hint_color_night_mode));
                    this.e.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_text_color_night_mode));
                    this.e.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
                    this.g.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
                    this.h.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_separate_line_color_night_mode));
                    Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField.setAccessible(true);
                    declaredField.set(this.e, Integer.valueOf((int) R.drawable.sapi_sdk_input_edit_text_cursor_bg_night));
                } else {
                    this.b.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_sms_bg_light_mode));
                    this.d.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_phone_text_color));
                    this.d.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_hint_color));
                    this.e.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_text_color));
                    this.e.setHintTextColor(getResources().getColor(R.color.sapi_sdk_sms_edit_check_code_hint_text_color));
                    this.g.setTextColor(getResources().getColor(R.color.sapi_sdk_sms_prompt_phone_number_error_color));
                    this.h.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_separate_line_color));
                    Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField2.setAccessible(true);
                    declaredField2.set(this.e, Integer.valueOf((int) R.drawable.sapi_sdk_input_edit_text_cursor_bg));
                }
            } catch (Exception unused) {
            }
            a(false);
        }
    }

    public void try2SmsLogin() {
        EditText editText;
        Editable text;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (editText = this.e) != null && (text = editText.getText()) != null && text.toString().length() >= 6) {
            PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
            if (privacyAgreementIntercept != null && !privacyAgreementIntercept.across(2)) {
                return;
            }
            d();
        }
    }
}
