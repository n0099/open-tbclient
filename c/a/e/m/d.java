package c.a.e.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.m.f.a;
import c.a.p0.l3.a0;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.afd.videopaster.view.VideoPasterContentView;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f2684b;

    /* renamed from: c  reason: collision with root package name */
    public View f2685c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.m.f.a f2686d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0114d f2687e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.m.g.b f2688f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.m.e.a f2689g;

    /* renamed from: h  reason: collision with root package name */
    public Context f2690h;
    public boolean i;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.e.m.f.a.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.f2689g = null;
            }
        }

        @Override // c.a.e.m.f.a.b
        public void b(c.a.e.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.f2689g = aVar;
                this.a.z(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f2688f.b(this.a.q());
                c.a.p0.b2.o.h.c.h(this.a.f2689g);
                if (this.a.f2689g != null) {
                    int d2 = a0.d(this.a.f2690h, this.a.f2689g.f2694e, this.a.f2689g.f2692c, this.a.f2689g.m, null);
                    d dVar = this.a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f2688f.k(this.a.q());
                if (this.a.f2687e != null) {
                    this.a.f2687e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f2688f.j(this.a.q());
                c.a.p0.b2.o.h.c.h(this.a.f2689g);
                if (this.a.f2689g != null) {
                    int d2 = a0.d(this.a.f2690h, this.a.f2689g.f2694e, this.a.f2689g.f2692c, this.a.f2689g.m, null);
                    d dVar = this.a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.o = true;
                this.a.u();
                this.a.f2688f.g(this.a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.f2688f.e(this.a.q());
                c.a.p0.b2.o.h.c.h(this.a.f2689g);
                if (this.a.f2689g != null) {
                    int d2 = a0.d(this.a.f2690h, this.a.f2689g.f2694e, this.a.f2689g.f2692c, this.a.f2689g.m, null);
                    d dVar = this.a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements VideoPasterContentView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
                if (this.a.f2687e != null) {
                    this.a.f2687e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.g
        public void onDetachedFromWindow() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.a.f2684b.s()) {
                    i = 0;
                } else if (this.a.o) {
                    this.a.o = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (this.a.f2687e != null) {
                    if (i == 0 || i == 1) {
                        this.a.M(i);
                    } else {
                        z = false;
                    }
                    if (this.a.f2687e.d()) {
                        return;
                    }
                    if (this.a.p) {
                        this.a.p = false;
                    } else if (z) {
                    } else {
                        this.a.M(i);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.e.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0114d {
        void a();

        void b();

        void c();

        boolean d();
    }

    public d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.o = false;
        this.p = false;
        this.f2690h = context;
        this.a = viewGroup;
        this.f2688f = new c.a.e.m.g.b();
        c.a.e.m.f.a aVar = new c.a.e.m.f.a();
        this.f2686d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f2684b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f2684b.setContentViewCallback(new c(this));
        View view = new View(this.f2690h);
        this.f2685c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(c.a.e.m.g.a aVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i) == null) && a0.q(i)) {
            this.f2688f.l(aVar, i);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2686d.i();
            this.f2684b.x();
            this.a.removeView(this.f2684b);
            this.a.removeView(this.f2685c);
        }
    }

    public void D(int i) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (videoPasterContentView = this.f2684b) == null) {
            return;
        }
        videoPasterContentView.z(i);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f2684b.A();
            if (s()) {
                int curDuration = this.f2684b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f2688f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0114d interfaceC0114d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0114d) == null) {
            this.f2687e = interfaceC0114d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f2684b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f2690h) == 1 && i == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (this.f2686d.f()) {
                return false;
            }
            this.i = z2;
            this.j = str;
            VideoPasterResponseData e2 = this.f2686d.e();
            if (e2 == null) {
                return false;
            }
            c.a.e.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f2686d.i();
                return false;
            } else if (pasterData.c()) {
                this.f2688f.i(q());
                this.f2686d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f2686d.i();
                return false;
            } else {
                this.a.removeView(this.f2685c);
                this.a.addView(this.f2685c);
                this.a.removeView(this.f2684b);
                this.a.addView(this.f2684b);
                ViewGroup viewGroup = this.a;
                if (viewGroup instanceof FrameLayout) {
                    this.f2684b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f2684b.setLayoutParams(layoutParams);
                }
                this.f2684b.setData(pasterData);
                this.k = this.f2684b.getCurDuration();
                if (!r()) {
                    this.f2688f.i(q());
                    c.a.p0.b2.o.h.c.g(this.f2689g);
                }
                this.f2684b.E(z, z2, str);
                InterfaceC0114d interfaceC0114d = this.f2687e;
                if (interfaceC0114d != null) {
                    interfaceC0114d.c();
                    return true;
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void J() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f2684b) == null) {
            return;
        }
        videoPasterContentView.B();
    }

    public void K(c.a.e.m.a aVar) {
        c.a.e.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f2686d) == null || aVar2.f() || this.f2686d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f2686d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f2684b.getCurDuration();
            if (s() && !H()) {
                this.f2688f.g(q());
            }
            this.f2684b.D();
        }
    }

    public final void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f2688f.c(q(), i);
            if (TextUtils.equals(this.j, "VIDEO_LIST") && i == 2) {
                this.f2688f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public c.a.e.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.e.m.g.a aVar = new c.a.e.m.g.a();
            aVar.f2710g = this.k;
            aVar.f2708e = this.f2684b.getTotalDuration();
            aVar.f2709f = this.f2684b.getCurDuration();
            aVar.f2706c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f2690h) == 1) {
                aVar.f2711h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f2690h) == 2) {
                aVar.f2711h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f2690h) == 0) {
                aVar.f2711h = 2;
            } else {
                aVar.f2711h = -1;
            }
            c.a.e.m.e.a aVar2 = this.f2689g;
            if (aVar2 != null) {
                aVar.i = aVar2.a();
                c.a.e.m.e.a aVar3 = this.f2689g;
                aVar.j = aVar3.f2691b;
                aVar.f2707d = aVar3.m;
                aVar.k = aVar3.o;
                aVar.l = aVar3.p;
            }
            return aVar;
        }
        return (c.a.e.m.g.a) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f2684b.q() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f2684b.r() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f2684b;
            return videoPasterContentView != null && videoPasterContentView.t();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0114d interfaceC0114d = this.f2687e;
            if (interfaceC0114d != null) {
                interfaceC0114d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f2688f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f2686d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f2684b) == null) {
            return;
        }
        videoPasterContentView.v();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f2684b) == null) {
            return;
        }
        videoPasterContentView.w();
    }

    public final void z(c.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.n) {
            this.f2688f.d(q());
        }
    }
}
