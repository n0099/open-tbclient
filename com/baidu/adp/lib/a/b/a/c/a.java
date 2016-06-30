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
    private Bundle hU;

    public a(Bundle bundle) {
        this.hU = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> ch() {
        return this.hU.keySet();
    }

    public Object getObject(String str) {
        return this.hU.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.hU.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.hU.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.hU.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.hU.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.hU.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.hU.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.hU.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.hU.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.hU.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.hU.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.hU.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.hU.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.hU.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.hU.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.hU.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.hU.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.hU.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.hU.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.hU.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.hU.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.hU.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.hU.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.hU.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.hU.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.hU.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.hU.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.hU.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object b(String str, Type type) {
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
