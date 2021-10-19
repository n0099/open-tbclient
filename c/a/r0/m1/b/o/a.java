package c.a.r0.m1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22186a;

    /* renamed from: b  reason: collision with root package name */
    public View f22187b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f22188c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f22189d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f22190e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f22191f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f22192g;

    /* renamed from: h  reason: collision with root package name */
    public g f22193h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f22194i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f22195j;
    public boolean k;
    public c.a.r0.m1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: c.a.r0.m1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1040a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22196e;

        public View$OnClickListenerC1040a(a aVar) {
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
            this.f22196e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22196e.f22194i == null || this.f22196e.m == null) {
                return;
            }
            this.f22196e.f22194i.J(0);
            this.f22196e.f22194i.z(null);
            this.f22196e.f22194i.O();
            this.f22196e.m.b();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22197e;

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
            this.f22197e = aVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f22197e.m != null) {
                        this.f22197e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f22197e.f22191f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22198e;

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
            this.f22198e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22198e.f22194i == null || this.f22198e.m == null) {
                return;
            }
            this.f22198e.f22194i.J(0);
            this.f22198e.f22194i.z(null);
            this.f22198e.f22194i.L();
            this.f22198e.m.b();
        }
    }

    /* loaded from: classes3.dex */
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
        this.n = new View$OnClickListenerC1040a(this);
        this.o = new b(this);
        this.f22186a = tbPageContext;
        this.f22187b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new c.a.r0.m1.b.p.d(tbPageContext, this.f22192g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f22193h;
            if (gVar != null) {
                gVar.D(i2);
            }
            NoNetworkView noNetworkView = this.f22189d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f22186a, i2);
            }
            PbListView pbListView = this.f22194i;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f22194i.d(i2);
            }
            NoDataView noDataView = this.f22195j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f22186a, i2);
                SkinManager.setBackgroundColor(this.f22195j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f22188c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f22186a, i2);
            }
            c.a.r0.m1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f22187b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22190e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22191f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22192g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22190e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f22192g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22187b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f22187b == null) {
            return;
        }
        if (this.f22193h == null) {
            g gVar = new g(tbPageContext);
            this.f22193h = gVar;
            gVar.a(this.o);
        }
        this.f22193h.V(tbPageContext.getUniqueId());
        if (this.f22194i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f22194i = pbListView;
            pbListView.b();
        }
        this.f22194i.o(R.color.CAM_X0205);
        this.f22194i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f22194i.v();
        this.f22194i.E(R.dimen.tbfontsize33);
        this.f22194i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f22194i.y(R.color.CAM_X0110);
        this.f22194i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f22187b.findViewById(R.id.no_networkview);
        this.f22189d = noNetworkView;
        noNetworkView.onChangeSkinType(this.f22186a, TbadkCoreApplication.getInst().getSkinType());
        this.f22190e = (RelativeLayout) this.f22187b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f22187b.findViewById(R.id.view_navigation_bar);
        this.f22188c = navigationBar;
        navigationBar.showBottomLine();
        this.f22188c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f22188c.setCenterTextTitle(this.f22186a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f22187b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f22191f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f22193h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f22187b.findViewById(R.id.agree_me_recycler_view);
        this.f22192g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f22192g.setLayoutManager(new LinearLayoutManager(this.f22186a.getContext()));
        this.f22192g.setFadingEdgeLength(0);
        this.f22192g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f22192g.setOverScrollMode(2);
        this.f22192g.addItemDecoration(new DeviderLineDecoration());
        this.f22192g.setRecyclerListener(new c(this));
        this.f22192g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.m1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f22193h;
            if (gVar != null) {
                gVar.T();
            }
        }
    }

    public void i(w wVar) {
        c.a.r0.m1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, wVar) == null) || (dVar = this.l) == null) {
            return;
        }
        dVar.e(wVar);
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f22191f) == null || this.f22194i == null || this.f22192g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f22194i.J(0);
            this.f22194i.f();
            this.f22194i.z(this.n);
        } else {
            this.f22194i.J(0);
            this.f22194i.f();
            this.f22194i.A(this.f22186a.getResources().getString(R.string.list_no_more));
            this.f22194i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f22195j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f22186a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f22186a.getResources().getString(R.string.agree_me_nodata)), null);
                this.f22195j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f22195j, R.color.CAM_X0201);
            }
            if (this.f22195j.getParent() == null && !this.k) {
                this.k = true;
                this.f22192g.addHeaderView(this.f22195j, 0);
                this.f22195j.setVisibility(0);
                this.f22195j.onChangeSkinType(this.f22186a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f22192g.setNextPage(null);
            return;
        }
        this.f22192g.removeHeaderView(this.f22195j);
        this.k = false;
        this.f22192g.setNextPage(this.f22194i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f22191f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
