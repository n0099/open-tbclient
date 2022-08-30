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
import com.baidu.tieba.aa1;
import com.baidu.tieba.fa1;
import com.baidu.tieba.h81;
import com.baidu.tieba.i81;
import com.baidu.tieba.i91;
import com.baidu.tieba.ia1;
import com.baidu.tieba.ja1;
import com.baidu.tieba.ka1;
import com.baidu.tieba.m91;
import com.baidu.tieba.n91;
import com.baidu.tieba.o91;
import com.baidu.tieba.q81;
import com.baidu.tieba.r91;
import com.baidu.tieba.ta1;
import com.baidu.tieba.x91;
import com.baidu.tieba.xa1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.CollapsingTextHelper;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public ia1 L;
    public IChannelAuth M;
    public PopupWindow N;
    public String O;
    public ta1 P;
    public boolean Q;
    public boolean R;
    public Runnable S;
    public boolean T;
    public boolean U;
    public String V;
    public String W;
    public View a;
    public boolean a0;
    public RelativeLayout b;
    public boolean b0;
    public PolyFrameLayout c;
    public String c0;
    public TipView d;
    public ViewGroup e;
    public Bundle f;
    public ProgressButton g;
    public h81.c h;
    public View i;
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

    /* loaded from: classes2.dex */
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
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i0();
            }
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void c(ta1.a aVar, ja1 ja1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, ja1Var) == null) || aVar == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.i);
            if (this.a.n != null && this.a.n.getIsSelected() == 1) {
                arrayList.add(this.a.n.getHostMarketingDetail());
            }
            this.a.L(arrayList, ja1Var);
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void d(boolean z, ta1.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, aVar) == null) || this.a.G == null) {
                return;
            }
            this.a.G.s(this.a.b);
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void onDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.G = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ja1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja1 a;
        public final /* synthetic */ ChannelListView b;

        public b(ChannelListView channelListView, ja1 ja1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView, ja1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = channelListView;
            this.a = ja1Var;
        }

        @Override // com.baidu.tieba.ja1
        public void a(ja1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar.a == 0) {
                    this.b.J = Long.valueOf(aVar.d);
                    this.b.f0();
                    if (this.b.n != null && this.b.n.getIsSelected() == 1) {
                        this.b.n.setHostMarketingDetail(aVar.f);
                    }
                }
                this.a.a(aVar);
                this.b.D.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends i81<JSONObject> {
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

        @Override // com.baidu.tieba.i81
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) && this.a.o == null) {
                this.a.n0(str);
                ChannelListView channelListView = this.a;
                channelListView.Z(3, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f07b0) + str, "0");
                this.a.Q();
                o91 o91Var = new o91("1");
                o91Var.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                r91.e(o91Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i81
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                aa1.g("requestChannelList onSuccess result=" + jSONObject.toString());
                n91.a("1.04", System.currentTimeMillis());
                Long valueOf = Long.valueOf(jSONObject.optLong("payMoney"));
                this.a.c0 = jSONObject.optString("isFoldChannel");
                String optString = jSONObject.optString("showTotalAmount", "1");
                this.a.a0 = optString.equals("1");
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
                    this.a.P = new ta1(optJSONArray2);
                    this.a.D.update(this.a.P);
                    if (this.a.G != null) {
                        this.a.G.update(this.a.P.b);
                    }
                    aa1.g("渲染coupon结束");
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("marketChannels");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        this.a.n = new PayChannelEntity(optJSONArray3.optJSONObject(0));
                    }
                    aa1.g("渲染hostMark结束");
                    JSONObject optJSONObject = jSONObject.optJSONObject("guideInfo");
                    if (optJSONObject != null) {
                        this.a.w.setVisibility(0);
                        this.a.x.setVisibility(0);
                        this.a.w.b(optJSONObject);
                    } else {
                        this.a.x.setVisibility(8);
                        this.a.w.setVisibility(8);
                    }
                    n91.h("7");
                    if (this.a.o.length != 1 || this.a.D.getVisibility() != 8 || this.a.n != null || this.a.o[0] == null) {
                        this.a.f0();
                        this.a.V();
                        aa1.g("渲染宿主营销结束");
                        ChannelListView channelListView = this.a;
                        PayChannelEntity[] payChannelEntityArr2 = channelListView.o;
                        channelListView.U(payChannelEntityArr2);
                        channelListView.o = payChannelEntityArr2;
                        this.a.h0();
                        aa1.g("渲染支付渠道结束");
                        this.a.d.a();
                        aa1.g("隐藏loading状态");
                        this.a.g0();
                        this.a.U = true;
                        this.a.s0();
                        return;
                    }
                    this.a.U = true;
                    this.a.s0();
                    TipView tipView = this.a.d;
                    String loadingIcon = this.a.o[0].getLoadingIcon();
                    tipView.d(loadingIcon, "即将进入" + this.a.o[0].getDisplayName() + CollapsingTextHelper.ELLIPSIS_NORMAL);
                    ChannelListView channelListView2 = this.a;
                    channelListView2.N(channelListView2.o[0]);
                    aa1.g("单渠道支付");
                    return;
                }
                n91.b("7", null, null);
                b(new ServerDataException("channelList is null"), "request channelList payChannels is null");
                aa1.g("requestChannelList channelList is null");
            }
        }
    }

    /* loaded from: classes2.dex */
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
                this.a.o0();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                this.a.s0();
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

    /* loaded from: classes2.dex */
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
        public void a(boolean z, PayChannelEntity payChannelEntity, ja1 ja1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), payChannelEntity, ja1Var}) == null) {
                this.a.c.a(true);
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
                this.a.L(arrayList, ja1Var);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.c
        public void b(ja1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.c.a(false);
                ChannelListView channelListView = this.a;
                channelListView.removeCallbacks(channelListView.S);
                this.a.W();
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
                this.a.P();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.N != null && this.a.N.r()) {
                this.a.N.n();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                this.a.P();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements ChannelItemView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayChannelEntity a;
        public final /* synthetic */ ChannelListView b;

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
            this.b = channelListView;
            this.a = payChannelEntity;
        }

        @Override // com.baidu.poly.widget.ChannelItemView.c
        public void a(ChannelItemView channelItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, channelItemView) == null) {
                if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(this.a.getPayChannel())) {
                    m91.b = "1";
                }
                m91.a++;
                PayChannelEntity[] payChannelEntityArr = this.b.o;
                int length = payChannelEntityArr.length;
                for (int i = 0; i < length; i++) {
                    PayChannelEntity payChannelEntity = payChannelEntityArr[i];
                    payChannelEntity.setIsSelected(payChannelEntity == this.a ? 1 : 0);
                }
                this.b.h0();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                this.a.h0();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        this.a0 = true;
        X();
    }

    public final void L(List<String> list, ja1 ja1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, ja1Var) == null) || ja1Var == null) {
            return;
        }
        String string = this.f.getString("bduss");
        String string2 = this.f.getString("appKey");
        ka1.b(string, string2, this.K + "", list, new b(this, ja1Var));
    }

    public void M(fa1 fa1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fa1Var) == null) || fa1Var == null) {
            return;
        }
        n91.f(System.currentTimeMillis());
        ia1 ia1Var = this.L;
        if (ia1Var != null) {
            ia1Var.m(fa1Var.a, fa1Var.b, fa1Var.c, this, this.c0);
        }
    }

    public final void N(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payChannelEntity) == null) || payChannelEntity == null) {
            return;
        }
        n91.f(System.currentTimeMillis());
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
            this.f.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (!TextUtils.isEmpty(this.c0)) {
            this.f.putString("isFoldChannel", this.c0);
        }
        if (this.L != null) {
            this.O = payChannelEntity.getPayChannel();
            this.L.l(this.f, payChannelEntity, this, this.c0);
        }
    }

    public final void O() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || PolyActivity.g == null) {
            return;
        }
        Bundle bundle = this.f;
        if (bundle != null) {
            str = bundle.getString("bduss");
            str2 = this.f.getString("appKey");
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
            Intent intent = new Intent(PolyActivity.g, GuideAgreeNoPwdPayActivity.class);
            intent.putExtra("key_bduss", str);
            intent.putExtra("key_app_key", str2);
            intent.putExtra("key_pay_channel", payChannel);
            intent.putExtra("key_auth_channel", this.M);
            intent.putExtra("key_invoker_task_id", i91.a().b());
            PolyActivity.g.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = this.N;
            boolean z = ((popupWindow != null && popupWindow.r()) || this.r || this.q) ? false : true;
            if ((!TextUtils.isEmpty(this.O) && (TextUtils.equals(this.O, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.O, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.R) {
                aa1.g("ChannelListView->confirmViewClose() ali pay channel");
                z &= this.Q;
            }
            aa1.g("ChannelListView->confirmViewClose() canFinishActivity = " + z);
            if (!z || this.t == null) {
                return;
            }
            aa1.g("ChannelListView->confirmViewClose() finish activity");
            this.t.onClose();
            this.t = null;
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.q) {
            this.q = false;
            this.a.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new g(this), 240L);
            postDelayed(new h(this), 480L);
        }
    }

    public void R(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, str) == null) {
            q0(bundle, str);
        }
    }

    public void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            aa1.g("ChannelListView->errorEnd()");
            W();
            if (!TextUtils.isEmpty(str2)) {
                n0(str2);
            } else {
                n0(getResources().getString(R.string.obfuscated_res_0x7f0f0ecc));
            }
            Z(3, str, "0");
            setIsPreparePaying(false);
        }
    }

    public final String T(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public final PayChannelEntity[] U(PayChannelEntity[] payChannelEntityArr) {
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

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.y.update(this.n);
            this.y.setListener(new f(this));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            xa1.b(this.I);
            this.I = null;
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.u = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01012a);
            this.v = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01012c);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08c6, this);
            this.a = findViewById(R.id.obfuscated_res_0x7f09037f);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0905ea);
            this.c = (PolyFrameLayout) findViewById(R.id.obfuscated_res_0x7f0919f2);
            this.E = findViewById(R.id.obfuscated_res_0x7f091785);
            this.F = findViewById(R.id.obfuscated_res_0x7f0905e1);
            this.d = (TipView) findViewById(R.id.obfuscated_res_0x7f0921bf);
            this.e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0905e2);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091786);
            DigitalBankPayView digitalBankPayView = (DigitalBankPayView) findViewById(R.id.obfuscated_res_0x7f0919d5);
            this.k = digitalBankPayView;
            digitalBankPayView.setOptionListener(this);
            this.l = (DigitalWalletVerifyView) findViewById(R.id.obfuscated_res_0x7f0919d6);
            this.g = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f091783);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09064d);
            this.i = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0919d3);
            this.j = findViewById2;
            findViewById2.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.w = (DuVipGuideView) findViewById(R.id.obfuscated_res_0x7f09258c);
            this.x = findViewById(R.id.obfuscated_res_0x7f092554);
            this.y = (HostMarketView) findViewById(R.id.obfuscated_res_0x7f090dac);
            CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(R.id.obfuscated_res_0x7f0906f4);
            this.D = couponEntranceView;
            couponEntranceView.setOnClickListener(this);
            this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f091520);
            this.A = (TextView) findViewById(R.id.obfuscated_res_0x7f09074a);
            this.B = findViewById(R.id.obfuscated_res_0x7f092575);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f09237c);
            this.C = findViewById3;
            findViewById3.setOnClickListener(this);
        }
    }

    public boolean Y() {
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
                    Z(2, x91.a(2, null, "key_back_cancel"), "0");
                    Q();
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void Z(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i2, str, str2) == null) {
            aa1.g("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
            this.Q = true;
            h81.c cVar = this.h;
            if (cVar != null) {
                cVar.a(i2, str);
                this.h = null;
            }
            r91.j(i2, str, str2);
            if (((PolyActivity) getContext()).isFinishing()) {
                r91.f();
            }
            P();
        }
    }

    @Override // com.baidu.poly.widget.digitalbank.DigitalBankPayView.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && R.id.obfuscated_res_0x7f0919d4 == i2) {
            N(this.k.getSelectedChildrenEntity());
        }
    }

    public final void a0() {
        ta1 ta1Var;
        List<ta1.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (ta1Var = this.P) == null || (list = ta1Var.b) == null || list.size() <= 0) {
            return;
        }
        CouponListView couponListView = new CouponListView(getContext());
        this.G = couponListView;
        couponListView.n(this.b.getMeasuredHeight());
        this.G.setListener(new a(this));
        this.G.update(this.P.b);
        this.G.p(this.b);
    }

    public void b0(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048593, this, i2, str, str2) == null) {
            aa1.g("ChannelListView->payEnd()");
            Z(i2, str, str2);
            setIsPreparePaying(false);
        }
    }

    public void c0(int i2, String str, String str2, String str3, Map<String, String> map, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), str, str2, str3, map, str4}) == null) {
            b0(i2, str, str2);
            if (i2 != 0 || this.f == null) {
                return;
            }
            PayChannelEntity payChannelEntity = this.p;
            if (payChannelEntity != null ? payChannelEntity.isNeedAgreementGuide() : false) {
                O();
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.r = false;
            this.g.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) ? this.r || super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final void e0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.b0) {
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

    public final void f0() {
        Long l2;
        Long l3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (l2 = this.K) == null || (l3 = this.J) == null) {
            return;
        }
        if (l2.equals(l3)) {
            this.z.setText(T(this.J.longValue()));
            this.A.setVisibility(8);
        } else {
            if (this.a0) {
                this.A.setVisibility(0);
            }
            this.z.setText(T(this.J.longValue()));
            TextView textView = this.A;
            textView.setText(" ¥" + T(this.K.longValue()));
        }
        if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.s <= 0) {
                this.g.setVisibility(4);
                return;
            }
            this.g.setVisibility(0);
            this.g.setEnable(true);
        }
    }

    public PayChannelEntity getSelectedPayChannelEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.p : (PayChannelEntity) invokeV.objValue;
    }

    public ia1 getWalletList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.L : (ia1) invokeV.objValue;
    }

    public final void h0() {
        PayChannelEntity[] payChannelEntityArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.F.setMinimumHeight(0);
            if (this.o != null) {
                this.e.removeAllViews();
                e0();
                for (PayChannelEntity payChannelEntity : this.o) {
                    if (this.b0 || !payChannelEntity.isFold()) {
                        Long l2 = this.J;
                        String T = l2 != null ? T(l2.longValue()) : "";
                        ChannelItemView channelItemView = new ChannelItemView(getContext());
                        channelItemView.setChannelInfo(payChannelEntity, new k(this, payChannelEntity), new l(this), T);
                        if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(payChannelEntity.getPayChannel())) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("hbit", "1");
                            } catch (JSONException unused) {
                            }
                            o91 o91Var = new o91("9");
                            o91Var.c(jSONObject);
                            r91.e(o91Var);
                        }
                        this.e.addView(channelItemView);
                    }
                }
            }
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            aa1.g("requestChannelList start");
            n91.a("1.01", System.currentTimeMillis());
            q81.j().e(this.f, new c(this));
        }
    }

    public void j0(Bundle bundle) {
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
                    aa1.g("totalAmount is not long");
                }
            }
            this.f = bundle;
            i0();
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.g.c();
            this.r = false;
            this.Q = true;
        }
    }

    public ChannelListView l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!this.q) {
                this.q = true;
                if (getContext() instanceof Activity) {
                    this.d.c("收银台加载中...");
                    aa1.g("ChannelListView->attach()");
                    m0();
                } else {
                    throw new IllegalStateException("can not attach to context " + getContext());
                }
            }
            return this;
        }
        return (ChannelListView) invokeV.objValue;
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.a.setAlpha(0.0f);
            this.a.animate().alpha(0.65f).setDuration(240L).start();
            this.b.startAnimation(this.u);
            this.u.setAnimationListener(new e(this));
            g0();
        }
    }

    public final void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f0ecc);
            }
            if (this.N == null) {
                View inflate = View.inflate(this.e.getContext(), R.layout.obfuscated_res_0x7f0d020b, null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919f1)).setText(EventAlias.PayEventAlias.PAY_FAIL);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919f0)).setText(str.trim());
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
                this.N = popupWindow;
                popupWindow.w(false);
                this.N.B(false);
                this.N.v(new ColorDrawable(0));
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919eb)).setOnClickListener(new i(this));
                this.N.A(new j(this));
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (polyActivity.isFinishing()) {
                return;
            }
            this.N.D(polyActivity.getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.I = xa1.c(this.c, layoutParams, "加载中", -1L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f09064d) {
                Z(2, "主动取消支付", "0");
                Q();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("default", this.V);
                    jSONObject.put("selected", this.W);
                    this.W = "";
                    jSONObject.put("selects", m91.a);
                    m91.a = 0;
                    jSONObject.put("hbit", m91.b);
                    m91.b = "0";
                } catch (JSONException unused) {
                }
                o91 o91Var = new o91("6");
                o91Var.c(jSONObject);
                r91.e(o91Var);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091783) {
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
                this.g.b();
                this.r = true;
                this.Q = false;
                PayChannelEntity payChannelEntity3 = this.p;
                if (payChannelEntity3 != null) {
                    N(payChannelEntity3);
                    this.W = this.p.getPayChannel();
                    r0();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906f4) {
                a0();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09237c) {
                this.b0 = true;
                h0();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0919d3) {
                this.k.a();
                this.m.setText("支付");
                this.j.setVisibility(8);
                this.i.setVisibility(0);
            }
        }
    }

    public void p0(String str, PayChannelEntity payChannelEntity) {
        DigitalWalletVerifyView digitalWalletVerifyView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048611, this, str, payChannelEntity) == null) || (digitalWalletVerifyView = this.l) == null) {
            return;
        }
        digitalWalletVerifyView.B(this, this.f, str, payChannelEntity);
    }

    public void q0(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, bundle, str) == null) {
            this.O = str;
            if (this.L != null) {
                this.r = true;
                this.Q = false;
                n91.f(System.currentTimeMillis());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.I = xa1.c(this, layoutParams, getResources().getString(R.string.obfuscated_res_0x7f0f0ecd), -1L);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DI.PAY_CHANNEL, str);
                    this.L.l(bundle, new PayChannelEntity(jSONObject), this, this.c0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("default", this.V);
                jSONObject.put("selected", this.W);
                this.W = "";
                jSONObject.put("selects", m91.a);
                m91.a = 0;
                jSONObject.put("hbit", m91.b);
                m91.b = "0";
            } catch (JSONException unused) {
            }
            o91 o91Var = new o91("5");
            o91Var.c(jSONObject);
            r91.e(o91Var);
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.T && this.U) {
            n91.e();
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
            P();
            Q();
        }
    }

    public void setResultListener(h81.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, cVar) == null) {
            this.h = cVar;
        }
    }

    public void setWalletList(ia1 ia1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ia1Var) == null) {
            this.L = ia1Var;
        }
    }

    public void setWechatH5Pay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.R = z;
        }
    }
}
