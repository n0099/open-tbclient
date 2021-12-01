package c.a.r0.s1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.d.m.e.w;
import c.a.q0.s.g0.f;
import c.a.q0.s.g0.g;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f23408b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f23409c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f23410d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f23411e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f23412f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f23413g;

    /* renamed from: h  reason: collision with root package name */
    public g f23414h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f23415i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f23416j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23417k;
    public c.a.r0.s1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: c.a.r0.s1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1352a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23418e;

        public View$OnClickListenerC1352a(a aVar) {
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
            this.f23418e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23418e.f23415i == null || this.f23418e.m == null) {
                return;
            }
            this.f23418e.f23415i.L(0);
            this.f23418e.f23415i.B(null);
            this.f23418e.f23415i.Q();
            this.f23418e.m.b();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23419e;

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
            this.f23419e = aVar;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f23419e.m != null) {
                        this.f23419e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f23419e.f23412f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23420e;

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
            this.f23420e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23420e.f23415i == null || this.f23420e.m == null) {
                return;
            }
            this.f23420e.f23415i.L(0);
            this.f23420e.f23415i.B(null);
            this.f23420e.f23415i.N();
            this.f23420e.m.b();
        }
    }

    /* loaded from: classes6.dex */
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
        this.n = new View$OnClickListenerC1352a(this);
        this.o = new b(this);
        this.a = tbPageContext;
        this.f23408b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new c.a.r0.s1.b.p.d(tbPageContext, this.f23413g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f23414h;
            if (gVar != null) {
                gVar.C(i2);
            }
            NoNetworkView noNetworkView = this.f23410d;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i2);
            }
            PbListView pbListView = this.f23415i;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f23415i.d(i2);
            }
            NoDataView noDataView = this.f23416j;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.a, i2);
                SkinManager.setBackgroundColor(this.f23416j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f23409c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i2);
            }
            c.a.r0.s1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f23408b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f23411e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f23412f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f23413g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23411e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f23413g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23408b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f23408b == null) {
            return;
        }
        if (this.f23414h == null) {
            g gVar = new g(tbPageContext);
            this.f23414h = gVar;
            gVar.a(this.o);
        }
        this.f23414h.V(tbPageContext.getUniqueId());
        if (this.f23415i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f23415i = pbListView;
            pbListView.b();
        }
        this.f23415i.p(R.color.CAM_X0205);
        this.f23415i.s(l.f(tbPageContext.getContext(), R.dimen.tbds182));
        this.f23415i.x();
        this.f23415i.G(R.dimen.tbfontsize33);
        this.f23415i.E(SkinManager.getColor(R.color.CAM_X0109));
        this.f23415i.A(R.color.CAM_X0110);
        this.f23415i.B(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f23408b.findViewById(R.id.no_networkview);
        this.f23410d = noNetworkView;
        noNetworkView.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        this.f23411e = (RelativeLayout) this.f23408b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f23408b.findViewById(R.id.view_navigation_bar);
        this.f23409c = navigationBar;
        navigationBar.showBottomLine();
        this.f23409c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23409c.setCenterTextTitle(this.a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f23408b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f23412f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f23414h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f23408b.findViewById(R.id.agree_me_recycler_view);
        this.f23413g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f23413g.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f23413g.setFadingEdgeLength(0);
        this.f23413g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f23413g.setOverScrollMode(2);
        this.f23413g.addItemDecoration(new DeviderLineDecoration());
        this.f23413g.setRecyclerListener(new c(this));
        this.f23413g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.s1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f23414h;
            if (gVar != null) {
                gVar.T();
            }
        }
    }

    public void i(w wVar) {
        c.a.r0.s1.b.p.d dVar;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f23412f) == null || this.f23415i == null || this.f23413g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f23415i.L(0);
            this.f23415i.f();
            this.f23415i.B(this.n);
        } else {
            this.f23415i.L(0);
            this.f23415i.f();
            this.f23415i.C(this.a.getResources().getString(R.string.list_no_more));
            this.f23415i.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f23416j == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.agree_me_nodata)), null);
                this.f23416j = a;
                a.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f23416j, R.color.CAM_X0201);
            }
            if (this.f23416j.getParent() == null && !this.f23417k) {
                this.f23417k = true;
                this.f23413g.addHeaderView(this.f23416j, 0);
                this.f23416j.setVisibility(0);
                this.f23416j.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f23413g.setNextPage(null);
            return;
        }
        this.f23413g.removeHeaderView(this.f23416j);
        this.f23417k = false;
        this.f23413g.setNextPage(this.f23415i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f23412f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
