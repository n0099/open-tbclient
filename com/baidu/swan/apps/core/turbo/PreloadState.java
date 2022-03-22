package com.baidu.swan.apps.core.turbo;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class PreloadState {
    public static final /* synthetic */ PreloadState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PreloadState LOADED;
    public static final PreloadState LOADING;
    public static final PreloadState LOAD_FAILED;
    public static final PreloadState UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mStatsCodeForNormal;
    public final int mStatsCodeForReload;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(160109823, "Lcom/baidu/swan/apps/core/turbo/PreloadState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(160109823, "Lcom/baidu/swan/apps/core/turbo/PreloadState;");
                return;
            }
        }
        UNKNOWN = new PreloadState(RomUtils.UNKNOWN, 0, 0, 0);
        LOADED = new PreloadState("LOADED", 1, 1, 5);
        LOAD_FAILED = new PreloadState("LOAD_FAILED", 2, 2, 6);
        PreloadState preloadState = new PreloadState("LOADING", 3, 3, 4);
        LOADING = preloadState;
        $VALUES = new PreloadState[]{UNKNOWN, LOADED, LOAD_FAILED, preloadState};
    }

    public PreloadState(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
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
        this.mStatsCodeForNormal = i2;
        this.mStatsCodeForReload = i3;
    }

    public static PreloadState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PreloadState) Enum.valueOf(PreloadState.class, str) : (PreloadState) invokeL.objValue;
    }

    public static PreloadState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PreloadState[]) $VALUES.clone() : (PreloadState[]) invokeV.objValue;
    }

    public int statsCode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? z ? this.mStatsCodeForReload : this.mStatsCodeForNormal : invokeZ.intValue;
    }
}
