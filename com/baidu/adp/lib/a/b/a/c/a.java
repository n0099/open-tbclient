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
    private Bundle rQ;

    public a(Bundle bundle) {
        this.rQ = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fJ() {
        return this.rQ.keySet();
    }

    public Object getObject(String str) {
        return this.rQ.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.rQ.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.rQ.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.rQ.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.rQ.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.rQ.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.rQ.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.rQ.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.rQ.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.rQ.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.rQ.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.rQ.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.rQ.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.rQ.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.rQ.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.rQ.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.rQ.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.rQ.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.rQ.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.rQ.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.rQ.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.rQ.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.rQ.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.rQ.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.rQ.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.rQ.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.rQ.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.rQ.putSerializable(str, (Serializable) obj);
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
