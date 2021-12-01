package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Type;
@Deprecated
/* loaded from: classes7.dex */
public class MappingFastJsonValue implements JSONSerializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BrowserSecureMask;
    public static final String SECURITY_PREFIX = "/**/";
    public transient /* synthetic */ FieldHolder $fh;
    public String jsonpFunction;
    public Object value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1532124952, "Lcom/alibaba/fastjson/support/spring/MappingFastJsonValue;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1532124952, "Lcom/alibaba/fastjson/support/spring/MappingFastJsonValue;");
                return;
            }
        }
        BrowserSecureMask = SerializerFeature.BrowserSecure.mask;
    }

    public MappingFastJsonValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = obj;
    }

    public String getJsonpFunction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.jsonpFunction : (String) invokeV.objValue;
    }

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : invokeV.objValue;
    }

    public void setJsonpFunction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.jsonpFunction = str;
        }
    }

    public void setValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.value = obj;
        }
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(JSONSerializer jSONSerializer, Object obj, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, jSONSerializer, obj, type, i2) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (this.jsonpFunction == null) {
                jSONSerializer.write(this.value);
                return;
            }
            int i3 = BrowserSecureMask;
            if ((i2 & i3) != 0 || serializeWriter.isEnabled(i3)) {
                serializeWriter.write(SECURITY_PREFIX);
            }
            serializeWriter.write(this.jsonpFunction);
            serializeWriter.write(40);
            jSONSerializer.write(this.value);
            serializeWriter.write(41);
        }
    }
}
