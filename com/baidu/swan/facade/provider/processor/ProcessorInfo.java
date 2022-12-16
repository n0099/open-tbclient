package com.baidu.swan.facade.provider.processor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kq3;
import com.baidu.tieba.lq3;
import com.baidu.tieba.mq3;
import com.baidu.tieba.nq3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class ProcessorInfo {
    public static final /* synthetic */ ProcessorInfo[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ProcessorInfo FAVORITE;
    public static final ProcessorInfo HISTORY;
    public static final ProcessorInfo PARAMS;
    public transient /* synthetic */ FieldHolder $fh;
    public Class<? extends kq3> mClass;
    public int mMatcherCode;
    public String mPath;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(951761841, "Lcom/baidu/swan/facade/provider/processor/ProcessorInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(951761841, "Lcom/baidu/swan/facade/provider/processor/ProcessorInfo;");
                return;
            }
        }
        PARAMS = new ProcessorInfo("PARAMS", 0, nq3.class, "params");
        FAVORITE = new ProcessorInfo("FAVORITE", 1, lq3.class, "favorite");
        ProcessorInfo processorInfo = new ProcessorInfo("HISTORY", 2, mq3.class, "history");
        HISTORY = processorInfo;
        $VALUES = new ProcessorInfo[]{PARAMS, FAVORITE, processorInfo};
    }

    public ProcessorInfo(String str, int i, Class cls, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), cls, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mClass = cls;
        this.mPath = str2;
        this.mMatcherCode = ordinal();
    }

    private Class<? extends kq3> getProcessorClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return this.mClass;
        }
        return (Class) invokeV.objValue;
    }

    public static ProcessorInfo[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return (ProcessorInfo[]) $VALUES.clone();
        }
        return (ProcessorInfo[]) invokeV.objValue;
    }

    public int getMatcherCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mMatcherCode;
        }
        return invokeV.intValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mPath;
        }
        return (String) invokeV.objValue;
    }

    public static Class<? extends kq3> getProcessorClass(int i) {
        InterceptResult invokeI;
        ProcessorInfo[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            for (ProcessorInfo processorInfo : values()) {
                if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                    return processorInfo.getProcessorClass();
                }
            }
            return null;
        }
        return (Class) invokeI.objValue;
    }

    public static ProcessorInfo valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return (ProcessorInfo) Enum.valueOf(ProcessorInfo.class, str);
        }
        return (ProcessorInfo) invokeL.objValue;
    }
}
