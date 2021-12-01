package c.a.r0.n1.h.k;

import android.util.LongSparseArray;
import android.util.SparseArray;
import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.g0.f0.q;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<n> list) {
        c.a.r0.g0.f0.b bVar;
        d2 threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, builder, list) == null) || builder == null || list == null) {
            return;
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
            if (threadPersonalized2 != null) {
                longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            n nVar = (n) ListUtils.getItem(list, i2);
            if ((nVar instanceof c.a.r0.g0.f0.b) && (threadData = (bVar = (c.a.r0.g0.f0.b) nVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(c.a.d.f.m.b.g(threadData.v1(), 0L))) != null) {
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

    public static void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i2 = 0;
        while (i2 < count) {
            n nVar = (n) ListUtils.getItem(list, i2);
            boolean z = nVar instanceof q;
            if (z) {
                ((q) nVar).b(true);
            }
            i2++;
            n nVar2 = (n) ListUtils.getItem(list, i2);
            if (z && (nVar2 instanceof q)) {
                q qVar = (q) nVar;
                q qVar2 = (q) nVar2;
                if (qVar.j()) {
                    qVar2.b(false);
                    if (qVar2 instanceof c.a.r0.n1.h.l.b) {
                        qVar.r(false);
                    }
                }
            }
            if (nVar instanceof c.a.r0.n1.h.l.b) {
                ((c.a.r0.n1.h.l.b) nVar).r(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
