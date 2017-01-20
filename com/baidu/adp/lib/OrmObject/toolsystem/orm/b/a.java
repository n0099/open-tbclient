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
    private Bundle kL;

    public a(Bundle bundle) {
        this.kL = bundle;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> cZ() {
        return this.kL.keySet();
    }

    public Object getObject(String str) {
        return this.kL.get(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void j(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.kL.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.kL.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.kL.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.kL.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.kL.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.kL.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.kL.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.kL.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.kL.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.kL.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.kL.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.kL.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.kL.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.kL.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.kL.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.kL.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.kL.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.kL.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.kL.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.kL.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.kL.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.kL.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.kL.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(componentType, Parcelable.class)) {
                this.kL.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.kL.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.kL.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.kL.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h m = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.m(object);
            if (m != null) {
                return m.g(cVar);
            }
        }
        return null;
    }
}
