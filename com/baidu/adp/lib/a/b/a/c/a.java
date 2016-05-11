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
    private Bundle hV;

    public a(Bundle bundle) {
        this.hV = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> cg() {
        return this.hV.keySet();
    }

    public Object getObject(String str) {
        return this.hV.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.hV.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.hV.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.hV.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.hV.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.hV.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.hV.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.hV.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.hV.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.hV.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.hV.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.hV.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.hV.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.hV.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.hV.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.hV.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.hV.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.hV.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.hV.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.hV.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.hV.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.hV.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.hV.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.hV.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.hV.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.hV.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.hV.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.hV.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h j = com.baidu.adp.lib.a.b.a.e.g.j(object);
            if (j != null) {
                return j.g(cVar);
            }
        }
        return null;
    }
}
