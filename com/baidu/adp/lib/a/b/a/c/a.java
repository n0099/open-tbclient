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
    private Bundle sh;

    public a(Bundle bundle) {
        this.sh = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fR() {
        return this.sh.keySet();
    }

    public Object getObject(String str) {
        return this.sh.get(str);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.sh.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.sh.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.sh.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.sh.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.sh.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.sh.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.sh.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.sh.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.sh.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.sh.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.sh.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.sh.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.sh.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.sh.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.sh.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.sh.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.sh.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.sh.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.sh.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.sh.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.sh.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.sh.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.sh.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.a.a.a.a(componentType, Parcelable.class)) {
                this.sh.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.sh.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.sh.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.sh.putSerializable(str, (Serializable) obj);
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
