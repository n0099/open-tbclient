package c.a.o0.w;

import android.text.TextUtils;
import c.a.o0.n.l.b;
import c.a.o0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
/* loaded from: classes3.dex */
public final class c implements c.a.o0.n.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f12457c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f12458d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12459a;

    /* renamed from: b  reason: collision with root package name */
    public String f12460b;

    /* loaded from: classes3.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f12461a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f12462b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f12463c;

        /* renamed from: c.a.o0.w.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0637a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f12464e;

            public RunnableC0637a(a aVar) {
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
                this.f12464e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f12464e.f12463c;
                    cVar.j(cVar.f12460b);
                }
            }
        }

        public a(c cVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12463c = cVar;
            this.f12461a = str;
            this.f12462b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (d.A(this.f12461a, str)) {
                    synchronized (c.f12458d) {
                        this.f12463c.i(new b(AppRuntime.getAppContext()).q());
                    }
                    return;
                }
                if (c.e(this.f12463c) <= 2) {
                    boolean z = true;
                    if (8 == i2) {
                        this.f12463c.f12460b = this.f12461a;
                    } else {
                        c cVar = this.f12463c;
                        cVar.f12460b = this.f12461a + File.pathSeparator + this.f12463c.f12459a;
                        if (d.f(this.f12462b, new File(this.f12463c.f12460b)) != this.f12462b.length()) {
                            z = false;
                        }
                    }
                    if (z && c.a.o0.a.a2.d.i().postDelayed(new RunnableC0637a(this), 1000L)) {
                        return;
                    }
                }
                if (8 == i2) {
                    d.j(this.f12461a);
                }
                synchronized (c.f12458d) {
                    this.f12463c.i(false);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997768792, "Lc/a/o0/w/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997768792, "Lc/a/o0/w/c;");
                return;
            }
        }
        f12458d = new HashSet();
    }

    public c() {
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
        this.f12459a = 0;
    }

    public static /* synthetic */ int e(c cVar) {
        int i2 = cVar.f12459a + 1;
        cVar.f12459a = i2;
        return i2;
    }

    @Override // c.a.o0.n.l.b
    public void a(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            synchronized (f12458d) {
                f12458d.add(aVar);
                if (f12457c) {
                    return;
                }
                f12457c = true;
                j(str);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (f12458d) {
                for (b.a aVar : f12458d) {
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
                f12458d.clear();
                f12457c = false;
                this.f12459a = 0;
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                synchronized (f12458d) {
                    i(false);
                }
                return;
            }
            File file = new File(str);
            if (!file.isFile()) {
                synchronized (f12458d) {
                    i(false);
                }
                return;
            }
            WebKitFactory.installAsync("file://" + str, new a(this, str, file));
        }
    }
}
