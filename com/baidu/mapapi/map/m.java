package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public m(double d, double d2, double d3, double d4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) {
            if (d < this.c && this.a < d2 && d3 < this.d && this.b < d4) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean a(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            if (this.a <= d && d <= this.c && this.b <= d2 && d2 <= this.d) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean a(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, point)) == null) {
            return a(point.x, point.y);
        }
        return invokeL.booleanValue;
    }

    public boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mVar)) == null) {
            return a(mVar.a, mVar.c, mVar.b, mVar.d);
        }
        return invokeL.booleanValue;
    }

    public boolean b(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mVar)) == null) {
            if (mVar.a >= this.a && mVar.c <= this.c && mVar.b >= this.b && mVar.d <= this.d) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("minX: " + this.a);
            sb.append(" minY: " + this.b);
            sb.append(" maxX: " + this.c);
            sb.append(" maxY: " + this.d);
            sb.append(" midX: " + this.e);
            sb.append(" midY: " + this.f);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
