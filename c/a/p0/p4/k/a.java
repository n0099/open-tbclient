package c.a.p0.p4.k;

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
import c.a.p0.c3.j;
import c.a.p0.c3.u;
import c.a.p0.p4.d.c;
import c.a.p0.w2.i.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
public class a extends c.a.p0.c3.w.d {
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
    public c.a.p0.p4.d.c c1;
    public d d1;
    public Runnable e1;
    public Runnable f1;

    /* renamed from: c.a.p0.p4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1281a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC1281a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.X0 && (this.a.O instanceof Activity)) {
                this.a.E0();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.p4.d.c.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.b1 == null || this.a.c1 == null) {
                return;
            }
            if (z) {
                this.a.b1.Z();
                if (this.a.t.getControl().isPlaying()) {
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

    /* loaded from: classes2.dex */
    public interface d {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view, int i) {
        super(tbPageContext.getPageActivity(), view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.N0 = 0;
        this.e1 = new RunnableC1281a(this);
        this.f1 = new b(this);
        this.Q0 = tbPageContext;
        this.R0 = bdUniqueId;
        this.R = bdUniqueId;
        this.T0 = i;
        O();
        this.W0 = TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) || TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity());
        W(true);
        X(true);
        this.i0 = false;
    }

    public f D0() {
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

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            UtilHelper.hideStatusBar((Activity) this.O, this.U0);
            this.X0 = false;
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            W(false);
            X(false);
            this.d1 = null;
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            c.a.p0.p4.d.c cVar = this.c1;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    public void G0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoItemData) == null) || videoItemData == null) {
            return;
        }
        this.S0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void H0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.d1 = dVar;
        }
    }

    public void I0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.a1 = fVar;
        }
    }

    public final void J0() {
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

    public final void K0() {
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

    @Override // c.a.p0.c3.w.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.f13522b & (-33);
            this.f13522b = i;
            int i2 = this.o & (-33);
            this.o = i2;
            int i3 = this.f13524d & (-33);
            this.f13524d = i3;
            int i4 = this.f13525e & (-33);
            this.f13525e = i4;
            int i5 = this.n & (-33);
            this.n = i5;
            int i6 = this.f13526f & (-33);
            this.f13526f = i6;
            int i7 = this.f13527g & (-33);
            this.f13527g = i7;
            int i8 = this.f13528h & (-33);
            this.f13528h = i8;
            int i9 = this.i & (-33);
            this.i = i9;
            int i10 = this.j & (-33);
            this.j = i10;
            int i11 = this.k & (-33);
            this.k = i11;
            this.f13522b = i | 1024;
            this.o = i2 | 1024;
            int i12 = i3 | 1024;
            this.f13524d = i12;
            this.f13525e = i4 & (-1025);
            this.n = i5 & (-1025);
            this.f13526f = i6 | 1024;
            this.f13527g = i7 | 1024;
            int i13 = i8 | 1024;
            this.f13528h = i13;
            int i14 = i9 | 1024;
            this.i = i14;
            this.j = i10 | 1024;
            this.k = i11 & (-1025);
            this.f13524d = i12 | 16384;
            this.f13528h = i13 | 16384;
            this.i = i14 & (-2);
        }
    }

    @Override // c.a.p0.c3.w.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).q(this.T, this.Y);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i = 0;
            int f2 = (this.Y && this.T) ? n.f(this.O, R.dimen.tbds42) : 0;
            if (this.Y && !this.T) {
                i = n.f(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = f2;
            layoutParams.rightMargin = i;
        }
    }

    @Override // c.a.p0.c3.w.d
    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            Context context = this.O;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.Y);
            }
            super.U(z);
            if (this.Y) {
                this.Q.setVisibility(0);
                p0();
            } else {
                this.Q.setVisibility(8);
                this.Q.removeView(this.t);
            }
            d dVar = this.d1;
            if (dVar != null) {
                dVar.a(this.Y);
            }
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                if (this.Y) {
                    videoDanmuController.b0(this.a1);
                } else {
                    videoDanmuController.c0();
                }
            }
        }
    }

    @Override // c.a.p0.c3.w.d
    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.obfuscated_res_0x7f0d064b : invokeV.intValue;
    }

    @Override // c.a.p0.c3.w.d
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.c0();
            this.u.s();
            this.u.setDrawCorner(false);
            this.M0 = n.k(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // c.a.p0.c3.w.d
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.p0.c3.w.d
    public boolean e0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) ? this.Y || motionEvent.getX() > ((float) this.M0) : invokeL.booleanValue;
    }

    @Override // c.a.p0.c3.w.d
    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.d
    public void n0(int i) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            int i2 = this.p;
            int i3 = this.k;
            if (i2 != i3 && i == i3) {
                e.a().removeCallbacks(this.e1);
                int i4 = this.p;
                if ((i4 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i4 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.n0(i);
            if (!this.Y) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i5 = i & 16384;
                operableVideoMediaControllerView.setVisibility((i5 > 0 || (i & 128) > 0) ? 0 : 8);
                ((VideoMediaController) this.F).setBottomBarShow(i5 > 0);
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f092321)) != null) {
                findViewById.setVisibility((i & 64) > 0 ? 0 : 8);
            }
            if (!this.Y && !this.W0 && (this.O instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.X0) {
                        K0();
                        UtilHelper.showStatusBar((Activity) this.O, this.U0);
                        this.X0 = true;
                        e.a().removeCallbacks(this.f1);
                        e.a().postDelayed(this.f1, 3000L);
                    }
                } else if (this.X0) {
                    E0();
                }
            }
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                if (i != this.f13524d && i != this.f13526f) {
                    videoDanmuController.R();
                } else {
                    this.b1.U();
                }
            }
        }
    }

    @Override // c.a.p0.c3.w.d, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.p4.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.obfuscated_res_0x7f091853) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.obfuscated_res_0x7f092321 && (cVar = this.c1) != null) {
            cVar.i();
            VideoItemData videoItemData = this.S0;
            if (videoItemData != null) {
                this.c1.e(videoItemData.thread_id, this.T0);
            }
        }
        super.onClick(view);
    }

    @Override // c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            e.a().removeCallbacks(this.e1);
            e.a().postDelayed(this.e1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.d, c.a.p0.c3.w.a
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) || threadData == null) {
            return;
        }
        u uVar = new u();
        uVar.a = "6";
        uVar.f13504c = threadData.getTid();
        uVar.f13505d = Long.toString(threadData.getFid());
        uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
        uVar.x = this.S0.getChannelMidRequestNum();
        uVar.y = this.S0.getChannelMidRequestVideoNum();
        Context context = this.O;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.N0 = intExtra;
                if (intExtra == 0) {
                    this.N0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.O0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    uVar.k = this.O0;
                }
                uVar.i = Integer.toString(this.N0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P0 = stringExtra2;
                uVar.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            uVar.m = threadData.getThreadVideoInfo().video_md5;
            uVar.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(uVar);
        if (this.Y && threadData.getThreadVideoInfo() != null) {
            if (this.T != (threadData.getThreadVideoInfo().is_vertical.intValue() == 1)) {
                T();
            }
        }
        super.setData(threadData);
        W(!this.T);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.U) && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.Q0, this.R0, this.Q, R.id.obfuscated_res_0x7f092322, this.S0, this.T0);
            this.b1 = videoDanmuController;
            videoDanmuController.W(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f092328);
        View findViewById2 = this.Q.findViewById(R.id.obfuscated_res_0x7f092344);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            c.a.p0.p4.d.c cVar = this.c1;
            if (cVar != null) {
                cVar.f();
                this.c1 = null;
            }
            c.a.p0.p4.d.c cVar2 = new c.a.p0.p4.d.c(this.Q, R.id.obfuscated_res_0x7f092321);
            this.c1 = cVar2;
            cVar2.g(this);
            this.c1.h(new c(this));
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

    @Override // c.a.p0.c3.w.d
    public void t0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    @Override // c.a.p0.c3.w.d
    public void u0() {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (uVar = this.Z) == null) {
            return;
        }
        u b2 = uVar.b();
        b2.a = "pb";
        j.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
    }
}
