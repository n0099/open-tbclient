package c.a.r0.k0;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public Runnable J;
    public Runnable K;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.f.g.c f18566b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f18567c;

    /* renamed from: d  reason: collision with root package name */
    public View f18568d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18569e;

    /* renamed from: f  reason: collision with root package name */
    public String f18570f;

    /* renamed from: g  reason: collision with root package name */
    public String f18571g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18572h;

    /* renamed from: i  reason: collision with root package name */
    public int f18573i;

    /* renamed from: j  reason: collision with root package name */
    public int f18574j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18575k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18576e;

        /* renamed from: c.a.r0.k0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1098a implements c.a.d.f.g.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1098a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.d.f.g.b
            public int a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.f18576e.w : invokeV.intValue;
            }

            @Override // c.a.d.f.g.b
            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.f18576e.v : invokeV.intValue;
            }

            @Override // c.a.d.f.g.b
            public View c(LayoutInflater layoutInflater) {
                InterceptResult invokeL;
                Drawable drawable;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                    TextView textView = new TextView(this.a.f18576e.f18567c.getPageActivity());
                    textView.setText(this.a.f18576e.f18570f);
                    if (this.a.f18576e.G != 0) {
                        textView.setGravity(this.a.f18576e.G);
                    } else {
                        textView.setGravity(17);
                    }
                    if (this.a.f18576e.E != 0) {
                        SkinManager.setViewTextColor(textView, this.a.f18576e.E);
                    } else {
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                    }
                    textView.setTextSize(0, this.a.f18576e.F != 0 ? this.a.f18576e.f18567c.getResources().getDimensionPixelSize(this.a.f18576e.F) : this.a.f18576e.f18567c.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (this.a.f18576e.B != 0) {
                        textView.setHeight(this.a.f18576e.B);
                    } else {
                        textView.setHeight(this.a.f18576e.f18567c.getResources().getDimensionPixelSize(R.dimen.ds76));
                    }
                    if (this.a.f18576e.C != 0) {
                        textView.setWidth(this.a.f18576e.C);
                    }
                    textView.setPadding(this.a.f18576e.r, this.a.f18576e.s, this.a.f18576e.t, this.a.f18576e.u);
                    textView.setLines(this.a.f18576e.A);
                    if (this.a.f18576e.D) {
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    if (this.a.f18576e.H != 0) {
                        if (this.a.f18576e.I) {
                            if (this.a.f18576e.E != 0) {
                                i2 = this.a.f18576e.E;
                            } else {
                                i2 = R.color.CAM_X0101;
                            }
                            drawable = WebPManager.getPureDrawable(this.a.f18576e.H, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL);
                        } else {
                            drawable = SkinManager.getDrawable(this.a.f18576e.H);
                        }
                        int f2 = l.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                        drawable.setBounds(0, 0, f2, f2);
                        textView.setCompoundDrawablePadding(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                        textView.setCompoundDrawables(drawable, null, null, null);
                    }
                    SkinManager.setBackgroundResource(textView, this.a.f18576e.f18573i);
                    if (this.a.f18576e.x != null) {
                        textView.setOnClickListener(this.a.f18576e.x);
                    }
                    return textView;
                }
                return (View) invokeL.objValue;
            }

            @Override // c.a.d.f.g.b
            public int getXOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.f18576e.p : invokeV.intValue;
            }

            @Override // c.a.d.f.g.b
            public int getYOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.f18576e.q : invokeV.intValue;
            }
        }

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18576e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f18576e.f18566b == null && !StringUtils.isNull(this.f18576e.f18570f)) {
                if (!this.f18576e.y || this.f18576e.H()) {
                    c.a.d.f.g.d dVar = new c.a.d.f.g.d();
                    dVar.j(this.f18576e.f18568d);
                    dVar.c(0);
                    dVar.i(true);
                    dVar.h(true);
                    dVar.a(new C1098a(this));
                    this.f18576e.f18566b = dVar.b();
                    this.f18576e.f18566b.o(false);
                    this.f18576e.f18566b.p(this.f18576e.z);
                    this.f18576e.f18566b.r(this.f18576e.f18567c.getPageActivity(), this.f18576e.o);
                    this.f18576e.f18569e = true;
                    this.f18576e.K();
                    this.f18576e.f18572h = true;
                    this.f18576e.a.postDelayed(this.f18576e.K, this.f18576e.n);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18577e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18577e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18577e.I();
            }
        }
    }

    public g(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f18566b = null;
        this.f18573i = R.drawable.pic_sign_tip;
        this.f18574j = 0;
        this.f18575k = false;
        this.l = 1;
        this.m = 1000;
        this.n = 3000;
        this.o = true;
        this.p = 5;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 48;
        this.w = 4;
        this.z = false;
        this.A = 1;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = false;
        this.J = new a(this);
        this.K = new b(this);
        this.f18567c = tbPageContext;
        this.f18568d = view;
        this.r = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.s = this.f18567c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.t = this.f18567c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.u = this.f18567c.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View view = this.f18568d;
            return view != null && view.getVisibility() == 0 && ((double) this.f18568d.getAlpha()) >= 0.4d;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.f.g.c cVar = this.f18566b;
            if (cVar != null) {
                cVar.e();
                this.f18566b = null;
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacks(this.J);
                this.a.removeCallbacks(this.K);
            }
            this.f18572h = false;
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18572h : invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f18575k) {
            return;
        }
        c.a.q0.s.e0.b.j().v(this.f18571g, this.f18574j + 1);
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.w = i2;
        }
    }

    public void M(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.n = i2;
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.v = i2;
        }
    }

    public void P(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.B = this.f18567c.getResources().getDimensionPixelSize(i2);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.D = z;
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.I = z;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.A = i2;
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.l = i2;
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.y = z;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.o = z;
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.m = i2;
    }

    public void X(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.E = i2;
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.H = i2;
        }
    }

    public void Z(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048594, this, i2, i3, i4, i5) == null) {
            this.r = i2;
            this.s = i3;
            this.t = i4;
            this.u = i5;
        }
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.u = i2;
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.r = i2;
        }
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.t = i2;
        }
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.s = i2;
        }
    }

    public void e0(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.F = i2;
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.G = i2;
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f18573i = i2;
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.z = z;
        }
    }

    public void i0(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.C = this.f18567c.getResources().getDimensionPixelSize(i2);
        }
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.p = i2;
        }
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.q = i2;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f18570f = str;
        if (this.a == null) {
            this.a = new Handler();
        }
        this.a.postDelayed(this.J, this.m);
    }

    public void m0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, str2) == null) {
            n0(str, str2, false);
        }
    }

    public boolean n0(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048608, this, str, str2, z)) == null) ? o0(str, str2, z, false) : invokeLLZ.booleanValue;
    }

    public boolean o0(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f18569e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view = this.f18568d) == null || view.getVisibility() != 0) {
                return false;
            }
            this.f18570f = str;
            this.f18571g = str2;
            this.f18575k = z2;
            int k2 = c.a.q0.s.e0.b.j().k(str2, 0);
            this.f18574j = k2;
            if (k2 < this.l || this.f18575k) {
                if (z) {
                    K();
                    this.f18569e = true;
                }
                if (this.a == null) {
                    this.a = new Handler();
                }
                this.a.postDelayed(this.J, this.m);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
