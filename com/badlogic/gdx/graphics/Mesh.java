package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.baidu.tieba.b3;
import com.baidu.tieba.c3;
import com.baidu.tieba.f3;
import com.baidu.tieba.h3;
import com.baidu.tieba.l3;
import com.baidu.tieba.o1;
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
public class Mesh implements l3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, h3<Mesh>> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final f3 a;
    public final b3 b;
    public c3 c;

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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (VertexDataType) Enum.valueOf(VertexDataType.class, str);
            }
            return (VertexDataType) invokeL.objValue;
        }

        public static VertexDataType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (VertexDataType[]) $VALUES.clone();
            }
            return (VertexDataType[]) invokeV.objValue;
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
        d = new HashMap();
    }

    public static void b(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            d.remove(application);
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed meshes/app: { ");
            for (Application application : d.keySet()) {
                sb.append(d.get(application).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Application application) {
        h3<Mesh> h3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, application) != null) || (h3Var = d.get(application)) == null) {
            return;
        }
        for (int i = 0; i < h3Var.b; i++) {
            h3Var.get(i).a.invalidate();
            h3Var.get(i).b.invalidate();
        }
    }

    @Override // com.baidu.tieba.l3
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.get(o1.a) != null) {
                d.get(o1.a).g(this, true);
            }
            this.a.dispose();
            c3 c3Var = this.c;
            if (c3Var != null) {
                c3Var.dispose();
            }
            this.b.dispose();
        }
    }
}
