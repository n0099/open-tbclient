package com.baidu.mapapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class MyLocationData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float accuracy;
    public final float direction;
    public final double latitude;
    public final double longitude;
    public final int satellitesNum;
    public final float speed;

    /* loaded from: classes8.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public double f35917b;

        /* renamed from: c  reason: collision with root package name */
        public float f35918c;

        /* renamed from: d  reason: collision with root package name */
        public float f35919d;

        /* renamed from: e  reason: collision with root package name */
        public float f35920e;

        /* renamed from: f  reason: collision with root package name */
        public int f35921f;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Builder accuracy(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                this.f35920e = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public MyLocationData build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new MyLocationData(this.a, this.f35917b, this.f35918c, this.f35919d, this.f35920e, this.f35921f) : (MyLocationData) invokeV.objValue;
        }

        public Builder direction(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                this.f35919d = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder latitude(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
                this.a = d2;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder longitude(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)})) == null) {
                this.f35917b = d2;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder satellitesNum(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f35921f = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder speed(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
                this.f35918c = f2;
                return this;
            }
            return (Builder) invokeF.objValue;
        }
    }

    public MyLocationData(double d2, double d3, float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.latitude = d2;
        this.longitude = d3;
        this.speed = f2;
        this.direction = f3;
        this.accuracy = f4;
        this.satellitesNum = i2;
    }
}
