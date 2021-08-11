package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
/* loaded from: classes4.dex */
public final class ListSerializer implements ObjectSerializer {
    public static /* synthetic */ Interceptable $ic;
    public static final ListSerializer instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-221314580, "Lcom/alibaba/fastjson/serializer/ListSerializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-221314580, "Lcom/alibaba/fastjson/serializer/ListSerializer;");
                return;
            }
        }
        instance = new ListSerializer();
    }

    public ListSerializer() {
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
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        int i3;
        Object obj3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            boolean z2 = jSONSerializer.out.isEnabled(SerializerFeature.WriteClassName) || SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName);
            SerializeWriter serializeWriter = jSONSerializer.out;
            Type collectionItemType = z2 ? TypeUtils.getCollectionItemType(type) : null;
            if (obj == null) {
                serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
                return;
            }
            List list = (List) obj;
            if (list.size() == 0) {
                serializeWriter.append((CharSequence) "[]");
                return;
            }
            SerialContext serialContext = jSONSerializer.context;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            try {
                char c2 = ',';
                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    serializeWriter.append('[');
                    jSONSerializer.incrementIndent();
                    int i4 = 0;
                    for (Object obj4 : list) {
                        if (i4 != 0) {
                            serializeWriter.append(c2);
                        }
                        jSONSerializer.println();
                        if (obj4 != null) {
                            if (jSONSerializer.containsReference(obj4)) {
                                jSONSerializer.writeReference(obj4);
                            } else {
                                ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(obj4.getClass());
                                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                                objectWriter.write(jSONSerializer, obj4, Integer.valueOf(i4), collectionItemType, i2);
                            }
                        } else {
                            jSONSerializer.out.writeNull();
                        }
                        i4++;
                        c2 = ',';
                    }
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                    serializeWriter.append(']');
                    return;
                }
                char c3 = ']';
                serializeWriter.append('[');
                int size = list.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj5 = list.get(i5);
                    if (i5 != 0) {
                        serializeWriter.append(',');
                    }
                    if (obj5 == null) {
                        serializeWriter.append((CharSequence) StringUtil.NULL_STRING);
                    } else {
                        Class<?> cls = obj5.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) obj5).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj5).longValue();
                            if (z2) {
                                serializeWriter.writeLong(longValue);
                                serializeWriter.write(76);
                            } else {
                                serializeWriter.writeLong(longValue);
                            }
                        } else {
                            if ((SerializerFeature.DisableCircularReferenceDetect.mask & i2) != 0) {
                                i3 = i5;
                                jSONSerializer.getObjectWriter(obj5.getClass()).write(jSONSerializer, obj5, Integer.valueOf(i5), collectionItemType, i2);
                                z = z2;
                            } else {
                                i3 = i5;
                                if (serializeWriter.disableCircularReferenceDetect) {
                                    obj3 = obj5;
                                    z = z2;
                                } else {
                                    obj3 = obj5;
                                    z = z2;
                                    jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                                }
                                if (jSONSerializer.containsReference(obj3)) {
                                    jSONSerializer.writeReference(obj3);
                                } else {
                                    ObjectSerializer objectWriter2 = jSONSerializer.getObjectWriter(obj3.getClass());
                                    if ((SerializerFeature.WriteClassName.mask & i2) != 0 && (objectWriter2 instanceof JavaBeanSerializer)) {
                                        ((JavaBeanSerializer) objectWriter2).writeNoneASM(jSONSerializer, obj3, Integer.valueOf(i3), collectionItemType, i2);
                                    } else {
                                        objectWriter2.write(jSONSerializer, obj3, Integer.valueOf(i3), collectionItemType, i2);
                                    }
                                }
                            }
                            i5 = i3 + 1;
                            z2 = z;
                            c3 = ']';
                        }
                    }
                    i3 = i5;
                    z = z2;
                    i5 = i3 + 1;
                    z2 = z;
                    c3 = ']';
                }
                serializeWriter.append(c3);
            } finally {
                jSONSerializer.context = serialContext;
            }
        }
    }
}
