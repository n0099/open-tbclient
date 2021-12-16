package com.alibaba.fastjson.serializer;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
/* loaded from: classes9.dex */
public class DoubleSerializer implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public static final DoubleSerializer instance;
    public transient /* synthetic */ FieldHolder $fh;
    public DecimalFormat decimalFormat;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1700015257, "Lcom/alibaba/fastjson/serializer/DoubleSerializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1700015257, "Lcom/alibaba/fastjson/serializer/DoubleSerializer;");
                return;
            }
        }
        instance = new DoubleSerializer();
    }

    public DoubleSerializer() {
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
        this.decimalFormat = null;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
                return;
            }
            double doubleValue = ((Double) obj).doubleValue();
            if (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue)) {
                DecimalFormat decimalFormat = this.decimalFormat;
                if (decimalFormat == null) {
                    serializeWriter.writeDouble(doubleValue, true);
                    return;
                } else {
                    serializeWriter.write(decimalFormat.format(doubleValue));
                    return;
                }
            }
            serializeWriter.writeNull();
        }
    }

    public DoubleSerializer(DecimalFormat decimalFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {decimalFormat};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.decimalFormat = null;
        this.decimalFormat = decimalFormat;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DoubleSerializer(String str) {
        this(new DecimalFormat(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((DecimalFormat) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
