package androidx.room.util;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.room.Room;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class StringUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] EMPTY_STRING_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-61841259, "Landroidx/room/util/StringUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-61841259, "Landroidx/room/util/StringUtil;");
                return;
            }
        }
        EMPTY_STRING_ARRAY = new String[0];
    }

    public StringUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void appendPlaceholders(StringBuilder sb, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, sb, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("?");
                if (i2 < i - 1) {
                    sb.append(",");
                }
            }
        }
    }

    @Nullable
    public static String joinIntoString(@Nullable List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null) {
                return null;
            }
            int size = list.size();
            if (size == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(Integer.toString(list.get(i).intValue()));
                if (i < size - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static StringBuilder newStringBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new StringBuilder() : (StringBuilder) invokeV.objValue;
    }

    @Nullable
    public static List<Integer> splitToIntList(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreElements()) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                } catch (NumberFormatException e) {
                    Log.e(Room.LOG_TAG, "Malformed integer list", e);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
