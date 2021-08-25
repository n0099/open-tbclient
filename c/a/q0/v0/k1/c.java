package c.a.q0.v0.k1;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.o0;
import c.a.p0.s.q.p0;
import c.a.p0.s.q.y0;
import c.a.q0.v0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes4.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsCommonTabFragment f26318e;

    /* renamed from: f  reason: collision with root package name */
    public d f26319f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f26320g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f26321h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26322i;

    /* renamed from: j  reason: collision with root package name */
    public FrsDynamicRequestData f26323j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m;
    public int n;
    public long o;
    public int p;
    public String q;
    public String r;
    public c.a.q0.x0.a s;

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
        this.f26318e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f26322i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f26323j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = l.i(TbadkCoreApplication.getInst());
            this.f26323j.scrW = l.k(TbadkCoreApplication.getInst());
            this.f26323j.scrDip = l.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f26323j);
            this.k = frsDynamicModel;
            frsDynamicModel.Z(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f26322i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f26320g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = h(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f26320g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f26320g);
        this.f26321h = frsCommonTabNetModel;
        frsCommonTabNetModel.Z(this);
        this.f26321h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(c2 c2Var) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) || c2Var == null || (dVar = this.f26319f) == null || dVar.f26326g == null) {
            return;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(c2Var);
        ArrayList<n> s = s(arrayList);
        if (ListUtils.isEmpty(this.f26319f.f26326g)) {
            this.f26319f.f26326g.addAll(s);
        } else {
            if (this.f26319f.f26326g.size() == 1 && (this.f26319f.f26326g.get(0) instanceof s)) {
                this.f26319f.f26326g.remove(0);
            }
            this.f26319f.f26326g.addAll(0, s);
        }
        this.f26318e.onViewDataChange(this.f26319f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || c.a.q0.o1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof c2) && (b2 = c.a.q0.x2.l0.b.b(((c2) nVar).N0())) != null) {
                arrayList.add(b2);
            }
        }
        c.a.q0.x2.l0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b2 = this.l ? 0 : c.a.q0.x2.a.b(this.f26319f.f26326g);
            String d2 = this.l ? "" : c.a.q0.x2.l0.b.f().d(this.r);
            d dVar = this.f26319f;
            String e2 = c.a.q0.x2.a.e(dVar == null ? null : dVar.f26326g, this.l);
            AdExtParam.a b3 = AdExtParam.a.b();
            b3.g(b2);
            b3.e(e2);
            b3.c(d2);
            b3.f(this.f26318e.forumName);
            return b3.a();
        }
        return (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.intValue;
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26319f : (d) invokeV.objValue;
    }

    public final void f(List<App> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, list2) == null) {
            b(list2);
            c.a.q0.x2.a.k(c.a.q0.x2.a.h(list, "FRS_GENERAL_TAB"), list2, 0);
            c.a.q0.x2.a.a(list2, this.n, "FRS_GENERAL_TAB");
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d dVar = this.f26319f;
            return (dVar == null || ListUtils.isEmpty(dVar.f26326g)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean h(int i2) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f26318e;
            return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.viewData) == null || frsViewData.mHeadLineDefaultNavTabId != i2) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.l = false;
            if (!this.f26322i) {
                if (this.f26321h.Q()) {
                    return;
                }
                int i3 = this.n + 1;
                this.n = i3;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f26320g;
                frsCommonTabRequestData.pn = i3;
                frsCommonTabRequestData.sortType = i2;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.f26321h.R();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f26323j.qType = 2;
                } else {
                    this.f26323j.qType = 1;
                }
                this.k.R();
            }
        }
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
            } else if (mvcSocketResponsedMessage.getData() instanceof c.a.q0.v0.l1.a) {
                c.a.q0.v0.l1.a aVar = (c.a.q0.v0.l1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f26376e;
                dVar2.f26326g = arrayList;
                dVar2.f26324e = aVar.f26378g;
                dVar2.f26325f = aVar.f26377f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f26326g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof c2) {
                        this.f26323j.lastThreadId = c.a.e.e.m.b.f(((c2) nVar).f0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !m(dVar)) {
            this.p = mvcSocketResponsedMessage.getError();
            this.q = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f26318e.onServerError(errorData);
            }
        }
    }

    public void l(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (dVar = this.f26319f) == null || c.a.q0.o1.o.k.a.e(dVar.f26326g)) {
            return;
        }
        c.a.q0.x2.a.d(str, this.f26319f.f26326g);
        this.f26318e.onViewDataChange(this.f26319f);
    }

    public final boolean m(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            if (this.l) {
                this.m.clear();
                Iterator<n> it = dVar.f26326g.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof c2) {
                        String q1 = ((c2) next).q1();
                        if (!this.m.contains(q1)) {
                            this.m.add(q1);
                        }
                    }
                }
                if (c.a.q0.x0.a.d()) {
                    c.a.q0.x0.a aVar = this.s;
                    if (aVar != null) {
                        aVar.b(dVar.f26326g, this.l, this.f26318e.getFid());
                    }
                } else {
                    f(dVar.o, dVar.f26326g);
                }
                this.f26319f = dVar;
                dVar.f26326g = s(dVar.f26326g);
            } else {
                d dVar2 = this.f26319f;
                dVar2.f26324e = dVar.f26324e;
                dVar2.f26325f.putAll(dVar.f26325f);
                ArrayList<n> arrayList = new ArrayList<>();
                Iterator<n> it2 = dVar.f26326g.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof c2) {
                        c2 c2Var = (c2) next2;
                        String q12 = c2Var.q1();
                        if (!this.m.contains(q12)) {
                            c2Var.H1 = this.f26318e.isBrandForum;
                            arrayList.add(next2);
                            this.m.add(q12);
                        }
                    }
                }
                if (c.a.q0.x0.a.d()) {
                    c.a.q0.x0.a aVar2 = this.s;
                    if (aVar2 != null) {
                        aVar2.b(arrayList, this.l, this.f26318e.getFid());
                    }
                } else {
                    f(dVar.o, arrayList);
                }
                this.f26319f.f26326g.addAll(s(arrayList));
            }
            this.f26318e.onViewDataChange(this.f26319f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.l = true;
            if (!this.f26322i) {
                if (this.f26321h.Q()) {
                    return;
                }
                this.n = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f26320g;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i2;
                long j2 = this.o;
                if (j2 >= 0) {
                    frsCommonTabRequestData.lastThreadId = j2;
                }
                this.f26320g.adExtParams = c();
                this.f26321h.R();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f26323j.qType = 2;
                } else {
                    this.f26323j.qType = 1;
                }
                this.f26323j.lastThreadId = 0L;
                this.k.R();
            }
        }
    }

    public void o(c.a.q0.x0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.s = aVar;
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
            } else if (mvcHttpResponsedMessage.getData() instanceof c.a.q0.v0.l1.a) {
                c.a.q0.v0.l1.a aVar = (c.a.q0.v0.l1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f26376e;
                dVar2.f26326g = arrayList;
                dVar2.f26324e = aVar.f26378g;
                dVar2.f26325f = aVar.f26377f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f26326g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof c2) {
                        this.f26323j.lastThreadId = c.a.e.e.m.b.f(((c2) nVar).f0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !m(dVar)) {
            this.p = mvcHttpResponsedMessage.getError();
            this.q = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f26318e.onServerError(errorData);
            }
        }
    }

    public void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            this.o = j2;
        }
    }

    public void r(int i2) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (frsCommonTabRequestData = this.f26320g) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i2;
    }

    public final ArrayList<n> s(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, arrayList)) == null) {
            boolean z = this.f26318e.tabType == 16;
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
                } else if (next instanceof c2) {
                    c2 c2Var = (c2) next;
                    c.a.p0.b.f.a.e(c2Var);
                    int[] g0 = c2Var.g0();
                    if (c2Var.getType() == c2.W2 && !c2Var.w2()) {
                        b2 b2Var = new b2();
                        b2Var.w = c2Var;
                        b2Var.position = i2;
                        b2Var.f14149e = true;
                        b2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(b2Var);
                        b2 b2Var2 = new b2();
                        b2Var2.w = c2Var;
                        b2Var2.position = i2;
                        if (c2Var.K1()) {
                            b2Var2.f14154j = true;
                        } else if (c2Var.X2() == 1) {
                            b2Var2.f14152h = true;
                            b2Var2.x = g0[0];
                            b2Var2.y = g0[1];
                        } else if (c2Var.X2() >= 2) {
                            b2Var2.f14153i = true;
                        } else {
                            b2Var2.f14150f = true;
                        }
                        b2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var2);
                        if (c2Var.G0() != null) {
                            b2 b2Var3 = new b2();
                            b2Var3.s = true;
                            b2Var3.w = c2Var;
                            b2Var3.position = i2;
                            b2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var3);
                        }
                        if (c2Var.c1() != null) {
                            b2 b2Var4 = new b2();
                            b2Var4.p = true;
                            b2Var4.w = c2Var;
                            b2Var4.position = i2;
                            b2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var4);
                        }
                        if (!ListUtils.isEmpty(c2Var.y0()) || !ListUtils.isEmpty(c2Var.c0())) {
                            b2 b2Var5 = new b2();
                            if (ListUtils.getCount(c2Var.y0()) + ListUtils.getCount(c2Var.c0()) == 1) {
                                b2Var5.t = true;
                            } else if (ListUtils.getCount(c2Var.y0()) + ListUtils.getCount(c2Var.c0()) > 1) {
                                b2Var5.u = true;
                            }
                            b2Var5.w = c2Var;
                            b2Var5.position = i2;
                            b2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var5);
                        }
                        if (c2Var.t1() != null) {
                            b2 b2Var6 = new b2();
                            b2Var6.l = true;
                            b2Var6.w = c2Var;
                            b2Var6.position = i2;
                            b2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var6);
                        }
                        if (!z && c2Var.q0() != null && !c2Var.D2()) {
                            b2 b2Var7 = new b2();
                            b2Var7.r = true;
                            b2Var7.w = c2Var;
                            b2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var7);
                        }
                        b2 b2Var8 = new b2();
                        b2Var8.k = true;
                        b2Var8.w = c2Var;
                        b2Var8.position = i2;
                        b2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(b2Var8);
                    } else if ((c2Var.getType() == c2.t3 || c2Var.getType() == c2.M3) && !c2Var.w2()) {
                        b2 b2Var9 = new b2();
                        b2Var9.w = c2Var;
                        b2Var9.position = i2;
                        b2Var9.f14149e = true;
                        b2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(b2Var9);
                        b2 b2Var10 = new b2();
                        b2Var10.w = c2Var;
                        b2Var10.position = i2;
                        if (c2Var instanceof y0) {
                            b2Var10.n = true;
                        } else {
                            b2Var10.m = true;
                        }
                        b2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var10);
                        if (c2Var.G0() != null) {
                            b2 b2Var11 = new b2();
                            b2Var11.s = true;
                            b2Var11.w = c2Var;
                            b2Var11.position = i2;
                            b2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var11);
                        }
                        if (c2Var.c1() != null) {
                            b2 b2Var12 = new b2();
                            b2Var12.p = true;
                            b2Var12.w = c2Var;
                            b2Var12.position = i2;
                            b2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var12);
                        }
                        if (c2Var.t1() != null) {
                            b2 b2Var13 = new b2();
                            b2Var13.l = true;
                            b2Var13.w = c2Var;
                            b2Var13.position = i2;
                            b2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var13);
                        }
                        if (!z && c2Var.q0() != null && !c2Var.D2()) {
                            b2 b2Var14 = new b2();
                            b2Var14.r = true;
                            b2Var14.w = c2Var;
                            b2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var14);
                        }
                        b2 b2Var15 = new b2();
                        b2Var15.k = true;
                        b2Var15.w = c2Var;
                        b2Var15.position = i2;
                        b2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(b2Var15);
                    } else if (c2Var.o1() != null && !c2Var.c2() && c2Var.W1()) {
                        b2 b2Var16 = new b2();
                        b2Var16.w = c2Var;
                        b2Var16.position = i2;
                        b2Var16.f14149e = true;
                        b2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(b2Var16);
                        b2 b2Var17 = new b2();
                        b2Var17.w = c2Var;
                        b2Var17.position = i2;
                        b2Var17.o = true;
                        b2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(b2Var17);
                        if (c2Var.G0() != null) {
                            b2 b2Var18 = new b2();
                            b2Var18.s = true;
                            b2Var18.w = c2Var;
                            b2Var18.position = i2;
                            b2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var18);
                        }
                        if (c2Var.c1() != null) {
                            b2 b2Var19 = new b2();
                            b2Var19.p = true;
                            b2Var19.w = c2Var;
                            b2Var19.position = i2;
                            b2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var19);
                        }
                        if (c2Var.t1() != null) {
                            b2 b2Var20 = new b2();
                            b2Var20.l = true;
                            b2Var20.w = c2Var;
                            b2Var20.position = i2;
                            b2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var20);
                        }
                        if (!z && c2Var.q0() != null && !c2Var.D2()) {
                            b2 b2Var21 = new b2();
                            b2Var21.r = true;
                            b2Var21.w = c2Var;
                            b2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(b2Var21);
                        }
                        b2 b2Var22 = new b2();
                        b2Var22.k = true;
                        b2Var22.w = c2Var;
                        b2Var22.position = i2;
                        b2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(b2Var22);
                    } else if (c2Var.getType() == c2.l3 && c2Var.J1()) {
                        c2Var.position = i2;
                        arrayList2.add(c2Var);
                    } else {
                        b2 b2Var23 = new b2();
                        b2Var23.w = c2Var;
                        b2Var23.position = i2;
                        arrayList2.add(b2Var23);
                    }
                    i2++;
                    c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.p0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
