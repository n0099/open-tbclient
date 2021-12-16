package c.a.c0.z;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Column column, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, column, str)) == null) {
            if (column.isAssignedValue) {
                return column.field.f2147b + " " + str + h.g(column);
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, columnArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = columnArr.length;
            String str = "";
            int i2 = 0;
            while (i2 < length) {
                Column column = columnArr[i2];
                if (column.isAssignedValue) {
                    sb.append(str);
                    sb.append(a(column, "="));
                    i2++;
                    str = " AND ";
                } else {
                    throw new IllegalArgumentException("Attribute must be initialized.");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static ArrayList<String> c(j jVar) {
        InterceptResult invokeL;
        b[][] e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jVar)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (b[] bVarArr : jVar.e()) {
                String[] strArr = new String[bVarArr.length];
                for (int i2 = 0; i2 < bVarArr.length; i2++) {
                    strArr[i2] = bVarArr[i2].f2147b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + jVar.g() + "_" + TextUtils.join("_", strArr) + " ON " + jVar.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String d(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jVar)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + jVar.g() + " (" + h(jVar.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar)) == null) {
            int i2 = bVar.f2149d;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + bVar.f2149d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String f(b... bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bVarArr)) == null) ? g(bVarArr, null) : (String) invokeL.objValue;
    }

    public static String g(b[] bVarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bVarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = bVarArr.length;
            String str2 = "";
            int i2 = 0;
            while (i2 < length) {
                b bVar = bVarArr[i2];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(bVar.f2147b);
                i2++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String getType(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) {
            int i2 = bVar.a;
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                return " INTEGER";
            }
            if (i2 == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + bVar.a);
        }
        return (String) invokeL.objValue;
    }

    public static String h(b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bVarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = bVarArr.length;
            String str = "";
            int i2 = 0;
            while (i2 < length) {
                b bVar = bVarArr[i2];
                sb.append(str);
                sb.append(bVar.f2147b);
                sb.append(getType(bVar));
                sb.append(e(bVar));
                i2++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String i(k kVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, kVar, str)) == null) {
            if (kVar == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ");
            sb.append(f(kVar.b().d()));
            sb.append(" FROM ");
            sb.append(kVar.b().g());
            if (str != null) {
                sb.append(" ");
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String j(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, columnArr)) == null) {
            return " WHERE " + b(columnArr);
        }
        return (String) invokeL.objValue;
    }
}
