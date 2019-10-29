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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class SmsLoginView extends FrameLayout {
    private static final String KEY_PRO_STAT_EXTRA = "extrajson";
    private static final String KEY_SDK_SITUATION = "sdk_situation";
    private static final String KEY_SDK_SITUATION_POP_LOGIN = "pop_login";
    private static final String KEY_SDK_SKIP_REG = "skipreg";
    private EditText checkCode;
    private View codeContainer;
    private Context context;
    private TextView getCode;
    private boolean isFirstGetCheckCode;
    private View loadingContainer;
    private Dialog loadingDialog;
    private String loginPhoneNumber;
    private EditText phone;
    private TextView prompt;
    private View rootView;
    private View separateLine;
    private SmsHandler smsHandler;
    private BroadcastReceiver smsReceiver;
    private CountDownTimer timer;

    /* loaded from: classes2.dex */
    private interface StatEvent {
        public static final String BEGIN_LOGIN = "verify";
        public static final String FINISH_INPUT_HPONE = "input_phone";
        public static final String FIRST_GET_CHCEK_CODE = "first_get_dpass";
        public static final String FIRST_GET_CHECK_CODE_FAILURE = "first_get_dpass_failure";
        public static final String FIRST_GET_CHECK_CODE_SUCC = "first_get_dpass_success";
        public static final String LOGIN_FAILURE = "failure";
        public static final String LOGIN_SHOW = "show";
        public static final String LOGIN_SUCC = "success";
        public static final String RE_GET_CHECK_CODE = "get_dpass_again";
        public static final String RE_GET_CHECK_CODE_FAILURE = "get_dpass_again_failure";
        public static final String RE_GET_CHECK_CODE_SUCC = "get_dpass_again_success";
        public static final String STAT_NAME_POP_LOGIN = "pop_login";
    }

    public SmsLoginView(Context context) {
        this(context, null);
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SmsLoginView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isFirstGetCheckCode = true;
        this.context = context;
        this.smsHandler = new SmsHandler();
        this.rootView = LayoutInflater.from(context).inflate(a.f.layout_sapi_sdk_sms_login_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.sapi_sdk_sms_login_view, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(a.i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.codeContainer = this.rootView.findViewById(a.e.code_container);
        this.phone = (EditText) this.rootView.findViewById(a.e.phone);
        this.loadingContainer = this.rootView.findViewById(a.e.loading_container);
        this.checkCode = (EditText) this.rootView.findViewById(a.e.check_code);
        this.getCode = (TextView) this.rootView.findViewById(a.e.get_code);
        this.prompt = (TextView) this.rootView.findViewById(a.e.prompt);
        this.separateLine = this.rootView.findViewById(a.e.separate_line);
        setHintFontSize(this.phone, context.getString(a.g.sapi_sdk_sms_hint_input_phone));
        setHintFontSize(this.checkCode, context.getString(a.g.sapi_sdk_sms_hint_input_check_code));
        this.phone.addTextChangedListener(new PhoneEditTextChangedListener());
        this.checkCode.addTextChangedListener(new CheckCodeTextChangedListener());
        this.getCode.setEnabled(false);
        this.getCode.setOnClickListener(new GetCheckCodeListener());
        switchNightModeView();
        if (z) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.sapi2.views.SmsLoginView.1
                @Override // java.lang.Runnable
                public void run() {
                    InputMethodManager inputMethodManager = (InputMethodManager) SmsLoginView.this.context.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(SmsLoginView.this.phone, 0);
                    }
                    if (SapiUtils.getLastLoginType() == 2) {
                        String decryptStr = SapiContext.getInstance(context).getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
                        if (!TextUtils.isEmpty(decryptStr) && decryptStr.length() == 11) {
                            SmsLoginView.this.phone.setText(decryptStr);
                            SmsLoginView.this.phone.setSelection(decryptStr.length());
                        }
                    }
                }
            }, 100L);
        }
    }

    public static void notifyStartLogin() {
        onEvent("show", null);
    }

    private void switchNightModeView() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            this.rootView.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_sms_bg_night_mode));
            this.phone.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
            this.phone.setHintTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_hint_color_night_mode));
            this.checkCode.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
            this.checkCode.setHintTextColor(getResources().getColor(a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
            this.prompt.setTextColor(getResources().getColor(a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
            this.separateLine.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_separate_line_color_night_mode));
        }
        updateGetCodeColor(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGetCodeColor(boolean z) {
        int color;
        int i;
        getResources().getColor(a.b.sapi_sdk_sms_get_code_text_color);
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            int color2 = getResources().getColor(a.b.sapi_sdk_sms_bg_night_mode);
            if (z) {
                color = getResources().getColor(a.b.sapi_sdk_sms_get_code_text_color_night_mode);
                i = color2;
            } else {
                color = getResources().getColor(a.b.sapi_sdk_sms_get_code_disable_color_night_mode);
                i = color2;
            }
        } else if (z) {
            color = getResources().getColor(a.b.sapi_sdk_sms_get_code_text_color);
            i = -1;
        } else {
            color = getResources().getColor(a.b.sapi_sdk_sms_get_code_disable_color);
            i = -1;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.getCode.getBackground();
        gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), color);
        gradientDrawable.setColor(i);
        this.getCode.setTextColor(color);
    }

    public void close() {
        if (this.timer != null) {
            this.timer.cancel();
        }
        PassportSDK.getInstance().release();
        unregisterReceiver();
    }

    public void clean() {
        this.checkCode.setText("");
        this.phone.setText("");
        if (this.timer != null) {
            this.timer.cancel();
        }
        this.getCode.setText(a.g.sapi_sdk_sms_get_check_code);
        updateGetCodeColor(false);
    }

    private void setHintFontSize(EditText editText, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    /* loaded from: classes2.dex */
    private class PhoneEditTextChangedListener implements TextWatcher {
        private PhoneEditTextChangedListener() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.toString().length();
            if (length != 0) {
                if (SmsLoginView.this.codeContainer.getVisibility() != 0) {
                    if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                        PassportSDK.getInstance().getSmsViewLoginCallback().onCheckCodeViewShow();
                    }
                    SmsLoginView.this.codeContainer.setVisibility(0);
                    SmsLoginView.this.phone.setGravity(17);
                }
            } else {
                if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                    PassportSDK.getInstance().getSmsViewLoginCallback().onCheckCodeViewHide();
                }
                SmsLoginView.this.codeContainer.setVisibility(8);
                SmsLoginView.this.prompt.setVisibility(8);
                SmsLoginView.this.prompt.setText("");
                SmsLoginView.this.phone.setGravity(19);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.loginPhoneNumber)) {
                    SmsLoginView.this.getCode.setText(a.g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.updateGetCodeColor(false);
                    SmsLoginView.this.prompt.setVisibility(8);
                    SmsLoginView.this.prompt.setText("");
                    SmsLoginView.this.getCode.setEnabled(false);
                }
            } else if (length == 11) {
                if (!SmsLoginView.this.phone.getText().toString().equals(SmsLoginView.this.loginPhoneNumber)) {
                    if (SmsLoginView.this.timer != null) {
                        SmsLoginView.this.timer.cancel();
                    }
                    SmsLoginView.this.getCode.setText(a.g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.updateGetCodeColor(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.getCode.setEnabled(true);
                    } else {
                        SmsLoginView.this.prompt.setVisibility(0);
                        SmsLoginView.this.prompt.setText(a.g.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.onEvent(StatEvent.FINISH_INPUT_HPONE, null);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    }

    /* loaded from: classes2.dex */
    private class CheckCodeTextChangedListener implements TextWatcher {
        private CheckCodeTextChangedListener() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            switch (charSequence.toString().length()) {
                case 0:
                    SmsLoginView.this.checkCode.setGravity(19);
                    return;
                case 1:
                    SmsLoginView.this.prompt.setText("");
                    SmsLoginView.this.prompt.setVisibility(8);
                    SmsLoginView.this.checkCode.setGravity(17);
                    return;
                case 6:
                    if (!TextUtils.isEmpty(SmsLoginView.this.loginPhoneNumber)) {
                        SmsLoginView.this.smsLogin();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smsLogin() {
        String obj = this.checkCode.getText().toString();
        String smsLoginStatExtra = PassportSDK.getInstance().getSmsLoginStatExtra();
        HashMap hashMap = new HashMap();
        if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
            hashMap.put("extrajson", smsLoginStatExtra);
        }
        hashMap.put(KEY_SDK_SITUATION, "pop_login");
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new DynamicPwdLoginCallback() { // from class: com.baidu.sapi2.views.SmsLoginView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
                SmsLoginView.onEvent("success", null);
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                webAuthResult.accountType = AccountType.NORMAL;
                if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                    SapiContext.getInstance(SmsLoginView.this.context).putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, SmsLoginView.this.loginPhoneNumber);
                    SapiContext.getInstance(SmsLoginView.this.context).put(SapiContext.KEY_PRE_LOGIN_TYPE, "sms");
                    PassportSDK.getInstance().getSmsViewLoginCallback().onSuccess(webAuthResult);
                }
                new PtokenStat().onEvent(PtokenStat.LOGIN_POP);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
                SmsLoginView.onEvent(StatEvent.LOGIN_FAILURE, dynamicPwdLoginResult.getResultCode() + "");
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                if (dynamicPwdLoginResult.noNeedBack) {
                    SmsLoginView.this.prompt.setText(dynamicPwdLoginResult.getResultMsg());
                    SmsLoginView.this.prompt.setVisibility(0);
                    SmsLoginView.this.checkCode.setText("");
                    if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                        PassportSDK.getInstance().getSmsViewLoginCallback().onFailure(webAuthResult);
                        return;
                    }
                    return;
                }
                SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.loginPhoneNumber;
                if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                    PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                SmsLoginView.this.showDialog();
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                SmsLoginView.this.hideDialog();
            }
        }, this.loginPhoneNumber, obj, hashMap);
        onEvent(StatEvent.BEGIN_LOGIN, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class GetCheckCodeListener implements View.OnClickListener {
        private GetCheckCodeListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SmsLoginView.this.phone.getText().toString().length() == 11) {
                SmsLoginView.this.isFirstGetCheckCode = SmsLoginView.this.getCode.getText().toString().equals(SmsLoginView.this.context.getString(a.g.sapi_sdk_sms_get_check_code));
                SmsLoginView.this.prompt.setVisibility(8);
                SmsLoginView.this.prompt.setText("");
                SmsLoginView.this.checkCode.requestFocus();
                SmsLoginView.this.registerReceiver(SmsLoginView.this.smsHandler);
                SmsLoginView.this.timer = new CountDownTimer(60000L, 1000L) { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.1
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        SmsLoginView.this.getCode.setText((j / 1000) + SmsLoginView.this.context.getString(a.g.sapi_sdk_sms_second));
                        SmsLoginView.this.getCode.setEnabled(false);
                        SmsLoginView.this.updateGetCodeColor(false);
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        if (SmsLoginView.this.phone.getText().toString().length() == 11) {
                            SmsLoginView.this.getCode.setEnabled(true);
                            SmsLoginView.this.getCode.setText(a.g.sapi_sdk_sms_re_get_check_code);
                            SmsLoginView.this.updateGetCodeColor(true);
                            return;
                        }
                        SmsLoginView.this.getCode.setText(a.g.sapi_sdk_sms_get_check_code);
                        SmsLoginView.this.updateGetCodeColor(false);
                    }
                };
                SmsLoginView.this.timer.start();
                SmsLoginView.this.loginPhoneNumber = SmsLoginView.this.phone.getText().toString();
                String smsLoginStatExtra = PassportSDK.getInstance().getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put(SmsLoginView.KEY_SDK_SITUATION, "pop_login");
                hashMap.put(SmsLoginView.KEY_SDK_SKIP_REG, "1");
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.views.SmsLoginView.GetCheckCodeListener.2
                    /* JADX DEBUG: Method merged with bridge method */
                    public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.isFirstGetCheckCode) {
                            SmsLoginView.onEvent(StatEvent.FIRST_GET_CHECK_CODE_FAILURE, getDynamicPwdResult.getResultCode() + "");
                        } else {
                            SmsLoginView.onEvent(StatEvent.RE_GET_CHECK_CODE_FAILURE, getDynamicPwdResult.getResultCode() + "");
                        }
                        if (SmsLoginView.this.timer != null) {
                            SmsLoginView.this.timer.cancel();
                        }
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.loginPhoneNumber;
                        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.isFirstGetCheckCode) {
                            SmsLoginView.onEvent(StatEvent.FIRST_GET_CHECK_CODE_SUCC, null);
                        } else {
                            SmsLoginView.onEvent(StatEvent.RE_GET_CHECK_CODE_SUCC, null);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                        if (SmsLoginView.this.isFirstGetCheckCode) {
                            SmsLoginView.onEvent(StatEvent.FIRST_GET_CHECK_CODE_FAILURE, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.getCode.setText(a.g.sapi_sdk_sms_get_check_code);
                        } else {
                            SmsLoginView.onEvent(StatEvent.RE_GET_CHECK_CODE_FAILURE, getDynamicPwdResult.getResultCode() + "");
                            SmsLoginView.this.getCode.setText(a.g.sapi_sdk_sms_re_get_check_code);
                        }
                        if (SmsLoginView.this.timer != null) {
                            SmsLoginView.this.timer.cancel();
                        }
                        SmsLoginView.this.getCode.setEnabled(true);
                        SmsLoginView.this.updateGetCodeColor(true);
                        if (getDynamicPwdResult.noNeedBack) {
                            SmsLoginView.this.prompt.setText(getDynamicPwdResult.getResultMsg());
                            SmsLoginView.this.prompt.setVisibility(0);
                            return;
                        }
                        WebAuthResult webAuthResult = new WebAuthResult();
                        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
                        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
                        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.loginPhoneNumber;
                        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
                        }
                    }

                    public void onStart() {
                    }

                    public void onFinish() {
                    }
                }, SmsLoginView.this.loginPhoneNumber, null, hashMap);
                if (SmsLoginView.this.isFirstGetCheckCode) {
                    SmsLoginView.onEvent(StatEvent.FIRST_GET_CHCEK_CODE, null);
                } else {
                    SmsLoginView.onEvent(StatEvent.RE_GET_CHECK_CODE, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerReceiver(Handler handler) {
        if (this.smsReceiver == null) {
            SapiCoreUtil.registerReceiver(this.context, handler, new RequestSMSCallback() { // from class: com.baidu.sapi2.views.SmsLoginView.3
                @Override // com.baidu.sapi2.callback.RequestSMSCallback
                public void receiverResult(BroadcastReceiver broadcastReceiver) {
                    SmsLoginView.this.smsReceiver = broadcastReceiver;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterReceiver() {
        if (this.smsReceiver != null) {
            try {
                getContext().unregisterReceiver(this.smsReceiver);
            } catch (Throwable th) {
            }
        }
        this.smsReceiver = null;
    }

    /* loaded from: classes2.dex */
    private class SmsHandler extends Handler {
        private SmsHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj != null) {
                SmsLoginView.this.checkCode.setText((String) message.obj);
                SmsLoginView.this.unregisterReceiver();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.loadingContainer.setVisibility(0);
        this.loadingDialog = new EmptyDialog(this.context);
        this.loadingDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class EmptyDialog extends Dialog {
        public EmptyDialog(Context context) {
            super(context, a.h.sapi_sdk_empty_dialog);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideDialog() {
        this.loadingContainer.setVisibility(8);
        try {
            this.loadingDialog.dismiss();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onEvent(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("pop_login", str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extrajson", PassportSDK.getInstance().getSmsLoginStatExtra());
        hashMap.put("errno", str2);
        StatService.onEventAutoStatistic(linkedHashMap, hashMap);
    }
}
