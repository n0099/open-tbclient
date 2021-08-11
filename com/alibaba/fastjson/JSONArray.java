package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
/* loaded from: classes4.dex */
public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Type componentType;
    public final List<Object> list;
    public transient Object relatedArray;

    public JSONArray() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.list = new ArrayList();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, objectInputStream) == null) {
            JSONObject.SecureObjectInputStream.ensureFields();
            if (JSONObject.SecureObjectInputStream.fields != null && !JSONObject.SecureObjectInputStream.fields_error) {
                try {
                    new JSONObject.SecureObjectInputStream(objectInputStream).defaultReadObject();
                    return;
                } catch (NotActiveException unused) {
                }
            }
            objectInputStream.defaultReadObject();
            for (Object obj : this.list) {
                if (obj != null) {
                    String name = obj.getClass().getName();
                    if (TypeUtils.getClassFromMapping(name) == null) {
                        ParserConfig.global.checkAutoType(name, null);
                    }
                }
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.list.add(obj) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) ? this.list.addAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.list.clear();
        }
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new JSONArray(new ArrayList(this.list)) : invokeV.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? this.list.contains(obj) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, collection)) == null) ? this.list.containsAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? this.list.equals(obj) : invokeL.booleanValue;
    }

    public JSONArray fluentAdd(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            this.list.add(obj);
            return this;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONArray fluentAddAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, collection)) == null) {
            this.list.addAll(collection);
            return this;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONArray fluentClear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.list.clear();
            return this;
        }
        return (JSONArray) invokeV.objValue;
    }

    public JSONArray fluentRemove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            this.list.remove(obj);
            return this;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONArray fluentRemoveAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, collection)) == null) {
            this.list.removeAll(collection);
            return this;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONArray fluentRetainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, collection)) == null) {
            this.list.retainAll(collection);
            return this;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONArray fluentSet(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i2, obj)) == null) {
            set(i2, obj);
            return this;
        }
        return (JSONArray) invokeIL.objValue;
    }

    @Override // java.util.List
    public Object get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.list.get(i2) : invokeI.objValue;
    }

    public BigDecimal getBigDecimal(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? TypeUtils.castToBigDecimal(get(i2)) : (BigDecimal) invokeI.objValue;
    }

    public BigInteger getBigInteger(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? TypeUtils.castToBigInteger(get(i2)) : (BigInteger) invokeI.objValue;
    }

    public Boolean getBoolean(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            Object obj = get(i2);
            if (obj == null) {
                return null;
            }
            return TypeUtils.castToBoolean(obj);
        }
        return (Boolean) invokeI.objValue;
    }

    public boolean getBooleanValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            Object obj = get(i2);
            if (obj == null) {
                return false;
            }
            return TypeUtils.castToBoolean(obj).booleanValue();
        }
        return invokeI.booleanValue;
    }

    public Byte getByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? TypeUtils.castToByte(get(i2)) : (Byte) invokeI.objValue;
    }

    public byte getByteValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            Byte castToByte = TypeUtils.castToByte(get(i2));
            if (castToByte == null) {
                return (byte) 0;
            }
            return castToByte.byteValue();
        }
        return invokeI.byteValue;
    }

    public Type getComponentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.componentType : (Type) invokeV.objValue;
    }

    public Date getDate(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) ? TypeUtils.castToDate(get(i2)) : (Date) invokeI.objValue;
    }

    public Double getDouble(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? TypeUtils.castToDouble(get(i2)) : (Double) invokeI.objValue;
    }

    public double getDoubleValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            Double castToDouble = TypeUtils.castToDouble(get(i2));
            if (castToDouble == null) {
                return 0.0d;
            }
            return castToDouble.doubleValue();
        }
        return invokeI.doubleValue;
    }

    public Float getFloat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) ? TypeUtils.castToFloat(get(i2)) : (Float) invokeI.objValue;
    }

    public float getFloatValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            Float castToFloat = TypeUtils.castToFloat(get(i2));
            if (castToFloat == null) {
                return 0.0f;
            }
            return castToFloat.floatValue();
        }
        return invokeI.floatValue;
    }

    public int getIntValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            Integer castToInt = TypeUtils.castToInt(get(i2));
            if (castToInt == null) {
                return 0;
            }
            return castToInt.intValue();
        }
        return invokeI.intValue;
    }

    public Integer getInteger(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) ? TypeUtils.castToInt(get(i2)) : (Integer) invokeI.objValue;
    }

    public JSONArray getJSONArray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            Object obj = this.list.get(i2);
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
            if (obj instanceof List) {
                return new JSONArray((List) obj);
            }
            return (JSONArray) JSON.toJSON(obj);
        }
        return (JSONArray) invokeI.objValue;
    }

    public JSONObject getJSONObject(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            Object obj = this.list.get(i2);
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            return (JSONObject) JSON.toJSON(obj);
        }
        return (JSONObject) invokeI.objValue;
    }

    public Long getLong(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) ? TypeUtils.castToLong(get(i2)) : (Long) invokeI.objValue;
    }

    public long getLongValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            Long castToLong = TypeUtils.castToLong(get(i2));
            if (castToLong == null) {
                return 0L;
            }
            return castToLong.longValue();
        }
        return invokeI.longValue;
    }

    public <T> T getObject(int i2, Class<T> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i2, cls)) == null) ? (T) TypeUtils.castToJavaBean(this.list.get(i2), cls) : (T) invokeIL.objValue;
    }

    public Object getRelatedArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.relatedArray : invokeV.objValue;
    }

    public Short getShort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) ? TypeUtils.castToShort(get(i2)) : (Short) invokeI.objValue;
    }

    public short getShortValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
            Short castToShort = TypeUtils.castToShort(get(i2));
            if (castToShort == null) {
                return (short) 0;
            }
            return castToShort.shortValue();
        }
        return invokeI.shortValue;
    }

    public java.sql.Date getSqlDate(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) ? TypeUtils.castToSqlDate(get(i2)) : (java.sql.Date) invokeI.objValue;
    }

    public String getString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) ? TypeUtils.castToString(get(i2)) : (String) invokeI.objValue;
    }

    public Timestamp getTimestamp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) ? TypeUtils.castToTimestamp(get(i2)) : (Timestamp) invokeI.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.list.hashCode() : invokeV.intValue;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, obj)) == null) ? this.list.indexOf(obj) : invokeL.intValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.list.isEmpty() : invokeV.booleanValue;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.list.iterator() : (Iterator) invokeV.objValue;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, obj)) == null) ? this.list.lastIndexOf(obj) : invokeL.intValue;
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.list.listIterator() : (ListIterator) invokeV.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, obj)) == null) ? this.list.remove(obj) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, collection)) == null) ? this.list.removeAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, collection)) == null) ? this.list.retainAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List
    public Object set(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048633, this, i2, obj)) == null) {
            if (i2 == -1) {
                this.list.add(obj);
                return null;
            } else if (this.list.size() <= i2) {
                for (int size = this.list.size(); size < i2; size++) {
                    this.list.add(null);
                }
                this.list.add(obj);
                return null;
            } else {
                return this.list.set(i2, obj);
            }
        }
        return invokeIL.objValue;
    }

    public void setComponentType(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, type) == null) {
            this.componentType = type;
        }
    }

    public void setRelatedArray(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, obj) == null) {
            this.relatedArray = obj;
        }
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.list.size() : invokeV.intValue;
    }

    @Override // java.util.List
    public List<Object> subList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048637, this, i2, i3)) == null) ? this.list.subList(i2, i3) : (List) invokeII.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.list.toArray() : (Object[]) invokeV.objValue;
    }

    public <T> List<T> toJavaList(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, cls)) == null) {
            ArrayList arrayList = new ArrayList(size());
            ParserConfig globalInstance = ParserConfig.getGlobalInstance();
            Iterator<Object> it = iterator();
            while (it.hasNext()) {
                arrayList.add(TypeUtils.cast(it.next(), (Class<Object>) cls, globalInstance));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // java.util.List
    public void add(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, obj) == null) {
            this.list.add(i2, obj);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.util.Collection<?>] */
    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends Object> collection) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, collection)) == null) ? this.list.addAll(i2, collection) : invokeIL.booleanValue;
    }

    public JSONArray fluentAdd(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, obj)) == null) {
            this.list.add(i2, obj);
            return this;
        }
        return (JSONArray) invokeIL.objValue;
    }

    public JSONArray fluentAddAll(int i2, Collection<?> collection) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, collection)) == null) {
            this.list.addAll(i2, collection);
            return this;
        }
        return (JSONArray) invokeIL.objValue;
    }

    public JSONArray fluentRemove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.list.remove(i2);
            return this;
        }
        return (JSONArray) invokeI.objValue;
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) ? this.list.listIterator(i2) : (ListIterator) invokeI.objValue;
    }

    @Override // java.util.List
    public Object remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) ? this.list.remove(i2) : invokeI.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, tArr)) == null) ? (T[]) this.list.toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
    }

    public JSONArray(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (list != null) {
            this.list = list;
            return;
        }
        throw new IllegalArgumentException("list is null.");
    }

    public <T> T getObject(int i2, Type type) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i2, type)) == null) {
            Object obj = this.list.get(i2);
            if (type instanceof Class) {
                return (T) TypeUtils.castToJavaBean(obj, (Class) type);
            }
            return (T) JSON.parseObject(JSON.toJSONString(obj), type, new Feature[0]);
        }
        return (T) invokeIL.objValue;
    }

    public JSONArray(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.list = new ArrayList(i2);
    }
}
