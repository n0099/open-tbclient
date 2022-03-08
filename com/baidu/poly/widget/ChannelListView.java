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
import c.a.f0.b;
import c.a.f0.j.e.a;
import c.a.f0.k.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.view.PayChannelController;
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
    public DuVipGuideView A;
    public View B;
    public HostMarketView C;
    public TextView D;
    public TextView E;
    public View F;
    public View G;
    public CouponEntranceView H;
    public View I;
    public View J;
    public CouponListView K;
    public PeriodView L;
    public ToastLoadingView M;
    public Long N;
    public Long O;
    public c.a.f0.j.d P;
    public IChannelAuth Q;
    public PopupWindow R;
    public String S;
    public c.a.f0.k.c.a T;
    public boolean U;
    public boolean V;
    public Runnable W;
    public boolean a0;
    public boolean b0;
    public String c0;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public View f36407e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f36408f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public PolyFrameLayout f36409g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public TipView f36410h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f36411i;

    /* renamed from: j  reason: collision with root package name */
    public Bundle f36412j;
    public ProgressButton k;
    public b.c l;
    public View m;
    public View n;
    public DigitalBankPayView o;
    public DigitalWalletVerifyView p;
    public TextView q;
    public PayChannelEntity r;
    public PayChannelEntity[] s;
    public PayChannelEntity t;
    public boolean u;
    public boolean v;
    public int w;
    public m x;
    public Animation y;
    public Animation z;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.W();
            }
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void b(a.C0143a c0143a, c.a.f0.j.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0143a, aVar) == null) || c0143a == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0143a.f3424i);
            if (this.a.r != null && this.a.r.getIsSelected() == 1) {
                arrayList.add(this.a.r.getHostMarketingDetail());
            }
            this.a.J(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void c(boolean z, a.C0143a c0143a) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, c0143a) == null) || this.a.K == null) {
                return;
            }
            this.a.K.quit(this.a.f36408f);
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void onDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.K = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.f0.j.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.j.e.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f36413b;

        public b(ChannelListView channelListView, c.a.f0.j.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36413b = channelListView;
            this.a = aVar;
        }

        @Override // c.a.f0.j.e.a
        public void a(a.C0140a c0140a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0140a) == null) {
                if (c0140a.a == 0) {
                    this.f36413b.N = Long.valueOf(c0140a.f3405d);
                    this.f36413b.T();
                    if (this.f36413b.r != null && this.f36413b.r.getIsSelected() == 1) {
                        this.f36413b.r.setHostMarketingDetail(c0140a.f3407f);
                    }
                }
                this.a.a(c0140a);
                this.f36413b.H.refreshUI();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.f0.c.a<JSONObject> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // c.a.f0.c.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) && this.a.s == null) {
                this.a.Y(str);
                ChannelListView channelListView = this.a;
                channelListView.onResult(3, this.a.getContext().getString(R.string.get_channel_fail) + str, "0");
                this.a.detach();
                c.a.f0.g.c cVar = new c.a.f0.g.c("1");
                cVar.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                c.a.f0.g.f.e(cVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.c.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                c.a.f0.i.h.g("requestChannelList onSuccess result=" + jSONObject.toString());
                c.a.f0.g.b.a("1.04", System.currentTimeMillis());
                Long valueOf = Long.valueOf(jSONObject.optLong("payMoney"));
                this.a.g0 = jSONObject.optString("isFoldChannel");
                String optString = jSONObject.optString("showTotalAmount", "1");
                this.a.e0 = optString.equals("1");
                this.a.N = valueOf;
                JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    PayChannelEntity[] payChannelEntityArr = new PayChannelEntity[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        PayChannelEntity payChannelEntity = new PayChannelEntity(optJSONArray.optJSONObject(i2));
                        if (payChannelEntity.getIsSelected() == 1) {
                            this.a.c0 = payChannelEntity.getPayChannel();
                        }
                        payChannelEntityArr[i2] = payChannelEntity;
                    }
                    this.a.s = payChannelEntityArr;
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("coupons");
                    this.a.T = new c.a.f0.k.c.a(optJSONArray2);
                    this.a.H.update(this.a.T);
                    if (this.a.K != null) {
                        this.a.K.update(this.a.T.f3416b);
                    }
                    c.a.f0.i.h.g("渲染coupon结束");
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("marketChannels");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        this.a.r = new PayChannelEntity(optJSONArray3.optJSONObject(0));
                    }
                    c.a.f0.i.h.g("渲染hostMark结束");
                    JSONObject optJSONObject = jSONObject.optJSONObject("guideInfo");
                    if (optJSONObject != null) {
                        this.a.A.setVisibility(0);
                        this.a.B.setVisibility(0);
                        this.a.A.updateContent(optJSONObject);
                    } else {
                        this.a.B.setVisibility(8);
                        this.a.A.setVisibility(8);
                    }
                    c.a.f0.g.b.h("7");
                    if (this.a.s.length != 1 || this.a.H.getVisibility() != 8 || this.a.r != null || this.a.s[0] == null) {
                        this.a.T();
                        this.a.P();
                        c.a.f0.i.h.g("渲染宿主营销结束");
                        ChannelListView channelListView = this.a;
                        PayChannelEntity[] payChannelEntityArr2 = channelListView.s;
                        channelListView.O(payChannelEntityArr2);
                        channelListView.s = payChannelEntityArr2;
                        this.a.V();
                        c.a.f0.i.h.g("渲染支付渠道结束");
                        this.a.f36410h.hideLoading();
                        c.a.f0.i.h.g("隐藏loading状态");
                        this.a.U();
                        this.a.b0 = true;
                        this.a.b0();
                        return;
                    }
                    this.a.b0 = true;
                    this.a.b0();
                    TipView tipView = this.a.f36410h;
                    String loadingIcon = this.a.s[0].getLoadingIcon();
                    tipView.showPayLoading(loadingIcon, "即将进入" + this.a.s[0].getDisplayName() + "…");
                    ChannelListView channelListView2 = this.a;
                    channelListView2.K(channelListView2.s[0]);
                    c.a.f0.i.h.g("单渠道支付");
                    return;
                }
                c.a.f0.g.b.b("7", null, null);
                b(new ServerDataException("channelList is null"), "request channelList payChannels is null");
                c.a.f0.i.h.g("requestChannelList channelList is null");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f36414e;

        public d(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36414e = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36414e.Z();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.a0 = true;
                this.a.b0();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.c
        public void a(boolean z, PayChannelEntity payChannelEntity, c.a.f0.j.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), payChannelEntity, aVar}) == null) {
                this.a.f36409g.interceptTouchEvent(true);
                ChannelListView channelListView = this.a;
                channelListView.postDelayed(channelListView.W, 500L);
                if (payChannelEntity == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(payChannelEntity.getHostMarketingDetail());
                }
                if (this.a.H.getSelectedItem() != null) {
                    arrayList.add(this.a.H.getSelectedItem().f3424i);
                }
                this.a.J(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.c
        public void b(a.C0140a c0140a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0140a) == null) {
                this.a.f36409g.interceptTouchEvent(false);
                ChannelListView channelListView = this.a;
                channelListView.removeCallbacks(channelListView.W);
                this.a.hideToastLoading();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f36415e;

        public g(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36415e = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f36415e.getParent() instanceof ViewGroup)) {
                ChannelListView channelListView = this.f36415e;
                channelListView.startAnimation(channelListView.z);
                ((ViewGroup) this.f36415e.getParent()).removeView(this.f36415e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f36416e;

        public h(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36416e = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36416e.M();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f36417e;

        public i(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36417e = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f36417e.R != null && this.f36417e.R.r()) {
                this.f36417e.R.n();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.M();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ChannelItemView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayChannelEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f36418b;

        public k(ChannelListView channelListView, PayChannelEntity payChannelEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView, payChannelEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36418b = channelListView;
            this.a = payChannelEntity;
        }

        @Override // com.baidu.poly.widget.ChannelItemView.c
        public void a(ChannelItemView channelItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, channelItemView) == null) {
                if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(this.a.getPayChannel())) {
                    c.a.f0.g.a.f3331b = "1";
                }
                c.a.f0.g.a.a++;
                PayChannelEntity[] payChannelEntityArr = this.f36418b.s;
                int length = payChannelEntityArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    PayChannelEntity payChannelEntity = payChannelEntityArr[i2];
                    payChannelEntity.setIsSelected(payChannelEntity == this.a ? 1 : 0);
                }
                this.f36418b.V();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                for (PayChannelEntity payChannelEntity : this.a.s) {
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
                this.a.V();
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
        this.U = true;
        this.V = false;
        this.W = new d(this);
        this.a0 = false;
        this.b0 = false;
        this.e0 = true;
        Q();
    }

    public final void J(List<String> list, c.a.f0.j.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, aVar) == null) || aVar == null) {
            return;
        }
        String string = this.f36412j.getString("bduss");
        String string2 = this.f36412j.getString("appKey");
        c.a.f0.j.e.b.b(string, string2, this.O + "", list, new b(this, aVar));
    }

    public final void K(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payChannelEntity) == null) || payChannelEntity == null) {
            return;
        }
        c.a.f0.g.b.f(System.currentTimeMillis());
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.r != null && this.r.getIsSelected() == 1 && !TextUtils.isEmpty(this.r.getHostMarketingDetail())) {
                jSONArray.put(new JSONObject(this.r.getHostMarketingDetail()));
            }
            if (this.H.getSelectedItem() != null && !TextUtils.isEmpty(this.H.getSelectedItem().f3424i)) {
                jSONArray.put(new JSONObject(this.H.getSelectedItem().f3424i));
            }
        } catch (Exception unused) {
        }
        if (jSONArray.length() > 0) {
            this.f36412j.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (!TextUtils.isEmpty(this.g0)) {
            this.f36412j.putString("isFoldChannel", this.g0);
        }
        if (this.P != null) {
            this.S = payChannelEntity.getPayChannel();
            this.P.l(this.f36412j, payChannelEntity, this, this.g0);
        }
    }

    public final void L() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || PolyActivity.invokerActivity == null) {
            return;
        }
        Bundle bundle = this.f36412j;
        if (bundle != null) {
            str = bundle.getString("bduss");
            str2 = this.f36412j.getString("appKey");
        } else {
            str = null;
            str2 = null;
        }
        PayChannelEntity payChannelEntity = this.t;
        String payChannel = payChannelEntity != null ? payChannelEntity.getPayChannel() : null;
        if (this.Q == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(payChannel)) {
            return;
        }
        try {
            Intent intent = new Intent(PolyActivity.invokerActivity, GuideAgreeNoPwdPayActivity.class);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_BDUSS, str);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_APP_KEY, str2);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_PAY_CHANNEL, payChannel);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_AUTH_CHANNEL, this.Q);
            intent.putExtra(GuideAgreeNoPwdPayActivity.KEY_INVOKER_TASK_ID, c.a.f0.e.a.a().b());
            PolyActivity.invokerActivity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PopupWindow popupWindow = this.R;
            boolean z = ((popupWindow != null && popupWindow.r()) || this.v || this.u) ? false : true;
            if ((!TextUtils.isEmpty(this.S) && (TextUtils.equals(this.S, PayChannelController.ALIPAY_PAYCHANNEL) || TextUtils.equals(this.S, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.V) {
                c.a.f0.i.h.g("ChannelListView->confirmViewClose() ali pay channel");
                z &= this.U;
            }
            c.a.f0.i.h.g("ChannelListView->confirmViewClose() canFinishActivity = " + z);
            if (!z || this.x == null) {
                return;
            }
            c.a.f0.i.h.g("ChannelListView->confirmViewClose() finish activity");
            this.x.onClose();
            this.x = null;
        }
    }

    public final String N(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public final PayChannelEntity[] O(PayChannelEntity[] payChannelEntityArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, payChannelEntityArr)) == null) {
            int i2 = 0;
            for (PayChannelEntity payChannelEntity : payChannelEntityArr) {
                if (payChannelEntity.getIsSelected() == 1 && (i2 = i2 + 1) > 1) {
                    payChannelEntity.setIsSelected(0);
                }
                if (payChannelEntity.getEnable() == 1) {
                    this.w++;
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

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.C.update(this.r);
            this.C.setListener(new f(this));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.y = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_bottom);
            this.z = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottom);
            LayoutInflater.from(getContext()).inflate(R.layout.view_channel_list, this);
            this.f36407e = findViewById(R.id.bg_view);
            this.f36408f = (RelativeLayout) findViewById(R.id.channel_pop_view);
            this.f36409g = (PolyFrameLayout) findViewById(R.id.popup_view);
            this.I = findViewById(R.id.pay_money_layout);
            this.J = findViewById(R.id.channel_list_scroll_view);
            this.f36410h = (TipView) findViewById(R.id.tip_view);
            this.f36411i = (ViewGroup) findViewById(R.id.channel_list_view);
            this.q = (TextView) findViewById(R.id.pay_text);
            DigitalBankPayView digitalBankPayView = (DigitalBankPayView) findViewById(R.id.poly_sdk_digital_bank_view);
            this.o = digitalBankPayView;
            digitalBankPayView.setOptionListener(this);
            this.p = (DigitalWalletVerifyView) findViewById(R.id.poly_sdk_digital_dynamic_code_view);
            this.k = (ProgressButton) findViewById(R.id.pay_button);
            View findViewById = findViewById(R.id.close_button);
            this.m = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = findViewById(R.id.poly_sdk_channel_list_back);
            this.n = findViewById2;
            findViewById2.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.A = (DuVipGuideView) findViewById(R.id.vip_guide_view);
            this.B = findViewById(R.id.view_du_vip_bg);
            this.C = (HostMarketView) findViewById(R.id.hostmarket);
            CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(R.id.coupon);
            this.H = couponEntranceView;
            couponEntranceView.setOnClickListener(this);
            this.D = (TextView) findViewById(R.id.money);
            this.E = (TextView) findViewById(R.id.cut);
            this.F = findViewById(R.id.view_translucence_shade);
            View findViewById3 = findViewById(R.id.tv_open_fold);
            this.G = findViewById3;
            findViewById3.setOnClickListener(this);
        }
    }

    public final void R() {
        c.a.f0.k.c.a aVar;
        List<a.C0143a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.T) == null || (list = aVar.f3416b) == null || list.size() <= 0) {
            return;
        }
        CouponListView couponListView = new CouponListView(getContext());
        this.K = couponListView;
        couponListView.attach(this.f36408f.getMeasuredHeight());
        this.K.setListener(new a(this));
        this.K.update(this.T.f3416b);
        this.K.enter(this.f36408f);
    }

    public final void S() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f0) {
                this.G.setVisibility(8);
                return;
            }
            PayChannelEntity[] payChannelEntityArr = this.s;
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
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
            }
        }
    }

    public final void T() {
        Long l2;
        Long l3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (l2 = this.O) == null || (l3 = this.N) == null) {
            return;
        }
        if (l2.equals(l3)) {
            this.D.setText(N(this.N.longValue()));
            this.E.setVisibility(8);
        } else {
            if (this.e0) {
                this.E.setVisibility(0);
            }
            this.D.setText(N(this.N.longValue()));
            TextView textView = this.E;
            textView.setText(" ¥" + N(this.O.longValue()));
        }
        if (this.I.getVisibility() != 0) {
            this.I.setVisibility(0);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.w <= 0) {
                this.k.setVisibility(4);
                return;
            }
            this.k.setVisibility(0);
            this.k.setEnable(true);
        }
    }

    public final void V() {
        PayChannelEntity[] payChannelEntityArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.J.setMinimumHeight(0);
            if (this.s != null) {
                this.f36411i.removeAllViews();
                S();
                for (PayChannelEntity payChannelEntity : this.s) {
                    if (this.f0 || !payChannelEntity.isFold()) {
                        Long l2 = this.N;
                        String N = l2 != null ? N(l2.longValue()) : "";
                        ChannelItemView channelItemView = new ChannelItemView(getContext());
                        channelItemView.setChannelInfo(payChannelEntity, new k(this, payChannelEntity), new l(this), N);
                        if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(payChannelEntity.getPayChannel())) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("hbit", "1");
                            } catch (JSONException unused) {
                            }
                            c.a.f0.g.c cVar = new c.a.f0.g.c("9");
                            cVar.c(jSONObject);
                            c.a.f0.g.f.e(cVar);
                        }
                        this.f36411i.addView(channelItemView);
                    }
                }
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.f0.i.h.g("requestChannelList start");
            c.a.f0.g.b.a("1.01", System.currentTimeMillis());
            c.a.f0.c.h.b.j().e(this.f36412j, new c(this));
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f36407e.setVisibility(0);
            this.f36408f.setVisibility(0);
            this.f36409g.setVisibility(0);
            this.f36407e.setAlpha(0.0f);
            this.f36407e.animate().alpha(0.65f).setDuration(240L).start();
            this.f36408f.startAnimation(this.y);
            this.y.setAnimationListener(new e(this));
            U();
        }
    }

    public final void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.poly_error_tips);
            }
            if (this.R == null) {
                View inflate = View.inflate(this.f36411i.getContext(), R.layout.default_pop_window, null);
                ((TextView) inflate.findViewById(R.id.pop_title)).setText(EventAlias.PayEventAlias.PAY_FAIL);
                ((TextView) inflate.findViewById(R.id.pop_tips)).setText(str.trim());
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
                this.R = popupWindow;
                popupWindow.w(false);
                this.R.B(false);
                this.R.v(new ColorDrawable(0));
                ((TextView) inflate.findViewById(R.id.pop_button)).setOnClickListener(new i(this));
                this.R.A(new j(this));
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (polyActivity.isFinishing()) {
                return;
            }
            this.R.D(polyActivity.getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.M = c.a.f0.k.e.a.c(this.f36409g, layoutParams, "加载中", -1L);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("default", this.c0);
                jSONObject.put("selected", this.d0);
                this.d0 = "";
                jSONObject.put("selects", c.a.f0.g.a.a);
                c.a.f0.g.a.a = 0;
                jSONObject.put("hbit", c.a.f0.g.a.f3331b);
                c.a.f0.g.a.f3331b = "0";
            } catch (JSONException unused) {
            }
            c.a.f0.g.c cVar = new c.a.f0.g.c("5");
            cVar.c(jSONObject);
            c.a.f0.g.f.e(cVar);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.a0 && this.b0) {
            c.a.f0.g.b.e();
        }
    }

    public void callPay(c.a.f0.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || aVar == null) {
            return;
        }
        c.a.f0.g.b.f(System.currentTimeMillis());
        c.a.f0.j.d dVar = this.P;
        if (dVar != null) {
            dVar.m(aVar.a, aVar.f3362b, aVar.f3363c, this, this.g0);
        }
    }

    public void detach() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.u) {
            this.u = false;
            this.f36407e.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new g(this), 240L);
            postDelayed(new h(this), 480L);
        }
    }

    public void directPay(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, bundle, str) == null) {
            startFastPay(bundle, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) ? this.v || super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public void errorEnd(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) {
            c.a.f0.i.h.g("ChannelListView->errorEnd()");
            hideToastLoading();
            if (!TextUtils.isEmpty(str2)) {
                Y(str2);
            } else {
                Y(getResources().getString(R.string.poly_error_tips));
            }
            onResult(3, str, "0");
            setIsPreparePaying(false);
        }
    }

    public PayChannelEntity getSelectedPayChannelEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.t : (PayChannelEntity) invokeV.objValue;
    }

    public c.a.f0.j.d getWalletList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.P : (c.a.f0.j.d) invokeV.objValue;
    }

    public void hideToastLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.f0.k.e.a.b(this.M);
            this.M = null;
        }
    }

    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            DigitalWalletVerifyView digitalWalletVerifyView = this.p;
            if (digitalWalletVerifyView != null && digitalWalletVerifyView.getVisibility() == 0) {
                this.p.hideVerifyView();
                return true;
            }
            DigitalBankPayView digitalBankPayView = this.o;
            if (digitalBankPayView != null && digitalBankPayView.getVisibility() == 0) {
                this.q.setText("支付");
                this.o.hideDigitalBankListView();
                this.n.setVisibility(8);
                this.m.setVisibility(0);
                return true;
            }
            CouponListView couponListView = this.K;
            if (couponListView != null) {
                couponListView.onBackPressed();
                return true;
            }
            PeriodView periodView = this.L;
            if (periodView != null) {
                periodView.onBackPressed();
                return true;
            } else if (this.v) {
                return true;
            } else {
                if (this.u) {
                    onResult(2, c.a.f0.i.e.a(2, null, "key_back_cancel"), "0");
                    detach();
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view) == null) {
            if (view.getId() == R.id.close_button) {
                onResult(2, "主动取消支付", "0");
                detach();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("default", this.c0);
                    jSONObject.put("selected", this.d0);
                    this.d0 = "";
                    jSONObject.put("selects", c.a.f0.g.a.a);
                    c.a.f0.g.a.a = 0;
                    jSONObject.put("hbit", c.a.f0.g.a.f3331b);
                    c.a.f0.g.a.f3331b = "0";
                } catch (JSONException unused) {
                }
                c.a.f0.g.c cVar = new c.a.f0.g.c("6");
                cVar.c(jSONObject);
                c.a.f0.g.f.e(cVar);
            } else if (view.getId() == R.id.pay_button) {
                if (this.w == 0) {
                    return;
                }
                PayChannelEntity[] payChannelEntityArr = this.s;
                int length = payChannelEntityArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    PayChannelEntity payChannelEntity = payChannelEntityArr[i2];
                    if (payChannelEntity.getIsSelected() == 1) {
                        this.t = payChannelEntity;
                        break;
                    }
                    i2++;
                }
                PayChannelEntity payChannelEntity2 = this.t;
                if (payChannelEntity2 == null) {
                    return;
                }
                if (TextUtils.equals("BAIDU-DRMB-WISE", payChannelEntity2.getPayChannel())) {
                    List<PayChannelEntity> list = this.t.childrenPayChannels;
                    if (list == null || list.size() == 0) {
                        return;
                    }
                    this.q.setText("数字人民币支付");
                    this.o.showDigitalBankListView();
                    this.o.update(this.t.childrenPayChannels);
                    this.m.setVisibility(8);
                    this.n.setVisibility(0);
                    return;
                }
                this.k.startLoading();
                this.v = true;
                this.U = false;
                PayChannelEntity payChannelEntity3 = this.t;
                if (payChannelEntity3 != null) {
                    K(payChannelEntity3);
                    this.d0 = this.t.getPayChannel();
                    a0();
                }
            } else if (view.getId() == R.id.coupon) {
                R();
            } else if (view.getId() == R.id.tv_open_fold) {
                this.f0 = true;
                V();
            } else if (view.getId() == R.id.poly_sdk_channel_list_back) {
                this.o.hideDigitalBankListView();
                this.q.setText("支付");
                this.n.setVisibility(8);
                this.m.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.poly.widget.digitalbank.DigitalBankPayView.b
    public void onDigitalBankPayViewClick(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i2) == null) && R.id.poly_sdk_digital_bank_pay == i2) {
            K(this.o.getSelectedChildrenEntity());
        }
    }

    public void onResult(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048606, this, i2, str, str2) == null) {
            c.a.f0.i.h.g("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
            this.U = true;
            b.c cVar = this.l;
            if (cVar != null) {
                cVar.a(i2, str);
                this.l = null;
            }
            c.a.f0.g.f.j(i2, str, str2);
            if (((PolyActivity) getContext()).isFinishing()) {
                c.a.f0.g.f.f();
            }
            M();
        }
    }

    public void payEnd(int i2, String str, String str2, String str3, Map<String, String> map, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), str, str2, str3, map, str4}) == null) {
            payEnd(i2, str, str2);
            if (i2 != 0 || this.f36412j == null) {
                return;
            }
            PayChannelEntity payChannelEntity = this.t;
            if (payChannelEntity != null ? payChannelEntity.isNeedAgreementGuide() : false) {
                L();
            }
        }
    }

    public void payPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.v = false;
            this.k.stopLoading();
        }
    }

    public void requestChannelList(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            if (bundle != null) {
                try {
                    String string = bundle.getString("totalAmount");
                    if (TextUtils.isEmpty(string)) {
                        this.O = -1L;
                    } else {
                        this.O = Long.valueOf(Long.parseLong(string));
                    }
                } catch (Exception unused) {
                    c.a.f0.i.h.g("totalAmount is not long");
                }
            }
            this.f36412j = bundle;
            W();
        }
    }

    public void resetPayStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.k.stopLoading();
            this.v = false;
            this.U = true;
        }
    }

    public void setChannelAuth(IChannelAuth iChannelAuth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, iChannelAuth) == null) {
            this.Q = iChannelAuth;
        }
    }

    public void setCloseListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, mVar) == null) {
            this.x = mVar;
        }
    }

    public void setIsPreparePaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.v = z;
            M();
            detach();
        }
    }

    public void setResultListener(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public void setWalletList(c.a.f0.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, dVar) == null) {
            this.P = dVar;
        }
    }

    public void setWechatH5Pay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.V = z;
        }
    }

    public ChannelListView showChannelBoard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!this.u) {
                this.u = true;
                if (getContext() instanceof Activity) {
                    this.f36410h.showChannelLoading("收银台加载中...");
                    c.a.f0.i.h.g("ChannelListView->attach()");
                    X();
                } else {
                    throw new IllegalStateException("can not attach to context " + getContext());
                }
            }
            return this;
        }
        return (ChannelListView) invokeV.objValue;
    }

    public void showVerifyView(String str, PayChannelEntity payChannelEntity) {
        DigitalWalletVerifyView digitalWalletVerifyView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, str, payChannelEntity) == null) || (digitalWalletVerifyView = this.p) == null) {
            return;
        }
        digitalWalletVerifyView.showVerifyView(this, this.f36412j, str, payChannelEntity);
    }

    public void startFastPay(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, bundle, str) == null) {
            this.S = str;
            if (this.P != null) {
                this.v = true;
                this.U = false;
                c.a.f0.g.b.f(System.currentTimeMillis());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.M = c.a.f0.k.e.a.c(this, layoutParams, getResources().getString(R.string.poly_fast_pay_loading), -1L);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DI.PAY_CHANNEL, str);
                    this.P.l(bundle, new PayChannelEntity(jSONObject), this, this.g0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void payEnd(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048607, this, i2, str, str2) == null) {
            c.a.f0.i.h.g("ChannelListView->payEnd()");
            onResult(i2, str, str2);
            setIsPreparePaying(false);
        }
    }
}
