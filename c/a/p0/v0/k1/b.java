package c.a.p0.v0.k1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
import c.a.p0.a0.t;
import c.a.p0.o2.i;
import c.a.p0.v0.h0;
import c.a.p0.v0.l0;
import c.a.p0.v0.s;
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
    public FrsCommonTabFragment f25967a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f25968b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f25969c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.v0.k1.a f25970d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.v0.k1.d f25971e;

    /* renamed from: f  reason: collision with root package name */
    public i f25972f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f25973g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.v0.m1.f.a.a f25974h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25975i;

    /* renamed from: j  reason: collision with root package name */
    public h0 f25976j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25977e;

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
            this.f25977e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25977e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.p0.v0.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1215b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25978e;

        public C1215b(b bVar) {
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
            this.f25978e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25978e.f25968b != null) {
                    this.f25978e.f25968b.stopScroll();
                }
                if (this.f25978e.f25969c == null || this.f25978e.f25967a == null) {
                    return;
                }
                if (j.z()) {
                    this.f25978e.f25968b.setNextPage(this.f25978e.f25969c);
                    this.f25978e.f25969c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f25978e.f25969c.z(null);
                    if (this.f25978e.f25975i) {
                        this.f25978e.f25969c.L();
                        this.f25978e.f25969c.z(null);
                        this.f25978e.f25967a.loadmore();
                        return;
                    }
                    this.f25978e.f25969c.A(this.f25978e.f25967a.getResources().getString(R.string.list_has_no_more));
                    this.f25978e.f25969c.f();
                    this.f25978e.f25969c.z(null);
                    return;
                }
                this.f25978e.f25968b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f25979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f25980b;

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
            this.f25980b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f25980b.f25972f != null) {
                    this.f25980b.f25972f.n(this.f25980b.f25968b.getFirstVisiblePosition(), this.f25980b.f25968b.getLastVisiblePosition(), this.f25979a, true);
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
                    this.f25979a = false;
                } else {
                    this.f25979a = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25981a;

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
            this.f25981a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f25981a.f25972f != null) {
                    this.f25981a.f25972f.k(view);
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
        this.m = new C1215b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f25967a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f25968b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f25967a.getContext()));
        this.f25968b.setFadingEdgeLength(0);
        this.f25968b.setOverScrollMode(2);
        this.f25968b.setOnSrollToBottomListener(this.m);
        this.f25968b.addOnScrollListener(this.n);
        this.f25968b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f25968b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f25968b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f25967a.getPageContext().getPageActivity());
        this.f25969c = pbListView;
        pbListView.b();
        this.f25969c.o(R.color.transparent);
        this.f25969c.r(l.g(this.f25967a.getActivity(), R.dimen.tbds182));
        this.f25969c.v();
        this.f25969c.E(R.dimen.tbfontsize33);
        this.f25969c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f25969c.y(R.color.CAM_X0110);
        this.f25969c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f25967a;
        this.f25970d = new c.a.p0.v0.k1.a(frsCommonTabFragment2, this.f25968b, frsViewData, frsCommonTabFragment2.tabType == 16);
        w(false);
        if (this.f25972f == null) {
            this.f25972f = new i(this.f25967a.getPageContext(), this.f25968b);
        }
        this.f25972f.p(1);
        this.f25972f.t(this.f25967a.getUniqueId());
        if (g()) {
            this.f25973g = new RelativeLayout(this.f25967a.getContext());
            this.f25973g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f25974h = new c.a.p0.v0.m1.f.a.a(this.f25967a, this.f25973g);
            this.f25968b.addHeaderView(this.f25973g, 0);
            this.f25974h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f25967a;
        if (frsCommonTabFragment3.tabType == 16) {
            h0 h0Var = new h0(frsCommonTabFragment3);
            this.f25976j = h0Var;
            this.f25968b.addHeaderView(h0Var.a(), 0);
            this.f25976j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f25967a;
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
            builder.tab_type = Integer.valueOf(this.f25967a.tabType);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.f25967a.tabType);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25972f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25968b : (BdTypeRecyclerView) invokeV.objValue;
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
                if (arrayList.get(i3) instanceof b2) {
                    int i5 = i3 - 1;
                    i3 = ((arrayList.get(i5) instanceof b2) && ((b2) arrayList.get(i3)).position == ((b2) arrayList.get(i5)).position) ? i3 + 1 : 1;
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
            c.a.p0.v0.k1.a aVar = this.f25970d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f25969c;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f25969c.d(i2);
            }
            c.a.p0.v0.m1.f.a.a aVar2 = this.f25974h;
            if (aVar2 != null) {
                aVar2.h();
            }
            h0 h0Var = this.f25976j;
            if (h0Var != null) {
                h0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.p0.v0.k1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f25971e) == null || ListUtils.isEmpty(dVar.f25990g)) {
            return;
        }
        Iterator<n> it = this.f25971e.f25990g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            c2 c2Var = null;
            if (next instanceof b2) {
                c2Var = ((b2) next).w;
            } else if (next instanceof c2) {
                c2Var = (c2) next;
            }
            if (c2Var != null && TextUtils.equals(str, c2Var.f0())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.f25971e.f25990g)) {
            this.f25971e.f25990g.add(new s());
        }
        this.f25970d.i(this.f25971e.f25990g);
        this.f25970d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f25972f;
            if (iVar != null) {
                iVar.h();
            }
            c.a.p0.v0.k1.a aVar = this.f25970d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.p0.v0.k1.d dVar) {
        h0 h0Var;
        c.a.p0.v0.m1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f25975i = dVar.f25988e;
        if (ListUtils.isEmpty(dVar.f25990g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f25990g = arrayList;
            arrayList.add(sVar);
            dVar.f25988e = false;
        }
        this.f25971e = dVar;
        this.f25969c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f25975i) {
            this.f25968b.setNextPage(this.f25969c);
            if (k(dVar.f25990g, 3)) {
                this.f25969c.z(null);
                this.f25969c.K();
            } else {
                this.f25969c.K();
                this.f25969c.z(this.l);
                this.f25969c.A(this.f25967a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f25968b.setNextPage(null);
            this.f25969c.A(this.f25967a.getResources().getString(R.string.list_has_no_more));
            this.f25969c.z(null);
            this.f25969c.f();
        }
        this.f25970d.i(dVar.f25990g);
        this.f25970d.f();
        i iVar = this.f25972f;
        if (iVar != null) {
            iVar.n(this.f25968b.getFirstVisiblePosition(), this.f25968b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f25974h) != null) {
            aVar.g(this.f25967a.getSortType());
            this.f25974h.j(this.f25967a.forumId);
        }
        this.k = dVar.n;
        if (this.f25967a.getFragmentActivity() instanceof l0) {
            ((l0) this.f25967a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f25967a.tabType != 16 || (h0Var = this.f25976j) == null) {
            return;
        }
        h0Var.c(this.k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f25972f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f25970d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.v0.t tVar = new c.a.p0.v0.t();
            tVar.f26819a = this.f25967a.tabId;
            tVar.f26820b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f25972f) == null) {
            return;
        }
        iVar.o();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f25968b.scrollToPosition(0);
        }
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (bdTypeRecyclerView = this.f25968b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z) {
        c.a.p0.v0.k1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (aVar = this.f25970d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f25967a == null) {
            return;
        }
        c.a.p0.v0.t tVar = new c.a.p0.v0.t();
        tVar.f26819a = this.f25967a.tabId;
        tVar.f26820b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onScrollListener) == null) {
            this.f25968b.setOnScrollListener(onScrollListener);
        }
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (bdTypeRecyclerView = this.f25968b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
