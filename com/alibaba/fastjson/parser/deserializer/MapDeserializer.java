package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    /* JADX WARN: Code restructure failed: missing block: B:88:0x01f4, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        String scanSymbolUnQuoted;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        int i2 = 0;
        if (i != 12) {
            String str = "syntax error, expect {, actual " + jSONLexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + StringUtil.ARRAY_ELEMENT_SEPARATOR) + jSONLexer.info();
            if (i != 4) {
                JSONArray jSONArray = new JSONArray();
                defaultJSONParser.parseArray(jSONArray, obj);
                if (jSONArray.size() == 1) {
                    Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof JSONObject) {
                        return (JSONObject) obj2;
                    }
                }
            }
            throw new JSONException(str2);
        }
        ParseContext context = defaultJSONParser.getContext();
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char current = jSONLexer.getCurrent();
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        current = jSONLexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), Typography.quote);
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos());
                    }
                } else if (current == '}') {
                    jSONLexer.next();
                    jSONLexer.resetStringPosition();
                    jSONLexer.nextToken(16);
                    return map;
                } else if (current == '\'') {
                    if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                        scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos());
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
                    jSONLexer.skipWhitespace();
                    char current2 = jSONLexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current2);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                jSONLexer.getCurrent();
                jSONLexer.resetStringPosition();
                Object obj3 = null;
                if (scanSymbolUnQuoted == JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), Typography.quote);
                    ParserConfig config = defaultJSONParser.getConfig();
                    Class<?> checkAutoType = config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures());
                    if (Map.class.isAssignableFrom(checkAutoType)) {
                        jSONLexer.nextToken(16);
                        if (jSONLexer.token() == 13) {
                            jSONLexer.nextToken(16);
                            return map;
                        }
                    } else {
                        ObjectDeserializer deserializer = config.getDeserializer(checkAutoType);
                        jSONLexer.nextToken(16);
                        defaultJSONParser.setResolveStatus(2);
                        if (context != null && !(obj instanceof Integer)) {
                            defaultJSONParser.popContext();
                        }
                        return (Map) deserializer.deserialze(defaultJSONParser, checkAutoType, obj);
                    }
                } else {
                    jSONLexer.nextToken();
                    if (i2 != 0) {
                        defaultJSONParser.setContext(context);
                    }
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken();
                    } else {
                        obj3 = defaultJSONParser.parseObject(type, scanSymbolUnQuoted);
                    }
                    map.put(scanSymbolUnQuoted, obj3);
                    defaultJSONParser.checkMapResolve(map, scanSymbolUnQuoted);
                    defaultJSONParser.setContext(context, obj3, scanSymbolUnQuoted);
                    defaultJSONParser.setContext(context);
                    int i3 = jSONLexer.token();
                    if (i3 == 20 || i3 == 15) {
                        break;
                    } else if (i3 == 13) {
                        jSONLexer.nextToken();
                        return map;
                    }
                }
                i2++;
            } finally {
                defaultJSONParser.setContext(context);
            }
        }
    }

    public Map<Object, Object> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type != SortedMap.class && type != TreeMap.class) {
            if (type != ConcurrentMap.class && type != ConcurrentHashMap.class) {
                if (type != Map.class && type != HashMap.class) {
                    if (type == LinkedHashMap.class) {
                        return new LinkedHashMap();
                    }
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Type rawType = parameterizedType.getRawType();
                        if (EnumMap.class.equals(rawType)) {
                            return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
                        }
                        return createMap(rawType);
                    }
                    Class cls = (Class) type;
                    if (!cls.isInterface()) {
                        try {
                            return (Map) cls.newInstance();
                        } catch (Exception e2) {
                            throw new JSONException("unsupport type " + type, e2);
                        }
                    }
                    throw new JSONException("unsupport type " + type);
                }
                return new HashMap();
            }
            return new ConcurrentHashMap();
        }
        return new TreeMap();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.getFieldTypeResolver() == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<Object, Object> createMap = createMap(type);
        ParseContext context = defaultJSONParser.getContext();
        try {
            defaultJSONParser.setContext(context, createMap, obj);
            return (T) deserialze(defaultJSONParser, type, obj, createMap);
        } finally {
            defaultJSONParser.setContext(context);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
        Type type2;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
                type2 = List.class;
            } else {
                type2 = parameterizedType.getActualTypeArguments()[1];
            }
            if (String.class == type3) {
                return parseMap(defaultJSONParser, map, type2, obj);
            }
            return parseMap(defaultJSONParser, map, type3, type2, obj);
        }
        return defaultJSONParser.parseObject(map, obj);
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
        }
        ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
        ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
        jSONLexer.nextToken(deserializer.getFastMatchToken());
        ParseContext context = defaultJSONParser.getContext();
        while (jSONLexer.token() != 13) {
            try {
                Object obj2 = null;
                if (jSONLexer.token() == 4 && jSONLexer.isRef() && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithColon(4);
                    if (jSONLexer.token() == 4) {
                        String stringVal = jSONLexer.stringVal();
                        if (IStringUtil.TOP_PATH.equals(stringVal)) {
                            obj2 = context.parent.object;
                        } else if ("$".equals(stringVal)) {
                            ParseContext parseContext = context;
                            while (parseContext.parent != null) {
                                parseContext = parseContext.parent;
                            }
                            obj2 = parseContext.object;
                        } else {
                            defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(context, stringVal));
                            defaultJSONParser.setResolveStatus(1);
                        }
                        jSONLexer.nextToken(13);
                        if (jSONLexer.token() == 13) {
                            jSONLexer.nextToken(16);
                            return obj2;
                        }
                        throw new JSONException("illegal ref");
                    }
                    throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                }
                if (map.size() == 0 && jSONLexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithColon(4);
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken();
                        return map;
                    }
                    jSONLexer.nextToken(deserializer.getFastMatchToken());
                }
                Object deserialze = deserializer.deserialze(defaultJSONParser, type, null);
                if (jSONLexer.token() == 17) {
                    jSONLexer.nextToken(deserializer2.getFastMatchToken());
                    Object deserialze2 = deserializer2.deserialze(defaultJSONParser, type2, deserialze);
                    defaultJSONParser.checkMapResolve(map, deserialze);
                    map.put(deserialze, deserialze2);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(deserializer.getFastMatchToken());
                    }
                } else {
                    throw new JSONException("syntax error, expect :, actual " + jSONLexer.token());
                }
            } finally {
                defaultJSONParser.setContext(context);
            }
        }
        jSONLexer.nextToken(16);
        return map;
    }
}
