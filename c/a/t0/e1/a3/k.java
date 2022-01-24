package c.a.t0.e1.a3;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.e1.f1;
import c.a.t0.e1.s0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.AdvancedAdSlideLoadingLayout;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedAdSlideLoadingLayout f16099b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f16100c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f16101d;

    /* renamed from: e  reason: collision with root package name */
    public s0 f16102e;

    /* renamed from: f  reason: collision with root package name */
    public String f16103f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f16104g;

    /* renamed from: h  reason: collision with root package name */
    public int f16105h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.s.k0.q.c f16106i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s.k0.q.b f16107j;
    public c.a.s0.s.k0.q.a k;
    public Runnable l;

    /* loaded from: classes7.dex */
    public class a implements c.a.s0.s.k0.q.c {
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

        @Override // c.a.s0.s.k0.q.c
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.s0.s.k0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

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
            this.a = kVar;
        }

        @Override // c.a.s0.s.k0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.s0.s.k0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.s0.s.k0.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

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
            this.a = kVar;
        }

        @Override // c.a.s0.s.k0.q.a
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.s0.s.k0.q.a
        public void b(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.s0.s.k0.q.a
        public void c(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // c.a.s0.s.k0.q.a
        public void d(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.a.f16102e == null) {
                return;
            }
            this.a.f16102e.onLoadingComplete();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f16108e;

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
            this.f16108e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16108e.f16099b.endLoading();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends TypeToken<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(k kVar) {
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
        this.f16103f = "999999";
        this.f16106i = new a(this);
        this.f16107j = new b(this);
        this.k = new c(this);
        this.l = new d(this);
        this.a = frsFragment;
        View rootView = frsFragment.getRootView();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) rootView.findViewById(f1.frs_content_layout);
        this.f16099b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.addScrollListener(this.f16106i);
        this.f16099b.addLoadingListener(this.f16107j);
        this.f16099b.addAnimationListener(this.k);
        this.f16099b.bringLoadViewToFront();
        this.f16100c = (AppBarLayout) rootView.findViewById(f1.frs_app_bar_layout);
        this.f16101d = (BdTypeRecyclerView) rootView.findViewById(f1.frs_lv_thread);
    }

    public void d(c.a.s0.s.q.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar != null && !c.a.d.f.p.m.isEmpty(dVar.f13519b) && !c.a.d.f.p.m.isEmpty(dVar.a) && dVar.f13520c >= 0) {
                if (this.f16099b.isLoading()) {
                    this.f16099b.endLoading();
                }
                this.f16099b.bindAdData(dVar, (ViewGroup) this.a.getActivity().getWindow().getDecorView());
                this.f16099b.setAdvancedAdStyle(true);
                this.f16099b.setNavigationBar((NavigationBar) this.a.getActivity().findViewById(f1.view_navigation_bar));
                return;
            }
            this.f16099b.setAdvancedAdStyle(false);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = false;
            if (this.f16099b.getData() != null && this.f16099b.isAdvancedAdStyle()) {
                c.a.s0.s.q.d data = this.f16099b.getData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.f16103f;
                }
                String str = currentAccount + data.f13526i;
                List<String> list = (List) new Gson().fromJson(c.a.s0.s.i0.b.k().q("key_uid_adid", ""), new e(this).getType());
                this.f16104g = list;
                if (list == null) {
                    this.f16104g = new ArrayList();
                }
                Iterator<String> it = this.f16104g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringHelper.isTaday(c.a.s0.s.i0.b.k().m(next, 0L))) {
                        c.a.s0.s.i0.b.k().D(next);
                        it.remove();
                    }
                }
                if (!StringHelper.isTaday(c.a.s0.s.i0.b.k().m(str, 0L))) {
                    this.f16104g.add(str);
                    c.a.s0.s.i0.b.k().x(str, System.currentTimeMillis());
                    z = true;
                }
                c.a.s0.s.i0.b.k().y("key_uid_adid", this.f16104g.toString());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (advancedAdSlideLoadingLayout = this.f16099b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.closeCompleteAd();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.l, 5000L);
            s0 s0Var = this.f16102e;
            if (s0Var != null) {
                s0Var.onPullRefresh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public s0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16102e : (s0) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16099b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16099b.isLoading() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16099b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View findViewById = this.a.getRootView().findViewById(f1.head_top_bg_container);
            TbImageView tbImageView = (TbImageView) this.a.getActivity().findViewById(f1.head_top_advanced_ad_bg);
            if (findViewById == null) {
                return;
            }
            this.f16099b.setBgView(findViewById);
            if (this.f16099b.getAdvancedAdView() == null) {
                this.f16099b.setAdvancedAdView(tbImageView, findViewById.getLayoutParams().height, c.a.d.f.p.n.k(this.a.getContext()));
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16099b.addSyncHeightView(this.a.getRootView().findViewById(f1.frs_header_empty_view), 0);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16099b.endLoading();
            c.a.d.f.m.e.a().removeCallbacks(this.l);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f16105h = i2;
        }
    }

    public void p(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, s0Var) == null) {
            this.f16102e = s0Var;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f16099b.setEnableSlideLoading(z);
        }
    }

    public void r(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 == this.f16105h) {
            if (z) {
                u();
                return;
            }
            this.f16101d.getAdapter().notifyDataSetChanged();
            v();
        }
    }

    public void s(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (advancedAdSlideLoadingLayout = this.f16099b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && e()) {
            this.f16099b.showGuideAnim();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f16099b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.isEnable()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f16101d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.f16100c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.f16099b.startLoading();
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.f16099b.isLoading()) {
            this.f16099b.endLoading();
            c.a.d.f.m.e.a().removeCallbacks(this.l);
        }
    }
}
