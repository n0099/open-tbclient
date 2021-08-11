package c.a.p0.k1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.e.k.e.w;
import c.a.o0.s.f0.f;
import c.a.o0.s.f0.g;
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
    public TbPageContext f21082a;

    /* renamed from: b  reason: collision with root package name */
    public View f21083b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21084c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f21085d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f21086e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f21087f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f21088g;

    /* renamed from: h  reason: collision with root package name */
    public g f21089h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f21090i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f21091j;
    public boolean k;
    public c.a.p0.k1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: c.a.p0.k1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0989a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21092e;

        public View$OnClickListenerC0989a(a aVar) {
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
            this.f21092e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21092e.f21090i == null || this.f21092e.m == null) {
                return;
            }
            this.f21092e.f21090i.J(0);
            this.f21092e.f21090i.z(null);
            this.f21092e.f21090i.O();
            this.f21092e.m.b();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21093e;

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
            this.f21093e = aVar;
        }

        @Override // c.a.o0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f21093e.m != null) {
                        this.f21093e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f21093e.f21087f;
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
        public final /* synthetic */ a f21094e;

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
            this.f21094e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21094e.f21090i == null || this.f21094e.m == null) {
                return;
            }
            this.f21094e.f21090i.J(0);
            this.f21094e.f21090i.z(null);
            this.f21094e.f21090i.L();
            this.f21094e.m.b();
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
        this.n = new View$OnClickListenerC0989a(this);
        this.o = new b(this);
        this.f21082a = tbPageContext;
        this.f21083b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new c.a.p0.k1.b.p.d(tbPageContext, this.f21088g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f21089h;
            if (gVar != null) {
                gVar.D(i2);
            }
            NoNetworkView noNetworkView = this.f21085d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f21082a, i2);
            }
            PbListView pbListView = this.f21090i;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f21090i.d(i2);
            }
            NoDataView noDataView = this.f21091j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f21082a, i2);
                SkinManager.setBackgroundColor(this.f21091j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f21084c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f21082a, i2);
            }
            c.a.p0.k1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f21083b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21086e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21087f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21088g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21086e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21088g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21083b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f21083b == null) {
            return;
        }
        if (this.f21089h == null) {
            g gVar = new g(tbPageContext);
            this.f21089h = gVar;
            gVar.a(this.o);
        }
        this.f21089h.V(tbPageContext.getUniqueId());
        if (this.f21090i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f21090i = pbListView;
            pbListView.b();
        }
        this.f21090i.o(R.color.CAM_X0205);
        this.f21090i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f21090i.v();
        this.f21090i.E(R.dimen.tbfontsize33);
        this.f21090i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f21090i.y(R.color.CAM_X0110);
        this.f21090i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f21083b.findViewById(R.id.no_networkview);
        this.f21085d = noNetworkView;
        noNetworkView.onChangeSkinType(this.f21082a, TbadkCoreApplication.getInst().getSkinType());
        this.f21086e = (RelativeLayout) this.f21083b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f21083b.findViewById(R.id.view_navigation_bar);
        this.f21084c = navigationBar;
        navigationBar.showBottomLine();
        this.f21084c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21084c.setCenterTextTitle(this.f21082a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f21083b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f21087f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f21089h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f21083b.findViewById(R.id.agree_me_recycler_view);
        this.f21088g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f21088g.setLayoutManager(new LinearLayoutManager(this.f21082a.getContext()));
        this.f21088g.setFadingEdgeLength(0);
        this.f21088g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f21088g.setOverScrollMode(2);
        this.f21088g.addItemDecoration(new DeviderLineDecoration());
        this.f21088g.setRecyclerListener(new c(this));
        this.f21088g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.k1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f21089h;
            if (gVar != null) {
                gVar.T();
            }
        }
    }

    public void i(w wVar) {
        c.a.p0.k1.b.p.d dVar;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f21087f) == null || this.f21090i == null || this.f21088g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f21090i.J(0);
            this.f21090i.f();
            this.f21090i.z(this.n);
        } else {
            this.f21090i.J(0);
            this.f21090i.f();
            this.f21090i.A(this.f21082a.getResources().getString(R.string.list_no_more));
            this.f21090i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f21091j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f21082a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f21082a.getResources().getString(R.string.agree_me_nodata)), null);
                this.f21091j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f21091j, R.color.CAM_X0201);
            }
            if (this.f21091j.getParent() == null && !this.k) {
                this.k = true;
                this.f21088g.addHeaderView(this.f21091j, 0);
                this.f21091j.setVisibility(0);
                this.f21091j.onChangeSkinType(this.f21082a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f21088g.setNextPage(null);
            return;
        }
        this.f21088g.removeHeaderView(this.f21091j);
        this.k = false;
        this.f21088g.setNextPage(this.f21090i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f21087f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
