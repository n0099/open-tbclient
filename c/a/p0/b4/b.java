package c.a.p0.b4;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            String valueOf = String.valueOf(i);
            if (i >= 1000000) {
                float f2 = i / 10000.0f;
                int i2 = i / 10000;
                if (f2 > i2) {
                    return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f146d);
                }
                return i2 + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f146d);
            }
            return valueOf;
        }
        return (String) invokeI.objValue;
    }

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            if (j < 0) {
                j = 0;
            }
            String valueOf = String.valueOf(j);
            if (j >= 1000000) {
                float f2 = ((float) j) / 10000.0f;
                long j2 = j / 10000;
                if (f2 > ((float) j2)) {
                    return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f146d);
                }
                return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f146d);
            }
            return valueOf;
        }
        return (String) invokeJ.objValue;
    }

    public static int c(UserInfo userInfo, int i, Setting setting) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, userInfo, i, setting)) == null) {
            if (userInfo == null || userInfo.is_mem == null) {
                return 0;
            }
            return userInfo.is_mem.intValue() != 2 ? i : (setting == null || setting.vip_extra_switch.intValue() != 1 || setting.vip_extra_percent.intValue() <= 0) ? i : ((setting.vip_extra_percent.intValue() * i) / 100) + i;
        }
        return invokeLIL.intValue;
    }

    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? (int) (i / 100.0f) : invokeI.intValue;
    }
}
