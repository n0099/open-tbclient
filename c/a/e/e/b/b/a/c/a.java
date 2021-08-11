package c.a.e.e.b.b.a.c;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
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
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f2090a;

    public a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2090a = bundle;
    }

    @Override // c.a.e.e.b.b.a.c.c
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2090a.keySet() : (Set) invokeV.objValue;
    }

    @Override // c.a.e.e.b.b.a.c.c
    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (obj instanceof Boolean) {
                this.f2090a.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                this.f2090a.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof Short) {
                this.f2090a.putShort(str, ((Short) obj).shortValue());
            } else if (obj instanceof Integer) {
                this.f2090a.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Character) {
                this.f2090a.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Long) {
                this.f2090a.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                this.f2090a.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                this.f2090a.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                this.f2090a.putString(str, (String) obj);
            } else if (obj instanceof Bundle) {
                this.f2090a.putBundle(str, (Bundle) obj);
            } else if (obj instanceof ArrayList) {
                ArrayList<String> arrayList = (ArrayList) obj;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                String str2 = arrayList.get(0);
                if (str2 instanceof String) {
                    this.f2090a.putStringArrayList(str, arrayList);
                } else if (str2 instanceof Integer) {
                    this.f2090a.putIntegerArrayList(str, arrayList);
                } else if (str2 instanceof Parcelable) {
                    this.f2090a.putParcelableArrayList(str, arrayList);
                }
            } else if (obj instanceof SparseArray) {
                this.f2090a.putSparseParcelableArray(str, (SparseArray) obj);
            } else if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Boolean.TYPE) {
                    this.f2090a.putBooleanArray(str, (boolean[]) obj);
                } else if (componentType == Byte.TYPE) {
                    this.f2090a.putByteArray(str, (byte[]) obj);
                } else if (componentType == Character.TYPE) {
                    this.f2090a.putCharArray(str, (char[]) obj);
                } else if (componentType == Double.TYPE) {
                    this.f2090a.putDoubleArray(str, (double[]) obj);
                } else if (componentType == Float.TYPE) {
                    this.f2090a.putFloatArray(str, (float[]) obj);
                } else if (componentType == Integer.TYPE) {
                    this.f2090a.putIntArray(str, (int[]) obj);
                } else if (componentType == Long.TYPE) {
                    this.f2090a.putLongArray(str, (long[]) obj);
                } else if (componentType == Short.TYPE) {
                    this.f2090a.putShortArray(str, (short[]) obj);
                } else if (componentType == String.class) {
                    this.f2090a.putStringArray(str, (String[]) obj);
                } else if (c.a.e.e.b.a.a.e(componentType, Parcelable.class)) {
                    this.f2090a.putParcelableArray(str, (Parcelable[]) obj);
                }
            } else if (obj instanceof CharSequence) {
                this.f2090a.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof IBinder) {
            } else {
                if (obj instanceof Parcelable) {
                    this.f2090a.putParcelable(str, (Parcelable) obj);
                } else if (obj instanceof Serializable) {
                    this.f2090a.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }

    @Override // c.a.e.e.b.b.a.c.c
    public Object c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object d2 = d(str);
            if (d2 != null) {
                c.a.e.e.b.b.a.e.c cVar = new c.a.e.e.b.b.a.e.c(type);
                c.a.e.e.b.b.a.d.h a2 = c.a.e.e.b.b.a.e.g.a(d2);
                if (a2 != null) {
                    return a2.a(cVar);
                }
                return null;
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public Object d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f2090a.get(str) : invokeL.objValue;
    }
}
