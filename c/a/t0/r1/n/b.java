package c.a.t0.r1.n;

import android.text.TextUtils;
import c.a.s0.s.q.e2;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(e2 e2Var, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65536, null, e2Var, str, str2, i2) == null) || e2Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13022").param("obj_name", str).param("tid", e2Var.w1()).param("fid", e2Var.U()).param("obj_source", e2Var.Z0).param("obj_locate", str2).param("obj_type", i2).param("ab_tag", e2Var.b1));
    }
}
