package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();
    public static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.alibaba.fastjson.serializer.SerializeWriter */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fd A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:168:0x024f, B:170:0x0255, B:172:0x025a, B:173:0x025d, B:175:0x0265, B:176:0x0268, B:189:0x0297, B:191:0x02a4, B:193:0x02ac, B:195:0x02b3, B:197:0x02bd, B:199:0x02c1, B:201:0x02c5, B:203:0x02d0, B:205:0x02d6, B:206:0x02e4, B:178:0x026e, B:179:0x0271, B:181:0x0279, B:186:0x028d, B:187:0x0290, B:183:0x0281, B:185:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023d A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:168:0x024f, B:170:0x0255, B:172:0x025a, B:173:0x025d, B:175:0x0265, B:176:0x0268, B:189:0x0297, B:191:0x02a4, B:193:0x02ac, B:195:0x02b3, B:197:0x02bd, B:199:0x02c1, B:201:0x02c5, B:203:0x02d0, B:205:0x02d6, B:206:0x02e4, B:178:0x026e, B:179:0x0271, B:181:0x0279, B:186:0x028d, B:187:0x0290, B:183:0x0281, B:185:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0255 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:168:0x024f, B:170:0x0255, B:172:0x025a, B:173:0x025d, B:175:0x0265, B:176:0x0268, B:189:0x0297, B:191:0x02a4, B:193:0x02ac, B:195:0x02b3, B:197:0x02bd, B:199:0x02c1, B:201:0x02c5, B:203:0x02d0, B:205:0x02d6, B:206:0x02e4, B:178:0x026e, B:179:0x0271, B:181:0x0279, B:186:0x028d, B:187:0x0290, B:183:0x0281, B:185:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0297 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:168:0x024f, B:170:0x0255, B:172:0x025a, B:173:0x025d, B:175:0x0265, B:176:0x0268, B:189:0x0297, B:191:0x02a4, B:193:0x02ac, B:195:0x02b3, B:197:0x02bd, B:199:0x02c1, B:201:0x02c5, B:203:0x02d0, B:205:0x02d6, B:206:0x02e4, B:178:0x026e, B:179:0x0271, B:181:0x0279, B:186:0x028d, B:187:0x0290, B:183:0x0281, B:185:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02a4 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:168:0x024f, B:170:0x0255, B:172:0x025a, B:173:0x025d, B:175:0x0265, B:176:0x0268, B:189:0x0297, B:191:0x02a4, B:193:0x02ac, B:195:0x02b3, B:197:0x02bd, B:199:0x02c1, B:201:0x02c5, B:203:0x02d0, B:205:0x02d6, B:206:0x02e4, B:178:0x026e, B:179:0x0271, B:181:0x0279, B:186:0x028d, B:187:0x0290, B:183:0x0281, B:185:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x024f A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:168:0x024f, B:170:0x0255, B:172:0x025a, B:173:0x025d, B:175:0x0265, B:176:0x0268, B:189:0x0297, B:191:0x02a4, B:193:0x02ac, B:195:0x02b3, B:197:0x02bd, B:199:0x02c1, B:201:0x02c5, B:203:0x02d0, B:205:0x02d6, B:206:0x02e4, B:178:0x026e, B:179:0x0271, B:181:0x0279, B:186:0x028d, B:187:0x0290, B:183:0x0281, B:185:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws IOException {
        TreeMap treeMap;
        boolean z2;
        String str;
        Class<?> cls;
        boolean z3;
        Object processValue;
        Object obj3;
        ?? r0;
        Class<?> cls2;
        Type type2;
        boolean z4;
        Object obj4 = obj;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj4 == null) {
            serializeWriter.writeNull();
            return;
        }
        Map<String, Object> map = (Map) obj4;
        int i2 = SerializerFeature.MapSortField.mask;
        if ((serializeWriter.features & i2) != 0 || (i2 & i) != 0) {
            if (map instanceof JSONObject) {
                map = ((JSONObject) map).getInnerMap();
            }
            if (!(map instanceof SortedMap) && !(map instanceof LinkedHashMap)) {
                try {
                    treeMap = new TreeMap(map);
                } catch (Exception unused) {
                }
                if (!jSONSerializer.containsReference(obj)) {
                    jSONSerializer.writeReference(obj);
                    return;
                }
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj4, obj2, 0);
                if (!z) {
                    try {
                        serializeWriter.write((int) Constants.METHOD_IM_FRIEND_GROUP_QUERY);
                    } catch (Throwable th) {
                        jSONSerializer.context = serialContext;
                        throw th;
                    }
                }
                jSONSerializer.incrementIndent();
                if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                    String str2 = jSONSerializer.config.typeKey;
                    Class<?> cls3 = treeMap.getClass();
                    if (!((cls3 == JSONObject.class || cls3 == HashMap.class || cls3 == LinkedHashMap.class) && treeMap.containsKey(str2))) {
                        serializeWriter.writeFieldName(str2);
                        serializeWriter.writeString(obj.getClass().getName());
                        z2 = false;
                        boolean z5 = z2;
                        Class<?> cls4 = null;
                        ObjectSerializer objectSerializer = null;
                        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                            Object value = entry.getValue();
                            String key = entry.getKey();
                            List<PropertyPreFilter> list = jSONSerializer.propertyPreFilters;
                            if (list != null && list.size() > 0) {
                                if (key != null && !(key instanceof String)) {
                                    if ((key.getClass().isPrimitive() || (key instanceof Number)) && !applyName(jSONSerializer, obj4, JSON.toJSONString(key))) {
                                        cls = cls4;
                                        obj4 = obj;
                                        cls4 = cls;
                                    }
                                }
                                if (!applyName(jSONSerializer, obj4, key)) {
                                    cls = cls4;
                                    obj4 = obj;
                                    cls4 = cls;
                                }
                            }
                            List<PropertyPreFilter> list2 = this.propertyPreFilters;
                            if (list2 != null && list2.size() > 0) {
                                if (key != null && !(key instanceof String)) {
                                    if ((key.getClass().isPrimitive() || (key instanceof Number)) && !applyName(jSONSerializer, obj4, JSON.toJSONString(key))) {
                                        cls = cls4;
                                        obj4 = obj;
                                        cls4 = cls;
                                    }
                                }
                                if (!applyName(jSONSerializer, obj4, key)) {
                                    cls = cls4;
                                    obj4 = obj;
                                    cls4 = cls;
                                }
                            }
                            List<PropertyFilter> list3 = jSONSerializer.propertyFilters;
                            if (list3 != null && list3.size() > 0) {
                                if (key != null && !(key instanceof String)) {
                                    if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj4, JSON.toJSONString(key), value)) {
                                        cls = cls4;
                                        obj4 = obj;
                                        cls4 = cls;
                                    }
                                }
                                if (!apply(jSONSerializer, obj4, key, value)) {
                                    cls = cls4;
                                    obj4 = obj;
                                    cls4 = cls;
                                }
                            }
                            List<PropertyFilter> list4 = this.propertyFilters;
                            if (list4 != null && list4.size() > 0) {
                                if (key != null && !(key instanceof String)) {
                                    if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj4, JSON.toJSONString(key), value)) {
                                        cls = cls4;
                                        obj4 = obj;
                                        cls4 = cls;
                                    }
                                }
                                if (!apply(jSONSerializer, obj4, key, value)) {
                                    cls = cls4;
                                    obj4 = obj;
                                    cls4 = cls;
                                }
                            }
                            List<NameFilter> list5 = jSONSerializer.nameFilters;
                            if (list5 != null && list5.size() > 0) {
                                if (key != null && !(key instanceof String)) {
                                    if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                        key = processKey(jSONSerializer, obj4, JSON.toJSONString(key), value);
                                    }
                                }
                                key = processKey(jSONSerializer, obj4, key, value);
                            }
                            List<NameFilter> list6 = this.nameFilters;
                            if (list6 != null && list6.size() > 0) {
                                if (key != null && !(key instanceof String)) {
                                    if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                        key = processKey(jSONSerializer, obj4, JSON.toJSONString(key), value);
                                    }
                                }
                                key = processKey(jSONSerializer, obj4, key, value);
                            }
                            String str3 = key;
                            if (str3 != null && !(str3 instanceof String)) {
                                if (!(str3 instanceof Map) && !(str3 instanceof Collection)) {
                                    z4 = false;
                                    if (z4) {
                                        str = str3;
                                        cls = cls4;
                                        z3 = true;
                                        processValue = processValue(jSONSerializer, null, obj, JSON.toJSONString(str3), value, i);
                                        obj3 = processValue;
                                        r0 = z3;
                                        if (obj3 != null || SerializerFeature.isEnabled(serializeWriter.features, i, SerializerFeature.WriteMapNullValue)) {
                                            if (str instanceof String) {
                                                String str4 = str;
                                                if (!z5) {
                                                    serializeWriter.write(44);
                                                }
                                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                                    jSONSerializer.println();
                                                }
                                                serializeWriter.writeFieldName(str4, r0);
                                            } else {
                                                if (!z5) {
                                                    serializeWriter.write(44);
                                                }
                                                if ((serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING) || SerializerFeature.isEnabled(i, SerializerFeature.WriteNonStringKeyAsString)) && !(str instanceof Enum)) {
                                                    jSONSerializer.write(JSON.toJSONString(str));
                                                } else {
                                                    jSONSerializer.write((Object) str);
                                                }
                                                serializeWriter.write(58);
                                            }
                                            if (obj3 == null) {
                                                serializeWriter.writeNull();
                                                obj4 = obj;
                                                cls4 = cls;
                                            } else {
                                                Class<?> cls5 = obj3.getClass();
                                                Class<?> cls6 = cls;
                                                if (cls5 != cls6) {
                                                    objectSerializer = jSONSerializer.getObjectWriter(cls5);
                                                    cls2 = cls5;
                                                } else {
                                                    cls2 = cls6;
                                                }
                                                ObjectSerializer objectSerializer2 = objectSerializer;
                                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName) && (objectSerializer2 instanceof JavaBeanSerializer)) {
                                                    if (type instanceof ParameterizedType) {
                                                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                                        if (actualTypeArguments.length == 2) {
                                                            type2 = actualTypeArguments[r0];
                                                            objectSerializer = objectSerializer2;
                                                            ((JavaBeanSerializer) objectSerializer2).writeNoneASM(jSONSerializer, obj3, str, type2, i);
                                                        }
                                                    }
                                                    type2 = null;
                                                    objectSerializer = objectSerializer2;
                                                    ((JavaBeanSerializer) objectSerializer2).writeNoneASM(jSONSerializer, obj3, str, type2, i);
                                                } else {
                                                    objectSerializer = objectSerializer2;
                                                    objectSerializer.write(jSONSerializer, obj3, str, null, i);
                                                }
                                                obj4 = obj;
                                                cls4 = cls2;
                                            }
                                            z5 = false;
                                        } else {
                                            obj4 = obj;
                                            cls4 = cls;
                                        }
                                    } else {
                                        str = str3;
                                        cls = cls4;
                                        r0 = 1;
                                        obj3 = value;
                                        if (obj3 != null) {
                                        }
                                        if (str instanceof String) {
                                        }
                                        if (obj3 == null) {
                                        }
                                        z5 = false;
                                    }
                                }
                                z4 = true;
                                if (z4) {
                                }
                            }
                            str = str3;
                            cls = cls4;
                            z3 = true;
                            processValue = processValue(jSONSerializer, null, obj, str, value, i);
                            obj3 = processValue;
                            r0 = z3;
                            if (obj3 != null) {
                            }
                            if (str instanceof String) {
                            }
                            if (obj3 == null) {
                            }
                            z5 = false;
                        }
                        jSONSerializer.context = serialContext;
                        jSONSerializer.decrementIdent();
                        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat) && treeMap.size() > 0) {
                            jSONSerializer.println();
                        }
                        if (z) {
                            serializeWriter.write(125);
                            return;
                        }
                        return;
                    }
                }
                z2 = true;
                boolean z52 = z2;
                Class<?> cls42 = null;
                ObjectSerializer objectSerializer3 = null;
                while (r16.hasNext()) {
                }
                jSONSerializer.context = serialContext;
                jSONSerializer.decrementIdent();
                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    jSONSerializer.println();
                }
                if (z) {
                }
            }
        }
        treeMap = map;
        if (!jSONSerializer.containsReference(obj)) {
        }
    }
}
