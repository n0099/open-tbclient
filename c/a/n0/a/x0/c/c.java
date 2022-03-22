package c.a.n0.a.x0.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7527d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f7528e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7529b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7530c;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Object f7531b;

        /* renamed from: c  reason: collision with root package name */
        public int f7532c;

        /* renamed from: d  reason: collision with root package name */
        public RuntimeException f7533d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.f7533d != null) {
                    if (c.f7527d) {
                        throw this.f7533d;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f7533d = new IllegalStateException("key == null");
                    if (c.f7527d) {
                        throw this.f7533d;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (c.f7528e.contains(this.a)) {
                            this.f7533d = new IllegalStateException("the key of switch has been occupied");
                            if (c.f7527d) {
                                throw this.f7533d;
                            }
                            return null;
                        } else if (this.f7531b == null) {
                            this.f7533d = new IllegalStateException("defaultValue == null");
                            if (c.f7527d) {
                                throw this.f7533d;
                            }
                            return null;
                        } else if (c.c(this.f7532c, this.f7531b)) {
                            c.f7528e.add(this.a);
                            return new c(this);
                        } else {
                            this.f7533d = new IllegalStateException("valueType error");
                            if (c.f7527d) {
                                throw this.f7533d;
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
                this.f7531b = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public Exception c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7533d : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a d(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f7533d = new IllegalArgumentException("the key of switch must not be empty");
                    if (!c.f7527d) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7533d;
                } else if (TextUtils.equals("sids", str)) {
                    this.f7533d = new IllegalArgumentException("sid must not equal \"sids\"");
                    if (!c.f7527d) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7533d;
                } else {
                    this.a = str;
                    return this;
                }
            }
            return (a) invokeL.objValue;
        }

        public a e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.f7532c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2143741126, "Lc/a/n0/a/x0/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2143741126, "Lc/a/n0/a/x0/c/c;");
                return;
            }
        }
        f7527d = c.a.n0.a.a.a;
        f7528e = new HashSet();
    }

    public c(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = aVar.a;
        this.f7529b = aVar.f7531b;
        this.f7530c = aVar.f7532c;
    }

    public static boolean c(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, obj)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7529b : invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7530c : invokeV.intValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f7527d) {
                return "SwanLocalABTestSwitch{key='" + this.a + "', defaultValue=" + this.f7529b + ", valueType=" + this.f7530c + '}';
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
