package b.a.p0.a.h1.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
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
    public static final boolean f6221f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f6222g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f6223a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6224b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6225c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6226d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f6227e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6228a;

        /* renamed from: b  reason: collision with root package name */
        public int f6229b;

        /* renamed from: c  reason: collision with root package name */
        public int f6230c;

        /* renamed from: d  reason: collision with root package name */
        public String f6231d;

        /* renamed from: e  reason: collision with root package name */
        public Object f6232e;

        /* renamed from: f  reason: collision with root package name */
        public RuntimeException f6233f;

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
                if (this.f6233f != null) {
                    if (b.f6221f) {
                        throw this.f6233f;
                    }
                    return null;
                } else if (this.f6228a == null) {
                    this.f6233f = new IllegalStateException("sid == null");
                    if (b.f6221f) {
                        throw this.f6233f;
                    }
                    return null;
                } else {
                    synchronized (a.class) {
                        if (b.f6222g.contains(this.f6228a)) {
                            this.f6233f = new IllegalStateException("sid has been occupied");
                            if (b.f6221f) {
                                throw this.f6233f;
                            }
                            return null;
                        } else if (this.f6232e != null) {
                            b.f6222g.add(this.f6228a);
                            return new b(this);
                        } else {
                            this.f6233f = new IllegalStateException("switchValue == null");
                            if (b.f6221f) {
                                throw this.f6233f;
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
                this.f6231d = str;
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
                    this.f6230c = i2;
                    return this;
                }
                this.f6233f = new IllegalArgumentException("flow must in [0, 100]");
                if (!b.f6221f) {
                    this.f6230c = 0;
                    return this;
                }
                throw this.f6233f;
            }
            return (a) invokeI.objValue;
        }

        public Exception d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6233f : (Exception) invokeV.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public a e(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f6233f = new IllegalArgumentException("sid must not be empty");
                    if (!b.f6221f) {
                        this.f6228a = null;
                        return this;
                    }
                    throw this.f6233f;
                } else if (str.contains("-")) {
                    this.f6233f = new IllegalArgumentException("sid must not contain '-'");
                    if (!b.f6221f) {
                        this.f6228a = null;
                        return this;
                    }
                    throw this.f6233f;
                } else {
                    this.f6228a = str;
                    return this;
                }
            }
            return (a) invokeL.objValue;
        }

        public a f(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                this.f6232e = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f6229b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1625912853, "Lb/a/p0/a/h1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1625912853, "Lb/a/p0/a/h1/c/b;");
                return;
            }
        }
        f6221f = k.f6863a;
        f6222g = new HashSet();
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
        this.f6223a = aVar.f6228a;
        this.f6224b = aVar.f6229b;
        this.f6225c = aVar.f6230c;
        this.f6226d = aVar.f6231d;
        this.f6227e = aVar.f6232e;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6225c : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6223a : (String) invokeV.objValue;
    }

    @NonNull
    public Object e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6227e : invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f6221f) {
                return "SwanLocalABTestBranch{mGroupType=" + this.f6224b + ", mFlow=" + this.f6225c + ", mBranchDescription='" + this.f6226d + ExtendedMessageFormat.QUOTE + ", mSwitchValue=" + this.f6227e + ExtendedMessageFormat.END_FE;
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
