package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FlowInstanceManager {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, Flow> FLOW_FETCHERS;
    public static UBCManager sUBCManager;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1456336254, "Lcom/baidu/searchbox/player/ubc/FlowInstanceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1456336254, "Lcom/baidu/searchbox/player/ubc/FlowInstanceManager;");
                return;
            }
        }
        FLOW_FETCHERS = new ConcurrentHashMap<>();
        sUBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public FlowInstanceManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void cancelFlow(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            sUBCManager.flowCancel(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            FLOW_FETCHERS.clear();
        }
    }

    public static void createFlow(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (hasCreateFlow(str)) {
            endFlow(str);
        }
        UBCManager uBCManager = sUBCManager;
        if (uBCManager != null) {
            FLOW_FETCHERS.put(str, uBCManager.beginFlow(VideoPlayerUbcConstants.UBC_PLAY_PERFORMANCE_ID));
        }
    }

    public static void endFlow(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            sUBCManager.flowEnd(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void endFlowPart(@Nullable String str, @NonNull String str2) {
        Flow flow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (flow = FLOW_FETCHERS.get(str)) == null) {
            return;
        }
        sUBCManager.flowEndSlot(flow, str2);
    }

    @Nullable
    public static Flow getFlow(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return FLOW_FETCHERS.get(str);
        }
        return (Flow) invokeL.objValue;
    }

    public static boolean hasCreateFlow(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return FLOW_FETCHERS.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public static void setValueAndEndFlow(@Nullable String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            sUBCManager.flowSetValueWithDuration(flow, str2);
            sUBCManager.flowEnd(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void startFlowPart(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            startFlowPart(str, str2, null);
        }
    }

    public static void startFlowPart(@Nullable String str, @NonNull String str2, JSONObject jSONObject) {
        Flow flow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, str, str2, jSONObject) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (flow = FLOW_FETCHERS.get(str)) == null) {
            return;
        }
        sUBCManager.flowStartSlot(flow, str2, jSONObject);
    }
}
