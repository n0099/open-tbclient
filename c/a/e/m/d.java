package c.a.e.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.m.f.a;
import c.a.t0.k3.z;
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
    public VideoPasterContentView f3585b;

    /* renamed from: c  reason: collision with root package name */
    public View f3586c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.m.f.a f3587d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0141d f3588e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.m.g.b f3589f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.m.e.a f3590g;

    /* renamed from: h  reason: collision with root package name */
    public Context f3591h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3592i;

    /* renamed from: j  reason: collision with root package name */
    public String f3593j;
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
                this.a.f3590g = null;
            }
        }

        @Override // c.a.e.m.f.a.b
        public void b(c.a.e.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.f3590g = aVar;
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
                this.a.f3589f.b(this.a.q());
                c.a.t0.y1.o.h.c.h(this.a.f3590g);
                if (this.a.f3590g != null) {
                    int d2 = z.d(this.a.f3591h, this.a.f3590g.f3598i, this.a.f3590g.f3596g, this.a.f3590g.q, null);
                    d dVar = this.a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f3589f.k(this.a.q());
                if (this.a.f3588e != null) {
                    this.a.f3588e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f3589f.j(this.a.q());
                c.a.t0.y1.o.h.c.h(this.a.f3590g);
                if (this.a.f3590g != null) {
                    int d2 = z.d(this.a.f3591h, this.a.f3590g.f3598i, this.a.f3590g.f3596g, this.a.f3590g.q, null);
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
                this.a.f3589f.g(this.a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.f3589f.e(this.a.q());
                c.a.t0.y1.o.h.c.h(this.a.f3590g);
                if (this.a.f3590g != null) {
                    int d2 = z.d(this.a.f3591h, this.a.f3590g.f3598i, this.a.f3590g.f3596g, this.a.f3590g.q, null);
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
                if (this.a.f3588e != null) {
                    this.a.f3588e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.g
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.a.f3585b.isCompleted()) {
                    i2 = 0;
                } else if (this.a.o) {
                    this.a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.a.f3588e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.a.f3588e.d()) {
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
    public interface InterfaceC0141d {
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
        this.f3592i = false;
        this.o = false;
        this.p = false;
        this.f3591h = context;
        this.a = viewGroup;
        this.f3589f = new c.a.e.m.g.b();
        c.a.e.m.f.a aVar = new c.a.e.m.f.a();
        this.f3587d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f3585b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f3585b.setContentViewCallback(new c(this));
        View view = new View(this.f3591h);
        this.f3586c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(c.a.e.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && z.q(i2)) {
            this.f3589f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f3592i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f3587d.i();
            this.f3585b.reset();
            this.a.removeView(this.f3585b);
            this.a.removeView(this.f3586c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f3585b) == null) {
            return;
        }
        videoPasterContentView.responseBackkeyDown(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f3585b.resume();
            if (s()) {
                int curDuration = this.f3585b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f3589f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0141d interfaceC0141d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0141d) == null) {
            this.f3588e = interfaceC0141d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3585b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f3591h) == 1 && i2 == 0 && TextUtils.equals(this.f3593j, "VIDEO_LIST")) {
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
            if (this.f3587d.f()) {
                return false;
            }
            this.f3592i = z2;
            this.f3593j = str;
            VideoPasterResponseData e2 = this.f3587d.e();
            if (e2 == null) {
                return false;
            }
            c.a.e.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f3587d.i();
                return false;
            } else if (pasterData.c()) {
                this.f3589f.i(q());
                this.f3587d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f3587d.i();
                return false;
            } else {
                this.a.removeView(this.f3586c);
                this.a.addView(this.f3586c);
                this.a.removeView(this.f3585b);
                this.a.addView(this.f3585b);
                ViewGroup viewGroup = this.a;
                if (viewGroup instanceof FrameLayout) {
                    this.f3585b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f3585b.setLayoutParams(layoutParams);
                }
                this.f3585b.setData(pasterData);
                this.k = this.f3585b.getCurDuration();
                if (!r()) {
                    this.f3589f.i(q());
                    c.a.t0.y1.o.h.c.g(this.f3590g);
                }
                this.f3585b.updateByData(z, z2, str);
                InterfaceC0141d interfaceC0141d = this.f3588e;
                if (interfaceC0141d != null) {
                    interfaceC0141d.c();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f3585b) == null) {
            return;
        }
        videoPasterContentView.showVideoCover();
    }

    public void K(c.a.e.m.a aVar) {
        c.a.e.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f3587d) == null || aVar2.f() || this.f3587d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f3587d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f3585b.getCurDuration();
            if (s() && !H()) {
                this.f3589f.g(q());
            }
            this.f3585b.stop();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f3589f.c(q(), i2);
            if (TextUtils.equals(this.f3593j, "VIDEO_LIST") && i2 == 2) {
                this.f3589f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f3592i : invokeV.booleanValue;
    }

    public c.a.e.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.e.m.g.a aVar = new c.a.e.m.g.a();
            aVar.f3612g = this.k;
            aVar.f3610e = this.f3585b.getTotalDuration();
            aVar.f3611f = this.f3585b.getCurDuration();
            aVar.f3608c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f3591h) == 1) {
                aVar.f3613h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f3591h) == 2) {
                aVar.f3613h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f3591h) == 0) {
                aVar.f3613h = 2;
            } else {
                aVar.f3613h = -1;
            }
            c.a.e.m.e.a aVar2 = this.f3590g;
            if (aVar2 != null) {
                aVar.f3614i = aVar2.a();
                c.a.e.m.e.a aVar3 = this.f3590g;
                aVar.f3615j = aVar3.f3595f;
                aVar.f3609d = aVar3.q;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f3585b.isAdAttached() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f3585b.isAdShowing() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3585b;
            return videoPasterContentView != null && videoPasterContentView.isVideoPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0141d interfaceC0141d = this.f3588e;
            if (interfaceC0141d != null) {
                interfaceC0141d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f3589f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f3587d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f3585b) == null) {
            return;
        }
        videoPasterContentView.onEnterFullScreen();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f3585b) == null) {
            return;
        }
        videoPasterContentView.onExitFullScreen();
    }

    public final void z(c.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f3589f.d(q());
        }
    }
}
