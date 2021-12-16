package c.a.s0.o1.e.d;

import android.util.LongSparseArray;
import android.util.SparseArray;
import c.a.d.m.e.n;
import c.a.r0.s.r.d2;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.DislikeReason;
import tbclient.RecomVertical.ThreadPersonalized;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes dataRes, List<n> list) {
        c.a.s0.g0.f0.b bVar;
        d2 threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, dataRes, list) == null) || dataRes == null || list == null) {
            return;
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        for (ThreadPersonalized threadPersonalized2 : dataRes.thread_personalized) {
            if (threadPersonalized2 != null) {
                longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            n nVar = (n) ListUtils.getItem(list, i2);
            if ((nVar instanceof c.a.s0.g0.f0.b) && (threadData = (bVar = (c.a.s0.g0.f0.b) nVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(c.a.d.f.m.b.g(threadData.v1(), 0L))) != null) {
                bVar.L(threadPersonalized.source);
                bVar.O(threadPersonalized.weight);
                bVar.H(threadPersonalized.abtest_tag);
                threadData.b1 = threadPersonalized.abtest_tag;
                threadData.Z0 = threadPersonalized.source;
                threadData.a1 = threadPersonalized.weight;
                if (threadData.t1() != null) {
                    bVar.J(threadData.t1().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    bVar.feedBackReasonMap = sparseArray;
                    bVar.I(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(DataRes dataRes, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, dataRes, list) == null) {
            a(dataRes, list);
        }
    }
}
