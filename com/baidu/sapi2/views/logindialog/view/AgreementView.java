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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.utils.VibrateUtils;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class AgreementView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String j = "百度用户协议";
    public static final String k = "https://wappass.baidu.com/passport/agreement?adapter=3";
    public static final String l = "隐私政策";
    public static final String m = "https://wappass.baidu.com/passport/agreement?personal=1&adapter=3";
    public static final String n = "儿童个人信息保护声明";
    public static final String o = "http://privacy.baidu.com/policy/children-privacy-policy/index.html";
    public static final String p = "中国移动认证服务条款";
    public static final String q = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String r = "中国联通认证服务协议";
    public static final String s = "https://ms.zzx9.cn/html/oauth/protocol2.html";
    public static final String t = "中国电信天翼账号服务条款";
    public static final String u = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String v = "阅读并同意百度用户协议 隐私政策 和 儿童个人信息保护声明";
    public static final String w = "阅读并同意百度用户协议 隐私政策";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Activity b;
    public TextView c;
    public ImageView d;
    public boolean e;
    public boolean f;
    public Animation g;
    public SpannableStringBuilder h;
    public IQuickLoginDialogCallback i;

    /* loaded from: classes2.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreementView a;

        public a(AgreementView agreementView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreementView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreementView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a("user_agreement");
                this.a.a(AgreementView.j, AgreementView.k);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(true);
                textPaint.setColor(Color.parseColor("#858585"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreementView a;

        public b(AgreementView agreementView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreementView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreementView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a("privacy_policy");
                this.a.a(AgreementView.l, AgreementView.m);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(true);
                textPaint.setColor(Color.parseColor("#858585"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreementView a;

        public c(AgreementView agreementView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreementView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreementView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a("children_agreement");
                this.a.a(AgreementView.n, AgreementView.o);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(true);
                textPaint.setColor(Color.parseColor("#858585"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AgreementView c;

        public d(AgreementView agreementView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreementView, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = agreementView;
            this.a = str;
            this.b = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a(this.a);
                this.c.a(AgreementView.l, this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(true);
                textPaint.setColor(Color.parseColor("#858585"));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgreementView(Context context) {
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

    private void c() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            boolean booleanValue = SapiContext.getInstance().getSapiOptions().getIsProtocolCheck(SapiAccountManager.getInstance().getConfignation().tpl).booleanValue();
            this.e = booleanValue;
            ImageView imageView = this.d;
            if (booleanValue) {
                drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08106c);
            } else {
                drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08106d);
            }
            imageView.setBackgroundDrawable(drawable);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04d5, this);
            setPadding(0, ViewUtils.dp2px(this.a, 25.0f), 0, 0);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091d9a);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d43);
            this.d = imageView;
            imageView.setOnClickListener(this);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010119);
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
                this.h.setSpan(new a(this), matcher.start(), matcher.end(), 33);
            }
            Matcher matcher2 = Pattern.compile(l).matcher(this.h);
            while (matcher2.find()) {
                this.h.setSpan(new b(this), matcher2.start(), matcher2.end(), 33);
            }
            if (this.f) {
                Matcher matcher3 = Pattern.compile(n).matcher(this.h);
                while (matcher3.find()) {
                    this.h.setSpan(new c(this), matcher3.start(), matcher3.end(), 33);
                }
            }
            this.c.setText(this.h);
            this.c.setMovementMethod(LinkMovementMethod.getInstance());
            c();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void a(Activity activity, IQuickLoginDialogCallback iQuickLoginDialogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, iQuickLoginDialogCallback) == null) {
            this.b = activity;
            this.i = iQuickLoginDialogCallback;
            iQuickLoginDialogCallback.onPreShowAgreement(this.c, this.h);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.e) {
                VibrateUtils.presetVibrate(this.a);
                startAnimation(this.g);
            }
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            com.baidu.sapi2.views.logindialog.utils.a.a("select_agree");
            boolean z = !this.e;
            this.e = z;
            ImageView imageView = this.d;
            if (z) {
                drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08106c);
            } else {
                drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08106d);
            }
            imageView.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgreementView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
    public AgreementView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.f = true;
        this.a = context;
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096 A[LOOP:0: B:35:0x0090->B:37:0x0096, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        char c2;
        String str2;
        String str3;
        String str4;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            SpannableStringBuilder spannableStringBuilder = this.h;
            int hashCode = str.hashCode();
            if (hashCode == 2154) {
                if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 2161) {
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
            String str5 = "https://wap.cmpassport.com/resources/html/contract.html";
            String str6 = "";
            if (c2 == 0) {
                str2 = "cmcc_agreement";
                str3 = p;
            } else if (c2 == 1) {
                str2 = "cucc_agreement";
                str3 = r;
                str5 = s;
            } else if (c2 != 2) {
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
                    spannableStringBuilder.setSpan(new d(this, str4, str5), matcher.start(), matcher.end(), 33);
                }
                this.c.setText(spannableStringBuilder);
                this.i.onPreShowAgreementWithOperator(this.c, str, spannableStringBuilder);
            } else {
                str2 = "ctcc_agreement";
                str3 = t;
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
            this.i.onPreShowAgreementWithOperator(this.c, str, spannableStringBuilder);
        }
    }

    public void a(String str, String str2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || (activity = this.b) == null) {
            return;
        }
        Intent intent = new Intent(activity, LoadExternalWebViewActivity.class);
        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
        intent.putExtra("extra_external_url", str2);
        this.b.startActivity(intent);
    }
}
