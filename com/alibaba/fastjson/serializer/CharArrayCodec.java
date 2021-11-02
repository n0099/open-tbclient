package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class CharArrayCodec implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CharArrayCodec() {
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

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) ? (T) deserialze(defaultJSONParser) : (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, defaultJSONParser)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                return (T) stringVal.toCharArray();
            } else if (jSONLexer.token() == 2) {
                Number integerValue = jSONLexer.integerValue();
                jSONLexer.nextToken(16);
                return (T) integerValue.toString().toCharArray();
            } else {
                Object parse = defaultJSONParser.parse();
                if (parse instanceof String) {
                    return (T) ((String) parse).toCharArray();
                }
                if (!(parse instanceof Collection)) {
                    if (parse == null) {
                        return null;
                    }
                    return (T) JSON.toJSONString(parse).toCharArray();
                }
                Collection<String> collection = (Collection) parse;
                Iterator it = collection.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if ((next instanceof String) && ((String) next).length() != 1) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    char[] cArr = new char[collection.size()];
                    int i2 = 0;
                    for (String str : collection) {
                        cArr[i2] = str.charAt(0);
                        i2++;
                    }
                    return cArr;
                }
                throw new JSONException("can not cast to char[]");
            }
        }
        return (T) invokeL.objValue;
    }
}
