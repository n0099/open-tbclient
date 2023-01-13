package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c7;
import com.baidu.tieba.g1;
import com.baidu.tieba.m1;
import com.baidu.tieba.n3;
import com.baidu.tieba.o1;
import com.baidu.tieba.q3;
import com.baidu.tieba.s1;
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
public class Cubemap extends q3 {
    public static /* synthetic */ Interceptable $ic;
    public static o1 j;
    public static final Map<Application, c7<Cubemap>> k;
    public transient /* synthetic */ FieldHolder $fh;
    public n3 i;

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

    /* loaded from: classes.dex */
    public static class a implements m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // com.baidu.tieba.m1.a
        public void a(o1 o1Var, String str, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, o1Var, str, cls) == null) {
                o1Var.A(str, this.a);
            }
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

    public n3 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return (n3) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i.a();
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (x()) {
                this.b = g1.e.a();
                y(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged Cubemap");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cubemap(n3 n3Var) {
        super(34067);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = n3Var;
        y(n3Var);
        if (n3Var.a()) {
            s(g1.a, this);
        }
    }

    public static void s(Application application, Cubemap cubemap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, cubemap) == null) {
            c7<Cubemap> c7Var = k.get(application);
            if (c7Var == null) {
                c7Var = new c7<>();
            }
            c7Var.a(cubemap);
            k.put(application, c7Var);
        }
    }

    public static void t(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            k.remove(application);
        }
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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

    public static void w(Application application) {
        c7<Cubemap> c7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, application) != null) || (c7Var = k.get(application)) == null) {
            return;
        }
        o1 o1Var = j;
        if (o1Var == null) {
            for (int i = 0; i < c7Var.b; i++) {
                c7Var.get(i).z();
            }
            return;
        }
        o1Var.h();
        c7<? extends Cubemap> c7Var2 = new c7<>(c7Var);
        c7.b<? extends Cubemap> it = c7Var2.iterator();
        while (it.hasNext()) {
            Cubemap next = it.next();
            String m = j.m(next);
            if (m == null) {
                next.z();
            } else {
                int q = j.q(m);
                j.A(m, 0);
                next.b = 0;
                s1.b bVar = new s1.b();
                bVar.d = next.u();
                bVar.e = next.h();
                bVar.f = next.f();
                bVar.g = next.j();
                bVar.h = next.k();
                bVar.c = next;
                bVar.a = new a(q);
                j.C(m);
                next.b = g1.e.a();
                j.w(m, Cubemap.class, bVar);
            }
        }
        c7Var.clear();
        c7Var.b(c7Var2);
    }

    @Override // com.baidu.tieba.q3, com.baidu.tieba.j7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b == 0) {
            return;
        }
        delete();
        if (this.i.a() && k.get(g1.a) != null) {
            k.get(g1.a).i(this, true);
        }
    }

    public void y(n3 n3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n3Var) == null) {
            if (!n3Var.isPrepared()) {
                n3Var.prepare();
            }
            a();
            o(this.c, this.d, true);
            p(this.e, this.f, true);
            n(this.g, true);
            n3Var.e();
            g1.e.N(this.a, 0);
        }
    }
}
