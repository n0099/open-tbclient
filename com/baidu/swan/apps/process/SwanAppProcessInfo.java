package com.baidu.swan.apps.process;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppActivity1;
import com.baidu.swan.apps.SwanAppActivity2;
import com.baidu.swan.apps.SwanAppActivity3;
import com.baidu.swan.apps.SwanAppActivity4;
import com.baidu.swan.apps.SwanAppActivity5;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService1;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService2;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService3;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService4;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class SwanAppProcessInfo {
    public static final /* synthetic */ SwanAppProcessInfo[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final SwanAppProcessInfo P0;
    public static final SwanAppProcessInfo P1;
    public static final SwanAppProcessInfo P2;
    public static final SwanAppProcessInfo P3;
    public static final SwanAppProcessInfo P4;
    public static final SwanAppProcessInfo P5;
    public static final int PROCESS_ID_END = 5;
    public static final int PROCESS_ID_START = 0;
    public static final SwanAppProcessInfo SERVICE;
    public static final String SWAN_APP_PROCESS_SUFFIX = ":swan";
    public static final SwanAppProcessInfo UNKNOWN;
    @NonNull
    public static SwanAppProcessInfo sCurrent;
    public static SwanAppProcessInfo[] sIndices;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<? extends SwanAppActivity> activity;
    public final int index;
    public final boolean isSwanClient;
    public final boolean isSwanService;
    public final Class<? extends SwanAppLocalService> service;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1006262177, "Lcom/baidu/swan/apps/process/SwanAppProcessInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1006262177, "Lcom/baidu/swan/apps/process/SwanAppProcessInfo;");
                return;
            }
        }
        UNKNOWN = new SwanAppProcessInfo(RomUtils.UNKNOWN, 0, -2, false, false, null, null);
        SERVICE = new SwanAppProcessInfo("SERVICE", 1, -1, true, false, null, null);
        P0 = new SwanAppProcessInfo("P0", 2, 0, false, true, SwanAppActivity.class, SwanAppLocalService.class);
        P1 = new SwanAppProcessInfo("P1", 3, 1, false, true, SwanAppActivity1.class, SwanAppLocalService1.class);
        P2 = new SwanAppProcessInfo("P2", 4, 2, false, true, SwanAppActivity2.class, SwanAppLocalService2.class);
        P3 = new SwanAppProcessInfo("P3", 5, 3, false, true, SwanAppActivity3.class, SwanAppLocalService3.class);
        P4 = new SwanAppProcessInfo("P4", 6, 4, false, true, SwanAppActivity4.class, SwanAppLocalService4.class);
        SwanAppProcessInfo swanAppProcessInfo = new SwanAppProcessInfo("P5", 7, 5, false, true, SwanAppActivity5.class, SwanAppLocalService5.class);
        P5 = swanAppProcessInfo;
        SwanAppProcessInfo swanAppProcessInfo2 = UNKNOWN;
        $VALUES = new SwanAppProcessInfo[]{swanAppProcessInfo2, SERVICE, P0, P1, P2, P3, P4, swanAppProcessInfo};
        sCurrent = swanAppProcessInfo2;
    }

    public SwanAppProcessInfo(String str, int i2, int i3, boolean z, boolean z2, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), cls, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.index = i3;
        this.activity = cls;
        this.service = cls2;
        this.isSwanService = z;
        this.isSwanClient = z2;
    }

    public static boolean checkProcessId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 >= 0 && i2 <= 5 : invokeI.booleanValue;
    }

    @NonNull
    public static SwanAppProcessInfo current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (isInited() || !ProcessUtils.isMainProcess()) ? sCurrent : init(SERVICE) : (SwanAppProcessInfo) invokeV.objValue;
    }

    public static SwanAppProcessInfo indexOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? indices()[i2] : (SwanAppProcessInfo) invokeI.objValue;
    }

    public static SwanAppProcessInfo[] indices() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (sIndices == null) {
                SwanAppProcessInfo[] values = values();
                sIndices = new SwanAppProcessInfo[values.length];
                int i3 = 0;
                for (SwanAppProcessInfo swanAppProcessInfo : values) {
                    if (swanAppProcessInfo != null && (i2 = swanAppProcessInfo.index) >= 0) {
                        SwanAppProcessInfo[] swanAppProcessInfoArr = sIndices;
                        if (i2 < swanAppProcessInfoArr.length && swanAppProcessInfoArr[i2] == null) {
                            swanAppProcessInfoArr[i2] = swanAppProcessInfo;
                        }
                    }
                }
                while (true) {
                    SwanAppProcessInfo[] swanAppProcessInfoArr2 = sIndices;
                    if (i3 >= swanAppProcessInfoArr2.length) {
                        break;
                    }
                    if (swanAppProcessInfoArr2[i3] == null) {
                        swanAppProcessInfoArr2[i3] = UNKNOWN;
                    }
                    i3++;
                }
            }
            return sIndices;
        }
        return (SwanAppProcessInfo[]) invokeV.objValue;
    }

    @NonNull
    public static SwanAppProcessInfo init(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, swanAppProcessInfo)) == null) {
            if (!isInited() && swanAppProcessInfo != null && !sCurrent.equals(swanAppProcessInfo) && !UNKNOWN.equals(swanAppProcessInfo)) {
                sCurrent = swanAppProcessInfo;
            }
            return sCurrent;
        }
        return (SwanAppProcessInfo) invokeL.objValue;
    }

    public static boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sCurrent.isSwanClient : invokeV.booleanValue;
    }

    public static SwanAppProcessInfo valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? (SwanAppProcessInfo) Enum.valueOf(SwanAppProcessInfo.class, str) : (SwanAppProcessInfo) invokeL.objValue;
    }

    public static SwanAppProcessInfo[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? (SwanAppProcessInfo[]) $VALUES.clone() : (SwanAppProcessInfo[]) invokeV.objValue;
    }

    public boolean isSwanAppProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? checkProcessId(this.index) : invokeV.booleanValue;
    }

    public static boolean isSwanAppProcess(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? !TextUtils.isEmpty(str) && str.contains(":swan") : invokeL.booleanValue;
    }
}
