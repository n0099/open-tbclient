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
    private Bundle ek;

    public a(Bundle bundle) {
        this.ek = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> bQ() {
        return this.ek.keySet();
    }

    public Object getObject(String str) {
        return this.ek.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void a(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.ek.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.ek.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.ek.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.ek.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.ek.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.ek.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.ek.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.ek.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.ek.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.ek.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.ek.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.ek.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.ek.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.ek.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.ek.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.ek.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.ek.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.ek.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.ek.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.ek.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.ek.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.ek.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.ek.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.ek.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.ek.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.ek.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.ek.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h d = com.baidu.adp.lib.a.b.a.e.g.d(object);
            if (d != null) {
                return d.g(cVar);
            }
        }
        return null;
    }
}
