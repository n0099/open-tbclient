package c.a.t0.e1.e3.h;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j2, String str2, c.a.t0.e1.e3.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j2), str2, aVar, Integer.valueOf(i2)}) == null) {
            StatisticItem param = new StatisticItem(str).param("fid", j2).param("fname", str2).param("obj_param1", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE).param(TiebaStatic.Params.OBJ_PARAM2, i2);
            if (aVar != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM3, aVar.f16412e);
            }
            param.eventStat();
        }
    }
}
