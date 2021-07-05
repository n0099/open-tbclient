package com.alibaba.fastjson.asm;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.ASMUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TypeCollector {
    public static /* synthetic */ Interceptable $ic;
    public static String JSONType;
    public static final Map<String, String> primitives;
    public transient /* synthetic */ FieldHolder $fh;
    public MethodCollector collector;
    public boolean jsonType;
    public final String methodName;
    public final Class<?>[] parameterTypes;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1460294522, "Lcom/alibaba/fastjson/asm/TypeCollector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1460294522, "Lcom/alibaba/fastjson/asm/TypeCollector;");
                return;
            }
        }
        JSONType = ASMUtils.desc(JSONType.class);
        primitives = new HashMap<String, String>() { // from class: com.alibaba.fastjson.asm.TypeCollector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("int", "I");
                put("boolean", "Z");
                put("byte", "B");
                put("char", "C");
                put("short", "S");
                put(ShaderParams.VALUE_TYPE_FLOAT, "F");
                put("long", "J");
                put("double", "D");
            }
        };
    }

    public TypeCollector(String str, Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, clsArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.methodName = str;
        this.parameterTypes = clsArr;
        this.collector = null;
    }

    private boolean correctTypeName(Type type, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, type, str)) == null) {
            String className = type.getClassName();
            StringBuilder sb = new StringBuilder();
            while (className.endsWith("[]")) {
                sb.append('[');
                className = className.substring(0, className.length() - 2);
            }
            if (sb.length() != 0) {
                if (primitives.containsKey(className)) {
                    sb.append(primitives.get(className));
                    className = sb.toString();
                } else {
                    sb.append('L');
                    sb.append(className);
                    sb.append(';');
                    className = sb.toString();
                }
            }
            return className.equals(str);
        }
        return invokeLL.booleanValue;
    }

    public String[] getParameterNamesForMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MethodCollector methodCollector = this.collector;
            return (methodCollector == null || !methodCollector.debugInfoPresent) ? new String[0] : methodCollector.getResult().split(",");
        }
        return (String[]) invokeV.objValue;
    }

    public boolean hasJsonType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.jsonType : invokeV.booleanValue;
    }

    public boolean matched() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.collector != null : invokeV.booleanValue;
    }

    public void visitAnnotation(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && JSONType.equals(str)) {
            this.jsonType = true;
        }
    }

    public MethodCollector visitMethod(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, str, str2)) == null) {
            if (this.collector == null && str.equals(this.methodName)) {
                Type[] argumentTypes = Type.getArgumentTypes(str2);
                int i3 = 0;
                for (Type type : argumentTypes) {
                    String className = type.getClassName();
                    if (className.equals("long") || className.equals("double")) {
                        i3++;
                    }
                }
                if (argumentTypes.length != this.parameterTypes.length) {
                    return null;
                }
                for (int i4 = 0; i4 < argumentTypes.length; i4++) {
                    if (!correctTypeName(argumentTypes[i4], this.parameterTypes[i4].getName())) {
                        return null;
                    }
                }
                MethodCollector methodCollector = new MethodCollector(!Modifier.isStatic(i2) ? 1 : 0, argumentTypes.length + i3);
                this.collector = methodCollector;
                return methodCollector;
            }
            return null;
        }
        return (MethodCollector) invokeILL.objValue;
    }
}
