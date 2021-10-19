package c.a.r0.x;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f26570g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f26571a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f26572b;

    /* renamed from: c  reason: collision with root package name */
    public final C1245a f26573c;

    /* renamed from: d  reason: collision with root package name */
    public c f26574d;

    /* renamed from: e  reason: collision with root package name */
    public long f26575e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26576f;

    /* renamed from: c.a.r0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1245a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26577a;

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
            this.f26577a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26577a.f26575e = SystemClock.uptimeMillis();
                a aVar = this.f26577a;
                aVar.h(aVar.f26575e);
                if (this.f26577a.f26572b.size() > 0) {
                    this.f26577a.j().a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(long j2);
    }

    /* loaded from: classes4.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final C1245a f26578a;

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
            this.f26578a = c1245a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f26579b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f26580c;

        /* renamed from: d  reason: collision with root package name */
        public long f26581d;

        /* renamed from: c.a.r0.x.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1246a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f26582e;

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
                this.f26582e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f26582e.f26581d = SystemClock.uptimeMillis();
                    this.f26582e.f26578a.a();
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
            this.f26581d = -1L;
            this.f26579b = new RunnableC1246a(this);
            this.f26580c = new Handler(Looper.myLooper());
        }

        @Override // c.a.r0.x.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26580c.postDelayed(this.f26579b, Math.max(10 - (SystemClock.uptimeMillis() - this.f26581d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f26583b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f26584c;

        /* renamed from: c.a.r0.x.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1247a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f26585e;

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
                this.f26585e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                    this.f26585e.f26578a.a();
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
            this.f26583b = Choreographer.getInstance();
            this.f26584c = new Choreographer$FrameCallbackC1247a(this);
        }

        @Override // c.a.r0.x.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26583b.postFrameCallback(this.f26584c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-634657732, "Lc/a/r0/x/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-634657732, "Lc/a/r0/x/a;");
                return;
            }
        }
        f26570g = new ThreadLocal<>();
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
        this.f26571a = new SimpleArrayMap<>();
        this.f26572b = new ArrayList<>();
        this.f26573c = new C1245a(this);
        this.f26575e = 0L;
        this.f26576f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f26570g.get() == null) {
                f26570g.set(new a());
            }
            return f26570g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j2) == null) {
            if (this.f26572b.size() == 0) {
                j().a();
            }
            if (!this.f26572b.contains(bVar)) {
                this.f26572b.add(bVar);
            }
            if (j2 > 0) {
                this.f26571a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f26576f) {
            for (int size = this.f26572b.size() - 1; size >= 0; size--) {
                if (this.f26572b.get(size) == null) {
                    this.f26572b.remove(size);
                }
            }
            this.f26576f = false;
        }
    }

    public final void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f26572b.size(); i2++) {
                b bVar = this.f26572b.get(i2);
                if (bVar != null && k(bVar, uptimeMillis)) {
                    bVar.a(j2);
                }
            }
            g();
        }
    }

    public final c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f26574d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f26574d = new e(this.f26573c);
                } else {
                    this.f26574d = new d(this.f26573c);
                }
            }
            return this.f26574d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j2)) == null) {
            Long l = this.f26571a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j2) {
                this.f26571a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f26571a.remove(bVar);
            int indexOf = this.f26572b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f26572b.set(indexOf, null);
                this.f26576f = true;
            }
        }
    }
}
