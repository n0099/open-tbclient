package b.a.r0.x;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f25391g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f25392a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f25393b;

    /* renamed from: c  reason: collision with root package name */
    public final C1245a f25394c;

    /* renamed from: d  reason: collision with root package name */
    public c f25395d;

    /* renamed from: e  reason: collision with root package name */
    public long f25396e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25397f;

    /* renamed from: b.a.r0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1245a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25398a;

        public C1245a(a aVar) {
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
            this.f25398a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25398a.f25396e = SystemClock.uptimeMillis();
                a aVar = this.f25398a;
                aVar.h(aVar.f25396e);
                if (this.f25398a.f25393b.size() > 0) {
                    this.f25398a.j().a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean a(long j);
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final C1245a f25399a;

        public c(C1245a c1245a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1245a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25399a = c1245a;
        }

        public abstract void a();
    }

    /* loaded from: classes5.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f25400b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f25401c;

        /* renamed from: d  reason: collision with root package name */
        public long f25402d;

        /* renamed from: b.a.r0.x.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1246a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f25403e;

            public RunnableC1246a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25403e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f25403e.f25402d = SystemClock.uptimeMillis();
                    this.f25403e.f25399a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1245a c1245a) {
            super(c1245a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1245a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1245a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25402d = -1L;
            this.f25400b = new RunnableC1246a(this);
            this.f25401c = new Handler(Looper.myLooper());
        }

        @Override // b.a.r0.x.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25401c.postDelayed(this.f25400b, Math.max(10 - (SystemClock.uptimeMillis() - this.f25402d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes5.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f25404b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f25405c;

        /* renamed from: b.a.r0.x.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class Choreographer$FrameCallbackC1247a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f25406e;

            public Choreographer$FrameCallbackC1247a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25406e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    this.f25406e.f25399a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1245a c1245a) {
            super(c1245a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1245a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1245a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25404b = Choreographer.getInstance();
            this.f25405c = new Choreographer$FrameCallbackC1247a(this);
        }

        @Override // b.a.r0.x.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25404b.postFrameCallback(this.f25405c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1162293627, "Lb/a/r0/x/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1162293627, "Lb/a/r0/x/a;");
                return;
            }
        }
        f25391g = new ThreadLocal<>();
    }

    public a() {
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
        this.f25392a = new SimpleArrayMap<>();
        this.f25393b = new ArrayList<>();
        this.f25394c = new C1245a(this);
        this.f25396e = 0L;
        this.f25397f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f25391g.get() == null) {
                f25391g.set(new a());
            }
            return f25391g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j) == null) {
            if (this.f25393b.size() == 0) {
                j().a();
            }
            if (!this.f25393b.contains(bVar)) {
                this.f25393b.add(bVar);
            }
            if (j > 0) {
                this.f25392a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f25397f) {
            for (int size = this.f25393b.size() - 1; size >= 0; size--) {
                if (this.f25393b.get(size) == null) {
                    this.f25393b.remove(size);
                }
            }
            this.f25397f = false;
        }
    }

    public final void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f25393b.size(); i2++) {
                b bVar = this.f25393b.get(i2);
                if (bVar != null && k(bVar, uptimeMillis)) {
                    bVar.a(j);
                }
            }
            g();
        }
    }

    public final c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f25395d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f25395d = new e(this.f25394c);
                } else {
                    this.f25395d = new d(this.f25394c);
                }
            }
            return this.f25395d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j)) == null) {
            Long l = this.f25392a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j) {
                this.f25392a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f25392a.remove(bVar);
            int indexOf = this.f25393b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f25393b.set(indexOf, null);
                this.f25397f = true;
            }
        }
    }
}
