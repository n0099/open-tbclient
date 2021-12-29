package c.a.t0.m4.t;

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
import c.a.s0.s.q.d2;
import c.a.t0.m4.g;
import c.a.t0.m4.m.c;
import c.a.t0.s2.r.f;
import c.a.t0.z2.j;
import c.a.t0.z2.t;
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
/* loaded from: classes7.dex */
public class a extends c.a.t0.z2.v.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int M0;
    public int N0;
    public String O0;
    public String P0;
    public TbPageContext<BaseFragmentActivity> Q0;
    public BdUniqueId R0;
    public VideoItemData S0;
    public int T0;
    public View U0;
    public View V0;
    public boolean W0;
    public boolean X0;
    public ObjectAnimator Y0;
    public ObjectAnimator Z0;
    public f a1;
    public VideoDanmuController b1;
    public c.a.t0.m4.m.c c1;
    public d d1;
    public Runnable e1;
    public Runnable f1;

    /* renamed from: c.a.t0.m4.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1206a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20093e;

        public RunnableC1206a(a aVar) {
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
            this.f20093e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20093e.M.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20094e;

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
            this.f20094e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20094e.X0 && (this.f20094e.Q instanceof Activity)) {
                this.f20094e.C0();
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // c.a.t0.m4.m.c.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.b1 == null || this.a.c1 == null) {
                return;
            }
            if (z) {
                this.a.b1.Z();
                if (this.a.v.getControl().isPlaying()) {
                    this.a.b1.U();
                } else {
                    this.a.b1.R();
                }
            } else {
                this.a.b1.R();
                this.a.b1.H();
            }
            this.a.c1.j(z);
        }
    }

    /* loaded from: classes7.dex */
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
        this.N0 = 0;
        this.e1 = new RunnableC1206a(this);
        this.f1 = new b(this);
        this.Q0 = tbPageContext;
        this.R0 = bdUniqueId;
        this.T = bdUniqueId;
        this.T0 = i2;
        M();
        this.W0 = TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) || TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity());
        U(true);
        V(true);
        this.e0 = false;
    }

    public f B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoDanmuController videoDanmuController = this.b1;
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
            UtilHelper.hideStatusBar((Activity) this.Q, this.U0);
            this.X0 = false;
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            U(false);
            V(false);
            this.d1 = null;
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            c.a.t0.m4.m.c cVar = this.c1;
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
        this.S0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void F0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.d1 = dVar;
        }
    }

    public void G0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.a1 = fVar;
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.Z0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.V0, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.Z0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Z0.start();
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.Y0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.V0, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.Y0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Y0.start();
        }
    }

    @Override // c.a.t0.z2.v.d
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i2 = this.f26893f & (-33);
            this.f26893f = i2;
            int i3 = this.f26894g & (-33);
            this.f26894g = i3;
            int i4 = this.f26895h & (-33);
            this.f26895h = i4;
            int i5 = this.q & (-33);
            this.q = i5;
            int i6 = this.f26896i & (-33);
            this.f26896i = i6;
            int i7 = this.f26897j & (-33);
            this.f26897j = i7;
            int i8 = this.f26898k & (-33);
            this.f26898k = i8;
            int i9 = this.l & (-33);
            this.l = i9;
            int i10 = this.m & (-33);
            this.m = i10;
            int i11 = this.n & (-33);
            this.n = i11;
            this.f26893f = i2 | 1024;
            int i12 = i3 | 1024;
            this.f26894g = i12;
            this.f26895h = i4 & (-1025);
            this.q = i5 & (-1025);
            this.f26896i = i6 | 1024;
            this.f26897j = i7 | 1024;
            int i13 = i8 | 1024;
            this.f26898k = i13;
            int i14 = i9 | 1024;
            this.l = i14;
            this.m = i10 | 1024;
            this.n = i11 & (-1025);
            this.f26894g = i12 | 16384;
            this.f26898k = i13 | 16384;
            this.l = i14 & (-2);
        }
    }

    @Override // c.a.t0.z2.v.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.I.changeViewLayout(this.V, this.a0);
            this.J.changeViewLayout(this.V, this.a0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.V, this.a0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
            int i2 = 0;
            int f2 = (this.a0 && this.V) ? n.f(this.Q, c.a.t0.m4.d.tbds42) : 0;
            if (this.a0 && !this.V) {
                i2 = n.f(this.Q, c.a.t0.m4.d.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // c.a.t0.z2.v.d
    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            Context context = this.Q;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.S(z);
            if (this.a0) {
                this.S.setVisibility(0);
                n0();
            } else {
                this.S.setVisibility(8);
                this.S.removeView(this.v);
            }
            d dVar = this.d1;
            if (dVar != null) {
                dVar.a(this.a0);
            }
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                if (this.a0) {
                    videoDanmuController.b0(this.a1);
                } else {
                    videoDanmuController.c0();
                }
            }
        }
    }

    @Override // c.a.t0.z2.v.d
    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? g.operable_danmu_video_container : invokeV.intValue;
    }

    @Override // c.a.t0.z2.v.d
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.a0();
            this.w.clearCornerFlag();
            this.w.setDrawCorner(false);
            this.M0 = n.k(this.Q) / 10;
            this.J.setShareFrom(18);
        }
    }

    @Override // c.a.t0.z2.v.d
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.v.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.t0.z2.v.d
    public boolean c0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.M0) : invokeL.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public void l0(int i2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            int i3 = this.r;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.e1);
                int i5 = this.r;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.l0(i2);
            if (!this.a0) {
                this.K.setVisibility(8);
                this.L.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((VideoMediaController) this.H).setBottomBarShow(i6 > 0);
            }
            if (c.a.s0.b.d.e0() && (findViewById = this.S.findViewById(c.a.t0.m4.f.video_danmu_switch)) != null) {
                findViewById.setVisibility((i2 & 64) > 0 ? 0 : 8);
            }
            if (!this.a0 && !this.W0 && (this.Q instanceof Activity)) {
                if ((i2 & 128) > 0) {
                    if (!this.X0) {
                        I0();
                        UtilHelper.showStatusBar((Activity) this.Q, this.U0);
                        this.X0 = true;
                        e.a().removeCallbacks(this.f1);
                        e.a().postDelayed(this.f1, 3000L);
                    }
                } else if (this.X0) {
                    C0();
                }
            }
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                if (i2 != this.f26894g && i2 != this.f26896i) {
                    videoDanmuController.R();
                } else {
                    this.b1.U();
                }
            }
        }
    }

    @Override // c.a.t0.z2.v.d, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.t0.m4.m.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == c.a.t0.m4.f.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == c.a.t0.m4.f.video_danmu_switch && (cVar = this.c1) != null) {
            cVar.i();
            VideoItemData videoItemData = this.S0;
            if (videoItemData != null) {
                this.c1.e(videoItemData.thread_id, this.T0);
            }
        }
        super.onClick(view);
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.r == this.n) {
                return false;
            }
            this.M.setVisibility(0);
            this.M.changeVolume(this.Q, true, 10);
            e.a().removeCallbacks(this.e1);
            e.a().postDelayed(this.e1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
        }
    }

    @Override // c.a.t0.z2.v.d
    public void s0() {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (tVar = this.b0) == null) {
            return;
        }
        t b2 = tVar.b();
        b2.a = "pb";
        j.e(b2.m, "", "2", b2, this.v.getControl().getPcdnState());
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, d2Var) == null) || d2Var == null) {
            return;
        }
        t tVar = new t();
        tVar.a = "6";
        tVar.f26871c = d2Var.v1();
        tVar.f26872d = Long.toString(d2Var.U());
        tVar.f26873e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.Q;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (d2Var.T1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.N0 = intExtra;
                if (intExtra == 0) {
                    this.N0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.O0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    tVar.f26879k = this.O0;
                }
                tVar.f26877i = Integer.toString(this.N0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P0 = stringExtra2;
                tVar.f26877i = stringExtra2;
            }
        }
        if (d2Var.t1() != null) {
            tVar.m = d2Var.t1().video_md5;
            tVar.p = String.valueOf(d2Var.t1().is_vertical);
        }
        setStatistic(tVar);
        if (this.a0 && d2Var.t1() != null) {
            if (this.V != (d2Var.t1().is_vertical.intValue() == 1)) {
                R();
            }
        }
        super.setData(d2Var);
        U(!this.V);
        if (d2Var.J() != null) {
            d2Var.J().setIsLike(d2Var.J().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.W) && c.a.s0.b.d.e0()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.Q0, this.R0, this.S, c.a.t0.m4.f.video_danmu_view, this.S0, this.T0);
            this.b1 = videoDanmuController;
            videoDanmuController.W(UtilHelper.getDimenPixelSize(c.a.t0.m4.d.T_X05));
        }
        View findViewById = this.S.findViewById(c.a.t0.m4.f.video_full_screen);
        View findViewById2 = this.S.findViewById(c.a.t0.m4.f.video_media_controller);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.t0.m4.d.tbds44);
        if (c.a.s0.b.d.e0()) {
            c.a.t0.m4.m.c cVar = new c.a.t0.m4.m.c(this.S, c.a.t0.m4.f.video_danmu_switch);
            this.c1 = cVar;
            cVar.g(this);
            this.c1.h(new c(this));
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                findViewById.setPadding(0, findViewById.getPaddingTop(), 0, findViewById.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = UtilHelper.getDimenPixelSize(c.a.t0.m4.d.tbds68);
                layoutParams3.rightMargin = dimenPixelSize;
                ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = dimenPixelSize;
            }
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            findViewById.setPadding(dimenPixelSize, findViewById.getPaddingTop(), dimenPixelSize, findViewById.getPaddingBottom());
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams4.width = UtilHelper.getDimenPixelSize(c.a.t0.m4.d.tbds150);
            layoutParams4.rightMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = 0;
        }
    }
}
