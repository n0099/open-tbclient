package c.a.p0.f1.n1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.n0;
import c.a.o0.r.r.o0;
import c.a.o0.r.r.w0;
import c.a.p0.f1.s;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public d f14265b;

    /* renamed from: c  reason: collision with root package name */
    public FrsCommonTabRequestData f14266c;

    /* renamed from: d  reason: collision with root package name */
    public FrsCommonTabNetModel f14267d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14268e;

    /* renamed from: f  reason: collision with root package name */
    public FrsDynamicRequestData f14269f;

    /* renamed from: g  reason: collision with root package name */
    public FrsDynamicModel f14270g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14271h;
    public HashSet<String> i;
    public int j;
    public long k;
    public int l;
    public String m;
    public String n;
    public c.a.p0.h1.a o;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashSet<>();
        this.j = 1;
        this.k = -1L;
        if (frsCommonTabFragment == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        this.n = "FRS_GENERAL_TAB" + i2;
        if (i2 == 89) {
            this.f14268e = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f14269f = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i;
            frsDynamicRequestData.scrH = n.i(TbadkCoreApplication.getInst());
            this.f14269f.scrW = n.k(TbadkCoreApplication.getInst());
            this.f14269f.scrDip = n.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f14269f);
            this.f14270g = frsDynamicModel;
            frsDynamicModel.a0(this);
            this.f14270g.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f14268e = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f14266c = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i;
        frsCommonTabRequestData.tabId = i2;
        frsCommonTabRequestData.isDefaultNavTab = i(i2) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f14266c;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i3;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f14266c);
        this.f14267d = frsCommonTabNetModel;
        frsCommonTabNetModel.a0(this);
        this.f14267d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(ThreadData threadData) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (dVar = this.f14265b) == null || dVar.f14273c == null) {
            return;
        }
        ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<c.a.d.o.e.n> t = t(arrayList);
        if (ListUtils.isEmpty(this.f14265b.f14273c)) {
            this.f14265b.f14273c.addAll(t);
        } else {
            if (this.f14265b.f14273c.size() == 1 && (this.f14265b.f14273c.get(0) instanceof s)) {
                this.f14265b.f14273c.remove(0);
            }
            this.f14265b.f14273c.addAll(0, t);
        }
        this.a.W0(this.f14265b);
    }

    public final void b(List<c.a.d.o.e.n> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || c.a.p0.b2.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (c.a.d.o.e.n nVar : list) {
            if ((nVar instanceof ThreadData) && (b2 = c.a.p0.l3.m0.b.b(((ThreadData) nVar).getRawThreadInfo())) != null) {
                arrayList.add(b2);
            }
        }
        c.a.p0.l3.m0.b.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b2 = this.f14271h ? 0 : c.a.p0.l3.a.b(this.f14265b.f14273c);
            String d2 = this.f14271h ? "" : c.a.p0.l3.m0.b.f().d(this.n);
            d dVar = this.f14265b;
            String e2 = c.a.p0.l3.a.e(dVar == null ? null : dVar.f14273c, this.f14271h);
            AdExtParam.a b3 = AdExtParam.a.b();
            b3.g(b2);
            b3.e(e2);
            b3.c(d2);
            b3.f(this.a.f32439f);
            return b3.a();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d dVar = this.f14265b;
            if (dVar == null) {
                return true;
            }
            return dVar.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14265b : (d) invokeV.objValue;
    }

    public final void g(List<App> list, List<c.a.d.o.e.n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            c.a.p0.l3.a.k(c.a.p0.l3.a.h(list, "FRS_GENERAL_TAB"), list2, 0);
            c.a.p0.l3.a.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f14265b;
            return (dVar == null || ListUtils.isEmpty(dVar.f14273c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.f32437d) == null || frsViewData.mHeadLineDefaultNavTabId != i) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f14271h : invokeV.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f14271h = false;
            if (!this.f14268e) {
                if (this.f14267d.S()) {
                    return;
                }
                int i2 = this.j + 1;
                this.j = i2;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f14266c;
                frsCommonTabRequestData.pn = i2;
                frsCommonTabRequestData.sortType = i;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.f14267d.loadData();
            } else if (this.f14270g.S()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f14269f.qType = 2;
                } else {
                    this.f14269f.qType = 1;
                }
                this.f14270g.loadData();
            }
            c.a.p0.g1.d.a();
        }
    }

    public void l(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (dVar = this.f14265b) == null || c.a.p0.b2.o.k.a.e(dVar.f14273c)) {
            return;
        }
        c.a.p0.l3.a.d(str, this.f14265b.f14273c);
        this.a.W0(this.f14265b);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof c.a.p0.f1.o1.a) {
                c.a.p0.f1.o1.a aVar = (c.a.p0.f1.o1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<c.a.d.o.e.n> arrayList = aVar.a;
                dVar2.f14273c = arrayList;
                dVar2.a = aVar.f14297c;
                dVar2.f14272b = aVar.f14296b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<c.a.d.o.e.n> arrayList2 = dVar2.f14273c;
                    c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof ThreadData) {
                        this.f14269f.lastThreadId = c.a.d.f.m.b.g(((ThreadData) nVar).getId(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !n(dVar)) {
            this.l = mvcSocketResponsedMessage.getError();
            this.m = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.onServerError(errorData);
            }
        }
    }

    public final boolean n(d dVar) {
        InterceptResult invokeL;
        c.a.p0.h1.a aVar;
        c.a.p0.h1.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            boolean z = this.a.f32441h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.f14271h) {
                this.i.clear();
                Iterator<c.a.d.o.e.n> it = dVar.f14273c.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.n next = it.next();
                    if (next instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) next;
                        String tid = threadData.getTid();
                        if (!this.i.contains(tid)) {
                            this.i.add(tid);
                        }
                        if (z && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(threadData);
                            arrayList.add(videoItemData);
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.putVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id, arrayList);
                }
                int i = dVar.l;
                if (i != -1) {
                    if (i == 1) {
                        g(dVar.k, dVar.f14273c);
                    } else if (i == 2) {
                        c.a.p0.h1.a aVar3 = this.o;
                        if (aVar3 != null) {
                            aVar3.b(dVar.f14273c, this.f14271h, this.a.z());
                        }
                    } else if (i != 3) {
                        if (c.a.p0.h1.a.d()) {
                            c.a.p0.h1.a aVar4 = this.o;
                            if (aVar4 != null) {
                                aVar4.b(dVar.f14273c, this.f14271h, this.a.z());
                            }
                        } else {
                            g(dVar.k, dVar.f14273c);
                        }
                    } else if (!ListUtils.isEmpty(dVar.m)) {
                        int intValue = dVar.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(dVar.k, dVar.f14273c);
                        } else if (intValue == 2 && (aVar2 = this.o) != null) {
                            aVar2.g(dVar.f14273c, dVar.m, this.f14271h, this.a.z());
                        }
                    }
                }
                this.f14265b = dVar;
                dVar.f14273c = t(dVar.f14273c);
            } else {
                d dVar2 = this.f14265b;
                dVar2.a = dVar.a;
                dVar2.f14272b.putAll(dVar.f14272b);
                ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
                Iterator<c.a.d.o.e.n> it2 = dVar.f14273c.iterator();
                while (it2.hasNext()) {
                    c.a.d.o.e.n next2 = it2.next();
                    if (next2 instanceof ThreadData) {
                        ThreadData threadData2 = (ThreadData) next2;
                        String tid2 = threadData2.getTid();
                        if (!this.i.contains(tid2)) {
                            threadData2.isFromBrandForum = this.a.l;
                            arrayList2.add(threadData2);
                            this.i.add(tid2);
                            if (z && threadData2.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData2.getThreadVideoInfo().video_url)) {
                                VideoItemData videoItemData2 = new VideoItemData();
                                videoItemData2.buildWithThreadData(threadData2);
                                arrayList.add(videoItemData2);
                            }
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                int i2 = dVar.l;
                if (i2 == 1) {
                    g(dVar.k, dVar.f14273c);
                } else if (i2 == 2) {
                    c.a.p0.h1.a aVar5 = this.o;
                    if (aVar5 != null) {
                        aVar5.b(dVar.f14273c, this.f14271h, this.a.z());
                    }
                } else if (i2 != 3) {
                    if (c.a.p0.h1.a.d()) {
                        c.a.p0.h1.a aVar6 = this.o;
                        if (aVar6 != null) {
                            aVar6.b(dVar.f14273c, this.f14271h, this.a.z());
                        }
                    } else {
                        g(dVar.k, dVar.f14273c);
                    }
                } else if (!ListUtils.isEmpty(dVar.m)) {
                    int intValue2 = dVar.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(dVar.k, dVar.f14273c);
                    } else if (intValue2 == 2 && (aVar = this.o) != null) {
                        aVar.g(dVar.f14273c, dVar.m, this.f14271h, this.a.z());
                    }
                }
                this.f14265b.f14273c.addAll(t(arrayList2));
            }
            this.a.W0(this.f14265b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f14271h = true;
            if (!this.f14268e) {
                if (this.f14267d.S()) {
                    return;
                }
                this.j = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f14266c;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i;
                long j = this.k;
                if (j >= 0) {
                    frsCommonTabRequestData.lastThreadId = j;
                }
                this.f14266c.adExtParams = c();
                this.f14267d.loadData();
            } else if (this.f14270g.S()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f14269f.qType = 2;
                } else {
                    this.f14269f.qType = 1;
                }
                this.f14269f.lastThreadId = 0L;
                this.f14270g.loadData();
            }
            c.a.p0.g1.d.a();
        }
    }

    public void p(c.a.p0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.o = aVar;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.k = j;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof c.a.p0.f1.o1.a) {
                c.a.p0.f1.o1.a aVar = (c.a.p0.f1.o1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<c.a.d.o.e.n> arrayList = aVar.a;
                dVar2.f14273c = arrayList;
                dVar2.a = aVar.f14297c;
                dVar2.f14272b = aVar.f14296b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<c.a.d.o.e.n> arrayList2 = dVar2.f14273c;
                    c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof ThreadData) {
                        this.f14269f.lastThreadId = c.a.d.f.m.b.g(((ThreadData) nVar).getId(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !n(dVar)) {
            this.l = mvcHttpResponsedMessage.getError();
            this.m = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.onServerError(errorData);
            }
        }
    }

    public void s(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || (frsCommonTabRequestData = this.f14266c) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i;
    }

    public final ArrayList<c.a.d.o.e.n> t(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.f32441h == 16;
            boolean z2 = this.a.f32441h == 100;
            ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if (next instanceof n0) {
                    ((n0) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof o0) {
                    ((o0) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        a2 a2Var = new a2();
                        a2Var.s = threadData;
                        a2Var.position = i;
                        a2Var.a = true;
                        a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.s = threadData;
                        a2Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            a2Var2.f10786f = true;
                        } else if (threadData.picCount() == 1) {
                            a2Var2.f10784d = true;
                            a2Var2.t = imageWidthAndHeight[0];
                            a2Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            a2Var2.f10785e = true;
                        } else {
                            a2Var2.f10782b = true;
                        }
                        a2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var2);
                        if (threadData.getPollData() != null) {
                            a2 a2Var3 = new a2();
                            a2Var3.o = true;
                            a2Var3.s = threadData;
                            a2Var3.position = i;
                            a2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            a2 a2Var4 = new a2();
                            a2Var4.l = true;
                            a2Var4.s = threadData;
                            a2Var4.position = i;
                            a2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            a2 a2Var5 = new a2();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                a2Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                a2Var5.q = true;
                            }
                            a2Var5.s = threadData;
                            a2Var5.position = i;
                            a2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            a2 a2Var6 = new a2();
                            a2Var6.f10788h = true;
                            a2Var6.s = threadData;
                            a2Var6.position = i;
                            a2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            a2 a2Var7 = new a2();
                            a2Var7.n = true;
                            a2Var7.s = threadData;
                            a2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var7);
                        }
                        a2 a2Var8 = new a2();
                        a2Var8.f10787g = true;
                        a2Var8.s = threadData;
                        a2Var8.position = i;
                        a2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        a2 a2Var9 = new a2();
                        a2Var9.s = threadData;
                        a2Var9.position = i;
                        a2Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        a2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var9);
                        a2 a2Var10 = new a2();
                        a2Var10.s = threadData;
                        a2Var10.position = i;
                        if (threadData instanceof w0) {
                            a2Var10.j = true;
                        } else {
                            a2Var10.i = true;
                        }
                        a2Var10.s.isJumpToFrsVideoTabPlay = z2;
                        a2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var10);
                        if (threadData.getPollData() != null) {
                            a2 a2Var11 = new a2();
                            a2Var11.o = true;
                            a2Var11.s = threadData;
                            a2Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            a2 a2Var12 = new a2();
                            a2Var12.l = true;
                            a2Var12.s = threadData;
                            a2Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            a2 a2Var13 = new a2();
                            a2Var13.f10788h = true;
                            a2Var13.s = threadData;
                            a2Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            a2 a2Var14 = new a2();
                            a2Var14.n = true;
                            a2Var14.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var14);
                        }
                        a2 a2Var15 = new a2();
                        a2Var15.f10787g = true;
                        a2Var15.s = threadData;
                        a2Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        a2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        a2 a2Var16 = new a2();
                        a2Var16.s = threadData;
                        a2Var16.position = i;
                        a2Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        a2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var16);
                        a2 a2Var17 = new a2();
                        a2Var17.s = threadData;
                        a2Var17.position = i;
                        a2Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        a2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var17);
                        if (threadData.getPollData() != null) {
                            a2 a2Var18 = new a2();
                            a2Var18.o = true;
                            a2Var18.s = threadData;
                            a2Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            a2 a2Var19 = new a2();
                            a2Var19.l = true;
                            a2Var19.s = threadData;
                            a2Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            a2 a2Var20 = new a2();
                            a2Var20.f10788h = true;
                            a2Var20.s = threadData;
                            a2Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            a2 a2Var21 = new a2();
                            a2Var21.n = true;
                            a2Var21.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            a2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var21);
                        }
                        a2 a2Var22 = new a2();
                        a2Var22.f10787g = true;
                        a2Var22.s = threadData;
                        a2Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        a2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        a2 a2Var23 = new a2();
                        a2Var23.s = threadData;
                        a2Var23.position = i;
                        arrayList2.add(a2Var23);
                    }
                    i++;
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
