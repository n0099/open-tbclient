package com.baidu.adp.lib.a.b.a.c;

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
    private Bundle go;

    public a(Bundle bundle) {
        this.go = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> co() {
        return this.go.keySet();
    }

    public Object getObject(String str) {
        return this.go.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.go.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.go.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.go.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.go.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.go.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.go.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.go.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.go.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.go.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.go.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.go.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.go.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.go.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.go.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.go.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.go.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.go.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.go.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.go.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.go.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.go.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.go.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.go.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.go.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.go.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.go.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.go.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h i = com.baidu.adp.lib.a.b.a.e.g.i(object);
            if (i != null) {
                return i.g(cVar);
            }
        }
        return null;
    }
}
