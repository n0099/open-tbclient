package c.a.p0.v0.o2;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.v0.r0;
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
    public FrsFragment f26462a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedAdSlideLoadingLayout f26463b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f26464c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f26465d;

    /* renamed from: e  reason: collision with root package name */
    public r0 f26466e;

    /* renamed from: f  reason: collision with root package name */
    public int f26467f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.s.f0.q.c f26468g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.s.f0.q.b f26469h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.o0.s.f0.q.a f26470i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f26471j;

    /* loaded from: classes4.dex */
    public class a implements c.a.o0.s.f0.q.c {
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

        @Override // c.a.o0.s.f0.q.c
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.o0.s.f0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f26472a;

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
            this.f26472a = kVar;
        }

        @Override // c.a.o0.s.f0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.o0.s.f0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26472a.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.o0.s.f0.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f26473a;

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
            this.f26473a = kVar;
        }

        @Override // c.a.o0.s.f0.q.a
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.o0.s.f0.q.a
        public void b(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.o0.s.f0.q.a
        public void c(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.o0.s.f0.q.a
        public void d(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f26473a.f26466e == null) {
                return;
            }
            this.f26473a.f26466e.onLoadingComplete();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f26474e;

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
            this.f26474e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26474e.f26463b.endLoading();
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
        this.f26468g = new a(this);
        this.f26469h = new b(this);
        this.f26470i = new c(this);
        this.f26471j = new d(this);
        this.f26462a = frsFragment;
        View rootView = frsFragment.getRootView();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) rootView.findViewById(R.id.frs_content_layout);
        this.f26463b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.addScrollListener(this.f26468g);
        this.f26463b.addLoadingListener(this.f26469h);
        this.f26463b.addAnimationListener(this.f26470i);
        this.f26463b.bringLoadViewToFront();
        this.f26464c = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.f26465d = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
    }

    public void d(c.a.o0.s.q.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar != null && !c.a.e.e.p.k.isEmpty(dVar.f13875b) && !c.a.e.e.p.k.isEmpty(dVar.f13874a) && dVar.f13876c >= 0) {
                if (this.f26463b.isLoading()) {
                    this.f26463b.endLoading();
                }
                this.f26463b.bindAdData(dVar, (ViewGroup) this.f26462a.getActivity().getWindow().getDecorView());
                this.f26463b.setAdvancedAdStyle(true);
                this.f26463b.setNavigationBar((NavigationBar) this.f26462a.getActivity().findViewById(R.id.view_navigation_bar));
                return;
            }
            this.f26463b.setAdvancedAdStyle(false);
        }
    }

    public void e() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (advancedAdSlideLoadingLayout = this.f26463b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.closeCompleteAd();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.e.e.m.e.a().postDelayed(this.f26471j, 5000L);
            r0 r0Var = this.f26466e;
            if (r0Var != null) {
                r0Var.onPullRefresh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public r0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26466e : (r0) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26463b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26463b.isLoading() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26463b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View findViewById = this.f26462a.getRootView().findViewById(R.id.head_top_bg_container);
            TbImageView tbImageView = (TbImageView) this.f26462a.getActivity().findViewById(R.id.head_top_advanced_ad_bg);
            if (findViewById == null) {
                return;
            }
            this.f26463b.setBgView(findViewById);
            if (this.f26463b.getAdvancedAdView() == null) {
                this.f26463b.setAdvancedAdView(tbImageView, findViewById.getLayoutParams().height, c.a.e.e.p.l.k(this.f26462a.getContext()));
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f26463b.addSyncHeightView(this.f26462a.getRootView().findViewById(R.id.frs_header_empty_view), 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f26463b.endLoading();
            c.a.e.e.m.e.a().removeCallbacks(this.f26471j);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f26467f = i2;
        }
    }

    public void o(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, r0Var) == null) {
            this.f26466e = r0Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f26463b.setEnableSlideLoading(z);
        }
    }

    public void q(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 == this.f26467f) {
            if (z) {
                t();
                return;
            }
            this.f26465d.getAdapter().notifyDataSetChanged();
            u();
        }
    }

    public void r(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (advancedAdSlideLoadingLayout = this.f26463b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f26463b.getData() == null || !this.f26463b.isAdvancedAdStyle() || c.a.o0.s.d0.b.j().g("key_frs_advanced_ad_guide", false)) {
            return;
        }
        c.a.o0.s.d0.b.j().t("key_frs_advanced_ad_guide", true);
        this.f26463b.showGuideAnim();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f26463b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.isEnable()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f26465d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.f26464c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.f26463b.startLoading();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f26463b.isLoading()) {
            this.f26463b.endLoading();
            c.a.e.e.m.e.a().removeCallbacks(this.f26471j);
        }
    }
}
