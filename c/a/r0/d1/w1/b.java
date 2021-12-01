package c.a.r0.d1.w1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.i0;
import c.a.r0.d1.i1;
import c.a.r0.d1.m0;
import c.a.r0.d1.s;
import c.a.r0.d1.t;
import c.a.r0.g0.v;
import c.a.r0.x2.i;
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
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f16112b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f16113c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.d1.w1.a f16114d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.d1.w1.d f16115e;

    /* renamed from: f  reason: collision with root package name */
    public i f16116f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f16117g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.d1.y1.f.a.a f16118h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16119i;

    /* renamed from: j  reason: collision with root package name */
    public i0 f16120j;

    /* renamed from: k  reason: collision with root package name */
    public ItemInfo f16121k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16122e;

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
            this.f16122e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16122e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.r0.d1.w1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0970b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16123e;

        public C0970b(b bVar) {
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
            this.f16123e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f16123e.f16112b != null) {
                    this.f16123e.f16112b.stopScroll();
                }
                if (this.f16123e.f16113c == null || this.f16123e.a == null) {
                    return;
                }
                if (j.z()) {
                    this.f16123e.f16112b.setNextPage(this.f16123e.f16113c);
                    this.f16123e.f16113c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f16123e.f16113c.B(null);
                    if (this.f16123e.f16119i) {
                        this.f16123e.f16113c.N();
                        this.f16123e.f16113c.B(null);
                        this.f16123e.a.loadmore();
                        return;
                    }
                    this.f16123e.f16113c.C(this.f16123e.a.getResources().getString(i1.list_has_no_more));
                    this.f16123e.f16113c.f();
                    this.f16123e.f16113c.B(null);
                    return;
                }
                this.f16123e.f16112b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f16124b;

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
            this.f16124b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f16124b.f16116f != null) {
                    this.f16124b.f16116f.n(this.f16124b.f16112b.getFirstVisiblePosition(), this.f16124b.f16112b.getLastVisiblePosition(), this.a, true);
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

    /* loaded from: classes5.dex */
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
                if (this.a.f16116f != null) {
                    this.a.f16116f.k(view);
                    this.a.f16116f.n(this.a.f16112b.getFirstVisiblePosition(), this.a.f16112b.getLastVisiblePosition(), false, true);
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
        this.m = new C0970b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_common_tab_recycler_view);
        this.f16112b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f16112b.setFadingEdgeLength(0);
        this.f16112b.setOverScrollMode(2);
        this.f16112b.setOnSrollToBottomListener(this.m);
        this.f16112b.addOnScrollListener(this.n);
        this.f16112b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f16112b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f16112b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.f16113c = pbListView;
        pbListView.b();
        this.f16113c.p(c1.transparent);
        this.f16113c.s(l.f(this.a.getActivity(), d1.tbds182));
        this.f16113c.x();
        this.f16113c.G(d1.tbfontsize33);
        this.f16113c.E(SkinManager.getColor(c1.CAM_X0107));
        this.f16113c.A(c1.CAM_X0110);
        this.f16113c.r();
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        this.f16114d = new c.a.r0.d1.w1.a(frsCommonTabFragment2, this.f16112b, frsViewData, frsCommonTabFragment2.tabType == 16);
        x(false);
        if (this.f16116f == null) {
            this.f16116f = new i(this.a.getPageContext(), this.f16112b);
        }
        this.f16116f.p(1);
        this.f16116f.t(this.a.getUniqueId());
        if (g()) {
            this.f16117g = new RelativeLayout(this.a.getContext());
            this.f16117g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f16118h = new c.a.r0.d1.y1.f.a.a(this.a, this.f16117g);
            this.f16112b.addHeaderView(this.f16117g, 0);
            this.f16118h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3.tabType == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.f16120j = i0Var;
            this.f16112b.addHeaderView(i0Var.a(), 0);
            this.f16120j.c(this.f16121k);
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

    public i i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16116f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16112b : (BdTypeRecyclerView) invokeV.objValue;
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
            c.a.r0.d1.w1.a aVar = this.f16114d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f16113c;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(c1.CAM_X0107));
                this.f16113c.d(i2);
            }
            c.a.r0.d1.y1.f.a.a aVar2 = this.f16118h;
            if (aVar2 != null) {
                aVar2.h();
            }
            i0 i0Var = this.f16120j;
            if (i0Var != null) {
                i0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.r0.d1.w1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f16115e) == null || ListUtils.isEmpty(dVar.f16134g)) {
            return;
        }
        Iterator<n> it = this.f16115e.f16134g.iterator();
        while (it.hasNext()) {
            n next = it.next();
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
        if (ListUtils.isEmpty(this.f16115e.f16134g)) {
            this.f16115e.f16134g.add(new s());
        }
        this.f16114d.i(this.f16115e.f16134g);
        this.f16114d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f16116f;
            if (iVar != null) {
                iVar.h();
            }
            c.a.r0.d1.w1.a aVar = this.f16114d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.r0.d1.w1.d dVar) {
        i0 i0Var;
        c.a.r0.d1.y1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f16119i = dVar.f16132e;
        if (ListUtils.isEmpty(dVar.f16134g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f16134g = arrayList;
            arrayList.add(sVar);
            dVar.f16132e = false;
        }
        this.f16115e = dVar;
        this.f16113c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f16119i) {
            this.f16112b.setNextPage(this.f16113c);
            if (k(dVar.f16134g, 3)) {
                this.f16113c.B(null);
                this.f16113c.M();
            } else {
                this.f16113c.M();
                this.f16113c.B(this.l);
                this.f16113c.C(this.a.getResources().getString(i1.list_click_load_more));
            }
        } else {
            this.f16112b.setNextPage(null);
            this.f16113c.C(this.a.getResources().getString(i1.list_has_no_more));
            this.f16113c.B(null);
            this.f16113c.f();
        }
        this.f16114d.i(dVar.f16134g);
        this.f16114d.f();
        i iVar = this.f16116f;
        if (iVar != null) {
            iVar.n(this.f16112b.getFirstVisiblePosition(), this.f16112b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f16118h) != null) {
            aVar.g(this.a.getSortType());
            this.f16118h.j(this.a.forumId);
        }
        this.f16121k = dVar.n;
        if (this.a.getFragmentActivity() instanceof m0) {
            ((m0) this.a.getFragmentActivity()).setItemInfo(this.f16121k);
        }
        if (this.a.tabType != 16 || (i0Var = this.f16120j) == null) {
            return;
        }
        i0Var.c(this.f16121k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f16116f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16114d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.a = this.a.tabId;
            tVar.f16010b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f16116f) == null) {
            return;
        }
        iVar.o();
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f16112b.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
            if (this.f16119i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f16112b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f16112b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        c.a.r0.d1.w1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f16114d) == null) {
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
        tVar.f16010b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f16112b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bdTypeRecyclerView = this.f16112b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
