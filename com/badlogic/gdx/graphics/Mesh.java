package com.badlogic.gdx.graphics;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a6;
import com.baidu.tieba.b6;
import com.baidu.tieba.b7;
import com.baidu.tieba.f1;
import com.baidu.tieba.i7;
import com.baidu.tieba.t3;
import com.baidu.tieba.t5;
import com.baidu.tieba.u3;
import com.baidu.tieba.u5;
import com.baidu.tieba.v5;
import com.baidu.tieba.z5;
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
/* loaded from: classes.dex */
public class Mesh implements i7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, b7<Mesh>> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final b6 a;
    public final u5 b;
    public v5 c;
    public final Vector3 d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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

        public VertexDataType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        e = new HashMap();
    }

    public Mesh(boolean z, int i, int i2, u3 u3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), u3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new Vector3();
        this.a = o(z, i, u3Var);
        this.b = new t5(z, i2);
        a(f1.a, this);
    }

    public static void a(Application application, Mesh mesh) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, mesh) == null) {
            b7<Mesh> b7Var = e.get(application);
            if (b7Var == null) {
                b7Var = new b7<>();
            }
            b7Var.a(mesh);
            e.put(application, b7Var);
        }
    }

    public static void g(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            e.remove(application);
        }
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed meshes/app: { ");
            for (Application application : e.keySet()) {
                sb.append(e.get(application).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void n(Application application) {
        b7<Mesh> b7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, application) == null) || (b7Var = e.get(application)) == null) {
            return;
        }
        for (int i = 0; i < b7Var.b; i++) {
            b7Var.get(i).a.invalidate();
            b7Var.get(i).b.invalidate();
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.c() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (e.get(f1.a) != null) {
                e.get(f1.a).j(this, true);
            }
            this.a.dispose();
            v5 v5Var = this.c;
            if (v5Var != null) {
                v5Var.dispose();
            }
            this.b.dispose();
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.e() : invokeV.intValue;
    }

    public BoundingBox f(BoundingBox boundingBox, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, boundingBox, i, i2)) == null) {
            BoundingBox inf = boundingBox.inf();
            h(inf, i, i2);
            return inf;
        }
        return (BoundingBox) invokeLII.objValue;
    }

    public BoundingBox h(BoundingBox boundingBox, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, boundingBox, i, i2)) == null) {
            i(boundingBox, i, i2, null);
            return boundingBox;
        }
        return (BoundingBox) invokeLII.objValue;
    }

    public BoundingBox i(BoundingBox boundingBox, int i, int i2, Matrix4 matrix4) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{boundingBox, Integer.valueOf(i), Integer.valueOf(i2), matrix4})) == null) {
            int e2 = e();
            int c = c();
            if (e2 != 0) {
                c = e2;
            }
            if (i >= 0 && i2 >= 1 && (i3 = i + i2) <= c) {
                FloatBuffer buffer = this.a.getBuffer();
                ShortBuffer buffer2 = this.b.getBuffer();
                t3 l = l(1);
                int i4 = l.e / 4;
                int i5 = this.a.b().b / 4;
                int i6 = l.b;
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (e2 > 0) {
                                while (i < i3) {
                                    int i7 = ((buffer2.get(i) & UShort.MAX_VALUE) * i5) + i4;
                                    this.d.set(buffer.get(i7), buffer.get(i7 + 1), buffer.get(i7 + 2));
                                    if (matrix4 != null) {
                                        this.d.mul(matrix4);
                                    }
                                    boundingBox.ext(this.d);
                                    i++;
                                }
                            } else {
                                while (i < i3) {
                                    int i8 = (i * i5) + i4;
                                    this.d.set(buffer.get(i8), buffer.get(i8 + 1), buffer.get(i8 + 2));
                                    if (matrix4 != null) {
                                        this.d.mul(matrix4);
                                    }
                                    boundingBox.ext(this.d);
                                    i++;
                                }
                            }
                        }
                    } else if (e2 > 0) {
                        while (i < i3) {
                            int i9 = ((buffer2.get(i) & UShort.MAX_VALUE) * i5) + i4;
                            this.d.set(buffer.get(i9), buffer.get(i9 + 1), 0.0f);
                            if (matrix4 != null) {
                                this.d.mul(matrix4);
                            }
                            boundingBox.ext(this.d);
                            i++;
                        }
                    } else {
                        while (i < i3) {
                            int i10 = (i * i5) + i4;
                            this.d.set(buffer.get(i10), buffer.get(i10 + 1), 0.0f);
                            if (matrix4 != null) {
                                this.d.mul(matrix4);
                            }
                            boundingBox.ext(this.d);
                            i++;
                        }
                    }
                } else if (e2 > 0) {
                    while (i < i3) {
                        this.d.set(buffer.get(((buffer2.get(i) & UShort.MAX_VALUE) * i5) + i4), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.d.mul(matrix4);
                        }
                        boundingBox.ext(this.d);
                        i++;
                    }
                } else {
                    while (i < i3) {
                        this.d.set(buffer.get((i * i5) + i4), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.d.mul(matrix4);
                        }
                        boundingBox.ext(this.d);
                        i++;
                    }
                }
                return boundingBox;
            }
            throw new GdxRuntimeException("Invalid part specified ( offset=" + i + ", count=" + i2 + ", max=" + c + " )");
        }
        return (BoundingBox) invokeCommon.objValue;
    }

    public ShortBuffer j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b.getBuffer() : (ShortBuffer) invokeV.objValue;
    }

    public t3 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            u3 b = this.a.b();
            int size = b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (b.c(i2).a == i) {
                    return b.c(i2);
                }
            }
            return null;
        }
        return (t3) invokeI.objValue;
    }

    public FloatBuffer m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getBuffer() : (FloatBuffer) invokeV.objValue;
    }

    public final b6 o(boolean z, int i, u3 u3Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), u3Var})) == null) {
            if (f1.g != null) {
                return new a6(z, i, u3Var);
            }
            return new z5(z, i, u3Var);
        }
        return (b6) invokeCommon.objValue;
    }
}
