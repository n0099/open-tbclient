package c.a.t0.e1.x1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.o0;
import c.a.s0.s.q.p0;
import c.a.s0.s.q.y0;
import c.a.t0.e1.s;
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
/* loaded from: classes7.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsCommonTabFragment f17083e;

    /* renamed from: f  reason: collision with root package name */
    public d f17084f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f17085g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f17086h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17087i;

    /* renamed from: j  reason: collision with root package name */
    public FrsDynamicRequestData f17088j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m;
    public int n;
    public long o;
    public int p;
    public String q;
    public String r;
    public c.a.t0.g1.a s;

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
        this.f17083e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f17087i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f17088j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = n.i(TbadkCoreApplication.getInst());
            this.f17088j.scrW = n.k(TbadkCoreApplication.getInst());
            this.f17088j.scrDip = n.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f17088j);
            this.k = frsDynamicModel;
            frsDynamicModel.Y(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f17087i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f17085g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = i(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f17085g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f17085g);
        this.f17086h = frsCommonTabNetModel;
        frsCommonTabNetModel.Y(this);
        this.f17086h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(e2 e2Var) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) || e2Var == null || (dVar = this.f17084f) == null || dVar.f17091g == null) {
            return;
        }
        ArrayList<c.a.d.n.e.n> arrayList = new ArrayList<>();
        arrayList.add(e2Var);
        ArrayList<c.a.d.n.e.n> t = t(arrayList);
        if (ListUtils.isEmpty(this.f17084f.f17091g)) {
            this.f17084f.f17091g.addAll(t);
        } else {
            if (this.f17084f.f17091g.size() == 1 && (this.f17084f.f17091g.get(0) instanceof s)) {
                this.f17084f.f17091g.remove(0);
            }
            this.f17084f.f17091g.addAll(0, t);
        }
        this.f17083e.onViewDataChange(this.f17084f);
    }

    public final void b(List<c.a.d.n.e.n> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || c.a.t0.y1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (c.a.d.n.e.n nVar : list) {
            if ((nVar instanceof e2) && (b2 = c.a.t0.k3.l0.b.b(((e2) nVar).R0())) != null) {
                arrayList.add(b2);
            }
        }
        c.a.t0.k3.l0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b2 = this.l ? 0 : c.a.t0.k3.a.b(this.f17084f.f17091g);
            String d2 = this.l ? "" : c.a.t0.k3.l0.b.f().d(this.r);
            d dVar = this.f17084f;
            String e2 = c.a.t0.k3.a.e(dVar == null ? null : dVar.f17091g, this.l);
            AdExtParam.a b3 = AdExtParam.a.b();
            b3.g(b2);
            b3.e(e2);
            b3.c(d2);
            b3.f(this.f17083e.forumName);
            return b3.a();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d dVar = this.f17084f;
            if (dVar == null) {
                return true;
            }
            return dVar.f17089e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17084f : (d) invokeV.objValue;
    }

    public final void g(List<App> list, List<c.a.d.n.e.n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            c.a.t0.k3.a.k(c.a.t0.k3.a.h(list, "FRS_GENERAL_TAB"), list2, 0);
            c.a.t0.k3.a.a(list2, this.n, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f17084f;
            return (dVar == null || ListUtils.isEmpty(dVar.f17091g)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f17083e;
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
            } else if (mvcSocketResponsedMessage.getData() instanceof c.a.t0.e1.y1.a) {
                c.a.t0.e1.y1.a aVar = (c.a.t0.e1.y1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<c.a.d.n.e.n> arrayList = aVar.f17131e;
                dVar2.f17091g = arrayList;
                dVar2.f17089e = aVar.f17133g;
                dVar2.f17090f = aVar.f17132f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<c.a.d.n.e.n> arrayList2 = dVar2.f17091g;
                    c.a.d.n.e.n nVar = (c.a.d.n.e.n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof e2) {
                        this.f17088j.lastThreadId = c.a.d.f.m.b.g(((e2) nVar).h0(), 0L);
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
                this.f17083e.onServerError(errorData);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.l = false;
            if (!this.f17087i) {
                if (this.f17086h.Q()) {
                    return;
                }
                int i3 = this.n + 1;
                this.n = i3;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f17085g;
                frsCommonTabRequestData.pn = i3;
                frsCommonTabRequestData.sortType = i2;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.f17086h.loadData();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f17088j.qType = 2;
                } else {
                    this.f17088j.qType = 1;
                }
                this.k.loadData();
            }
        }
    }

    public void m(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (dVar = this.f17084f) == null || c.a.t0.y1.o.k.a.e(dVar.f17091g)) {
            return;
        }
        c.a.t0.k3.a.d(str, this.f17084f.f17091g);
        this.f17083e.onViewDataChange(this.f17084f);
    }

    public final boolean n(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            boolean z = this.f17083e.tabType == 100;
            ArrayList arrayList = new ArrayList();
            if (this.l) {
                this.m.clear();
                Iterator<c.a.d.n.e.n> it = dVar.f17091g.iterator();
                while (it.hasNext()) {
                    c.a.d.n.e.n next = it.next();
                    if (next instanceof e2) {
                        e2 e2Var = (e2) next;
                        String w1 = e2Var.w1();
                        if (!this.m.contains(w1)) {
                            this.m.add(w1);
                        }
                        if (z && e2Var.u1() != null && !TextUtils.isEmpty(e2Var.u1().video_url)) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(e2Var);
                            arrayList.add(videoItemData);
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.putVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id, arrayList);
                }
                if (c.a.t0.g1.a.d()) {
                    c.a.t0.g1.a aVar = this.s;
                    if (aVar != null) {
                        aVar.b(dVar.f17091g, this.l, this.f17083e.getFid());
                    }
                } else {
                    g(dVar.o, dVar.f17091g);
                }
                this.f17084f = dVar;
                dVar.f17091g = t(dVar.f17091g);
            } else {
                d dVar2 = this.f17084f;
                dVar2.f17089e = dVar.f17089e;
                dVar2.f17090f.putAll(dVar.f17090f);
                ArrayList<c.a.d.n.e.n> arrayList2 = new ArrayList<>();
                Iterator<c.a.d.n.e.n> it2 = dVar.f17091g.iterator();
                while (it2.hasNext()) {
                    c.a.d.n.e.n next2 = it2.next();
                    if (next2 instanceof e2) {
                        e2 e2Var2 = (e2) next2;
                        String w12 = e2Var2.w1();
                        if (!this.m.contains(w12)) {
                            e2Var2.K1 = this.f17083e.isBrandForum;
                            arrayList2.add(e2Var2);
                            this.m.add(w12);
                            if (z && e2Var2.u1() != null && !TextUtils.isEmpty(e2Var2.u1().video_url)) {
                                VideoItemData videoItemData2 = new VideoItemData();
                                videoItemData2.buildWithThreadData(e2Var2);
                                arrayList.add(videoItemData2);
                            }
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                if (c.a.t0.g1.a.d()) {
                    c.a.t0.g1.a aVar2 = this.s;
                    if (aVar2 != null) {
                        aVar2.b(arrayList2, this.l, this.f17083e.getFid());
                    }
                } else {
                    g(dVar.o, arrayList2);
                }
                this.f17084f.f17091g.addAll(t(arrayList2));
            }
            this.f17083e.onViewDataChange(this.f17084f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l = true;
            if (!this.f17087i) {
                if (this.f17086h.Q()) {
                    return;
                }
                this.n = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f17085g;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i2;
                long j2 = this.o;
                if (j2 >= 0) {
                    frsCommonTabRequestData.lastThreadId = j2;
                }
                this.f17085g.adExtParams = c();
                this.f17086h.loadData();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f17088j.qType = 2;
                } else {
                    this.f17088j.qType = 1;
                }
                this.f17088j.lastThreadId = 0L;
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
            } else if (mvcHttpResponsedMessage.getData() instanceof c.a.t0.e1.y1.a) {
                c.a.t0.e1.y1.a aVar = (c.a.t0.e1.y1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<c.a.d.n.e.n> arrayList = aVar.f17131e;
                dVar2.f17091g = arrayList;
                dVar2.f17089e = aVar.f17133g;
                dVar2.f17090f = aVar.f17132f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<c.a.d.n.e.n> arrayList2 = dVar2.f17091g;
                    c.a.d.n.e.n nVar = (c.a.d.n.e.n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof e2) {
                        this.f17088j.lastThreadId = c.a.d.f.m.b.g(((e2) nVar).h0(), 0L);
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
                this.f17083e.onServerError(errorData);
            }
        }
    }

    public void q(c.a.t0.g1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            this.o = j2;
        }
    }

    public void s(int i2) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (frsCommonTabRequestData = this.f17085g) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i2;
    }

    public final ArrayList<c.a.d.n.e.n> t(ArrayList<c.a.d.n.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.f17083e.tabType == 16;
            boolean z2 = this.f17083e.tabType == 100;
            ArrayList<c.a.d.n.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.n.e.n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                c.a.d.n.e.n next = it.next();
                if (next instanceof o0) {
                    ((o0) next).setPosition(i2);
                    arrayList2.add(next);
                } else if (next instanceof p0) {
                    ((p0) next).position = i2;
                    arrayList2.add(next);
                } else if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    c.a.s0.b.f.a.e(e2Var);
                    int[] i0 = e2Var.i0();
                    if (e2Var.getType() == e2.j3 && !e2Var.E2()) {
                        d2 d2Var = new d2();
                        d2Var.w = e2Var;
                        d2Var.position = i2;
                        d2Var.f13529e = true;
                        d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d2Var);
                        d2 d2Var2 = new d2();
                        d2Var2.w = e2Var;
                        d2Var2.position = i2;
                        if (e2Var.R1()) {
                            d2Var2.f13534j = true;
                        } else if (e2Var.i3() == 1) {
                            d2Var2.f13532h = true;
                            d2Var2.x = i0[0];
                            d2Var2.y = i0[1];
                        } else if (e2Var.i3() >= 2) {
                            d2Var2.f13533i = true;
                        } else {
                            d2Var2.f13530f = true;
                        }
                        d2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var2);
                        if (e2Var.K0() != null) {
                            d2 d2Var3 = new d2();
                            d2Var3.s = true;
                            d2Var3.w = e2Var;
                            d2Var3.position = i2;
                            d2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var3);
                        }
                        if (e2Var.h1() != null) {
                            d2 d2Var4 = new d2();
                            d2Var4.p = true;
                            d2Var4.w = e2Var;
                            d2Var4.position = i2;
                            d2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var4);
                        }
                        if (!ListUtils.isEmpty(e2Var.C0()) || !ListUtils.isEmpty(e2Var.e0())) {
                            d2 d2Var5 = new d2();
                            if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) == 1) {
                                d2Var5.t = true;
                            } else if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) > 1) {
                                d2Var5.u = true;
                            }
                            d2Var5.w = e2Var;
                            d2Var5.position = i2;
                            d2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var5);
                        }
                        if (e2Var.z1() != null) {
                            d2 d2Var6 = new d2();
                            d2Var6.l = true;
                            d2Var6.w = e2Var;
                            d2Var6.position = i2;
                            d2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var6);
                        }
                        if (!z && e2Var.u0() != null && !e2Var.M2()) {
                            d2 d2Var7 = new d2();
                            d2Var7.r = true;
                            d2Var7.w = e2Var;
                            d2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var7);
                        }
                        d2 d2Var8 = new d2();
                        d2Var8.k = true;
                        d2Var8.w = e2Var;
                        d2Var8.position = i2;
                        d2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var8);
                    } else if ((e2Var.getType() == e2.H3 || e2Var.getType() == e2.Z3) && !e2Var.E2()) {
                        d2 d2Var9 = new d2();
                        d2Var9.w = e2Var;
                        d2Var9.position = i2;
                        d2Var9.f13529e = true;
                        e2Var.n = z2;
                        d2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d2Var9);
                        d2 d2Var10 = new d2();
                        d2Var10.w = e2Var;
                        d2Var10.position = i2;
                        if (e2Var instanceof y0) {
                            d2Var10.n = true;
                        } else {
                            d2Var10.m = true;
                        }
                        d2Var10.w.n = z2;
                        d2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var10);
                        if (e2Var.K0() != null) {
                            d2 d2Var11 = new d2();
                            d2Var11.s = true;
                            d2Var11.w = e2Var;
                            d2Var11.position = i2;
                            e2Var.n = z2;
                            d2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var11);
                        }
                        if (e2Var.h1() != null) {
                            d2 d2Var12 = new d2();
                            d2Var12.p = true;
                            d2Var12.w = e2Var;
                            d2Var12.position = i2;
                            e2Var.n = z2;
                            d2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var12);
                        }
                        if (e2Var.z1() != null) {
                            d2 d2Var13 = new d2();
                            d2Var13.l = true;
                            d2Var13.w = e2Var;
                            d2Var13.position = i2;
                            e2Var.n = z2;
                            d2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var13);
                        }
                        if (!z && e2Var.u0() != null && !e2Var.M2()) {
                            d2 d2Var14 = new d2();
                            d2Var14.r = true;
                            d2Var14.w = e2Var;
                            e2Var.n = z2;
                            d2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var14);
                        }
                        d2 d2Var15 = new d2();
                        d2Var15.k = true;
                        d2Var15.w = e2Var;
                        d2Var15.position = i2;
                        e2Var.n = z2;
                        d2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var15);
                    } else if (e2Var.u1() != null && !e2Var.j2() && e2Var.d2()) {
                        d2 d2Var16 = new d2();
                        d2Var16.w = e2Var;
                        d2Var16.position = i2;
                        d2Var16.f13529e = true;
                        e2Var.n = z2;
                        d2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d2Var16);
                        d2 d2Var17 = new d2();
                        d2Var17.w = e2Var;
                        d2Var17.position = i2;
                        d2Var17.o = true;
                        e2Var.n = z2;
                        d2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var17);
                        if (e2Var.K0() != null) {
                            d2 d2Var18 = new d2();
                            d2Var18.s = true;
                            d2Var18.w = e2Var;
                            d2Var18.position = i2;
                            e2Var.n = z2;
                            d2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var18);
                        }
                        if (e2Var.h1() != null) {
                            d2 d2Var19 = new d2();
                            d2Var19.p = true;
                            d2Var19.w = e2Var;
                            d2Var19.position = i2;
                            e2Var.n = z2;
                            d2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var19);
                        }
                        if (e2Var.z1() != null) {
                            d2 d2Var20 = new d2();
                            d2Var20.l = true;
                            d2Var20.w = e2Var;
                            d2Var20.position = i2;
                            e2Var.n = z2;
                            d2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var20);
                        }
                        if (!z && e2Var.u0() != null && !e2Var.M2()) {
                            d2 d2Var21 = new d2();
                            d2Var21.r = true;
                            d2Var21.w = e2Var;
                            e2Var.n = z2;
                            d2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var21);
                        }
                        d2 d2Var22 = new d2();
                        d2Var22.k = true;
                        d2Var22.w = e2Var;
                        d2Var22.position = i2;
                        e2Var.n = z2;
                        d2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var22);
                    } else if (e2Var.getType() == e2.z3 && e2Var.Q1()) {
                        e2Var.position = i2;
                        arrayList2.add(e2Var);
                    } else {
                        d2 d2Var23 = new d2();
                        d2Var23.w = e2Var;
                        d2Var23.position = i2;
                        arrayList2.add(d2Var23);
                    }
                    i2++;
                    e2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            c.a.s0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
