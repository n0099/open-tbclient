package c.a.r0.w1.o.l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.t3.w;
import c.a.r0.w1.o.l.a;
import c.a.r0.w1.o.l.c;
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
/* loaded from: classes7.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f25146b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f25147c;

    /* renamed from: d  reason: collision with root package name */
    public int f25148d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f25149e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f25150f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f25151g;

    /* renamed from: h  reason: collision with root package name */
    public String f25152h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25153i;

    /* renamed from: j  reason: collision with root package name */
    public View f25154j;

    /* renamed from: k  reason: collision with root package name */
    public int f25155k;
    public int l;
    public boolean m;
    public m n;
    public c.a.r0.w1.o.l.a o;
    public c.a.r0.w1.o.l.c p;
    public TbImageView.g q;
    public SeekBar.OnSeekBarChangeListener r;
    public VideoControllerView.d s;
    public View.OnClickListener t;
    public c.p u;
    public CyberPlayerManager.OnPreparedListener v;
    public VideoControllerView.c w;
    public a.h x;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

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
            this.a = nVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.f25150f != null) {
                this.a.f25150f.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f25156e;

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
            this.f25156e = nVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f25156e.p.X();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || this.f25156e.p.a0() || this.f25156e.p.h0() == null) {
                return;
            }
            this.f25156e.p.D0(this.f25156e.p.h0().getSeekPosition());
            this.f25156e.p.O0(this.f25156e.f25152h);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

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
            this.a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.r()) {
                return;
            }
            this.a.p.i0(i2);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f25157e;

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
            this.f25157e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f25157e.r() && view.getId() == this.f25157e.f25146b.getId()) {
                if (!c.a.d.f.p.j.z()) {
                    c.a.d.f.p.l.J(this.f25157e.a.getPageActivity(), this.f25157e.a.getString(R.string.neterror));
                }
                if (this.f25157e.o == null || !this.f25157e.f25147c.isPlaying()) {
                    return;
                }
                this.f25157e.o.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

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
            this.a = nVar;
        }

        @Override // c.a.r0.w1.o.l.c.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.w1.o.l.c.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o.l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f25158e;

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
            this.f25158e = nVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25158e.f25147c == null) {
                return;
            }
            this.f25158e.o.r();
            if (this.f25158e.n == null || this.f25158e.n.e() == null || !this.f25158e.n.e().equals(this.f25158e.f25152h) || this.f25158e.n.f() <= 0) {
                if (this.f25158e.n == null || this.f25158e.n.g(this.f25158e.f25152h) <= 0) {
                    return;
                }
                this.f25158e.f25147c.seekTo(this.f25158e.n.g(this.f25158e.f25152h));
                return;
            }
            this.f25158e.f25147c.seekTo(this.f25158e.n.f());
            this.f25158e.n.o(null);
            this.f25158e.n.p(0);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

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
            this.a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.r() || this.a.o == null || this.a.f25154j == null) {
                return;
            }
            if (this.a.f25147c.isPlaying()) {
                this.a.o.r();
            }
            if (this.a.f25154j.getAlpha() != 1.0f) {
                this.a.f25154j.setAlpha(1.0f);
            }
            this.a.f25154j.clearAnimation();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

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
            this.a = nVar;
        }

        @Override // c.a.r0.w1.o.l.a.h
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p.a0()) {
                this.a.p.l0();
            }
        }

        @Override // c.a.r0.w1.o.l.a.h
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.p.a0()) {
                this.a.p.W();
            }
        }

        @Override // c.a.r0.w1.o.l.a.h
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.p.a0()) {
                this.a.p.W();
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
        this.f25153i = false;
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
        this.x = new h(this);
        this.a = tbPageContext;
        this.f25146b = view;
        view.setOnClickListener(this.t);
        c.a.r0.w1.o.l.c a2 = c.a.r0.w1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f25147c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f25146b.findViewById(R.id.video_thumbnail);
        this.f25150f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f25151g = (ImageView) this.f25146b.findViewById(R.id.img_play);
        this.f25154j = this.p.b0();
        this.f25155k = c.a.d.f.p.l.k(this.a.getPageActivity());
        this.l = c.a.d.f.p.l.i(this.a.getPageActivity());
        this.n = c.a.r0.w1.o.l.d.c(this.a);
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r()) {
                return 0;
            }
            return this.f25147c.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25148d : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25152h : (String) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25146b : (View) invokeV.objValue;
    }

    public final void o() {
        c.a.r0.w1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.p) == null || this.f25147c == null || this.f25149e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f25146b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f25149e.f46545d);
        this.p.I0(this.f25149e.f46548g);
        this.p.J0(this.f25152h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f25153i : invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25146b == null || this.f25147c == null || this.f25150f == null || this.f25151g == null || this.f25154j == null || this.o == null : invokeV.booleanValue;
    }

    public void s(c.a.r0.w1.o.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.o = aVar;
            if (aVar != null) {
                aVar.t(this.x);
            }
        }
    }

    public void t(boolean z) {
        c.a.r0.w1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.C0(z);
    }

    public void u(boolean z) {
        c.a.r0.w1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.N0(z);
    }

    public void v() {
        c.a.r0.w1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.m) {
            return;
        }
        int i2 = this.f25148d;
        if (i2 <= 0 || i2 == c.a.r0.w1.o.k.c.a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!w.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f25152h);
        }
    }

    public void w() {
        c.a.r0.w1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f25146b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.f25153i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i2) == null) {
            this.f25149e = aVar;
            this.f25148d = i2;
            if (r() || aVar == null) {
                return;
            }
            String str = this.f25152h;
            if (str == null || !str.equalsIgnoreCase(aVar.a)) {
                w();
                this.f25152h = aVar.a;
                this.f25150f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f25150f.startLoad(aVar.f46545d, 17, false);
                int i3 = aVar.f46546e;
                int i4 = aVar.f46547f;
                ViewGroup.LayoutParams layoutParams = this.f25146b.getLayoutParams();
                if (i3 > 0 && i4 > 0 && layoutParams != null && !aVar.f46549h) {
                    if (i3 > i4) {
                        layoutParams.height = ((this.f25155k * 1) * i4) / i3;
                    } else {
                        layoutParams.height = this.f25155k;
                    }
                    this.f25146b.setLayoutParams(layoutParams);
                    this.p.M0();
                } else if (layoutParams != null && aVar.f46549h) {
                    layoutParams.width = this.f25155k;
                    layoutParams.height = this.l;
                    this.f25146b.setLayoutParams(layoutParams);
                    this.p.k0();
                }
                this.p.T();
            }
        }
    }

    public void y(String str, String str2) {
        c.a.r0.w1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.R0(str, str2);
    }
}
