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
    private Bundle rI;

    public a(Bundle bundle) {
        this.rI = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fM() {
        return this.rI.keySet();
    }

    public Object getObject(String str) {
        return this.rI.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.rI.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.rI.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.rI.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.rI.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.rI.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.rI.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.rI.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.rI.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.rI.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.rI.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.rI.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.rI.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.rI.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.rI.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.rI.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.rI.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.rI.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.rI.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.rI.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.rI.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.rI.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.rI.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.rI.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.rI.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.rI.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.rI.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.rI.putSerializable(str, (Serializable) obj);
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
