package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.utils.VibrateUtils;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class AgreementView extends LinearLayout implements View.OnClickListener {
    public static final String j = "百度用户协议";
    public static final String k = "https://wappass.baidu.com/passport/agreement?adapter=3";
    public static final String l = "隐私政策";
    public static final String m = "https://wappass.baidu.com/passport/agreement?personal=1&adapter=3";
    public static final String n = "儿童个人信息保护声明";
    public static final String o = "https://privacy.baidu.com/policy/children-privacy-policy/index.html";
    public static final String p = "中国移动认证服务条款";
    public static final String q = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String r = "中国联通认证服务协议";
    public static final String s = "https://ms.zzx9.cn/html/oauth/protocol2.html";
    public static final String t = "中国电信天翼账号服务条款";
    public static final String u = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String v = "阅读并同意百度用户协议 隐私政策 和 儿童个人信息保护声明";
    public static final String w = "阅读并同意百度用户协议 隐私政策";
    public Context a;
    public Activity b;
    public TextView c;
    public ImageView d;
    public boolean e;
    public boolean f;
    public Animation g;
    public SpannableStringBuilder h;
    public IQuickLoginDialogCallback i;

    public void a() {
    }

    /* loaded from: classes2.dex */
    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            com.baidu.sapi2.views.logindialog.utils.a.a("user_agreement");
            AgreementView.this.a(AgreementView.j, AgreementView.k);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
            textPaint.setColor(Color.parseColor("#858585"));
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            com.baidu.sapi2.views.logindialog.utils.a.a("privacy_policy");
            AgreementView.this.a(AgreementView.l, AgreementView.m);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
            textPaint.setColor(Color.parseColor("#858585"));
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            com.baidu.sapi2.views.logindialog.utils.a.a("children_agreement");
            AgreementView.this.a(AgreementView.n, AgreementView.o);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
            textPaint.setColor(Color.parseColor("#858585"));
        }
    }

    /* loaded from: classes2.dex */
    public class d extends ClickableSpan {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            com.baidu.sapi2.views.logindialog.utils.a.a(this.a);
            AgreementView.this.a(AgreementView.l, this.b);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
            textPaint.setColor(Color.parseColor("#858585"));
        }
    }

    public AgreementView(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Drawable drawable;
        com.baidu.sapi2.views.logindialog.utils.a.a("select_agree");
        boolean z = !this.e;
        this.e = z;
        ImageView imageView = this.d;
        if (z) {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_checked);
        } else {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_narmol);
        }
        imageView.setBackgroundDrawable(drawable);
    }

    public AgreementView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(Activity activity, IQuickLoginDialogCallback iQuickLoginDialogCallback) {
        this.b = activity;
        this.i = iQuickLoginDialogCallback;
        iQuickLoginDialogCallback.onPreShowAgreement(this.c, this.h);
    }

    public AgreementView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.a = context;
        d();
    }

    private void c() {
        Drawable drawable;
        boolean booleanValue = SapiContext.getInstance().getSapiOptions().getIsProtocolCheck(SapiAccountManager.getInstance().getConfignation().tpl).booleanValue();
        this.e = booleanValue;
        ImageView imageView = this.d;
        if (booleanValue) {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_checked);
        } else {
            drawable = this.a.getResources().getDrawable(R.drawable.sapi_sdk_icon_quick_login_dialog_selector_narmol);
        }
        imageView.setBackgroundDrawable(drawable);
    }

    private void d() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_agreement, this);
        setPadding(0, ViewUtils.dp2px(this.a, 25.0f), 0, 0);
        this.c = (TextView) findViewById(R.id.sapi_sdk_tv_login_dialog_agreement);
        ImageView imageView = (ImageView) findViewById(R.id.sapi_sdk_iv_login_dialog_agreement_selector);
        this.d = imageView;
        imageView.setOnClickListener(this);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.sapi_sdk_shake);
        this.g = loadAnimation;
        loadAnimation.setRepeatCount(5);
        boolean isShowChildrenAgreement = SapiContext.getInstance().getSapiOptions().getIsShowChildrenAgreement();
        this.f = isShowChildrenAgreement;
        if (isShowChildrenAgreement) {
            this.h = new SpannableStringBuilder(v);
        } else {
            this.h = new SpannableStringBuilder(w);
        }
        Matcher matcher = Pattern.compile(j).matcher(this.h);
        while (matcher.find()) {
            this.h.setSpan(new a(), matcher.start(), matcher.end(), 33);
        }
        Matcher matcher2 = Pattern.compile(l).matcher(this.h);
        while (matcher2.find()) {
            this.h.setSpan(new b(), matcher2.start(), matcher2.end(), 33);
        }
        if (this.f) {
            Matcher matcher3 = Pattern.compile(n).matcher(this.h);
            while (matcher3.find()) {
                this.h.setSpan(new c(), matcher3.start(), matcher3.end(), 33);
            }
        }
        this.c.setText(this.h);
        this.d.setContentDescription(this.c.getText());
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092 A[LOOP:0: B:33:0x008c->B:35:0x0092, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        char c2;
        String str2;
        String str3;
        String str4;
        Matcher matcher;
        SpannableStringBuilder spannableStringBuilder = this.h;
        int hashCode = str.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                    c2 = 2;
                }
                c2 = 65535;
            }
        } else {
            if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 0;
            }
            c2 = 65535;
        }
        String str5 = "https://wap.cmpassport.com/resources/html/contract.html";
        String str6 = "";
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    str4 = "";
                    str5 = str4;
                    if (!this.f) {
                        int indexOf = spannableStringBuilder.toString().indexOf("和");
                        spannableStringBuilder.insert(indexOf, (CharSequence) (str6 + " "));
                    } else {
                        spannableStringBuilder.append((CharSequence) " 和 ").append((CharSequence) str6);
                    }
                    matcher = Pattern.compile(str6).matcher(spannableStringBuilder);
                    while (matcher.find()) {
                        spannableStringBuilder.setSpan(new d(str4, str5), matcher.start(), matcher.end(), 33);
                    }
                    this.c.setText(spannableStringBuilder);
                    this.d.setContentDescription(this.c.getText());
                    this.i.onPreShowAgreementWithOperator(this.c, str, spannableStringBuilder);
                }
                str2 = "ctcc_agreement";
                str3 = t;
            } else {
                str2 = "cucc_agreement";
                str3 = r;
                str5 = s;
            }
        } else {
            str2 = "cmcc_agreement";
            str3 = p;
        }
        String str7 = str2;
        str6 = str3;
        str4 = str7;
        if (!this.f) {
        }
        matcher = Pattern.compile(str6).matcher(spannableStringBuilder);
        while (matcher.find()) {
        }
        this.c.setText(spannableStringBuilder);
        this.d.setContentDescription(this.c.getText());
        this.i.onPreShowAgreementWithOperator(this.c, str, spannableStringBuilder);
    }

    public void a(String str, String str2) {
        Activity activity = this.b;
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, LoadExternalWebViewActivity.class);
        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
        intent.putExtra("extra_external_url", str2);
        this.b.startActivity(intent);
    }

    public boolean b() {
        if (!this.e) {
            VibrateUtils.presetVibrate(this.a);
            startAnimation(this.g);
            TextView textView = this.c;
            if (textView != null) {
                announceForAccessibility(textView.getText());
            }
        }
        return this.e;
    }
}
