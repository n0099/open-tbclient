package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final double f7194a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7195b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7196c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7197d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7198e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7199f;

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
        this.f7194a = d2;
        this.f7195b = d4;
        this.f7196c = d3;
        this.f7197d = d5;
        this.f7198e = (d2 + d3) / 2.0d;
        this.f7199f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? this.f7194a <= d2 && d2 <= this.f7196c && this.f7195b <= d3 && d3 <= this.f7197d : invokeCommon.booleanValue;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) ? d2 < this.f7196c && this.f7194a < d3 && d4 < this.f7197d && this.f7195b < d5 : invokeCommon.booleanValue;
    }

    public boolean a(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, point)) == null) ? a(point.x, point.y) : invokeL.booleanValue;
    }

    public boolean a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) ? a(hVar.f7194a, hVar.f7196c, hVar.f7195b, hVar.f7197d) : invokeL.booleanValue;
    }

    public boolean b(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? hVar.f7194a >= this.f7194a && hVar.f7196c <= this.f7196c && hVar.f7195b >= this.f7195b && hVar.f7197d <= this.f7197d : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("minX: " + this.f7194a);
            sb.append(" minY: " + this.f7195b);
            sb.append(" maxX: " + this.f7196c);
            sb.append(" maxY: " + this.f7197d);
            sb.append(" midX: " + this.f7198e);
            sb.append(" midY: " + this.f7199f);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
