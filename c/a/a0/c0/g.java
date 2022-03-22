package c.a.a0.c0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(j jVar) {
        InterceptResult invokeL;
        b[][] e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jVar)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (b[] bVarArr : jVar.e()) {
                String[] strArr = new String[bVarArr.length];
                for (int i = 0; i < bVarArr.length; i++) {
                    strArr[i] = bVarArr[i].f1052b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + jVar.g() + "_" + TextUtils.join("_", strArr) + " ON " + jVar.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jVar)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + jVar.g() + " (" + f(jVar.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            int i = bVar.f1054d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + bVar.f1054d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(b... bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVarArr)) == null) ? e(bVarArr, null) : (String) invokeL.objValue;
    }

    public static String e(b[] bVarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = bVarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                b bVar = bVarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(bVar.f1052b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bVarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = bVarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                b bVar = bVarArr[i];
                sb.append(str);
                sb.append(bVar.f1052b);
                sb.append(getType(bVar));
                sb.append(c(bVar));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bVar)) == null) {
            int i = bVar.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + bVar.a);
        }
        return (String) invokeL.objValue;
    }
}
