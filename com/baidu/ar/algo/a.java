package com.baidu.ar.algo;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a bV;
    public static a bW;
    public static a bX;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] bY;
    public float[] bZ;
    public boolean ca;
    public int height;
    public float scale;
    public int width;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2138763546, "Lcom/baidu/ar/algo/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2138763546, "Lcom/baidu/ar/algo/a;");
                return;
            }
        }
        a aVar = new a();
        bV = aVar;
        aVar.width = 1280;
        aVar.height = 720;
        aVar.ca = true;
        aVar.bY = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        aVar.bZ = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        a aVar2 = new a();
        bW = aVar2;
        aVar2.width = 640;
        aVar2.height = 480;
        bV.ca = true;
        aVar2.bY = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        aVar2.bZ = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        a aVar3 = new a();
        bX = aVar3;
        aVar3.width = 640;
        aVar3.height = 360;
        aVar3.ca = true;
        aVar3.bY = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        aVar3.bZ = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.scale = 1.0f;
        this.ca = false;
    }

    public a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.scale = 1.0f;
        this.ca = false;
        this.width = i;
        this.height = i2;
        this.scale = i > 640 ? 0.5f : 1.0f;
    }

    public static a a(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                a aVar2 = new a(i, i2);
                float f = i;
                a aVar3 = bX;
                if (Math.abs((f / i2) - (aVar3.width / aVar3.height)) < 0.03d) {
                    aVar2.a(bX, f / aVar.width);
                }
                return aVar2;
            }
            return b(i, i2);
        }
        return (a) invokeCommon.objValue;
    }

    private void a(a aVar, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, f) == null) {
            this.bY = new float[9];
            this.bZ = new float[5];
            this.ca = true;
            for (int i = 0; i < 8; i++) {
                this.bY[i] = aVar.bY[i] * f;
            }
            for (int i2 = 0; i2 < 5; i2++) {
                this.bZ[i2] = aVar.bZ[i2];
            }
        }
    }

    public static a b(int i, int i2) {
        InterceptResult invokeII;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            a aVar2 = new a(i, i2);
            float f = i;
            float f2 = f / i2;
            a aVar3 = bV;
            if (Math.abs(f2 - (aVar3.width / aVar3.height)) < 0.03d) {
                aVar = bV;
            } else {
                a aVar4 = bW;
                if (Math.abs(f2 - (aVar4.width / aVar4.height)) >= 0.03d) {
                    return aVar2;
                }
                aVar = bW;
            }
            aVar2.a(aVar, f / aVar.width);
            return aVar2;
        }
        return (a) invokeII.objValue;
    }

    public float[] aj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bY : (float[]) invokeV.objValue;
    }

    public float[] ak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bZ : (float[]) invokeV.objValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1.0f;
        }
        return invokeV.floatValue;
    }
}
