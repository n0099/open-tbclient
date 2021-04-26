package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
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
/* loaded from: classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    public SerializeBeanInfo beanInfo;
    public final FieldSerializer[] getters;
    public volatile transient long[] hashArray;
    public volatile transient short[] hashArrayMapping;
    public final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
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

    public BeanContext getBeanContext(int i2) {
        return this.sortedGetters[i2].fieldContext;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public FieldSerializer getFieldSerializer(String str) {
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

    public Type getFieldType(int i2) {
        return this.sortedGetters[i2].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
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

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
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

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i2 = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i2++;
            }
        }
        return i2;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        write(jSONSerializer, obj, obj2, type, i2, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c2) {
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

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        write(jSONSerializer, obj, obj2, type, i2);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        write(jSONSerializer, obj, obj2, type, i2);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c2) {
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

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
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

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        write(jSONSerializer, obj, obj2, type, i2);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        write(jSONSerializer, obj, obj2, type, i2, false);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i2) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i3 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext != null && (serialContext.features & i3) == 0 && (i2 & i3) == 0 && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return true;
        }
        return false;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i2) {
        int i3 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i3) == 0 && !jSONSerializer.out.beanToArray && (i2 & i3) == 0) ? false : true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:428:0x05d6
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r36, java.lang.Object r37, java.lang.Object r38, java.lang.reflect.Type r39, int r40, boolean r41) throws java.io.IOException {
        /*
            r35 = this;
            r8 = r35
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            com.alibaba.fastjson.serializer.SerializeWriter r15 = r9.out
            if (r10 != 0) goto L16
            r15.writeNull()
            return
        L16:
            boolean r1 = r8.writeReference(r9, r10, r13)
            if (r1 == 0) goto L1d
            return
        L1d:
            boolean r1 = r15.sortField
            if (r1 == 0) goto L24
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r8.sortedGetters
            goto L26
        L24:
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r8.getters
        L26:
            r7 = r1
            com.alibaba.fastjson.serializer.SerialContext r6 = r9.context
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo
            java.lang.Class<?> r1 = r1.beanType
            boolean r1 = r1.isEnum()
            if (r1 != 0) goto L45
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo
            int r5 = r1.features
            r1 = r36
            r2 = r6
            r3 = r37
            r4 = r38
            r11 = r6
            r6 = r40
            r1.setContext(r2, r3, r4, r5, r6)
            goto L46
        L45:
            r11 = r6
        L46:
            boolean r16 = r8.isWriteAsArray(r9, r13)
            if (r16 == 0) goto L4f
            r1 = 91
            goto L51
        L4f:
            r1 = 123(0x7b, float:1.72E-43)
        L51:
            if (r16 == 0) goto L58
            r2 = 93
            r6 = 93
            goto L5c
        L58:
            r2 = 125(0x7d, float:1.75E-43)
            r6 = 125(0x7d, float:1.75E-43)
        L5c:
            r17 = 0
            if (r41 != 0) goto L6a
            r15.append(r1)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            goto L6a
        L64:
            r0 = move-exception
            r3 = r0
            r1 = r10
            r2 = r11
            goto L523
        L6a:
            int r1 = r7.length     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            if (r1 <= 0) goto L7b
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            boolean r1 = r15.isEnabled(r1)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            if (r1 == 0) goto L7b
            r36.incrementIndent()     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            r36.println()     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
        L7b:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            int r1 = r1.features     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            int r2 = r2.mask     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            r1 = r1 & r2
            if (r1 != 0) goto L93
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            int r1 = r1.mask     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            r1 = r1 & r13
            if (r1 != 0) goto L93
            boolean r1 = r9.isWriteClassName(r12, r10)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            if (r1 == 0) goto Lae
        L93:
            java.lang.Class r1 = r37.getClass()     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            if (r1 == r12) goto La2
            boolean r2 = r12 instanceof java.lang.reflect.WildcardType     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            if (r2 == 0) goto La2
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r39)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            goto La3
        La2:
            r2 = r12
        La3:
            if (r1 == r2) goto Lae
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r8.beanInfo     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            java.lang.String r1 = r1.typeKey     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            r8.writeClassName(r9, r1, r10)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L51a
            r1 = 1
            goto Laf
        Lae:
            r1 = 0
        Laf:
            r3 = 44
            if (r1 == 0) goto Lb6
            r1 = 44
            goto Lb7
        Lb6:
            r1 = 0
        Lb7:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            boolean r18 = r15.isEnabled(r2)     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            char r1 = r8.writeBefore(r9, r10, r1)     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            if (r1 != r3) goto Lc5
            r1 = 1
            goto Lc6
        Lc5:
            r1 = 0
        Lc6:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            boolean r19 = r15.isEnabled(r2)     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            boolean r20 = r15.isEnabled(r2)     // Catch: java.lang.Throwable -> L51a java.lang.Exception -> L51f
            r21 = r1
            r1 = r17
            r2 = 0
        Ld7:
            int r3 = r7.length     // Catch: java.lang.Exception -> L511 java.lang.Throwable -> L51a
            if (r2 >= r3) goto L4cf
            r3 = r7[r2]     // Catch: java.lang.Exception -> L4c7 java.lang.Throwable -> L51a
            com.alibaba.fastjson.util.FieldInfo r4 = r3.fieldInfo     // Catch: java.lang.Exception -> L4c7 java.lang.Throwable -> L51a
            java.lang.reflect.Field r4 = r4.field     // Catch: java.lang.Exception -> L4c7 java.lang.Throwable -> L51a
            com.alibaba.fastjson.util.FieldInfo r13 = r3.fieldInfo     // Catch: java.lang.Exception -> L4c7 java.lang.Throwable -> L51a
            r24 = r11
            java.lang.String r11 = r13.name     // Catch: java.lang.Exception -> L4be java.lang.Throwable -> L507
            r25 = r7
            java.lang.Class<?> r7 = r13.fieldClass     // Catch: java.lang.Exception -> L4be java.lang.Throwable -> L507
            int r5 = r15.features     // Catch: java.lang.Exception -> L4be java.lang.Throwable -> L507
            r27 = r1
            int r1 = r13.serialzeFeatures     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r28 = r2
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r29 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r5, r1, r2)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r1 = r15.quoteFieldNames     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r1 == 0) goto L101
            if (r29 != 0) goto L101
            r30 = 1
            goto L103
        L101:
            r30 = 0
        L103:
            if (r19 == 0) goto L111
            if (r13 == 0) goto L111
            boolean r1 = r13.fieldTransient     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            if (r1 == 0) goto L111
            goto L115
        L10c:
            r0 = move-exception
            r3 = r0
            r1 = r10
            goto L4c4
        L111:
            if (r20 == 0) goto L11f
            if (r4 != 0) goto L11f
        L115:
            r33 = r6
            r34 = r25
        L119:
            r3 = 44
            r5 = 1
            r7 = 0
            goto L4aa
        L11f:
            boolean r1 = r8.applyName(r9, r10, r11)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r1 == 0) goto L130
            java.lang.String r1 = r13.label     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            boolean r1 = r8.applyLabel(r9, r1)     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            if (r1 != 0) goto L12e
            goto L130
        L12e:
            r1 = 0
            goto L133
        L130:
            if (r16 == 0) goto L115
            r1 = 1
        L133:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r2 = r8.beanInfo     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            java.lang.String r2 = r2.typeKey     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 == 0) goto L14a
            com.alibaba.fastjson.serializer.SerializeBeanInfo r2 = r8.beanInfo     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            java.lang.String r2 = r2.typeKey     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            boolean r2 = r11.equals(r2)     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            if (r2 == 0) goto L14a
            boolean r2 = r9.isWriteClassName(r12, r10)     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            if (r2 == 0) goto L14a
            goto L115
        L14a:
            if (r1 == 0) goto L14f
        L14c:
            r1 = r17
            goto L161
        L14f:
            java.lang.Object r1 = r3.getPropertyValueDirect(r10)     // Catch: java.lang.Exception -> L10c java.lang.reflect.InvocationTargetException -> L154 java.lang.Throwable -> L507
            goto L161
        L154:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter     // Catch: java.lang.Exception -> L4a1 java.lang.Throwable -> L507
            boolean r2 = r15.isEnabled(r2)     // Catch: java.lang.Exception -> L4a1 java.lang.Throwable -> L507
            if (r2 == 0) goto L49d
            r27 = r3
            goto L14c
        L161:
            boolean r2 = r8.apply(r9, r10, r11, r1)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 != 0) goto L16c
            r33 = r6
            r34 = r25
            goto L119
        L16c:
            if (r7 != r14) goto L180
            java.lang.String r2 = "trim"
            java.lang.String r4 = r13.format     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            if (r2 == 0) goto L180
            if (r1 == 0) goto L180
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L10c java.lang.Throwable -> L507
        L180:
            r5 = r1
            java.lang.String r4 = r8.processKey(r9, r10, r11, r5)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.BeanContext r2 = r3.fieldContext     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
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
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            java.lang.String r2 = ""
            if (r1 != 0) goto L2be
            int r3 = r13.serialzeFeatures     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.annotation.JSONField r4 = r13.getAnnotation()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializeBeanInfo r5 = r8.beanInfo     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.annotation.JSONType r5 = r5.jsonType     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r5 == 0) goto L1c5
            com.alibaba.fastjson.serializer.SerializeBeanInfo r5 = r8.beanInfo     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.annotation.JSONType r5 = r5.jsonType     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature[] r5 = r5.serialzeFeatures()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r5 = com.alibaba.fastjson.serializer.SerializerFeature.of(r5)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 | r5
        L1c5:
            if (r4 == 0) goto L1d7
            java.lang.String r5 = r4.defaultValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r5 = r2.equals(r5)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r5 != 0) goto L1d7
            java.lang.String r1 = r4.defaultValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L2be
        L1d7:
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            if (r10 != r4) goto L209
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 | r4
            if (r16 != 0) goto L1f1
            r6 = r3 & r5
            if (r6 != 0) goto L1f1
            int r6 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 & r6
            if (r5 != 0) goto L1f1
            goto L379
        L1f1:
            r5 = r3 & r4
            if (r5 == 0) goto L1f9
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L2be
        L1f9:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r4 = r4 & r5
            if (r4 == 0) goto L2be
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 & r4
            if (r3 != 0) goto L2be
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L2be
        L209:
            if (r10 != r14) goto L235
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 | r4
            if (r16 != 0) goto L221
            r6 = r3 & r5
            if (r6 != 0) goto L221
            int r6 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 & r6
            if (r5 != 0) goto L221
            goto L379
        L221:
            r5 = r3 & r4
            if (r5 == 0) goto L228
        L225:
            r1 = r2
            goto L2be
        L228:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r4 = r4 & r5
            if (r4 == 0) goto L2be
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 & r4
            if (r3 != 0) goto L2be
            goto L225
        L235:
            java.lang.Class<java.lang.Number> r4 = java.lang.Number.class
            boolean r4 = r4.isAssignableFrom(r10)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L26d
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 | r4
            if (r16 != 0) goto L253
            r6 = r3 & r5
            if (r6 != 0) goto L253
            int r6 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 & r6
            if (r5 != 0) goto L253
            goto L379
        L253:
            r5 = r3 & r4
            if (r5 == 0) goto L25c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r22)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L2be
        L25c:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r4 = r4 & r5
            if (r4 == 0) goto L2be
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 & r4
            if (r3 != 0) goto L2be
            java.lang.Integer r1 = java.lang.Integer.valueOf(r22)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L2be
        L26d:
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            boolean r4 = r4.isAssignableFrom(r10)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L2a5
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r5 = r5.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 | r4
            if (r16 != 0) goto L28b
            r6 = r3 & r5
            if (r6 != 0) goto L28b
            int r6 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = r5 & r6
            if (r5 != 0) goto L28b
            goto L379
        L28b:
            r5 = r3 & r4
            if (r5 == 0) goto L294
            java.util.List r1 = java.util.Collections.emptyList()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L2be
        L294:
            int r5 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r4 = r4 & r5
            if (r4 == 0) goto L2be
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 & r4
            if (r3 != 0) goto L2be
            java.util.List r1 = java.util.Collections.emptyList()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L2be
        L2a5:
            if (r16 != 0) goto L2be
            boolean r4 = r12.writeNull     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 != 0) goto L2be
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r4 = r15.isEnabled(r4)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 != 0) goto L2be
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 & r4
            if (r3 != 0) goto L2be
            goto L379
        L2be:
            if (r1 == 0) goto L366
            boolean r3 = r15.notWriteDefaultValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != 0) goto L2d8
            int r3 = r13.serialzeFeatures     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 & r4
            if (r3 != 0) goto L2d8
            com.alibaba.fastjson.serializer.SerializeBeanInfo r3 = r8.beanInfo     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r3 = r3.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r3 = r3 & r4
            if (r3 == 0) goto L366
        L2d8:
            java.lang.Class<?> r3 = r13.fieldClass     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            java.lang.Class r4 = java.lang.Byte.TYPE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != r4) goto L2ed
            boolean r4 = r1 instanceof java.lang.Byte     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L2ed
            r4 = r1
            java.lang.Byte r4 = (java.lang.Byte) r4     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            byte r4 = r4.byteValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 != 0) goto L2ed
            goto L379
        L2ed:
            java.lang.Class r4 = java.lang.Short.TYPE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != r4) goto L300
            boolean r4 = r1 instanceof java.lang.Short     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L300
            r4 = r1
            java.lang.Short r4 = (java.lang.Short) r4     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            short r4 = r4.shortValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 != 0) goto L300
            goto L379
        L300:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != r4) goto L313
            boolean r4 = r1 instanceof java.lang.Integer     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L313
            r4 = r1
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 != 0) goto L313
            goto L379
        L313:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != r4) goto L329
            boolean r4 = r1 instanceof java.lang.Long     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L329
            r4 = r1
            java.lang.Long r4 = (java.lang.Long) r4     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            long r4 = r4.longValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r6 = 0
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 != 0) goto L329
            goto L379
        L329:
            java.lang.Class r4 = java.lang.Float.TYPE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != r4) goto L33e
            boolean r4 = r1 instanceof java.lang.Float     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L33e
            r4 = r1
            java.lang.Float r4 = (java.lang.Float) r4     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            float r4 = r4.floatValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L33e
            goto L379
        L33e:
            java.lang.Class r4 = java.lang.Double.TYPE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != r4) goto L354
            boolean r4 = r1 instanceof java.lang.Double     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L354
            r4 = r1
            java.lang.Double r4 = (java.lang.Double) r4     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            double r4 = r4.doubleValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r6 = 0
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 != 0) goto L354
            goto L379
        L354:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != r4) goto L366
            boolean r3 = r1 instanceof java.lang.Boolean     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 == 0) goto L366
            r3 = r1
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != 0) goto L366
            goto L379
        L366:
            if (r21 == 0) goto L38c
            boolean r3 = r13.unwrapped     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 == 0) goto L37b
            boolean r3 = r1 instanceof java.util.Map     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 == 0) goto L37b
            r3 = r1
            java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r3 = r3.size()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r3 != 0) goto L37b
        L379:
            goto L119
        L37b:
            r3 = 44
            r15.write(r3)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r4 = r15.isEnabled(r4)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r4 == 0) goto L38e
            r36.println()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L38e
        L38c:
            r3 = 44
        L38e:
            r4 = r32
            if (r4 == r11) goto L3a0
            if (r16 != 0) goto L399
            r5 = 1
            r15.writeFieldName(r4, r5)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L39a
        L399:
            r5 = 1
        L39a:
            r9.write(r1)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
        L39d:
            r7 = 0
            goto L461
        L3a0:
            r4 = r23
            r5 = 1
            if (r4 == r1) goto L3ae
            if (r16 != 0) goto L3aa
            r12.writePrefix(r9)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
        L3aa:
            r9.write(r1)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L39d
        L3ae:
            if (r16 != 0) goto L3ea
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            boolean r4 = r4.isAssignableFrom(r10)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r6 = r10.isPrimitive()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r6 != 0) goto L3c8
            java.lang.String r6 = r10.getName()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            java.lang.String r7 = "java."
            boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r6 == 0) goto L3cc
        L3c8:
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            if (r10 != r6) goto L3ce
        L3cc:
            r6 = 1
            goto L3cf
        L3ce:
            r6 = 0
        L3cf:
            if (r18 != 0) goto L3d9
            boolean r7 = r13.unwrapped     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r7 == 0) goto L3d9
            if (r4 != 0) goto L3ea
            if (r6 != 0) goto L3ea
        L3d9:
            if (r30 == 0) goto L3e5
            char[] r4 = r13.name_chars     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            char[] r6 = r13.name_chars     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r6 = r6.length     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r7 = 0
            r15.write(r4, r7, r6)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L3eb
        L3e5:
            r7 = 0
            r12.writePrefix(r9)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L3eb
        L3ea:
            r7 = 0
        L3eb:
            if (r16 != 0) goto L45e
            com.alibaba.fastjson.annotation.JSONField r4 = r13.getAnnotation()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r10 != r14) goto L444
            if (r4 == 0) goto L3fd
            java.lang.Class r4 = r4.serializeUsing()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            java.lang.Class<java.lang.Void> r6 = java.lang.Void.class
            if (r4 != r6) goto L444
        L3fd:
            if (r1 != 0) goto L437
            int r4 = r12.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r8.beanInfo     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.annotation.JSONType r6 = r6.jsonType     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r6 == 0) goto L414
            com.alibaba.fastjson.serializer.SerializeBeanInfo r6 = r8.beanInfo     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.annotation.JSONType r6 = r6.jsonType     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature[] r6 = r6.serialzeFeatures()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r6 = com.alibaba.fastjson.serializer.SerializerFeature.of(r6)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r4 = r4 | r6
        L414:
            int r6 = r15.features     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r10 = r10.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r6 = r6 & r10
            if (r6 == 0) goto L428
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r6 = r6.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r6 = r6 & r4
            if (r6 != 0) goto L428
            r15.writeString(r2)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L461
        L428:
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r6 = r6.mask     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            r4 = r4 & r6
            if (r4 == 0) goto L433
            r15.writeString(r2)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L461
        L433:
            r15.writeNull()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L461
        L437:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r29 == 0) goto L440
            r15.writeStringWithSingleQuote(r2)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L461
        L440:
            r15.writeStringWithDoubleQuote(r2, r7)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L461
        L444:
            boolean r2 = r13.unwrapped     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 == 0) goto L45a
            boolean r2 = r1 instanceof java.util.Map     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 == 0) goto L45a
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r2 = r2.size()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 != 0) goto L45a
            r1 = r27
            r21 = 0
            goto L4ac
        L45a:
            r12.writeValue(r9, r1)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            goto L461
        L45e:
            r12.writeValue(r9, r1)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
        L461:
            boolean r2 = r13.unwrapped     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 == 0) goto L495
            boolean r2 = r1 instanceof java.util.Map     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 == 0) goto L495
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            int r2 = r1.size()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 != 0) goto L473
        L471:
            r1 = 1
            goto L496
        L473:
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            boolean r2 = r9.isEnabled(r2)     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 != 0) goto L495
            java.util.Collection r1 = r1.values()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
        L483:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 == 0) goto L491
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L4bc java.lang.Throwable -> L507
            if (r2 == 0) goto L483
            r1 = 1
            goto L492
        L491:
            r1 = 0
        L492:
            if (r1 != 0) goto L495
            goto L471
        L495:
            r1 = 0
        L496:
            if (r1 != 0) goto L4aa
            r1 = r27
            r21 = 1
            goto L4ac
        L49d:
            r12 = r3
            throw r1     // Catch: java.lang.Exception -> L49f java.lang.Throwable -> L507
        L49f:
            r0 = move-exception
            goto L4a3
        L4a1:
            r0 = move-exception
            r12 = r3
        L4a3:
            r1 = r37
            r3 = r0
            r2 = r24
            goto L525
        L4aa:
            r1 = r27
        L4ac:
            int r2 = r28 + 1
            r10 = r37
            r12 = r39
            r13 = r40
            r11 = r24
            r6 = r33
            r7 = r34
            goto Ld7
        L4bc:
            r0 = move-exception
            goto L4c1
        L4be:
            r0 = move-exception
            r27 = r1
        L4c1:
            r1 = r37
        L4c3:
            r3 = r0
        L4c4:
            r2 = r24
            goto L517
        L4c7:
            r0 = move-exception
            r27 = r1
            r1 = r37
            r3 = r0
            r2 = r11
            goto L517
        L4cf:
            r27 = r1
            r33 = r6
            r34 = r7
            r24 = r11
            r3 = 44
            r7 = 0
            r1 = r37
            if (r21 == 0) goto L4e1
            r4 = 44
            goto L4e2
        L4e1:
            r4 = 0
        L4e2:
            r8.writeAfter(r9, r1, r4)     // Catch: java.lang.Throwable -> L507 java.lang.Exception -> L50d
            r2 = r34
            int r2 = r2.length     // Catch: java.lang.Throwable -> L507 java.lang.Exception -> L50d
            if (r2 <= 0) goto L4fb
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch: java.lang.Exception -> L4f9 java.lang.Throwable -> L507
            boolean r2 = r15.isEnabled(r2)     // Catch: java.lang.Exception -> L4f9 java.lang.Throwable -> L507
            if (r2 == 0) goto L4fb
            r36.decrementIdent()     // Catch: java.lang.Exception -> L4f9 java.lang.Throwable -> L507
            r36.println()     // Catch: java.lang.Exception -> L4f9 java.lang.Throwable -> L507
            goto L4fb
        L4f9:
            r0 = move-exception
            goto L4c3
        L4fb:
            if (r41 != 0) goto L502
            r2 = r33
            r15.append(r2)     // Catch: java.lang.Exception -> L4f9 java.lang.Throwable -> L507
        L502:
            r2 = r24
            r9.context = r2
            return
        L507:
            r0 = move-exception
            r1 = r0
            r5 = r24
            goto L5d9
        L50d:
            r0 = move-exception
            r2 = r24
            goto L516
        L511:
            r0 = move-exception
            r27 = r1
            r1 = r10
            r2 = r11
        L516:
            r3 = r0
        L517:
            r12 = r27
            goto L525
        L51a:
            r0 = move-exception
            r1 = r0
            r5 = r11
            goto L5d9
        L51f:
            r0 = move-exception
            r1 = r10
            r2 = r11
            r3 = r0
        L523:
            r12 = r17
        L525:
            java.lang.String r4 = "write javaBean error, fastjson version 1.2.75"
            if (r1 == 0) goto L54b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L546
            r5.<init>()     // Catch: java.lang.Throwable -> L546
            r5.append(r4)     // Catch: java.lang.Throwable -> L546
            java.lang.String r4 = ", class "
            r5.append(r4)     // Catch: java.lang.Throwable -> L546
            java.lang.Class r1 = r37.getClass()     // Catch: java.lang.Throwable -> L546
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L546
            r5.append(r1)     // Catch: java.lang.Throwable -> L546
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L546
            goto L54b
        L546:
            r0 = move-exception
            r1 = r0
            r5 = r2
            goto L5d9
        L54b:
            java.lang.String r1 = ", fieldName : "
            r5 = r2
            r2 = r38
            if (r2 == 0) goto L568
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L565
            r6.<init>()     // Catch: java.lang.Throwable -> L565
            r6.append(r4)     // Catch: java.lang.Throwable -> L565
            r6.append(r1)     // Catch: java.lang.Throwable -> L565
            r6.append(r2)     // Catch: java.lang.Throwable -> L565
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L565
            goto L5a5
        L565:
            r0 = move-exception
            goto L5d8
        L568:
            if (r12 == 0) goto L5a5
            com.alibaba.fastjson.util.FieldInfo r2 = r12.fieldInfo     // Catch: java.lang.Throwable -> L565
            if (r2 == 0) goto L5a5
            com.alibaba.fastjson.util.FieldInfo r2 = r12.fieldInfo     // Catch: java.lang.Throwable -> L565
            java.lang.reflect.Method r6 = r2.method     // Catch: java.lang.Throwable -> L565
            if (r6 == 0) goto L58f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L565
            r1.<init>()     // Catch: java.lang.Throwable -> L565
            r1.append(r4)     // Catch: java.lang.Throwable -> L565
            java.lang.String r4 = ", method : "
            r1.append(r4)     // Catch: java.lang.Throwable -> L565
            java.lang.reflect.Method r2 = r2.method     // Catch: java.lang.Throwable -> L565
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L565
            r1.append(r2)     // Catch: java.lang.Throwable -> L565
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L565
            goto L5a5
        L58f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L565
            r2.<init>()     // Catch: java.lang.Throwable -> L565
            r2.append(r4)     // Catch: java.lang.Throwable -> L565
            r2.append(r1)     // Catch: java.lang.Throwable -> L565
            com.alibaba.fastjson.util.FieldInfo r1 = r12.fieldInfo     // Catch: java.lang.Throwable -> L565
            java.lang.String r1 = r1.name     // Catch: java.lang.Throwable -> L565
            r2.append(r1)     // Catch: java.lang.Throwable -> L565
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L565
        L5a5:
            java.lang.String r1 = r3.getMessage()     // Catch: java.lang.Throwable -> L565
            if (r1 == 0) goto L5c3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L565
            r1.<init>()     // Catch: java.lang.Throwable -> L565
            r1.append(r4)     // Catch: java.lang.Throwable -> L565
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch: java.lang.Throwable -> L565
            java.lang.String r2 = r3.getMessage()     // Catch: java.lang.Throwable -> L565
            r1.append(r2)     // Catch: java.lang.Throwable -> L565
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L565
        L5c3:
            boolean r1 = r3 instanceof java.lang.reflect.InvocationTargetException     // Catch: java.lang.Throwable -> L565
            if (r1 == 0) goto L5cb
            java.lang.Throwable r17 = r3.getCause()     // Catch: java.lang.Throwable -> L565
        L5cb:
            if (r17 != 0) goto L5ce
            goto L5d0
        L5ce:
            r3 = r17
        L5d0:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch: java.lang.Throwable -> L565
            r1.<init>(r4, r3)     // Catch: java.lang.Throwable -> L565
            throw r1     // Catch: java.lang.Throwable -> L565
        L5d6:
            r0 = move-exception
            r5 = r2
        L5d8:
            r1 = r0
        L5d9:
            r9.context = r5
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        boolean z;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i2 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i2 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i2] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i2]);
            i2++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
        } else {
            this.getters = new FieldSerializer[fieldInfoArr.length];
            int i3 = 0;
            while (true) {
                if (i3 >= this.getters.length) {
                    z = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i3].name);
                if (fieldSerializer == null) {
                    z = true;
                    break;
                } else {
                    this.getters[i3] = fieldSerializer;
                    i3++;
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

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
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
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
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

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
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
}
