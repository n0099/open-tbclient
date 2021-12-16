package c.a.s0.l4.t;

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
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.s0.l4.g;
import c.a.s0.l4.m.c;
import c.a.s0.s2.r.f;
import c.a.s0.z2.h;
import c.a.s0.z2.p;
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
public class a extends c.a.s0.z2.r.d {
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
    public c.a.s0.l4.m.c d1;
    public d e1;
    public Runnable f1;
    public Runnable g1;

    /* renamed from: c.a.s0.l4.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1162a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19246e;

        public RunnableC1162a(a aVar) {
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
            this.f19246e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19246e.M.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19247e;

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
            this.f19247e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19247e.Y0 && (this.f19247e.Q instanceof Activity)) {
                this.f19247e.I0();
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

        @Override // c.a.s0.l4.m.c.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.c1 == null || this.a.d1 == null) {
                return;
            }
            if (z) {
                this.a.c1.Z();
                if (this.a.v.isPlaying()) {
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
        this.O0 = 0;
        this.f1 = new RunnableC1162a(this);
        this.g1 = new b(this);
        this.R0 = tbPageContext;
        this.S0 = bdUniqueId;
        this.T = bdUniqueId;
        this.U0 = i2;
        Q();
        this.X0 = TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) || TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity());
        a0(true);
        b0(true);
        this.f0 = false;
    }

    public f H0() {
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

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            N0();
            UtilHelper.hideStatusBar((Activity) this.Q, this.V0);
            this.Y0 = false;
        }
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.r == this.n) {
                return false;
            }
            this.M.setVisibility(0);
            this.M.changeVolume(this.Q, true, 10);
            e.a().removeCallbacks(this.f1);
            e.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a0(false);
            b0(false);
            this.e1 = null;
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            c.a.s0.l4.m.c cVar = this.d1;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    public void K0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, videoItemData) == null) || videoItemData == null) {
            return;
        }
        this.T0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void L0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.e1 = dVar;
        }
    }

    public void M0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.b1 = fVar;
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.a1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.a1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.a1.start();
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.Z0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.Z0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Z0.start();
        }
    }

    @Override // c.a.s0.z2.r.d
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i2 = this.f26428f & (-33);
            this.f26428f = i2;
            int i3 = this.f26429g & (-33);
            this.f26429g = i3;
            int i4 = this.f26430h & (-33);
            this.f26430h = i4;
            int i5 = this.q & (-33);
            this.q = i5;
            int i6 = this.f26431i & (-33);
            this.f26431i = i6;
            int i7 = this.f26432j & (-33);
            this.f26432j = i7;
            int i8 = this.f26433k & (-33);
            this.f26433k = i8;
            int i9 = this.l & (-33);
            this.l = i9;
            int i10 = this.m & (-33);
            this.m = i10;
            int i11 = this.n & (-33);
            this.n = i11;
            this.f26428f = i2 | 1024;
            int i12 = i3 | 1024;
            this.f26429g = i12;
            this.f26430h = i4 & (-1025);
            this.q = i5 & (-1025);
            this.f26431i = i6 | 1024;
            this.f26432j = i7 | 1024;
            int i13 = i8 | 1024;
            this.f26433k = i13;
            int i14 = i9 | 1024;
            this.l = i14;
            this.m = i10 | 1024;
            this.n = i11 & (-1025);
            this.f26429g = i12 | 16384;
            this.f26433k = i13 | 16384;
            this.l = i14 & (-2);
        }
    }

    @Override // c.a.s0.z2.r.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.I.changeViewLayout(this.V, this.b0);
            this.J.changeViewLayout(this.V, this.b0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.V, this.b0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
            int i2 = 0;
            int f2 = (this.b0 && this.V) ? m.f(this.Q, c.a.s0.l4.d.tbds42) : 0;
            if (this.b0 && !this.V) {
                i2 = m.f(this.Q, c.a.s0.l4.d.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // c.a.s0.z2.r.d
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            Context context = this.Q;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.Y(z);
            if (this.b0) {
                this.S.setVisibility(0);
                t0();
            } else {
                this.S.setVisibility(8);
                this.S.removeView(this.v);
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

    @Override // c.a.s0.z2.r.d
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? g.operable_danmu_video_container : invokeV.intValue;
    }

    @Override // c.a.s0.z2.r.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.g0();
            this.w.clearCornerFlag();
            this.w.setDrawCorner(false);
            this.N0 = m.k(this.Q) / 10;
            this.J.setShareFrom(18);
        }
    }

    @Override // c.a.s0.z2.r.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.v.setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.s0.z2.r.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) ? this.b0 || motionEvent.getX() > ((float) this.N0) : invokeL.booleanValue;
    }

    @Override // c.a.s0.z2.r.d
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.d, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.s0.l4.m.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == c.a.s0.l4.f.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == c.a.s0.l4.f.video_danmu_switch && (cVar = this.d1) != null) {
            cVar.i();
            VideoItemData videoItemData = this.T0;
            if (videoItemData != null) {
                this.d1.e(videoItemData.thread_id, this.U0);
            }
        }
        super.onClick(view);
    }

    @Override // c.a.s0.z2.r.d
    public void r0(int i2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            int i3 = this.r;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.f1);
                int i5 = this.r;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.r0(i2);
            if (!this.b0) {
                this.K.setVisibility(8);
                this.L.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.H;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i6 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
                ((VideoMediaController) this.H).setBottomBarShow(i6 > 0);
            }
            if (c.a.r0.b.d.e0() && (findViewById = this.S.findViewById(c.a.s0.l4.f.video_danmu_switch)) != null) {
                findViewById.setVisibility((i2 & 64) > 0 ? 0 : 8);
            }
            if (!this.b0 && !this.X0 && (this.Q instanceof Activity)) {
                if ((i2 & 128) > 0) {
                    if (!this.Y0) {
                        O0();
                        UtilHelper.showStatusBar((Activity) this.Q, this.V0);
                        this.Y0 = true;
                        e.a().removeCallbacks(this.g1);
                        e.a().postDelayed(this.g1, 3000L);
                    }
                } else if (this.Y0) {
                    I0();
                }
            }
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                if (i2 != this.f26429g && i2 != this.f26431i) {
                    videoDanmuController.R();
                } else {
                    this.c1.U();
                }
            }
        }
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, d2Var) == null) || d2Var == null) {
            return;
        }
        p pVar = new p();
        pVar.a = "6";
        pVar.f26406c = d2Var.v1();
        pVar.f26407d = Long.toString(d2Var.U());
        pVar.f26408e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.Q;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (d2Var.T1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.O0 = intExtra;
                if (intExtra == 0) {
                    this.O0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.P0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    pVar.f26414k = this.P0;
                }
                pVar.f26412i = Integer.toString(this.O0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Q0 = stringExtra2;
                pVar.f26412i = stringExtra2;
            }
        }
        if (d2Var.t1() != null) {
            pVar.m = d2Var.t1().video_md5;
            pVar.p = String.valueOf(d2Var.t1().is_vertical);
        }
        N(pVar);
        if (this.b0 && d2Var.t1() != null) {
            if (this.V != (d2Var.t1().is_vertical.intValue() == 1)) {
                X();
            }
        }
        super.setData(d2Var);
        a0(!this.V);
        if (d2Var.J() != null) {
            d2Var.J().setIsLike(d2Var.J().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.W) && c.a.r0.b.d.e0()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.R0, this.S0, this.S, c.a.s0.l4.f.video_danmu_view, this.T0, this.U0);
            this.c1 = videoDanmuController;
            videoDanmuController.W(UtilHelper.getDimenPixelSize(c.a.s0.l4.d.T_X05));
        }
        View findViewById = this.S.findViewById(c.a.s0.l4.f.video_full_screen);
        View findViewById2 = this.S.findViewById(c.a.s0.l4.f.video_media_controller);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds44);
        if (c.a.r0.b.d.e0()) {
            c.a.s0.l4.m.c cVar = new c.a.s0.l4.m.c(this.S, c.a.s0.l4.f.video_danmu_switch);
            this.d1 = cVar;
            cVar.g(this);
            this.d1.h(new c(this));
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                findViewById.setPadding(0, findViewById.getPaddingTop(), 0, findViewById.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds68);
                layoutParams3.rightMargin = dimenPixelSize;
                ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = dimenPixelSize;
            }
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            findViewById.setPadding(dimenPixelSize, findViewById.getPaddingTop(), dimenPixelSize, findViewById.getPaddingBottom());
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams4.width = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds150);
            layoutParams4.rightMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = 0;
        }
    }

    @Override // c.a.s0.z2.r.d
    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
        }
    }

    @Override // c.a.s0.z2.r.d
    public void y0() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (pVar = this.c0) == null) {
            return;
        }
        p b2 = pVar.b();
        b2.a = "pb";
        h.e(b2.m, "", "2", b2, this.v.getPcdnState());
    }
}
