package b.a.r0.x0.z2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.x0.a1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
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
/* loaded from: classes6.dex */
public class b implements b.a.r0.x0.y1.e.c, b.a.r0.x0.w2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f28420a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f28421b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f28422c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f28423d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f28424e;

    /* renamed from: f  reason: collision with root package name */
    public int f28425f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28426g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f28427h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f28428i;
    public EntelechyPullUpRefreshView j;
    public boolean k;
    public View.OnClickListener l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28429e;

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
            this.f28429e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f28429e.f28420a == null) {
                return;
            }
            if (view == this.f28429e.f28428i) {
                TiebaStatic.eventStat(this.f28429e.f28420a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (this.f28429e.f28420a.getIsRefresh() || this.f28429e.f28420a.getFrsView() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f28429e.f28420a.getFid()).param("obj_locate", "3"));
                this.f28429e.f28420a.getFrsView().Q1();
            } else if (view != this.f28429e.j || this.f28429e.f28420a.getFrsView() == null || this.f28429e.f28420a.getFrsView().a0() == null) {
            } else {
                this.f28429e.f28420a.getFrsView().a0().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: b.a.r0.x0.z2.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class animation.Animation$AnimationListenerC1391b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f28430a;

        public animation.Animation$AnimationListenerC1391b(View view) {
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
            this.f28430a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f28430a) != null && view.getAnimation() == animation) {
                this.f28430a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f28430a) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f28431a;

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
            this.f28431a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && (view = this.f28431a) != null && view.getAnimation() == animation) {
                this.f28431a.clearAnimation();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (view = this.f28431a) == null) {
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
        this.f28422c = null;
        this.f28425f = 3;
        this.f28426g = false;
        this.f28427h = null;
        this.f28428i = null;
        this.j = null;
        this.k = true;
        this.l = new a(this);
        this.f28420a = frsFragment;
        this.f28421b = noPressedRelativeLayout;
        i();
        this.f28427h = (LinearLayout) this.f28421b.findViewById(f1.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f28421b.findViewById(f1.frs_stick_bottom_goto_top);
        this.f28428i = (EntelechyPullUpRefreshView) this.f28421b.findViewById(f1.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.f28428i.setOnClickListener(this.l);
        onChangeSkinType(this.f28425f);
    }

    @Override // b.a.r0.x0.y1.e.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f28426g = z;
            if (this.f28428i != null) {
                if (z) {
                    LinearLayout linearLayout = this.f28427h;
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

    @Override // b.a.r0.x0.y1.e.c
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f28426g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f28427h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f28427h.setVisibility(8);
        }
    }

    @Override // b.a.r0.x0.y1.e.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f28428i == null) {
                return false;
            }
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.w2.d
    public void d() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbImageView = this.f28422c) == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f28422c.setImageDrawable(null);
        this.f28422c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linearLayout = this.f28427h) == null) {
            return;
        }
        linearLayout.clearAnimation();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28422c = new TbImageView(this.f28420a.getPageContext().getPageActivity());
            int g2 = b.a.e.f.p.l.g(this.f28420a.getPageContext().getPageActivity(), d1.ds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = g2;
            this.f28422c.setLayoutParams(layoutParams);
            this.f28421b.addView(this.f28422c);
            this.f28422c.setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f28420a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f28420a.getPageContext().getPageActivity(), a1.frs_pull_up_refresh_out);
            this.f28423d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1391b(this.f28427h));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f28420a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f28420a.getPageContext().getPageActivity(), a1.frs_pull_up_refresh_in);
            this.f28424e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f28427h));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            if (this.f28423d == null) {
                j();
            }
            Animation animation = this.f28423d;
            if (animation == null) {
                return;
            }
            this.f28427h.startAnimation(animation);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            if (this.f28424e == null) {
                k();
            }
            if (this.f28424e == null) {
                return;
            }
            this.f28427h.setVisibility(0);
            this.f28427h.startAnimation(this.f28424e);
        }
    }

    @Override // b.a.r0.x0.y1.e.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f28425f == i2) {
            return;
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f28428i;
        if (entelechyPullUpRefreshView != null) {
            entelechyPullUpRefreshView.onChangeSkinType(i2);
        }
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
        if (entelechyPullUpRefreshView2 != null) {
            entelechyPullUpRefreshView2.onChangeSkinType(i2);
        }
        this.f28425f = i2;
    }
}
