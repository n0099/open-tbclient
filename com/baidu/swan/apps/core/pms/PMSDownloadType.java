package com.baidu.swan.apps.core.pms;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class PMSDownloadType {
    public static final /* synthetic */ PMSDownloadType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PMSDownloadType ALONE_SUB;
    public static final PMSDownloadType ASYNC;
    public static final PMSDownloadType BATCH;
    public static final PMSDownloadType PLUGIN;
    public static final PMSDownloadType PRE;
    public static final PMSDownloadType SILENT_UPDATE;
    public static final PMSDownloadType SO_LIB;
    public static final PMSDownloadType SWAN_APP_UPDATE_CORE;
    public static final PMSDownloadType SWAN_GAME_UPDATE_CORE;
    public static final PMSDownloadType SYNC;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(746581663, "Lcom/baidu/swan/apps/core/pms/PMSDownloadType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(746581663, "Lcom/baidu/swan/apps/core/pms/PMSDownloadType;");
                return;
            }
        }
        PRE = new PMSDownloadType("PRE", 0);
        ASYNC = new PMSDownloadType("ASYNC", 1);
        SYNC = new PMSDownloadType("SYNC", 2);
        SILENT_UPDATE = new PMSDownloadType("SILENT_UPDATE", 3);
        BATCH = new PMSDownloadType("BATCH", 4);
        ALONE_SUB = new PMSDownloadType("ALONE_SUB", 5);
        SWAN_APP_UPDATE_CORE = new PMSDownloadType("SWAN_APP_UPDATE_CORE", 6);
        SWAN_GAME_UPDATE_CORE = new PMSDownloadType("SWAN_GAME_UPDATE_CORE", 7);
        SO_LIB = new PMSDownloadType("SO_LIB", 8);
        PMSDownloadType pMSDownloadType = new PMSDownloadType("PLUGIN", 9);
        PLUGIN = pMSDownloadType;
        $VALUES = new PMSDownloadType[]{PRE, ASYNC, SYNC, SILENT_UPDATE, BATCH, ALONE_SUB, SWAN_APP_UPDATE_CORE, SWAN_GAME_UPDATE_CORE, SO_LIB, pMSDownloadType};
    }

    public PMSDownloadType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PMSDownloadType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PMSDownloadType) Enum.valueOf(PMSDownloadType.class, str) : (PMSDownloadType) invokeL.objValue;
    }

    public static PMSDownloadType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PMSDownloadType[]) $VALUES.clone() : (PMSDownloadType[]) invokeV.objValue;
    }
}
