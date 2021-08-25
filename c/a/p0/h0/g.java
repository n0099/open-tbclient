package c.a.p0.h0;

import android.content.ContentResolver;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.p0.s.d0.b.j().h() : (String) invokeV.objValue;
    }

    public static ContentResolver b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.p0.s.d0.b.j().i() : (ContentResolver) invokeV.objValue;
    }

    public static OrmObject c(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, cls)) == null) {
            if (str == null || cls == null) {
                return null;
            }
            return OrmObject.objectWithJsonStr(d(str), cls);
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return e(Uri.parse(a() + str));
        }
        return (String) invokeL.objValue;
    }

    public static String e(Uri uri) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = b().getType(uri);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
                str = null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            f.f("getValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
            return str;
        }
        return (String) invokeL.objValue;
    }
}
