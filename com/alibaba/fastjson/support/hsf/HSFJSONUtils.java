package com.alibaba.fastjson.support.hsf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class HSFJSONUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] fieldName_argsObjs;
    public static final char[] fieldName_argsTypes;
    public static final char[] fieldName_type;
    public static final SymbolTable typeSymbolTable;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1503671269, "Lcom/alibaba/fastjson/support/hsf/HSFJSONUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1503671269, "Lcom/alibaba/fastjson/support/hsf/HSFJSONUtils;");
                return;
            }
        }
        typeSymbolTable = new SymbolTable(1024);
        fieldName_argsTypes = "\"argsTypes\"".toCharArray();
        fieldName_argsObjs = "\"argsObjs\"".toCharArray();
        fieldName_type = "\"@type\":".toCharArray();
    }

    public HSFJSONUtils() {
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

    public static Object[] parseInvocationArguments(String str, MethodLocator methodLocator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, methodLocator)) == null) {
            DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str);
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
            Object[] objArr = null;
            ParseContext context = defaultJSONParser.setContext(null, null);
            int i2 = jSONLexerBase.token();
            int i3 = 0;
            if (i2 != 12) {
                if (i2 == 14) {
                    String[] scanFieldStringArray = jSONLexerBase.scanFieldStringArray(null, -1, typeSymbolTable);
                    jSONLexerBase.skipWhitespace();
                    char current = jSONLexerBase.getCurrent();
                    if (current == ']') {
                        Type[] genericParameterTypes = methodLocator.findMethod(null).getGenericParameterTypes();
                        Object[] objArr2 = new Object[scanFieldStringArray.length];
                        while (i3 < scanFieldStringArray.length) {
                            Type type = genericParameterTypes[i3];
                            String str2 = scanFieldStringArray[i3];
                            if (type != String.class) {
                                objArr2[i3] = TypeUtils.cast(str2, type, defaultJSONParser.getConfig());
                            } else {
                                objArr2[i3] = str2;
                            }
                            i3++;
                        }
                        return objArr2;
                    }
                    if (current == ',') {
                        jSONLexerBase.next();
                        jSONLexerBase.skipWhitespace();
                    }
                    jSONLexerBase.nextToken(14);
                    Object[] parseArray = defaultJSONParser.parseArray(methodLocator.findMethod(scanFieldStringArray).getGenericParameterTypes());
                    jSONLexerBase.close();
                    return parseArray;
                }
                return null;
            }
            String[] scanFieldStringArray2 = jSONLexerBase.scanFieldStringArray(fieldName_argsTypes, -1, typeSymbolTable);
            if (scanFieldStringArray2 == null && jSONLexerBase.matchStat == -2 && "com.alibaba.fastjson.JSONObject".equals(jSONLexerBase.scanFieldString(fieldName_type))) {
                scanFieldStringArray2 = jSONLexerBase.scanFieldStringArray(fieldName_argsTypes, -1, typeSymbolTable);
            }
            Method findMethod = methodLocator.findMethod(scanFieldStringArray2);
            if (findMethod == null) {
                jSONLexerBase.close();
                JSONObject parseObject = JSON.parseObject(str);
                Method findMethod2 = methodLocator.findMethod((String[]) parseObject.getObject("argsTypes", (Class<Object>) String[].class));
                JSONArray jSONArray = parseObject.getJSONArray("argsObjs");
                if (jSONArray == null) {
                    return null;
                }
                Type[] genericParameterTypes2 = findMethod2.getGenericParameterTypes();
                Object[] objArr3 = new Object[genericParameterTypes2.length];
                while (i3 < genericParameterTypes2.length) {
                    objArr3[i3] = jSONArray.getObject(i3, genericParameterTypes2[i3]);
                    i3++;
                }
                return objArr3;
            }
            Type[] genericParameterTypes3 = findMethod.getGenericParameterTypes();
            jSONLexerBase.skipWhitespace();
            if (jSONLexerBase.getCurrent() == ',') {
                jSONLexerBase.next();
            }
            if (jSONLexerBase.matchField2(fieldName_argsObjs)) {
                jSONLexerBase.nextToken();
                ParseContext context2 = defaultJSONParser.setContext(context, null, "argsObjs");
                Object[] parseArray2 = defaultJSONParser.parseArray(genericParameterTypes3);
                context2.object = parseArray2;
                defaultJSONParser.accept(13);
                defaultJSONParser.handleResovleTask(null);
                objArr = parseArray2;
            }
            defaultJSONParser.close();
            return objArr;
        }
        return (Object[]) invokeLL.objValue;
    }
}
