package c.a.r0.q1.o.l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.k3.w;
import c.a.r0.q1.o.l.a;
import c.a.r0.q1.o.l.c;
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
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f23815a;

    /* renamed from: b  reason: collision with root package name */
    public View f23816b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f23817c;

    /* renamed from: d  reason: collision with root package name */
    public int f23818d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f23819e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f23820f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23821g;

    /* renamed from: h  reason: collision with root package name */
    public String f23822h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23823i;

    /* renamed from: j  reason: collision with root package name */
    public View f23824j;
    public int k;
    public int l;
    public boolean m;
    public m n;
    public c.a.r0.q1.o.l.a o;
    public c.a.r0.q1.o.l.c p;
    public TbImageView.g q;
    public SeekBar.OnSeekBarChangeListener r;
    public VideoControllerView.d s;
    public View.OnClickListener t;
    public c.p u;
    public CyberPlayerManager.OnPreparedListener v;
    public VideoControllerView.c w;
    public a.h x;

    /* loaded from: classes3.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f23825a;

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
            this.f23825a = nVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f23825a.f23820f != null) {
                this.f23825a.f23820f.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23826e;

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
            this.f23826e = nVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f23826e.p.X();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || this.f23826e.p.a0() || this.f23826e.p.h0() == null) {
                return;
            }
            this.f23826e.p.D0(this.f23826e.p.h0().getSeekPosition());
            this.f23826e.p.O0(this.f23826e.f23822h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f23827a;

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
            this.f23827a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f23827a.r()) {
                return;
            }
            this.f23827a.p.i0(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23828e;

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
            this.f23828e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f23828e.r() && view.getId() == this.f23828e.f23816b.getId()) {
                if (!c.a.e.e.p.j.z()) {
                    c.a.e.e.p.l.J(this.f23828e.f23815a.getPageActivity(), this.f23828e.f23815a.getString(R.string.neterror));
                }
                if (this.f23828e.o == null || !this.f23828e.f23817c.isPlaying()) {
                    return;
                }
                this.f23828e.o.r();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f23829a;

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
            this.f23829a = nVar;
        }

        @Override // c.a.r0.q1.o.l.c.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.q1.o.l.c.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f23829a.o.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f23830e;

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
            this.f23830e = nVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23830e.f23817c == null) {
                return;
            }
            this.f23830e.o.r();
            if (this.f23830e.n == null || this.f23830e.n.e() == null || !this.f23830e.n.e().equals(this.f23830e.f23822h) || this.f23830e.n.f() <= 0) {
                if (this.f23830e.n == null || this.f23830e.n.g(this.f23830e.f23822h) <= 0) {
                    return;
                }
                this.f23830e.f23817c.seekTo(this.f23830e.n.g(this.f23830e.f23822h));
                return;
            }
            this.f23830e.f23817c.seekTo(this.f23830e.n.f());
            this.f23830e.n.o(null);
            this.f23830e.n.p(0);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f23831a;

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
            this.f23831a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23831a.r() || this.f23831a.o == null || this.f23831a.f23824j == null) {
                return;
            }
            if (this.f23831a.f23817c.isPlaying()) {
                this.f23831a.o.r();
            }
            if (this.f23831a.f23824j.getAlpha() != 1.0f) {
                this.f23831a.f23824j.setAlpha(1.0f);
            }
            this.f23831a.f23824j.clearAnimation();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f23832a;

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
            this.f23832a = nVar;
        }

        @Override // c.a.r0.q1.o.l.a.h
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23832a.p.a0()) {
                this.f23832a.p.l0();
            }
        }

        @Override // c.a.r0.q1.o.l.a.h
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f23832a.p.a0()) {
                this.f23832a.p.W();
            }
        }

        @Override // c.a.r0.q1.o.l.a.h
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f23832a.p.a0()) {
                this.f23832a.p.W();
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
        this.f23823i = false;
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
        this.x = new h(this);
        this.f23815a = tbPageContext;
        this.f23816b = view;
        view.setOnClickListener(this.t);
        c.a.r0.q1.o.l.c a2 = c.a.r0.q1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f23817c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f23816b.findViewById(R.id.video_thumbnail);
        this.f23820f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f23821g = (ImageView) this.f23816b.findViewById(R.id.img_play);
        this.f23824j = this.p.b0();
        this.k = c.a.e.e.p.l.k(this.f23815a.getPageActivity());
        this.l = c.a.e.e.p.l.i(this.f23815a.getPageActivity());
        this.n = c.a.r0.q1.o.l.d.c(this.f23815a);
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r()) {
                return 0;
            }
            return this.f23817c.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23818d : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23822h : (String) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23816b : (View) invokeV.objValue;
    }

    public final void o() {
        c.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.p) == null || this.f23817c == null || this.f23819e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f23816b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f23819e.f53867d);
        this.p.I0(this.f23819e.f53870g);
        this.p.J0(this.f23822h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f23823i : invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23816b == null || this.f23817c == null || this.f23820f == null || this.f23821g == null || this.f23824j == null || this.o == null : invokeV.booleanValue;
    }

    public void s(c.a.r0.q1.o.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.o = aVar;
            if (aVar != null) {
                aVar.t(this.x);
            }
        }
    }

    public void t(boolean z) {
        c.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.C0(z);
    }

    public void u(boolean z) {
        c.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.N0(z);
    }

    public void v() {
        c.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.m) {
            return;
        }
        int i2 = this.f23818d;
        if (i2 <= 0 || i2 == c.a.r0.q1.o.k.c.f23757a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!w.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f23822h);
        }
    }

    public void w() {
        c.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f23816b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.f23823i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i2) == null) {
            this.f23819e = aVar;
            this.f23818d = i2;
            if (r() || aVar == null) {
                return;
            }
            String str = this.f23822h;
            if (str == null || !str.equalsIgnoreCase(aVar.f53864a)) {
                w();
                this.f23822h = aVar.f53864a;
                this.f23820f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f23820f.startLoad(aVar.f53867d, 17, false);
                int i3 = aVar.f53868e;
                int i4 = aVar.f53869f;
                ViewGroup.LayoutParams layoutParams = this.f23816b.getLayoutParams();
                if (i3 > 0 && i4 > 0 && layoutParams != null && !aVar.f53871h) {
                    if (i3 > i4) {
                        layoutParams.height = ((this.k * 1) * i4) / i3;
                    } else {
                        layoutParams.height = this.k;
                    }
                    this.f23816b.setLayoutParams(layoutParams);
                    this.p.M0();
                } else if (layoutParams != null && aVar.f53871h) {
                    layoutParams.width = this.k;
                    layoutParams.height = this.l;
                    this.f23816b.setLayoutParams(layoutParams);
                    this.p.k0();
                }
                this.p.T();
            }
        }
    }

    public void y(String str, String str2) {
        c.a.r0.q1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.R0(str, str2);
    }
}
