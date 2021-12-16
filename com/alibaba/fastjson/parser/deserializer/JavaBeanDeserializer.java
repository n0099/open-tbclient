package com.alibaba.fastjson.parser.deserializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes9.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final ParserConfig.AutoTypeCheckHandler autoTypeCheckHandler;
    public final JavaBeanInfo beanInfo;
    public final Class<?> clazz;
    public ConcurrentMap<String, Object> extraFieldDeserializers;
    public Map<String, FieldDeserializer> fieldDeserializerMap;
    public final FieldDeserializer[] fieldDeserializers;
    public transient long[] hashArray;
    public transient short[] hashArrayMapping;
    public transient long[] smartMatchHashArray;
    public transient short[] smartMatchHashArrayMapping;
    public final FieldDeserializer[] sortedFieldDeserializers;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parserConfig, cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ParserConfig) objArr2[0], (Class) objArr2[1], (Type) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, parserConfig, obj)) == null) ? this.beanInfo.factoryMethod.invoke(null, obj) : invokeLL.objValue;
    }

    public static JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, parserConfig, javaBeanInfo, str)) == null) {
            JSONType jSONType = javaBeanInfo.jsonType;
            if (jSONType == null) {
                return null;
            }
            for (Class<?> cls : jSONType.seeAlso()) {
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                if (deserializer instanceof JavaBeanDeserializer) {
                    JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                    JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                    if (javaBeanInfo2.typeName.equals(str)) {
                        return javaBeanDeserializer;
                    }
                    JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                    if (seeAlso != null) {
                        return seeAlso;
                    }
                }
            }
            return null;
        }
        return (JavaBeanDeserializer) invokeLLL.objValue;
    }

    public static boolean isSetFlag(int i2, int[] iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i2, iArr)) == null) {
            if (iArr == null) {
                return false;
            }
            int i3 = i2 / 32;
            int i4 = i2 % 32;
            if (i3 < iArr.length) {
                if (((1 << i4) & iArr[i3]) != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, collection, objectDeserializer, defaultJSONParser, type, obj) == null) {
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            int i2 = jSONLexerBase.token();
            if (i2 == 8) {
                jSONLexerBase.nextToken(16);
                jSONLexerBase.token();
                return;
            }
            if (i2 != 14) {
                defaultJSONParser.throwException(i2);
            }
            if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
            if (jSONLexerBase.token() == 15) {
                jSONLexerBase.nextToken();
                return;
            }
            int i3 = 0;
            while (true) {
                collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i3)));
                i3++;
                if (jSONLexerBase.token() != 16) {
                    break;
                } else if (jSONLexerBase.getCurrent() == '[') {
                    jSONLexerBase.next();
                    jSONLexerBase.setToken(14);
                } else {
                    jSONLexerBase.nextToken(14);
                }
            }
            int i4 = jSONLexerBase.token();
            if (i4 != 15) {
                defaultJSONParser.throwException(i4);
            }
            if (jSONLexerBase.getCurrent() == ',') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(16);
                return;
            }
            jSONLexerBase.nextToken(16);
        }
    }

    public void check(JSONLexer jSONLexer, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, jSONLexer, i2) == null) && jSONLexer.token() != i2) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        InterceptResult invokeLL;
        Object newInstance;
        FieldInfo[] fieldInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, defaultJSONParser, type)) == null) {
            if ((type instanceof Class) && this.clazz.isInterface()) {
                return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
            }
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            Object obj = null;
            if (javaBeanInfo.defaultConstructor == null && javaBeanInfo.factoryMethod == null) {
                return null;
            }
            JavaBeanInfo javaBeanInfo2 = this.beanInfo;
            if (javaBeanInfo2.factoryMethod == null || javaBeanInfo2.defaultConstructorParameterSize <= 0) {
                try {
                    Constructor<?> constructor = this.beanInfo.defaultConstructor;
                    if (this.beanInfo.defaultConstructorParameterSize != 0) {
                        ParseContext context = defaultJSONParser.getContext();
                        if (context != null && context.object != null) {
                            if (type instanceof Class) {
                                String name = ((Class) type).getName();
                                String substring = name.substring(0, name.lastIndexOf(36));
                                Object obj2 = context.object;
                                String name2 = obj2.getClass().getName();
                                if (!name2.equals(substring)) {
                                    ParseContext parseContext = context.parent;
                                    if (parseContext == null || parseContext.object == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                                        obj = obj2;
                                    } else if (parseContext.object.getClass().getName().equals(substring)) {
                                        obj = parseContext.object;
                                    }
                                    obj2 = obj;
                                }
                                if (obj2 != null && (!(obj2 instanceof Collection) || !((Collection) obj2).isEmpty())) {
                                    newInstance = constructor.newInstance(obj2);
                                } else {
                                    throw new JSONException("can't create non-static inner class instance.");
                                }
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        } else {
                            throw new JSONException("can't create non-static inner class instance.");
                        }
                    } else if (constructor != null) {
                        newInstance = constructor.newInstance(new Object[0]);
                    } else {
                        newInstance = this.beanInfo.factoryMethod.invoke(null, new Object[0]);
                    }
                    if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                        for (FieldInfo fieldInfo : this.beanInfo.fields) {
                            if (fieldInfo.fieldClass == String.class) {
                                try {
                                    fieldInfo.set(newInstance, "");
                                } catch (Exception e2) {
                                    throw new JSONException("create instance error, class " + this.clazz.getName(), e2);
                                }
                            }
                        }
                    }
                    return newInstance;
                } catch (JSONException e3) {
                    throw e3;
                } catch (Exception e4) {
                    throw new JSONException("create instance error, class " + this.clazz.getName(), e4);
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, defaultJSONParser, type, obj)) == null) ? (T) deserialze(defaultJSONParser, type, obj, 0) : (T) invokeLLL.objValue;
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        InterceptResult invokeLLLL;
        Enum<?> scanEnum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, defaultJSONParser, type, obj, obj2)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 14) {
                String scanTypeName = jSONLexer.scanTypeName(defaultJSONParser.symbolTable);
                if (scanTypeName != null) {
                    ObjectDeserializer seeAlso = getSeeAlso(defaultJSONParser.getConfig(), this.beanInfo, scanTypeName);
                    if (seeAlso == null) {
                        seeAlso = defaultJSONParser.getConfig().getDeserializer(defaultJSONParser.getConfig().checkAutoType(scanTypeName, TypeUtils.getClass(type), jSONLexer.getFeatures()));
                    }
                    if (seeAlso instanceof JavaBeanDeserializer) {
                        return (T) ((JavaBeanDeserializer) seeAlso).deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                    }
                }
                T t = (T) createInstance(defaultJSONParser, type);
                int i2 = 0;
                int length = this.sortedFieldDeserializers.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    char c2 = i2 == length + (-1) ? ']' : ',';
                    FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i2];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (cls == Integer.TYPE) {
                        fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c2));
                    } else if (cls == String.class) {
                        fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c2));
                    } else if (cls == Long.TYPE) {
                        fieldDeserializer.setValue(t, jSONLexer.scanLong(c2));
                    } else if (cls.isEnum()) {
                        char current = jSONLexer.getCurrent();
                        if (current == '\"' || current == 'n') {
                            scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c2);
                        } else if (current >= '0' && current <= '9') {
                            scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c2));
                        } else {
                            scanEnum = scanEnum(jSONLexer, c2);
                        }
                        fieldDeserializer.setValue(t, scanEnum);
                    } else if (cls == Boolean.TYPE) {
                        fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c2));
                    } else if (cls == Float.TYPE) {
                        fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c2)));
                    } else if (cls == Double.TYPE) {
                        fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c2)));
                    } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                        fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c2)));
                    } else if (cls == BigDecimal.class) {
                        fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c2));
                    } else {
                        jSONLexer.nextToken(14);
                        FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                        fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldInfo.fieldType, fieldInfo.name));
                        if (jSONLexer.token() == 15) {
                            break;
                        }
                        check(jSONLexer, c2 == ']' ? 15 : 16);
                    }
                    i2++;
                }
                jSONLexer.nextToken(16);
                return t;
            }
            throw new JSONException("error");
        }
        return (T) invokeLLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? getFieldDeserializer(str, null) : (FieldDeserializer) invokeL.objValue;
    }

    public Type getFieldType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.sortedFieldDeserializers[i2].fieldInfo.fieldType : (Type) invokeI.objValue;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, defaultJSONParser, str, obj, type, map)) == null) ? parseField(defaultJSONParser, str, obj, type, map, null) : invokeLLLLL.booleanValue;
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{defaultJSONParser, type, obj, obj2, Integer.valueOf(i2)})) == null) ? parseRest(defaultJSONParser, type, obj, obj2, i2, new int[0]) : invokeCommon.objValue;
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{jSONLexer, Character.valueOf(c2)})) == null) {
            throw new JSONException("illegal enum. " + jSONLexer.info());
        }
        return (Enum) invokeCommon.objValue;
    }

    public FieldDeserializer smartMatch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? smartMatch(str, null) : (FieldDeserializer) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parserConfig, cls, type};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ParserConfig) objArr2[0], (JavaBeanInfo) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048580, this, defaultJSONParser, type, obj, i2)) == null) ? (T) deserialze(defaultJSONParser, type, obj, null, i2, null) : (T) invokeLLLI.objValue;
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        InterceptResult invokeLL;
        FieldDeserializer fieldDeserializer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, iArr)) == null) {
            if (str == null) {
                return null;
            }
            Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
            if (map == null || (fieldDeserializer = map.get(str)) == null) {
                int i2 = 0;
                int length = this.sortedFieldDeserializers.length - 1;
                while (i2 <= length) {
                    int i3 = (i2 + length) >>> 1;
                    int compareTo = this.sortedFieldDeserializers[i3].fieldInfo.name.compareTo(str);
                    if (compareTo < 0) {
                        i2 = i3 + 1;
                    } else if (compareTo <= 0) {
                        if (isSetFlag(i3, iArr)) {
                            return null;
                        }
                        return this.sortedFieldDeserializers[i3];
                    } else {
                        length = i3 - 1;
                    }
                }
                Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
                if (map2 != null) {
                    return map2.get(str);
                }
                return null;
            }
            return fieldDeserializer;
        }
        return (FieldDeserializer) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0129  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map, int[] iArr) {
        InterceptResult invokeCommon;
        FieldDeserializer fieldDeserializer;
        FieldDeserializer fieldDeserializer2;
        JSONLexer jSONLexer;
        ?? r17;
        FieldDeserializer fieldDeserializer3;
        FieldDeserializer fieldDeserializer4;
        Field[] fieldArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{defaultJSONParser, str, obj, type, map, iArr})) != null) {
            return invokeCommon.booleanValue;
        }
        JSONLexer jSONLexer2 = defaultJSONParser.lexer;
        int i2 = Feature.DisableFieldSmartMatch.mask;
        int i3 = Feature.InitStringFieldAsEmpty.mask;
        if (!jSONLexer2.isEnabled(i2) && (i2 & this.beanInfo.parserFeatures) == 0) {
            if (!jSONLexer2.isEnabled(i3) && (this.beanInfo.parserFeatures & i3) == 0) {
                fieldDeserializer = smartMatch(str, iArr);
            } else {
                fieldDeserializer = smartMatch(str);
            }
        } else {
            fieldDeserializer = getFieldDeserializer(str);
        }
        int i4 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer != null || (!jSONLexer2.isEnabled(i4) && (i4 & this.beanInfo.parserFeatures) == 0)) {
            fieldDeserializer2 = fieldDeserializer;
        } else {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> cls = this.clazz; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                    Field[] declaredFields = cls.getDeclaredFields();
                    int length = declaredFields.length;
                    int i5 = 0;
                    while (i5 < length) {
                        Field field = declaredFields[i5];
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                fieldDeserializer4 = fieldDeserializer;
                                JSONField jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                                if (jSONField != null) {
                                    String name2 = jSONField.name();
                                    fieldArr = declaredFields;
                                    if (!"".equals(name2)) {
                                        name = name2;
                                    }
                                } else {
                                    fieldArr = declaredFields;
                                }
                                concurrentHashMap.put(name, field);
                                i5++;
                                fieldDeserializer = fieldDeserializer4;
                                declaredFields = fieldArr;
                            }
                        }
                        fieldDeserializer4 = fieldDeserializer;
                        fieldArr = declaredFields;
                        i5++;
                        fieldDeserializer = fieldDeserializer4;
                        declaredFields = fieldArr;
                    }
                }
                fieldDeserializer2 = fieldDeserializer;
                this.extraFieldDeserializers = concurrentHashMap;
            } else {
                fieldDeserializer2 = fieldDeserializer;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer3 = (FieldDeserializer) obj2;
                    jSONLexer = jSONLexer2;
                    r17 = 1;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    r17 = 1;
                    jSONLexer = jSONLexer2;
                    fieldDeserializer3 = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer3);
                }
                if (fieldDeserializer3 != null) {
                    if (!jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
                        throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
                    }
                    int i6 = 0;
                    int i7 = -1;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                        if (i6 >= fieldDeserializerArr.length) {
                            break;
                        }
                        FieldDeserializer fieldDeserializer5 = fieldDeserializerArr[i6];
                        FieldInfo fieldInfo = fieldDeserializer5.fieldInfo;
                        if (fieldInfo.unwrapped && (fieldDeserializer5 instanceof DefaultFieldDeserializer)) {
                            if (fieldInfo.field != null) {
                                DefaultFieldDeserializer defaultFieldDeserializer = (DefaultFieldDeserializer) fieldDeserializer5;
                                ObjectDeserializer fieldValueDeserilizer = defaultFieldDeserializer.getFieldValueDeserilizer(defaultJSONParser.getConfig());
                                if (fieldValueDeserilizer instanceof JavaBeanDeserializer) {
                                    FieldDeserializer fieldDeserializer6 = ((JavaBeanDeserializer) fieldValueDeserilizer).getFieldDeserializer(str);
                                    if (fieldDeserializer6 != null) {
                                        try {
                                            Object obj3 = fieldInfo.field.get(obj);
                                            if (obj3 == null) {
                                                obj3 = ((JavaBeanDeserializer) fieldValueDeserilizer).createInstance(defaultJSONParser, fieldInfo.fieldType);
                                                fieldDeserializer5.setValue(obj, obj3);
                                            }
                                            jSONLexer.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
                                            fieldDeserializer6.parseField(defaultJSONParser, obj3, type, map);
                                            i7 = i6;
                                        } catch (Exception e2) {
                                            throw new JSONException("parse unwrapped field error.", e2);
                                        }
                                    } else {
                                        continue;
                                    }
                                } else if (fieldValueDeserilizer instanceof MapDeserializer) {
                                    MapDeserializer mapDeserializer = (MapDeserializer) fieldValueDeserilizer;
                                    try {
                                        Map<Object, Object> map2 = (Map) fieldInfo.field.get(obj);
                                        if (map2 == null) {
                                            map2 = mapDeserializer.createMap(fieldInfo.fieldType);
                                            fieldDeserializer5.setValue(obj, map2);
                                        }
                                        jSONLexer.nextTokenWithColon();
                                        map2.put(str, defaultJSONParser.parse(str));
                                        i7 = i6;
                                    } catch (Exception e3) {
                                        throw new JSONException("parse unwrapped field error.", e3);
                                    }
                                } else {
                                    continue;
                                }
                            } else if (fieldInfo.method.getParameterTypes().length == 2) {
                                jSONLexer.nextTokenWithColon();
                                Object parse = defaultJSONParser.parse(str);
                                try {
                                    Method method = fieldInfo.method;
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str;
                                    objArr[r17] = parse;
                                    method.invoke(obj, objArr);
                                    i7 = i6;
                                } catch (Exception e4) {
                                    throw new JSONException("parse unwrapped field error.", e4);
                                }
                            } else {
                                continue;
                            }
                        }
                        i6++;
                    }
                    if (i7 == -1) {
                        defaultJSONParser.parseExtra(obj, str);
                        return false;
                    }
                    if (iArr != null) {
                        int i8 = i7 / 32;
                        iArr[i8] = iArr[i8] | (r17 << (i7 % 32));
                    }
                    return r17;
                }
                JSONLexer jSONLexer3 = jSONLexer;
                int i9 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                    if (i9 >= fieldDeserializerArr2.length) {
                        i9 = -1;
                        break;
                    } else if (fieldDeserializerArr2[i9] == fieldDeserializer3) {
                        break;
                    } else {
                        i9++;
                    }
                }
                if (i9 != -1 && iArr != null && str.startsWith("_") && isSetFlag(i9, iArr)) {
                    defaultJSONParser.parseExtra(obj, str);
                    return false;
                }
                jSONLexer3.nextTokenWithColon(fieldDeserializer3.getFastMatchToken());
                fieldDeserializer3.parseField(defaultJSONParser, obj, type, map);
                if (iArr != null) {
                    int i10 = i9 / 32;
                    iArr[i10] = iArr[i10] | (r17 << (i9 % 32));
                }
                return r17;
            }
        }
        jSONLexer = jSONLexer2;
        r17 = 1;
        fieldDeserializer3 = fieldDeserializer2;
        if (fieldDeserializer3 != null) {
        }
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i2, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{defaultJSONParser, type, obj, obj2, Integer.valueOf(i2), iArr})) == null) ? deserialze(defaultJSONParser, type, obj, obj2, i2, iArr) : invokeCommon.objValue;
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, jSONLexerBase, cArr, objectDeserializer)) == null) {
            EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
            if (enumDeserializer == null) {
                jSONLexerBase.matchStat = -1;
                return null;
            }
            long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
            if (jSONLexerBase.matchStat > 0) {
                Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
                if (enumByHashCode == null) {
                    if (scanEnumSymbol == -3750763034362895579L) {
                        return null;
                    }
                    if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                        throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
                    }
                }
                return enumByHashCode;
            }
            return null;
        }
        return (Enum) invokeLLL.objValue;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, iArr)) == null) {
            if (str == null) {
                return null;
            }
            FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
            if (fieldDeserializer == null) {
                int i2 = 0;
                if (this.smartMatchHashArray == null) {
                    long[] jArr = new long[this.sortedFieldDeserializers.length];
                    int i3 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                        if (i3 >= fieldDeserializerArr.length) {
                            break;
                        }
                        jArr[i3] = fieldDeserializerArr[i3].fieldInfo.nameHashCode;
                        i3++;
                    }
                    Arrays.sort(jArr);
                    this.smartMatchHashArray = jArr;
                }
                int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str));
                if (binarySearch < 0) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_extract(str));
                }
                if (binarySearch < 0) {
                    z = str.startsWith("is");
                    if (z) {
                        binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_extract(str.substring(2)));
                    }
                } else {
                    z = false;
                }
                if (binarySearch >= 0) {
                    if (this.smartMatchHashArrayMapping == null) {
                        short[] sArr = new short[this.smartMatchHashArray.length];
                        Arrays.fill(sArr, (short) -1);
                        while (true) {
                            FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                            if (i2 >= fieldDeserializerArr2.length) {
                                break;
                            }
                            int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, fieldDeserializerArr2[i2].fieldInfo.nameHashCode);
                            if (binarySearch2 >= 0) {
                                sArr[binarySearch2] = (short) i2;
                            }
                            i2++;
                        }
                        this.smartMatchHashArrayMapping = sArr;
                    }
                    short s = this.smartMatchHashArrayMapping[binarySearch];
                    if (s != -1 && !isSetFlag(s, iArr)) {
                        fieldDeserializer = this.sortedFieldDeserializers[s];
                    }
                }
                if (fieldDeserializer != null) {
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                        return null;
                    }
                    Class<?> cls = fieldInfo.fieldClass;
                    if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                        return null;
                    }
                }
            }
            return fieldDeserializer;
        }
        return (FieldDeserializer) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:726:0x0759 */
    /* JADX DEBUG: Type inference failed for r2v90. Raw type applied. Possible types: java.lang.Class<?> */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x03a2, code lost:
        if (r14.matchStat == (-2)) goto L624;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x03fd, code lost:
        if (r14.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x04f5, code lost:
        if (r12.equals(r6) == false) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0524, code lost:
        r4 = r30;
        r2 = getSeeAlso(r4, r37.beanInfo, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x052c, code lost:
        if (r2 != null) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x052e, code lost:
        r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0534, code lost:
        if (r37.autoTypeCheckHandler == null) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0536, code lost:
        r6 = r37.autoTypeCheckHandler.handler(r1, r2, r14.getFeatures());
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0541, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0542, code lost:
        if (r6 != null) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0544, code lost:
        r6 = r4.checkAutoType(r1, r2, r14.getFeatures());
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x054d, code lost:
        r2 = r38.getConfig().getDeserializer(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0556, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0557, code lost:
        r4 = (T) r2.deserialze(r38, r6, r40);
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x055d, code lost:
        if ((r2 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x055f, code lost:
        r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0561, code lost:
        if (r12 == null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0563, code lost:
        r2 = r2.getFieldDeserializer(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0567, code lost:
        if (r2 == null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0569, code lost:
        r2.setValue((java.lang.Object) r4, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x056c, code lost:
        if (r3 == null) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x056e, code lost:
        r3.object = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0572, code lost:
        r38.setContext(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0575, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0737, code lost:
        r1 = r20;
        r2 = r22;
        r6 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:691:0x0a07, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r14.token()));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #12 {all -> 0x0051, blocks: (B:19:0x0041, B:21:0x0046, B:31:0x005c, B:33:0x0067, B:35:0x006f, B:41:0x0079, B:47:0x0088, B:54:0x009e, B:78:0x00f1, B:80:0x00f7, B:83:0x00ff, B:87:0x010d, B:90:0x0120, B:94:0x0127, B:99:0x0138, B:100:0x0141, B:101:0x0142, B:103:0x0163, B:104:0x016b, B:105:0x017e, B:110:0x0185), top: B:734:0x003f, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x05e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x069d A[Catch: all -> 0x06db, TryCatch #16 {all -> 0x06db, blocks: (B:427:0x05ee, B:429:0x05ff, B:444:0x0636, B:448:0x0650, B:473:0x069d, B:475:0x06ab, B:450:0x0658, B:452:0x065c, B:454:0x0660, B:456:0x0664, B:458:0x0668, B:460:0x066c, B:464:0x0676, B:466:0x067e, B:468:0x0689, B:470:0x0692, B:471:0x0698, B:481:0x06d0), top: B:740:0x05ee }] */
    /* JADX WARN: Removed duplicated region for block: B:474:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x072e A[Catch: all -> 0x0a10, TryCatch #9 {all -> 0x0a10, blocks: (B:689:0x09d6, B:496:0x0723, B:499:0x072e, B:501:0x0734, B:684:0x09c5, B:686:0x09cd, B:690:0x09e9, B:691:0x0a07, B:487:0x0702, B:489:0x0708, B:491:0x070e, B:494:0x071b, B:692:0x0a08, B:693:0x0a0f), top: B:729:0x09d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:639:0x0902 A[Catch: all -> 0x09be, TRY_ENTER, TryCatch #19 {all -> 0x09be, blocks: (B:505:0x0741, B:507:0x0747, B:520:0x076a, B:522:0x077a, B:524:0x0781, B:526:0x0785, B:527:0x078a, B:529:0x078e, B:530:0x0793, B:532:0x0797, B:533:0x079c, B:535:0x07a0, B:536:0x07a5, B:538:0x07a9, B:539:0x07ae, B:541:0x07b2, B:544:0x07b9, B:625:0x08d6, B:627:0x08d9, B:629:0x08dd, B:631:0x08e3, B:633:0x08ea, B:639:0x0902, B:640:0x090a, B:642:0x0910, B:644:0x0922, B:659:0x098a, B:665:0x0997, B:672:0x09a6, B:679:0x09b6, B:680:0x09bd, B:647:0x092d, B:648:0x0954), top: B:746:0x073d, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:704:0x0a27  */
    /* JADX WARN: Removed duplicated region for block: B:754:0x06b0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v35, types: [com.alibaba.fastjson.parser.deserializer.FieldDeserializer[]] */
    /* JADX WARN: Type inference failed for: r10v36, types: [com.alibaba.fastjson.parser.deserializer.FieldDeserializer] */
    /* JADX WARN: Type inference failed for: r41v15 */
    /* JADX WARN: Type inference failed for: r41v16 */
    /* JADX WARN: Type inference failed for: r41v3, types: [int] */
    /* JADX WARN: Type inference failed for: r41v6 */
    /* JADX WARN: Type inference failed for: r41v8 */
    /* JADX WARN: Type inference failed for: r41v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i2, int[] iArr) {
        InterceptResult invokeCommon;
        ParseContext parseContext;
        Throwable th;
        Object obj3;
        Object obj4;
        ParseContext parseContext2;
        int[] iArr2;
        Object obj5;
        Object obj6;
        DefaultFieldDeserializer defaultFieldDeserializer;
        Class cls;
        boolean z;
        FieldInfo fieldInfo;
        JSONField jSONField;
        Throwable th2;
        String str;
        ParserConfig parserConfig;
        boolean z2;
        String str2;
        Class cls2;
        int i3;
        Object obj7;
        int i4;
        ParserConfig parserConfig2;
        int[] iArr3;
        Class cls3;
        Class cls4;
        int i5;
        String str3;
        ParserConfig parserConfig3;
        boolean z3;
        String str4;
        Object obj8;
        String str5;
        Object obj9;
        byte b2;
        int i6;
        Class cls5;
        Class cls6;
        Class cls7;
        Object[] objArr;
        String str6;
        boolean z4;
        Class cls8;
        Object obj10;
        int i7;
        T t;
        Class cls9;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{defaultJSONParser, type, obj, obj2, Integer.valueOf(i2), iArr})) == null) {
            Class cls10 = Integer.class;
            Class cls11 = String.class;
            if (type != JSON.class && type != JSONObject.class) {
                JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
                ParserConfig config = defaultJSONParser.getConfig();
                int i8 = jSONLexerBase.token();
                ParseContext parseContext3 = null;
                if (i8 == 8) {
                    jSONLexerBase.nextToken(16);
                    return null;
                }
                ParseContext context = defaultJSONParser.getContext();
                if (obj2 != null && context != null) {
                    context = context.parent;
                }
                ParseContext parseContext4 = context;
                try {
                } catch (Throwable th3) {
                    th = th3;
                    obj3 = obj2;
                    th = th;
                    parseContext = parseContext4;
                    if (parseContext3 != null) {
                    }
                    defaultJSONParser.setContext(parseContext);
                    throw th;
                }
                if (i8 == 13) {
                    jSONLexerBase.nextToken(16);
                    T t2 = obj2 == null ? (T) createInstance(defaultJSONParser, type) : (T) obj2;
                    defaultJSONParser.setContext(parseContext4);
                    return t2;
                }
                int i9 = 14;
                if (i8 == 14) {
                    int i10 = Feature.SupportArrayToBean.mask;
                    if ((this.beanInfo.parserFeatures & i10) == 0 && !jSONLexerBase.isEnabled(Feature.SupportArrayToBean) && (i2 & i10) == 0) {
                        z5 = false;
                        if (z5) {
                            T t3 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                            defaultJSONParser.setContext(parseContext4);
                            return t3;
                        }
                    }
                    z5 = true;
                    if (z5) {
                    }
                }
                if (i8 != 12 && i8 != 16) {
                    if (jSONLexerBase.isBlankInput()) {
                        defaultJSONParser.setContext(parseContext4);
                        return null;
                    }
                    if (i8 == 4) {
                        try {
                            String stringVal = jSONLexerBase.stringVal();
                            if (stringVal.length() == 0) {
                                jSONLexerBase.nextToken();
                                defaultJSONParser.setContext(parseContext4);
                                return null;
                            } else if (this.beanInfo.jsonType != null) {
                                Class<?>[] seeAlso = this.beanInfo.jsonType.seeAlso();
                                int length = seeAlso.length;
                                int i11 = 0;
                                while (i11 < length) {
                                    Class<?> cls12 = seeAlso[i11];
                                    if (Enum.class.isAssignableFrom(cls12)) {
                                        try {
                                            T t4 = (T) Enum.valueOf(cls12, stringVal);
                                            defaultJSONParser.setContext(parseContext4);
                                            return t4;
                                        } catch (IllegalArgumentException unused) {
                                            continue;
                                        }
                                    }
                                    i11++;
                                    i9 = 14;
                                }
                            }
                        } catch (Throwable th4) {
                            obj3 = obj2;
                            th = th4;
                            parseContext = parseContext4;
                            parseContext3 = null;
                        }
                    }
                    if (i8 == i9) {
                        try {
                            if (jSONLexerBase.getCurrent() == ']') {
                                jSONLexerBase.next();
                                jSONLexerBase.nextToken();
                                defaultJSONParser.setContext(parseContext4);
                                return null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            parseContext3 = null;
                            obj3 = obj2;
                            th = th;
                            parseContext = parseContext4;
                            if (parseContext3 != null) {
                            }
                            defaultJSONParser.setContext(parseContext);
                            throw th;
                        }
                    }
                    parseContext3 = null;
                    if (this.beanInfo.factoryMethod != null && this.beanInfo.fields.length == 1) {
                        try {
                            FieldInfo fieldInfo2 = this.beanInfo.fields[0];
                            if (fieldInfo2.fieldClass == cls10) {
                                if (i8 == 2) {
                                    int intValue = jSONLexerBase.intValue();
                                    jSONLexerBase.nextToken();
                                    T t5 = (T) createFactoryInstance(config, Integer.valueOf(intValue));
                                    defaultJSONParser.setContext(parseContext4);
                                    return t5;
                                }
                            } else if (fieldInfo2.fieldClass == cls11 && i8 == 4) {
                                String stringVal2 = jSONLexerBase.stringVal();
                                jSONLexerBase.nextToken();
                                T t6 = (T) createFactoryInstance(config, stringVal2);
                                defaultJSONParser.setContext(parseContext4);
                                return t6;
                            }
                        } catch (Exception e2) {
                            throw new JSONException(e2.getMessage(), e2);
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("syntax error, expect {, actual ");
                    sb.append(jSONLexerBase.tokenName());
                    sb.append(", pos ");
                    sb.append(jSONLexerBase.pos());
                    if (obj instanceof String) {
                        sb.append(", fieldName ");
                        sb.append(obj);
                    }
                    sb.append(", fastjson-version ");
                    sb.append(JSON.VERSION);
                    throw new JSONException(sb.toString());
                }
                try {
                    if (defaultJSONParser.resolveStatus == 2) {
                        defaultJSONParser.resolveStatus = 0;
                    }
                    String str7 = this.beanInfo.typeKey;
                    obj3 = obj2;
                    int[] iArr4 = iArr;
                    ParseContext parseContext5 = null;
                    HashMap hashMap = null;
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        try {
                            if (i13 >= this.sortedFieldDeserializers.length || i12 >= 16) {
                                iArr2 = iArr4;
                                obj5 = i13;
                                obj6 = obj3;
                                defaultFieldDeserializer = null;
                                cls = null;
                                z = false;
                                fieldInfo = null;
                                jSONField = null;
                            } else {
                                try {
                                    ?? r10 = this.sortedFieldDeserializers[i13];
                                    int i14 = i13;
                                    FieldInfo fieldInfo3 = r10.fieldInfo;
                                    iArr2 = iArr4;
                                    Class cls13 = fieldInfo3.fieldClass;
                                    JSONField annotation = fieldInfo3.getAnnotation();
                                    if (annotation != null) {
                                        cls9 = cls13;
                                        if (r10 instanceof DefaultFieldDeserializer) {
                                            boolean z6 = ((DefaultFieldDeserializer) r10).customDeserilizer;
                                            obj6 = obj3;
                                            defaultFieldDeserializer = r10;
                                            fieldInfo = fieldInfo3;
                                            z = z6;
                                            cls = cls9;
                                            jSONField = annotation;
                                            obj5 = i14;
                                        }
                                    } else {
                                        cls9 = cls13;
                                    }
                                    cls = cls9;
                                    jSONField = annotation;
                                    obj6 = obj3;
                                    defaultFieldDeserializer = r10;
                                    fieldInfo = fieldInfo3;
                                    z = false;
                                    obj5 = i14;
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    th = th2;
                                    parseContext3 = parseContext5;
                                    parseContext = parseContext4;
                                    if (parseContext3 != null) {
                                    }
                                    defaultJSONParser.setContext(parseContext);
                                    throw th;
                                }
                            }
                            try {
                                if (defaultFieldDeserializer != null) {
                                    parserConfig = config;
                                    try {
                                        char[] cArr = fieldInfo.name_chars;
                                        if (z && jSONLexerBase.matchField(cArr)) {
                                            str = str7;
                                        } else {
                                            str = str7;
                                            if (cls != Integer.TYPE && cls != cls10) {
                                                if (cls != Long.TYPE && cls != Long.class) {
                                                    if (cls == cls11) {
                                                        str4 = jSONLexerBase.scanFieldString(cArr);
                                                        if (jSONLexerBase.matchStat <= 0) {
                                                            if (jSONLexerBase.matchStat == -2) {
                                                                i4 = obj5;
                                                                parseContext = parseContext4;
                                                                i3 = i12 + 1;
                                                                cls2 = cls10;
                                                                cls3 = cls11;
                                                                parserConfig2 = parserConfig;
                                                                str2 = str;
                                                                iArr3 = iArr2;
                                                                parseContext2 = parseContext5;
                                                            }
                                                            z2 = false;
                                                            z3 = false;
                                                            if (z2) {
                                                                i5 = i12;
                                                                cls2 = cls10;
                                                                cls4 = cls11;
                                                                obj8 = obj6;
                                                                parserConfig2 = parserConfig;
                                                                str3 = str;
                                                                str5 = null;
                                                            } else {
                                                                i5 = i12;
                                                                try {
                                                                    str5 = jSONLexerBase.scanSymbol(defaultJSONParser.symbolTable);
                                                                    if (str5 == null) {
                                                                        cls2 = cls10;
                                                                        int i15 = jSONLexerBase.token();
                                                                        cls4 = cls11;
                                                                        if (i15 == 13) {
                                                                            jSONLexerBase.nextToken(16);
                                                                            obj3 = (T) obj6;
                                                                            break;
                                                                        } else if (i15 == 16) {
                                                                        }
                                                                    } else {
                                                                        cls2 = cls10;
                                                                        cls4 = cls11;
                                                                    }
                                                                    if ("$ref" == str5 && parseContext4 != null) {
                                                                        jSONLexerBase.nextTokenWithColon(4);
                                                                        if (jSONLexerBase.token() == 4) {
                                                                            String stringVal3 = jSONLexerBase.stringVal();
                                                                            if ("@".equals(stringVal3)) {
                                                                                t = (T) parseContext4.object;
                                                                            } else if (IStringUtil.TOP_PATH.equals(stringVal3)) {
                                                                                ParseContext parseContext6 = parseContext4.parent;
                                                                                if (parseContext6.object != null) {
                                                                                    t = (T) parseContext6.object;
                                                                                } else {
                                                                                    defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext6, stringVal3));
                                                                                    defaultJSONParser.resolveStatus = 1;
                                                                                    t = (T) obj6;
                                                                                }
                                                                            } else if ("$".equals(stringVal3)) {
                                                                                ParseContext parseContext7 = parseContext4;
                                                                                while (parseContext7.parent != null) {
                                                                                    parseContext7 = parseContext7.parent;
                                                                                }
                                                                                if (parseContext7.object != null) {
                                                                                    t = (T) parseContext7.object;
                                                                                } else {
                                                                                    defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext7, stringVal3));
                                                                                    defaultJSONParser.resolveStatus = 1;
                                                                                    t = (T) obj6;
                                                                                }
                                                                            } else {
                                                                                if (stringVal3.indexOf(92) > 0) {
                                                                                    StringBuilder sb2 = new StringBuilder();
                                                                                    int i16 = 0;
                                                                                    while (i16 < stringVal3.length()) {
                                                                                        char charAt = stringVal3.charAt(i16);
                                                                                        if (charAt == '\\') {
                                                                                            i16++;
                                                                                            charAt = stringVal3.charAt(i16);
                                                                                        }
                                                                                        sb2.append(charAt);
                                                                                        i16++;
                                                                                    }
                                                                                    stringVal3 = sb2.toString();
                                                                                }
                                                                                Object resolveReference = defaultJSONParser.resolveReference(stringVal3);
                                                                                if (resolveReference != null) {
                                                                                    t = (T) resolveReference;
                                                                                } else {
                                                                                    defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext4, stringVal3));
                                                                                    defaultJSONParser.resolveStatus = 1;
                                                                                    t = (T) obj6;
                                                                                }
                                                                            }
                                                                            jSONLexerBase.nextToken(13);
                                                                            if (jSONLexerBase.token() == 13) {
                                                                                jSONLexerBase.nextToken(16);
                                                                                defaultJSONParser.setContext(parseContext4, t, obj);
                                                                                if (parseContext5 != null) {
                                                                                    parseContext5.object = t;
                                                                                }
                                                                                defaultJSONParser.setContext(parseContext4);
                                                                                return t;
                                                                            }
                                                                            throw new JSONException("illegal ref");
                                                                        }
                                                                        throw new JSONException("illegal ref, " + JSONToken.name(i7));
                                                                    }
                                                                    if (str != null) {
                                                                        str3 = str;
                                                                    } else {
                                                                        str3 = str;
                                                                    }
                                                                    if (JSON.DEFAULT_TYPE_KEY != str5) {
                                                                        obj8 = obj6;
                                                                        parserConfig2 = parserConfig;
                                                                    }
                                                                    try {
                                                                        jSONLexerBase.nextTokenWithColon(4);
                                                                        if (jSONLexerBase.token() == 4) {
                                                                            String stringVal4 = jSONLexerBase.stringVal();
                                                                            jSONLexerBase.nextToken(16);
                                                                            if (!stringVal4.equals(this.beanInfo.typeName) && !defaultJSONParser.isEnabled(Feature.IgnoreAutoType)) {
                                                                                break;
                                                                            }
                                                                            obj3 = (T) obj6;
                                                                            parserConfig3 = parserConfig;
                                                                            if (jSONLexerBase.token() == 13) {
                                                                                jSONLexerBase.nextToken();
                                                                                break;
                                                                            }
                                                                            i4 = obj5;
                                                                            obj6 = obj3;
                                                                            parseContext2 = parseContext5;
                                                                            parserConfig2 = parserConfig3;
                                                                            parseContext = parseContext4;
                                                                            str2 = str3;
                                                                            i3 = i5;
                                                                            cls3 = cls4;
                                                                            iArr3 = iArr2;
                                                                        } else {
                                                                            throw new JSONException("syntax error");
                                                                        }
                                                                    } catch (Throwable th7) {
                                                                        th2 = th7;
                                                                        obj3 = obj6;
                                                                        th = th2;
                                                                        parseContext3 = parseContext5;
                                                                        parseContext = parseContext4;
                                                                        if (parseContext3 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    parseContext3 = parseContext5;
                                                                    parseContext = parseContext4;
                                                                    obj3 = obj6;
                                                                }
                                                            }
                                                            if (obj8 == null || hashMap != null) {
                                                                parseContext2 = parseContext5;
                                                                str2 = str3;
                                                                iArr3 = iArr2;
                                                                obj9 = obj8;
                                                            } else {
                                                                try {
                                                                    obj9 = createInstance(defaultJSONParser, type);
                                                                    if (obj9 == null) {
                                                                        parseContext2 = parseContext5;
                                                                        try {
                                                                            str2 = str3;
                                                                            hashMap = new HashMap(this.fieldDeserializers.length);
                                                                        } catch (Throwable th9) {
                                                                            th = th9;
                                                                            parseContext = parseContext4;
                                                                            obj3 = obj9;
                                                                            parseContext3 = parseContext2;
                                                                            if (parseContext3 != null) {
                                                                            }
                                                                            defaultJSONParser.setContext(parseContext);
                                                                            throw th;
                                                                        }
                                                                    } else {
                                                                        parseContext2 = parseContext5;
                                                                        str2 = str3;
                                                                    }
                                                                    ParseContext context2 = defaultJSONParser.setContext(parseContext4, obj9, obj);
                                                                    if (iArr2 == null) {
                                                                        try {
                                                                            iArr3 = new int[(this.fieldDeserializers.length / 32) + 1];
                                                                        } catch (Throwable th10) {
                                                                            th = th10;
                                                                            parseContext3 = context2;
                                                                            parseContext = parseContext4;
                                                                            obj3 = obj9;
                                                                        }
                                                                    } else {
                                                                        iArr3 = iArr2;
                                                                    }
                                                                    parseContext2 = context2;
                                                                } catch (Throwable th11) {
                                                                    parseContext2 = parseContext5;
                                                                    th = th11;
                                                                    parseContext = parseContext4;
                                                                    obj3 = obj8;
                                                                }
                                                            }
                                                            HashMap hashMap2 = hashMap;
                                                            if (!z2) {
                                                                Class cls14 = cls4;
                                                                HashMap hashMap3 = hashMap2 == null ? new HashMap(this.fieldDeserializers.length) : hashMap2;
                                                                hashMap = hashMap2;
                                                                b2 = 0;
                                                                String str8 = str5;
                                                                Object obj11 = obj9;
                                                                parseContext = parseContext4;
                                                                obj7 = obj9;
                                                                i3 = i5;
                                                                i6 = 13;
                                                                HashMap hashMap4 = hashMap3;
                                                                i4 = obj5;
                                                                cls5 = cls14;
                                                                if (!parseField(defaultJSONParser, str8, obj11, type, hashMap4, iArr3)) {
                                                                    if (jSONLexerBase.token() == 13) {
                                                                        jSONLexerBase.nextToken();
                                                                        break;
                                                                    }
                                                                    cls3 = cls5;
                                                                    obj6 = obj7;
                                                                } else {
                                                                    if (jSONLexerBase.token() == 17) {
                                                                        throw new JSONException("syntax error, unexpect token ':'");
                                                                    }
                                                                    if (jSONLexerBase.token() != 16) {
                                                                    }
                                                                }
                                                            } else {
                                                                if (!z3) {
                                                                    defaultFieldDeserializer.parseField(defaultJSONParser, obj9, type, hashMap2);
                                                                    i4 = obj5;
                                                                    hashMap = hashMap2;
                                                                    parseContext = parseContext4;
                                                                    obj7 = obj9;
                                                                    i3 = i5;
                                                                    cls5 = cls4;
                                                                } else {
                                                                    if (obj9 == null) {
                                                                        hashMap2.put(fieldInfo.name, str4);
                                                                    } else if (str4 == null) {
                                                                        if (cls != Integer.TYPE && cls != Long.TYPE && cls != Float.TYPE && cls != Double.TYPE && cls != Boolean.TYPE) {
                                                                            defaultFieldDeserializer.setValue(obj9, str4);
                                                                        }
                                                                    } else {
                                                                        cls6 = cls4;
                                                                        if (cls == cls6 && ((i2 & Feature.TrimStringFieldValue.mask) != 0 || (this.beanInfo.parserFeatures & Feature.TrimStringFieldValue.mask) != 0 || (fieldInfo.parserFeatures & Feature.TrimStringFieldValue.mask) != 0)) {
                                                                            str4 = ((String) str4).trim();
                                                                        }
                                                                        defaultFieldDeserializer.setValue(obj9, str4);
                                                                        if (iArr3 == null) {
                                                                            int i17 = obj5 / 32;
                                                                            iArr3[i17] = (1 << (obj5 % 32)) | iArr3[i17];
                                                                        }
                                                                        if (jSONLexerBase.matchStat != 4) {
                                                                            hashMap = hashMap2;
                                                                            cls5 = cls6;
                                                                            parseContext = parseContext4;
                                                                            obj7 = obj9;
                                                                            b2 = 0;
                                                                            break;
                                                                        }
                                                                        i4 = obj5;
                                                                        hashMap = hashMap2;
                                                                        cls5 = cls6;
                                                                        parseContext = parseContext4;
                                                                        obj7 = obj9;
                                                                        i3 = i5;
                                                                    }
                                                                    cls6 = cls4;
                                                                    if (iArr3 == null) {
                                                                    }
                                                                    if (jSONLexerBase.matchStat != 4) {
                                                                    }
                                                                }
                                                                b2 = 0;
                                                                i6 = 13;
                                                                if (jSONLexerBase.token() != 16) {
                                                                    cls3 = cls5;
                                                                    obj6 = obj7;
                                                                } else if (jSONLexerBase.token() == i6) {
                                                                    jSONLexerBase.nextToken(16);
                                                                    break;
                                                                } else {
                                                                    cls3 = cls5;
                                                                    if (jSONLexerBase.token() == 18 || jSONLexerBase.token() == 1) {
                                                                        break;
                                                                    }
                                                                    obj6 = obj7;
                                                                }
                                                            }
                                                        }
                                                        z2 = true;
                                                        z3 = true;
                                                        if (z2) {
                                                        }
                                                        if (obj8 == null) {
                                                        }
                                                        parseContext2 = parseContext5;
                                                        str2 = str3;
                                                        iArr3 = iArr2;
                                                        obj9 = obj8;
                                                        HashMap hashMap22 = hashMap;
                                                        if (!z2) {
                                                        }
                                                    } else if (cls == Date.class && fieldInfo.format == null) {
                                                        str4 = jSONLexerBase.scanFieldDate(cArr);
                                                        if (jSONLexerBase.matchStat > 0) {
                                                            z2 = true;
                                                            z3 = true;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        } else {
                                                            if (jSONLexerBase.matchStat == -2) {
                                                                i4 = obj5;
                                                                parseContext = parseContext4;
                                                                i3 = i12 + 1;
                                                                cls2 = cls10;
                                                                cls3 = cls11;
                                                                parserConfig2 = parserConfig;
                                                                str2 = str;
                                                                iArr3 = iArr2;
                                                                parseContext2 = parseContext5;
                                                            }
                                                            z2 = false;
                                                            z3 = false;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap2222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        }
                                                    } else if (cls == BigDecimal.class) {
                                                        str4 = jSONLexerBase.scanFieldDecimal(cArr);
                                                        if (jSONLexerBase.matchStat > 0) {
                                                            z2 = true;
                                                            z3 = true;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap22222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        } else {
                                                            if (jSONLexerBase.matchStat == -2) {
                                                                i4 = obj5;
                                                                parseContext = parseContext4;
                                                                i3 = i12 + 1;
                                                                cls2 = cls10;
                                                                cls3 = cls11;
                                                                parserConfig2 = parserConfig;
                                                                str2 = str;
                                                                iArr3 = iArr2;
                                                                parseContext2 = parseContext5;
                                                            }
                                                            z2 = false;
                                                            z3 = false;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap222222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        }
                                                    } else if (cls == BigInteger.class) {
                                                        str4 = jSONLexerBase.scanFieldBigInteger(cArr);
                                                        if (jSONLexerBase.matchStat > 0) {
                                                            z2 = true;
                                                            z3 = true;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap2222222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        } else {
                                                            if (jSONLexerBase.matchStat == -2) {
                                                                i4 = obj5;
                                                                parseContext = parseContext4;
                                                                i3 = i12 + 1;
                                                                cls2 = cls10;
                                                                cls3 = cls11;
                                                                parserConfig2 = parserConfig;
                                                                str2 = str;
                                                                iArr3 = iArr2;
                                                                parseContext2 = parseContext5;
                                                            }
                                                            z2 = false;
                                                            z3 = false;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap22222222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        }
                                                    } else {
                                                        if (cls != Boolean.TYPE && cls != Boolean.class) {
                                                            if (cls != Float.TYPE && cls != Float.class) {
                                                                if (cls != Double.TYPE && cls != Double.class) {
                                                                    if (cls.isEnum() && (defaultJSONParser.getConfig().getDeserializer(cls) instanceof EnumDeserializer) && (jSONField == null || jSONField.deserializeUsing() == Void.class)) {
                                                                        if (defaultFieldDeserializer instanceof DefaultFieldDeserializer) {
                                                                            str4 = scanEnum(jSONLexerBase, cArr, defaultFieldDeserializer.fieldValueDeserilizer);
                                                                            if (jSONLexerBase.matchStat > 0) {
                                                                                z2 = true;
                                                                                z3 = true;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj8 == null) {
                                                                                }
                                                                                parseContext2 = parseContext5;
                                                                                str2 = str3;
                                                                                iArr3 = iArr2;
                                                                                obj9 = obj8;
                                                                                HashMap hashMap222222222 = hashMap;
                                                                                if (!z2) {
                                                                                }
                                                                            } else {
                                                                                if (jSONLexerBase.matchStat == -2) {
                                                                                    i4 = obj5;
                                                                                    parseContext = parseContext4;
                                                                                    i3 = i12 + 1;
                                                                                    cls2 = cls10;
                                                                                    cls3 = cls11;
                                                                                    parserConfig2 = parserConfig;
                                                                                    str2 = str;
                                                                                    iArr3 = iArr2;
                                                                                    parseContext2 = parseContext5;
                                                                                }
                                                                                z2 = false;
                                                                                z3 = false;
                                                                                if (z2) {
                                                                                }
                                                                                if (obj8 == null) {
                                                                                }
                                                                                parseContext2 = parseContext5;
                                                                                str2 = str3;
                                                                                iArr3 = iArr2;
                                                                                obj9 = obj8;
                                                                                HashMap hashMap2222222222 = hashMap;
                                                                                if (!z2) {
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (cls == int[].class) {
                                                                        str4 = jSONLexerBase.scanFieldIntArray(cArr);
                                                                        if (jSONLexerBase.matchStat > 0) {
                                                                            z2 = true;
                                                                            z3 = true;
                                                                            if (z2) {
                                                                            }
                                                                            if (obj8 == null) {
                                                                            }
                                                                            parseContext2 = parseContext5;
                                                                            str2 = str3;
                                                                            iArr3 = iArr2;
                                                                            obj9 = obj8;
                                                                            HashMap hashMap22222222222 = hashMap;
                                                                            if (!z2) {
                                                                            }
                                                                        } else {
                                                                            if (jSONLexerBase.matchStat == -2) {
                                                                                i4 = obj5;
                                                                                parseContext = parseContext4;
                                                                                i3 = i12 + 1;
                                                                                cls2 = cls10;
                                                                                cls3 = cls11;
                                                                                parserConfig2 = parserConfig;
                                                                                str2 = str;
                                                                                iArr3 = iArr2;
                                                                                parseContext2 = parseContext5;
                                                                            }
                                                                            z2 = false;
                                                                            z3 = false;
                                                                            if (z2) {
                                                                            }
                                                                            if (obj8 == null) {
                                                                            }
                                                                            parseContext2 = parseContext5;
                                                                            str2 = str3;
                                                                            iArr3 = iArr2;
                                                                            obj9 = obj8;
                                                                            HashMap hashMap222222222222 = hashMap;
                                                                            if (!z2) {
                                                                            }
                                                                        }
                                                                    } else if (cls == float[].class) {
                                                                        str4 = jSONLexerBase.scanFieldFloatArray(cArr);
                                                                        if (jSONLexerBase.matchStat > 0) {
                                                                            z2 = true;
                                                                            z3 = true;
                                                                            if (z2) {
                                                                            }
                                                                            if (obj8 == null) {
                                                                            }
                                                                            parseContext2 = parseContext5;
                                                                            str2 = str3;
                                                                            iArr3 = iArr2;
                                                                            obj9 = obj8;
                                                                            HashMap hashMap2222222222222 = hashMap;
                                                                            if (!z2) {
                                                                            }
                                                                        } else {
                                                                            if (jSONLexerBase.matchStat == -2) {
                                                                                i4 = obj5;
                                                                                parseContext = parseContext4;
                                                                                i3 = i12 + 1;
                                                                                cls2 = cls10;
                                                                                cls3 = cls11;
                                                                                parserConfig2 = parserConfig;
                                                                                str2 = str;
                                                                                iArr3 = iArr2;
                                                                                parseContext2 = parseContext5;
                                                                            }
                                                                            z2 = false;
                                                                            z3 = false;
                                                                            if (z2) {
                                                                            }
                                                                            if (obj8 == null) {
                                                                            }
                                                                            parseContext2 = parseContext5;
                                                                            str2 = str3;
                                                                            iArr3 = iArr2;
                                                                            obj9 = obj8;
                                                                            HashMap hashMap22222222222222 = hashMap;
                                                                            if (!z2) {
                                                                            }
                                                                        }
                                                                    } else if (cls == float[][].class) {
                                                                        str4 = jSONLexerBase.scanFieldFloatArray2(cArr);
                                                                        if (jSONLexerBase.matchStat > 0) {
                                                                            z2 = true;
                                                                            z3 = true;
                                                                            if (z2) {
                                                                            }
                                                                            if (obj8 == null) {
                                                                            }
                                                                            parseContext2 = parseContext5;
                                                                            str2 = str3;
                                                                            iArr3 = iArr2;
                                                                            obj9 = obj8;
                                                                            HashMap hashMap222222222222222 = hashMap;
                                                                            if (!z2) {
                                                                            }
                                                                        } else {
                                                                            if (jSONLexerBase.matchStat == -2) {
                                                                                i4 = obj5;
                                                                                parseContext = parseContext4;
                                                                                i3 = i12 + 1;
                                                                                cls2 = cls10;
                                                                                cls3 = cls11;
                                                                                parserConfig2 = parserConfig;
                                                                                str2 = str;
                                                                                iArr3 = iArr2;
                                                                                parseContext2 = parseContext5;
                                                                            }
                                                                            z2 = false;
                                                                            z3 = false;
                                                                            if (z2) {
                                                                            }
                                                                            if (obj8 == null) {
                                                                            }
                                                                            parseContext2 = parseContext5;
                                                                            str2 = str3;
                                                                            iArr3 = iArr2;
                                                                            obj9 = obj8;
                                                                            HashMap hashMap2222222222222222 = hashMap;
                                                                            if (!z2) {
                                                                            }
                                                                        }
                                                                    } else if (!jSONLexerBase.matchField(cArr)) {
                                                                        i5 = i12;
                                                                        cls2 = cls10;
                                                                        cls4 = cls11;
                                                                        obj3 = obj6;
                                                                        parserConfig3 = parserConfig;
                                                                        str3 = str;
                                                                        i4 = obj5;
                                                                        obj6 = obj3;
                                                                        parseContext2 = parseContext5;
                                                                        parserConfig2 = parserConfig3;
                                                                        parseContext = parseContext4;
                                                                        str2 = str3;
                                                                        i3 = i5;
                                                                        cls3 = cls4;
                                                                        iArr3 = iArr2;
                                                                    }
                                                                }
                                                                double scanFieldDouble = jSONLexerBase.scanFieldDouble(cArr);
                                                                str4 = (scanFieldDouble == 0.0d && jSONLexerBase.matchStat == 5) ? null : Double.valueOf(scanFieldDouble);
                                                                if (jSONLexerBase.matchStat > 0) {
                                                                    z2 = true;
                                                                    z3 = true;
                                                                    if (z2) {
                                                                    }
                                                                    if (obj8 == null) {
                                                                    }
                                                                    parseContext2 = parseContext5;
                                                                    str2 = str3;
                                                                    iArr3 = iArr2;
                                                                    obj9 = obj8;
                                                                    HashMap hashMap22222222222222222 = hashMap;
                                                                    if (!z2) {
                                                                    }
                                                                } else {
                                                                    if (jSONLexerBase.matchStat == -2) {
                                                                        i4 = obj5;
                                                                        parseContext = parseContext4;
                                                                        i3 = i12 + 1;
                                                                        cls2 = cls10;
                                                                        cls3 = cls11;
                                                                        parserConfig2 = parserConfig;
                                                                        str2 = str;
                                                                        iArr3 = iArr2;
                                                                        parseContext2 = parseContext5;
                                                                    }
                                                                    z2 = false;
                                                                    z3 = false;
                                                                    if (z2) {
                                                                    }
                                                                    if (obj8 == null) {
                                                                    }
                                                                    parseContext2 = parseContext5;
                                                                    str2 = str3;
                                                                    iArr3 = iArr2;
                                                                    obj9 = obj8;
                                                                    HashMap hashMap222222222222222222 = hashMap;
                                                                    if (!z2) {
                                                                    }
                                                                }
                                                            }
                                                            float scanFieldFloat = jSONLexerBase.scanFieldFloat(cArr);
                                                            str4 = (scanFieldFloat == 0.0f && jSONLexerBase.matchStat == 5) ? null : Float.valueOf(scanFieldFloat);
                                                            if (jSONLexerBase.matchStat > 0) {
                                                                z2 = true;
                                                                z3 = true;
                                                                if (z2) {
                                                                }
                                                                if (obj8 == null) {
                                                                }
                                                                parseContext2 = parseContext5;
                                                                str2 = str3;
                                                                iArr3 = iArr2;
                                                                obj9 = obj8;
                                                                HashMap hashMap2222222222222222222 = hashMap;
                                                                if (!z2) {
                                                                }
                                                            } else {
                                                                if (jSONLexerBase.matchStat == -2) {
                                                                    i4 = obj5;
                                                                    parseContext = parseContext4;
                                                                    i3 = i12 + 1;
                                                                    cls2 = cls10;
                                                                    cls3 = cls11;
                                                                    parserConfig2 = parserConfig;
                                                                    str2 = str;
                                                                    iArr3 = iArr2;
                                                                    parseContext2 = parseContext5;
                                                                }
                                                                z2 = false;
                                                                z3 = false;
                                                                if (z2) {
                                                                }
                                                                if (obj8 == null) {
                                                                }
                                                                parseContext2 = parseContext5;
                                                                str2 = str3;
                                                                iArr3 = iArr2;
                                                                obj9 = obj8;
                                                                HashMap hashMap22222222222222222222 = hashMap;
                                                                if (!z2) {
                                                                }
                                                            }
                                                        }
                                                        str4 = jSONLexerBase.matchStat == 5 ? null : Boolean.valueOf(jSONLexerBase.scanFieldBoolean(cArr));
                                                        if (jSONLexerBase.matchStat > 0) {
                                                            z2 = true;
                                                            z3 = true;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap222222222222222222222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        } else {
                                                            if (jSONLexerBase.matchStat == -2) {
                                                                i4 = obj5;
                                                                parseContext = parseContext4;
                                                                i3 = i12 + 1;
                                                                cls2 = cls10;
                                                                cls3 = cls11;
                                                                parserConfig2 = parserConfig;
                                                                str2 = str;
                                                                iArr3 = iArr2;
                                                                parseContext2 = parseContext5;
                                                            }
                                                            z2 = false;
                                                            z3 = false;
                                                            if (z2) {
                                                            }
                                                            if (obj8 == null) {
                                                            }
                                                            parseContext2 = parseContext5;
                                                            str2 = str3;
                                                            iArr3 = iArr2;
                                                            obj9 = obj8;
                                                            HashMap hashMap2222222222222222222222 = hashMap;
                                                            if (!z2) {
                                                            }
                                                        }
                                                    }
                                                    i13 = i4 + 1;
                                                    cls11 = cls3;
                                                    parseContext4 = parseContext;
                                                    iArr4 = iArr3;
                                                    config = parserConfig2;
                                                    i12 = i3;
                                                    obj3 = obj6;
                                                    parseContext5 = parseContext2;
                                                    cls10 = cls2;
                                                    str7 = str2;
                                                }
                                                long scanFieldLong = jSONLexerBase.scanFieldLong(cArr);
                                                str4 = (scanFieldLong == 0 && jSONLexerBase.matchStat == 5) ? null : Long.valueOf(scanFieldLong);
                                                if (jSONLexerBase.matchStat > 0) {
                                                    z2 = true;
                                                    z3 = true;
                                                    if (z2) {
                                                    }
                                                    if (obj8 == null) {
                                                    }
                                                    parseContext2 = parseContext5;
                                                    str2 = str3;
                                                    iArr3 = iArr2;
                                                    obj9 = obj8;
                                                    HashMap hashMap22222222222222222222222 = hashMap;
                                                    if (!z2) {
                                                    }
                                                    i13 = i4 + 1;
                                                    cls11 = cls3;
                                                    parseContext4 = parseContext;
                                                    iArr4 = iArr3;
                                                    config = parserConfig2;
                                                    i12 = i3;
                                                    obj3 = obj6;
                                                    parseContext5 = parseContext2;
                                                    cls10 = cls2;
                                                    str7 = str2;
                                                } else {
                                                    if (jSONLexerBase.matchStat == -2) {
                                                        i4 = obj5;
                                                        parseContext = parseContext4;
                                                        i3 = i12 + 1;
                                                        cls2 = cls10;
                                                        cls3 = cls11;
                                                        parserConfig2 = parserConfig;
                                                        str2 = str;
                                                        iArr3 = iArr2;
                                                        parseContext2 = parseContext5;
                                                        i13 = i4 + 1;
                                                        cls11 = cls3;
                                                        parseContext4 = parseContext;
                                                        iArr4 = iArr3;
                                                        config = parserConfig2;
                                                        i12 = i3;
                                                        obj3 = obj6;
                                                        parseContext5 = parseContext2;
                                                        cls10 = cls2;
                                                        str7 = str2;
                                                    }
                                                    z2 = false;
                                                    z3 = false;
                                                    if (z2) {
                                                    }
                                                    if (obj8 == null) {
                                                    }
                                                    parseContext2 = parseContext5;
                                                    str2 = str3;
                                                    iArr3 = iArr2;
                                                    obj9 = obj8;
                                                    HashMap hashMap222222222222222222222222 = hashMap;
                                                    if (!z2) {
                                                    }
                                                    i13 = i4 + 1;
                                                    cls11 = cls3;
                                                    parseContext4 = parseContext;
                                                    iArr4 = iArr3;
                                                    config = parserConfig2;
                                                    i12 = i3;
                                                    obj3 = obj6;
                                                    parseContext5 = parseContext2;
                                                    cls10 = cls2;
                                                    str7 = str2;
                                                }
                                            }
                                            int scanFieldInt = jSONLexerBase.scanFieldInt(cArr);
                                            str4 = (scanFieldInt == 0 && jSONLexerBase.matchStat == 5) ? null : Integer.valueOf(scanFieldInt);
                                            if (jSONLexerBase.matchStat > 0) {
                                                z2 = true;
                                                z3 = true;
                                                if (z2) {
                                                }
                                                if (obj8 == null) {
                                                }
                                                parseContext2 = parseContext5;
                                                str2 = str3;
                                                iArr3 = iArr2;
                                                obj9 = obj8;
                                                HashMap hashMap2222222222222222222222222 = hashMap;
                                                if (!z2) {
                                                }
                                                i13 = i4 + 1;
                                                cls11 = cls3;
                                                parseContext4 = parseContext;
                                                iArr4 = iArr3;
                                                config = parserConfig2;
                                                i12 = i3;
                                                obj3 = obj6;
                                                parseContext5 = parseContext2;
                                                cls10 = cls2;
                                                str7 = str2;
                                            }
                                        }
                                        z2 = true;
                                        str4 = null;
                                        z3 = false;
                                        if (z2) {
                                        }
                                        if (obj8 == null) {
                                        }
                                        parseContext2 = parseContext5;
                                        str2 = str3;
                                        iArr3 = iArr2;
                                        obj9 = obj8;
                                        HashMap hashMap22222222222222222222222222 = hashMap;
                                        if (!z2) {
                                        }
                                        i13 = i4 + 1;
                                        cls11 = cls3;
                                        parseContext4 = parseContext;
                                        iArr4 = iArr3;
                                        config = parserConfig2;
                                        i12 = i3;
                                        obj3 = obj6;
                                        parseContext5 = parseContext2;
                                        cls10 = cls2;
                                        str7 = str2;
                                    } catch (Throwable th12) {
                                        th = th12;
                                        parseContext3 = parseContext5;
                                        parseContext = parseContext4;
                                        obj3 = obj6;
                                    }
                                } else {
                                    str = str7;
                                    parserConfig = config;
                                }
                                i13 = i4 + 1;
                                cls11 = cls3;
                                parseContext4 = parseContext;
                                iArr4 = iArr3;
                                config = parserConfig2;
                                i12 = i3;
                                obj3 = obj6;
                                parseContext5 = parseContext2;
                                cls10 = cls2;
                                str7 = str2;
                            } catch (Throwable th13) {
                                th = th13;
                                obj3 = obj7;
                                parseContext3 = parseContext2;
                                if (parseContext3 != null) {
                                }
                                defaultJSONParser.setContext(parseContext);
                                throw th;
                            }
                            z2 = false;
                            str4 = null;
                            z3 = false;
                            if (z2) {
                            }
                            if (obj8 == null) {
                            }
                            parseContext2 = parseContext5;
                            str2 = str3;
                            iArr3 = iArr2;
                            obj9 = obj8;
                            HashMap hashMap222222222222222222222222222 = hashMap;
                            if (!z2) {
                            }
                        } catch (Throwable th14) {
                            parseContext2 = parseContext5;
                            parseContext = parseContext4;
                            th = th14;
                        }
                    }
                    parseContext3 = parseContext5;
                    parseContext = parseContext4;
                    HashMap hashMap5 = hashMap;
                    cls5 = cls4;
                    b2 = 0;
                    try {
                        if (obj3 != null) {
                            Object obj12 = obj3;
                        } else if (hashMap5 == null) {
                            T t7 = (T) createInstance(defaultJSONParser, type);
                            if (parseContext3 == null) {
                                parseContext3 = defaultJSONParser.setContext(parseContext, t7, obj);
                            }
                            if (parseContext3 != null) {
                                parseContext3.object = t7;
                            }
                            defaultJSONParser.setContext(parseContext);
                            return t7;
                        } else {
                            try {
                                String[] strArr = this.beanInfo.creatorConstructorParameters;
                                String str9 = "";
                                try {
                                    if (strArr != null) {
                                        objArr = new Object[strArr.length];
                                        int i18 = 0;
                                        while (i18 < strArr.length) {
                                            Object remove = hashMap5.remove(strArr[i18]);
                                            if (remove == null) {
                                                Type type2 = this.beanInfo.creatorConstructorParameterTypes[i18];
                                                FieldInfo fieldInfo4 = this.beanInfo.fields[i18];
                                                if (type2 == Byte.TYPE) {
                                                    remove = Byte.valueOf(b2);
                                                } else if (type2 == Short.TYPE) {
                                                    remove = Short.valueOf(b2);
                                                } else if (type2 == Integer.TYPE) {
                                                    remove = Integer.valueOf(b2);
                                                } else if (type2 == Long.TYPE) {
                                                    remove = 0L;
                                                } else if (type2 == Float.TYPE) {
                                                    remove = Float.valueOf(0.0f);
                                                } else if (type2 == Double.TYPE) {
                                                    remove = Double.valueOf(0.0d);
                                                } else if (type2 == Boolean.TYPE) {
                                                    remove = Boolean.FALSE;
                                                } else {
                                                    cls8 = cls5;
                                                    if (type2 == cls8 && (fieldInfo4.parserFeatures & Feature.InitStringFieldAsEmpty.mask) != 0) {
                                                        remove = "";
                                                    }
                                                }
                                                cls8 = cls5;
                                            } else {
                                                cls8 = cls5;
                                                if (this.beanInfo.creatorConstructorParameterTypes != null && i18 < this.beanInfo.creatorConstructorParameterTypes.length) {
                                                    Type type3 = this.beanInfo.creatorConstructorParameterTypes[i18];
                                                    if (type3 instanceof Class) {
                                                        Class cls15 = (Class) type3;
                                                        if (!cls15.isInstance(remove) && (remove instanceof List)) {
                                                            List list = (List) remove;
                                                            obj10 = obj3;
                                                            if (list.size() == 1) {
                                                                if (cls15.isInstance(list.get(0))) {
                                                                    remove = list.get(0);
                                                                }
                                                                objArr[i18] = remove;
                                                                i18++;
                                                                obj3 = (T) obj10;
                                                                cls5 = cls8;
                                                                b2 = 0;
                                                            }
                                                            objArr[i18] = remove;
                                                            i18++;
                                                            obj3 = (T) obj10;
                                                            cls5 = cls8;
                                                            b2 = 0;
                                                        }
                                                    }
                                                }
                                            }
                                            obj10 = obj3;
                                            objArr[i18] = remove;
                                            i18++;
                                            obj3 = (T) obj10;
                                            cls5 = cls8;
                                            b2 = 0;
                                        }
                                        obj5 = obj3;
                                        cls7 = cls5;
                                    } else {
                                        obj5 = obj3;
                                        cls7 = cls5;
                                        FieldInfo[] fieldInfoArr = this.beanInfo.fields;
                                        int length2 = fieldInfoArr.length;
                                        Object[] objArr2 = new Object[length2];
                                        int i19 = 0;
                                        while (i19 < length2) {
                                            FieldInfo fieldInfo5 = fieldInfoArr[i19];
                                            Object obj13 = hashMap5.get(fieldInfo5.name);
                                            if (obj13 == null) {
                                                Type type4 = fieldInfo5.fieldType;
                                                str6 = str9;
                                                if (type4 == Byte.TYPE) {
                                                    obj13 = (byte) 0;
                                                } else if (type4 == Short.TYPE) {
                                                    obj13 = (short) 0;
                                                } else if (type4 == Integer.TYPE) {
                                                    obj13 = 0;
                                                } else if (type4 == Long.TYPE) {
                                                    obj13 = 0L;
                                                } else if (type4 == Float.TYPE) {
                                                    obj13 = Float.valueOf(0.0f);
                                                } else if (type4 == Double.TYPE) {
                                                    obj13 = Double.valueOf(0.0d);
                                                } else if (type4 == Boolean.TYPE) {
                                                    obj13 = Boolean.FALSE;
                                                } else if (type4 == cls7 && (fieldInfo5.parserFeatures & Feature.InitStringFieldAsEmpty.mask) != 0) {
                                                    obj13 = str6;
                                                }
                                            } else {
                                                str6 = str9;
                                            }
                                            objArr2[i19] = obj13;
                                            i19++;
                                            str9 = str6;
                                        }
                                        objArr = objArr2;
                                    }
                                    if (this.beanInfo.creatorConstructor != null) {
                                        if (this.beanInfo.f31483kotlin) {
                                            int i20 = 0;
                                            while (true) {
                                                if (i20 >= objArr.length) {
                                                    break;
                                                } else if (objArr[i20] != null || this.beanInfo.fields == null || i20 >= this.beanInfo.fields.length) {
                                                    i20++;
                                                } else if (this.beanInfo.fields[i20].fieldClass == cls7) {
                                                    z4 = true;
                                                }
                                            }
                                        }
                                        z4 = false;
                                        if (z4) {
                                            try {
                                                if (this.beanInfo.kotlinDefaultConstructor != null) {
                                                    obj3 = this.beanInfo.kotlinDefaultConstructor.newInstance(new Object[0]);
                                                    for (int i21 = 0; i21 < objArr.length; i21++) {
                                                        try {
                                                            Object obj14 = objArr[i21];
                                                            if (obj14 != null && this.beanInfo.fields != null && i21 < this.beanInfo.fields.length) {
                                                                this.beanInfo.fields[i21].set(obj3, obj14);
                                                            }
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            throw new JSONException("create instance error, " + strArr + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.beanInfo.creatorConstructor.toGenericString(), e);
                                                        }
                                                    }
                                                    if (strArr != null) {
                                                        for (Map.Entry<String, Object> entry : hashMap5.entrySet()) {
                                                            FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
                                                            if (fieldDeserializer != null) {
                                                                fieldDeserializer.setValue(obj3, entry.getValue());
                                                            }
                                                        }
                                                    }
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                            }
                                        }
                                        obj3 = (T) this.beanInfo.creatorConstructor.newInstance(objArr);
                                        if (strArr != null) {
                                        }
                                    } else if (this.beanInfo.factoryMethod != null) {
                                        try {
                                            obj3 = this.beanInfo.factoryMethod.invoke(null, objArr);
                                        } catch (Exception e5) {
                                            throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e5);
                                        }
                                    } else {
                                        obj3 = obj5;
                                    }
                                    if (parseContext3 != null) {
                                        parseContext3.object = obj3;
                                    }
                                } catch (Throwable th15) {
                                    th = th15;
                                    obj4 = obj5;
                                    obj3 = obj4;
                                    th = th;
                                    if (parseContext3 != null) {
                                    }
                                    defaultJSONParser.setContext(parseContext);
                                    throw th;
                                }
                            } catch (Throwable th16) {
                                th = th16;
                                th = th;
                                if (parseContext3 != null) {
                                }
                                defaultJSONParser.setContext(parseContext);
                                throw th;
                            }
                        }
                        Method method = this.beanInfo.buildMethod;
                        if (method == null) {
                            if (parseContext3 != null) {
                                parseContext3.object = obj3;
                            }
                            defaultJSONParser.setContext(parseContext);
                            return (T) obj3;
                        }
                        try {
                            T t8 = (T) method.invoke(obj3, new Object[0]);
                            if (parseContext3 != null) {
                                parseContext3.object = obj3;
                            }
                            defaultJSONParser.setContext(parseContext);
                            return t8;
                        } catch (Exception e6) {
                            throw new JSONException("build object error", e6);
                        }
                    } catch (Throwable th17) {
                        th = th17;
                        th = th;
                        if (parseContext3 != null) {
                        }
                        defaultJSONParser.setContext(parseContext);
                        throw th;
                    }
                } catch (Throwable th18) {
                    th = th18;
                    parseContext = parseContext4;
                    obj4 = obj2;
                }
                if (parseContext3 != null) {
                    parseContext3.object = obj3;
                }
                defaultJSONParser.setContext(parseContext);
                throw th;
            }
            return (T) defaultJSONParser.parse();
        }
        return (T) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[LOOP:2: B:27:0x007a->B:28:0x007c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        ParserConfig.AutoTypeCheckHandler autoTypeCheckHandler;
        int length;
        int i2;
        int i3;
        int length2;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parserConfig, javaBeanInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        JSONType jSONType = javaBeanInfo.jsonType;
        HashMap hashMap = null;
        if (jSONType != null && jSONType.autoTypeCheckHandler() != ParserConfig.AutoTypeCheckHandler.class) {
            try {
                autoTypeCheckHandler = javaBeanInfo.jsonType.autoTypeCheckHandler().newInstance();
            } catch (Exception unused) {
            }
            this.autoTypeCheckHandler = autoTypeCheckHandler;
            FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
            this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
            length = fieldInfoArr.length;
            for (i3 = 0; i3 < length; i3++) {
                FieldInfo fieldInfo = javaBeanInfo.sortedFields[i3];
                FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
                this.sortedFieldDeserializers[i3] = createFieldDeserializer;
                if (length > 128) {
                    if (this.fieldDeserializerMap == null) {
                        this.fieldDeserializerMap = new HashMap();
                    }
                    this.fieldDeserializerMap.put(fieldInfo.name, createFieldDeserializer);
                }
                for (String str : fieldInfo.alternateNames) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(str, createFieldDeserializer);
                }
            }
            this.alterNameFieldDeserializers = hashMap;
            FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
            this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
            length2 = fieldInfoArr2.length;
            for (i2 = 0; i2 < length2; i2++) {
                this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
            }
        }
        autoTypeCheckHandler = null;
        this.autoTypeCheckHandler = autoTypeCheckHandler;
        FieldInfo[] fieldInfoArr3 = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr3.length];
        length = fieldInfoArr3.length;
        while (i3 < length) {
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr22 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr22.length];
        length2 = fieldInfoArr22.length;
        while (i2 < length2) {
        }
    }

    public FieldDeserializer getFieldDeserializer(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
            int i2 = 0;
            if (this.hashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i3 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i3 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i3] = TypeUtils.fnv1a_64(fieldDeserializerArr[i3].fieldInfo.name);
                    i3++;
                }
                Arrays.sort(jArr);
                this.hashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.hashArray, j2);
            if (binarySearch < 0) {
                return null;
            }
            if (this.hashArrayMapping == null) {
                short[] sArr = new short[this.hashArray.length];
                Arrays.fill(sArr, (short) -1);
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr2.length) {
                        break;
                    }
                    int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i2].fieldInfo.name));
                    if (binarySearch2 >= 0) {
                        sArr[binarySearch2] = (short) i2;
                    }
                    i2++;
                }
                this.hashArrayMapping = sArr;
            }
            short s = this.hashArrayMapping[binarySearch];
            if (s != -1) {
                return this.sortedFieldDeserializers[s];
            }
            return null;
        }
        return (FieldDeserializer) invokeJ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r6.method != null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        r9 = r7.getType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r9 != java.lang.Boolean.TYPE) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
        if (r1 != java.lang.Boolean.FALSE) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
        r7.setBoolean(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
        if (r1 != java.lang.Boolean.TRUE) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
        r7.setBoolean(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        if (r9 != java.lang.Integer.TYPE) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
        if ((r1 instanceof java.lang.Number) == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
        r7.setInt(r0, ((java.lang.Number) r1).intValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009b, code lost:
        if (r9 != java.lang.Long.TYPE) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009f, code lost:
        if ((r1 instanceof java.lang.Number) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
        r7.setLong(r0, ((java.lang.Number) r1).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
        if (r9 != java.lang.Float.TYPE) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b4, code lost:
        if ((r1 instanceof java.lang.Number) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b6, code lost:
        r7.setFloat(r0, ((java.lang.Number) r1).floatValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c3, code lost:
        if ((r1 instanceof java.lang.String) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c5, code lost:
        r1 = (java.lang.String) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cb, code lost:
        if (r1.length() > 10) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00cd, code lost:
        r1 = com.alibaba.fastjson.util.TypeUtils.parseFloat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d2, code lost:
        r1 = java.lang.Float.parseFloat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d6, code lost:
        r7.setFloat(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dd, code lost:
        if (r9 != java.lang.Double.TYPE) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e1, code lost:
        if ((r1 instanceof java.lang.Number) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e3, code lost:
        r7.setDouble(r0, ((java.lang.Number) r1).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f0, code lost:
        if ((r1 instanceof java.lang.String) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f2, code lost:
        r1 = (java.lang.String) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f8, code lost:
        if (r1.length() > 10) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00fa, code lost:
        r5 = com.alibaba.fastjson.util.TypeUtils.parseDouble(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ff, code lost:
        r5 = java.lang.Double.parseDouble(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0103, code lost:
        r7.setDouble(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0108, code lost:
        if (r1 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010e, code lost:
        if (r8 != r1.getClass()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0110, code lost:
        r7.set(r0, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLL;
        boolean z;
        Constructor<?> constructor;
        Integer num;
        Object cast;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, parserConfig)) == null) {
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            if (javaBeanInfo.creatorConstructor == null && javaBeanInfo.factoryMethod == null) {
                Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    FieldDeserializer smartMatch = smartMatch(entry.getKey());
                    if (smartMatch != null) {
                        FieldInfo fieldInfo = smartMatch.fieldInfo;
                        Field field = fieldInfo.field;
                        Type type = fieldInfo.fieldType;
                        Class<?> cls = fieldInfo.fieldClass;
                        JSONField annotation = fieldInfo.getAnnotation();
                        if (fieldInfo.declaringClass != null && (!cls.isInstance(value) || (annotation != null && annotation.deserializeUsing() != Void.class))) {
                            smartMatch.parseField(new DefaultJSONParser(JSON.toJSONString(value)), createInstance, type, null);
                        } else {
                            String str = fieldInfo.format;
                            if (str != null && type == Date.class) {
                                cast = TypeUtils.castToDate(value, str);
                            } else if (str != null && (type instanceof Class) && ((Class) type).getName().equals("java.time.LocalDateTime")) {
                                cast = Jdk8DateCodec.castToLocalDateTime(value, str);
                            } else if (type instanceof ParameterizedType) {
                                cast = TypeUtils.cast(value, (ParameterizedType) type, parserConfig);
                            } else {
                                cast = TypeUtils.cast(value, type, parserConfig);
                            }
                            smartMatch.setValue(createInstance, cast);
                        }
                    }
                }
                Method method = this.beanInfo.buildMethod;
                if (method != null) {
                    try {
                        return method.invoke(createInstance, new Object[0]);
                    } catch (Exception e2) {
                        throw new JSONException("build object error", e2);
                    }
                }
                return createInstance;
            }
            FieldInfo[] fieldInfoArr = this.beanInfo.fields;
            int length = fieldInfoArr.length;
            Object[] objArr = new Object[length];
            HashMap hashMap = null;
            for (int i2 = 0; i2 < length; i2++) {
                FieldInfo fieldInfo2 = fieldInfoArr[i2];
                char c2 = map.get(fieldInfo2.name);
                if (c2 == null) {
                    Class<?> cls2 = fieldInfo2.fieldClass;
                    if (cls2 == Integer.TYPE) {
                        c2 = 0;
                    } else if (cls2 == Long.TYPE) {
                        c2 = 0L;
                    } else if (cls2 == Short.TYPE) {
                        c2 = (short) 0;
                    } else if (cls2 == Byte.TYPE) {
                        c2 = (byte) 0;
                    } else if (cls2 == Float.TYPE) {
                        c2 = Float.valueOf(0.0f);
                    } else if (cls2 == Double.TYPE) {
                        c2 = Double.valueOf(0.0d);
                    } else if (cls2 == Character.TYPE) {
                        c2 = '0';
                    } else if (cls2 == Boolean.TYPE) {
                        c2 = Boolean.FALSE;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(fieldInfo2.name, Integer.valueOf(i2));
                }
                objArr[i2] = c2;
            }
            if (hashMap != null) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    Object value2 = entry2.getValue();
                    FieldDeserializer smartMatch2 = smartMatch(entry2.getKey());
                    if (smartMatch2 != null && (num = (Integer) hashMap.get(smartMatch2.fieldInfo.name)) != null) {
                        objArr[num.intValue()] = value2;
                    }
                }
            }
            JavaBeanInfo javaBeanInfo2 = this.beanInfo;
            if (javaBeanInfo2.creatorConstructor != null) {
                if (javaBeanInfo2.f31483kotlin) {
                    z = false;
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = objArr[i3];
                        if (obj == null) {
                            FieldInfo[] fieldInfoArr2 = this.beanInfo.fields;
                            if (fieldInfoArr2 != null && i3 < fieldInfoArr2.length && fieldInfoArr2[i3].fieldClass == String.class) {
                                z = true;
                            }
                        } else {
                            Class<?> cls3 = obj.getClass();
                            FieldInfo[] fieldInfoArr3 = this.beanInfo.fields;
                            if (cls3 != fieldInfoArr3[i3].fieldClass) {
                                objArr[i3] = TypeUtils.cast(obj, (Class<Object>) fieldInfoArr3[i3].fieldClass, parserConfig);
                            }
                        }
                    }
                } else {
                    z = false;
                }
                if (z && (constructor = this.beanInfo.kotlinDefaultConstructor) != null) {
                    try {
                        Object newInstance = constructor.newInstance(new Object[0]);
                        for (int i4 = 0; i4 < length; i4++) {
                            Object obj2 = objArr[i4];
                            if (obj2 != null && this.beanInfo.fields != null && i4 < this.beanInfo.fields.length) {
                                this.beanInfo.fields[i4].set(newInstance, obj2);
                            }
                        }
                        return newInstance;
                    } catch (Exception e3) {
                        throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e3);
                    }
                }
                try {
                    return this.beanInfo.creatorConstructor.newInstance(objArr);
                } catch (Exception e4) {
                    throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e4);
                }
            }
            Method method2 = javaBeanInfo2.factoryMethod;
            if (method2 != null) {
                try {
                    return method2.invoke(null, objArr);
                } catch (Exception e5) {
                    throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e5);
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
