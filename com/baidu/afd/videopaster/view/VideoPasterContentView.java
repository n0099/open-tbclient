package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.m;
import c.a.r0.q2.f;
import c.a.r0.q2.n;
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
/* loaded from: classes4.dex */
public class VideoPasterContentView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VideoPasterOverlayView f36707e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f36708f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f36709g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f36710h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.q2.f f36711i;

    /* renamed from: j  reason: collision with root package name */
    public i f36712j;
    public boolean k;
    public m l;
    public boolean m;
    public int n;
    public int o;
    public c.a.f.m.e.a p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public int u;
    public Runnable v;

    /* loaded from: classes4.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36713e;

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
            this.f36713e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36713e.f36710h == null) {
                return;
            }
            if (!TextUtils.equals(this.f36713e.r, "NEWINDEX")) {
                this.f36713e.f36710h.setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                this.f36713e.f36710h.setVolume(0.0f, 0.0f);
            } else {
                this.f36713e.f36710h.setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = this.f36713e;
            videoPasterContentView.u = videoPasterContentView.f36710h.getDuration();
            if (this.f36713e.f36707e != null) {
                this.f36713e.f36707e.updateLayout(this.f36713e.f36710h.getVideoWidth(), this.f36713e.f36710h.getVideoHeight(), this.f36713e.r);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36714e;

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
            this.f36714e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36714e.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36715e;

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
            this.f36715e = videoPasterContentView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f36715e.q();
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36716e;

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
            this.f36716e = videoPasterContentView;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36716e.m = false;
                this.f36716e.n = 100;
                c.a.e.e.m.e.a().removeCallbacks(this.f36716e.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36717a;

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
            this.f36717a = videoPasterContentView;
        }

        @Override // c.a.r0.q2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36718a;

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
            this.f36718a = videoPasterContentView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((f) aVar, str, i2);
                if (aVar == null || aVar.p() == null || this.f36718a.f36707e == null) {
                    return;
                }
                this.f36718a.f36707e.updateLayout(aVar.r(), aVar.m(), this.f36718a.r);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36719e;

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
            this.f36719e = videoPasterContentView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f36719e.v);
                if (this.f36719e.m) {
                    return;
                }
                boolean z = this.f36719e.f36710h.getCurrentPositionSync() == 0 && this.f36719e.n == 100;
                if (this.f36719e.f36710h.getCurrentPositionSync() > this.f36719e.n) {
                    this.f36719e.o();
                } else if (z) {
                    c.a.e.e.m.e.a().postDelayed(this.f36719e.v, 20L);
                } else {
                    this.f36719e.o();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f36720a;

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
            this.f36720a = videoPasterContentView;
        }

        @Override // c.a.q0.d1.m.b
        public void onCountDown(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.f36720a.q = (int) (j3 / 1000);
                if (this.f36720a.f36707e != null) {
                    this.f36720a.f36707e.setCountDownNum((int) this.f36720a.q);
                }
                if (this.f36720a.q == 0) {
                    this.f36720a.q();
                    this.f36720a.l.s();
                }
            }
        }

        @Override // c.a.q0.d1.m.b
        public void onCountDownFinish(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f36720a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            c.a.f.m.e.a aVar = this.p;
            if (aVar == null) {
                return -1;
            }
            return aVar.f3315j;
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
            TbCyberVideoView tbCyberVideoView = this.f36710h;
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
        this.f36709g.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            i iVar = this.f36712j;
            if (iVar != null) {
                iVar.onDetachedFromWindow();
            }
        }
    }

    public void onEnterFullScreen() {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (videoPasterOverlayView = this.f36707e) == null) {
            return;
        }
        videoPasterOverlayView.onEnterFullScreen();
    }

    public void onExitFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            VideoPasterOverlayView videoPasterOverlayView = this.f36707e;
            if (videoPasterOverlayView != null) {
                videoPasterOverlayView.onExitFullScreen();
            }
            c.a.f.m.e.a aVar = this.p;
            if (aVar != null && aVar.d() && !this.p.c() && this.k && this.p.a() == 1) {
                this.f36709g.setVisibility(0);
                int c2 = n.d().c(this.p.l);
                this.o = c2;
                this.n = (c2 <= 100 || this.u <= c2) ? 100 : 100;
                c.a.e.e.m.e.a().removeCallbacks(this.v);
                c.a.e.e.m.e.a().postDelayed(this.v, 20L);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f36707e = new VideoPasterOverlayView(getContext());
            this.f36708f = new TbImageView(getContext());
            this.f36709g = new TbImageView(getContext());
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.f36710h = tbCyberVideoView;
            tbCyberVideoView.setStageType(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            setBackgroundResource(R.color.black_alpha100);
            this.f36710h.setContinuePlayEnable(true);
            this.f36710h.setOnPreparedListener(new a(this));
            this.f36710h.setOnCompletionListener(new b(this));
            this.f36710h.setOnErrorListener(new c(this));
            this.f36710h.setOnSurfaceDestroyedListener(new d(this));
            c.a.r0.q2.f fVar = new c.a.r0.q2.f();
            this.f36711i = fVar;
            fVar.l(this.f36710h);
            this.f36711i.i(new e(this));
            setBackgroundColor(-16777216);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.t = true;
            i iVar = this.f36712j;
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
            c.a.e.e.m.e.a().removeCallbacks(this.v);
        }
    }

    public final void r() {
        c.a.f.m.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (aVar = this.p) != null && aVar.a() == 1) {
            n.d().e(this.p.l);
            TbCyberVideoView tbCyberVideoView = this.f36710h;
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
            this.f36707e.reset();
            this.k = false;
            this.p = null;
            this.q = 0L;
            this.m = false;
            this.n = 100;
            c.a.e.e.m.e.a().removeCallbacks(this.v);
        }
    }

    public void responseBackkeyDown(int i2) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (videoPasterOverlayView = this.f36707e) == null) {
            return;
        }
        videoPasterOverlayView.responseBackkeyDown(i2);
    }

    public void resume() {
        c.a.f.m.e.a aVar;
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
            this.f36709g.setVisibility(0);
            this.f36710h.setVideoPath(this.p.l);
            this.f36710h.start();
            c.a.r0.q2.f fVar = this.f36711i;
            if (fVar != null) {
                fVar.m();
            }
            m mVar2 = this.l;
            if (mVar2 != null) {
                mVar2.p();
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
            c.a.e.e.m.e.a().removeCallbacks(this.v);
            c.a.e.e.m.e.a().postDelayed(this.v, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f36707e;
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
            this.f36712j = iVar;
        }
    }

    public void setData(c.a.f.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) || (videoPasterOverlayView = this.f36707e) == null) {
            return;
        }
        videoPasterOverlayView.setOverlayViewCallback(bVar);
    }

    public void showVideoCover() {
        c.a.f.m.e.a aVar;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.p) == null || aVar.a() != 1 || (tbImageView = this.f36709g) == null) {
            return;
        }
        tbImageView.setVisibility(0);
    }

    public void stop() {
        c.a.f.m.e.a aVar;
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
            this.f36709g.setVisibility(0);
            this.f36710h.stopPlayback();
            c.a.r0.q2.f fVar = this.f36711i;
            if (fVar != null) {
                fVar.n();
            }
            m mVar2 = this.l;
            if (mVar2 != null) {
                mVar2.o();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.v);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f36707e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.stop();
        }
        this.s = false;
        this.m = false;
    }

    public void updateByData(boolean z, boolean z2, String str) {
        c.a.f.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (aVar = this.p) == null || !aVar.d() || this.p.c()) {
            return;
        }
        this.f36707e.updateByData(this.p, z, z2);
        if (this.k) {
            return;
        }
        if (this.p.a() == 0) {
            this.f36707e.setCountDownNum(this.p.f3315j);
            s(this.p.f3315j);
        } else if (this.p.a() == 1) {
            this.f36707e.setCountDownNum(this.p.f3315j);
            s(this.p.f3315j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.r = str;
        if (this.p.a() == 0) {
            removeAllViews();
            addView(this.f36708f);
            addView(this.f36707e.getRootView(), layoutParams);
            this.f36708f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            c.a.e.e.l.d.h().m(this.p.k, 10, new f(this), null);
            this.f36708f.startLoad(this.p.k, 10, false);
        } else if (this.p.a() == 1) {
            r();
            removeAllViews();
            addView(this.f36710h.getView());
            addView(this.f36709g);
            addView(this.f36707e.getRootView(), layoutParams);
            this.f36709g.startLoad(this.p.m, 10, false);
            this.f36710h.setVideoPath(this.p.l);
            this.f36710h.start();
            c.a.e.e.m.e.a().removeCallbacks(this.v);
            c.a.e.e.m.e.a().postDelayed(this.v, 20L);
        }
        this.k = true;
        this.s = true;
    }
}
