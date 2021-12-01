package c.a.f0.t;

import android.content.res.ColorStateList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ColorStateList a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            int i3 = i2 - (-805306368);
            return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842912, 16842919}, new int[]{-16842912, 16842919}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i2 - (-520093696), 268435456, i3, 536870912, i3, 536870912});
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static ColorStateList b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            int i3 = i2 - (-1728053248);
            return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842919, -16842912}, new int[]{16842919, 16842912}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i2 - (-1442840576), -4539718, i3, i3, i2 | (-16777216), -1118482});
        }
        return (ColorStateList) invokeI.objValue;
    }
}
