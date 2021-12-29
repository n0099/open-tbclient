package c.a.t0.d1.w1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.d2;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
import c.a.t0.d1.i0;
import c.a.t0.d1.i1;
import c.a.t0.d1.m0;
import c.a.t0.d1.s;
import c.a.t0.d1.t;
import c.a.t0.g0.v;
import c.a.t0.z2.k;
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
    public BdTypeRecyclerView f17017b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f17018c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.d1.w1.a f17019d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.d1.w1.d f17020e;

    /* renamed from: f  reason: collision with root package name */
    public k f17021f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f17022g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.d1.y1.f.a.a f17023h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17024i;

    /* renamed from: j  reason: collision with root package name */
    public i0 f17025j;

    /* renamed from: k  reason: collision with root package name */
    public ItemInfo f17026k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17027e;

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
            this.f17027e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17027e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.t0.d1.w1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1039b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17028e;

        public C1039b(b bVar) {
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
            this.f17028e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17028e.f17017b != null) {
                    this.f17028e.f17017b.stopScroll();
                }
                if (this.f17028e.f17018c == null || this.f17028e.a == null) {
                    return;
                }
                if (l.z()) {
                    this.f17028e.f17017b.setNextPage(this.f17028e.f17018c);
                    this.f17028e.f17018c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f17028e.f17018c.C(null);
                    if (this.f17028e.f17024i) {
                        this.f17028e.f17018c.O();
                        this.f17028e.f17018c.C(null);
                        this.f17028e.a.loadmore();
                        return;
                    }
                    this.f17028e.f17018c.D(this.f17028e.a.getResources().getString(i1.list_has_no_more));
                    this.f17028e.f17018c.f();
                    this.f17028e.f17018c.C(null);
                    return;
                }
                this.f17028e.f17017b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17029b;

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
            this.f17029b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f17029b.f17021f != null) {
                    this.f17029b.f17021f.n(this.f17029b.f17017b.getFirstVisiblePosition(), this.f17029b.f17017b.getLastVisiblePosition(), this.a, true);
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
                if (this.a.f17021f != null) {
                    this.a.f17021f.k(view);
                    this.a.f17021f.n(this.a.f17017b.getFirstVisiblePosition(), this.a.f17017b.getLastVisiblePosition(), false, true);
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
        this.m = new C1039b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_common_tab_recycler_view);
        this.f17017b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f17017b.setFadingEdgeLength(0);
        this.f17017b.setOverScrollMode(2);
        this.f17017b.setOnSrollToBottomListener(this.m);
        this.f17017b.addOnScrollListener(this.n);
        this.f17017b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f17017b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f17017b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.f17018c = pbListView;
        pbListView.b();
        this.f17018c.p(c1.transparent);
        this.f17018c.t(n.f(this.a.getActivity(), d1.tbds182));
        this.f17018c.y();
        this.f17018c.H(d1.tbfontsize33);
        this.f17018c.F(SkinManager.getColor(c1.CAM_X0107));
        this.f17018c.B(c1.CAM_X0110);
        this.f17018c.s();
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        this.f17019d = new c.a.t0.d1.w1.a(frsCommonTabFragment2, this.f17017b, frsViewData, frsCommonTabFragment2.tabType == 16);
        x(false);
        if (this.f17021f == null) {
            this.f17021f = new k(this.a.getPageContext(), this.f17017b);
        }
        if (c.a.s0.b.d.o()) {
            this.f17021f.p(2);
        } else {
            this.f17021f.p(1);
        }
        this.f17021f.u(this.a.getUniqueId());
        if (g()) {
            this.f17022g = new RelativeLayout(this.a.getContext());
            this.f17022g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f17023h = new c.a.t0.d1.y1.f.a.a(this.a, this.f17022g);
            this.f17017b.addHeaderView(this.f17022g, 0);
            this.f17023h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3.tabType == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.f17025j = i0Var;
            this.f17017b.addHeaderView(i0Var.a(), 0);
            this.f17025j.c(this.f17026k);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17021f : (k) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17017b : (BdTypeRecyclerView) invokeV.objValue;
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
                if (arrayList.get(i3) instanceof c2) {
                    int i5 = i3 - 1;
                    i3 = ((arrayList.get(i5) instanceof c2) && ((c2) arrayList.get(i3)).position == ((c2) arrayList.get(i5)).position) ? i3 + 1 : 1;
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
            c.a.t0.d1.w1.a aVar = this.f17019d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f17018c;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c1.CAM_X0107));
                this.f17018c.d(i2);
            }
            c.a.t0.d1.y1.f.a.a aVar2 = this.f17023h;
            if (aVar2 != null) {
                aVar2.h();
            }
            i0 i0Var = this.f17025j;
            if (i0Var != null) {
                i0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.t0.d1.w1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f17020e) == null || ListUtils.isEmpty(dVar.f17039g)) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = this.f17020e.f17039g.iterator();
        while (it.hasNext()) {
            c.a.d.n.e.n next = it.next();
            d2 d2Var = null;
            if (next instanceof c2) {
                d2Var = ((c2) next).w;
            } else if (next instanceof d2) {
                d2Var = (d2) next;
            }
            if (d2Var != null && TextUtils.equals(str, d2Var.g0())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.f17020e.f17039g)) {
            this.f17020e.f17039g.add(new s());
        }
        this.f17019d.i(this.f17020e.f17039g);
        this.f17019d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k kVar = this.f17021f;
            if (kVar != null) {
                kVar.h();
            }
            c.a.t0.d1.w1.a aVar = this.f17019d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.t0.d1.w1.d dVar) {
        i0 i0Var;
        c.a.t0.d1.y1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f17024i = dVar.f17037e;
        if (ListUtils.isEmpty(dVar.f17039g)) {
            s sVar = new s();
            ArrayList<c.a.d.n.e.n> arrayList = new ArrayList<>();
            dVar.f17039g = arrayList;
            arrayList.add(sVar);
            dVar.f17037e = false;
        }
        this.f17020e = dVar;
        this.f17018c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f17024i) {
            this.f17017b.setNextPage(this.f17018c);
            if (k(dVar.f17039g, 3)) {
                this.f17018c.C(null);
                this.f17018c.N();
            } else {
                this.f17018c.N();
                this.f17018c.C(this.l);
                this.f17018c.D(this.a.getResources().getString(i1.list_click_load_more));
            }
        } else {
            this.f17017b.setNextPage(null);
            this.f17018c.D(this.a.getResources().getString(i1.list_has_no_more));
            this.f17018c.C(null);
            this.f17018c.f();
        }
        this.f17019d.i(dVar.f17039g);
        this.f17019d.f();
        k kVar = this.f17021f;
        if (kVar != null) {
            kVar.n(this.f17017b.getFirstVisiblePosition(), this.f17017b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f17023h) != null) {
            aVar.g(this.a.getSortType());
            this.f17023h.j(this.a.forumId);
        }
        this.f17026k = dVar.n;
        if (this.a.getFragmentActivity() instanceof m0) {
            ((m0) this.a.getFragmentActivity()).setItemInfo(this.f17026k);
        }
        if (this.a.tabType != 16 || (i0Var = this.f17025j) == null) {
            return;
        }
        i0Var.c(this.f17026k);
    }

    public void p() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (kVar = this.f17021f) == null) {
            return;
        }
        kVar.y();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f17019d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.a = this.a.tabId;
            tVar.f16915b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (kVar = this.f17021f) == null) {
            return;
        }
        kVar.o();
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f17017b.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
            if (this.f17024i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17017b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f17017b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        c.a.t0.d1.w1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f17019d) == null) {
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
        tVar.f16915b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f17017b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bdTypeRecyclerView = this.f17017b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
