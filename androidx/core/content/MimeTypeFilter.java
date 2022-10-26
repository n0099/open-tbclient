package androidx.core.content;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class MimeTypeFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MimeTypeFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String matches(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, strArr)) == null) {
            if (str == null) {
                return null;
            }
            String[] split = str.split("/");
            for (String str2 : strArr) {
                if (mimeTypeAgainstFilter(split, str2.split("/"))) {
                    return str2;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String matches(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, strArr, str)) == null) {
            if (strArr == null) {
                return null;
            }
            String[] split = str.split("/");
            for (String str2 : strArr) {
                if (mimeTypeAgainstFilter(str2.split("/"), split)) {
                    return str2;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean matches(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str == null) {
                return false;
            }
            return mimeTypeAgainstFilter(str.split("/"), str2.split("/"));
        }
        return invokeLL.booleanValue;
    }

    public static String[] matchesMany(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr, str)) == null) {
            if (strArr == null) {
                return new String[0];
            }
            ArrayList arrayList = new ArrayList();
            String[] split = str.split("/");
            for (String str2 : strArr) {
                if (mimeTypeAgainstFilter(str2.split("/"), split)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeLL.objValue;
    }

    public static boolean mimeTypeAgainstFilter(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, strArr, strArr2)) == null) {
            if (strArr2.length == 2) {
                if (!strArr2[0].isEmpty() && !strArr2[1].isEmpty()) {
                    if (strArr.length != 2) {
                        return false;
                    }
                    if (!"*".equals(strArr2[0]) && !strArr2[0].equals(strArr[0])) {
                        return false;
                    }
                    if (!"*".equals(strArr2[1]) && !strArr2[1].equals(strArr[1])) {
                        return false;
                    }
                    return true;
                }
                throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
            }
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        return invokeLL.booleanValue;
    }
}
