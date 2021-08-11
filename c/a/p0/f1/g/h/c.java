package c.a.p0.f1.g.h;

import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.MoreTreasureTrove.DataRes;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                c2 c2Var = new c2();
                c2Var.S2(threadInfo);
                c2Var.e2 = true;
                arrayList.add(c2Var);
            }
            return c.a.p0.f1.f.a.c.a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(MoreTreasureTroveResIdl moreTreasureTroveResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, moreTreasureTroveResIdl)) == null) {
            if (moreTreasureTroveResIdl == null || (dataRes = moreTreasureTroveResIdl.data) == null || ListUtils.isEmpty(dataRes.hot_thread_info)) {
                return null;
            }
            return a(moreTreasureTroveResIdl.data.hot_thread_info);
        }
        return (List) invokeL.objValue;
    }
}
