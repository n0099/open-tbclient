package c.a.n0.a.x0.c;

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
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7516f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f7517g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7518b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7519c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7520d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f7521e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f7522b;

        /* renamed from: c  reason: collision with root package name */
        public int f7523c;

        /* renamed from: d  reason: collision with root package name */
        public String f7524d;

        /* renamed from: e  reason: collision with root package name */
        public Object f7525e;

        /* renamed from: f  reason: collision with root package name */
        public RuntimeException f7526f;

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
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f7526f != null) {
                    if (b.f7516f) {
                        throw this.f7526f;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f7526f = new IllegalStateException("sid == null");
                    if (b.f7516f) {
                        throw this.f7526f;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (b.f7517g.contains(this.a)) {
                            this.f7526f = new IllegalStateException("sid has been occupied");
                            if (b.f7516f) {
                                throw this.f7526f;
                            }
                            return null;
                        } else if (this.f7525e != null) {
                            b.f7517g.add(this.a);
                            return new b(this);
                        } else {
                            this.f7526f = new IllegalStateException("switchValue == null");
                            if (b.f7516f) {
                                throw this.f7526f;
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
                this.f7524d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i >= 0 && i <= 100) {
                    this.f7523c = i;
                    return this;
                }
                this.f7526f = new IllegalArgumentException("flow must in [0, 100]");
                if (!b.f7516f) {
                    this.f7523c = 0;
                    return this;
                }
                throw this.f7526f;
            }
            return (a) invokeI.objValue;
        }

        public Exception d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7526f : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a e(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f7526f = new IllegalArgumentException("sid must not be empty");
                    if (!b.f7516f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7526f;
                } else if (str.contains("-")) {
                    this.f7526f = new IllegalArgumentException("sid must not contain '-'");
                    if (!b.f7516f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f7526f;
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
                this.f7525e = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.f7522b = i;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2143741095, "Lc/a/n0/a/x0/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2143741095, "Lc/a/n0/a/x0/c/b;");
                return;
            }
        }
        f7516f = c.a.n0.a.a.a;
        f7517g = new HashSet();
    }

    public b(a aVar) {
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
        this.f7518b = aVar.f7522b;
        this.f7519c = aVar.f7523c;
        this.f7520d = aVar.f7524d;
        this.f7521e = aVar.f7525e;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7519c : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7521e : invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f7516f) {
                return "SwanLocalABTestBranch{mGroupType=" + this.f7518b + ", mFlow=" + this.f7519c + ", mBranchDescription='" + this.f7520d + "', mSwitchValue=" + this.f7521e + '}';
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
