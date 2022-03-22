package c.a.p0.p2.d;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import c.a.o0.t.i;
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
/* loaded from: classes2.dex */
public class b implements c.a.p0.p2.d.a, f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NearbyFriendsActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.p2.c.a f16909b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16910c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f16911d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f16912e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f16913f;

    /* renamed from: g  reason: collision with root package name */
    public g f16914g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f16915h;
    public c.a.p0.p2.a.a i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f16913f != null) {
                    this.a.f16913f.stopScroll();
                }
                if (!(this.a.f16915h == null && this.a.a == null && this.a.f16909b == null) && l.z()) {
                    this.a.f16915h.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.f16915h.C(null);
                    if (this.a.f16909b.hasMore()) {
                        this.a.f16915h.O();
                        this.a.f16909b.loadMore();
                    }
                }
            }
        }
    }

    /* renamed from: c.a.p0.p2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1270b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1270b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f16913f != null) {
                    this.a.f16913f.stopScroll();
                }
                this.a.z();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nearbyFriendsActivity;
    }

    @Override // c.a.p0.p2.d.a
    public void a() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.f16911d) == null) {
            return;
        }
        nearbyFriendsActivity.showLoadingView(frameLayout);
    }

    @Override // c.a.p0.p2.d.a
    public void b(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdSwipeRefreshLayout = this.f16912e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    @Override // c.a.p0.p2.d.a
    public void c() {
        c.a.p0.p2.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f16909b) == null || this.a == null) {
            return;
        }
        aVar.reload();
    }

    @Override // c.a.p0.p2.d.a
    public void d() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.f16911d) == null) {
            return;
        }
        nearbyFriendsActivity.hideLoadingView(frameLayout);
    }

    @Override // c.a.p0.p2.d.a
    public void f(boolean z, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, list) == null) || this.f16913f == null || list == null) {
            return;
        }
        c.a.p0.p2.a.a aVar = this.i;
        if (aVar != null) {
            aVar.i0(z);
        }
        this.f16913f.setData(list);
    }

    @Override // c.a.p0.p2.d.a
    public void g(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (pbListView = this.f16915h) == null) {
            return;
        }
        pbListView.D(str);
        this.f16915h.C(t());
    }

    @Override // c.a.p0.p2.d.a
    public void h(int i) {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        NavigationBar navigationBar = this.f16910c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(nearbyFriendsActivity.getPageContext(), i);
        }
        g gVar = this.f16914g;
        if (gVar != null) {
            gVar.H(i);
        }
        PbListView pbListView = this.f16915h;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f16915h.d(i);
        }
    }

    @Override // c.a.p0.p2.d.a
    public void i() {
        c.a.p0.p2.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.i) == null) {
            return;
        }
        aVar.i0(false);
    }

    @Override // c.a.p0.p2.d.a
    public void j(int i) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (bdSwipeRefreshLayout = this.f16912e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(i);
    }

    @Override // c.a.p0.p2.d.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            z();
        }
    }

    @Override // c.a.p0.p2.d.a
    public void l(c.a.p0.p2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f16909b = aVar;
        }
    }

    @Override // c.a.p0.p2.d.a
    public void m() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.f16911d) == null) {
            return;
        }
        nearbyFriendsActivity.hideNetRefreshView(frameLayout);
    }

    @Override // c.a.p0.p2.d.a
    public void n(String str) {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.f16911d) == null) {
            return;
        }
        nearbyFriendsActivity.showNetRefreshView(frameLayout, str, false);
    }

    @Override // c.a.p0.p2.d.a
    public void onCreate() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        this.f16910c = (NavigationBar) nearbyFriendsActivity.findViewById(R.id.obfuscated_res_0x7f091519);
        this.f16911d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906cd);
        this.f16912e = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091a2e);
        this.f16913f = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f091530);
        w();
        y();
        x();
        v();
        this.f16909b.reload();
    }

    @Override // c.a.p0.p2.d.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            g gVar = this.f16914g;
            if (gVar != null) {
                gVar.f(null);
            }
            PbListView pbListView = this.f16915h;
            if (pbListView != null) {
                pbListView.C(null);
            }
            this.a = null;
        }
    }

    @Override // c.a.o0.r.l0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f16909b.refresh();
        }
    }

    public final View.OnClickListener t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new a(this) : (View.OnClickListener) invokeV.objValue;
    }

    public final BdListView.p u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new C1270b(this) : (BdListView.p) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.a == null) {
            return;
        }
        PbListView pbListView = new PbListView(this.a);
        this.f16915h = pbListView;
        pbListView.b();
        this.f16915h.p(R.color.transparent);
        this.f16915h.t(c.a.d.f.p.n.f(this.a, R.dimen.tbds182));
        this.f16915h.y();
        this.f16915h.H(R.dimen.tbfontsize36);
        this.f16915h.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f16915h.B(R.color.CAM_X0110);
        this.f16915h.s();
        this.f16915h.C(t());
    }

    public final void w() {
        NearbyFriendsActivity nearbyFriendsActivity;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (nearbyFriendsActivity = this.a) == null || (navigationBar = this.f16910c) == null) {
            return;
        }
        navigationBar.setCenterTextTitle(nearbyFriendsActivity.getString(R.string.obfuscated_res_0x7f0f0c08));
        this.f16910c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public final void x() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (nearbyFriendsActivity = this.a) == null || this.f16912e == null) {
            return;
        }
        g gVar = new g(nearbyFriendsActivity.getPageContext());
        this.f16914g = gVar;
        gVar.f(this);
        this.f16912e.setProgressView(this.f16914g);
    }

    public final void y() {
        BdTypeRecyclerView bdTypeRecyclerView;
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bdTypeRecyclerView = this.f16913f) == null || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(nearbyFriendsActivity));
        this.f16913f.setFadingEdgeLength(0);
        this.f16913f.setOverScrollMode(2);
        this.f16913f.setOnSrollToBottomListener(u());
        ArrayList arrayList = new ArrayList();
        c.a.p0.p2.a.a aVar = new c.a.p0.p2.a.a(this.a, i.l, 2);
        this.i = aVar;
        arrayList.add(aVar);
        this.f16913f.a(arrayList);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.f16915h == null || this.f16909b == null || this.a == null) {
            return;
        }
        if (!l.z()) {
            this.f16913f.setNextPage(null);
            return;
        }
        this.f16913f.setNextPage(this.f16915h);
        this.f16915h.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f16915h.C(null);
        if (this.f16909b.hasMore()) {
            this.f16915h.q(false);
            this.f16915h.O();
            this.f16909b.loadMore();
            return;
        }
        this.f16915h.q(true);
        this.f16915h.D(this.a.getString(R.string.obfuscated_res_0x7f0f0c0d));
        this.f16915h.f();
    }
}
