package com.baidu.sapi2.views.logindialog.page;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.utils.VibrateUtils;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.view.a;
import com.baidu.tieba.R;
import java.text.MessageFormat;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SmsPager extends LinearLayout implements a.c {
    public static final String q = "sdk_situation";
    public static final String r = "pop_login";
    public static final String s = "skipreg";
    public Context a;
    public String b;
    public ColorType c;
    public int d;
    public TextView e;
    public FrameLayout f;
    public TextView g;
    public TextView h;
    public TextView i;
    public IQuickLoginDialogCallback j;
    public IPagerLoadCallback k;
    public ILoginConfirmCallback l;
    public ISendSmsCallback m;
    public com.baidu.sapi2.views.logindialog.view.a n;
    public Animation o;
    public CountDownTimer p;

    /* loaded from: classes2.dex */
    public class d extends DynamicPwdLoginCallback {
        public final /* synthetic */ long a;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SmsPager.this.n != null) {
                    SmsPager.this.n.c();
                }
            }
        }

        public d(long j) {
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
            if (dynamicPwdLoginResult == null) {
                return;
            }
            com.baidu.sapi2.views.logindialog.utils.a.a("sms_login", System.currentTimeMillis() - this.a, dynamicPwdLoginResult.getResultCode(), dynamicPwdLoginResult.getResultMsg());
            if (dynamicPwdLoginResult.getResultCode() == 12) {
                SmsPager.this.g.setVisibility(0);
                SmsPager.this.g.setText("验证码有误，请重新输入");
                SmsPager.this.n.a();
                VibrateUtils.presetVibrate(SmsPager.this.a);
                SmsPager smsPager = SmsPager.this;
                smsPager.startAnimation(smsPager.o);
                SmsPager.this.postDelayed(new a(), 600L);
            } else if (SmsPager.this.j != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                quickLoginResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.SMS;
                SmsPager.this.j.onLoginFailure(quickLoginResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
            if (dynamicPwdLoginResult == null) {
                return;
            }
            com.baidu.sapi2.views.logindialog.utils.a.a("sms_login", System.currentTimeMillis() - this.a, dynamicPwdLoginResult.getResultCode(), dynamicPwdLoginResult.getResultMsg());
            if (SmsPager.this.j != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                quickLoginResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.SMS;
                SmsPager.this.j.onLoginSuccess(quickLoginResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SmsPager.this.i.setText("重新发送");
            SmsPager.this.i.setClickable(true);
            if (ColorType.DARK == SmsPager.this.c) {
                SmsPager.this.i.setTextColor(Color.parseColor("#CCFFFFFF"));
            } else {
                SmsPager.this.i.setTextColor(Color.parseColor("#1F1F1F"));
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            SmsPager.this.i.setText(String.format("重新发送 (%ds)", Long.valueOf(j / 1000)));
            SmsPager.this.i.setClickable(false);
            if (ColorType.DARK == SmsPager.this.c) {
                SmsPager.this.i.setTextColor(Color.parseColor("#80FFFFFF"));
            } else {
                SmsPager.this.i.setTextColor(Color.parseColor("#858585"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            com.baidu.sapi2.views.logindialog.utils.a.a("change_phone_number");
            if (SmsPager.this.k != null) {
                SmsPager.this.k.onChange2LoginPage();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SmsPager smsPager = SmsPager.this;
            smsPager.d(smsPager.b);
        }
    }

    public SmsPager(Context context, ColorType colorType, IQuickLoginDialogCallback iQuickLoginDialogCallback, IPagerLoadCallback iPagerLoadCallback, ISendSmsCallback iSendSmsCallback) {
        super(context, null);
        this.p = new a(60000L, 1000L);
        this.a = context;
        this.c = colorType;
        this.j = iQuickLoginDialogCallback;
        this.k = iPagerLoadCallback;
        this.m = iSendSmsCallback;
        e();
    }

    private void d() {
        if (ColorType.DARK == this.c) {
            this.e.setTextColor(Color.parseColor("#80FFFFFF"));
            this.h.setTextColor(Color.parseColor("#CCFFFFFF"));
            this.i.setTextColor(Color.parseColor("#80FFFFFF"));
        }
    }

    public void a() {
        this.p.cancel();
    }

    public void b() {
        this.g.setVisibility(8);
    }

    public void c() {
        this.p.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_situation", "pop_login");
        hashMap.put("skipreg", "1");
        final long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.views.logindialog.page.SmsPager.5
            public void onFinish() {
            }

            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a("reget_sms_code", System.currentTimeMillis() - currentTimeMillis, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                if (SmsPager.this.m != null) {
                    SmsPager.this.m.onSendSmsFailure(str, getDynamicPwdResult);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a("reget_sms_code", System.currentTimeMillis() - currentTimeMillis, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                if (SmsPager.this.m != null) {
                    SmsPager.this.m.onSendSmsFailure(str, getDynamicPwdResult);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a("reget_sms_code", System.currentTimeMillis() - currentTimeMillis, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                if (getDynamicPwdResult.getResultCode() != 0) {
                    onFailure(getDynamicPwdResult);
                    return;
                }
                ToastUtil.show("发送成功");
                SmsPager.this.p.start();
            }
        }, str, null, hashMap);
    }

    @Override // com.baidu.sapi2.views.logindialog.view.a.c
    public void a(String str) {
        b(str);
    }

    public void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_situation", "pop_login");
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new d(System.currentTimeMillis()), this.b, str, hashMap);
    }

    public void c(String str) {
        this.g.setVisibility(0);
        this.g.setText(str);
    }

    private void e() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_sms_pager, this);
        this.e = (TextView) findViewById(R.id.sapi_sdk_tv_input_code_tip);
        this.f = (FrameLayout) findViewById(R.id.sapi_sdk_fl_input_box);
        this.g = (TextView) findViewById(R.id.sapi_sdk_tv_error_tip);
        this.h = (TextView) findViewById(R.id.sapi_sdk_tv_change_phone_number);
        this.i = (TextView) findViewById(R.id.sapi_sdk_tv_resend_code);
        this.h.setOnClickListener(new b());
        this.i.setOnClickListener(new c());
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.sapi_sdk_shake);
        this.o = loadAnimation;
        loadAnimation.setRepeatCount(5);
        d();
    }

    public void a(String str, int i) {
        this.b = str;
        this.d = i;
        this.e.setText(MessageFormat.format("验证码已发送至您的手机 {0}", str));
        this.f.removeAllViews();
        com.baidu.sapi2.views.logindialog.view.a aVar = new com.baidu.sapi2.views.logindialog.view.a(this.a);
        this.n = aVar;
        aVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.n.setBox(i);
        if (ColorType.DARK == this.c) {
            this.n.setBoxNormalBg(this.a.getResources().getDrawable(R.drawable.sapi_sdk_verification_edit_bg_normal_dark));
            this.n.setBoxErrorBg(this.a.getResources().getDrawable(R.drawable.sapi_sdk_verification_edit_bg_error_dark));
            this.n.setTextColor(Color.parseColor("#CCFFFFFF"));
        } else {
            this.n.setBoxNormalBg(this.a.getResources().getDrawable(R.drawable.sapi_sdk_verification_edit_bg_normal));
            this.n.setBoxErrorBg(this.a.getResources().getDrawable(R.drawable.sapi_sdk_verification_edit_bg_error));
            this.n.setTextColor(Color.parseColor("#1F1F1F"));
        }
        this.n.b();
        this.n.setListener(this);
        this.f.addView(this.n);
    }
}
