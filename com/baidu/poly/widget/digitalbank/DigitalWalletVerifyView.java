package com.baidu.poly.widget.digitalbank;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.PolyNoticeDialog;
import com.baidu.poly.widget.VerificationCodeView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DigitalWalletVerifyView extends LinearLayout implements VerificationCodeView.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28290b;

    /* renamed from: c  reason: collision with root package name */
    public VerificationCodeView f28291c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28292d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28293e;

    /* renamed from: f  reason: collision with root package name */
    public long f28294f;

    /* renamed from: g  reason: collision with root package name */
    public PolyNoticeDialog f28295g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28296h;
    public ChannelListView i;
    public Bundle j;
    public String k;
    public PayChannelEntity l;
    public Handler m;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        public a(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.a.f28294f;
                if (currentTimeMillis < 60) {
                    this.a.s(60 - currentTimeMillis);
                    this.a.m.sendEmptyMessageDelayed(0, 1000L);
                    return;
                }
                this.a.m.removeCallbacksAndMessages(null);
                if (this.a.f28296h) {
                    this.a.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c.a.e0.c.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        public b(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // c.a.e0.c.a
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                if (127007 == i || 127008 == i) {
                    this.a.z(str);
                    this.a.f28296h = false;
                    return;
                }
                c.a.e0.k.g.b.f(this.a.getContext(), str);
                this.a.u();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.m.sendEmptyMessage(0);
                this.a.f28294f = System.currentTimeMillis() / 1000;
                TextView textView = this.a.f28290b;
                textView.setText("验证码已发送至你的手机 " + c.a.e0.k.f.b.f2891c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        public c(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends c.a.e0.c.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        public d(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // c.a.e0.c.a
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.f28292d.setVisibility(8);
                if (127010 == i || 127002 == i) {
                    this.a.f28291c.g();
                }
                if (127001 == i) {
                    this.a.A();
                    this.a.f28292d.setVisibility(0);
                    this.a.f28292d.setText(str);
                } else if (127007 == i || 127008 == i || 127013 == i || 224810 == i) {
                    this.a.z(str);
                    this.a.f28296h = false;
                } else {
                    c.a.e0.k.g.b.f(this.a.getContext(), str);
                    this.a.u();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.f28292d.setVisibility(8);
                this.a.r(jSONObject.optString("drmbCheckInfo"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        public e(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.f28291c.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends c.a.e0.c.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        public f(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // c.a.e0.c.a
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                if (this.a.f28295g != null) {
                    this.a.f28295g.dismiss();
                }
                this.a.i.a0(3, EventAlias.PayEventAlias.PAY_FAIL, "0");
                c.a.e0.k.g.b.f(this.a.getContext(), str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (this.a.f28295g != null) {
                    this.a.f28295g.dismiss();
                }
                int optInt = jSONObject.optInt("status", 1);
                if (optInt == 2) {
                    c.a.e0.k.g.b.d(this.a.getContext(), R.drawable.obfuscated_res_0x7f08065c, EventAlias.PayEventAlias.PAY_SUCCESS);
                    this.a.i.a0(0, EventAlias.PayEventAlias.PAY_SUCCESS, "0");
                } else if (optInt != -1) {
                    this.a.i.a0(3, EventAlias.PayEventAlias.PAY_FAIL, "0");
                    c.a.e0.k.g.b.d(this.a.getContext(), R.drawable.obfuscated_res_0x7f080653, EventAlias.PayEventAlias.PAY_FAIL);
                } else {
                    c.a.e0.k.g.b.f(this.a.getContext(), "支付取消");
                    this.a.i.a0(2, "支付取消", "0");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        public g(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f28295g.setRightBtnEnable(false);
                this.a.f28295g.startLoadingAnim();
                this.a.f28295g.setTitle("确认支付结果");
                this.a.f28295g.setTips("支付结果查询中 请稍候");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                onDismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyNoticeDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f28297b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DigitalWalletVerifyView f28298c;

        public h(DigitalWalletVerifyView digitalWalletVerifyView, PolyNoticeDialog polyNoticeDialog, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView, polyNoticeDialog, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28298c = digitalWalletVerifyView;
            this.a = polyNoticeDialog;
            this.f28297b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTitle(EventAlias.PayEventAlias.PAY_FAIL);
                this.a.setTips(this.f28297b);
                this.a.setSingleBtnText("我知道了");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28298c.i == null) {
                return;
            }
            this.f28298c.i.a0(3, "pay failed", "0");
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalWalletVerifyView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28296h = true;
        this.m = new a(this);
        x(context);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((Vibrator) getContext().getSystemService("vibrator")).vibrate(100L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f28291c, AnimationProperty.TRANSLATE_X, 0.0f, 20.0f, -20.0f, 0.0f);
            ofFloat.setDuration(600L);
            ofFloat.addListener(new e(this));
            ofFloat.start();
            this.f28291c.f();
        }
    }

    public void B(ChannelListView channelListView, Bundle bundle, String str, PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, channelListView, bundle, str, payChannelEntity) == null) {
            this.i = channelListView;
            setVisibility(0);
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01011b));
            this.f28291c.g();
            if ((System.currentTimeMillis() / 1000) - this.f28294f >= 60) {
                v(bundle, str, payChannelEntity);
            }
        }
    }

    @Override // com.baidu.poly.widget.VerificationCodeView.a
    public void a(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, str) == null) {
        }
    }

    @Override // com.baidu.poly.widget.VerificationCodeView.a
    public void b(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, str) == null) {
            c.a.e0.k.g.b.e(getContext(), R.drawable.obfuscated_res_0x7f08063a, "支付中");
            c.a.e0.k.f.b.h(str, new d(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f09187f) {
                w();
            }
            if (view.getId() == R.id.obfuscated_res_0x7f09188a) {
                t();
            }
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            y();
            c.a.e0.k.f.b.c(str, new f(this));
        }
    }

    public final void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            TextView textView = this.f28293e;
            textView.setText("重新发送 (" + j + "s)");
            this.f28293e.setEnabled(false);
            this.f28293e.setTextColor(Color.parseColor("#B8B8B8"));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.j == null || this.k == null || this.l == null) {
            return;
        }
        c.a.e0.k.g.b.e(getContext(), R.drawable.obfuscated_res_0x7f08063a, "请稍候");
        c.a.e0.k.f.b.e(this.j, this.k, this.l.getPayChannel(), System.currentTimeMillis() / 1000, new b(this));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f28293e.setText("重新获取验证码");
            this.f28293e.setEnabled(true);
            this.f28293e.setTextColor(Color.parseColor("#4E6EF2"));
        }
    }

    public void v(Bundle bundle, String str, PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, str, payChannelEntity) == null) {
            this.j = bundle;
            this.k = str;
            this.l = payChannelEntity;
            t();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f010119);
            loadAnimation.setAnimationListener(new c(this));
            startAnimation(loadAnimation);
        }
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04b1, this);
            this.a = inflate.findViewById(R.id.obfuscated_res_0x7f09187f);
            this.f28290b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09188f);
            this.f28291c = (VerificationCodeView) inflate.findViewById(R.id.obfuscated_res_0x7f09188e);
            this.f28292d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09188d);
            this.f28293e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09188a);
            s(60L);
            this.f28291c.setOnCodeFinishListener(this);
            this.a.setOnClickListener(this);
            this.f28293e.setOnClickListener(this);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.f28295g = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.f28295g.setOptionOnClickListener(new g(this));
            this.f28295g.show(((Activity) getContext()).getFragmentManager(), "DRMB_QUERY_ORDER_NOTICE_FRAGMENT_TAG");
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.setOptionOnClickListener(new h(this, polyNoticeDialog, str));
            polyNoticeDialog.show(((Activity) getContext()).getFragmentManager(), "DRMP_PAY_RESULT_NOTICE_FRAGMENT_TAG");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalWalletVerifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28296h = true;
        this.m = new a(this);
        x(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalWalletVerifyView(Context context, AttributeSet attributeSet, int i) {
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
        this.f28296h = true;
        this.m = new a(this);
        x(context);
    }
}
