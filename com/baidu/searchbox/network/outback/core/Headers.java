package com.baidu.searchbox.network.outback.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.internal.HttpDate;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public final class Headers {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] namesAndValues;

    /* loaded from: classes2.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List namesAndValues;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.namesAndValues = new ArrayList(20);
        }

        public Headers build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new Headers(this);
            }
            return (Headers) invokeV.objValue;
        }

        public Builder add(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
                }
                throw new IllegalArgumentException("Unexpected header: " + str);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addLenient(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                int indexOf = str.indexOf(":", 1);
                if (indexOf != -1) {
                    return addLenient(str.substring(0, indexOf), str.substring(indexOf + 1));
                }
                if (str.startsWith(":")) {
                    return addLenient("", str.substring(1));
                }
                return addLenient("", str);
            }
            return (Builder) invokeL.objValue;
        }

        public String get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                    if (str.equalsIgnoreCase((String) this.namesAndValues.get(size))) {
                        return (String) this.namesAndValues.get(size + 1);
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public Builder removeAll(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                int i = 0;
                while (i < this.namesAndValues.size()) {
                    if (str.equalsIgnoreCase((String) this.namesAndValues.get(i))) {
                        this.namesAndValues.remove(i);
                        this.namesAndValues.remove(i);
                        i -= 2;
                    }
                    i += 2;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder add(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                Headers.checkName(str);
                Headers.checkValue(str2, str);
                return addLenient(str, str2);
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addLenient(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                this.namesAndValues.add(str);
                this.namesAndValues.add(str2.trim());
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addUnsafeNonAscii(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
                Headers.checkName(str);
                return addLenient(str, str2);
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder set(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
                Headers.checkName(str);
                Headers.checkValue(str2, str);
                removeAll(str);
                addLenient(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addAll(Headers headers) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, headers)) == null) {
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    addLenient(headers.name(i), headers.value(i));
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public Headers(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        List list = builder.namesAndValues;
        this.namesAndValues = (String[]) list.toArray(new String[list.size()]);
    }

    public List values(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            int size = size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                if (str.equalsIgnoreCase(name(i))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                    }
                    arrayList.add(value(i));
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    public Headers(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.namesAndValues = strArr;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if ((obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return get(this.namesAndValues, str);
        }
        return (String) invokeL.objValue;
    }

    public Date getDate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String str2 = get(str);
            if (str2 != null) {
                return HttpDate.parse(str2);
            }
            return null;
        }
        return (Date) invokeL.objValue;
    }

    public String name(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.namesAndValues[i * 2];
        }
        return (String) invokeI.objValue;
    }

    public String value(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return this.namesAndValues[(i * 2) + 1];
        }
        return (String) invokeI.objValue;
    }

    public static void checkName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (charAt <= ' ' || charAt >= 127) {
                            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }
    }

    public static void checkValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            if (str != null) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                    }
                }
                return;
            }
            throw new NullPointerException("value for name " + str2 + " == null");
        }
    }

    public static String get(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr, str)) == null) {
            for (int length = strArr.length - 2; length >= 0; length -= 2) {
                if (str.equalsIgnoreCase(strArr[length])) {
                    return strArr[length + 1];
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static Headers of(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) {
            if (map != null) {
                String[] strArr = new String[map.size() * 2];
                int i = 0;
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        String trim = ((String) entry.getKey()).trim();
                        String trim2 = ((String) entry.getValue()).trim();
                        checkName(trim);
                        checkValue(trim2, trim);
                        strArr[i] = trim;
                        strArr[i + 1] = trim2;
                        i += 2;
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                return new Headers(strArr);
            }
            throw new NullPointerException("headers == null");
        }
        return (Headers) invokeL.objValue;
    }

    public static Headers of(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, strArr)) == null) {
            if (strArr != null) {
                if (strArr.length % 2 == 0) {
                    String[] strArr2 = (String[]) strArr.clone();
                    for (int i = 0; i < strArr2.length; i++) {
                        if (strArr2[i] != null) {
                            strArr2[i] = strArr2[i].trim();
                        } else {
                            throw new IllegalArgumentException("Headers cannot be null");
                        }
                    }
                    for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                        String str = strArr2[i2];
                        String str2 = strArr2[i2 + 1];
                        checkName(str);
                        checkValue(str2, str);
                    }
                    return new Headers(strArr2);
                }
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            throw new NullPointerException("namesAndValues == null");
        }
        return (Headers) invokeL.objValue;
    }

    public long byteCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String[] strArr = this.namesAndValues;
            long length = strArr.length * 2;
            for (int i = 0; i < strArr.length; i++) {
                length += this.namesAndValues[i].length();
            }
            return length;
        }
        return invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Arrays.hashCode(this.namesAndValues);
        }
        return invokeV.intValue;
    }

    public Set names() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            int size = size();
            for (int i = 0; i < size; i++) {
                treeSet.add(name(i));
            }
            return Collections.unmodifiableSet(treeSet);
        }
        return (Set) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Builder builder = new Builder();
            Collections.addAll(builder.namesAndValues, this.namesAndValues);
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.namesAndValues.length / 2;
        }
        return invokeV.intValue;
    }

    public Map toMultimap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            int size = size();
            for (int i = 0; i < size; i++) {
                String lowerCase = name(i).toLowerCase(Locale.US);
                List list = (List) treeMap.get(lowerCase);
                if (list == null) {
                    list = new ArrayList(2);
                    treeMap.put(lowerCase, list);
                }
                list.add(value(i));
            }
            return treeMap;
        }
        return (Map) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = size();
            for (int i = 0; i < size; i++) {
                sb.append(name(i));
                sb.append(": ");
                sb.append(value(i));
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
