package c.a.r0.w0.l1;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.o0;
import c.a.q0.s.q.p0;
import c.a.q0.s.q.y0;
import c.a.r0.w0.s;
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
    public FrsCommonTabFragment f26985e;

    /* renamed from: f  reason: collision with root package name */
    public d f26986f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f26987g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f26988h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26989i;

    /* renamed from: j  reason: collision with root package name */
    public FrsDynamicRequestData f26990j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m;
    public int n;
    public long o;
    public int p;
    public String q;
    public String r;
    public c.a.r0.y0.a s;

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
        this.f26985e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f26989i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f26990j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = l.i(TbadkCoreApplication.getInst());
            this.f26990j.scrW = l.k(TbadkCoreApplication.getInst());
            this.f26990j.scrDip = l.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f26990j);
            this.k = frsDynamicModel;
            frsDynamicModel.Z(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f26989i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f26987g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = h(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f26987g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f26987g);
        this.f26988h = frsCommonTabNetModel;
        frsCommonTabNetModel.Z(this);
        this.f26988h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(d2 d2Var) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null || (dVar = this.f26986f) == null || dVar.f26993g == null) {
            return;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(d2Var);
        ArrayList<n> s = s(arrayList);
        if (ListUtils.isEmpty(this.f26986f.f26993g)) {
            this.f26986f.f26993g.addAll(s);
        } else {
            if (this.f26986f.f26993g.size() == 1 && (this.f26986f.f26993g.get(0) instanceof s)) {
                this.f26986f.f26993g.remove(0);
            }
            this.f26986f.f26993g.addAll(0, s);
        }
        this.f26985e.onViewDataChange(this.f26986f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || c.a.r0.p1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof d2) && (b2 = c.a.r0.y2.l0.b.b(((d2) nVar).P0())) != null) {
                arrayList.add(b2);
            }
        }
        c.a.r0.y2.l0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b2 = this.l ? 0 : c.a.r0.y2.a.b(this.f26986f.f26993g);
            String d2 = this.l ? "" : c.a.r0.y2.l0.b.f().d(this.r);
            d dVar = this.f26986f;
            String e2 = c.a.r0.y2.a.e(dVar == null ? null : dVar.f26993g, this.l);
            AdExtParam.a b3 = AdExtParam.a.b();
            b3.g(b2);
            b3.e(e2);
            b3.c(d2);
            b3.f(this.f26985e.forumName);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26986f : (d) invokeV.objValue;
    }

    public final void f(List<App> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, list2) == null) {
            b(list2);
            c.a.r0.y2.a.k(c.a.r0.y2.a.h(list, "FRS_GENERAL_TAB"), list2, 0);
            c.a.r0.y2.a.a(list2, this.n, "FRS_GENERAL_TAB");
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d dVar = this.f26986f;
            return (dVar == null || ListUtils.isEmpty(dVar.f26993g)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean h(int i2) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f26985e;
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
            if (!this.f26989i) {
                if (this.f26988h.Q()) {
                    return;
                }
                int i3 = this.n + 1;
                this.n = i3;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f26987g;
                frsCommonTabRequestData.pn = i3;
                frsCommonTabRequestData.sortType = i2;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.f26988h.R();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f26990j.qType = 2;
                } else {
                    this.f26990j.qType = 1;
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
            } else if (mvcSocketResponsedMessage.getData() instanceof c.a.r0.w0.m1.a) {
                c.a.r0.w0.m1.a aVar = (c.a.r0.w0.m1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f27048e;
                dVar2.f26993g = arrayList;
                dVar2.f26991e = aVar.f27050g;
                dVar2.f26992f = aVar.f27049f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f26993g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof d2) {
                        this.f26990j.lastThreadId = c.a.e.e.m.b.g(((d2) nVar).f0(), 0L);
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
                this.f26985e.onServerError(errorData);
            }
        }
    }

    public void l(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (dVar = this.f26986f) == null || c.a.r0.p1.o.k.a.e(dVar.f26993g)) {
            return;
        }
        c.a.r0.y2.a.d(str, this.f26986f.f26993g);
        this.f26985e.onViewDataChange(this.f26986f);
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
                Iterator<n> it = dVar.f26993g.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof d2) {
                        String s1 = ((d2) next).s1();
                        if (!this.m.contains(s1)) {
                            this.m.add(s1);
                        }
                    }
                }
                if (c.a.r0.y0.a.d()) {
                    c.a.r0.y0.a aVar = this.s;
                    if (aVar != null) {
                        aVar.b(dVar.f26993g, this.l, this.f26985e.getFid());
                    }
                } else {
                    f(dVar.o, dVar.f26993g);
                }
                this.f26986f = dVar;
                dVar.f26993g = s(dVar.f26993g);
            } else {
                d dVar2 = this.f26986f;
                dVar2.f26991e = dVar.f26991e;
                dVar2.f26992f.putAll(dVar.f26992f);
                ArrayList<n> arrayList = new ArrayList<>();
                Iterator<n> it2 = dVar.f26993g.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof d2) {
                        d2 d2Var = (d2) next2;
                        String s12 = d2Var.s1();
                        if (!this.m.contains(s12)) {
                            d2Var.J1 = this.f26985e.isBrandForum;
                            arrayList.add(next2);
                            this.m.add(s12);
                        }
                    }
                }
                if (c.a.r0.y0.a.d()) {
                    c.a.r0.y0.a aVar2 = this.s;
                    if (aVar2 != null) {
                        aVar2.b(arrayList, this.l, this.f26985e.getFid());
                    }
                } else {
                    f(dVar.o, arrayList);
                }
                this.f26986f.f26993g.addAll(s(arrayList));
            }
            this.f26985e.onViewDataChange(this.f26986f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.l = true;
            if (!this.f26989i) {
                if (this.f26988h.Q()) {
                    return;
                }
                this.n = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f26987g;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i2;
                long j2 = this.o;
                if (j2 >= 0) {
                    frsCommonTabRequestData.lastThreadId = j2;
                }
                this.f26987g.adExtParams = c();
                this.f26988h.R();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f26990j.qType = 2;
                } else {
                    this.f26990j.qType = 1;
                }
                this.f26990j.lastThreadId = 0L;
                this.k.R();
            }
        }
    }

    public void o(c.a.r0.y0.a aVar) {
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
            } else if (mvcHttpResponsedMessage.getData() instanceof c.a.r0.w0.m1.a) {
                c.a.r0.w0.m1.a aVar = (c.a.r0.w0.m1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f27048e;
                dVar2.f26993g = arrayList;
                dVar2.f26991e = aVar.f27050g;
                dVar2.f26992f = aVar.f27049f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f26993g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof d2) {
                        this.f26990j.lastThreadId = c.a.e.e.m.b.g(((d2) nVar).f0(), 0L);
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
                this.f26985e.onServerError(errorData);
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
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (frsCommonTabRequestData = this.f26987g) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i2;
    }

    public final ArrayList<n> s(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, arrayList)) == null) {
            boolean z = this.f26985e.tabType == 16;
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
                    c.a.q0.b.f.a.e(d2Var);
                    int[] g0 = d2Var.g0();
                    if (d2Var.getType() == d2.Z2 && !d2Var.A2()) {
                        c2 c2Var = new c2();
                        c2Var.w = d2Var;
                        c2Var.position = i2;
                        c2Var.f14122e = true;
                        c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var);
                        c2 c2Var2 = new c2();
                        c2Var2.w = d2Var;
                        c2Var2.position = i2;
                        if (d2Var.N1()) {
                            c2Var2.f14127j = true;
                        } else if (d2Var.d3() == 1) {
                            c2Var2.f14125h = true;
                            c2Var2.x = g0[0];
                            c2Var2.y = g0[1];
                        } else if (d2Var.d3() >= 2) {
                            c2Var2.f14126i = true;
                        } else {
                            c2Var2.f14123f = true;
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
                        if (d2Var.e1() != null) {
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
                        if (d2Var.v1() != null) {
                            c2 c2Var6 = new c2();
                            c2Var6.l = true;
                            c2Var6.w = d2Var;
                            c2Var6.position = i2;
                            c2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var6);
                        }
                        if (!z && d2Var.s0() != null && !d2Var.H2()) {
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
                    } else if ((d2Var.getType() == d2.w3 || d2Var.getType() == d2.P3) && !d2Var.A2()) {
                        c2 c2Var9 = new c2();
                        c2Var9.w = d2Var;
                        c2Var9.position = i2;
                        c2Var9.f14122e = true;
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
                        c2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var10);
                        if (d2Var.I0() != null) {
                            c2 c2Var11 = new c2();
                            c2Var11.s = true;
                            c2Var11.w = d2Var;
                            c2Var11.position = i2;
                            c2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var11);
                        }
                        if (d2Var.e1() != null) {
                            c2 c2Var12 = new c2();
                            c2Var12.p = true;
                            c2Var12.w = d2Var;
                            c2Var12.position = i2;
                            c2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var12);
                        }
                        if (d2Var.v1() != null) {
                            c2 c2Var13 = new c2();
                            c2Var13.l = true;
                            c2Var13.w = d2Var;
                            c2Var13.position = i2;
                            c2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var13);
                        }
                        if (!z && d2Var.s0() != null && !d2Var.H2()) {
                            c2 c2Var14 = new c2();
                            c2Var14.r = true;
                            c2Var14.w = d2Var;
                            c2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var14);
                        }
                        c2 c2Var15 = new c2();
                        c2Var15.k = true;
                        c2Var15.w = d2Var;
                        c2Var15.position = i2;
                        c2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var15);
                    } else if (d2Var.q1() != null && !d2Var.f2() && d2Var.Z1()) {
                        c2 c2Var16 = new c2();
                        c2Var16.w = d2Var;
                        c2Var16.position = i2;
                        c2Var16.f14122e = true;
                        c2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var16);
                        c2 c2Var17 = new c2();
                        c2Var17.w = d2Var;
                        c2Var17.position = i2;
                        c2Var17.o = true;
                        c2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var17);
                        if (d2Var.I0() != null) {
                            c2 c2Var18 = new c2();
                            c2Var18.s = true;
                            c2Var18.w = d2Var;
                            c2Var18.position = i2;
                            c2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var18);
                        }
                        if (d2Var.e1() != null) {
                            c2 c2Var19 = new c2();
                            c2Var19.p = true;
                            c2Var19.w = d2Var;
                            c2Var19.position = i2;
                            c2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var19);
                        }
                        if (d2Var.v1() != null) {
                            c2 c2Var20 = new c2();
                            c2Var20.l = true;
                            c2Var20.w = d2Var;
                            c2Var20.position = i2;
                            c2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var20);
                        }
                        if (!z && d2Var.s0() != null && !d2Var.H2()) {
                            c2 c2Var21 = new c2();
                            c2Var21.r = true;
                            c2Var21.w = d2Var;
                            c2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var21);
                        }
                        c2 c2Var22 = new c2();
                        c2Var22.k = true;
                        c2Var22.w = d2Var;
                        c2Var22.position = i2;
                        c2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var22);
                    } else if (d2Var.getType() == d2.o3 && d2Var.M1()) {
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
            c.a.q0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
