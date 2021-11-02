package b.a.r0.x0.y2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.z0;
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
/* loaded from: classes5.dex */
public class b implements b.a.r0.x0.x1.e.c, b.a.r0.x0.v2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26825a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f26826b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f26827c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f26828d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f26829e;

    /* renamed from: f  reason: collision with root package name */
    public int f26830f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26831g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f26832h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f26833i;
    public EntelechyPullUpRefreshView j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26834e;

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
            this.f26834e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26834e.f26825a == null) {
                return;
            }
            if (view == this.f26834e.f26833i) {
                TiebaStatic.eventStat(this.f26834e.f26825a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f26834e.f26825a.getIsRefresh() || this.f26834e.f26825a.getFrsView() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f26834e.f26825a.getFid()).param("obj_locate", "3"));
                this.f26834e.f26825a.getFrsView().Q1();
            } else if (view != this.f26834e.j || this.f26834e.f26825a.getFrsView() == null || this.f26834e.f26825a.getFrsView().a0() == null) {
            } else {
                this.f26834e.f26825a.getFrsView().a0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: b.a.r0.x0.y2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class animation.Animation$AnimationListenerC1318b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26835a;

        public animation.Animation$AnimationListenerC1318b(View view) {
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
            this.f26835a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f26835a) != null && view.getAnimation() == animation) {
                this.f26835a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f26835a) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26836a;

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
            this.f26836a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f26836a) != null && view.getAnimation() == animation) {
                this.f26836a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f26836a) == null) {
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
        this.f26827c = null;
        this.f26830f = 3;
        this.f26831g = false;
        this.f26832h = null;
        this.f26833i = null;
        this.j = null;
        this.k = true;
        this.l = new a(this);
        this.f26825a = frsFragment;
        this.f26826b = noPressedRelativeLayout;
        i();
        this.f26832h = (LinearLayout) this.f26826b.findViewById(e1.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f26826b.findViewById(e1.frs_stick_bottom_goto_top);
        this.f26833i = (EntelechyPullUpRefreshView) this.f26826b.findViewById(e1.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.f26833i.setOnClickListener(this.l);
        onChangeSkinType(this.f26830f);
    }

    @Override // b.a.r0.x0.x1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f26831g = z;
            if (this.f26833i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f26832h;
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

    @Override // b.a.r0.x0.x1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f26831g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f26832h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f26832h.setVisibility(8);
        }
    }

    @Override // b.a.r0.x0.x1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f26833i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.v2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f26827c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f26827c.setImageDrawable(null);
        this.f26827c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f26832h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f26827c = new TbImageView(this.f26825a.getPageContext().getPageActivity());
            int g2 = b.a.e.e.p.l.g(this.f26825a.getPageContext().getPageActivity(), c1.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = g2;
            this.f26827c.setLayoutParams(layoutParams);
            this.f26826b.addView(this.f26827c);
            this.f26827c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f26825a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f26825a.getPageContext().getPageActivity(), z0.frs_pull_up_refresh_out);
            this.f26828d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1318b(this.f26832h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f26825a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f26825a.getPageContext().getPageActivity(), z0.frs_pull_up_refresh_in);
            this.f26829e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f26832h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f26828d == null) {
                j();
            }
            Animation animation = this.f26828d;
            if (animation == null) {
                return;
            }
            this.f26832h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f26829e == null) {
                k();
            }
            if (this.f26829e == null) {
                return;
            }
            this.f26832h.setVisibility(0);
            this.f26832h.startAnimation(this.f26829e);
        }
    }

    @Override // b.a.r0.x0.x1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f26830f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f26833i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.onChangeSkinType(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.onChangeSkinType(i2);
        }
        this.f26830f = i2;
    }
}
