package c.a.t0.e1.a3;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.e1.a1;
import c.a.t0.e1.d1;
import c.a.t0.e1.f1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements c.a.t0.e1.z1.e.c, c.a.t0.e1.x2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f16025b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f16026c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f16027d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f16028e;

    /* renamed from: f  reason: collision with root package name */
    public int f16029f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16030g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16031h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f16032i;

    /* renamed from: j  reason: collision with root package name */
    public EntelechyPullUpRefreshView f16033j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16034e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16034e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16034e.a == null) {
                return;
            }
            if (view == this.f16034e.f16032i) {
                TiebaStatic.eventStat(this.f16034e.a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f16034e.a.getIsRefresh() || this.f16034e.a.getFrsView() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f16034e.a.getFid()).param("obj_locate", "3"));
                this.f16034e.a.getFrsView().Q1();
            } else if (view != this.f16034e.f16033j || this.f16034e.a.getFrsView() == null || this.f16034e.a.getFrsView().a0() == null) {
            } else {
                this.f16034e.a.getFrsView().a0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: c.a.t0.e1.a3.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class animation.Animation$AnimationListenerC1023b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public animation.Animation$AnimationListenerC1023b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.a) != null && view.getAnimation() == animation) {
                this.a.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.a) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public c(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.a) != null && view.getAnimation() == animation) {
                this.a.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.a) == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16026c = null;
        this.f16029f = 3;
        this.f16030g = false;
        this.f16031h = null;
        this.f16032i = null;
        this.f16033j = null;
        this.k = true;
        this.l = new a(this);
        this.a = frsFragment;
        this.f16025b = noPressedRelativeLayout;
        i();
        this.f16031h = (LinearLayout) this.f16025b.findViewById(f1.frs_stick_bottom_holder);
        this.f16033j = (EntelechyPullUpRefreshView) this.f16025b.findViewById(f1.frs_stick_bottom_goto_top);
        this.f16032i = (EntelechyPullUpRefreshView) this.f16025b.findViewById(f1.frs_stick_bottom_reload);
        this.f16033j.setOnClickListener(this.l);
        this.f16032i.setOnClickListener(this.l);
        onChangeSkinType(this.f16029f);
    }

    @Override // c.a.t0.e1.z1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f16030g = z;
            if (this.f16032i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f16031h;
                    if (linearLayout == null || linearLayout.getVisibility() != 0) {
                        return;
                    }
                    l();
                    return;
                }
                m();
            }
        }
    }

    @Override // c.a.t0.e1.z1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f16030g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f16031h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f16031h.setVisibility(8);
        }
    }

    @Override // c.a.t0.e1.z1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f16032i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.e1.x2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f16026c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f16026c.setImageDrawable(null);
        this.f16026c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f16031h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16026c = new TbImageView(this.a.getPageContext().getPageActivity());
            int f2 = c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), d1.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f2, f2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = f2;
            this.f16026c.setLayoutParams(layoutParams);
            this.f16025b.addView(this.f16026c);
            this.f16026c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getPageContext().getPageActivity(), a1.frs_pull_up_refresh_out);
            this.f16027d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1023b(this.f16031h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getPageContext().getPageActivity(), a1.frs_pull_up_refresh_in);
            this.f16028e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f16031h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f16027d == null) {
                j();
            }
            Animation animation = this.f16027d;
            if (animation == null) {
                return;
            }
            this.f16031h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f16028e == null) {
                k();
            }
            if (this.f16028e == null) {
                return;
            }
            this.f16031h.setVisibility(0);
            this.f16031h.startAnimation(this.f16028e);
        }
    }

    @Override // c.a.t0.e1.z1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f16029f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f16032i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.onChangeSkinType(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.f16033j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.onChangeSkinType(i2);
        }
        this.f16029f = i2;
    }
}
