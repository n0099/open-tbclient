package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes9.dex */
public class AtomicCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1759093775, "Lcom/alibaba/fastjson/serializer/AtomicCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1759093775, "Lcom/alibaba/fastjson/serializer/AtomicCodec;");
                return;
            }
        }
        instance = new AtomicCodec();
    }

    public AtomicCodec() {
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

    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            if (defaultJSONParser.lexer.token() == 8) {
                defaultJSONParser.lexer.nextToken(16);
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            defaultJSONParser.parseArray(jSONArray);
            int i2 = 0;
            if (type == AtomicIntegerArray.class) {
                ?? r5 = (T) new AtomicIntegerArray(jSONArray.size());
                while (i2 < jSONArray.size()) {
                    r5.set(i2, jSONArray.getInteger(i2).intValue());
                    i2++;
                }
                return r5;
            }
            ?? r52 = (T) new AtomicLongArray(jSONArray.size());
            while (i2 < jSONArray.size()) {
                r52.set(i2, jSONArray.getLong(i2).longValue());
                i2++;
            }
            return r52;
        }
        return (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 14;
        }
        return invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj instanceof AtomicInteger) {
                serializeWriter.writeInt(((AtomicInteger) obj).get());
            } else if (obj instanceof AtomicLong) {
                serializeWriter.writeLong(((AtomicLong) obj).get());
            } else if (obj instanceof AtomicBoolean) {
                serializeWriter.append((CharSequence) (((AtomicBoolean) obj).get() ? "true" : "false"));
            } else if (obj == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            } else {
                int i3 = 0;
                if (obj instanceof AtomicIntegerArray) {
                    AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                    int length = atomicIntegerArray.length();
                    serializeWriter.write(91);
                    while (i3 < length) {
                        int i4 = atomicIntegerArray.get(i3);
                        if (i3 != 0) {
                            serializeWriter.write(44);
                        }
                        serializeWriter.writeInt(i4);
                        i3++;
                    }
                    serializeWriter.write(93);
                    return;
                }
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                int length2 = atomicLongArray.length();
                serializeWriter.write(91);
                while (i3 < length2) {
                    long j2 = atomicLongArray.get(i3);
                    if (i3 != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.writeLong(j2);
                    i3++;
                }
                serializeWriter.write(93);
            }
        }
    }
}
