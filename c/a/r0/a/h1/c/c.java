package c.a.r0.a.h1.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7135d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f7136e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7137b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7138c;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Object f7139b;

        /* renamed from: c  reason: collision with root package name */
        public int f7140c;

        /* renamed from: d  reason: collision with root package name */
        public RuntimeException f7141d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Nullable
        @SuppressLint({"BDThrowableCheck"})
        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f7141d != null) {
                    if (c.f7135d) {
                        throw this.f7141d;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f7141d = new IllegalStateException("key == null");
                    if (c.f7135d) {
                        throw this.f7141d;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (c.f7136e.contains(this.a)) {
                            this.f7141d = new IllegalStateException("the key of switch has been occupied");
                            if (c.f7135d) {
                                throw this.f7141d;
                            }
                            return null;
                        } else if (this.f7139b == null) {
                            this.f7141d = new IllegalStateException("defaultValue == null");
                            if (c.f7135d) {
                                throw this.f7141d;
                            }
                            return null;
                        } else if (c.c(this.f7140c, this.f7139b)) {
                            c.f7136e.add(this.a);
                            return new c(this);
                        } else {
                            this.f7141d = new IllegalStateException("valueType error");
                            if (c.f7135d) {
                                throw this.f7141d;
                            }
                            return null;
                        }
                    }
                }
            }
            return (c) invokeV.objValue;
        }

        public a b(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                this.f7139b = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public Exception c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7141d : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a d(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f7141d = new IllegalArgumentException("the key of switch must not be empty");
                    if (!c.f7135d) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7141d;
                } else if (TextUtils.equals(Config.SID, str)) {
                    this.f7141d = new IllegalArgumentException("sid must not equal \"sids\"");
                    if (!c.f7135d) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7141d;
                } else {
                    this.a = str;
                    return this;
                }
            }
            return (a) invokeL.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f7140c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1373544145, "Lc/a/r0/a/h1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1373544145, "Lc/a/r0/a/h1/c/c;");
                return;
            }
        }
        f7135d = k.a;
        f7136e = new HashSet();
    }

    public c(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = aVar.a;
        this.f7137b = aVar.f7139b;
        this.f7138c = aVar.f7140c;
    }

    public static boolean c(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, obj)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                return false;
                            }
                            return obj instanceof String;
                        }
                        return obj instanceof Long;
                    }
                    return obj instanceof Integer;
                }
                return obj instanceof Double;
            }
            return obj instanceof Boolean;
        }
        return invokeIL.booleanValue;
    }

    public Object d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7137b : invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7138c : invokeV.intValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f7135d) {
                return "SwanLocalABTestSwitch{key='" + this.a + ExtendedMessageFormat.QUOTE + ", defaultValue=" + this.f7137b + ", valueType=" + this.f7138c + ExtendedMessageFormat.END_FE;
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
