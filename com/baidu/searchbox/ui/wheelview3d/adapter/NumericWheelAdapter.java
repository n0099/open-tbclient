package com.baidu.searchbox.ui.wheelview3d.adapter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NumericWheelAdapter implements WheelAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int maxValue;
    public int minValue;

    public NumericWheelAdapter(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.minValue = i2;
        this.maxValue = i3;
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0 && i2 < getItemsCount()) {
                return Integer.valueOf(this.minValue + i2);
            }
            return 0;
        }
        return invokeI.objValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.maxValue - this.minValue) + 1 : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            try {
                return ((Integer) obj).intValue() - this.minValue;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }
}
