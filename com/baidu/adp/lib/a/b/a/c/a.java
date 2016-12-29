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
    private Bundle kR;

    public a(Bundle bundle) {
        this.kR = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> db() {
        return this.kR.keySet();
    }

    public Object getObject(String str) {
        return this.kR.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void j(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.kR.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.kR.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.kR.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.kR.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.kR.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.kR.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.kR.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.kR.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.kR.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.kR.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.kR.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.kR.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.kR.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.kR.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.kR.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.kR.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.kR.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.kR.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.kR.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.kR.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.kR.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.kR.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.kR.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.e(componentType, Parcelable.class)) {
                this.kR.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.kR.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.kR.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.kR.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h m = com.baidu.adp.lib.a.b.a.e.g.m(object);
            if (m != null) {
                return m.g(cVar);
            }
        }
        return null;
    }
}
