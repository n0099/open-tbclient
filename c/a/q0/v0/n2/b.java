package c.a.q0.v0.n2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements c.a.q0.v0.m1.e.c, c.a.q0.v0.k2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26699a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f26700b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f26701c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f26702d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f26703e;

    /* renamed from: f  reason: collision with root package name */
    public int f26704f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26705g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f26706h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f26707i;

    /* renamed from: j  reason: collision with root package name */
    public EntelechyPullUpRefreshView f26708j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26709e;

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
            this.f26709e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26709e.f26699a == null) {
                return;
            }
            if (view == this.f26709e.f26707i) {
                TiebaStatic.eventStat(this.f26709e.f26699a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f26709e.f26699a.getIsRefresh() || this.f26709e.f26699a.getFrsView() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f26709e.f26699a.getFid()).param("obj_locate", "3"));
                this.f26709e.f26699a.getFrsView().R1();
            } else if (view != this.f26709e.f26708j || this.f26709e.f26699a.getFrsView() == null || this.f26709e.f26699a.getFrsView().b0() == null) {
            } else {
                this.f26709e.f26699a.getFrsView().b0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: c.a.q0.v0.n2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1248b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26710a;

        public animation.Animation$AnimationListenerC1248b(View view) {
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
            this.f26710a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f26710a) != null && view.getAnimation() == animation) {
                this.f26710a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f26710a) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26711a;

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
            this.f26711a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f26711a) != null && view.getAnimation() == animation) {
                this.f26711a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f26711a) == null) {
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
        this.f26701c = null;
        this.f26704f = 3;
        this.f26705g = false;
        this.f26706h = null;
        this.f26707i = null;
        this.f26708j = null;
        this.k = true;
        this.l = new a(this);
        this.f26699a = frsFragment;
        this.f26700b = noPressedRelativeLayout;
        i();
        this.f26706h = (LinearLayout) this.f26700b.findViewById(R.id.frs_stick_bottom_holder);
        this.f26708j = (EntelechyPullUpRefreshView) this.f26700b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.f26707i = (EntelechyPullUpRefreshView) this.f26700b.findViewById(R.id.frs_stick_bottom_reload);
        this.f26708j.setOnClickListener(this.l);
        this.f26707i.setOnClickListener(this.l);
        onChangeSkinType(this.f26704f);
    }

    @Override // c.a.q0.v0.m1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f26705g = z;
            if (this.f26707i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f26706h;
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

    @Override // c.a.q0.v0.m1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f26705g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f26706h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f26706h.setVisibility(8);
        }
    }

    @Override // c.a.q0.v0.m1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f26707i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.v0.k2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f26701c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f26701c.setImageDrawable(null);
        this.f26701c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f26706h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f26701c = new TbImageView(this.f26699a.getPageContext().getPageActivity());
            int g2 = c.a.e.e.p.l.g(this.f26699a.getPageContext().getPageActivity(), R.dimen.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = g2;
            this.f26701c.setLayoutParams(layoutParams);
            this.f26700b.addView(this.f26701c);
            this.f26701c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f26699a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f26699a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f26702d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1248b(this.f26706h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f26699a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f26699a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f26703e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f26706h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f26702d == null) {
                j();
            }
            Animation animation = this.f26702d;
            if (animation == null) {
                return;
            }
            this.f26706h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f26703e == null) {
                k();
            }
            if (this.f26703e == null) {
                return;
            }
            this.f26706h.setVisibility(0);
            this.f26706h.startAnimation(this.f26703e);
        }
    }

    @Override // c.a.q0.v0.m1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f26704f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f26707i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.onChangeSkinType(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.f26708j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.onChangeSkinType(i2);
        }
        this.f26704f = i2;
    }
}
