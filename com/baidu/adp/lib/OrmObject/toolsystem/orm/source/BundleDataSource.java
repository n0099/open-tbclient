package com.baidu.adp.lib.OrmObject.toolsystem.orm.source;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.be;
import com.baidu.tieba.re;
import com.baidu.tieba.td;
import com.baidu.tieba.ve;
import com.baidu.tieba.yc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class BundleDataSource implements td {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle bundle;

    public BundleDataSource(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bundle = bundle;
    }

    public Object getObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.bundle.get(str);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.td
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bundle.keySet();
        }
        return (Set) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td
    public Object getObjectByType(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object object = getObject(str);
            if (object != null) {
                re reVar = new re(type);
                be a = ve.a(object);
                if (a != null) {
                    return a.a(reVar);
                }
                return null;
            }
            return null;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.td
    public void set(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) {
            if (obj instanceof Boolean) {
                this.bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                this.bundle.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof Short) {
                this.bundle.putShort(str, ((Short) obj).shortValue());
            } else if (obj instanceof Integer) {
                this.bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Character) {
                this.bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Long) {
                this.bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                this.bundle.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                this.bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                this.bundle.putString(str, (String) obj);
            } else if (obj instanceof Bundle) {
                this.bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof ArrayList) {
                ArrayList<String> arrayList = (ArrayList) obj;
                if (arrayList != null && arrayList.size() > 0) {
                    String str2 = arrayList.get(0);
                    if (str2 instanceof String) {
                        this.bundle.putStringArrayList(str, arrayList);
                    } else if (str2 instanceof Integer) {
                        this.bundle.putIntegerArrayList(str, arrayList);
                    } else if (str2 instanceof Parcelable) {
                        this.bundle.putParcelableArrayList(str, arrayList);
                    }
                }
            } else if (obj instanceof SparseArray) {
                this.bundle.putSparseParcelableArray(str, (SparseArray) obj);
            } else if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Boolean.TYPE) {
                    this.bundle.putBooleanArray(str, (boolean[]) obj);
                } else if (componentType == Byte.TYPE) {
                    this.bundle.putByteArray(str, (byte[]) obj);
                } else if (componentType == Character.TYPE) {
                    this.bundle.putCharArray(str, (char[]) obj);
                } else if (componentType == Double.TYPE) {
                    this.bundle.putDoubleArray(str, (double[]) obj);
                } else if (componentType == Float.TYPE) {
                    this.bundle.putFloatArray(str, (float[]) obj);
                } else if (componentType == Integer.TYPE) {
                    this.bundle.putIntArray(str, (int[]) obj);
                } else if (componentType == Long.TYPE) {
                    this.bundle.putLongArray(str, (long[]) obj);
                } else if (componentType == Short.TYPE) {
                    this.bundle.putShortArray(str, (short[]) obj);
                } else if (componentType == String.class) {
                    this.bundle.putStringArray(str, (String[]) obj);
                } else if (yc.e(componentType, Parcelable.class)) {
                    this.bundle.putParcelableArray(str, (Parcelable[]) obj);
                }
            } else if (obj instanceof CharSequence) {
                this.bundle.putCharSequence(str, (CharSequence) obj);
            } else if (!(obj instanceof IBinder)) {
                if (obj instanceof Parcelable) {
                    this.bundle.putParcelable(str, (Parcelable) obj);
                } else if (obj instanceof Serializable) {
                    this.bundle.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }
}
