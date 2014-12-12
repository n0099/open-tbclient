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
    private Bundle gm;

    public a(Bundle bundle) {
        this.gm = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> cq() {
        return this.gm.keySet();
    }

    public Object getObject(String str) {
        return this.gm.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.gm.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.gm.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.gm.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.gm.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.gm.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.gm.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.gm.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.gm.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.gm.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.gm.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.gm.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.gm.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.gm.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.gm.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.gm.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.gm.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.gm.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.gm.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.gm.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.gm.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.gm.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.gm.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.gm.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.gm.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.gm.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.gm.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.gm.putSerializable(str, (Serializable) obj);
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
