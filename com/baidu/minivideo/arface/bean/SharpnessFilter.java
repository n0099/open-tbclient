package com.baidu.minivideo.arface.bean;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class SharpnessFilter implements FilterParam {
    public static final /* synthetic */ SharpnessFilter[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SharpnessFilter sharpness;
    public transient /* synthetic */ FieldHolder $fh;
    public String mParamName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1995826905, "Lcom/baidu/minivideo/arface/bean/SharpnessFilter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1995826905, "Lcom/baidu/minivideo/arface/bean/SharpnessFilter;");
                return;
            }
        }
        SharpnessFilter sharpnessFilter = new SharpnessFilter("sharpness", 0, "intensity_sharpness");
        sharpness = sharpnessFilter;
        $VALUES = new SharpnessFilter[]{sharpnessFilter};
    }

    public SharpnessFilter(String str, int i, String str2) {
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
        this.mParamName = str2;
    }

    public static SharpnessFilter valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SharpnessFilter) Enum.valueOf(SharpnessFilter.class, str) : (SharpnessFilter) invokeL.objValue;
    }

    public static SharpnessFilter[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SharpnessFilter[]) $VALUES.clone() : (SharpnessFilter[]) invokeV.objValue;
    }

    @Override // com.baidu.ar.filter.FilterParam
    public FilterNode getFilterNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FilterNode.skinFilter : (FilterNode) invokeV.objValue;
    }

    @Override // com.baidu.ar.filter.FilterParam
    public String getParamName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mParamName : (String) invokeV.objValue;
    }
}
