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
/* loaded from: classes6.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x019f A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:27:0x005a, B:28:0x005f, B:30:0x006f, B:40:0x008e, B:36:0x0085, B:41:0x00a1, B:42:0x00ae, B:44:0x00b4, B:46:0x00c8, B:49:0x00d0, B:116:0x01d9, B:118:0x01e3, B:120:0x01e7, B:51:0x00d4, B:53:0x00e4, B:55:0x00ea, B:58:0x00f2, B:123:0x01f9, B:125:0x0203, B:127:0x0207, B:60:0x00f6, B:62:0x0106, B:64:0x010c, B:67:0x0114, B:130:0x0219, B:132:0x0223, B:134:0x0227, B:69:0x0118, B:71:0x0128, B:73:0x012e, B:76:0x0136, B:137:0x0239, B:139:0x0243, B:141:0x0247, B:78:0x013a, B:80:0x014a, B:82:0x0150, B:85:0x0158, B:144:0x0259, B:146:0x0263, B:148:0x0267, B:88:0x0169, B:90:0x016f, B:93:0x0177, B:149:0x0278, B:151:0x0282, B:153:0x0286, B:97:0x018a, B:154:0x0297, B:156:0x029b, B:160:0x02a2, B:101:0x019f, B:103:0x01a9, B:105:0x01ad, B:107:0x01b3, B:108:0x01ba, B:110:0x01c4, B:111:0x01c7, B:114:0x01d0, B:175:0x02ec, B:177:0x02f4, B:178:0x02fa, B:180:0x0304, B:182:0x0308, B:184:0x030f, B:186:0x031c, B:187:0x031f, B:189:0x0331, B:163:0x02b7, B:164:0x02be, B:166:0x02c8, B:168:0x02cc, B:169:0x02d5, B:174:0x02e6, B:99:0x018e, B:95:0x017b, B:87:0x015c), top: B:203:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ad A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:27:0x005a, B:28:0x005f, B:30:0x006f, B:40:0x008e, B:36:0x0085, B:41:0x00a1, B:42:0x00ae, B:44:0x00b4, B:46:0x00c8, B:49:0x00d0, B:116:0x01d9, B:118:0x01e3, B:120:0x01e7, B:51:0x00d4, B:53:0x00e4, B:55:0x00ea, B:58:0x00f2, B:123:0x01f9, B:125:0x0203, B:127:0x0207, B:60:0x00f6, B:62:0x0106, B:64:0x010c, B:67:0x0114, B:130:0x0219, B:132:0x0223, B:134:0x0227, B:69:0x0118, B:71:0x0128, B:73:0x012e, B:76:0x0136, B:137:0x0239, B:139:0x0243, B:141:0x0247, B:78:0x013a, B:80:0x014a, B:82:0x0150, B:85:0x0158, B:144:0x0259, B:146:0x0263, B:148:0x0267, B:88:0x0169, B:90:0x016f, B:93:0x0177, B:149:0x0278, B:151:0x0282, B:153:0x0286, B:97:0x018a, B:154:0x0297, B:156:0x029b, B:160:0x02a2, B:101:0x019f, B:103:0x01a9, B:105:0x01ad, B:107:0x01b3, B:108:0x01ba, B:110:0x01c4, B:111:0x01c7, B:114:0x01d0, B:175:0x02ec, B:177:0x02f4, B:178:0x02fa, B:180:0x0304, B:182:0x0308, B:184:0x030f, B:186:0x031c, B:187:0x031f, B:189:0x0331, B:163:0x02b7, B:164:0x02be, B:166:0x02c8, B:168:0x02cc, B:169:0x02d5, B:174:0x02e6, B:99:0x018e, B:95:0x017b, B:87:0x015c), top: B:203:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x01a9 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018a A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:27:0x005a, B:28:0x005f, B:30:0x006f, B:40:0x008e, B:36:0x0085, B:41:0x00a1, B:42:0x00ae, B:44:0x00b4, B:46:0x00c8, B:49:0x00d0, B:116:0x01d9, B:118:0x01e3, B:120:0x01e7, B:51:0x00d4, B:53:0x00e4, B:55:0x00ea, B:58:0x00f2, B:123:0x01f9, B:125:0x0203, B:127:0x0207, B:60:0x00f6, B:62:0x0106, B:64:0x010c, B:67:0x0114, B:130:0x0219, B:132:0x0223, B:134:0x0227, B:69:0x0118, B:71:0x0128, B:73:0x012e, B:76:0x0136, B:137:0x0239, B:139:0x0243, B:141:0x0247, B:78:0x013a, B:80:0x014a, B:82:0x0150, B:85:0x0158, B:144:0x0259, B:146:0x0263, B:148:0x0267, B:88:0x0169, B:90:0x016f, B:93:0x0177, B:149:0x0278, B:151:0x0282, B:153:0x0286, B:97:0x018a, B:154:0x0297, B:156:0x029b, B:160:0x02a2, B:101:0x019f, B:103:0x01a9, B:105:0x01ad, B:107:0x01b3, B:108:0x01ba, B:110:0x01c4, B:111:0x01c7, B:114:0x01d0, B:175:0x02ec, B:177:0x02f4, B:178:0x02fa, B:180:0x0304, B:182:0x0308, B:184:0x030f, B:186:0x031c, B:187:0x031f, B:189:0x0331, B:163:0x02b7, B:164:0x02be, B:166:0x02c8, B:168:0x02cc, B:169:0x02d5, B:174:0x02e6, B:99:0x018e, B:95:0x017b, B:87:0x015c), top: B:203:0x005a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws IOException {
        TreeMap treeMap;
        String str;
        List<NameFilter> list;
        String str2;
        Object processValue;
        ObjectSerializer objectSerializer;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Map<String, Object> map = (Map) obj;
        int i2 = SerializerFeature.MapSortField.mask;
        if ((serializeWriter.features & i2) != 0 || (i2 & i) != 0) {
            if (map instanceof JSONObject) {
                map = ((JSONObject) map).getInnerMap();
            }
            if (!(map instanceof SortedMap) && !(map instanceof LinkedHashMap)) {
                try {
                    treeMap = new TreeMap(map);
                } catch (Exception e) {
                    treeMap = map;
                }
                if (!jSONSerializer.containsReference(obj)) {
                    jSONSerializer.writeReference(obj);
                    return;
                }
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj, obj2, 0);
                if (!z) {
                    try {
                        serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_QUERY);
                    } catch (Throwable th) {
                        jSONSerializer.context = serialContext;
                        throw th;
                    }
                }
                jSONSerializer.incrementIndent();
                boolean z2 = true;
                if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                    String str3 = jSONSerializer.config.typeKey;
                    Class<?> cls = treeMap.getClass();
                    if (!((cls == JSONObject.class || cls == HashMap.class || cls == LinkedHashMap.class) && treeMap.containsKey(str3))) {
                        serializeWriter.writeFieldName(str3);
                        serializeWriter.writeString(obj.getClass().getName());
                        z2 = false;
                    }
                }
                boolean z3 = z2;
                ObjectSerializer objectSerializer2 = null;
                Class<?> cls2 = null;
                for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                    Object value = entry.getValue();
                    String key = entry.getKey();
                    List<PropertyPreFilter> list2 = jSONSerializer.propertyPreFilters;
                    if (list2 != null && list2.size() > 0) {
                        if (key == null || (key instanceof String)) {
                            if (applyName(jSONSerializer, obj, key)) {
                            }
                        } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !applyName(jSONSerializer, obj, JSON.toJSONString(key))) {
                        }
                    }
                    List<PropertyPreFilter> list3 = this.propertyPreFilters;
                    if (list3 != null && list3.size() > 0) {
                        if (key == null || (key instanceof String)) {
                            if (applyName(jSONSerializer, obj, key)) {
                            }
                        } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !applyName(jSONSerializer, obj, JSON.toJSONString(key))) {
                        }
                    }
                    List<PropertyFilter> list4 = jSONSerializer.propertyFilters;
                    if (list4 != null && list4.size() > 0) {
                        if (key == null || (key instanceof String)) {
                            if (apply(jSONSerializer, obj, key, value)) {
                            }
                        } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj, JSON.toJSONString(key), value)) {
                        }
                    }
                    List<PropertyFilter> list5 = this.propertyFilters;
                    if (list5 != null && list5.size() > 0) {
                        if (key == null || (key instanceof String)) {
                            if (apply(jSONSerializer, obj, key, value)) {
                            }
                        } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj, JSON.toJSONString(key), value)) {
                        }
                    }
                    List<NameFilter> list6 = jSONSerializer.nameFilters;
                    if (list6 != null && list6.size() > 0) {
                        if (key == null || (key instanceof String)) {
                            str = processKey(jSONSerializer, obj, key, value);
                        } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                            str = processKey(jSONSerializer, obj, JSON.toJSONString(key), value);
                        }
                        list = this.nameFilters;
                        if (list != null && list.size() > 0) {
                            if (str != null || (str instanceof String)) {
                                str2 = processKey(jSONSerializer, obj, str, value);
                            } else if (str.getClass().isPrimitive() || (str instanceof Number)) {
                                str2 = processKey(jSONSerializer, obj, JSON.toJSONString(str), value);
                            }
                            if (str2 != null || (str2 instanceof String)) {
                                processValue = processValue(jSONSerializer, null, obj, str2, value);
                            } else {
                                processValue = !((str2 instanceof Map) || (str2 instanceof Collection)) ? processValue(jSONSerializer, null, obj, JSON.toJSONString(str2), value) : value;
                            }
                            if (processValue == null || serializeWriter.isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES)) {
                                if (!(str2 instanceof String)) {
                                    String str4 = str2;
                                    if (!z3) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str4, true);
                                } else {
                                    if (!z3) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING) && !(str2 instanceof Enum)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write((Object) str2);
                                    }
                                    serializeWriter.write(58);
                                }
                                if (processValue != null) {
                                    serializeWriter.writeNull();
                                    z3 = false;
                                } else {
                                    Class<?> cls3 = processValue.getClass();
                                    if (cls3 != cls2) {
                                        objectSerializer = jSONSerializer.getObjectWriter(cls3);
                                    } else {
                                        objectSerializer = objectSerializer2;
                                        cls3 = cls2;
                                    }
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName) && (objectSerializer instanceof JavaBeanSerializer)) {
                                        Type type2 = null;
                                        if (type instanceof ParameterizedType) {
                                            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                            if (actualTypeArguments.length == 2) {
                                                type2 = actualTypeArguments[1];
                                            }
                                        }
                                        ((JavaBeanSerializer) objectSerializer).writeNoneASM(jSONSerializer, processValue, str2, type2, i);
                                    } else {
                                        objectSerializer.write(jSONSerializer, processValue, str2, null, i);
                                    }
                                    z3 = false;
                                    objectSerializer2 = objectSerializer;
                                    cls2 = cls3;
                                }
                            }
                        }
                        str2 = str;
                        if (str2 != null) {
                        }
                        processValue = processValue(jSONSerializer, null, obj, str2, value);
                        if (processValue == null) {
                        }
                        if (!(str2 instanceof String)) {
                        }
                        if (processValue != null) {
                        }
                    }
                    str = key;
                    list = this.nameFilters;
                    if (list != null) {
                        if (str != null) {
                        }
                        str2 = processKey(jSONSerializer, obj, str, value);
                        if (str2 != null) {
                        }
                        processValue = processValue(jSONSerializer, null, obj, str2, value);
                        if (processValue == null) {
                        }
                        if (!(str2 instanceof String)) {
                        }
                        if (processValue != null) {
                        }
                    }
                    str2 = str;
                    if (str2 != null) {
                    }
                    processValue = processValue(jSONSerializer, null, obj, str2, value);
                    if (processValue == null) {
                    }
                    if (!(str2 instanceof String)) {
                    }
                    if (processValue != null) {
                    }
                }
                jSONSerializer.context = serialContext;
                jSONSerializer.decrementIdent();
                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat) && treeMap.size() > 0) {
                    jSONSerializer.println();
                }
                if (!z) {
                    serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
                    return;
                }
                return;
            }
        }
        treeMap = map;
        if (!jSONSerializer.containsReference(obj)) {
        }
    }
}
