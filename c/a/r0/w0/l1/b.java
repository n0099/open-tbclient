package c.a.r0.w0.l1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.a0.t;
import c.a.r0.p2.i;
import c.a.r0.w0.h0;
import c.a.r0.w0.l0;
import c.a.r0.w0.s;
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
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f26970a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26971b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f26972c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.w0.l1.a f26973d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.w0.l1.d f26974e;

    /* renamed from: f  reason: collision with root package name */
    public i f26975f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f26976g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.w0.n1.f.a.a f26977h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26978i;

    /* renamed from: j  reason: collision with root package name */
    public h0 f26979j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26980e;

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
            this.f26980e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26980e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.r0.w0.l1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1265b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26981e;

        public C1265b(b bVar) {
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
            this.f26981e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26981e.f26971b != null) {
                    this.f26981e.f26971b.stopScroll();
                }
                if (this.f26981e.f26972c == null || this.f26981e.f26970a == null) {
                    return;
                }
                if (j.z()) {
                    this.f26981e.f26971b.setNextPage(this.f26981e.f26972c);
                    this.f26981e.f26972c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f26981e.f26972c.z(null);
                    if (this.f26981e.f26978i) {
                        this.f26981e.f26972c.L();
                        this.f26981e.f26972c.z(null);
                        this.f26981e.f26970a.loadmore();
                        return;
                    }
                    this.f26981e.f26972c.A(this.f26981e.f26970a.getResources().getString(R.string.list_has_no_more));
                    this.f26981e.f26972c.f();
                    this.f26981e.f26972c.z(null);
                    return;
                }
                this.f26981e.f26971b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f26982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f26983b;

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
            this.f26983b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f26983b.f26975f != null) {
                    this.f26983b.f26975f.n(this.f26983b.f26971b.getFirstVisiblePosition(), this.f26983b.f26971b.getLastVisiblePosition(), this.f26982a, true);
                }
                t.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f26982a = false;
                } else {
                    this.f26982a = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26984a;

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
            this.f26984a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f26984a.f26975f != null) {
                    this.f26984a.f26975f.k(view);
                }
                if (view != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
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
        this.m = new C1265b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f26970a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f26971b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f26970a.getContext()));
        this.f26971b.setFadingEdgeLength(0);
        this.f26971b.setOverScrollMode(2);
        this.f26971b.setOnSrollToBottomListener(this.m);
        this.f26971b.addOnScrollListener(this.n);
        this.f26971b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f26971b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f26971b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f26970a.getPageContext().getPageActivity());
        this.f26972c = pbListView;
        pbListView.b();
        this.f26972c.o(R.color.transparent);
        this.f26972c.r(l.g(this.f26970a.getActivity(), R.dimen.tbds182));
        this.f26972c.v();
        this.f26972c.E(R.dimen.tbfontsize33);
        this.f26972c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f26972c.y(R.color.CAM_X0110);
        this.f26972c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f26970a;
        this.f26973d = new c.a.r0.w0.l1.a(frsCommonTabFragment2, this.f26971b, frsViewData, frsCommonTabFragment2.tabType == 16);
        w(false);
        if (this.f26975f == null) {
            this.f26975f = new i(this.f26970a.getPageContext(), this.f26971b);
        }
        this.f26975f.p(1);
        this.f26975f.t(this.f26970a.getUniqueId());
        if (g()) {
            this.f26976g = new RelativeLayout(this.f26970a.getContext());
            this.f26976g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f26977h = new c.a.r0.w0.n1.f.a.a(this.f26970a, this.f26976g);
            this.f26971b.addHeaderView(this.f26976g, 0);
            this.f26977h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f26970a;
        if (frsCommonTabFragment3.tabType == 16) {
            h0 h0Var = new h0(frsCommonTabFragment3);
            this.f26979j = h0Var;
            this.f26971b.addHeaderView(h0Var.a(), 0);
            this.f26979j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f26970a;
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
            builder.tab_type = Integer.valueOf(this.f26970a.tabType);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.f26970a.tabType);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26975f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26971b : (BdTypeRecyclerView) invokeV.objValue;
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
            c.a.r0.w0.l1.a aVar = this.f26973d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f26972c;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f26972c.d(i2);
            }
            c.a.r0.w0.n1.f.a.a aVar2 = this.f26977h;
            if (aVar2 != null) {
                aVar2.h();
            }
            h0 h0Var = this.f26979j;
            if (h0Var != null) {
                h0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.r0.w0.l1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f26974e) == null || ListUtils.isEmpty(dVar.f26993g)) {
            return;
        }
        Iterator<n> it = this.f26974e.f26993g.iterator();
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
        if (ListUtils.isEmpty(this.f26974e.f26993g)) {
            this.f26974e.f26993g.add(new s());
        }
        this.f26973d.i(this.f26974e.f26993g);
        this.f26973d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f26975f;
            if (iVar != null) {
                iVar.h();
            }
            c.a.r0.w0.l1.a aVar = this.f26973d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.r0.w0.l1.d dVar) {
        h0 h0Var;
        c.a.r0.w0.n1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f26978i = dVar.f26991e;
        if (ListUtils.isEmpty(dVar.f26993g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f26993g = arrayList;
            arrayList.add(sVar);
            dVar.f26991e = false;
        }
        this.f26974e = dVar;
        this.f26972c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f26978i) {
            this.f26971b.setNextPage(this.f26972c);
            if (k(dVar.f26993g, 3)) {
                this.f26972c.z(null);
                this.f26972c.K();
            } else {
                this.f26972c.K();
                this.f26972c.z(this.l);
                this.f26972c.A(this.f26970a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f26971b.setNextPage(null);
            this.f26972c.A(this.f26970a.getResources().getString(R.string.list_has_no_more));
            this.f26972c.z(null);
            this.f26972c.f();
        }
        this.f26973d.i(dVar.f26993g);
        this.f26973d.f();
        i iVar = this.f26975f;
        if (iVar != null) {
            iVar.n(this.f26971b.getFirstVisiblePosition(), this.f26971b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f26977h) != null) {
            aVar.g(this.f26970a.getSortType());
            this.f26977h.j(this.f26970a.forumId);
        }
        this.k = dVar.n;
        if (this.f26970a.getFragmentActivity() instanceof l0) {
            ((l0) this.f26970a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f26970a.tabType != 16 || (h0Var = this.f26979j) == null) {
            return;
        }
        h0Var.c(this.k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f26975f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26973d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.w0.t tVar = new c.a.r0.w0.t();
            tVar.f27822a = this.f26970a.tabId;
            tVar.f27823b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f26975f) == null) {
            return;
        }
        iVar.o();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f26971b.scrollToPosition(0);
        }
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (bdTypeRecyclerView = this.f26971b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z) {
        c.a.r0.w0.l1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (aVar = this.f26973d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f26970a == null) {
            return;
        }
        c.a.r0.w0.t tVar = new c.a.r0.w0.t();
        tVar.f27822a = this.f26970a.tabId;
        tVar.f27823b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onScrollListener) == null) {
            this.f26971b.setOnScrollListener(onScrollListener);
        }
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (bdTypeRecyclerView = this.f26971b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
