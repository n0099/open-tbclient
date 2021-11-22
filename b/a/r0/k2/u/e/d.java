package b.a.r0.k2.u.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f20511a;

    /* renamed from: b  reason: collision with root package name */
    public int f20512b;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f20513c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f20514d;

    /* renamed from: e  reason: collision with root package name */
    public ViewStub f20515e;

    /* renamed from: f  reason: collision with root package name */
    public View f20516f;

    /* renamed from: g  reason: collision with root package name */
    public View f20517g;

    /* renamed from: h  reason: collision with root package name */
    public View f20518h;

    /* renamed from: i  reason: collision with root package name */
    public PbLandscapeListView f20519i;
    public NavigationBar j;
    public b.a.r0.k2.u.e.b k;
    public View l;

    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f20520e;

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
            this.f20520e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || (runnable = this.f20520e) == null) {
                return;
            }
            runnable.run();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (runnable = this.f20520e) == null) {
                return;
            }
            runnable.run();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f20521e;

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
            this.f20521e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || (runnable = this.f20521e) == null) {
                return;
            }
            runnable.run();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (runnable = this.f20521e) == null) {
                return;
            }
            runnable.run();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(526638905, "Lb/a/r0/k2/u/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(526638905, "Lb/a/r0/k2/u/e/d;");
                return;
            }
        }
        m = l.g(TbadkCoreApplication.getInst(), g.ds160);
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
        this.f20511a = 3;
        this.f20512b = 3;
        this.f20518h = null;
        this.f20513c = pbFragment;
        this.f20515e = viewStub;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f20511a = i2;
            this.f20513c.getBaseFragmentActivity().getLayoutMode().j(this.f20516f);
            this.j.onChangeSkinType(this.f20513c.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.l, f.cp_bg_line_k_alpha40);
            this.f20514d.onChangeSkinType(this.f20513c.getPageContext(), i2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.k.R();
            } else {
                this.k.f();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20518h : (View) invokeV.objValue;
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20519i : (BdTypeListView) invokeV.objValue;
    }

    public b.a.r0.k2.u.e.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (b.a.r0.k2.u.e.b) invokeV.objValue;
    }

    public NavigationBar g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (NavigationBar) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.f20519i;
            if (pbLandscapeListView == null || pbLandscapeListView.getChildCount() <= 0) {
                return true;
            }
            return this.f20519i.getFirstVisiblePosition() <= 0 && (childAt = this.f20519i.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && m()) {
            this.f20516f.setVisibility(8);
            this.j.setStatusBarVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || m()) {
            return;
        }
        this.f20516f = this.f20515e.inflate();
        k();
        int i2 = this.f20511a;
        int i3 = this.f20512b;
        if (i2 != i3) {
            a(i3);
        }
    }

    public final void k() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (view = this.f20516f) == null) {
            return;
        }
        this.f20519i = (PbLandscapeListView) view.findViewById(i.more_god_reply_list);
        this.f20517g = this.f20516f.findViewById(i.more_god_reply_list_content);
        l();
        this.l = this.f20516f.findViewById(i.more_god_reply_back_curtain);
        this.f20514d = (NoNetworkView) this.f20516f.findViewById(i.more_god_reply_view_no_network);
        b.a.r0.k2.u.e.b bVar = new b.a.r0.k2.u.e.b(this.f20513c.getPageContext());
        this.k = bVar;
        this.f20519i.setNextPage(bVar);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f20516f.findViewById(i.more_god_reply_nav_bar);
            this.j = navigationBar;
            this.f20518h = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ImageView backImageView = this.j.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20518h.getLayoutParams();
                int g2 = l.g(TbadkCoreApplication.getInst(), g.ds30);
                layoutParams.height = g2;
                layoutParams.width = g2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.f20518h;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f20518h.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                this.f20518h.setPadding(l.g(TbadkCoreApplication.getInst(), g.ds32), this.f20518h.getPaddingTop(), this.f20518h.getPaddingRight(), this.f20518h.getPaddingBottom());
                this.f20518h.setLayoutParams(layoutParams2);
            }
            if (this.j.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j.getBackImageView(), h.icon_pure_topbar_close44_svg, f.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f20516f != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? m() && this.f20516f.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f20512b = i2;
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
            if (n() || (view = this.f20516f) == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    public void q(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, runnable) == null) && m()) {
            this.f20517g.setTranslationY(l.p(this.f20513c.getContext())[1]);
            this.l.setAlpha(0.0f);
            s(m, 1.0f, runnable);
        }
    }

    public void r(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, runnable) == null) && m()) {
            s(this.f20517g.getHeight(), 0.0f, runnable);
        }
    }

    public final void s(float f2, float f3, Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), runnable}) == null) && m()) {
            this.f20517g.animate().translationY(f2).setDuration(300L).setListener(new b(this, runnable)).start();
            this.l.animate().alpha(f3).setDuration(300L).start();
        }
    }

    public void t(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, runnable) == null) && m()) {
            this.j.setStatusBarVisibility(0);
            this.f20517g.animate().translationY(0.0f).setDuration(300L).setListener(new a(this, runnable)).start();
        }
    }
}
