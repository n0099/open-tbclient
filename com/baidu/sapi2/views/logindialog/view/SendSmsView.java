package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsUICallback;
import com.baidu.tieba.R;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class SendSmsView extends LinearLayout {
    public static final String i = "sdk_situation";
    public static final String j = "pop_login";
    public static final String k = "skipreg";
    public Context a;
    public EditText b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public ISendSmsCallback f;
    public ILoginConfirmCallback g;
    public ISendSmsUICallback h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SendSmsView.this.b.setText("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = editable.toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.length() != 0) {
                SendSmsView.this.c.setVisibility(0);
                SendSmsView.this.d.setVisibility(0);
                SendSmsView.this.h.onHideThirdParty();
            } else {
                SendSmsView.this.c.setVisibility(8);
                SendSmsView.this.d.setVisibility(8);
                SendSmsView.this.h.onShowThirdParty();
            }
            SendSmsView.this.h.onHideErrorTip();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SendSmsView.this.f == null) {
                Log.e(QuickLoginDialog.STAG, "sharelogin mWebAuthListener is null");
            } else if (!SendSmsView.this.g.onPreStart(false)) {
                Log.e(QuickLoginDialog.STAG, "sharelogin privacy is not agree");
            } else {
                String trim = SendSmsView.this.b.getText().toString().trim();
                if (!TextUtils.isEmpty(trim) && trim.length() == 11) {
                    SendSmsView.this.b(trim);
                } else {
                    ToastUtil.show("请您输入正确的手机号");
                }
            }
        }
    }

    public SendSmsView(Context context) {
        this(context, null);
    }

    public SendSmsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendSmsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        c();
    }

    public void a(ILoginConfirmCallback iLoginConfirmCallback, ISendSmsCallback iSendSmsCallback, ISendSmsUICallback iSendSmsUICallback) {
        this.g = iLoginConfirmCallback;
        this.f = iSendSmsCallback;
        this.h = iSendSmsUICallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_situation", "pop_login");
        hashMap.put("skipreg", "1");
        final long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.views.logindialog.view.SendSmsView.4
            public void onFinish() {
            }

            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a("get_sms_code", System.currentTimeMillis() - currentTimeMillis, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                if (SendSmsView.this.f != null) {
                    SendSmsView.this.f.onSendSmsFailure(str, getDynamicPwdResult);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a("get_sms_code", System.currentTimeMillis() - currentTimeMillis, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                if (SendSmsView.this.f != null) {
                    SendSmsView.this.f.onSendSmsFailure(str, getDynamicPwdResult);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a("get_sms_code", System.currentTimeMillis() - currentTimeMillis, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                if (SendSmsView.this.f != null) {
                    if (getDynamicPwdResult.getResultCode() != 0) {
                        SendSmsView.this.f.onSendSmsFailure(str, getDynamicPwdResult);
                    } else {
                        SendSmsView.this.f.onSendSmsSuccess(true, str, getDynamicPwdResult);
                    }
                }
            }
        }, str, null, hashMap);
    }

    public void a(Activity activity) {
        EditText editText = this.b;
        if (editText != null) {
            editText.setFocusable(true);
            this.b.setFocusableInTouchMode(true);
            this.b.requestFocus();
            ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(this.b, 0);
        }
    }

    private void c() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_send_sms, this);
        setOrientation(1);
        this.b = (EditText) findViewById(R.id.sapi_sdk_et_login_dialog_phone_input);
        this.c = (ImageView) findViewById(R.id.sapi_sdk_iv_login_dialog_phone_clear);
        this.d = (TextView) findViewById(R.id.sapi_sdk_tv_login_dialog_send_sms);
        this.e = (TextView) findViewById(R.id.sapi_sdk_tv_error_tip);
        this.c.setOnClickListener(new a());
        this.b.addTextChangedListener(new b());
        this.d.setOnClickListener(new c());
    }

    public void a() {
        this.b.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.b.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_quick_login_dialog_sms_input_bg_dark));
    }

    public void b() {
        this.e.setVisibility(8);
    }

    public TextView getTvSendSms() {
        return this.d;
    }

    public void a(String str) {
        this.e.setText(str);
        this.e.setVisibility(0);
    }
}
