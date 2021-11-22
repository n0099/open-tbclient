package b.a.p0.a.h1.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
    public static final boolean f6234d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f6235e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f6236a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6237b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6238c;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6239a;

        /* renamed from: b  reason: collision with root package name */
        public Object f6240b;

        /* renamed from: c  reason: collision with root package name */
        public int f6241c;

        /* renamed from: d  reason: collision with root package name */
        public RuntimeException f6242d;

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
                if (this.f6242d != null) {
                    if (c.f6234d) {
                        throw this.f6242d;
                    }
                    return null;
                } else if (this.f6239a == null) {
                    this.f6242d = new IllegalStateException("key == null");
                    if (c.f6234d) {
                        throw this.f6242d;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (c.f6235e.contains(this.f6239a)) {
                            this.f6242d = new IllegalStateException("the key of switch has been occupied");
                            if (c.f6234d) {
                                throw this.f6242d;
                            }
                            return null;
                        } else if (this.f6240b == null) {
                            this.f6242d = new IllegalStateException("defaultValue == null");
                            if (c.f6234d) {
                                throw this.f6242d;
                            }
                            return null;
                        } else if (c.c(this.f6241c, this.f6240b)) {
                            c.f6235e.add(this.f6239a);
                            return new c(this);
                        } else {
                            this.f6242d = new IllegalStateException("valueType error");
                            if (c.f6234d) {
                                throw this.f6242d;
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
                this.f6240b = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public Exception c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6242d : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a d(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f6242d = new IllegalArgumentException("the key of switch must not be empty");
                    if (!c.f6234d) {
                        this.f6239a = null;
                        return this;
                    }
                    throw this.f6242d;
                } else if (TextUtils.equals(Config.SID, str)) {
                    this.f6242d = new IllegalArgumentException("sid must not equal \"sids\"");
                    if (!c.f6234d) {
                        this.f6239a = null;
                        return this;
                    }
                    throw this.f6242d;
                } else {
                    this.f6239a = str;
                    return this;
                }
            }
            return (a) invokeL.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f6241c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1625912884, "Lb/a/p0/a/h1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1625912884, "Lb/a/p0/a/h1/c/c;");
                return;
            }
        }
        f6234d = k.f6863a;
        f6235e = new HashSet();
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
        this.f6236a = aVar.f6239a;
        this.f6237b = aVar.f6240b;
        this.f6238c = aVar.f6241c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6237b : invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6236a : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6238c : invokeV.intValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f6234d) {
                return "SwanLocalABTestSwitch{key='" + this.f6236a + ExtendedMessageFormat.QUOTE + ", defaultValue=" + this.f6237b + ", valueType=" + this.f6238c + ExtendedMessageFormat.END_FE;
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
