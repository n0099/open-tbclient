package b.a.r0.m1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22251a;

    /* renamed from: b  reason: collision with root package name */
    public View f22252b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f22253c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f22254d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f22255e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f22256f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f22257g;

    /* renamed from: h  reason: collision with root package name */
    public g f22258h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f22259i;
    public NoDataView j;
    public boolean k;
    public b.a.r0.m1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: b.a.r0.m1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1098a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22260e;

        public View$OnClickListenerC1098a(a aVar) {
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
            this.f22260e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22260e.f22259i == null || this.f22260e.m == null) {
                return;
            }
            this.f22260e.f22259i.L(0);
            this.f22260e.f22259i.B(null);
            this.f22260e.f22259i.Q();
            this.f22260e.m.b();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22261e;

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
            this.f22261e = aVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f22261e.m != null) {
                        this.f22261e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f22261e.f22256f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22262e;

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
            this.f22262e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22262e.f22259i == null || this.f22262e.m == null) {
                return;
            }
            this.f22262e.f22259i.L(0);
            this.f22262e.f22259i.B(null);
            this.f22262e.f22259i.N();
            this.f22262e.m.b();
        }
    }

    /* loaded from: classes5.dex */
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
        this.n = new View$OnClickListenerC1098a(this);
        this.o = new b(this);
        this.f22251a = tbPageContext;
        this.f22252b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new b.a.r0.m1.b.p.d(tbPageContext, this.f22257g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f22258h;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoNetworkView noNetworkView = this.f22254d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f22251a, i2);
            }
            PbListView pbListView = this.f22259i;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f22259i.d(i2);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f22251a, i2);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f22253c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f22251a, i2);
            }
            b.a.r0.m1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f22252b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22255e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22256f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22257g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22255e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f22257g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22252b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f22252b == null) {
            return;
        }
        if (this.f22258h == null) {
            g gVar = new g(tbPageContext);
            this.f22258h = gVar;
            gVar.a(this.o);
        }
        this.f22258h.U(tbPageContext.getUniqueId());
        if (this.f22259i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f22259i = pbListView;
            pbListView.b();
        }
        this.f22259i.p(R.color.CAM_X0205);
        this.f22259i.s(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f22259i.x();
        this.f22259i.G(R.dimen.tbfontsize33);
        this.f22259i.E(SkinManager.getColor(R.color.CAM_X0109));
        this.f22259i.A(R.color.CAM_X0110);
        this.f22259i.B(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f22252b.findViewById(R.id.no_networkview);
        this.f22254d = noNetworkView;
        noNetworkView.onChangeSkinType(this.f22251a, TbadkCoreApplication.getInst().getSkinType());
        this.f22255e = (RelativeLayout) this.f22252b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f22252b.findViewById(R.id.view_navigation_bar);
        this.f22253c = navigationBar;
        navigationBar.showBottomLine();
        this.f22253c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f22253c.setCenterTextTitle(this.f22251a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f22252b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f22256f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f22258h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f22252b.findViewById(R.id.agree_me_recycler_view);
        this.f22257g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f22257g.setLayoutManager(new LinearLayoutManager(this.f22251a.getContext()));
        this.f22257g.setFadingEdgeLength(0);
        this.f22257g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f22257g.setOverScrollMode(2);
        this.f22257g.addItemDecoration(new DeviderLineDecoration());
        this.f22257g.setRecyclerListener(new c(this));
        this.f22257g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.m1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f22258h;
            if (gVar != null) {
                gVar.S();
            }
        }
    }

    public void i(w wVar) {
        b.a.r0.m1.b.p.d dVar;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f22256f) == null || this.f22259i == null || this.f22257g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f22259i.L(0);
            this.f22259i.f();
            this.f22259i.B(this.n);
        } else {
            this.f22259i.L(0);
            this.f22259i.f();
            this.f22259i.C(this.f22251a.getResources().getString(R.string.list_no_more));
            this.f22259i.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f22251a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f22251a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f22257g.addHeaderView(this.j, 0);
                this.j.setVisibility(0);
                this.j.onChangeSkinType(this.f22251a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f22257g.setNextPage(null);
            return;
        }
        this.f22257g.removeHeaderView(this.j);
        this.k = false;
        this.f22257g.setNextPage(this.f22259i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f22256f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
