package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c1;
import com.baidu.tieba.e2;
import com.baidu.tieba.h2;
import com.baidu.tieba.r2;
import com.baidu.tieba.y0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class Cubemap extends h2 {
    public static /* synthetic */ Interceptable $ic;
    public static c1 j;
    public static final Map<Application, r2<Cubemap>> k;
    public transient /* synthetic */ FieldHolder $fh;
    public e2 i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class CubemapSide {
        public static final /* synthetic */ CubemapSide[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CubemapSide NegativeX;
        public static final CubemapSide NegativeY;
        public static final CubemapSide NegativeZ;
        public static final CubemapSide PositiveX;
        public static final CubemapSide PositiveY;
        public static final CubemapSide PositiveZ;
        public transient /* synthetic */ FieldHolder $fh;
        public final Vector3 direction;
        public final int glEnum;
        public final int index;
        public final Vector3 up;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1498807662, "Lcom/badlogic/gdx/graphics/Cubemap$CubemapSide;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1498807662, "Lcom/badlogic/gdx/graphics/Cubemap$CubemapSide;");
                    return;
                }
            }
            PositiveX = new CubemapSide("PositiveX", 0, 0, 34069, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f);
            NegativeX = new CubemapSide("NegativeX", 1, 1, 34070, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f);
            PositiveY = new CubemapSide("PositiveY", 2, 2, 34071, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
            NegativeY = new CubemapSide("NegativeY", 3, 3, 34072, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f);
            PositiveZ = new CubemapSide("PositiveZ", 4, 4, 34073, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
            CubemapSide cubemapSide = new CubemapSide("NegativeZ", 5, 5, 34074, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f);
            NegativeZ = cubemapSide;
            $VALUES = new CubemapSide[]{PositiveX, NegativeX, PositiveY, NegativeY, PositiveZ, cubemapSide};
        }

        public CubemapSide(String str, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r5;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.index = i2;
            this.glEnum = i3;
            this.up = new Vector3(f, f2, f3);
            this.direction = new Vector3(f4, f5, f6);
        }

        public static CubemapSide valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CubemapSide) Enum.valueOf(CubemapSide.class, str);
            }
            return (CubemapSide) invokeL.objValue;
        }

        public Vector3 getDirection(Vector3 vector3) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vector3)) == null) {
                return vector3.set(this.direction);
            }
            return (Vector3) invokeL.objValue;
        }

        public Vector3 getUp(Vector3 vector3) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vector3)) == null) {
                return vector3.set(this.up);
            }
            return (Vector3) invokeL.objValue;
        }

        public static CubemapSide[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CubemapSide[]) $VALUES.clone();
            }
            return (CubemapSide[]) invokeV.objValue;
        }

        public int getGLEnum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.glEnum;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-422319640, "Lcom/badlogic/gdx/graphics/Cubemap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-422319640, "Lcom/badlogic/gdx/graphics/Cubemap;");
                return;
            }
        }
        k = new HashMap();
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i.a();
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (p()) {
                this.b = y0.c.a();
                q(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged Cubemap");
        }
    }

    public static void m(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            k.remove(application);
        }
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed cubemap/app: { ");
            for (Application application : k.keySet()) {
                sb.append(k.get(application).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void o(Application application) {
        r2<Cubemap> r2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, application) != null) || (r2Var = k.get(application)) == null) {
            return;
        }
        c1 c1Var = j;
        if (c1Var == null) {
            for (int i = 0; i < r2Var.b; i++) {
                r2Var.get(i).r();
            }
            return;
        }
        c1Var.b();
        r2<? extends Cubemap> r2Var2 = new r2<>(r2Var);
        r2.b<? extends Cubemap> it = r2Var2.iterator();
        if (!it.hasNext()) {
            r2Var.clear();
            r2Var.b(r2Var2);
            return;
        }
        j.c(it.next());
        throw null;
    }

    @Override // com.baidu.tieba.h2, com.baidu.tieba.v2
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b == 0) {
            return;
        }
        c();
        if (this.i.a() && k.get(y0.a) != null) {
            k.get(y0.a).g(this, true);
        }
    }

    public void q(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            if (!e2Var.isPrepared()) {
                e2Var.prepare();
            }
            b();
            i(this.c, this.d, true);
            j(this.e, this.f, true);
            h(this.g, true);
            e2Var.b();
            y0.c.F(this.a, 0);
        }
    }
}
