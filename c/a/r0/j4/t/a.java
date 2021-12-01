package c.a.r0.j4.t;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.j4.g;
import c.a.r0.j4.m.c;
import c.a.r0.q2.r.f;
import c.a.r0.x2.h;
import c.a.r0.x2.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.videoview.VideoMediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes6.dex */
public class a extends c.a.r0.x2.r.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int L0;
    public int M0;
    public String N0;
    public String O0;
    public TbPageContext<BaseFragmentActivity> P0;
    public BdUniqueId Q0;
    public VideoItemData R0;
    public int S0;
    public View T0;
    public View U0;
    public boolean V0;
    public boolean W0;
    public ObjectAnimator X0;
    public ObjectAnimator Y0;
    public f Z0;
    public VideoDanmuController a1;
    public c.a.r0.j4.m.c b1;
    public d c1;
    public Runnable d1;
    public Runnable e1;

    /* renamed from: c.a.r0.j4.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1091a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18461e;

        public RunnableC1091a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18461e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18461e.L.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18462e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18462e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f18462e.W0 && (this.f18462e.P instanceof Activity)) {
                this.f18462e.H0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.j4.m.c.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.a1 == null || this.a.b1 == null) {
                return;
            }
            if (z) {
                this.a.a1.V();
                if (this.a.u.isPlaying()) {
                    this.a.a1.R();
                } else {
                    this.a.a1.O();
                }
            } else {
                this.a.a1.O();
                this.a.a1.E();
            }
            this.a.b1.j(z);
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view, int i2) {
        super(tbPageContext.getPageActivity(), view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.M0 = 0;
        this.d1 = new RunnableC1091a(this);
        this.e1 = new b(this);
        this.P0 = tbPageContext;
        this.Q0 = bdUniqueId;
        this.S = bdUniqueId;
        this.S0 = i2;
        Q();
        this.V0 = TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) || TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity());
        a0(true);
        b0(true);
        this.e0 = false;
    }

    public f G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoDanmuController videoDanmuController = this.a1;
            if (videoDanmuController != null) {
                return videoDanmuController.C();
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            M0();
            UtilHelper.hideStatusBar((Activity) this.P, this.T0);
            this.W0 = false;
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a0(false);
            b0(false);
            this.c1 = null;
            VideoDanmuController videoDanmuController = this.a1;
            if (videoDanmuController != null) {
                videoDanmuController.Q();
            }
            c.a.r0.j4.m.c cVar = this.b1;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.changeVolume(this.P, true, 10);
            e.a().removeCallbacks(this.d1);
            e.a().postDelayed(this.d1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, videoItemData) == null) || videoItemData == null) {
            return;
        }
        this.R0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void K0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.c1 = dVar;
        }
    }

    public void L0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.Z0 = fVar;
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.Y0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.U0, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.Y0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Y0.start();
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.X0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.U0, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.X0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.X0.start();
        }
    }

    @Override // c.a.r0.x2.r.d
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i2 = this.f25448f & (-33);
            this.f25448f = i2;
            int i3 = this.f25449g & (-33);
            this.f25449g = i3;
            int i4 = this.f25450h & (-33);
            this.f25450h = i4;
            int i5 = this.f25451i & (-33);
            this.f25451i = i5;
            int i6 = this.f25452j & (-33);
            this.f25452j = i6;
            int i7 = this.f25453k & (-33);
            this.f25453k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            this.f25448f = i2 | 1024;
            int i11 = i3 | 1024;
            this.f25449g = i11;
            this.f25450h = i4 & (-1025);
            this.f25451i = i5 | 1024;
            this.f25452j = i6 | 1024;
            int i12 = i7 | 1024;
            this.f25453k = i12;
            int i13 = i8 | 1024;
            this.l = i13;
            this.m = i9 | 1024;
            this.n = i10 & (-1025);
            this.f25449g = i11 | 16384;
            this.f25453k = i12 | 16384;
            this.l = i13 & (-2);
        }
    }

    @Override // c.a.r0.x2.r.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.H.changeViewLayout(this.U, this.a0);
            this.I.changeViewLayout(this.U, this.a0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.U, this.a0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            int i2 = 0;
            int f2 = (this.a0 && this.U) ? l.f(this.P, c.a.r0.j4.d.tbds42) : 0;
            if (this.a0 && !this.U) {
                i2 = l.f(this.P, c.a.r0.j4.d.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // c.a.r0.x2.r.d
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            Context context = this.P;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.Y(z);
            if (this.a0) {
                this.R.setVisibility(0);
                t0();
            } else {
                this.R.setVisibility(8);
                this.R.removeView(this.u);
            }
            d dVar = this.c1;
            if (dVar != null) {
                dVar.a(this.a0);
            }
            VideoDanmuController videoDanmuController = this.a1;
            if (videoDanmuController != null) {
                if (this.a0) {
                    videoDanmuController.X(this.Z0);
                } else {
                    videoDanmuController.Y();
                }
            }
        }
    }

    @Override // c.a.r0.x2.r.d
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? g.operable_danmu_video_container : invokeV.intValue;
    }

    @Override // c.a.r0.x2.r.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.g0();
            this.v.clearCornerFlag();
            this.v.setDrawCorner(false);
            this.L0 = l.k(this.P) / 10;
            this.I.setShareFrom(18);
        }
    }

    @Override // c.a.r0.x2.r.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.r0.x2.r.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.L0) : invokeL.booleanValue;
    }

    @Override // c.a.r0.x2.r.d
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.x2.r.d, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.j4.m.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == c.a.r0.j4.f.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == c.a.r0.j4.f.video_danmu_switch && (cVar = this.b1) != null) {
            cVar.i();
            VideoItemData videoItemData = this.R0;
            if (videoItemData != null) {
                this.b1.e(videoItemData.thread_id, this.S0);
            }
        }
        super.onClick(view);
    }

    @Override // c.a.r0.x2.r.d
    public void r0(int i2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            int i3 = this.q;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.d1);
                int i5 = this.q;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.r0(i2);
            if (!this.a0) {
                this.J.setVisibility(8);
                this.K.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((VideoMediaController) this.G).setBottomBarShow(i6 > 0);
            }
            if (c.a.q0.b.d.d0() && (findViewById = this.R.findViewById(c.a.r0.j4.f.video_danmu_switch)) != null) {
                findViewById.setVisibility((i2 & 64) > 0 ? 0 : 8);
            }
            if (!this.a0 && !this.V0 && (this.P instanceof Activity)) {
                if ((i2 & 128) > 0) {
                    if (!this.W0) {
                        N0();
                        UtilHelper.showStatusBar((Activity) this.P, this.T0);
                        this.W0 = true;
                        e.a().removeCallbacks(this.e1);
                        e.a().postDelayed(this.e1, 3000L);
                    }
                } else if (this.W0) {
                    H0();
                }
            }
            VideoDanmuController videoDanmuController = this.a1;
            if (videoDanmuController != null) {
                if (i2 != this.f25449g && i2 != this.f25451i) {
                    videoDanmuController.O();
                } else {
                    this.a1.R();
                }
            }
        }
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, d2Var) == null) || d2Var == null) {
            return;
        }
        p pVar = new p();
        pVar.a = "6";
        pVar.f25426c = d2Var.v1();
        pVar.f25427d = Long.toString(d2Var.U());
        pVar.f25428e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (d2Var.T1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.M0 = intExtra;
                if (intExtra == 0) {
                    this.M0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.N0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    pVar.f25434k = this.N0;
                }
                pVar.f25432i = Integer.toString(this.M0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.O0 = stringExtra2;
                pVar.f25432i = stringExtra2;
            }
        }
        if (d2Var.t1() != null) {
            pVar.m = d2Var.t1().video_md5;
            pVar.p = String.valueOf(d2Var.t1().is_vertical);
        }
        N(pVar);
        if (this.a0 && d2Var.t1() != null) {
            if (this.U != (d2Var.t1().is_vertical.intValue() == 1)) {
                X();
            }
        }
        super.setData(d2Var);
        a0(!this.U);
        if (d2Var.J() != null) {
            d2Var.J().setIsLike(d2Var.J().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.V) && c.a.q0.b.d.d0()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.P0, this.Q0, this.R, c.a.r0.j4.f.video_danmu_view, this.R0, this.S0);
            this.a1 = videoDanmuController;
            videoDanmuController.T(UtilHelper.getDimenPixelSize(c.a.r0.j4.d.T_X05));
        }
        View findViewById = this.R.findViewById(c.a.r0.j4.f.video_full_screen);
        View findViewById2 = this.R.findViewById(c.a.r0.j4.f.video_media_controller);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.tbds44);
        if (c.a.q0.b.d.d0()) {
            c.a.r0.j4.m.c cVar = new c.a.r0.j4.m.c(this.R, c.a.r0.j4.f.video_danmu_switch);
            this.b1 = cVar;
            cVar.g(this);
            this.b1.h(new c(this));
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                findViewById.setPadding(0, findViewById.getPaddingTop(), 0, findViewById.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.tbds68);
                layoutParams3.rightMargin = dimenPixelSize;
                ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = dimenPixelSize;
            }
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            findViewById.setPadding(dimenPixelSize, findViewById.getPaddingTop(), dimenPixelSize, findViewById.getPaddingBottom());
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams4.width = UtilHelper.getDimenPixelSize(c.a.r0.j4.d.tbds150);
            layoutParams4.rightMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = 0;
        }
    }

    @Override // c.a.r0.x2.r.d
    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
        }
    }

    @Override // c.a.r0.x2.r.d
    public void x0() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (pVar = this.b0) == null) {
            return;
        }
        p b2 = pVar.b();
        b2.a = "pb";
        h.e(b2.m, "", "2", b2, this.u.getPcdnState());
    }
}
