package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public static final int NON_STRINGKEY_AS_STRING;
    public static MapSerializer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-675234484, "Lcom/alibaba/fastjson/serializer/MapSerializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-675234484, "Lcom/alibaba/fastjson/serializer/MapSerializer;");
                return;
            }
        }
        instance = new MapSerializer();
        NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});
    }

    public MapSerializer() {
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

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            write(jSONSerializer, obj, obj2, type, i2, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.alibaba.fastjson.serializer.SerializeWriter */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0201 A[Catch: all -> 0x0317, TryCatch #0 {all -> 0x0317, blocks: (B:30:0x0056, B:31:0x0059, B:33:0x0065, B:44:0x0084, B:46:0x0095, B:47:0x00a5, B:49:0x00ab, B:51:0x00bd, B:54:0x00c5, B:57:0x00ca, B:59:0x00d4, B:61:0x00d8, B:64:0x00e3, B:67:0x00f1, B:69:0x00f5, B:72:0x00fd, B:75:0x0102, B:77:0x010c, B:79:0x0110, B:82:0x011b, B:85:0x0125, B:87:0x0129, B:90:0x0131, B:93:0x0136, B:95:0x0140, B:97:0x0144, B:100:0x014f, B:103:0x0159, B:105:0x015d, B:108:0x0165, B:111:0x016a, B:113:0x0174, B:115:0x0178, B:118:0x0184, B:121:0x018f, B:123:0x0193, B:126:0x019b, B:129:0x01a0, B:131:0x01aa, B:133:0x01ae, B:134:0x01b7, B:135:0x01bd, B:137:0x01c1, B:140:0x01c9, B:143:0x01ce, B:145:0x01d8, B:147:0x01dc, B:148:0x01e5, B:151:0x01ee, B:154:0x01f3, B:156:0x01f7, B:162:0x0201, B:167:0x0241, B:170:0x0253, B:172:0x0259, B:174:0x025e, B:175:0x0261, B:177:0x0269, B:178:0x026c, B:191:0x029b, B:193:0x02a8, B:195:0x02b0, B:197:0x02b7, B:199:0x02c1, B:201:0x02c5, B:203:0x02c9, B:205:0x02d4, B:207:0x02da, B:208:0x02e8, B:180:0x0272, B:181:0x0275, B:183:0x027d, B:188:0x0291, B:189:0x0294, B:185:0x0285, B:187:0x0289, B:164:0x0226, B:39:0x0079), top: B:225:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0241 A[Catch: all -> 0x0317, TryCatch #0 {all -> 0x0317, blocks: (B:30:0x0056, B:31:0x0059, B:33:0x0065, B:44:0x0084, B:46:0x0095, B:47:0x00a5, B:49:0x00ab, B:51:0x00bd, B:54:0x00c5, B:57:0x00ca, B:59:0x00d4, B:61:0x00d8, B:64:0x00e3, B:67:0x00f1, B:69:0x00f5, B:72:0x00fd, B:75:0x0102, B:77:0x010c, B:79:0x0110, B:82:0x011b, B:85:0x0125, B:87:0x0129, B:90:0x0131, B:93:0x0136, B:95:0x0140, B:97:0x0144, B:100:0x014f, B:103:0x0159, B:105:0x015d, B:108:0x0165, B:111:0x016a, B:113:0x0174, B:115:0x0178, B:118:0x0184, B:121:0x018f, B:123:0x0193, B:126:0x019b, B:129:0x01a0, B:131:0x01aa, B:133:0x01ae, B:134:0x01b7, B:135:0x01bd, B:137:0x01c1, B:140:0x01c9, B:143:0x01ce, B:145:0x01d8, B:147:0x01dc, B:148:0x01e5, B:151:0x01ee, B:154:0x01f3, B:156:0x01f7, B:162:0x0201, B:167:0x0241, B:170:0x0253, B:172:0x0259, B:174:0x025e, B:175:0x0261, B:177:0x0269, B:178:0x026c, B:191:0x029b, B:193:0x02a8, B:195:0x02b0, B:197:0x02b7, B:199:0x02c1, B:201:0x02c5, B:203:0x02c9, B:205:0x02d4, B:207:0x02da, B:208:0x02e8, B:180:0x0272, B:181:0x0275, B:183:0x027d, B:188:0x0291, B:189:0x0294, B:185:0x0285, B:187:0x0289, B:164:0x0226, B:39:0x0079), top: B:225:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0259 A[Catch: all -> 0x0317, TryCatch #0 {all -> 0x0317, blocks: (B:30:0x0056, B:31:0x0059, B:33:0x0065, B:44:0x0084, B:46:0x0095, B:47:0x00a5, B:49:0x00ab, B:51:0x00bd, B:54:0x00c5, B:57:0x00ca, B:59:0x00d4, B:61:0x00d8, B:64:0x00e3, B:67:0x00f1, B:69:0x00f5, B:72:0x00fd, B:75:0x0102, B:77:0x010c, B:79:0x0110, B:82:0x011b, B:85:0x0125, B:87:0x0129, B:90:0x0131, B:93:0x0136, B:95:0x0140, B:97:0x0144, B:100:0x014f, B:103:0x0159, B:105:0x015d, B:108:0x0165, B:111:0x016a, B:113:0x0174, B:115:0x0178, B:118:0x0184, B:121:0x018f, B:123:0x0193, B:126:0x019b, B:129:0x01a0, B:131:0x01aa, B:133:0x01ae, B:134:0x01b7, B:135:0x01bd, B:137:0x01c1, B:140:0x01c9, B:143:0x01ce, B:145:0x01d8, B:147:0x01dc, B:148:0x01e5, B:151:0x01ee, B:154:0x01f3, B:156:0x01f7, B:162:0x0201, B:167:0x0241, B:170:0x0253, B:172:0x0259, B:174:0x025e, B:175:0x0261, B:177:0x0269, B:178:0x026c, B:191:0x029b, B:193:0x02a8, B:195:0x02b0, B:197:0x02b7, B:199:0x02c1, B:201:0x02c5, B:203:0x02c9, B:205:0x02d4, B:207:0x02da, B:208:0x02e8, B:180:0x0272, B:181:0x0275, B:183:0x027d, B:188:0x0291, B:189:0x0294, B:185:0x0285, B:187:0x0289, B:164:0x0226, B:39:0x0079), top: B:225:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x029b A[Catch: all -> 0x0317, TryCatch #0 {all -> 0x0317, blocks: (B:30:0x0056, B:31:0x0059, B:33:0x0065, B:44:0x0084, B:46:0x0095, B:47:0x00a5, B:49:0x00ab, B:51:0x00bd, B:54:0x00c5, B:57:0x00ca, B:59:0x00d4, B:61:0x00d8, B:64:0x00e3, B:67:0x00f1, B:69:0x00f5, B:72:0x00fd, B:75:0x0102, B:77:0x010c, B:79:0x0110, B:82:0x011b, B:85:0x0125, B:87:0x0129, B:90:0x0131, B:93:0x0136, B:95:0x0140, B:97:0x0144, B:100:0x014f, B:103:0x0159, B:105:0x015d, B:108:0x0165, B:111:0x016a, B:113:0x0174, B:115:0x0178, B:118:0x0184, B:121:0x018f, B:123:0x0193, B:126:0x019b, B:129:0x01a0, B:131:0x01aa, B:133:0x01ae, B:134:0x01b7, B:135:0x01bd, B:137:0x01c1, B:140:0x01c9, B:143:0x01ce, B:145:0x01d8, B:147:0x01dc, B:148:0x01e5, B:151:0x01ee, B:154:0x01f3, B:156:0x01f7, B:162:0x0201, B:167:0x0241, B:170:0x0253, B:172:0x0259, B:174:0x025e, B:175:0x0261, B:177:0x0269, B:178:0x026c, B:191:0x029b, B:193:0x02a8, B:195:0x02b0, B:197:0x02b7, B:199:0x02c1, B:201:0x02c5, B:203:0x02c9, B:205:0x02d4, B:207:0x02da, B:208:0x02e8, B:180:0x0272, B:181:0x0275, B:183:0x027d, B:188:0x0291, B:189:0x0294, B:185:0x0285, B:187:0x0289, B:164:0x0226, B:39:0x0079), top: B:225:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02a8 A[Catch: all -> 0x0317, TryCatch #0 {all -> 0x0317, blocks: (B:30:0x0056, B:31:0x0059, B:33:0x0065, B:44:0x0084, B:46:0x0095, B:47:0x00a5, B:49:0x00ab, B:51:0x00bd, B:54:0x00c5, B:57:0x00ca, B:59:0x00d4, B:61:0x00d8, B:64:0x00e3, B:67:0x00f1, B:69:0x00f5, B:72:0x00fd, B:75:0x0102, B:77:0x010c, B:79:0x0110, B:82:0x011b, B:85:0x0125, B:87:0x0129, B:90:0x0131, B:93:0x0136, B:95:0x0140, B:97:0x0144, B:100:0x014f, B:103:0x0159, B:105:0x015d, B:108:0x0165, B:111:0x016a, B:113:0x0174, B:115:0x0178, B:118:0x0184, B:121:0x018f, B:123:0x0193, B:126:0x019b, B:129:0x01a0, B:131:0x01aa, B:133:0x01ae, B:134:0x01b7, B:135:0x01bd, B:137:0x01c1, B:140:0x01c9, B:143:0x01ce, B:145:0x01d8, B:147:0x01dc, B:148:0x01e5, B:151:0x01ee, B:154:0x01f3, B:156:0x01f7, B:162:0x0201, B:167:0x0241, B:170:0x0253, B:172:0x0259, B:174:0x025e, B:175:0x0261, B:177:0x0269, B:178:0x026c, B:191:0x029b, B:193:0x02a8, B:195:0x02b0, B:197:0x02b7, B:199:0x02c1, B:201:0x02c5, B:203:0x02c9, B:205:0x02d4, B:207:0x02da, B:208:0x02e8, B:180:0x0272, B:181:0x0275, B:183:0x027d, B:188:0x0291, B:189:0x0294, B:185:0x0285, B:187:0x0289, B:164:0x0226, B:39:0x0079), top: B:225:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0253 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ab A[Catch: all -> 0x0317, TryCatch #0 {all -> 0x0317, blocks: (B:30:0x0056, B:31:0x0059, B:33:0x0065, B:44:0x0084, B:46:0x0095, B:47:0x00a5, B:49:0x00ab, B:51:0x00bd, B:54:0x00c5, B:57:0x00ca, B:59:0x00d4, B:61:0x00d8, B:64:0x00e3, B:67:0x00f1, B:69:0x00f5, B:72:0x00fd, B:75:0x0102, B:77:0x010c, B:79:0x0110, B:82:0x011b, B:85:0x0125, B:87:0x0129, B:90:0x0131, B:93:0x0136, B:95:0x0140, B:97:0x0144, B:100:0x014f, B:103:0x0159, B:105:0x015d, B:108:0x0165, B:111:0x016a, B:113:0x0174, B:115:0x0178, B:118:0x0184, B:121:0x018f, B:123:0x0193, B:126:0x019b, B:129:0x01a0, B:131:0x01aa, B:133:0x01ae, B:134:0x01b7, B:135:0x01bd, B:137:0x01c1, B:140:0x01c9, B:143:0x01ce, B:145:0x01d8, B:147:0x01dc, B:148:0x01e5, B:151:0x01ee, B:154:0x01f3, B:156:0x01f7, B:162:0x0201, B:167:0x0241, B:170:0x0253, B:172:0x0259, B:174:0x025e, B:175:0x0261, B:177:0x0269, B:178:0x026c, B:191:0x029b, B:193:0x02a8, B:195:0x02b0, B:197:0x02b7, B:199:0x02c1, B:201:0x02c5, B:203:0x02c9, B:205:0x02d4, B:207:0x02da, B:208:0x02e8, B:180:0x0272, B:181:0x0275, B:183:0x027d, B:188:0x0291, B:189:0x0294, B:185:0x0285, B:187:0x0289, B:164:0x0226, B:39:0x0079), top: B:225:0x0056 }] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2, boolean z) throws IOException {
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
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2), Boolean.valueOf(z)}) != null) {
            return;
        }
        Object obj4 = obj;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj4 == null) {
            serializeWriter.writeNull();
            return;
        }
        Map<String, Object> map = (Map) obj4;
        int i3 = SerializerFeature.MapSortField.mask;
        if ((serializeWriter.features & i3) != 0 || (i3 & i2) != 0) {
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
                        serializeWriter.write(123);
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
                                        processValue = processValue(jSONSerializer, null, obj, JSON.toJSONString(str3), value, i2);
                                        obj3 = processValue;
                                        r0 = z3;
                                        if (obj3 != null || SerializerFeature.isEnabled(serializeWriter.features, i2, SerializerFeature.WriteMapNullValue)) {
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
                                                if ((serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING) || SerializerFeature.isEnabled(i2, SerializerFeature.WriteNonStringKeyAsString)) && !(str instanceof Enum)) {
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
                                                if (SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName) && (objectSerializer2 instanceof JavaBeanSerializer)) {
                                                    if (type instanceof ParameterizedType) {
                                                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                                        if (actualTypeArguments.length == 2) {
                                                            type2 = actualTypeArguments[r0];
                                                            objectSerializer = objectSerializer2;
                                                            ((JavaBeanSerializer) objectSerializer2).writeNoneASM(jSONSerializer, obj3, str, type2, i2);
                                                        }
                                                    }
                                                    type2 = null;
                                                    objectSerializer = objectSerializer2;
                                                    ((JavaBeanSerializer) objectSerializer2).writeNoneASM(jSONSerializer, obj3, str, type2, i2);
                                                } else {
                                                    objectSerializer = objectSerializer2;
                                                    objectSerializer.write(jSONSerializer, obj3, str, null, i2);
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
                            processValue = processValue(jSONSerializer, null, obj, str, value, i2);
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
