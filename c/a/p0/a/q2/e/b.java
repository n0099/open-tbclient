package c.a.p0.a.q2.e;

import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f7561c;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.p0.a.z2.g1.c<Exception>> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c.a.p0.a.z2.g1.c<Exception>> f7562b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7563e;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7563e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.k("PresetSwanCoreUpdater", "onPresetCheck start.");
                c.a.p0.a.q2.e.a.s(this.f7563e);
                d.k("PresetSwanCoreUpdater", "onPresetCheck end.");
            }
        }
    }

    /* renamed from: c.a.p0.a.q2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0429b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7565f;

        public RunnableC0429b(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7565f = bVar;
            this.f7564e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.k("PresetSwanCoreUpdater", "onPresetUpdate start.");
                b bVar = this.f7565f;
                int i2 = this.f7564e;
                bVar.c(i2, c.a.p0.a.q2.e.a.t(i2));
                d.k("PresetSwanCoreUpdater", "onPresetUpdate end.");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.g1.c f7566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f7567f;

        public c(b bVar, c.a.p0.a.z2.g1.c cVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7566e = cVar;
            this.f7567f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7566e.onCallback(this.f7567f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(541665946, "Lc/a/p0/a/q2/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(541665946, "Lc/a/p0/a/q2/e/b;");
                return;
            }
        }
        boolean z = k.a;
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
        this.a = new ArrayList<>();
        this.f7562b = new ArrayList<>();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f7561c == null) {
                synchronized (b.class) {
                    if (f7561c == null) {
                        f7561c = new b();
                    }
                }
            }
            return f7561c;
        }
        return (b) invokeV.objValue;
    }

    public final void c(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
            synchronized (b.class) {
                try {
                    if (i2 == 0) {
                        Iterator<c.a.p0.a.z2.g1.c<Exception>> it = this.a.iterator();
                        while (it.hasNext()) {
                            d(it.next(), exc);
                        }
                        this.a.clear();
                    } else if (i2 == 1) {
                        Iterator<c.a.p0.a.z2.g1.c<Exception>> it2 = this.f7562b.iterator();
                        while (it2.hasNext()) {
                            d(it2.next(), exc);
                        }
                        this.f7562b.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void d(c.a.p0.a.z2.g1.c<Exception> cVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, exc) == null) || cVar == null) {
            return;
        }
        q0.e0(new c(this, cVar, exc));
    }

    public void e(c.a.p0.a.z2.g1.c<Exception> cVar, int i2) {
        ArrayList<c.a.p0.a.z2.g1.c<Exception>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) {
            d.k("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
            synchronized (b.class) {
                boolean q = c.a.p0.a.q2.e.a.q(i2);
                d.k("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
                if (!q && i2 == 0 && !c.a.p0.a.q2.e.a.r(i2)) {
                    c.a.p0.a.q2.e.a.w(true, i2);
                    new Thread(new a(this, i2), "onPresetCheck").start();
                }
                if (!q) {
                    d(cVar, null);
                    return;
                }
                if (i2 == 1) {
                    arrayList = this.f7562b;
                } else {
                    arrayList = this.a;
                }
                if (arrayList.isEmpty()) {
                    new Thread(new RunnableC0429b(this, i2), "updateSwanCoreAsync").start();
                }
                arrayList.add(cVar);
                d.k("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (b.class) {
                c(i2, c.a.p0.a.q2.e.a.t(i2));
            }
        }
    }
}
