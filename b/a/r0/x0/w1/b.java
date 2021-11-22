package b.a.r0.x0.w1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.b0.v;
import b.a.r0.q2.i;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.i0;
import b.a.r0.x0.i1;
import b.a.r0.x0.m0;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f28024a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f28025b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f28026c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.x0.w1.a f28027d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.x0.w1.d f28028e;

    /* renamed from: f  reason: collision with root package name */
    public i f28029f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f28030g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.x0.y1.f.a.a f28031h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28032i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28033e;

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
            this.f28033e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f28033e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: b.a.r0.x0.w1.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1369b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28034e;

        public C1369b(b bVar) {
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
            this.f28034e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28034e.f28025b != null) {
                    this.f28034e.f28025b.stopScroll();
                }
                if (this.f28034e.f28026c == null || this.f28034e.f28024a == null) {
                    return;
                }
                if (j.z()) {
                    this.f28034e.f28025b.setNextPage(this.f28034e.f28026c);
                    this.f28034e.f28026c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f28034e.f28026c.B(null);
                    if (this.f28034e.f28032i) {
                        this.f28034e.f28026c.N();
                        this.f28034e.f28026c.B(null);
                        this.f28034e.f28024a.loadmore();
                        return;
                    }
                    this.f28034e.f28026c.C(this.f28034e.f28024a.getResources().getString(i1.list_has_no_more));
                    this.f28034e.f28026c.f();
                    this.f28034e.f28026c.B(null);
                    return;
                }
                this.f28034e.f28025b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28035a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f28036b;

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
            this.f28036b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f28036b.f28029f != null) {
                    this.f28036b.f28029f.n(this.f28036b.f28025b.getFirstVisiblePosition(), this.f28036b.f28025b.getLastVisiblePosition(), this.f28035a, true);
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
                    this.f28035a = false;
                } else {
                    this.f28035a = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28037a;

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
            this.f28037a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f28037a.f28029f != null) {
                    this.f28037a.f28029f.k(view);
                    this.f28037a.f28029f.n(this.f28037a.f28025b.getFirstVisiblePosition(), this.f28037a.f28025b.getLastVisiblePosition(), false, true);
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
        this.m = new C1369b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f28024a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_common_tab_recycler_view);
        this.f28025b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f28024a.getContext()));
        this.f28025b.setFadingEdgeLength(0);
        this.f28025b.setOverScrollMode(2);
        this.f28025b.setOnSrollToBottomListener(this.m);
        this.f28025b.addOnScrollListener(this.n);
        this.f28025b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f28025b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f28025b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f28024a.getPageContext().getPageActivity());
        this.f28026c = pbListView;
        pbListView.b();
        this.f28026c.p(c1.transparent);
        this.f28026c.s(l.g(this.f28024a.getActivity(), d1.tbds182));
        this.f28026c.x();
        this.f28026c.G(d1.tbfontsize33);
        this.f28026c.E(SkinManager.getColor(c1.CAM_X0107));
        this.f28026c.A(c1.CAM_X0110);
        this.f28026c.r();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f28024a;
        this.f28027d = new b.a.r0.x0.w1.a(frsCommonTabFragment2, this.f28025b, frsViewData, frsCommonTabFragment2.tabType == 16);
        x(false);
        if (this.f28029f == null) {
            this.f28029f = new i(this.f28024a.getPageContext(), this.f28025b);
        }
        this.f28029f.p(1);
        this.f28029f.t(this.f28024a.getUniqueId());
        if (g()) {
            this.f28030g = new RelativeLayout(this.f28024a.getContext());
            this.f28030g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f28031h = new b.a.r0.x0.y1.f.a.a(this.f28024a, this.f28030g);
            this.f28025b.addHeaderView(this.f28030g, 0);
            this.f28031h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f28024a;
        if (frsCommonTabFragment3.tabType == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f28025b.addHeaderView(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f28024a;
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
            builder.tab_type = Integer.valueOf(this.f28024a.tabType);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.f28024a.tabType);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28029f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28025b : (BdTypeRecyclerView) invokeV.objValue;
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
            b.a.r0.x0.w1.a aVar = this.f28027d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f28026c;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(c1.CAM_X0107));
                this.f28026c.d(i2);
            }
            b.a.r0.x0.y1.f.a.a aVar2 = this.f28031h;
            if (aVar2 != null) {
                aVar2.h();
            }
            i0 i0Var = this.j;
            if (i0Var != null) {
                i0Var.b();
            }
        }
    }

    public void m(String str) {
        b.a.r0.x0.w1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f28028e) == null || ListUtils.isEmpty(dVar.f28045g)) {
            return;
        }
        Iterator<n> it = this.f28028e.f28045g.iterator();
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
        if (ListUtils.isEmpty(this.f28028e.f28045g)) {
            this.f28028e.f28045g.add(new s());
        }
        this.f28027d.i(this.f28028e.f28045g);
        this.f28027d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f28029f;
            if (iVar != null) {
                iVar.h();
            }
            b.a.r0.x0.w1.a aVar = this.f28027d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(b.a.r0.x0.w1.d dVar) {
        i0 i0Var;
        b.a.r0.x0.y1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f28032i = dVar.f28043e;
        if (ListUtils.isEmpty(dVar.f28045g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f28045g = arrayList;
            arrayList.add(sVar);
            dVar.f28043e = false;
        }
        this.f28028e = dVar;
        this.f28026c.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f28032i) {
            this.f28025b.setNextPage(this.f28026c);
            if (k(dVar.f28045g, 3)) {
                this.f28026c.B(null);
                this.f28026c.M();
            } else {
                this.f28026c.M();
                this.f28026c.B(this.l);
                this.f28026c.C(this.f28024a.getResources().getString(i1.list_click_load_more));
            }
        } else {
            this.f28025b.setNextPage(null);
            this.f28026c.C(this.f28024a.getResources().getString(i1.list_has_no_more));
            this.f28026c.B(null);
            this.f28026c.f();
        }
        this.f28027d.i(dVar.f28045g);
        this.f28027d.f();
        i iVar = this.f28029f;
        if (iVar != null) {
            iVar.n(this.f28025b.getFirstVisiblePosition(), this.f28025b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f28031h) != null) {
            aVar.g(this.f28024a.getSortType());
            this.f28031h.j(this.f28024a.forumId);
        }
        this.k = dVar.n;
        if (this.f28024a.getFragmentActivity() instanceof m0) {
            ((m0) this.f28024a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f28024a.tabType != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f28029f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f28027d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.f27908a = this.f28024a.tabId;
            tVar.f27909b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f28029f) == null) {
            return;
        }
        iVar.o();
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f28025b.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
            if (this.f28032i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f28025b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f28025b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        b.a.r0.x0.w1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f28027d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f28024a == null) {
            return;
        }
        t tVar = new t();
        tVar.f27908a = this.f28024a.tabId;
        tVar.f27909b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f28025b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bdTypeRecyclerView = this.f28025b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
