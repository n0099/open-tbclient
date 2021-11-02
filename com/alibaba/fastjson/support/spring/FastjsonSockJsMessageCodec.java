package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;
/* loaded from: classes6.dex */
public class FastjsonSockJsMessageCodec extends AbstractSockJsMessageCodec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FastjsonSockJsMessageCodec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public char[] applyJsonQuoting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SerializeWriter serializeWriter = new SerializeWriter();
            try {
                new JSONSerializer(serializeWriter).write(str);
                return serializeWriter.toCharArrayForSpringWebSocket();
            } finally {
                serializeWriter.close();
            }
        }
        return (char[]) invokeL.objValue;
    }

    public String[] decode(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (String[]) JSON.parseObject(str, String[].class) : (String[]) invokeL.objValue;
    }

    public String[] decodeInputStream(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream)) == null) ? (String[]) JSON.parseObject(inputStream, String[].class, new Feature[0]) : (String[]) invokeL.objValue;
    }
}
