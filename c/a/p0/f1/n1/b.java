package c.a.p0.f1.n1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.r.r.a2;
import c.a.p0.c3.k;
import c.a.p0.f1.i0;
import c.a.p0.f1.m0;
import c.a.p0.f1.s;
import c.a.p0.f1.t;
import c.a.p0.h0.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f14257b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f14258c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f1.n1.a f14259d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.n1.d f14260e;

    /* renamed from: f  reason: collision with root package name */
    public k f14261f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f14262g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f1.p1.f.a.a f14263h;
    public boolean i;
    public i0 j;
    public ItemInfo k;
    public View.OnClickListener l;
    public BdListView.p m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.m.onScrollToBottom();
            }
        }
    }

    /* renamed from: c.a.p0.f1.n1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1072b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1072b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f14257b != null) {
                    this.a.f14257b.stopScroll();
                }
                if (this.a.f14258c == null || this.a.a == null) {
                    return;
                }
                if (l.z()) {
                    this.a.f14257b.setNextPage(this.a.f14258c);
                    this.a.f14258c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.f14258c.C(null);
                    if (this.a.i) {
                        this.a.f14258c.O();
                        this.a.f14258c.C(null);
                        this.a.a.V0();
                        return;
                    }
                    this.a.f14258c.D(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                    this.a.f14258c.f();
                    this.a.f14258c.C(null);
                    return;
                }
                this.a.f14257b.setNextPage(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f14264b;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14264b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.f14264b.f14261f != null) {
                    this.f14264b.f14261f.n(this.f14264b.f14257b.getFirstVisiblePosition(), this.f14264b.f14257b.getLastVisiblePosition(), this.a, true);
                }
                u.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.a.f14261f != null) {
                    this.a.f14261f.k(view);
                    this.a.f14261f.n(this.a.f14257b.getFirstVisiblePosition(), this.a.f14257b.getLastVisiblePosition(), false, true);
                }
                if (view != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.obfuscated_res_0x7f090029);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.k();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.obfuscated_res_0x7f090027);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.p();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.m = new C1072b(this);
        this.n = new c(this);
        if (frsCommonTabFragment == null || view == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.obfuscated_res_0x7f090ae1);
        this.f14257b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.f14257b.setFadingEdgeLength(0);
        this.f14257b.setOverScrollMode(2);
        this.f14257b.setOnSrollToBottomListener(this.m);
        this.f14257b.addOnScrollListener(this.n);
        this.f14257b.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f14257b;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f14257b.getPaddingBottom());
        PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
        this.f14258c = pbListView;
        pbListView.b();
        this.f14258c.p(R.color.transparent);
        this.f14258c.t(n.f(this.a.getActivity(), R.dimen.tbds182));
        this.f14258c.y();
        this.f14258c.H(R.dimen.tbfontsize33);
        this.f14258c.F(SkinManager.getColor(R.color.CAM_X0107));
        this.f14258c.B(R.color.CAM_X0110);
        this.f14258c.s();
        FrsCommonTabFragment frsCommonTabFragment2 = this.a;
        this.f14259d = new c.a.p0.f1.n1.a(frsCommonTabFragment2, this.f14257b, frsViewData, frsCommonTabFragment2.f32441h == 16);
        x(false);
        if (this.f14261f == null) {
            this.f14261f = new k(this.a.getPageContext(), this.f14257b);
        }
        if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
            this.f14261f.p(2);
        } else {
            this.f14261f.p(1);
        }
        this.f14261f.u(this.a.getUniqueId());
        if (g()) {
            this.f14262g = new RelativeLayout(this.a.getContext());
            this.f14262g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f14263h = new c.a.p0.f1.p1.f.a.a(this.a, this.f14262g);
            this.f14257b.t(this.f14262g, 0);
            this.f14263h.i(h());
        }
        FrsCommonTabFragment frsCommonTabFragment3 = this.a;
        if (frsCommonTabFragment3.f32441h == 16) {
            i0 i0Var = new i0(frsCommonTabFragment3);
            this.j = i0Var;
            this.f14257b.t(i0Var.a(), 0);
            this.j.c(this.k);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment != null) {
                return frsCommonTabFragment.j == 1 || frsCommonTabFragment.f32441h == 16;
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
            builder.tab_type = Integer.valueOf(this.a.f32441h);
            FrsTabInfo build = builder.build(true);
            FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
            builder2.tab_id = 3;
            builder2.tab_type = Integer.valueOf(this.a.f32441h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14261f : (k) invokeV.objValue;
    }

    public BdTypeRecyclerView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14257b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final boolean k(ArrayList<c.a.d.o.e.n> arrayList, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, arrayList, i)) == null) {
            if (ListUtils.isEmpty(arrayList) || i < 0) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            int i3 = 1;
            while (i2 < arrayList.size() && i3 <= i) {
                if (arrayList.get(i2) instanceof a2) {
                    int i4 = i2 - 1;
                    i2 = ((arrayList.get(i4) instanceof a2) && ((a2) arrayList.get(i2)).position == ((a2) arrayList.get(i4)).position) ? i2 + 1 : 1;
                }
                i3++;
            }
            return i3 > i;
        }
        return invokeLI.booleanValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            c.a.p0.f1.n1.a aVar = this.f14259d;
            if (aVar != null) {
                aVar.f();
            }
            PbListView pbListView = this.f14258c;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f14258c.d(i);
            }
            c.a.p0.f1.p1.f.a.a aVar2 = this.f14263h;
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
        c.a.p0.f1.n1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str) || (dVar = this.f14260e) == null || ListUtils.isEmpty(dVar.f14273c)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.f14260e.f14273c.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            ThreadData threadData = null;
            if (next instanceof a2) {
                threadData = ((a2) next).s;
            } else if (next instanceof ThreadData) {
                threadData = (ThreadData) next;
            }
            if (threadData != null && TextUtils.equals(str, threadData.getId())) {
                it.remove();
            }
        }
        if (ListUtils.isEmpty(this.f14260e.f14273c)) {
            this.f14260e.f14273c.add(new s());
        }
        this.f14259d.i(this.f14260e.f14273c);
        this.f14259d.f();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k kVar = this.f14261f;
            if (kVar != null) {
                kVar.h();
            }
            c.a.p0.f1.n1.a aVar = this.f14259d;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void o(c.a.p0.f1.n1.d dVar) {
        i0 i0Var;
        c.a.p0.f1.p1.f.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) || dVar == null) {
            return;
        }
        this.i = dVar.a;
        if (ListUtils.isEmpty(dVar.f14273c)) {
            s sVar = new s();
            ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
            dVar.f14273c = arrayList;
            arrayList.add(sVar);
            dVar.a = false;
        }
        this.f14260e = dVar;
        this.f14258c.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (this.i) {
            this.f14257b.setNextPage(this.f14258c);
            if (k(dVar.f14273c, 3)) {
                this.f14258c.C(null);
                this.f14258c.N();
            } else {
                this.f14258c.N();
                this.f14258c.C(this.l);
                this.f14258c.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e5));
            }
        } else {
            this.f14257b.setNextPage(null);
            this.f14258c.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
            this.f14258c.C(null);
            this.f14258c.f();
        }
        this.f14259d.i(dVar.f14273c);
        this.f14259d.f();
        k kVar = this.f14261f;
        if (kVar != null) {
            kVar.n(this.f14257b.getFirstVisiblePosition(), this.f14257b.getLastVisiblePosition(), false, true);
        }
        if (g() && (aVar = this.f14263h) != null) {
            aVar.g(this.a.T0());
            this.f14263h.j(this.a.f32438e);
        }
        this.k = dVar.j;
        if (this.a.getFragmentActivity() instanceof m0) {
            ((m0) this.a.getFragmentActivity()).setItemInfo(this.k);
        }
        if (this.a.f32441h != 16 || (i0Var = this.j) == null) {
            return;
        }
        i0Var.c(this.k);
    }

    public void p() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (kVar = this.f14261f) == null) {
            return;
        }
        kVar.y();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f14259d.f();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.a = this.a.f32440g;
            tVar.f14634b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void s() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (kVar = this.f14261f) == null) {
            return;
        }
        kVar.o();
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.FALSE));
            ((LinearLayoutManager) this.f14257b.getLayoutManager()).scrollToPositionWithOffset(i, 0);
            if (this.i) {
                return;
            }
            this.m.onScrollToBottom();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f14257b.scrollToPosition(0);
        }
    }

    public void v(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdTypeRecyclerView = this.f14257b) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        c.a.p0.f1.n1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.f14259d) == null) {
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
        tVar.a = this.a.f32440g;
        tVar.f14634b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.f14257b.setOnScrollListener(onScrollListener);
        }
    }

    public void z(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (bdTypeRecyclerView = this.f14257b) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i);
    }
}
