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
    private Bundle rO;

    public a(Bundle bundle) {
        this.rO = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fJ() {
        return this.rO.keySet();
    }

    public Object getObject(String str) {
        return this.rO.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.rO.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.rO.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.rO.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.rO.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.rO.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.rO.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.rO.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.rO.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.rO.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.rO.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.rO.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.rO.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.rO.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.rO.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.rO.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.rO.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.rO.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.rO.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.rO.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.rO.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.rO.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.rO.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.rO.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.rO.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.rO.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.rO.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.rO.putSerializable(str, (Serializable) obj);
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
