package c.a.t0.w3;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, bool)) == null) {
            if (SwitchManager.getInstance().findType("voice") != 0 || ((str != null && b(str)) || bool == null)) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String[] stringArray = TbadkCoreApplication.getInst().getApp().getResources().getStringArray(R.array.voice_black_frs_list);
            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.forum);
            int length = stringArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (stringArray[i2].equals(str)) {
                    return true;
                }
                if (str.equals(stringArray[i2] + string)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
