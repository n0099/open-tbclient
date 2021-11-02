package b.a.r0.x0.v1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.b0.u;
import b.a.r0.q2.i;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h0;
import b.a.r0.x0.h1;
import b.a.r0.x0.l0;
import b.a.r0.x0.s;
import b.a.r0.x0.t;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f26424a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26425b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f26426c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.x0.v1.a f26427d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.x0.v1.d f26428e;

    /* renamed from: f  reason: collision with root package name */
    public i f26429f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f26430g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.x0.x1.f.a.a f26431h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26432i;
    public h0 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26433e;

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
            this.f26433e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26433e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: b.a.r0.x0.v1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1296b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26434e;

        public C1296b(b bVar) {
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
            this.f26434e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26434e.f26425b != null) {
                    this.f26434e.f26425b.stopScroll();
                }
                if (this.f26434e.f26426c == null || this.f26434e.f26424a == null) {
                    return;
                }
                if (j.z()) {
                    this.f26434e.f26425b.setNextPage(this.f26434e.f26426c);
                    this.f26434e.f26426c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f26434e.f26426c.B(null);
                    if (this.f26434e.f26432i) {
                        this.f26434e.f26426c.N();
                        this.f26434e.f26426c.B(null);
                        this.f26434e.f26424a.loadmore();
                        return;
                    }
                    this.f26434e.f26426c.C(this.f26434e.f26424a.getResources().getString(h1.list_has_no_more));
                    this.f26434e.f26426c.f();
                    this.f26434e.f26426c.B(null);
                    return;
                }
                this.f26434e.f26425b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f26435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f26436b;

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
            this.f26436b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f26436b.f26429f != null) {
                    this.f26436b.f26429f.n(this.f26436b.f26425b.getFirstVisiblePosition(), this.f26436b.f26425b.getLastVisiblePosition(), this.f26435a, true);
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
                    this.f26435a = false;
                } else {
                    this.f26435a = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26437a;

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
            this.f26437a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f26437a.f26429f != null) {
                    this.f26437a.f26429f.k(view);
                    this.f26437a.f26429f.n(this.f26437a.f26425b.getFirstVisiblePosition(), this.f26437a.f26425b.getLastVisiblePosition(), false, true);
                }
                if (view != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(e1.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(e1.abstract_img_layout);
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
        this.m = new C1296b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f26424a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(e1.frs_common_tab_recycler_view);
        this.f26425b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f26424a.getContext()));
        this.f26425b.setFadingEdgeLength(0);
        this.f26425b.setOverScrollMode(2);
        this.f26425b.setOnSrollToBottomListener(this.m);
        this.f26425b.addOnScrollListener(this.n);
        this.f26425b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f26425b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f26425b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f26424a.getPageContext().getPageActivity());
        this.f26426c = pbListView;
        pbListView.b();
        this.f26426c.p(b1.transparent);
        this.f26426c.s(l.g(this.f26424a.getActivity(), c1.tbds182));
        this.f26426c.x();
        this.f26426c.G(c1.tbfontsize33);
        this.f26426c.E(SkinManager.getColor(b1.CAM_X0107));
        this.f26426c.A(b1.CAM_X0110);
        this.f26426c.r();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f26424a;
        this.f26427d = new b.a.r0.x0.v1.a(frsCommonTabFragment2, this.f26425b, frsViewData, frsCommonTabFragment2.tabType == 16);
        x(false);
        if (this.f26429f == null) {
            this.f26429f = new i(this.f26424a.getPageContext(), this.f26425b);
        }
        this.f26429f.p(1);
        this.f26429f.t(this.f26424a.getUniqueId());
        if (g()) {
            this.f26430g = new RelativeLayout(this.f26424a.getContext());
            this.f26430g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f26431h = new b.a.r0.x0.x1.f.a.a(this.f26424a, this.f26430g);
            this.f26425b.addHeaderView(this.f26430g, 0);
            this.f26431h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f26424a;
        if (frsCommonTabFragment3.tabType == 16) {
            h0 h0Var = new h0(frsCommonTabFragment3);
            this.j = h0Var;
            this.f26425b.addHeaderView(h0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f26424a;
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
            builder.tab_type = Integer.valueOf(this.f26424a.tabType);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.f26424a.tabType);
            FrsTabInfo build2 = builder2.build(true);
            arrayList.add(build);
            arrayList.add(build2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public i i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26429f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26425b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final boolean k(ArrayList<n> arrayList, int i2) {
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
            b.a.r0.x0.v1.a aVar = this.f26427d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f26426c;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(b1.CAM_X0107));
                this.f26426c.d(i2);
            }
            b.a.r0.x0.x1.f.a.a aVar2 = this.f26431h;
            if (aVar2 != null) {
                aVar2.h();
            }
            h0 h0Var = this.j;
            if (h0Var != null) {
                h0Var.b();
            }
        }
    }

    public void m(String str) {
        b.a.r0.x0.v1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f26428e) == null || ListUtils.isEmpty(dVar.f26445g)) {
            return;
        }
        Iterator<n> it = this.f26428e.f26445g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            d2 d2Var = null;
            if (next instanceof c2) {
                d2Var = ((c2) next).w;
            } else if (next instanceof d2) {
                d2Var = (d2) next;
            }
            if (d2Var != null && TextUtils.equals(str, d2Var.f0())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.f26428e.f26445g)) {
            this.f26428e.f26445g.add(new s());
        }
        this.f26427d.i(this.f26428e.f26445g);
        this.f26427d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f26429f;
            if (iVar != null) {
                iVar.h();
            }
            b.a.r0.x0.v1.a aVar = this.f26427d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(b.a.r0.x0.v1.d dVar) {
        h0 h0Var;
        b.a.r0.x0.x1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f26432i = dVar.f26443e;
        if (ListUtils.isEmpty(dVar.f26445g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f26445g = arrayList;
            arrayList.add(sVar);
            dVar.f26443e = false;
        }
        this.f26428e = dVar;
        this.f26426c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f26432i) {
            this.f26425b.setNextPage(this.f26426c);
            if (k(dVar.f26445g, 3)) {
                this.f26426c.B(null);
                this.f26426c.M();
            } else {
                this.f26426c.M();
                this.f26426c.B(this.l);
                this.f26426c.C(this.f26424a.getResources().getString(h1.list_click_load_more));
            }
        } else {
            this.f26425b.setNextPage(null);
            this.f26426c.C(this.f26424a.getResources().getString(h1.list_has_no_more));
            this.f26426c.B(null);
            this.f26426c.f();
        }
        this.f26427d.i(dVar.f26445g);
        this.f26427d.f();
        i iVar = this.f26429f;
        if (iVar != null) {
            iVar.n(this.f26425b.getFirstVisiblePosition(), this.f26425b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f26431h) != null) {
            aVar.g(this.f26424a.getSortType());
            this.f26431h.j(this.f26424a.forumId);
        }
        this.k = dVar.n;
        if (this.f26424a.getFragmentActivity() instanceof l0) {
            ((l0) this.f26424a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f26424a.tabType != 16 || (h0Var = this.j) == null) {
            return;
        }
        h0Var.c(this.k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f26429f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26427d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.f26328a = this.f26424a.tabId;
            tVar.f26329b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f26429f) == null) {
            return;
        }
        iVar.o();
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f26425b.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
            if (this.f26432i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f26425b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f26425b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        b.a.r0.x0.v1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f26427d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f26424a == null) {
            return;
        }
        t tVar = new t();
        tVar.f26328a = this.f26424a.tabId;
        tVar.f26329b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f26425b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bdTypeRecyclerView = this.f26425b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
