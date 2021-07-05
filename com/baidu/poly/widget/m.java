package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
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
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.poly.widget.a;
import com.baidu.poly.widget.coupon.CouponEntranceView;
import com.baidu.poly.widget.coupon.l;
import com.baidu.poly.widget.hostmarket.HostMarketView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import d.a.g0.a;
import d.a.g0.k.j.a;
import d.a.g0.p.a.a;
import d.a.g0.p.c;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.poly.widget.coupon.l A;
    public com.baidu.poly.a.l.c B;
    public Long C;
    public Long D;
    public d.a.g0.k.i.c E;
    public d.a.g0.p.c F;
    public String G;
    public d.a.g0.p.a.a H;
    public boolean I;
    public boolean J;
    public Runnable K;
    public boolean L;
    public boolean M;
    public String N;
    public boolean O;

    /* renamed from: e  reason: collision with root package name */
    public View f9483e;

    /* renamed from: f  reason: collision with root package name */
    public PolyFrameLayout f9484f;

    /* renamed from: g  reason: collision with root package name */
    public TipView f9485g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f9486h;

    /* renamed from: i  reason: collision with root package name */
    public Bundle f9487i;
    public ProgressButton j;
    public a.b k;
    public o l;
    public o[] m;
    public boolean n;
    public boolean o;
    public int p;
    public l q;
    public Animation r;
    public Animation s;
    public HostMarketView t;
    public TextView u;
    public TextView v;
    public View w;
    public CouponEntranceView x;
    public View y;
    public View z;

    /* loaded from: classes3.dex */
    public class a implements d.a.g0.k.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.g0.k.j.a f9488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f9489b;

        public a(m mVar, d.a.g0.k.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9489b = mVar;
            this.f9488a = aVar;
        }

        @Override // d.a.g0.k.j.a
        public void a(a.C0633a c0633a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0633a) == null) {
                if (c0633a.f45482a == 0) {
                    this.f9489b.C = Long.valueOf(c0633a.f45484c);
                    this.f9489b.M();
                    if (this.f9489b.l != null && this.f9489b.l.P() == 1) {
                        this.f9489b.l.l(c0633a.f45485d);
                    }
                }
                this.f9488a.a(c0633a);
                this.f9489b.x.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.g0.k.a.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f9490a;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9490a = mVar;
        }

        @Override // d.a.g0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) && this.f9490a.m == null) {
                m mVar = this.f9490a;
                mVar.c0(mVar.getResources().getString(d.a.g0.h.common_error_tips));
                this.f9490a.h0(3, "request channel list fail");
                this.f9490a.H();
                d.a.g0.k.h.b bVar = new d.a.g0.k.h.b("1");
                bVar.c(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U());
                d.a.g0.k.h.d.b(bVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.g0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                d.a.g0.n.d.e("requestChannelList onSuccess");
                Long valueOf = Long.valueOf(jSONObject.optLong("payMoney"));
                String optString = jSONObject.optString("showTotalAmount", "1");
                this.f9490a.O = optString.equals("1");
                this.f9490a.C = valueOf;
                JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    o[] oVarArr = new o[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        o oVar = new o(optJSONArray.optJSONObject(i2));
                        if (oVar.P() == 1) {
                            this.f9490a.N = oVar.R();
                        }
                        oVarArr[i2] = oVar;
                    }
                    this.f9490a.m = oVarArr;
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("coupons");
                    this.f9490a.H = new d.a.g0.p.a.a(optJSONArray2);
                    this.f9490a.x.b(this.f9490a.H);
                    if (this.f9490a.A != null) {
                        this.f9490a.A.g(this.f9490a.H.f45501b);
                    }
                    d.a.g0.n.d.e("渲染coupon结束");
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("marketChannels");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        this.f9490a.l = new o(optJSONArray3.optJSONObject(0));
                    }
                    d.a.g0.n.d.e("渲染hostMark结束");
                    d.a.g0.k.h.a.g("7");
                    if (this.f9490a.m.length != 1 || this.f9490a.x.getVisibility() != 8 || this.f9490a.l != null || this.f9490a.m[0] == null) {
                        this.f9490a.M();
                        if (this.f9490a.l != null || this.f9490a.x.getVisibility() != 8) {
                            this.f9490a.w.setVisibility(0);
                        } else {
                            this.f9490a.w.setVisibility(8);
                        }
                        this.f9490a.B();
                        d.a.g0.n.d.e("渲染宿主营销结束");
                        m mVar = this.f9490a;
                        o[] oVarArr2 = mVar.m;
                        mVar.p(oVarArr2);
                        mVar.u(oVarArr2);
                        d.a.g0.n.d.e("渲染支付渠道结束");
                        this.f9490a.f9485g.d();
                        d.a.g0.n.d.e("隐藏loading状态");
                        this.f9490a.P();
                        this.f9490a.M = true;
                        this.f9490a.Y();
                        return;
                    }
                    this.f9490a.M = true;
                    this.f9490a.Y();
                    TipView tipView = this.f9490a.f9485g;
                    String Q = this.f9490a.m[0].Q();
                    tipView.b(Q, "即将进入" + this.f9490a.m[0].getDisplayName() + "…");
                    m mVar2 = this.f9490a;
                    mVar2.t(mVar2.m[0]);
                    d.a.g0.n.d.e("单渠道支付");
                    return;
                }
                d.a.g0.k.h.a.d("7", null, null);
                b(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
                d.a.g0.n.d.e("requestChannelList channelList is null");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f9491e;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9491e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9491e.W();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f9492a;

        public d(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9492a = mVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f9492a.L = true;
                this.f9492a.Y();
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

    /* loaded from: classes3.dex */
    public class e implements HostMarketView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f9493a;

        public e(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9493a = mVar;
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, d.a.g0.k.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), oVar, aVar}) == null) {
                this.f9493a.f9484f.a(true);
                m mVar = this.f9493a;
                mVar.postDelayed(mVar.K, 500L);
                if (oVar == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (this.f9493a.x.getSelectedItem() != null) {
                    arrayList.add(this.f9493a.x.getSelectedItem().f45509h);
                }
                this.f9493a.n(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0633a c0633a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0633a) == null) {
                this.f9493a.f9484f.a(false);
                m mVar = this.f9493a;
                mVar.removeCallbacks(mVar.K);
                this.f9493a.I();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f9494e;

        public f(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9494e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f9494e.getParent() instanceof ViewGroup)) {
                m mVar = this.f9494e;
                mVar.startAnimation(mVar.s);
                ((ViewGroup) this.f9494e.getParent()).removeView(this.f9494e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f9495e;

        public g(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9495e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9495e.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f9496e;

        public h(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9496e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f9496e.F != null && this.f9496e.F.u()) {
                this.f9496e.F.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f9497a;

        public i(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9497a = mVar;
        }

        @Override // d.a.g0.p.c.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9497a.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements a.InterfaceC0138a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o[] f9498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f9499b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m f9500c;

        public j(m mVar, o[] oVarArr, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, oVarArr, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9500c = mVar;
            this.f9498a = oVarArr;
            this.f9499b = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC0138a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o[] oVarArr = this.f9498a;
                int length = oVarArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    o oVar = oVarArr[i2];
                    oVar.i(oVar == this.f9499b ? 1 : 0);
                }
                this.f9500c.u(this.f9498a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements l.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f9501a;

        public k(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9501a = mVar;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0636a c0636a, d.a.g0.k.j.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0636a, aVar) == null) || c0636a == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0636a.f45509h);
            if (this.f9501a.l != null && this.f9501a.l.P() == 1) {
                arrayList.add(this.f9501a.l.O());
            }
            this.f9501a.n(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9501a.R();
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f9501a.A == null) {
                return;
            }
            this.f9501a.A.k(this.f9501a.f9484f);
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f9501a.A = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        void onClose();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PolyActivity polyActivity) {
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
        this.I = true;
        this.J = false;
        this.K = new c(this);
        this.L = false;
        this.M = false;
        this.O = true;
        G();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t.d(this.l);
            this.t.setListener(new e(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r = AnimationUtils.loadAnimation(getContext(), d.a.g0.b.slide_in_bottom);
            this.s = AnimationUtils.loadAnimation(getContext(), d.a.g0.b.slide_out_bottom);
            LayoutInflater.from(getContext()).inflate(d.a.g0.g.view_channel_list, this);
            this.f9483e = findViewById(d.a.g0.f.bg_view);
            this.f9484f = (PolyFrameLayout) findViewById(d.a.g0.f.popup_view);
            this.y = findViewById(d.a.g0.f.pay_money_layout);
            this.z = findViewById(d.a.g0.f.channel_list_scroll_view);
            this.f9485g = (TipView) findViewById(d.a.g0.f.tip_view);
            this.f9486h = (ViewGroup) findViewById(d.a.g0.f.channel_list_view);
            this.j = (ProgressButton) findViewById(d.a.g0.f.pay_button);
            this.w = findViewById(d.a.g0.f.line);
            findViewById(d.a.g0.f.close_button).setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.t = (HostMarketView) findViewById(d.a.g0.f.hostmarket);
            CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(d.a.g0.f.coupon);
            this.x = couponEntranceView;
            couponEntranceView.setOnClickListener(this);
            this.u = (TextView) findViewById(d.a.g0.f.money);
            this.v = (TextView) findViewById(d.a.g0.f.cut);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.n) {
            this.n = false;
            this.f9483e.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(this), 240L);
            postDelayed(new g(this), 480L);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.g0.k.k.a.c(this.B);
            this.B = null;
        }
    }

    public final void K() {
        d.a.g0.p.a.a aVar;
        List<a.C0636a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.H) == null || (list = aVar.f45501b) == null || list.size() <= 0) {
            return;
        }
        com.baidu.poly.widget.coupon.l lVar = new com.baidu.poly.widget.coupon.l(getContext());
        this.A = lVar;
        lVar.c(this.f9484f.getMeasuredHeight());
        this.A.setListener(new k(this));
        this.A.g(this.H.f45501b);
        this.A.d(this.f9484f);
    }

    public final void M() {
        Long l2;
        Long l3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (l2 = this.D) == null || (l3 = this.C) == null) {
            return;
        }
        if (l2.equals(l3)) {
            this.u.setText(e(this.C.longValue()));
            this.v.setVisibility(8);
        } else {
            if (this.O) {
                this.v.setVisibility(0);
            }
            this.u.setText(e(this.C.longValue()));
            TextView textView = this.v;
            textView.setText(" ¥" + e(this.D.longValue()));
        }
        if (this.y.getVisibility() != 0) {
            this.y.setVisibility(0);
        }
    }

    public m O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.n) {
                this.n = true;
                if (getContext() instanceof Activity) {
                    this.f9485g.a("收银台加载中...");
                    d.a.g0.n.d.e("ChannelListView->attach()");
                    T();
                } else {
                    throw new IllegalStateException("can not attach to context " + getContext());
                }
            }
            return this;
        }
        return (m) invokeV.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.p <= 0) {
                this.j.setVisibility(4);
                return;
            }
            this.j.setVisibility(0);
            this.j.setEnable(true);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.g0.n.d.e("requestChannelList start");
            d.a.g0.k.b.b.j().c(this.f9487i, new b(this));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f9483e.setVisibility(0);
            this.f9484f.setVisibility(0);
            this.f9483e.setAlpha(0.0f);
            this.f9483e.animate().alpha(0.65f).setDuration(240L).start();
            this.f9484f.startAnimation(this.r);
            this.r.setAnimationListener(new d(this));
            P();
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.B = d.a.g0.k.k.a.a(this.f9484f, layoutParams, "加载中", -1L);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.L && this.M) {
            d.a.g0.k.h.a.b();
        }
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(d.a.g0.h.common_error_tips);
            }
            if (this.F == null) {
                View inflate = View.inflate(this.f9486h.getContext(), d.a.g0.g.default_pop_window, null);
                ((TextView) inflate.findViewById(d.a.g0.f.pop_title)).setText(EventAlias.PayEventAlias.PAY_FAIL);
                ((TextView) inflate.findViewById(d.a.g0.f.pop_tips)).setText(str.trim());
                d.a.g0.p.c cVar = new d.a.g0.p.c(inflate, -1, -1, true);
                this.F = cVar;
                cVar.y(false);
                this.F.C(false);
                this.F.x(new ColorDrawable(0));
                ((TextView) inflate.findViewById(d.a.g0.f.pop_button)).setOnClickListener(new h(this));
                this.F.h(new i(this));
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (polyActivity.isFinishing()) {
                return;
            }
            this.F.E(polyActivity.getWindow().getDecorView(), 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) ? this.o || super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final String e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public final void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("default", this.N);
                jSONObject.put("selected", str);
            } catch (JSONException unused) {
            }
            d.a.g0.k.h.b bVar = new d.a.g0.k.h.b("5");
            bVar.b(jSONObject);
            d.a.g0.k.h.d.b(bVar);
        }
    }

    public void g(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, str) == null) {
            d.a.g0.n.d.e("ChannelListView->payEnd()");
            h0(i2, str);
            setIsPreparePaying(false);
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            com.baidu.poly.widget.coupon.l lVar = this.A;
            if (lVar != null) {
                lVar.t();
                return true;
            } else if (this.o) {
                return true;
            } else {
                if (this.n) {
                    h0(2, d.a.g0.n.b.a(2, null, "key_back_cancel"));
                    H();
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            if (bundle != null) {
                try {
                    String string = bundle.getString("totalAmount");
                    if (TextUtils.isEmpty(string)) {
                        this.D = -1L;
                    } else {
                        this.D = Long.valueOf(Long.parseLong(string));
                    }
                } catch (Exception unused) {
                    d.a.g0.n.d.e("totalAmount is not long");
                }
            }
            this.f9487i = bundle;
            R();
        }
    }

    public void h0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i2, str) == null) {
            d.a.g0.n.d.e("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
            this.I = true;
            a.b bVar = this.k;
            if (bVar != null) {
                bVar.a(i2, str);
                this.k = null;
            }
            d.a.g0.k.h.d.e(i2, str);
            if (((PolyActivity) getContext()).isFinishing()) {
                d.a.g0.k.h.d.j();
            }
            x();
        }
    }

    public void i(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, bundle, str) == null) {
            this.G = str;
            if (this.E != null) {
                this.o = true;
                this.I = false;
                d.a.g0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.B = d.a.g0.k.k.a.a(this, layoutParams, getResources().getString(d.a.g0.h.poly_fast_pay_loading), -1L);
                this.E.c(bundle, str, this);
            }
        }
    }

    public void m(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            d.a.g0.n.d.e("ChannelListView->errorEnd()");
            I();
            if (!TextUtils.isEmpty(str2)) {
                c0(str2);
            } else {
                c0(getResources().getString(d.a.g0.h.common_error_tips));
            }
            h0(3, str);
            setIsPreparePaying(false);
        }
    }

    public final void n(List<String> list, d.a.g0.k.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, list, aVar) == null) || aVar == null) {
            return;
        }
        String string = this.f9487i.getString("bduss");
        String string2 = this.f9487i.getString("appKey");
        d.a.g0.k.j.b.a(string, string2, this.D + "", list, new a(this, aVar));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            if (view.getId() == d.a.g0.f.close_button) {
                h0(2, "主动取消支付");
                H();
                d.a.g0.k.h.d.b(new d.a.g0.k.h.b("6"));
            } else if (view.getId() == d.a.g0.f.pay_button) {
                if (this.p == 0) {
                    return;
                }
                this.j.b();
                this.o = true;
                int i2 = 0;
                this.I = false;
                o oVar = null;
                o[] oVarArr = this.m;
                int length = oVarArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    o oVar2 = oVarArr[i2];
                    if (oVar2.P() == 1) {
                        oVar = oVar2;
                        break;
                    }
                    i2++;
                }
                if (oVar != null) {
                    t(oVar);
                    f0(oVar.R());
                }
            } else if (view.getId() == d.a.g0.f.coupon) {
                K();
            }
        }
    }

    public final o[] p(o[] oVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, oVarArr)) == null) {
            int i2 = 0;
            for (o oVar : oVarArr) {
                if (oVar.P() == 1 && (i2 = i2 + 1) > 1) {
                    oVar.i(0);
                }
                if (oVar.N() == 1) {
                    this.p++;
                }
            }
            if (i2 == 0) {
                for (o oVar2 : oVarArr) {
                    if (oVar2.N() == 1) {
                        oVar2.i(1);
                        return oVarArr;
                    }
                }
            }
            return oVarArr;
        }
        return (o[]) invokeL.objValue;
    }

    public void setCloseListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, lVar) == null) {
            this.q = lVar;
        }
    }

    public void setIsPreparePaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.o = z;
            x();
            H();
        }
    }

    public void setResultListener(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void setWalletList(d.a.g0.k.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, cVar) == null) {
            this.E = cVar;
        }
    }

    public void setWechatH5Pay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.J = z;
        }
    }

    public final void t(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, oVar) == null) || oVar == null) {
            return;
        }
        d.a.g0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.l != null && this.l.P() == 1 && !TextUtils.isEmpty(this.l.O())) {
                jSONArray.put(new JSONObject(this.l.O()));
            }
            if (this.x.getSelectedItem() != null && !TextUtils.isEmpty(this.x.getSelectedItem().f45509h)) {
                jSONArray.put(new JSONObject(this.x.getSelectedItem().f45509h));
            }
        } catch (Exception unused) {
        }
        if (jSONArray.length() > 0) {
            this.f9487i.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (this.E != null) {
            this.G = oVar.R();
            this.E.c(this.f9487i, oVar.R(), this);
        }
    }

    public final void u(o[] oVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, oVarArr) == null) {
            this.z.setMinimumHeight(0);
            if (oVarArr != null) {
                this.f9486h.removeAllViews();
                for (o oVar : oVarArr) {
                    com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                    aVar.a(oVar, new j(this, oVarArr, oVar));
                    this.f9486h.addView(aVar);
                }
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            d.a.g0.p.c cVar = this.F;
            boolean z = ((cVar != null && cVar.u()) || this.o || this.n) ? false : true;
            if ((!TextUtils.isEmpty(this.G) && (TextUtils.equals(this.G, PayChannelController.ALIPAY_PAYCHANNEL) || TextUtils.equals(this.G, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.J) {
                d.a.g0.n.d.e("ChannelListView->confirmViewClose() ali pay channel");
                z &= this.I;
            }
            d.a.g0.n.d.e("ChannelListView->confirmViewClose() canFinishActivity = " + z);
            if (!z || this.q == null) {
                return;
            }
            d.a.g0.n.d.e("ChannelListView->confirmViewClose() finish activity");
            this.q.onClose();
            this.q = null;
        }
    }
}
