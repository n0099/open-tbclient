package b.a.f.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.f.m.f.a;
import b.a.r0.a3.z;
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

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f2836a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f2837b;

    /* renamed from: c  reason: collision with root package name */
    public View f2838c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.f.m.f.a f2839d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0065d f2840e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.f.m.g.b f2841f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.f.m.e.a f2842g;

    /* renamed from: h  reason: collision with root package name */
    public Context f2843h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2844i;
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2845a;

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
            this.f2845a = dVar;
        }

        @Override // b.a.f.m.f.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f2845a.f2842g = null;
            }
        }

        @Override // b.a.f.m.f.a.b
        public void b(b.a.f.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f2845a.f2842g = aVar;
                this.f2845a.z(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2846a;

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
            this.f2846a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2846a.f2841f.j(this.f2846a.q());
                b.a.r0.q1.o.h.c.h(this.f2846a.f2842g);
                if (this.f2846a.f2842g != null) {
                    int d2 = z.d(this.f2846a.f2843h, this.f2846a.f2842g.f2852i, this.f2846a.f2842g.f2850g, this.f2846a.f2842g.q);
                    d dVar = this.f2846a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f2846a.f2841f.k(this.f2846a.q());
                if (this.f2846a.f2840e != null) {
                    this.f2846a.f2840e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f2846a.o = true;
                this.f2846a.u();
                this.f2846a.f2841f.g(this.f2846a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f2846a.f2841f.e(this.f2846a.q());
                b.a.r0.q1.o.h.c.h(this.f2846a.f2842g);
                if (this.f2846a.f2842g != null) {
                    int d2 = z.d(this.f2846a.f2843h, this.f2846a.f2842g.f2852i, this.f2846a.f2842g.f2850g, this.f2846a.f2842g.q);
                    d dVar = this.f2846a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f2846a.f2841f.b(this.f2846a.q());
                b.a.r0.q1.o.h.c.h(this.f2846a.f2842g);
                if (this.f2846a.f2842g != null) {
                    int d2 = z.d(this.f2846a.f2843h, this.f2846a.f2842g.f2852i, this.f2846a.f2842g.f2850g, this.f2846a.f2842g.q);
                    d dVar = this.f2846a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements VideoPasterContentView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2847a;

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
            this.f2847a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2847a.v();
                if (this.f2847a.f2840e != null) {
                    this.f2847a.f2840e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.f2847a.f2837b.isCompleted()) {
                    i2 = 0;
                } else if (this.f2847a.o) {
                    this.f2847a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.f2847a.f2840e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.f2847a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.f2847a.f2840e.d()) {
                        return;
                    }
                    if (this.f2847a.p) {
                        this.f2847a.p = false;
                    } else if (z) {
                    } else {
                        this.f2847a.M(i2);
                    }
                }
            }
        }
    }

    /* renamed from: b.a.f.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065d {
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
        this.f2844i = false;
        this.o = false;
        this.p = false;
        this.f2843h = context;
        this.f2836a = viewGroup;
        this.f2841f = new b.a.f.m.g.b();
        b.a.f.m.f.a aVar = new b.a.f.m.f.a();
        this.f2839d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f2837b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f2837b.setContentViewCallback(new c(this));
        View view = new View(this.f2843h);
        this.f2838c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(b.a.f.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && z.p(i2)) {
            this.f2841f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f2844i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2839d.i();
            this.f2837b.reset();
            this.f2836a.removeView(this.f2837b);
            this.f2836a.removeView(this.f2838c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f2837b) == null) {
            return;
        }
        videoPasterContentView.responseBackkeyDown(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f2837b.resume();
            if (s()) {
                int curDuration = this.f2837b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f2841f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0065d interfaceC0065d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0065d) == null) {
            this.f2840e = interfaceC0065d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f2837b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f2843h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
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
            if (this.f2839d.f()) {
                return false;
            }
            this.f2844i = z2;
            this.j = str;
            VideoPasterResponseData e2 = this.f2839d.e();
            if (e2 == null) {
                return false;
            }
            b.a.f.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f2839d.i();
                return false;
            } else if (pasterData.c()) {
                this.f2841f.i(q());
                this.f2839d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f2839d.i();
                return false;
            } else {
                this.f2836a.removeView(this.f2838c);
                this.f2836a.addView(this.f2838c);
                this.f2836a.removeView(this.f2837b);
                this.f2836a.addView(this.f2837b);
                ViewGroup viewGroup = this.f2836a;
                if (viewGroup instanceof FrameLayout) {
                    this.f2837b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f2837b.setLayoutParams(layoutParams);
                }
                this.f2837b.setData(pasterData);
                this.k = this.f2837b.getCurDuration();
                if (!r()) {
                    this.f2841f.i(q());
                    b.a.r0.q1.o.h.c.g(this.f2842g);
                }
                this.f2837b.updateByData(z, z2, str);
                InterfaceC0065d interfaceC0065d = this.f2840e;
                if (interfaceC0065d != null) {
                    interfaceC0065d.c();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f2837b) == null) {
            return;
        }
        videoPasterContentView.showVideoCover();
    }

    public void K(b.a.f.m.a aVar) {
        b.a.f.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f2839d) == null || aVar2.f() || this.f2839d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f2839d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f2837b.getCurDuration();
            if (s() && !H()) {
                this.f2841f.g(q());
            }
            this.f2837b.stop();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f2841f.c(q(), i2);
            if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
                this.f2841f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2844i : invokeV.booleanValue;
    }

    public b.a.f.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            b.a.f.m.g.a aVar = new b.a.f.m.g.a();
            aVar.f2869g = this.k;
            aVar.f2867e = this.f2837b.getTotalDuration();
            aVar.f2868f = this.f2837b.getCurDuration();
            aVar.f2865c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f2843h) == 1) {
                aVar.f2870h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f2843h) == 2) {
                aVar.f2870h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f2843h) == 0) {
                aVar.f2870h = 2;
            } else {
                aVar.f2870h = -1;
            }
            b.a.f.m.e.a aVar2 = this.f2842g;
            if (aVar2 != null) {
                aVar.f2871i = aVar2.a();
                b.a.f.m.e.a aVar3 = this.f2842g;
                aVar.j = aVar3.f2849f;
                aVar.f2866d = aVar3.q;
                aVar.k = aVar3.s;
                aVar.l = aVar3.t;
            }
            return aVar;
        }
        return (b.a.f.m.g.a) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f2837b.isAdAttached() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f2837b.isAdShowing() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f2837b;
            return videoPasterContentView != null && videoPasterContentView.isVideoPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0065d interfaceC0065d = this.f2840e;
            if (interfaceC0065d != null) {
                interfaceC0065d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f2841f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f2839d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f2837b) == null) {
            return;
        }
        videoPasterContentView.onEnterFullScreen();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f2837b) == null) {
            return;
        }
        videoPasterContentView.onExitFullScreen();
    }

    public final void z(b.a.f.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f2841f.d(q());
        }
    }
}
