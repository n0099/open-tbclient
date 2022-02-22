package c.a.u0.e1.x1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.u0.b3.k;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.f1;
import c.a.u0.e1.i0;
import c.a.u0.e1.i1;
import c.a.u0.e1.m0;
import c.a.u0.e1.s;
import c.a.u0.e1.t;
import c.a.u0.g0.u;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17280b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f17281c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.e1.x1.a f17282d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.u0.e1.x1.d f17283e;

    /* renamed from: f  reason: collision with root package name */
    public k f17284f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f17285g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.u0.e1.z1.f.a.a f17286h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17287i;

    /* renamed from: j  reason: collision with root package name */
    public i0 f17288j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17289e;

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
            this.f17289e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17289e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.u0.e1.x1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1082b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17290e;

        public C1082b(b bVar) {
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
            this.f17290e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17290e.f17280b != null) {
                    this.f17290e.f17280b.stopScroll();
                }
                if (this.f17290e.f17281c == null || this.f17290e.a == null) {
                    return;
                }
                if (l.z()) {
                    this.f17290e.f17280b.setNextPage(this.f17290e.f17281c);
                    this.f17290e.f17281c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f17290e.f17281c.C(null);
                    if (this.f17290e.f17287i) {
                        this.f17290e.f17281c.O();
                        this.f17290e.f17281c.C(null);
                        this.f17290e.a.loadmore();
                        return;
                    }
                    this.f17290e.f17281c.D(this.f17290e.a.getResources().getString(i1.list_has_no_more));
                    this.f17290e.f17281c.f();
                    this.f17290e.f17281c.C(null);
                    return;
                }
                this.f17290e.f17280b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17291b;

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
            this.f17291b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f17291b.f17284f != null) {
                    this.f17291b.f17284f.n(this.f17291b.f17280b.getFirstVisiblePosition(), this.f17291b.f17280b.getLastVisiblePosition(), this.a, true);
                }
                u.b().e(true);
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

    /* loaded from: classes8.dex */
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
                if (this.a.f17284f != null) {
                    this.a.f17284f.k(view);
                    this.a.f17284f.n(this.a.f17280b.getFirstVisiblePosition(), this.a.f17280b.getLastVisiblePosition(), false, true);
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
        this.m = new C1082b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_common_tab_recycler_view);
        this.f17280b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f17280b.setFadingEdgeLength(0);
        this.f17280b.setOverScrollMode(2);
        this.f17280b.setOnSrollToBottomListener(this.m);
        this.f17280b.addOnScrollListener(this.n);
        this.f17280b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f17280b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f17280b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.f17281c = pbListView;
        pbListView.b();
        this.f17281c.p(c1.transparent);
        this.f17281c.t(n.f(this.a.getActivity(), d1.tbds182));
        this.f17281c.y();
        this.f17281c.H(d1.tbfontsize33);
        this.f17281c.F(SkinManager.getColor(c1.CAM_X0107));
        this.f17281c.B(c1.CAM_X0110);
        this.f17281c.s();
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        this.f17282d = new c.a.u0.e1.x1.a(frsCommonTabFragment2, this.f17280b, frsViewData, frsCommonTabFragment2.tabType == 16);
        x(false);
        if (this.f17284f == null) {
            this.f17284f = new k(this.a.getPageContext(), this.f17280b);
        }
        if (c.a.t0.b.d.l()) {
            this.f17284f.p(2);
        } else {
            this.f17284f.p(1);
        }
        this.f17284f.u(this.a.getUniqueId());
        if (g()) {
            this.f17285g = new RelativeLayout(this.a.getContext());
            this.f17285g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f17286h = new c.a.u0.e1.z1.f.a.a(this.a, this.f17285g);
            this.f17280b.addHeaderView(this.f17285g, 0);
            this.f17286h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3.tabType == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.f17288j = i0Var;
            this.f17280b.addHeaderView(i0Var.a(), 0);
            this.f17288j.c(this.k);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17284f : (k) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17280b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final boolean k(ArrayList<c.a.d.o.e.n> arrayList, int i2) {
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
            c.a.u0.e1.x1.a aVar = this.f17282d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f17281c;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c1.CAM_X0107));
                this.f17281c.d(i2);
            }
            c.a.u0.e1.z1.f.a.a aVar2 = this.f17286h;
            if (aVar2 != null) {
                aVar2.h();
            }
            i0 i0Var = this.f17288j;
            if (i0Var != null) {
                i0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.u0.e1.x1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f17283e) == null || ListUtils.isEmpty(dVar.f17300g)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.f17283e.f17300g.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
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
        if (ListUtils.isEmpty(this.f17283e.f17300g)) {
            this.f17283e.f17300g.add(new s());
        }
        this.f17282d.i(this.f17283e.f17300g);
        this.f17282d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k kVar = this.f17284f;
            if (kVar != null) {
                kVar.h();
            }
            c.a.u0.e1.x1.a aVar = this.f17282d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.u0.e1.x1.d dVar) {
        i0 i0Var;
        c.a.u0.e1.z1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f17287i = dVar.f17298e;
        if (ListUtils.isEmpty(dVar.f17300g)) {
            s sVar = new s();
            ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
            dVar.f17300g = arrayList;
            arrayList.add(sVar);
            dVar.f17298e = false;
        }
        this.f17283e = dVar;
        this.f17281c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f17287i) {
            this.f17280b.setNextPage(this.f17281c);
            if (k(dVar.f17300g, 3)) {
                this.f17281c.C(null);
                this.f17281c.N();
            } else {
                this.f17281c.N();
                this.f17281c.C(this.l);
                this.f17281c.D(this.a.getResources().getString(i1.list_click_load_more));
            }
        } else {
            this.f17280b.setNextPage(null);
            this.f17281c.D(this.a.getResources().getString(i1.list_has_no_more));
            this.f17281c.C(null);
            this.f17281c.f();
        }
        this.f17282d.i(dVar.f17300g);
        this.f17282d.f();
        k kVar = this.f17284f;
        if (kVar != null) {
            kVar.n(this.f17280b.getFirstVisiblePosition(), this.f17280b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f17286h) != null) {
            aVar.g(this.a.getSortType());
            this.f17286h.j(this.a.forumId);
        }
        this.k = dVar.n;
        if (this.a.getFragmentActivity() instanceof m0) {
            ((m0) this.a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.a.tabType != 16 || (i0Var = this.f17288j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (kVar = this.f17284f) == null) {
            return;
        }
        kVar.y();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f17282d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.a = this.a.tabId;
            tVar.f17093b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (kVar = this.f17284f) == null) {
            return;
        }
        kVar.o();
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f17280b.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
            if (this.f17287i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17280b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f17280b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        c.a.u0.e1.x1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f17282d) == null) {
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
        tVar.f17093b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f17280b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bdTypeRecyclerView = this.f17280b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
