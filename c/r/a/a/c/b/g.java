package c.r.a.a.c.b;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Context f35580c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Class f35581a;

    /* renamed from: b  reason: collision with root package name */
    public i f35582b;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35581a = g();
        this.f35582b = new i(this);
    }

    public /* synthetic */ g(byte b2) {
        this();
    }

    public static g d(Context context) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            f35580c = context;
            gVar = h.f35583a;
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public static Class g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            try {
                return Class.forName("android.os.ServiceManager");
            } catch (ClassNotFoundException e2) {
                c.c(e2);
                return null;
            }
        }
        return (Class) invokeV.objValue;
    }

    public final Parcel c(String str, String str2, Parcel parcel, Parcel parcel2) {
        InterceptResult invokeLLLL;
        Object obj;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, parcel, parcel2)) == null) {
            String f2 = f(str);
            if (f2 != null && str2 != null) {
                try {
                    obj = this.f35581a.getDeclaredMethod("getService", String.class).invoke(null, str);
                    try {
                        Field declaredField = Class.forName(f2 + "$Stub").getDeclaredField(str2);
                        declaredField.setAccessible(true);
                        i2 = declaredField.getInt(null);
                    } catch (Throwable th) {
                        th = th;
                        c.c(th);
                        i2 = -1;
                        if (obj != null) {
                            try {
                                ((IBinder) obj).transact(i2, parcel, parcel2, 0);
                            } catch (Throwable th2) {
                                c.c(th2);
                            }
                            return parcel2;
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = null;
                }
                if (obj != null && i2 >= 0) {
                    ((IBinder) obj).transact(i2, parcel, parcel2, 0);
                    return parcel2;
                }
            }
            return null;
        }
        return (Parcel) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str2 = null;
            try {
                ((IBinder) this.f35581a.getDeclaredMethod("getService", String.class).invoke(null, str)).transact(1598968902, obtain, obtain2, 0);
                str2 = obtain2.readString();
            } finally {
                try {
                    return str2;
                } finally {
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
