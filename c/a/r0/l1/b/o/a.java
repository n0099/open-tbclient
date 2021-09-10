package c.a.r0.l1.b.o;

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
    public TbPageContext f21992a;

    /* renamed from: b  reason: collision with root package name */
    public View f21993b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21994c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f21995d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f21996e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f21997f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f21998g;

    /* renamed from: h  reason: collision with root package name */
    public g f21999h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f22000i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f22001j;
    public boolean k;
    public c.a.r0.l1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: c.a.r0.l1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1033a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22002e;

        public View$OnClickListenerC1033a(a aVar) {
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
            this.f22002e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22002e.f22000i == null || this.f22002e.m == null) {
                return;
            }
            this.f22002e.f22000i.J(0);
            this.f22002e.f22000i.z(null);
            this.f22002e.f22000i.O();
            this.f22002e.m.b();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22003e;

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
            this.f22003e = aVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f22003e.m != null) {
                        this.f22003e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f22003e.f21997f;
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
        public final /* synthetic */ a f22004e;

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
            this.f22004e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22004e.f22000i == null || this.f22004e.m == null) {
                return;
            }
            this.f22004e.f22000i.J(0);
            this.f22004e.f22000i.z(null);
            this.f22004e.f22000i.L();
            this.f22004e.m.b();
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
        this.n = new View$OnClickListenerC1033a(this);
        this.o = new b(this);
        this.f21992a = tbPageContext;
        this.f21993b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new c.a.r0.l1.b.p.d(tbPageContext, this.f21998g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f21999h;
            if (gVar != null) {
                gVar.D(i2);
            }
            NoNetworkView noNetworkView = this.f21995d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f21992a, i2);
            }
            PbListView pbListView = this.f22000i;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f22000i.d(i2);
            }
            NoDataView noDataView = this.f22001j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f21992a, i2);
                SkinManager.setBackgroundColor(this.f22001j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f21994c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f21992a, i2);
            }
            c.a.r0.l1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f21993b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21996e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21997f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21998g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21996e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21998g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21993b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f21993b == null) {
            return;
        }
        if (this.f21999h == null) {
            g gVar = new g(tbPageContext);
            this.f21999h = gVar;
            gVar.a(this.o);
        }
        this.f21999h.V(tbPageContext.getUniqueId());
        if (this.f22000i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f22000i = pbListView;
            pbListView.b();
        }
        this.f22000i.o(R.color.CAM_X0205);
        this.f22000i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f22000i.v();
        this.f22000i.E(R.dimen.tbfontsize33);
        this.f22000i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f22000i.y(R.color.CAM_X0110);
        this.f22000i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f21993b.findViewById(R.id.no_networkview);
        this.f21995d = noNetworkView;
        noNetworkView.onChangeSkinType(this.f21992a, TbadkCoreApplication.getInst().getSkinType());
        this.f21996e = (RelativeLayout) this.f21993b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f21993b.findViewById(R.id.view_navigation_bar);
        this.f21994c = navigationBar;
        navigationBar.showBottomLine();
        this.f21994c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21994c.setCenterTextTitle(this.f21992a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f21993b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f21997f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f21999h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f21993b.findViewById(R.id.agree_me_recycler_view);
        this.f21998g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f21998g.setLayoutManager(new LinearLayoutManager(this.f21992a.getContext()));
        this.f21998g.setFadingEdgeLength(0);
        this.f21998g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f21998g.setOverScrollMode(2);
        this.f21998g.addItemDecoration(new DeviderLineDecoration());
        this.f21998g.setRecyclerListener(new c(this));
        this.f21998g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.l1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f21999h;
            if (gVar != null) {
                gVar.T();
            }
        }
    }

    public void i(w wVar) {
        c.a.r0.l1.b.p.d dVar;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f21997f) == null || this.f22000i == null || this.f21998g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f22000i.J(0);
            this.f22000i.f();
            this.f22000i.z(this.n);
        } else {
            this.f22000i.J(0);
            this.f22000i.f();
            this.f22000i.A(this.f21992a.getResources().getString(R.string.list_no_more));
            this.f22000i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f22001j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f21992a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f21992a.getResources().getString(R.string.agree_me_nodata)), null);
                this.f22001j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f22001j, R.color.CAM_X0201);
            }
            if (this.f22001j.getParent() == null && !this.k) {
                this.k = true;
                this.f21998g.addHeaderView(this.f22001j, 0);
                this.f22001j.setVisibility(0);
                this.f22001j.onChangeSkinType(this.f21992a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f21998g.setNextPage(null);
            return;
        }
        this.f21998g.removeHeaderView(this.f22001j);
        this.k = false;
        this.f21998g.setNextPage(this.f22000i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f21997f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
