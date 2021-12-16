package c.a.s0.d1.w1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.m.e.n;
import c.a.r0.s.r.c2;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.o0;
import c.a.r0.s.r.p0;
import c.a.r0.s.r.y0;
import c.a.s0.d1.s;
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
    public FrsCommonTabFragment f16535e;

    /* renamed from: f  reason: collision with root package name */
    public d f16536f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f16537g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f16538h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16539i;

    /* renamed from: j  reason: collision with root package name */
    public FrsDynamicRequestData f16540j;

    /* renamed from: k  reason: collision with root package name */
    public FrsDynamicModel f16541k;
    public boolean l;
    public HashSet<String> m;
    public int n;
    public long o;
    public int p;
    public String q;
    public String r;
    public c.a.s0.f1.a s;

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
        this.f16535e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f16539i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f16540j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = m.i(TbadkCoreApplication.getInst());
            this.f16540j.scrW = m.k(TbadkCoreApplication.getInst());
            this.f16540j.scrDip = m.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f16540j);
            this.f16541k = frsDynamicModel;
            frsDynamicModel.Y(this);
            this.f16541k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f16539i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f16537g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = i(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f16537g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f16537g);
        this.f16538h = frsCommonTabNetModel;
        frsCommonTabNetModel.Y(this);
        this.f16538h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(d2 d2Var) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null || (dVar = this.f16536f) == null || dVar.f16544g == null) {
            return;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(d2Var);
        ArrayList<n> t = t(arrayList);
        if (ListUtils.isEmpty(this.f16536f.f16544g)) {
            this.f16536f.f16544g.addAll(t);
        } else {
            if (this.f16536f.f16544g.size() == 1 && (this.f16536f.f16544g.get(0) instanceof s)) {
                this.f16536f.f16544g.remove(0);
            }
            this.f16536f.f16544g.addAll(0, t);
        }
        this.f16535e.onViewDataChange(this.f16536f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || c.a.s0.x1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof d2) && (b2 = c.a.s0.j3.l0.b.b(((d2) nVar).Q0())) != null) {
                arrayList.add(b2);
            }
        }
        c.a.s0.j3.l0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b2 = this.l ? 0 : c.a.s0.j3.a.b(this.f16536f.f16544g);
            String d2 = this.l ? "" : c.a.s0.j3.l0.b.f().d(this.r);
            d dVar = this.f16536f;
            String e2 = c.a.s0.j3.a.e(dVar == null ? null : dVar.f16544g, this.l);
            AdExtParam.a b3 = AdExtParam.a.b();
            b3.g(b2);
            b3.e(e2);
            b3.c(d2);
            b3.f(this.f16535e.forumName);
            return b3.a();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d dVar = this.f16536f;
            if (dVar == null) {
                return true;
            }
            return dVar.f16542e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16536f : (d) invokeV.objValue;
    }

    public final void g(List<App> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            c.a.s0.j3.a.k(c.a.s0.j3.a.h(list, "FRS_GENERAL_TAB"), list2, 0);
            c.a.s0.j3.a.a(list2, this.n, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f16536f;
            return (dVar == null || ListUtils.isEmpty(dVar.f16544g)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f16535e;
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
            } else if (mvcSocketResponsedMessage.getData() instanceof c.a.s0.d1.x1.a) {
                c.a.s0.d1.x1.a aVar = (c.a.s0.d1.x1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f16586e;
                dVar2.f16544g = arrayList;
                dVar2.f16542e = aVar.f16588g;
                dVar2.f16543f = aVar.f16587f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f16544g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof d2) {
                        this.f16540j.lastThreadId = c.a.d.f.m.b.g(((d2) nVar).g0(), 0L);
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
                this.f16535e.onServerError(errorData);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.l = false;
            if (!this.f16539i) {
                if (this.f16538h.Q()) {
                    return;
                }
                int i3 = this.n + 1;
                this.n = i3;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f16537g;
                frsCommonTabRequestData.pn = i3;
                frsCommonTabRequestData.sortType = i2;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.f16538h.loadData();
            } else if (this.f16541k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f16540j.qType = 2;
                } else {
                    this.f16540j.qType = 1;
                }
                this.f16541k.loadData();
            }
        }
    }

    public void m(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (dVar = this.f16536f) == null || c.a.s0.x1.o.k.a.e(dVar.f16544g)) {
            return;
        }
        c.a.s0.j3.a.d(str, this.f16536f.f16544g);
        this.f16535e.onViewDataChange(this.f16536f);
    }

    public final boolean n(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            boolean z = this.f16535e.tabType == 100;
            ArrayList arrayList = new ArrayList();
            if (this.l) {
                this.m.clear();
                Iterator<n> it = dVar.f16544g.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof d2) {
                        d2 d2Var = (d2) next;
                        String v1 = d2Var.v1();
                        if (!this.m.contains(v1)) {
                            this.m.add(v1);
                        }
                        if (z && d2Var.t1() != null && !TextUtils.isEmpty(d2Var.t1().video_url)) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(d2Var);
                            arrayList.add(videoItemData);
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.putVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id, arrayList);
                }
                if (c.a.s0.f1.a.d()) {
                    c.a.s0.f1.a aVar = this.s;
                    if (aVar != null) {
                        aVar.b(dVar.f16544g, this.l, this.f16535e.getFid());
                    }
                } else {
                    g(dVar.o, dVar.f16544g);
                }
                this.f16536f = dVar;
                dVar.f16544g = t(dVar.f16544g);
            } else {
                d dVar2 = this.f16536f;
                dVar2.f16542e = dVar.f16542e;
                dVar2.f16543f.putAll(dVar.f16543f);
                ArrayList<n> arrayList2 = new ArrayList<>();
                Iterator<n> it2 = dVar.f16544g.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof d2) {
                        d2 d2Var2 = (d2) next2;
                        String v12 = d2Var2.v1();
                        if (!this.m.contains(v12)) {
                            d2Var2.L1 = this.f16535e.isBrandForum;
                            arrayList2.add(d2Var2);
                            this.m.add(v12);
                            if (z && d2Var2.t1() != null && !TextUtils.isEmpty(d2Var2.t1().video_url)) {
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
                if (c.a.s0.f1.a.d()) {
                    c.a.s0.f1.a aVar2 = this.s;
                    if (aVar2 != null) {
                        aVar2.b(arrayList2, this.l, this.f16535e.getFid());
                    }
                } else {
                    g(dVar.o, arrayList2);
                }
                this.f16536f.f16544g.addAll(t(arrayList2));
            }
            this.f16535e.onViewDataChange(this.f16536f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l = true;
            if (!this.f16539i) {
                if (this.f16538h.Q()) {
                    return;
                }
                this.n = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f16537g;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i2;
                long j2 = this.o;
                if (j2 >= 0) {
                    frsCommonTabRequestData.lastThreadId = j2;
                }
                this.f16537g.adExtParams = c();
                this.f16538h.loadData();
            } else if (this.f16541k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f16540j.qType = 2;
                } else {
                    this.f16540j.qType = 1;
                }
                this.f16540j.lastThreadId = 0L;
                this.f16541k.loadData();
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
            } else if (mvcHttpResponsedMessage.getData() instanceof c.a.s0.d1.x1.a) {
                c.a.s0.d1.x1.a aVar = (c.a.s0.d1.x1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f16586e;
                dVar2.f16544g = arrayList;
                dVar2.f16542e = aVar.f16588g;
                dVar2.f16543f = aVar.f16587f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f16544g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof d2) {
                        this.f16540j.lastThreadId = c.a.d.f.m.b.g(((d2) nVar).g0(), 0L);
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
                this.f16535e.onServerError(errorData);
            }
        }
    }

    public void q(c.a.s0.f1.a aVar) {
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
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (frsCommonTabRequestData = this.f16537g) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i2;
    }

    public final ArrayList<n> t(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.f16535e.tabType == 16;
            boolean z2 = this.f16535e.tabType == 100;
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
                    c.a.r0.b.f.a.e(d2Var);
                    int[] h0 = d2Var.h0();
                    if (d2Var.getType() == d2.g3 && !d2Var.D2()) {
                        c2 c2Var = new c2();
                        c2Var.w = d2Var;
                        c2Var.position = i2;
                        c2Var.f13264e = true;
                        c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var);
                        c2 c2Var2 = new c2();
                        c2Var2.w = d2Var;
                        c2Var2.position = i2;
                        if (d2Var.Q1()) {
                            c2Var2.f13269j = true;
                        } else if (d2Var.h3() == 1) {
                            c2Var2.f13267h = true;
                            c2Var2.x = h0[0];
                            c2Var2.y = h0[1];
                        } else if (d2Var.h3() >= 2) {
                            c2Var2.f13268i = true;
                        } else {
                            c2Var2.f13265f = true;
                        }
                        c2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var2);
                        if (d2Var.J0() != null) {
                            c2 c2Var3 = new c2();
                            c2Var3.s = true;
                            c2Var3.w = d2Var;
                            c2Var3.position = i2;
                            c2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var3);
                        }
                        if (d2Var.g1() != null) {
                            c2 c2Var4 = new c2();
                            c2Var4.p = true;
                            c2Var4.w = d2Var;
                            c2Var4.position = i2;
                            c2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var4);
                        }
                        if (!ListUtils.isEmpty(d2Var.B0()) || !ListUtils.isEmpty(d2Var.d0())) {
                            c2 c2Var5 = new c2();
                            if (ListUtils.getCount(d2Var.B0()) + ListUtils.getCount(d2Var.d0()) == 1) {
                                c2Var5.t = true;
                            } else if (ListUtils.getCount(d2Var.B0()) + ListUtils.getCount(d2Var.d0()) > 1) {
                                c2Var5.u = true;
                            }
                            c2Var5.w = d2Var;
                            c2Var5.position = i2;
                            c2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var5);
                        }
                        if (d2Var.y1() != null) {
                            c2 c2Var6 = new c2();
                            c2Var6.l = true;
                            c2Var6.w = d2Var;
                            c2Var6.position = i2;
                            c2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var6);
                        }
                        if (!z && d2Var.t0() != null && !d2Var.L2()) {
                            c2 c2Var7 = new c2();
                            c2Var7.r = true;
                            c2Var7.w = d2Var;
                            c2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var7);
                        }
                        c2 c2Var8 = new c2();
                        c2Var8.f13270k = true;
                        c2Var8.w = d2Var;
                        c2Var8.position = i2;
                        c2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var8);
                    } else if ((d2Var.getType() == d2.E3 || d2Var.getType() == d2.W3) && !d2Var.D2()) {
                        c2 c2Var9 = new c2();
                        c2Var9.w = d2Var;
                        c2Var9.position = i2;
                        c2Var9.f13264e = true;
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
                        if (d2Var.J0() != null) {
                            c2 c2Var11 = new c2();
                            c2Var11.s = true;
                            c2Var11.w = d2Var;
                            c2Var11.position = i2;
                            d2Var.n = z2;
                            c2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var11);
                        }
                        if (d2Var.g1() != null) {
                            c2 c2Var12 = new c2();
                            c2Var12.p = true;
                            c2Var12.w = d2Var;
                            c2Var12.position = i2;
                            d2Var.n = z2;
                            c2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var12);
                        }
                        if (d2Var.y1() != null) {
                            c2 c2Var13 = new c2();
                            c2Var13.l = true;
                            c2Var13.w = d2Var;
                            c2Var13.position = i2;
                            d2Var.n = z2;
                            c2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var13);
                        }
                        if (!z && d2Var.t0() != null && !d2Var.L2()) {
                            c2 c2Var14 = new c2();
                            c2Var14.r = true;
                            c2Var14.w = d2Var;
                            d2Var.n = z2;
                            c2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var14);
                        }
                        c2 c2Var15 = new c2();
                        c2Var15.f13270k = true;
                        c2Var15.w = d2Var;
                        c2Var15.position = i2;
                        d2Var.n = z2;
                        c2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var15);
                    } else if (d2Var.t1() != null && !d2Var.i2() && d2Var.c2()) {
                        c2 c2Var16 = new c2();
                        c2Var16.w = d2Var;
                        c2Var16.position = i2;
                        c2Var16.f13264e = true;
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
                        if (d2Var.J0() != null) {
                            c2 c2Var18 = new c2();
                            c2Var18.s = true;
                            c2Var18.w = d2Var;
                            c2Var18.position = i2;
                            d2Var.n = z2;
                            c2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var18);
                        }
                        if (d2Var.g1() != null) {
                            c2 c2Var19 = new c2();
                            c2Var19.p = true;
                            c2Var19.w = d2Var;
                            c2Var19.position = i2;
                            d2Var.n = z2;
                            c2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var19);
                        }
                        if (d2Var.y1() != null) {
                            c2 c2Var20 = new c2();
                            c2Var20.l = true;
                            c2Var20.w = d2Var;
                            c2Var20.position = i2;
                            d2Var.n = z2;
                            c2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var20);
                        }
                        if (!z && d2Var.t0() != null && !d2Var.L2()) {
                            c2 c2Var21 = new c2();
                            c2Var21.r = true;
                            c2Var21.w = d2Var;
                            d2Var.n = z2;
                            c2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var21);
                        }
                        c2 c2Var22 = new c2();
                        c2Var22.f13270k = true;
                        c2Var22.w = d2Var;
                        c2Var22.position = i2;
                        d2Var.n = z2;
                        c2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var22);
                    } else if (d2Var.getType() == d2.w3 && d2Var.P1()) {
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
            c.a.r0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
