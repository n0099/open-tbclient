package c.a.t0.d1.a3;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.a1;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
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
public class b implements c.a.t0.d1.z1.e.c, c.a.t0.d1.x2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f15693b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f15694c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f15695d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f15696e;

    /* renamed from: f  reason: collision with root package name */
    public int f15697f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15698g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15699h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f15700i;

    /* renamed from: j  reason: collision with root package name */
    public EntelechyPullUpRefreshView f15701j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15702e;

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
            this.f15702e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15702e.a == null) {
                return;
            }
            if (view == this.f15702e.f15700i) {
                TiebaStatic.eventStat(this.f15702e.a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f15702e.a.getIsRefresh() || this.f15702e.a.getFrsView() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f15702e.a.getFid()).param("obj_locate", "3"));
                this.f15702e.a.getFrsView().Q1();
            } else if (view != this.f15702e.f15701j || this.f15702e.a.getFrsView() == null || this.f15702e.a.getFrsView().a0() == null) {
            } else {
                this.f15702e.a.getFrsView().a0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: c.a.t0.d1.a3.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class animation.Animation$AnimationListenerC1008b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public animation.Animation$AnimationListenerC1008b(View view) {
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
        this.f15694c = null;
        this.f15697f = 3;
        this.f15698g = false;
        this.f15699h = null;
        this.f15700i = null;
        this.f15701j = null;
        this.k = true;
        this.l = new a(this);
        this.a = frsFragment;
        this.f15693b = noPressedRelativeLayout;
        i();
        this.f15699h = (LinearLayout) this.f15693b.findViewById(f1.frs_stick_bottom_holder);
        this.f15701j = (EntelechyPullUpRefreshView) this.f15693b.findViewById(f1.frs_stick_bottom_goto_top);
        this.f15700i = (EntelechyPullUpRefreshView) this.f15693b.findViewById(f1.frs_stick_bottom_reload);
        this.f15701j.setOnClickListener(this.l);
        this.f15700i.setOnClickListener(this.l);
        onChangeSkinType(this.f15697f);
    }

    @Override // c.a.t0.d1.z1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f15698g = z;
            if (this.f15700i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f15699h;
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

    @Override // c.a.t0.d1.z1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f15698g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f15699h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f15699h.setVisibility(8);
        }
    }

    @Override // c.a.t0.d1.z1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f15700i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.d1.x2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f15694c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f15694c.setImageDrawable(null);
        this.f15694c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f15699h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15694c = new TbImageView(this.a.getPageContext().getPageActivity());
            int f2 = c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), d1.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f2, f2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = f2;
            this.f15694c.setLayoutParams(layoutParams);
            this.f15693b.addView(this.f15694c);
            this.f15694c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getPageContext().getPageActivity(), a1.frs_pull_up_refresh_out);
            this.f15695d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1008b(this.f15699h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getPageContext().getPageActivity(), a1.frs_pull_up_refresh_in);
            this.f15696e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f15699h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f15695d == null) {
                j();
            }
            Animation animation = this.f15695d;
            if (animation == null) {
                return;
            }
            this.f15699h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f15696e == null) {
                k();
            }
            if (this.f15696e == null) {
                return;
            }
            this.f15699h.setVisibility(0);
            this.f15699h.startAnimation(this.f15696e);
        }
    }

    @Override // c.a.t0.d1.z1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f15697f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f15700i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.onChangeSkinType(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.f15701j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.onChangeSkinType(i2);
        }
        this.f15697f = i2;
    }
}
