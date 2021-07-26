package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.j;
import d.a.q0.n2.f;
import d.a.q0.n2.n;
/* loaded from: classes.dex */
public class VideoPasterContentView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VideoPasterOverlayView f2562e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f2563f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f2564g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f2565h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.n2.f f2566i;
    public i j;
    public boolean k;
    public j l;
    public boolean m;
    public int n;
    public int o;
    public d.a.e.m.e.a p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public int u;
    public Runnable v;

    /* loaded from: classes.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2567e;

        public a(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2567e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f2567e.f2565h == null) {
                return;
            }
            if (!TextUtils.equals(this.f2567e.r, "NEWINDEX")) {
                this.f2567e.f2565h.setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                this.f2567e.f2565h.setVolume(0.0f, 0.0f);
            } else {
                this.f2567e.f2565h.setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = this.f2567e;
            videoPasterContentView.u = videoPasterContentView.f2565h.getDuration();
            if (this.f2567e.f2562e != null) {
                this.f2567e.f2562e.o(this.f2567e.f2565h.getVideoWidth(), this.f2567e.f2565h.getVideoHeight(), this.f2567e.r);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2568e;

        public b(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2568e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2568e.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2569e;

        public c(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2569e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f2569e.u();
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2570e;

        public d(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2570e = videoPasterContentView;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2570e.m = false;
                this.f2570e.n = 100;
                d.a.d.e.m.e.a().removeCallbacks(this.f2570e.v);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2571a;

        public e(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2571a = videoPasterContentView;
        }

        @Override // d.a.q0.n2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2572a;

        public f(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2572a = videoPasterContentView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((f) aVar, str, i2);
                if (aVar == null || aVar.p() == null || this.f2572a.f2562e == null) {
                    return;
                }
                this.f2572a.f2562e.o(aVar.r(), aVar.m(), this.f2572a.r);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2573e;

        public g(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2573e = videoPasterContentView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.d.e.m.e.a().removeCallbacks(this.f2573e.v);
                if (this.f2573e.m) {
                    return;
                }
                boolean z = this.f2573e.f2565h.getCurrentPositionSync() == 0 && this.f2573e.n == 100;
                if (this.f2573e.f2565h.getCurrentPositionSync() > this.f2573e.n) {
                    this.f2573e.o();
                } else if (z) {
                    d.a.d.e.m.e.a().postDelayed(this.f2573e.v, 20L);
                } else {
                    this.f2573e.o();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f2574a;

        public h(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2574a = videoPasterContentView;
        }

        @Override // d.a.p0.b1.j.b
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f2574a.q = (int) (j2 / 1000);
                if (this.f2574a.f2562e != null) {
                    this.f2574a.f2562e.setCountDownNum((int) this.f2574a.q);
                }
                if (this.f2574a.q == 0) {
                    this.f2574a.u();
                    this.f2574a.l.s();
                }
            }
        }

        @Override // d.a.p0.b1.j.b
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f2574a.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a();

        void onDetachedFromWindow();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPasterContentView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.m = false;
        this.n = 100;
        this.o = 0;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = new g(this);
        p();
    }

    public void A() {
        d.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.p) == null) {
            return;
        }
        if (aVar.a() == 0) {
            j jVar = this.l;
            if (jVar != null) {
                jVar.p();
            }
        } else if (this.p.a() == 1) {
            this.f2564g.setVisibility(0);
            this.f2565h.setVideoPath(this.p.l);
            this.f2565h.start();
            d.a.q0.n2.f fVar = this.f2566i;
            if (fVar != null) {
                fVar.m();
            }
            j jVar2 = this.l;
            if (jVar2 != null) {
                jVar2.p();
            }
            int i2 = 100;
            if (this.k) {
                int c2 = n.d().c(this.p.l);
                this.o = c2;
                if (c2 > 100 && this.u > c2) {
                    i2 = c2;
                }
                this.n = i2;
            } else {
                this.n = 100;
            }
            d.a.d.e.m.e.a().removeCallbacks(this.v);
            d.a.d.e.m.e.a().postDelayed(this.v, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f2562e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.l();
        }
        this.s = true;
    }

    public void B() {
        d.a.e.m.e.a aVar;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.p) == null || aVar.a() != 1 || (tbImageView = this.f2564g) == null) {
            return;
        }
        tbImageView.setVisibility(0);
    }

    public final void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            j jVar = this.l;
            if (jVar != null) {
                jVar.s();
                this.l.q(null);
            }
            j jVar2 = new j(i2 * 1000, 1000L);
            this.l = jVar2;
            jVar2.q(new h(this));
            this.l.r();
            this.t = false;
        }
    }

    public void D() {
        d.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.p) == null) {
            return;
        }
        if (aVar.a() == 0) {
            j jVar = this.l;
            if (jVar != null) {
                jVar.o();
            }
        } else if (this.p.a() == 1) {
            this.f2564g.setVisibility(0);
            this.f2565h.stopPlayback();
            d.a.q0.n2.f fVar = this.f2566i;
            if (fVar != null) {
                fVar.n();
            }
            j jVar2 = this.l;
            if (jVar2 != null) {
                jVar2.o();
            }
            d.a.d.e.m.e.a().removeCallbacks(this.v);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f2562e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.m();
        }
        this.s = false;
        this.m = false;
    }

    public void E(boolean z, boolean z2, String str) {
        d.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (aVar = this.p) == null || !aVar.d() || this.p.c()) {
            return;
        }
        this.f2562e.n(this.p, z, z2);
        if (this.k) {
            return;
        }
        if (this.p.a() == 0) {
            this.f2562e.setCountDownNum(this.p.j);
            C(this.p.j);
        } else if (this.p.a() == 1) {
            this.f2562e.setCountDownNum(this.p.j);
            C(this.p.j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.r = str;
        if (this.p.a() == 0) {
            removeAllViews();
            addView(this.f2563f);
            addView(this.f2562e.getRootView(), layoutParams);
            this.f2563f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            d.a.d.e.l.d.h().m(this.p.k, 10, new f(this), null);
            this.f2563f.M(this.p.k, 10, false);
        } else if (this.p.a() == 1) {
            y();
            removeAllViews();
            addView(this.f2565h.getView());
            addView(this.f2564g);
            addView(this.f2562e.getRootView(), layoutParams);
            this.f2564g.M(this.p.m, 10, false);
            this.f2565h.setVideoPath(this.p.l);
            this.f2565h.start();
            d.a.d.e.m.e.a().removeCallbacks(this.v);
            d.a.d.e.m.e.a().postDelayed(this.v, 20L);
        }
        this.k = true;
        this.s = true;
    }

    public int getCurDuration() {
        InterceptResult invokeV;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.p == null || (jVar = this.l) == null) {
                return 0;
            }
            return ((int) jVar.n()) / 1000;
        }
        return invokeV.intValue;
    }

    public int getTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.e.m.e.a aVar = this.p;
            if (aVar == null) {
                return -1;
            }
            return aVar.j;
        }
        return invokeV.intValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.m) {
            return;
        }
        this.m = true;
        this.f2564g.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            i iVar = this.j;
            if (iVar != null) {
                iVar.onDetachedFromWindow();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f2562e = new VideoPasterOverlayView(getContext());
            this.f2563f = new TbImageView(getContext());
            this.f2564g = new TbImageView(getContext());
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.f2565h = tbCyberVideoView;
            tbCyberVideoView.setStageType(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            setBackgroundResource(R.color.black_alpha100);
            this.f2565h.setContinuePlayEnable(true);
            this.f2565h.setOnPreparedListener(new a(this));
            this.f2565h.setOnCompletionListener(new b(this));
            this.f2565h.setOnErrorListener(new c(this));
            this.f2565h.setOnSurfaceDestroyedListener(new d(this));
            d.a.q0.n2.f fVar = new d.a.q0.n2.f();
            this.f2566i = fVar;
            fVar.l(this.f2565h);
            this.f2566i.i(new e(this));
            setBackgroundColor(-16777216);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void setContentViewCallback(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iVar) == null) {
            this.j = iVar;
        }
    }

    public void setData(d.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) || (videoPasterOverlayView = this.f2562e) == null) {
            return;
        }
        videoPasterOverlayView.setOverlayViewCallback(bVar);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f2565h;
            return tbCyberVideoView != null && tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = true;
            i iVar = this.j;
            if (iVar != null) {
                iVar.a();
            }
            removeAllViews();
            this.p = null;
            this.q = 0L;
            this.k = false;
            this.s = false;
            this.m = false;
            this.n = 100;
            d.a.d.e.m.e.a().removeCallbacks(this.v);
        }
    }

    public void v() {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (videoPasterOverlayView = this.f2562e) == null) {
            return;
        }
        videoPasterOverlayView.g();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VideoPasterOverlayView videoPasterOverlayView = this.f2562e;
            if (videoPasterOverlayView != null) {
                videoPasterOverlayView.h();
            }
            d.a.e.m.e.a aVar = this.p;
            if (aVar != null && aVar.d() && !this.p.c() && this.k && this.p.a() == 1) {
                this.f2564g.setVisibility(0);
                int c2 = n.d().c(this.p.l);
                this.o = c2;
                this.n = (c2 <= 100 || this.u <= c2) ? 100 : 100;
                d.a.d.e.m.e.a().removeCallbacks(this.v);
                d.a.d.e.m.e.a().postDelayed(this.v, 20L);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            y();
            D();
            this.f2562e.i();
            this.k = false;
            this.p = null;
            this.q = 0L;
            this.m = false;
            this.n = 100;
            d.a.d.e.m.e.a().removeCallbacks(this.v);
        }
    }

    public final void y() {
        d.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (aVar = this.p) != null && aVar.a() == 1) {
            n.d().e(this.p.l);
            TbCyberVideoView tbCyberVideoView = this.f2565h;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.seekTo(0);
            }
        }
    }

    public void z(int i2) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (videoPasterOverlayView = this.f2562e) == null) {
            return;
        }
        videoPasterOverlayView.k(i2);
    }
}
