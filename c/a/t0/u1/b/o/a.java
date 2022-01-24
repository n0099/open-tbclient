package c.a.t0.u1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.d.n.e.v;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f24022b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f24023c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f24024d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f24025e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f24026f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f24027g;

    /* renamed from: h  reason: collision with root package name */
    public g f24028h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f24029i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f24030j;
    public boolean k;
    public c.a.t0.u1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: c.a.t0.u1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1461a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24031e;

        public View$OnClickListenerC1461a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24031e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24031e.f24029i == null || this.f24031e.m == null) {
                return;
            }
            this.f24031e.f24029i.M(0);
            this.f24031e.f24029i.C(null);
            this.f24031e.f24029i.R();
            this.f24031e.m.b();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24032e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24032e = aVar;
        }

        @Override // c.a.s0.s.k0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    if (this.f24032e.m != null) {
                        this.f24032e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f24032e.f24026f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24033e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24033e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24033e.f24029i == null || this.f24033e.m == null) {
                return;
            }
            this.f24033e.f24029i.M(0);
            this.f24033e.f24029i.C(null);
            this.f24033e.f24029i.O();
            this.f24033e.m.b();
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void b();
    }

    public a(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new View$OnClickListenerC1461a(this);
        this.o = new b(this);
        this.a = tbPageContext;
        this.f24022b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new c.a.t0.u1.b.p.d(tbPageContext, this.f24027g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f24028h;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoNetworkView noNetworkView = this.f24024d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i2);
            }
            PbListView pbListView = this.f24029i;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f24029i.d(i2);
            }
            NoDataView noDataView = this.f24030j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.a, i2);
                SkinManager.setBackgroundColor(this.f24030j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f24023c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i2);
            }
            c.a.t0.u1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f24022b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f24025e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f24026f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f24027g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24025e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f24027g;
            if (bdTypeRecyclerView == null) {
                return null;
            }
            return bdTypeRecyclerView.getData();
        }
        return (List) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24022b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f24022b == null) {
            return;
        }
        if (this.f24028h == null) {
            g gVar = new g(tbPageContext);
            this.f24028h = gVar;
            gVar.a(this.o);
        }
        this.f24028h.V(tbPageContext.getUniqueId());
        if (this.f24029i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f24029i = pbListView;
            pbListView.b();
        }
        this.f24029i.p(R.color.CAM_X0205);
        this.f24029i.t(c.a.d.f.p.n.f(tbPageContext.getContext(), R.dimen.tbds182));
        this.f24029i.y();
        this.f24029i.H(R.dimen.tbfontsize33);
        this.f24029i.F(SkinManager.getColor(R.color.CAM_X0109));
        this.f24029i.B(R.color.CAM_X0110);
        this.f24029i.C(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f24022b.findViewById(R.id.no_networkview);
        this.f24024d = noNetworkView;
        noNetworkView.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        this.f24025e = (RelativeLayout) this.f24022b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f24022b.findViewById(R.id.view_navigation_bar);
        this.f24023c = navigationBar;
        navigationBar.showBottomLine();
        this.f24023c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24023c.setCenterTextTitle(this.a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f24022b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f24026f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f24028h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f24022b.findViewById(R.id.agree_me_recycler_view);
        this.f24027g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f24027g.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f24027g.setFadingEdgeLength(0);
        this.f24027g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f24027g.setOverScrollMode(2);
        this.f24027g.addItemDecoration(new DeviderLineDecoration());
        this.f24027g.setRecyclerListener(new c(this));
        this.f24027g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.t0.u1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f24028h;
            if (gVar != null) {
                gVar.T();
            }
        }
    }

    public void i(v vVar) {
        c.a.t0.u1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, vVar) == null) || (dVar = this.l) == null) {
            return;
        }
        dVar.e(vVar);
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void k(boolean z, ArrayList<n> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f24026f) == null || this.f24029i == null || this.f24027g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f24029i.M(0);
            this.f24029i.f();
            this.f24029i.C(this.n);
        } else {
            this.f24029i.M(0);
            this.f24029i.f();
            this.f24029i.D(this.a.getResources().getString(R.string.list_no_more));
            this.f24029i.C(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f24030j == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.agree_me_nodata)), null);
                this.f24030j = a;
                a.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f24030j, R.color.CAM_X0201);
            }
            if (this.f24030j.getParent() == null && !this.k) {
                this.k = true;
                this.f24027g.addHeaderView(this.f24030j, 0);
                this.f24030j.setVisibility(0);
                this.f24030j.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f24027g.setNextPage(null);
            return;
        }
        this.f24027g.removeHeaderView(this.f24030j);
        this.k = false;
        this.f24027g.setNextPage(this.f24029i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f24026f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
