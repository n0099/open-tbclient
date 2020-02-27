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
/* loaded from: classes7.dex */
public class HSFJSONUtils {
    static final SymbolTable typeSymbolTable = new SymbolTable(1024);
    static final char[] fieldName_argsTypes = "\"argsTypes\"".toCharArray();
    static final char[] fieldName_argsObjs = "\"argsObjs\"".toCharArray();
    static final char[] fieldName_type = "\"@type\":".toCharArray();

    public static Object[] parseInvocationArguments(String str, MethodLocator methodLocator) {
        Object[] objArr = null;
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str);
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
        ParseContext context = defaultJSONParser.setContext(null, null);
        int i = jSONLexerBase.token();
        if (i == 12) {
            String[] scanFieldStringArray = jSONLexerBase.scanFieldStringArray(fieldName_argsTypes, -1, typeSymbolTable);
            if (scanFieldStringArray == null && jSONLexerBase.matchStat == -2 && "com.alibaba.fastjson.JSONObject".equals(jSONLexerBase.scanFieldString(fieldName_type))) {
                scanFieldStringArray = jSONLexerBase.scanFieldStringArray(fieldName_argsTypes, -1, typeSymbolTable);
            }
            Method findMethod = methodLocator.findMethod(scanFieldStringArray);
            if (findMethod == null) {
                jSONLexerBase.close();
                JSONObject parseObject = JSON.parseObject(str);
                Method findMethod2 = methodLocator.findMethod((String[]) parseObject.getObject("argsTypes", (Class<Object>) String[].class));
                JSONArray jSONArray = parseObject.getJSONArray("argsObjs");
                if (jSONArray == null) {
                    return null;
                }
                Type[] genericParameterTypes = findMethod2.getGenericParameterTypes();
                Object[] objArr2 = new Object[genericParameterTypes.length];
                for (int i2 = 0; i2 < genericParameterTypes.length; i2++) {
                    objArr2[i2] = jSONArray.getObject(i2, genericParameterTypes[i2]);
                }
                return objArr2;
            }
            Type[] genericParameterTypes2 = findMethod.getGenericParameterTypes();
            jSONLexerBase.skipWhitespace();
            if (jSONLexerBase.getCurrent() == ',') {
                jSONLexerBase.next();
            }
            if (jSONLexerBase.matchField2(fieldName_argsObjs)) {
                jSONLexerBase.nextToken();
                ParseContext context2 = defaultJSONParser.setContext(context, null, "argsObjs");
                Object[] parseArray = defaultJSONParser.parseArray(genericParameterTypes2);
                context2.object = parseArray;
                defaultJSONParser.accept(13);
                defaultJSONParser.handleResovleTask(null);
                objArr = parseArray;
            }
            defaultJSONParser.close();
            return objArr;
        } else if (i == 14) {
            String[] scanFieldStringArray2 = jSONLexerBase.scanFieldStringArray(null, -1, typeSymbolTable);
            jSONLexerBase.skipWhitespace();
            char current = jSONLexerBase.getCurrent();
            if (current == ']') {
                Type[] genericParameterTypes3 = methodLocator.findMethod(null).getGenericParameterTypes();
                Object[] objArr3 = new Object[scanFieldStringArray2.length];
                for (int i3 = 0; i3 < scanFieldStringArray2.length; i3++) {
                    Type type = genericParameterTypes3[i3];
                    String str2 = scanFieldStringArray2[i3];
                    if (type != String.class) {
                        objArr3[i3] = TypeUtils.cast(str2, type, defaultJSONParser.getConfig());
                    } else {
                        objArr3[i3] = str2;
                    }
                }
                return objArr3;
            }
            if (current == ',') {
                jSONLexerBase.next();
                jSONLexerBase.skipWhitespace();
            }
            jSONLexerBase.nextToken(14);
            Object[] parseArray2 = defaultJSONParser.parseArray(methodLocator.findMethod(scanFieldStringArray2).getGenericParameterTypes());
            jSONLexerBase.close();
            return parseArray2;
        } else {
            return null;
        }
    }
}
