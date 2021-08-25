package c.a.q0.v0.k1;

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
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.q0.a0.t;
import c.a.q0.o2.i;
import c.a.q0.v0.h0;
import c.a.q0.v0.l0;
import c.a.q0.v0.s;
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
    public FrsCommonTabFragment f26303a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26304b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f26305c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.v0.k1.a f26306d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v0.k1.d f26307e;

    /* renamed from: f  reason: collision with root package name */
    public i f26308f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f26309g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.v0.m1.f.a.a f26310h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26311i;

    /* renamed from: j  reason: collision with root package name */
    public h0 f26312j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26313e;

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
            this.f26313e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26313e.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.q0.v0.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1226b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26314e;

        public C1226b(b bVar) {
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
            this.f26314e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26314e.f26304b != null) {
                    this.f26314e.f26304b.stopScroll();
                }
                if (this.f26314e.f26305c == null || this.f26314e.f26303a == null) {
                    return;
                }
                if (j.z()) {
                    this.f26314e.f26304b.setNextPage(this.f26314e.f26305c);
                    this.f26314e.f26305c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f26314e.f26305c.z(null);
                    if (this.f26314e.f26311i) {
                        this.f26314e.f26305c.L();
                        this.f26314e.f26305c.z(null);
                        this.f26314e.f26303a.loadmore();
                        return;
                    }
                    this.f26314e.f26305c.A(this.f26314e.f26303a.getResources().getString(R.string.list_has_no_more));
                    this.f26314e.f26305c.f();
                    this.f26314e.f26305c.z(null);
                    return;
                }
                this.f26314e.f26304b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f26315a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f26316b;

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
            this.f26316b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f26316b.f26308f != null) {
                    this.f26316b.f26308f.n(this.f26316b.f26304b.getFirstVisiblePosition(), this.f26316b.f26304b.getLastVisiblePosition(), this.f26315a, true);
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
                    this.f26315a = false;
                } else {
                    this.f26315a = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26317a;

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
            this.f26317a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f26317a.f26308f != null) {
                    this.f26317a.f26308f.k(view);
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
        this.m = new C1226b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.f26303a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
        this.f26304b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f26303a.getContext()));
        this.f26304b.setFadingEdgeLength(0);
        this.f26304b.setOverScrollMode(2);
        this.f26304b.setOnSrollToBottomListener(this.m);
        this.f26304b.addOnScrollListener(this.n);
        this.f26304b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f26304b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f26304b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f26303a.getPageContext().getPageActivity());
        this.f26305c = pbListView;
        pbListView.b();
        this.f26305c.o(R.color.transparent);
        this.f26305c.r(l.g(this.f26303a.getActivity(), R.dimen.tbds182));
        this.f26305c.v();
        this.f26305c.E(R.dimen.tbfontsize33);
        this.f26305c.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f26305c.y(R.color.CAM_X0110);
        this.f26305c.q();
        FrsCommonTabFragment frsCommonTabFragment2 = this.f26303a;
        this.f26306d = new c.a.q0.v0.k1.a(frsCommonTabFragment2, this.f26304b, frsViewData, frsCommonTabFragment2.tabType == 16);
        w(false);
        if (this.f26308f == null) {
            this.f26308f = new i(this.f26303a.getPageContext(), this.f26304b);
        }
        this.f26308f.p(1);
        this.f26308f.t(this.f26303a.getUniqueId());
        if (g()) {
            this.f26309g = new RelativeLayout(this.f26303a.getContext());
            this.f26309g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f26310h = new c.a.q0.v0.m1.f.a.a(this.f26303a, this.f26309g);
            this.f26304b.addHeaderView(this.f26309g, 0);
            this.f26310h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.f26303a;
        if (frsCommonTabFragment3.tabType == 16) {
            h0 h0Var = new h0(frsCommonTabFragment3);
            this.f26312j = h0Var;
            this.f26304b.addHeaderView(h0Var.a(), 0);
            this.f26312j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f26303a;
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
            builder.tab_type = Integer.valueOf(this.f26303a.tabType);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.f26303a.tabType);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26308f : (i) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26304b : (BdTypeRecyclerView) invokeV.objValue;
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
            c.a.q0.v0.k1.a aVar = this.f26306d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f26305c;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f26305c.d(i2);
            }
            c.a.q0.v0.m1.f.a.a aVar2 = this.f26310h;
            if (aVar2 != null) {
                aVar2.h();
            }
            h0 h0Var = this.f26312j;
            if (h0Var != null) {
                h0Var.b();
            }
        }
    }

    public void m(String str) {
        c.a.q0.v0.k1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f26307e) == null || ListUtils.isEmpty(dVar.f26326g)) {
            return;
        }
        Iterator<n> it = this.f26307e.f26326g.iterator();
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
        if (ListUtils.isEmpty(this.f26307e.f26326g)) {
            this.f26307e.f26326g.add(new s());
        }
        this.f26306d.i(this.f26307e.f26326g);
        this.f26306d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f26308f;
            if (iVar != null) {
                iVar.h();
            }
            c.a.q0.v0.k1.a aVar = this.f26306d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.q0.v0.k1.d dVar) {
        h0 h0Var;
        c.a.q0.v0.m1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f26311i = dVar.f26324e;
        if (ListUtils.isEmpty(dVar.f26326g)) {
            s sVar = new s();
            ArrayList<n> arrayList = new ArrayList<>();
            dVar.f26326g = arrayList;
            arrayList.add(sVar);
            dVar.f26324e = false;
        }
        this.f26307e = dVar;
        this.f26305c.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.f26311i) {
            this.f26304b.setNextPage(this.f26305c);
            if (k(dVar.f26326g, 3)) {
                this.f26305c.z(null);
                this.f26305c.K();
            } else {
                this.f26305c.K();
                this.f26305c.z(this.l);
                this.f26305c.A(this.f26303a.getResources().getString(R.string.list_click_load_more));
            }
        } else {
            this.f26304b.setNextPage(null);
            this.f26305c.A(this.f26303a.getResources().getString(R.string.list_has_no_more));
            this.f26305c.z(null);
            this.f26305c.f();
        }
        this.f26306d.i(dVar.f26326g);
        this.f26306d.f();
        i iVar = this.f26308f;
        if (iVar != null) {
            iVar.n(this.f26304b.getFirstVisiblePosition(), this.f26304b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f26310h) != null) {
            aVar.g(this.f26303a.getSortType());
            this.f26310h.j(this.f26303a.forumId);
        }
        this.k = dVar.n;
        if (this.f26303a.getFragmentActivity() instanceof l0) {
            ((l0) this.f26303a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.f26303a.tabType != 16 || (h0Var = this.f26312j) == null) {
            return;
        }
        h0Var.c(this.k);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f26308f) == null) {
            return;
        }
        iVar.x();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26306d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.q0.v0.t tVar = new c.a.q0.v0.t();
            tVar.f27158a = this.f26303a.tabId;
            tVar.f27159b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f26308f) == null) {
            return;
        }
        iVar.o();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f26304b.scrollToPosition(0);
        }
    }

    public void u(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (bdTypeRecyclerView = this.f26304b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z) {
        c.a.q0.v0.k1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (aVar = this.f26306d) == null) {
            return;
        }
        aVar.j(z);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f26303a == null) {
            return;
        }
        c.a.q0.v0.t tVar = new c.a.q0.v0.t();
        tVar.f27158a = this.f26303a.tabId;
        tVar.f27159b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void x(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onScrollListener) == null) {
            this.f26304b.setOnScrollListener(onScrollListener);
        }
    }

    public void y(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (bdTypeRecyclerView = this.f26304b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }
}
