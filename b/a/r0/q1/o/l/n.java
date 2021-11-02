package b.a.r0.q1.o.l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.w;
import b.a.r0.q1.o.l.a;
import b.a.r0.q1.o.l.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f22702a;

    /* renamed from: b  reason: collision with root package name */
    public View f22703b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f22704c;

    /* renamed from: d  reason: collision with root package name */
    public int f22705d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f22706e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f22707f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22708g;

    /* renamed from: h  reason: collision with root package name */
    public String f22709h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22710i;
    public View j;
    public int k;
    public int l;
    public boolean m;
    public m n;
    public b.a.r0.q1.o.l.a o;
    public b.a.r0.q1.o.l.c p;
    public TbImageView.g q;
    public SeekBar.OnSeekBarChangeListener r;
    public VideoControllerView.d s;
    public View.OnClickListener t;
    public c.p u;
    public CyberPlayerManager.OnPreparedListener v;
    public VideoControllerView.c w;
    public a.h x;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22711a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22711a = nVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f22711a.f22707f != null) {
                this.f22711a.f22707f.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f22712e;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22712e = nVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f22712e.p.X();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || this.f22712e.p.a0() || this.f22712e.p.h0() == null) {
                return;
            }
            this.f22712e.p.D0(this.f22712e.p.h0().getSeekPosition());
            this.f22712e.p.O0(this.f22712e.f22709h);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22713a;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22713a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f22713a.r()) {
                return;
            }
            this.f22713a.p.i0(i2);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f22714e;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22714e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f22714e.r() && view.getId() == this.f22714e.f22703b.getId()) {
                if (!b.a.e.e.p.j.z()) {
                    b.a.e.e.p.l.J(this.f22714e.f22702a.getPageActivity(), this.f22714e.f22702a.getString(R.string.neterror));
                }
                if (this.f22714e.o == null || !this.f22714e.f22704c.isPlaying()) {
                    return;
                }
                this.f22714e.o.r();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22715a;

        public e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22715a = nVar;
        }

        @Override // b.a.r0.q1.o.l.c.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // b.a.r0.q1.o.l.c.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f22715a.o.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f22716e;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22716e = nVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22716e.f22704c == null) {
                return;
            }
            this.f22716e.o.r();
            if (this.f22716e.n == null || this.f22716e.n.e() == null || !this.f22716e.n.e().equals(this.f22716e.f22709h) || this.f22716e.n.f() <= 0) {
                if (this.f22716e.n == null || this.f22716e.n.g(this.f22716e.f22709h) <= 0) {
                    return;
                }
                this.f22716e.f22704c.seekTo(this.f22716e.n.g(this.f22716e.f22709h));
                return;
            }
            this.f22716e.f22704c.seekTo(this.f22716e.n.f());
            this.f22716e.n.o(null);
            this.f22716e.n.p(0);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22717a;

        public g(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22717a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22717a.r() || this.f22717a.o == null || this.f22717a.j == null) {
                return;
            }
            if (this.f22717a.f22704c.isPlaying()) {
                this.f22717a.o.r();
            }
            if (this.f22717a.j.getAlpha() != 1.0f) {
                this.f22717a.j.setAlpha(1.0f);
            }
            this.f22717a.j.clearAnimation();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f22718a;

        public h(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22718a = nVar;
        }

        @Override // b.a.r0.q1.o.l.a.h
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22718a.p.a0()) {
                this.f22718a.p.l0();
            }
        }

        @Override // b.a.r0.q1.o.l.a.h
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22718a.p.a0()) {
                this.f22718a.p.W();
            }
        }

        @Override // b.a.r0.q1.o.l.a.h
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f22718a.p.a0()) {
                this.f22718a.p.W();
            }
        }
    }

    public n(TbPageContext<?> tbPageContext, View view) {
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
        this.f22710i = false;
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
        this.x = new h(this);
        this.f22702a = tbPageContext;
        this.f22703b = view;
        view.setOnClickListener(this.t);
        b.a.r0.q1.o.l.c a2 = b.a.r0.q1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f22704c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f22703b.findViewById(R.id.video_thumbnail);
        this.f22707f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f22708g = (ImageView) this.f22703b.findViewById(R.id.img_play);
        this.j = this.p.b0();
        this.k = b.a.e.e.p.l.k(this.f22702a.getPageActivity());
        this.l = b.a.e.e.p.l.i(this.f22702a.getPageActivity());
        this.n = b.a.r0.q1.o.l.d.c(this.f22702a);
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r()) {
                return 0;
            }
            return this.f22704c.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22705d : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22709h : (String) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22703b : (View) invokeV.objValue;
    }

    public final void o() {
        b.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.p) == null || this.f22704c == null || this.f22706e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f22703b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f22706e.f51091d);
        this.p.I0(this.f22706e.f51094g);
        this.p.J0(this.f22709h);
        this.p.x0(this.u);
        this.p.r0();
        this.p.L0();
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f22710i : invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22703b == null || this.f22704c == null || this.f22707f == null || this.f22708g == null || this.j == null || this.o == null : invokeV.booleanValue;
    }

    public void s(b.a.r0.q1.o.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.o = aVar;
            if (aVar != null) {
                aVar.t(this.x);
            }
        }
    }

    public void t(boolean z) {
        b.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.C0(z);
    }

    public void u(boolean z) {
        b.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.N0(z);
    }

    public void v() {
        b.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.m) {
            return;
        }
        int i2 = this.f22705d;
        if (i2 <= 0 || i2 == b.a.r0.q1.o.k.c.f22647a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!w.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f22709h);
        }
    }

    public void w() {
        b.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f22703b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.f22710i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i2) == null) {
            this.f22706e = aVar;
            this.f22705d = i2;
            if (r() || aVar == null) {
                return;
            }
            String str = this.f22709h;
            if (str == null || !str.equalsIgnoreCase(aVar.f51088a)) {
                w();
                this.f22709h = aVar.f51088a;
                this.f22707f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f22707f.startLoad(aVar.f51091d, 17, false);
                int i3 = aVar.f51092e;
                int i4 = aVar.f51093f;
                ViewGroup.LayoutParams layoutParams = this.f22703b.getLayoutParams();
                if (i3 > 0 && i4 > 0 && layoutParams != null && !aVar.f51095h) {
                    if (i3 > i4) {
                        layoutParams.height = ((this.k * 1) * i4) / i3;
                    } else {
                        layoutParams.height = this.k;
                    }
                    this.f22703b.setLayoutParams(layoutParams);
                    this.p.M0();
                } else if (layoutParams != null && aVar.f51095h) {
                    layoutParams.width = this.k;
                    layoutParams.height = this.l;
                    this.f22703b.setLayoutParams(layoutParams);
                    this.p.k0();
                }
                this.p.T();
            }
        }
    }

    public void y(String str, String str2) {
        b.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.R0(str, str2);
    }
}
