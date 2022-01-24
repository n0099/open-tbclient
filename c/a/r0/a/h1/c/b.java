package c.a.r0.a.h1.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.k;
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
    public static final boolean f7113f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f7114g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7115b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7116c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7117d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f7118e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f7119b;

        /* renamed from: c  reason: collision with root package name */
        public int f7120c;

        /* renamed from: d  reason: collision with root package name */
        public String f7121d;

        /* renamed from: e  reason: collision with root package name */
        public Object f7122e;

        /* renamed from: f  reason: collision with root package name */
        public RuntimeException f7123f;

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
                if (this.f7123f != null) {
                    if (b.f7113f) {
                        throw this.f7123f;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f7123f = new IllegalStateException("sid == null");
                    if (b.f7113f) {
                        throw this.f7123f;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (b.f7114g.contains(this.a)) {
                            this.f7123f = new IllegalStateException("sid has been occupied");
                            if (b.f7113f) {
                                throw this.f7123f;
                            }
                            return null;
                        } else if (this.f7122e != null) {
                            b.f7114g.add(this.a);
                            return new b(this);
                        } else {
                            this.f7123f = new IllegalStateException("switchValue == null");
                            if (b.f7113f) {
                                throw this.f7123f;
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
                this.f7121d = str;
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
                    this.f7120c = i2;
                    return this;
                }
                this.f7123f = new IllegalArgumentException("flow must in [0, 100]");
                if (!b.f7113f) {
                    this.f7120c = 0;
                    return this;
                }
                throw this.f7123f;
            }
            return (a) invokeI.objValue;
        }

        public Exception d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7123f : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a e(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f7123f = new IllegalArgumentException("sid must not be empty");
                    if (!b.f7113f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7123f;
                } else if (str.contains("-")) {
                    this.f7123f = new IllegalArgumentException("sid must not contain '-'");
                    if (!b.f7113f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7123f;
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
                this.f7122e = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f7119b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1373544114, "Lc/a/r0/a/h1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1373544114, "Lc/a/r0/a/h1/c/b;");
                return;
            }
        }
        f7113f = k.a;
        f7114g = new HashSet();
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
        this.f7115b = aVar.f7119b;
        this.f7116c = aVar.f7120c;
        this.f7117d = aVar.f7121d;
        this.f7118e = aVar.f7122e;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7116c : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7118e : invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f7113f) {
                return "SwanLocalABTestBranch{mGroupType=" + this.f7115b + ", mFlow=" + this.f7116c + ", mBranchDescription='" + this.f7117d + ExtendedMessageFormat.QUOTE + ", mSwitchValue=" + this.f7118e + ExtendedMessageFormat.END_FE;
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
