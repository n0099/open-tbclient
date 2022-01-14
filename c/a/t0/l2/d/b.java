package c.a.t0.l2.d;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.s0.s.j0.f;
import c.a.s0.s.j0.g;
import c.a.s0.u.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.nearby.NearbyFriendsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements c.a.t0.l2.d.a, f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NearbyFriendsActivity f19124e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.l2.c.a f19125f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f19126g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f19127h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwipeRefreshLayout f19128i;

    /* renamed from: j  reason: collision with root package name */
    public BdTypeRecyclerView f19129j;
    public g k;
    public PbListView l;
    public c.a.t0.l2.a.a m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19130e;

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
            this.f19130e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19130e.f19129j != null) {
                    this.f19130e.f19129j.stopScroll();
                }
                if (!(this.f19130e.l == null && this.f19130e.f19124e == null && this.f19130e.f19125f == null) && l.z()) {
                    this.f19130e.l.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f19130e.l.C(null);
                    if (this.f19130e.f19125f.hasMore()) {
                        this.f19130e.l.O();
                        this.f19130e.f19125f.loadMore();
                    }
                }
            }
        }
    }

    /* renamed from: c.a.t0.l2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1196b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19131e;

        public C1196b(b bVar) {
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
            this.f19131e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19131e.f19129j != null) {
                    this.f19131e.f19129j.stopScroll();
                }
                this.f19131e.x();
            }
        }
    }

    public b(NearbyFriendsActivity nearbyFriendsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nearbyFriendsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19124e = nearbyFriendsActivity;
    }

    @Override // c.a.t0.l2.d.a
    public void a() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nearbyFriendsActivity = this.f19124e) == null || (frameLayout = this.f19127h) == null) {
            return;
        }
        nearbyFriendsActivity.showLoadingView(frameLayout);
    }

    @Override // c.a.t0.l2.d.a
    public void b(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdSwipeRefreshLayout = this.f19128i) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    @Override // c.a.t0.l2.d.a
    public void c() {
        c.a.t0.l2.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f19125f) == null || this.f19124e == null) {
            return;
        }
        aVar.reload();
    }

    @Override // c.a.t0.l2.d.a
    public void d(boolean z, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048579, this, z, list) == null) || this.f19129j == null || list == null) {
            return;
        }
        c.a.t0.l2.a.a aVar = this.m;
        if (aVar != null) {
            aVar.i0(z);
        }
        this.f19129j.setData(list);
    }

    @Override // c.a.t0.l2.d.a
    public void e(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.D(str);
        this.l.C(r());
    }

    @Override // c.a.t0.l2.d.a
    public void f(int i2) {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (nearbyFriendsActivity = this.f19124e) == null) {
            return;
        }
        NavigationBar navigationBar = this.f19126g;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(nearbyFriendsActivity.getPageContext(), i2);
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.C(i2);
        }
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.l.d(i2);
        }
    }

    @Override // c.a.t0.l2.d.a
    public void g() {
        c.a.t0.l2.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.i0(false);
    }

    @Override // c.a.t0.l2.d.a
    public void h(int i2) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bdSwipeRefreshLayout = this.f19128i) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(i2);
    }

    @Override // c.a.t0.l2.d.a
    public void hideLoadingView() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (nearbyFriendsActivity = this.f19124e) == null || (frameLayout = this.f19127h) == null) {
            return;
        }
        nearbyFriendsActivity.hideLoadingView(frameLayout);
    }

    @Override // c.a.t0.l2.d.a
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            x();
        }
    }

    @Override // c.a.t0.l2.d.a
    public void j(c.a.t0.l2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f19125f = aVar;
        }
    }

    @Override // c.a.t0.l2.d.a
    public void k() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (nearbyFriendsActivity = this.f19124e) == null || (frameLayout = this.f19127h) == null) {
            return;
        }
        nearbyFriendsActivity.hideNetRefreshView(frameLayout);
    }

    @Override // c.a.t0.l2.d.a
    public void l(String str) {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (nearbyFriendsActivity = this.f19124e) == null || (frameLayout = this.f19127h) == null) {
            return;
        }
        nearbyFriendsActivity.showNetRefreshView(frameLayout, str, false);
    }

    @Override // c.a.t0.l2.d.a
    public void onCreate() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (nearbyFriendsActivity = this.f19124e) == null) {
            return;
        }
        this.f19126g = (NavigationBar) nearbyFriendsActivity.findViewById(R.id.navigation_bar);
        this.f19127h = (FrameLayout) this.f19124e.findViewById(R.id.container_fl);
        this.f19128i = (BdSwipeRefreshLayout) this.f19124e.findViewById(R.id.refresh_layout);
        this.f19129j = (BdTypeRecyclerView) this.f19124e.findViewById(R.id.nearby_friends_recyclerview);
        u();
        w();
        v();
        t();
        this.f19125f.reload();
    }

    @Override // c.a.t0.l2.d.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            g gVar = this.k;
            if (gVar != null) {
                gVar.a(null);
            }
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.C(null);
            }
            this.f19124e = null;
        }
    }

    @Override // c.a.s0.s.j0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f19125f.refresh();
        }
    }

    public final View.OnClickListener r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new a(this) : (View.OnClickListener) invokeV.objValue;
    }

    public final BdListView.p s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new C1196b(this) : (BdListView.p) invokeV.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f19124e == null) {
            return;
        }
        PbListView pbListView = new PbListView(this.f19124e);
        this.l = pbListView;
        pbListView.b();
        this.l.p(R.color.transparent);
        this.l.t(c.a.d.f.p.n.f(this.f19124e, R.dimen.tbds182));
        this.l.y();
        this.l.H(R.dimen.tbfontsize36);
        this.l.F(SkinManager.getColor(R.color.CAM_X0107));
        this.l.B(R.color.CAM_X0110);
        this.l.s();
        this.l.C(r());
    }

    public final void u() {
        NearbyFriendsActivity nearbyFriendsActivity;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (nearbyFriendsActivity = this.f19124e) == null || (navigationBar = this.f19126g) == null) {
            return;
        }
        navigationBar.setCenterTextTitle(nearbyFriendsActivity.getString(R.string.nearby_friends));
        this.f19126g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public final void v() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (nearbyFriendsActivity = this.f19124e) == null || this.f19128i == null) {
            return;
        }
        g gVar = new g(nearbyFriendsActivity.getPageContext());
        this.k = gVar;
        gVar.a(this);
        this.f19128i.setProgressView(this.k);
    }

    public final void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bdTypeRecyclerView = this.f19129j) == null || (nearbyFriendsActivity = this.f19124e) == null) {
            return;
        }
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(nearbyFriendsActivity));
        this.f19129j.setFadingEdgeLength(0);
        this.f19129j.setOverScrollMode(2);
        this.f19129j.setOnSrollToBottomListener(s());
        ArrayList arrayList = new ArrayList();
        c.a.t0.l2.a.a aVar = new c.a.t0.l2.a.a(this.f19124e, i.p, 2);
        this.m = aVar;
        arrayList.add(aVar);
        this.f19129j.addAdapters(arrayList);
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.l == null || this.f19125f == null || this.f19124e == null) {
            return;
        }
        if (!l.z()) {
            this.f19129j.setNextPage(null);
            return;
        }
        this.f19129j.setNextPage(this.l);
        this.l.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.l.C(null);
        if (this.f19125f.hasMore()) {
            this.l.q(false);
            this.l.O();
            this.f19125f.loadMore();
            return;
        }
        this.l.q(true);
        this.l.D(this.f19124e.getString(R.string.nearby_friends_no_more));
        this.l.f();
    }
}
