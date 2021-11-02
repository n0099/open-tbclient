package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.m;
import b.a.r0.q2.f;
import b.a.r0.q2.o;
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
/* loaded from: classes6.dex */
public class VideoPasterContentView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VideoPasterOverlayView f34761e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f34762f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f34763g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f34764h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.q2.f f34765i;
    public i j;
    public boolean k;
    public m l;
    public boolean m;
    public int n;
    public int o;
    public b.a.f.m.e.a p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public int u;
    public Runnable v;

    /* loaded from: classes6.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34766e;

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
            this.f34766e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34766e.f34764h == null) {
                return;
            }
            if (!TextUtils.equals(this.f34766e.r, "NEWINDEX")) {
                this.f34766e.f34764h.setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                this.f34766e.f34764h.setVolume(0.0f, 0.0f);
            } else {
                this.f34766e.f34764h.setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = this.f34766e;
            videoPasterContentView.u = videoPasterContentView.f34764h.getDuration();
            if (this.f34766e.f34761e != null) {
                this.f34766e.f34761e.updateLayout(this.f34766e.f34764h.getVideoWidth(), this.f34766e.f34764h.getVideoHeight(), this.f34766e.r);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34767e;

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
            this.f34767e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34767e.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34768e;

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
            this.f34768e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f34768e.q();
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34769e;

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
            this.f34769e = videoPasterContentView;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34769e.m = false;
                this.f34769e.n = 100;
                b.a.e.e.m.e.a().removeCallbacks(this.f34769e.v);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34770a;

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
            this.f34770a = videoPasterContentView;
        }

        @Override // b.a.r0.q2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34771a;

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
            this.f34771a = videoPasterContentView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((f) aVar, str, i2);
                if (aVar == null || aVar.p() == null || this.f34771a.f34761e == null) {
                    return;
                }
                this.f34771a.f34761e.updateLayout(aVar.r(), aVar.m(), this.f34771a.r);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34772e;

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
            this.f34772e = videoPasterContentView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.e.e.m.e.a().removeCallbacks(this.f34772e.v);
                if (this.f34772e.m) {
                    return;
                }
                boolean z = this.f34772e.f34764h.getCurrentPositionSync() == 0 && this.f34772e.n == 100;
                if (this.f34772e.f34764h.getCurrentPositionSync() > this.f34772e.n) {
                    this.f34772e.o();
                } else if (z) {
                    b.a.e.e.m.e.a().postDelayed(this.f34772e.v, 20L);
                } else {
                    this.f34772e.o();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f34773a;

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
            this.f34773a = videoPasterContentView;
        }

        @Override // b.a.q0.d1.m.b
        public void onCountDown(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f34773a.q = (int) (j2 / 1000);
                if (this.f34773a.f34761e != null) {
                    this.f34773a.f34761e.setCountDownNum((int) this.f34773a.q);
                }
                if (this.f34773a.q == 0) {
                    this.f34773a.q();
                    this.f34773a.l.s();
                }
            }
        }

        @Override // b.a.q0.d1.m.b
        public void onCountDownFinish(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f34773a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    public int getCurDuration() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.p == null || (mVar = this.l) == null) {
                return 0;
            }
            return ((int) mVar.n()) / 1000;
        }
        return invokeV.intValue;
    }

    public int getTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.f.m.e.a aVar = this.p;
            if (aVar == null) {
                return -1;
            }
            return aVar.j;
        }
        return invokeV.intValue;
    }

    public boolean isAdAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean isAdShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean isCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean isVideoPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f34764h;
            return tbCyberVideoView != null && tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.m) {
            return;
        }
        this.m = true;
        this.f34763g.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            i iVar = this.j;
            if (iVar != null) {
                iVar.onDetachedFromWindow();
            }
        }
    }

    public void onEnterFullScreen() {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (videoPasterOverlayView = this.f34761e) == null) {
            return;
        }
        videoPasterOverlayView.onEnterFullScreen();
    }

    public void onExitFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            VideoPasterOverlayView videoPasterOverlayView = this.f34761e;
            if (videoPasterOverlayView != null) {
                videoPasterOverlayView.onExitFullScreen();
            }
            b.a.f.m.e.a aVar = this.p;
            if (aVar != null && aVar.d() && !this.p.c() && this.k && this.p.a() == 1) {
                this.f34763g.setVisibility(0);
                int c2 = o.d().c(this.p.l);
                this.o = c2;
                this.n = (c2 <= 100 || this.u <= c2) ? 100 : 100;
                b.a.e.e.m.e.a().removeCallbacks(this.v);
                b.a.e.e.m.e.a().postDelayed(this.v, 20L);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f34761e = new VideoPasterOverlayView(getContext());
            this.f34762f = new TbImageView(getContext());
            this.f34763g = new TbImageView(getContext());
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.f34764h = tbCyberVideoView;
            tbCyberVideoView.setStageType(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            setBackgroundResource(R.color.black_alpha100);
            this.f34764h.setContinuePlayEnable(true);
            this.f34764h.setOnPreparedListener(new a(this));
            this.f34764h.setOnCompletionListener(new b(this));
            this.f34764h.setOnErrorListener(new c(this));
            this.f34764h.setOnSurfaceDestroyedListener(new d(this));
            b.a.r0.q2.f fVar = new b.a.r0.q2.f();
            this.f34765i = fVar;
            fVar.l(this.f34764h);
            this.f34765i.i(new e(this));
            setBackgroundColor(-16777216);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
            b.a.e.e.m.e.a().removeCallbacks(this.v);
        }
    }

    public final void r() {
        b.a.f.m.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (aVar = this.p) != null && aVar.a() == 1) {
            o.d().e(this.p.l);
            TbCyberVideoView tbCyberVideoView = this.f34764h;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.seekTo(0);
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            r();
            stop();
            this.f34761e.reset();
            this.k = false;
            this.p = null;
            this.q = 0L;
            this.m = false;
            this.n = 100;
            b.a.e.e.m.e.a().removeCallbacks(this.v);
        }
    }

    public void responseBackkeyDown(int i2) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (videoPasterOverlayView = this.f34761e) == null) {
            return;
        }
        videoPasterOverlayView.responseBackkeyDown(i2);
    }

    public void resume() {
        b.a.f.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (aVar = this.p) == null) {
            return;
        }
        if (aVar.a() == 0) {
            m mVar = this.l;
            if (mVar != null) {
                mVar.p();
            }
        } else if (this.p.a() == 1) {
            this.f34763g.setVisibility(0);
            this.f34764h.setVideoPath(this.p.l);
            this.f34764h.start();
            b.a.r0.q2.f fVar = this.f34765i;
            if (fVar != null) {
                fVar.m();
            }
            m mVar2 = this.l;
            if (mVar2 != null) {
                mVar2.p();
            }
            int i2 = 100;
            if (this.k) {
                int c2 = o.d().c(this.p.l);
                this.o = c2;
                if (c2 > 100 && this.u > c2) {
                    i2 = c2;
                }
                this.n = i2;
            } else {
                this.n = 100;
            }
            b.a.e.e.m.e.a().removeCallbacks(this.v);
            b.a.e.e.m.e.a().postDelayed(this.v, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f34761e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.resume();
        }
        this.s = true;
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            m mVar = this.l;
            if (mVar != null) {
                mVar.s();
                this.l.q(null);
            }
            m mVar2 = new m(i2 * 1000, 1000L);
            this.l = mVar2;
            mVar2.q(new h(this));
            this.l.r();
            this.t = false;
        }
    }

    public void setContentViewCallback(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iVar) == null) {
            this.j = iVar;
        }
    }

    public void setData(b.a.f.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) || (videoPasterOverlayView = this.f34761e) == null) {
            return;
        }
        videoPasterOverlayView.setOverlayViewCallback(bVar);
    }

    public void showVideoCover() {
        b.a.f.m.e.a aVar;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.p) == null || aVar.a() != 1 || (tbImageView = this.f34763g) == null) {
            return;
        }
        tbImageView.setVisibility(0);
    }

    public void stop() {
        b.a.f.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (aVar = this.p) == null) {
            return;
        }
        if (aVar.a() == 0) {
            m mVar = this.l;
            if (mVar != null) {
                mVar.o();
            }
        } else if (this.p.a() == 1) {
            this.f34763g.setVisibility(0);
            this.f34764h.stopPlayback();
            b.a.r0.q2.f fVar = this.f34765i;
            if (fVar != null) {
                fVar.n();
            }
            m mVar2 = this.l;
            if (mVar2 != null) {
                mVar2.o();
            }
            b.a.e.e.m.e.a().removeCallbacks(this.v);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f34761e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.stop();
        }
        this.s = false;
        this.m = false;
    }

    public void updateByData(boolean z, boolean z2, String str) {
        b.a.f.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (aVar = this.p) == null || !aVar.d() || this.p.c()) {
            return;
        }
        this.f34761e.updateByData(this.p, z, z2);
        if (this.k) {
            return;
        }
        if (this.p.a() == 0) {
            this.f34761e.setCountDownNum(this.p.j);
            s(this.p.j);
        } else if (this.p.a() == 1) {
            this.f34761e.setCountDownNum(this.p.j);
            s(this.p.j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.r = str;
        if (this.p.a() == 0) {
            removeAllViews();
            addView(this.f34762f);
            addView(this.f34761e.getRootView(), layoutParams);
            this.f34762f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            b.a.e.e.l.d.h().m(this.p.k, 10, new f(this), null);
            this.f34762f.startLoad(this.p.k, 10, false);
        } else if (this.p.a() == 1) {
            r();
            removeAllViews();
            addView(this.f34764h.getView());
            addView(this.f34763g);
            addView(this.f34761e.getRootView(), layoutParams);
            this.f34763g.startLoad(this.p.m, 10, false);
            this.f34764h.setVideoPath(this.p.l);
            this.f34764h.start();
            b.a.e.e.m.e.a().removeCallbacks(this.v);
            b.a.e.e.m.e.a().postDelayed(this.v, 20L);
        }
        this.k = true;
        this.s = true;
    }
}
