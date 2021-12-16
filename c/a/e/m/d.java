package c.a.e.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.m.f.a;
import c.a.s0.j3.z;
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
    public VideoPasterContentView f3069b;

    /* renamed from: c  reason: collision with root package name */
    public View f3070c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.m.f.a f3071d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0103d f3072e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.m.g.b f3073f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.m.e.a f3074g;

    /* renamed from: h  reason: collision with root package name */
    public Context f3075h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3076i;

    /* renamed from: j  reason: collision with root package name */
    public String f3077j;

    /* renamed from: k  reason: collision with root package name */
    public int f3078k;
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
                this.a.f3074g = null;
            }
        }

        @Override // c.a.e.m.f.a.b
        public void b(c.a.e.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.f3074g = aVar;
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
                this.a.f3073f.b(this.a.q());
                c.a.s0.x1.o.h.c.h(this.a.f3074g);
                if (this.a.f3074g != null) {
                    int d2 = z.d(this.a.f3075h, this.a.f3074g.f3083i, this.a.f3074g.f3081g, this.a.f3074g.q, null);
                    d dVar = this.a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f3073f.k(this.a.q());
                if (this.a.f3072e != null) {
                    this.a.f3072e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f3073f.j(this.a.q());
                c.a.s0.x1.o.h.c.h(this.a.f3074g);
                if (this.a.f3074g != null) {
                    int d2 = z.d(this.a.f3075h, this.a.f3074g.f3083i, this.a.f3074g.f3081g, this.a.f3074g.q, null);
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
                this.a.f3073f.g(this.a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.f3073f.e(this.a.q());
                c.a.s0.x1.o.h.c.h(this.a.f3074g);
                if (this.a.f3074g != null) {
                    int d2 = z.d(this.a.f3075h, this.a.f3074g.f3083i, this.a.f3074g.f3081g, this.a.f3074g.q, null);
                    d dVar = this.a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements VideoPasterContentView.i {
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

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
                if (this.a.f3072e != null) {
                    this.a.f3072e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.a.f3069b.isCompleted()) {
                    i2 = 0;
                } else if (this.a.o) {
                    this.a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.a.f3072e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.a.f3072e.d()) {
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
    public interface InterfaceC0103d {
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
        this.f3076i = false;
        this.o = false;
        this.p = false;
        this.f3075h = context;
        this.a = viewGroup;
        this.f3073f = new c.a.e.m.g.b();
        c.a.e.m.f.a aVar = new c.a.e.m.f.a();
        this.f3071d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f3069b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f3069b.setContentViewCallback(new c(this));
        View view = new View(this.f3075h);
        this.f3070c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(c.a.e.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && z.q(i2)) {
            this.f3073f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f3076i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f3071d.i();
            this.f3069b.reset();
            this.a.removeView(this.f3069b);
            this.a.removeView(this.f3070c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f3069b) == null) {
            return;
        }
        videoPasterContentView.responseBackkeyDown(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f3069b.resume();
            if (s()) {
                int curDuration = this.f3069b.getCurDuration();
                this.f3078k = curDuration;
                this.m = curDuration;
                this.f3073f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0103d interfaceC0103d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0103d) == null) {
            this.f3072e = interfaceC0103d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3069b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f3075h) == 1 && i2 == 0 && TextUtils.equals(this.f3077j, "VIDEO_LIST")) {
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
            if (this.f3071d.f()) {
                return false;
            }
            this.f3076i = z2;
            this.f3077j = str;
            VideoPasterResponseData e2 = this.f3071d.e();
            if (e2 == null) {
                return false;
            }
            c.a.e.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f3071d.i();
                return false;
            } else if (pasterData.c()) {
                this.f3073f.i(q());
                this.f3071d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f3071d.i();
                return false;
            } else {
                this.a.removeView(this.f3070c);
                this.a.addView(this.f3070c);
                this.a.removeView(this.f3069b);
                this.a.addView(this.f3069b);
                ViewGroup viewGroup = this.a;
                if (viewGroup instanceof FrameLayout) {
                    this.f3069b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f3069b.setLayoutParams(layoutParams);
                }
                this.f3069b.setData(pasterData);
                this.f3078k = this.f3069b.getCurDuration();
                if (!r()) {
                    this.f3073f.i(q());
                    c.a.s0.x1.o.h.c.g(this.f3074g);
                }
                this.f3069b.updateByData(z, z2, str);
                InterfaceC0103d interfaceC0103d = this.f3072e;
                if (interfaceC0103d != null) {
                    interfaceC0103d.c();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f3069b) == null) {
            return;
        }
        videoPasterContentView.showVideoCover();
    }

    public void K(c.a.e.m.a aVar) {
        c.a.e.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f3071d) == null || aVar2.f() || this.f3071d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f3071d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f3069b.getCurDuration();
            if (s() && !H()) {
                this.f3073f.g(q());
            }
            this.f3069b.stop();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f3073f.c(q(), i2);
            if (TextUtils.equals(this.f3077j, "VIDEO_LIST") && i2 == 2) {
                this.f3073f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f3076i : invokeV.booleanValue;
    }

    public c.a.e.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.e.m.g.a aVar = new c.a.e.m.g.a();
            aVar.f3098g = this.f3078k;
            aVar.f3096e = this.f3069b.getTotalDuration();
            aVar.f3097f = this.f3069b.getCurDuration();
            aVar.f3094c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f3075h) == 1) {
                aVar.f3099h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f3075h) == 2) {
                aVar.f3099h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f3075h) == 0) {
                aVar.f3099h = 2;
            } else {
                aVar.f3099h = -1;
            }
            c.a.e.m.e.a aVar2 = this.f3074g;
            if (aVar2 != null) {
                aVar.f3100i = aVar2.a();
                c.a.e.m.e.a aVar3 = this.f3074g;
                aVar.f3101j = aVar3.f3080f;
                aVar.f3095d = aVar3.q;
                aVar.f3102k = aVar3.s;
                aVar.l = aVar3.t;
            }
            return aVar;
        }
        return (c.a.e.m.g.a) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f3069b.isAdAttached() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f3069b.isAdShowing() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3069b;
            return videoPasterContentView != null && videoPasterContentView.isVideoPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0103d interfaceC0103d = this.f3072e;
            if (interfaceC0103d != null) {
                interfaceC0103d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f3073f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f3071d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f3069b) == null) {
            return;
        }
        videoPasterContentView.onEnterFullScreen();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f3069b) == null) {
            return;
        }
        videoPasterContentView.onExitFullScreen();
    }

    public final void z(c.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f3073f.d(q());
        }
    }
}
