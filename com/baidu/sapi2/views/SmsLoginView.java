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
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import d.a.y.a.g;
import d.a.y.a.h;
import d.a.y.a.i;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class SmsLoginView extends FrameLayout implements NoProguard {
    public static final String o = "extrajson";
    public static final String p = "sdk_situation";
    public static final String q = "pop_login";
    public static final String r = "skipreg";

    /* renamed from: a  reason: collision with root package name */
    public Context f9971a;

    /* renamed from: b  reason: collision with root package name */
    public View f9972b;

    /* renamed from: c  reason: collision with root package name */
    public View f9973c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f9974d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f9975e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9976f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9977g;

    /* renamed from: h  reason: collision with root package name */
    public View f9978h;

    /* renamed from: i  reason: collision with root package name */
    public View f9979i;
    public Dialog j;
    public CountDownTimer k;
    public String l;
    public boolean m;
    public boolean n;

    /* loaded from: classes2.dex */
    public class GetCheckCodeListener implements View.OnClickListener {

        /* loaded from: classes2.dex */
        public class a extends CountDownTimer {
            public a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (SmsLoginView.this.f9974d.getText().toString().length() == 11) {
                    SmsLoginView.this.f9976f.setEnabled(true);
                    SmsLoginView.this.f9976f.setText(g.sapi_sdk_sms_re_get_check_code);
                    SmsLoginView.this.a(true);
                    return;
                }
                SmsLoginView.this.f9976f.setText(g.sapi_sdk_sms_get_check_code);
                SmsLoginView.this.a(false);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView = SmsLoginView.this.f9976f;
                textView.setText((j / 1000) + SmsLoginView.this.f9971a.getString(g.sapi_sdk_sms_second));
                SmsLoginView.this.f9976f.setEnabled(false);
                SmsLoginView.this.a(false);
            }
        }

        public GetCheckCodeListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SmsLoginView.this.f9974d.getText().toString().length() != 11) {
                return;
            }
            SmsLoginView smsLoginView = SmsLoginView.this;
            smsLoginView.m = smsLoginView.f9976f.getText().toString().equals(SmsLoginView.this.f9971a.getString(g.sapi_sdk_sms_get_check_code));
            SmsLoginView.this.f9977g.setVisibility(8);
            SmsLoginView.this.f9977g.setText("");
            SmsLoginView.this.f9975e.requestFocus();
            SmsLoginView.this.k = new a(60000L, 1000L);
            SmsLoginView.this.k.start();
            SmsLoginView smsLoginView2 = SmsLoginView.this;
            smsLoginView2.l = smsLoginView2.f9974d.getText().toString();
            String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
            HashMap hashMap = new HashMap();
            if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                hashMap.put("extrajson", smsLoginStatExtra);
            }
            hashMap.put(SmsLoginView.p, "pop_login");
            hashMap.put(SmsLoginView.r, "1");
            SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                public void onFinish() {
                }

                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                    if (SmsLoginView.this.m) {
                        SmsLoginView.b(f.f9993f, getDynamicPwdResult.getResultCode() + "");
                    } else {
                        SmsLoginView.b(f.f9996i, getDynamicPwdResult.getResultCode() + "");
                    }
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    WebAuthResult webAuthResult = new WebAuthResult();
                    webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                    webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                    SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                    if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                        SmsLoginView.this.l = "";
                        CoreViewRouter.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                    if (SmsLoginView.this.m) {
                        SmsLoginView.b(f.f9993f, getDynamicPwdResult.getResultCode() + "");
                        SmsLoginView.this.f9976f.setText(g.sapi_sdk_sms_get_check_code);
                    } else {
                        SmsLoginView.b(f.f9996i, getDynamicPwdResult.getResultCode() + "");
                        SmsLoginView.this.f9976f.setText(g.sapi_sdk_sms_re_get_check_code);
                    }
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    SmsLoginView.this.f9976f.setEnabled(true);
                    SmsLoginView.this.a(true);
                    if (getDynamicPwdResult.noNeedBack) {
                        SmsLoginView.this.f9977g.setText(getDynamicPwdResult.getResultMsg());
                        SmsLoginView.this.f9977g.setVisibility(0);
                        return;
                    }
                    WebAuthResult webAuthResult = new WebAuthResult();
                    webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                    webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                    SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                    if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                        SmsLoginView.this.l = "";
                        CoreViewRouter.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                    if (SmsLoginView.this.m) {
                        SmsLoginView.b(f.f9992e, (String) null);
                    } else {
                        SmsLoginView.b(f.f9995h, (String) null);
                    }
                }
            }, SmsLoginView.this.l, null, hashMap);
            if (SmsLoginView.this.m) {
                SmsLoginView.b(f.f9991d, (String) null);
            } else {
                SmsLoginView.b(f.f9994g, (String) null);
            }
        }

        public /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsLoginView.this.f9975e.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) SmsLoginView.this.f9971a.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(SmsLoginView.this.f9974d, 0);
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
                SmsLoginView.this.f9977g.setText(dynamicPwdLoginResult.getResultMsg());
                SmsLoginView.this.f9977g.setVisibility(0);
                SmsLoginView.this.f9975e.setText("");
                if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                    CoreViewRouter.getInstance().getSmsViewLoginCallback().onFailure(webAuthResult);
                    return;
                }
                return;
            }
            SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
            if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                SmsLoginView.this.l = "";
                CoreViewRouter.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
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
            if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, SmsLoginView.this.l);
                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "sms");
                CoreViewRouter.getInstance().getSmsViewLoginCallback().onSuccess(webAuthResult);
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
                SmsLoginView.this.f9975e.setGravity(19);
            } else if (length != 1) {
                if (length == 6 && !TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.c();
                }
            } else {
                SmsLoginView.this.f9977g.setText("");
                SmsLoginView.this.f9977g.setVisibility(8);
                SmsLoginView.this.f9975e.setGravity(17);
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
            if (length != 0) {
                if (SmsLoginView.this.f9973c.getVisibility() != 0) {
                    if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                        CoreViewRouter.getInstance().getSmsViewLoginCallback().onCheckCodeViewShow();
                    }
                    SmsLoginView.this.f9973c.setVisibility(0);
                    SmsLoginView.this.f9974d.setGravity(17);
                }
            } else {
                if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                    CoreViewRouter.getInstance().getSmsViewLoginCallback().onCheckCodeViewHide();
                }
                SmsLoginView.this.f9973c.setVisibility(8);
                SmsLoginView.this.f9977g.setVisibility(8);
                SmsLoginView.this.f9977g.setText("");
                SmsLoginView.this.f9974d.setGravity(19);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.f9976f.setText(g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(false);
                    SmsLoginView.this.f9977g.setVisibility(8);
                    SmsLoginView.this.f9977g.setText("");
                    SmsLoginView.this.f9976f.setEnabled(false);
                }
            } else if (length == 11) {
                if (!SmsLoginView.this.f9974d.getText().toString().equals(SmsLoginView.this.l)) {
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    SmsLoginView.this.f9976f.setText(g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.f9976f.setEnabled(true);
                    } else {
                        SmsLoginView.this.f9977g.setVisibility(0);
                        SmsLoginView.this.f9977g.setText(g.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.b(f.f9990c, (String) null);
            }
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final String f9988a = "pop_login";

        /* renamed from: b  reason: collision with root package name */
        public static final String f9989b = "show";

        /* renamed from: c  reason: collision with root package name */
        public static final String f9990c = "input_phone";

        /* renamed from: d  reason: collision with root package name */
        public static final String f9991d = "first_get_dpass";

        /* renamed from: e  reason: collision with root package name */
        public static final String f9992e = "first_get_dpass_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f9993f = "first_get_dpass_failure";

        /* renamed from: g  reason: collision with root package name */
        public static final String f9994g = "get_dpass_again";

        /* renamed from: h  reason: collision with root package name */
        public static final String f9995h = "get_dpass_again_success";

        /* renamed from: i  reason: collision with root package name */
        public static final String f9996i = "get_dpass_again_failure";
        public static final String j = "verify";
        public static final String k = "success";
        public static final String l = "failure";
    }

    public SmsLoginView(Context context) {
        this(context, null);
    }

    public static void notifyStartLogin() {
        b("show", (String) null);
    }

    public void clean() {
        this.f9975e.setText("");
        this.f9974d.setText("");
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f9976f.setText(g.sapi_sdk_sms_get_check_code);
        a(false);
    }

    public void close() {
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CoreViewRouter.getInstance().release();
    }

    public void setDarkMode(boolean z) {
        if (this.n == (!z)) {
            this.n = z;
            d();
            a(false);
        }
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String obj = this.f9975e.getText().toString();
        String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
        HashMap hashMap = new HashMap();
        if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
            hashMap.put("extrajson", smsLoginStatExtra);
        }
        hashMap.put(p, "pop_login");
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new b(), this.l, obj, hashMap);
        b(f.j, (String) null);
    }

    private void d() {
        try {
            if (this.n) {
                this.f9972b.setBackgroundColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_bg_night_mode));
                this.f9974d.setTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
                this.f9974d.setHintTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_hint_color_night_mode));
                this.f9975e.setTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
                this.f9975e.setHintTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
                this.f9977g.setTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
                this.f9978h.setBackgroundColor(getResources().getColor(d.a.y.a.b.sapi_sdk_separate_line_color_night_mode));
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.f9975e, Integer.valueOf(d.a.y.a.d.sapi_sdk_input_edit_text_cursor_bg_night));
            } else {
                this.f9972b.setBackgroundColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_bg_light_mode));
                this.f9974d.setTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_phone_text_color));
                this.f9974d.setHintTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_hint_color));
                this.f9975e.setTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_check_code_text_color));
                this.f9975e.setHintTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_edit_check_code_hint_text_color));
                this.f9977g.setTextColor(getResources().getColor(d.a.y.a.b.sapi_sdk_sms_prompt_phone_number_error_color));
                this.f9978h.setBackgroundColor(getResources().getColor(d.a.y.a.b.sapi_sdk_separate_line_color));
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.f9975e, Integer.valueOf(d.a.y.a.d.sapi_sdk_input_edit_text_cursor_bg));
            }
        } catch (Exception unused) {
        }
        a(false);
    }

    public SmsLoginView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z = true;
        this.m = true;
        this.f9971a = context;
        this.f9972b = LayoutInflater.from(context).inflate(d.a.y.a.f.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_sms_login_view, i2, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.f9973c = this.f9972b.findViewById(d.a.y.a.e.code_container);
        this.f9974d = (EditText) this.f9972b.findViewById(d.a.y.a.e.phone);
        this.f9979i = this.f9972b.findViewById(d.a.y.a.e.loading_container);
        this.f9975e = (EditText) this.f9972b.findViewById(d.a.y.a.e.check_code);
        this.f9976f = (TextView) this.f9972b.findViewById(d.a.y.a.e.get_code);
        this.f9977g = (TextView) this.f9972b.findViewById(d.a.y.a.e.prompt);
        this.f9978h = this.f9972b.findViewById(d.a.y.a.e.separate_line);
        a(this.f9974d, context.getString(g.sapi_sdk_sms_hint_input_phone));
        a(this.f9975e, context.getString(g.sapi_sdk_sms_hint_input_check_code));
        this.f9974d.addTextChangedListener(new e(this, null));
        this.f9975e.addTextChangedListener(new c(this, null));
        this.f9976f.setEnabled(false);
        this.f9976f.setOnClickListener(new GetCheckCodeListener(this, null));
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
        if (SapiUtils.getLastLoginType() != 2) {
            return;
        }
        String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
        if (TextUtils.isEmpty(decryptStr) || decryptStr.length() != 11) {
            return;
        }
        this.f9974d.setText(decryptStr);
        this.f9974d.setSelection(decryptStr.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f9979i.setVisibility(0);
        d dVar = new d(this.f9971a);
        this.j = dVar;
        dVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int color;
        getResources().getColor(d.a.y.a.b.sapi_sdk_sms_get_code_text_color);
        int i2 = -1;
        if (this.n) {
            i2 = getResources().getColor(d.a.y.a.b.sapi_sdk_sms_bg_night_mode);
            if (z) {
                color = getResources().getColor(d.a.y.a.b.sapi_sdk_sms_get_code_text_color_night_mode);
            } else {
                color = getResources().getColor(d.a.y.a.b.sapi_sdk_sms_get_code_disable_color_night_mode);
            }
        } else if (z) {
            color = getResources().getColor(d.a.y.a.b.sapi_sdk_sms_get_code_text_color);
        } else {
            color = getResources().getColor(d.a.y.a.b.sapi_sdk_sms_get_code_disable_color);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.f9976f.getBackground();
        gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
        gradientDrawable.setColor(i2);
        this.f9976f.setTextColor(color);
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
        this.f9979i.setVisibility(8);
        try {
            this.j.dismiss();
        } catch (Throwable unused) {
        }
    }
}
