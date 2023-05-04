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
import com.baidu.tieba.ne1;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class SmsLoginView extends FrameLayout implements NoProguard {
    public static final String q = "extrajson";
    public static final String r = "sdk_situation";
    public static final String s = "pop_login";
    public static final String t = "skipreg";
    public static final int u = 6;
    public static String v;
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

        /* loaded from: classes2.dex */
        public class a extends CountDownTimer {
            public a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (SmsLoginView.this.d.getText().toString().length() == 11) {
                    SmsLoginView.this.f.setEnabled(true);
                    SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_re_get_check_code);
                    SmsLoginView.this.a(true);
                    return;
                }
                SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                SmsLoginView.this.a(false);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView = SmsLoginView.this.f;
                textView.setText((j / 1000) + SmsLoginView.this.a.getString(R.string.sapi_sdk_sms_second));
                SmsLoginView.this.f.setEnabled(false);
                SmsLoginView.this.a(false);
            }
        }

        public GetCheckCodeListener() {
        }

        public /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if ((SmsLoginView.this.o != null && !SmsLoginView.this.o.across(1)) || SmsLoginView.this.d.getText().toString().length() != 11) {
                return;
            }
            SmsLoginView smsLoginView = SmsLoginView.this;
            smsLoginView.m = smsLoginView.f.getText().toString().equals(SmsLoginView.this.a.getString(R.string.sapi_sdk_sms_get_check_code));
            SmsLoginView.this.g.setVisibility(8);
            SmsLoginView.this.g.setText("");
            SmsLoginView.this.e.requestFocus();
            SmsLoginView.this.k = new a(60000L, 1000L);
            SmsLoginView.this.k.start();
            SmsLoginView smsLoginView2 = SmsLoginView.this;
            smsLoginView2.l = smsLoginView2.d.getText().toString();
            String a2 = SmsLoginView.a();
            HashMap hashMap = new HashMap();
            if (SapiUtils.statExtraValid(a2)) {
                hashMap.put("extrajson", a2);
            }
            hashMap.put("sdk_situation", "pop_login");
            hashMap.put("skipreg", "1");
            SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                public void onFinish() {
                }

                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                    if (SmsLoginView.this.m) {
                        SmsLoginView.b(f.e, (String) null);
                    } else {
                        SmsLoginView.b(f.h, (String) null);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                    if (SmsLoginView.this.m) {
                        SmsLoginView.b(f.f, getDynamicPwdResult.getResultCode() + "");
                    } else {
                        SmsLoginView.b(f.i, getDynamicPwdResult.getResultCode() + "");
                    }
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    WebAuthResult webAuthResult = new WebAuthResult();
                    webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                    webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                    SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                    SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                    if (smsViewLoginCallback == null) {
                        return;
                    }
                    SmsLoginView.this.l = "";
                    smsViewLoginCallback.onNeedBack(webAuthResult);
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                    if (SmsLoginView.this.m) {
                        SmsLoginView.b(f.f, getDynamicPwdResult.getResultCode() + "");
                        SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                    } else {
                        SmsLoginView.b(f.i, getDynamicPwdResult.getResultCode() + "");
                        SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_re_get_check_code);
                    }
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    SmsLoginView.this.f.setEnabled(true);
                    SmsLoginView.this.a(true);
                    if (getDynamicPwdResult.noNeedBack) {
                        SmsLoginView.this.g.setText(getDynamicPwdResult.getResultMsg());
                        SmsLoginView.this.g.setVisibility(0);
                        return;
                    }
                    WebAuthResult webAuthResult = new WebAuthResult();
                    webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                    webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                    SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
                    SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                    if (smsViewLoginCallback == null) {
                        return;
                    }
                    SmsLoginView.this.l = "";
                    smsViewLoginCallback.onNeedBack(webAuthResult);
                }
            }, SmsLoginView.this.l, null, hashMap);
            if (SmsLoginView.this.m) {
                SmsLoginView.b(f.d, (String) null);
            } else {
                SmsLoginView.b(f.g, (String) null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsLoginView.this.e.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) SmsLoginView.this.a.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(SmsLoginView.this.d, 0);
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
                SmsLoginView.this.g.setText(dynamicPwdLoginResult.getResultMsg());
                SmsLoginView.this.g.setVisibility(0);
                SmsLoginView.this.e.setText("");
                SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                if (smsViewLoginCallback != null) {
                    smsViewLoginCallback.onFailure(webAuthResult);
                    return;
                }
                return;
            }
            SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.l;
            SmsViewLoginCallback smsViewLoginCallback2 = SmsLoginView.this.getSmsViewLoginCallback();
            if (smsViewLoginCallback2 == null) {
                return;
            }
            SmsLoginView.this.l = "";
            smsViewLoginCallback2.onNeedBack(webAuthResult);
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
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.SMS.getName());
                smsViewLoginCallback.onSuccess(webAuthResult);
            }
            new PtokenStat().onEvent(PtokenStat.LOGIN_POP);
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            SmsLoginView.this.b();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            SmsLoginView.this.c();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public c() {
        }

        public /* synthetic */ c(SmsLoginView smsLoginView, a aVar) {
            this();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsLoginView.this.e.setGravity(19);
            } else if (1 == length) {
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.e.setGravity(17);
            } else if (length == SapiAccountManager.getInstance().getSmsCodeLength() && !TextUtils.isEmpty(SmsLoginView.this.l)) {
                SmsLoginView.this.d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends Dialog {
        public d(Context context) {
            super(context, R.style.obfuscated_res_0x7f1003f6);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public e() {
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsViewLoginCallback smsViewLoginCallback = SmsLoginView.this.getSmsViewLoginCallback();
                if (smsViewLoginCallback != null) {
                    smsViewLoginCallback.onCheckCodeViewHide();
                }
                SmsLoginView.this.c.setVisibility(8);
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.d.setGravity(19);
            } else if (SmsLoginView.this.c.getVisibility() != 0) {
                SmsViewLoginCallback smsViewLoginCallback2 = SmsLoginView.this.getSmsViewLoginCallback();
                if (smsViewLoginCallback2 != null) {
                    smsViewLoginCallback2.onCheckCodeViewShow();
                }
                SmsLoginView.this.c.setVisibility(0);
                SmsLoginView.this.d.setGravity(17);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(false);
                    SmsLoginView.this.g.setVisibility(8);
                    SmsLoginView.this.g.setText("");
                    SmsLoginView.this.f.setEnabled(false);
                }
            } else if (length == 11) {
                if (!SmsLoginView.this.d.getText().toString().equals(SmsLoginView.this.l)) {
                    if (SmsLoginView.this.k != null) {
                        SmsLoginView.this.k.cancel();
                    }
                    SmsLoginView.this.f.setText(R.string.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.f.setEnabled(true);
                    } else {
                        SmsLoginView.this.g.setVisibility(0);
                        SmsLoginView.this.g.setText(R.string.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.b(f.c, (String) null);
            }
        }
    }

    public SmsLoginView(Context context) {
        this(context, null);
    }

    public void setDarkMode(boolean z) {
        if (this.n == (!z)) {
            this.n = z;
            e();
            a(false);
        }
    }

    public void setSendVerificationCodeIntercept(PrivacyAgreementIntercept privacyAgreementIntercept) {
        this.o = privacyAgreementIntercept;
    }

    public void setSmsLoginStatExtra(String str) {
        v = str;
    }

    public void setSmsViewLoginCallback(SmsViewLoginCallback smsViewLoginCallback) {
        this.p = smsViewLoginCallback;
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public static void b(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("pop_login", str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extrajson", getSmsLoginStatExtra());
        hashMap.put("errno", str2);
        StatService.onEventAutoStatistic(linkedHashMap, hashMap);
    }

    public SmsLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = true;
        this.m = true;
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(R.layout.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ne1.sapi_sdk_sms_login_view, i, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        this.c = this.b.findViewById(R.id.code_container);
        this.d = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f091b4c);
        this.i = this.b.findViewById(R.id.loading_container);
        this.e = (EditText) this.b.findViewById(R.id.check_code);
        this.f = (TextView) this.b.findViewById(R.id.get_code);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c61);
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
            new Handler().postDelayed(new a(), 100L);
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

    public static /* synthetic */ String a() {
        return getSmsLoginStatExtra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.i.setVisibility(8);
        try {
            this.j.dismiss();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.i.setVisibility(0);
        d dVar = new d(this.a);
        this.j = dVar;
        dVar.show();
    }

    public static String getSmsLoginStatExtra() {
        if (v == null) {
            v = CoreViewRouter.getInstance().getSmsLoginStatExtra();
        }
        return WebLoginDTO.getStatExtraDecode(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmsViewLoginCallback getSmsViewLoginCallback() {
        if (this.p == null) {
            this.p = CoreViewRouter.getInstance().getSmsViewLoginCallback();
            CoreViewRouter.getInstance().releaseSmsViewLoginCallback();
        }
        return this.p;
    }

    public static void notifyStartLogin() {
        b("show", (String) null);
    }

    public void clean() {
        this.e.setText("");
        this.d.setText("");
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f.setText(R.string.sapi_sdk_sms_get_check_code);
        a(false);
    }

    public void close() {
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CoreViewRouter.getInstance().releaseWithoutAccountCenter();
    }

    public void try2SmsLogin() {
        Editable text;
        EditText editText = this.e;
        if (editText != null && (text = editText.getText()) != null && text.toString().length() >= 6) {
            PrivacyAgreementIntercept privacyAgreementIntercept = this.o;
            if (privacyAgreementIntercept != null && !privacyAgreementIntercept.across(2)) {
                return;
            }
            d();
        }
    }

    private void a(EditText editText, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int color;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
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
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new b(), this.l, obj, hashMap);
        b(f.j, (String) null);
    }

    private void e() {
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
