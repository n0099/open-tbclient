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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class DigitalWalletVerifyView extends LinearLayout implements VerificationCodeView.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f37861e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37862f;

    /* renamed from: g  reason: collision with root package name */
    public VerificationCodeView f37863g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37864h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37865i;

    /* renamed from: j  reason: collision with root package name */
    public long f37866j;
    public PolyNoticeDialog k;
    public boolean l;
    public ChannelListView m;
    public Bundle n;
    public String o;
    public PayChannelEntity p;
    public Handler q;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.a.f37866j;
                if (currentTimeMillis < 60) {
                    this.a.q(60 - currentTimeMillis);
                    this.a.q.sendEmptyMessageDelayed(0, 1000L);
                    return;
                }
                this.a.q.removeCallbacksAndMessages(null);
                if (this.a.l) {
                    this.a.s();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends c.a.h0.l.a<JSONObject> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                if (127007 == i2 || 127008 == i2) {
                    this.a.v(str);
                    this.a.l = false;
                    return;
                }
                c.a.h0.t.e.b.f(this.a.getContext(), str);
                this.a.s();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.q.sendEmptyMessage(0);
                this.a.f37866j = System.currentTimeMillis() / 1000;
                TextView textView = this.a.f37862f;
                textView.setText("验证码已发送至你的手机 " + c.a.h0.t.d.b.f3705c);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes10.dex */
    public class d extends c.a.h0.l.a<JSONObject> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.a.f37864h.setVisibility(8);
                if (127010 == i2 || 127002 == i2) {
                    this.a.f37863g.showNormalNotice();
                }
                if (127001 == i2) {
                    this.a.w();
                    this.a.f37864h.setVisibility(0);
                    this.a.f37864h.setText(str);
                } else if (127007 == i2 || 127008 == i2 || 127013 == i2 || 224810 == i2) {
                    this.a.v(str);
                    this.a.l = false;
                } else {
                    c.a.h0.t.e.b.f(this.a.getContext(), str);
                    this.a.s();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.f37864h.setVisibility(8);
                this.a.p(jSONObject.optString("drmbCheckInfo"));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DigitalWalletVerifyView f37867e;

        public e(DigitalWalletVerifyView digitalWalletVerifyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37867e = digitalWalletVerifyView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f37867e.f37863g.showNormalNotice();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f extends c.a.h0.l.a<JSONObject> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalWalletVerifyView;
        }

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                if (this.a.k != null) {
                    this.a.k.dismiss();
                }
                this.a.m.payEnd(3, EventAlias.PayEventAlias.PAY_FAIL, "0");
                c.a.h0.t.e.b.f(this.a.getContext(), str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (this.a.k != null) {
                    this.a.k.dismiss();
                }
                int optInt = jSONObject.optInt("status", 1);
                if (optInt == 2) {
                    c.a.h0.t.e.b.d(this.a.getContext(), c.a.h0.f.ic_success_4_toast, EventAlias.PayEventAlias.PAY_SUCCESS);
                    this.a.m.payEnd(0, EventAlias.PayEventAlias.PAY_SUCCESS, "0");
                } else if (optInt != -1) {
                    this.a.m.payEnd(3, EventAlias.PayEventAlias.PAY_FAIL, "0");
                    c.a.h0.t.e.b.d(this.a.getContext(), c.a.h0.f.ic_poly_sdk_drmb_pay_fail, EventAlias.PayEventAlias.PAY_FAIL);
                } else {
                    c.a.h0.t.e.b.f(this.a.getContext(), "支付取消");
                    this.a.m.payEnd(2, "支付取消", "0");
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.k.setRightBtnEnable(false);
                this.a.k.startLoadingAnim();
                this.a.k.setTitle("确认支付结果");
                this.a.k.setTips("支付结果查询中 请稍候");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                onDismiss();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyNoticeDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f37868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DigitalWalletVerifyView f37869c;

        public h(DigitalWalletVerifyView digitalWalletVerifyView, PolyNoticeDialog polyNoticeDialog, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalWalletVerifyView, polyNoticeDialog, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37869c = digitalWalletVerifyView;
            this.a = polyNoticeDialog;
            this.f37868b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTitle(EventAlias.PayEventAlias.PAY_FAIL);
                this.a.setTips(this.f37868b);
                this.a.setSingleBtnText("我知道了");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f37869c.m == null) {
                return;
            }
            this.f37869c.m.payEnd(3, "pay failed", "0");
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
        this.q = new a(this);
        t(context);
    }

    public void getReqCode(Bundle bundle, String str, PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bundle, str, payChannelEntity) == null) {
            this.n = bundle;
            this.o = str;
            this.p = payChannelEntity;
            r();
        }
    }

    public void hideVerifyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), c.a.h0.c.slide_left_2_right);
            loadAnimation.setAnimationListener(new c(this));
            startAnimation(loadAnimation);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == c.a.h0.g.poly_sdk_bank_list_back) {
                hideVerifyView();
            }
            if (view.getId() == c.a.h0.g.poly_sdk_retry_get_verify_code) {
                r();
            }
        }
    }

    @Override // com.baidu.poly.widget.VerificationCodeView.a
    public void onComplete(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, str) == null) {
            c.a.h0.t.e.b.e(getContext(), c.a.h0.f.ic_loading_4_toast, "支付中");
            c.a.h0.t.d.b.h(str, new d(this));
        }
    }

    @Override // com.baidu.poly.widget.VerificationCodeView.a
    public void onTextChange(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view, str) == null) {
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            u();
            c.a.h0.t.d.b.c(str, new f(this));
        }
    }

    public final void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            TextView textView = this.f37865i;
            textView.setText("重新发送 (" + j2 + "s)");
            this.f37865i.setEnabled(false);
            this.f37865i.setTextColor(Color.parseColor("#B8B8B8"));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.n == null || this.o == null || this.p == null) {
            return;
        }
        c.a.h0.t.e.b.e(getContext(), c.a.h0.f.ic_loading_4_toast, "请稍候");
        c.a.h0.t.d.b.e(this.n, this.o, this.p.getPayChannel(), System.currentTimeMillis() / 1000, new b(this));
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f37865i.setText("重新获取验证码");
            this.f37865i.setEnabled(true);
            this.f37865i.setTextColor(Color.parseColor("#4E6EF2"));
        }
    }

    public void showVerifyView(ChannelListView channelListView, Bundle bundle, String str, PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, channelListView, bundle, str, payChannelEntity) == null) {
            this.m = channelListView;
            setVisibility(0);
            startAnimation(AnimationUtils.loadAnimation(getContext(), c.a.h0.c.slide_right_2_left));
            this.f37863g.showNormalNotice();
            if ((System.currentTimeMillis() / 1000) - this.f37866j >= 60) {
                getReqCode(bundle, str, payChannelEntity);
            }
        }
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(c.a.h0.h.layout_poly_digital_wallet_view, this);
            this.f37861e = inflate.findViewById(c.a.h0.g.poly_sdk_bank_list_back);
            this.f37862f = (TextView) inflate.findViewById(c.a.h0.g.poly_sdk_verify_mobile_tip);
            this.f37863g = (VerificationCodeView) inflate.findViewById(c.a.h0.g.poly_sdk_verify_code_view);
            this.f37864h = (TextView) inflate.findViewById(c.a.h0.g.poly_sdk_tv_verify_code_tip);
            this.f37865i = (TextView) inflate.findViewById(c.a.h0.g.poly_sdk_retry_get_verify_code);
            q(60L);
            this.f37863g.setOnCodeFinishListener(this);
            this.f37861e.setOnClickListener(this);
            this.f37865i.setOnClickListener(this);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.k = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.k.setOptionOnClickListener(new g(this));
            this.k.show(((Activity) getContext()).getFragmentManager(), "DRMB_QUERY_ORDER_NOTICE_FRAGMENT_TAG");
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.setOptionOnClickListener(new h(this, polyNoticeDialog, str));
            polyNoticeDialog.show(((Activity) getContext()).getFragmentManager(), "DRMP_PAY_RESULT_NOTICE_FRAGMENT_TAG");
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ((Vibrator) getContext().getSystemService("vibrator")).vibrate(100L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f37863g, AnimationProperty.TRANSLATE_X, 0.0f, 20.0f, -20.0f, 0.0f);
            ofFloat.setDuration(600L);
            ofFloat.addListener(new e(this));
            ofFloat.start();
            this.f37863g.showErrorNotice();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = true;
        this.q = new a(this);
        t(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalWalletVerifyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = true;
        this.q = new a(this);
        t(context);
    }
}
