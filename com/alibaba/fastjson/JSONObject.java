package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes.dex */
public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Object> map;

    /* loaded from: classes.dex */
    public static class SecureObjectInputStream extends ObjectInputStream {
        public static /* synthetic */ Interceptable $ic;
        public static Field[] fields;
        public static volatile boolean fields_error;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SecureObjectInputStream(ObjectInputStream objectInputStream) throws IOException {
            super(objectInputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectInputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            for (int i4 = 0; i4 < fields.length; i4++) {
                try {
                    Field field = fields[i4];
                    field.set(this, field.get(objectInputStream));
                } catch (IllegalAccessException unused) {
                    fields_error = true;
                    return;
                }
            }
        }

        public static void ensureFields() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, null) == null) && fields == null && !fields_error) {
                try {
                    Field[] declaredFields = ObjectInputStream.class.getDeclaredFields();
                    String[] strArr = {"bin", "passHandle", "handles", "curContext"};
                    Field[] fieldArr = new Field[4];
                    for (int i2 = 0; i2 < 4; i2++) {
                        Field field = TypeUtils.getField(ObjectInputStream.class, strArr[i2], declaredFields);
                        field.setAccessible(true);
                        fieldArr[i2] = field;
                    }
                    fields = fieldArr;
                } catch (Throwable unused) {
                    fields_error = true;
                }
            }
        }

        @Override // java.io.ObjectInputStream
        public void readStreamHeader() throws IOException, StreamCorruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objectStreamClass)) == null) {
                String name = objectStreamClass.getName();
                if (name.length() > 2) {
                    int lastIndexOf = name.lastIndexOf(91);
                    if (lastIndexOf != -1) {
                        name = name.substring(lastIndexOf + 1);
                    }
                    if (name.length() > 2 && name.charAt(0) == 'L' && name.charAt(name.length() - 1) == ';') {
                        name = name.substring(1, name.length() - 1);
                    }
                    if (TypeUtils.getClassFromMapping(name) == null) {
                        ParserConfig.global.checkAutoType(name, null, Feature.SupportAutoType.mask);
                    }
                }
                return super.resolveClass(objectStreamClass);
            }
            return (Class) invokeL.objValue;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveProxyClass(String[] strArr) throws IOException, ClassNotFoundException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                for (String str : strArr) {
                    if (TypeUtils.getClassFromMapping(str) == null) {
                        ParserConfig.global.checkAutoType(str, null);
                    }
                }
                return super.resolveProxyClass(strArr);
            }
            return (Class) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONObject() {
        this(16, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, objectInputStream) == null) {
            SecureObjectInputStream.ensureFields();
            if (SecureObjectInputStream.fields != null && !SecureObjectInputStream.fields_error) {
                try {
                    new SecureObjectInputStream(objectInputStream).defaultReadObject();
                    return;
                } catch (NotActiveException unused) {
                }
            }
            objectInputStream.defaultReadObject();
            for (Map.Entry<String, Object> entry : this.map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    ParserConfig.global.checkAutoType(key.getClass());
                }
                Object value = entry.getValue();
                if (value != null) {
                    ParserConfig.global.checkAutoType(value.getClass());
                }
            }
        }
    }

    @Override // java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.map.clear();
        }
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new JSONObject(this.map instanceof LinkedHashMap ? new LinkedHashMap(this.map) : new HashMap(this.map));
        }
        return invokeV.objValue;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            boolean containsKey = this.map.containsKey(obj);
            return !containsKey ? ((obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean) || (obj instanceof UUID)) ? this.map.containsKey(obj.toString()) : containsKey : containsKey;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.map.containsValue(obj) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.map.entrySet() : (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.map.equals(obj) : invokeL.booleanValue;
    }

    public JSONObject fluentClear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.map.clear();
            return this;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject fluentPut(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, obj)) == null) {
            this.map.put(str, obj);
            return this;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public JSONObject fluentPutAll(Map<? extends String, ?> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map)) == null) {
            this.map.putAll(map);
            return this;
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject fluentRemove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            this.map.remove(obj);
            return this;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            Object obj2 = this.map.get(obj);
            return obj2 == null ? ((obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean) || (obj instanceof UUID)) ? this.map.get(obj.toString()) : obj2 : obj2;
        }
        return invokeL.objValue;
    }

    public BigDecimal getBigDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? TypeUtils.castToBigDecimal(get(str)) : (BigDecimal) invokeL.objValue;
    }

    public BigInteger getBigInteger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? TypeUtils.castToBigInteger(get(str)) : (BigInteger) invokeL.objValue;
    }

    public Boolean getBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Object obj = get(str);
            if (obj == null) {
                return null;
            }
            return TypeUtils.castToBoolean(obj);
        }
        return (Boolean) invokeL.objValue;
    }

    public boolean getBooleanValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Boolean castToBoolean = TypeUtils.castToBoolean(get(str));
            if (castToBoolean == null) {
                return false;
            }
            return castToBoolean.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public Byte getByte(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? TypeUtils.castToByte(get(str)) : (Byte) invokeL.objValue;
    }

    public byte getByteValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            Byte castToByte = TypeUtils.castToByte(get(str));
            if (castToByte == null) {
                return (byte) 0;
            }
            return castToByte.byteValue();
        }
        return invokeL.byteValue;
    }

    public byte[] getBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            Object obj = get(str);
            if (obj == null) {
                return null;
            }
            return TypeUtils.castToBytes(obj);
        }
        return (byte[]) invokeL.objValue;
    }

    public Date getDate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? TypeUtils.castToDate(get(str)) : (Date) invokeL.objValue;
    }

    public Double getDouble(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? TypeUtils.castToDouble(get(str)) : (Double) invokeL.objValue;
    }

    public double getDoubleValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            Double castToDouble = TypeUtils.castToDouble(get(str));
            if (castToDouble == null) {
                return 0.0d;
            }
            return castToDouble.doubleValue();
        }
        return invokeL.doubleValue;
    }

    public Float getFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? TypeUtils.castToFloat(get(str)) : (Float) invokeL.objValue;
    }

    public float getFloatValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            Float castToFloat = TypeUtils.castToFloat(get(str));
            if (castToFloat == null) {
                return 0.0f;
            }
            return castToFloat.floatValue();
        }
        return invokeL.floatValue;
    }

    public Map<String, Object> getInnerMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.map : (Map) invokeV.objValue;
    }

    public int getIntValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            Integer castToInt = TypeUtils.castToInt(get(str));
            if (castToInt == null) {
                return 0;
            }
            return castToInt.intValue();
        }
        return invokeL.intValue;
    }

    public Integer getInteger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? TypeUtils.castToInt(get(str)) : (Integer) invokeL.objValue;
    }

    public JSONArray getJSONArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            Object obj = this.map.get(str);
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
            if (obj instanceof List) {
                return new JSONArray((List) obj);
            }
            if (obj instanceof String) {
                return (JSONArray) JSON.parse((String) obj);
            }
            return (JSONArray) JSON.toJSON(obj);
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONObject getJSONObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Object obj = this.map.get(str);
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            if (obj instanceof String) {
                return JSON.parseObject((String) obj);
            }
            return (JSONObject) JSON.toJSON(obj);
        }
        return (JSONObject) invokeL.objValue;
    }

    public Long getLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? TypeUtils.castToLong(get(str)) : (Long) invokeL.objValue;
    }

    public long getLongValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            Long castToLong = TypeUtils.castToLong(get(str));
            if (castToLong == null) {
                return 0L;
            }
            return castToLong.longValue();
        }
        return invokeL.longValue;
    }

    public <T> T getObject(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, str, cls)) == null) ? (T) TypeUtils.castToJavaBean(this.map.get(str), cls) : (T) invokeLL.objValue;
    }

    public Short getShort(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) ? TypeUtils.castToShort(get(str)) : (Short) invokeL.objValue;
    }

    public short getShortValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            Short castToShort = TypeUtils.castToShort(get(str));
            if (castToShort == null) {
                return (short) 0;
            }
            return castToShort.shortValue();
        }
        return invokeL.shortValue;
    }

    public java.sql.Date getSqlDate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) ? TypeUtils.castToSqlDate(get(str)) : (java.sql.Date) invokeL.objValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            Object obj = get(str);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public Timestamp getTimestamp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) ? TypeUtils.castToTimestamp(get(str)) : (Timestamp) invokeL.objValue;
    }

    @Override // java.util.Map
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.map.hashCode() : invokeV.intValue;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        InterceptResult invokeLLL;
        String substring;
        String substring2;
        String substring3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, obj, method, objArr)) == null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            String str = null;
            if (parameterTypes.length == 1) {
                if (method.getName().equals("equals")) {
                    return Boolean.valueOf(equals(objArr[0]));
                }
                if (method.getReturnType() == Void.TYPE) {
                    JSONField jSONField = (JSONField) TypeUtils.getAnnotation(method, JSONField.class);
                    String name = (jSONField == null || jSONField.name().length() == 0) ? null : jSONField.name();
                    if (name == null) {
                        String name2 = method.getName();
                        if (name2.startsWith("set")) {
                            if (name2.substring(3).length() != 0) {
                                name = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                            } else {
                                throw new JSONException("illegal setter");
                            }
                        } else {
                            throw new JSONException("illegal setter");
                        }
                    }
                    this.map.put(name, objArr[0]);
                    return null;
                }
                throw new JSONException("illegal setter");
            } else if (parameterTypes.length == 0) {
                if (method.getReturnType() != Void.TYPE) {
                    JSONField jSONField2 = (JSONField) TypeUtils.getAnnotation(method, JSONField.class);
                    if (jSONField2 != null && jSONField2.name().length() != 0) {
                        str = jSONField2.name();
                    }
                    if (str == null) {
                        String name3 = method.getName();
                        if (name3.startsWith("get")) {
                            if (name3.substring(3).length() != 0) {
                                str = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                            } else {
                                throw new JSONException("illegal getter");
                            }
                        } else if (name3.startsWith("is")) {
                            if (name3.substring(2).length() != 0) {
                                str = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                            } else {
                                throw new JSONException("illegal getter");
                            }
                        } else if (name3.startsWith("hashCode")) {
                            return Integer.valueOf(hashCode());
                        } else {
                            if (name3.startsWith("toString")) {
                                return toString();
                            }
                            throw new JSONException("illegal getter");
                        }
                    }
                    return TypeUtils.cast(this.map.get(str), method.getGenericReturnType(), ParserConfig.getGlobalInstance());
                }
                throw new JSONException("illegal getter");
            } else {
                throw new UnsupportedOperationException(method.toGenericString());
            }
        }
        return invokeLLL.objValue;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.map.isEmpty() : invokeV.booleanValue;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.map.keySet() : (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Map<? extends java.lang.String, ?>] */
    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, map) == null) {
            this.map.putAll(map);
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, obj)) == null) ? this.map.remove(obj) : invokeL.objValue;
    }

    @Override // java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.map.size() : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.alibaba.fastjson.JSONObject */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.JSON
    public <T> T toJavaObject(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, cls)) == null) ? (cls == Map.class || cls == JSONObject.class || cls == JSON.class) ? this : (cls != Object.class || containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) TypeUtils.castToJavaBean(this, cls, ParserConfig.getGlobalInstance()) : this : (T) invokeL.objValue;
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.map.values() : (Collection) invokeV.objValue;
    }

    public JSONObject(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (map != null) {
            this.map = map;
            return;
        }
        throw new IllegalArgumentException("map is null.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public Object put(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, str, obj)) == null) ? this.map.put(str, obj) : invokeLL.objValue;
    }

    public <T> T getObject(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, str, type)) == null) ? (T) TypeUtils.cast(this.map.get(str), type, ParserConfig.getGlobalInstance()) : (T) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.alibaba.fastjson.JSONObject */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T toJavaObject(Class<T> cls, ParserConfig parserConfig, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048624, this, cls, parserConfig, i2)) == null) ? cls == Map.class ? this : (cls != Object.class || containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) TypeUtils.castToJavaBean(this, cls, parserConfig) : this : (T) invokeLLI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONObject(boolean z) {
        this(16, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65540, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65540, newInitContext);
                return;
            }
        }
    }

    public <T> T getObject(String str, TypeReference typeReference) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, typeReference)) == null) {
            T t = (T) this.map.get(str);
            return typeReference == null ? t : (T) TypeUtils.cast(t, typeReference.getType(), ParserConfig.getGlobalInstance());
        }
        return (T) invokeLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONObject(int i2) {
        this(i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public JSONObject(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (z) {
            this.map = new LinkedHashMap(i2);
        } else {
            this.map = new HashMap(i2);
        }
    }
}
