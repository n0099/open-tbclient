package com.baidu.mobads.sdk.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class CPUAdType {
    public static final /* synthetic */ CPUAdType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CPUAdType FEED;
    public static final CPUAdType INTERSTITIAL;
    public static final CPUAdType OTHER;
    public static final CPUAdType REWARDVIDEO;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1169695695, "Lcom/baidu/mobads/sdk/api/CPUAdType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1169695695, "Lcom/baidu/mobads/sdk/api/CPUAdType;");
                return;
            }
        }
        FEED = new CPUAdType("FEED", 0, "feed");
        INTERSTITIAL = new CPUAdType("INTERSTITIAL", 1, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        REWARDVIDEO = new CPUAdType("REWARDVIDEO", 2, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
        CPUAdType cPUAdType = new CPUAdType("OTHER", 3, ExceptionHandlerImpl.KEY_CUSTOM);
        OTHER = cPUAdType;
        $VALUES = new CPUAdType[]{FEED, INTERSTITIAL, REWARDVIDEO, cPUAdType};
    }

    public CPUAdType(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
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
        this.value = str2;
    }

    public static CPUAdType parse(String str) {
        InterceptResult invokeL;
        CPUAdType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (CPUAdType cPUAdType : values()) {
                if (cPUAdType.value.equalsIgnoreCase(str)) {
                    return cPUAdType;
                }
            }
            return null;
        }
        return (CPUAdType) invokeL.objValue;
    }

    public static CPUAdType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CPUAdType) Enum.valueOf(CPUAdType.class, str);
        }
        return (CPUAdType) invokeL.objValue;
    }

    public static CPUAdType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CPUAdType[]) $VALUES.clone();
        }
        return (CPUAdType[]) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return (String) invokeV.objValue;
    }
}
