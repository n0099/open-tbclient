package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class JSONPDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final JSONPDeserializer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1868814038, "Lcom/alibaba/fastjson/parser/deserializer/JSONPDeserializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1868814038, "Lcom/alibaba/fastjson/parser/deserializer/JSONPDeserializer;");
                return;
            }
        }
        instance = new JSONPDeserializer();
    }

    public JSONPDeserializer() {
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

    /* JADX WARN: Type inference failed for: r1v2, types: [com.alibaba.fastjson.JSONPObject, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
            String scanSymbolUnQuoted = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
            jSONLexerBase.nextToken();
            int i3 = jSONLexerBase.token();
            if (i3 == 25) {
                String str = scanSymbolUnQuoted + ".";
                scanSymbolUnQuoted = str + jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
                jSONLexerBase.nextToken();
                i3 = jSONLexerBase.token();
            }
            ?? r1 = (T) new JSONPObject(scanSymbolUnQuoted);
            if (i3 == 10) {
                jSONLexerBase.nextToken();
                while (true) {
                    r1.addParameter(defaultJSONParser.parse());
                    i2 = jSONLexerBase.token();
                    if (i2 != 16) {
                        break;
                    }
                    jSONLexerBase.nextToken();
                }
                if (i2 == 11) {
                    jSONLexerBase.nextToken();
                    if (jSONLexerBase.token() == 24) {
                        jSONLexerBase.nextToken();
                    }
                    return r1;
                }
                throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
            }
            throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        return (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
