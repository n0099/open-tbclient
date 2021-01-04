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
/* loaded from: classes6.dex */
public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

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

    protected Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=6] */
    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        String scanSymbolUnQuoted;
        Object parseObject;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i != 12) {
            String str = "syntax error, expect {, actual " + jSONLexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + ", ") + jSONLexer.info();
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
        int i2 = 0;
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
                    scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
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
                    if (!jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                        throw new JSONException("syntax error");
                    }
                    scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\'');
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos());
                    }
                } else if (!jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    throw new JSONException("syntax error");
                } else {
                    scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
                    jSONLexer.skipWhitespace();
                    char current2 = jSONLexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current2);
                    }
                }
                String str3 = scanSymbolUnQuoted;
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                jSONLexer.getCurrent();
                jSONLexer.resetStringPosition();
                if (str3 != JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextToken();
                    if (i2 != 0) {
                        defaultJSONParser.setContext(context);
                    }
                    if (jSONLexer.token() == 8) {
                        parseObject = null;
                        jSONLexer.nextToken();
                    } else {
                        parseObject = defaultJSONParser.parseObject(type, str3);
                    }
                    map.put(str3, parseObject);
                    defaultJSONParser.checkMapResolve(map, str3);
                    defaultJSONParser.setContext(context, parseObject, str3);
                    defaultJSONParser.setContext(context);
                    int i3 = jSONLexer.token();
                    if (i3 == 20 || i3 == 15) {
                        break;
                    } else if (i3 == 13) {
                        jSONLexer.nextToken();
                        return map;
                    }
                } else {
                    String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                    ParserConfig config = defaultJSONParser.getConfig();
                    Class<?> checkAutoType = config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures());
                    if (!Map.class.isAssignableFrom(checkAutoType)) {
                        ObjectDeserializer deserializer = config.getDeserializer(checkAutoType);
                        jSONLexer.nextToken(16);
                        defaultJSONParser.setResolveStatus(2);
                        if (context != null && !(obj instanceof Integer)) {
                            defaultJSONParser.popContext();
                        }
                        return (Map) deserializer.deserialze(defaultJSONParser, checkAutoType, obj);
                    }
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        return map;
                    }
                }
                i2++;
            } finally {
                defaultJSONParser.setContext(context);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [307=4] */
    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2 = null;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
            ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
            jSONLexer.nextToken(deserializer.getFastMatchToken());
            ParseContext context = defaultJSONParser.getContext();
            while (jSONLexer.token() != 13) {
                try {
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
                            if (jSONLexer.token() != 13) {
                                throw new JSONException("illegal ref");
                            }
                            jSONLexer.nextToken(16);
                            defaultJSONParser.setContext(context);
                            return obj2;
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
                    if (jSONLexer.token() != 17) {
                        throw new JSONException("syntax error, expect :, actual " + jSONLexer.token());
                    }
                    jSONLexer.nextToken(deserializer2.getFastMatchToken());
                    Object deserialze2 = deserializer2.deserialze(defaultJSONParser, type2, deserialze);
                    defaultJSONParser.checkMapResolve(map, deserialze);
                    map.put(deserialze, deserialze2);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(deserializer.getFastMatchToken());
                    }
                } finally {
                    defaultJSONParser.setContext(context);
                }
            }
            jSONLexer.nextToken(16);
            return map;
        }
        throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
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
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException("unsupport type " + type, e);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
