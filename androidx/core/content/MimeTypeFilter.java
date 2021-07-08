package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean matches(@Nullable String str, @NonNull String str2) {
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

    @NonNull
    public static String[] matchesMany(@Nullable String[] strArr, @NonNull String str) {
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

    public static boolean mimeTypeAgainstFilter(@NonNull String[] strArr, @NonNull String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, strArr, strArr2)) == null) {
            if (strArr2.length == 2) {
                if (!strArr2[0].isEmpty() && !strArr2[1].isEmpty()) {
                    if (strArr.length != 2) {
                        return false;
                    }
                    if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
                        return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
                    }
                    return false;
                }
                throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
            }
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static String matches(@Nullable String str, @NonNull String[] strArr) {
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

    @Nullable
    public static String matches(@Nullable String[] strArr, @NonNull String str) {
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
}
