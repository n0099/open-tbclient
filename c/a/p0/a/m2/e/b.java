package c.a.p0.a.m2.e;

import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
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
    public static volatile b f7389c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c.a.p0.a.v2.e1.b<Exception>> f7390a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c.a.p0.a.v2.e1.b<Exception>> f7391b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7392e;

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
            this.f7392e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.h("PresetSwanCoreUpdater", "onPresetCheck start.");
                c.a.p0.a.m2.e.a.s(this.f7392e);
                d.h("PresetSwanCoreUpdater", "onPresetCheck end.");
            }
        }
    }

    /* renamed from: c.a.p0.a.m2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0299b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7394f;

        public RunnableC0299b(b bVar, int i2) {
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
            this.f7394f = bVar;
            this.f7393e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.h("PresetSwanCoreUpdater", "onPresetUpdate start.");
                b bVar = this.f7394f;
                int i2 = this.f7393e;
                bVar.c(i2, c.a.p0.a.m2.e.a.t(i2));
                d.h("PresetSwanCoreUpdater", "onPresetUpdate end.");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f7395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f7396f;

        public c(b bVar, c.a.p0.a.v2.e1.b bVar2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7395e = bVar2;
            this.f7396f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7395e.onCallback(this.f7396f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1286618518, "Lc/a/p0/a/m2/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1286618518, "Lc/a/p0/a/m2/e/b;");
                return;
            }
        }
        boolean z = k.f7077a;
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
        this.f7390a = new ArrayList<>();
        this.f7391b = new ArrayList<>();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f7389c == null) {
                synchronized (b.class) {
                    if (f7389c == null) {
                        f7389c = new b();
                    }
                }
            }
            return f7389c;
        }
        return (b) invokeV.objValue;
    }

    public final void c(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
            synchronized (b.class) {
                try {
                    if (i2 == 0) {
                        Iterator<c.a.p0.a.v2.e1.b<Exception>> it = this.f7390a.iterator();
                        while (it.hasNext()) {
                            d(it.next(), exc);
                        }
                        this.f7390a.clear();
                    } else if (i2 == 1) {
                        Iterator<c.a.p0.a.v2.e1.b<Exception>> it2 = this.f7391b.iterator();
                        while (it2.hasNext()) {
                            d(it2.next(), exc);
                        }
                        this.f7391b.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void d(c.a.p0.a.v2.e1.b<Exception> bVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, exc) == null) || bVar == null) {
            return;
        }
        q0.b0(new c(this, bVar, exc));
    }

    public void e(c.a.p0.a.v2.e1.b<Exception> bVar, int i2) {
        ArrayList<c.a.p0.a.v2.e1.b<Exception>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) {
            d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
            synchronized (b.class) {
                boolean q = c.a.p0.a.m2.e.a.q(i2);
                d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
                if (!q && i2 == 0 && !c.a.p0.a.m2.e.a.r(i2)) {
                    c.a.p0.a.m2.e.a.w(true, i2);
                    new Thread(new a(this, i2), "onPresetCheck").start();
                }
                if (!q) {
                    d(bVar, null);
                    return;
                }
                if (i2 == 1) {
                    arrayList = this.f7391b;
                } else {
                    arrayList = this.f7390a;
                }
                if (arrayList.isEmpty()) {
                    new Thread(new RunnableC0299b(this, i2), "updateSwanCoreAsync").start();
                }
                arrayList.add(bVar);
                d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (b.class) {
                c(i2, c.a.p0.a.m2.e.a.t(i2));
            }
        }
    }
}
