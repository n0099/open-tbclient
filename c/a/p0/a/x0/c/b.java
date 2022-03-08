package c.a.p0.a.x0.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8946f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f8947g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8948b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8949c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8950d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f8951e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f8952b;

        /* renamed from: c  reason: collision with root package name */
        public int f8953c;

        /* renamed from: d  reason: collision with root package name */
        public String f8954d;

        /* renamed from: e  reason: collision with root package name */
        public Object f8955e;

        /* renamed from: f  reason: collision with root package name */
        public RuntimeException f8956f;

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
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f8956f != null) {
                    if (b.f8946f) {
                        throw this.f8956f;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f8956f = new IllegalStateException("sid == null");
                    if (b.f8946f) {
                        throw this.f8956f;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (b.f8947g.contains(this.a)) {
                            this.f8956f = new IllegalStateException("sid has been occupied");
                            if (b.f8946f) {
                                throw this.f8956f;
                            }
                            return null;
                        } else if (this.f8955e != null) {
                            b.f8947g.add(this.a);
                            return new b(this);
                        } else {
                            this.f8956f = new IllegalStateException("switchValue == null");
                            if (b.f8946f) {
                                throw this.f8956f;
                            }
                            return null;
                        }
                    }
                }
            }
            return (b) invokeV.objValue;
        }

        public a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f8954d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 >= 0 && i2 <= 100) {
                    this.f8953c = i2;
                    return this;
                }
                this.f8956f = new IllegalArgumentException("flow must in [0, 100]");
                if (!b.f8946f) {
                    this.f8953c = 0;
                    return this;
                }
                throw this.f8956f;
            }
            return (a) invokeI.objValue;
        }

        public Exception d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8956f : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a e(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f8956f = new IllegalArgumentException("sid must not be empty");
                    if (!b.f8946f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f8956f;
                } else if (str.contains("-")) {
                    this.f8956f = new IllegalArgumentException("sid must not contain '-'");
                    if (!b.f8946f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f8956f;
                } else {
                    this.a = str;
                    return this;
                }
            }
            return (a) invokeL.objValue;
        }

        public a f(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                this.f8955e = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f8952b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1893060763, "Lc/a/p0/a/x0/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1893060763, "Lc/a/p0/a/x0/c/b;");
                return;
            }
        }
        f8946f = c.a.p0.a.a.a;
        f8947g = new HashSet();
    }

    public b(a aVar) {
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
        this.f8948b = aVar.f8952b;
        this.f8949c = aVar.f8953c;
        this.f8950d = aVar.f8954d;
        this.f8951e = aVar.f8955e;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8949c : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @NonNull
    public Object e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8951e : invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f8946f) {
                return "SwanLocalABTestBranch{mGroupType=" + this.f8948b + ", mFlow=" + this.f8949c + ", mBranchDescription='" + this.f8950d + ExtendedMessageFormat.QUOTE + ", mSwitchValue=" + this.f8951e + ExtendedMessageFormat.END_FE;
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
