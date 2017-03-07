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
    private Bundle sG;

    public a(Bundle bundle) {
        this.sG = bundle;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> ei() {
        return this.sG.keySet();
    }

    public Object getObject(String str) {
        return this.sG.get(str);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void j(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.sG.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            this.sG.putByte(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            this.sG.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            this.sG.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Character) {
            this.sG.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Long) {
            this.sG.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.sG.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.sG.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            this.sG.putString(str, (String) obj);
        } else if (obj instanceof Bundle) {
            this.sG.putBundle(str, (Bundle) obj);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && arrayList.size() > 0) {
                Object obj2 = arrayList.get(0);
                if (obj2 instanceof String) {
                    this.sG.putStringArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Integer) {
                    this.sG.putIntegerArrayList(str, (ArrayList) obj);
                } else if (obj2 instanceof Parcelable) {
                    this.sG.putParcelableArrayList(str, (ArrayList) obj);
                }
            }
        } else if (obj instanceof SparseArray) {
            this.sG.putSparseParcelableArray(str, (SparseArray) obj);
        } else if (obj.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                this.sG.putBooleanArray(str, (boolean[]) obj);
            } else if (componentType == Byte.TYPE) {
                this.sG.putByteArray(str, (byte[]) obj);
            } else if (componentType == Character.TYPE) {
                this.sG.putCharArray(str, (char[]) obj);
            } else if (componentType == Double.TYPE) {
                this.sG.putDoubleArray(str, (double[]) obj);
            } else if (componentType == Float.TYPE) {
                this.sG.putFloatArray(str, (float[]) obj);
            } else if (componentType == Integer.TYPE) {
                this.sG.putIntArray(str, (int[]) obj);
            } else if (componentType == Long.TYPE) {
                this.sG.putLongArray(str, (long[]) obj);
            } else if (componentType == Short.TYPE) {
                this.sG.putShortArray(str, (short[]) obj);
            } else if (componentType == String.class) {
                this.sG.putStringArray(str, (String[]) obj);
            } else if (com.baidu.adp.lib.OrmObject.a.a.e(componentType, Parcelable.class)) {
                this.sG.putParcelableArray(str, (Parcelable[]) obj);
            }
        } else if (obj instanceof CharSequence) {
            this.sG.putCharSequence(str, (CharSequence) obj);
        } else if (!(obj instanceof IBinder)) {
            if (obj instanceof Parcelable) {
                this.sG.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                this.sG.putSerializable(str, (Serializable) obj);
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
