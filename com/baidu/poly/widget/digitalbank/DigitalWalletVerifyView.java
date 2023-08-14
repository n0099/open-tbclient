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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.PolyNoticeDialog;
import com.baidu.poly.widget.VerificationCodeView;
import com.baidu.tieba.R;
import com.baidu.tieba.fg1;
import com.baidu.tieba.ti1;
import com.baidu.tieba.vi1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DigitalWalletVerifyView extends LinearLayout implements VerificationCodeView.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public VerificationCodeView c;
    public TextView d;
    public TextView e;
    public long f;
    public PolyNoticeDialog g;
    public boolean h;
    public ChannelListView i;
    public Bundle j;
    public String k;
    public PayChannelEntity l;
    public Handler m;

    @Override // com.baidu.poly.widget.VerificationCodeView.a
    public void a(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
                long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.a.f;
                if (currentTimeMillis >= 60) {
                    this.a.m.removeCallbacksAndMessages(null);
                    if (!this.a.h) {
                        return;
                    }
                    this.a.u();
                    return;
                }
                this.a.s(60 - currentTimeMillis);
                this.a.m.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends fg1<JSONObject> {
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

        @Override // com.baidu.tieba.fg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                if (127007 != i && 127008 != i) {
                    vi1.f(this.a.getContext(), str);
                    this.a.u();
                    return;
                }
                this.a.B(str);
                this.a.h = false;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fg1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.m.sendEmptyMessage(0);
                this.a.f = System.currentTimeMillis() / 1000;
                TextView textView = this.a.b;
                textView.setText("验证码已发送至你的手机 " + ti1.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

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
    }

    /* loaded from: classes3.dex */
    public class d extends fg1<JSONObject> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fg1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.d.setVisibility(8);
                this.a.r(jSONObject.optString("drmbCheckInfo"));
            }
        }

        @Override // com.baidu.tieba.fg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.d.setVisibility(8);
                if (127010 == i || 127002 == i) {
                    this.a.c.g();
                }
                if (127001 != i) {
                    if (127007 != i && 127008 != i && 127013 != i && 224810 != i) {
                        vi1.f(this.a.getContext(), str);
                        this.a.u();
                        return;
                    }
                    this.a.B(str);
                    this.a.h = false;
                    return;
                }
                this.a.C();
                this.a.d.setVisibility(0);
                this.a.d.setText(str);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.c.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends fg1<JSONObject> {
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

        @Override // com.baidu.tieba.fg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                if (this.a.g != null) {
                    this.a.g.dismiss();
                }
                this.a.i.d0(3, EventAlias.PayEventAlias.PAY_FAIL, "0");
                vi1.f(this.a.getContext(), str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fg1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (this.a.g != null) {
                    this.a.g.dismiss();
                }
                int optInt = jSONObject.optInt("status", 1);
                if (optInt == 2) {
                    vi1.d(this.a.getContext(), R.drawable.obfuscated_res_0x7f0807e0, EventAlias.PayEventAlias.PAY_SUCCESS);
                    this.a.i.d0(0, EventAlias.PayEventAlias.PAY_SUCCESS, "0");
                } else if (optInt == -1) {
                    vi1.f(this.a.getContext(), "支付取消");
                    this.a.i.d0(2, "支付取消", "0");
                } else {
                    this.a.i.d0(3, EventAlias.PayEventAlias.PAY_FAIL, "0");
                    vi1.d(this.a.getContext(), R.drawable.obfuscated_res_0x7f0807d7, EventAlias.PayEventAlias.PAY_FAIL);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalWalletVerifyView a;

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                onDismiss();
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.d(false);
                this.a.g.h();
                this.a.g.g("确认支付结果");
                this.a.g.f("支付结果查询中 请稍候");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyNoticeDialog a;
        public final /* synthetic */ String b;
        public final /* synthetic */ DigitalWalletVerifyView c;

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
            this.c = digitalWalletVerifyView;
            this.a = polyNoticeDialog;
            this.b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g(EventAlias.PayEventAlias.PAY_FAIL);
                this.a.f(this.b);
                this.a.e("我知道了");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.i != null) {
                this.c.i.d0(3, "pay failed", "0");
            }
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
        this.h = true;
        this.m = new a(this);
        z(context);
    }

    public final void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            TextView textView = this.e;
            textView.setText("重新发送 (" + j + "s)");
            this.e.setEnabled(false);
            this.e.setTextColor(Color.parseColor("#B8B8B8"));
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
        this.h = true;
        this.m = new a(this);
        z(context);
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
        this.h = true;
        this.m = new a(this);
        z(context);
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.c(new h(this, polyNoticeDialog, str));
            polyNoticeDialog.show(((Activity) getContext()).getFragmentManager(), "DRMP_PAY_RESULT_NOTICE_FRAGMENT_TAG");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091cc0) {
                y();
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091ccb) {
                t();
            }
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            A();
            ti1.c(str, new f(this));
        }
    }

    @Override // com.baidu.poly.widget.VerificationCodeView.a
    public void b(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, str) == null) {
            vi1.e(getContext(), R.drawable.obfuscated_res_0x7f0807bb, "支付中");
            ti1.h(str, new d(this));
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.g = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.g.c(new g(this));
            this.g.show(((Activity) getContext()).getFragmentManager(), "DRMB_QUERY_ORDER_NOTICE_FRAGMENT_TAG");
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.j != null && this.k != null && this.l != null) {
            vi1.e(getContext(), R.drawable.obfuscated_res_0x7f0807bb, "请稍候");
            ti1.e(this.j, this.k, this.l.getPayChannel(), System.currentTimeMillis() / 1000, new b(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((Vibrator) getContext().getSystemService("vibrator")).vibrate(100L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_X, 0.0f, 20.0f, -20.0f, 0.0f);
            ofFloat.setDuration(600L);
            ofFloat.addListener(new e(this));
            ofFloat.start();
            this.c.f();
        }
    }

    public void D(ChannelListView channelListView, Bundle bundle, String str, PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, channelListView, bundle, str, payChannelEntity) == null) {
            this.i = channelListView;
            setVisibility(0);
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f010164));
            this.c.g();
            if ((System.currentTimeMillis() / 1000) - this.f >= 60) {
                x(bundle, str, payChannelEntity);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e.setText("重新获取验证码");
            this.e.setEnabled(true);
            this.e.setTextColor(Color.parseColor("#4E6EF2"));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01015e);
            loadAnimation.setAnimationListener(new c(this));
            startAnimation(loadAnimation);
        }
    }

    public void x(Bundle bundle, String str, PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, str, payChannelEntity) == null) {
            this.j = bundle;
            this.k = str;
            this.l = payChannelEntity;
            t();
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d053f, this);
            this.a = inflate.findViewById(R.id.obfuscated_res_0x7f091cc0);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091cd0);
            this.c = (VerificationCodeView) inflate.findViewById(R.id.obfuscated_res_0x7f091ccf);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091cce);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ccb);
            s(60L);
            this.c.setOnCodeFinishListener(this);
            this.a.setOnClickListener(this);
            this.e.setOnClickListener(this);
        }
    }
}
