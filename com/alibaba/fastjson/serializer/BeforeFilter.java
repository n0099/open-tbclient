package com.alibaba.fastjson.serializer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class BeforeFilter implements SerializeFilter {
    public static /* synthetic */ Interceptable $ic;
    public static final Character COMMA;
    public static final ThreadLocal<Character> seperatorLocal;
    public static final ThreadLocal<JSONSerializer> serializerLocal;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1964328965, "Lcom/alibaba/fastjson/serializer/BeforeFilter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1964328965, "Lcom/alibaba/fastjson/serializer/BeforeFilter;");
                return;
            }
        }
        serializerLocal = new ThreadLocal<>();
        seperatorLocal = new ThreadLocal<>();
        COMMA = ',';
    }

    public BeforeFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final char writeBefore(JSONSerializer jSONSerializer, Object obj, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, Character.valueOf(c2)})) == null) {
            serializerLocal.set(jSONSerializer);
            seperatorLocal.set(Character.valueOf(c2));
            writeBefore(obj);
            serializerLocal.set(serializerLocal.get());
            return seperatorLocal.get().charValue();
        }
        return invokeCommon.charValue;
    }

    public abstract void writeBefore(Object obj);

    public final void writeKeyValue(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
            JSONSerializer jSONSerializer = serializerLocal.get();
            char charValue = seperatorLocal.get().charValue();
            boolean containsKey = jSONSerializer.references.containsKey(obj);
            jSONSerializer.writeKeyValue(charValue, str, obj);
            if (!containsKey) {
                jSONSerializer.references.remove(obj);
            }
            if (charValue != ',') {
                seperatorLocal.set(COMMA);
            }
        }
    }
}
