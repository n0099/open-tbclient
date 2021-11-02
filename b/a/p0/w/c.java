package b.a.p0.w;

import android.text.TextUtils;
import b.a.p0.n.l.b;
import b.a.p0.t.d;
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
/* loaded from: classes4.dex */
public final class c implements b.a.p0.n.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f11666c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f11667d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11668a;

    /* renamed from: b  reason: collision with root package name */
    public String f11669b;

    /* loaded from: classes4.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11670a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f11671b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11672c;

        /* renamed from: b.a.p0.w.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0633a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f11673e;

            public RunnableC0633a(a aVar) {
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
                this.f11673e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f11673e.f11672c;
                    cVar.j(cVar.f11669b);
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
            this.f11672c = cVar;
            this.f11670a = str;
            this.f11671b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (d.A(this.f11670a, str)) {
                    synchronized (c.f11667d) {
                        this.f11672c.i(new b(AppRuntime.getAppContext()).q());
                    }
                    return;
                }
                if (c.e(this.f11672c) <= 2) {
                    boolean z = true;
                    if (8 == i2) {
                        this.f11672c.f11669b = this.f11670a;
                    } else {
                        c cVar = this.f11672c;
                        cVar.f11669b = this.f11670a + File.pathSeparator + this.f11672c.f11668a;
                        if (d.f(this.f11671b, new File(this.f11672c.f11669b)) != this.f11671b.length()) {
                            z = false;
                        }
                    }
                    if (z && b.a.p0.a.a2.d.i().postDelayed(new RunnableC0633a(this), 1000L)) {
                        return;
                    }
                }
                if (8 == i2) {
                    d.j(this.f11670a);
                }
                synchronized (c.f11667d) {
                    this.f11672c.i(false);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-612743464, "Lb/a/p0/w/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-612743464, "Lb/a/p0/w/c;");
                return;
            }
        }
        f11667d = new HashSet();
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
        this.f11668a = 0;
    }

    public static /* synthetic */ int e(c cVar) {
        int i2 = cVar.f11668a + 1;
        cVar.f11668a = i2;
        return i2;
    }

    @Override // b.a.p0.n.l.b
    public void a(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            synchronized (f11667d) {
                f11667d.add(aVar);
                if (f11666c) {
                    return;
                }
                f11666c = true;
                j(str);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (f11667d) {
                for (b.a aVar : f11667d) {
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
                f11667d.clear();
                f11666c = false;
                this.f11668a = 0;
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                synchronized (f11667d) {
                    i(false);
                }
                return;
            }
            File file = new File(str);
            if (!file.isFile()) {
                synchronized (f11667d) {
                    i(false);
                }
                return;
            }
            WebKitFactory.installAsync("file://" + str, new a(this, str, file));
        }
    }
}
