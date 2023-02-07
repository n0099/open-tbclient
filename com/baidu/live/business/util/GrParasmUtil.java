package com.baidu.live.business.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.live.business.model.data.LiveGrParams;
import com.baidu.tieba.qc0;
import com.baidu.tieba.tc0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GrParasmUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, LiveGrParams> grParamsMap;
    public static List<String> uploadFeedList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(608433185, "Lcom/baidu/live/business/util/GrParasmUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(608433185, "Lcom/baidu/live/business/util/GrParasmUtil;");
                return;
            }
        }
        grParamsMap = new HashMap();
        uploadFeedList = new ArrayList();
    }

    public GrParasmUtil() {
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

    public static void clear(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, list) == null) && !grParamsMap.isEmpty() && !qc0.c(list)) {
            Iterator<Map.Entry<String, LiveGrParams>> it = grParamsMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, LiveGrParams> next = it.next();
                if (next != null && list.contains(next.getKey())) {
                    it.remove();
                }
            }
        }
    }

    public static String genUploadJson() {
        InterceptResult invokeV;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (grParamsMap.isEmpty()) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, LiveGrParams> entry : grParamsMap.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    LiveGrParams value = entry.getValue();
                    if (value != null && (json = value.toJson()) != null) {
                        jSONArray.put(json);
                        uploadFeedList.add(key);
                    }
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void logGrParam(String str, boolean z, boolean z2) {
        LiveGrParams liveGrParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || tc0.a(str)) {
            return;
        }
        if (grParamsMap.containsKey(str)) {
            liveGrParams = grParamsMap.get(str);
        } else {
            liveGrParams = new LiveGrParams();
            grParamsMap.put(str, liveGrParams);
        }
        liveGrParams.id = str;
        if (z2) {
            liveGrParams.clk = 1;
            liveGrParams.clkTs = System.currentTimeMillis() / 1000;
        }
        if (z) {
            liveGrParams.show = 1;
            liveGrParams.showTs = System.currentTimeMillis() / 1000;
        }
    }
}
