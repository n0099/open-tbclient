package b.a.r0.x0.y2;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.x0.e1;
import b.a.r0.x0.r0;
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
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26916a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedAdSlideLoadingLayout f26917b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f26918c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f26919d;

    /* renamed from: e  reason: collision with root package name */
    public r0 f26920e;

    /* renamed from: f  reason: collision with root package name */
    public String f26921f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f26922g;

    /* renamed from: h  reason: collision with root package name */
    public int f26923h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.s.g0.q.c f26924i;
    public b.a.q0.s.g0.q.b j;
    public b.a.q0.s.g0.q.a k;
    public Runnable l;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.s.g0.q.c {
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

        @Override // b.a.q0.s.g0.q.c
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.a.q0.s.g0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f26925a;

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
            this.f26925a = kVar;
        }

        @Override // b.a.q0.s.g0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // b.a.q0.s.g0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26925a.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b.a.q0.s.g0.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f26926a;

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
            this.f26926a = kVar;
        }

        @Override // b.a.q0.s.g0.q.a
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // b.a.q0.s.g0.q.a
        public void b(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // b.a.q0.s.g0.q.a
        public void c(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // b.a.q0.s.g0.q.a
        public void d(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f26926a.f26920e == null) {
                return;
            }
            this.f26926a.f26920e.onLoadingComplete();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f26927e;

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
            this.f26927e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26927e.f26917b.endLoading();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f26921f = "999999";
        this.f26924i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        this.l = new d(this);
        this.f26916a = frsFragment;
        View rootView = frsFragment.getRootView();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) rootView.findViewById(e1.frs_content_layout);
        this.f26917b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.addScrollListener(this.f26924i);
        this.f26917b.addLoadingListener(this.j);
        this.f26917b.addAnimationListener(this.k);
        this.f26917b.bringLoadViewToFront();
        this.f26918c = (AppBarLayout) rootView.findViewById(e1.frs_app_bar_layout);
        this.f26919d = (BdTypeRecyclerView) rootView.findViewById(e1.frs_lv_thread);
    }

    public void d(b.a.q0.s.q.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar != null && !b.a.e.e.p.k.isEmpty(dVar.f13260b) && !b.a.e.e.p.k.isEmpty(dVar.f13259a) && dVar.f13261c >= 0) {
                if (this.f26917b.isLoading()) {
                    this.f26917b.endLoading();
                }
                this.f26917b.bindAdData(dVar, (ViewGroup) this.f26916a.getActivity().getWindow().getDecorView());
                this.f26917b.setAdvancedAdStyle(true);
                this.f26917b.setNavigationBar((NavigationBar) this.f26916a.getActivity().findViewById(e1.view_navigation_bar));
                return;
            }
            this.f26917b.setAdvancedAdStyle(false);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = false;
            if (this.f26917b.getData() != null && this.f26917b.isAdvancedAdStyle()) {
                b.a.q0.s.q.d data = this.f26917b.getData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.f26921f;
                }
                String str = currentAccount + data.f13267i;
                List<String> list = (List) new Gson().fromJson(b.a.q0.s.e0.b.j().p("key_uid_adid", ""), new e(this).getType());
                this.f26922g = list;
                if (list == null) {
                    this.f26922g = new ArrayList();
                }
                Iterator<String> it = this.f26922g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringHelper.isTaday(b.a.q0.s.e0.b.j().l(next, 0L))) {
                        b.a.q0.s.e0.b.j().C(next);
                        it.remove();
                    }
                }
                if (!StringHelper.isTaday(b.a.q0.s.e0.b.j().l(str, 0L))) {
                    this.f26922g.add(str);
                    b.a.q0.s.e0.b.j().w(str, System.currentTimeMillis());
                    z = true;
                }
                b.a.q0.s.e0.b.j().x("key_uid_adid", this.f26922g.toString());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (advancedAdSlideLoadingLayout = this.f26917b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.closeCompleteAd();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.e.e.m.e.a().postDelayed(this.l, 5000L);
            r0 r0Var = this.f26920e;
            if (r0Var != null) {
                r0Var.onPullRefresh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public r0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26920e : (r0) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26917b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26917b.isLoading() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26917b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View findViewById = this.f26916a.getRootView().findViewById(e1.head_top_bg_container);
            TbImageView tbImageView = (TbImageView) this.f26916a.getActivity().findViewById(e1.head_top_advanced_ad_bg);
            if (findViewById == null) {
                return;
            }
            this.f26917b.setBgView(findViewById);
            if (this.f26917b.getAdvancedAdView() == null) {
                this.f26917b.setAdvancedAdView(tbImageView, findViewById.getLayoutParams().height, b.a.e.e.p.l.k(this.f26916a.getContext()));
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f26917b.addSyncHeightView(this.f26916a.getRootView().findViewById(e1.frs_header_empty_view), 0);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26917b.endLoading();
            b.a.e.e.m.e.a().removeCallbacks(this.l);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f26923h = i2;
        }
    }

    public void p(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, r0Var) == null) {
            this.f26920e = r0Var;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f26917b.setEnableSlideLoading(z);
        }
    }

    public void r(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 == this.f26923h) {
            if (z) {
                u();
                return;
            }
            this.f26919d.getAdapter().notifyDataSetChanged();
            v();
        }
    }

    public void s(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (advancedAdSlideLoadingLayout = this.f26917b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && e()) {
            this.f26917b.showGuideAnim();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f26917b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.isEnable()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f26919d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.f26918c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.f26917b.startLoading();
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.f26917b.isLoading()) {
            this.f26917b.endLoading();
            b.a.e.e.m.e.a().removeCallbacks(this.l);
        }
    }
}
