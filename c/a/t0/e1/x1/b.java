package c.a.t0.e1.x1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.a3.k;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.f1;
import c.a.t0.e1.i0;
import c.a.t0.e1.i1;
import c.a.t0.e1.m0;
import c.a.t0.e1.s;
import c.a.t0.e1.t;
import c.a.t0.g0.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17071b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f17072c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.e1.x1.a f17073d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.e1.x1.d f17074e;

    /* renamed from: f  reason: collision with root package name */
    public k f17075f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f17076g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.e1.z1.f.a.a f17077h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17078i;

    /* renamed from: j  reason: collision with root package name */
    public i0 f17079j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17080e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17080e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17080e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.t0.e1.x1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1077b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17081e;

        public C1077b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17081e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17081e.f17071b != null) {
                    this.f17081e.f17071b.stopScroll();
                }
                if (this.f17081e.f17072c == null || this.f17081e.a == null) {
                    return;
                }
                if (l.z()) {
                    this.f17081e.f17071b.setNextPage(this.f17081e.f17072c);
                    this.f17081e.f17072c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f17081e.f17072c.C(null);
                    if (this.f17081e.f17078i) {
                        this.f17081e.f17072c.O();
                        this.f17081e.f17072c.C(null);
                        this.f17081e.a.loadmore();
                        return;
                    }
                    this.f17081e.f17072c.D(this.f17081e.a.getResources().getString(i1.list_has_no_more));
                    this.f17081e.f17072c.f();
                    this.f17081e.f17072c.C(null);
                    return;
                }
                this.f17081e.f17071b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17082b;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17082b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f17082b.f17075f != null) {
                    this.f17082b.f17075f.n(this.f17082b.f17071b.getFirstVisiblePosition(), this.f17082b.f17071b.getLastVisiblePosition(), this.a, true);
                }
                v.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.a.f17075f != null) {
                    this.a.f17075f.k(view);
                    this.a.f17075f.n(this.a.f17071b.getFirstVisiblePosition(), this.a.f17071b.getLastVisiblePosition(), false, true);
                }
                if (view != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(f1.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(f1.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view).reset();
                    }
                }
            }
        }
    }

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, view, frsViewData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.m = new C1077b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_common_tab_recycler_view);
        this.f17071b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f17071b.setFadingEdgeLength(0);
        this.f17071b.setOverScrollMode(2);
        this.f17071b.setOnSrollToBottomListener(this.m);
        this.f17071b.addOnScrollListener(this.n);
        this.f17071b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f17071b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f17071b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.f17072c = pbListView;
        pbListView.b();
        this.f17072c.p(c1.transparent);
        this.f17072c.t(n.f(this.a.getActivity(), d1.tbds182));
        this.f17072c.y();
        this.f17072c.H(d1.tbfontsize33);
        this.f17072c.F(SkinManager.getColor(c1.CAM_X0107));
        this.f17072c.B(c1.CAM_X0110);
        this.f17072c.s();
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        this.f17073d = new c.a.t0.e1.x1.a(frsCommonTabFragment2, this.f17071b, frsViewData, frsCommonTabFragment2.tabType == 16);
        x(false);
        if (this.f17075f == null) {
            this.f17075f = new k(this.a.getPageContext(), this.f17071b);
        }
        if (c.a.s0.b.d.l()) {
            this.f17075f.p(2);
        } else {
            this.f17075f.p(1);
        }
        this.f17075f.u(this.a.getUniqueId());
        if (g()) {
            this.f17076g = new RelativeLayout(this.a.getContext());
            this.f17076g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f17077h = new c.a.t0.e1.z1.f.a.a(this.a, this.f17076g);
            this.f17071b.addHeaderView(this.f17076g, 0);
            this.f17077h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3.tabType == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.f17079j = i0Var;
            this.f17071b.addHeaderView(i0Var.a(), 0);
            this.f17079j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment != null) {
                return frsCommonTabFragment.isGeneralTab == 1 || frsCommonTabFragment.tabType == 16;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<FrsTabInfo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 2;
            builder.tab_type = Integer.valueOf(this.a.tabType);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.a.tabType);
            FrsTabInfo build2 = builder2.build(true);
            arrayList.add(build);
            arrayList.add(build2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public k i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17075f : (k) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17071b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final boolean k(ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, arrayList, i2)) == null) {
            if (ListUtils.isEmpty(arrayList) || i2 < 0) {
                return false;
            }
            if (i2 == 0) {
                return true;
            }
            int i4 = 1;
            while (i3 < arrayList.size() && i4 <= i2) {
                if (arrayList.get(i3) instanceof d2) {
                    int i5 = i3 - 1;
                    i3 = ((arrayList.get(i5) instanceof d2) && ((d2) arrayList.get(i3)).position == ((d2) arrayList.get(i5)).position) ? i3 + 1 : 1;
                }
                i4++;
            }
            return i4 > i2;
        }
        return invokeLI.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            c.a.t0.e1.x1.a aVar = this.f17073d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f17072c;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c1.CAM_X0107));
                this.f17072c.d(i2);
            }
            c.a.t0.e1.z1.f.a.a aVar2 = this.f17077h;
            if (aVar2 != null) {
                aVar2.h();
            }
            i0 i0Var = this.f17079j;
            if (i0Var != null) {
                i0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.t0.e1.x1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f17074e) == null || ListUtils.isEmpty(dVar.f17091g)) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = this.f17074e.f17091g.iterator();
        while (it.hasNext()) {
            c.a.d.n.e.n next = it.next();
            e2 e2Var = null;
            if (next instanceof d2) {
                e2Var = ((d2) next).w;
            } else if (next instanceof e2) {
                e2Var = (e2) next;
            }
            if (e2Var != null && TextUtils.equals(str, e2Var.h0())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.f17074e.f17091g)) {
            this.f17074e.f17091g.add(new s());
        }
        this.f17073d.i(this.f17074e.f17091g);
        this.f17073d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k kVar = this.f17075f;
            if (kVar != null) {
                kVar.h();
            }
            c.a.t0.e1.x1.a aVar = this.f17073d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.t0.e1.x1.d dVar) {
        i0 i0Var;
        c.a.t0.e1.z1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f17078i = dVar.f17089e;
        if (ListUtils.isEmpty(dVar.f17091g)) {
            s sVar = new s();
            ArrayList<c.a.d.n.e.n> arrayList = new ArrayList<>();
            dVar.f17091g = arrayList;
            arrayList.add(sVar);
            dVar.f17089e = false;
        }
        this.f17074e = dVar;
        this.f17072c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f17078i) {
            this.f17071b.setNextPage(this.f17072c);
            if (k(dVar.f17091g, 3)) {
                this.f17072c.C(null);
                this.f17072c.N();
            } else {
                this.f17072c.N();
                this.f17072c.C(this.l);
                this.f17072c.D(this.a.getResources().getString(i1.list_click_load_more));
            }
        } else {
            this.f17071b.setNextPage(null);
            this.f17072c.D(this.a.getResources().getString(i1.list_has_no_more));
            this.f17072c.C(null);
            this.f17072c.f();
        }
        this.f17073d.i(dVar.f17091g);
        this.f17073d.f();
        k kVar = this.f17075f;
        if (kVar != null) {
            kVar.n(this.f17071b.getFirstVisiblePosition(), this.f17071b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f17077h) != null) {
            aVar.g(this.a.getSortType());
            this.f17077h.j(this.a.forumId);
        }
        this.k = dVar.n;
        if (this.a.getFragmentActivity() instanceof m0) {
            ((m0) this.a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.a.tabType != 16 || (i0Var = this.f17079j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (kVar = this.f17075f) == null) {
            return;
        }
        kVar.y();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f17073d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.a = this.a.tabId;
            tVar.f16908b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (kVar = this.f17075f) == null) {
            return;
        }
        kVar.o();
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f17071b.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
            if (this.f17078i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17071b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f17071b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        c.a.t0.e1.x1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f17073d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.a == null) {
            return;
        }
        t tVar = new t();
        tVar.a = this.a.tabId;
        tVar.f16908b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f17071b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bdTypeRecyclerView = this.f17071b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
