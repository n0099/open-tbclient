package c.a.s0.q1.n;

import android.text.TextUtils;
import c.a.r0.s.r.d2;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d2 d2Var, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65536, null, d2Var, str, str2, i2) == null) || d2Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13022").param("obj_name", str).param("tid", d2Var.v1()).param("fid", d2Var.U()).param("obj_source", d2Var.Z0).param("obj_locate", str2).param("obj_type", i2).param("ab_tag", d2Var.b1));
    }
}
