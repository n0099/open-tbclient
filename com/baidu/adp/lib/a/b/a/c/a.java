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
    private Bundle rT;

    public a(Bundle bundle) {
        this.rT = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fR() {
        return this.rT.keySet();
    }

    public Object getObject(String str) {
        return this.rT.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.rT.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.rT.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.rT.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.rT.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.rT.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.rT.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.rT.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.rT.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.rT.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.rT.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.rT.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.rT.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.rT.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.rT.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.rT.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.rT.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.rT.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.rT.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.rT.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.rT.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.rT.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.rT.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.rT.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.rT.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.rT.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.rT.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.rT.putSerializable(str, (Serializable) obj);
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
