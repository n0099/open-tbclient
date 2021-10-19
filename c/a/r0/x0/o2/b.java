package c.a.r0.x0.o2;

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
public class b implements c.a.r0.x0.n1.e.c, c.a.r0.x0.l2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f27564a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f27565b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f27566c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f27567d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f27568e;

    /* renamed from: f  reason: collision with root package name */
    public int f27569f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27570g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f27571h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f27572i;

    /* renamed from: j  reason: collision with root package name */
    public EntelechyPullUpRefreshView f27573j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27574e;

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
            this.f27574e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27574e.f27564a == null) {
                return;
            }
            if (view == this.f27574e.f27572i) {
                TiebaStatic.eventStat(this.f27574e.f27564a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f27574e.f27564a.getIsRefresh() || this.f27574e.f27564a.getFrsView() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f27574e.f27564a.getFid()).param("obj_locate", "3"));
                this.f27574e.f27564a.getFrsView().R1();
            } else if (view != this.f27574e.f27573j || this.f27574e.f27564a.getFrsView() == null || this.f27574e.f27564a.getFrsView().b0() == null) {
            } else {
                this.f27574e.f27564a.getFrsView().b0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: c.a.r0.x0.o2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1295b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f27575a;

        public animation.Animation$AnimationListenerC1295b(View view) {
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
            this.f27575a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f27575a) != null && view.getAnimation() == animation) {
                this.f27575a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f27575a) == null) {
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
        public View f27576a;

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
            this.f27576a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f27576a) != null && view.getAnimation() == animation) {
                this.f27576a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f27576a) == null) {
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
        this.f27566c = null;
        this.f27569f = 3;
        this.f27570g = false;
        this.f27571h = null;
        this.f27572i = null;
        this.f27573j = null;
        this.k = true;
        this.l = new a(this);
        this.f27564a = frsFragment;
        this.f27565b = noPressedRelativeLayout;
        i();
        this.f27571h = (LinearLayout) this.f27565b.findViewById(R.id.frs_stick_bottom_holder);
        this.f27573j = (EntelechyPullUpRefreshView) this.f27565b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.f27572i = (EntelechyPullUpRefreshView) this.f27565b.findViewById(R.id.frs_stick_bottom_reload);
        this.f27573j.setOnClickListener(this.l);
        this.f27572i.setOnClickListener(this.l);
        onChangeSkinType(this.f27569f);
    }

    @Override // c.a.r0.x0.n1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f27570g = z;
            if (this.f27572i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f27571h;
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

    @Override // c.a.r0.x0.n1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f27570g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f27571h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f27571h.setVisibility(8);
        }
    }

    @Override // c.a.r0.x0.n1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f27572i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.x0.l2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f27566c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f27566c.setImageDrawable(null);
        this.f27566c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f27571h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f27566c = new TbImageView(this.f27564a.getPageContext().getPageActivity());
            int g2 = c.a.e.e.p.l.g(this.f27564a.getPageContext().getPageActivity(), R.dimen.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = g2;
            this.f27566c.setLayoutParams(layoutParams);
            this.f27565b.addView(this.f27566c);
            this.f27566c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f27564a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f27564a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f27567d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1295b(this.f27571h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f27564a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f27564a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f27568e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f27571h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f27567d == null) {
                j();
            }
            Animation animation = this.f27567d;
            if (animation == null) {
                return;
            }
            this.f27571h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f27568e == null) {
                k();
            }
            if (this.f27568e == null) {
                return;
            }
            this.f27571h.setVisibility(0);
            this.f27571h.startAnimation(this.f27568e);
        }
    }

    @Override // c.a.r0.x0.n1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f27569f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f27572i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.onChangeSkinType(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.f27573j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.onChangeSkinType(i2);
        }
        this.f27569f = i2;
    }
}
