package c.a.q0.y3.j;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.e;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import c.a.q0.o2.h;
import c.a.q0.o2.o;
import c.a.q0.o2.q.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
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
    public int L0;
    public int M0;
    public String N0;
    public String O0;
    public View P0;
    public View Q0;
    public boolean R0;
    public boolean S0;
    public ObjectAnimator T0;
    public ObjectAnimator U0;
    public c V0;
    public Runnable W0;
    public Runnable X0;

    /* renamed from: c.a.q0.y3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1355a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29202e;

        public RunnableC1355a(a aVar) {
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
            this.f29202e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29202e.L.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29203e;

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
            this.f29203e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f29203e.S0 && (this.f29203e.P instanceof Activity)) {
                this.f29203e.D0();
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
            this.M0 = 0;
            this.W0 = new RunnableC1355a(this);
            this.X0 = new b(this);
            S();
            if (!TbSingleton.getInstance().isNotchScreen((Activity) context) && !TbSingleton.getInstance().isCutoutScreen((Activity) context)) {
                z = false;
                this.R0 = z;
                a0(true);
                b0(true);
                this.j0 = false;
            }
            z = true;
            this.R0 = z;
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
            UtilHelper.hideStatusBar((Activity) this.P, this.P0);
            this.S0 = false;
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a0(false);
            b0(false);
        }
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.changeVolume(this.P, true, 10);
            e.a().removeCallbacks(this.W0);
            e.a().postDelayed(this.W0, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void F0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.V0 = cVar;
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.U0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Q0, "alpha", 1.0f, 0.0f);
                this.U0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.U0.start();
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.T0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Q0, "alpha", 0.0f, 1.0f);
                this.T0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.T0.start();
        }
    }

    @Override // c.a.q0.o2.q.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.f23242f & (-33);
            this.f23242f = i2;
            int i3 = this.f23243g & (-33);
            this.f23243g = i3;
            int i4 = this.f23244h & (-33);
            this.f23244h = i4;
            int i5 = this.f23245i & (-33);
            this.f23245i = i5;
            int i6 = this.f23246j & (-33);
            this.f23246j = i6;
            int i7 = this.k & (-33);
            this.k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            this.f23242f = i2 | 1024;
            int i11 = i3 | 1024;
            this.f23243g = i11;
            this.f23244h = i4 & (-1025);
            this.f23245i = i5 | 1024;
            this.f23246j = i6 | 1024;
            int i12 = i7 | 1024;
            this.k = i12;
            int i13 = i8 | 1024;
            this.l = i13;
            this.m = i9 | 1024;
            this.n = i10 & (-1025);
            this.f23243g = i11 | 16384;
            this.k = i12 | 16384;
            this.l = i13 & (-2);
        }
    }

    @Override // c.a.q0.o2.q.d
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
            int g2 = (this.a0 && this.U) ? l.g(this.P, R.dimen.tbds42) : 0;
            if (this.a0 && !this.U) {
                i2 = l.g(this.P, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = g2;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // c.a.q0.o2.q.d
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
            c cVar = this.V0;
            if (cVar != null) {
                cVar.a(this.a0);
            }
        }
    }

    @Override // c.a.q0.o2.q.d
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.operable_video_container : invokeV.intValue;
    }

    @Override // c.a.q0.o2.q.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.g0();
            this.v.clearCornerFlag();
            this.v.setDrawCorner(false);
            this.L0 = l.k(this.P) / 10;
            this.I.setShareFrom(18);
        }
    }

    @Override // c.a.q0.o2.q.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.q0.o2.q.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.L0) : invokeL.booleanValue;
    }

    @Override // c.a.q0.o2.q.d
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view);
    }

    @Override // c.a.q0.o2.q.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            int i3 = this.q;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.W0);
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
            if (this.a0 || this.R0 || !(this.P instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.S0) {
                    return;
                }
                H0();
                UtilHelper.showStatusBar((Activity) this.P, this.P0);
                this.S0 = true;
                e.a().removeCallbacks(this.X0);
                e.a().postDelayed(this.X0, 3000L);
            } else if (this.S0) {
                D0();
            }
        }
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, c2Var) == null) || c2Var == null) {
            return;
        }
        c2Var.L();
        o oVar = new o();
        oVar.f23216a = "6";
        oVar.f23218c = c2Var.q1();
        oVar.f23219d = Long.toString(c2Var.T());
        oVar.f23220e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (c2Var.N1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.M0 = intExtra;
                if (intExtra == 0) {
                    this.M0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.N0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    oVar.k = this.N0;
                }
                oVar.f23224i = Integer.toString(this.M0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.O0 = stringExtra2;
                oVar.f23224i = stringExtra2;
            }
        }
        if (c2Var.o1() != null) {
            oVar.m = c2Var.o1().video_md5;
            oVar.p = String.valueOf(c2Var.o1().is_vertical);
        }
        G(oVar);
        if (this.a0 && c2Var.o1() != null) {
            if (this.U != (c2Var.o1().is_vertical.intValue() == 1)) {
                X();
            }
        }
        super.setData(c2Var);
        a0(!this.U);
        if (c2Var.J() != null) {
            c2Var.J().setIsLike(c2Var.J().hadConcerned());
        }
    }

    @Override // c.a.q0.o2.q.d
    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // c.a.q0.o2.q.d
    public void x0() {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (oVar = this.b0) == null) {
            return;
        }
        o b2 = oVar.b();
        b2.f23216a = "pb";
        h.e(b2.m, "", "2", b2, this.u.getPcdnState());
    }
}
