package com.baidu.sofire.mutiprocess;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class Sp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Sp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int isMainProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? SubProcessManager.isMainProcess(context) : invokeL.intValue;
    }

    public static Bundle mainProcessCallGetPluginStatus(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) ? SubProcessManager.mainProcessCallGetPluginStatus(i, str) : (Bundle) invokeIL.objValue;
    }

    public static Set<Integer> mainProcessGetSubProcessPids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SubProcessManager.mainProcessGetSubProcessPids() : (Set) invokeV.objValue;
    }

    public static Bundle mainProcessRequestCallPlugin(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bundle)) == null) ? SubProcessManager.mainProcessRequestCallPlugin(i, bundle) : (Bundle) invokeIL.objValue;
    }

    public static Map<Integer, Integer> mainProcessStartAllPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? SubProcessManager.mainProcessStartAllPlugin(str) : (Map) invokeL.objValue;
    }

    public static int mainProcessStartOrStopPlugin(int i, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)})) == null) ? SubProcessManager.mainProcessStartOrStopPlugin(i, str, z) : invokeCommon.intValue;
    }

    public static void registerNeedNotifySubProcess(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, str, z) == null) {
            SubProcessManager.registerNeedNotifySubProcess(str, z);
        }
    }

    public static Bundle subProcessRequestCallPlugin(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bundle)) == null) ? SubProcessManager.subProcessRequestCallPlugin(bundle) : (Bundle) invokeL.objValue;
    }
}
