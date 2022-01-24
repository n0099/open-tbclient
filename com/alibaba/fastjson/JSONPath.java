package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class JSONPath implements JSONAware {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long LENGTH = -1580386065683472715L;
    public static final long SIZE = 5614464919154503228L;
    public static ConcurrentMap<String, JSONPath> pathCache;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasRefSegment;
    public ParserConfig parserConfig;
    public final String path;
    public Segment[] segments;
    public SerializeConfig serializeConfig;

    /* renamed from: com.alibaba.fastjson.JSONPath$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1920371107, "Lcom/alibaba/fastjson/JSONPath$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1920371107, "Lcom/alibaba/fastjson/JSONPath$1;");
                    return;
                }
            }
            int[] iArr = new int[Operator.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = iArr;
            try {
                iArr[Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class ArrayAccessSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int index;

        public ArrayAccessSegment(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.index = i2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) ? jSONPath.getArrayItem(obj2, this.index) : invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) && ((JSONLexerBase) defaultJSONParser.lexer).seekArrayToItem(this.index) && context.eval) {
                context.object = defaultJSONParser.parse();
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONPath, obj)) == null) ? jSONPath.removeArrayItem(jSONPath, obj, this.index) : invokeLL.booleanValue;
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, jSONPath, obj, obj2)) == null) ? jSONPath.setArrayItem(jSONPath, obj, this.index, obj2) : invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class Context {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean eval;
        public Object object;
        public final Context parent;

        public Context(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = context;
            this.eval = z;
        }
    }

    /* loaded from: classes9.dex */
    public static class DoubleOpSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Operator op;
        public final double value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoubleOpSegement(String str, boolean z, double d2, Operator operator) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Double.valueOf(d2), operator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = d2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 != null && (obj4 instanceof Number)) {
                    double doubleValue = ((Number) obj4).doubleValue();
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            return doubleValue == this.value;
                        case 2:
                            return doubleValue != this.value;
                        case 3:
                            return doubleValue >= this.value;
                        case 4:
                            return doubleValue > this.value;
                        case 5:
                            return doubleValue <= this.value;
                        case 6:
                            return doubleValue < this.value;
                        default:
                            return false;
                    }
                }
                return false;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* loaded from: classes9.dex */
    public static class FilterGroup implements Filter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean and;
        public List<Filter> fitlers;

        public FilterGroup(Filter filter, Filter filter2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {filter, filter2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList(2);
            this.fitlers = arrayList;
            arrayList.add(filter);
            this.fitlers.add(filter2);
            this.and = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                if (this.and) {
                    for (Filter filter : this.fitlers) {
                        if (!filter.apply(jSONPath, obj, obj2, obj3)) {
                            return false;
                        }
                    }
                    return true;
                }
                for (Filter filter2 : this.fitlers) {
                    if (filter2.apply(jSONPath, obj, obj2, obj3)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class FilterSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Filter filter;

        public FilterSegment(Filter filter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {filter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                if (obj2 == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                if (obj2 instanceof Iterable) {
                    for (Object obj3 : (Iterable) obj2) {
                        if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                            jSONArray.add(obj3);
                        }
                    }
                    return jSONArray;
                } else if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                    return obj2;
                } else {
                    return null;
                }
            }
            return invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                Object parse = defaultJSONParser.parse();
                context.object = eval(jSONPath, parse, parse);
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONPath, obj, obj2)) == null) {
                if (obj2 != null && (obj2 instanceof Iterable)) {
                    Iterator it = ((Iterable) obj2).iterator();
                    while (it.hasNext()) {
                        if (this.filter.apply(jSONPath, obj, obj2, it.next())) {
                            it.remove();
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class FloorSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public static final FloorSegment instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1298856539, "Lcom/alibaba/fastjson/JSONPath$FloorSegment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1298856539, "Lcom/alibaba/fastjson/JSONPath$FloorSegment;");
                    return;
                }
            }
            instance = new FloorSegment();
        }

        public FloorSegment() {
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

        public static Object floor(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Float) {
                    return Double.valueOf(Math.floor(((Float) obj).floatValue()));
                }
                if (obj instanceof Double) {
                    return Double.valueOf(Math.floor(((Double) obj).doubleValue()));
                }
                if (obj instanceof BigDecimal) {
                    return ((BigDecimal) obj).setScale(0, RoundingMode.FLOOR);
                }
                if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                    return obj;
                }
                throw new UnsupportedOperationException();
            }
            return invokeL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                if (obj2 instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) ((JSONArray) obj2).clone();
                    for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                        Object obj3 = jSONArray.get(i2);
                        Object floor = floor(obj3);
                        if (floor != obj3) {
                            jSONArray.set(i2, floor);
                        }
                    }
                    return jSONArray;
                }
                return floor(obj2);
            }
            return invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class IntBetweenSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long endValue;
        public final boolean not;
        public final long startValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntBetweenSegement(String str, boolean z, long j2, long j3, boolean z2) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startValue = j2;
            this.endValue = j3;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 == null) {
                    return false;
                }
                if (obj4 instanceof Number) {
                    long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                    if (longExtractValue >= this.startValue && longExtractValue <= this.endValue) {
                        return !this.not;
                    }
                }
                return this.not;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class IntInSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean not;
        public final long[] values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntInSegement(String str, boolean z, long[] jArr, boolean z2) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), jArr, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.values = jArr;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 == null) {
                    return false;
                }
                if (obj4 instanceof Number) {
                    long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                    for (long j2 : this.values) {
                        if (j2 == longExtractValue) {
                            return !this.not;
                        }
                    }
                }
                return this.not;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class IntObjInSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean not;
        public final Long[] values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntObjInSegement(String str, boolean z, Long[] lArr, boolean z2) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), lArr, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.values = lArr;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                int i2 = 0;
                if (obj4 == null) {
                    Long[] lArr = this.values;
                    int length = lArr.length;
                    while (i2 < length) {
                        if (lArr[i2] == null) {
                            return !this.not;
                        }
                        i2++;
                    }
                    return this.not;
                }
                if (obj4 instanceof Number) {
                    long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                    Long[] lArr2 = this.values;
                    int length2 = lArr2.length;
                    while (i2 < length2) {
                        Long l = lArr2[i2];
                        if (l != null && l.longValue() == longExtractValue) {
                            return !this.not;
                        }
                        i2++;
                    }
                }
                return this.not;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class IntOpSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Operator op;
        public final long value;
        public BigDecimal valueDecimal;
        public Double valueDouble;
        public Float valueFloat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntOpSegement(String str, boolean z, long j2, Operator operator) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Long.valueOf(j2), operator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = j2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 != null && (obj4 instanceof Number)) {
                    if (obj4 instanceof BigDecimal) {
                        if (this.valueDecimal == null) {
                            this.valueDecimal = BigDecimal.valueOf(this.value);
                        }
                        int compareTo = this.valueDecimal.compareTo((BigDecimal) obj4);
                        switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                            case 1:
                                return compareTo == 0;
                            case 2:
                                return compareTo != 0;
                            case 3:
                                return compareTo <= 0;
                            case 4:
                                return compareTo < 0;
                            case 5:
                                return compareTo >= 0;
                            case 6:
                                return compareTo > 0;
                            default:
                                return false;
                        }
                    } else if (obj4 instanceof Float) {
                        if (this.valueFloat == null) {
                            this.valueFloat = Float.valueOf((float) this.value);
                        }
                        int compareTo2 = this.valueFloat.compareTo((Float) obj4);
                        switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                            case 1:
                                return compareTo2 == 0;
                            case 2:
                                return compareTo2 != 0;
                            case 3:
                                return compareTo2 <= 0;
                            case 4:
                                return compareTo2 < 0;
                            case 5:
                                return compareTo2 >= 0;
                            case 6:
                                return compareTo2 > 0;
                            default:
                                return false;
                        }
                    } else if (obj4 instanceof Double) {
                        if (this.valueDouble == null) {
                            this.valueDouble = Double.valueOf(this.value);
                        }
                        int compareTo3 = this.valueDouble.compareTo((Double) obj4);
                        switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                            case 1:
                                return compareTo3 == 0;
                            case 2:
                                return compareTo3 != 0;
                            case 3:
                                return compareTo3 <= 0;
                            case 4:
                                return compareTo3 < 0;
                            case 5:
                                return compareTo3 >= 0;
                            case 6:
                                return compareTo3 > 0;
                            default:
                                return false;
                        }
                    } else {
                        long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                        switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                            case 1:
                                return longExtractValue == this.value;
                            case 2:
                                return longExtractValue != this.value;
                            case 3:
                                return longExtractValue >= this.value;
                            case 4:
                                return longExtractValue > this.value;
                            case 5:
                                return longExtractValue <= this.value;
                            case 6:
                                return longExtractValue < this.value;
                            default:
                                return false;
                        }
                    }
                }
                return false;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class JSONPathParser {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Pattern strArrayPatternx;
        public static final String strArrayRegex = "'\\s*,\\s*'";
        public transient /* synthetic */ FieldHolder $fh;
        public char ch;
        public boolean hasRefSegment;
        public int level;
        public final String path;
        public int pos;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-773045450, "Lcom/alibaba/fastjson/JSONPath$JSONPathParser;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-773045450, "Lcom/alibaba/fastjson/JSONPath$JSONPathParser;");
                    return;
                }
            }
            strArrayPatternx = Pattern.compile(strArrayRegex);
        }

        public JSONPathParser(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.path = str;
            next();
        }

        public static boolean isDigitFirst(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == '-' || c2 == '+' || (c2 >= '0' && c2 <= '9') : invokeCommon.booleanValue;
        }

        public void accept(char c2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)}) == null) {
                if (this.ch == ' ') {
                    next();
                }
                if (this.ch == c2) {
                    if (isEOF()) {
                        return;
                    }
                    next();
                    return;
                }
                throw new JSONPathException("expect '" + c2 + ", but '" + this.ch + "'");
            }
        }

        public Segment buildArraySegement(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                int length = str.length();
                char charAt = str.charAt(0);
                int i2 = length - 1;
                char charAt2 = str.charAt(i2);
                int indexOf = str.indexOf(44);
                if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                    String substring = str.substring(1, i2);
                    if (indexOf != -1 && strArrayPatternx.matcher(str).find()) {
                        return new MultiPropertySegment(substring.split(strArrayRegex));
                    }
                    return new PropertySegment(substring, false);
                }
                int indexOf2 = str.indexOf(58);
                if (indexOf == -1 && indexOf2 == -1) {
                    if (TypeUtils.isNumber(str)) {
                        try {
                            return new ArrayAccessSegment(Integer.parseInt(str));
                        } catch (NumberFormatException unused) {
                            return new PropertySegment(str, false);
                        }
                    }
                    if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                        str = str.substring(1, str.length() - 1);
                    }
                    return new PropertySegment(str, false);
                } else if (indexOf != -1) {
                    String[] split = str.split(",");
                    int[] iArr = new int[split.length];
                    for (int i3 = 0; i3 < split.length; i3++) {
                        iArr[i3] = Integer.parseInt(split[i3]);
                    }
                    return new MultiIndexSegment(iArr);
                } else if (indexOf2 != -1) {
                    String[] split2 = str.split(":");
                    int length2 = split2.length;
                    int[] iArr2 = new int[length2];
                    for (int i4 = 0; i4 < split2.length; i4++) {
                        String str2 = split2[i4];
                        if (str2.length() != 0) {
                            iArr2[i4] = Integer.parseInt(str2);
                        } else if (i4 == 0) {
                            iArr2[i4] = 0;
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    int i5 = iArr2[0];
                    int i6 = length2 > 1 ? iArr2[1] : -1;
                    int i7 = length2 == 3 ? iArr2[2] : 1;
                    if (i6 < 0 || i6 >= i5) {
                        if (i7 > 0) {
                            return new RangeSegment(i5, i6, i7);
                        }
                        throw new UnsupportedOperationException("step must greater than zero : " + i7);
                    }
                    throw new UnsupportedOperationException("end must greater than or equals start. start " + i5 + ",  end " + i6);
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            return (Segment) invokeL.objValue;
        }

        public Segment[] explain() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.path;
                if (str != null && str.length() != 0) {
                    Segment[] segmentArr = new Segment[8];
                    while (true) {
                        Segment readSegement = readSegement();
                        if (readSegement == null) {
                            break;
                        }
                        if (readSegement instanceof PropertySegment) {
                            PropertySegment propertySegment = (PropertySegment) readSegement;
                            if (!propertySegment.deep && propertySegment.propertyName.equals("*")) {
                            }
                        }
                        int i2 = this.level;
                        if (i2 == segmentArr.length) {
                            Segment[] segmentArr2 = new Segment[(i2 * 3) / 2];
                            System.arraycopy(segmentArr, 0, segmentArr2, 0, i2);
                            segmentArr = segmentArr2;
                        }
                        int i3 = this.level;
                        this.level = i3 + 1;
                        segmentArr[i3] = readSegement;
                    }
                    int i4 = this.level;
                    if (i4 == segmentArr.length) {
                        return segmentArr;
                    }
                    Segment[] segmentArr3 = new Segment[i4];
                    System.arraycopy(segmentArr, 0, segmentArr3, 0, i4);
                    return segmentArr3;
                }
                throw new IllegalArgumentException();
            }
            return (Segment[]) invokeV.objValue;
        }

        public Filter filterRest(Filter filter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, filter)) == null) {
                boolean z = true;
                boolean z2 = this.ch == '&';
                if ((this.ch == '&' && getNextChar() == '&') || (this.ch == '|' && getNextChar() == '|')) {
                    next();
                    next();
                    if (this.ch == '(') {
                        next();
                    } else {
                        z = false;
                    }
                    while (this.ch == ' ') {
                        next();
                    }
                    FilterGroup filterGroup = new FilterGroup(filter, (Filter) parseArrayAccessFilter(false), z2);
                    if (z && this.ch == ')') {
                        next();
                    }
                    return filterGroup;
                }
                return filter;
            }
            return (Filter) invokeL.objValue;
        }

        public char getNextChar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.path.charAt(this.pos) : invokeV.charValue;
        }

        public boolean isEOF() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pos >= this.path.length() : invokeV.booleanValue;
        }

        public void next() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                String str = this.path;
                int i2 = this.pos;
                this.pos = i2 + 1;
                this.ch = str.charAt(i2);
            }
        }

        public Segment parseArrayAccess(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                Object parseArrayAccessFilter = parseArrayAccessFilter(z);
                if (parseArrayAccessFilter instanceof Segment) {
                    return (Segment) parseArrayAccessFilter;
                }
                return new FilterSegment((Filter) parseArrayAccessFilter);
            }
            return (Segment) invokeZ.objValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x007f, code lost:
            r4 = r26.pos;
         */
        /* JADX WARN: Removed duplicated region for block: B:52:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x011f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object parseArrayAccessFilter(boolean z) {
            InterceptResult invokeZ;
            int i2;
            boolean z2;
            boolean z3;
            char c2;
            char c3;
            char c4;
            char c5;
            char c6;
            Filter nullSegement;
            char c7;
            String str;
            String[] strArr;
            String str2;
            String str3;
            Filter matchSegement;
            Operator operator;
            Filter stringOpSegement;
            char c8;
            Filter valueSegment;
            char c9;
            Filter valueSegment2;
            char c10;
            Filter notNullSegement;
            char c11;
            int i3;
            Filter doubleOpSegement;
            char c12;
            char c13;
            char c14;
            char c15;
            int i4;
            String substring;
            String replaceAll;
            int i5;
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) != null) {
                return invokeZ.objValue;
            }
            if (z) {
                accept('[');
            }
            if (this.ch == '?') {
                next();
                accept('(');
                i2 = 1;
                while (this.ch == '(') {
                    next();
                    i2++;
                }
                z2 = true;
            } else {
                i2 = 0;
                z2 = false;
            }
            skipWhitespace();
            if (!z2 && !IOUtils.firstIdentifier(this.ch) && !Character.isJavaIdentifierStart(this.ch) && (c15 = this.ch) != '\\' && c15 != '@') {
                int i6 = this.pos - 1;
                while (true) {
                    char c16 = this.ch;
                    if (c16 == ']' || c16 == '/' || isEOF() || !(this.ch != '.' || z2 || z2 || c15 == '\'')) {
                        break;
                    }
                    if (this.ch == '\\') {
                        next();
                    }
                    next();
                }
                char c17 = this.ch;
                if (c17 != '/' && c17 != '.') {
                    i4 = this.pos;
                    substring = this.path.substring(i6, i4);
                    if (substring.indexOf(92) != 0) {
                    }
                    if (substring.indexOf(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) == -1) {
                    }
                } else {
                    int i7 = this.pos;
                    i4 = i7 - 1;
                    substring = this.path.substring(i6, i4);
                    if (substring.indexOf(92) != 0) {
                        StringBuilder sb = new StringBuilder(substring.length());
                        int i8 = 0;
                        while (i8 < substring.length()) {
                            char charAt2 = substring.charAt(i8);
                            if (charAt2 == '\\' && i8 < substring.length() - 1 && ((charAt = substring.charAt((i5 = i8 + 1))) == '@' || charAt2 == '\\' || charAt2 == '\"')) {
                                sb.append(charAt);
                                i8 = i5;
                            } else {
                                sb.append(charAt2);
                            }
                            i8++;
                        }
                        substring = sb.toString();
                    }
                    if (substring.indexOf(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) == -1) {
                        if (c15 == '\'' && substring.length() > 2 && substring.charAt(substring.length() - 1) == c15) {
                            replaceAll = substring.substring(1, substring.length() - 1);
                        } else {
                            replaceAll = substring.replaceAll("\\\\\\.", EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                            if (replaceAll.indexOf("\\-") != -1) {
                                replaceAll = replaceAll.replaceAll("\\\\-", "-");
                            }
                        }
                        if (z2) {
                            accept(')');
                        }
                        return new PropertySegment(replaceAll, false);
                    }
                    Segment buildArraySegement = buildArraySegement(substring);
                    if (z && !isEOF()) {
                        accept(']');
                    }
                    return buildArraySegement;
                }
            } else {
                if (this.ch == '@') {
                    next();
                    accept('.');
                }
                String readName = readName();
                skipWhitespace();
                if (z2 && this.ch == ')') {
                    next();
                    Filter notNullSegement2 = new NotNullSegement(readName, false);
                    while (true) {
                        c14 = this.ch;
                        if (c14 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c14 == '&' || c14 == '|') {
                        notNullSegement2 = filterRest(notNullSegement2);
                    }
                    if (z) {
                        accept(']');
                    }
                    return notNullSegement2;
                } else if (z && this.ch == ']') {
                    if (isEOF() && readName.equals("last")) {
                        return new MultiIndexSegment(new int[]{-1});
                    }
                    next();
                    Filter notNullSegement3 = new NotNullSegement(readName, false);
                    while (true) {
                        c13 = this.ch;
                        if (c13 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c13 == '&' || c13 == '|') {
                        notNullSegement3 = filterRest(notNullSegement3);
                    }
                    accept(')');
                    if (z2) {
                        accept(')');
                    }
                    if (z) {
                        accept(']');
                    }
                    return notNullSegement3;
                } else {
                    skipWhitespace();
                    if (this.ch == '(') {
                        next();
                        accept(')');
                        skipWhitespace();
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Operator readOp = readOp();
                    skipWhitespace();
                    if (readOp != Operator.BETWEEN && readOp != Operator.NOT_BETWEEN) {
                        if (readOp != Operator.IN && readOp != Operator.NOT_IN) {
                            char c18 = this.ch;
                            if (c18 != '\'' && c18 != '\"') {
                                if (isDigitFirst(c18)) {
                                    long readLongValue = readLongValue();
                                    double readDoubleValue = this.ch == '.' ? readDoubleValue(readLongValue) : 0.0d;
                                    if (readDoubleValue == 0.0d) {
                                        doubleOpSegement = new IntOpSegement(readName, z3, readLongValue, readOp);
                                    } else {
                                        doubleOpSegement = new DoubleOpSegement(readName, z3, readDoubleValue, readOp);
                                    }
                                    while (true) {
                                        c12 = this.ch;
                                        if (c12 != ' ') {
                                            break;
                                        }
                                        next();
                                    }
                                    if (i2 > 1 && c12 == ')') {
                                        next();
                                    }
                                    char c19 = this.ch;
                                    if (c19 == '&' || c19 == '|') {
                                        doubleOpSegement = filterRest(doubleOpSegement);
                                    }
                                    if (z2) {
                                        accept(')');
                                    }
                                    if (z) {
                                        accept(']');
                                    }
                                    return doubleOpSegement;
                                }
                                char c20 = this.ch;
                                if (c20 == '$') {
                                    RefOpSegement refOpSegement = new RefOpSegement(readName, z3, readSegement(), readOp);
                                    this.hasRefSegment = true;
                                    while (this.ch == ' ') {
                                        next();
                                    }
                                    if (z2) {
                                        accept(')');
                                    }
                                    if (z) {
                                        accept(']');
                                    }
                                    return refOpSegement;
                                } else if (c20 == '/') {
                                    StringBuilder sb2 = new StringBuilder();
                                    while (true) {
                                        next();
                                        char c21 = this.ch;
                                        if (c21 == '/') {
                                            break;
                                        } else if (c21 == '\\') {
                                            next();
                                            sb2.append(this.ch);
                                        } else {
                                            sb2.append(c21);
                                        }
                                    }
                                    next();
                                    if (this.ch == 'i') {
                                        next();
                                        i3 = 2;
                                    } else {
                                        i3 = 0;
                                    }
                                    RegMatchSegement regMatchSegement = new RegMatchSegement(readName, z3, Pattern.compile(sb2.toString(), i3), readOp);
                                    if (z2) {
                                        accept(')');
                                    }
                                    if (z) {
                                        accept(']');
                                    }
                                    return regMatchSegement;
                                } else {
                                    if (c20 == 'n') {
                                        if (StringUtil.NULL_STRING.equals(readName())) {
                                            if (readOp == Operator.EQ) {
                                                notNullSegement = new NullSegement(readName, z3);
                                            } else {
                                                notNullSegement = readOp == Operator.NE ? new NotNullSegement(readName, z3) : null;
                                            }
                                            if (notNullSegement != null) {
                                                while (true) {
                                                    c11 = this.ch;
                                                    if (c11 != ' ') {
                                                        break;
                                                    }
                                                    next();
                                                }
                                                if (c11 == '&' || c11 == '|') {
                                                    notNullSegement = filterRest(notNullSegement);
                                                }
                                            }
                                            if (z2) {
                                                accept(')');
                                            }
                                            accept(']');
                                            if (notNullSegement != null) {
                                                return notNullSegement;
                                            }
                                            throw new UnsupportedOperationException();
                                        }
                                    } else if (c20 == 't') {
                                        if ("true".equals(readName())) {
                                            if (readOp == Operator.EQ) {
                                                valueSegment2 = new ValueSegment(readName, z3, Boolean.TRUE, true);
                                            } else {
                                                valueSegment2 = readOp == Operator.NE ? new ValueSegment(readName, z3, Boolean.TRUE, false) : null;
                                            }
                                            if (valueSegment2 != null) {
                                                while (true) {
                                                    c10 = this.ch;
                                                    if (c10 != ' ') {
                                                        break;
                                                    }
                                                    next();
                                                }
                                                if (c10 == '&' || c10 == '|') {
                                                    valueSegment2 = filterRest(valueSegment2);
                                                }
                                            }
                                            if (z2) {
                                                accept(')');
                                            }
                                            accept(']');
                                            if (valueSegment2 != null) {
                                                return valueSegment2;
                                            }
                                            throw new UnsupportedOperationException();
                                        }
                                    } else if (c20 == 'f' && "false".equals(readName())) {
                                        if (readOp == Operator.EQ) {
                                            valueSegment = new ValueSegment(readName, z3, Boolean.FALSE, true);
                                        } else {
                                            valueSegment = readOp == Operator.NE ? new ValueSegment(readName, z3, Boolean.FALSE, false) : null;
                                        }
                                        if (valueSegment != null) {
                                            while (true) {
                                                c9 = this.ch;
                                                if (c9 != ' ') {
                                                    break;
                                                }
                                                next();
                                            }
                                            if (c9 == '&' || c9 == '|') {
                                                valueSegment = filterRest(valueSegment);
                                            }
                                        }
                                        if (z2) {
                                            accept(')');
                                        }
                                        accept(']');
                                        if (valueSegment != null) {
                                            return valueSegment;
                                        }
                                        throw new UnsupportedOperationException();
                                    }
                                    throw new UnsupportedOperationException();
                                }
                            }
                            String readString = readString();
                            if (readOp == Operator.RLIKE) {
                                matchSegement = new RlikeSegement(readName, z3, readString, false);
                            } else {
                                if (readOp == Operator.NOT_RLIKE) {
                                    stringOpSegement = new RlikeSegement(readName, z3, readString, true);
                                } else if (readOp != Operator.LIKE && readOp != Operator.NOT_LIKE) {
                                    matchSegement = new StringOpSegement(readName, z3, readString, readOp);
                                } else {
                                    while (readString.indexOf("%%") != -1) {
                                        readString = readString.replaceAll("%%", "%");
                                    }
                                    boolean z4 = readOp == Operator.NOT_LIKE;
                                    int indexOf = readString.indexOf(37);
                                    if (indexOf == -1) {
                                        if (readOp == Operator.LIKE) {
                                            operator = Operator.EQ;
                                        } else {
                                            operator = Operator.NE;
                                        }
                                        stringOpSegement = new StringOpSegement(readName, z3, readString, operator);
                                    } else {
                                        String[] split = readString.split("%");
                                        if (indexOf == 0) {
                                            if (readString.charAt(readString.length() - 1) == '%') {
                                                int length = split.length - 1;
                                                String[] strArr2 = new String[length];
                                                System.arraycopy(split, 1, strArr2, 0, length);
                                                strArr = strArr2;
                                                str = null;
                                                str2 = null;
                                                matchSegement = new MatchSegement(readName, z3, str, str2, strArr, z4);
                                            } else {
                                                String str4 = split[split.length - 1];
                                                if (split.length > 2) {
                                                    int length2 = split.length - 2;
                                                    String[] strArr3 = new String[length2];
                                                    System.arraycopy(split, 1, strArr3, 0, length2);
                                                    str2 = str4;
                                                    strArr = strArr3;
                                                    str = null;
                                                } else {
                                                    str2 = str4;
                                                    str = null;
                                                    strArr = null;
                                                }
                                                matchSegement = new MatchSegement(readName, z3, str, str2, strArr, z4);
                                            }
                                        } else {
                                            if (readString.charAt(readString.length() - 1) == '%') {
                                                if (split.length == 1) {
                                                    str3 = split[0];
                                                } else {
                                                    strArr = split;
                                                    str = null;
                                                    str2 = null;
                                                    matchSegement = new MatchSegement(readName, z3, str, str2, strArr, z4);
                                                }
                                            } else if (split.length == 1) {
                                                str3 = split[0];
                                            } else {
                                                if (split.length == 2) {
                                                    str = split[0];
                                                    str2 = split[1];
                                                    strArr = null;
                                                } else {
                                                    String str5 = split[0];
                                                    String str6 = split[split.length - 1];
                                                    int length3 = split.length - 2;
                                                    String[] strArr4 = new String[length3];
                                                    System.arraycopy(split, 1, strArr4, 0, length3);
                                                    str = str5;
                                                    strArr = strArr4;
                                                    str2 = str6;
                                                }
                                                matchSegement = new MatchSegement(readName, z3, str, str2, strArr, z4);
                                            }
                                            str = str3;
                                            str2 = null;
                                            strArr = null;
                                            matchSegement = new MatchSegement(readName, z3, str, str2, strArr, z4);
                                        }
                                    }
                                }
                                matchSegement = stringOpSegement;
                            }
                            while (true) {
                                c8 = this.ch;
                                if (c8 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c8 == '&' || c8 == '|') {
                                matchSegement = filterRest(matchSegement);
                            }
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return matchSegement;
                        }
                        boolean z5 = readOp == Operator.NOT_IN;
                        accept('(');
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.add(readValue());
                        while (true) {
                            skipWhitespace();
                            if (this.ch != ',') {
                                break;
                            }
                            next();
                            jSONArray.add(readValue());
                        }
                        boolean z6 = true;
                        boolean z7 = true;
                        boolean z8 = true;
                        for (Object obj : jSONArray) {
                            if (obj != null) {
                                Class<?> cls = obj.getClass();
                                if (z6 && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class) {
                                    z6 = false;
                                    z8 = false;
                                }
                                if (z7 && cls != String.class) {
                                    z7 = false;
                                }
                            } else if (z6) {
                                z6 = false;
                            }
                        }
                        if (jSONArray.size() == 1 && jSONArray.get(0) == null) {
                            if (z5) {
                                nullSegement = new NotNullSegement(readName, z3);
                            } else {
                                nullSegement = new NullSegement(readName, z3);
                            }
                            while (true) {
                                c7 = this.ch;
                                if (c7 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c7 == '&' || c7 == '|') {
                                nullSegement = filterRest(nullSegement);
                            }
                            accept(')');
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return nullSegement;
                        } else if (z6) {
                            if (jSONArray.size() == 1) {
                                Filter intOpSegement = new IntOpSegement(readName, z3, TypeUtils.longExtractValue((Number) jSONArray.get(0)), z5 ? Operator.NE : Operator.EQ);
                                while (true) {
                                    c6 = this.ch;
                                    if (c6 != ' ') {
                                        break;
                                    }
                                    next();
                                }
                                if (c6 == '&' || c6 == '|') {
                                    intOpSegement = filterRest(intOpSegement);
                                }
                                accept(')');
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return intOpSegement;
                            }
                            int size = jSONArray.size();
                            long[] jArr = new long[size];
                            for (int i9 = 0; i9 < size; i9++) {
                                jArr[i9] = TypeUtils.longExtractValue((Number) jSONArray.get(i9));
                            }
                            Filter intInSegement = new IntInSegement(readName, z3, jArr, z5);
                            while (true) {
                                c5 = this.ch;
                                if (c5 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c5 == '&' || c5 == '|') {
                                intInSegement = filterRest(intInSegement);
                            }
                            accept(')');
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return intInSegement;
                        } else if (z7) {
                            if (jSONArray.size() == 1) {
                                Filter stringOpSegement2 = new StringOpSegement(readName, z3, (String) jSONArray.get(0), z5 ? Operator.NE : Operator.EQ);
                                while (true) {
                                    c4 = this.ch;
                                    if (c4 != ' ') {
                                        break;
                                    }
                                    next();
                                }
                                if (c4 == '&' || c4 == '|') {
                                    stringOpSegement2 = filterRest(stringOpSegement2);
                                }
                                accept(')');
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return stringOpSegement2;
                            } else {
                                String[] strArr5 = new String[jSONArray.size()];
                                jSONArray.toArray(strArr5);
                                Filter stringInSegement = new StringInSegement(readName, z3, strArr5, z5);
                                while (true) {
                                    c3 = this.ch;
                                    if (c3 != ' ') {
                                        break;
                                    }
                                    next();
                                }
                                if (c3 == '&' || c3 == '|') {
                                    stringInSegement = filterRest(stringInSegement);
                                }
                                accept(')');
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return stringInSegement;
                            }
                        } else {
                            if (z8) {
                                int size2 = jSONArray.size();
                                Long[] lArr = new Long[size2];
                                for (int i10 = 0; i10 < size2; i10++) {
                                    Number number = (Number) jSONArray.get(i10);
                                    if (number != null) {
                                        lArr[i10] = Long.valueOf(TypeUtils.longExtractValue(number));
                                    }
                                }
                                Filter intObjInSegement = new IntObjInSegement(readName, z3, lArr, z5);
                                while (true) {
                                    c2 = this.ch;
                                    if (c2 != ' ') {
                                        break;
                                    }
                                    next();
                                }
                                if (c2 == '&' || c2 == '|') {
                                    intObjInSegement = filterRest(intObjInSegement);
                                }
                                accept(')');
                                if (z2) {
                                    accept(')');
                                }
                                if (z) {
                                    accept(']');
                                }
                                return intObjInSegement;
                            }
                            throw new UnsupportedOperationException();
                        }
                    }
                    boolean z9 = readOp == Operator.NOT_BETWEEN;
                    Object readValue = readValue();
                    if ("and".equalsIgnoreCase(readName())) {
                        Object readValue2 = readValue();
                        if (readValue != null && readValue2 != null) {
                            if (JSONPath.isInt(readValue.getClass()) && JSONPath.isInt(readValue2.getClass())) {
                                return new IntBetweenSegement(readName, z3, TypeUtils.longExtractValue((Number) readValue), TypeUtils.longExtractValue((Number) readValue2), z9);
                            }
                            throw new JSONPathException(this.path);
                        }
                        throw new JSONPathException(this.path);
                    }
                    throw new JSONPathException(this.path);
                }
            }
        }

        public double readDoubleValue(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
                int i2 = this.pos - 1;
                next();
                while (true) {
                    char c2 = this.ch;
                    if (c2 < '0' || c2 > '9') {
                        break;
                    }
                    next();
                }
                return Double.parseDouble(this.path.substring(i2, this.pos - 1)) + j2;
            }
            return invokeJ.doubleValue;
        }

        public long readLongValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                int i2 = this.pos - 1;
                char c2 = this.ch;
                if (c2 == '+' || c2 == '-') {
                    next();
                }
                while (true) {
                    char c3 = this.ch;
                    if (c3 < '0' || c3 > '9') {
                        break;
                    }
                    next();
                }
                return Long.parseLong(this.path.substring(i2, this.pos - 1));
            }
            return invokeV.longValue;
        }

        public String readName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                skipWhitespace();
                char c2 = this.ch;
                if (c2 != '\\' && !Character.isJavaIdentifierStart(c2)) {
                    throw new JSONPathException("illeal jsonpath syntax. " + this.path);
                }
                StringBuilder sb = new StringBuilder();
                while (!isEOF()) {
                    char c3 = this.ch;
                    if (c3 == '\\') {
                        next();
                        sb.append(this.ch);
                        if (isEOF()) {
                            return sb.toString();
                        }
                        next();
                    } else if (!Character.isJavaIdentifierPart(c3)) {
                        break;
                    } else {
                        sb.append(this.ch);
                        next();
                    }
                }
                if (isEOF() && Character.isJavaIdentifierPart(this.ch)) {
                    sb.append(this.ch);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public Operator readOp() {
            InterceptResult invokeV;
            Operator operator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                char c2 = this.ch;
                if (c2 == '=') {
                    next();
                    char c3 = this.ch;
                    if (c3 == '~') {
                        next();
                        operator = Operator.REG_MATCH;
                    } else if (c3 == '=') {
                        next();
                        operator = Operator.EQ;
                    } else {
                        operator = Operator.EQ;
                    }
                } else if (c2 == '!') {
                    next();
                    accept(a.f30893h);
                    operator = Operator.NE;
                } else if (c2 == '<') {
                    next();
                    if (this.ch == '=') {
                        next();
                        operator = Operator.LE;
                    } else {
                        operator = Operator.LT;
                    }
                } else if (c2 == '>') {
                    next();
                    if (this.ch == '=') {
                        next();
                        operator = Operator.GE;
                    } else {
                        operator = Operator.GT;
                    }
                } else {
                    operator = null;
                }
                if (operator == null) {
                    String readName = readName();
                    if ("not".equalsIgnoreCase(readName)) {
                        skipWhitespace();
                        String readName2 = readName();
                        if ("like".equalsIgnoreCase(readName2)) {
                            return Operator.NOT_LIKE;
                        }
                        if ("rlike".equalsIgnoreCase(readName2)) {
                            return Operator.NOT_RLIKE;
                        }
                        if ("in".equalsIgnoreCase(readName2)) {
                            return Operator.NOT_IN;
                        }
                        if ("between".equalsIgnoreCase(readName2)) {
                            return Operator.NOT_BETWEEN;
                        }
                        throw new UnsupportedOperationException();
                    } else if ("nin".equalsIgnoreCase(readName)) {
                        return Operator.NOT_IN;
                    } else {
                        if ("like".equalsIgnoreCase(readName)) {
                            return Operator.LIKE;
                        }
                        if ("rlike".equalsIgnoreCase(readName)) {
                            return Operator.RLIKE;
                        }
                        if ("in".equalsIgnoreCase(readName)) {
                            return Operator.IN;
                        }
                        if ("between".equalsIgnoreCase(readName)) {
                            return Operator.BETWEEN;
                        }
                        throw new UnsupportedOperationException();
                    }
                }
                return operator;
            }
            return (Operator) invokeV.objValue;
        }

        public Segment readSegement() {
            InterceptResult invokeV;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                boolean z = true;
                if (this.level == 0 && this.path.length() == 1) {
                    if (isDigitFirst(this.ch)) {
                        return new ArrayAccessSegment(this.ch - '0');
                    }
                    char c3 = this.ch;
                    if ((c3 >= 'a' && c3 <= 'z') || ((c2 = this.ch) >= 'A' && c2 <= 'Z')) {
                        return new PropertySegment(Character.toString(this.ch), false);
                    }
                }
                while (!isEOF()) {
                    skipWhitespace();
                    char c4 = this.ch;
                    if (c4 != '$') {
                        if (c4 != '.' && c4 != '/') {
                            if (c4 == '[') {
                                return parseArrayAccess(true);
                            }
                            if (this.level == 0) {
                                return new PropertySegment(readName(), false);
                            }
                            if (c4 == '?') {
                                return new FilterSegment((Filter) parseArrayAccessFilter(false));
                            }
                            throw new JSONPathException("not support jsonpath : " + this.path);
                        }
                        char c5 = this.ch;
                        next();
                        if (c5 == '.' && this.ch == '.') {
                            next();
                            int length = this.path.length();
                            int i2 = this.pos;
                            if (length > i2 + 3 && this.ch == '[' && this.path.charAt(i2) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                                next();
                                next();
                                next();
                                next();
                            }
                        } else {
                            z = false;
                        }
                        char c6 = this.ch;
                        if (c6 == '*') {
                            if (!isEOF()) {
                                next();
                            }
                            return z ? WildCardSegment.instance_deep : WildCardSegment.instance;
                        } else if (isDigitFirst(c6)) {
                            return parseArrayAccess(false);
                        } else {
                            String readName = readName();
                            if (this.ch == '(') {
                                next();
                                if (this.ch == ')') {
                                    if (!isEOF()) {
                                        next();
                                    }
                                    if (!"size".equals(readName) && !"length".equals(readName)) {
                                        if ("max".equals(readName)) {
                                            return MaxSegment.instance;
                                        }
                                        if ("min".equals(readName)) {
                                            return MinSegment.instance;
                                        }
                                        if ("keySet".equals(readName)) {
                                            return KeySetSegment.instance;
                                        }
                                        if ("type".equals(readName)) {
                                            return TypeSegment.instance;
                                        }
                                        if ("floor".equals(readName)) {
                                            return FloorSegment.instance;
                                        }
                                        throw new JSONPathException("not support jsonpath : " + this.path);
                                    }
                                    return SizeSegment.instance;
                                }
                                throw new JSONPathException("not support jsonpath : " + this.path);
                            }
                            return new PropertySegment(readName, z);
                        }
                    }
                    next();
                    skipWhitespace();
                    if (this.ch == '?') {
                        return new FilterSegment((Filter) parseArrayAccessFilter(false));
                    }
                }
                return null;
            }
            return (Segment) invokeV.objValue;
        }

        public String readString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                char c2 = this.ch;
                next();
                int i2 = this.pos - 1;
                while (this.ch != c2 && !isEOF()) {
                    next();
                }
                String substring = this.path.substring(i2, isEOF() ? this.pos : this.pos - 1);
                accept(c2);
                return substring;
            }
            return (String) invokeV.objValue;
        }

        public Object readValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                skipWhitespace();
                if (isDigitFirst(this.ch)) {
                    return Long.valueOf(readLongValue());
                }
                char c2 = this.ch;
                if (c2 == '\"' || c2 == '\'') {
                    return readString();
                }
                if (c2 == 'n') {
                    if (StringUtil.NULL_STRING.equals(readName())) {
                        return null;
                    }
                    throw new JSONPathException(this.path);
                }
                throw new UnsupportedOperationException();
            }
            return invokeV.objValue;
        }

        public final void skipWhitespace() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048592, this) != null) {
                return;
            }
            while (true) {
                char c2 = this.ch;
                if (c2 > ' ') {
                    return;
                }
                if (c2 != ' ' && c2 != '\r' && c2 != '\n' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                    return;
                }
                next();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class KeySetSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public static final KeySetSegment instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(994471972, "Lcom/alibaba/fastjson/JSONPath$KeySetSegment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(994471972, "Lcom/alibaba/fastjson/JSONPath$KeySetSegment;");
                    return;
                }
            }
            instance = new KeySetSegment();
        }

        public KeySetSegment() {
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

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) ? jSONPath.evalKeySet(obj2) : invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class MatchSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] containsValues;
        public final String endsWithValue;
        public final int minLength;
        public final boolean not;
        public final String startsWithValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MatchSegement(String str, boolean z, String str2, String str3, String[] strArr, boolean z2) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, str3, strArr, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z2;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 == null) {
                    return false;
                }
                String obj5 = obj4.toString();
                if (obj5.length() < this.minLength) {
                    return this.not;
                }
                String str = this.startsWithValue;
                if (str == null) {
                    i2 = 0;
                } else if (!obj5.startsWith(str)) {
                    return this.not;
                } else {
                    i2 = this.startsWithValue.length() + 0;
                }
                String[] strArr = this.containsValues;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        int indexOf = obj5.indexOf(str2, i2);
                        if (indexOf == -1) {
                            return this.not;
                        }
                        i2 = indexOf + str2.length();
                    }
                }
                String str3 = this.endsWithValue;
                if (str3 != null && !obj5.endsWith(str3)) {
                    return this.not;
                }
                return !this.not;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class MaxSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public static final MaxSegment instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(425634163, "Lcom/alibaba/fastjson/JSONPath$MaxSegment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(425634163, "Lcom/alibaba/fastjson/JSONPath$MaxSegment;");
                    return;
                }
            }
            instance = new MaxSegment();
        }

        public MaxSegment() {
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

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                if (obj2 instanceof Collection) {
                    Object obj3 = null;
                    for (Object obj4 : (Collection) obj2) {
                        if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) < 0)) {
                            obj3 = obj4;
                        }
                    }
                    return obj3;
                }
                throw new UnsupportedOperationException();
            }
            return invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class MinSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public static final MinSegment instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-251798431, "Lcom/alibaba/fastjson/JSONPath$MinSegment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-251798431, "Lcom/alibaba/fastjson/JSONPath$MinSegment;");
                    return;
                }
            }
            instance = new MinSegment();
        }

        public MinSegment() {
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

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                if (obj2 instanceof Collection) {
                    Object obj3 = null;
                    for (Object obj4 : (Collection) obj2) {
                        if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) > 0)) {
                            obj3 = obj4;
                        }
                    }
                    return obj3;
                }
                throw new UnsupportedOperationException();
            }
            return invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class MultiIndexSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] indexes;

        public MultiIndexSegment(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) != null) {
                return invokeLLL.objValue;
            }
            JSONArray jSONArray = new JSONArray(this.indexes.length);
            int i2 = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i2 >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.getArrayItem(obj2, iArr[i2]));
                i2++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                if (context.eval) {
                    Object parse = defaultJSONParser.parse();
                    if (parse instanceof List) {
                        int[] iArr = this.indexes;
                        int length = iArr.length;
                        int[] iArr2 = new int[length];
                        System.arraycopy(iArr, 0, iArr2, 0, length);
                        List list = (List) parse;
                        if (iArr2[0] >= 0) {
                            for (int size = list.size() - 1; size >= 0; size--) {
                                if (Arrays.binarySearch(iArr2, size) < 0) {
                                    list.remove(size);
                                }
                            }
                            context.object = list;
                            return;
                        }
                    }
                }
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class MultiPropertySegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] propertyNames;
        public final long[] propertyNamesHash;

        public MultiPropertySegment(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i4 = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i4 >= jArr.length) {
                    return;
                }
                jArr[i4] = TypeUtils.fnv1a_64(strArr[i4]);
                i4++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) != null) {
                return invokeLLL.objValue;
            }
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            int i2 = 0;
            while (true) {
                String[] strArr = this.propertyNames;
                if (i2 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i2], this.propertyNamesHash[i2]));
                i2++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            JSONArray jSONArray;
            Object integerValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
                Object obj = context.object;
                if (obj == null) {
                    jSONArray = new JSONArray();
                    context.object = jSONArray;
                } else {
                    jSONArray = (JSONArray) obj;
                }
                for (int size = jSONArray.size(); size < this.propertyNamesHash.length; size++) {
                    jSONArray.add(null);
                }
                do {
                    int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNamesHash);
                    if (jSONLexerBase.matchStat != 3) {
                        return;
                    }
                    int i2 = jSONLexerBase.token();
                    if (i2 == 2) {
                        integerValue = jSONLexerBase.integerValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 == 3) {
                        integerValue = jSONLexerBase.decimalValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 != 4) {
                        integerValue = defaultJSONParser.parse();
                    } else {
                        integerValue = jSONLexerBase.stringVal();
                        jSONLexerBase.nextToken(16);
                    }
                    jSONArray.set(seekObjectToField, integerValue);
                } while (jSONLexerBase.token() == 16);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class NotNullSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotNullSegement(String str, boolean z) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) ? jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null : invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class NullSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NullSegement(String str, boolean z) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) ? get(jSONPath, obj, obj3) == null : invokeLLLL.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Operator {
        public static final /* synthetic */ Operator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Operator And;
        public static final Operator BETWEEN;
        public static final Operator EQ;
        public static final Operator GE;
        public static final Operator GT;
        public static final Operator IN;
        public static final Operator LE;
        public static final Operator LIKE;
        public static final Operator LT;
        public static final Operator NE;
        public static final Operator NOT_BETWEEN;
        public static final Operator NOT_IN;
        public static final Operator NOT_LIKE;
        public static final Operator NOT_RLIKE;
        public static final Operator Or;
        public static final Operator REG_MATCH;
        public static final Operator RLIKE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(716922462, "Lcom/alibaba/fastjson/JSONPath$Operator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(716922462, "Lcom/alibaba/fastjson/JSONPath$Operator;");
                    return;
                }
            }
            EQ = new Operator("EQ", 0);
            NE = new Operator("NE", 1);
            GT = new Operator("GT", 2);
            GE = new Operator("GE", 3);
            LT = new Operator("LT", 4);
            LE = new Operator("LE", 5);
            LIKE = new Operator("LIKE", 6);
            NOT_LIKE = new Operator("NOT_LIKE", 7);
            RLIKE = new Operator("RLIKE", 8);
            NOT_RLIKE = new Operator("NOT_RLIKE", 9);
            IN = new Operator("IN", 10);
            NOT_IN = new Operator("NOT_IN", 11);
            BETWEEN = new Operator("BETWEEN", 12);
            NOT_BETWEEN = new Operator("NOT_BETWEEN", 13);
            And = new Operator("And", 14);
            Or = new Operator("Or", 15);
            Operator operator = new Operator("REG_MATCH", 16);
            REG_MATCH = operator;
            $VALUES = new Operator[]{EQ, NE, GT, GE, LT, LE, LIKE, NOT_LIKE, RLIKE, NOT_RLIKE, IN, NOT_IN, BETWEEN, NOT_BETWEEN, And, Or, operator};
        }

        public Operator(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Operator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Operator) Enum.valueOf(Operator.class, str) : (Operator) invokeL.objValue;
        }

        public static Operator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Operator[]) $VALUES.clone() : (Operator[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class PropertyFilter implements Filter {
        public static /* synthetic */ Interceptable $ic;
        public static long TYPE;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean function;
        public Segment functionExpr;
        public final String propertyName;
        public final long propertyNameHash;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1859155253, "Lcom/alibaba/fastjson/JSONPath$PropertyFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1859155253, "Lcom/alibaba/fastjson/JSONPath$PropertyFilter;");
                    return;
                }
            }
            TYPE = TypeUtils.fnv1a_64("type");
        }

        public PropertyFilter(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.propertyName = str;
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            this.propertyNameHash = fnv1a_64;
            this.function = z;
            if (z) {
                if (fnv1a_64 == TYPE) {
                    this.functionExpr = TypeSegment.instance;
                } else if (fnv1a_64 == JSONPath.SIZE) {
                    this.functionExpr = SizeSegment.instance;
                } else {
                    throw new JSONPathException("unsupported funciton : " + str);
                }
            }
        }

        public Object get(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                Segment segment = this.functionExpr;
                if (segment != null) {
                    return segment.eval(jSONPath, obj, obj2);
                }
                return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class PropertySegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean deep;
        public final String propertyName;
        public final long propertyNameHash;

        public PropertySegment(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.deep = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                if (this.deep) {
                    ArrayList arrayList = new ArrayList();
                    jSONPath.deepScan(obj2, this.propertyName, arrayList);
                    return arrayList;
                }
                return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
            }
            return invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Object integerValue;
            Object integerValue2;
            JSONArray jSONArray;
            Object integerValue3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) != null) {
                return;
            }
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            if (this.deep && context.object == null) {
                context.object = new JSONArray();
            }
            if (jSONLexerBase.token() == 14) {
                if ("*".equals(this.propertyName)) {
                    return;
                }
                jSONLexerBase.nextToken();
                if (this.deep) {
                    jSONArray = (JSONArray) context.object;
                } else {
                    jSONArray = new JSONArray();
                }
                while (true) {
                    int i2 = jSONLexerBase.token();
                    if (i2 == 12) {
                        boolean z = this.deep;
                        if (z) {
                            extract(jSONPath, defaultJSONParser, context);
                        } else {
                            int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNameHash, z);
                            if (seekObjectToField == 3) {
                                int i3 = jSONLexerBase.token();
                                if (i3 == 2) {
                                    integerValue3 = jSONLexerBase.integerValue();
                                    jSONLexerBase.nextToken();
                                } else if (i3 != 4) {
                                    integerValue3 = defaultJSONParser.parse();
                                } else {
                                    integerValue3 = jSONLexerBase.stringVal();
                                    jSONLexerBase.nextToken();
                                }
                                jSONArray.add(integerValue3);
                                if (jSONLexerBase.token() == 13) {
                                    jSONLexerBase.nextToken();
                                } else {
                                    jSONLexerBase.skipObject(false);
                                }
                            } else if (seekObjectToField == -1) {
                                continue;
                            } else if (!this.deep) {
                                jSONLexerBase.skipObject(false);
                            } else {
                                throw new UnsupportedOperationException(jSONLexerBase.info());
                            }
                        }
                    } else if (i2 != 14) {
                        switch (i2) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                jSONLexerBase.nextToken();
                                break;
                        }
                    } else if (this.deep) {
                        extract(jSONPath, defaultJSONParser, context);
                    } else {
                        jSONLexerBase.skipObject(false);
                    }
                    if (jSONLexerBase.token() == 15) {
                        jSONLexerBase.nextToken();
                        if (this.deep || jSONArray.size() <= 0) {
                            return;
                        }
                        context.object = jSONArray;
                        return;
                    } else if (jSONLexerBase.token() == 16) {
                        jSONLexerBase.nextToken();
                    } else {
                        throw new JSONException("illegal json : " + jSONLexerBase.info());
                    }
                }
            } else {
                boolean z2 = this.deep;
                if (!z2) {
                    if (jSONLexerBase.seekObjectToField(this.propertyNameHash, z2) == 3 && context.eval) {
                        int i4 = jSONLexerBase.token();
                        if (i4 == 2) {
                            integerValue2 = jSONLexerBase.integerValue();
                            jSONLexerBase.nextToken(16);
                        } else if (i4 == 3) {
                            integerValue2 = jSONLexerBase.decimalValue();
                            jSONLexerBase.nextToken(16);
                        } else if (i4 != 4) {
                            integerValue2 = defaultJSONParser.parse();
                        } else {
                            integerValue2 = jSONLexerBase.stringVal();
                            jSONLexerBase.nextToken(16);
                        }
                        if (context.eval) {
                            context.object = integerValue2;
                            return;
                        }
                        return;
                    }
                    return;
                }
                while (true) {
                    int seekObjectToField2 = jSONLexerBase.seekObjectToField(this.propertyNameHash, this.deep);
                    if (seekObjectToField2 == -1) {
                        return;
                    }
                    if (seekObjectToField2 == 3) {
                        if (context.eval) {
                            int i5 = jSONLexerBase.token();
                            if (i5 == 2) {
                                integerValue = jSONLexerBase.integerValue();
                                jSONLexerBase.nextToken(16);
                            } else if (i5 == 3) {
                                integerValue = jSONLexerBase.decimalValue();
                                jSONLexerBase.nextToken(16);
                            } else if (i5 != 4) {
                                integerValue = defaultJSONParser.parse();
                            } else {
                                integerValue = jSONLexerBase.stringVal();
                                jSONLexerBase.nextToken(16);
                            }
                            if (context.eval) {
                                Object obj = context.object;
                                if (obj instanceof List) {
                                    List list = (List) obj;
                                    if (list.size() == 0 && (integerValue instanceof List)) {
                                        context.object = integerValue;
                                    } else {
                                        list.add(integerValue);
                                    }
                                } else {
                                    context.object = integerValue;
                                }
                            }
                        }
                    } else if (seekObjectToField2 == 1 || seekObjectToField2 == 2) {
                        extract(jSONPath, defaultJSONParser, context);
                    }
                }
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONPath, obj)) == null) ? jSONPath.removePropertyValue(obj, this.propertyName, this.deep) : invokeLL.booleanValue;
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, jSONPath, obj, obj2) == null) {
                if (this.deep) {
                    jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
                } else {
                    jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class RangeSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int end;
        public final int start;
        public final int step;

        public RangeSegment(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.start = i2;
            this.end = i3;
            this.step = i4;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                int intValue = SizeSegment.instance.eval(jSONPath, obj, obj2).intValue();
                int i2 = this.start;
                if (i2 < 0) {
                    i2 += intValue;
                }
                int i3 = this.end;
                if (i3 < 0) {
                    i3 += intValue;
                }
                int i4 = ((i3 - i2) / this.step) + 1;
                if (i4 == -1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(i4);
                while (i2 <= i3 && i2 < intValue) {
                    arrayList.add(jSONPath.getArrayItem(obj2, i2));
                    i2 += this.step;
                }
                return arrayList;
            }
            return invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class RefOpSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Operator op;
        public final Segment refSgement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefOpSegement(String str, boolean z, Segment segment, Operator operator) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), segment, operator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.refSgement = segment;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 != null && (obj4 instanceof Number)) {
                    Object eval = this.refSgement.eval(jSONPath, obj, obj);
                    if ((eval instanceof Integer) || (eval instanceof Long) || (eval instanceof Short) || (eval instanceof Byte)) {
                        long longExtractValue = TypeUtils.longExtractValue((Number) eval);
                        if (!(obj4 instanceof Integer) && !(obj4 instanceof Long) && !(obj4 instanceof Short) && !(obj4 instanceof Byte)) {
                            if (obj4 instanceof BigDecimal) {
                                int compareTo = BigDecimal.valueOf(longExtractValue).compareTo((BigDecimal) obj4);
                                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                                    case 1:
                                        return compareTo == 0;
                                    case 2:
                                        return compareTo != 0;
                                    case 3:
                                        return compareTo <= 0;
                                    case 4:
                                        return compareTo < 0;
                                    case 5:
                                        return compareTo >= 0;
                                    case 6:
                                        return compareTo > 0;
                                    default:
                                        return false;
                                }
                            }
                        } else {
                            long longExtractValue2 = TypeUtils.longExtractValue((Number) obj4);
                            switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                                case 1:
                                    return longExtractValue2 == longExtractValue;
                                case 2:
                                    return longExtractValue2 != longExtractValue;
                                case 3:
                                    return longExtractValue2 >= longExtractValue;
                                case 4:
                                    return longExtractValue2 > longExtractValue;
                                case 5:
                                    return longExtractValue2 <= longExtractValue;
                                case 6:
                                    return longExtractValue2 < longExtractValue;
                            }
                        }
                    }
                    throw new UnsupportedOperationException();
                }
                return false;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class RegMatchSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Operator op;
        public final Pattern pattern;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RegMatchSegement(String str, boolean z, Pattern pattern, Operator operator) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), pattern, operator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pattern = pattern;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 == null) {
                    return false;
                }
                return this.pattern.matcher(obj4.toString()).matches();
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class RlikeSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean not;
        public final Pattern pattern;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RlikeSegement(String str, boolean z, String str2, boolean z2) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pattern = Pattern.compile(str2);
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                if (obj4 == null) {
                    return false;
                }
                boolean matches = this.pattern.matcher(obj4.toString()).matches();
                return this.not ? !matches : matches;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface Segment {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);

        void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context);
    }

    /* loaded from: classes9.dex */
    public static class SizeSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public static final SizeSegment instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2075561698, "Lcom/alibaba/fastjson/JSONPath$SizeSegment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2075561698, "Lcom/alibaba/fastjson/JSONPath$SizeSegment;");
                    return;
                }
            }
            instance = new SizeSegment();
        }

        public SizeSegment() {
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

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONPath, defaultJSONParser, context) == null) {
                context.object = Integer.valueOf(jSONPath.evalSize(defaultJSONParser.parse()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) ? Integer.valueOf(jSONPath.evalSize(obj2)) : (Integer) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class StringInSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean not;
        public final String[] values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringInSegement(String str, boolean z, String[] strArr, boolean z2) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), strArr, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.values = strArr;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                for (String str : this.values) {
                    if (str == obj4) {
                        return !this.not;
                    }
                    if (str != null && str.equals(obj4)) {
                        return !this.not;
                    }
                }
                return this.not;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class StringOpSegement extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Operator op;
        public final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringOpSegement(String str, boolean z, String str2, Operator operator) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, operator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                Object obj4 = get(jSONPath, obj, obj3);
                Operator operator = this.op;
                if (operator == Operator.EQ) {
                    return this.value.equals(obj4);
                }
                if (operator == Operator.NE) {
                    return !this.value.equals(obj4);
                }
                if (obj4 == null) {
                    return false;
                }
                int compareTo = this.value.compareTo(obj4.toString());
                Operator operator2 = this.op;
                return operator2 == Operator.GE ? compareTo <= 0 : operator2 == Operator.GT ? compareTo < 0 : operator2 == Operator.LE ? compareTo >= 0 : operator2 == Operator.LT && compareTo > 0;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class TypeSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public static final TypeSegment instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1188361499, "Lcom/alibaba/fastjson/JSONPath$TypeSegment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1188361499, "Lcom/alibaba/fastjson/JSONPath$TypeSegment;");
                    return;
                }
            }
            instance = new TypeSegment();
        }

        public TypeSegment() {
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

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONPath, defaultJSONParser, context) == null) {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.alibaba.fastjson.JSONPath.Segment
        public String eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, obj, obj2)) == null) ? obj2 == null ? StringUtil.NULL_STRING : obj2 instanceof Collection ? "array" : obj2 instanceof Number ? "number" : obj2 instanceof Boolean ? "boolean" : ((obj2 instanceof String) || (obj2 instanceof UUID) || (obj2 instanceof Enum)) ? "string" : "object" : (String) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class ValueSegment extends PropertyFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean eq;
        public final Object value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValueSegment(String str, boolean z, Object obj, boolean z2) {
            super(str, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), obj, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.eq = true;
            if (obj != null) {
                this.value = obj;
                this.eq = z2;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, jSONPath, obj, obj2, obj3)) == null) {
                boolean equals = this.value.equals(get(jSONPath, obj, obj3));
                return !this.eq ? !equals : equals;
            }
            return invokeLLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class WildCardSegment implements Segment {
        public static /* synthetic */ Interceptable $ic;
        public static final WildCardSegment instance;
        public static final WildCardSegment instance_deep;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean deep;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(146439003, "Lcom/alibaba/fastjson/JSONPath$WildCardSegment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(146439003, "Lcom/alibaba/fastjson/JSONPath$WildCardSegment;");
                    return;
                }
            }
            instance = new WildCardSegment(false);
            instance_deep = new WildCardSegment(true);
        }

        public WildCardSegment(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.deep = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, jSONPath, obj, obj2)) == null) {
                if (!this.deep) {
                    return jSONPath.getPropertyValues(obj2);
                }
                ArrayList arrayList = new ArrayList();
                jSONPath.deepGetPropertyValues(obj2, arrayList);
                return arrayList;
            }
            return invokeLLL.objValue;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPath, defaultJSONParser, context) == null) {
                if (context.eval) {
                    Object parse = defaultJSONParser.parse();
                    if (this.deep) {
                        ArrayList arrayList = new ArrayList();
                        jSONPath.deepGetPropertyValues(parse, arrayList);
                        context.object = arrayList;
                        return;
                    } else if (parse instanceof JSONObject) {
                        Collection<?> values = ((JSONObject) parse).values();
                        JSONArray jSONArray = new JSONArray(values.size());
                        jSONArray.addAll(values);
                        context.object = jSONArray;
                        return;
                    } else if (parse instanceof JSONArray) {
                        context.object = parse;
                        return;
                    }
                }
                throw new JSONException("TODO");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(654511568, "Lcom/alibaba/fastjson/JSONPath;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(654511568, "Lcom/alibaba/fastjson/JSONPath;");
                return;
            }
        }
        pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (SerializeConfig) objArr2[1], (ParserConfig) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Object d2;
        Object f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2)) == null) {
            if (obj.getClass() == obj2.getClass()) {
                return ((Comparable) obj).compareTo(obj2);
            }
            Class<?> cls = obj.getClass();
            Class<?> cls2 = obj2.getClass();
            if (cls == BigDecimal.class) {
                if (cls2 == Integer.class) {
                    f2 = new BigDecimal(((Integer) obj2).intValue());
                } else if (cls2 != Long.class) {
                    if (cls2 == Float.class) {
                        f2 = new BigDecimal(((Float) obj2).floatValue());
                    } else {
                        if (cls2 == Double.class) {
                            f2 = new BigDecimal(((Double) obj2).doubleValue());
                        }
                        return ((Comparable) obj).compareTo(obj2);
                    }
                } else {
                    f2 = new BigDecimal(((Long) obj2).longValue());
                }
                obj2 = f2;
                return ((Comparable) obj).compareTo(obj2);
            }
            if (cls == Long.class) {
                if (cls2 == Integer.class) {
                    f2 = new Long(((Integer) obj2).intValue());
                    obj2 = f2;
                } else {
                    if (cls2 != BigDecimal.class) {
                        if (cls2 == Float.class) {
                            d2 = new Float((float) ((Long) obj).longValue());
                        } else if (cls2 == Double.class) {
                            d2 = new Double(((Long) obj).longValue());
                        }
                    } else {
                        d2 = new BigDecimal(((Long) obj).longValue());
                    }
                    obj = d2;
                }
            } else if (cls == Integer.class) {
                if (cls2 == Long.class) {
                    d2 = new Long(((Integer) obj).intValue());
                } else if (cls2 != BigDecimal.class) {
                    if (cls2 == Float.class) {
                        d2 = new Float(((Integer) obj).intValue());
                    } else if (cls2 == Double.class) {
                        d2 = new Double(((Integer) obj).intValue());
                    }
                } else {
                    d2 = new BigDecimal(((Integer) obj).intValue());
                }
                obj = d2;
            } else if (cls == Double.class) {
                if (cls2 == Integer.class) {
                    f2 = new Double(((Integer) obj2).intValue());
                } else if (cls2 != Long.class) {
                    if (cls2 == Float.class) {
                        f2 = new Double(((Float) obj2).floatValue());
                    }
                } else {
                    f2 = new Double(((Long) obj2).longValue());
                }
                obj2 = f2;
            } else if (cls == Float.class) {
                if (cls2 == Integer.class) {
                    f2 = new Float(((Integer) obj2).intValue());
                } else if (cls2 == Long.class) {
                    f2 = new Float((float) ((Long) obj2).longValue());
                } else if (cls2 == Double.class) {
                    d2 = new Double(((Float) obj).floatValue());
                    obj = d2;
                }
                obj2 = f2;
            }
            return ((Comparable) obj).compareTo(obj2);
        }
        return invokeLL.intValue;
    }

    public static JSONPath compile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null) {
                JSONPath jSONPath = pathCache.get(str);
                if (jSONPath == null) {
                    JSONPath jSONPath2 = new JSONPath(str);
                    if (pathCache.size() < 1024) {
                        pathCache.putIfAbsent(str, jSONPath2);
                        return pathCache.get(str);
                    }
                    return jSONPath2;
                }
                return jSONPath;
            }
            throw new JSONPathException("jsonpath can not be null");
        }
        return (JSONPath) invokeL.objValue;
    }

    public static boolean eq(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, obj2)) == null) {
            if (obj == obj2) {
                return true;
            }
            if (obj == null || obj2 == null) {
                return false;
            }
            if (obj.getClass() == obj2.getClass()) {
                return obj.equals(obj2);
            }
            if (obj instanceof Number) {
                if (obj2 instanceof Number) {
                    return eqNotNull((Number) obj, (Number) obj2);
                }
                return false;
            }
            return obj.equals(obj2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean eqNotNull(Number number, Number number2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, number, number2)) == null) {
            Class<?> cls = number.getClass();
            boolean isInt = isInt(cls);
            Class<?> cls2 = number2.getClass();
            boolean isInt2 = isInt(cls2);
            if (number instanceof BigDecimal) {
                BigDecimal bigDecimal = (BigDecimal) number;
                if (isInt2) {
                    return bigDecimal.equals(BigDecimal.valueOf(TypeUtils.longExtractValue(number2)));
                }
            }
            if (isInt) {
                if (isInt2) {
                    return number.longValue() == number2.longValue();
                } else if (number2 instanceof BigInteger) {
                    return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
                }
            }
            if (isInt2 && (number instanceof BigInteger)) {
                return ((BigInteger) number).equals(BigInteger.valueOf(TypeUtils.longExtractValue(number2)));
            }
            boolean isDouble = isDouble(cls);
            boolean isDouble2 = isDouble(cls2);
            return ((isDouble && isDouble2) || ((isDouble && isInt2) || (isDouble2 && isInt))) && number.doubleValue() == number2.doubleValue();
        }
        return invokeLL.booleanValue;
    }

    public static boolean isDouble(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) ? cls == Float.class || cls == Double.class : invokeL.booleanValue;
    }

    public static boolean isInt(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, cls)) == null) ? cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class : invokeL.booleanValue;
    }

    public static Map<String, Object> paths(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, obj)) == null) ? paths(obj, SerializeConfig.globalInstance) : (Map) invokeL.objValue;
    }

    public static Object read(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, str2)) == null) ? compile(str2).eval(JSON.parse(str)) : invokeLL.objValue;
    }

    public static Object reserveToArray(Object obj, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, obj, strArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    JSONPath compile = compile(str);
                    compile.init();
                    jSONArray.add(compile.eval(obj));
                }
            }
            return jSONArray;
        }
        return invokeLL.objValue;
    }

    public static Object reserveToObject(Object obj, String... strArr) {
        InterceptResult invokeLL;
        Object eval;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, obj, strArr)) == null) {
            if (strArr == null || strArr.length == 0) {
                return obj;
            }
            JSONObject jSONObject = new JSONObject(true);
            for (String str : strArr) {
                JSONPath compile = compile(str);
                compile.init();
                Segment[] segmentArr = compile.segments;
                if ((segmentArr[segmentArr.length - 1] instanceof PropertySegment) && (eval = compile.eval(obj)) != null) {
                    compile.set(jSONObject, eval);
                }
            }
            return jSONObject;
        }
        return invokeLL.objValue;
    }

    public void arrayAdd(Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, objArr) == null) || objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        Object obj2 = null;
        int i2 = 0;
        Object obj3 = obj;
        int i3 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i3 >= segmentArr.length) {
                break;
            }
            if (i3 == segmentArr.length - 1) {
                obj2 = obj3;
            }
            obj3 = this.segments[i3].eval(this, obj, obj3);
            i3++;
        }
        if (obj3 != null) {
            if (obj3 instanceof Collection) {
                Collection collection = (Collection) obj3;
                int length = objArr.length;
                while (i2 < length) {
                    collection.add(objArr[i2]);
                    i2++;
                }
                return;
            }
            Class<?> cls = obj3.getClass();
            if (cls.isArray()) {
                int length2 = Array.getLength(obj3);
                Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
                System.arraycopy(obj3, 0, newInstance, 0, length2);
                while (i2 < objArr.length) {
                    Array.set(newInstance, length2 + i2, objArr[i2]);
                    i2++;
                }
                Segment[] segmentArr2 = this.segments;
                Segment segment = segmentArr2[segmentArr2.length - 1];
                if (segment instanceof PropertySegment) {
                    ((PropertySegment) segment).setValue(this, obj2, newInstance);
                    return;
                } else if (segment instanceof ArrayAccessSegment) {
                    ((ArrayAccessSegment) segment).setValue(this, obj2, newInstance);
                    return;
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            throw new JSONException("unsupported array put operation. " + cls);
        }
        throw new JSONPathException("value not found in path " + this.path);
    }

    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) != null) {
            return invokeL.booleanValue;
        }
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i2 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                return true;
            }
            Object eval = segmentArr[i2].eval(this, obj, obj2);
            if (eval == null) {
                return false;
            }
            if (eval == Collections.EMPTY_LIST && (obj2 instanceof List)) {
                return ((List) obj2).contains(eval);
            }
            i2++;
            obj2 = eval;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2)) == null) {
            Object eval = eval(obj);
            if (eval == obj2) {
                return true;
            }
            if (eval == null) {
                return false;
            }
            if (eval instanceof Iterable) {
                for (Object obj3 : (Iterable) eval) {
                    if (eq(obj3, obj2)) {
                        return true;
                    }
                }
                return false;
            }
            return eq(eval, obj2);
        }
        return invokeLL.booleanValue;
    }

    public void deepGetPropertyValues(Object obj, List<Object> list) {
        Collection fieldValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, list) == null) {
            Class<?> cls = obj.getClass();
            JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
            if (javaBeanSerializer != null) {
                try {
                    fieldValues = javaBeanSerializer.getFieldValues(obj);
                } catch (Exception e2) {
                    throw new JSONPathException("jsonpath error, path " + this.path, e2);
                }
            } else if (obj instanceof Map) {
                fieldValues = ((Map) obj).values();
            } else {
                fieldValues = obj instanceof Collection ? (Collection) obj : null;
            }
            if (fieldValues != null) {
                for (Object obj2 : fieldValues) {
                    if (obj2 != null && !ParserConfig.isPrimitive2(obj2.getClass())) {
                        deepGetPropertyValues(obj2, list);
                    } else {
                        list.add(obj2);
                    }
                }
                return;
            }
            throw new UnsupportedOperationException(cls.getName());
        }
    }

    public void deepScan(Object obj, String str, List<Object> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, obj, str, list) == null) || obj == null) {
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof Collection) {
                        list.addAll((Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !ParserConfig.isPrimitive2(value.getClass())) {
                    deepScan(value, str, list);
                }
            }
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (!ParserConfig.isPrimitive2(obj2.getClass())) {
                    deepScan(obj2, str, list);
                }
            }
        } else {
            JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
            if (javaBeanSerializer != null) {
                try {
                    FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                    if (fieldSerializer != null) {
                        try {
                            list.add(fieldSerializer.getPropertyValueDirect(obj));
                            return;
                        } catch (IllegalAccessException e2) {
                            throw new JSONException("getFieldValue error." + str, e2);
                        } catch (InvocationTargetException e3) {
                            throw new JSONException("getFieldValue error." + str, e3);
                        }
                    }
                    for (Object obj3 : javaBeanSerializer.getFieldValues(obj)) {
                        deepScan(obj3, str, list);
                    }
                } catch (Exception e4) {
                    throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e4);
                }
            } else if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    deepScan(list2.get(i2), str, list);
                }
            }
        }
    }

    public void deepSet(Object obj, String str, long j2, Object obj2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{obj, str, Long.valueOf(j2), obj2}) == null) || obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            }
            for (Object obj3 : map.values()) {
                deepSet(obj3, str, j2, obj2);
            }
            return;
        }
        Class<?> cls = obj.getClass();
        JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
        if (javaBeanDeserializer != null) {
            try {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                if (fieldDeserializer != null) {
                    fieldDeserializer.setValue(obj, obj2);
                    return;
                }
                for (Object obj4 : getJavaBeanSerializer(cls).getObjectFieldValues(obj)) {
                    deepSet(obj4, str, j2, obj2);
                }
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e2);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                deepSet(list.get(i2), str, j2, obj2);
            }
        }
    }

    public Object eval(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, obj)) != null) {
            return invokeL.objValue;
        }
        if (obj == null) {
            return null;
        }
        init();
        int i2 = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                return obj2;
            }
            obj2 = segmentArr[i2].eval(this, obj, obj2);
            i2++;
        }
    }

    public Set<?> evalKeySet(Object obj) {
        InterceptResult invokeL;
        JavaBeanSerializer javaBeanSerializer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Map) {
                return ((Map) obj).keySet();
            }
            if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (javaBeanSerializer = getJavaBeanSerializer(obj.getClass())) == null) {
                return null;
            }
            try {
                return javaBeanSerializer.getFieldNames(obj);
            } catch (Exception e2) {
                throw new JSONPathException("evalKeySet error : " + this.path, e2);
            }
        }
        return (Set) invokeL.objValue;
    }

    public int evalSize(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == null) {
                return -1;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).size();
            }
            if (obj instanceof Object[]) {
                return ((Object[]) obj).length;
            }
            if (obj.getClass().isArray()) {
                return Array.getLength(obj);
            }
            if (obj instanceof Map) {
                int i2 = 0;
                for (Object obj2 : ((Map) obj).values()) {
                    if (obj2 != null) {
                        i2++;
                    }
                }
                return i2;
            }
            JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
            if (javaBeanSerializer == null) {
                return -1;
            }
            try {
                return javaBeanSerializer.getSize(obj);
            } catch (Exception e2) {
                throw new JSONPathException("evalSize error : " + this.path, e2);
            }
        }
        return invokeL.intValue;
    }

    public Object extract(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048585, this, defaultJSONParser)) != null) {
            return invokeL.objValue;
        }
        if (defaultJSONParser == null) {
            return null;
        }
        init();
        if (this.hasRefSegment) {
            return eval(defaultJSONParser.parse());
        }
        Segment[] segmentArr = this.segments;
        if (segmentArr.length == 0) {
            return defaultJSONParser.parse();
        }
        Segment segment = segmentArr[segmentArr.length - 1];
        if ((segment instanceof TypeSegment) || (segment instanceof FloorSegment) || (segment instanceof MultiIndexSegment)) {
            return eval(defaultJSONParser.parse());
        }
        Context context = null;
        int i2 = 0;
        while (true) {
            Segment[] segmentArr2 = this.segments;
            if (i2 < segmentArr2.length) {
                Segment segment2 = segmentArr2[i2];
                boolean z2 = i2 == segmentArr2.length - 1;
                if (context != null && (obj = context.object) != null) {
                    context.object = segment2.eval(this, null, obj);
                } else {
                    if (!z2) {
                        Segment segment3 = this.segments[i2 + 1];
                        if ((!(segment2 instanceof PropertySegment) || !((PropertySegment) segment2).deep || (!(segment3 instanceof ArrayAccessSegment) && !(segment3 instanceof MultiIndexSegment) && !(segment3 instanceof MultiPropertySegment) && !(segment3 instanceof SizeSegment) && !(segment3 instanceof PropertySegment) && !(segment3 instanceof FilterSegment))) && ((!(segment3 instanceof ArrayAccessSegment) || ((ArrayAccessSegment) segment3).index >= 0) && !(segment3 instanceof FilterSegment) && !(segment2 instanceof WildCardSegment) && !(segment2 instanceof MultiIndexSegment))) {
                            z = false;
                            Context context2 = new Context(context, z);
                            segment2.extract(this, defaultJSONParser, context2);
                            context = context2;
                        }
                    }
                    z = true;
                    Context context22 = new Context(context, z);
                    segment2.extract(this, defaultJSONParser, context22);
                    context = context22;
                }
                i2++;
            } else {
                return context.object;
            }
        }
    }

    public Object getArrayItem(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, obj, i2)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                if (i2 >= 0) {
                    if (i2 < list.size()) {
                        return list.get(i2);
                    }
                    return null;
                } else if (Math.abs(i2) <= list.size()) {
                    return list.get(list.size() + i2);
                } else {
                    return null;
                }
            } else if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                if (i2 >= 0) {
                    if (i2 < length) {
                        return Array.get(obj, i2);
                    }
                    return null;
                } else if (Math.abs(i2) <= length) {
                    return Array.get(obj, length + i2);
                } else {
                    return null;
                }
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                Object obj2 = map.get(Integer.valueOf(i2));
                return obj2 == null ? map.get(Integer.toString(i2)) : obj2;
            } else if (obj instanceof Collection) {
                int i3 = 0;
                for (Object obj3 : (Collection) obj) {
                    if (i3 == i2) {
                        return obj3;
                    }
                    i3++;
                }
                return null;
            } else {
                if (i2 == 0) {
                    return obj;
                }
                throw new UnsupportedOperationException();
            }
        }
        return invokeLI.objValue;
    }

    public JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cls)) == null) {
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                return (JavaBeanDeserializer) deserializer;
            }
            return null;
        }
        return (JavaBeanDeserializer) invokeL.objValue;
    }

    public JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cls)) == null) {
            ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
            if (objectWriter instanceof JavaBeanSerializer) {
                return (JavaBeanSerializer) objectWriter;
            }
            return null;
        }
        return (JavaBeanSerializer) invokeL.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.path : (String) invokeV.objValue;
    }

    public Object getPropertyValue(Object obj, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{obj, str, Long.valueOf(j2)})) == null) {
            JSONArray jSONArray = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof String) {
                try {
                    obj = JSON.parseObject((String) obj);
                } catch (Exception unused) {
                }
            }
            Object obj2 = obj;
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get(str);
                return obj3 == null ? (SIZE == j2 || LENGTH == j2) ? Integer.valueOf(map.size()) : obj3 : obj3;
            }
            JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj2.getClass());
            if (javaBeanSerializer != null) {
                try {
                    return javaBeanSerializer.getFieldValue(obj2, str, j2, false);
                } catch (Exception e2) {
                    throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e2);
                }
            }
            int i2 = 0;
            if (obj2 instanceof List) {
                List list = (List) obj2;
                if (SIZE != j2 && LENGTH != j2) {
                    while (i2 < list.size()) {
                        Object obj4 = list.get(i2);
                        if (obj4 == list) {
                            if (jSONArray == null) {
                                jSONArray = new JSONArray(list.size());
                            }
                            jSONArray.add(obj4);
                        } else {
                            Object propertyValue = getPropertyValue(obj4, str, j2);
                            if (propertyValue instanceof Collection) {
                                Collection collection = (Collection) propertyValue;
                                if (jSONArray == null) {
                                    jSONArray = new JSONArray(list.size());
                                }
                                jSONArray.addAll(collection);
                            } else if (propertyValue != null) {
                                if (jSONArray == null) {
                                    jSONArray = new JSONArray(list.size());
                                }
                                jSONArray.add(propertyValue);
                            }
                        }
                        i2++;
                    }
                    return jSONArray == null ? Collections.emptyList() : jSONArray;
                }
                return Integer.valueOf(list.size());
            } else if (obj2 instanceof Object[]) {
                Object[] objArr = (Object[]) obj2;
                if (SIZE != j2 && LENGTH != j2) {
                    JSONArray jSONArray2 = new JSONArray(objArr.length);
                    while (i2 < objArr.length) {
                        Object obj5 = objArr[i2];
                        if (obj5 == objArr) {
                            jSONArray2.add(obj5);
                        } else {
                            Object propertyValue2 = getPropertyValue(obj5, str, j2);
                            if (propertyValue2 instanceof Collection) {
                                jSONArray2.addAll((Collection) propertyValue2);
                            } else if (propertyValue2 != null) {
                                jSONArray2.add(propertyValue2);
                            }
                        }
                        i2++;
                    }
                    return jSONArray2;
                }
                return Integer.valueOf(objArr.length);
            } else {
                if (obj2 instanceof Enum) {
                    Enum r8 = (Enum) obj2;
                    if (-4270347329889690746L == j2) {
                        return r8.name();
                    }
                    if (-1014497654951707614L == j2) {
                        return Integer.valueOf(r8.ordinal());
                    }
                }
                if (obj2 instanceof Calendar) {
                    Calendar calendar = (Calendar) obj2;
                    if (8963398325558730460L == j2) {
                        return Integer.valueOf(calendar.get(1));
                    }
                    if (-811277319855450459L == j2) {
                        return Integer.valueOf(calendar.get(2));
                    }
                    if (-3851359326990528739L == j2) {
                        return Integer.valueOf(calendar.get(5));
                    }
                    if (4647432019745535567L == j2) {
                        return Integer.valueOf(calendar.get(11));
                    }
                    if (6607618197526598121L == j2) {
                        return Integer.valueOf(calendar.get(12));
                    }
                    if (-6586085717218287427L == j2) {
                        return Integer.valueOf(calendar.get(13));
                    }
                }
                return null;
            }
        }
        return invokeCommon.objValue;
    }

    public Collection<Object> getPropertyValues(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
            if (javaBeanSerializer != null) {
                try {
                    return javaBeanSerializer.getFieldValues(obj);
                } catch (Exception e2) {
                    throw new JSONPathException("jsonpath error, path " + this.path, e2);
                }
            } else if (obj instanceof Map) {
                return ((Map) obj).values();
            } else {
                if (obj instanceof Collection) {
                    return (Collection) obj;
                }
                throw new UnsupportedOperationException();
            }
        }
        return (Collection) invokeL.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.segments == null) {
            if ("*".equals(this.path)) {
                this.segments = new Segment[]{WildCardSegment.instance};
                return;
            }
            JSONPathParser jSONPathParser = new JSONPathParser(this.path);
            this.segments = jSONPathParser.explain();
            this.hasRefSegment = jSONPathParser.hasRefSegment;
        }
    }

    public boolean isRef() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                init();
                for (int i2 = 0; i2 < this.segments.length; i2++) {
                    Class<?> cls = this.segments[i2].getClass();
                    if (cls != ArrayAccessSegment.class && cls != PropertySegment.class) {
                        return false;
                    }
                }
                return true;
            } catch (JSONPathException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public Set<?> keySet(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048594, this, obj)) != null) {
            return (Set) invokeL.objValue;
        }
        if (obj == null) {
            return null;
        }
        init();
        int i2 = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i2 < segmentArr.length) {
                obj2 = segmentArr[i2].eval(this, obj, obj2);
                i2++;
            } else {
                return evalKeySet(obj2);
            }
        }
    }

    public void patchAdd(Object obj, Object obj2, boolean z) {
        Segment[] segmentArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048595, this, obj, obj2, z) == null) || obj == null) {
            return;
        }
        init();
        Object obj3 = null;
        int i2 = 0;
        Object obj4 = obj;
        while (true) {
            Segment[] segmentArr2 = this.segments;
            if (i2 >= segmentArr2.length) {
                break;
            }
            Segment segment = segmentArr2[i2];
            Object eval = segment.eval(this, obj, obj4);
            if (eval == null && i2 != this.segments.length - 1 && (segment instanceof PropertySegment)) {
                eval = new JSONObject();
                ((PropertySegment) segment).setValue(this, obj4, eval);
            }
            i2++;
            obj3 = obj4;
            obj4 = eval;
        }
        if (!z && (obj4 instanceof Collection)) {
            ((Collection) obj4).add(obj2);
            return;
        }
        if (obj4 != null && !z) {
            Class<?> cls = obj4.getClass();
            if (cls.isArray()) {
                int length = Array.getLength(obj4);
                Object newInstance = Array.newInstance(cls.getComponentType(), length + 1);
                System.arraycopy(obj4, 0, newInstance, 0, length);
                Array.set(newInstance, length, obj2);
                obj2 = newInstance;
            } else if (!Map.class.isAssignableFrom(cls)) {
                throw new JSONException("unsupported array put operation. " + cls);
            }
        }
        Segment segment2 = this.segments[segmentArr.length - 1];
        if (segment2 instanceof PropertySegment) {
            ((PropertySegment) segment2).setValue(this, obj3, obj2);
        } else if (segment2 instanceof ArrayAccessSegment) {
            ((ArrayAccessSegment) segment2).setValue(this, obj3, obj2);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            init();
            Collection<Object> collection = null;
            Segment[] segmentArr = this.segments;
            Segment segment = segmentArr[segmentArr.length - 1];
            Object obj2 = obj;
            int i2 = 0;
            while (true) {
                Segment[] segmentArr2 = this.segments;
                if (i2 >= segmentArr2.length) {
                    break;
                } else if (i2 == segmentArr2.length - 1) {
                    collection = obj2;
                    break;
                } else {
                    Segment segment2 = segmentArr2[i2];
                    if (i2 == segmentArr2.length - 2 && (segment instanceof FilterSegment) && (segment2 instanceof PropertySegment)) {
                        FilterSegment filterSegment = (FilterSegment) segment;
                        if (obj2 instanceof List) {
                            PropertySegment propertySegment = (PropertySegment) segment2;
                            Iterator it = ((List) obj2).iterator();
                            while (it.hasNext()) {
                                Object eval = propertySegment.eval(this, obj, it.next());
                                if (eval instanceof Iterable) {
                                    filterSegment.remove(this, obj, eval);
                                } else if ((eval instanceof Map) && filterSegment.filter.apply(this, obj, obj2, eval)) {
                                    it.remove();
                                }
                            }
                            return true;
                        } else if (obj2 instanceof Map) {
                            PropertySegment propertySegment2 = (PropertySegment) segment2;
                            Object eval2 = propertySegment2.eval(this, obj, obj2);
                            if (eval2 == null) {
                                return false;
                            }
                            if ((eval2 instanceof Map) && filterSegment.filter.apply(this, obj, obj2, eval2)) {
                                propertySegment2.remove(this, obj2);
                                return true;
                            }
                        }
                    }
                    obj2 = segment2.eval(this, obj, obj2);
                    if (obj2 == null) {
                        break;
                    }
                    i2++;
                }
            }
            if (collection == null) {
                return false;
            }
            if (segment instanceof PropertySegment) {
                PropertySegment propertySegment3 = (PropertySegment) segment;
                if (collection instanceof Collection) {
                    Segment[] segmentArr3 = this.segments;
                    if (segmentArr3.length > 1) {
                        Segment segment3 = segmentArr3[segmentArr3.length - 2];
                        if ((segment3 instanceof RangeSegment) || (segment3 instanceof MultiIndexSegment)) {
                            for (Object obj3 : collection) {
                                if (propertySegment3.remove(this, obj3)) {
                                    z = true;
                                }
                            }
                            return z;
                        }
                    }
                }
                return propertySegment3.remove(this, collection);
            } else if (segment instanceof ArrayAccessSegment) {
                return ((ArrayAccessSegment) segment).remove(this, collection);
            } else {
                if (segment instanceof FilterSegment) {
                    return ((FilterSegment) segment).remove(this, obj, collection);
                }
                throw new UnsupportedOperationException();
            }
        }
        return invokeL.booleanValue;
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, jSONPath, obj, i2)) == null) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (i2 >= 0) {
                    if (i2 >= list.size()) {
                        return false;
                    }
                    list.remove(i2);
                    return true;
                }
                int size = list.size() + i2;
                if (size < 0) {
                    return false;
                }
                list.remove(size);
                return true;
            }
            Class<?> cls = obj.getClass();
            throw new JSONPathException("unsupported set operation." + cls);
        }
        return invokeLLI.booleanValue;
    }

    public boolean removePropertyValue(Object obj, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048598, this, obj, str, z)) == null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                r1 = map.remove(str) != null;
                if (z) {
                    for (Object obj2 : map.values()) {
                        removePropertyValue(obj2, str, z);
                    }
                }
                return r1;
            }
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer == null) {
                if (z) {
                    return false;
                }
                throw new UnsupportedOperationException();
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer != null) {
                fieldDeserializer.setValue(obj, (String) null);
            } else {
                r1 = false;
            }
            if (z) {
                for (Object obj3 : getPropertyValues(obj)) {
                    if (obj3 != null) {
                        removePropertyValue(obj3, str, z);
                    }
                }
            }
            return r1;
        }
        return invokeLLZ.booleanValue;
    }

    public boolean set(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, obj, obj2)) == null) ? set(obj, obj2, true) : invokeLL.booleanValue;
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i2, Object obj2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048601, this, jSONPath, obj, i2, obj2)) == null) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (i2 >= 0) {
                    list.set(i2, obj2);
                } else {
                    list.set(list.size() + i2, obj2);
                }
                return true;
            }
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                if (i2 >= 0) {
                    if (i2 < length) {
                        Array.set(obj, i2, obj2);
                    }
                } else if (Math.abs(i2) <= length) {
                    Array.set(obj, length + i2, obj2);
                }
                return true;
            }
            throw new JSONPathException("unsupported set operation." + cls);
        }
        return invokeLLIL.booleanValue;
    }

    public boolean setPropertyValue(Object obj, String str, long j2, Object obj2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{obj, str, Long.valueOf(j2), obj2})) == null) {
            if (obj instanceof Map) {
                ((Map) obj).put(str, obj2);
                return true;
            } else if (obj instanceof List) {
                for (Object obj3 : (List) obj) {
                    if (obj3 != null) {
                        setPropertyValue(obj3, str, j2, obj2);
                    }
                }
                return true;
            } else {
                ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
                JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
                if (javaBeanDeserializer != null) {
                    FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j2);
                    if (fieldDeserializer == null) {
                        return false;
                    }
                    if (obj2 != null) {
                        Class<?> cls = obj2.getClass();
                        FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                        if (cls != fieldInfo.fieldClass) {
                            obj2 = TypeUtils.cast(obj2, fieldInfo.fieldType, this.parserConfig);
                        }
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    return true;
                }
                throw new UnsupportedOperationException();
            }
        }
        return invokeCommon.booleanValue;
    }

    public int size(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048603, this, obj)) != null) {
            return invokeL.intValue;
        }
        if (obj == null) {
            return -1;
        }
        init();
        int i2 = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i2 < segmentArr.length) {
                obj2 = segmentArr[i2].eval(this, obj, obj2);
                i2++;
            } else {
                return evalSize(obj2);
            }
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? JSON.toJSONString(this.path) : (String) invokeV.objValue;
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, serializeConfig, parserConfig};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (str != null && str.length() != 0) {
            this.path = str;
            this.serializeConfig = serializeConfig;
            this.parserConfig = parserConfig;
            return;
        }
        throw new JSONPathException("json-path can not be null or empty");
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, obj, serializeConfig)) == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            HashMap hashMap = new HashMap();
            paths(identityHashMap, hashMap, "/", obj, serializeConfig);
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean set(Object obj, Object obj2, boolean z) {
        InterceptResult invokeLLZ;
        Class<?> cls;
        JavaBeanDeserializer javaBeanDeserializer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048600, this, obj, obj2, z)) == null) {
            if (obj == null) {
                return false;
            }
            init();
            Object obj3 = obj;
            Object obj4 = null;
            int i2 = 0;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i2 >= segmentArr.length) {
                    obj3 = obj4;
                    break;
                }
                Segment segment = segmentArr[i2];
                Object eval = segment.eval(this, obj, obj3);
                if (eval == null) {
                    Segment[] segmentArr2 = this.segments;
                    Segment segment2 = i2 < segmentArr2.length - 1 ? segmentArr2[i2 + 1] : null;
                    if (segment2 instanceof PropertySegment) {
                        if (segment instanceof PropertySegment) {
                            String str = ((PropertySegment) segment).propertyName;
                            JavaBeanDeserializer javaBeanDeserializer2 = getJavaBeanDeserializer(obj3.getClass());
                            if (javaBeanDeserializer2 != null) {
                                cls = javaBeanDeserializer2.getFieldDeserializer(str).fieldInfo.fieldClass;
                                javaBeanDeserializer = getJavaBeanDeserializer(cls);
                                if (javaBeanDeserializer == null) {
                                    if (javaBeanDeserializer.beanInfo.defaultConstructor == null) {
                                        return false;
                                    }
                                    eval = javaBeanDeserializer.createInstance((DefaultJSONParser) null, cls);
                                } else {
                                    eval = new JSONObject();
                                }
                            }
                        }
                        cls = null;
                        javaBeanDeserializer = null;
                        if (javaBeanDeserializer == null) {
                        }
                    } else {
                        eval = segment2 instanceof ArrayAccessSegment ? new JSONArray() : null;
                    }
                    if (eval != null) {
                        if (segment instanceof PropertySegment) {
                            ((PropertySegment) segment).setValue(this, obj3, eval);
                        } else if (!(segment instanceof ArrayAccessSegment)) {
                            break;
                        } else {
                            ((ArrayAccessSegment) segment).setValue(this, obj3, eval);
                        }
                    } else {
                        break;
                    }
                }
                i2++;
                obj4 = obj3;
                obj3 = eval;
            }
            if (obj3 == null) {
                return false;
            }
            Segment[] segmentArr3 = this.segments;
            Segment segment3 = segmentArr3[segmentArr3.length - 1];
            if (segment3 instanceof PropertySegment) {
                ((PropertySegment) segment3).setValue(this, obj3, obj2);
                return true;
            } else if (segment3 instanceof ArrayAccessSegment) {
                return ((ArrayAccessSegment) segment3).setValue(this, obj3, obj2);
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static Object eval(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, obj, str)) == null) ? compile(str).eval(obj) : invokeLL.objValue;
    }

    public static Set<?> keySet(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, obj, str)) == null) {
            JSONPath compile = compile(str);
            return compile.evalKeySet(compile.eval(obj));
        }
        return (Set) invokeLL.objValue;
    }

    public static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65554, null, map, map2, str, obj, serializeConfig) == null) || obj == null) {
            return;
        }
        int i2 = 0;
        if (map.put(obj, str) != null) {
            Class<?> cls = obj.getClass();
            if (!(cls == String.class || cls == Boolean.class || cls == Character.class || cls == UUID.class || cls.isEnum() || (obj instanceof Number) || (obj instanceof Date))) {
                return;
            }
        }
        map2.put(str, obj);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals("/")) {
                        sb4 = new StringBuilder();
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(str);
                    }
                    sb4.append("/");
                    sb4.append(key);
                    paths(map, map2, sb4.toString(), entry.getValue(), serializeConfig);
                }
            }
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals("/")) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append("/");
                sb3.append(i2);
                paths(map, map2, sb3.toString(), obj2, serializeConfig);
                i2++;
            }
        } else {
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray()) {
                int length = Array.getLength(obj);
                while (i2 < length) {
                    Object obj3 = Array.get(obj, i2);
                    if (str.equals("/")) {
                        sb2 = new StringBuilder();
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(str);
                    }
                    sb2.append("/");
                    sb2.append(i2);
                    paths(map, map2, sb2.toString(), obj3, serializeConfig);
                    i2++;
                }
            } else if (!ParserConfig.isPrimitive2(cls2) && !cls2.isEnum()) {
                ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls2);
                if (objectWriter instanceof JavaBeanSerializer) {
                    try {
                        for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                            String key2 = entry2.getKey();
                            if (key2 instanceof String) {
                                if (str.equals("/")) {
                                    sb = new StringBuilder();
                                    sb.append("/");
                                    sb.append(key2);
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("/");
                                    sb.append(key2);
                                }
                                paths(map, map2, sb.toString(), entry2.getValue(), serializeConfig);
                            }
                        }
                    } catch (Exception e2) {
                        throw new JSONException("toJSON error", e2);
                    }
                }
            }
        }
    }

    public static int size(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, obj, str)) == null) {
            JSONPath compile = compile(str);
            return compile.evalSize(compile.eval(obj));
        }
        return invokeLL.intValue;
    }

    public static boolean contains(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, str)) == null) {
            if (obj == null) {
                return false;
            }
            return compile(str).contains(obj);
        }
        return invokeLL.booleanValue;
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, str, obj2)) == null) ? compile(str).containsValue(obj, obj2) : invokeLLL.booleanValue;
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, obj, str, objArr) == null) {
            compile(str).arrayAdd(obj, objArr);
        }
    }

    public static Object extract(String str, String str2, ParserConfig parserConfig, int i2, Feature... featureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, parserConfig, Integer.valueOf(i2), featureArr})) == null) {
            DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i2 | Feature.OrderedField.mask);
            Object extract = compile(str2).extract(defaultJSONParser);
            defaultJSONParser.lexer.close();
            return extract;
        }
        return invokeCommon.objValue;
    }

    public static Object extract(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) ? extract(str, str2, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]) : invokeLL.objValue;
    }

    public static boolean set(Object obj, String str, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, obj, str, obj2)) == null) ? compile(str).set(obj, obj2) : invokeLLL.booleanValue;
    }

    public static boolean remove(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, obj, str)) == null) ? compile(str).remove(obj) : invokeLL.booleanValue;
    }
}
