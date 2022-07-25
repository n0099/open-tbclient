package com.baidu.sapi2.views.logindialog.page;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SmsPager extends LinearLayout implements a.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String q = "sdk_situation";
    public static final String r = "pop_login";
    public static final String s = "skipreg";
    public transient /* synthetic */ FieldHolder $fh;
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
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsPager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SmsPager smsPager, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsPager, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smsPager;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i.setText("重新发送");
                this.a.i.setClickable(true);
                if (ColorType.DARK == this.a.c) {
                    this.a.i.setTextColor(Color.parseColor("#CCFFFFFF"));
                } else {
                    this.a.i.setTextColor(Color.parseColor("#1F1F1F"));
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.i.setText(String.format("重新发送 (%ds)", Long.valueOf(j / 1000)));
                this.a.i.setClickable(false);
                if (ColorType.DARK == this.a.c) {
                    this.a.i.setTextColor(Color.parseColor("#80FFFFFF"));
                } else {
                    this.a.i.setTextColor(Color.parseColor("#858585"));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsPager a;

        public b(SmsPager smsPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smsPager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a("change_phone_number");
                if (this.a.k != null) {
                    this.a.k.onChange2LoginPage();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmsPager a;

        public c(SmsPager smsPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smsPager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SmsPager smsPager = this.a;
                smsPager.d(smsPager.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends DynamicPwdLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ SmsPager b;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b.n == null) {
                    return;
                }
                this.a.b.n.c();
            }
        }

        public d(SmsPager smsPager, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smsPager, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = smsPager;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dynamicPwdLoginResult) == null) || dynamicPwdLoginResult == null) {
                return;
            }
            com.baidu.sapi2.views.logindialog.utils.a.a("sms_login", System.currentTimeMillis() - this.a, dynamicPwdLoginResult.getResultCode(), dynamicPwdLoginResult.getResultMsg());
            if (dynamicPwdLoginResult.getResultCode() == 12) {
                this.b.g.setVisibility(0);
                this.b.g.setText("验证码有误，请重新输入");
                this.b.n.a();
                VibrateUtils.presetVibrate(this.b.a);
                SmsPager smsPager = this.b;
                smsPager.startAnimation(smsPager.o);
                this.b.postDelayed(new a(this), 600L);
            } else if (this.b.j != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                quickLoginResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.SMS;
                this.b.j.onLoginFailure(quickLoginResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dynamicPwdLoginResult) == null) || dynamicPwdLoginResult == null) {
                return;
            }
            com.baidu.sapi2.views.logindialog.utils.a.a("sms_login", System.currentTimeMillis() - this.a, dynamicPwdLoginResult.getResultCode(), dynamicPwdLoginResult.getResultMsg());
            if (this.b.j != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(dynamicPwdLoginResult.getResultCode());
                quickLoginResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.SMS;
                this.b.j.onLoginSuccess(quickLoginResult);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsPager(Context context, ColorType colorType, IQuickLoginDialogCallback iQuickLoginDialogCallback, IPagerLoadCallback iPagerLoadCallback, ISendSmsCallback iSendSmsCallback) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, colorType, iQuickLoginDialogCallback, iPagerLoadCallback, iSendSmsCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this, 60000L, 1000L);
        this.a = context;
        this.c = colorType;
        this.j = iQuickLoginDialogCallback;
        this.k = iPagerLoadCallback;
        this.m = iSendSmsCallback;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_situation", "pop_login");
            hashMap.put("skipreg", "1");
            SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback(this, System.currentTimeMillis(), str) { // from class: com.baidu.sapi2.views.logindialog.page.SmsPager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ String b;
                public final /* synthetic */ SmsPager c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r7), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = r7;
                    this.b = str;
                }

                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    }
                }

                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, getDynamicPwdResult) == null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("reget_sms_code", System.currentTimeMillis() - this.a, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                        if (this.c.m != null) {
                            this.c.m.onSendSmsFailure(this.b, getDynamicPwdResult);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, getDynamicPwdResult) == null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("reget_sms_code", System.currentTimeMillis() - this.a, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                        if (this.c.m != null) {
                            this.c.m.onSendSmsFailure(this.b, getDynamicPwdResult);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, getDynamicPwdResult) == null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("reget_sms_code", System.currentTimeMillis() - this.a, getDynamicPwdResult.getResultCode(), getDynamicPwdResult.getResultMsg());
                        if (getDynamicPwdResult.getResultCode() != 0) {
                            onFailure(getDynamicPwdResult);
                            return;
                        }
                        ToastUtil.show("发送成功");
                        this.c.p.start();
                    }
                }
            }, str, null, hashMap);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04c0, this);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091c5e);
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091bfb);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091c5c);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091c5a);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091c64);
            this.h.setOnClickListener(new b(this));
            this.i.setOnClickListener(new c(this));
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f01010f);
            this.o = loadAnimation;
            loadAnimation.setRepeatCount(5);
            d();
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_situation", "pop_login");
            SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new d(this, System.currentTimeMillis()), this.b, str, hashMap);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.start();
        }
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            this.b = str;
            this.d = i;
            this.e.setText(MessageFormat.format("验证码已发送至您的手机 {0}", str));
            this.f.removeAllViews();
            com.baidu.sapi2.views.logindialog.view.a aVar = new com.baidu.sapi2.views.logindialog.view.a(this.a);
            this.n = aVar;
            aVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.n.setBox(i);
            if (ColorType.DARK == this.c) {
                this.n.setBoxNormalBg(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081012));
                this.n.setBoxErrorBg(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081010));
                this.n.setTextColor(Color.parseColor("#CCFFFFFF"));
            } else {
                this.n.setBoxNormalBg(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081011));
                this.n.setBoxErrorBg(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08100f));
                this.n.setTextColor(Color.parseColor("#1F1F1F"));
            }
            this.n.b();
            this.n.setListener(this);
            this.f.addView(this.n);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.g.setVisibility(0);
            this.g.setText(str);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.setVisibility(8);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && ColorType.DARK == this.c) {
            this.e.setTextColor(Color.parseColor("#80FFFFFF"));
            this.h.setTextColor(Color.parseColor("#CCFFFFFF"));
            this.i.setTextColor(Color.parseColor("#80FFFFFF"));
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.view.a.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            b(str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p.cancel();
        }
    }
}
