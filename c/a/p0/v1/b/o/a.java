package c.a.p0.v1.b.o;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f19154b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19155c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f19156d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f19157e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f19158f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f19159g;

    /* renamed from: h  reason: collision with root package name */
    public g f19160h;
    public PbListView i;
    public NoDataView j;
    public boolean k;
    public c.a.p0.v1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: c.a.p0.v1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1451a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1451a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.i == null || this.a.m == null) {
                return;
            }
            this.a.i.M(0);
            this.a.i.C(null);
            this.a.i.R();
            this.a.m.b();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    if (this.a.m != null) {
                        this.a.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a.f19158f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i == null || this.a.m == null) {
                return;
            }
            this.a.i.M(0);
            this.a.i.C(null);
            this.a.i.O();
            this.a.m.b();
        }
    }

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new View$OnClickListenerC1451a(this);
        this.o = new b(this);
        this.a = tbPageContext;
        this.f19154b = view.findViewById(R.id.obfuscated_res_0x7f090153);
        g(tbPageContext);
        this.l = new c.a.p0.v1.b.p.d(tbPageContext, this.f19159g);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            g gVar = this.f19160h;
            if (gVar != null) {
                gVar.H(i);
            }
            NoNetworkView noNetworkView = this.f19156d;
            if (noNetworkView != null) {
                noNetworkView.c(this.a, i);
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.i.d(i);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.f(this.a, i);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f19155c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            c.a.p0.v1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f19154b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f19157e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f19158f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f19159g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19157e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19159g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19154b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f19154b == null) {
            return;
        }
        if (this.f19160h == null) {
            g gVar = new g(tbPageContext);
            this.f19160h = gVar;
            gVar.f(this.o);
        }
        this.f19160h.a0(tbPageContext.getUniqueId());
        if (this.i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.i = pbListView;
            pbListView.b();
        }
        this.i.p(R.color.CAM_X0205);
        this.i.t(c.a.d.f.p.n.f(tbPageContext.getContext(), R.dimen.tbds182));
        this.i.y();
        this.i.H(R.dimen.tbfontsize33);
        this.i.F(SkinManager.getColor(R.color.CAM_X0109));
        this.i.B(R.color.CAM_X0110);
        this.i.C(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f19154b.findViewById(R.id.obfuscated_res_0x7f09159e);
        this.f19156d = noNetworkView;
        noNetworkView.c(this.a, TbadkCoreApplication.getInst().getSkinType());
        this.f19157e = (RelativeLayout) this.f19154b.findViewById(R.id.obfuscated_res_0x7f0906c9);
        NavigationBar navigationBar = (NavigationBar) this.f19154b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f19155c = navigationBar;
        navigationBar.showBottomLine();
        this.f19155c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19155c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f00db));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19154b.findViewById(R.id.obfuscated_res_0x7f090155);
        this.f19158f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f19160h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f19154b.findViewById(R.id.obfuscated_res_0x7f090156);
        this.f19159g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f19159g.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f19159g.setFadingEdgeLength(0);
        this.f19159g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f19159g.setOverScrollMode(2);
        this.f19159g.addItemDecoration(new DeviderLineDecoration());
        this.f19159g.setRecyclerListener(new c(this));
        this.f19159g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.v1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f19160h;
            if (gVar != null) {
                gVar.Y();
            }
        }
    }

    public void i(w wVar) {
        c.a.p0.v1.b.p.d dVar;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f19158f) == null || this.i == null || this.f19159g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.i.M(0);
            this.i.f();
            this.i.C(this.n);
        } else {
            this.i.M(0);
            this.i.f();
            this.i.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
            this.i.C(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a = NoDataViewFactory.a(this.a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f00dc)), null);
                this.j = a;
                a.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f19159g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f19159g.setNextPage(null);
            return;
        }
        this.f19159g.removeHeaderView(this.j);
        this.k = false;
        this.f19159g.setNextPage(this.i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f19158f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
