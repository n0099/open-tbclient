package c.a.q0.e0;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class e {
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

    /* renamed from: a  reason: collision with root package name */
    public Handler f16911a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.e.g.c f16912b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f16913c;

    /* renamed from: d  reason: collision with root package name */
    public View f16914d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16915e;

    /* renamed from: f  reason: collision with root package name */
    public String f16916f;

    /* renamed from: g  reason: collision with root package name */
    public String f16917g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16918h;

    /* renamed from: i  reason: collision with root package name */
    public int f16919i;

    /* renamed from: j  reason: collision with root package name */
    public int f16920j;
    public boolean k;
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

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16921e;

        /* renamed from: c.a.q0.e0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0819a implements c.a.e.e.g.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f16922a;

            public C0819a(a aVar) {
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
                this.f16922a = aVar;
            }

            @Override // c.a.e.e.g.b
            public int a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16922a.f16921e.w : invokeV.intValue;
            }

            @Override // c.a.e.e.g.b
            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16922a.f16921e.v : invokeV.intValue;
            }

            @Override // c.a.e.e.g.b
            public View c(LayoutInflater layoutInflater) {
                InterceptResult invokeL;
                Drawable drawable;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                    TextView textView = new TextView(this.f16922a.f16921e.f16913c.getPageActivity());
                    textView.setText(this.f16922a.f16921e.f16916f);
                    if (this.f16922a.f16921e.G != 0) {
                        textView.setGravity(this.f16922a.f16921e.G);
                    } else {
                        textView.setGravity(17);
                    }
                    if (this.f16922a.f16921e.E != 0) {
                        SkinManager.setViewTextColor(textView, this.f16922a.f16921e.E);
                    } else {
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                    }
                    textView.setTextSize(0, this.f16922a.f16921e.F != 0 ? this.f16922a.f16921e.f16913c.getResources().getDimensionPixelSize(this.f16922a.f16921e.F) : this.f16922a.f16921e.f16913c.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (this.f16922a.f16921e.B != 0) {
                        textView.setHeight(this.f16922a.f16921e.B);
                    } else {
                        textView.setHeight(this.f16922a.f16921e.f16913c.getResources().getDimensionPixelSize(R.dimen.ds76));
                    }
                    if (this.f16922a.f16921e.C != 0) {
                        textView.setWidth(this.f16922a.f16921e.C);
                    }
                    textView.setPadding(this.f16922a.f16921e.r, this.f16922a.f16921e.s, this.f16922a.f16921e.t, this.f16922a.f16921e.u);
                    textView.setLines(this.f16922a.f16921e.A);
                    if (this.f16922a.f16921e.D) {
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    if (this.f16922a.f16921e.H != 0) {
                        if (this.f16922a.f16921e.I) {
                            if (this.f16922a.f16921e.E != 0) {
                                i2 = this.f16922a.f16921e.E;
                            } else {
                                i2 = R.color.CAM_X0101;
                            }
                            drawable = WebPManager.getPureDrawable(this.f16922a.f16921e.H, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL);
                        } else {
                            drawable = SkinManager.getDrawable(this.f16922a.f16921e.H);
                        }
                        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                        drawable.setBounds(0, 0, g2, g2);
                        textView.setCompoundDrawablePadding(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                        textView.setCompoundDrawables(drawable, null, null, null);
                    }
                    SkinManager.setBackgroundResource(textView, this.f16922a.f16921e.f16919i);
                    if (this.f16922a.f16921e.x != null) {
                        textView.setOnClickListener(this.f16922a.f16921e.x);
                    }
                    return textView;
                }
                return (View) invokeL.objValue;
            }

            @Override // c.a.e.e.g.b
            public int getXOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16922a.f16921e.p : invokeV.intValue;
            }

            @Override // c.a.e.e.g.b
            public int getYOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16922a.f16921e.q : invokeV.intValue;
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16921e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16921e.f16912b == null && !StringUtils.isNull(this.f16921e.f16916f)) {
                if (!this.f16921e.y || this.f16921e.H()) {
                    c.a.e.e.g.d dVar = new c.a.e.e.g.d();
                    dVar.j(this.f16921e.f16914d);
                    dVar.c(0);
                    dVar.i(true);
                    dVar.h(true);
                    dVar.a(new C0819a(this));
                    this.f16921e.f16912b = dVar.b();
                    this.f16921e.f16912b.k(false);
                    this.f16921e.f16912b.l(this.f16921e.z);
                    this.f16921e.f16912b.n(this.f16921e.f16913c.getPageActivity(), this.f16921e.o);
                    this.f16921e.f16915e = true;
                    this.f16921e.K();
                    this.f16921e.f16918h = true;
                    this.f16921e.f16911a.postDelayed(this.f16921e.K, this.f16921e.n);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16923e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16923e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16923e.I();
            }
        }
    }

    public e(TbPageContext tbPageContext, View view) {
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
        this.f16911a = null;
        this.f16912b = null;
        this.f16919i = R.drawable.pic_sign_tip;
        this.f16920j = 0;
        this.k = false;
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
        this.f16913c = tbPageContext;
        this.f16914d = view;
        this.r = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.s = this.f16913c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.t = this.f16913c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.u = this.f16913c.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View view = this.f16914d;
            return view != null && view.getVisibility() == 0 && ((double) this.f16914d.getAlpha()) >= 0.4d;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.g.c cVar = this.f16912b;
            if (cVar != null) {
                cVar.d();
                this.f16912b = null;
            }
            Handler handler = this.f16911a;
            if (handler != null) {
                handler.removeCallbacks(this.J);
                this.f16911a.removeCallbacks(this.K);
            }
            this.f16918h = false;
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16918h : invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k) {
            return;
        }
        c.a.p0.s.d0.b.j().v(this.f16917g, this.f16920j + 1);
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
            this.B = this.f16913c.getResources().getDimensionPixelSize(i2);
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
        this.f16919i = i2;
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
            this.C = this.f16913c.getResources().getDimensionPixelSize(i2);
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
        this.f16916f = str;
        if (this.f16911a == null) {
            this.f16911a = new Handler();
        }
        this.f16911a.postDelayed(this.J, this.m);
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
            if (this.f16915e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view = this.f16914d) == null || view.getVisibility() != 0) {
                return false;
            }
            this.f16916f = str;
            this.f16917g = str2;
            this.k = z2;
            int k = c.a.p0.s.d0.b.j().k(str2, 0);
            this.f16920j = k;
            if (k < this.l || this.k) {
                if (z) {
                    K();
                    this.f16915e = true;
                }
                if (this.f16911a == null) {
                    this.f16911a = new Handler();
                }
                this.f16911a.postDelayed(this.J, this.m);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
