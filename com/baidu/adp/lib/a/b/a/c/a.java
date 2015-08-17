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
    private Bundle rP;

    public a(Bundle bundle) {
        this.rP = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fM() {
        return this.rP.keySet();
    }

    public Object getObject(String str) {
        return this.rP.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.rP.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.rP.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.rP.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.rP.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.rP.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.rP.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.rP.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.rP.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.rP.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.rP.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.rP.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.rP.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.rP.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.rP.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.rP.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.rP.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.rP.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.rP.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.rP.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.rP.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.rP.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.rP.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.rP.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.rP.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.rP.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.rP.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.rP.putSerializable(str, (Serializable) obj);
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
