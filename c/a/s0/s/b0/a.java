package c.a.s0.s.b0;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j2, int i2, String str2, int i3, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, objArr}) == null) {
            c.a.d.f.n.a aVar = new c.a.d.f.n.a();
            aVar.c("cmd", Integer.valueOf(i2));
            if (!TextUtils.isEmpty(str2)) {
                aVar.b("action", str2);
            }
            aVar.b("errNo", String.valueOf(i3));
            if (!TextUtils.isEmpty(str3) && i3 != 0) {
                aVar.b("errMsg", str3);
            }
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            if (i3 == 0) {
                BdStatisticsManager.getInstance().debug(str, j2, null, aVar);
            } else {
                BdStatisticsManager.getInstance().error(str, j2, (String) null, aVar);
            }
        }
    }
}
