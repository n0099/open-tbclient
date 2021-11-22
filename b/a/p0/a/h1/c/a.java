package b.a.p0.a.h1.c;

import android.annotation.SuppressLint;
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
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6213e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f6214a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f6215b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f6216c;

    /* renamed from: d  reason: collision with root package name */
    public b f6217d;

    /* renamed from: b.a.p0.a.h1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0263a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f6218a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f6219b;

        /* renamed from: c  reason: collision with root package name */
        public RuntimeException f6220c;

        public C0263a() {
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
        public C0263a a(@NonNull List<b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                if (list.contains(null)) {
                    this.f6220c = new IllegalArgumentException("branches contains null value");
                    if (!a.f6213e) {
                        this.f6219b = null;
                        return this;
                    }
                    throw this.f6220c;
                }
                for (b bVar : list) {
                    if (bVar.c() + 0 > 100) {
                        this.f6220c = new IllegalArgumentException("The sum of all flow in the branch must be in [0,100]");
                        if (!a.f6213e) {
                            this.f6219b = null;
                            return this;
                        }
                        throw this.f6220c;
                    }
                }
                this.f6219b = Collections.unmodifiableList(list);
                return this;
            }
            return (C0263a) invokeL.objValue;
        }

        @Nullable
        @SuppressLint({"BDThrowableCheck"})
        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f6220c != null) {
                    if (a.f6213e) {
                        throw this.f6220c;
                    }
                    return null;
                } else if (this.f6218a == null) {
                    this.f6220c = new IllegalStateException("testSwitch == null");
                    if (a.f6213e) {
                        throw this.f6220c;
                    }
                    return null;
                } else {
                    List<b> list = this.f6219b;
                    if (list == null) {
                        this.f6220c = new IllegalStateException("branches == null");
                        if (a.f6213e) {
                            throw this.f6220c;
                        }
                        return null;
                    }
                    for (b bVar : list) {
                        if (!c.c(this.f6218a.f(), bVar.f6227e)) {
                            this.f6220c = new IllegalStateException("branch valueType error");
                            if (a.f6213e) {
                                throw this.f6220c;
                            }
                            return null;
                        }
                    }
                    return new a(this);
                }
            }
            return (a) invokeV.objValue;
        }

        public C0263a c(@NonNull c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.f6218a = cVar;
                return this;
            }
            return (C0263a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1625912822, "Lb/a/p0/a/h1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1625912822, "Lb/a/p0/a/h1/c/a;");
                return;
            }
        }
        f6213e = k.f6863a;
    }

    public a(C0263a c0263a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0263a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6216c = Boolean.FALSE;
        this.f6214a = c0263a.f6218a;
        this.f6215b = c0263a.f6219b;
    }

    @Nullable
    public synchronized b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f6216c.booleanValue()) {
                    return this.f6217d;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() % 100);
                this.f6216c = Boolean.TRUE;
                for (int i2 = 0; i2 < this.f6215b.size(); i2++) {
                    b bVar = this.f6215b.get(i2);
                    currentTimeMillis -= bVar.c();
                    if (currentTimeMillis < 0) {
                        this.f6217d = bVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6214a : (c) invokeV.objValue;
    }
}
