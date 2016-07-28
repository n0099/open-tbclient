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
    private Bundle iC;

    public a(Bundle bundle) {
        this.iC = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> cg() {
        return this.iC.keySet();
    }

    public Object getObject(String str) {
        return this.iC.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void j(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.iC.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.iC.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.iC.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.iC.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.iC.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.iC.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.iC.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.iC.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.iC.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.iC.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.iC.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.iC.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.iC.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.iC.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.iC.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.iC.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.iC.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.iC.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.iC.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.iC.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.iC.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.iC.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.iC.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.e(componentType, Parcelable.class)) {
                this.iC.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.iC.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.iC.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.iC.putSerializable(str, (Serializable) obj);
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
