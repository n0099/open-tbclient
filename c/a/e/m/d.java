package c.a.e.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.m.f.a;
import c.a.r0.j3.a0;
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
    public VideoPasterContentView f3217b;

    /* renamed from: c  reason: collision with root package name */
    public View f3218c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.m.f.a f3219d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0125d f3220e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.m.g.b f3221f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.m.e.a f3222g;

    /* renamed from: h  reason: collision with root package name */
    public Context f3223h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3224i;

    /* renamed from: j  reason: collision with root package name */
    public String f3225j;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.e.m.f.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.a.f3222g = null;
            }
        }

        @Override // c.a.e.m.f.a.b
        public void b(c.a.e.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.f3222g = aVar;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.f3221f.b(this.a.q());
                c.a.r0.z1.o.h.c.h(this.a.f3222g);
                if (this.a.f3222g != null) {
                    int d2 = a0.d(this.a.f3223h, this.a.f3222g.f3230i, this.a.f3222g.f3228g, this.a.f3222g.q, null);
                    d dVar = this.a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f3221f.k(this.a.q());
                if (this.a.f3220e != null) {
                    this.a.f3220e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f3221f.j(this.a.q());
                c.a.r0.z1.o.h.c.h(this.a.f3222g);
                if (this.a.f3222g != null) {
                    int d2 = a0.d(this.a.f3223h, this.a.f3222g.f3230i, this.a.f3222g.f3228g, this.a.f3222g.q, null);
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
                this.a.f3221f.g(this.a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.f3221f.e(this.a.q());
                c.a.r0.z1.o.h.c.h(this.a.f3222g);
                if (this.a.f3222g != null) {
                    int d2 = a0.d(this.a.f3223h, this.a.f3222g.f3230i, this.a.f3222g.f3228g, this.a.f3222g.q, null);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.f3220e != null) {
                    this.a.f3220e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.g
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.a.f3217b.isCompleted()) {
                    i2 = 0;
                } else if (this.a.o) {
                    this.a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.a.f3220e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.a.f3220e.d()) {
                        return;
                    }
                    if (this.a.p) {
                        this.a.p = false;
                    } else if (z) {
                    } else {
                        this.a.M(i2);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.e.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0125d {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3224i = false;
        this.o = false;
        this.p = false;
        this.f3223h = context;
        this.a = viewGroup;
        this.f3221f = new c.a.e.m.g.b();
        c.a.e.m.f.a aVar = new c.a.e.m.f.a();
        this.f3219d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f3217b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f3217b.setContentViewCallback(new c(this));
        View view = new View(this.f3223h);
        this.f3218c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(c.a.e.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && a0.q(i2)) {
            this.f3221f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f3224i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f3219d.i();
            this.f3217b.reset();
            this.a.removeView(this.f3217b);
            this.a.removeView(this.f3218c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f3217b) == null) {
            return;
        }
        videoPasterContentView.responseBackkeyDown(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f3217b.resume();
            if (s()) {
                int curDuration = this.f3217b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f3221f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0125d interfaceC0125d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0125d) == null) {
            this.f3220e = interfaceC0125d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3217b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f3223h) == 1 && i2 == 0 && TextUtils.equals(this.f3225j, "VIDEO_LIST")) {
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
            if (this.f3219d.f()) {
                return false;
            }
            this.f3224i = z2;
            this.f3225j = str;
            VideoPasterResponseData e2 = this.f3219d.e();
            if (e2 == null) {
                return false;
            }
            c.a.e.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f3219d.i();
                return false;
            } else if (pasterData.c()) {
                this.f3221f.i(q());
                this.f3219d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f3219d.i();
                return false;
            } else {
                this.a.removeView(this.f3218c);
                this.a.addView(this.f3218c);
                this.a.removeView(this.f3217b);
                this.a.addView(this.f3217b);
                ViewGroup viewGroup = this.a;
                if (viewGroup instanceof FrameLayout) {
                    this.f3217b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f3217b.setLayoutParams(layoutParams);
                }
                this.f3217b.setData(pasterData);
                this.k = this.f3217b.getCurDuration();
                if (!r()) {
                    this.f3221f.i(q());
                    c.a.r0.z1.o.h.c.g(this.f3222g);
                }
                this.f3217b.updateByData(z, z2, str);
                InterfaceC0125d interfaceC0125d = this.f3220e;
                if (interfaceC0125d != null) {
                    interfaceC0125d.c();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f3217b) == null) {
            return;
        }
        videoPasterContentView.showVideoCover();
    }

    public void K(c.a.e.m.a aVar) {
        c.a.e.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f3219d) == null || aVar2.f() || this.f3219d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f3219d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f3217b.getCurDuration();
            if (s() && !H()) {
                this.f3221f.g(q());
            }
            this.f3217b.stop();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f3221f.c(q(), i2);
            if (TextUtils.equals(this.f3225j, "VIDEO_LIST") && i2 == 2) {
                this.f3221f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f3224i : invokeV.booleanValue;
    }

    public c.a.e.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.e.m.g.a aVar = new c.a.e.m.g.a();
            aVar.f3244g = this.k;
            aVar.f3242e = this.f3217b.getTotalDuration();
            aVar.f3243f = this.f3217b.getCurDuration();
            aVar.f3240c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f3223h) == 1) {
                aVar.f3245h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f3223h) == 2) {
                aVar.f3245h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f3223h) == 0) {
                aVar.f3245h = 2;
            } else {
                aVar.f3245h = -1;
            }
            c.a.e.m.e.a aVar2 = this.f3222g;
            if (aVar2 != null) {
                aVar.f3246i = aVar2.a();
                c.a.e.m.e.a aVar3 = this.f3222g;
                aVar.f3247j = aVar3.f3227f;
                aVar.f3241d = aVar3.q;
                aVar.k = aVar3.s;
                aVar.l = aVar3.t;
            }
            return aVar;
        }
        return (c.a.e.m.g.a) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f3217b.isAdAttached() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f3217b.isAdShowing() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3217b;
            return videoPasterContentView != null && videoPasterContentView.isVideoPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0125d interfaceC0125d = this.f3220e;
            if (interfaceC0125d != null) {
                interfaceC0125d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f3221f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f3219d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f3217b) == null) {
            return;
        }
        videoPasterContentView.onEnterFullScreen();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f3217b) == null) {
            return;
        }
        videoPasterContentView.onExitFullScreen();
    }

    public final void z(c.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f3221f.d(q());
        }
    }
}
