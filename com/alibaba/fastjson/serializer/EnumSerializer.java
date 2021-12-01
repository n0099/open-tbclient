package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
/* loaded from: classes7.dex */
public class EnumSerializer implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public static final EnumSerializer instance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Member member;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1907453527, "Lcom/alibaba/fastjson/serializer/EnumSerializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1907453527, "Lcom/alibaba/fastjson/serializer/EnumSerializer;");
                return;
            }
        }
        instance = new EnumSerializer();
    }

    public EnumSerializer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.member = null;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            Member member = this.member;
            if (member == null) {
                jSONSerializer.out.writeEnum((Enum) obj);
                return;
            }
            try {
                if (member instanceof Field) {
                    invoke = ((Field) member).get(obj);
                } else {
                    invoke = ((Method) member).invoke(obj, new Object[0]);
                }
                jSONSerializer.write(invoke);
            } catch (Exception e2) {
                throw new JSONException("getEnumValue error", e2);
            }
        }
    }

    public EnumSerializer(Member member) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {member};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.member = member;
    }
}
