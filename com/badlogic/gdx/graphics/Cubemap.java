package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import c.b.b.f;
import c.b.b.j.c;
import c.b.b.j.f.d;
import c.b.b.n.b;
import c.b.b.n.e;
import c.b.b.q.a;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class Cubemap extends e {
    public static /* synthetic */ Interceptable $ic;
    public static c.b.b.j.e n;
    public static final Map<Application, c.b.b.q.a<Cubemap>> o;
    public transient /* synthetic */ FieldHolder $fh;
    public b m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public CubemapSide(String str, int i2, int i3, int i4, float f2, float f3, float f4, float f5, float f6, float f7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r5;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.index = i3;
            this.glEnum = i4;
            this.up = new Vector3(f2, f3, f4);
            this.direction = new Vector3(f5, f6, f7);
        }

        public static CubemapSide valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CubemapSide) Enum.valueOf(CubemapSide.class, str) : (CubemapSide) invokeL.objValue;
        }

        public static CubemapSide[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CubemapSide[]) $VALUES.clone() : (CubemapSide[]) invokeV.objValue;
        }

        public Vector3 getDirection(Vector3 vector3) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vector3)) == null) ? vector3.set(this.direction) : (Vector3) invokeL.objValue;
        }

        public int getGLEnum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.glEnum : invokeV.intValue;
        }

        public Vector3 getUp(Vector3 vector3) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vector3)) == null) ? vector3.set(this.up) : (Vector3) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        @Override // c.b.b.j.c.a
        public void a(c.b.b.j.e eVar, String str, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, cls) == null) {
                eVar.A(str, this.a);
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
        o = new HashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cubemap(b bVar) {
        super(34067);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = bVar;
        y(bVar);
        if (bVar.b()) {
            s(f.a, this);
        }
    }

    public static void s(Application application, Cubemap cubemap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, cubemap) == null) {
            c.b.b.q.a<Cubemap> aVar = o.get(application);
            if (aVar == null) {
                aVar = new c.b.b.q.a<>();
            }
            aVar.a(cubemap);
            o.put(application, aVar);
        }
    }

    public static void t(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            o.remove(application);
        }
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed cubemap/app: { ");
            for (Application application : o.keySet()) {
                sb.append(o.get(application).f27499f);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void w(Application application) {
        c.b.b.q.a<Cubemap> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, application) == null) || (aVar = o.get(application)) == null) {
            return;
        }
        c.b.b.j.e eVar = n;
        if (eVar == null) {
            for (int i2 = 0; i2 < aVar.f27499f; i2++) {
                aVar.get(i2).z();
            }
            return;
        }
        eVar.h();
        c.b.b.q.a<? extends Cubemap> aVar2 = new c.b.b.q.a<>(aVar);
        a.b<? extends Cubemap> it = aVar2.iterator();
        while (it.hasNext()) {
            Cubemap next = it.next();
            String m = n.m(next);
            if (m == null) {
                next.z();
            } else {
                int q = n.q(m);
                n.A(m, 0);
                next.f27224f = 0;
                d.b bVar = new d.b();
                bVar.f27111d = next.u();
                bVar.f27112e = next.h();
                bVar.f27113f = next.f();
                bVar.f27114g = next.j();
                bVar.f27115h = next.k();
                bVar.f27110c = next;
                bVar.a = new a(q);
                n.C(m);
                next.f27224f = f.f27077e.a();
                n.w(m, Cubemap.class, bVar);
            }
        }
        aVar.clear();
        aVar.b(aVar2);
    }

    @Override // c.b.b.n.e, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27224f == 0) {
            return;
        }
        delete();
        if (!this.m.b() || o.get(f.a) == null) {
            return;
        }
        o.get(f.a).i(this, true);
    }

    public b u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (b) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m.b() : invokeV.booleanValue;
    }

    public void y(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (!bVar.a()) {
                bVar.prepare();
            }
            a();
            o(this.f27225g, this.f27226h, true);
            p(this.f27227i, this.f27228j, true);
            n(this.k, true);
            bVar.f();
            f.f27077e.N(this.f27223e, 0);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (x()) {
                this.f27224f = f.f27077e.a();
                y(this.m);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged Cubemap");
        }
    }
}
