package c.d.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] a;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList(20);
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                r.a(str);
                r.b(str2, str);
                c(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                int indexOf = str.indexOf(":", 1);
                if (indexOf != -1) {
                    c(str.substring(0, indexOf), str.substring(indexOf + 1));
                    return this;
                } else if (str.startsWith(":")) {
                    c("", str.substring(1));
                    return this;
                } else {
                    c("", str);
                    return this;
                }
            }
            return (a) invokeL.objValue;
        }

        public a c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                this.a.add(str);
                this.a.add(str2.trim());
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public r d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new r(this) : (r) invokeV.objValue;
        }

        public String e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                for (int size = this.a.size() - 2; size >= 0; size -= 2) {
                    if (str.equalsIgnoreCase(this.a.get(size))) {
                        return this.a.get(size + 1);
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                int i2 = 0;
                while (i2 < this.a.size()) {
                    if (str.equalsIgnoreCase(this.a.get(i2))) {
                        this.a.remove(i2);
                        this.a.remove(i2);
                        i2 -= 2;
                    }
                    i2 += 2;
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                r.a(str);
                r.b(str2, str);
                f(str);
                c(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }
    }

    public r(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        List<String> list = aVar.a;
        this.a = (String[]) list.toArray(new String[list.size()]);
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        char charAt = str.charAt(i2);
                        if (charAt <= ' ' || charAt >= 127) {
                            throw new IllegalArgumentException(c.d.b.e0.e.q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            if (str != null) {
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                        throw new IllegalArgumentException(c.d.b.e0.e.q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2, str));
                    }
                }
                return;
            }
            throw new NullPointerException("value for name " + str2 + " == null");
        }
    }

    public static String d(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, strArr, str)) == null) {
            for (int length = strArr.length - 2; length >= 0; length -= 2) {
                if (str.equalsIgnoreCase(strArr[length])) {
                    return strArr[length + 1];
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? d(this.a, str) : (String) invokeL.objValue;
    }

    public String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.a[i2 * 2] : (String) invokeI.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof r) && Arrays.equals(((r) obj).a, this.a) : invokeL.booleanValue;
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = new a();
            Collections.addAll(aVar.a, this.a);
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.length / 2 : invokeV.intValue;
    }

    public String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.a[(i2 * 2) + 1] : (String) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Arrays.hashCode(this.a) : invokeV.intValue;
    }

    public List<String> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            int g2 = g();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < g2; i2++) {
                if (str.equalsIgnoreCase(e(i2))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                    }
                    arrayList.add(h(i2));
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int g2 = g();
            for (int i2 = 0; i2 < g2; i2++) {
                sb.append(e(i2));
                sb.append(": ");
                sb.append(h(i2));
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
