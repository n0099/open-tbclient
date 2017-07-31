package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

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
    private Bundle tO;

    public a(Bundle bundle) {
        this.tO = bundle;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> eq() {
        return this.tO.keySet();
    }

    public Object getObject(String str) {
        return this.tO.get(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void j(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.tO.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.tO.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.tO.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.tO.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.tO.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.tO.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.tO.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.tO.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.tO.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.tO.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.tO.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.tO.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.tO.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.tO.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.tO.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.tO.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.tO.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.tO.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.tO.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.tO.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.tO.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.tO.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.tO.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(componentType, Parcelable.class)) {
                this.tO.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.tO.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.tO.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.tO.putSerializable(str, (Serializable) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h m = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.m(object);
            if (m != null) {
                return m.g(cVar);
            }
        }
        return null;
    }
}
