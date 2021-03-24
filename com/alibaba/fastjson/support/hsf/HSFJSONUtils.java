package com.alibaba.fastjson.support.hsf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class HSFJSONUtils {
    public static final SymbolTable typeSymbolTable = new SymbolTable(1024);
    public static final char[] fieldName_argsTypes = "\"argsTypes\"".toCharArray();
    public static final char[] fieldName_argsObjs = "\"argsObjs\"".toCharArray();
    public static final char[] fieldName_type = "\"@type\":".toCharArray();

    public static Object[] parseInvocationArguments(String str, MethodLocator methodLocator) {
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str);
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
        Object[] objArr = null;
        ParseContext context = defaultJSONParser.setContext(null, null);
        int i = jSONLexerBase.token();
        int i2 = 0;
        if (i != 12) {
            if (i == 14) {
                String[] scanFieldStringArray = jSONLexerBase.scanFieldStringArray(null, -1, typeSymbolTable);
                jSONLexerBase.skipWhitespace();
                char current = jSONLexerBase.getCurrent();
                if (current == ']') {
                    Type[] genericParameterTypes = methodLocator.findMethod(null).getGenericParameterTypes();
                    Object[] objArr2 = new Object[scanFieldStringArray.length];
                    while (i2 < scanFieldStringArray.length) {
                        Type type = genericParameterTypes[i2];
                        String str2 = scanFieldStringArray[i2];
                        if (type != String.class) {
                            objArr2[i2] = TypeUtils.cast(str2, type, defaultJSONParser.getConfig());
                        } else {
                            objArr2[i2] = str2;
                        }
                        i2++;
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
            while (i2 < genericParameterTypes2.length) {
                objArr3[i2] = jSONArray.getObject(i2, genericParameterTypes2[i2]);
                i2++;
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
}
