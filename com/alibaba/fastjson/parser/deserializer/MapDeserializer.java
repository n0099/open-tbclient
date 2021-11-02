package com.alibaba.fastjson.parser.deserializer;

import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class MapDeserializer extends ContextObjectDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static MapDeserializer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-440148138, "Lcom/alibaba/fastjson/parser/deserializer/MapDeserializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-440148138, "Lcom/alibaba/fastjson/parser/deserializer/MapDeserializer;");
                return;
            }
        }
        instance = new MapDeserializer();
    }

    public MapDeserializer() {
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

    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, defaultJSONParser, map, type, obj)) == null) ? parseMap(defaultJSONParser, map, type, obj, 0) : (Map) invokeLLLL.objValue;
    }

    public Map<Object, Object> createMap(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, type)) == null) ? createMap(type, JSON.DEFAULT_GENERATE_FEATURE) : (Map) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i2) {
        InterceptResult invokeCommon;
        Map<Object, Object> createMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{defaultJSONParser, type, obj, str, Integer.valueOf(i2)})) == null) {
            if (type == JSONObject.class && defaultJSONParser.getFieldTypeResolver() == null) {
                return (T) defaultJSONParser.parseObject();
            }
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 8) {
                jSONLexer.nextToken(16);
                return null;
            }
            boolean z = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
            if ((jSONLexer.getFeatures() & Feature.OrderedField.mask) != 0) {
                createMap = createMap(type, jSONLexer.getFeatures());
            } else {
                createMap = createMap(type);
            }
            Map<Object, Object> map = createMap;
            ParseContext context = defaultJSONParser.getContext();
            try {
                defaultJSONParser.setContext(context, map, obj);
                T t = (T) deserialze(defaultJSONParser, type, obj, map, i2);
                if (z) {
                    t = (T) Collections.unmodifiableMap((Map) t);
                }
                return t;
            } finally {
                defaultJSONParser.setContext(context);
            }
        }
        return (T) invokeCommon.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x020b, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj, int i2) {
        InterceptResult invokeCommon;
        String scanSymbolUnQuoted;
        Class<?> checkAutoType;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{defaultJSONParser, map, type, obj, Integer.valueOf(i2)})) != null) {
            return (Map) invokeCommon.objValue;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i3 = jSONLexer.token();
        int i4 = 0;
        if (i3 != 12) {
            String str = "syntax error, expect {, actual " + jSONLexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + StringUtil.ARRAY_ELEMENT_SEPARATOR) + jSONLexer.info();
            if (i3 != 4) {
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
                    if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                        scanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), ExtendedMessageFormat.QUOTE);
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
                if (scanSymbolUnQuoted == JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect) && !Feature.isEnabled(i2, Feature.DisableSpecialKeyDetect)) {
                    String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                    ParserConfig config = defaultJSONParser.getConfig();
                    if (scanSymbol.equals("java.util.HashMap")) {
                        checkAutoType = HashMap.class;
                    } else {
                        checkAutoType = config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures());
                    }
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
                    if (i4 != 0) {
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
                    int i5 = jSONLexer.token();
                    if (i5 == 20 || i5 == 15) {
                        break;
                    } else if (i5 == 13) {
                        jSONLexer.nextToken();
                        return map;
                    }
                }
                i4++;
            } finally {
                defaultJSONParser.setContext(context);
            }
        }
    }

    public Map<Object, Object> createMap(Type type, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, i2)) == null) {
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
                    if (type == Map.class) {
                        return (Feature.OrderedField.mask & i2) != 0 ? new LinkedHashMap() : new HashMap();
                    } else if (type == HashMap.class) {
                        return new HashMap();
                    } else {
                        if (type == LinkedHashMap.class) {
                            return new LinkedHashMap();
                        }
                        if (type instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType) type;
                            Type rawType = parameterizedType.getRawType();
                            if (EnumMap.class.equals(rawType)) {
                                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
                            }
                            return createMap(rawType, i2);
                        }
                        Class cls = (Class) type;
                        if (!cls.isInterface()) {
                            if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
                                return new HashMap();
                            }
                            try {
                                return (Map) cls.newInstance();
                            } catch (Exception e2) {
                                throw new JSONException("unsupport type " + type, e2);
                            }
                        }
                        throw new JSONException("unsupport type " + type);
                    }
                }
                return new ConcurrentHashMap();
            }
            return new TreeMap();
        }
        return (Map) invokeLI.objValue;
    }

    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, defaultJSONParser, type, obj, map)) == null) ? deserialze(defaultJSONParser, type, obj, map, 0) : invokeLLLL.objValue;
    }

    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map, int i2) {
        InterceptResult invokeCommon;
        Type type2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{defaultJSONParser, type, obj, map, Integer.valueOf(i2)})) == null) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type3 = parameterizedType.getActualTypeArguments()[0];
                if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
                    type2 = List.class;
                } else {
                    type2 = parameterizedType.getActualTypeArguments()[1];
                }
                if (String.class == type3) {
                    return parseMap(defaultJSONParser, map, type2, obj, i2);
                }
                return parseMap(defaultJSONParser, map, type3, type2, obj);
            }
            return defaultJSONParser.parseObject(map, obj);
        }
        return invokeCommon.objValue;
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        InterceptResult invokeLLLLL;
        Object deserialze;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, defaultJSONParser, map, type, type2, obj)) == null) {
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
                    if (jSONLexer.token() == 4 && (deserializer instanceof JavaBeanDeserializer)) {
                        String stringVal2 = jSONLexer.stringVal();
                        jSONLexer.nextToken();
                        DefaultJSONParser defaultJSONParser2 = new DefaultJSONParser(stringVal2, defaultJSONParser.getConfig(), defaultJSONParser.getLexer().getFeatures());
                        defaultJSONParser2.setDateFormat(defaultJSONParser.getDateFomartPattern());
                        deserialze = deserializer.deserialze(defaultJSONParser2, type, null);
                    } else {
                        deserialze = deserializer.deserialze(defaultJSONParser, type, null);
                    }
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
        return invokeLLLLL.objValue;
    }
}
