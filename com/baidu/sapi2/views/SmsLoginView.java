package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.i.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class SmsLoginView extends FrameLayout implements com.baidu.sapi2.c {
    private static final String a = "extrajson";
    private static final String b = "sdk_situation";
    private static final String c = "pop_login";
    private static final String d = "skipreg";
    private Context e;
    private View f;
    private View g;
    private EditText h;
    private EditText i;
    private TextView j;
    private TextView k;
    private View l;
    private View m;
    private Dialog n;
    private CountDownTimer o;
    private String p;
    private boolean q;
    private BroadcastReceiver r;
    private e s;

    /* loaded from: classes6.dex */
    private class a implements TextWatcher {
        private a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.i("dragon", "onTextChanged");
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsLoginView.this.i.setGravity(19);
            } else if (length != 1) {
                if (length == 6 && !TextUtils.isEmpty(SmsLoginView.this.p)) {
                    SmsLoginView.this.c();
                }
            } else {
                SmsLoginView.this.k.setText("");
                SmsLoginView.this.k.setVisibility(8);
                SmsLoginView.this.i.setGravity(17);
            }
        }

        /* synthetic */ a(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends Dialog {
        public b(Context context) {
            super(context, a.h.sapi_sdk_empty_dialog);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SmsLoginView.this.h.getText().toString().length() == 11) {
                SmsLoginView smsLoginView = SmsLoginView.this;
                smsLoginView.q = smsLoginView.j.getText().toString().equals(SmsLoginView.this.e.getString(a.g.sapi_sdk_sms_get_check_code));
                SmsLoginView.this.k.setVisibility(8);
                SmsLoginView.this.k.setText("");
                SmsLoginView.this.i.requestFocus();
                SmsLoginView smsLoginView2 = SmsLoginView.this;
                smsLoginView2.a(smsLoginView2.s);
                SmsLoginView.this.o = new k(this, 60000L, 1000L);
                SmsLoginView.this.o.start();
                SmsLoginView smsLoginView3 = SmsLoginView.this;
                smsLoginView3.p = smsLoginView3.h.getText().toString();
                String smsLoginStatExtra = PassportSDK.getInstance().getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put(SmsLoginView.b, "pop_login");
                hashMap.put(SmsLoginView.d, "1");
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new l(this), SmsLoginView.this.p, null, hashMap);
                if (SmsLoginView.this.q) {
                    SmsLoginView.b(f.d, (String) null);
                } else {
                    SmsLoginView.b(f.g, (String) null);
                }
            }
        }

        /* synthetic */ c(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    private class d implements TextWatcher {
        private d() {
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
                if (SmsLoginView.this.g.getVisibility() != 0) {
                    if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                        PassportSDK.getInstance().getSmsViewLoginCallback().onCheckCodeViewShow();
                    }
                    SmsLoginView.this.g.setVisibility(0);
                    SmsLoginView.this.h.setGravity(17);
                }
            } else {
                if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                    PassportSDK.getInstance().getSmsViewLoginCallback().onCheckCodeViewHide();
                }
                SmsLoginView.this.g.setVisibility(8);
                SmsLoginView.this.k.setVisibility(8);
                SmsLoginView.this.k.setText("");
                SmsLoginView.this.h.setGravity(19);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.p)) {
                    SmsLoginView.this.j.setText(a.g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(false);
                    SmsLoginView.this.k.setVisibility(8);
                    SmsLoginView.this.k.setText("");
                    SmsLoginView.this.j.setEnabled(false);
                }
            } else if (length == 11) {
                if (!SmsLoginView.this.h.getText().toString().equals(SmsLoginView.this.p)) {
                    if (SmsLoginView.this.o != null) {
                        SmsLoginView.this.o.cancel();
                    }
                    SmsLoginView.this.j.setText(a.g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.j.setEnabled(true);
                    } else {
                        SmsLoginView.this.k.setVisibility(0);
                        SmsLoginView.this.k.setText(a.g.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.b(f.c, (String) null);
            }
        }

        /* synthetic */ d(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    private class e extends Handler {
        private e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj != null) {
                SmsLoginView.this.i.setText((String) obj);
                SmsLoginView.this.e();
            }
        }

        /* synthetic */ e(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    private interface f {
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

    public SmsLoginView(Context context) {
        this(context, null);
    }

    public static void notifyStartLogin() {
        b("show", (String) null);
    }

    public void clean() {
        this.i.setText("");
        this.h.setText("");
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.j.setText(a.g.sapi_sdk_sms_get_check_code);
        a(false);
    }

    public void close() {
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        PassportSDK.getInstance().release();
        e();
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String obj = this.i.getText().toString();
        String smsLoginStatExtra = PassportSDK.getInstance().getSmsLoginStatExtra();
        HashMap hashMap = new HashMap();
        if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
            hashMap.put("extrajson", smsLoginStatExtra);
        }
        hashMap.put(b, "pop_login");
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new i(this), this.p, obj, hashMap);
        b(f.j, (String) null);
    }

    private void d() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode || SapiAccountManager.getInstance().getSapiConfiguration().isDarkMode) {
            this.f.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_sms_bg_night_mode));
            this.h.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
            this.h.setHintTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_hint_color_night_mode));
            this.i.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
            this.i.setHintTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
            this.k.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
            this.l.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_separate_line_color_night_mode));
        }
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.r != null) {
            try {
                getContext().unregisterReceiver(this.r);
            } catch (Throwable th) {
            }
        }
        this.r = null;
    }

    public SmsLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = true;
        this.e = context;
        this.s = new e(this, null);
        this.f = LayoutInflater.from(context).inflate(a.f.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.sapi_sdk_sms_login_view, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(a.i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.g = this.f.findViewById(a.e.code_container);
        this.h = (EditText) this.f.findViewById(a.e.phone);
        this.m = this.f.findViewById(a.e.loading_container);
        this.i = (EditText) this.f.findViewById(a.e.check_code);
        this.j = (TextView) this.f.findViewById(a.e.get_code);
        this.k = (TextView) this.f.findViewById(a.e.prompt);
        this.l = this.f.findViewById(a.e.separate_line);
        a(this.h, context.getString(a.g.sapi_sdk_sms_hint_input_phone));
        a(this.i, context.getString(a.g.sapi_sdk_sms_hint_input_check_code));
        this.h.addTextChangedListener(new d(this, null));
        this.i.addTextChangedListener(new a(this, null));
        this.j.setEnabled(false);
        this.j.setOnClickListener(new c(this, null));
        d();
        if (z) {
            new Handler().postDelayed(new h(this), 100L);
        }
        if (SapiUtils.getLastLoginType() == 2) {
            String decryptStr = SapiContext.getInstance(context).getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
            if (!TextUtils.isEmpty(decryptStr) && decryptStr.length() == 11) {
                this.h.setText(decryptStr);
                this.h.setSelection(decryptStr.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.m.setVisibility(0);
        this.n = new b(this.e);
        this.n.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("pop_login", str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extrajson", PassportSDK.getInstance().getSmsLoginStatExtra());
        hashMap.put("errno", str2);
        com.baidu.sapi2.utils.r.a(linkedHashMap, hashMap);
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
        GradientDrawable gradientDrawable = (GradientDrawable) this.j.getBackground();
        gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
        gradientDrawable.setColor(i);
        this.j.setTextColor(color);
    }

    private void a(EditText editText, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler) {
        if (this.r == null) {
            com.baidu.sapi2.utils.e.a(this.e, handler, new j(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.m.setVisibility(8);
        try {
            this.n.dismiss();
        } catch (Throwable th) {
        }
    }
}
