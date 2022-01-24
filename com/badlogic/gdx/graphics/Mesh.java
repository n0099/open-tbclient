package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import c.b.b.n.i;
import c.b.b.n.j;
import c.b.b.n.m.d;
import c.b.b.n.m.e;
import c.b.b.n.m.f;
import c.b.b.n.m.k;
import c.b.b.n.m.l;
import c.b.b.q.a;
import c.b.b.q.h;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.UShort;
/* loaded from: classes9.dex */
public class Mesh implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Map<Application, a<Mesh>> f31098i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final l f31099e;

    /* renamed from: f  reason: collision with root package name */
    public final e f31100f;

    /* renamed from: g  reason: collision with root package name */
    public f f31101g;

    /* renamed from: h  reason: collision with root package name */
    public final Vector3 f31102h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class VertexDataType {
        public static final /* synthetic */ VertexDataType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VertexDataType VertexArray;
        public static final VertexDataType VertexBufferObject;
        public static final VertexDataType VertexBufferObjectSubData;
        public static final VertexDataType VertexBufferObjectWithVAO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1413899376, "Lcom/badlogic/gdx/graphics/Mesh$VertexDataType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1413899376, "Lcom/badlogic/gdx/graphics/Mesh$VertexDataType;");
                    return;
                }
            }
            VertexArray = new VertexDataType("VertexArray", 0);
            VertexBufferObject = new VertexDataType("VertexBufferObject", 1);
            VertexBufferObjectSubData = new VertexDataType("VertexBufferObjectSubData", 2);
            VertexDataType vertexDataType = new VertexDataType("VertexBufferObjectWithVAO", 3);
            VertexBufferObjectWithVAO = vertexDataType;
            $VALUES = new VertexDataType[]{VertexArray, VertexBufferObject, VertexBufferObjectSubData, vertexDataType};
        }

        public VertexDataType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static VertexDataType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VertexDataType) Enum.valueOf(VertexDataType.class, str) : (VertexDataType) invokeL.objValue;
        }

        public static VertexDataType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VertexDataType[]) $VALUES.clone() : (VertexDataType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1277023898, "Lcom/badlogic/gdx/graphics/Mesh;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1277023898, "Lcom/badlogic/gdx/graphics/Mesh;");
                return;
            }
        }
        f31098i = new HashMap();
    }

    public Mesh(boolean z, int i2, int i3, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31102h = new Vector3();
        this.f31099e = o(z, i2, jVar);
        this.f31100f = new d(z, i3);
        a(c.b.b.f.a, this);
    }

    public static void a(Application application, Mesh mesh) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, mesh) == null) {
            a<Mesh> aVar = f31098i.get(application);
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.a(mesh);
            f31098i.put(application, aVar);
        }
    }

    public static void g(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            f31098i.remove(application);
        }
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed meshes/app: { ");
            for (Application application : f31098i.keySet()) {
                sb.append(f31098i.get(application).f27389f);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void n(Application application) {
        a<Mesh> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, application) == null) || (aVar = f31098i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < aVar.f27389f; i2++) {
            aVar.get(i2).f31099e.invalidate();
            aVar.get(i2).f31100f.invalidate();
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31099e.c() : invokeV.intValue;
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f31098i.get(c.b.b.f.a) != null) {
                f31098i.get(c.b.b.f.a).i(this, true);
            }
            this.f31099e.dispose();
            f fVar = this.f31101g;
            if (fVar != null) {
                fVar.dispose();
            }
            this.f31100f.dispose();
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31100f.e() : invokeV.intValue;
    }

    public BoundingBox f(BoundingBox boundingBox, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, boundingBox, i2, i3)) == null) {
            BoundingBox inf = boundingBox.inf();
            h(inf, i2, i3);
            return inf;
        }
        return (BoundingBox) invokeLII.objValue;
    }

    public BoundingBox h(BoundingBox boundingBox, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, boundingBox, i2, i3)) == null) {
            i(boundingBox, i2, i3, null);
            return boundingBox;
        }
        return (BoundingBox) invokeLII.objValue;
    }

    public BoundingBox i(BoundingBox boundingBox, int i2, int i3, Matrix4 matrix4) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{boundingBox, Integer.valueOf(i2), Integer.valueOf(i3), matrix4})) == null) {
            int e2 = e();
            int c2 = c();
            if (e2 != 0) {
                c2 = e2;
            }
            if (i2 >= 0 && i3 >= 1 && (i4 = i2 + i3) <= c2) {
                FloatBuffer buffer = this.f31099e.getBuffer();
                ShortBuffer buffer2 = this.f31100f.getBuffer();
                i l = l(1);
                int i5 = l.f27122e / 4;
                int i6 = this.f31099e.b().f27127f / 4;
                int i7 = l.f27119b;
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (e2 > 0) {
                                while (i2 < i4) {
                                    int i8 = ((buffer2.get(i2) & UShort.MAX_VALUE) * i6) + i5;
                                    this.f31102h.set(buffer.get(i8), buffer.get(i8 + 1), buffer.get(i8 + 2));
                                    if (matrix4 != null) {
                                        this.f31102h.mul(matrix4);
                                    }
                                    boundingBox.ext(this.f31102h);
                                    i2++;
                                }
                            } else {
                                while (i2 < i4) {
                                    int i9 = (i2 * i6) + i5;
                                    this.f31102h.set(buffer.get(i9), buffer.get(i9 + 1), buffer.get(i9 + 2));
                                    if (matrix4 != null) {
                                        this.f31102h.mul(matrix4);
                                    }
                                    boundingBox.ext(this.f31102h);
                                    i2++;
                                }
                            }
                        }
                    } else if (e2 > 0) {
                        while (i2 < i4) {
                            int i10 = ((buffer2.get(i2) & UShort.MAX_VALUE) * i6) + i5;
                            this.f31102h.set(buffer.get(i10), buffer.get(i10 + 1), 0.0f);
                            if (matrix4 != null) {
                                this.f31102h.mul(matrix4);
                            }
                            boundingBox.ext(this.f31102h);
                            i2++;
                        }
                    } else {
                        while (i2 < i4) {
                            int i11 = (i2 * i6) + i5;
                            this.f31102h.set(buffer.get(i11), buffer.get(i11 + 1), 0.0f);
                            if (matrix4 != null) {
                                this.f31102h.mul(matrix4);
                            }
                            boundingBox.ext(this.f31102h);
                            i2++;
                        }
                    }
                } else if (e2 > 0) {
                    while (i2 < i4) {
                        this.f31102h.set(buffer.get(((buffer2.get(i2) & UShort.MAX_VALUE) * i6) + i5), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.f31102h.mul(matrix4);
                        }
                        boundingBox.ext(this.f31102h);
                        i2++;
                    }
                } else {
                    while (i2 < i4) {
                        this.f31102h.set(buffer.get((i2 * i6) + i5), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.f31102h.mul(matrix4);
                        }
                        boundingBox.ext(this.f31102h);
                        i2++;
                    }
                }
                return boundingBox;
            }
            throw new GdxRuntimeException("Invalid part specified ( offset=" + i2 + ", count=" + i3 + ", max=" + c2 + " )");
        }
        return (BoundingBox) invokeCommon.objValue;
    }

    public ShortBuffer j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31100f.getBuffer() : (ShortBuffer) invokeV.objValue;
    }

    public i l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            j b2 = this.f31099e.b();
            int size = b2.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (b2.d(i3).a == i2) {
                    return b2.d(i3);
                }
            }
            return null;
        }
        return (i) invokeI.objValue;
    }

    public FloatBuffer m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31099e.getBuffer() : (FloatBuffer) invokeV.objValue;
    }

    public final l o(boolean z, int i2, j jVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), jVar})) == null) {
            if (c.b.b.f.f26969g != null) {
                return new k(z, i2, jVar);
            }
            return new c.b.b.n.m.j(z, i2, jVar);
        }
        return (l) invokeCommon.objValue;
    }
}
