package c.a.q0.d1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.switchs.TBCdnPortraitSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null) {
                return false;
            }
            if (b(str)) {
                return true;
            }
            int indexOf = str.indexOf("imgsrc");
            if (indexOf <= 0 || indexOf >= 20) {
                return (SwitchManager.getInstance().findType(TBCdnPortraitSwitch.CDNPORTRAIT_SWITCH_KEY) != 0) && c(str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return false;
            }
            int indexOf = str.indexOf("hiphotos");
            if (indexOf <= 0 || indexOf >= 20) {
                int indexOf2 = str.indexOf("tiebapic");
                return indexOf2 > 0 && indexOf2 < 20;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20 : invokeL.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str != null && (indexOf = str.indexOf("tiebapic")) > 0 && indexOf < 20 : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f() : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? FileHelper.checkSD() && c.a.e.d.d.c() : invokeV.booleanValue;
    }
}
