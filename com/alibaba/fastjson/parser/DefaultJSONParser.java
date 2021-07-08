package com.alibaba.fastjson.parser;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class DefaultJSONParser implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public static final Set<Class<?>> primitiveClasses;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] autoTypeAccept;
    public boolean autoTypeEnable;
    public ParserConfig config;
    public ParseContext context;
    public ParseContext[] contextArray;
    public int contextArrayIndex;
    public DateFormat dateFormat;
    public String dateFormatPattern;
    public List<ExtraProcessor> extraProcessors;
    public List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final Object input;
    public transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int objectKeyLevel;
    public int resolveStatus;
    public List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: classes.dex */
    public static class ResolveTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parseContext, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1755127227, "Lcom/alibaba/fastjson/parser/DefaultJSONParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1755127227, "Lcom/alibaba/fastjson/parser/DefaultJSONParser;");
                return;
            }
        }
        primitiveClasses = new HashSet();
        primitiveClasses.addAll(Arrays.asList(Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (ParserConfig) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    private void addContext(ParseContext parseContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, parseContext) == null) {
            int i2 = this.contextArrayIndex;
            this.contextArrayIndex = i2 + 1;
            ParseContext[] parseContextArr = this.contextArray;
            if (parseContextArr == null) {
                this.contextArray = new ParseContext[8];
            } else if (i2 >= parseContextArr.length) {
                ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
                System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
                this.contextArray = parseContextArr2;
            }
            this.contextArray[i2] = parseContext;
        }
    }

    public final void accept(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token() == i2) {
                jSONLexer.nextToken();
                return;
            }
            throw new JSONException("syntax error, expect " + JSONToken.name(i2) + ", actual " + JSONToken.name(jSONLexer.token()));
        }
    }

    public void acceptType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            JSONLexer jSONLexer = this.lexer;
            jSONLexer.nextTokenWithColon();
            if (jSONLexer.token() == 4) {
                if (str.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                        return;
                    }
                    return;
                }
                throw new JSONException("type not match error");
            }
            throw new JSONException("type not match error");
        }
    }

    public void addResolveTask(ResolveTask resolveTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, resolveTask) == null) {
            if (this.resolveTaskList == null) {
                this.resolveTaskList = new ArrayList(2);
            }
            this.resolveTaskList.add(resolveTask);
        }
    }

    public void checkListResolve(Collection collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, collection) == null) && this.resolveStatus == 1) {
            if (collection instanceof List) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, map, obj) == null) && this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            JSONLexer jSONLexer = this.lexer;
            try {
                if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                    throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
                }
            } finally {
                jSONLexer.close();
            }
        }
    }

    public void config(Feature feature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, feature, z) == null) {
            this.lexer.config(feature, z);
        }
    }

    public ParserConfig getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.config : (ParserConfig) invokeV.objValue;
    }

    public ParseContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.context : (ParseContext) invokeV.objValue;
    }

    public String getDateFomartPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.dateFormatPattern : (String) invokeV.objValue;
    }

    public DateFormat getDateFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.dateFormat == null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
                this.dateFormat = simpleDateFormat;
                simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
            }
            return this.dateFormat;
        }
        return (DateFormat) invokeV.objValue;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.extraProcessors == null) {
                this.extraProcessors = new ArrayList(2);
            }
            return this.extraProcessors;
        }
        return (List) invokeV.objValue;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.extraTypeProviders == null) {
                this.extraTypeProviders = new ArrayList(2);
            }
            return this.extraTypeProviders;
        }
        return (List) invokeV.objValue;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.fieldTypeResolver : (FieldTypeResolver) invokeV.objValue;
    }

    public String getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Object obj = this.input;
            if (obj instanceof char[]) {
                return new String((char[]) this.input);
            }
            return obj.toString();
        }
        return (String) invokeV.objValue;
    }

    public ResolveTask getLastResolveTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            List<ResolveTask> list = this.resolveTaskList;
            return list.get(list.size() - 1);
        }
        return (ResolveTask) invokeV.objValue;
    }

    public JSONLexer getLexer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.lexer : (JSONLexer) invokeV.objValue;
    }

    public Object getObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            for (int i2 = 0; i2 < this.contextArrayIndex; i2++) {
                if (str.equals(this.contextArray[i2].toString())) {
                    return this.contextArray[i2].object;
                }
            }
            return null;
        }
        return invokeL.objValue;
    }

    public ParseContext getOwnerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.context.parent : (ParseContext) invokeV.objValue;
    }

    public int getResolveStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.resolveStatus : invokeV.intValue;
    }

    public List<ResolveTask> getResolveTaskList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.resolveTaskList == null) {
                this.resolveTaskList = new ArrayList(2);
            }
            return this.resolveTaskList;
        }
        return (List) invokeV.objValue;
    }

    public SymbolTable getSymbolTable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.symbolTable : (SymbolTable) invokeV.objValue;
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list;
        Object obj2;
        FieldInfo fieldInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, obj) == null) || (list = this.resolveTaskList) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i2);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj3 = parseContext != null ? parseContext.object : null;
            if (str.startsWith("$")) {
                obj2 = getObject(str);
                if (obj2 == null) {
                    try {
                        JSONPath compile = JSONPath.compile(str);
                        if (compile.isRef()) {
                            obj2 = compile.eval(obj);
                        }
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                obj2 = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (obj2 != null && obj2.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    Object obj4 = this.contextArray[0].object;
                    JSONPath compile2 = JSONPath.compile(str);
                    if (compile2.isRef()) {
                        obj2 = compile2.eval(obj4);
                    }
                }
                if (fieldDeserializer.getOwnerClass() != null && !fieldDeserializer.getOwnerClass().isInstance(obj3) && resolveTask.ownerContext.parent != null && fieldDeserializer.getOwnerClass().isInstance(resolveTask.ownerContext.parent.object)) {
                    obj3 = resolveTask.ownerContext.parent.object;
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, feature)) == null) ? this.lexer.isEnabled(feature) : invokeL.booleanValue;
    }

    public Object parse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? parse(null) : invokeV.objValue;
    }

    public <T> List<T> parseArray(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, cls)) == null) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class<?>) cls, (Collection) arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public Object parseArrayWithType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, type)) == null) {
            if (this.lexer.token() == 8) {
                this.lexer.nextToken();
                return null;
            }
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                Type type2 = actualTypeArguments[0];
                if (type2 instanceof Class) {
                    ArrayList arrayList = new ArrayList();
                    parseArray((Class) type2, (Collection) arrayList);
                    return arrayList;
                } else if (type2 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type2;
                    Type type3 = wildcardType.getUpperBounds()[0];
                    if (Object.class.equals(type3)) {
                        if (wildcardType.getLowerBounds().length == 0) {
                            return parse();
                        }
                        throw new JSONException("not support type : " + type);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else {
                    if (type2 instanceof TypeVariable) {
                        TypeVariable typeVariable = (TypeVariable) type2;
                        Type[] bounds = typeVariable.getBounds();
                        if (bounds.length == 1) {
                            Type type4 = bounds[0];
                            if (type4 instanceof Class) {
                                ArrayList arrayList3 = new ArrayList();
                                parseArray((Class) type4, (Collection) arrayList3);
                                return arrayList3;
                            }
                        } else {
                            throw new JSONException("not support : " + typeVariable);
                        }
                    }
                    if (type2 instanceof ParameterizedType) {
                        ArrayList arrayList4 = new ArrayList();
                        parseArray((ParameterizedType) type2, arrayList4);
                        return arrayList4;
                    }
                    throw new JSONException("TODO : " + type);
                }
            }
            throw new JSONException("not support type " + type);
        }
        return invokeL.objValue;
    }

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, obj, str) == null) {
            this.lexer.nextTokenWithColon();
            List<ExtraTypeProvider> list = this.extraTypeProviders;
            Type type = null;
            if (list != null) {
                for (ExtraTypeProvider extraTypeProvider : list) {
                    type = extraTypeProvider.getExtraType(obj, str);
                }
            }
            if (type == null) {
                parseObject = parse();
            } else {
                parseObject = parseObject(type);
            }
            if (obj instanceof ExtraProcessable) {
                ((ExtraProcessable) obj).processExtra(str, parseObject);
                return;
            }
            List<ExtraProcessor> list2 = this.extraProcessors;
            if (list2 != null) {
                for (ExtraProcessor extraProcessor : list2) {
                    extraProcessor.processExtra(obj, str, parseObject);
                }
            }
            if (this.resolveStatus == 1) {
                this.resolveStatus = 0;
            }
        }
    }

    public Object parseKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.lexer.token() == 18) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken(16);
                return stringVal;
            }
            return parse(null);
        }
        return invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x028d, code lost:
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0298, code lost:
        if (r4.token() != 13) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x029a, code lost:
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02a5, code lost:
        if ((r17.config.getDeserializer(r7) instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02a7, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r18, (java.lang.Class<java.lang.Object>) r7, r17.config);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02ae, code lost:
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02af, code lost:
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02b3, code lost:
        if (r7 != java.lang.Cloneable.class) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02b5, code lost:
        r0 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02c1, code lost:
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02c3, code lost:
        r0 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02ce, code lost:
        if ("java.util.Collections$UnmodifiableMap".equals(r6) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02d0, code lost:
        r0 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02da, code lost:
        r0 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02e1, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02ea, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02eb, code lost:
        setResolveStatus(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02f1, code lost:
        if (r17.context == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02f3, code lost:
        if (r19 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02f7, code lost:
        if ((r19 instanceof java.lang.Integer) != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02ff, code lost:
        if ((r17.context.fieldName instanceof java.lang.Integer) != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0301, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0308, code lost:
        if (r18.size() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x030a, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r18, (java.lang.Class<java.lang.Object>) r7, r17.config);
        setResolveStatus(0);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x031a, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x031b, code lost:
        r0 = r17.config.getDeserializer(r7);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x032b, code lost:
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x032f, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0333, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0335, code lost:
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x033c, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x033e, code lost:
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0349, code lost:
        return r0.deserialze(r17, r7, r19);
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x021b A[Catch: all -> 0x069c, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0459 A[Catch: all -> 0x069c, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0484 A[Catch: all -> 0x069c, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04e0 A[Catch: all -> 0x069c, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x05e4 A[Catch: all -> 0x069c, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05f0 A[Catch: all -> 0x069c, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x05fc A[Catch: all -> 0x069c, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0611 A[Catch: all -> 0x069c, TRY_ENTER, TryCatch #1 {all -> 0x069c, blocks: (B:26:0x0076, B:28:0x007a, B:31:0x0084, B:34:0x0097, B:38:0x00af, B:117:0x021b, B:118:0x0221, B:120:0x022c, B:122:0x0234, B:126:0x0249, B:128:0x0257, B:143:0x0287, B:144:0x028d, B:146:0x029a, B:147:0x029d, B:149:0x02a7, B:154:0x02b5, B:155:0x02bb, B:157:0x02c3, B:158:0x02c8, B:160:0x02d0, B:161:0x02da, B:165:0x02e3, B:166:0x02ea, B:167:0x02eb, B:170:0x02f5, B:172:0x02f9, B:174:0x0301, B:175:0x0304, B:177:0x030a, B:180:0x031b, B:186:0x0335, B:190:0x0342, B:187:0x033a, B:189:0x033e, B:130:0x025e, B:132:0x0264, B:137:0x0271, B:140:0x0277, B:197:0x0354, B:199:0x035a, B:201:0x0362, B:203:0x036c, B:205:0x037d, B:207:0x0388, B:209:0x0390, B:211:0x0394, B:213:0x039c, B:216:0x03a1, B:218:0x03a5, B:241:0x040b, B:243:0x0413, B:246:0x041c, B:247:0x0436, B:220:0x03ac, B:222:0x03b4, B:224:0x03b8, B:225:0x03bb, B:226:0x03c7, B:229:0x03d0, B:231:0x03d4, B:232:0x03d7, B:234:0x03db, B:235:0x03df, B:236:0x03eb, B:238:0x03f5, B:240:0x0402, B:248:0x0437, B:249:0x0455, B:252:0x0459, B:254:0x045d, B:256:0x0463, B:258:0x0469, B:259:0x046c, B:263:0x0474, B:269:0x0484, B:271:0x0493, B:273:0x049e, B:274:0x04a6, B:275:0x04a9, B:287:0x04d5, B:289:0x04e0, B:293:0x04ed, B:296:0x04fd, B:297:0x051d, B:282:0x04b9, B:284:0x04c3, B:286:0x04d2, B:285:0x04c8, B:300:0x0522, B:302:0x052c, B:304:0x0534, B:305:0x0537, B:307:0x0542, B:308:0x0546, B:310:0x0551, B:313:0x0558, B:316:0x0561, B:317:0x0566, B:320:0x056b, B:322:0x0570, B:326:0x057b, B:328:0x0583, B:330:0x0598, B:334:0x05b7, B:336:0x05bf, B:339:0x05c5, B:341:0x05cb, B:343:0x05d3, B:346:0x05e4, B:349:0x05ec, B:351:0x05f0, B:352:0x05f7, B:354:0x05fc, B:355:0x05ff, B:357:0x0607, B:360:0x0611, B:363:0x061b, B:364:0x0620, B:365:0x0625, B:366:0x063f, B:331:0x05a3, B:332:0x05aa, B:367:0x0640, B:369:0x0652, B:372:0x0659, B:375:0x0667, B:376:0x0687, B:41:0x00c1, B:42:0x00df, B:45:0x00e4, B:47:0x00ef, B:49:0x00f3, B:51:0x00f9, B:53:0x00ff, B:54:0x0102, B:61:0x0111, B:63:0x0119, B:66:0x0129, B:67:0x0141, B:68:0x0142, B:69:0x0147, B:80:0x015c, B:81:0x0162, B:83:0x0169, B:85:0x0172, B:92:0x0184, B:95:0x018c, B:96:0x01a4, B:90:0x017f, B:84:0x016e, B:97:0x01a5, B:98:0x01bd, B:104:0x01c7, B:106:0x01cf, B:109:0x01e0, B:110:0x0200, B:111:0x0201, B:112:0x0206, B:113:0x0207, B:115:0x0211, B:377:0x0688, B:378:0x068f, B:379:0x0690, B:380:0x0695, B:381:0x0696, B:382:0x069b), top: B:392:0x0076, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x018c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0607 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x04e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseObject(Map map, Object obj) {
        InterceptResult invokeLL;
        Object parse;
        boolean z;
        Object decimalValue;
        char current;
        Map jSONObject;
        boolean z2;
        Object obj2;
        Number decimalValue2;
        Object obj3;
        char current2;
        Object fluentPut;
        Object obj4;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048619, this, map, obj)) != null) {
            return invokeLL.objValue;
        }
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 13) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() == 4 && jSONLexer.stringVal().length() == 0) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName() + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONLexer.info());
        } else {
            ParseContext parseContext = this.context;
            try {
                boolean z3 = map instanceof JSONObject;
                Map<String, Object> innerMap = z3 ? ((JSONObject) map).getInnerMap() : map;
                boolean z4 = false;
                while (true) {
                    jSONLexer.skipWhitespace();
                    char current3 = jSONLexer.getCurrent();
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (current3 == ',') {
                            jSONLexer.next();
                            jSONLexer.skipWhitespace();
                            current3 = jSONLexer.getCurrent();
                        }
                    }
                    boolean z5 = true;
                    if (current3 == '\"') {
                        parse = jSONLexer.scanSymbol(this.symbolTable, Typography.quote);
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos() + ", name " + parse);
                        }
                    } else if (current3 == '}') {
                        jSONLexer.next();
                        jSONLexer.resetStringPosition();
                        jSONLexer.nextToken();
                        if (!z4) {
                            if (this.context != null && obj == this.context.fieldName && map == this.context.object) {
                                parseContext = this.context;
                            } else {
                                ParseContext context = setContext(map, obj);
                                if (parseContext == null) {
                                    parseContext = context;
                                }
                            }
                        }
                        return map;
                    } else if (current3 == '\'') {
                        if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                            parse = jSONLexer.scanSymbol(this.symbolTable, '\'');
                            jSONLexer.skipWhitespace();
                            if (jSONLexer.getCurrent() != ':') {
                                throw new JSONException("expect ':' at " + jSONLexer.pos());
                            }
                        } else {
                            throw new JSONException("syntax error");
                        }
                    } else if (current3 == 26) {
                        throw new JSONException("syntax error");
                    } else {
                        if (current3 == ',') {
                            throw new JSONException("syntax error");
                        }
                        if ((current3 >= '0' && current3 <= '9') || current3 == '-') {
                            jSONLexer.resetStringPosition();
                            jSONLexer.scanNumber();
                            try {
                                if (jSONLexer.token() == 2) {
                                    decimalValue = jSONLexer.integerValue();
                                } else {
                                    decimalValue = jSONLexer.decimalValue(true);
                                }
                                if (!jSONLexer.isEnabled(Feature.NonStringKeyAsString)) {
                                    if (z3) {
                                    }
                                    parse = decimalValue;
                                    if (jSONLexer.getCurrent() == ':') {
                                        throw new JSONException("parse number key error" + jSONLexer.info());
                                    }
                                }
                                decimalValue = decimalValue.toString();
                                parse = decimalValue;
                                if (jSONLexer.getCurrent() == ':') {
                                }
                            } catch (NumberFormatException unused) {
                                throw new JSONException("parse number key error" + jSONLexer.info());
                            }
                        } else {
                            if (current3 != '{' && current3 != '[') {
                                if (jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                                    parse = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                                    jSONLexer.skipWhitespace();
                                    char current4 = jSONLexer.getCurrent();
                                    if (current4 != ':') {
                                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current4);
                                    }
                                } else {
                                    throw new JSONException("syntax error");
                                }
                            }
                            int i2 = this.objectKeyLevel;
                            this.objectKeyLevel = i2 + 1;
                            if (i2 <= 512) {
                                jSONLexer.nextToken();
                                parse = parse();
                                z = true;
                                if (!z) {
                                    jSONLexer.next();
                                    jSONLexer.skipWhitespace();
                                }
                                current = jSONLexer.getCurrent();
                                jSONLexer.resetStringPosition();
                                if (parse != JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                                    String scanSymbol = jSONLexer.scanSymbol(this.symbolTable, Typography.quote);
                                    if (!jSONLexer.isEnabled(Feature.IgnoreAutoType)) {
                                        if (map != null && map.getClass().getName().equals(scanSymbol)) {
                                            cls = map.getClass();
                                            obj4 = null;
                                        } else {
                                            for (int i3 = 0; i3 < scanSymbol.length(); i3++) {
                                                char charAt = scanSymbol.charAt(i3);
                                                if (charAt >= '0' && charAt <= '9') {
                                                }
                                                z5 = false;
                                            }
                                            if (z5) {
                                                obj4 = null;
                                                cls = null;
                                            } else {
                                                obj4 = null;
                                                cls = this.config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures());
                                            }
                                        }
                                        if (cls != null) {
                                            break;
                                        }
                                        innerMap.put(JSON.DEFAULT_TYPE_KEY, scanSymbol);
                                    }
                                } else if (parse != "$ref" && parseContext != null && ((map == null || map.size() == 0) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect))) {
                                    jSONLexer.nextToken(4);
                                    if (jSONLexer.token() == 4) {
                                        String stringVal = jSONLexer.stringVal();
                                        jSONLexer.nextToken(13);
                                        if (jSONLexer.token() == 16) {
                                            innerMap.put(parse, stringVal);
                                        } else {
                                            if (TNCManager.TNC_PROBE_HEADER_SECEPTOR.equals(stringVal)) {
                                                if (this.context != null) {
                                                    ParseContext parseContext2 = this.context;
                                                    Object obj5 = parseContext2.object;
                                                    if (!(obj5 instanceof Object[]) && !(obj5 instanceof Collection)) {
                                                        if (parseContext2.parent != null) {
                                                            fluentPut = parseContext2.parent.object;
                                                        }
                                                    }
                                                    fluentPut = obj5;
                                                }
                                                fluentPut = null;
                                            } else if (IStringUtil.TOP_PATH.equals(stringVal)) {
                                                if (parseContext.object != null) {
                                                    fluentPut = parseContext.object;
                                                } else {
                                                    addResolveTask(new ResolveTask(parseContext, stringVal));
                                                    setResolveStatus(1);
                                                    fluentPut = null;
                                                }
                                            } else if ("$".equals(stringVal)) {
                                                ParseContext parseContext3 = parseContext;
                                                while (parseContext3.parent != null) {
                                                    parseContext3 = parseContext3.parent;
                                                }
                                                if (parseContext3.object != null) {
                                                    fluentPut = parseContext3.object;
                                                } else {
                                                    addResolveTask(new ResolveTask(parseContext3, stringVal));
                                                    setResolveStatus(1);
                                                    fluentPut = null;
                                                }
                                            } else if (JSONPath.compile(stringVal).isRef()) {
                                                addResolveTask(new ResolveTask(parseContext, stringVal));
                                                setResolveStatus(1);
                                                fluentPut = null;
                                            } else {
                                                fluentPut = new JSONObject().fluentPut("$ref", stringVal);
                                            }
                                            if (jSONLexer.token() == 13) {
                                                jSONLexer.nextToken(16);
                                                return fluentPut;
                                            }
                                            throw new JSONException("syntax error, " + jSONLexer.info());
                                        }
                                    } else {
                                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                                    }
                                } else {
                                    if (!z4) {
                                        if (this.context != null && obj == this.context.fieldName && map == this.context.object) {
                                            parseContext = this.context;
                                        } else {
                                            ParseContext context2 = setContext(map, obj);
                                            if (parseContext == null) {
                                                parseContext = context2;
                                            }
                                            z4 = true;
                                        }
                                    }
                                    if (map.getClass() == JSONObject.class && parse == null) {
                                        parse = StringUtil.NULL_STRING;
                                    }
                                    if (current != '\"') {
                                        jSONLexer.scanString();
                                        String stringVal2 = jSONLexer.stringVal();
                                        Number number = stringVal2;
                                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                            JSONScanner jSONScanner = new JSONScanner(stringVal2);
                                            Date date = stringVal2;
                                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                                date = jSONScanner.getCalendar().getTime();
                                            }
                                            jSONScanner.close();
                                            number = date;
                                        }
                                        innerMap.put(parse, number);
                                        obj3 = number;
                                    } else if ((current >= '0' && current <= '9') || current == '-') {
                                        jSONLexer.scanNumber();
                                        if (jSONLexer.token() == 2) {
                                            decimalValue2 = jSONLexer.integerValue();
                                        } else {
                                            decimalValue2 = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                                        }
                                        innerMap.put(parse, decimalValue2);
                                        obj3 = decimalValue2;
                                    } else if (current == '[') {
                                        jSONLexer.nextToken();
                                        Collection jSONArray = new JSONArray();
                                        if (obj != null) {
                                            obj.getClass();
                                        }
                                        if (obj == null) {
                                            setContext(parseContext);
                                        }
                                        parseArray(jSONArray, parse);
                                        Object[] objArr = jSONArray;
                                        if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                            objArr = jSONArray.toArray();
                                        }
                                        innerMap.put(parse, objArr);
                                        if (jSONLexer.token() == 13) {
                                            jSONLexer.nextToken();
                                            return map;
                                        } else if (jSONLexer.token() != 16) {
                                            throw new JSONException("syntax error");
                                        }
                                    } else if (current == '{') {
                                        jSONLexer.nextToken();
                                        boolean z6 = obj != null && obj.getClass() == Integer.class;
                                        if (jSONLexer.isEnabled(Feature.CustomMapDeserializer)) {
                                            MapDeserializer mapDeserializer = (MapDeserializer) this.config.getDeserializer(Map.class);
                                            if ((jSONLexer.getFeatures() & Feature.OrderedField.mask) != 0) {
                                                jSONObject = mapDeserializer.createMap(Map.class, jSONLexer.getFeatures());
                                            } else {
                                                jSONObject = mapDeserializer.createMap(Map.class);
                                            }
                                        } else {
                                            jSONObject = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
                                        }
                                        ParseContext context3 = !z6 ? setContext(this.context, jSONObject, parse) : null;
                                        if (this.fieldTypeResolver != null) {
                                            Type resolve = this.fieldTypeResolver.resolve(map, parse != null ? parse.toString() : null);
                                            if (resolve != null) {
                                                obj2 = this.config.getDeserializer(resolve).deserialze(this, resolve, parse);
                                                z2 = true;
                                                if (!z2) {
                                                    obj2 = parseObject(jSONObject, parse);
                                                }
                                                if (context3 != null && jSONObject != obj2) {
                                                    context3.object = map;
                                                }
                                                if (parse != null) {
                                                    checkMapResolve(map, parse.toString());
                                                }
                                                innerMap.put(parse, obj2);
                                                if (z6) {
                                                    setContext(obj2, parse);
                                                }
                                                if (jSONLexer.token() != 13) {
                                                    jSONLexer.nextToken();
                                                    setContext(parseContext);
                                                    return map;
                                                } else if (jSONLexer.token() != 16) {
                                                    throw new JSONException("syntax error, " + jSONLexer.tokenName());
                                                } else if (z6) {
                                                    popContext();
                                                } else {
                                                    setContext(parseContext);
                                                }
                                            }
                                        }
                                        z2 = false;
                                        obj2 = null;
                                        if (!z2) {
                                        }
                                        if (context3 != null) {
                                            context3.object = map;
                                        }
                                        if (parse != null) {
                                        }
                                        innerMap.put(parse, obj2);
                                        if (z6) {
                                        }
                                        if (jSONLexer.token() != 13) {
                                        }
                                    } else {
                                        jSONLexer.nextToken();
                                        innerMap.put(parse, parse());
                                        if (jSONLexer.token() == 13) {
                                            jSONLexer.nextToken();
                                            return map;
                                        } else if (jSONLexer.token() != 16) {
                                            throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + parse);
                                        }
                                    }
                                    jSONLexer.skipWhitespace();
                                    current2 = jSONLexer.getCurrent();
                                    if (current2 == ',') {
                                        if (current2 == '}') {
                                            jSONLexer.next();
                                            jSONLexer.resetStringPosition();
                                            jSONLexer.nextToken();
                                            setContext(obj3, parse);
                                            return map;
                                        }
                                        throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + parse);
                                    }
                                    jSONLexer.next();
                                }
                            } else {
                                throw new JSONException("object key level > 512");
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                    current = jSONLexer.getCurrent();
                    jSONLexer.resetStringPosition();
                    if (parse != JSON.DEFAULT_TYPE_KEY) {
                    }
                    if (parse != "$ref") {
                    }
                    if (!z4) {
                    }
                    if (map.getClass() == JSONObject.class) {
                        parse = StringUtil.NULL_STRING;
                    }
                    if (current != '\"') {
                    }
                    jSONLexer.skipWhitespace();
                    current2 = jSONLexer.getCurrent();
                    if (current2 == ',') {
                    }
                }
            } finally {
                setContext(parseContext);
            }
        }
    }

    public void popContext() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i2 = this.contextArrayIndex;
        if (i2 <= 0) {
            return;
        }
        int i3 = i2 - 1;
        this.contextArrayIndex = i3;
        this.contextArray[i3] = null;
    }

    public Object resolveReference(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
            if (this.contextArray == null) {
                return null;
            }
            int i2 = 0;
            while (true) {
                ParseContext[] parseContextArr = this.contextArray;
                if (i2 >= parseContextArr.length || i2 >= this.contextArrayIndex) {
                    break;
                }
                ParseContext parseContext = parseContextArr[i2];
                if (parseContext.toString().equals(str)) {
                    return parseContext.object;
                }
                i2++;
            }
            return null;
        }
        return invokeL.objValue;
    }

    public void setConfig(ParserConfig parserConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, parserConfig) == null) {
            this.config = parserConfig;
        }
    }

    public void setContext(ParseContext parseContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, parseContext) == null) || this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, dateFormat) == null) {
            setDateFormat(dateFormat);
        }
    }

    public void setDateFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.dateFormatPattern = str;
            this.dateFormat = null;
        }
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, fieldTypeResolver) == null) {
            this.fieldTypeResolver = fieldTypeResolver;
        }
    }

    public void setResolveStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.resolveStatus = i2;
        }
    }

    public void throwException(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            throw new JSONException("syntax error, expect " + JSONToken.name(i2) + ", actual " + JSONToken.name(this.lexer.token()));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, parserConfig};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], (JSONLexer) objArr2[1], (ParserConfig) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    public Object parse(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            JSONLexer jSONLexer = this.lexer;
            int i2 = jSONLexer.token();
            if (i2 == 2) {
                Number integerValue = jSONLexer.integerValue();
                jSONLexer.nextToken();
                return integerValue;
            } else if (i2 == 3) {
                Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                jSONLexer.nextToken();
                return decimalValue;
            } else if (i2 == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                    try {
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            return jSONScanner.getCalendar().getTime();
                        }
                    } finally {
                        jSONScanner.close();
                    }
                }
                return stringVal;
            } else if (i2 != 12) {
                if (i2 == 14) {
                    JSONArray jSONArray = new JSONArray();
                    parseArray(jSONArray, obj);
                    return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
                } else if (i2 == 18) {
                    if (WalletPayViewController.DEF_CHANNEL_TITLE.equals(jSONLexer.stringVal())) {
                        jSONLexer.nextToken();
                        return null;
                    }
                    throw new JSONException("syntax error, " + jSONLexer.info());
                } else if (i2 != 26) {
                    switch (i2) {
                        case 6:
                            jSONLexer.nextToken();
                            return Boolean.TRUE;
                        case 7:
                            jSONLexer.nextToken();
                            return Boolean.FALSE;
                        case 8:
                            jSONLexer.nextToken();
                            return null;
                        case 9:
                            jSONLexer.nextToken(18);
                            if (jSONLexer.token() == 18) {
                                jSONLexer.nextToken(10);
                                accept(10);
                                long longValue = jSONLexer.integerValue().longValue();
                                accept(2);
                                accept(11);
                                return new Date(longValue);
                            }
                            throw new JSONException("syntax error");
                        default:
                            switch (i2) {
                                case 20:
                                    if (jSONLexer.isBlankInput()) {
                                        return null;
                                    }
                                    throw new JSONException("unterminated json string, " + jSONLexer.info());
                                case 21:
                                    jSONLexer.nextToken();
                                    HashSet hashSet = new HashSet();
                                    parseArray(hashSet, obj);
                                    return hashSet;
                                case 22:
                                    jSONLexer.nextToken();
                                    TreeSet treeSet = new TreeSet();
                                    parseArray(treeSet, obj);
                                    return treeSet;
                                case 23:
                                    jSONLexer.nextToken();
                                    return null;
                                default:
                                    throw new JSONException("syntax error, " + jSONLexer.info());
                            }
                    }
                } else {
                    byte[] bytesValue = jSONLexer.bytesValue();
                    jSONLexer.nextToken();
                    return bytesValue;
                }
            } else {
                return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
            }
        }
        return invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultJSONParser(String str, ParserConfig parserConfig, int i2) {
        this(str, new JSONScanner(str, i2), parserConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, parserConfig, Integer.valueOf(i2)};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], (JSONLexer) objArr2[1], (ParserConfig) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
    }

    public void parseArray(Class<?> cls, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, cls, collection) == null) {
            parseArray((Type) cls, collection);
        }
    }

    public ParseContext setContext(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048625, this, obj, obj2)) == null) {
            if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
                return null;
            }
            return setContext(this.context, obj, obj2);
        }
        return (ParseContext) invokeLL.objValue;
    }

    public void setDateFormat(DateFormat dateFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, dateFormat) == null) {
            this.dateFormat = dateFormat;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultJSONParser(char[] cArr, int i2, ParserConfig parserConfig, int i3) {
        this(cArr, new JSONScanner(cArr, i2, i3), parserConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, Integer.valueOf(i2), parserConfig, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], (JSONLexer) objArr2[1], (ParserConfig) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    public void parseArray(Type type, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, type, collection) == null) {
            parseArray(type, collection, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONLexer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((JSONLexer) objArr2[0], (ParserConfig) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048607, this, type, collection, obj) != null) {
            return;
        }
        int i2 = this.lexer.token();
        if (i2 == 21 || i2 == 22) {
            this.lexer.nextToken();
            i2 = this.lexer.token();
        }
        if (i2 == 14) {
            if (Integer.TYPE != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    this.lexer.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
            } else {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i3 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE != type) {
                        if (String.class == type) {
                            if (this.lexer.token() == 4) {
                                obj2 = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj2 = parse.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.lexer.token() == 8) {
                                this.lexer.nextToken();
                            } else {
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i3));
                            }
                            collection.add(obj2);
                            checkListResolve(collection);
                        }
                    } else {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i3++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("expect '[', but " + JSONToken.name(i2) + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048624, this, parseContext, obj, obj2)) == null) {
            if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
                return null;
            }
            ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
            this.context = parseContext2;
            addContext(parseContext2);
            return this.context;
        }
        return (ParseContext) invokeLLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONLexer, parserConfig};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], (JSONLexer) objArr2[1], (ParserConfig) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void accept(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token() == i2) {
                jSONLexer.nextToken(i3);
            } else {
                throwException(i2);
            }
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, jSONLexer, parserConfig};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.objectKeyLevel = 0;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        InterceptResult invokeL;
        Object cast;
        Class<?> cls;
        boolean z;
        Class cls2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, typeArr)) == null) {
            int i2 = 8;
            if (this.lexer.token() == 8) {
                this.lexer.nextToken(16);
                return null;
            }
            int i3 = 14;
            if (this.lexer.token() == 14) {
                Object[] objArr = new Object[typeArr.length];
                if (typeArr.length == 0) {
                    this.lexer.nextToken(15);
                    if (this.lexer.token() == 15) {
                        this.lexer.nextToken(16);
                        return new Object[0];
                    }
                    throw new JSONException("syntax error");
                }
                this.lexer.nextToken(2);
                int i4 = 0;
                while (i4 < typeArr.length) {
                    if (this.lexer.token() == i2) {
                        this.lexer.nextToken(16);
                        cast = null;
                    } else {
                        Type type = typeArr[i4];
                        if (type != Integer.TYPE && type != Integer.class) {
                            if (type == String.class) {
                                if (this.lexer.token() == 4) {
                                    cast = this.lexer.stringVal();
                                    this.lexer.nextToken(16);
                                } else {
                                    cast = TypeUtils.cast(parse(), type, this.config);
                                }
                            } else {
                                if (i4 == typeArr.length - 1 && (type instanceof Class) && (((cls2 = (Class) type) != byte[].class && cls2 != char[].class) || this.lexer.token() != 4)) {
                                    z = cls2.isArray();
                                    cls = cls2.getComponentType();
                                } else {
                                    cls = null;
                                    z = false;
                                }
                                if (z && this.lexer.token() != i3) {
                                    ArrayList arrayList = new ArrayList();
                                    ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                    int fastMatchToken = deserializer.getFastMatchToken();
                                    if (this.lexer.token() != 15) {
                                        while (true) {
                                            arrayList.add(deserializer.deserialze(this, type, null));
                                            if (this.lexer.token() != 16) {
                                                break;
                                            }
                                            this.lexer.nextToken(fastMatchToken);
                                        }
                                        if (this.lexer.token() != 15) {
                                            throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                        }
                                    }
                                    cast = TypeUtils.cast(arrayList, type, this.config);
                                } else {
                                    cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i4));
                                }
                            }
                        } else if (this.lexer.token() == 2) {
                            cast = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    }
                    objArr[i4] = cast;
                    if (this.lexer.token() == 15) {
                        break;
                    } else if (this.lexer.token() == 16) {
                        if (i4 == typeArr.length - 1) {
                            this.lexer.nextToken(15);
                        } else {
                            this.lexer.nextToken(2);
                        }
                        i4++;
                        i2 = 8;
                        i3 = 14;
                    } else {
                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                    }
                }
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return objArr;
                }
                throw new JSONException("syntax error");
            }
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        }
        return (Object[]) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x023a, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object parse(PropertyProcessable propertyProcessable, Object obj) {
        InterceptResult invokeLL;
        String scanSymbolUnQuoted;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048602, this, propertyProcessable, obj)) != null) {
            return invokeLL.objValue;
        }
        int i2 = 0;
        if (this.lexer.token() != 12) {
            String str = "syntax error, expect {, actual " + this.lexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + StringUtil.ARRAY_ELEMENT_SEPARATOR) + this.lexer.info();
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            if (jSONArray.size() == 1) {
                Object obj2 = jSONArray.get(0);
                if (obj2 instanceof JSONObject) {
                    return (JSONObject) obj2;
                }
            }
            throw new JSONException(str2);
        }
        ParseContext parseContext = this.context;
        while (true) {
            try {
                this.lexer.skipWhitespace();
                char current = this.lexer.getCurrent();
                if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        this.lexer.next();
                        this.lexer.skipWhitespace();
                        current = this.lexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, Typography.quote);
                    this.lexer.skipWhitespace();
                    if (this.lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos());
                    }
                } else if (current == '}') {
                    this.lexer.next();
                    this.lexer.resetStringPosition();
                    this.lexer.nextToken(16);
                    return propertyProcessable;
                } else if (current == '\'') {
                    if (this.lexer.isEnabled(Feature.AllowSingleQuotes)) {
                        scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, '\'');
                        this.lexer.skipWhitespace();
                        if (this.lexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + this.lexer.pos());
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (this.lexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    scanSymbolUnQuoted = this.lexer.scanSymbolUnQuoted(this.symbolTable);
                    this.lexer.skipWhitespace();
                    char current2 = this.lexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos() + ", actual " + current2);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
                this.lexer.next();
                this.lexer.skipWhitespace();
                this.lexer.getCurrent();
                this.lexer.resetStringPosition();
                Object obj3 = null;
                if (scanSymbolUnQuoted == JSON.DEFAULT_TYPE_KEY && !this.lexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    Class<?> checkAutoType = this.config.checkAutoType(this.lexer.scanSymbol(this.symbolTable, Typography.quote), null, this.lexer.getFeatures());
                    if (Map.class.isAssignableFrom(checkAutoType)) {
                        this.lexer.nextToken(16);
                        if (this.lexer.token() == 13) {
                            this.lexer.nextToken(16);
                            return propertyProcessable;
                        }
                    } else {
                        ObjectDeserializer deserializer = this.config.getDeserializer(checkAutoType);
                        this.lexer.nextToken(16);
                        setResolveStatus(2);
                        if (parseContext != null && !(obj instanceof Integer)) {
                            popContext();
                        }
                        return (Map) deserializer.deserialze(this, checkAutoType, obj);
                    }
                } else {
                    this.lexer.nextToken();
                    if (i2 != 0) {
                        setContext(parseContext);
                    }
                    Type type = propertyProcessable.getType(scanSymbolUnQuoted);
                    if (this.lexer.token() == 8) {
                        this.lexer.nextToken();
                    } else {
                        obj3 = parseObject(type, scanSymbolUnQuoted);
                    }
                    propertyProcessable.apply(scanSymbolUnQuoted, obj3);
                    setContext(parseContext, obj3, scanSymbolUnQuoted);
                    setContext(parseContext);
                    int i3 = this.lexer.token();
                    if (i3 == 20 || i3 == 15) {
                        break;
                    } else if (i3 == 13) {
                        this.lexer.nextToken();
                        return propertyProcessable;
                    }
                }
                i2++;
            } finally {
                setContext(parseContext);
            }
        }
    }

    public final void parseArray(Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, collection) == null) {
            parseArray(collection, (Object) null);
        }
    }

    public final void parseArray(Collection collection, Object obj) {
        Number decimalValue;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048609, this, collection, obj) != null) {
            return;
        }
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            if (parseContext != null && parseContext.level > 512) {
                throw new JSONException("array level > 512");
            }
            ParseContext parseContext2 = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i3 = jSONLexer.token();
                    Number number = null;
                    number = null;
                    if (i3 == 2) {
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        number = integerValue;
                    } else if (i3 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            decimalValue = jSONLexer.decimalValue(true);
                        } else {
                            decimalValue = jSONLexer.decimalValue(false);
                        }
                        number = decimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i3 == 4) {
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        number = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Date date = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                date = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            number = date;
                        }
                    } else if (i3 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        number = bool;
                    } else if (i3 == 7) {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        number = bool2;
                    } else if (i3 == 8) {
                        jSONLexer.nextToken(4);
                    } else if (i3 == 12) {
                        number = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i2));
                    } else if (i3 == 20) {
                        throw new JSONException("unclosed jsonArray");
                    } else {
                        if (i3 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i3 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i2));
                            number = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                number = jSONArray.toArray();
                            }
                        } else if (i3 != 15) {
                            number = parse();
                        } else {
                            jSONLexer.nextToken(16);
                            return;
                        }
                    }
                    collection.add(number);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i2++;
                } finally {
                    setContext(parseContext2);
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, cls)) == null) ? (T) parseObject(cls, (Object) null) : (T) invokeL.objValue;
    }

    public <T> T parseObject(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, type)) == null) ? (T) parseObject(type, (Object) null) : (T) invokeL.objValue;
    }

    public <T> T parseObject(Type type, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, type, obj)) == null) {
            int i2 = this.lexer.token();
            if (i2 == 8) {
                this.lexer.nextToken();
                return null;
            }
            if (i2 == 4) {
                if (type == byte[].class) {
                    T t = (T) this.lexer.bytesValue();
                    this.lexer.nextToken();
                    return t;
                } else if (type == char[].class) {
                    String stringVal = this.lexer.stringVal();
                    this.lexer.nextToken();
                    return (T) stringVal.toCharArray();
                }
            }
            ObjectDeserializer deserializer = this.config.getDeserializer(type);
            try {
                if (deserializer.getClass() == JavaBeanDeserializer.class) {
                    if (this.lexer.token() != 12 && this.lexer.token() != 14) {
                        throw new JSONException("syntax error,except start with { or [,but actually start with " + this.lexer.tokenName());
                    }
                    return (T) ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
                }
                return (T) deserializer.deserialze(this, type, obj);
            } catch (JSONException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new JSONException(th.getMessage(), th);
            }
        }
        return (T) invokeLL.objValue;
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048620, this, obj) != null) {
            return;
        }
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, map)) == null) ? parseObject(map, (Object) null) : invokeL.objValue;
    }

    public JSONObject parseObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            Object parseObject = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
            if (parseObject instanceof JSONObject) {
                return (JSONObject) parseObject;
            }
            if (parseObject == null) {
                return null;
            }
            return new JSONObject((Map) parseObject);
        }
        return (JSONObject) invokeV.objValue;
    }
}
