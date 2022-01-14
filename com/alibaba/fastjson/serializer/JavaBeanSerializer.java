package com.alibaba.fastjson.serializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SerializeBeanInfo beanInfo;
    public final FieldSerializer[] getters;
    public volatile transient long[] hashArray;
    public volatile transient short[] hashArrayMapping;
    public final FieldSerializer[] sortedGetters;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Class) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr)) == null) {
            HashMap hashMap = new HashMap();
            for (String str : strArr) {
                hashMap.put(str, str);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONSerializer, str)) == null) {
            List<LabelFilter> list = jSONSerializer.labelFilters;
            if (list != null) {
                for (LabelFilter labelFilter : list) {
                    if (!labelFilter.apply(str)) {
                        return false;
                    }
                }
            }
            List<LabelFilter> list2 = this.labelFilters;
            if (list2 != null) {
                for (LabelFilter labelFilter2 : list2) {
                    if (!labelFilter2.apply(str)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public BeanContext getBeanContext(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.sortedGetters[i2].fieldContext : (BeanContext) invokeI.objValue;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        InterceptResult invokeL;
        FieldSerializer[] fieldSerializerArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            HashSet hashSet = new HashSet();
            for (FieldSerializer fieldSerializer : this.sortedGetters) {
                if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                    hashSet.add(fieldSerializer.fieldInfo.name);
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public FieldSerializer getFieldSerializer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return null;
            }
            int i2 = 0;
            int length = this.sortedGetters.length - 1;
            while (i2 <= length) {
                int i3 = (i2 + length) >>> 1;
                int compareTo = this.sortedGetters[i3].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i2 = i3 + 1;
                } else if (compareTo <= 0) {
                    return this.sortedGetters[i3];
                } else {
                    length = i3 - 1;
                }
            }
            return null;
        }
        return (FieldSerializer) invokeL.objValue;
    }

    public Type getFieldType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.sortedGetters[i2].fieldInfo.fieldType : (Type) invokeI.objValue;
    }

    public Object getFieldValue(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, obj, str)) == null) {
            FieldSerializer fieldSerializer = getFieldSerializer(str);
            if (fieldSerializer != null) {
                try {
                    return fieldSerializer.getPropertyValue(obj);
                } catch (IllegalAccessException e2) {
                    throw new JSONException("getFieldValue error." + str, e2);
                } catch (InvocationTargetException e3) {
                    throw new JSONException("getFieldValue error." + str, e3);
                }
            }
            throw new JSONException("field not found. " + str);
        }
        return invokeLL.objValue;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            ArrayList arrayList = new ArrayList(this.sortedGetters.length);
            for (FieldSerializer fieldSerializer : this.sortedGetters) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        InterceptResult invokeL;
        FieldSerializer[] fieldSerializerArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
            for (FieldSerializer fieldSerializer : this.sortedGetters) {
                boolean isEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
                FieldInfo fieldInfo = fieldSerializer.fieldInfo;
                if (!isEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                    FieldInfo fieldInfo2 = fieldSerializer.fieldInfo;
                    if (fieldInfo2.unwrapped) {
                        Object json = JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                        if (json instanceof Map) {
                            linkedHashMap.putAll((Map) json);
                        } else {
                            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                        }
                    } else {
                        linkedHashMap.put(fieldInfo2.name, fieldSerializer.getPropertyValue(obj));
                    }
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        InterceptResult invokeL;
        FieldSerializer[] fieldSerializerArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            ArrayList arrayList = new ArrayList(this.sortedGetters.length);
            for (FieldSerializer fieldSerializer : this.sortedGetters) {
                Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
                if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                    arrayList.add(fieldSerializer.getPropertyValue(obj));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public int getSize(Object obj) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            int i2 = 0;
            for (FieldSerializer fieldSerializer : this.sortedGetters) {
                if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public Class<?> getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.beanInfo.beanType : (Class) invokeV.objValue;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jSONSerializer)) == null) ? isWriteAsArray(jSONSerializer, 0) : invokeL.booleanValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            write(jSONSerializer, obj, obj2, type, i2, false);
        }
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{jSONSerializer, obj, Character.valueOf(c2)})) == null) {
            List<AfterFilter> list = jSONSerializer.afterFilters;
            if (list != null) {
                for (AfterFilter afterFilter : list) {
                    c2 = afterFilter.writeAfter(jSONSerializer, obj, c2);
                }
            }
            List<AfterFilter> list2 = this.afterFilters;
            if (list2 != null) {
                for (AfterFilter afterFilter2 : list2) {
                    c2 = afterFilter2.writeAfter(jSONSerializer, obj, c2);
                }
            }
            return c2;
        }
        return invokeCommon.charValue;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            write(jSONSerializer, obj, obj2, type, i2);
        }
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            write(jSONSerializer, obj, obj2, type, i2);
        }
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{jSONSerializer, obj, Character.valueOf(c2)})) == null) {
            List<BeforeFilter> list = jSONSerializer.beforeFilters;
            if (list != null) {
                for (BeforeFilter beforeFilter : list) {
                    c2 = beforeFilter.writeBefore(jSONSerializer, obj, c2);
                }
            }
            List<BeforeFilter> list2 = this.beforeFilters;
            if (list2 != null) {
                for (BeforeFilter beforeFilter2 : list2) {
                    c2 = beforeFilter2.writeBefore(jSONSerializer, obj, c2);
                }
            }
            return c2;
        }
        return invokeCommon.charValue;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, jSONSerializer, str, obj) == null) {
            if (str == null) {
                str = jSONSerializer.config.typeKey;
            }
            jSONSerializer.out.writeFieldName(str, false);
            String str2 = this.beanInfo.typeName;
            if (str2 == null) {
                Class<?> cls = obj.getClass();
                if (TypeUtils.isProxy(cls)) {
                    cls = cls.getSuperclass();
                }
                str2 = cls.getName();
            }
            jSONSerializer.write(str2);
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            write(jSONSerializer, obj, obj2, type, i2);
        }
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            write(jSONSerializer, obj, obj2, type, i2, false);
        }
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i2) {
        InterceptResult invokeLLI;
        IdentityHashMap<Object, SerialContext> identityHashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048600, this, jSONSerializer, obj, i2)) == null) {
            SerialContext serialContext = jSONSerializer.context;
            int i3 = SerializerFeature.DisableCircularReferenceDetect.mask;
            if (serialContext != null && (serialContext.features & i3) == 0 && (i2 & i3) == 0 && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj)) {
                jSONSerializer.writeReference(obj);
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, strArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Class) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, jSONSerializer, i2)) == null) {
            int i3 = SerializerFeature.BeanToArray.mask;
            return ((this.beanInfo.features & i3) == 0 && !jSONSerializer.out.beanToArray && (i2 & i3) == 0) ? false : true;
        }
        return invokeLI.booleanValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:430:0x05dc
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r36, java.lang.Object r37, java.lang.Object r38, java.lang.reflect.Type r39, int r40, boolean r41) throws java.io.IOException {
        /*
            r35 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.alibaba.fastjson.serializer.JavaBeanSerializer.$ic
            if (r0 != 0) goto L5e2
        L4:
            r8 = r35
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            com.alibaba.fastjson.serializer.SerializeWriter r15 = r9.out
            if (r10 != 0) goto L1a
            r15.writeNull()
            return
        L1a:
            boolean r1 = r8.writeReference(r9, r10, r13)
            if (r1 == 0) goto L21
            return
        L21:
            boolean r1 = r15.sortField
            if (r1 == 0) goto L28
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r8.sortedGetters
            goto L2a
        L28:
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r8.getters
        L2a:
            r7 = r1
            com.alibaba.fastjson.serializer.SerialContext r6 = r9.context
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo
            java.lang.Class<?> r1 = r1.beanType
            boolean r1 = r1.isEnum()
            if (r1 != 0) goto L49
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo
            int r5 = r1.features
            r1 = r36
            r2 = r6
            r3 = r37
            r4 = r38
            r11 = r6
            r6 = r40
            r1.setContext(r2, r3, r4, r5, r6)
            goto L4a
        L49:
            r11 = r6
        L4a:
            boolean r16 = r8.isWriteAsArray(r9, r13)
            if (r16 == 0) goto L53
            r1 = 91
            goto L55
        L53:
            r1 = 123(0x7b, float:1.72E-43)
        L55:
            if (r16 == 0) goto L5c
            r2 = 93
            r6 = 93
            goto L60
        L5c:
            r2 = 125(0x7d, float:1.75E-43)
            r6 = 125(0x7d, float:1.75E-43)
        L60:
            r17 = 0
            if (r41 != 0) goto L6e
            r15.append(r1)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            goto L6e
        L68:
            r0 = move-exception
            r3 = r0
            r1 = r10
            r2 = r11
            goto L528
        L6e:
            int r1 = r7.length     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            if (r1 <= 0) goto L7f
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            boolean r1 = r15.isEnabled(r1)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            if (r1 == 0) goto L7f
            r36.incrementIndent()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            r36.println()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
        L7f:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            int r1 = r1.features     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            int r2 = r2.mask     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            r1 = r1 & r2
            if (r1 != 0) goto L97
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            int r1 = r1.mask     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            r1 = r1 & r13
            if (r1 != 0) goto L97
            boolean r1 = r9.isWriteClassName(r12, r10)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            if (r1 == 0) goto Lb2
        L97:
            java.lang.Class r1 = r37.getClass()     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            if (r1 == r12) goto La6
            boolean r2 = r12 instanceof java.lang.reflect.WildcardType     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            if (r2 == 0) goto La6
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r39)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            goto La7
        La6:
            r2 = r12
        La7:
            if (r1 == r2) goto Lb2
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            java.lang.String r1 = r1.typeKey     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            r8.writeClassName(r9, r1, r10)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L51f
            r1 = 1
            goto Lb3
        Lb2:
            r1 = 0
        Lb3:
            r3 = 44
            if (r1 == 0) goto Lba
            r1 = 44
            goto Lbb
        Lba:
            r1 = 0
        Lbb:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            boolean r18 = r15.isEnabled(r2)     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            char r1 = r8.writeBefore(r9, r10, r1)     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            if (r1 != r3) goto Lc9
            r1 = 1
            goto Lca
        Lc9:
            r1 = 0
        Lca:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            boolean r19 = r15.isEnabled(r2)     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            boolean r20 = r15.isEnabled(r2)     // Catch: java.lang.Throwable -> L51f java.lang.Exception -> L524
            r21 = r1
            r1 = r17
            r2 = 0
        Ldb:
            int r3 = r7.length     // Catch: java.lang.Exception -> L516 java.lang.Throwable -> L51f
            if (r2 >= r3) goto L4d4
            r3 = r7[r2]     // Catch: java.lang.Exception -> L4cc java.lang.Throwable -> L51f
            com.alibaba.fastjson.util.FieldInfo r4 = r3.fieldInfo     // Catch: java.lang.Exception -> L4cc java.lang.Throwable -> L51f
            java.lang.reflect.Field r4 = r4.field     // Catch: java.lang.Exception -> L4cc java.lang.Throwable -> L51f
            com.alibaba.fastjson.util.FieldInfo r13 = r3.fieldInfo     // Catch: java.lang.Exception -> L4cc java.lang.Throwable -> L51f
            r24 = r11
            java.lang.String r11 = r13.name     // Catch: java.lang.Exception -> L4c3 java.lang.Throwable -> L50c
            r25 = r7
            java.lang.Class<?> r7 = r13.fieldClass     // Catch: java.lang.Exception -> L4c3 java.lang.Throwable -> L50c
            int r5 = r15.features     // Catch: java.lang.Exception -> L4c3 java.lang.Throwable -> L50c
            r27 = r1
            int r1 = r13.serialzeFeatures     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r28 = r2
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r29 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r5, r1, r2)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r1 = r15.quoteFieldNames     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r1 == 0) goto L105
            if (r29 != 0) goto L105
            r30 = 1
            goto L107
        L105:
            r30 = 0
        L107:
            if (r19 == 0) goto L115
            if (r13 == 0) goto L115
            boolean r1 = r13.fieldTransient     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            if (r1 == 0) goto L115
            goto L119
        L110:
            r0 = move-exception
            r3 = r0
            r1 = r10
            goto L4c9
        L115:
            if (r20 == 0) goto L123
            if (r4 != 0) goto L123
        L119:
            r33 = r6
            r34 = r25
        L11d:
            r3 = 44
            r5 = 1
            r7 = 0
            goto L4af
        L123:
            boolean r1 = r8.applyName(r9, r10, r11)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r1 == 0) goto L134
            java.lang.String r1 = r13.label     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            boolean r1 = r8.applyLabel(r9, r1)     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            if (r1 != 0) goto L132
            goto L134
        L132:
            r1 = 0
            goto L137
        L134:
            if (r16 == 0) goto L119
            r1 = 1
        L137:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r2 = r8.beanInfo     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            java.lang.String r2 = r2.typeKey     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 == 0) goto L14e
            com.alibaba.fastjson.serializer.SerializeBeanInfo r2 = r8.beanInfo     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            java.lang.String r2 = r2.typeKey     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            boolean r2 = r11.equals(r2)     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            if (r2 == 0) goto L14e
            boolean r2 = r9.isWriteClassName(r12, r10)     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            if (r2 == 0) goto L14e
            goto L119
        L14e:
            if (r1 == 0) goto L153
        L150:
            r1 = r17
            goto L165
        L153:
            java.lang.Object r1 = r3.getPropertyValueDirect(r10)     // Catch: java.lang.Exception -> L110 java.lang.reflect.InvocationTargetException -> L158 java.lang.Throwable -> L50c
            goto L165
        L158:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter     // Catch: java.lang.Exception -> L4a6 java.lang.Throwable -> L50c
            boolean r2 = r15.isEnabled(r2)     // Catch: java.lang.Exception -> L4a6 java.lang.Throwable -> L50c
            if (r2 == 0) goto L4a2
            r27 = r3
            goto L150
        L165:
            boolean r2 = r8.apply(r9, r10, r11, r1)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 != 0) goto L170
            r33 = r6
            r34 = r25
            goto L11d
        L170:
            if (r7 != r14) goto L185
            java.lang.String r2 = "trim"
            java.lang.String r4 = r13.format     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            if (r2 == 0) goto L185
            if (r1 == 0) goto L185
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L110 java.lang.Throwable -> L50c
        L185:
            r5 = r1
            java.lang.String r4 = r8.processKey(r9, r10, r11, r5)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.BeanContext r2 = r3.fieldContext     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r1 = r35
            r31 = r2
            r2 = r36
            r12 = r3
            r10 = 44
            r3 = r31
            r32 = r4
            r22 = 0
            r4 = r37
            r23 = r5
            r5 = r11
            r33 = r6
            r6 = r23
            r10 = r7
            r34 = r25
            r7 = r40
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            java.lang.String r2 = ""
            if (r1 != 0) goto L2c3
            int r3 = r13.serialzeFeatures     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.annotation.JSONField r4 = r13.getAnnotation()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializeBeanInfo r5 = r8.beanInfo     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.annotation.JSONType r5 = r5.jsonType     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r5 == 0) goto L1ca
            com.alibaba.fastjson.serializer.SerializeBeanInfo r5 = r8.beanInfo     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.annotation.JSONType r5 = r5.jsonType     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature[] r5 = r5.serialzeFeatures()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r5 = com.alibaba.fastjson.serializer.SerializerFeature.of(r5)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 | r5
        L1ca:
            if (r4 == 0) goto L1dc
            java.lang.String r5 = r4.defaultValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r5 = r2.equals(r5)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r5 != 0) goto L1dc
            java.lang.String r1 = r4.defaultValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L2c3
        L1dc:
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            if (r10 != r4) goto L20e
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 | r4
            if (r16 != 0) goto L1f6
            r6 = r3 & r5
            if (r6 != 0) goto L1f6
            int r6 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 & r6
            if (r5 != 0) goto L1f6
            goto L37e
        L1f6:
            r5 = r3 & r4
            if (r5 == 0) goto L1fe
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L2c3
        L1fe:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r4 = r4 & r5
            if (r4 == 0) goto L2c3
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 & r4
            if (r3 != 0) goto L2c3
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L2c3
        L20e:
            if (r10 != r14) goto L23a
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 | r4
            if (r16 != 0) goto L226
            r6 = r3 & r5
            if (r6 != 0) goto L226
            int r6 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 & r6
            if (r5 != 0) goto L226
            goto L37e
        L226:
            r5 = r3 & r4
            if (r5 == 0) goto L22d
        L22a:
            r1 = r2
            goto L2c3
        L22d:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r4 = r4 & r5
            if (r4 == 0) goto L2c3
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 & r4
            if (r3 != 0) goto L2c3
            goto L22a
        L23a:
            java.lang.Class<java.lang.Number> r4 = java.lang.Number.class
            boolean r4 = r4.isAssignableFrom(r10)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L272
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 | r4
            if (r16 != 0) goto L258
            r6 = r3 & r5
            if (r6 != 0) goto L258
            int r6 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 & r6
            if (r5 != 0) goto L258
            goto L37e
        L258:
            r5 = r3 & r4
            if (r5 == 0) goto L261
            java.lang.Integer r1 = java.lang.Integer.valueOf(r22)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L2c3
        L261:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r4 = r4 & r5
            if (r4 == 0) goto L2c3
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 & r4
            if (r3 != 0) goto L2c3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r22)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L2c3
        L272:
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            boolean r4 = r4.isAssignableFrom(r10)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L2aa
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 | r4
            if (r16 != 0) goto L290
            r6 = r3 & r5
            if (r6 != 0) goto L290
            int r6 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = r5 & r6
            if (r5 != 0) goto L290
            goto L37e
        L290:
            r5 = r3 & r4
            if (r5 == 0) goto L299
            java.util.List r1 = java.util.Collections.emptyList()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L2c3
        L299:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r4 = r4 & r5
            if (r4 == 0) goto L2c3
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 & r4
            if (r3 != 0) goto L2c3
            java.util.List r1 = java.util.Collections.emptyList()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L2c3
        L2aa:
            if (r16 != 0) goto L2c3
            boolean r4 = r12.writeNull     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 != 0) goto L2c3
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r4 = r15.isEnabled(r4)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 != 0) goto L2c3
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 & r4
            if (r3 != 0) goto L2c3
            goto L37e
        L2c3:
            if (r1 == 0) goto L36b
            boolean r3 = r15.notWriteDefaultValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != 0) goto L2dd
            int r3 = r13.serialzeFeatures     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 & r4
            if (r3 != 0) goto L2dd
            com.alibaba.fastjson.serializer.SerializeBeanInfo r3 = r8.beanInfo     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r3 = r3.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r3 = r3 & r4
            if (r3 == 0) goto L36b
        L2dd:
            java.lang.Class<?> r3 = r13.fieldClass     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            java.lang.Class r4 = java.lang.Byte.TYPE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != r4) goto L2f2
            boolean r4 = r1 instanceof java.lang.Byte     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L2f2
            r4 = r1
            java.lang.Byte r4 = (java.lang.Byte) r4     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            byte r4 = r4.byteValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 != 0) goto L2f2
            goto L37e
        L2f2:
            java.lang.Class r4 = java.lang.Short.TYPE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != r4) goto L305
            boolean r4 = r1 instanceof java.lang.Short     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L305
            r4 = r1
            java.lang.Short r4 = (java.lang.Short) r4     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            short r4 = r4.shortValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 != 0) goto L305
            goto L37e
        L305:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != r4) goto L318
            boolean r4 = r1 instanceof java.lang.Integer     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L318
            r4 = r1
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 != 0) goto L318
            goto L37e
        L318:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != r4) goto L32e
            boolean r4 = r1 instanceof java.lang.Long     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L32e
            r4 = r1
            java.lang.Long r4 = (java.lang.Long) r4     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            long r4 = r4.longValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r6 = 0
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 != 0) goto L32e
            goto L37e
        L32e:
            java.lang.Class r4 = java.lang.Float.TYPE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != r4) goto L343
            boolean r4 = r1 instanceof java.lang.Float     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L343
            r4 = r1
            java.lang.Float r4 = (java.lang.Float) r4     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            float r4 = r4.floatValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L343
            goto L37e
        L343:
            java.lang.Class r4 = java.lang.Double.TYPE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != r4) goto L359
            boolean r4 = r1 instanceof java.lang.Double     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L359
            r4 = r1
            java.lang.Double r4 = (java.lang.Double) r4     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            double r4 = r4.doubleValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r6 = 0
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 != 0) goto L359
            goto L37e
        L359:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != r4) goto L36b
            boolean r3 = r1 instanceof java.lang.Boolean     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 == 0) goto L36b
            r3 = r1
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != 0) goto L36b
            goto L37e
        L36b:
            if (r21 == 0) goto L391
            boolean r3 = r13.unwrapped     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 == 0) goto L380
            boolean r3 = r1 instanceof java.util.Map     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 == 0) goto L380
            r3 = r1
            java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r3 = r3.size()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r3 != 0) goto L380
        L37e:
            goto L11d
        L380:
            r3 = 44
            r15.write(r3)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r4 = r15.isEnabled(r4)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r4 == 0) goto L393
            r36.println()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L393
        L391:
            r3 = 44
        L393:
            r4 = r32
            if (r4 == r11) goto L3a5
            if (r16 != 0) goto L39e
            r5 = 1
            r15.writeFieldName(r4, r5)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L39f
        L39e:
            r5 = 1
        L39f:
            r9.write(r1)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
        L3a2:
            r7 = 0
            goto L466
        L3a5:
            r4 = r23
            r5 = 1
            if (r4 == r1) goto L3b3
            if (r16 != 0) goto L3af
            r12.writePrefix(r9)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
        L3af:
            r9.write(r1)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L3a2
        L3b3:
            if (r16 != 0) goto L3ef
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            boolean r4 = r4.isAssignableFrom(r10)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r6 = r10.isPrimitive()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r6 != 0) goto L3cd
            java.lang.String r6 = r10.getName()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            java.lang.String r7 = "java."
            boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r6 == 0) goto L3d1
        L3cd:
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            if (r10 != r6) goto L3d3
        L3d1:
            r6 = 1
            goto L3d4
        L3d3:
            r6 = 0
        L3d4:
            if (r18 != 0) goto L3de
            boolean r7 = r13.unwrapped     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r7 == 0) goto L3de
            if (r4 != 0) goto L3ef
            if (r6 != 0) goto L3ef
        L3de:
            if (r30 == 0) goto L3ea
            char[] r4 = r13.name_chars     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            char[] r6 = r13.name_chars     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r6 = r6.length     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r7 = 0
            r15.write(r4, r7, r6)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L3f0
        L3ea:
            r7 = 0
            r12.writePrefix(r9)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L3f0
        L3ef:
            r7 = 0
        L3f0:
            if (r16 != 0) goto L463
            com.alibaba.fastjson.annotation.JSONField r4 = r13.getAnnotation()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r10 != r14) goto L449
            if (r4 == 0) goto L402
            java.lang.Class r4 = r4.serializeUsing()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            java.lang.Class<java.lang.Void> r6 = java.lang.Void.class
            if (r4 != r6) goto L449
        L402:
            if (r1 != 0) goto L43c
            int r4 = r12.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r8.beanInfo     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.annotation.JSONType r6 = r6.jsonType     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r6 == 0) goto L419
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r8.beanInfo     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.annotation.JSONType r6 = r6.jsonType     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature[] r6 = r6.serialzeFeatures()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r6 = com.alibaba.fastjson.serializer.SerializerFeature.of(r6)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r4 = r4 | r6
        L419:
            int r6 = r15.features     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r10 = r10.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r6 = r6 & r10
            if (r6 == 0) goto L42d
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r6 = r6.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r6 = r6 & r4
            if (r6 != 0) goto L42d
            r15.writeString(r2)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L466
        L42d:
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r6 = r6.mask     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            r4 = r4 & r6
            if (r4 == 0) goto L438
            r15.writeString(r2)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L466
        L438:
            r15.writeNull()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L466
        L43c:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r29 == 0) goto L445
            r15.writeStringWithSingleQuote(r2)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L466
        L445:
            r15.writeStringWithDoubleQuote(r2, r7)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L466
        L449:
            boolean r2 = r13.unwrapped     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 == 0) goto L45f
            boolean r2 = r1 instanceof java.util.Map     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 == 0) goto L45f
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r2 = r2.size()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 != 0) goto L45f
            r1 = r27
            r21 = 0
            goto L4b1
        L45f:
            r12.writeValue(r9, r1)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            goto L466
        L463:
            r12.writeValue(r9, r1)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
        L466:
            boolean r2 = r13.unwrapped     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 == 0) goto L49a
            boolean r2 = r1 instanceof java.util.Map     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 == 0) goto L49a
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            int r2 = r1.size()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 != 0) goto L478
        L476:
            r1 = 1
            goto L49b
        L478:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            boolean r2 = r9.isEnabled(r2)     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 != 0) goto L49a
            java.util.Collection r1 = r1.values()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
        L488:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 == 0) goto L496
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L4c1 java.lang.Throwable -> L50c
            if (r2 == 0) goto L488
            r1 = 1
            goto L497
        L496:
            r1 = 0
        L497:
            if (r1 != 0) goto L49a
            goto L476
        L49a:
            r1 = 0
        L49b:
            if (r1 != 0) goto L4af
            r1 = r27
            r21 = 1
            goto L4b1
        L4a2:
            r12 = r3
            throw r1     // Catch: java.lang.Exception -> L4a4 java.lang.Throwable -> L50c
        L4a4:
            r0 = move-exception
            goto L4a8
        L4a6:
            r0 = move-exception
            r12 = r3
        L4a8:
            r1 = r37
            r3 = r0
            r2 = r24
            goto L52a
        L4af:
            r1 = r27
        L4b1:
            int r2 = r28 + 1
            r10 = r37
            r12 = r39
            r13 = r40
            r11 = r24
            r6 = r33
            r7 = r34
            goto Ldb
        L4c1:
            r0 = move-exception
            goto L4c6
        L4c3:
            r0 = move-exception
            r27 = r1
        L4c6:
            r1 = r37
        L4c8:
            r3 = r0
        L4c9:
            r2 = r24
            goto L51c
        L4cc:
            r0 = move-exception
            r27 = r1
            r1 = r37
            r3 = r0
            r2 = r11
            goto L51c
        L4d4:
            r27 = r1
            r33 = r6
            r34 = r7
            r24 = r11
            r3 = 44
            r7 = 0
            r1 = r37
            if (r21 == 0) goto L4e6
            r4 = 44
            goto L4e7
        L4e6:
            r4 = 0
        L4e7:
            r8.writeAfter(r9, r1, r4)     // Catch: java.lang.Throwable -> L50c java.lang.Exception -> L512
            r2 = r34
            int r2 = r2.length     // Catch: java.lang.Throwable -> L50c java.lang.Exception -> L512
            if (r2 <= 0) goto L500
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch: java.lang.Exception -> L4fe java.lang.Throwable -> L50c
            boolean r2 = r15.isEnabled(r2)     // Catch: java.lang.Exception -> L4fe java.lang.Throwable -> L50c
            if (r2 == 0) goto L500
            r36.decrementIdent()     // Catch: java.lang.Exception -> L4fe java.lang.Throwable -> L50c
            r36.println()     // Catch: java.lang.Exception -> L4fe java.lang.Throwable -> L50c
            goto L500
        L4fe:
            r0 = move-exception
            goto L4c8
        L500:
            if (r41 != 0) goto L507
            r2 = r33
            r15.append(r2)     // Catch: java.lang.Exception -> L4fe java.lang.Throwable -> L50c
        L507:
            r2 = r24
            r9.context = r2
            return
        L50c:
            r0 = move-exception
            r1 = r0
            r5 = r24
            goto L5df
        L512:
            r0 = move-exception
            r2 = r24
            goto L51b
        L516:
            r0 = move-exception
            r27 = r1
            r1 = r10
            r2 = r11
        L51b:
            r3 = r0
        L51c:
            r12 = r27
            goto L52a
        L51f:
            r0 = move-exception
            r1 = r0
            r5 = r11
            goto L5df
        L524:
            r0 = move-exception
            r1 = r10
            r2 = r11
            r3 = r0
        L528:
            r12 = r17
        L52a:
            java.lang.String r4 = "write javaBean error, fastjson version 1.2.75"
            if (r1 == 0) goto L551
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54c
            r5.<init>()     // Catch: java.lang.Throwable -> L54c
            r5.append(r4)     // Catch: java.lang.Throwable -> L54c
            java.lang.String r4 = ", class "
            r5.append(r4)     // Catch: java.lang.Throwable -> L54c
            java.lang.Class r1 = r37.getClass()     // Catch: java.lang.Throwable -> L54c
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L54c
            r5.append(r1)     // Catch: java.lang.Throwable -> L54c
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L54c
            goto L551
        L54c:
            r0 = move-exception
            r1 = r0
            r5 = r2
            goto L5df
        L551:
            java.lang.String r1 = ", fieldName : "
            r5 = r2
            r2 = r38
            if (r2 == 0) goto L56e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56b
            r6.<init>()     // Catch: java.lang.Throwable -> L56b
            r6.append(r4)     // Catch: java.lang.Throwable -> L56b
            r6.append(r1)     // Catch: java.lang.Throwable -> L56b
            r6.append(r2)     // Catch: java.lang.Throwable -> L56b
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L56b
            goto L5ab
        L56b:
            r0 = move-exception
            goto L5de
        L56e:
            if (r12 == 0) goto L5ab
            com.alibaba.fastjson.util.FieldInfo r2 = r12.fieldInfo     // Catch: java.lang.Throwable -> L56b
            if (r2 == 0) goto L5ab
            com.alibaba.fastjson.util.FieldInfo r2 = r12.fieldInfo     // Catch: java.lang.Throwable -> L56b
            java.lang.reflect.Method r6 = r2.method     // Catch: java.lang.Throwable -> L56b
            if (r6 == 0) goto L595
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56b
            r1.<init>()     // Catch: java.lang.Throwable -> L56b
            r1.append(r4)     // Catch: java.lang.Throwable -> L56b
            java.lang.String r4 = ", method : "
            r1.append(r4)     // Catch: java.lang.Throwable -> L56b
            java.lang.reflect.Method r2 = r2.method     // Catch: java.lang.Throwable -> L56b
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L56b
            r1.append(r2)     // Catch: java.lang.Throwable -> L56b
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L56b
            goto L5ab
        L595:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56b
            r2.<init>()     // Catch: java.lang.Throwable -> L56b
            r2.append(r4)     // Catch: java.lang.Throwable -> L56b
            r2.append(r1)     // Catch: java.lang.Throwable -> L56b
            com.alibaba.fastjson.util.FieldInfo r1 = r12.fieldInfo     // Catch: java.lang.Throwable -> L56b
            java.lang.String r1 = r1.name     // Catch: java.lang.Throwable -> L56b
            r2.append(r1)     // Catch: java.lang.Throwable -> L56b
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L56b
        L5ab:
            java.lang.String r1 = r3.getMessage()     // Catch: java.lang.Throwable -> L56b
            if (r1 == 0) goto L5c9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56b
            r1.<init>()     // Catch: java.lang.Throwable -> L56b
            r1.append(r4)     // Catch: java.lang.Throwable -> L56b
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch: java.lang.Throwable -> L56b
            java.lang.String r2 = r3.getMessage()     // Catch: java.lang.Throwable -> L56b
            r1.append(r2)     // Catch: java.lang.Throwable -> L56b
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L56b
        L5c9:
            boolean r1 = r3 instanceof java.lang.reflect.InvocationTargetException     // Catch: java.lang.Throwable -> L56b
            if (r1 == 0) goto L5d1
            java.lang.Throwable r17 = r3.getCause()     // Catch: java.lang.Throwable -> L56b
        L5d1:
            if (r17 != 0) goto L5d4
            goto L5d6
        L5d4:
            r3 = r17
        L5d6:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch: java.lang.Throwable -> L56b
            r1.<init>(r4, r3)     // Catch: java.lang.Throwable -> L56b
            throw r1     // Catch: java.lang.Throwable -> L56b
        L5dc:
            r0 = move-exception
            r5 = r2
        L5de:
            r1 = r0
        L5df:
            r9.context = r5
            throw r1
        L5e2:
            r3 = 6
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r1 = 0
            r3[r1] = r36
            r1 = 1
            r3[r1] = r37
            r1 = 2
            r3[r1] = r38
            r1 = 3
            r3[r1] = r39
            r1 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r40)
            r3[r1] = r2
            r1 = 5
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r41)
            r3[r1] = r2
            r1 = 1048592(0x100010, float:1.46939E-39)
            r2 = r35
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r0.invokeCommon(r1, r2, r3)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, map};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((SerializeBeanInfo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {serializeBeanInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i4 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i4 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i4] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i4]);
            i4++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
        } else {
            this.getters = new FieldSerializer[fieldInfoArr.length];
            int i5 = 0;
            while (true) {
                if (i5 >= this.getters.length) {
                    z = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i5].name);
                if (fieldSerializer == null) {
                    z = true;
                    break;
                } else {
                    this.getters[i5] = fieldSerializer;
                    i5++;
                }
            }
            if (z) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
            }
        }
        JSONType jSONType = serializeBeanInfo.jsonType;
        if (jSONType != null) {
            for (Class<? extends SerializeFilter> cls : jSONType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
    }

    public FieldSerializer getFieldSerializer(long j2) {
        InterceptResult invokeJ;
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            if (this.hashArray == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
                long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArr.length];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                    if (i2 >= fieldSerializerArr.length) {
                        break;
                    }
                    String str = fieldSerializerArr[i2].fieldInfo.name;
                    jArr[i3] = TypeUtils.fnv1a_64(str);
                    i3++;
                    for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                        String translate = propertyNamingStrategy.translate(str);
                        if (!str.equals(translate)) {
                            jArr[i3] = TypeUtils.fnv1a_64(translate);
                            i3++;
                        }
                    }
                    i2++;
                }
                Arrays.sort(jArr, 0, i3);
                this.hashArray = new long[i3];
                System.arraycopy(jArr, 0, this.hashArray, 0, i3);
            } else {
                propertyNamingStrategyArr = null;
            }
            int binarySearch2 = Arrays.binarySearch(this.hashArray, j2);
            if (binarySearch2 < 0) {
                return null;
            }
            if (this.hashArrayMapping == null) {
                if (propertyNamingStrategyArr == null) {
                    propertyNamingStrategyArr = PropertyNamingStrategy.values();
                }
                short[] sArr = new short[this.hashArray.length];
                Arrays.fill(sArr, (short) -1);
                int i4 = 0;
                while (true) {
                    FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                    if (i4 >= fieldSerializerArr2.length) {
                        break;
                    }
                    String str2 = fieldSerializerArr2[i4].fieldInfo.name;
                    int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                    if (binarySearch3 >= 0) {
                        sArr[binarySearch3] = (short) i4;
                    }
                    for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                        String translate2 = propertyNamingStrategy2.translate(str2);
                        if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                            sArr[binarySearch] = (short) i4;
                        }
                    }
                    i4++;
                }
                this.hashArrayMapping = sArr;
            }
            short s = this.hashArrayMapping[binarySearch2];
            if (s != -1) {
                return this.sortedGetters[s];
            }
            return null;
        }
        return (FieldSerializer) invokeJ.objValue;
    }

    public Object getFieldValue(Object obj, String str, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{obj, str, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            FieldSerializer fieldSerializer = getFieldSerializer(j2);
            if (fieldSerializer == null) {
                if (z) {
                    throw new JSONException("field not found. " + str);
                }
                return null;
            }
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            } catch (InvocationTargetException e3) {
                throw new JSONException("getFieldValue error." + str, e3);
            }
        }
        return invokeCommon.objValue;
    }
}
