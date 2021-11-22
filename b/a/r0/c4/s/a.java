package b.a.r0.c4.s;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.e;
import b.a.e.f.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.c4.f;
import b.a.r0.c4.g;
import b.a.r0.q2.h;
import b.a.r0.q2.p;
import b.a.r0.q2.r.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.videoplay.videoview.VideoMediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int K0;
    public int L0;
    public String M0;
    public String N0;
    public View O0;
    public View P0;
    public boolean Q0;
    public boolean R0;
    public ObjectAnimator S0;
    public ObjectAnimator T0;
    public c U0;
    public Runnable V0;
    public Runnable W0;

    /* renamed from: b.a.r0.c4.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0833a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16708e;

        public RunnableC0833a(a aVar) {
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
            this.f16708e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16708e.L.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16709e;

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
            this.f16709e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16709e.R0 && (this.f16709e.P instanceof Activity)) {
                this.f16709e.D0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, View view) {
        super(context, view);
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.L0 = 0;
            this.V0 = new RunnableC0833a(this);
            this.W0 = new b(this);
            S();
            if (!TbSingleton.getInstance().isNotchScreen((Activity) context) && !TbSingleton.getInstance().isCutoutScreen((Activity) context)) {
                z = false;
                this.Q0 = z;
                a0(true);
                b0(true);
                this.j0 = false;
            }
            z = true;
            this.Q0 = z;
            a0(true);
            b0(true);
            this.j0 = false;
        } finally {
            TTIStats.record("OperableVideoController.<init>", System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            G0();
            UtilHelper.hideStatusBar((Activity) this.P, this.O0);
            this.R0 = false;
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a0(false);
            b0(false);
            this.U0 = null;
        }
    }

    @Override // b.a.r0.q2.r.d, b.a.r0.q2.r.a
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.changeVolume(this.P, true, 10);
            e.a().removeCallbacks(this.V0);
            e.a().postDelayed(this.V0, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void F0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.U0 = cVar;
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.T0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.P0, "alpha", 1.0f, 0.0f);
                this.T0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.T0.start();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.S0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.P0, "alpha", 0.0f, 1.0f);
                this.S0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.S0.start();
        }
    }

    @Override // b.a.r0.q2.r.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.f24428f & (-33);
            this.f24428f = i2;
            int i3 = this.f24429g & (-33);
            this.f24429g = i3;
            int i4 = this.f24430h & (-33);
            this.f24430h = i4;
            int i5 = this.f24431i & (-33);
            this.f24431i = i5;
            int i6 = this.j & (-33);
            this.j = i6;
            int i7 = this.k & (-33);
            this.k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            this.f24428f = i2 | 1024;
            int i11 = i3 | 1024;
            this.f24429g = i11;
            this.f24430h = i4 & (-1025);
            this.f24431i = i5 | 1024;
            this.j = i6 | 1024;
            int i12 = i7 | 1024;
            this.k = i12;
            int i13 = i8 | 1024;
            this.l = i13;
            this.m = i9 | 1024;
            this.n = i10 & (-1025);
            this.f24429g = i11 | 16384;
            this.k = i12 | 16384;
            this.l = i13 & (-2);
        }
    }

    @Override // b.a.r0.q2.r.d
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.H.changeViewLayout(this.U, this.a0);
            this.I.changeViewLayout(this.U, this.a0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).changeViewLayout(this.U, this.a0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            int i2 = 0;
            int g2 = (this.a0 && this.U) ? l.g(this.P, b.a.r0.c4.d.tbds42) : 0;
            if (this.a0 && !this.U) {
                i2 = l.g(this.P, b.a.r0.c4.d.tbds34);
            }
            layoutParams.bottomMargin = g2;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // b.a.r0.q2.r.d
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
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
            c cVar = this.U0;
            if (cVar != null) {
                cVar.a(this.a0);
            }
        }
    }

    @Override // b.a.r0.q2.r.d
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? g.operable_video_container : invokeV.intValue;
    }

    @Override // b.a.r0.q2.r.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.g0();
            this.v.clearCornerFlag();
            this.v.setDrawCorner(false);
            this.K0 = l.k(this.P) / 10;
            this.I.setShareFrom(18);
        }
    }

    @Override // b.a.r0.q2.r.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // b.a.r0.q2.r.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.K0) : invokeL.booleanValue;
    }

    @Override // b.a.r0.q2.r.d
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.r.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == f.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view);
    }

    @Override // b.a.r0.q2.r.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            int i3 = this.q;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.V0);
                int i5 = this.q;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.r0(i2);
            int i6 = 8;
            if (!this.a0) {
                this.J.setVisibility(8);
                this.K.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i7 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i7 > 0 || (i2 & 128) > 0) ? 0 : 0);
                ((VideoMediaController) this.G).setBottomBarShow(i7 > 0);
            }
            if (this.a0 || this.Q0 || !(this.P instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.R0) {
                    return;
                }
                H0();
                UtilHelper.showStatusBar((Activity) this.P, this.O0);
                this.R0 = true;
                e.a().removeCallbacks(this.W0);
                e.a().postDelayed(this.W0, 3000L);
            } else if (this.R0) {
                D0();
            }
        }
    }

    @Override // b.a.r0.q2.r.d, b.a.r0.q2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, d2Var) == null) || d2Var == null) {
            return;
        }
        d2Var.L();
        p pVar = new p();
        pVar.f24403a = "6";
        pVar.f24405c = d2Var.t1();
        pVar.f24406d = Long.toString(d2Var.T());
        pVar.f24407e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (d2Var.S1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.L0 = intExtra;
                if (intExtra == 0) {
                    this.L0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.M0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    pVar.k = this.M0;
                }
                pVar.f24411i = Integer.toString(this.L0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.N0 = stringExtra2;
                pVar.f24411i = stringExtra2;
            }
        }
        if (d2Var.r1() != null) {
            pVar.m = d2Var.r1().video_md5;
            pVar.p = String.valueOf(d2Var.r1().is_vertical);
        }
        G(pVar);
        if (this.a0 && d2Var.r1() != null) {
            if (this.U != (d2Var.r1().is_vertical.intValue() == 1)) {
                X();
            }
        }
        super.setData(d2Var);
        a0(!this.U);
        if (d2Var.J() != null) {
            d2Var.J().setIsLike(d2Var.J().hadConcerned());
        }
    }

    @Override // b.a.r0.q2.r.d
    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // b.a.r0.q2.r.d
    public void x0() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pVar = this.b0) == null) {
            return;
        }
        p b2 = pVar.b();
        b2.f24403a = "pb";
        h.e(b2.m, "", "2", b2, this.u.getPcdnState());
    }
}
