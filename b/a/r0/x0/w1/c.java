package b.a.r0.x0.w1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.o0;
import b.a.q0.s.q.p0;
import b.a.q0.s.q.y0;
import b.a.r0.x0.s;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabNetModel;
import com.baidu.tieba.frs.commontab.FrsCommonTabRequestData;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes6.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsCommonTabFragment f28038e;

    /* renamed from: f  reason: collision with root package name */
    public d f28039f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f28040g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f28041h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28042i;
    public FrsDynamicRequestData j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m;
    public int n;
    public long o;
    public int p;
    public String q;
    public String r;
    public b.a.r0.z0.a s;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i2, int i3, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new HashSet<>();
        this.n = 1;
        this.o = -1L;
        if (frsCommonTabFragment == null) {
            return;
        }
        this.f28038e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f28042i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = l.i(TbadkCoreApplication.getInst());
            this.j.scrW = l.k(TbadkCoreApplication.getInst());
            this.j.scrDip = l.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.j);
            this.k = frsDynamicModel;
            frsDynamicModel.Y(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f28042i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f28040g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = i(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f28040g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f28040g);
        this.f28041h = frsCommonTabNetModel;
        frsCommonTabNetModel.Y(this);
        this.f28041h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(d2 d2Var) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null || (dVar = this.f28039f) == null || dVar.f28045g == null) {
            return;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(d2Var);
        ArrayList<n> t = t(arrayList);
        if (ListUtils.isEmpty(this.f28039f.f28045g)) {
            this.f28039f.f28045g.addAll(t);
        } else {
            if (this.f28039f.f28045g.size() == 1 && (this.f28039f.f28045g.get(0) instanceof s)) {
                this.f28039f.f28045g.remove(0);
            }
            this.f28039f.f28045g.addAll(0, t);
        }
        this.f28038e.onViewDataChange(this.f28039f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || b.a.r0.q1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof d2) && (b2 = b.a.r0.a3.l0.b.b(((d2) nVar).P0())) != null) {
                arrayList.add(b2);
            }
        }
        b.a.r0.a3.l0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b2 = this.l ? 0 : b.a.r0.a3.a.b(this.f28039f.f28045g);
            String d2 = this.l ? "" : b.a.r0.a3.l0.b.f().d(this.r);
            d dVar = this.f28039f;
            String e2 = b.a.r0.a3.a.e(dVar == null ? null : dVar.f28045g, this.l);
            AdExtParam.a b3 = AdExtParam.a.b();
            b3.g(b2);
            b3.e(e2);
            b3.c(d2);
            b3.f(this.f28038e.forumName);
            return b3.a();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d dVar = this.f28039f;
            if (dVar == null) {
                return true;
            }
            return dVar.f28043e;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.intValue;
    }

    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28039f : (d) invokeV.objValue;
    }

    public final void g(List<App> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            b.a.r0.a3.a.k(b.a.r0.a3.a.h(list, "FRS_GENERAL_TAB"), list2, 0);
            b.a.r0.a3.a.a(list2, this.n, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f28039f;
            return (dVar == null || ListUtils.isEmpty(dVar.f28045g)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f28038e;
            return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.viewData) == null || frsViewData.mHeadLineDefaultNavTabId != i2) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof b.a.r0.x0.x1.a) {
                b.a.r0.x0.x1.a aVar = (b.a.r0.x0.x1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f28093e;
                dVar2.f28045g = arrayList;
                dVar2.f28043e = aVar.f28095g;
                dVar2.f28044f = aVar.f28094f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f28045g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof d2) {
                        this.j.lastThreadId = b.a.e.f.m.b.g(((d2) nVar).f0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !n(dVar)) {
            this.p = mvcSocketResponsedMessage.getError();
            this.q = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f28038e.onServerError(errorData);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.l = false;
            if (!this.f28042i) {
                if (this.f28041h.Q()) {
                    return;
                }
                int i3 = this.n + 1;
                this.n = i3;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f28040g;
                frsCommonTabRequestData.pn = i3;
                frsCommonTabRequestData.sortType = i2;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.f28041h.loadData();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.j.qType = 2;
                } else {
                    this.j.qType = 1;
                }
                this.k.loadData();
            }
        }
    }

    public void m(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (dVar = this.f28039f) == null || b.a.r0.q1.o.k.a.e(dVar.f28045g)) {
            return;
        }
        b.a.r0.a3.a.d(str, this.f28039f.f28045g);
        this.f28038e.onViewDataChange(this.f28039f);
    }

    public final boolean n(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            boolean z = this.f28038e.tabType == 100;
            ArrayList arrayList = new ArrayList();
            if (this.l) {
                this.m.clear();
                Iterator<n> it = dVar.f28045g.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof d2) {
                        d2 d2Var = (d2) next;
                        String t1 = d2Var.t1();
                        if (!this.m.contains(t1)) {
                            this.m.add(t1);
                        }
                        if (z && d2Var.r1() != null && !TextUtils.isEmpty(d2Var.r1().video_url)) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(d2Var);
                            arrayList.add(videoItemData);
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.putVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id, arrayList);
                }
                if (b.a.r0.z0.a.d()) {
                    b.a.r0.z0.a aVar = this.s;
                    if (aVar != null) {
                        aVar.b(dVar.f28045g, this.l, this.f28038e.getFid());
                    }
                } else {
                    g(dVar.o, dVar.f28045g);
                }
                this.f28039f = dVar;
                dVar.f28045g = t(dVar.f28045g);
            } else {
                d dVar2 = this.f28039f;
                dVar2.f28043e = dVar.f28043e;
                dVar2.f28044f.putAll(dVar.f28044f);
                ArrayList<n> arrayList2 = new ArrayList<>();
                Iterator<n> it2 = dVar.f28045g.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof d2) {
                        d2 d2Var2 = (d2) next2;
                        String t12 = d2Var2.t1();
                        if (!this.m.contains(t12)) {
                            d2Var2.K1 = this.f28038e.isBrandForum;
                            arrayList2.add(d2Var2);
                            this.m.add(t12);
                            if (z && d2Var2.r1() != null && !TextUtils.isEmpty(d2Var2.r1().video_url)) {
                                VideoItemData videoItemData2 = new VideoItemData();
                                videoItemData2.buildWithThreadData(d2Var2);
                                arrayList.add(videoItemData2);
                            }
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                if (b.a.r0.z0.a.d()) {
                    b.a.r0.z0.a aVar2 = this.s;
                    if (aVar2 != null) {
                        aVar2.b(arrayList2, this.l, this.f28038e.getFid());
                    }
                } else {
                    g(dVar.o, arrayList2);
                }
                this.f28039f.f28045g.addAll(t(arrayList2));
            }
            this.f28038e.onViewDataChange(this.f28039f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l = true;
            if (!this.f28042i) {
                if (this.f28041h.Q()) {
                    return;
                }
                this.n = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f28040g;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i2;
                long j = this.o;
                if (j >= 0) {
                    frsCommonTabRequestData.lastThreadId = j;
                }
                this.f28040g.adExtParams = c();
                this.f28041h.loadData();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.j.qType = 2;
                } else {
                    this.j.qType = 1;
                }
                this.j.lastThreadId = 0L;
                this.k.loadData();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048591, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof b.a.r0.x0.x1.a) {
                b.a.r0.x0.x1.a aVar = (b.a.r0.x0.x1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f28093e;
                dVar2.f28045g = arrayList;
                dVar2.f28043e = aVar.f28095g;
                dVar2.f28044f = aVar.f28094f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f28045g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof d2) {
                        this.j.lastThreadId = b.a.e.f.m.b.g(((d2) nVar).f0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !n(dVar)) {
            this.p = mvcHttpResponsedMessage.getError();
            this.q = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f28038e.onServerError(errorData);
            }
        }
    }

    public void q(b.a.r0.z0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.o = j;
        }
    }

    public void s(int i2) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (frsCommonTabRequestData = this.f28040g) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i2;
    }

    public final ArrayList<n> t(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.f28038e.tabType == 16;
            boolean z2 = this.f28038e.tabType == 100;
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof o0) {
                    ((o0) next).setPosition(i2);
                    arrayList2.add(next);
                } else if (next instanceof p0) {
                    ((p0) next).position = i2;
                    arrayList2.add(next);
                } else if (next instanceof d2) {
                    d2 d2Var = (d2) next;
                    b.a.q0.b.f.a.e(d2Var);
                    int[] g0 = d2Var.g0();
                    if (d2Var.getType() == d2.b3 && !d2Var.C2()) {
                        c2 c2Var = new c2();
                        c2Var.w = d2Var;
                        c2Var.position = i2;
                        c2Var.f14034e = true;
                        c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var);
                        c2 c2Var2 = new c2();
                        c2Var2.w = d2Var;
                        c2Var2.position = i2;
                        if (d2Var.P1()) {
                            c2Var2.j = true;
                        } else if (d2Var.f3() == 1) {
                            c2Var2.f14037h = true;
                            c2Var2.x = g0[0];
                            c2Var2.y = g0[1];
                        } else if (d2Var.f3() >= 2) {
                            c2Var2.f14038i = true;
                        } else {
                            c2Var2.f14035f = true;
                        }
                        c2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var2);
                        if (d2Var.I0() != null) {
                            c2 c2Var3 = new c2();
                            c2Var3.s = true;
                            c2Var3.w = d2Var;
                            c2Var3.position = i2;
                            c2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var3);
                        }
                        if (d2Var.f1() != null) {
                            c2 c2Var4 = new c2();
                            c2Var4.p = true;
                            c2Var4.w = d2Var;
                            c2Var4.position = i2;
                            c2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var4);
                        }
                        if (!ListUtils.isEmpty(d2Var.A0()) || !ListUtils.isEmpty(d2Var.c0())) {
                            c2 c2Var5 = new c2();
                            if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) == 1) {
                                c2Var5.t = true;
                            } else if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) > 1) {
                                c2Var5.u = true;
                            }
                            c2Var5.w = d2Var;
                            c2Var5.position = i2;
                            c2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var5);
                        }
                        if (d2Var.w1() != null) {
                            c2 c2Var6 = new c2();
                            c2Var6.l = true;
                            c2Var6.w = d2Var;
                            c2Var6.position = i2;
                            c2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var6);
                        }
                        if (!z && d2Var.s0() != null && !d2Var.J2()) {
                            c2 c2Var7 = new c2();
                            c2Var7.r = true;
                            c2Var7.w = d2Var;
                            c2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var7);
                        }
                        c2 c2Var8 = new c2();
                        c2Var8.k = true;
                        c2Var8.w = d2Var;
                        c2Var8.position = i2;
                        c2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var8);
                    } else if ((d2Var.getType() == d2.z3 || d2Var.getType() == d2.R3) && !d2Var.C2()) {
                        c2 c2Var9 = new c2();
                        c2Var9.w = d2Var;
                        c2Var9.position = i2;
                        c2Var9.f14034e = true;
                        d2Var.n = z2;
                        c2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var9);
                        c2 c2Var10 = new c2();
                        c2Var10.w = d2Var;
                        c2Var10.position = i2;
                        if (d2Var instanceof y0) {
                            c2Var10.n = true;
                        } else {
                            c2Var10.m = true;
                        }
                        c2Var10.w.n = z2;
                        c2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var10);
                        if (d2Var.I0() != null) {
                            c2 c2Var11 = new c2();
                            c2Var11.s = true;
                            c2Var11.w = d2Var;
                            c2Var11.position = i2;
                            d2Var.n = z2;
                            c2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var11);
                        }
                        if (d2Var.f1() != null) {
                            c2 c2Var12 = new c2();
                            c2Var12.p = true;
                            c2Var12.w = d2Var;
                            c2Var12.position = i2;
                            d2Var.n = z2;
                            c2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var12);
                        }
                        if (d2Var.w1() != null) {
                            c2 c2Var13 = new c2();
                            c2Var13.l = true;
                            c2Var13.w = d2Var;
                            c2Var13.position = i2;
                            d2Var.n = z2;
                            c2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var13);
                        }
                        if (!z && d2Var.s0() != null && !d2Var.J2()) {
                            c2 c2Var14 = new c2();
                            c2Var14.r = true;
                            c2Var14.w = d2Var;
                            d2Var.n = z2;
                            c2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var14);
                        }
                        c2 c2Var15 = new c2();
                        c2Var15.k = true;
                        c2Var15.w = d2Var;
                        c2Var15.position = i2;
                        d2Var.n = z2;
                        c2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var15);
                    } else if (d2Var.r1() != null && !d2Var.h2() && d2Var.b2()) {
                        c2 c2Var16 = new c2();
                        c2Var16.w = d2Var;
                        c2Var16.position = i2;
                        c2Var16.f14034e = true;
                        d2Var.n = z2;
                        c2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var16);
                        c2 c2Var17 = new c2();
                        c2Var17.w = d2Var;
                        c2Var17.position = i2;
                        c2Var17.o = true;
                        d2Var.n = z2;
                        c2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var17);
                        if (d2Var.I0() != null) {
                            c2 c2Var18 = new c2();
                            c2Var18.s = true;
                            c2Var18.w = d2Var;
                            c2Var18.position = i2;
                            d2Var.n = z2;
                            c2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var18);
                        }
                        if (d2Var.f1() != null) {
                            c2 c2Var19 = new c2();
                            c2Var19.p = true;
                            c2Var19.w = d2Var;
                            c2Var19.position = i2;
                            d2Var.n = z2;
                            c2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var19);
                        }
                        if (d2Var.w1() != null) {
                            c2 c2Var20 = new c2();
                            c2Var20.l = true;
                            c2Var20.w = d2Var;
                            c2Var20.position = i2;
                            d2Var.n = z2;
                            c2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var20);
                        }
                        if (!z && d2Var.s0() != null && !d2Var.J2()) {
                            c2 c2Var21 = new c2();
                            c2Var21.r = true;
                            c2Var21.w = d2Var;
                            d2Var.n = z2;
                            c2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var21);
                        }
                        c2 c2Var22 = new c2();
                        c2Var22.k = true;
                        c2Var22.w = d2Var;
                        c2Var22.position = i2;
                        d2Var.n = z2;
                        c2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var22);
                    } else if (d2Var.getType() == d2.r3 && d2Var.O1()) {
                        d2Var.position = i2;
                        arrayList2.add(d2Var);
                    } else {
                        c2 c2Var23 = new c2();
                        c2Var23.w = d2Var;
                        c2Var23.position = i2;
                        arrayList2.add(c2Var23);
                    }
                    i2++;
                    d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            b.a.q0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
