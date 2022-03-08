package c.a.r0.n4.k;

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
import c.a.d.f.p.n;
import c.a.q0.r.r.e2;
import c.a.r0.a3.j;
import c.a.r0.a3.t;
import c.a.r0.n4.d.c;
import c.a.r0.u2.h.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class a extends c.a.r0.a3.v.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public int O0;
    public String P0;
    public String Q0;
    public TbPageContext<BaseFragmentActivity> R0;
    public BdUniqueId S0;
    public VideoItemData T0;
    public int U0;
    public View V0;
    public View W0;
    public boolean X0;
    public boolean Y0;
    public ObjectAnimator Z0;
    public ObjectAnimator a1;
    public f b1;
    public VideoDanmuController c1;
    public c.a.r0.n4.d.c d1;
    public d e1;
    public Runnable f1;
    public Runnable g1;

    /* renamed from: c.a.r0.n4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1227a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19587e;

        public RunnableC1227a(a aVar) {
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
            this.f19587e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19587e.N.setVisibility(8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19588e;

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
            this.f19588e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19588e.Y0 && (this.f19588e.R instanceof Activity)) {
                this.f19588e.C0();
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // c.a.r0.n4.d.c.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.c1 == null || this.a.d1 == null) {
                return;
            }
            if (z) {
                this.a.c1.Z();
                if (this.a.w.getControl().isPlaying()) {
                    this.a.c1.U();
                } else {
                    this.a.c1.R();
                }
            } else {
                this.a.c1.R();
                this.a.c1.H();
            }
            this.a.d1.j(z);
        }
    }

    /* loaded from: classes2.dex */
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
        this.O0 = 0;
        this.f1 = new RunnableC1227a(this);
        this.g1 = new b(this);
        this.R0 = tbPageContext;
        this.S0 = bdUniqueId;
        this.U = bdUniqueId;
        this.U0 = i2;
        M();
        this.X0 = TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) || TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity());
        U(true);
        V(true);
        this.f0 = false;
    }

    public f B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                return videoDanmuController.F();
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            H0();
            UtilHelper.hideStatusBar((Activity) this.R, this.V0);
            this.Y0 = false;
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            U(false);
            V(false);
            this.e1 = null;
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            c.a.r0.n4.d.c cVar = this.d1;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    public void E0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoItemData) == null) || videoItemData == null) {
            return;
        }
        this.T0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void F0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.e1 = dVar;
        }
    }

    public void G0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.b1 = fVar;
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.a1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.a1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.a1.start();
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.Z0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.Z0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Z0.start();
        }
    }

    @Override // c.a.r0.a3.v.d
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i2 = this.f14961f & (-33);
            this.f14961f = i2;
            int i3 = this.f14963h & (-33);
            this.f14963h = i3;
            int i4 = this.f14964i & (-33);
            this.f14964i = i4;
            int i5 = this.r & (-33);
            this.r = i5;
            int i6 = this.f14965j & (-33);
            this.f14965j = i6;
            int i7 = this.k & (-33);
            this.k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            int i11 = this.o & (-33);
            this.o = i11;
            this.f14961f = i2 | 1024;
            int i12 = i3 | 1024;
            this.f14963h = i12;
            this.f14964i = i4 & (-1025);
            this.r = i5 & (-1025);
            this.f14965j = i6 | 1024;
            this.k = i7 | 1024;
            int i13 = i8 | 1024;
            this.l = i13;
            int i14 = i9 | 1024;
            this.m = i14;
            this.n = i10 | 1024;
            this.o = i11 & (-1025);
            this.f14963h = i12 | 16384;
            this.l = i13 | 16384;
            this.m = i14 & (-2);
        }
    }

    @Override // c.a.r0.a3.v.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.J.changeViewLayout(this.W, this.b0);
            this.K.changeViewLayout(this.W, this.b0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.I;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.W, this.b0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
            int i2 = 0;
            int f2 = (this.b0 && this.W) ? n.f(this.R, R.dimen.tbds42) : 0;
            if (this.b0 && !this.W) {
                i2 = n.f(this.R, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // c.a.r0.a3.v.d
    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            Context context = this.R;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.S(z);
            if (this.b0) {
                this.T.setVisibility(0);
                n0();
            } else {
                this.T.setVisibility(8);
                this.T.removeView(this.w);
            }
            d dVar = this.e1;
            if (dVar != null) {
                dVar.a(this.b0);
            }
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                if (this.b0) {
                    videoDanmuController.b0(this.b1);
                } else {
                    videoDanmuController.c0();
                }
            }
        }
    }

    @Override // c.a.r0.a3.v.d
    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.operable_danmu_video_container : invokeV.intValue;
    }

    @Override // c.a.r0.a3.v.d
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.a0();
            this.x.clearCornerFlag();
            this.x.setDrawCorner(false);
            this.N0 = n.k(this.R) / 10;
            this.K.setShareFrom(18);
        }
    }

    @Override // c.a.r0.a3.v.d
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.w.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.r0.a3.v.d
    public boolean c0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) ? this.b0 || motionEvent.getX() > ((float) this.N0) : invokeL.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public void l0(int i2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            int i3 = this.s;
            int i4 = this.o;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.f1);
                int i5 = this.s;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.o = i2;
            }
            super.l0(i2);
            if (!this.b0) {
                this.L.setVisibility(8);
                this.M.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.I;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((VideoMediaController) this.I).setBottomBarShow(i6 > 0);
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.T.findViewById(R.id.video_danmu_switch)) != null) {
                findViewById.setVisibility((i2 & 64) > 0 ? 0 : 8);
            }
            if (!this.b0 && !this.X0 && (this.R instanceof Activity)) {
                if ((i2 & 128) > 0) {
                    if (!this.Y0) {
                        I0();
                        UtilHelper.showStatusBar((Activity) this.R, this.V0);
                        this.Y0 = true;
                        e.a().removeCallbacks(this.g1);
                        e.a().postDelayed(this.g1, 3000L);
                    }
                } else if (this.Y0) {
                    C0();
                }
            }
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                if (i2 != this.f14963h && i2 != this.f14965j) {
                    videoDanmuController.R();
                } else {
                    this.c1.U();
                }
            }
        }
    }

    @Override // c.a.r0.a3.v.d, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.n4.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.video_danmu_switch && (cVar = this.d1) != null) {
            cVar.i();
            VideoItemData videoItemData = this.T0;
            if (videoItemData != null) {
                this.d1.e(videoItemData.thread_id, this.U0);
            }
        }
        super.onClick(view);
    }

    @Override // c.a.r0.a3.v.d, c.a.r0.a3.v.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.s == this.o) {
                return false;
            }
            this.N.setVisibility(0);
            this.N.changeVolume(this.R, true, 10);
            e.a().removeCallbacks(this.f1);
            e.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a3.v.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
        }
    }

    @Override // c.a.r0.a3.v.d
    public void s0() {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (tVar = this.c0) == null) {
            return;
        }
        t b2 = tVar.b();
        b2.a = "pb";
        j.e(b2.m, "", "2", b2, this.w.getControl().getPcdnState());
    }

    @Override // c.a.r0.a3.v.d, c.a.r0.a3.v.a
    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, e2Var) == null) || e2Var == null) {
            return;
        }
        t tVar = new t();
        tVar.a = "6";
        tVar.f14940c = e2Var.w1();
        tVar.f14941d = Long.toString(e2Var.U());
        tVar.f14942e = TbadkCoreApplication.getCurrentAccount();
        tVar.x = this.T0.getChannelMidRequestNum();
        tVar.y = this.T0.getChannelMidRequestVideoNum();
        Context context = this.R;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (e2Var.U1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.O0 = intExtra;
                if (intExtra == 0) {
                    this.O0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.P0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    tVar.k = this.P0;
                }
                tVar.f14946i = Integer.toString(this.O0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Q0 = stringExtra2;
                tVar.f14946i = stringExtra2;
            }
        }
        if (e2Var.u1() != null) {
            tVar.m = e2Var.u1().video_md5;
            tVar.p = String.valueOf(e2Var.u1().is_vertical);
        }
        setStatistic(tVar);
        if (this.b0 && e2Var.u1() != null) {
            if (this.W != (e2Var.u1().is_vertical.intValue() == 1)) {
                R();
            }
        }
        super.setData(e2Var);
        U(!this.W);
        if (e2Var.J() != null) {
            e2Var.J().setIsLike(e2Var.J().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.X) && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.R0, this.S0, this.T, R.id.video_danmu_view, this.T0, this.U0);
            this.c1 = videoDanmuController;
            videoDanmuController.W(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.T.findViewById(R.id.video_full_screen);
        View findViewById2 = this.T.findViewById(R.id.video_media_controller);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            c.a.r0.n4.d.c cVar = new c.a.r0.n4.d.c(this.T, R.id.video_danmu_switch);
            this.d1 = cVar;
            cVar.g(this);
            this.d1.h(new c(this));
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                findViewById.setPadding(0, findViewById.getPaddingTop(), 0, findViewById.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = UtilHelper.getDimenPixelSize(R.dimen.tbds68);
                layoutParams3.rightMargin = dimenPixelSize;
                ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = dimenPixelSize;
            }
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            findViewById.setPadding(dimenPixelSize, findViewById.getPaddingTop(), dimenPixelSize, findViewById.getPaddingBottom());
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams4.width = UtilHelper.getDimenPixelSize(R.dimen.tbds150);
            layoutParams4.rightMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = 0;
        }
    }
}
