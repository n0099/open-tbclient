package com.baidu.searchbox.http.okurlconnection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Headers;
/* loaded from: classes2.dex */
public final class JavaNetHeaders {
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator<String> FIELD_NAME_COMPARATOR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1170413019, "Lcom/baidu/searchbox/http/okurlconnection/JavaNetHeaders;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1170413019, "Lcom/baidu/searchbox/http/okurlconnection/JavaNetHeaders;");
                return;
            }
        }
        FIELD_NAME_COMPARATOR = new Comparator<String>() { // from class: com.baidu.searchbox.http.okurlconnection.JavaNetHeaders.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                    if (str == str2) {
                        return 0;
                    }
                    if (str == null) {
                        return -1;
                    }
                    if (str2 == null) {
                        return 1;
                    }
                    return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
                }
                return invokeLL.intValue;
            }
        };
    }

    public JavaNetHeaders() {
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

    public static Map<String, List<String>> toMultimap(Headers headers, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, headers, str)) == null) {
            TreeMap treeMap = new TreeMap(FIELD_NAME_COMPARATOR);
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                ArrayList arrayList = new ArrayList();
                List list = (List) treeMap.get(name);
                if (list != null) {
                    arrayList.addAll(list);
                }
                arrayList.add(value);
                treeMap.put(name, Collections.unmodifiableList(arrayList));
            }
            if (str != null) {
                treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
            }
            return Collections.unmodifiableMap(treeMap);
        }
        return (Map) invokeLL.objValue;
    }
}
