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
import d.a.a0.a.g;
import d.a.a0.a.h;
import d.a.a0.a.i;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class SmsLoginView extends FrameLayout implements NoProguard {
    public static final String q = "extrajson";
    public static final String r = "sdk_situation";
    public static final String s = "pop_login";
    public static int smgLoginViewIndexStat = 0;
    public static final String t = "skipreg";
    public static final int u = 6;

    /* renamed from: a  reason: collision with root package name */
    public Context f9954a;

    /* renamed from: b  reason: collision with root package name */
    public View f9955b;

    /* renamed from: c  reason: collision with root package name */
    public View f9956c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f9957d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f9958e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9959f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9960g;

    /* renamed from: h  reason: collision with root package name */
    public View f9961h;

    /* renamed from: i  reason: collision with root package name */
    public View f9962i;
    public Dialog j;
    public CountDownTimer k;
    public String l;
    public boolean m;
    public boolean n;
    public PrivacyAgreementIntercept o;
    public int p;

    /* loaded from: classes2.dex */
    public class GetCheckCodeListener implements View.OnClickListener {

        /* loaded from: classes2.dex */
        public class a extends CountDownTimer {
            public a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (SmsLoginView.this.f9957d.getText().toString().length() == 11) {
                    SmsLoginView.this.f9959f.setEnabled(true);
                    SmsLoginView.this.f9959f.setText(g.sapi_sdk_sms_re_get_check_code);
                    SmsLoginView.this.a(true);
                    return;
                }
                SmsLoginView.this.f9959f.setText(g.sapi_sdk_sms_get_check_code);
                SmsLoginView.this.a(false);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView = SmsLoginView.this.f9959f;
                textView.setText((j / 1000) + SmsLoginView.this.f9954a.getString(g.sapi_sdk_sms_second));
                SmsLoginView.this.f9959f.setEnabled(false);
                SmsLoginView.this.a(false);
            }
        }

        public GetCheckCodeListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((SmsLoginView.this.o == null || SmsLoginView.this.o.across(1)) && SmsLoginView.this.f9957d.getText().toString().length() == 11) {
                SmsLoginView smsLoginView = SmsLoginView.this;
                smsLoginView.m = smsLoginView.f9959f.getText().toString().equals(SmsLoginView.this.f9954a.getString(g.sapi_sdk_sms_get_check_code));
                SmsLoginView.this.f9960g.setVisibility(8);
                SmsLoginView.this.f9960g.setText("");
                SmsLoginView.this.f9958e.requestFocus();
                SmsLoginView.this.k = new a(60000L, 1000L);
                SmsLoginView.this.k.start();
                SmsLoginView smsLoginView2 = SmsLoginView.this;
                smsLoginView2.l = smsLoginView2.f9957d.getText().toString();
                String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put(SmsLoginView.r, "pop_login");
                hashMap.put(SmsLoginView.t, "1");
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                    public void onFinish() {
                    }

                    public void onStart() {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.f9976f, getDynamicPwdResult.getResultCode() + "");
                        } else {
                            SmsLoginView.b(f.f9979i, getDynamicPwdResult.getResultCode() + "");
                        }
                        if (SmsLoginView.this.k != null) {
                            SmsLoginView.this.k.cancel();
                        }
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                        SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                        if (smsViewLoginCallback != null) {
                            SmsLoginView.this.l = "";
                            smsViewLoginCallback.onNeedBack(webAuthResult);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.f9976f, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.f9959f.setText(g.sapi_sdk_sms_get_check_code);
                        } else {
                            SmsLoginView.b(f.f9979i, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.f9959f.setText(g.sapi_sdk_sms_re_get_check_code);
                        }
                        if (SmsLoginView.this.k != null) {
                            SmsLoginView.this.k.cancel();
                        }
                        SmsLoginView.this.f9959f.setEnabled(true);
                        SmsLoginView.this.a(true);
                        if (getDynamicPwdResult.noNeedBack) {
                            SmsLoginView.this.f9960g.setText(getDynamicPwdResult.getResultMsg());
                            SmsLoginView.this.f9960g.setVisibility(0);
                            return;
                        }
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                        SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                        if (smsViewLoginCallback != null) {
                            SmsLoginView.this.l = "";
                            smsViewLoginCallback.onNeedBack(webAuthResult);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.f9975e, (String) null);
                        } else {
                            SmsLoginView.b(f.f9978h, (String) null);
                        }
                    }
                }, SmsLoginView.this.l, null, hashMap);
                if (SmsLoginView.this.m) {
                    SmsLoginView.b(f.f9974d, (String) null);
                } else {
                    SmsLoginView.b(f.f9977g, (String) null);
                }
            }
        }

        public /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface PrivacyAgreementIntercept extends NoProguard {
        public static final int LOGIN = 2;
        public static final int SNED_SMS = 1;

        boolean across(int i2);
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsLoginView.this.f9958e.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) SmsLoginView.this.f9954a.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(SmsLoginView.this.f9957d, 0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends DynamicPwdLoginCallback {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
            SmsLoginView.b(f.l, dynamicPwdLoginResult.getResultCode() + "");
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
            webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
            if (dynamicPwdLoginResult.noNeedBack) {
                SmsLoginView.this.f9960g.setText(dynamicPwdLoginResult.getResultMsg());
                SmsLoginView.this.f9960g.setVisibility(0);
                SmsLoginView.this.f9958e.setText("");
                SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                if (smsViewLoginCallback != null) {
                    smsViewLoginCallback.onFailure(webAuthResult);
                    return;
                }
                return;
            }
            SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
            SmsViewLoginCallback smsViewLoginCallback2 = SmsLoginView.this.getSmsViewLoginCallback();
            if (smsViewLoginCallback2 != null) {
                SmsLoginView.this.l = "";
                smsViewLoginCallback2.onNeedBack(webAuthResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
            SmsLoginView.b("success", (String) null);
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
            webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
            webAuthResult.accountType = AccountType.NORMAL;
            SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
            if (smsViewLoginCallback != null) {
                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, SmsLoginView.this.l);
                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "sms");
                smsViewLoginCallback.onSuccess(webAuthResult);
            }
            new PtokenStat().onEvent(PtokenStat.LOGIN_POP);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            SmsLoginView.this.a();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            SmsLoginView.this.b();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsLoginView.this.f9958e.setGravity(19);
            } else if (length != 1) {
                if (length == 6 && !TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.c();
                }
            } else {
                SmsLoginView.this.f9960g.setText("");
                SmsLoginView.this.f9960g.setVisibility(8);
                SmsLoginView.this.f9958e.setGravity(17);
            }
        }

        public /* synthetic */ c(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class d extends Dialog {
        public d(Context context) {
            super(context, h.sapi_sdk_empty_dialog);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                if (smsViewLoginCallback != null) {
                    smsViewLoginCallback.onCheckCodeViewHide();
                }
                SmsLoginView.this.f9956c.setVisibility(8);
                SmsLoginView.this.f9960g.setVisibility(8);
                SmsLoginView.this.f9960g.setText("");
                SmsLoginView.this.f9957d.setGravity(19);
            } else if (SmsLoginView.this.f9956c.getVisibility() != 0) {
                SmsViewLoginCallback smsViewLoginCallback2 = SmsLoginView.this.getSmsViewLoginCallback();
                if (smsViewLoginCallback2 != null) {
                    smsViewLoginCallback2.onCheckCodeViewShow();
                }
                SmsLoginView.this.f9956c.setVisibility(0);
                SmsLoginView.this.f9957d.setGravity(17);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.f9959f.setText(g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(false);
                    SmsLoginView.this.f9960g.setVisibility(8);
                    SmsLoginView.this.f9960g.setText("");
                    SmsLoginView.this.f9959f.setEnabled(false);
                }
            } else if (length == 11) {
                if (!SmsLoginView.this.f9957d.getText().toString().equals(SmsLoginView.this.l)) {
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    SmsLoginView.this.f9959f.setText(g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.f9959f.setEnabled(true);
                    } else {
                        SmsLoginView.this.f9960g.setVisibility(0);
                        SmsLoginView.this.f9960g.setText(g.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.b(f.f9973c, (String) null);
            }
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final String f9971a = "pop_login";

        /* renamed from: b  reason: collision with root package name */
        public static final String f9972b = "show";

        /* renamed from: c  reason: collision with root package name */
        public static final String f9973c = "input_phone";

        /* renamed from: d  reason: collision with root package name */
        public static final String f9974d = "first_get_dpass";

        /* renamed from: e  reason: collision with root package name */
        public static final String f9975e = "first_get_dpass_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f9976f = "first_get_dpass_failure";

        /* renamed from: g  reason: collision with root package name */
        public static final String f9977g = "get_dpass_again";

        /* renamed from: h  reason: collision with root package name */
        public static final String f9978h = "get_dpass_again_success";

        /* renamed from: i  reason: collision with root package name */
        public static final String f9979i = "get_dpass_again_failure";
        public static final String j = "verify";
        public static final String k = "success";
        public static final String l = "failure";
    }

    public SmsLoginView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return CoreViewRouter.getInstance().getSmsViewLoginCallback(getSmsLoginViewIndex());
    }

    public static void notifyStartLogin() {
        b("show", (String) null);
    }

    public void clean() {
        this.f9958e.setText("");
        this.f9957d.setText("");
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f9959f.setText(g.sapi_sdk_sms_get_check_code);
        a(false);
    }

    public void close() {
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CoreViewRouter.getInstance().release();
    }

    public int getSmsLoginViewIndex() {
        return this.p;
    }

    public void setDarkMode(boolean z) {
        if (this.n == (!z)) {
            this.n = z;
            d();
            a(false);
        }
    }

    public void setSendVerificationCodeIntercept(PrivacyAgreementIntercept privacyAgreementIntercept) {
        this.o = privacyAgreementIntercept;
    }

    public void setSmsLoginViewIndex(int i2) {
        this.p = i2;
    }

    public void try2SmsLogin() {
        Editable text;
        EditText editText = this.f9958e;
        if (editText == null || (text = editText.getText()) == null || text.toString().length() < 6) {
            return;
        }
        PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
        if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
            c();
        }
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
        if (privacyAgreementIntercept == null || privacyAgreementIntercept.across(2)) {
            String obj = this.f9958e.getText().toString();
            String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
            HashMap hashMap = new HashMap();
            if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                hashMap.put("extrajson", smsLoginStatExtra);
            }
            hashMap.put(r, "pop_login");
            SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new b(), this.l, obj, hashMap);
            b(f.j, (String) null);
        }
    }

    private void d() {
        try {
            if (this.n) {
                this.f9955b.setBackgroundColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_bg_night_mode));
                this.f9957d.setTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
                this.f9957d.setHintTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_hint_color_night_mode));
                this.f9958e.setTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
                this.f9958e.setHintTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
                this.f9960g.setTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
                this.f9961h.setBackgroundColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_separate_line_color_night_mode));
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.f9958e, Integer.valueOf(d.a.a0.a.d.sapi_sdk_input_edit_text_cursor_bg_night));
            } else {
                this.f9955b.setBackgroundColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_bg_light_mode));
                this.f9957d.setTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_phone_text_color));
                this.f9957d.setHintTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_hint_color));
                this.f9958e.setTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_check_code_text_color));
                this.f9958e.setHintTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_edit_check_code_hint_text_color));
                this.f9960g.setTextColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_prompt_phone_number_error_color));
                this.f9961h.setBackgroundColor(getResources().getColor(d.a.a0.a.b.sapi_sdk_separate_line_color));
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.f9958e, Integer.valueOf(d.a.a0.a.d.sapi_sdk_input_edit_text_cursor_bg));
            }
        } catch (Exception unused) {
        }
        a(false);
    }

    public SmsLoginView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z = true;
        this.m = true;
        this.p = -1;
        this.f9954a = context;
        this.f9955b = LayoutInflater.from(context).inflate(d.a.a0.a.f.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_sms_login_view, i2, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.f9956c = this.f9955b.findViewById(d.a.a0.a.e.code_container);
        this.f9957d = (EditText) this.f9955b.findViewById(d.a.a0.a.e.phone);
        this.f9962i = this.f9955b.findViewById(d.a.a0.a.e.loading_container);
        this.f9958e = (EditText) this.f9955b.findViewById(d.a.a0.a.e.check_code);
        this.f9959f = (TextView) this.f9955b.findViewById(d.a.a0.a.e.get_code);
        this.f9960g = (TextView) this.f9955b.findViewById(d.a.a0.a.e.prompt);
        this.f9961h = this.f9955b.findViewById(d.a.a0.a.e.separate_line);
        a(this.f9957d, context.getString(g.sapi_sdk_sms_hint_input_phone));
        a(this.f9958e, context.getString(g.sapi_sdk_sms_hint_input_check_code));
        this.f9957d.addTextChangedListener(new e(this, null));
        this.f9958e.addTextChangedListener(new c(this, null));
        this.f9959f.setEnabled(false);
        this.f9959f.setOnClickListener(new GetCheckCodeListener(this, null));
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
            new Handler().postDelayed(new a(), 100L);
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null) {
            ViewUtility.enlargedViews(this.f9957d, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f9958e, sapiConfiguration.textZoom);
            ViewUtility.enlargedViews(this.f9959f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedOtherView(this.f9959f, (sapiConfiguration.textZoom * 100) / 120);
            ViewUtility.enlargedViews(this.f9960g, sapiConfiguration.textZoom);
        }
        if (SapiUtils.getLastLoginType() != 2) {
            return;
        }
        String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
        if (TextUtils.isEmpty(decryptStr) || decryptStr.length() != 11) {
            return;
        }
        this.f9957d.setText(decryptStr);
        this.f9957d.setSelection(decryptStr.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f9962i.setVisibility(0);
        d dVar = new d(this.f9954a);
        this.j = dVar;
        dVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int color;
        getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_get_code_text_color);
        int i2 = -1;
        if (this.n) {
            i2 = getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_bg_night_mode);
            if (z) {
                color = getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_get_code_text_color_night_mode);
            } else {
                color = getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_get_code_disable_color_night_mode);
            }
        } else if (z) {
            color = getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_get_code_text_color);
        } else {
            color = getResources().getColor(d.a.a0.a.b.sapi_sdk_sms_get_code_disable_color);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.f9959f.getBackground();
        gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
        gradientDrawable.setColor(i2);
        this.f9959f.setTextColor(color);
    }

    public static void b(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("pop_login", str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extrajson", CoreViewRouter.getInstance().getSmsLoginStatExtra());
        hashMap.put("errno", str2);
        StatService.onEventAutoStatistic(linkedHashMap, hashMap);
    }

    private void a(EditText editText, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f9962i.setVisibility(8);
        try {
            this.j.dismiss();
        } catch (Throwable unused) {
        }
    }
}
