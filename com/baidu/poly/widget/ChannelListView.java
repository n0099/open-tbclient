package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.b;
import c.a.e0.j.e.a;
import c.a.e0.k.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.widget.ChannelItemView;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.poly.widget.coupon.CouponEntranceView;
import com.baidu.poly.widget.coupon.CouponListView;
import com.baidu.poly.widget.digitalbank.DigitalBankPayView;
import com.baidu.poly.widget.digitalbank.DigitalWalletVerifyView;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.poly.widget.entitiy.PayChannelExtInfoEntity;
import com.baidu.poly.widget.hostmarket.HostMarketView;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChannelListView extends FrameLayout implements View.OnClickListener, DigitalBankPayView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public View C;
    public CouponEntranceView D;
    public View E;
    public View F;
    public CouponListView G;
    public PeriodView H;
    public ToastLoadingView I;
    public Long J;
    public Long K;
    public c.a.e0.j.d L;
    public IChannelAuth M;
    public PopupWindow N;
    public String O;
    public c.a.e0.k.e.a P;
    public boolean Q;
    public boolean R;
    public Runnable S;
    public boolean T;
    public boolean U;
    public String V;
    public String W;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f28224b;

    /* renamed from: c  reason: collision with root package name */
    public PolyFrameLayout f28225c;

    /* renamed from: d  reason: collision with root package name */
    public TipView f28226d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f28227e;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f28228f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressButton f28229g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public b.c f28230h;
    public boolean h0;
    public View i;
    public String i0;
    public View j;
    public DigitalBankPayView k;
    public DigitalWalletVerifyView l;
    public TextView m;
    public PayChannelEntity n;
    public PayChannelEntity[] o;
    public PayChannelEntity p;
    public boolean q;
    public boolean r;
    public int s;
    public m t;
    public Animation u;
    public Animation v;
    public DuVipGuideView w;
    public View x;
    public HostMarketView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements CouponListView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public a(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h0();
            }
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void b(a.C0134a c0134a, c.a.e0.j.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0134a, aVar) == null) || c0134a == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0134a.i);
            if (this.a.n != null && this.a.n.getIsSelected() == 1) {
                arrayList.add(this.a.n.getHostMarketingDetail());
            }
            this.a.K(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void c(boolean z, a.C0134a c0134a) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, c0134a) == null) || this.a.G == null) {
                return;
            }
            this.a.G.s(this.a.f28224b);
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void onDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.G = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.e0.j.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.e0.j.e.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f28231b;

        public b(ChannelListView channelListView, c.a.e0.j.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28231b = channelListView;
            this.a = aVar;
        }

        @Override // c.a.e0.j.e.a
        public void a(a.C0129a c0129a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0129a) == null) {
                if (c0129a.a == 0) {
                    this.f28231b.J = Long.valueOf(c0129a.f2847d);
                    this.f28231b.e0();
                    if (this.f28231b.n != null && this.f28231b.n.getIsSelected() == 1) {
                        this.f28231b.n.setHostMarketingDetail(c0129a.f2849f);
                    }
                }
                this.a.a(c0129a);
                this.f28231b.D.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.e0.c.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public c(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // c.a.e0.c.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) && this.a.o == null) {
                this.a.m0(str);
                ChannelListView channelListView = this.a;
                channelListView.Y(3, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0786) + str, "0");
                this.a.P();
                c.a.e0.g.c cVar = new c.a.e0.g.c("1");
                cVar.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                c.a.e0.g.f.e(cVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                c.a.e0.i.h.g("requestChannelList onSuccess result=" + jSONObject.toString());
                c.a.e0.g.b.a("1.04", System.currentTimeMillis());
                Long valueOf = Long.valueOf(jSONObject.optLong("payMoney"));
                this.a.i0 = jSONObject.optString("isFoldChannel");
                String optString = jSONObject.optString("showTotalAmount", "1");
                this.a.g0 = optString.equals("1");
                this.a.J = valueOf;
                JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    PayChannelEntity[] payChannelEntityArr = new PayChannelEntity[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        PayChannelEntity payChannelEntity = new PayChannelEntity(optJSONArray.optJSONObject(i));
                        if (payChannelEntity.getIsSelected() == 1) {
                            this.a.V = payChannelEntity.getPayChannel();
                        }
                        payChannelEntityArr[i] = payChannelEntity;
                    }
                    this.a.o = payChannelEntityArr;
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("coupons");
                    this.a.P = new c.a.e0.k.e.a(optJSONArray2);
                    this.a.D.update(this.a.P);
                    if (this.a.G != null) {
                        this.a.G.update(this.a.P.f2871b);
                    }
                    c.a.e0.i.h.g("渲染coupon结束");
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("marketChannels");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        this.a.n = new PayChannelEntity(optJSONArray3.optJSONObject(0));
                    }
                    c.a.e0.i.h.g("渲染hostMark结束");
                    JSONObject optJSONObject = jSONObject.optJSONObject("guideInfo");
                    if (optJSONObject != null) {
                        this.a.w.setVisibility(0);
                        this.a.x.setVisibility(0);
                        this.a.w.b(optJSONObject);
                    } else {
                        this.a.x.setVisibility(8);
                        this.a.w.setVisibility(8);
                    }
                    c.a.e0.g.b.h("7");
                    if (this.a.o.length != 1 || this.a.D.getVisibility() != 8 || this.a.n != null || this.a.o[0] == null) {
                        this.a.e0();
                        this.a.U();
                        c.a.e0.i.h.g("渲染宿主营销结束");
                        ChannelListView channelListView = this.a;
                        PayChannelEntity[] payChannelEntityArr2 = channelListView.o;
                        channelListView.T(payChannelEntityArr2);
                        channelListView.o = payChannelEntityArr2;
                        this.a.g0();
                        c.a.e0.i.h.g("渲染支付渠道结束");
                        this.a.f28226d.a();
                        c.a.e0.i.h.g("隐藏loading状态");
                        this.a.f0();
                        this.a.U = true;
                        this.a.r0();
                        return;
                    }
                    this.a.U = true;
                    this.a.r0();
                    TipView tipView = this.a.f28226d;
                    String loadingIcon = this.a.o[0].getLoadingIcon();
                    tipView.d(loadingIcon, "即将进入" + this.a.o[0].getDisplayName() + "…");
                    ChannelListView channelListView2 = this.a;
                    channelListView2.M(channelListView2.o[0]);
                    c.a.e0.i.h.g("单渠道支付");
                    return;
                }
                c.a.e0.g.b.b("7", null, null);
                b(new ServerDataException("channelList is null"), "request channelList payChannels is null");
                c.a.e0.i.h.g("requestChannelList channelList is null");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public d(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public e(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.T = true;
                this.a.r0();
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
    public class f implements HostMarketView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public f(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.c
        public void a(boolean z, PayChannelEntity payChannelEntity, c.a.e0.j.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), payChannelEntity, aVar}) == null) {
                this.a.f28225c.a(true);
                ChannelListView channelListView = this.a;
                channelListView.postDelayed(channelListView.S, 500L);
                if (payChannelEntity == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(payChannelEntity.getHostMarketingDetail());
                }
                if (this.a.D.getSelectedItem() != null) {
                    arrayList.add(this.a.D.getSelectedItem().i);
                }
                this.a.K(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.c
        public void b(a.C0129a c0129a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0129a) == null) {
                this.a.f28225c.a(false);
                ChannelListView channelListView = this.a;
                channelListView.removeCallbacks(channelListView.S);
                this.a.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public g(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup)) {
                ChannelListView channelListView = this.a;
                channelListView.startAnimation(channelListView.v);
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public h(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public i(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.N != null && this.a.N.r()) {
                this.a.N.n();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public j(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ChannelItemView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayChannelEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f28232b;

        public k(ChannelListView channelListView, PayChannelEntity payChannelEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView, payChannelEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28232b = channelListView;
            this.a = payChannelEntity;
        }

        @Override // com.baidu.poly.widget.ChannelItemView.c
        public void a(ChannelItemView channelItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, channelItemView) == null) {
                if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(this.a.getPayChannel())) {
                    c.a.e0.g.a.f2781b = "1";
                }
                c.a.e0.g.a.a++;
                PayChannelEntity[] payChannelEntityArr = this.f28232b.o;
                int length = payChannelEntityArr.length;
                for (int i = 0; i < length; i++) {
                    PayChannelEntity payChannelEntity = payChannelEntityArr[i];
                    payChannelEntity.setIsSelected(payChannelEntity == this.a ? 1 : 0);
                }
                this.f28232b.g0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements ChannelItemView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public l(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.ChannelItemView.b
        public void a(InstallmentEntity installmentEntity) {
            ArrayList<InstallmentEntity> installmentEntities;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, installmentEntity) == null) {
                for (PayChannelEntity payChannelEntity : this.a.o) {
                    PayChannelExtInfoEntity payChannelExtInfoEntity = payChannelEntity.getPayChannelExtInfoEntity();
                    if (payChannelExtInfoEntity != null && (installmentEntities = payChannelExtInfoEntity.getInstallmentEntities()) != null && installmentEntities.size() != 0) {
                        Iterator<InstallmentEntity> it = installmentEntities.iterator();
                        while (it.hasNext()) {
                            InstallmentEntity next = it.next();
                            if (next != null) {
                                if (next.equals(installmentEntity)) {
                                    next.setIsSelected("1");
                                } else {
                                    next.setIsSelected("0");
                                }
                            }
                        }
                    }
                }
                this.a.g0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface m {
        void onClose();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListView(PolyActivity polyActivity) {
        super(polyActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {polyActivity};
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
        this.Q = true;
        this.R = false;
        this.S = new d(this);
        this.T = false;
        this.U = false;
        this.g0 = true;
        W();
    }

    public final void K(List<String> list, c.a.e0.j.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, aVar) == null) || aVar == null) {
            return;
        }
        String string = this.f28228f.getString("bduss");
        String string2 = this.f28228f.getString("appKey");
        c.a.e0.j.e.b.b(string, string2, this.K + "", list, new b(this, aVar));
    }

    public void L(c.a.e0.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        c.a.e0.g.b.f(System.currentTimeMillis());
        c.a.e0.j.d dVar = this.L;
        if (dVar != null) {
            dVar.m(aVar.a, aVar.f2808b, aVar.f2809c, this, this.i0);
        }
    }

    public final void M(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payChannelEntity) == null) || payChannelEntity == null) {
            return;
        }
        c.a.e0.g.b.f(System.currentTimeMillis());
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.n != null && this.n.getIsSelected() == 1 && !TextUtils.isEmpty(this.n.getHostMarketingDetail())) {
                jSONArray.put(new JSONObject(this.n.getHostMarketingDetail()));
            }
            if (this.D.getSelectedItem() != null && !TextUtils.isEmpty(this.D.getSelectedItem().i)) {
                jSONArray.put(new JSONObject(this.D.getSelectedItem().i));
            }
        } catch (Exception unused) {
        }
        if (jSONArray.length() > 0) {
            this.f28228f.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (!TextUtils.isEmpty(this.i0)) {
            this.f28228f.putString("isFoldChannel", this.i0);
        }
        if (this.L != null) {
            this.O = payChannelEntity.getPayChannel();
            this.L.l(this.f28228f, payChannelEntity, this, this.i0);
        }
    }

    public final void N() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || PolyActivity.invokerActivity == null) {
            return;
        }
        Bundle bundle = this.f28228f;
        if (bundle != null) {
            str = bundle.getString("bduss");
            str2 = this.f28228f.getString("appKey");
        } else {
            str = null;
            str2 = null;
        }
        PayChannelEntity payChannelEntity = this.p;
        String payChannel = payChannelEntity != null ? payChannelEntity.getPayChannel() : null;
        if (this.M == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(payChannel)) {
            return;
        }
        try {
            Intent intent = new Intent(PolyActivity.invokerActivity, GuideAgreeNoPwdPayActivity.class);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_BDUSS, str);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_APP_KEY, str2);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_PAY_CHANNEL, payChannel);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_AUTH_CHANNEL, this.M);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_INVOKER_TASK_ID, c.a.e0.e.a.a().b());
            PolyActivity.invokerActivity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = this.N;
            boolean z = ((popupWindow != null && popupWindow.r()) || this.r || this.q) ? false : true;
            if ((!TextUtils.isEmpty(this.O) && (TextUtils.equals(this.O, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.O, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.R) {
                c.a.e0.i.h.g("ChannelListView->confirmViewClose() ali pay channel");
                z &= this.Q;
            }
            c.a.e0.i.h.g("ChannelListView->confirmViewClose() canFinishActivity = " + z);
            if (!z || this.t == null) {
                return;
            }
            c.a.e0.i.h.g("ChannelListView->confirmViewClose() finish activity");
            this.t.onClose();
            this.t = null;
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.q) {
            this.q = false;
            this.a.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new g(this), 240L);
            postDelayed(new h(this), 480L);
        }
    }

    public void Q(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, str) == null) {
            p0(bundle, str);
        }
    }

    public void R(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            c.a.e0.i.h.g("ChannelListView->errorEnd()");
            V();
            if (!TextUtils.isEmpty(str2)) {
                m0(str2);
            } else {
                m0(getResources().getString(R.string.obfuscated_res_0x7f0f0e8b));
            }
            Y(3, str, "0");
            setIsPreparePaying(false);
        }
    }

    public final String S(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public final PayChannelEntity[] T(PayChannelEntity[] payChannelEntityArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, payChannelEntityArr)) == null) {
            int i2 = 0;
            for (PayChannelEntity payChannelEntity : payChannelEntityArr) {
                if (payChannelEntity.getIsSelected() == 1 && (i2 = i2 + 1) > 1) {
                    payChannelEntity.setIsSelected(0);
                }
                if (payChannelEntity.getEnable() == 1) {
                    this.s++;
                }
            }
            if (i2 == 0) {
                for (PayChannelEntity payChannelEntity2 : payChannelEntityArr) {
                    if (payChannelEntity2.getEnable() == 1) {
                        payChannelEntity2.setIsSelected(1);
                        return payChannelEntityArr;
                    }
                }
            }
            return payChannelEntityArr;
        }
        return (PayChannelEntity[]) invokeL.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.y.update(this.n);
            this.y.setListener(new f(this));
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.e0.k.g.a.b(this.I);
            this.I = null;
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.u = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f010118);
            this.v = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01011a);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0894, this);
            this.a = findViewById(R.id.obfuscated_res_0x7f090362);
            this.f28224b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0905f1);
            this.f28225c = (PolyFrameLayout) findViewById(R.id.obfuscated_res_0x7f0918a2);
            this.E = findViewById(R.id.obfuscated_res_0x7f09166c);
            this.F = findViewById(R.id.obfuscated_res_0x7f0905e8);
            this.f28226d = (TipView) findViewById(R.id.obfuscated_res_0x7f092025);
            this.f28227e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0905e9);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f09166d);
            DigitalBankPayView digitalBankPayView = (DigitalBankPayView) findViewById(R.id.obfuscated_res_0x7f091885);
            this.k = digitalBankPayView;
            digitalBankPayView.setOptionListener(this);
            this.l = (DigitalWalletVerifyView) findViewById(R.id.obfuscated_res_0x7f091886);
            this.f28229g = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f09166a);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09066b);
            this.i = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091883);
            this.j = findViewById2;
            findViewById2.setOnClickListener(this);
            this.f28229g.setOnClickListener(this);
            this.w = (DuVipGuideView) findViewById(R.id.obfuscated_res_0x7f0923f3);
            this.x = findViewById(R.id.obfuscated_res_0x7f0923bc);
            this.y = (HostMarketView) findViewById(R.id.obfuscated_res_0x7f090daf);
            CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(R.id.obfuscated_res_0x7f0906fc);
            this.D = couponEntranceView;
            couponEntranceView.setOnClickListener(this);
            this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f09142e);
            this.A = (TextView) findViewById(R.id.obfuscated_res_0x7f09074c);
            this.B = findViewById(R.id.obfuscated_res_0x7f0923df);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f0921e3);
            this.C = findViewById3;
            findViewById3.setOnClickListener(this);
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DigitalWalletVerifyView digitalWalletVerifyView = this.l;
            if (digitalWalletVerifyView != null && digitalWalletVerifyView.getVisibility() == 0) {
                this.l.w();
                return true;
            }
            DigitalBankPayView digitalBankPayView = this.k;
            if (digitalBankPayView != null && digitalBankPayView.getVisibility() == 0) {
                this.m.setText("支付");
                this.k.a();
                this.j.setVisibility(8);
                this.i.setVisibility(0);
                return true;
            }
            CouponListView couponListView = this.G;
            if (couponListView != null) {
                couponListView.r();
                return true;
            }
            PeriodView periodView = this.H;
            if (periodView != null) {
                periodView.f();
                return true;
            } else if (this.r) {
                return true;
            } else {
                if (this.q) {
                    Y(2, c.a.e0.i.e.a(2, null, "key_back_cancel"), "0");
                    P();
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void Y(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i2, str, str2) == null) {
            c.a.e0.i.h.g("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
            this.Q = true;
            b.c cVar = this.f28230h;
            if (cVar != null) {
                cVar.a(i2, str);
                this.f28230h = null;
            }
            c.a.e0.g.f.j(i2, str, str2);
            if (((PolyActivity) getContext()).isFinishing()) {
                c.a.e0.g.f.f();
            }
            O();
        }
    }

    public final void Z() {
        c.a.e0.k.e.a aVar;
        List<a.C0134a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (aVar = this.P) == null || (list = aVar.f2871b) == null || list.size() <= 0) {
            return;
        }
        CouponListView couponListView = new CouponListView(getContext());
        this.G = couponListView;
        couponListView.n(this.f28224b.getMeasuredHeight());
        this.G.setListener(new a(this));
        this.G.update(this.P.f2871b);
        this.G.p(this.f28224b);
    }

    @Override // com.baidu.poly.widget.digitalbank.DigitalBankPayView.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && R.id.obfuscated_res_0x7f091884 == i2) {
            M(this.k.getSelectedChildrenEntity());
        }
    }

    public void a0(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048593, this, i2, str, str2) == null) {
            c.a.e0.i.h.g("ChannelListView->payEnd()");
            Y(i2, str, str2);
            setIsPreparePaying(false);
        }
    }

    public void b0(int i2, String str, String str2, String str3, Map<String, String> map, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), str, str2, str3, map, str4}) == null) {
            a0(i2, str, str2);
            if (i2 != 0 || this.f28228f == null) {
                return;
            }
            PayChannelEntity payChannelEntity = this.p;
            if (payChannelEntity != null ? payChannelEntity.isNeedAgreementGuide() : false) {
                N();
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.r = false;
            this.f28229g.c();
        }
    }

    public final void d0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.h0) {
                this.C.setVisibility(8);
                return;
            }
            PayChannelEntity[] payChannelEntityArr = this.o;
            int length = payChannelEntityArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                PayChannelEntity payChannelEntity = payChannelEntityArr[i2];
                if (payChannelEntity != null && payChannelEntity.isFold()) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (z) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) ? this.r || super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final void e0() {
        Long l2;
        Long l3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (l2 = this.K) == null || (l3 = this.J) == null) {
            return;
        }
        if (l2.equals(l3)) {
            this.z.setText(S(this.J.longValue()));
            this.A.setVisibility(8);
        } else {
            if (this.g0) {
                this.A.setVisibility(0);
            }
            this.z.setText(S(this.J.longValue()));
            TextView textView = this.A;
            textView.setText(" ¥" + S(this.K.longValue()));
        }
        if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.s <= 0) {
                this.f28229g.setVisibility(4);
                return;
            }
            this.f28229g.setVisibility(0);
            this.f28229g.setEnable(true);
        }
    }

    public final void g0() {
        PayChannelEntity[] payChannelEntityArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.F.setMinimumHeight(0);
            if (this.o != null) {
                this.f28227e.removeAllViews();
                d0();
                for (PayChannelEntity payChannelEntity : this.o) {
                    if (this.h0 || !payChannelEntity.isFold()) {
                        Long l2 = this.J;
                        String S = l2 != null ? S(l2.longValue()) : "";
                        ChannelItemView channelItemView = new ChannelItemView(getContext());
                        channelItemView.setChannelInfo(payChannelEntity, new k(this, payChannelEntity), new l(this), S);
                        if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(payChannelEntity.getPayChannel())) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("hbit", "1");
                            } catch (JSONException unused) {
                            }
                            c.a.e0.g.c cVar = new c.a.e0.g.c("9");
                            cVar.c(jSONObject);
                            c.a.e0.g.f.e(cVar);
                        }
                        this.f28227e.addView(channelItemView);
                    }
                }
            }
        }
    }

    public PayChannelEntity getSelectedPayChannelEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.p : (PayChannelEntity) invokeV.objValue;
    }

    public c.a.e0.j.d getWalletList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.L : (c.a.e0.j.d) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.e0.i.h.g("requestChannelList start");
            c.a.e0.g.b.a("1.01", System.currentTimeMillis());
            c.a.e0.c.h.b.j().e(this.f28228f, new c(this));
        }
    }

    public void i0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            if (bundle != null) {
                try {
                    String string = bundle.getString("totalAmount");
                    if (TextUtils.isEmpty(string)) {
                        this.K = -1L;
                    } else {
                        this.K = Long.valueOf(Long.parseLong(string));
                    }
                } catch (Exception unused) {
                    c.a.e0.i.h.g("totalAmount is not long");
                }
            }
            this.f28228f = bundle;
            h0();
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f28229g.c();
            this.r = false;
            this.Q = true;
        }
    }

    public ChannelListView k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!this.q) {
                this.q = true;
                if (getContext() instanceof Activity) {
                    this.f28226d.c("收银台加载中...");
                    c.a.e0.i.h.g("ChannelListView->attach()");
                    l0();
                } else {
                    throw new IllegalStateException("can not attach to context " + getContext());
                }
            }
            return this;
        }
        return (ChannelListView) invokeV.objValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.a.setVisibility(0);
            this.f28224b.setVisibility(0);
            this.f28225c.setVisibility(0);
            this.a.setAlpha(0.0f);
            this.a.animate().alpha(0.65f).setDuration(240L).start();
            this.f28224b.startAnimation(this.u);
            this.u.setAnimationListener(new e(this));
            f0();
        }
    }

    public final void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f0e8b);
            }
            if (this.N == null) {
                View inflate = View.inflate(this.f28227e.getContext(), R.layout.obfuscated_res_0x7f0d0218, null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918a1)).setText(EventAlias.PayEventAlias.PAY_FAIL);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918a0)).setText(str.trim());
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
                this.N = popupWindow;
                popupWindow.w(false);
                this.N.B(false);
                this.N.v(new ColorDrawable(0));
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09189b)).setOnClickListener(new i(this));
                this.N.A(new j(this));
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (polyActivity.isFinishing()) {
                return;
            }
            this.N.D(polyActivity.getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.I = c.a.e0.k.g.a.c(this.f28225c, layoutParams, "加载中", -1L);
        }
    }

    public void o0(String str, PayChannelEntity payChannelEntity) {
        DigitalWalletVerifyView digitalWalletVerifyView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048610, this, str, payChannelEntity) == null) || (digitalWalletVerifyView = this.l) == null) {
            return;
        }
        digitalWalletVerifyView.B(this, this.f28228f, str, payChannelEntity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f09066b) {
                Y(2, "主动取消支付", "0");
                P();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("default", this.V);
                    jSONObject.put("selected", this.W);
                    this.W = "";
                    jSONObject.put("selects", c.a.e0.g.a.a);
                    c.a.e0.g.a.a = 0;
                    jSONObject.put("hbit", c.a.e0.g.a.f2781b);
                    c.a.e0.g.a.f2781b = "0";
                } catch (JSONException unused) {
                }
                c.a.e0.g.c cVar = new c.a.e0.g.c("6");
                cVar.c(jSONObject);
                c.a.e0.g.f.e(cVar);
            } else if (view.getId() == R.id.obfuscated_res_0x7f09166a) {
                if (this.s == 0) {
                    return;
                }
                PayChannelEntity[] payChannelEntityArr = this.o;
                int length = payChannelEntityArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    PayChannelEntity payChannelEntity = payChannelEntityArr[i2];
                    if (payChannelEntity.getIsSelected() == 1) {
                        this.p = payChannelEntity;
                        break;
                    }
                    i2++;
                }
                PayChannelEntity payChannelEntity2 = this.p;
                if (payChannelEntity2 == null) {
                    return;
                }
                if (TextUtils.equals("BAIDU-DRMB-WISE", payChannelEntity2.getPayChannel())) {
                    List<PayChannelEntity> list = this.p.childrenPayChannels;
                    if (list == null || list.size() == 0) {
                        return;
                    }
                    this.m.setText("数字人民币支付");
                    this.k.c();
                    this.k.update(this.p.childrenPayChannels);
                    this.i.setVisibility(8);
                    this.j.setVisibility(0);
                    return;
                }
                this.f28229g.b();
                this.r = true;
                this.Q = false;
                PayChannelEntity payChannelEntity3 = this.p;
                if (payChannelEntity3 != null) {
                    M(payChannelEntity3);
                    this.W = this.p.getPayChannel();
                    q0();
                }
            } else if (view.getId() == R.id.obfuscated_res_0x7f0906fc) {
                Z();
            } else if (view.getId() == R.id.obfuscated_res_0x7f0921e3) {
                this.h0 = true;
                g0();
            } else if (view.getId() == R.id.obfuscated_res_0x7f091883) {
                this.k.a();
                this.m.setText("支付");
                this.j.setVisibility(8);
                this.i.setVisibility(0);
            }
        }
    }

    public void p0(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, bundle, str) == null) {
            this.O = str;
            if (this.L != null) {
                this.r = true;
                this.Q = false;
                c.a.e0.g.b.f(System.currentTimeMillis());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.I = c.a.e0.k.g.a.c(this, layoutParams, getResources().getString(R.string.obfuscated_res_0x7f0f0e8c), -1L);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DI.PAY_CHANNEL, str);
                    this.L.l(bundle, new PayChannelEntity(jSONObject), this, this.i0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("default", this.V);
                jSONObject.put("selected", this.W);
                this.W = "";
                jSONObject.put("selects", c.a.e0.g.a.a);
                c.a.e0.g.a.a = 0;
                jSONObject.put("hbit", c.a.e0.g.a.f2781b);
                c.a.e0.g.a.f2781b = "0";
            } catch (JSONException unused) {
            }
            c.a.e0.g.c cVar = new c.a.e0.g.c("5");
            cVar.c(jSONObject);
            c.a.e0.g.f.e(cVar);
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.T && this.U) {
            c.a.e0.g.b.e();
        }
    }

    public void setChannelAuth(IChannelAuth iChannelAuth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, iChannelAuth) == null) {
            this.M = iChannelAuth;
        }
    }

    public void setCloseListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, mVar) == null) {
            this.t = mVar;
        }
    }

    public void setIsPreparePaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.r = z;
            O();
            P();
        }
    }

    public void setResultListener(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, cVar) == null) {
            this.f28230h = cVar;
        }
    }

    public void setWalletList(c.a.e0.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, dVar) == null) {
            this.L = dVar;
        }
    }

    public void setWechatH5Pay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.R = z;
        }
    }
}
