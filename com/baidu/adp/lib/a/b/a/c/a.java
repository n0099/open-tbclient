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
    private Bundle kS;

    public a(Bundle bundle) {
        this.kS = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> db() {
        return this.kS.keySet();
    }

    public Object getObject(String str) {
        return this.kS.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void j(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.kS.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.kS.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.kS.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.kS.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.kS.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.kS.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.kS.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.kS.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.kS.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.kS.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.kS.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.kS.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.kS.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.kS.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.kS.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.kS.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.kS.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.kS.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.kS.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.kS.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.kS.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.kS.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.kS.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.e(componentType, Parcelable.class)) {
                this.kS.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.kS.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.kS.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.kS.putSerializable(str, (Serializable) obj);
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
