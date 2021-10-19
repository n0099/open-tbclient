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
import c.a.e0.a;
import c.a.e0.k.j.a;
import c.a.e0.p.a.a;
import c.a.e0.p.c;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.poly.widget.coupon.l A;
    public com.baidu.poly.a.l.c B;
    public Long C;
    public Long D;
    public c.a.e0.k.i.c E;
    public c.a.e0.p.c F;
    public String G;
    public c.a.e0.p.a.a H;
    public boolean I;
    public boolean J;
    public Runnable K;
    public boolean L;
    public boolean M;
    public String N;
    public boolean O;

    /* renamed from: e  reason: collision with root package name */
    public View f44376e;

    /* renamed from: f  reason: collision with root package name */
    public PolyFrameLayout f44377f;

    /* renamed from: g  reason: collision with root package name */
    public TipView f44378g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f44379h;

    /* renamed from: i  reason: collision with root package name */
    public Bundle f44380i;

    /* renamed from: j  reason: collision with root package name */
    public ProgressButton f44381j;
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

    /* loaded from: classes5.dex */
    public class a implements c.a.e0.k.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.e0.k.j.a f44382a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f44383b;

        public a(m mVar, c.a.e0.k.j.a aVar) {
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
            this.f44383b = mVar;
            this.f44382a = aVar;
        }

        @Override // c.a.e0.k.j.a
        public void a(a.C0062a c0062a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0062a) == null) {
                if (c0062a.f3225a == 0) {
                    this.f44383b.C = Long.valueOf(c0062a.f3227c);
                    this.f44383b.J();
                    if (this.f44383b.l != null && this.f44383b.l.P() == 1) {
                        this.f44383b.l.l(c0062a.f3228d);
                    }
                }
                this.f44382a.a(c0062a);
                this.f44383b.x.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c.a.e0.k.a.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f44384a;

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
            this.f44384a = mVar;
        }

        @Override // c.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) && this.f44384a.m == null) {
                m mVar = this.f44384a;
                mVar.Y(mVar.getResources().getString(c.a.e0.h.common_error_tips));
                this.f44384a.onResult(3, "request channel list fail");
                this.f44384a.detach();
                c.a.e0.k.h.b bVar = new c.a.e0.k.h.b("1");
                bVar.c(new com.baidu.poly.a.i.a("gatewaylist error --> " + str, th).U());
                c.a.e0.k.h.d.b(bVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                c.a.e0.n.d.e("requestChannelList onSuccess");
                Long valueOf = Long.valueOf(jSONObject.optLong("payMoney"));
                String optString = jSONObject.optString("showTotalAmount", "1");
                this.f44384a.O = optString.equals("1");
                this.f44384a.C = valueOf;
                JSONArray optJSONArray = jSONObject.optJSONArray("payChannels");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    o[] oVarArr = new o[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        o oVar = new o(optJSONArray.optJSONObject(i2));
                        if (oVar.P() == 1) {
                            this.f44384a.N = oVar.R();
                        }
                        oVarArr[i2] = oVar;
                    }
                    this.f44384a.m = oVarArr;
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("coupons");
                    this.f44384a.H = new c.a.e0.p.a.a(optJSONArray2);
                    this.f44384a.x.a(this.f44384a.H);
                    if (this.f44384a.A != null) {
                        this.f44384a.A.a(this.f44384a.H.f3244b);
                    }
                    c.a.e0.n.d.e("渲染coupon结束");
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("marketChannels");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        this.f44384a.l = new o(optJSONArray3.optJSONObject(0));
                    }
                    c.a.e0.n.d.e("渲染hostMark结束");
                    c.a.e0.k.h.a.g("7");
                    if (this.f44384a.m.length != 1 || this.f44384a.x.getVisibility() != 8 || this.f44384a.l != null || this.f44384a.m[0] == null) {
                        this.f44384a.J();
                        if (this.f44384a.l != null || this.f44384a.x.getVisibility() != 8) {
                            this.f44384a.w.setVisibility(0);
                        } else {
                            this.f44384a.w.setVisibility(8);
                        }
                        this.f44384a.x();
                        c.a.e0.n.d.e("渲染宿主营销结束");
                        m mVar = this.f44384a;
                        o[] oVarArr2 = mVar.m;
                        mVar.l(oVarArr2);
                        mVar.q(oVarArr2);
                        c.a.e0.n.d.e("渲染支付渠道结束");
                        this.f44384a.f44378g.j();
                        c.a.e0.n.d.e("隐藏loading状态");
                        this.f44384a.L();
                        this.f44384a.M = true;
                        this.f44384a.U();
                        return;
                    }
                    this.f44384a.M = true;
                    this.f44384a.U();
                    TipView tipView = this.f44384a.f44378g;
                    String Q = this.f44384a.m[0].Q();
                    tipView.b(Q, "即将进入" + this.f44384a.m[0].getDisplayName() + "…");
                    m mVar2 = this.f44384a;
                    mVar2.p(mVar2.m[0]);
                    c.a.e0.n.d.e("单渠道支付");
                    return;
                }
                c.a.e0.k.h.a.d("7", null, null);
                b(new com.baidu.poly.a.i.b("channelList is null"), "request channelList payChannels is null");
                c.a.e0.n.d.e("requestChannelList channelList is null");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f44385e;

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
            this.f44385e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44385e.S();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f44386a;

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
            this.f44386a = mVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f44386a.L = true;
                this.f44386a.U();
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

    /* loaded from: classes5.dex */
    public class e implements HostMarketView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f44387a;

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
            this.f44387a = mVar;
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void a(boolean z, o oVar, c.a.e0.k.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), oVar, aVar}) == null) {
                this.f44387a.f44377f.a(true);
                m mVar = this.f44387a;
                mVar.postDelayed(mVar.K, 500L);
                if (oVar == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(oVar.O());
                }
                if (this.f44387a.x.getSelectedItem() != null) {
                    arrayList.add(this.f44387a.x.getSelectedItem().f3252h);
                }
                this.f44387a.j(arrayList, aVar);
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.a
        public void b(a.C0062a c0062a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0062a) == null) {
                this.f44387a.f44377f.a(false);
                m mVar = this.f44387a;
                mVar.removeCallbacks(mVar.K);
                this.f44387a.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f44388e;

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
            this.f44388e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f44388e.getParent() instanceof ViewGroup)) {
                m mVar = this.f44388e;
                mVar.startAnimation(mVar.s);
                ((ViewGroup) this.f44388e.getParent()).removeView(this.f44388e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f44389e;

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
            this.f44389e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44389e.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f44390e;

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
            this.f44390e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f44390e.F != null && this.f44390e.F.u()) {
                this.f44390e.F.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f44391a;

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
            this.f44391a = mVar;
        }

        @Override // c.a.e0.p.c.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44391a.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.InterfaceC1695a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o[] f44392a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f44393b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m f44394c;

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
            this.f44394c = mVar;
            this.f44392a = oVarArr;
            this.f44393b = oVar;
        }

        @Override // com.baidu.poly.widget.a.InterfaceC1695a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o[] oVarArr = this.f44392a;
                int length = oVarArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    o oVar = oVarArr[i2];
                    oVar.i(oVar == this.f44393b ? 1 : 0);
                }
                this.f44394c.q(this.f44392a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements l.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f44395a;

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
            this.f44395a = mVar;
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void a(a.C0065a c0065a, c.a.e0.k.j.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0065a, aVar) == null) || c0065a == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0065a.f3252h);
            if (this.f44395a.l != null && this.f44395a.l.P() == 1) {
                arrayList.add(this.f44395a.l.O());
            }
            this.f44395a.j(arrayList, aVar);
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f44395a.O();
            }
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f44395a.A == null) {
                return;
            }
            this.f44395a.A.b(this.f44395a.f44377f);
        }

        @Override // com.baidu.poly.widget.coupon.l.h
        public void onDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f44395a.A = null;
            }
        }
    }

    /* loaded from: classes5.dex */
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
        z();
    }

    public final void B() {
        c.a.e0.p.a.a aVar;
        List<a.C0065a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.H) == null || (list = aVar.f3244b) == null || list.size() <= 0) {
            return;
        }
        com.baidu.poly.widget.coupon.l lVar = new com.baidu.poly.widget.coupon.l(getContext());
        this.A = lVar;
        lVar.a(this.f44377f.getMeasuredHeight());
        this.A.setListener(new k(this));
        this.A.a(this.H.f3244b);
        this.A.a(this.f44377f);
    }

    public final void J() {
        Long l2;
        Long l3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (l2 = this.D) == null || (l3 = this.C) == null) {
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

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.p <= 0) {
                this.f44381j.setVisibility(4);
                return;
            }
            this.f44381j.setVisibility(0);
            this.f44381j.setEnable(true);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.e0.n.d.e("requestChannelList start");
            c.a.e0.k.b.b.j().c(this.f44380i, new b(this));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f44376e.setVisibility(0);
            this.f44377f.setVisibility(0);
            this.f44376e.setAlpha(0.0f);
            this.f44376e.animate().alpha(0.65f).setDuration(240L).start();
            this.f44377f.startAnimation(this.r);
            this.r.setAnimationListener(new d(this));
            L();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.B = c.a.e0.k.k.a.a(this.f44377f, layoutParams, "加载中", -1L);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.L && this.M) {
            c.a.e0.k.h.a.b();
        }
    }

    public final void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(c.a.e0.h.common_error_tips);
            }
            if (this.F == null) {
                View inflate = View.inflate(this.f44379h.getContext(), c.a.e0.g.default_pop_window, null);
                ((TextView) inflate.findViewById(c.a.e0.f.pop_title)).setText(EventAlias.PayEventAlias.PAY_FAIL);
                ((TextView) inflate.findViewById(c.a.e0.f.pop_tips)).setText(str.trim());
                c.a.e0.p.c cVar = new c.a.e0.p.c(inflate, -1, -1, true);
                this.F = cVar;
                cVar.y(false);
                this.F.C(false);
                this.F.x(new ColorDrawable(0));
                ((TextView) inflate.findViewById(c.a.e0.f.pop_button)).setOnClickListener(new h(this));
                this.F.h(new i(this));
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (polyActivity.isFinishing()) {
                return;
            }
            this.F.E(polyActivity.getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public final void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("default", this.N);
                jSONObject.put("selected", str);
            } catch (JSONException unused) {
            }
            c.a.e0.k.h.b bVar = new c.a.e0.k.h.b("5");
            bVar.b(jSONObject);
            c.a.e0.k.h.d.b(bVar);
        }
    }

    public void detach() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.n) {
            this.n = false;
            this.f44376e.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new f(this), 240L);
            postDelayed(new g(this), 480L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) ? this.o || super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.e0.k.k.a.c(this.B);
            this.B = null;
        }
    }

    public final void j(List<String> list, c.a.e0.k.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, list, aVar) == null) || aVar == null) {
            return;
        }
        String string = this.f44380i.getString("bduss");
        String string2 = this.f44380i.getString("appKey");
        c.a.e0.k.j.b.a(string, string2, this.D + "", list, new a(this, aVar));
    }

    public final o[] l(o[] oVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, oVarArr)) == null) {
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

    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            com.baidu.poly.widget.coupon.l lVar = this.A;
            if (lVar != null) {
                lVar.onBackPressed();
                return true;
            } else if (this.o) {
                return true;
            } else {
                if (this.n) {
                    onResult(2, c.a.e0.n.b.a(2, null, "key_back_cancel"));
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
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            if (view.getId() == c.a.e0.f.close_button) {
                onResult(2, "主动取消支付");
                detach();
                c.a.e0.k.h.d.b(new c.a.e0.k.h.b("6"));
            } else if (view.getId() == c.a.e0.f.pay_button) {
                if (this.p == 0) {
                    return;
                }
                this.f44381j.startLoading();
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
                    p(oVar);
                    a0(oVar.R());
                }
            } else if (view.getId() == c.a.e0.f.coupon) {
                B();
            }
        }
    }

    public void onResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, str) == null) {
            c.a.e0.n.d.e("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
            this.I = true;
            a.b bVar = this.k;
            if (bVar != null) {
                bVar.a(i2, str);
                this.k = null;
            }
            c.a.e0.k.h.d.e(i2, str);
            if (((PolyActivity) getContext()).isFinishing()) {
                c.a.e0.k.h.d.j();
            }
            t();
        }
    }

    public final void p(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, oVar) == null) || oVar == null) {
            return;
        }
        c.a.e0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.l != null && this.l.P() == 1 && !TextUtils.isEmpty(this.l.O())) {
                jSONArray.put(new JSONObject(this.l.O()));
            }
            if (this.x.getSelectedItem() != null && !TextUtils.isEmpty(this.x.getSelectedItem().f3252h)) {
                jSONArray.put(new JSONObject(this.x.getSelectedItem().f3252h));
            }
        } catch (Exception unused) {
        }
        if (jSONArray.length() > 0) {
            this.f44380i.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (this.E != null) {
            this.G = oVar.R();
            this.E.c(this.f44380i, oVar.R(), this);
        }
    }

    public final void q(o[] oVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, oVarArr) == null) {
            this.z.setMinimumHeight(0);
            if (oVarArr != null) {
                this.f44379h.removeAllViews();
                for (o oVar : oVarArr) {
                    com.baidu.poly.widget.a aVar = new com.baidu.poly.widget.a(getContext());
                    aVar.a(oVar, new j(this, oVarArr, oVar));
                    this.f44379h.addView(aVar);
                }
            }
        }
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
            t();
            detach();
        }
    }

    public void setResultListener(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void setWalletList(c.a.e0.k.i.c cVar) {
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

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            c.a.e0.p.c cVar = this.F;
            boolean z = ((cVar != null && cVar.u()) || this.o || this.n) ? false : true;
            if ((!TextUtils.isEmpty(this.G) && (TextUtils.equals(this.G, PayChannelController.ALIPAY_PAYCHANNEL) || TextUtils.equals(this.G, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.J) {
                c.a.e0.n.d.e("ChannelListView->confirmViewClose() ali pay channel");
                z &= this.I;
            }
            c.a.e0.n.d.e("ChannelListView->confirmViewClose() canFinishActivity = " + z);
            if (!z || this.q == null) {
                return;
            }
            c.a.e0.n.d.e("ChannelListView->confirmViewClose() finish activity");
            this.q.onClose();
            this.q = null;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.t.a(this.l);
            this.t.setListener(new e(this));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.r = AnimationUtils.loadAnimation(getContext(), c.a.e0.b.slide_in_bottom);
            this.s = AnimationUtils.loadAnimation(getContext(), c.a.e0.b.slide_out_bottom);
            LayoutInflater.from(getContext()).inflate(c.a.e0.g.view_channel_list, this);
            this.f44376e = findViewById(c.a.e0.f.bg_view);
            this.f44377f = (PolyFrameLayout) findViewById(c.a.e0.f.popup_view);
            this.y = findViewById(c.a.e0.f.pay_money_layout);
            this.z = findViewById(c.a.e0.f.channel_list_scroll_view);
            this.f44378g = (TipView) findViewById(c.a.e0.f.tip_view);
            this.f44379h = (ViewGroup) findViewById(c.a.e0.f.channel_list_view);
            this.f44381j = (ProgressButton) findViewById(c.a.e0.f.pay_button);
            this.w = findViewById(c.a.e0.f.line);
            findViewById(c.a.e0.f.close_button).setOnClickListener(this);
            this.f44381j.setOnClickListener(this);
            this.t = (HostMarketView) findViewById(c.a.e0.f.hostmarket);
            CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(c.a.e0.f.coupon);
            this.x = couponEntranceView;
            couponEntranceView.setOnClickListener(this);
            this.u = (TextView) findViewById(c.a.e0.f.money);
            this.v = (TextView) findViewById(c.a.e0.f.cut);
        }
    }

    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            if (bundle != null) {
                try {
                    String string = bundle.getString("totalAmount");
                    if (TextUtils.isEmpty(string)) {
                        this.D = -1L;
                    } else {
                        this.D = Long.valueOf(Long.parseLong(string));
                    }
                } catch (Exception unused) {
                    c.a.e0.n.d.e("totalAmount is not long");
                }
            }
            this.f44380i = bundle;
            O();
        }
    }

    public m g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!this.n) {
                this.n = true;
                if (getContext() instanceof Activity) {
                    this.f44378g.a("收银台加载中...");
                    c.a.e0.n.d.e("ChannelListView->attach()");
                    Q();
                } else {
                    throw new IllegalStateException("can not attach to context " + getContext());
                }
            }
            return this;
        }
        return (m) invokeV.objValue;
    }

    public final String e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public void a(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bundle, str) == null) {
            this.G = str;
            if (this.E != null) {
                this.o = true;
                this.I = false;
                c.a.e0.k.h.a.e(Long.valueOf(System.currentTimeMillis()));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.B = c.a.e0.k.k.a.a(this, layoutParams, getResources().getString(c.a.e0.h.poly_fast_pay_loading), -1L);
                this.E.c(bundle, str, this);
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            c.a.e0.n.d.e("ChannelListView->errorEnd()");
            e();
            if (!TextUtils.isEmpty(str2)) {
                Y(str2);
            } else {
                Y(getResources().getString(c.a.e0.h.common_error_tips));
            }
            onResult(3, str);
            setIsPreparePaying(false);
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            c.a.e0.n.d.e("ChannelListView->payEnd()");
            onResult(i2, str);
            setIsPreparePaying(false);
        }
    }
}
