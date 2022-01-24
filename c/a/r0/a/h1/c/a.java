package c.a.r0.a.h1.c;

import android.annotation.SuppressLint;
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
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7107e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f7108b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f7109c;

    /* renamed from: d  reason: collision with root package name */
    public b f7110d;

    /* renamed from: c.a.r0.a.h1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0421a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f7111b;

        /* renamed from: c  reason: collision with root package name */
        public RuntimeException f7112c;

        public C0421a() {
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

        @SuppressLint({"BDThrowableCheck"})
        public C0421a a(@NonNull List<b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                if (list.contains(null)) {
                    this.f7112c = new IllegalArgumentException("branches contains null value");
                    if (!a.f7107e) {
                        this.f7111b = null;
                        return this;
                    }
                    throw this.f7112c;
                }
                for (b bVar : list) {
                    if (bVar.c() + 0 > 100) {
                        this.f7112c = new IllegalArgumentException("The sum of all flow in the branch must be in [0,100]");
                        if (!a.f7107e) {
                            this.f7111b = null;
                            return this;
                        }
                        throw this.f7112c;
                    }
                }
                this.f7111b = Collections.unmodifiableList(list);
                return this;
            }
            return (C0421a) invokeL.objValue;
        }

        @Nullable
        @SuppressLint({"BDThrowableCheck"})
        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f7112c != null) {
                    if (a.f7107e) {
                        throw this.f7112c;
                    }
                    return null;
                } else if (this.a == null) {
                    this.f7112c = new IllegalStateException("testSwitch == null");
                    if (a.f7107e) {
                        throw this.f7112c;
                    }
                    return null;
                } else {
                    List<b> list = this.f7111b;
                    if (list == null) {
                        this.f7112c = new IllegalStateException("branches == null");
                        if (a.f7107e) {
                            throw this.f7112c;
                        }
                        return null;
                    }
                    for (b bVar : list) {
                        if (!c.c(this.a.f(), bVar.f7118e)) {
                            this.f7112c = new IllegalStateException("branch valueType error");
                            if (a.f7107e) {
                                throw this.f7112c;
                            }
                            return null;
                        }
                    }
                    return new a(this);
                }
            }
            return (a) invokeV.objValue;
        }

        public C0421a c(@NonNull c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.a = cVar;
                return this;
            }
            return (C0421a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1373544083, "Lc/a/r0/a/h1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1373544083, "Lc/a/r0/a/h1/c/a;");
                return;
            }
        }
        f7107e = k.a;
    }

    public a(C0421a c0421a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0421a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7109c = Boolean.FALSE;
        this.a = c0421a.a;
        this.f7108b = c0421a.f7111b;
    }

    @Nullable
    public synchronized b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f7109c.booleanValue()) {
                    return this.f7110d;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() % 100);
                this.f7109c = Boolean.TRUE;
                for (int i2 = 0; i2 < this.f7108b.size(); i2++) {
                    b bVar = this.f7108b.get(i2);
                    currentTimeMillis -= bVar.c();
                    if (currentTimeMillis < 0) {
                        this.f7110d = bVar;
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
