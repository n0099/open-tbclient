package b.a.r0.m1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.e.l.e.w;
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
    public TbPageContext f21096a;

    /* renamed from: b  reason: collision with root package name */
    public View f21097b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21098c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f21099d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f21100e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f21101f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f21102g;

    /* renamed from: h  reason: collision with root package name */
    public g f21103h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f21104i;
    public NoDataView j;
    public boolean k;
    public b.a.r0.m1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: b.a.r0.m1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1036a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21105e;

        public View$OnClickListenerC1036a(a aVar) {
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
            this.f21105e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21105e.f21104i == null || this.f21105e.m == null) {
                return;
            }
            this.f21105e.f21104i.L(0);
            this.f21105e.f21104i.B(null);
            this.f21105e.f21104i.Q();
            this.f21105e.m.b();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21106e;

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
            this.f21106e = aVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f21106e.m != null) {
                        this.f21106e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f21106e.f21101f;
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
        public final /* synthetic */ a f21107e;

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
            this.f21107e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21107e.f21104i == null || this.f21107e.m == null) {
                return;
            }
            this.f21107e.f21104i.L(0);
            this.f21107e.f21104i.B(null);
            this.f21107e.f21104i.N();
            this.f21107e.m.b();
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
        this.n = new View$OnClickListenerC1036a(this);
        this.o = new b(this);
        this.f21096a = tbPageContext;
        this.f21097b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new b.a.r0.m1.b.p.d(tbPageContext, this.f21102g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f21103h;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoNetworkView noNetworkView = this.f21099d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f21096a, i2);
            }
            PbListView pbListView = this.f21104i;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f21104i.d(i2);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f21096a, i2);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f21098c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f21096a, i2);
            }
            b.a.r0.m1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f21097b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21100e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21101f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f21102g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21100e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f21102g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21097b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f21097b == null) {
            return;
        }
        if (this.f21103h == null) {
            g gVar = new g(tbPageContext);
            this.f21103h = gVar;
            gVar.a(this.o);
        }
        this.f21103h.U(tbPageContext.getUniqueId());
        if (this.f21104i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f21104i = pbListView;
            pbListView.b();
        }
        this.f21104i.p(R.color.CAM_X0205);
        this.f21104i.s(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f21104i.x();
        this.f21104i.G(R.dimen.tbfontsize33);
        this.f21104i.E(SkinManager.getColor(R.color.CAM_X0109));
        this.f21104i.A(R.color.CAM_X0110);
        this.f21104i.B(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f21097b.findViewById(R.id.no_networkview);
        this.f21099d = noNetworkView;
        noNetworkView.onChangeSkinType(this.f21096a, TbadkCoreApplication.getInst().getSkinType());
        this.f21100e = (RelativeLayout) this.f21097b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f21097b.findViewById(R.id.view_navigation_bar);
        this.f21098c = navigationBar;
        navigationBar.showBottomLine();
        this.f21098c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21098c.setCenterTextTitle(this.f21096a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f21097b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f21101f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f21103h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f21097b.findViewById(R.id.agree_me_recycler_view);
        this.f21102g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f21102g.setLayoutManager(new LinearLayoutManager(this.f21096a.getContext()));
        this.f21102g.setFadingEdgeLength(0);
        this.f21102g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f21102g.setOverScrollMode(2);
        this.f21102g.addItemDecoration(new DeviderLineDecoration());
        this.f21102g.setRecyclerListener(new c(this));
        this.f21102g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.m1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f21103h;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f21101f) == null || this.f21104i == null || this.f21102g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f21104i.L(0);
            this.f21104i.f();
            this.f21104i.B(this.n);
        } else {
            this.f21104i.L(0);
            this.f21104i.f();
            this.f21104i.C(this.f21096a.getResources().getString(R.string.list_no_more));
            this.f21104i.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f21096a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f21096a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f21102g.addHeaderView(this.j, 0);
                this.j.setVisibility(0);
                this.j.onChangeSkinType(this.f21096a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f21102g.setNextPage(null);
            return;
        }
        this.f21102g.removeHeaderView(this.j);
        this.k = false;
        this.f21102g.setNextPage(this.f21104i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f21101f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
