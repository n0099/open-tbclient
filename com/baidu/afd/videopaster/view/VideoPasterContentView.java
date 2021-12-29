package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.o;
import c.a.s0.s.q.d2;
import c.a.t0.z2.h;
import c.a.t0.z2.r;
import c.a.t0.z2.s;
import c.a.t0.z2.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoPasterContentView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VideoPasterOverlayView f32535e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f32536f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f32537g;

    /* renamed from: h  reason: collision with root package name */
    public TbVideoViewContainer f32538h;

    /* renamed from: i  reason: collision with root package name */
    public h f32539i;

    /* renamed from: j  reason: collision with root package name */
    public g f32540j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f32541k;
    public o l;
    public boolean m;
    public int n;
    public int o;
    public c.a.e.m.e.a p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public int u;
    public Runnable v;

    /* loaded from: classes9.dex */
    public class a implements c.a.t0.z2.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f32542e;

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
            this.f32542e = videoPasterContentView;
        }

        @Override // c.a.t0.z2.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.t0.z2.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f32542e.q();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                this.f32542e.q();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f32542e.f32538h == null) {
                return;
            }
            if (!TextUtils.equals(this.f32542e.r, "NEWINDEX")) {
                this.f32542e.f32538h.getControl().setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                this.f32542e.f32538h.getControl().setVolume(0.0f, 0.0f);
            } else {
                this.f32542e.f32538h.getControl().setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = this.f32542e;
            videoPasterContentView.u = videoPasterContentView.f32538h.getControl().getDuration();
            if (this.f32542e.f32535e != null) {
                this.f32542e.f32535e.updateLayout(this.f32542e.f32538h.getControl().getVideoWidth(), this.f32542e.f32538h.getControl().getVideoHeight(), this.f32542e.r);
            }
        }

        @Override // c.a.t0.z2.v.a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setData(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setStatistic(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f32543e;

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
            this.f32543e = videoPasterContentView;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32543e.m = false;
                this.f32543e.n = 100;
                c.a.d.f.m.e.a().removeCallbacks(this.f32543e.v);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPasterContentView a;

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
            this.a = videoPasterContentView;
        }

        @Override // c.a.t0.z2.h.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPasterContentView a;

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
            this.a = videoPasterContentView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((d) aVar, str, i2);
                if (aVar == null || aVar.p() == null || this.a.f32535e == null) {
                    return;
                }
                this.a.f32535e.updateLayout(aVar.r(), aVar.m(), this.a.r);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPasterContentView f32544e;

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
            this.f32544e = videoPasterContentView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f32544e.v);
                if (this.f32544e.m) {
                    return;
                }
                boolean z = this.f32544e.f32538h.getControl().getCurrentPositionSync() == 0 && this.f32544e.n == 100;
                if (this.f32544e.f32538h.getControl().getCurrentPositionSync() > this.f32544e.n) {
                    this.f32544e.o();
                } else if (z) {
                    c.a.d.f.m.e.a().postDelayed(this.f32544e.v, 20L);
                } else {
                    this.f32544e.o();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements o.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPasterContentView a;

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
            this.a = videoPasterContentView;
        }

        @Override // c.a.s0.e1.o.b
        public void onCountDown(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.a.q = (int) (j3 / 1000);
                if (this.a.f32535e != null) {
                    this.a.f32535e.setCountDownNum((int) this.a.q);
                }
                if (this.a.q == 0) {
                    this.a.q();
                    this.a.l.s();
                }
            }
        }

        @Override // c.a.s0.e1.o.b
        public void onCountDownFinish(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface g {
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
        this.f32541k = false;
        this.m = false;
        this.n = 100;
        this.o = 0;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = new e(this);
        p();
    }

    public int getCurDuration() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.p == null || (oVar = this.l) == null) {
                return 0;
            }
            return ((int) oVar.n()) / 1000;
        }
        return invokeV.intValue;
    }

    public int getTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.e.m.e.a aVar = this.p;
            if (aVar == null) {
                return -1;
            }
            return aVar.f3512j;
        }
        return invokeV.intValue;
    }

    public boolean isAdAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32541k : invokeV.booleanValue;
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
            TbVideoViewContainer tbVideoViewContainer = this.f32538h;
            return (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.f32538h.getControl().isPlaying()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.m) {
            return;
        }
        this.m = true;
        this.f32537g.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            g gVar = this.f32540j;
            if (gVar != null) {
                gVar.onDetachedFromWindow();
            }
        }
    }

    public void onEnterFullScreen() {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (videoPasterOverlayView = this.f32535e) == null) {
            return;
        }
        videoPasterOverlayView.onEnterFullScreen();
    }

    public void onExitFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            VideoPasterOverlayView videoPasterOverlayView = this.f32535e;
            if (videoPasterOverlayView != null) {
                videoPasterOverlayView.onExitFullScreen();
            }
            c.a.e.m.e.a aVar = this.p;
            if (aVar != null && aVar.d() && !this.p.c() && this.f32541k && this.p.a() == 1) {
                this.f32537g.setVisibility(0);
                int c2 = s.d().c(this.p.l);
                this.o = c2;
                this.n = (c2 <= 100 || this.u <= c2) ? 100 : 100;
                c.a.d.f.m.e.a().removeCallbacks(this.v);
                c.a.d.f.m.e.a().postDelayed(this.v, 20L);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f32535e = new VideoPasterOverlayView(getContext());
            this.f32536f = new TbImageView(getContext());
            this.f32537g = new TbImageView(getContext());
            TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(getContext());
            this.f32538h = tbVideoViewContainer;
            tbVideoViewContainer.getControl().setStageType("23");
            setBackgroundResource(R.color.black_alpha100);
            this.f32538h.getControl().setContinuePlayEnable(true);
            this.f32538h.getControl().setOperableVideoContainer(new a(this));
            this.f32538h.getControl().setOnSurfaceDestroyedListener(new b(this));
            h hVar = new h();
            this.f32539i = hVar;
            hVar.l(this.f32538h.getControl());
            this.f32539i.i(new c(this));
            setBackgroundColor(-16777216);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.t = true;
            g gVar = this.f32540j;
            if (gVar != null) {
                gVar.a();
            }
            removeAllViews();
            this.p = null;
            this.q = 0L;
            this.f32541k = false;
            this.s = false;
            this.m = false;
            this.n = 100;
            c.a.d.f.m.e.a().removeCallbacks(this.v);
        }
    }

    public final void r() {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (aVar = this.p) != null && aVar.a() == 1) {
            s.d().e(this.p.l);
            TbVideoViewContainer tbVideoViewContainer = this.f32538h;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().seekTo(0);
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            r();
            stop();
            this.f32535e.reset();
            this.f32541k = false;
            this.p = null;
            this.q = 0L;
            this.m = false;
            this.n = 100;
            c.a.d.f.m.e.a().removeCallbacks(this.v);
        }
    }

    public void responseBackkeyDown(int i2) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (videoPasterOverlayView = this.f32535e) == null) {
            return;
        }
        videoPasterOverlayView.responseBackkeyDown(i2);
    }

    public void resume() {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (aVar = this.p) == null) {
            return;
        }
        if (aVar.a() == 0) {
            o oVar = this.l;
            if (oVar != null) {
                oVar.p();
            }
        } else if (this.p.a() == 1) {
            this.f32537g.setVisibility(0);
            r rVar = new r();
            rVar.f26866e = "ad_paster";
            rVar.f26865d = rVar.a("ad_paster");
            rVar.f26867f = rVar.c("1");
            this.f32538h.getControl().setVideoModel(rVar);
            this.f32538h.getControl().setVideoPath(this.p.l);
            this.f32538h.getControl().start();
            h hVar = this.f32539i;
            if (hVar != null) {
                hVar.m();
            }
            o oVar2 = this.l;
            if (oVar2 != null) {
                oVar2.p();
            }
            int i2 = 100;
            if (this.f32541k) {
                int c2 = s.d().c(this.p.l);
                this.o = c2;
                if (c2 > 100 && this.u > c2) {
                    i2 = c2;
                }
                this.n = i2;
            } else {
                this.n = 100;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.v);
            c.a.d.f.m.e.a().postDelayed(this.v, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f32535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.resume();
        }
        this.s = true;
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            o oVar = this.l;
            if (oVar != null) {
                oVar.s();
                this.l.q(null);
            }
            o oVar2 = new o(i2 * 1000, 1000L);
            this.l = oVar2;
            oVar2.q(new f(this));
            this.l.r();
            this.t = false;
        }
    }

    public void setContentViewCallback(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.f32540j = gVar;
        }
    }

    public void setData(c.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) || (videoPasterOverlayView = this.f32535e) == null) {
            return;
        }
        videoPasterOverlayView.setOverlayViewCallback(bVar);
    }

    public void showVideoCover() {
        c.a.e.m.e.a aVar;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.p) == null || aVar.a() != 1 || (tbImageView = this.f32537g) == null) {
            return;
        }
        tbImageView.setVisibility(0);
    }

    public void stop() {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (aVar = this.p) == null) {
            return;
        }
        if (aVar.a() == 0) {
            o oVar = this.l;
            if (oVar != null) {
                oVar.o();
            }
        } else if (this.p.a() == 1) {
            this.f32537g.setVisibility(0);
            this.f32538h.getControl().stopPlayback();
            h hVar = this.f32539i;
            if (hVar != null) {
                hVar.n();
            }
            o oVar2 = this.l;
            if (oVar2 != null) {
                oVar2.o();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.v);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f32535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.stop();
        }
        this.s = false;
        this.m = false;
    }

    public void updateByData(boolean z, boolean z2, String str) {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (aVar = this.p) == null || !aVar.d() || this.p.c()) {
            return;
        }
        this.f32535e.updateByData(this.p, z, z2);
        if (this.f32541k) {
            return;
        }
        if (this.p.a() == 0) {
            this.f32535e.setCountDownNum(this.p.f3512j);
            s(this.p.f3512j);
        } else if (this.p.a() == 1) {
            this.f32535e.setCountDownNum(this.p.f3512j);
            s(this.p.f3512j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.r = str;
        if (this.p.a() == 0) {
            removeAllViews();
            addView(this.f32536f);
            addView(this.f32535e.getRootView(), layoutParams);
            this.f32536f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            c.a.d.f.l.d.h().m(this.p.f3513k, 10, new d(this), null);
            this.f32536f.startLoad(this.p.f3513k, 10, false);
        } else if (this.p.a() == 1) {
            r();
            removeAllViews();
            addView(this.f32538h);
            addView(this.f32537g);
            addView(this.f32535e.getRootView(), layoutParams);
            this.f32537g.startLoad(this.p.m, 10, false);
            r rVar = new r();
            rVar.f26866e = "ad_paster";
            rVar.f26865d = rVar.a("ad_paster");
            rVar.f26867f = rVar.c("1");
            this.f32538h.getControl().setVideoModel(rVar);
            this.f32538h.getControl().setVideoPath(this.p.l);
            this.f32538h.getControl().start();
            c.a.d.f.m.e.a().removeCallbacks(this.v);
            c.a.d.f.m.e.a().postDelayed(this.v, 20L);
        }
        this.f32541k = true;
        this.s = true;
    }
}
