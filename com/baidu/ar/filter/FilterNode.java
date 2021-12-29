package com.baidu.ar.filter;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class FilterNode {
    public static final /* synthetic */ FilterNode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FilterNode faceFilter;
    public static final FilterNode lutFilter;
    public static final FilterNode makeupFilter;
    public static final FilterNode skinFilter;
    public static final FilterNode tuneColorFilter;
    public transient /* synthetic */ FieldHolder $fh;
    public String mNodeName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1704173050, "Lcom/baidu/ar/filter/FilterNode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1704173050, "Lcom/baidu/ar/filter/FilterNode;");
                return;
            }
        }
        lutFilter = new FilterNode("lutFilter", 0, "globalLutFilter");
        skinFilter = new FilterNode("skinFilter", 1, "globalSkinFilter");
        faceFilter = new FilterNode("faceFilter", 2, "globalFaceFilter");
        makeupFilter = new FilterNode("makeupFilter", 3, "globalBeautyMakeupFilter");
        FilterNode filterNode = new FilterNode("tuneColorFilter", 4, "globalTuneColorFilter");
        tuneColorFilter = filterNode;
        $VALUES = new FilterNode[]{lutFilter, skinFilter, faceFilter, makeupFilter, filterNode};
    }

    public FilterNode(String str, int i2, String str2) {
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
        this.mNodeName = str2;
    }

    public static FilterNode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FilterNode) Enum.valueOf(FilterNode.class, str) : (FilterNode) invokeL.objValue;
    }

    public static FilterNode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FilterNode[]) $VALUES.clone() : (FilterNode[]) invokeV.objValue;
    }

    public String getNodeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mNodeName : (String) invokeV.objValue;
    }
}
