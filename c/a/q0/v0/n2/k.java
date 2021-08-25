package c.a.q0.v0.n2;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.v0.r0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.AdvancedAdSlideLoadingLayout;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26796a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedAdSlideLoadingLayout f26797b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f26798c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f26799d;

    /* renamed from: e  reason: collision with root package name */
    public r0 f26800e;

    /* renamed from: f  reason: collision with root package name */
    public int f26801f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.f0.q.c f26802g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.s.f0.q.b f26803h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.s.f0.q.a f26804i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f26805j;

    /* loaded from: classes4.dex */
    public class a implements c.a.p0.s.f0.q.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.f0.q.c
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.p0.s.f0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f26806a;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26806a = kVar;
        }

        @Override // c.a.p0.s.f0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.p0.s.f0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26806a.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.p0.s.f0.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f26807a;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26807a = kVar;
        }

        @Override // c.a.p0.s.f0.q.a
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.p0.s.f0.q.a
        public void b(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.p0.s.f0.q.a
        public void c(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.p0.s.f0.q.a
        public void d(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f26807a.f26800e == null) {
                return;
            }
            this.f26807a.f26800e.onLoadingComplete();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f26808e;

        public d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26808e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26808e.f26797b.endLoading();
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26802g = new a(this);
        this.f26803h = new b(this);
        this.f26804i = new c(this);
        this.f26805j = new d(this);
        this.f26796a = frsFragment;
        View rootView = frsFragment.getRootView();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) rootView.findViewById(R.id.frs_content_layout);
        this.f26797b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.addScrollListener(this.f26802g);
        this.f26797b.addLoadingListener(this.f26803h);
        this.f26797b.addAnimationListener(this.f26804i);
        this.f26797b.bringLoadViewToFront();
        this.f26798c = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.f26799d = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
    }

    public void d(c.a.p0.s.q.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar != null && !c.a.e.e.p.k.isEmpty(dVar.f14179b) && !c.a.e.e.p.k.isEmpty(dVar.f14178a) && dVar.f14180c >= 0) {
                if (this.f26797b.isLoading()) {
                    this.f26797b.endLoading();
                }
                this.f26797b.bindAdData(dVar, (ViewGroup) this.f26796a.getActivity().getWindow().getDecorView());
                this.f26797b.setAdvancedAdStyle(true);
                this.f26797b.setNavigationBar((NavigationBar) this.f26796a.getActivity().findViewById(R.id.view_navigation_bar));
                return;
            }
            this.f26797b.setAdvancedAdStyle(false);
        }
    }

    public void e() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (advancedAdSlideLoadingLayout = this.f26797b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.closeCompleteAd();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.e.e.m.e.a().postDelayed(this.f26805j, 5000L);
            r0 r0Var = this.f26800e;
            if (r0Var != null) {
                r0Var.onPullRefresh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public r0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26800e : (r0) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26797b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26797b.isLoading() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26797b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View findViewById = this.f26796a.getRootView().findViewById(R.id.head_top_bg_container);
            TbImageView tbImageView = (TbImageView) this.f26796a.getActivity().findViewById(R.id.head_top_advanced_ad_bg);
            if (findViewById == null) {
                return;
            }
            this.f26797b.setBgView(findViewById);
            if (this.f26797b.getAdvancedAdView() == null) {
                this.f26797b.setAdvancedAdView(tbImageView, findViewById.getLayoutParams().height, c.a.e.e.p.l.k(this.f26796a.getContext()));
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f26797b.addSyncHeightView(this.f26796a.getRootView().findViewById(R.id.frs_header_empty_view), 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f26797b.endLoading();
            c.a.e.e.m.e.a().removeCallbacks(this.f26805j);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f26801f = i2;
        }
    }

    public void o(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, r0Var) == null) {
            this.f26800e = r0Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f26797b.setEnableSlideLoading(z);
        }
    }

    public void q(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 == this.f26801f) {
            if (z) {
                t();
                return;
            }
            this.f26799d.getAdapter().notifyDataSetChanged();
            u();
        }
    }

    public void r(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (advancedAdSlideLoadingLayout = this.f26797b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f26797b.getData() == null || !this.f26797b.isAdvancedAdStyle() || c.a.p0.s.d0.b.j().g("key_frs_advanced_ad_guide", false)) {
            return;
        }
        c.a.p0.s.d0.b.j().t("key_frs_advanced_ad_guide", true);
        this.f26797b.showGuideAnim();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f26797b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.isEnable()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f26799d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.f26798c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.f26797b.startLoading();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f26797b.isLoading()) {
            this.f26797b.endLoading();
            c.a.e.e.m.e.a().removeCallbacks(this.f26805j);
        }
    }
}
