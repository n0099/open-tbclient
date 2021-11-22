package b.a.p0.a0;

import android.text.TextUtils;
import b.a.p0.q.m.b;
import b.a.p0.w.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class b implements b.a.p0.q.m.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9901c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f9902d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f9903a;

    /* renamed from: b  reason: collision with root package name */
    public String f9904b;

    /* loaded from: classes.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9905a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f9906b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9907c;

        /* renamed from: b.a.p0.a0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0508a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f9908e;

            public RunnableC0508a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9908e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f9908e.f9907c;
                    bVar.j(bVar.f9904b);
                }
            }
        }

        public a(b bVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9907c = bVar;
            this.f9905a = str;
            this.f9906b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                boolean z = true;
                if (d.B(this.f9905a, str)) {
                    synchronized (b.f9902d) {
                        this.f9907c.i(true);
                    }
                    return;
                }
                if (b.e(this.f9907c) <= 2) {
                    if (8 == i2) {
                        this.f9907c.f9904b = this.f9905a;
                    } else {
                        b bVar = this.f9907c;
                        bVar.f9904b = this.f9905a + File.pathSeparator + this.f9907c.f9903a;
                        if (d.f(this.f9906b, new File(this.f9907c.f9904b)) != this.f9906b.length()) {
                            z = false;
                        }
                    }
                    if (z && b.a.p0.a.d2.d.L().postDelayed(new RunnableC0508a(this), 1000L)) {
                        return;
                    }
                }
                if (8 == i2) {
                    d.k(this.f9905a);
                }
                synchronized (b.f9902d) {
                    this.f9907c.i(false);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1835514575, "Lb/a/p0/a0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1835514575, "Lb/a/p0/a0/b;");
                return;
            }
        }
        f9902d = new HashSet();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9903a = 0;
    }

    public static /* synthetic */ int e(b bVar) {
        int i2 = bVar.f9903a + 1;
        bVar.f9903a = i2;
        return i2;
    }

    @Override // b.a.p0.q.m.b
    public void a(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            synchronized (f9902d) {
                f9902d.add(aVar);
                if (f9901c) {
                    return;
                }
                f9901c = true;
                j(str);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (f9902d) {
                for (b.a aVar : f9902d) {
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
                f9902d.clear();
                f9901c = false;
                this.f9903a = 0;
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                synchronized (f9902d) {
                    i(false);
                }
                return;
            }
            File file = new File(str);
            if (!file.isFile()) {
                synchronized (f9902d) {
                    i(false);
                }
                return;
            }
            WebKitFactory.installAsync("file://" + str, new a(this, str, file));
        }
    }
}
