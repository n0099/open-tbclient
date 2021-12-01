package c.a.r0.q2.u.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.r0.q2.f;
import c.a.r0.q2.g;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f21726b;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f21727c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f21728d;

    /* renamed from: e  reason: collision with root package name */
    public ViewStub f21729e;

    /* renamed from: f  reason: collision with root package name */
    public View f21730f;

    /* renamed from: g  reason: collision with root package name */
    public View f21731g;

    /* renamed from: h  reason: collision with root package name */
    public View f21732h;

    /* renamed from: i  reason: collision with root package name */
    public PbLandscapeListView f21733i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f21734j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.r0.q2.u.e.b f21735k;
    public View l;

    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f21736e;

        public a(d dVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21736e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || (runnable = this.f21736e) == null) {
                return;
            }
            runnable.run();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (runnable = this.f21736e) == null) {
                return;
            }
            runnable.run();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f21737e;

        public b(d dVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21737e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || (runnable = this.f21737e) == null) {
                return;
            }
            runnable.run();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (runnable = this.f21737e) == null) {
                return;
            }
            runnable.run();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2056279838, "Lc/a/r0/q2/u/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2056279838, "Lc/a/r0/q2/u/e/d;");
                return;
            }
        }
        m = l.f(TbadkCoreApplication.getInst(), g.ds160);
    }

    public d(PbFragment pbFragment, ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, viewStub};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f21726b = 3;
        this.f21732h = null;
        this.f21727c = pbFragment;
        this.f21729e = viewStub;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.a = i2;
            this.f21727c.getBaseFragmentActivity().getLayoutMode().j(this.f21730f);
            this.f21734j.onChangeSkinType(this.f21727c.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.l, f.cp_bg_line_k_alpha40);
            this.f21728d.onChangeSkinType(this.f21727c.getPageContext(), i2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f21735k.R();
            } else {
                this.f21735k.f();
            }
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21732h : (View) invokeV.objValue;
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21733i : (BdTypeListView) invokeV.objValue;
    }

    public c.a.r0.q2.u.e.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21735k : (c.a.r0.q2.u.e.b) invokeV.objValue;
    }

    public NavigationBar g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21734j : (NavigationBar) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.f21733i;
            if (pbLandscapeListView == null || pbLandscapeListView.getChildCount() <= 0) {
                return true;
            }
            return this.f21733i.getFirstVisiblePosition() <= 0 && (childAt = this.f21733i.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && m()) {
            this.f21730f.setVisibility(8);
            this.f21734j.setStatusBarVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || m()) {
            return;
        }
        this.f21730f = this.f21729e.inflate();
        k();
        int i2 = this.a;
        int i3 = this.f21726b;
        if (i2 != i3) {
            a(i3);
        }
    }

    public final void k() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (view = this.f21730f) == null) {
            return;
        }
        this.f21733i = (PbLandscapeListView) view.findViewById(i.more_god_reply_list);
        this.f21731g = this.f21730f.findViewById(i.more_god_reply_list_content);
        l();
        this.l = this.f21730f.findViewById(i.more_god_reply_back_curtain);
        this.f21728d = (NoNetworkView) this.f21730f.findViewById(i.more_god_reply_view_no_network);
        c.a.r0.q2.u.e.b bVar = new c.a.r0.q2.u.e.b(this.f21727c.getPageContext());
        this.f21735k = bVar;
        this.f21733i.setNextPage(bVar);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f21730f.findViewById(i.more_god_reply_nav_bar);
            this.f21734j = navigationBar;
            this.f21732h = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ImageView backImageView = this.f21734j.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f21732h.getLayoutParams();
                int f2 = l.f(TbadkCoreApplication.getInst(), g.ds30);
                layoutParams.height = f2;
                layoutParams.width = f2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.f21732h;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f21732h.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                this.f21732h.setPadding(l.f(TbadkCoreApplication.getInst(), g.ds32), this.f21732h.getPaddingTop(), this.f21732h.getPaddingRight(), this.f21732h.getPaddingBottom());
                this.f21732h.setLayoutParams(layoutParams2);
            }
            if (this.f21734j.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21734j.getBackImageView(), h.icon_pure_topbar_close44_svg, f.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f21730f != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? m() && this.f21730f.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f21726b = i2;
            if (m()) {
                a(i2);
            }
        }
    }

    public void p() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            j();
            if (n() || (view = this.f21730f) == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    public void q(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, runnable) == null) && m()) {
            this.f21731g.setTranslationY(l.p(this.f21727c.getContext())[1]);
            this.l.setAlpha(0.0f);
            s(m, 1.0f, runnable);
        }
    }

    public void r(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, runnable) == null) && m()) {
            s(this.f21731g.getHeight(), 0.0f, runnable);
        }
    }

    public final void s(float f2, float f3, Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), runnable}) == null) && m()) {
            this.f21731g.animate().translationY(f2).setDuration(300L).setListener(new b(this, runnable)).start();
            this.l.animate().alpha(f3).setDuration(300L).start();
        }
    }

    public void t(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, runnable) == null) && m()) {
            this.f21734j.setStatusBarVisibility(0);
            this.f21731g.animate().translationY(0.0f).setDuration(300L).setListener(new a(this, runnable)).start();
        }
    }
}
