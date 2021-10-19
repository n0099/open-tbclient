package c.a.r0.x0.l1;

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
import c.a.r0.b0.u;
import c.a.r0.q2.i;
import c.a.r0.x0.h0;
import c.a.r0.x0.l0;
import c.a.r0.x0.s;
import c.a.r0.x0.t;
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
    public FrsCommonTabFragment f27165a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27166b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f27167c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.x0.l1.a f27168d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.x0.l1.d f27169e;

    /* renamed from: f  reason: collision with root package name */
    public i f27170f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f27171g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.x0.n1.f.a.a f27172h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27173i;

    /* renamed from: j  reason: collision with root package name */
    public h0 f27174j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27175e;

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
            this.f27175e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f27175e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.r0.x0.l1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1272b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27176e;

        public C1272b(b bVar) {
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
            this.f27176e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f27176e.f27166b != null) {
                    this.f27176e.f27166b.stopScroll();
                }
                if (this.f27176e.f27167c == null || this.f27176e.f27165a == null) {
                    return;
                }
                if (j.z()) {
                    this.f27176e.f27166b.setNextPage(this.f27176e.f27167c);
                    this.f27176e.f27167c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f27176e.f27167c.z(null);
                    if (this.f27176e.f27173i) {
                        this.f27176e.f27167c.L();
                        this.f27176e.f27167c.z(null);
                        this.f27176e.f27165a.loadmore();
                        return;
                    }
                    this.f27176e.f27167c.A(this.f27176e.f27165a.getResources().getString(R.string.list_has_no_more));
                    this.f27176e.f27167c.f();
                    this.f27176e.f27167c.z(null);
                    return;
                }
                this.f27176e.f27166b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f27177a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f27178b;

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
            this.f27178b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f27178b.f27170f != null) {
                    this.f27178b.f27170f.n(this.f27178b.f27166b.getFirstVisiblePosition(), this.f27178b.f27166b.getLastVisiblePosition(), this.f27177a, true);
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
                    this.f27177a = false;
                } else {
                    this.f27177a = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27179a;

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
            this.f27179a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f27179a.f27170f != null) {
                    this.f27179a.f27170f.k(view);
                    this.f27179a.f27170f.n(this.f27179a.f27166b.getFirstVisiblePosition(), this.f27179a.f27166b.getLastVisiblePosition(), false, true);
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
        this.m = new C1272b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f27165a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f27166b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f27165a.getContext()));
        this.f27166b.setFadingEdgeLength(0);
        this.f27166b.setOverScrollMode(2);
        this.f27166b.setOnSrollToBottomListener(this.m);
        this.f27166b.addOnScrollListener(this.n);
        this.f27166b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f27166b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f27166b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f27165a.getPageContext().getPageActivity());
        this.f27167c = pbListView;
        pbListView.b();
        this.f27167c.o(R.color.transparent);
        this.f27167c.r(l.g(this.f27165a.getActivity(), R.dimen.tbds182));
        this.f27167c.v();
        this.f27167c.E(R.dimen.tbfontsize33);
        this.f27167c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f27167c.y(R.color.CAM_X0110);
        this.f27167c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f27165a;
        this.f27168d = new c.a.r0.x0.l1.a(frsCommonTabFragment2, this.f27166b, frsViewData, frsCommonTabFragment2.tabType == 16);
        x(false);
        if (this.f27170f == null) {
            this.f27170f = new i(this.f27165a.getPageContext(), this.f27166b);
        }
        this.f27170f.p(1);
        this.f27170f.t(this.f27165a.getUniqueId());
        if (g()) {
            this.f27171g = new RelativeLayout(this.f27165a.getContext());
            this.f27171g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f27172h = new c.a.r0.x0.n1.f.a.a(this.f27165a, this.f27171g);
            this.f27166b.addHeaderView(this.f27171g, 0);
            this.f27172h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f27165a;
        if (frsCommonTabFragment3.tabType == 16) {
            h0 h0Var = new h0(frsCommonTabFragment3);
            this.f27174j = h0Var;
            this.f27166b.addHeaderView(h0Var.a(), 0);
            this.f27174j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f27165a;
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
            builder.tab_type = Integer.valueOf(this.f27165a.tabType);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.f27165a.tabType);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27170f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27166b : (BdTypeRecyclerView) invokeV.objValue;
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
            c.a.r0.x0.l1.a aVar = this.f27168d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f27167c;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f27167c.d(i2);
            }
            c.a.r0.x0.n1.f.a.a aVar2 = this.f27172h;
            if (aVar2 != null) {
                aVar2.h();
            }
            h0 h0Var = this.f27174j;
            if (h0Var != null) {
                h0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.r0.x0.l1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f27169e) == null || ListUtils.isEmpty(dVar.f27188g)) {
            return;
        }
        Iterator<n> it = this.f27169e.f27188g.iterator();
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
        if (ListUtils.isEmpty(this.f27169e.f27188g)) {
            this.f27169e.f27188g.add(new s());
        }
        this.f27168d.i(this.f27169e.f27188g);
        this.f27168d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f27170f;
            if (iVar != null) {
                iVar.h();
            }
            c.a.r0.x0.l1.a aVar = this.f27168d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.r0.x0.l1.d dVar) {
        h0 h0Var;
        c.a.r0.x0.n1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f27173i = dVar.f27186e;
        if (ListUtils.isEmpty(dVar.f27188g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f27188g = arrayList;
            arrayList.add(sVar);
            dVar.f27186e = false;
        }
        this.f27169e = dVar;
        this.f27167c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f27173i) {
            this.f27166b.setNextPage(this.f27167c);
            if (k(dVar.f27188g, 3)) {
                this.f27167c.z(null);
                this.f27167c.K();
            } else {
                this.f27167c.K();
                this.f27167c.z(this.l);
                this.f27167c.A(this.f27165a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f27166b.setNextPage(null);
            this.f27167c.A(this.f27165a.getResources().getString(R.string.list_has_no_more));
            this.f27167c.z(null);
            this.f27167c.f();
        }
        this.f27168d.i(dVar.f27188g);
        this.f27168d.f();
        i iVar = this.f27170f;
        if (iVar != null) {
            iVar.n(this.f27166b.getFirstVisiblePosition(), this.f27166b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f27172h) != null) {
            aVar.g(this.f27165a.getSortType());
            this.f27172h.j(this.f27165a.forumId);
        }
        this.k = dVar.n;
        if (this.f27165a.getFragmentActivity() instanceof l0) {
            ((l0) this.f27165a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f27165a.tabType != 16 || (h0Var = this.f27174j) == null) {
            return;
        }
        h0Var.c(this.k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f27170f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f27168d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.f28018a = this.f27165a.tabId;
            tVar.f28019b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f27170f) == null) {
            return;
        }
        iVar.o();
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f27166b.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
            if (this.f27173i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f27166b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f27166b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        c.a.r0.x0.l1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f27168d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f27165a == null) {
            return;
        }
        t tVar = new t();
        tVar.f28018a = this.f27165a.tabId;
        tVar.f28019b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f27166b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bdTypeRecyclerView = this.f27166b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
