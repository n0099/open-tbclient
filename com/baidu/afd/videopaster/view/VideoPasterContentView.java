package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.o;
import c.a.p0.c3.h;
import c.a.p0.c3.s;
import c.a.p0.c3.t;
import c.a.p0.c3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VideoPasterContentView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoPasterOverlayView a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f24094b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f24095c;

    /* renamed from: d  reason: collision with root package name */
    public TbVideoViewContainer f24096d;

    /* renamed from: e  reason: collision with root package name */
    public h f24097e;

    /* renamed from: f  reason: collision with root package name */
    public g f24098f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24099g;

    /* renamed from: h  reason: collision with root package name */
    public o f24100h;
    public boolean i;
    public int j;
    public int k;
    public c.a.e.m.e.a l;
    public long m;
    public String n;
    public boolean o;
    public boolean p;
    public int q;
    public Runnable r;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.c3.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPasterContentView a;

        public a(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPasterContentView;
        }

        @Override // c.a.p0.c3.w.a
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.p0.c3.w.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
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
                this.a.u();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.u();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a.f24096d == null) {
                return;
            }
            if (!TextUtils.equals(this.a.n, "HOME")) {
                this.a.f24096d.getControl().setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                this.a.f24096d.getControl().setVolume(0.0f, 0.0f);
            } else {
                this.a.f24096d.getControl().setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = this.a;
            videoPasterContentView.q = videoPasterContentView.f24096d.getControl().getDuration();
            if (this.a.a != null) {
                this.a.a.o(this.a.f24096d.getControl().getVideoWidth(), this.a.f24096d.getControl().getVideoHeight(), this.a.n);
            }
        }

        @Override // c.a.p0.c3.w.a
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

        @Override // c.a.p0.c3.w.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStatistic(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, uVar) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPasterContentView a;

        public b(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPasterContentView;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i = false;
                this.a.j = 100;
                c.a.d.f.m.e.a().removeCallbacks(this.a.r);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPasterContentView;
        }

        @Override // c.a.p0.c3.h.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends c.a.d.f.l.c<c.a.d.o.d.a> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPasterContentView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((d) aVar, str, i);
                if (aVar == null || aVar.p() == null || this.a.a == null) {
                    return;
                }
                this.a.a.o(aVar.r(), aVar.m(), this.a.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPasterContentView a;

        public e(VideoPasterContentView videoPasterContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPasterContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPasterContentView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.a.r);
                if (this.a.i) {
                    return;
                }
                boolean z = this.a.f24096d.getControl().getCurrentPositionSync() == 0 && this.a.j == 100;
                if (this.a.f24096d.getControl().getCurrentPositionSync() > this.a.j) {
                    this.a.o();
                } else if (z) {
                    c.a.d.f.m.e.a().postDelayed(this.a.r, 20L);
                } else {
                    this.a.o();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPasterContentView;
        }

        @Override // c.a.o0.c1.o.b
        public void onCountDown(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.a.m = (int) (j2 / 1000);
                if (this.a.a != null) {
                    this.a.a.setCountDownNum((int) this.a.m);
                }
                if (this.a.m == 0) {
                    this.a.u();
                    this.a.f24100h.s();
                }
            }
        }

        @Override // c.a.o0.c1.o.b
        public void onCountDownFinish(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24099g = false;
        this.i = false;
        this.j = 100;
        this.k = 0;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = new e(this);
        p();
    }

    public void A() {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.l) == null) {
            return;
        }
        if (aVar.a() == 0) {
            o oVar = this.f24100h;
            if (oVar != null) {
                oVar.p();
            }
        } else if (this.l.a() == 1) {
            this.f24095c.setVisibility(0);
            s sVar = new s();
            sVar.f13499e = "ad_paster";
            sVar.f13498d = sVar.a("ad_paster");
            sVar.f13500f = sVar.c("1");
            this.f24096d.getControl().setVideoModel(sVar);
            this.f24096d.getControl().setVideoPath(this.l.f2697h);
            this.f24096d.getControl().start();
            h hVar = this.f24097e;
            if (hVar != null) {
                hVar.m();
            }
            o oVar2 = this.f24100h;
            if (oVar2 != null) {
                oVar2.p();
            }
            int i = 100;
            if (this.f24099g) {
                int c2 = t.d().c(this.l.f2697h);
                this.k = c2;
                if (c2 > 100 && this.q > c2) {
                    i = c2;
                }
                this.j = i;
            } else {
                this.j = 100;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.r);
            c.a.d.f.m.e.a().postDelayed(this.r, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.a;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.l();
        }
        this.o = true;
    }

    public void B() {
        c.a.e.m.e.a aVar;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.l) == null || aVar.a() != 1 || (tbImageView = this.f24095c) == null) {
            return;
        }
        tbImageView.setVisibility(0);
    }

    public final void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            o oVar = this.f24100h;
            if (oVar != null) {
                oVar.s();
                this.f24100h.q(null);
            }
            o oVar2 = new o(i * 1000, 1000L);
            this.f24100h = oVar2;
            oVar2.q(new f(this));
            this.f24100h.r();
            this.p = false;
        }
    }

    public void D() {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.l) == null) {
            return;
        }
        if (aVar.a() == 0) {
            o oVar = this.f24100h;
            if (oVar != null) {
                oVar.o();
            }
        } else if (this.l.a() == 1) {
            this.f24095c.setVisibility(0);
            this.f24096d.getControl().stopPlayback();
            h hVar = this.f24097e;
            if (hVar != null) {
                hVar.n();
            }
            o oVar2 = this.f24100h;
            if (oVar2 != null) {
                oVar2.o();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.r);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.a;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.m();
        }
        this.o = false;
        this.i = false;
    }

    public void E(boolean z, boolean z2, String str) {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (aVar = this.l) == null || !aVar.d() || this.l.c()) {
            return;
        }
        this.a.n(this.l, z, z2);
        if (this.f24099g) {
            return;
        }
        if (this.l.a() == 0) {
            this.a.setCountDownNum(this.l.f2695f);
            C(this.l.f2695f);
        } else if (this.l.a() == 1) {
            this.a.setCountDownNum(this.l.f2695f);
            C(this.l.f2695f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.n = str;
        if (this.l.a() == 0) {
            removeAllViews();
            addView(this.f24094b);
            addView(this.a.getRootView(), layoutParams);
            this.f24094b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            c.a.d.f.l.d.h().m(this.l.f2696g, 10, new d(this), null);
            this.f24094b.J(this.l.f2696g, 10, false);
        } else if (this.l.a() == 1) {
            y();
            removeAllViews();
            addView(this.f24096d);
            addView(this.f24095c);
            addView(this.a.getRootView(), layoutParams);
            this.f24095c.J(this.l.i, 10, false);
            s sVar = new s();
            sVar.f13499e = "ad_paster";
            sVar.f13498d = sVar.a("ad_paster");
            sVar.f13500f = sVar.c("1");
            this.f24096d.getControl().setVideoModel(sVar);
            this.f24096d.getControl().setVideoPath(this.l.f2697h);
            this.f24096d.getControl().start();
            c.a.d.f.m.e.a().removeCallbacks(this.r);
            c.a.d.f.m.e.a().postDelayed(this.r, 20L);
        }
        this.f24099g = true;
        this.o = true;
    }

    public int getCurDuration() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.l == null || (oVar = this.f24100h) == null) {
                return 0;
            }
            return ((int) oVar.n()) / 1000;
        }
        return invokeV.intValue;
    }

    public int getTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.e.m.e.a aVar = this.l;
            if (aVar == null) {
                return -1;
            }
            return aVar.f2695f;
        }
        return invokeV.intValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.i) {
            return;
        }
        this.i = true;
        this.f24095c.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            g gVar = this.f24098f;
            if (gVar != null) {
                gVar.onDetachedFromWindow();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = new VideoPasterOverlayView(getContext());
            this.f24094b = new TbImageView(getContext());
            this.f24095c = new TbImageView(getContext());
            TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(getContext());
            this.f24096d = tbVideoViewContainer;
            tbVideoViewContainer.getControl().setStageType("23");
            setBackgroundResource(R.color.black_alpha100);
            this.f24096d.getControl().setContinuePlayEnable(true);
            this.f24096d.getControl().setOperableVideoContainer(new a(this));
            this.f24096d.getControl().setOnSurfaceDestroyedListener(new b(this));
            h hVar = new h();
            this.f24097e = hVar;
            hVar.l(this.f24096d.getControl());
            this.f24097e.i(new c(this));
            setBackgroundColor(-16777216);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f24099g : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void setContentViewCallback(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f24098f = gVar;
        }
    }

    public void setData(c.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) || (videoPasterOverlayView = this.a) == null) {
            return;
        }
        videoPasterOverlayView.setOverlayViewCallback(bVar);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f24096d;
            return (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.f24096d.getControl().isPlaying()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.p = true;
            g gVar = this.f24098f;
            if (gVar != null) {
                gVar.a();
            }
            removeAllViews();
            this.l = null;
            this.m = 0L;
            this.f24099g = false;
            this.o = false;
            this.i = false;
            this.j = 100;
            c.a.d.f.m.e.a().removeCallbacks(this.r);
        }
    }

    public void v() {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (videoPasterOverlayView = this.a) == null) {
            return;
        }
        videoPasterOverlayView.g();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VideoPasterOverlayView videoPasterOverlayView = this.a;
            if (videoPasterOverlayView != null) {
                videoPasterOverlayView.h();
            }
            c.a.e.m.e.a aVar = this.l;
            if (aVar != null && aVar.d() && !this.l.c() && this.f24099g && this.l.a() == 1) {
                this.f24095c.setVisibility(0);
                int c2 = t.d().c(this.l.f2697h);
                this.k = c2;
                this.j = (c2 <= 100 || this.q <= c2) ? 100 : 100;
                c.a.d.f.m.e.a().removeCallbacks(this.r);
                c.a.d.f.m.e.a().postDelayed(this.r, 20L);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            y();
            D();
            this.a.i();
            this.f24099g = false;
            this.l = null;
            this.m = 0L;
            this.i = false;
            this.j = 100;
            c.a.d.f.m.e.a().removeCallbacks(this.r);
        }
    }

    public final void y() {
        c.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (aVar = this.l) != null && aVar.a() == 1) {
            t.d().e(this.l.f2697h);
            TbVideoViewContainer tbVideoViewContainer = this.f24096d;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().seekTo(0);
            }
        }
    }

    public void z(int i) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || (videoPasterOverlayView = this.a) == null) {
            return;
        }
        videoPasterOverlayView.k(i);
    }
}
