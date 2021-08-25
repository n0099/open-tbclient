package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final double f41559a;

    /* renamed from: b  reason: collision with root package name */
    public final double f41560b;

    /* renamed from: c  reason: collision with root package name */
    public final double f41561c;

    /* renamed from: d  reason: collision with root package name */
    public final double f41562d;

    /* renamed from: e  reason: collision with root package name */
    public final double f41563e;

    /* renamed from: f  reason: collision with root package name */
    public final double f41564f;

    public h(double d2, double d3, double d4, double d5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41559a = d2;
        this.f41560b = d4;
        this.f41561c = d3;
        this.f41562d = d5;
        this.f41563e = (d2 + d3) / 2.0d;
        this.f41564f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? this.f41559a <= d2 && d2 <= this.f41561c && this.f41560b <= d3 && d3 <= this.f41562d : invokeCommon.booleanValue;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) ? d2 < this.f41561c && this.f41559a < d3 && d4 < this.f41562d && this.f41560b < d5 : invokeCommon.booleanValue;
    }

    public boolean a(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, point)) == null) ? a(point.x, point.y) : invokeL.booleanValue;
    }

    public boolean a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) ? a(hVar.f41559a, hVar.f41561c, hVar.f41560b, hVar.f41562d) : invokeL.booleanValue;
    }

    public boolean b(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? hVar.f41559a >= this.f41559a && hVar.f41561c <= this.f41561c && hVar.f41560b >= this.f41560b && hVar.f41562d <= this.f41562d : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("minX: " + this.f41559a);
            sb.append(" minY: " + this.f41560b);
            sb.append(" maxX: " + this.f41561c);
            sb.append(" maxY: " + this.f41562d);
            sb.append(" midX: " + this.f41563e);
            sb.append(" midY: " + this.f41564f);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
