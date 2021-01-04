package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public abstract class FieldDeserializer {
    protected BeanContext beanContext;
    protected final Class<?> clazz;
    public final FieldInfo fieldInfo;

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
    }

    public int getFastMatchToken() {
        return 0;
    }

    public void setValue(Object obj, boolean z) {
        setValue(obj, Boolean.valueOf(z));
    }

    public void setValue(Object obj, int i) {
        setValue(obj, Integer.valueOf(i));
    }

    public void setValue(Object obj, long j) {
        setValue(obj, Long.valueOf(j));
    }

    public void setValue(Object obj, String str) {
        setValue(obj, (Object) str);
    }

    public void setValue(Object obj, Object obj2) {
        if (obj2 != null || !this.fieldInfo.fieldClass.isPrimitive()) {
            String trim = (this.fieldInfo.fieldClass == String.class && this.fieldInfo.format != null && this.fieldInfo.format.equals("trim")) ? ((String) obj2).trim() : obj2;
            try {
                Method method = this.fieldInfo.method;
                if (method != null) {
                    if (!this.fieldInfo.getOnly) {
                        method.invoke(obj, trim);
                    } else if (this.fieldInfo.fieldClass == AtomicInteger.class) {
                        AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, new Object[0]);
                        if (atomicInteger != null) {
                            atomicInteger.set(((AtomicInteger) trim).get());
                        }
                    } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
                        AtomicLong atomicLong = (AtomicLong) method.invoke(obj, new Object[0]);
                        if (atomicLong != null) {
                            atomicLong.set(((AtomicLong) trim).get());
                        }
                    } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
                        AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, new Object[0]);
                        if (atomicBoolean != null) {
                            atomicBoolean.set(((AtomicBoolean) trim).get());
                        }
                    } else if (Map.class.isAssignableFrom(method.getReturnType())) {
                        Map map = (Map) method.invoke(obj, new Object[0]);
                        if (map != null) {
                            map.putAll((Map) trim);
                        }
                    } else {
                        Collection collection = (Collection) method.invoke(obj, new Object[0]);
                        if (collection != null && trim != null) {
                            collection.clear();
                            collection.addAll((Collection) trim);
                        }
                    }
                } else {
                    Field field = this.fieldInfo.field;
                    if (this.fieldInfo.getOnly) {
                        if (this.fieldInfo.fieldClass == AtomicInteger.class) {
                            AtomicInteger atomicInteger2 = (AtomicInteger) field.get(obj);
                            if (atomicInteger2 != null) {
                                atomicInteger2.set(((AtomicInteger) trim).get());
                            }
                        } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
                            AtomicLong atomicLong2 = (AtomicLong) field.get(obj);
                            if (atomicLong2 != null) {
                                atomicLong2.set(((AtomicLong) trim).get());
                            }
                        } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
                            AtomicBoolean atomicBoolean2 = (AtomicBoolean) field.get(obj);
                            if (atomicBoolean2 != null) {
                                atomicBoolean2.set(((AtomicBoolean) trim).get());
                            }
                        } else if (Map.class.isAssignableFrom(this.fieldInfo.fieldClass)) {
                            Map map2 = (Map) field.get(obj);
                            if (map2 != null) {
                                map2.putAll((Map) trim);
                            }
                        } else {
                            Collection collection2 = (Collection) field.get(obj);
                            if (collection2 != null && trim != null) {
                                collection2.clear();
                                collection2.addAll((Collection) trim);
                            }
                        }
                    } else if (field != null) {
                        field.set(obj, trim);
                    }
                }
            } catch (Exception e) {
                throw new JSONException("set property error, " + this.fieldInfo.name, e);
            }
        }
    }

    public void setWrappedValue(String str, Object obj) {
        throw new JSONException("TODO");
    }
}
