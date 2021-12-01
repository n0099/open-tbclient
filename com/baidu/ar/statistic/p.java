package com.baidu.ar.statistic;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public static com.baidu.ar.lua.c wS;
    public static final List<String> wT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2090663738, "Lcom/baidu/ar/statistic/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2090663738, "Lcom/baidu/ar/statistic/p;");
                return;
            }
        }
        wT = Arrays.asList(StatisticConstants.EVENT_FILTER_ADJUST, StatisticConstants.EVENT_FILTER_SWITCH, StatisticConstants.EVENT_BEAUTIFY_ADJUST);
    }

    public static void b(com.baidu.ar.lua.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bVar) == null) {
            com.baidu.ar.lua.c cVar = new com.baidu.ar.lua.c() { // from class: com.baidu.ar.statistic.p.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.ar.lua.c
                public void a(int i2, int i3, HashMap<String, Object> hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, hashMap) == null) {
                        if (i2 == 1801) {
                            p.o(hashMap);
                        } else if (i2 == 1901) {
                            p.n(hashMap);
                        }
                    }
                }

                @Override // com.baidu.ar.lua.c
                public List<Integer> n() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_STATISTICS));
                        arrayList.add(1901);
                        return arrayList;
                    }
                    return (List) invokeV.objValue;
                }
            };
            wS = cVar;
            bVar.c(cVar);
        }
    }

    public static void c(com.baidu.ar.lua.b bVar) {
        com.baidu.ar.lua.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bVar) == null) || (cVar = wS) == null) {
            return;
        }
        if (bVar != null) {
            bVar.d(cVar);
        }
        wS = null;
    }

    public static void n(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hashMap) == null) && hashMap != null && hashMap.containsKey("event_name") && hashMap.containsKey("event_id") && "statistic_lua_event".equals((String) hashMap.get("event_name"))) {
            String str = (String) hashMap.get("event_id");
            Object obj = hashMap.get("event_map");
            if (obj == null || !(obj instanceof Map)) {
                StatisticApi.onEvent(str);
            } else {
                StatisticApi.onEvent(str, (Map) obj);
            }
        }
    }

    public static void o(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hashMap) == null) || hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("id");
        String str2 = (String) hashMap.get("type");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        if (hashMap.size() > 1) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                if (entry.getValue() != null) {
                    hashMap2.put(entry.getKey(), entry.getValue().toString());
                }
            }
            hashMap2.remove("type");
            if (hashMap2.containsKey("id")) {
                hashMap2.remove("id");
                hashMap2.put("event_param", str);
            }
        }
        if (wT.contains(str2)) {
            StatisticApi.onEventDebounce(str2, 200L, hashMap2);
        } else {
            StatisticApi.onEvent(str2, hashMap2);
        }
    }
}
