package c.a.p0.q1.d.g;

import c.a.d.o.e.n;
import c.a.p0.h0.e0.j;
import c.a.p0.h0.e0.k;
import c.a.p0.h0.e0.l;
import c.a.p0.h0.e0.m;
import c.a.p0.q1.d.f.c;
import c.a.p0.q1.i.k.d;
import c.a.p0.q1.i.k.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new d();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public d b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                a(builder);
                a(builder2);
                d(z, builder, builder2, i);
                LinkedList linkedList = new LinkedList();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (ConcernData concernData : builder.thread_info) {
                    if (concernData != null) {
                        if (c.q(builder.hot_recomforum, i2)) {
                            c cVar = new c();
                            if (cVar.k(builder.hot_recomforum.tab_list)) {
                                cVar.position = i2;
                                linkedList.add(cVar);
                                i2++;
                            }
                        }
                        if (c.a.p0.q1.d.f.a.k(concernData)) {
                            c.a.p0.q1.d.f.a aVar = new c.a.p0.q1.d.f.a();
                            if (concernData.recom_user_list.size() >= 4) {
                                aVar.g(concernData.recom_user_list);
                                aVar.position = i2;
                                aVar.m(builder.thread_info.size() > 1);
                                linkedList.add(aVar);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = c.a.p0.l3.m0.b.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(e(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                c.a.p0.l3.m0.b.f().h("CONCERN", arrayList);
                d dVar = this.a;
                dVar.a = linkedList;
                return dVar;
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public final void c(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) || list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i == 1) {
            for (ConcernData concernData : list2) {
                if (c.a.p0.q1.d.f.a.k(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!c.a.p0.q1.d.d.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && c.a.p0.q1.d.f.a.k(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.a.f17468b = ListUtils.getCount(list) - count;
    }

    public final void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || (list = builder.thread_info) == null || (list2 = builder2.thread_info) == null) {
            return;
        }
        c(z, list, list2, i);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<n> e(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        c.a.p0.h0.e0.b kVar;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((k.W(threadData) || l.R(threadData) || m.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (m.W(threadData)) {
                    kVar = new m(threadData);
                } else if (l.R(threadData)) {
                    kVar = new l(threadData);
                } else {
                    kVar = new k();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    kVar.a = threadData;
                }
                kVar.f15321g = threadData.getTid();
                if (k.W(threadData)) {
                    kVar.L("1");
                } else if (l.R(threadData)) {
                    kVar.L("2");
                }
                kVar.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && kVar.getThreadData() != null && kVar.getThreadData().getAuthor() != null) {
                    if (!kVar.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        e.r(kVar);
                        e.o(threadData);
                    } else {
                        e.t(kVar);
                    }
                } else if (kVar instanceof m) {
                    e.t(kVar);
                } else {
                    e.t(kVar);
                }
                kVar.a.insertItemToTitleOrAbstractText();
                if (kVar instanceof k) {
                    if (threadData.isBJHNormalThreadType()) {
                        e.u(kVar);
                    } else if (threadData.picCount() == 1) {
                        e.w(kVar);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        kVar.j = imageWidthAndHeight[0];
                        kVar.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        e.v(kVar);
                    } else {
                        e.x(kVar);
                    }
                } else if (kVar instanceof l) {
                    e.y(kVar);
                }
                if (kVar instanceof m) {
                    e.z(kVar);
                }
                if (threadData.getItem() != null) {
                    e.A(kVar);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        e.D(kVar);
                    } else {
                        e.B(kVar);
                    }
                }
                e.q(kVar);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    e.s(kVar);
                }
                e.p(kVar);
                kVar.setSupportType(BaseCardInfo.SupportType.TOP);
                kVar.position = i;
                arrayList.add(kVar);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    e.o(threadData);
                }
                if (threadData.isShareThread) {
                    k kVar2 = new k();
                    kVar2.a = threadData;
                    kVar2.position = i;
                    arrayList.add(kVar2);
                } else if (l.R(threadData)) {
                    l lVar = new l(threadData);
                    lVar.f15321g = threadData.getTid();
                    if (concernData != null) {
                        lVar.K(concernData.source.intValue());
                    }
                    if (lVar.isValid()) {
                        arrayList.add(lVar);
                    }
                } else if (j.W(threadData)) {
                    j jVar = new j(threadData);
                    jVar.f15321g = threadData.getTid();
                    jVar.L("3");
                    if (jVar.isValid()) {
                        arrayList.add(jVar);
                    }
                } else if (c.a.p0.h0.e0.e.W(threadData) && threadData.isBJHArticleThreadType()) {
                    c.a.p0.h0.e0.e eVar = new c.a.p0.h0.e0.e(threadData);
                    eVar.position = i;
                    arrayList.add(eVar);
                } else {
                    k kVar3 = new k();
                    kVar3.a = threadData;
                    kVar3.L(threadData.isLinkThread() ? "4" : "1");
                    kVar3.position = i;
                    if (concernData != null) {
                        kVar3.K(concernData.source.intValue());
                    }
                    if (kVar3.a != null && kVar3.isValid() && !StringUtils.isNull(kVar3.a.getId()) && !"0".equals(kVar3.a.getTid())) {
                        arrayList.add(kVar3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
