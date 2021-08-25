package c.a.q0.f1.l.c;

import android.util.SparseArray;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(List<ThreadPersonalized> list, List<n> list2) {
        c.a.q0.a0.d0.b bVar;
        c2 threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (ThreadPersonalized threadPersonalized2 : list) {
            if (threadPersonalized2 != null) {
                hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list2);
        for (int i2 = 0; i2 < count; i2++) {
            n nVar = (n) ListUtils.getItem(list2, i2);
            if ((nVar instanceof c.a.q0.a0.d0.b) && (threadData = (bVar = (c.a.q0.a0.d0.b) nVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(threadData.q1())) != null) {
                bVar.L(threadPersonalized.source);
                bVar.O(threadPersonalized.weight);
                bVar.H(threadPersonalized.abtest_tag);
                threadData.W0 = threadPersonalized.abtest_tag;
                threadData.U0 = threadPersonalized.source;
                threadData.V0 = threadPersonalized.weight;
                if (threadData.o1() != null) {
                    bVar.J(threadData.o1().is_vertical);
                }
                List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                if (list3 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list3) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    bVar.feedBackReasonMap = sparseArray;
                    bVar.I(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<ThreadPersonalized> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            a(list, list2);
        }
    }
}
