package c.a.t0.d1.z2;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences a;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbadkCoreApplication.getInst().getSharedPreferences("frs_guide_sp", 0);
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true : invokeLL.booleanValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && a(str, str2)) {
            String str3 = str + '_' + str2;
            Set<String> keySet = this.a.getAll().keySet();
            SharedPreferences.Editor edit = this.a.edit();
            for (String str4 : keySet) {
                if (str4.startsWith(str3)) {
                    edit.remove(str4);
                }
            }
            edit.apply();
        }
    }

    public long c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (a(str, str2)) {
                return this.a.getLong(str + '_' + str2 + "_visit_time", 0L);
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (a(str, str2)) {
                return this.a.getBoolean(str + '_' + str2 + "_show", false);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (a(str, str2)) {
                return this.a.getInt(str + '_' + str2 + "_show_cnt", 0);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public long f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (a(str, str2)) {
                return this.a.getLong(str + '_' + str2 + "_show_time", 0L);
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public void g(String str, String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j2), Boolean.valueOf(z)}) == null) && a(str, str2)) {
            String str3 = str + '_' + str2 + "_show_time";
            String str4 = str + '_' + str2 + "_show_cnt";
            int i2 = this.a.getInt(str4, 0);
            SharedPreferences.Editor edit = this.a.edit();
            if (i2 > 3) {
                edit.putInt(str4, i2 + 1);
            }
            edit.putLong(str3, j2);
            if (z) {
                edit.putBoolean(str + '_' + str2 + "_show", true);
            }
            edit.apply();
        }
    }

    public void h(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) && a(str, str2)) {
            String str3 = str + '_' + str2 + "_visit_time";
            SharedPreferences.Editor edit = this.a.edit();
            edit.putLong(str3, j2);
            edit.apply();
        }
    }
}
