package c.o.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Object> f28887b;

    public d(String str, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f28887b = list == null ? new ArrayList<>() : list;
    }

    public static Map<String, Object> a(Map<Object, Object> map) {
        InterceptResult invokeL;
        Object j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Map) {
                    j2 = a((Map) value);
                } else {
                    j2 = j(value);
                }
                hashMap.put(j(entry.getKey()), j2);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String j(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof byte[]) {
                ArrayList arrayList = new ArrayList();
                for (byte b2 : (byte[]) obj) {
                    arrayList.add(Integer.valueOf(b2));
                }
                return arrayList.toString();
            } else if (obj instanceof Map) {
                return a((Map) obj).toString();
            } else {
                return obj.toString();
            }
        }
        return (String) invokeL.objValue;
    }

    public static Object k(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (c.o.a.e.a.f28889c) {
                String str = "arg " + obj.getClass().getCanonicalName() + " " + j(obj);
            }
            if (obj instanceof List) {
                List list = (List) obj;
                byte[] bArr = new byte[list.size()];
                for (int i2 = 0; i2 < list.size(); i2++) {
                    bArr[i2] = (byte) ((Integer) list.get(i2)).intValue();
                }
                obj = bArr;
            }
            if (c.o.a.e.a.f28889c) {
                String str2 = "arg " + obj.getClass().getCanonicalName() + " " + j(obj);
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c(this.f28887b) : (String[]) invokeV.objValue;
    }

    public final String[] c(List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) ? (String[]) h(list).toArray(new String[0]) : (String[]) invokeL.objValue;
    }

    public List<Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28887b : (List) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                String str = this.a;
                if (str != null) {
                    if (!str.equals(dVar.a)) {
                        return false;
                    }
                } else if (dVar.a != null) {
                    return false;
                }
                if (this.f28887b.size() != dVar.f28887b.size()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f28887b.size(); i2++) {
                    if ((this.f28887b.get(i2) instanceof byte[]) && (dVar.f28887b.get(i2) instanceof byte[])) {
                        if (!Arrays.equals((byte[]) this.f28887b.get(i2), (byte[]) dVar.f28887b.get(i2))) {
                            return false;
                        }
                    } else if (!this.f28887b.get(i2).equals(dVar.f28887b.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Object[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? g(this.f28887b) : (Object[]) invokeV.objValue;
    }

    public final Object[] g(List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (Object obj : list) {
                    arrayList.add(k(obj));
                }
            }
            return arrayList.toArray(new Object[0]);
        }
        return (Object[]) invokeL.objValue;
    }

    public final List<String> h(List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (Object obj : list) {
                    arrayList.add(j(obj));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f28887b.size() == 0) {
                return this;
            }
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            int length = this.a.length();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = this.a.charAt(i4);
                if (charAt == '?') {
                    int i5 = i4 + 1;
                    if (i5 < length && Character.isDigit(this.a.charAt(i5))) {
                        return this;
                    }
                    i2++;
                    if (i3 >= this.f28887b.size()) {
                        return this;
                    }
                    int i6 = i3 + 1;
                    Object obj = this.f28887b.get(i3);
                    if (!(obj instanceof Integer) && !(obj instanceof Long)) {
                        arrayList.add(obj);
                        i3 = i6;
                    } else {
                        sb.append(obj.toString());
                        i3 = i6;
                    }
                }
                sb.append(charAt);
            }
            return i2 != this.f28887b.size() ? this : new d(sb.toString(), arrayList);
        }
        return (d) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            List<Object> list = this.f28887b;
            if (list == null || list.isEmpty()) {
                str = "";
            } else {
                str = " " + h(this.f28887b);
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
