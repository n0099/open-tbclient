package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "Point")
/* loaded from: classes3.dex */
public class Point extends Geometry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double latitude;
    public double longitude;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Point() {
        super("Point");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public double[] getCoordinates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new double[]{this.longitude, this.latitude} : (double[]) invokeV.objValue;
    }

    @JSONField(serialize = false)
    public double getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.latitude : invokeV.doubleValue;
    }

    @JSONField(serialize = false)
    public double getLongitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.longitude : invokeV.doubleValue;
    }

    public void setCoordinates(double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dArr) == null) {
            if (dArr != null && dArr.length != 0) {
                if (dArr.length == 1) {
                    this.longitude = dArr[0];
                    return;
                }
                this.longitude = dArr[0];
                this.latitude = dArr[1];
                return;
            }
            this.longitude = 0.0d;
            this.latitude = 0.0d;
        }
    }

    @JSONField(deserialize = false)
    public void setLatitude(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.latitude = d2;
        }
    }

    @JSONField(deserialize = false)
    public void setLongitude(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.longitude = d2;
        }
    }
}
