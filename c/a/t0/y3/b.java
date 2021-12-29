package c.a.t0.y3;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            String valueOf = String.valueOf(i2);
            if (i2 >= 1000000) {
                float f2 = i2 / 10000.0f;
                int i3 = i2 / 10000;
                if (f2 > i3) {
                    return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return i3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return valueOf;
        }
        return (String) invokeI.objValue;
    }

    public static String b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            String valueOf = String.valueOf(j2);
            if (j2 >= 1000000) {
                float f2 = ((float) j2) / 10000.0f;
                long j3 = j2 / 10000;
                if (f2 > ((float) j3)) {
                    return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return valueOf;
        }
        return (String) invokeJ.objValue;
    }

    public static int c(UserInfo userInfo, int i2, Setting setting) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, userInfo, i2, setting)) == null) {
            if (userInfo == null || userInfo.is_mem == null) {
                return 0;
            }
            return userInfo.is_mem.intValue() != 2 ? i2 : (setting == null || setting.vip_extra_switch.intValue() != 1 || setting.vip_extra_percent.intValue() <= 0) ? i2 : ((setting.vip_extra_percent.intValue() * i2) / 100) + i2;
        }
        return invokeLIL.intValue;
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? (int) (i2 / 100.0f) : invokeI.intValue;
    }
}
