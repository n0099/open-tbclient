package c.a.p0.a.h1.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.k;
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
    public static final boolean f6080f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f6081g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6082b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6083c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6084d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f6085e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f6086b;

        /* renamed from: c  reason: collision with root package name */
        public int f6087c;

        /* renamed from: d  reason: collision with root package name */
        public String f6088d;

        /* renamed from: e  reason: collision with root package name */
        public Object f6089e;

        /* renamed from: f  reason: collision with root package name */
        public RuntimeException f6090f;

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
                if (this.f6090f != null) {
                    if (b.f6080f) {
                        throw this.f6090f;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f6090f = new IllegalStateException("sid == null");
                    if (b.f6080f) {
                        throw this.f6090f;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (b.f6081g.contains(this.a)) {
                            this.f6090f = new IllegalStateException("sid has been occupied");
                            if (b.f6080f) {
                                throw this.f6090f;
                            }
                            return null;
                        } else if (this.f6089e != null) {
                            b.f6081g.add(this.a);
                            return new b(this);
                        } else {
                            this.f6090f = new IllegalStateException("switchValue == null");
                            if (b.f6080f) {
                                throw this.f6090f;
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
                this.f6088d = str;
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
                    this.f6087c = i2;
                    return this;
                }
                this.f6090f = new IllegalArgumentException("flow must in [0, 100]");
                if (!b.f6080f) {
                    this.f6087c = 0;
                    return this;
                }
                throw this.f6090f;
            }
            return (a) invokeI.objValue;
        }

        public Exception d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6090f : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a e(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f6090f = new IllegalArgumentException("sid must not be empty");
                    if (!b.f6080f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f6090f;
                } else if (str.contains("-")) {
                    this.f6090f = new IllegalArgumentException("sid must not contain '-'");
                    if (!b.f6080f) {
                        this.a = null;
                        return this;
                    }
                    throw this.f6090f;
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
                this.f6089e = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f6086b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1115378676, "Lc/a/p0/a/h1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1115378676, "Lc/a/p0/a/h1/c/b;");
                return;
            }
        }
        f6080f = k.a;
        f6081g = new HashSet();
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
        this.f6082b = aVar.f6086b;
        this.f6083c = aVar.f6087c;
        this.f6084d = aVar.f6088d;
        this.f6085e = aVar.f6089e;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6083c : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6085e : invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f6080f) {
                return "SwanLocalABTestBranch{mGroupType=" + this.f6082b + ", mFlow=" + this.f6083c + ", mBranchDescription='" + this.f6084d + ExtendedMessageFormat.QUOTE + ", mSwitchValue=" + this.f6085e + ExtendedMessageFormat.END_FE;
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
