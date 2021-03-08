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
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.j.a.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.k;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class SmsLoginView extends FrameLayout implements NoProguard {
    private static final String n = "extrajson";
    private static final String o = "sdk_situation";
    private static final String p = "pop_login";
    private static final String q = "skipreg";

    /* renamed from: a  reason: collision with root package name */
    private Context f3472a;
    private View b;
    private View c;
    private EditText d;
    private EditText e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private Dialog j;
    private CountDownTimer k;
    private String l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class GetCheckCodeListener implements View.OnClickListener {

        /* loaded from: classes3.dex */
        class a extends CountDownTimer {
            a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (SmsLoginView.this.d.getText().toString().length() == 11) {
                    SmsLoginView.this.f.setEnabled(true);
                    SmsLoginView.this.f.setText(a.g.sapi_sdk_sms_re_get_check_code);
                    SmsLoginView.this.a(true);
                    return;
                }
                SmsLoginView.this.f.setText(a.g.sapi_sdk_sms_get_check_code);
                SmsLoginView.this.a(false);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                SmsLoginView.this.f.setText((j / 1000) + SmsLoginView.this.f3472a.getString(a.g.sapi_sdk_sms_second));
                SmsLoginView.this.f.setEnabled(false);
                SmsLoginView.this.a(false);
            }
        }

        private GetCheckCodeListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SmsLoginView.this.d.getText().toString().length() == 11) {
                SmsLoginView smsLoginView = SmsLoginView.this;
                smsLoginView.m = smsLoginView.f.getText().toString().equals(SmsLoginView.this.f3472a.getString(a.g.sapi_sdk_sms_get_check_code));
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.e.requestFocus();
                SmsLoginView.this.k = new a(AppStatusRules.DEFAULT_GRANULARITY, 1000L);
                SmsLoginView.this.k.start();
                SmsLoginView smsLoginView2 = SmsLoginView.this;
                smsLoginView2.l = smsLoginView2.d.getText().toString();
                String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put(SmsLoginView.o, "pop_login");
                hashMap.put(SmsLoginView.q, "1");
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                    public void onFinish() {
                    }

                    public void onStart() {
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
                        if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                            SmsLoginView.this.l = "";
                            CoreViewRouter.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.f, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.f.setText(a.g.sapi_sdk_sms_get_check_code);
                        } else {
                            SmsLoginView.b(f.i, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.f.setText(a.g.sapi_sdk_sms_re_get_check_code);
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
                        if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                            SmsLoginView.this.l = "";
                            CoreViewRouter.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.m) {
                            SmsLoginView.b(f.e, (String) null);
                        } else {
                            SmsLoginView.b(f.h, (String) null);
                        }
                    }
                }, SmsLoginView.this.l, null, hashMap);
                if (SmsLoginView.this.m) {
                    SmsLoginView.b(f.d, (String) null);
                } else {
                    SmsLoginView.b(f.g, (String) null);
                }
            }
        }

        /* synthetic */ GetCheckCodeListener(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsLoginView.this.e.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) SmsLoginView.this.f3472a.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(SmsLoginView.this.d, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends DynamicPwdLoginCallback {
        b() {
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
                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, LoginConstants.SMS_LOGIN);
                CoreViewRouter.getInstance().getSmsViewLoginCallback().onSuccess(webAuthResult);
            }
            new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.b);
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

    /* loaded from: classes3.dex */
    private class c implements TextWatcher {
        private c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsLoginView.this.e.setGravity(19);
            } else if (length != 1) {
                if (length == 6 && !TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.c();
                }
            } else {
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.e.setGravity(17);
            }
        }

        /* synthetic */ c(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends Dialog {
        public d(Context context) {
            super(context, a.h.sapi_sdk_empty_dialog);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    /* loaded from: classes3.dex */
    private class e implements TextWatcher {
        private e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.toString().length();
            if (length != 0) {
                if (SmsLoginView.this.c.getVisibility() != 0) {
                    if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                        CoreViewRouter.getInstance().getSmsViewLoginCallback().onCheckCodeViewShow();
                    }
                    SmsLoginView.this.c.setVisibility(0);
                    SmsLoginView.this.d.setGravity(17);
                }
            } else {
                if (CoreViewRouter.getInstance().getSmsViewLoginCallback() != null) {
                    CoreViewRouter.getInstance().getSmsViewLoginCallback().onCheckCodeViewHide();
                }
                SmsLoginView.this.c.setVisibility(8);
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.g.setText("");
                SmsLoginView.this.d.setGravity(19);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.l)) {
                    SmsLoginView.this.f.setText(a.g.sapi_sdk_sms_get_check_code);
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
                    SmsLoginView.this.f.setText(a.g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.f.setEnabled(true);
                    } else {
                        SmsLoginView.this.g.setVisibility(0);
                        SmsLoginView.this.g.setText(a.g.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.b(f.c, (String) null);
            }
        }

        /* synthetic */ e(SmsLoginView smsLoginView, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    private interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final String f3481a = "pop_login";
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

    public SmsLoginView(Context context) {
        this(context, null);
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
        this.f.setText(a.g.sapi_sdk_sms_get_check_code);
        a(false);
    }

    public void close() {
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CoreViewRouter.getInstance().release();
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String obj = this.e.getText().toString();
        String smsLoginStatExtra = CoreViewRouter.getInstance().getSmsLoginStatExtra();
        HashMap hashMap = new HashMap();
        if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
            hashMap.put("extrajson", smsLoginStatExtra);
        }
        hashMap.put(o, "pop_login");
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new b(), this.l, obj, hashMap);
        b(f.j, (String) null);
    }

    private void d() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode || SapiAccountManager.getInstance().getSapiConfiguration().isDarkMode) {
            this.b.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_sms_bg_night_mode));
            this.d.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
            this.d.setHintTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_hint_color_night_mode));
            this.e.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
            this.e.setHintTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
            this.g.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
            this.h.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_separate_line_color_night_mode));
        }
        a(false);
    }

    public SmsLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = true;
        this.f3472a = context;
        this.b = LayoutInflater.from(context).inflate(a.f.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.sapi_sdk_sms_login_view, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(a.i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.c = this.b.findViewById(a.e.code_container);
        this.d = (EditText) this.b.findViewById(a.e.phone);
        this.i = this.b.findViewById(a.e.loading_container);
        this.e = (EditText) this.b.findViewById(a.e.check_code);
        this.f = (TextView) this.b.findViewById(a.e.get_code);
        this.g = (TextView) this.b.findViewById(a.e.prompt);
        this.h = this.b.findViewById(a.e.separate_line);
        a(this.d, context.getString(a.g.sapi_sdk_sms_hint_input_phone));
        a(this.e, context.getString(a.g.sapi_sdk_sms_hint_input_check_code));
        this.d.addTextChangedListener(new e(this, null));
        this.e.addTextChangedListener(new c(this, null));
        this.f.setEnabled(false);
        this.f.setOnClickListener(new GetCheckCodeListener(this, null));
        d();
        if (z) {
            new Handler().postDelayed(new a(), 100L);
        }
        if (SapiUtils.getLastLoginType() == 2) {
            String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
            if (!TextUtils.isEmpty(decryptStr) && decryptStr.length() == 11) {
                this.d.setText(decryptStr);
                this.d.setSelection(decryptStr.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.i.setVisibility(0);
        this.j = new d(this.f3472a);
        this.j.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int color;
        int i;
        getResources().getColor(a.b.sapi_sdk_sms_get_code_text_color);
        if (!SapiAccountManager.getInstance().getSapiConfiguration().isNightMode && !SapiAccountManager.getInstance().getSapiConfiguration().isDarkMode) {
            if (z) {
                color = getResources().getColor(a.b.sapi_sdk_sms_get_code_text_color);
                i = -1;
            } else {
                color = getResources().getColor(a.b.sapi_sdk_sms_get_code_disable_color);
                i = -1;
            }
        } else {
            int color2 = getResources().getColor(a.b.sapi_sdk_sms_bg_night_mode);
            if (z) {
                color = getResources().getColor(a.b.sapi_sdk_sms_get_code_text_color_night_mode);
                i = color2;
            } else {
                color = getResources().getColor(a.b.sapi_sdk_sms_get_code_disable_color_night_mode);
                i = color2;
            }
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.f.getBackground();
        gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
        gradientDrawable.setColor(i);
        this.f.setTextColor(color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("pop_login", str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extrajson", CoreViewRouter.getInstance().getSmsLoginStatExtra());
        hashMap.put(BaseJsonData.TAG_ERRNO, str2);
        k.a(linkedHashMap, hashMap);
    }

    private void a(EditText editText, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.i.setVisibility(8);
        try {
            this.j.dismiss();
        } catch (Throwable th) {
        }
    }
}
