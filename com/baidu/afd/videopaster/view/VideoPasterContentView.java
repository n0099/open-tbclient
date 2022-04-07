package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.d78;
import com.repackage.dc5;
import com.repackage.e78;
import com.repackage.f78;
import com.repackage.fo;
import com.repackage.hg;
import com.repackage.ig;
import com.repackage.k78;
import com.repackage.pg;
import com.repackage.s68;
import com.repackage.xp;
/* loaded from: classes.dex */
public class VideoPasterContentView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoPasterOverlayView a;
    public TbImageView b;
    public TbImageView c;
    public TbVideoViewContainer d;
    public s68 e;
    public g f;
    public boolean g;
    public dc5 h;
    public boolean i;
    public int j;
    public int k;
    public xp l;
    public long m;
    public String n;
    public boolean o;
    public boolean p;
    public int q;
    public Runnable r;

    /* loaded from: classes.dex */
    public class a implements k78 {
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

        @Override // com.repackage.k78
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.k78
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.k78
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.k78
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.k78
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.k78
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.k78
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
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
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a.d == null) {
                return;
            }
            if (!TextUtils.equals(this.a.n, "HOME")) {
                this.a.d.getControl().setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                this.a.d.getControl().setVolume(0.0f, 0.0f);
            } else {
                this.a.d.getControl().setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = this.a;
            videoPasterContentView.q = videoPasterContentView.d.getControl().getDuration();
            if (this.a.a != null) {
                this.a.a.l(this.a.d.getControl().getVideoWidth(), this.a.d.getControl().getVideoHeight(), this.a.n);
            }
        }

        @Override // com.repackage.k78
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

        @Override // com.repackage.k78
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.k78
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.k78
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.repackage.k78
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.repackage.k78
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.k78
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.repackage.k78
        public void setStatistic(f78 f78Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, f78Var) == null) {
            }
        }

        @Override // com.repackage.k78
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.repackage.k78
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.repackage.k78
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
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
                pg.a().removeCallbacks(this.a.r);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements s68.b {
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

        @Override // com.repackage.s68.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends hg<fo> {
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
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) {
                super.onLoaded((d) foVar, str, i);
                if (foVar == null || foVar.p() == null || this.a.a == null) {
                    return;
                }
                this.a.a.l(foVar.r(), foVar.m(), this.a.n);
            }
        }
    }

    /* loaded from: classes.dex */
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
                pg.a().removeCallbacks(this.a.r);
                if (this.a.i) {
                    return;
                }
                boolean z = this.a.d.getControl().getCurrentPositionSync() == 0 && this.a.j == 100;
                if (this.a.d.getControl().getCurrentPositionSync() > this.a.j) {
                    this.a.o();
                } else if (z) {
                    pg.a().postDelayed(this.a.r, 20L);
                } else {
                    this.a.o();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements dc5.b {
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

        @Override // com.repackage.dc5.b
        public void onCountDown(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.a.m = (int) (j2 / 1000);
                if (this.a.a != null) {
                    this.a.a.setCountDownNum((int) this.a.m);
                }
                if (this.a.m == 0) {
                    this.a.u();
                    this.a.h.s();
                }
            }
        }

        @Override // com.repackage.dc5.b
        public void onCountDownFinish(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes.dex */
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
        this.g = false;
        this.i = false;
        this.j = 100;
        this.k = 0;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = new e(this);
        p();
    }

    public void A(boolean z, boolean z2, String str) {
        xp xpVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || (xpVar = this.l) == null || !xpVar.d() || this.l.c()) {
            return;
        }
        this.a.k(this.l, z, z2);
        if (this.g) {
            return;
        }
        if (this.l.a() == 0) {
            this.a.setCountDownNum(this.l.f);
            y(this.l.f);
        } else if (this.l.a() == 1) {
            this.a.setCountDownNum(this.l.f);
            y(this.l.f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.n = str;
        if (this.l.a() == 0) {
            removeAllViews();
            addView(this.b);
            addView(this.a.getRootView(), layoutParams);
            this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ig.h().m(this.l.g, 10, new d(this), null);
            this.b.K(this.l.g, 10, false);
        } else if (this.l.a() == 1) {
            w();
            removeAllViews();
            addView(this.d);
            addView(this.c);
            addView(this.a.getRootView(), layoutParams);
            this.c.K(this.l.i, 10, false);
            d78 d78Var = new d78();
            d78Var.e = "ad_paster";
            d78Var.d = d78Var.a("ad_paster");
            d78Var.f = d78Var.c("1");
            this.d.getControl().setVideoModel(d78Var);
            this.d.getControl().setVideoPath(this.l.h);
            this.d.getControl().start();
            pg.a().removeCallbacks(this.r);
            pg.a().postDelayed(this.r, 20L);
        }
        this.g = true;
        this.o = true;
    }

    public int getCurDuration() {
        InterceptResult invokeV;
        dc5 dc5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.l == null || (dc5Var = this.h) == null) {
                return 0;
            }
            return ((int) dc5Var.n()) / 1000;
        }
        return invokeV.intValue;
    }

    public int getTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            xp xpVar = this.l;
            if (xpVar == null) {
                return -1;
            }
            return xpVar.f;
        }
        return invokeV.intValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.i) {
            return;
        }
        this.i = true;
        this.c.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            g gVar = this.f;
            if (gVar != null) {
                gVar.onDetachedFromWindow();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = new VideoPasterOverlayView(getContext());
            this.b = new TbImageView(getContext());
            this.c = new TbImageView(getContext());
            TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(getContext());
            this.d = tbVideoViewContainer;
            tbVideoViewContainer.getControl().setStageType("23");
            setBackgroundResource(R.color.black_alpha100);
            this.d.getControl().setContinuePlayEnable(true);
            this.d.getControl().setOperableVideoContainer(new a(this));
            this.d.getControl().setOnSurfaceDestroyedListener(new b(this));
            s68 s68Var = new s68();
            this.e = s68Var;
            s68Var.l(this.d.getControl());
            this.e.i(new c(this));
            setBackgroundColor(-16777216);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void setContentViewCallback(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f = gVar;
        }
    }

    public void setData(xp xpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xpVar) == null) {
            this.l = xpVar;
        }
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || (videoPasterOverlayView = this.a) == null) {
            return;
        }
        videoPasterOverlayView.setOverlayViewCallback(bVar);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.d;
            return (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.d.getControl().isPlaying()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.p = true;
            g gVar = this.f;
            if (gVar != null) {
                gVar.a();
            }
            removeAllViews();
            this.l = null;
            this.m = 0L;
            this.g = false;
            this.o = false;
            this.i = false;
            this.j = 100;
            pg.a().removeCallbacks(this.r);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            w();
            z();
            this.a.g();
            this.g = false;
            this.l = null;
            this.m = 0L;
            this.i = false;
            this.j = 100;
            pg.a().removeCallbacks(this.r);
        }
    }

    public final void w() {
        xp xpVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (xpVar = this.l) != null && xpVar.a() == 1) {
            e78.d().e(this.l.h);
            TbVideoViewContainer tbVideoViewContainer = this.d;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().seekTo(0);
            }
        }
    }

    public void x() {
        xp xpVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (xpVar = this.l) == null) {
            return;
        }
        if (xpVar.a() == 0) {
            dc5 dc5Var = this.h;
            if (dc5Var != null) {
                dc5Var.p();
            }
        } else if (this.l.a() == 1) {
            this.c.setVisibility(0);
            d78 d78Var = new d78();
            d78Var.e = "ad_paster";
            d78Var.d = d78Var.a("ad_paster");
            d78Var.f = d78Var.c("1");
            this.d.getControl().setVideoModel(d78Var);
            this.d.getControl().setVideoPath(this.l.h);
            this.d.getControl().start();
            s68 s68Var = this.e;
            if (s68Var != null) {
                s68Var.m();
            }
            dc5 dc5Var2 = this.h;
            if (dc5Var2 != null) {
                dc5Var2.p();
            }
            int i = 100;
            if (this.g) {
                int c2 = e78.d().c(this.l.h);
                this.k = c2;
                if (c2 > 100 && this.q > c2) {
                    i = c2;
                }
                this.j = i;
            } else {
                this.j = 100;
            }
            pg.a().removeCallbacks(this.r);
            pg.a().postDelayed(this.r, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.a;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.i();
        }
        this.o = true;
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            dc5 dc5Var = this.h;
            if (dc5Var != null) {
                dc5Var.s();
                this.h.q(null);
            }
            dc5 dc5Var2 = new dc5(i * 1000, 1000L);
            this.h = dc5Var2;
            dc5Var2.q(new f(this));
            this.h.r();
            this.p = false;
        }
    }

    public void z() {
        xp xpVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (xpVar = this.l) == null) {
            return;
        }
        if (xpVar.a() == 0) {
            dc5 dc5Var = this.h;
            if (dc5Var != null) {
                dc5Var.o();
            }
        } else if (this.l.a() == 1) {
            this.c.setVisibility(0);
            this.d.getControl().stopPlayback();
            s68 s68Var = this.e;
            if (s68Var != null) {
                s68Var.n();
            }
            dc5 dc5Var2 = this.h;
            if (dc5Var2 != null) {
                dc5Var2.o();
            }
            pg.a().removeCallbacks(this.r);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.a;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.j();
        }
        this.o = false;
        this.i = false;
    }
}
