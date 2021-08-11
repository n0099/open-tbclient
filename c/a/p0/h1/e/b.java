package c.a.p0.h1.e;

import android.text.TextUtils;
import c.a.o0.s.q.c2;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c2 c2Var, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65536, null, c2Var, str, str2, i2) == null) || c2Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13022").param("obj_name", str).param("tid", c2Var.q1()).param("fid", c2Var.T()).param("obj_source", c2Var.U0).param("obj_locate", str2).param("obj_type", i2).param("ab_tag", c2Var.W0));
    }
}
