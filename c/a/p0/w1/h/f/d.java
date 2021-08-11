package c.a.p0.w1.h.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? c(d(str)) : (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(str).trim() : (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Pattern compile = Pattern.compile(TbadkCoreApplication.getInst().getString(R.string.tail_remove_dupe_regex));
            boolean z = false;
            int i2 = 0;
            while (!z && i2 < 1000) {
                Matcher matcher = compile.matcher(str);
                if (matcher.find()) {
                    str = matcher.replaceAll(TbadkCoreApplication.getInst().getString(R.string.tail_remove_dupe_replace));
                    i2++;
                } else {
                    z = true;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.trim() : (String) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Matcher matcher = Pattern.compile(TbFaceManager.f48147d).matcher(str);
            while (matcher.find()) {
                if (TbFaceManager.e().g(matcher.group()) <= 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            String c2 = c(str);
            if (StringUtils.isNull(c2)) {
                return TbadkCoreApplication.getInst().getString(R.string.tail_empty_toast);
            }
            return !e(c2) ? TbadkCoreApplication.getInst().getString(R.string.tail_invalid_emotion) : "";
        }
        return (String) invokeL.objValue;
    }
}
