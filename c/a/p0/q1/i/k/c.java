package c.a.p0.q1.i.k;

import android.util.LongSparseArray;
import android.util.SparseArray;
import c.a.d.o.e.n;
import c.a.p0.h0.e0.q;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<n> list) {
        c.a.p0.h0.e0.b bVar;
        ThreadData threadData;
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
        for (int i = 0; i < count; i++) {
            n nVar = (n) ListUtils.getItem(list, i);
            if ((nVar instanceof c.a.p0.h0.e0.b) && (threadData = (bVar = (c.a.p0.h0.e0.b) nVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(c.a.d.f.m.b.g(threadData.getTid(), 0L))) != null) {
                bVar.J(threadPersonalized.source);
                bVar.M(threadPersonalized.weight);
                bVar.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    bVar.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    bVar.feedBackReasonMap = sparseArray;
                    bVar.G(threadPersonalized.extra);
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
        int i = 0;
        while (i < count) {
            n nVar = (n) ListUtils.getItem(list, i);
            boolean z = nVar instanceof q;
            if (z) {
                ((q) nVar).c(true);
            }
            i++;
            n nVar2 = (n) ListUtils.getItem(list, i);
            if (z && (nVar2 instanceof q)) {
                q qVar = (q) nVar;
                q qVar2 = (q) nVar2;
                if (qVar.l()) {
                    qVar2.c(false);
                    if (qVar2 instanceof c.a.p0.q1.i.l.b) {
                        qVar.t(false);
                    }
                }
            }
            if (nVar instanceof c.a.p0.q1.i.l.b) {
                ((c.a.p0.q1.i.l.b) nVar).t(false);
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
