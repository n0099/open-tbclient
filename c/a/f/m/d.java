package c.a.f.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.f.m.f.a;
import c.a.p0.x2.z;
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
    public ViewGroup f3185a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f3186b;

    /* renamed from: c  reason: collision with root package name */
    public View f3187c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.f.m.f.a f3188d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0065d f3189e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.f.m.g.b f3190f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.f.m.e.a f3191g;

    /* renamed from: h  reason: collision with root package name */
    public Context f3192h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3193i;

    /* renamed from: j  reason: collision with root package name */
    public String f3194j;
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
        public final /* synthetic */ d f3195a;

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
            this.f3195a = dVar;
        }

        @Override // c.a.f.m.f.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f3195a.f3191g = null;
            }
        }

        @Override // c.a.f.m.f.a.b
        public void b(c.a.f.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f3195a.f3191g = aVar;
                this.f3195a.z(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements VideoPasterOverlayView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3196a;

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
            this.f3196a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3196a.f3190f.j(this.f3196a.q());
                c.a.p0.o1.o.h.c.h(this.f3196a.f3191g);
                if (this.f3196a.f3191g != null) {
                    int d2 = z.d(this.f3196a.f3192h, this.f3196a.f3191g.f3202i, this.f3196a.f3191g.f3200g, this.f3196a.f3191g.q);
                    d dVar = this.f3196a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f3196a.f3190f.k(this.f3196a.q());
                if (this.f3196a.f3189e != null) {
                    this.f3196a.f3189e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f3196a.o = true;
                this.f3196a.u();
                this.f3196a.f3190f.g(this.f3196a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f3196a.f3190f.e(this.f3196a.q());
                c.a.p0.o1.o.h.c.h(this.f3196a.f3191g);
                if (this.f3196a.f3191g != null) {
                    int d2 = z.d(this.f3196a.f3192h, this.f3196a.f3191g.f3202i, this.f3196a.f3191g.f3200g, this.f3196a.f3191g.q);
                    d dVar = this.f3196a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f3196a.f3190f.b(this.f3196a.q());
                c.a.p0.o1.o.h.c.h(this.f3196a.f3191g);
                if (this.f3196a.f3191g != null) {
                    int d2 = z.d(this.f3196a.f3192h, this.f3196a.f3191g.f3202i, this.f3196a.f3191g.f3200g, this.f3196a.f3191g.q);
                    d dVar = this.f3196a;
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
        public final /* synthetic */ d f3197a;

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
            this.f3197a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3197a.v();
                if (this.f3197a.f3189e != null) {
                    this.f3197a.f3189e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.f3197a.f3186b.isCompleted()) {
                    i2 = 0;
                } else if (this.f3197a.o) {
                    this.f3197a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.f3197a.f3189e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.f3197a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.f3197a.f3189e.d()) {
                        return;
                    }
                    if (this.f3197a.p) {
                        this.f3197a.p = false;
                    } else if (z) {
                    } else {
                        this.f3197a.M(i2);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.f.m.d$d  reason: collision with other inner class name */
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
        this.f3193i = false;
        this.o = false;
        this.p = false;
        this.f3192h = context;
        this.f3185a = viewGroup;
        this.f3190f = new c.a.f.m.g.b();
        c.a.f.m.f.a aVar = new c.a.f.m.f.a();
        this.f3188d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f3186b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f3186b.setContentViewCallback(new c(this));
        View view = new View(this.f3192h);
        this.f3187c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(c.a.f.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && z.p(i2)) {
            this.f3190f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f3193i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f3188d.i();
            this.f3186b.reset();
            this.f3185a.removeView(this.f3186b);
            this.f3185a.removeView(this.f3187c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f3186b) == null) {
            return;
        }
        videoPasterContentView.responseBackkeyDown(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f3186b.resume();
            if (s()) {
                int curDuration = this.f3186b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f3190f.h(q());
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
            this.f3189e = interfaceC0065d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3186b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f3192h) == 1 && i2 == 0 && TextUtils.equals(this.f3194j, "VIDEO_LIST")) {
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
            if (this.f3188d.f()) {
                return false;
            }
            this.f3193i = z2;
            this.f3194j = str;
            VideoPasterResponseData e2 = this.f3188d.e();
            if (e2 == null) {
                return false;
            }
            c.a.f.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f3188d.i();
                return false;
            } else if (pasterData.c()) {
                this.f3190f.i(q());
                this.f3188d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f3188d.i();
                return false;
            } else {
                this.f3185a.removeView(this.f3187c);
                this.f3185a.addView(this.f3187c);
                this.f3185a.removeView(this.f3186b);
                this.f3185a.addView(this.f3186b);
                ViewGroup viewGroup = this.f3185a;
                if (viewGroup instanceof FrameLayout) {
                    this.f3186b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f3186b.setLayoutParams(layoutParams);
                }
                this.f3186b.setData(pasterData);
                this.k = this.f3186b.getCurDuration();
                if (!r()) {
                    this.f3190f.i(q());
                    c.a.p0.o1.o.h.c.g(this.f3191g);
                }
                this.f3186b.updateByData(z, z2, str);
                InterfaceC0065d interfaceC0065d = this.f3189e;
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f3186b) == null) {
            return;
        }
        videoPasterContentView.showVideoCover();
    }

    public void K(c.a.f.m.a aVar) {
        c.a.f.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f3188d) == null || aVar2.f() || this.f3188d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f3188d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f3186b.getCurDuration();
            if (s() && !H()) {
                this.f3190f.g(q());
            }
            this.f3186b.stop();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f3190f.c(q(), i2);
            if (TextUtils.equals(this.f3194j, "VIDEO_LIST") && i2 == 2) {
                this.f3190f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f3193i : invokeV.booleanValue;
    }

    public c.a.f.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.f.m.g.a aVar = new c.a.f.m.g.a();
            aVar.f3220g = this.k;
            aVar.f3218e = this.f3186b.getTotalDuration();
            aVar.f3219f = this.f3186b.getCurDuration();
            aVar.f3216c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f3192h) == 1) {
                aVar.f3221h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f3192h) == 2) {
                aVar.f3221h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f3192h) == 0) {
                aVar.f3221h = 2;
            } else {
                aVar.f3221h = -1;
            }
            c.a.f.m.e.a aVar2 = this.f3191g;
            if (aVar2 != null) {
                aVar.f3222i = aVar2.a();
                c.a.f.m.e.a aVar3 = this.f3191g;
                aVar.f3223j = aVar3.f3199f;
                aVar.f3217d = aVar3.q;
                aVar.k = aVar3.s;
                aVar.l = aVar3.t;
            }
            return aVar;
        }
        return (c.a.f.m.g.a) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f3186b.isAdAttached() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f3186b.isAdShowing() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f3186b;
            return videoPasterContentView != null && videoPasterContentView.isVideoPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0065d interfaceC0065d = this.f3189e;
            if (interfaceC0065d != null) {
                interfaceC0065d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f3190f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f3188d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f3186b) == null) {
            return;
        }
        videoPasterContentView.onEnterFullScreen();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f3186b) == null) {
            return;
        }
        videoPasterContentView.onExitFullScreen();
    }

    public final void z(c.a.f.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f3190f.d(q());
        }
    }
}
