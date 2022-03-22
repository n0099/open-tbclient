package c.a.n0.a.x0.c;

import android.annotation.SuppressLint;
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
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7510e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f7511b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f7512c;

    /* renamed from: d  reason: collision with root package name */
    public b f7513d;

    /* renamed from: c.a.n0.a.x0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0578a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f7514b;

        /* renamed from: c  reason: collision with root package name */
        public RuntimeException f7515c;

        public C0578a() {
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

        @SuppressLint({"BDThrowableCheck"})
        public C0578a a(@NonNull List<b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                if (list.contains(null)) {
                    this.f7515c = new IllegalArgumentException("branches contains null value");
                    if (!a.f7510e) {
                        this.f7514b = null;
                        return this;
                    }
                    throw this.f7515c;
                }
                for (b bVar : list) {
                    if (bVar.c() + 0 > 100) {
                        this.f7515c = new IllegalArgumentException("The sum of all flow in the branch must be in [0,100]");
                        if (!a.f7510e) {
                            this.f7514b = null;
                            return this;
                        }
                        throw this.f7515c;
                    }
                }
                this.f7514b = Collections.unmodifiableList(list);
                return this;
            }
            return (C0578a) invokeL.objValue;
        }

        @Nullable
        @SuppressLint({"BDThrowableCheck"})
        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f7515c != null) {
                    if (a.f7510e) {
                        throw this.f7515c;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f7515c = new IllegalStateException("testSwitch == null");
                    if (a.f7510e) {
                        throw this.f7515c;
                    }
                    return null;
                } else {
                    List<b> list = this.f7514b;
                    if (list == null) {
                        this.f7515c = new IllegalStateException("branches == null");
                        if (a.f7510e) {
                            throw this.f7515c;
                        }
                        return null;
                    }
                    for (b bVar : list) {
                        if (!c.c(this.a.f(), bVar.f7521e)) {
                            this.f7515c = new IllegalStateException("branch valueType error");
                            if (a.f7510e) {
                                throw this.f7515c;
                            }
                            return null;
                        }
                    }
                    return new a(this);
                }
            }
            return (a) invokeV.objValue;
        }

        public C0578a c(@NonNull c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.a = cVar;
                return this;
            }
            return (C0578a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2143741064, "Lc/a/n0/a/x0/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2143741064, "Lc/a/n0/a/x0/c/a;");
                return;
            }
        }
        f7510e = c.a.n0.a.a.a;
    }

    public a(C0578a c0578a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0578a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7512c = Boolean.FALSE;
        this.a = c0578a.a;
        this.f7511b = c0578a.f7514b;
    }

    @Nullable
    public synchronized b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f7512c.booleanValue()) {
                    return this.f7513d;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() % 100);
                this.f7512c = Boolean.TRUE;
                for (int i = 0; i < this.f7511b.size(); i++) {
                    b bVar = this.f7511b.get(i);
                    currentTimeMillis -= bVar.c();
                    if (currentTimeMillis < 0) {
                        this.f7513d = bVar;
                        return bVar;
                    }
                }
                return null;
            }
        }
        return (b) invokeV.objValue;
    }

    @NonNull
    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c) invokeV.objValue;
    }
}
