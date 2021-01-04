package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class a implements c {
    private Bundle bundle;

    public a(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.bundle.keySet();
    }

    public Object getObject(String str) {
        return this.bundle.get(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.bundle.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.bundle.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.bundle.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.bundle.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.bundle.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.bundle.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.bundle.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.bundle.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.bundle.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.bundle.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.bundle.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.bundle.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.bundle.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.bundle.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.bundle.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.bundle.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.bundle.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(componentType, Parcelable.class)) {
                this.bundle.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.bundle.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.bundle.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h s = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(object);
            if (s != null) {
                return s.g(cVar);
            }
        }
        return null;
    }
}
