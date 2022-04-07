package com.baidu.ar.databasic;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class ReserveHandleData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<byte[]> mByteArrayListData;
    public int mByteDataSize;
    public int[] mByteFormats;
    public int[] mByteHeights;
    public int[] mByteWidths;
    public List<char[]> mCharArrayListData;
    public int mCharDataSize;
    public List<double[]> mDoubleArrayListData;
    public int mDoubleDataSize;
    public List<float[]> mFloatArrayListData;
    public int mFloatDataSize;
    public List<int[]> mIntArrayListData;
    public int mIntDataSize;
    public List<long[]> mLongArrayListData;
    public int mLongDataSize;

    public ReserveHandleData() {
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

    public List<byte[]> getByteArrayListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mByteArrayListData : (List) invokeV.objValue;
    }

    public int getByteDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mByteDataSize : invokeV.intValue;
    }

    public int[] getByteFormats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mByteFormats : (int[]) invokeV.objValue;
    }

    public int[] getByteHeights() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mByteHeights : (int[]) invokeV.objValue;
    }

    public int[] getByteWidths() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mByteWidths : (int[]) invokeV.objValue;
    }

    public List<char[]> getCharArrayListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCharArrayListData : (List) invokeV.objValue;
    }

    public int getCharDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCharDataSize : invokeV.intValue;
    }

    public List<double[]> getDoubleArrayListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mDoubleArrayListData : (List) invokeV.objValue;
    }

    public int getDoubleDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mDoubleDataSize : invokeV.intValue;
    }

    public List<float[]> getFloatArrayListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mFloatArrayListData : (List) invokeV.objValue;
    }

    public int getFloatDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mFloatDataSize : invokeV.intValue;
    }

    public List<int[]> getIntArrayListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIntArrayListData : (List) invokeV.objValue;
    }

    public int getIntDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIntDataSize : invokeV.intValue;
    }

    public List<long[]> getLongArrayListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mLongArrayListData : (List) invokeV.objValue;
    }

    public int getLongDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mLongDataSize : invokeV.intValue;
    }

    public void setByteArrayListData(List<byte[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.mByteArrayListData = list;
        }
    }

    public void setByteDataSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mByteDataSize = i;
        }
    }

    public void setByteFormats(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iArr) == null) {
            this.mByteFormats = iArr;
        }
    }

    public void setByteHeights(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iArr) == null) {
            this.mByteHeights = iArr;
        }
    }

    public void setByteWidths(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iArr) == null) {
            this.mByteWidths = iArr;
        }
    }

    public void setCharArrayListData(List<char[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            this.mCharArrayListData = list;
        }
    }

    public void setCharDataSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.mCharDataSize = i;
        }
    }

    public void setDoubleArrayListData(List<double[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            this.mDoubleArrayListData = list;
        }
    }

    public void setDoubleDataSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.mDoubleDataSize = i;
        }
    }

    public void setFloatArrayListData(List<float[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            this.mFloatArrayListData = list;
        }
    }

    public void setFloatDataSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mFloatDataSize = i;
        }
    }

    public void setIntArrayListData(List<int[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            this.mIntArrayListData = list;
        }
    }

    public void setIntDataSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mIntDataSize = i;
        }
    }

    public void setLongArrayListData(List<long[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            this.mLongArrayListData = list;
        }
    }

    public void setLongDataSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.mLongDataSize = i;
        }
    }
}
