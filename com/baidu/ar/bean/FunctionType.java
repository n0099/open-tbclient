package com.baidu.ar.bean;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class FunctionType {
    public static final /* synthetic */ FunctionType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FunctionType IMU;
    public static final FunctionType NONE;
    public static final FunctionType VIDEO;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2071932762, "Lcom/baidu/ar/bean/FunctionType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2071932762, "Lcom/baidu/ar/bean/FunctionType;");
                return;
            }
        }
        NONE = new FunctionType("NONE", 0, "none");
        VIDEO = new FunctionType(HlsPlaylistParser.TYPE_VIDEO, 1, "video");
        FunctionType functionType = new FunctionType("IMU", 2, ARPScriptEnvironment.KEY_DATA_PIP_IMU);
        IMU = functionType;
        $VALUES = new FunctionType[]{NONE, VIDEO, functionType};
    }

    public FunctionType(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mValue = str2;
    }

    public static FunctionType getValueOf(String str) {
        InterceptResult invokeL;
        FunctionType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return NONE;
            }
            for (FunctionType functionType : values()) {
                if (functionType.getValue().equalsIgnoreCase(str)) {
                    return functionType;
                }
            }
            return NONE;
        }
        return (FunctionType) invokeL.objValue;
    }

    public static FunctionType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FunctionType) Enum.valueOf(FunctionType.class, str) : (FunctionType) invokeL.objValue;
    }

    public static FunctionType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FunctionType[]) $VALUES.clone() : (FunctionType[]) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mValue : (String) invokeV.objValue;
    }
}
