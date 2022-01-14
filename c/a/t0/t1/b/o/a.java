package c.a.t0.t1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.s0.s.j0.f;
import c.a.s0.s.j0.g;
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
    public View f23788b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f23789c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f23790d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f23791e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f23792f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f23793g;

    /* renamed from: h  reason: collision with root package name */
    public g f23794h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f23795i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f23796j;
    public boolean k;
    public c.a.t0.t1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: c.a.t0.t1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1449a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23797e;

        public View$OnClickListenerC1449a(a aVar) {
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
            this.f23797e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23797e.f23795i == null || this.f23797e.m == null) {
                return;
            }
            this.f23797e.f23795i.M(0);
            this.f23797e.f23795i.C(null);
            this.f23797e.f23795i.R();
            this.f23797e.m.b();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23798e;

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
            this.f23798e = aVar;
        }

        @Override // c.a.s0.s.j0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    if (this.f23798e.m != null) {
                        this.f23798e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f23798e.f23792f;
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
        public final /* synthetic */ a f23799e;

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
            this.f23799e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23799e.f23795i == null || this.f23799e.m == null) {
                return;
            }
            this.f23799e.f23795i.M(0);
            this.f23799e.f23795i.C(null);
            this.f23799e.f23795i.O();
            this.f23799e.m.b();
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
        this.n = new View$OnClickListenerC1449a(this);
        this.o = new b(this);
        this.a = tbPageContext;
        this.f23788b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new c.a.t0.t1.b.p.d(tbPageContext, this.f23793g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f23794h;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoNetworkView noNetworkView = this.f23790d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i2);
            }
            PbListView pbListView = this.f23795i;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f23795i.d(i2);
            }
            NoDataView noDataView = this.f23796j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.a, i2);
                SkinManager.setBackgroundColor(this.f23796j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f23789c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i2);
            }
            c.a.t0.t1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f23788b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f23791e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f23792f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f23793g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23791e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f23793g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23788b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f23788b == null) {
            return;
        }
        if (this.f23794h == null) {
            g gVar = new g(tbPageContext);
            this.f23794h = gVar;
            gVar.a(this.o);
        }
        this.f23794h.V(tbPageContext.getUniqueId());
        if (this.f23795i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f23795i = pbListView;
            pbListView.b();
        }
        this.f23795i.p(R.color.CAM_X0205);
        this.f23795i.t(c.a.d.f.p.n.f(tbPageContext.getContext(), R.dimen.tbds182));
        this.f23795i.y();
        this.f23795i.H(R.dimen.tbfontsize33);
        this.f23795i.F(SkinManager.getColor(R.color.CAM_X0109));
        this.f23795i.B(R.color.CAM_X0110);
        this.f23795i.C(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f23788b.findViewById(R.id.no_networkview);
        this.f23790d = noNetworkView;
        noNetworkView.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        this.f23791e = (RelativeLayout) this.f23788b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f23788b.findViewById(R.id.view_navigation_bar);
        this.f23789c = navigationBar;
        navigationBar.showBottomLine();
        this.f23789c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23789c.setCenterTextTitle(this.a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f23788b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f23792f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f23794h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f23788b.findViewById(R.id.agree_me_recycler_view);
        this.f23793g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f23793g.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f23793g.setFadingEdgeLength(0);
        this.f23793g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f23793g.setOverScrollMode(2);
        this.f23793g.addItemDecoration(new DeviderLineDecoration());
        this.f23793g.setRecyclerListener(new c(this));
        this.f23793g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.t0.t1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f23794h;
            if (gVar != null) {
                gVar.T();
            }
        }
    }

    public void i(w wVar) {
        c.a.t0.t1.b.p.d dVar;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f23792f) == null || this.f23795i == null || this.f23793g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f23795i.M(0);
            this.f23795i.f();
            this.f23795i.C(this.n);
        } else {
            this.f23795i.M(0);
            this.f23795i.f();
            this.f23795i.D(this.a.getResources().getString(R.string.list_no_more));
            this.f23795i.C(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f23796j == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.agree_me_nodata)), null);
                this.f23796j = a;
                a.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f23796j, R.color.CAM_X0201);
            }
            if (this.f23796j.getParent() == null && !this.k) {
                this.k = true;
                this.f23793g.addHeaderView(this.f23796j, 0);
                this.f23796j.setVisibility(0);
                this.f23796j.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f23793g.setNextPage(null);
            return;
        }
        this.f23793g.removeHeaderView(this.f23796j);
        this.k = false;
        this.f23793g.setNextPage(this.f23795i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f23792f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
