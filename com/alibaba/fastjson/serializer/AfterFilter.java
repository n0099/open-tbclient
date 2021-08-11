package com.alibaba.fastjson.serializer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.IdentityHashMap;
/* loaded from: classes4.dex */
public abstract class AfterFilter implements SerializeFilter {
    public static /* synthetic */ Interceptable $ic;
    public static final Character COMMA;
    public static final ThreadLocal<Character> seperatorLocal;
    public static final ThreadLocal<JSONSerializer> serializerLocal;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1362010470, "Lcom/alibaba/fastjson/serializer/AfterFilter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1362010470, "Lcom/alibaba/fastjson/serializer/AfterFilter;");
                return;
            }
        }
        serializerLocal = new ThreadLocal<>();
        seperatorLocal = new ThreadLocal<>();
        COMMA = ',';
    }

    public AfterFilter() {
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

    public final char writeAfter(JSONSerializer jSONSerializer, Object obj, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, Character.valueOf(c2)})) == null) {
            serializerLocal.set(jSONSerializer);
            seperatorLocal.set(Character.valueOf(c2));
            writeAfter(obj);
            serializerLocal.set(serializerLocal.get());
            return seperatorLocal.get().charValue();
        }
        return invokeCommon.charValue;
    }

    public abstract void writeAfter(Object obj);

    public final void writeKeyValue(String str, Object obj) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
            JSONSerializer jSONSerializer = serializerLocal.get();
            char charValue = seperatorLocal.get().charValue();
            boolean containsReference = jSONSerializer.containsReference(obj);
            jSONSerializer.writeKeyValue(charValue, str, obj);
            if (!containsReference && (identityHashMap = jSONSerializer.references) != null) {
                identityHashMap.remove(obj);
            }
            if (charValue != ',') {
                seperatorLocal.set(COMMA);
            }
        }
    }
}
