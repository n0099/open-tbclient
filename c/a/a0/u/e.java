package c.a.a0.u;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static m a;

    /* renamed from: b  reason: collision with root package name */
    public static m f1615b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1457559626, "Lc/a/a0/u/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1457559626, "Lc/a/a0/u/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static m a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f1615b == null) {
                synchronized (e.class) {
                    if (f1615b == null) {
                        if (a == null) {
                            a = (m) ServiceManager.getService(m.a);
                        }
                        f1615b = a;
                    }
                    if (f1615b != null) {
                        return f1615b;
                    }
                    if (TextUtils.equals("okhttp", "mixed")) {
                        f1615b = b.b().a("okhttp");
                    } else {
                        f1615b = c.a;
                    }
                }
            }
            return f1615b;
        }
        return (m) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k a;

        /* renamed from: b  reason: collision with root package name */
        public k f1616b;

        /* loaded from: classes.dex */
        public class a implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ k f1617b;

            public a(b bVar, k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1617b = kVar;
            }

            @Override // c.a.a0.u.m
            public k a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1617b : (k) invokeV.objValue;
            }
        }

        /* renamed from: c.a.a0.u.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0067b {
            public static /* synthetic */ Interceptable $ic;
            public static final b a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1204840014, "Lc/a/a0/u/e$b$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1204840014, "Lc/a/a0/u/e$b$b;");
                        return;
                    }
                }
                a = new b(null);
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f1616b = null;
        }

        public static b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0067b.a : (b) invokeV.objValue;
        }

        public m a(String str) {
            InterceptResult invokeL;
            char c2;
            k kVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode != -1015101340) {
                    if (hashCode == 1544803905 && str.equals("default")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("okhttp")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    if (this.a == null) {
                        synchronized (e.class) {
                            if (this.a == null) {
                                this.a = c.a.b(str);
                            }
                        }
                    }
                    kVar = this.a;
                } else if (c2 == 1) {
                    if (this.f1616b == null) {
                        synchronized (e.class) {
                            if (this.f1616b == null) {
                                this.f1616b = c.a.b(str);
                            }
                        }
                    }
                    kVar = this.f1616b;
                } else {
                    throw new IllegalStateException("Unexpected type:" + str);
                }
                return new a(this, kVar);
            }
            return (m) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
