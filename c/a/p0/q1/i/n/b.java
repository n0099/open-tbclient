package c.a.p0.q1.i.n;

import android.content.Context;
import c.a.o0.s.c.z;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, list) == null) {
            if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && c.a.o0.r.j0.b.k().l("key_home_concern_all_status", 0) == 1) {
                list.add(context.getString(R.string.obfuscated_res_0x7f0f02a8));
            } else {
                list.add(context.getString(R.string.obfuscated_res_0x7f0f131c));
            }
            list.add(context.getString(R.string.obfuscated_res_0x7f0f1323));
        }
    }

    public static void b(List<z> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            for (z zVar : list) {
                if (!zVar.c()) {
                    list2.add(zVar.f11280b);
                }
            }
        }
    }

    public static ArrayList<String> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            List<z> g2 = new c.a.p0.q1.e.g.a().g();
            ArrayList<String> arrayList = new ArrayList<>();
            a(context, arrayList);
            b(g2, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
