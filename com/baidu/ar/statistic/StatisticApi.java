package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class StatisticApi {
    public static /* synthetic */ Interceptable $ic;
    public static g wU;
    public static f wV;
    public transient /* synthetic */ FieldHolder $fh;

    public StatisticApi() {
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

    public static f getPerformanceApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (wV == null) {
                wV = new o();
            }
            return wV;
        }
        return (f) invokeV.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (wU == null) {
                try {
                    Constructor<?> a2 = com.baidu.ar.h.n.a("com.baidu.ar.statistic.StatisticApiImpl", Context.class, HandlerThread.class);
                    if (a2 != null) {
                        wU = (g) com.baidu.ar.h.n.a(a2, context, null);
                    }
                } catch (Throwable th) {
                    wU = null;
                    com.baidu.ar.h.b.aS("Statistic init fail");
                    th.printStackTrace();
                }
            }
            if (wV == null) {
                wV = new o();
            }
        }
    }

    public static boolean isAllowPerformanceEvent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            g gVar = wU;
            if (gVar != null) {
                return gVar.isAllowPerformanceEvent(str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            onEvent(str, "");
        }
    }

    public static void onEvent(String str, String str2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onEvent(str, str2);
    }

    public static void onEvent(String str, Map<String, String> map) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, map) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onEvent(str, map);
    }

    public static void onEventDebounce(String str, long j2, String str2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j2), str2}) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onEventDebounce(str, j2, str2);
    }

    public static void onEventDebounce(String str, long j2, Map<String, String> map) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, Long.valueOf(j2), map}) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onEventDebounce(str, j2, map);
    }

    public static void onEventEnd(String str) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onEventEnd(str);
    }

    public static void onEventStart(String str) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onEventStart(str);
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65547, null, str, str2, z) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onEventStatus(str, str2, z);
    }

    public static void onPerformance(String str, Map<String, String> map) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onPerformance(str, map);
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, str, jSONObject) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.onPerformance(str, jSONObject);
    }

    public static void pause() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.pause();
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            wV = null;
            g gVar = wU;
            if (gVar != null) {
                gVar.release();
                wU = null;
            }
        }
    }

    public static void resume() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, null) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.resume();
    }

    public static void setPubParam(String str, String str2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.setPubParam(str, str2);
    }

    public static void setPubParams(Map<String, String> map) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, map) == null) || (gVar = wU) == null) {
            return;
        }
        gVar.setPubParams(map);
    }
}
